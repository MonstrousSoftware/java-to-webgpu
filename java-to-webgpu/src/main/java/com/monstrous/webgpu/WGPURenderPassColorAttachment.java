package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPURenderPassColorAttachment extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Struct.Pointer view = new Struct.Pointer();
    private final Struct.Unsigned32 depthSlice = new Struct.Unsigned32();
    private final Struct.Pointer resolveTarget = new Struct.Pointer();
    private final Struct.Enum<WGPULoadOp> loadOp = new Struct.Enum<>(WGPULoadOp.class);
    private final Struct.Enum<WGPUStoreOp> storeOp = new Struct.Enum<>(WGPUStoreOp.class);
    private final WGPUColor clearValue = inner(WGPUColor.createHeap());

    private WGPURenderPassColorAttachment(){}

    @Deprecated
    public WGPURenderPassColorAttachment(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPURenderPassColorAttachment createHeap(){
        return new WGPURenderPassColorAttachment();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPURenderPassColorAttachment createDirect(){
        WGPURenderPassColorAttachment struct = new WGPURenderPassColorAttachment();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStruct> getNextInChain(){
        return nextInChain;
    }

    public void setNextInChain(WGPUChainedStruct... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
    }

    public jnr.ffi.Pointer getView(){
        return view.get();
    }

    public void setView(jnr.ffi.Pointer x){
        this.view.set(x);
    }

    public long getDepthSlice(){
        return depthSlice.get();
    }

    public void setDepthSlice(long x){
        this.depthSlice.set(x);
    }

    public jnr.ffi.Pointer getResolveTarget(){
        return resolveTarget.get();
    }

    public void setResolveTarget(jnr.ffi.Pointer x){
        this.resolveTarget.set(x);
    }

    public WGPULoadOp getLoadOp(){
        return loadOp.get();
    }

    public void setLoadOp(WGPULoadOp x){
        this.loadOp.set(x);
    }

    public WGPUStoreOp getStoreOp(){
        return storeOp.get();
    }

    public void setStoreOp(WGPUStoreOp x){
        this.storeOp.set(x);
    }

    public WGPUColor getClearValue(){
        return clearValue;
    }

}