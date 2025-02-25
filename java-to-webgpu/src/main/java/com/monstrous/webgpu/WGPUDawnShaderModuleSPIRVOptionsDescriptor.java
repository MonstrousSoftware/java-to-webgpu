package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUDawnShaderModuleSPIRVOptionsDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Unsigned32 allowNonUniformDerivatives = new Unsigned32();

    private WGPUDawnShaderModuleSPIRVOptionsDescriptor(){}

    @Deprecated
    public WGPUDawnShaderModuleSPIRVOptionsDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUDawnShaderModuleSPIRVOptionsDescriptor createHeap(){
        return new WGPUDawnShaderModuleSPIRVOptionsDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUDawnShaderModuleSPIRVOptionsDescriptor createDirect(){
        var struct = new WGPUDawnShaderModuleSPIRVOptionsDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public long getAllowNonUniformDerivatives(){
        return allowNonUniformDerivatives.get();
    }

    public void setAllowNonUniformDerivatives(long x){
        this.allowNonUniformDerivatives.set(x);
    }

}