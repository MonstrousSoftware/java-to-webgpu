package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSurfaceDescriptorFromWindowsHWND extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.Pointer hinstance = new Struct.Pointer();
    private final Struct.Pointer hwnd = new Struct.Pointer();

    private WGPUSurfaceDescriptorFromWindowsHWND(){}

    @Deprecated
    public WGPUSurfaceDescriptorFromWindowsHWND(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSurfaceDescriptorFromWindowsHWND createHeap(){
        return new WGPUSurfaceDescriptorFromWindowsHWND();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSurfaceDescriptorFromWindowsHWND createDirect(){
        WGPUSurfaceDescriptorFromWindowsHWND struct = new WGPUSurfaceDescriptorFromWindowsHWND();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public jnr.ffi.Pointer getHinstance(){
        return hinstance.get();
    }

    public void setHinstance(jnr.ffi.Pointer x){
        this.hinstance.set(x);
    }

    public jnr.ffi.Pointer getHwnd(){
        return hwnd.get();
    }

    public void setHwnd(jnr.ffi.Pointer x){
        this.hwnd.set(x);
    }

}