package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.CStrPointer;
import com.monstrous.wgpuUtils.RustCString;
import com.monstrous.wgpuUtils.WgpuJava;
import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUQuerySetDescriptor extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final @CStrPointer Pointer label = new Pointer();
    private final Enum<WGPUQueryType> type = new Enum<>(WGPUQueryType.class);
    private final Unsigned32 count = new Unsigned32();

    private WGPUQuerySetDescriptor(){}

    @Deprecated
    public WGPUQuerySetDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUQuerySetDescriptor createHeap(){
        return new WGPUQuerySetDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUQuerySetDescriptor createDirect(){
        var struct = new WGPUQuerySetDescriptor();
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

    public WGPUQueryType getType(){
        return type.get();
    }

    public void setType(WGPUQueryType x){
        this.type.set(x);
    }

    public long getCount(){
        return count.get();
    }

    public void setCount(long x){
        this.count.set(x);
    }

}