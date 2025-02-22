package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.CStrPointer;
import com.monstrous.wgpuUtils.RustCString;
import com.monstrous.wgpuUtils.WgpuJava;
import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUFragmentState extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Pointer module = new Pointer();
    private final @CStrPointer Pointer entryPoint = new Pointer();
    private final size_t constantCount = new size_t();
    private final DynamicStructRef<WGPUConstantEntry> constants = new DynamicStructRef<>(WGPUConstantEntry.class);
    private final size_t targetCount = new size_t();
    private final DynamicStructRef<WGPUColorTargetState> targets = new DynamicStructRef<>(WGPUColorTargetState.class);

    private WGPUFragmentState(){}

    @Deprecated
    public WGPUFragmentState(Runtime runtime){
        super(runtime);
    }

    /**
     * Creates this struct on the java heap.
     * In general, this should <b>not</b> be used because these structs
     * cannot be directly passed into native code.
     */
    public static WGPUFragmentState createHeap(){
        return new WGPUFragmentState();
    }

    /**
     * Creates this struct in direct memory.
     * This is how most structs should be created (unless, they
     * are members of a nothing struct)
     *
     * @see WgpuJavaStruct#useDirectMemory
     */
    public static WGPUFragmentState createDirect(){
        var struct = new WGPUFragmentState();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStruct> getNextInChain(){
        return nextInChain;
    }

    public void setNextInChain(WGPUChainedStruct... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(WgpuJava.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
    }

    public jnr.ffi.Pointer getModule(){
        return module.get();
    }

    public void setModule(jnr.ffi.Pointer x){
        this.module.set(x);
    }

    public java.lang.String getEntryPoint(){
        return RustCString.fromPointer(entryPoint.get());
    }

    public void setEntryPoint(java.lang.String x){
        this.entryPoint.set(RustCString.toPointer(x));
    }

    public long getConstantCount(){
        return constantCount.get();
    }

    public void setConstantCount(long x){
        this.constantCount.set(x);
    }

    public DynamicStructRef<WGPUConstantEntry> getConstants(){
        return constants;
    }

    public void setConstants(WGPUConstantEntry... x){
        if(x.length == 0 || x[0] == null){
            this.constants.set(WgpuJava.createNullPointer());
        } else {
            this.constants.set(x);
        }
    }

    public long getTargetCount(){
        return targetCount.get();
    }

    public void setTargetCount(long x){
        this.targetCount.set(x);
    }

    public DynamicStructRef<WGPUColorTargetState> getTargets(){
        return targets;
    }

    public void setTargets(WGPUColorTargetState... x){
        if(x.length == 0 || x[0] == null){
            this.targets.set(WgpuJava.createNullPointer());
        } else {
            this.targets.set(x);
        }
    }

}