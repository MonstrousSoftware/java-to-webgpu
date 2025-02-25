package jnrgen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class EnumItem implements Item {

    private final String name;
    private final List<EnumField> fields;
    public boolean contiguous = true;

    public EnumItem(String name, List<EnumField> fields) {
        this.name = name.replace("_", "");
        this.fields = fields;

        this.fields.sort(Comparator.comparingInt(field -> field.index));
    }

    @Override
    public void preSave(OutputHandler outputHandler) {
        outputHandler.registerType(name, this);
    }

    @Override
    public void save(OutputHandler outputHandler) throws IOException {

        String className = this.name; //.replace("WGPU", "Wgpu");

        if(outputHandler.isExcluded(name)) {
            return;
        }

        BufferedWriter writer = outputHandler.startFile(className + ".java");

        if(!checkFields()){
            this.contiguous = false;
            //System.out.println("Warning: Non-contiguous range for "+name);

            //writer.write("import jnr.ffi.util.EnumMapper;\n\n");
            writer.write("public class ");
            writer.write(className);
            writer.write(" {\n");

            saveConstants(writer);


//            writer.write("import jnr.ffi.util.EnumMapper;\n\n");
//            writer.write("public enum ");
//            writer.write(className);
//            writer.write(" implements EnumMapper.IntegerEnum {\n");
//
//            saveValuedFields(writer);
//
//            writer.write("\n\tprivate final int value;\n");
//            writer.write("\n\t");
//            writer.write(className);
//            writer.write("(int value) {this.value = value;}\n");
//            writer.write("\n\t@Override\n");
//            writer.write("\tpublic int intValue() {return value;} // mapping function\n");
        }
        else {
            writer.write("public enum ");
            writer.write(className);
            writer.write(" {\n");

            saveFields(writer);
        }

        writer.write("}");

        writer.flush();
        writer.close();
    }

    private void saveFields(BufferedWriter writer) throws IOException {

        if(fields.get(0).index != 0){
            writer.write("    ");
            writer.write(toFieldName("Undefined"));
            writer.write(",\n");
        }
        for(EnumField field : fields){
            if(field.name.endsWith("Force32"))              // remove the entry that is just there to force 32 bit width
                continue;

            // put comment in front of the entry
            if(!field.comment.isEmpty()){
                writer.write("     ");
                writer.write(field.comment.replace("\n", "\n    "));
                writer.write("\n");
            }

            writer.write("    ");
            writer.write(toFieldName(field.name));
            writer.write(",\n");
        }
    }

    private void saveConstants(BufferedWriter writer) throws IOException {

        for(EnumField field : fields){
            if(field.name.endsWith("Force32"))              // remove the entry that is just there to force 32 bit width
                continue;

            // put comment in front of the entry
            if(!field.comment.isEmpty()){
                writer.write("     ");
                writer.write(field.comment.replace("\n", "\n    "));
                writer.write("\n");
            }

            writer.write("    public static final int ");
            writer.write(toFieldName(field.name));
            writer.write(" = 0x");
            writer.write(Integer.toString(field.index, 16));
            writer.write(";\n");
        }
    }

    // save enums with a value, e.g. APPLE(0x23), PEAR(0x34)
    private void saveValuedFields(BufferedWriter writer) throws IOException {

        for(int i = 0; i < fields.size() - 1; i++){     // skip last entry (Force32)
            EnumField field = fields.get(i);

            // put comment in front of the entry
            if(!field.comment.isEmpty()){
                writer.write("     ");
                writer.write(field.comment.replace("\n", "\n    "));
                writer.write("\n");
            }

            writer.write("    ");
            writer.write(toFieldName(field.name));
            writer.write(" ( 0x");
            writer.write(Integer.toString(field.index, 16));
            writer.write(" )");
            if(i == fields.size() - 2)
                writer.write(";\n");
            else
                writer.write(",\n");
        }
    }

    // check if the numbering is (0) 1, 2, 3, 4, etc.
    public boolean checkFields(){
        boolean ok = true;
        int offset = 0;

        if(fields.get(0).index != 0){   // we will add a 'undefined' entry if numbering starts at 1
            offset = 1;
        }
        for(int index = 0; index < fields.size(); index++){
            EnumField field = fields.get(index);
            if(field.index != index + offset && field.index != 0x7FFFFFFF)
                ok = false;
        }
        return ok;
    }

    @Override
    public String getJavaTypeName() {
        return this.name;  //.replace("WGPU", "Wgpu");
    }

    private String toFieldName(String fieldName) {
        //Replace tag due to CBindgen adding "Tag" for enum names, but not for each field for some reason
        String cFieldHeader = this.name.replace("Tag", "");

        fieldName = fieldName.replace(cFieldHeader, "").replace("_", "");

        if(Character.isDigit(fieldName.charAt(0)))           // name starting with digit e.g. 1D gets a underscore prefix _1D to be a valid identifier
            fieldName = "_" + fieldName;

        return OutputHandler.toExportName(fieldName.toString());
    }

    @Override
    public String toString() {
        return "Enum(" + name + ")";
    }

    static class EnumField{
        private final String name;
        private final int index;
        private final String comment;

        public EnumField(String name, int index, String comment) {
            this.name = name;
            this.index = index;
            this.comment = comment;
        }
    }
}
