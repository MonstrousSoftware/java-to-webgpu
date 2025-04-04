package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUDawnCacheDeviceDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final @CStrPointer Struct.Pointer isolationKey = new Struct.Pointer();
    private final Struct.Pointer loadDataFunction = new Struct.Pointer();
    private final Struct.Pointer storeDataFunction = new Struct.Pointer();
    private final Struct.Pointer functionUserdata = new Struct.Pointer();

    private WGPUDawnCacheDeviceDescriptor(){}

    @Deprecated
    public WGPUDawnCacheDeviceDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUDawnCacheDeviceDescriptor createHeap(){
        return new WGPUDawnCacheDeviceDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUDawnCacheDeviceDescriptor createDirect(){
        WGPUDawnCacheDeviceDescriptor struct = new WGPUDawnCacheDeviceDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public java.lang.String getIsolationKey(){
        return RustCString.fromPointer(isolationKey.get());
    }

    public WGPUDawnCacheDeviceDescriptor setIsolationKey(java.lang.String str){
        this.isolationKey.set(RustCString.toPointer(str)); return this;
    }

    public jnr.ffi.Pointer getLoadDataFunction(){
        return loadDataFunction.get();
    }

    public WGPUDawnCacheDeviceDescriptor setLoadDataFunction(jnr.ffi.Pointer val){
        this.loadDataFunction.set(val); return this;
    }

    public jnr.ffi.Pointer getStoreDataFunction(){
        return storeDataFunction.get();
    }

    public WGPUDawnCacheDeviceDescriptor setStoreDataFunction(jnr.ffi.Pointer val){
        this.storeDataFunction.set(val); return this;
    }

    public jnr.ffi.Pointer getFunctionUserdata(){
        return functionUserdata.get();
    }

    public WGPUDawnCacheDeviceDescriptor setFunctionUserdata(jnr.ffi.Pointer val){
        this.functionUserdata.set(val); return this;
    }

}