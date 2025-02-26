package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUDawnExperimentalSubgroupLimits extends WgpuJavaStruct {

    private final WGPUChainedStructOut chain = inner(WGPUChainedStructOut.createHeap());
    private final Struct.Unsigned32 minSubgroupSize = new Struct.Unsigned32();
    private final Struct.Unsigned32 maxSubgroupSize = new Struct.Unsigned32();

    private WGPUDawnExperimentalSubgroupLimits(){}

    @Deprecated
    public WGPUDawnExperimentalSubgroupLimits(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUDawnExperimentalSubgroupLimits createHeap(){
        return new WGPUDawnExperimentalSubgroupLimits();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUDawnExperimentalSubgroupLimits createDirect(){
        WGPUDawnExperimentalSubgroupLimits struct = new WGPUDawnExperimentalSubgroupLimits();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStructOut getChain(){
        return chain;
    }

    public long getMinSubgroupSize(){
        return minSubgroupSize.get();
    }

    public void setMinSubgroupSize(long x){
        this.minSubgroupSize.set(x);
    }

    public long getMaxSubgroupSize(){
        return maxSubgroupSize.get();
    }

    public void setMaxSubgroupSize(long x){
        this.maxSubgroupSize.set(x);
    }

}