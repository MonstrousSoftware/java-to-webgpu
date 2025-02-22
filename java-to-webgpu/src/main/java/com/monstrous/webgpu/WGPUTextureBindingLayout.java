package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.WgpuJava;
import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUTextureBindingLayout extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Enum<WGPUTextureSampleType> sampleType = new Enum<>(WGPUTextureSampleType.class);
    private final Enum<WGPUTextureViewDimension> viewDimension = new Enum<>(WGPUTextureViewDimension.class);
    private final Unsigned32 multisampled = new Unsigned32();

    private WGPUTextureBindingLayout(){}

    @Deprecated
    public WGPUTextureBindingLayout(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUTextureBindingLayout createHeap(){
        return new WGPUTextureBindingLayout();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUTextureBindingLayout createDirect(){
        var struct = new WGPUTextureBindingLayout();
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

    public WGPUTextureSampleType getSampleType(){
        return sampleType.get();
    }

    public void setSampleType(WGPUTextureSampleType x){
        this.sampleType.set(x);
    }

    public WGPUTextureViewDimension getViewDimension(){
        return viewDimension.get();
    }

    public void setViewDimension(WGPUTextureViewDimension x){
        this.viewDimension.set(x);
    }

    public long getMultisampled(){
        return multisampled.get();
    }

    public void setMultisampled(long x){
        this.multisampled.set(x);
    }

}