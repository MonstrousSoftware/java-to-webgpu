package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSurfaceConfiguration extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Pointer device = new Pointer();
    private final Enum<WGPUTextureFormat> format = new Enum<>(WGPUTextureFormat.class);
    private final Unsigned32 usage = new Unsigned32();
    private final size_t viewFormatCount = new size_t();
    private final Pointer viewFormats = new Pointer();
    private final Enum<WGPUCompositeAlphaMode> alphaMode = new Enum<>(WGPUCompositeAlphaMode.class);
    private final Unsigned32 width = new Unsigned32();
    private final Unsigned32 height = new Unsigned32();
    private final Enum<WGPUPresentMode> presentMode = new Enum<>(WGPUPresentMode.class);

    private WGPUSurfaceConfiguration(){}

    @Deprecated
    public WGPUSurfaceConfiguration(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSurfaceConfiguration createHeap(){
        return new WGPUSurfaceConfiguration();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSurfaceConfiguration createDirect(){
        var struct = new WGPUSurfaceConfiguration();
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

    public jnr.ffi.Pointer getDevice(){
        return device.get();
    }

    public void setDevice(jnr.ffi.Pointer x){
        this.device.set(x);
    }

    public WGPUTextureFormat getFormat(){
        return format.get();
    }

    public void setFormat(WGPUTextureFormat x){
        this.format.set(x);
    }

    public long getUsage(){
        return usage.get();
    }

    public void setUsage(long x){
        this.usage.set(x);
    }

    public long getViewFormatCount(){
        return viewFormatCount.get();
    }

    public void setViewFormatCount(long x){
        this.viewFormatCount.set(x);
    }

    public jnr.ffi.Pointer getViewFormats(){
        return viewFormats.get();
    }

    public void setViewFormats(jnr.ffi.Pointer x){
        this.viewFormats.set(x);
    }

    public WGPUCompositeAlphaMode getAlphaMode(){
        return alphaMode.get();
    }

    public void setAlphaMode(WGPUCompositeAlphaMode x){
        this.alphaMode.set(x);
    }

    public long getWidth(){
        return width.get();
    }

    public void setWidth(long x){
        this.width.set(x);
    }

    public long getHeight(){
        return height.get();
    }

    public void setHeight(long x){
        this.height.set(x);
    }

    public WGPUPresentMode getPresentMode(){
        return presentMode.get();
    }

    public void setPresentMode(WGPUPresentMode x){
        this.presentMode.set(x);
    }

}