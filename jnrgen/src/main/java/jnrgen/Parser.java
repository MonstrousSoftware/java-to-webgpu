package jnrgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Parser {

    private final List<Item> items = new ArrayList<>();
    private final List<Token> tokens;

    private Token lastComment;
    private int index = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;

        parse();
    }

    private void parse() {
        Token token;

        while((token = poll()) != null){
            Item item = createItem(token);

            if(item != null){
                lastComment = null;
                items.add(item);
            }
        }
    }

    private Item createItem(Token token) {
        if(Token.identifier(0,"typedef").equals(token)){
            Token next = poll();

            if(Token.identifier(0,"enum").equals(next)){
                return createEnum();
            }else if(Token.identifier(0,"struct").equals(next)){
                return createStruct();
            }else {
                return createCallback(next);        // typedef void (*WGPUBlaCallback)(WGPUMapAsyncStatus status, char const * message, void* userdata1, void* userdata2) WGPU_FUNCTION_ATT
                //return createTypeAlias(next);
            }
        }else if(token.getType() == Token.TokenType.HASH){
            Token macroType = pollExpect(Token.TokenType.IDENTIFIER);

            if(Token.identifier(0,"define").equals(macroType)){     // #define not supported
                skipToEndOfLine();
                return null;
                //return createConstant();
            }
        }else if(token.getType() == Token.TokenType.COMMENT){
            lastComment = token;
        }else if(Token.identifier(0,"enum").equals(token)) {
            return createEnum();
        } else if(Token.identifier(0,"struct").equals(token)) {
            while(token != null && token.getType() != Token.TokenType.SEMICOLON)
                token = poll();
        } else if(token.getType() == Token.TokenType.IDENTIFIER) {
            return createFunction(token);
        }
        return null;
    }

    // #define ABCD 123
    //        ^
    //
    // also supports #define A (1) or #define A ((3))
    //
    private Item createConstant() {
        Token name = pollExpect(Token.TokenType.IDENTIFIER);
        int brackets = 0;

        while(Token.TokenType.LEFT_PARENTHESIS == peek().getType()) {
            brackets++;
            pollExpect(Token.TokenType.LEFT_PARENTHESIS);
        }

        if(Token.TokenType.IDENTIFIER != peek().getType()) {
            return null;
        }

        Token def = pollExpect(Token.TokenType.IDENTIFIER);

        while(brackets > 0){
            pollExpect(Token.TokenType.RIGHT_PARENTHESIS);
            brackets--;
        }

        return null; // todo new ConstantItem(name.getText(), def.getText(), getLastCommentOrEmpty());
        // there are some weird defines in dawn.h
    }

    private Item createTypeAlias(Token token) {
        List<Token> tokens = new ArrayList<>();

        while(token != null && token.getType() != Token.TokenType.SEMICOLON){
            tokens.add(token);
            token = poll();
        }

        String alias = tokens.remove(tokens.size() - 1).getText();
        String original = tokens.stream().map(Token::getText).collect(Collectors.joining(" "));

        if(alias.endsWith("Flags"))
            original = alias.replace("Flags","");

        return new TypeAliasItem(alias, original);
    }

    // typedef struct tag { const char a; char b; } label;
    //               ^

    // typedef struct InstanceImpl* Instance ;     // to define a pointer type (InstanceImpl is never defined)
    //
    private Item createStruct() {
        List<StructItem.StructField> fields = new ArrayList<>();
        skipWhitespace();
        Token tag = peek();
        pollExpect(Token.TokenType.IDENTIFIER);
        skipWhitespace();

        //might be something like typedef struct WGPUSamplerDescriptor* WGPUSamplerDescriptor;
        // this defines an opaque pointer type
        Token tok = peek();
        if(!tok.equals(new Token(0, Token.TokenType.OPEN_BRACKET))){
            //System.out.println("Alias "+tok.getText()+ " for struct "+tag.getText());
            Token next = peek();
            assert next != null;
            while(next.getType() != Token.TokenType.SEMICOLON) {
                poll();
                next = peek();
                assert next != null;
            }

            return new OpaquePointerItem(tok.getText(), "struct " +tag.getText());
        }

        pollExpect(Token.TokenType.OPEN_BRACKET);
        skipWhitespace();

        while(!new Token(0, Token.TokenType.CLOSE_BRACKET).equals(peek())){
            boolean nullable = false;

            if(Token.identifier(0,"const").equals(peek())){
                poll();
            }

            if(peek().getType() == Token.TokenType.NULLABLE){ // nullable param
                // e.g.  WGPUInstance wgpuCreateInstance(WGPU_NULLABLE WGPUInstanceDescriptor const * descriptor)
                nullable = true;
                poll();
            }

            if(Token.identifier(0,"union").equals(peek())){
                return null; //Unions in structs currently not supported
            }

            // note: char const *ptr; is not supported
            if(Token.identifier(0,"struct").equals(peek())){    // struct Bla is usually typedef'd as Bla, skip the struct keyword
                poll();
            }

            Token fieldType = pollExpect(Token.TokenType.IDENTIFIER);           // type name, e.g. int or char or WGPUChainedStruct

            if(Token.identifier(0,"const").equals(peek())){           // note: char const a; is also valid
                poll();
            }

            boolean indirect = false;
            if(Token.identifier(0,"*").equals(peek())){           // * not attached to name
                indirect = true;
                poll();
            }

            Token fieldName = pollExpect(Token.TokenType.IDENTIFIER);           // member name, may include *
            if(indirect)
                fieldName = new Token(fieldName.lineNumber, Token.TokenType.IDENTIFIER, "*" + fieldName.getText());

            pollExpect(Token.TokenType.SEMICOLON);
            skipWhitespace();

            fields.add(new StructItem.StructField(fieldType.getText(), fieldName.getText(), nullable));
        }

        pollExpect(Token.TokenType.CLOSE_BRACKET);
        Token structName = pollExpect(Token.TokenType.IDENTIFIER);
        pollExpect(Token.TokenType.SEMICOLON);

        return new StructItem(structName.getText(), fields);
    }

    // void wgpuAdapterInfoFreeMembers(WGPUAdapterInfo value);
    //     ^

    private Item createFunction(Token returnType) {

        skipWhitespace();

        if(Token.identifier(0,"const").equals(peek())){ // ignore const     void const * bla();
            poll();
        }

        if(Token.identifier(0,"*").equals(peek())){           // void * functionName
            poll();
            returnType = new Token( returnType.lineNumber, Token.TokenType.IDENTIFIER, returnType.getText()+"*");
        }

        Token functionName = pollExpect(Token.TokenType.IDENTIFIER);


        List<FunctionItem.FunctionParameter> params = getParameterList();

        pollExpect(Token.TokenType.SEMICOLON);

        return new FunctionItem(returnType.getText(), false, functionName.getText(), params, getLastCommentOrEmpty());
    }



    // typedef + identifier: could be a type alias or a callback definition
    //
    // typedef void (*WGPUCallback)(void * userdata) WGPU_FUNCTION_ATTRIBUTE;
    //             ^
    // typedef int32 bool;
    //              ^
    private Item createCallback(Token returnType) {
        skipWhitespace();
        Token next = peek();
        while(Token.identifier(0,"const").equals(next)||Token.identifier(0,"*").equals(next)){
            poll();
            next = peek();
        }
        next = peek();
        if(next.getType() == Token.TokenType.IDENTIFIER){
            // typedef ident ident ;
            return createTypeAlias(returnType);
        }


        // ( *WGPUCallBack )
        pollExpect(Token.TokenType.LEFT_PARENTHESIS);
        skipWhitespace();
        Token tok = peek();
        Token functionName = pollExpect(Token.TokenType.IDENTIFIER);    // *function name
        skipWhitespace();
        pollExpect(Token.TokenType.RIGHT_PARENTHESIS);

        List<FunctionItem.FunctionParameter> params = getParameterList();

        pollExpect(Token.TokenType.SEMICOLON);

        if(functionName.getText().startsWith("*WGPUProc"))  // hack: ignore all the Procs definitions
            return null;

        // callbacks are kept as FunctionItems
        // remove the * at the start of the name
        return new FunctionItem(returnType.getText(), true, functionName.getText().substring(1), params, getLastCommentOrEmpty());
    }

    // parse "( int a, void * ptr )"
    private List<FunctionItem.FunctionParameter> getParameterList(){
        List<FunctionItem.FunctionParameter> params = new ArrayList<>();
        skipWhitespace();
        pollExpect(Token.TokenType.LEFT_PARENTHESIS);
        skipWhitespace();

        while(!new Token(0, Token.TokenType.RIGHT_PARENTHESIS).equals(peek())){
            boolean hasConst = false;
            boolean nullable = false;

            if(Token.identifier(0,"const").equals(peek())){ // ignore const
                poll();
            }

            if(peek().getType() == Token.TokenType.NULLABLE){ // nullable param
                // e.g.  WGPUInstance wgpuCreateInstance(WGPU_NULLABLE WGPUInstanceDescriptor const * descriptor)
                nullable = true;
                poll();
            }

            Token paramType = pollExpect(Token.TokenType.IDENTIFIER);

            if(Token.identifier(0,"const").equals(peek())){ // ignore const
                poll();
                hasConst = true;
            }

            // we need to cope with:
            //      int* p
            //      int * p
            //  and int *p


            if(Token.identifier(0,"*").equals(peek())){           // void * bla
                paramType = new Token(paramType.lineNumber, Token.TokenType.IDENTIFIER,  paramType.getText()+"*");      // type becomes void*
                poll();
            }

            // special case : ( void ) i.e empty param list, same as ( )
            if(new Token(0, Token.TokenType.RIGHT_PARENTHESIS).equals(peek()) && paramType.getText().contentEquals("void"))
                break;


            Token paramName = pollExpect(Token.TokenType.IDENTIFIER);

            FunctionItem.FunctionParameter param = new FunctionItem.FunctionParameter(paramType.getText(), paramName.getText());
            if(hasConst)
                param.inParam = true;
            param.nullable = nullable;
            params.add( param );

            Token tok = peek();
            assert tok != null;
            if(tok.getType() == Token.TokenType.RIGHT_PARENTHESIS)
                break;
            pollExpect(Token.TokenType.COMMA);
            skipWhitespace();

        }

        pollExpect(Token.TokenType.RIGHT_PARENTHESIS);
        return params;
    }

    // typedef enum Tag { A, B, C, D = 2, E = 3 } TypeName;
    //             ^
    private Item createEnum() {
        List<EnumItem.EnumField> fields = new ArrayList<>();

        skipWhitespace();
        Token enumIdentifier = pollExpect(Token.TokenType.IDENTIFIER);
        skipWhitespace();
        pollExpect(Token.TokenType.OPEN_BRACKET);
        lastComment = null;
        skipWhitespace();

        Token token;
        while((token = poll()).getType() != Token.TokenType.CLOSE_BRACKET){
            Token identifier = Objects.requireNonNull(token);
            Token equalOrComma = Objects.requireNonNull(poll());

            if(equalOrComma.getType() == Token.TokenType.COMMA){
                fields.add(new EnumItem.EnumField(identifier.getText(), fields.size(), getLastCommentOrEmpty()));
            }else{
                Token valueToken = pollExpect(Token.TokenType.IDENTIFIER);      // =
                int value = parseInteger(valueToken.getText()); // integer

                fields.add(new EnumItem.EnumField(identifier.getText(), value, getLastCommentOrEmpty()));
                skipWhitespace();

                if(peek().getType() == Token.TokenType.CLOSE_BRACKET)       // last enum doesn't need to end with a comma
                    continue;
                pollExpect(Token.TokenType.COMMA);
            }

            lastComment = null;
            skipWhitespace();
        }
        Token typeNameIdentifier = pollExpect(Token.TokenType.IDENTIFIER);
        pollExpect(Token.TokenType.SEMICOLON);

        return new EnumItem(enumIdentifier.getText(), fields);
    }

    private int parseInteger(String s){
        if(s.startsWith("0x") || s.startsWith("0X"))
            return Integer.parseInt(s.substring(2), 16);
        return Integer.parseInt(s);
    }


    private void skipWhitespace(){
        while( peek().getType() == Token.TokenType.COMMENT || peek().getType() == Token.TokenType.NEWLINE){
            if(peek().getType() == Token.TokenType.COMMENT)
                lastComment = peek();

            poll();
        }
    }

    private void skipToEndOfLine(){
        while( peek().getType() != Token.TokenType.NEWLINE){
            poll();
        }
    }

    private void skipToEndOfStatement(){
        while( peek().getType() != Token.TokenType.SEMICOLON){
            poll();
        }
    }

    private Token pollExpect(Token.TokenType type){
        Token token = poll();

        if(token == null || token.getType() != type){
            throw new RuntimeException("Line "+token.lineNumber+" : Expected " + type + " but found " + token);
        }

        return token;
    }

    private String getLastCommentOrEmpty(){
        return lastComment == null ? "" : lastComment.getText();
    }

    private Token poll(){
        if(index >= tokens.size())
            return null;

        return tokens.get(index++);
    }

    private Token peek(){
        if(index >= tokens.size())
            return null;

        return tokens.get(index);
    }

    public List<Item> getItems() {
        return items;
    }
}
