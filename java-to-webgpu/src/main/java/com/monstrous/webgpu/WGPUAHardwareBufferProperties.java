package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUAHardwareBufferProperties extends WgpuJavaStruct {

    private final WGPUYCbCrVkDescriptor yCbCrInfo = inner(WGPUYCbCrVkDescriptor.createHeap());

    private WGPUAHardwareBufferProperties(){}

    @Deprecated
    public WGPUAHardwareBufferProperties(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUAHardwareBufferProperties createHeap(){
        return new WGPUAHardwareBufferProperties();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUAHardwareBufferProperties createDirect(){
        WGPUAHardwareBufferProperties struct = new WGPUAHardwareBufferProperties();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUYCbCrVkDescriptor getYCbCrInfo(){
        return yCbCrInfo;
    }

}