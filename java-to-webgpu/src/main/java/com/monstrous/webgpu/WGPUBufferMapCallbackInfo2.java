package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUBufferMapCallbackInfo2 extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Struct.Enum<WGPUCallbackMode> mode = new Struct.Enum<>(WGPUCallbackMode.class);
    private final Struct.Pointer callback = new Struct.Pointer();
    private final Struct.Pointer userdata1 = new Struct.Pointer();
    private final Struct.Pointer userdata2 = new Struct.Pointer();

    private WGPUBufferMapCallbackInfo2(){}

    @Deprecated
    public WGPUBufferMapCallbackInfo2(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUBufferMapCallbackInfo2 createHeap(){
        return new WGPUBufferMapCallbackInfo2();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUBufferMapCallbackInfo2 createDirect(){
        WGPUBufferMapCallbackInfo2 struct = new WGPUBufferMapCallbackInfo2();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStruct> getNextInChain(){
        return nextInChain;
    }

    public WGPUBufferMapCallbackInfo2 setNextInChain(WGPUChainedStruct... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
        return this;
    }

    public WGPUCallbackMode getMode(){
        return mode.get();
    }

    public WGPUBufferMapCallbackInfo2 setMode(WGPUCallbackMode val){
        this.mode.set(val); return this;
    }

    public jnr.ffi.Pointer getCallback(){
        return callback.get();
    }

    public WGPUBufferMapCallbackInfo2 setCallback(jnr.ffi.Pointer val){
        this.callback.set(val); return this;
    }

    public jnr.ffi.Pointer getUserdata1(){
        return userdata1.get();
    }

    public WGPUBufferMapCallbackInfo2 setUserdata1(jnr.ffi.Pointer val){
        this.userdata1.set(val); return this;
    }

    public jnr.ffi.Pointer getUserdata2(){
        return userdata2.get();
    }

    public WGPUBufferMapCallbackInfo2 setUserdata2(jnr.ffi.Pointer val){
        this.userdata2.set(val); return this;
    }

}