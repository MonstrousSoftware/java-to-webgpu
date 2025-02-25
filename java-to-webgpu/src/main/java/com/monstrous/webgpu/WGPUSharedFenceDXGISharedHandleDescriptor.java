package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedFenceDXGISharedHandleDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Pointer handle = new Pointer();

    private WGPUSharedFenceDXGISharedHandleDescriptor(){}

    @Deprecated
    public WGPUSharedFenceDXGISharedHandleDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedFenceDXGISharedHandleDescriptor createHeap(){
        return new WGPUSharedFenceDXGISharedHandleDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedFenceDXGISharedHandleDescriptor createDirect(){
        var struct = new WGPUSharedFenceDXGISharedHandleDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public jnr.ffi.Pointer getHandle(){
        return handle.get();
    }

    public void setHandle(jnr.ffi.Pointer x){
        this.handle.set(x);
    }

}