package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.CStrPointer;
import com.monstrous.wgpuUtils.RustCString;
import com.monstrous.wgpuUtils.WgpuJava;
import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUAdapterProperties extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStructOut> nextInChain = new DynamicStructRef<>(WGPUChainedStructOut.class);
    private final Unsigned32 vendorID = new Unsigned32();
    private final @CStrPointer Pointer vendorName = new Pointer();
    private final @CStrPointer Pointer architecture = new Pointer();
    private final Unsigned32 deviceID = new Unsigned32();
    private final @CStrPointer Pointer name = new Pointer();
    private final @CStrPointer Pointer driverDescription = new Pointer();
    private final Enum<WGPUAdapterType> adapterType = new Enum<>(WGPUAdapterType.class);
    private final Enum<WGPUBackendType> backendType = new Enum<>(WGPUBackendType.class);
    private final Unsigned32 compatibilityMode = new Unsigned32();

    private WGPUAdapterProperties(){}

    @Deprecated
    public WGPUAdapterProperties(Runtime runtime){
        super(runtime);
    }

    /**
     * Creates this struct on the java heap.
     * In general, this should <b>not</b> be used because these structs
     * cannot be directly passed into native code.
     */
    public static WGPUAdapterProperties createHeap(){
        return new WGPUAdapterProperties();
    }

    /**
     * Creates this struct in direct memory.
     * This is how most structs should be created (unless, they
     * are members of a nothing struct)
     *
     * @see WgpuJavaStruct#useDirectMemory
     */
    public static WGPUAdapterProperties createDirect(){
        var struct = new WGPUAdapterProperties();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStructOut> getNextInChain(){
        return nextInChain;
    }

    public void setNextInChain(WGPUChainedStructOut... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(WgpuJava.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
    }

    public long getVendorID(){
        return vendorID.get();
    }

    public void setVendorID(long x){
        this.vendorID.set(x);
    }

    public java.lang.String getVendorName(){
        return RustCString.fromPointer(vendorName.get());
    }

    public void setVendorName(java.lang.String x){
        this.vendorName.set(RustCString.toPointer(x));
    }

    public java.lang.String getArchitecture(){
        return RustCString.fromPointer(architecture.get());
    }

    public void setArchitecture(java.lang.String x){
        this.architecture.set(RustCString.toPointer(x));
    }

    public long getDeviceID(){
        return deviceID.get();
    }

    public void setDeviceID(long x){
        this.deviceID.set(x);
    }

    public java.lang.String getName(){
        return RustCString.fromPointer(name.get());
    }

    public void setName(java.lang.String x){
        this.name.set(RustCString.toPointer(x));
    }

    public java.lang.String getDriverDescription(){
        return RustCString.fromPointer(driverDescription.get());
    }

    public void setDriverDescription(java.lang.String x){
        this.driverDescription.set(RustCString.toPointer(x));
    }

    public WGPUAdapterType getAdapterType(){
        return adapterType.get();
    }

    public void setAdapterType(WGPUAdapterType x){
        this.adapterType.set(x);
    }

    public WGPUBackendType getBackendType(){
        return backendType.get();
    }

    public void setBackendType(WGPUBackendType x){
        this.backendType.set(x);
    }

    public long getCompatibilityMode(){
        return compatibilityMode.get();
    }

    public void setCompatibilityMode(long x){
        this.compatibilityMode.set(x);
    }

}