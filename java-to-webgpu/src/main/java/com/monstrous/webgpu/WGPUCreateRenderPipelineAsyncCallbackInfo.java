package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUCreateRenderPipelineAsyncCallbackInfo extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Enum<WGPUCallbackMode> mode = new Enum<>(WGPUCallbackMode.class);
    private final Pointer callback = new Pointer();
    private final Pointer userdata = new Pointer();

    private WGPUCreateRenderPipelineAsyncCallbackInfo(){}

    @Deprecated
    public WGPUCreateRenderPipelineAsyncCallbackInfo(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUCreateRenderPipelineAsyncCallbackInfo createHeap(){
        return new WGPUCreateRenderPipelineAsyncCallbackInfo();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUCreateRenderPipelineAsyncCallbackInfo createDirect(){
        var struct = new WGPUCreateRenderPipelineAsyncCallbackInfo();
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

    public WGPUCallbackMode getMode(){
        return mode.get();
    }

    public void setMode(WGPUCallbackMode x){
        this.mode.set(x);
    }

    public jnr.ffi.Pointer getCallback(){
        return callback.get();
    }

    public void setCallback(jnr.ffi.Pointer x){
        this.callback.set(x);
    }

    public jnr.ffi.Pointer getUserdata(){
        return userdata.get();
    }

    public void setUserdata(jnr.ffi.Pointer x){
        this.userdata.set(x);
    }

}