package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUFuture extends WgpuJavaStruct {

    private final Unsigned64 id = new Unsigned64();

    private WGPUFuture(){}

    @Deprecated
    public WGPUFuture(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUFuture createHeap(){
        return new WGPUFuture();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUFuture createDirect(){
        var struct = new WGPUFuture();
        struct.useDirectMemory();
        return struct;
    }


    public @jnr.ffi.types.u_int64_t long getId(){
        return id.get();
    }

    public void setId(@jnr.ffi.types.u_int64_t long x){
        this.id.set(x);
    }

}