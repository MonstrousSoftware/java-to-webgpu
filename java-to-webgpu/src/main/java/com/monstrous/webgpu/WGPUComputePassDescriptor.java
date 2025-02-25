package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUComputePassDescriptor extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final @CStrPointer Pointer label = new Pointer();
    private final DynamicStructRef<WGPUComputePassTimestampWrites> timestampWrites = new DynamicStructRef<>(WGPUComputePassTimestampWrites.class);

    private WGPUComputePassDescriptor(){}

    @Deprecated
    public WGPUComputePassDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUComputePassDescriptor createHeap(){
        return new WGPUComputePassDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUComputePassDescriptor createDirect(){
        var struct = new WGPUComputePassDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStruct> getNextInChain(){
        return nextInChain;
    }

    public void setNextInChain(WGPUChainedStruct... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(WgpuJava.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
    }

    public java.lang.String getLabel(){
        return RustCString.fromPointer(label.get());
    }

    public void setLabel(java.lang.String x){
        this.label.set(RustCString.toPointer(x));
    }

    public DynamicStructRef<WGPUComputePassTimestampWrites> getTimestampWrites(){
        return timestampWrites;
    }

    public void setTimestampWrites(WGPUComputePassTimestampWrites... x){
        if(x.length == 0 || x[0] == null){
            this.timestampWrites.set(WgpuJava.createNullPointer());
        } else {
            this.timestampWrites.set(x);
        }
    }

}