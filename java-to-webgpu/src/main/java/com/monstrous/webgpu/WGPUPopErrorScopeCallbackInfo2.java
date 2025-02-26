package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUPopErrorScopeCallbackInfo2 extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Struct.Enum<WGPUCallbackMode> mode = new Struct.Enum<>(WGPUCallbackMode.class);
    private final Struct.Pointer callback = new Struct.Pointer();
    private final Struct.Pointer userdata1 = new Struct.Pointer();
    private final Struct.Pointer userdata2 = new Struct.Pointer();

    private WGPUPopErrorScopeCallbackInfo2(){}

    @Deprecated
    public WGPUPopErrorScopeCallbackInfo2(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUPopErrorScopeCallbackInfo2 createHeap(){
        return new WGPUPopErrorScopeCallbackInfo2();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUPopErrorScopeCallbackInfo2 createDirect(){
        WGPUPopErrorScopeCallbackInfo2 struct = new WGPUPopErrorScopeCallbackInfo2();
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

    public jnr.ffi.Pointer getUserdata1(){
        return userdata1.get();
    }

    public void setUserdata1(jnr.ffi.Pointer x){
        this.userdata1.set(x);
    }

    public jnr.ffi.Pointer getUserdata2(){
        return userdata2.get();
    }

    public void setUserdata2(jnr.ffi.Pointer x){
        this.userdata2.set(x);
    }

}