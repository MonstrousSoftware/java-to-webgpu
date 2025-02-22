package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPURenderPassDepthStencilAttachment extends WgpuJavaStruct {

    private final Pointer view = new Pointer();
    private final Enum<WGPULoadOp> depthLoadOp = new Enum<>(WGPULoadOp.class);
    private final Enum<WGPUStoreOp> depthStoreOp = new Enum<>(WGPUStoreOp.class);
    private final Float depthClearValue = new Float();
    private final Unsigned32 depthReadOnly = new Unsigned32();
    private final Enum<WGPULoadOp> stencilLoadOp = new Enum<>(WGPULoadOp.class);
    private final Enum<WGPUStoreOp> stencilStoreOp = new Enum<>(WGPUStoreOp.class);
    private final Unsigned32 stencilClearValue = new Unsigned32();
    private final Unsigned32 stencilReadOnly = new Unsigned32();

    private WGPURenderPassDepthStencilAttachment(){}

    @Deprecated
    public WGPURenderPassDepthStencilAttachment(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPURenderPassDepthStencilAttachment createHeap(){
        return new WGPURenderPassDepthStencilAttachment();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPURenderPassDepthStencilAttachment createDirect(){
        var struct = new WGPURenderPassDepthStencilAttachment();
        struct.useDirectMemory();
        return struct;
    }


    public jnr.ffi.Pointer getView(){
        return view.get();
    }

    public void setView(jnr.ffi.Pointer x){
        this.view.set(x);
    }

    public WGPULoadOp getDepthLoadOp(){
        return depthLoadOp.get();
    }

    public void setDepthLoadOp(WGPULoadOp x){
        this.depthLoadOp.set(x);
    }

    public WGPUStoreOp getDepthStoreOp(){
        return depthStoreOp.get();
    }

    public void setDepthStoreOp(WGPUStoreOp x){
        this.depthStoreOp.set(x);
    }

    public float getDepthClearValue(){
        return depthClearValue.get();
    }

    public void setDepthClearValue(float x){
        this.depthClearValue.set(x);
    }

    public long getDepthReadOnly(){
        return depthReadOnly.get();
    }

    public void setDepthReadOnly(long x){
        this.depthReadOnly.set(x);
    }

    public WGPULoadOp getStencilLoadOp(){
        return stencilLoadOp.get();
    }

    public void setStencilLoadOp(WGPULoadOp x){
        this.stencilLoadOp.set(x);
    }

    public WGPUStoreOp getStencilStoreOp(){
        return stencilStoreOp.get();
    }

    public void setStencilStoreOp(WGPUStoreOp x){
        this.stencilStoreOp.set(x);
    }

    public long getStencilClearValue(){
        return stencilClearValue.get();
    }

    public void setStencilClearValue(long x){
        this.stencilClearValue.set(x);
    }

    public long getStencilReadOnly(){
        return stencilReadOnly.get();
    }

    public void setStencilReadOnly(long x){
        this.stencilReadOnly.set(x);
    }

}