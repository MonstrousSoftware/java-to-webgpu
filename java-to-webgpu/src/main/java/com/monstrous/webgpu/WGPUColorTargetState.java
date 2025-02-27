package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUColorTargetState extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Struct.Enum<WGPUTextureFormat> format = new Struct.Enum<>(WGPUTextureFormat.class);
    private final @Nullable DynamicStructRef<WGPUBlendState> blend = new DynamicStructRef<>(WGPUBlendState.class);
    private final Struct.Unsigned32 writeMask = new Struct.Unsigned32();

    private WGPUColorTargetState(){}

    @Deprecated
    public WGPUColorTargetState(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUColorTargetState createHeap(){
        return new WGPUColorTargetState();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUColorTargetState createDirect(){
        WGPUColorTargetState struct = new WGPUColorTargetState();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStruct> getNextInChain(){
        return nextInChain;
    }

    public WGPUColorTargetState setNextInChain(WGPUChainedStruct... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
        return this;
    }

    public WGPUTextureFormat getFormat(){
        return format.get();
    }

    public WGPUColorTargetState setFormat(WGPUTextureFormat val){
        this.format.set(val); return this;
    }

    public DynamicStructRef<WGPUBlendState> getBlend(){
        return blend;
    }

    public WGPUColorTargetState setBlend(WGPUBlendState... x){
        if(x.length == 0 || x[0] == null){
            this.blend.set(JavaWebGPU.createNullPointer());
        } else {
            this.blend.set(x);
        }
        return this;
    }

    public long getWriteMask(){
        return writeMask.get();
    }

    public WGPUColorTargetState setWriteMask(long val){
        this.writeMask.set(val); return this;
    }

}