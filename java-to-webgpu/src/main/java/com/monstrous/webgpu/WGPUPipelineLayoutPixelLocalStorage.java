package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUPipelineLayoutPixelLocalStorage extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.Unsigned64 totalPixelLocalStorageSize = new Struct.Unsigned64();
    private final Struct.size_t storageAttachmentCount = new Struct.size_t();
    private final DynamicStructRef<WGPUPipelineLayoutStorageAttachment> storageAttachments = new DynamicStructRef<>(WGPUPipelineLayoutStorageAttachment.class);

    private WGPUPipelineLayoutPixelLocalStorage(){}

    @Deprecated
    public WGPUPipelineLayoutPixelLocalStorage(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUPipelineLayoutPixelLocalStorage createHeap(){
        return new WGPUPipelineLayoutPixelLocalStorage();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUPipelineLayoutPixelLocalStorage createDirect(){
        WGPUPipelineLayoutPixelLocalStorage struct = new WGPUPipelineLayoutPixelLocalStorage();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public @jnr.ffi.types.u_int64_t long getTotalPixelLocalStorageSize(){
        return totalPixelLocalStorageSize.get();
    }

    public void setTotalPixelLocalStorageSize(@jnr.ffi.types.u_int64_t long x){
        this.totalPixelLocalStorageSize.set(x);
    }

    public long getStorageAttachmentCount(){
        return storageAttachmentCount.get();
    }

    public void setStorageAttachmentCount(long x){
        this.storageAttachmentCount.set(x);
    }

    public DynamicStructRef<WGPUPipelineLayoutStorageAttachment> getStorageAttachments(){
        return storageAttachments;
    }

    public void setStorageAttachments(WGPUPipelineLayoutStorageAttachment... x){
        if(x.length == 0 || x[0] == null){
            this.storageAttachments.set(JavaWebGPU.createNullPointer());
        } else {
            this.storageAttachments.set(x);
        }
    }

}