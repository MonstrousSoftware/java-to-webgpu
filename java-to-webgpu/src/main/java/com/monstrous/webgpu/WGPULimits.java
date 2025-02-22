package com.monstrous.webgpu;

import com.monstrous.wgpuUtils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPULimits extends WgpuJavaStruct {

    private final Unsigned32 maxTextureDimension1D = new Unsigned32();
    private final Unsigned32 maxTextureDimension2D = new Unsigned32();
    private final Unsigned32 maxTextureDimension3D = new Unsigned32();
    private final Unsigned32 maxTextureArrayLayers = new Unsigned32();
    private final Unsigned32 maxBindGroups = new Unsigned32();
    private final Unsigned32 maxBindGroupsPlusVertexBuffers = new Unsigned32();
    private final Unsigned32 maxBindingsPerBindGroup = new Unsigned32();
    private final Unsigned32 maxDynamicUniformBuffersPerPipelineLayout = new Unsigned32();
    private final Unsigned32 maxDynamicStorageBuffersPerPipelineLayout = new Unsigned32();
    private final Unsigned32 maxSampledTexturesPerShaderStage = new Unsigned32();
    private final Unsigned32 maxSamplersPerShaderStage = new Unsigned32();
    private final Unsigned32 maxStorageBuffersPerShaderStage = new Unsigned32();
    private final Unsigned32 maxStorageTexturesPerShaderStage = new Unsigned32();
    private final Unsigned32 maxUniformBuffersPerShaderStage = new Unsigned32();
    private final Unsigned64 maxUniformBufferBindingSize = new Unsigned64();
    private final Unsigned64 maxStorageBufferBindingSize = new Unsigned64();
    private final Unsigned32 minUniformBufferOffsetAlignment = new Unsigned32();
    private final Unsigned32 minStorageBufferOffsetAlignment = new Unsigned32();
    private final Unsigned32 maxVertexBuffers = new Unsigned32();
    private final Unsigned64 maxBufferSize = new Unsigned64();
    private final Unsigned32 maxVertexAttributes = new Unsigned32();
    private final Unsigned32 maxVertexBufferArrayStride = new Unsigned32();
    private final Unsigned32 maxInterStageShaderComponents = new Unsigned32();
    private final Unsigned32 maxInterStageShaderVariables = new Unsigned32();
    private final Unsigned32 maxColorAttachments = new Unsigned32();
    private final Unsigned32 maxColorAttachmentBytesPerSample = new Unsigned32();
    private final Unsigned32 maxComputeWorkgroupStorageSize = new Unsigned32();
    private final Unsigned32 maxComputeInvocationsPerWorkgroup = new Unsigned32();
    private final Unsigned32 maxComputeWorkgroupSizeX = new Unsigned32();
    private final Unsigned32 maxComputeWorkgroupSizeY = new Unsigned32();
    private final Unsigned32 maxComputeWorkgroupSizeZ = new Unsigned32();
    private final Unsigned32 maxComputeWorkgroupsPerDimension = new Unsigned32();

    private WGPULimits(){}

    @Deprecated
    public WGPULimits(Runtime runtime){
        super(runtime);
    }

    /**
     * Creates this struct on the java heap.
     * In general, this should <b>not</b> be used because these structs
     * cannot be directly passed into native code.
     */
    public static WGPULimits createHeap(){
        return new WGPULimits();
    }

    /**
     * Creates this struct in direct memory.
     * This is how most structs should be created (unless, they
     * are members of a nothing struct)
     *
     * @see WgpuJavaStruct#useDirectMemory
     */
    public static WGPULimits createDirect(){
        var struct = new WGPULimits();
        struct.useDirectMemory();
        return struct;
    }


    public long getMaxTextureDimension1D(){
        return maxTextureDimension1D.get();
    }

    public void setMaxTextureDimension1D(long x){
        this.maxTextureDimension1D.set(x);
    }

    public long getMaxTextureDimension2D(){
        return maxTextureDimension2D.get();
    }

    public void setMaxTextureDimension2D(long x){
        this.maxTextureDimension2D.set(x);
    }

    public long getMaxTextureDimension3D(){
        return maxTextureDimension3D.get();
    }

    public void setMaxTextureDimension3D(long x){
        this.maxTextureDimension3D.set(x);
    }

    public long getMaxTextureArrayLayers(){
        return maxTextureArrayLayers.get();
    }

    public void setMaxTextureArrayLayers(long x){
        this.maxTextureArrayLayers.set(x);
    }

    public long getMaxBindGroups(){
        return maxBindGroups.get();
    }

    public void setMaxBindGroups(long x){
        this.maxBindGroups.set(x);
    }

    public long getMaxBindGroupsPlusVertexBuffers(){
        return maxBindGroupsPlusVertexBuffers.get();
    }

    public void setMaxBindGroupsPlusVertexBuffers(long x){
        this.maxBindGroupsPlusVertexBuffers.set(x);
    }

    public long getMaxBindingsPerBindGroup(){
        return maxBindingsPerBindGroup.get();
    }

    public void setMaxBindingsPerBindGroup(long x){
        this.maxBindingsPerBindGroup.set(x);
    }

    public long getMaxDynamicUniformBuffersPerPipelineLayout(){
        return maxDynamicUniformBuffersPerPipelineLayout.get();
    }

    public void setMaxDynamicUniformBuffersPerPipelineLayout(long x){
        this.maxDynamicUniformBuffersPerPipelineLayout.set(x);
    }

    public long getMaxDynamicStorageBuffersPerPipelineLayout(){
        return maxDynamicStorageBuffersPerPipelineLayout.get();
    }

    public void setMaxDynamicStorageBuffersPerPipelineLayout(long x){
        this.maxDynamicStorageBuffersPerPipelineLayout.set(x);
    }

    public long getMaxSampledTexturesPerShaderStage(){
        return maxSampledTexturesPerShaderStage.get();
    }

    public void setMaxSampledTexturesPerShaderStage(long x){
        this.maxSampledTexturesPerShaderStage.set(x);
    }

    public long getMaxSamplersPerShaderStage(){
        return maxSamplersPerShaderStage.get();
    }

    public void setMaxSamplersPerShaderStage(long x){
        this.maxSamplersPerShaderStage.set(x);
    }

    public long getMaxStorageBuffersPerShaderStage(){
        return maxStorageBuffersPerShaderStage.get();
    }

    public void setMaxStorageBuffersPerShaderStage(long x){
        this.maxStorageBuffersPerShaderStage.set(x);
    }

    public long getMaxStorageTexturesPerShaderStage(){
        return maxStorageTexturesPerShaderStage.get();
    }

    public void setMaxStorageTexturesPerShaderStage(long x){
        this.maxStorageTexturesPerShaderStage.set(x);
    }

    public long getMaxUniformBuffersPerShaderStage(){
        return maxUniformBuffersPerShaderStage.get();
    }

    public void setMaxUniformBuffersPerShaderStage(long x){
        this.maxUniformBuffersPerShaderStage.set(x);
    }

    public long getMaxUniformBufferBindingSize(){
        return maxUniformBufferBindingSize.get();
    }

    public void setMaxUniformBufferBindingSize(long x){
        this.maxUniformBufferBindingSize.set(x);
    }

    public long getMaxStorageBufferBindingSize(){
        return maxStorageBufferBindingSize.get();
    }

    public void setMaxStorageBufferBindingSize(long x){
        this.maxStorageBufferBindingSize.set(x);
    }

    public long getMinUniformBufferOffsetAlignment(){
        return minUniformBufferOffsetAlignment.get();
    }

    public void setMinUniformBufferOffsetAlignment(long x){
        this.minUniformBufferOffsetAlignment.set(x);
    }

    public long getMinStorageBufferOffsetAlignment(){
        return minStorageBufferOffsetAlignment.get();
    }

    public void setMinStorageBufferOffsetAlignment(long x){
        this.minStorageBufferOffsetAlignment.set(x);
    }

    public long getMaxVertexBuffers(){
        return maxVertexBuffers.get();
    }

    public void setMaxVertexBuffers(long x){
        this.maxVertexBuffers.set(x);
    }

    public long getMaxBufferSize(){
        return maxBufferSize.get();
    }

    public void setMaxBufferSize(long x){
        this.maxBufferSize.set(x);
    }

    public long getMaxVertexAttributes(){
        return maxVertexAttributes.get();
    }

    public void setMaxVertexAttributes(long x){
        this.maxVertexAttributes.set(x);
    }

    public long getMaxVertexBufferArrayStride(){
        return maxVertexBufferArrayStride.get();
    }

    public void setMaxVertexBufferArrayStride(long x){
        this.maxVertexBufferArrayStride.set(x);
    }

    public long getMaxInterStageShaderComponents(){
        return maxInterStageShaderComponents.get();
    }

    public void setMaxInterStageShaderComponents(long x){
        this.maxInterStageShaderComponents.set(x);
    }

    public long getMaxInterStageShaderVariables(){
        return maxInterStageShaderVariables.get();
    }

    public void setMaxInterStageShaderVariables(long x){
        this.maxInterStageShaderVariables.set(x);
    }

    public long getMaxColorAttachments(){
        return maxColorAttachments.get();
    }

    public void setMaxColorAttachments(long x){
        this.maxColorAttachments.set(x);
    }

    public long getMaxColorAttachmentBytesPerSample(){
        return maxColorAttachmentBytesPerSample.get();
    }

    public void setMaxColorAttachmentBytesPerSample(long x){
        this.maxColorAttachmentBytesPerSample.set(x);
    }

    public long getMaxComputeWorkgroupStorageSize(){
        return maxComputeWorkgroupStorageSize.get();
    }

    public void setMaxComputeWorkgroupStorageSize(long x){
        this.maxComputeWorkgroupStorageSize.set(x);
    }

    public long getMaxComputeInvocationsPerWorkgroup(){
        return maxComputeInvocationsPerWorkgroup.get();
    }

    public void setMaxComputeInvocationsPerWorkgroup(long x){
        this.maxComputeInvocationsPerWorkgroup.set(x);
    }

    public long getMaxComputeWorkgroupSizeX(){
        return maxComputeWorkgroupSizeX.get();
    }

    public void setMaxComputeWorkgroupSizeX(long x){
        this.maxComputeWorkgroupSizeX.set(x);
    }

    public long getMaxComputeWorkgroupSizeY(){
        return maxComputeWorkgroupSizeY.get();
    }

    public void setMaxComputeWorkgroupSizeY(long x){
        this.maxComputeWorkgroupSizeY.set(x);
    }

    public long getMaxComputeWorkgroupSizeZ(){
        return maxComputeWorkgroupSizeZ.get();
    }

    public void setMaxComputeWorkgroupSizeZ(long x){
        this.maxComputeWorkgroupSizeZ.set(x);
    }

    public long getMaxComputeWorkgroupsPerDimension(){
        return maxComputeWorkgroupsPerDimension.get();
    }

    public void setMaxComputeWorkgroupsPerDimension(long x){
        this.maxComputeWorkgroupsPerDimension.set(x);
    }

}