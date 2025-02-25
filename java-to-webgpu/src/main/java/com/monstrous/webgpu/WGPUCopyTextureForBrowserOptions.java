package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJava;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUCopyTextureForBrowserOptions extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Unsigned32 flipY = new Unsigned32();
    private final Unsigned32 needsColorSpaceConversion = new Unsigned32();
    private final Enum<WGPUAlphaMode> srcAlphaMode = new Enum<>(WGPUAlphaMode.class);
    private final Pointer srcTransferFunctionParameters = new Pointer();
    private final Pointer conversionMatrix = new Pointer();
    private final Pointer dstTransferFunctionParameters = new Pointer();
    private final Enum<WGPUAlphaMode> dstAlphaMode = new Enum<>(WGPUAlphaMode.class);
    private final Unsigned32 internalUsage = new Unsigned32();

    private WGPUCopyTextureForBrowserOptions(){}

    @Deprecated
    public WGPUCopyTextureForBrowserOptions(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUCopyTextureForBrowserOptions createHeap(){
        return new WGPUCopyTextureForBrowserOptions();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUCopyTextureForBrowserOptions createDirect(){
        var struct = new WGPUCopyTextureForBrowserOptions();
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

    public long getFlipY(){
        return flipY.get();
    }

    public void setFlipY(long x){
        this.flipY.set(x);
    }

    public long getNeedsColorSpaceConversion(){
        return needsColorSpaceConversion.get();
    }

    public void setNeedsColorSpaceConversion(long x){
        this.needsColorSpaceConversion.set(x);
    }

    public WGPUAlphaMode getSrcAlphaMode(){
        return srcAlphaMode.get();
    }

    public void setSrcAlphaMode(WGPUAlphaMode x){
        this.srcAlphaMode.set(x);
    }

    public jnr.ffi.Pointer getSrcTransferFunctionParameters(){
        return srcTransferFunctionParameters.get();
    }

    public void setSrcTransferFunctionParameters(jnr.ffi.Pointer x){
        this.srcTransferFunctionParameters.set(x);
    }

    public jnr.ffi.Pointer getConversionMatrix(){
        return conversionMatrix.get();
    }

    public void setConversionMatrix(jnr.ffi.Pointer x){
        this.conversionMatrix.set(x);
    }

    public jnr.ffi.Pointer getDstTransferFunctionParameters(){
        return dstTransferFunctionParameters.get();
    }

    public void setDstTransferFunctionParameters(jnr.ffi.Pointer x){
        this.dstTransferFunctionParameters.set(x);
    }

    public WGPUAlphaMode getDstAlphaMode(){
        return dstAlphaMode.get();
    }

    public void setDstAlphaMode(WGPUAlphaMode x){
        this.dstAlphaMode.set(x);
    }

    public long getInternalUsage(){
        return internalUsage.get();
    }

    public void setInternalUsage(long x){
        this.internalUsage.set(x);
    }

}