package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSurfaceTexture extends WgpuJavaStruct {

    private final Struct.Pointer texture = new Struct.Pointer();
    private final Struct.Unsigned32 suboptimal = new Struct.Unsigned32();
    private final Struct.Enum<WGPUSurfaceGetCurrentTextureStatus> status = new Struct.Enum<>(WGPUSurfaceGetCurrentTextureStatus.class);

    private WGPUSurfaceTexture(){}

    @Deprecated
    public WGPUSurfaceTexture(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSurfaceTexture createHeap(){
        return new WGPUSurfaceTexture();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSurfaceTexture createDirect(){
        WGPUSurfaceTexture struct = new WGPUSurfaceTexture();
        struct.useDirectMemory();
        return struct;
    }


    public jnr.ffi.Pointer getTexture(){
        return texture.get();
    }

    public void setTexture(jnr.ffi.Pointer x){
        this.texture.set(x);
    }

    public long getSuboptimal(){
        return suboptimal.get();
    }

    public void setSuboptimal(long x){
        this.suboptimal.set(x);
    }

    public WGPUSurfaceGetCurrentTextureStatus getStatus(){
        return status.get();
    }

    public void setStatus(WGPUSurfaceGetCurrentTextureStatus x){
        this.status.set(x);
    }

}