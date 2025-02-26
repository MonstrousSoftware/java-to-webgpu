package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedFenceDXGISharedHandleExportInfo extends WgpuJavaStruct {

    private final WGPUChainedStructOut chain = inner(WGPUChainedStructOut.createHeap());
    private final Struct.Pointer handle = new Struct.Pointer();

    private WGPUSharedFenceDXGISharedHandleExportInfo(){}

    @Deprecated
    public WGPUSharedFenceDXGISharedHandleExportInfo(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedFenceDXGISharedHandleExportInfo createHeap(){
        return new WGPUSharedFenceDXGISharedHandleExportInfo();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedFenceDXGISharedHandleExportInfo createDirect(){
        WGPUSharedFenceDXGISharedHandleExportInfo struct = new WGPUSharedFenceDXGISharedHandleExportInfo();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStructOut getChain(){
        return chain;
    }

    public jnr.ffi.Pointer getHandle(){
        return handle.get();
    }

    public void setHandle(jnr.ffi.Pointer x){
        this.handle.set(x);
    }

}