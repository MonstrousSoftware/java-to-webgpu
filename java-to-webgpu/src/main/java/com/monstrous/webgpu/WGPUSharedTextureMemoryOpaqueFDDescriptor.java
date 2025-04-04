package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedTextureMemoryOpaqueFDDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.Pointer vkImageCreateInfo = new Struct.Pointer();
    private final Struct.Unsigned32 memoryFD = new Struct.Unsigned32();
    private final Struct.Unsigned32 memoryTypeIndex = new Struct.Unsigned32();
    private final Struct.Unsigned64 allocationSize = new Struct.Unsigned64();
    private final Struct.Unsigned32 dedicatedAllocation = new Struct.Unsigned32();

    private WGPUSharedTextureMemoryOpaqueFDDescriptor(){}

    @Deprecated
    public WGPUSharedTextureMemoryOpaqueFDDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedTextureMemoryOpaqueFDDescriptor createHeap(){
        return new WGPUSharedTextureMemoryOpaqueFDDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedTextureMemoryOpaqueFDDescriptor createDirect(){
        WGPUSharedTextureMemoryOpaqueFDDescriptor struct = new WGPUSharedTextureMemoryOpaqueFDDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public jnr.ffi.Pointer getVkImageCreateInfo(){
        return vkImageCreateInfo.get();
    }

    public WGPUSharedTextureMemoryOpaqueFDDescriptor setVkImageCreateInfo(jnr.ffi.Pointer val){
        this.vkImageCreateInfo.set(val); return this;
    }

    public long getMemoryFD(){
        return memoryFD.get();
    }

    public WGPUSharedTextureMemoryOpaqueFDDescriptor setMemoryFD(long val){
        this.memoryFD.set(val); return this;
    }

    public long getMemoryTypeIndex(){
        return memoryTypeIndex.get();
    }

    public WGPUSharedTextureMemoryOpaqueFDDescriptor setMemoryTypeIndex(long val){
        this.memoryTypeIndex.set(val); return this;
    }

    public @jnr.ffi.types.u_int64_t long getAllocationSize(){
        return allocationSize.get();
    }

    public WGPUSharedTextureMemoryOpaqueFDDescriptor setAllocationSize(@jnr.ffi.types.u_int64_t long val){
        this.allocationSize.set(val); return this;
    }

    public long getDedicatedAllocation(){
        return dedicatedAllocation.get();
    }

    public WGPUSharedTextureMemoryOpaqueFDDescriptor setDedicatedAllocation(long val){
        this.dedicatedAllocation.set(val); return this;
    }

}