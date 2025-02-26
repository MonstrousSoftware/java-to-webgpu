package jnrgen;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Custom handlers for specific structs with strange properties
 * like padding, weird names, etc.
 */
public class Hooks {

    private static final Map<String, Consumer<Item>> hooks = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("WgpuBindGroupEntry", Hooks::bindGroupEntryPadding)
    );

    public static void preSave(OutputHandler handler){
        handler.registerType("WGPUBindingResource", new MockStructItem("WgpuBindingResource"));
    }

    public static void bindGroupEntryPadding(Item item){
        if(!(item instanceof StructItem))
            throw new RuntimeException("Expected struct, found " + item);
        StructItem struct = (StructItem) item;
        StructItem.StructField padding = new StructItem.StructField("uint32_t", StructItem.doNotUsePrefix + "padding", false);

        struct.getFields().add(1, padding);
    }

    public static Map<String, Consumer<Item>> getHooks() {
        return hooks;
    }
}
