package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUOrigin2D extends WgpuJavaStruct {

    private final Struct.Unsigned32 x = new Struct.Unsigned32();
    private final Struct.Unsigned32 y = new Struct.Unsigned32();

    private WGPUOrigin2D(){}

    @Deprecated
    public WGPUOrigin2D(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUOrigin2D createHeap(){
        return new WGPUOrigin2D();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUOrigin2D createDirect(){
        WGPUOrigin2D struct = new WGPUOrigin2D();
        struct.useDirectMemory();
        return struct;
    }


    public long getX(){
        return x.get();
    }

    public WGPUOrigin2D setX(long val){
        this.x.set(val); return this;
    }

    public long getY(){
        return y.get();
    }

    public WGPUOrigin2D setY(long val){
        this.y.set(val); return this;
    }

}