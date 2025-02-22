package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.WgpuJava;
import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUDepthStencilState extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Enum<WGPUTextureFormat> format = new Enum<>(WGPUTextureFormat.class);
    private final Unsigned32 depthWriteEnabled = new Unsigned32();
    private final Enum<WGPUCompareFunction> depthCompare = new Enum<>(WGPUCompareFunction.class);
    private final WGPUStencilFaceState stencilFront = inner(WGPUStencilFaceState.createHeap());
    private final WGPUStencilFaceState stencilBack = inner(WGPUStencilFaceState.createHeap());
    private final Unsigned32 stencilReadMask = new Unsigned32();
    private final Unsigned32 stencilWriteMask = new Unsigned32();
    private final Signed32 depthBias = new Signed32();
    private final Float depthBiasSlopeScale = new Float();
    private final Float depthBiasClamp = new Float();

    private WGPUDepthStencilState(){}

    @Deprecated
    public WGPUDepthStencilState(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUDepthStencilState createHeap(){
        return new WGPUDepthStencilState();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUDepthStencilState createDirect(){
        var struct = new WGPUDepthStencilState();
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

    public WGPUTextureFormat getFormat(){
        return format.get();
    }

    public void setFormat(WGPUTextureFormat x){
        this.format.set(x);
    }

    public long getDepthWriteEnabled(){
        return depthWriteEnabled.get();
    }

    public void setDepthWriteEnabled(long x){
        this.depthWriteEnabled.set(x);
    }

    public WGPUCompareFunction getDepthCompare(){
        return depthCompare.get();
    }

    public void setDepthCompare(WGPUCompareFunction x){
        this.depthCompare.set(x);
    }

    public WGPUStencilFaceState getStencilFront(){
        return stencilFront;
    }

    public WGPUStencilFaceState getStencilBack(){
        return stencilBack;
    }

    public long getStencilReadMask(){
        return stencilReadMask.get();
    }

    public void setStencilReadMask(long x){
        this.stencilReadMask.set(x);
    }

    public long getStencilWriteMask(){
        return stencilWriteMask.get();
    }

    public void setStencilWriteMask(long x){
        this.stencilWriteMask.set(x);
    }

    public int getDepthBias(){
        return depthBias.get();
    }

    public void setDepthBias(int x){
        this.depthBias.set(x);
    }

    public float getDepthBiasSlopeScale(){
        return depthBiasSlopeScale.get();
    }

    public void setDepthBiasSlopeScale(float x){
        this.depthBiasSlopeScale.set(x);
    }

    public float getDepthBiasClamp(){
        return depthBiasClamp.get();
    }

    public void setDepthBiasClamp(float x){
        this.depthBiasClamp.set(x);
    }

}