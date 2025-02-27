package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPURenderPassDepthStencilAttachment extends WgpuJavaStruct {

    private final Struct.Pointer view = new Struct.Pointer();
    private final Struct.Enum<WGPULoadOp> depthLoadOp = new Struct.Enum<>(WGPULoadOp.class);
    private final Struct.Enum<WGPUStoreOp> depthStoreOp = new Struct.Enum<>(WGPUStoreOp.class);
    private final Struct.Float depthClearValue = new Struct.Float();
    private final Struct.Unsigned32 depthReadOnly = new Struct.Unsigned32();
    private final Struct.Enum<WGPULoadOp> stencilLoadOp = new Struct.Enum<>(WGPULoadOp.class);
    private final Struct.Enum<WGPUStoreOp> stencilStoreOp = new Struct.Enum<>(WGPUStoreOp.class);
    private final Struct.Unsigned32 stencilClearValue = new Struct.Unsigned32();
    private final Struct.Unsigned32 stencilReadOnly = new Struct.Unsigned32();

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
        WGPURenderPassDepthStencilAttachment struct = new WGPURenderPassDepthStencilAttachment();
        struct.useDirectMemory();
        return struct;
    }


    public jnr.ffi.Pointer getView(){
        return view.get();
    }

    public WGPURenderPassDepthStencilAttachment setView(jnr.ffi.Pointer val){
        this.view.set(val); return this;
    }

    public WGPULoadOp getDepthLoadOp(){
        return depthLoadOp.get();
    }

    public WGPURenderPassDepthStencilAttachment setDepthLoadOp(WGPULoadOp val){
        this.depthLoadOp.set(val); return this;
    }

    public WGPUStoreOp getDepthStoreOp(){
        return depthStoreOp.get();
    }

    public WGPURenderPassDepthStencilAttachment setDepthStoreOp(WGPUStoreOp val){
        this.depthStoreOp.set(val); return this;
    }

    public float getDepthClearValue(){
        return depthClearValue.get();
    }

    public WGPURenderPassDepthStencilAttachment setDepthClearValue(float val){
        this.depthClearValue.set(val); return this;
    }

    public long getDepthReadOnly(){
        return depthReadOnly.get();
    }

    public WGPURenderPassDepthStencilAttachment setDepthReadOnly(long val){
        this.depthReadOnly.set(val); return this;
    }

    public WGPULoadOp getStencilLoadOp(){
        return stencilLoadOp.get();
    }

    public WGPURenderPassDepthStencilAttachment setStencilLoadOp(WGPULoadOp val){
        this.stencilLoadOp.set(val); return this;
    }

    public WGPUStoreOp getStencilStoreOp(){
        return stencilStoreOp.get();
    }

    public WGPURenderPassDepthStencilAttachment setStencilStoreOp(WGPUStoreOp val){
        this.stencilStoreOp.set(val); return this;
    }

    public long getStencilClearValue(){
        return stencilClearValue.get();
    }

    public WGPURenderPassDepthStencilAttachment setStencilClearValue(long val){
        this.stencilClearValue.set(val); return this;
    }

    public long getStencilReadOnly(){
        return stencilReadOnly.get();
    }

    public WGPURenderPassDepthStencilAttachment setStencilReadOnly(long val){
        this.stencilReadOnly.set(val); return this;
    }

}