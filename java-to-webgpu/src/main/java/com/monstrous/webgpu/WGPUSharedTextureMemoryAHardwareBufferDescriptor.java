package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedTextureMemoryAHardwareBufferDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.Pointer handle = new Struct.Pointer();
    private final Struct.Unsigned32 useExternalFormat = new Struct.Unsigned32();

    private WGPUSharedTextureMemoryAHardwareBufferDescriptor(){}

    @Deprecated
    public WGPUSharedTextureMemoryAHardwareBufferDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedTextureMemoryAHardwareBufferDescriptor createHeap(){
        return new WGPUSharedTextureMemoryAHardwareBufferDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedTextureMemoryAHardwareBufferDescriptor createDirect(){
        WGPUSharedTextureMemoryAHardwareBufferDescriptor struct = new WGPUSharedTextureMemoryAHardwareBufferDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public jnr.ffi.Pointer getHandle(){
        return handle.get();
    }

    public WGPUSharedTextureMemoryAHardwareBufferDescriptor setHandle(jnr.ffi.Pointer val){
        this.handle.set(val); return this;
    }

    public long getUseExternalFormat(){
        return useExternalFormat.get();
    }

    public WGPUSharedTextureMemoryAHardwareBufferDescriptor setUseExternalFormat(long val){
        this.useExternalFormat.set(val); return this;
    }

}