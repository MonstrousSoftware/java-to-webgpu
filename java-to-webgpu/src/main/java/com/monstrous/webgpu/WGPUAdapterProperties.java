package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUAdapterProperties extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStructOut> nextInChain = new DynamicStructRef<>(WGPUChainedStructOut.class);
    private final Struct.Unsigned32 vendorID = new Struct.Unsigned32();
    private final @CStrPointer Struct.Pointer vendorName = new Struct.Pointer();
    private final @CStrPointer Struct.Pointer architecture = new Struct.Pointer();
    private final Struct.Unsigned32 deviceID = new Struct.Unsigned32();
    private final @CStrPointer Struct.Pointer name = new Struct.Pointer();
    private final @CStrPointer Struct.Pointer driverDescription = new Struct.Pointer();
    private final Struct.Enum<WGPUAdapterType> adapterType = new Struct.Enum<>(WGPUAdapterType.class);
    private final Struct.Enum<WGPUBackendType> backendType = new Struct.Enum<>(WGPUBackendType.class);
    private final Struct.Unsigned32 compatibilityMode = new Struct.Unsigned32();

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
        WGPUAdapterProperties struct = new WGPUAdapterProperties();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStructOut> getNextInChain(){
        return nextInChain;
    }

    public WGPUAdapterProperties setNextInChain(WGPUChainedStructOut... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
        return this;
    }

    public long getVendorID(){
        return vendorID.get();
    }

    public WGPUAdapterProperties setVendorID(long val){
        this.vendorID.set(val); return this;
    }

    public java.lang.String getVendorName(){
        return RustCString.fromPointer(vendorName.get());
    }

    public WGPUAdapterProperties setVendorName(java.lang.String str){
        this.vendorName.set(RustCString.toPointer(str)); return this;
    }

    public java.lang.String getArchitecture(){
        return RustCString.fromPointer(architecture.get());
    }

    public WGPUAdapterProperties setArchitecture(java.lang.String str){
        this.architecture.set(RustCString.toPointer(str)); return this;
    }

    public long getDeviceID(){
        return deviceID.get();
    }

    public WGPUAdapterProperties setDeviceID(long val){
        this.deviceID.set(val); return this;
    }

    public java.lang.String getName(){
        return RustCString.fromPointer(name.get());
    }

    public WGPUAdapterProperties setName(java.lang.String str){
        this.name.set(RustCString.toPointer(str)); return this;
    }

    public java.lang.String getDriverDescription(){
        return RustCString.fromPointer(driverDescription.get());
    }

    public WGPUAdapterProperties setDriverDescription(java.lang.String str){
        this.driverDescription.set(RustCString.toPointer(str)); return this;
    }

    public WGPUAdapterType getAdapterType(){
        return adapterType.get();
    }

    public WGPUAdapterProperties setAdapterType(WGPUAdapterType val){
        this.adapterType.set(val); return this;
    }

    public WGPUBackendType getBackendType(){
        return backendType.get();
    }

    public WGPUAdapterProperties setBackendType(WGPUBackendType val){
        this.backendType.set(val); return this;
    }

    public long getCompatibilityMode(){
        return compatibilityMode.get();
    }

    public WGPUAdapterProperties setCompatibilityMode(long val){
        this.compatibilityMode.set(val); return this;
    }

}