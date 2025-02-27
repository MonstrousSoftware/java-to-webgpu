package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUDawnWGSLBlocklist extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.size_t blocklistedFeatureCount = new Struct.size_t();
    private final Struct.Pointer blocklistedFeatures = new Struct.Pointer();

    private WGPUDawnWGSLBlocklist(){}

    @Deprecated
    public WGPUDawnWGSLBlocklist(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUDawnWGSLBlocklist createHeap(){
        return new WGPUDawnWGSLBlocklist();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUDawnWGSLBlocklist createDirect(){
        WGPUDawnWGSLBlocklist struct = new WGPUDawnWGSLBlocklist();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public long getBlocklistedFeatureCount(){
        return blocklistedFeatureCount.get();
    }

    public WGPUDawnWGSLBlocklist setBlocklistedFeatureCount(long val){
        this.blocklistedFeatureCount.set(val); return this;
    }

    public jnr.ffi.Pointer getBlocklistedFeatures(){
        return blocklistedFeatures.get();
    }

    public WGPUDawnWGSLBlocklist setBlocklistedFeatures(jnr.ffi.Pointer val){
        this.blocklistedFeatures.set(val); return this;
    }

}