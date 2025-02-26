package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUAdapterPropertiesMemoryHeaps extends WgpuJavaStruct {

    private final WGPUChainedStructOut chain = inner(WGPUChainedStructOut.createHeap());
    private final Struct.size_t heapCount = new Struct.size_t();
    private final DynamicStructRef<WGPUMemoryHeapInfo> heapInfo = new DynamicStructRef<>(WGPUMemoryHeapInfo.class);

    private WGPUAdapterPropertiesMemoryHeaps(){}

    @Deprecated
    public WGPUAdapterPropertiesMemoryHeaps(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUAdapterPropertiesMemoryHeaps createHeap(){
        return new WGPUAdapterPropertiesMemoryHeaps();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUAdapterPropertiesMemoryHeaps createDirect(){
        WGPUAdapterPropertiesMemoryHeaps struct = new WGPUAdapterPropertiesMemoryHeaps();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStructOut getChain(){
        return chain;
    }

    public long getHeapCount(){
        return heapCount.get();
    }

    public void setHeapCount(long x){
        this.heapCount.set(x);
    }

    public DynamicStructRef<WGPUMemoryHeapInfo> getHeapInfo(){
        return heapInfo;
    }

    public void setHeapInfo(WGPUMemoryHeapInfo... x){
        if(x.length == 0 || x[0] == null){
            this.heapInfo.set(JavaWebGPU.createNullPointer());
        } else {
            this.heapInfo.set(x);
        }
    }

}