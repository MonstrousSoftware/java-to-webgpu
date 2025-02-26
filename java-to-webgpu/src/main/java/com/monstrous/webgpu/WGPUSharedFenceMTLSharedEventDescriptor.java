package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedFenceMTLSharedEventDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.Pointer sharedEvent = new Struct.Pointer();

    private WGPUSharedFenceMTLSharedEventDescriptor(){}

    @Deprecated
    public WGPUSharedFenceMTLSharedEventDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedFenceMTLSharedEventDescriptor createHeap(){
        return new WGPUSharedFenceMTLSharedEventDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedFenceMTLSharedEventDescriptor createDirect(){
        WGPUSharedFenceMTLSharedEventDescriptor struct = new WGPUSharedFenceMTLSharedEventDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public jnr.ffi.Pointer getSharedEvent(){
        return sharedEvent.get();
    }

    public void setSharedEvent(jnr.ffi.Pointer x){
        this.sharedEvent.set(x);
    }

}