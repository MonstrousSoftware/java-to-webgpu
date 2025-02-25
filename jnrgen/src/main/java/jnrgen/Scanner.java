package jnrgen;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private final List<Token> tokens = new ArrayList<>();
    private final String text;
    private int line;

    private int index;

    public Scanner(String text) {
        this.text = text;
        line = 1;

        parse();
    }

    private void parse() {
        while(index < text.length()){
            Token token = parseToken(poll());

            if(token != null){
                tokens.add(token);
            }
        }

        tokens.add(new Token(line, Token.TokenType.EOF));
    }

    private Token parseToken(char c) {
        switch(c){
            case '#':
                return new Token(line, Token.TokenType.HASH);
            case '(':
                return new Token(line, Token.TokenType.LEFT_PARENTHESIS);
            case ')':
                return new Token(line, Token.TokenType.RIGHT_PARENTHESIS);
            case '{':
                return new Token(line, Token.TokenType.OPEN_BRACKET);
            case '}':
                return new Token(line, Token.TokenType.CLOSE_BRACKET);
            case '<':
                return new Token(line, Token.TokenType.LESS_THAN);
            case '>':
                return new Token(line, Token.TokenType.GREATER_THAN);
            case ',':
                return new Token(line, Token.TokenType.COMMA);
            case ';':
                return new Token(line, Token.TokenType.SEMICOLON);
            case '.':
                return new Token(line, Token.TokenType.PERIOD);
            case '=':
                return new Token(line, Token.TokenType.EQUAL);
            case '!':
                return new Token(line, Token.TokenType.NOT);
            case '&':
                return new Token(line, Token.TokenType.AMPERSAND);
            case '\n':
                line++;
                return new Token(line, Token.TokenType.NEWLINE);    // newline is white space, but for #define we need to know the end of line
            case '\r':
            case ' ':
            case '\t':
                return null;
            case '\\':
                char nxt = poll();
                if(nxt == '\r')
                    nxt = poll();
                if(nxt == '\n')            // line continuation \+CRLF or \+LF
                    return null;
                return new Token(line, Token.TokenType.BACKSLASH);
            case '/':
                char next = poll();
                if(next == '*'){
                    String comment = readComment();
                    return new Token(line, Token.TokenType.COMMENT, comment);
                }else if(next == '/'){      // comment
                    String comment = readLineComment();
                    //System.out.println("Line comment ["+comment+"]");
                    return new Token(line, Token.TokenType.COMMENT, comment);
                }else{
                    System.out.println("Line "+ line +" : Expected * after / but found: " + next);
                    return null;
                }
            case '"':
                String str = readString();
                return new Token(line, Token.TokenType.STRING, str);

            default:
                if(isIdentifierCharacter(c)){
                    String text = readIdentifier(c);

                    // hacky
                    if(text.contentEquals("WGPU_EXPORT")||
                        text.contentEquals("WGPU_STRUCTURE_ATTRIBUTE")||
                        text.contentEquals("WGPU_FUNCTION_ATTRIBUTE")||
                        text.contentEquals("WGPU_ENUM_ATTRIBUTE")||
                        text.contentEquals("WGPU_NULLABLE"))
                        return null;

                    return Token.identifier(line, text);
                }else{
                    System.out.println("Line "+ line +" : Unknown character: " + c);

                    return null;
                }
        }
    }

    private String readComment() {
        StringBuilder builder = new StringBuilder("/*");

        char c;
        char prev = 0;

        while((c = poll()) != 0){
            builder.append(c);

            if(c == '\n')
                line++;

            if(c == '/' && prev == '*'){
                break;
            }

            prev = c;
        }

        return builder.toString();
    }

    private String readLineComment() {
        StringBuilder builder = new StringBuilder("//");

        char c;

        while((c = poll()) != 0){
            if(c == '\r')
                continue;
            if(c == '\n') {
                line++;
                break;
            }
            builder.append(c);
        }

        return builder.toString();
    }

    // the quotes are included in the token
    // todo: handle escaped quotes
    private String readString() {
        StringBuilder builder = new StringBuilder("\"");

        char c;

        while((c = poll()) != 0){
            builder.append(c);
            if(c == '\n')
                line++;
            if(c == '"') {
                break;
            }
        }
        return builder.toString();
    }

    private String readIdentifier(char c) {
        StringBuilder builder = new StringBuilder(String.valueOf(c));

        while(index < text.length() && isIdentifierCharacter(peek())){
            builder.append(poll());
        }

        return builder.toString();
    }

    // note how * is considered part of an identifier, so char *ptr instead of char * ptr

    private boolean isIdentifierCharacter(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c) || c == '_' || c == '*';
    }

    private char poll(){
        if(index >= text.length())
            return 0;

        return text.charAt(index++);
    }

    private char peek(){
        if(index >= text.length())
            return 0;

        return text.charAt(index);
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
