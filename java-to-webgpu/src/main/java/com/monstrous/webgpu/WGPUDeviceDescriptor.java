package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.CStrPointer;
import com.monstrous.wgpuUtils.RustCString;
import com.monstrous.wgpuUtils.WgpuJava;
import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;


// MM modified


/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUDeviceDescriptor extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final @CStrPointer Pointer label = new Pointer();
    private final size_t requiredFeatureCount = new size_t();
    private final Pointer requiredFeatures = new Pointer();
    private final Pointer requiredLimits = new Pointer();
    //private final DynamicStructRef<WGPURequiredLimits> requiredLimits = new DynamicStructRef<>(WGPURequiredLimits.class);
    private final WGPUQueueDescriptor defaultQueue = inner(WGPUQueueDescriptor.createHeap());
    private final Pointer deviceLostCallback = new Pointer();
    private final Pointer deviceLostUserdata = new Pointer();
    private final WGPUDeviceLostCallbackInfo deviceLostCallbackInfo = inner(WGPUDeviceLostCallbackInfo.createHeap());
    private final WGPUUncapturedErrorCallbackInfo uncapturedErrorCallbackInfo = inner(WGPUUncapturedErrorCallbackInfo.createHeap());

    private WGPUDeviceDescriptor(){}

    @Deprecated
    public WGPUDeviceDescriptor(Runtime runtime){
        super(runtime);
    }

    /**
     * Creates this struct on the java heap.
     * In general, this should <b>not</b> be used because these structs
     * cannot be directly passed into native code.
     */
    public static WGPUDeviceDescriptor createHeap(){
        return new WGPUDeviceDescriptor();
    }

    /**
     * Creates this struct in direct memory.
     * This is how most structs should be created (unless, they
     * are members of a nothing struct)
     *
     * @see WgpuJavaStruct#useDirectMemory
     */
    public static WGPUDeviceDescriptor createDirect(){
        var struct = new WGPUDeviceDescriptor();
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

    public java.lang.String getLabel(){
        return RustCString.fromPointer(label.get());
    }

    public void setLabel(java.lang.String x){
        this.label.set(RustCString.toPointer(x));
    }

    public long getRequiredFeatureCount(){
        return requiredFeatureCount.get();
    }

    public void setRequiredFeatureCount(long x){
        this.requiredFeatureCount.set(x);
    }

    public Pointer getRequiredFeatures(){
        return requiredFeatures;
    }

    public void setRequiredFeatures(jnr.ffi.Pointer x){
//        if(x.length == 0 || x[0] == null){
            this.requiredFeatures.set(x);
//        } else {
//            this.requiredFeatures.set(x);
//        }
    }


    public Pointer getRequiredLimits(){
        return requiredLimits;
    }

    public void setRequiredLimits(WGPURequiredLimits... x){
//        if(x.length == 0 || x[0] == null){
        this.requiredLimits.set(WgpuJava.createNullPointer());
//        } else {
//            this.requiredLimits.set(x);
//        }
    }
//    public DynamicStructRef<WGPURequiredLimits> getRequiredLimits(){
//        return requiredLimits;
//    }
//
//    public void setRequiredLimits(WGPURequiredLimits... x){
//        if(x.length == 0 || x[0] == null){
//            this.requiredLimits.set(WgpuJava.createNullPointer());
//        } else {
//            this.requiredLimits.set(x);
//        }
//    }

    public WGPUQueueDescriptor getDefaultQueue(){
        return defaultQueue;
    }

    public jnr.ffi.Pointer getDeviceLostCallback(){
        return deviceLostCallback.get();
    }

    public void setDeviceLostCallback(jnr.ffi.Pointer x){
        this.deviceLostCallback.set(x);
    }

    public jnr.ffi.Pointer getDeviceLostUserdata(){
        return deviceLostUserdata.get();
    }

    public void setDeviceLostUserdata(jnr.ffi.Pointer x){
        this.deviceLostUserdata.set(x);
    }

    public WGPUDeviceLostCallbackInfo getDeviceLostCallbackInfo(){
        return deviceLostCallbackInfo;
    }

    public WGPUUncapturedErrorCallbackInfo getUncapturedErrorCallbackInfo(){
        return uncapturedErrorCallbackInfo;
    }

}