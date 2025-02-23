package com.monstrous.webgpu;

import jnr.ffi.Pointer;

public interface WebGPU { // A representation of the C interface in Java


    Pointer wgpuCreateInstance();
    void wgpuInstanceRelease(Pointer instance);

    //Pointer wgpuRequestAdapterSync(Pointer instance, WGPURequestAdapterOptions options);
    //Pointer wgpuRequestDeviceSync(Pointer adapter, WGPUDeviceDescriptor descriptor);


    void wgpuAdapterRelease(Pointer adapter);
    boolean    wgpuAdapterGetLimits(Pointer adapter, WGPUSupportedLimits limits);
    void wgpuAdapterGetProperties(Pointer adapter, WGPUAdapterProperties properties);


    void wgpuDeviceRelease(Pointer device);
    void wgpuDeviceTick(Pointer device);    // DAWN
    //WGPUStatus wgpuDeviceGetFeatures(Pointer device, WGPUSupportedFeatures features);
    boolean wgpuDeviceGetLimits(Pointer device, WGPUSupportedLimits limits);
    void wgpuDeviceSetUncapturedErrorCallback(Pointer device, WGPUErrorCallback callback, Pointer userdata);

    Pointer wgpuDeviceGetQueue(Pointer device);
    void wgpuQueueRelease(Pointer queue);
    void wgpuQueueSubmit(Pointer queue, int count, Pointer commandBuffer);       // array of command buffer
    void wgpuQueueOnSubmittedWorkDone(Pointer queue, WGPUQueueWorkDoneCallback callback, Pointer userdata);

    Pointer wgpuDeviceCreateCommandEncoder(Pointer device, WGPUCommandEncoderDescriptor encoderDesc);
    void wgpuCommandEncoderRelease(Pointer commandEncoder);
    Pointer wgpuCommandEncoderFinish(Pointer encoder, WGPUCommandBufferDescriptor cmdBufferDescriptor);
    void wgpuCommandEncoderInsertDebugMarker(Pointer encoder, String marker);
    Pointer wgpuCommandEncoderBeginRenderPass(Pointer encoder, WGPURenderPassDescriptor renderPassDescriptor);

    void wgpuRenderPassEncoderEnd(Pointer renderPass);
    void wgpuRenderPassEncoderRelease(Pointer renderPass);
    void wgpuRenderPassEncoderSetPipeline(Pointer renderPass, Pointer pipeline);
    void wgpuRenderPassEncoderDraw(Pointer renderPass, int numVertices, int numInstances, int firstVertex, int firstInstance);
    void wgpuRenderPassEncoderSetVertexBuffer(Pointer renderPass, int slot, Pointer vertexBuffer, long offset, long size);
    void wgpuRenderPassEncoderSetIndexBuffer(Pointer renderPass, Pointer indexBuffer, WGPUIndexFormat wgpuIndexFormat, int offset, long size);
    void wgpuRenderPassEncoderDrawIndexed(Pointer renderPass, int indexCount, int numInstances, int firstIndex, int baseVertex, int firstInstance);
    void wgpuRenderPassEncoderSetScissorRect(Pointer renderPass, int x, int y, int width, int height);
    void wgpuRenderPassEncoderSetViewport(Pointer renderPass, float x, float y, float width, float height, float minDepth, float maxDepth);
    void wgpuRenderPassEncoderSetBindGroup(Pointer renderPass, int groupIndex, Pointer bindGroup, int dynamicOffsetCount, Pointer dynamicOffsets);


    void wgpuCommandBufferRelease(Pointer commandBuffer);


    void wgpuSurfaceRelease(Pointer surface);
    void wgpuSurfaceConfigure(Pointer surface, WGPUSurfaceConfiguration config);
    void wgpuSurfaceUnconfigure(Pointer surface);
    void wgpuSurfacePresent(Pointer surface);
    WGPUTextureFormat wgpuSurfaceGetPreferredFormat(Pointer surface, Pointer adapter);
    int wgpuSurfaceGetCapabilities(Pointer surface, Pointer adapter, WGPUSurfaceCapabilities caps);

    void wgpuSurfaceGetCurrentTexture(Pointer surface, WGPUSurfaceTexture texture);



    Pointer wgpuDeviceCreateRenderPipeline(Pointer device, WGPURenderPipelineDescriptor pipelineDesc);
    void wgpuRenderPipelineRelease(Pointer pipeline);

    Pointer wgpuDeviceCreateShaderModule(Pointer device, WGPUShaderModuleDescriptor shaderDesc);
    void wgpuShaderModuleRelease(Pointer shaderModule);

    Pointer wgpuDeviceCreateBuffer(Pointer device, WGPUBufferDescriptor bufferDesc);
    void wgpuBufferRelease(Pointer buffer);
    void wgpuBufferDestroy(Pointer buffer);
    void wgpuBufferUnmap(Pointer buffer1);
    long wgpuBufferGetSize(Pointer vertexBuffer);

    void wgpuQueueWriteBuffer(Pointer queue, Pointer buffer, int dynamicOffset, Pointer data, int length);

    void wgpuCommandEncoderCopyBufferToBuffer(Pointer encoder, Pointer buffer1, int i, Pointer buffer2, int i1, int i2);
    void wgpuBufferMapAsync(Pointer buffer2, WGPUMapMode wgpuMapMode, int offset, int size, WGPUBufferMapCallback onBuffer2Mapped, Pointer userData);

    Pointer wgpuBufferGetConstMappedRange(Pointer buffer1, int offset, int size);       // todo use long for size_t?


    Pointer wgpuDeviceCreateBindGroup(Pointer device, WGPUBindGroupDescriptor bindGroupDesc);
    void wgpuBindGroupRelease(Pointer bindGroup);

    Pointer wgpuDeviceCreateBindGroupLayout(Pointer device, WGPUBindGroupLayoutDescriptor bindGroupLayoutDesc);
    void wgpuBindGroupLayoutRelease(Pointer bindGroupLayout);

    Pointer wgpuDeviceCreatePipelineLayout(Pointer device, WGPUPipelineLayoutDescriptor layoutDesc);
    void wgpuPipelineLayoutRelease(Pointer layout);


    Pointer wgpuDeviceCreateTexture(Pointer device, WGPUTextureDescriptor depthTextureDesc);
    void wgpuTextureDestroy(Pointer depthTexture);
    void wgpuTextureRelease(Pointer depthTexture);
    WGPUTextureFormat wgpuTextureGetFormat(Pointer Texture);

    Pointer wgpuTextureCreateView(Pointer Texture, WGPUTextureViewDescriptor viewDescriptor);
    void wgpuTextureViewRelease(Pointer view);

    void wgpuQueueWriteTexture(Pointer queue, WGPUImageCopyTexture destination, Pointer pixelPtr, int i, WGPUTextureDataLayout source, WGPUExtent3D size);

    Pointer wgpuDeviceCreateSampler(Pointer device, WGPUSamplerDescriptor samplerDesc);

    Pointer wgpuCreateQuerySet(Pointer device, WGPUQuerySetDescriptor queryDesc);

    void wgpuCommandEncoderResolveQuerySet(Pointer commandEncoder, Pointer querySet, int firstQuery, int queryCount, Pointer destination, long destinationOffset);

}