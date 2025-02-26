package jnrgen;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JNRGenerator {

    public static String inputFile = "/dawn2.h";
    public static String outputDir = "../java-to-webgpu/src/main/java/com/monstrous/webgpu";

    public static void main(String[] args) {


        File outputDirectory = createOutputDirectory(outputDir);
        OutputHandler outputHandler = new OutputHandler(outputDirectory);
        String header = readHeaderFile();

        List<Token> tokens = new Scanner(header).getTokens();
        List<Item> items = new Parser(tokens).getItems();
        for(Item item: items){
            try{
                item.preSave(outputHandler);
            }catch(RuntimeException e){
                System.out.println("Failed to parse type from item " + item + ": " + e.getLocalizedMessage());
            }
        }
        Hooks.preSave(outputHandler);

        for(Item item: items){
            try{
                item.save(outputHandler);
            }catch(RuntimeException | IOException e){
                System.out.println("Failed to save item " + item + ": " + e.getLocalizedMessage());
            }
        }

        try{
            outputHandler.saveConstants();
        }catch(IOException e){
            System.out.println("Failed to save constants: " + e);
        }
        printStats(items);

    }

    private static void printStats(List<Item> items){
        //System.out.println("Generated " + items.size() + " items.");
        int numStructs = 0;
        int numEnums = 0;
        int numFunctions = 0;
        int numCallbacks = 0;
        for(Item item: items){
            if(item instanceof StructItem )
                numStructs++;
            if(item instanceof EnumItem )
                numEnums++;
            if(item instanceof FunctionItem) {
                if (((FunctionItem) item).isCallback)
                    numCallbacks++;
                else
                    numFunctions++;
            }

        }
        System.out.println("Enums: " + numEnums);
        System.out.println("Structs: " + numStructs);
        System.out.println("Functions: " + numFunctions);
        System.out.println("Callbacks: " + numCallbacks);
    }

    private static String readHeaderFile() {
        InputStream headerStream = JNRGenerator.class.getResourceAsStream(inputFile);     // MM: was wgpu.h

        if(headerStream == null){
            throw new RuntimeException("Failed to find "+inputFile+" in the classpath!");
        }

        try {
            return new String(headerStream.readNBytes(Integer.MAX_VALUE), StandardCharsets.UTF_8);
        } catch(IOException e) {
            throw new RuntimeException("Failed to read");
        }
    }

    private static File createOutputDirectory(String arg){
        File file = new File(arg);
        System.out.println("Output Directory: " + file);

        if(file.exists()){
            System.out.println("Output directory already exists, deleting!");

            if(!file.delete()){
                throw new RuntimeException("Failed to delete previous output directory!");
            }
        }

        if(!file.mkdir()){
            throw new RuntimeException("Failed to make the output directory!");
        }

        return file;
    }
}
