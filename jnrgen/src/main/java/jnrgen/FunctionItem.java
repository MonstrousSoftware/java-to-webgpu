
package jnrgen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FunctionItem implements Item {

    private final String comment;
    private final String returnType;
    public boolean isCallback;
    private final String name;
    private final List<FunctionParameter> params;


    @Override
    public void save(OutputHandler outputHandler) throws IOException {
        if(!isCallback)  // only save callbacks to their own interface file
            return;

        String className = this.name;

        if(OutputHandler.isExcluded(name)) {
            return;
        }

        BufferedWriter writer = outputHandler.startFile(className + ".java");

        writer.write("import jnr.ffi.Pointer;\n");
        writer.write("import jnr.ffi.types.*;\n");
        writer.write("import jnr.ffi.annotations.Delegate;\n\n");
        writer.write("public interface ");
        writer.write(className);
        writer.write(" {\n");
        writer.write("\n\t@Delegate\n");
        writer.write("\tvoid invoke(");

        boolean first = true;
        for (FunctionParameter parm : params) {
            if(!first)
                writer.write(", ");
            first = false;
            writer.write(convertParamType(outputHandler, parm));
            writer.write(" ");
            writer.write(parm.name);
        }


        writer.write(");\n}\n");
        writer.flush();
        writer.close();
    }

    @Override
    public String getJavaTypeName() {
        return "";
    }

    static public class FunctionParameter {
        String type;
        String name;
        boolean inParam;    // can we add @In? e.g. a const *
        boolean outParam;

        public FunctionParameter(String type, String name) {
            this.type = type;
            this.name = name;
            inParam = false;
            outParam = false;
        }
    }

    public FunctionItem(String returnType, boolean isCallback, String name, List<FunctionParameter> fields, String comment) {
        this.returnType = returnType;
        this.isCallback = isCallback;
        this.name = OutputHandler.toExportName(name); //.replace("WGPU", "Wgpu"));
        this.comment = comment;
        this.params = fields;
    }


    public void write(OutputHandler handler, BufferedWriter writer) throws IOException {
        if(isCallback)  // these don't go in the function list
            return;

        if(!comment.isEmpty()){
            writer.write("\n\t"+comment.replace("\n", "\n\t"));
            writer.write("\n");
        }

        writer.write("\t");
        writer.write(convertReturnType(handler, returnType));
        writer.write("\t");
        writer.write(name);
        writer.write(" (");

        boolean first = true;
        for (FunctionParameter parm : params) {
            if(!first)
                writer.write(", ");
            first = false;
            writer.write(convertParamType(handler, parm));
            writer.write(" ");
            writer.write(parm.name);
        }

        writer.write(");\n");


    }

    @Override
    public void preSave(OutputHandler outputHandler) {
        outputHandler.registerFunction(name, this);
    }

    public static String convertReturnType(OutputHandler handler, String type) {

        if (type.equals("void*")) {
            type = "Pointer";
        }else if (type.equals("uint64_t")) {
            type = "long";
        } else if (type.equals("WGPUBool")) {
            type = "boolean";
        } else if (type.equals("uint32_t")) {
            type = "int";
        } else if (type.equals("size_t")) {
            type = "long";
        } else if (type.equals("int32_t")) {
            type = "int";
        } else if (type.equals("uint8_t")) {
            type = "byte";
        }else if (handler.containsPointer(type)) { // opaque pointer
            type = "Pointer";
        } else if (handler.containsFlags(type)) { // enum flags
                type = "int";
        } else if (handler.containsAlias(type)) {
            type = handler.getAlias(type);
            type = convertReturnType(handler, type);
        }
        return type;
    }

    public static String convertParamType(OutputHandler handler, FunctionParameter param) {

        // we don't want the asterisk on the name but as part of the type
        // the parser may get it wrong depending on input formatting
        if(param.name.startsWith("*")){
            param.type = param.type + "*";
            param.name = param.name.substring(1);
        }
        String type = param.type;


        if (type.equals("char*"))  {
            type = "String";
        } else  if (param.type.endsWith("*")) {
            String typeName = param.type.substring(0, param.type.length()-1);
            if(handler.containsStruct(typeName))
                type = typeName;
            else
                type = "Pointer";
        } else if (type.equals("uint64_t")) {
            type = "long";  // may cause truncation
        } else if (type.equals("WGPUBool")) {
            type = "boolean";
        } else if (type.equals("uint32_t")) {
            type = "int";
        } else if (type.equals("size_t")) {
            type = "long";
        } else if (type.equals("int32_t")) {
            type = "int";
        } else if (type.equals("uint8_t")) {
            type = "byte";
        }else if (handler.containsPointer(type)) { // opaque pointer, e.g. WGPUDevice
            type = "Pointer";

        }  else if (handler.containsFlags(type)) { // enum flags
            type = "int";
        } else if (handler.containsAlias(type)) {
            param.type = handler.getAlias(type);
            type = convertParamType(handler, param);
        }
        param.type = type;
        return type;
    }

    public List<FunctionParameter> getParameters() {
        return params;
    }
}
