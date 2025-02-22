package com.monstrous.webgpu;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Pointer;
import jnr.ffi.Runtime;

public interface WebGPU { // A representation of the C interface in Java

    final static long WGPU_DEPTH_SLICE_UNDEFINED = -1L;

    Pointer gdx2d_load (Pointer buffer, int len);
    void gdx2d_free(Pointer pixmapInfo);

    Pointer glfwGetWGPUSurface(Pointer instance, long HWND);


    Pointer CreateInstance();
    void InstanceRelease(Pointer instance);

    Pointer RequestAdapterSync(Pointer instance, WGPURequestAdapterOptions options);


    void AdapterRelease(Pointer adapter);
    boolean    AdapterGetLimits(Pointer adapter, WGPUSupportedLimits limits);
    void AdapterGetProperties(Pointer adapter, WGPUAdapterProperties properties);

    Pointer RequestDeviceSync(Pointer adapter, WGPUDeviceDescriptor descriptor);
    void DeviceRelease(Pointer device);
    void DeviceTick(Pointer device);    // DAWN
    //WGPUStatus DeviceGetFeatures(Pointer device, WGPUSupportedFeatures features);
    boolean DeviceGetLimits(Pointer device, WGPUSupportedLimits limits);
    void DeviceSetUncapturedErrorCallback(Pointer device, WGPUErrorCallback callback, Pointer userdata);

    Pointer DeviceGetQueue(Pointer device);
    void QueueRelease(Pointer queue);
    void QueueSubmit(Pointer queue, int count, Pointer commandBuffer);       // array of command buffer
    void QueueOnSubmittedWorkDone(Pointer queue, WGPUQueueWorkDoneCallback callback, Pointer userdata);

    Pointer DeviceCreateCommandEncoder(Pointer device, WGPUCommandEncoderDescriptor encoderDesc);
    void CommandEncoderRelease(Pointer commandEncoder);
    Pointer CommandEncoderFinish(Pointer encoder, WGPUCommandBufferDescriptor cmdBufferDescriptor);
    void CommandEncoderInsertDebugMarker(Pointer encoder, String marker);
    Pointer CommandEncoderBeginRenderPass(Pointer encoder, WGPURenderPassDescriptor renderPassDescriptor);

    void RenderPassEncoderEnd(Pointer renderPass);
    void RenderPassEncoderRelease(Pointer renderPass);
    void RenderPassEncoderSetPipeline(Pointer renderPass, Pointer pipeline);
    void RenderPassEncoderDraw(Pointer renderPass, int numVertices, int numInstances, int firstVertex, int firstInstance);
    void RenderPassEncoderSetVertexBuffer(Pointer renderPass, int slot, Pointer vertexBuffer, long offset, long size);
    void RenderPassEncoderSetIndexBuffer(Pointer renderPass, Pointer indexBuffer, WGPUIndexFormat wgpuIndexFormat, int offset, long size);
    void RenderPassEncoderDrawIndexed(Pointer renderPass, int indexCount, int numInstances, int firstIndex, int baseVertex, int firstInstance);
    void RenderPassEncoderSetScissorRect(Pointer renderPass, int x, int y, int width, int height);
    void RenderPassEncoderSetViewport(Pointer renderPass, float x, float y, float width, float height, float minDepth, float maxDepth);
    void RenderPassEncoderSetBindGroup(Pointer renderPass, int groupIndex, Pointer bindGroup, int dynamicOffsetCount, Pointer dynamicOffsets);


    void CommandBufferRelease(Pointer commandBuffer);


    void SurfaceRelease(Pointer surface);
    void SurfaceConfigure(Pointer surface, WGPUSurfaceConfiguration config);
    void SurfaceUnconfigure(Pointer surface);
    void SurfacePresent(Pointer surface);
    WGPUTextureFormat SurfaceGetPreferredFormat(Pointer surface, Pointer adapter);
    int SurfaceGetCapabilities(Pointer surface, Pointer adapter, WGPUSurfaceCapabilities caps);

    void SurfaceGetCurrentTexture(Pointer surface, WGPUSurfaceTexture texture);



    Pointer DeviceCreateRenderPipeline(Pointer device, WGPURenderPipelineDescriptor pipelineDesc);
    void RenderPipelineRelease(Pointer pipeline);

    Pointer DeviceCreateShaderModule(Pointer device, WGPUShaderModuleDescriptor shaderDesc);
    void ShaderModuleRelease(Pointer shaderModule);

    Pointer DeviceCreateBuffer(Pointer device, WGPUBufferDescriptor bufferDesc);
    void BufferRelease(Pointer buffer);
    void BufferDestroy(Pointer buffer);
    void BufferUnmap(Pointer buffer1);
    long BufferGetSize(Pointer vertexBuffer);

    void QueueWriteBuffer(Pointer queue, Pointer buffer, int dynamicOffset, Pointer data, int length);

    void CommandEncoderCopyBufferToBuffer(Pointer encoder, Pointer buffer1, int i, Pointer buffer2, int i1, int i2);
    void BufferMapAsync(Pointer buffer2, WGPUMapMode wgpuMapMode, int offset, int size, WGPUBufferMapCallback onBuffer2Mapped, Pointer userData);

    Pointer BufferGetConstMappedRange(Pointer buffer1, int offset, int size);       // todo use long for size_t?


    Pointer DeviceCreateBindGroup(Pointer device, WGPUBindGroupDescriptor bindGroupDesc);
    void BindGroupRelease(Pointer bindGroup);

    Pointer DeviceCreateBindGroupLayout(Pointer device, WGPUBindGroupLayoutDescriptor bindGroupLayoutDesc);
    void BindGroupLayoutRelease(Pointer bindGroupLayout);

    Pointer DeviceCreatePipelineLayout(Pointer device, WGPUPipelineLayoutDescriptor layoutDesc);
    void PipelineLayoutRelease(Pointer layout);


    Pointer DeviceCreateTexture(Pointer device, WGPUTextureDescriptor depthTextureDesc);
    void TextureDestroy(Pointer depthTexture);
    void TextureRelease(Pointer depthTexture);
    WGPUTextureFormat TextureGetFormat(Pointer Texture);

    Pointer TextureCreateView(Pointer Texture, WGPUTextureViewDescriptor viewDescriptor);
    void TextureViewRelease(Pointer view);

    void QueueWriteTexture(Pointer queue, WGPUImageCopyTexture destination, Pointer pixelPtr, int i, WGPUTextureDataLayout source, WGPUExtent3D size);

    Pointer DeviceCreateSampler(Pointer device, WGPUSamplerDescriptor samplerDesc);

    Pointer CreateQuerySet(Pointer device, WGPUQuerySetDescriptor queryDesc);

    void CommandEncoderResolveQuerySet(Pointer commandEncoder, Pointer querySet, int firstQuery, int queryCount, Pointer destination, long destinationOffset);

}