package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUExternalTextureBindingEntry extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.Pointer externalTexture = new Struct.Pointer();

    private WGPUExternalTextureBindingEntry(){}

    @Deprecated
    public WGPUExternalTextureBindingEntry(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUExternalTextureBindingEntry createHeap(){
        return new WGPUExternalTextureBindingEntry();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUExternalTextureBindingEntry createDirect(){
        WGPUExternalTextureBindingEntry struct = new WGPUExternalTextureBindingEntry();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public jnr.ffi.Pointer getExternalTexture(){
        return externalTexture.get();
    }

    public WGPUExternalTextureBindingEntry setExternalTexture(jnr.ffi.Pointer val){
        this.externalTexture.set(val); return this;
    }

}