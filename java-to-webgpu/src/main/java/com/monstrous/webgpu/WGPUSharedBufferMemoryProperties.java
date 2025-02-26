package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedBufferMemoryProperties extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStructOut> nextInChain = new DynamicStructRef<>(WGPUChainedStructOut.class);
    private final Struct.Unsigned32 usage = new Struct.Unsigned32();
    private final Struct.Unsigned64 size = new Struct.Unsigned64();

    private WGPUSharedBufferMemoryProperties(){}

    @Deprecated
    public WGPUSharedBufferMemoryProperties(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedBufferMemoryProperties createHeap(){
        return new WGPUSharedBufferMemoryProperties();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedBufferMemoryProperties createDirect(){
        WGPUSharedBufferMemoryProperties struct = new WGPUSharedBufferMemoryProperties();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStructOut> getNextInChain(){
        return nextInChain;
    }

    public void setNextInChain(WGPUChainedStructOut... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
    }

    public long getUsage(){
        return usage.get();
    }

    public void setUsage(long x){
        this.usage.set(x);
    }

    public @jnr.ffi.types.u_int64_t long getSize(){
        return size.get();
    }

    public void setSize(@jnr.ffi.types.u_int64_t long x){
        this.size.set(x);
    }

}