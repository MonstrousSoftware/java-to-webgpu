package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUBufferBindingLayout extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Struct.Enum<WGPUBufferBindingType> type = new Struct.Enum<>(WGPUBufferBindingType.class);
    private final Struct.Unsigned32 hasDynamicOffset = new Struct.Unsigned32();
    private final Struct.Unsigned64 minBindingSize = new Struct.Unsigned64();

    private WGPUBufferBindingLayout(){}

    @Deprecated
    public WGPUBufferBindingLayout(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUBufferBindingLayout createHeap(){
        return new WGPUBufferBindingLayout();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUBufferBindingLayout createDirect(){
        WGPUBufferBindingLayout struct = new WGPUBufferBindingLayout();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStruct> getNextInChain(){
        return nextInChain;
    }

    public WGPUBufferBindingLayout setNextInChain(WGPUChainedStruct... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
        return this;
    }

    public WGPUBufferBindingType getType(){
        return type.get();
    }

    public WGPUBufferBindingLayout setType(WGPUBufferBindingType val){
        this.type.set(val); return this;
    }

    public long getHasDynamicOffset(){
        return hasDynamicOffset.get();
    }

    public WGPUBufferBindingLayout setHasDynamicOffset(long val){
        this.hasDynamicOffset.set(val); return this;
    }

    public @jnr.ffi.types.u_int64_t long getMinBindingSize(){
        return minBindingSize.get();
    }

    public WGPUBufferBindingLayout setMinBindingSize(@jnr.ffi.types.u_int64_t long val){
        this.minBindingSize.set(val); return this;
    }

}