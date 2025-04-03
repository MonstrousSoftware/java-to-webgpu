package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.Unsigned32 handle = new Struct.Unsigned32();

    private WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor(){}

    @Deprecated
    public WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor createHeap(){
        return new WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor createDirect(){
        WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor struct = new WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public long getHandle(){
        return handle.get();
    }

    public WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor setHandle(long val){
        this.handle.set(val); return this;
    }

}