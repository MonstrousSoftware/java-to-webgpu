package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUFormatCapabilities extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStructOut> nextInChain = new DynamicStructRef<>(WGPUChainedStructOut.class);

    private WGPUFormatCapabilities(){}

    @Deprecated
    public WGPUFormatCapabilities(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUFormatCapabilities createHeap(){
        return new WGPUFormatCapabilities();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUFormatCapabilities createDirect(){
        var struct = new WGPUFormatCapabilities();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStructOut> getNextInChain(){
        return nextInChain;
    }

    public void setNextInChain(WGPUChainedStructOut... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(WgpuJava.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
    }

}