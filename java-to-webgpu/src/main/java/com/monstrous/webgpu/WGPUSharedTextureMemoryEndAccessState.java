package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedTextureMemoryEndAccessState extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStructOut> nextInChain = new DynamicStructRef<>(WGPUChainedStructOut.class);
    private final Unsigned32 initialized = new Unsigned32();
    private final size_t fenceCount = new size_t();
    private final Pointer fences = new Pointer();
    private final Pointer signaledValues = new Pointer();

    private WGPUSharedTextureMemoryEndAccessState(){}

    @Deprecated
    public WGPUSharedTextureMemoryEndAccessState(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedTextureMemoryEndAccessState createHeap(){
        return new WGPUSharedTextureMemoryEndAccessState();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedTextureMemoryEndAccessState createDirect(){
        var struct = new WGPUSharedTextureMemoryEndAccessState();
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

    public long getInitialized(){
        return initialized.get();
    }

    public void setInitialized(long x){
        this.initialized.set(x);
    }

    public long getFenceCount(){
        return fenceCount.get();
    }

    public void setFenceCount(long x){
        this.fenceCount.set(x);
    }

    public jnr.ffi.Pointer getFences(){
        return fences.get();
    }

    public void setFences(jnr.ffi.Pointer x){
        this.fences.set(x);
    }

    public jnr.ffi.Pointer getSignaledValues(){
        return signaledValues.get();
    }

    public void setSignaledValues(jnr.ffi.Pointer x){
        this.signaledValues.set(x);
    }

}