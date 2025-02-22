package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUBlendState extends WgpuJavaStruct {

    private final WGPUBlendComponent color = inner(WGPUBlendComponent.createHeap());
    private final WGPUBlendComponent alpha = inner(WGPUBlendComponent.createHeap());

    private WGPUBlendState(){}

    @Deprecated
    public WGPUBlendState(Runtime runtime){
        super(runtime);
    }

    /**
     * Creates this struct on the java heap.
     * In general, this should <b>not</b> be used because these structs
     * cannot be directly passed into native code.
     */
    public static WGPUBlendState createHeap(){
        return new WGPUBlendState();
    }

    /**
     * Creates this struct in direct memory.
     * This is how most structs should be created (unless, they
     * are members of a nothing struct)
     *
     * @see WgpuJavaStruct#useDirectMemory
     */
    public static WGPUBlendState createDirect(){
        var struct = new WGPUBlendState();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUBlendComponent getColor(){
        return color;
    }

    public WGPUBlendComponent getAlpha(){
        return alpha;
    }

}