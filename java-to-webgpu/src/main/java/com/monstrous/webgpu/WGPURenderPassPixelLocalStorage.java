package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPURenderPassPixelLocalStorage extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Struct.Unsigned64 totalPixelLocalStorageSize = new Struct.Unsigned64();
    private final Struct.size_t storageAttachmentCount = new Struct.size_t();
    private final DynamicStructRef<WGPURenderPassStorageAttachment> storageAttachments = new DynamicStructRef<>(WGPURenderPassStorageAttachment.class);

    private WGPURenderPassPixelLocalStorage(){}

    @Deprecated
    public WGPURenderPassPixelLocalStorage(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPURenderPassPixelLocalStorage createHeap(){
        return new WGPURenderPassPixelLocalStorage();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPURenderPassPixelLocalStorage createDirect(){
        WGPURenderPassPixelLocalStorage struct = new WGPURenderPassPixelLocalStorage();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public @jnr.ffi.types.u_int64_t long getTotalPixelLocalStorageSize(){
        return totalPixelLocalStorageSize.get();
    }

    public WGPURenderPassPixelLocalStorage setTotalPixelLocalStorageSize(@jnr.ffi.types.u_int64_t long val){
        this.totalPixelLocalStorageSize.set(val); return this;
    }

    public long getStorageAttachmentCount(){
        return storageAttachmentCount.get();
    }

    public WGPURenderPassPixelLocalStorage setStorageAttachmentCount(long val){
        this.storageAttachmentCount.set(val); return this;
    }

    public DynamicStructRef<WGPURenderPassStorageAttachment> getStorageAttachments(){
        return storageAttachments;
    }

    public WGPURenderPassPixelLocalStorage setStorageAttachments(WGPURenderPassStorageAttachment... x){
        if(x.length == 0 || x[0] == null){
            this.storageAttachments.set(JavaWebGPU.createNullPointer());
        } else {
            this.storageAttachments.set(x);
        }
        return this;
    }

}