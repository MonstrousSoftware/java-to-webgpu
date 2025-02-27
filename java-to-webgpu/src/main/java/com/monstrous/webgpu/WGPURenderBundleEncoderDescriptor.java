package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import org.jetbrains.annotations.Nullable;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPURenderBundleEncoderDescriptor extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final @Nullable @CStrPointer Struct.Pointer label = new Struct.Pointer();
    private final Struct.size_t colorFormatCount = new Struct.size_t();
    private final Struct.Pointer colorFormats = new Struct.Pointer();
    private final Struct.Enum<WGPUTextureFormat> depthStencilFormat = new Struct.Enum<>(WGPUTextureFormat.class);
    private final Struct.Unsigned32 sampleCount = new Struct.Unsigned32();
    private final Struct.Unsigned32 depthReadOnly = new Struct.Unsigned32();
    private final Struct.Unsigned32 stencilReadOnly = new Struct.Unsigned32();

    private WGPURenderBundleEncoderDescriptor(){}

    @Deprecated
    public WGPURenderBundleEncoderDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPURenderBundleEncoderDescriptor createHeap(){
        return new WGPURenderBundleEncoderDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPURenderBundleEncoderDescriptor createDirect(){
        WGPURenderBundleEncoderDescriptor struct = new WGPURenderBundleEncoderDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStruct> getNextInChain(){
        return nextInChain;
    }

    public WGPURenderBundleEncoderDescriptor setNextInChain(WGPUChainedStruct... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
        return this;
    }

    public java.lang.String getLabel(){
        return RustCString.fromPointer(label.get());
    }

    public WGPURenderBundleEncoderDescriptor setLabel(java.lang.String str){
        this.label.set(RustCString.toPointer(str)); return this;
    }

    public long getColorFormatCount(){
        return colorFormatCount.get();
    }

    public WGPURenderBundleEncoderDescriptor setColorFormatCount(long val){
        this.colorFormatCount.set(val); return this;
    }

    public jnr.ffi.Pointer getColorFormats(){
        return colorFormats.get();
    }

    public WGPURenderBundleEncoderDescriptor setColorFormats(jnr.ffi.Pointer val){
        this.colorFormats.set(val); return this;
    }

    public WGPUTextureFormat getDepthStencilFormat(){
        return depthStencilFormat.get();
    }

    public WGPURenderBundleEncoderDescriptor setDepthStencilFormat(WGPUTextureFormat val){
        this.depthStencilFormat.set(val); return this;
    }

    public long getSampleCount(){
        return sampleCount.get();
    }

    public WGPURenderBundleEncoderDescriptor setSampleCount(long val){
        this.sampleCount.set(val); return this;
    }

    public long getDepthReadOnly(){
        return depthReadOnly.get();
    }

    public WGPURenderBundleEncoderDescriptor setDepthReadOnly(long val){
        this.depthReadOnly.set(val); return this;
    }

    public long getStencilReadOnly(){
        return stencilReadOnly.get();
    }

    public WGPURenderBundleEncoderDescriptor setStencilReadOnly(long val){
        this.stencilReadOnly.set(val); return this;
    }

}