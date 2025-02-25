package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedTextureMemoryD3DSwapchainBeginState extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Unsigned32 isSwapchain = new Unsigned32();

    private WGPUSharedTextureMemoryD3DSwapchainBeginState(){}

    @Deprecated
    public WGPUSharedTextureMemoryD3DSwapchainBeginState(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedTextureMemoryD3DSwapchainBeginState createHeap(){
        return new WGPUSharedTextureMemoryD3DSwapchainBeginState();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedTextureMemoryD3DSwapchainBeginState createDirect(){
        var struct = new WGPUSharedTextureMemoryD3DSwapchainBeginState();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public long getIsSwapchain(){
        return isSwapchain.get();
    }

    public void setIsSwapchain(long x){
        this.isSwapchain.set(x);
    }

}