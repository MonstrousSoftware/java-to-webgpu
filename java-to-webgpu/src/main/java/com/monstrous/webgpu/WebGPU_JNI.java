package com.monstrous.webgpu;


/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
import jnr.ffi.Pointer;
import jnr.ffi.types.u_int64_t;
import jnr.ffi.types.u_int32_t;
import jnr.ffi.types.size_t;
import org.jetbrains.annotations.Nullable;

public interface WebGPU_JNI {



// functions

	// Procs of TextureView
	void	wgpuAdapterInfoFreeMembers (WGPUAdapterInfo value);
	void	wgpuAdapterPropertiesFreeMembers (WGPUAdapterProperties value);
	void	wgpuAdapterPropertiesMemoryHeapsFreeMembers (WGPUAdapterPropertiesMemoryHeaps value);
	Pointer	wgpuCreateInstance (@Nullable WGPUInstanceDescriptor descriptor);
	void	wgpuDrmFormatCapabilitiesFreeMembers (WGPUDrmFormatCapabilities value);
	WGPUStatus	wgpuGetInstanceFeatures (WGPUInstanceFeatures features);

	//  WGPU_EXPORT WGPUProc wgpuGetProcAddress(WGPU_NULLABLE WGPUDevice device, char const * procName) WGPU_FUNCTION_ATTRIBUTE;
	void	wgpuSharedBufferMemoryEndAccessStateFreeMembers (WGPUSharedBufferMemoryEndAccessState value);
	void	wgpuSharedTextureMemoryEndAccessStateFreeMembers (WGPUSharedTextureMemoryEndAccessState value);
	void	wgpuSurfaceCapabilitiesFreeMembers (WGPUSurfaceCapabilities value);

	// Methods of Adapter
	Pointer	wgpuAdapterCreateDevice (Pointer adapter, @Nullable WGPUDeviceDescriptor descriptor);
	long	wgpuAdapterEnumerateFeatures (Pointer adapter, Pointer features);
	WGPUStatus	wgpuAdapterGetFormatCapabilities (Pointer adapter, WGPUTextureFormat format, WGPUFormatCapabilities capabilities);
	WGPUStatus	wgpuAdapterGetInfo (Pointer adapter, WGPUAdapterInfo info);
	Pointer	wgpuAdapterGetInstance (Pointer adapter);
	WGPUStatus	wgpuAdapterGetLimits (Pointer adapter, WGPUSupportedLimits limits);
	WGPUStatus	wgpuAdapterGetProperties (Pointer adapter, WGPUAdapterProperties properties);
	boolean	wgpuAdapterHasFeature (Pointer adapter, int feature);
	void	wgpuAdapterRequestDevice (Pointer adapter, @Nullable WGPUDeviceDescriptor descriptor, WGPURequestDeviceCallback callback, Pointer userdata);
	WGPUFuture	wgpuAdapterRequestDevice2 (Pointer adapter, @Nullable WGPUDeviceDescriptor options, WGPURequestDeviceCallbackInfo2 callbackInfo);
	WGPUFuture	wgpuAdapterRequestDeviceF (Pointer adapter, @Nullable WGPUDeviceDescriptor options, WGPURequestDeviceCallbackInfo callbackInfo);
	void	wgpuAdapterAddRef (Pointer adapter);
	void	wgpuAdapterRelease (Pointer adapter);

	// Methods of BindGroup
	void	wgpuBindGroupSetLabel (Pointer bindGroup, String label);
	void	wgpuBindGroupAddRef (Pointer bindGroup);
	void	wgpuBindGroupRelease (Pointer bindGroup);

	// Methods of BindGroupLayout
	void	wgpuBindGroupLayoutSetLabel (Pointer bindGroupLayout, String label);
	void	wgpuBindGroupLayoutAddRef (Pointer bindGroupLayout);
	void	wgpuBindGroupLayoutRelease (Pointer bindGroupLayout);

	// Methods of Buffer
	void	wgpuBufferDestroy (Pointer buffer);
	Pointer	wgpuBufferGetConstMappedRange (Pointer buffer, long offset, long size);
	WGPUBufferMapState	wgpuBufferGetMapState (Pointer buffer);
	Pointer	wgpuBufferGetMappedRange (Pointer buffer, long offset, long size);
	long	wgpuBufferGetSize (Pointer buffer);
	int	wgpuBufferGetUsage (Pointer buffer);
	void	wgpuBufferMapAsync (Pointer buffer, WGPUMapMode mode, long offset, long size, WGPUBufferMapCallback callback, Pointer userdata);
	WGPUFuture	wgpuBufferMapAsync2 (Pointer buffer, WGPUMapMode mode, long offset, long size, WGPUBufferMapCallbackInfo2 callbackInfo);
	WGPUFuture	wgpuBufferMapAsyncF (Pointer buffer, WGPUMapMode mode, long offset, long size, WGPUBufferMapCallbackInfo callbackInfo);
	void	wgpuBufferSetLabel (Pointer buffer, String label);
	void	wgpuBufferUnmap (Pointer buffer);
	void	wgpuBufferAddRef (Pointer buffer);
	void	wgpuBufferRelease (Pointer buffer);

	// Methods of CommandBuffer
	void	wgpuCommandBufferSetLabel (Pointer commandBuffer, String label);
	void	wgpuCommandBufferAddRef (Pointer commandBuffer);
	void	wgpuCommandBufferRelease (Pointer commandBuffer);

	// Methods of CommandEncoder
	Pointer	wgpuCommandEncoderBeginComputePass (Pointer commandEncoder, @Nullable WGPUComputePassDescriptor descriptor);
	Pointer	wgpuCommandEncoderBeginRenderPass (Pointer commandEncoder, WGPURenderPassDescriptor descriptor);
	void	wgpuCommandEncoderClearBuffer (Pointer commandEncoder, Pointer buffer, long offset, long size);
	void	wgpuCommandEncoderCopyBufferToBuffer (Pointer commandEncoder, Pointer source, long sourceOffset, Pointer destination, long destinationOffset, long size);
	void	wgpuCommandEncoderCopyBufferToTexture (Pointer commandEncoder, WGPUImageCopyBuffer source, WGPUImageCopyTexture destination, WGPUExtent3D copySize);
	void	wgpuCommandEncoderCopyTextureToBuffer (Pointer commandEncoder, WGPUImageCopyTexture source, WGPUImageCopyBuffer destination, WGPUExtent3D copySize);
	void	wgpuCommandEncoderCopyTextureToTexture (Pointer commandEncoder, WGPUImageCopyTexture source, WGPUImageCopyTexture destination, WGPUExtent3D copySize);
	Pointer	wgpuCommandEncoderFinish (Pointer commandEncoder, @Nullable WGPUCommandBufferDescriptor descriptor);
	void	wgpuCommandEncoderInjectValidationError (Pointer commandEncoder, String message);
	void	wgpuCommandEncoderInsertDebugMarker (Pointer commandEncoder, String markerLabel);
	void	wgpuCommandEncoderPopDebugGroup (Pointer commandEncoder);
	void	wgpuCommandEncoderPushDebugGroup (Pointer commandEncoder, String groupLabel);
	void	wgpuCommandEncoderResolveQuerySet (Pointer commandEncoder, Pointer querySet, int firstQuery, int queryCount, Pointer destination, long destinationOffset);
	void	wgpuCommandEncoderSetLabel (Pointer commandEncoder, String label);
	void	wgpuCommandEncoderWriteBuffer (Pointer commandEncoder, Pointer buffer, long bufferOffset, Pointer data, long size);
	void	wgpuCommandEncoderWriteTimestamp (Pointer commandEncoder, Pointer querySet, int queryIndex);
	void	wgpuCommandEncoderAddRef (Pointer commandEncoder);
	void	wgpuCommandEncoderRelease (Pointer commandEncoder);

	// Methods of ComputePassEncoder
	void	wgpuComputePassEncoderDispatchWorkgroups (Pointer computePassEncoder, int workgroupCountX, int workgroupCountY, int workgroupCountZ);
	void	wgpuComputePassEncoderDispatchWorkgroupsIndirect (Pointer computePassEncoder, Pointer indirectBuffer, long indirectOffset);
	void	wgpuComputePassEncoderEnd (Pointer computePassEncoder);
	void	wgpuComputePassEncoderInsertDebugMarker (Pointer computePassEncoder, String markerLabel);
	void	wgpuComputePassEncoderPopDebugGroup (Pointer computePassEncoder);
	void	wgpuComputePassEncoderPushDebugGroup (Pointer computePassEncoder, String groupLabel);
	void	wgpuComputePassEncoderSetBindGroup (Pointer computePassEncoder, int groupIndex, @Nullable Pointer group, long dynamicOffsetCount, Pointer dynamicOffsets);
	void	wgpuComputePassEncoderSetLabel (Pointer computePassEncoder, String label);
	void	wgpuComputePassEncoderSetPipeline (Pointer computePassEncoder, Pointer pipeline);
	void	wgpuComputePassEncoderWriteTimestamp (Pointer computePassEncoder, Pointer querySet, int queryIndex);
	void	wgpuComputePassEncoderAddRef (Pointer computePassEncoder);
	void	wgpuComputePassEncoderRelease (Pointer computePassEncoder);

	// Methods of ComputePipeline
	Pointer	wgpuComputePipelineGetBindGroupLayout (Pointer computePipeline, int groupIndex);
	void	wgpuComputePipelineSetLabel (Pointer computePipeline, String label);
	void	wgpuComputePipelineAddRef (Pointer computePipeline);
	void	wgpuComputePipelineRelease (Pointer computePipeline);

	// Methods of Device
	Pointer	wgpuDeviceCreateBindGroup (Pointer device, WGPUBindGroupDescriptor descriptor);
	Pointer	wgpuDeviceCreateBindGroupLayout (Pointer device, WGPUBindGroupLayoutDescriptor descriptor);
	Pointer	wgpuDeviceCreateBuffer (Pointer device, WGPUBufferDescriptor descriptor);
	Pointer	wgpuDeviceCreateCommandEncoder (Pointer device, @Nullable WGPUCommandEncoderDescriptor descriptor);
	Pointer	wgpuDeviceCreateComputePipeline (Pointer device, WGPUComputePipelineDescriptor descriptor);
	void	wgpuDeviceCreateComputePipelineAsync (Pointer device, WGPUComputePipelineDescriptor descriptor, WGPUCreateComputePipelineAsyncCallback callback, Pointer userdata);
	WGPUFuture	wgpuDeviceCreateComputePipelineAsync2 (Pointer device, WGPUComputePipelineDescriptor descriptor, WGPUCreateComputePipelineAsyncCallbackInfo2 callbackInfo);
	WGPUFuture	wgpuDeviceCreateComputePipelineAsyncF (Pointer device, WGPUComputePipelineDescriptor descriptor, WGPUCreateComputePipelineAsyncCallbackInfo callbackInfo);
	Pointer	wgpuDeviceCreateErrorBuffer (Pointer device, WGPUBufferDescriptor descriptor);
	Pointer	wgpuDeviceCreateErrorExternalTexture (Pointer device);
	Pointer	wgpuDeviceCreateErrorShaderModule (Pointer device, WGPUShaderModuleDescriptor descriptor, String errorMessage);
	Pointer	wgpuDeviceCreateErrorTexture (Pointer device, WGPUTextureDescriptor descriptor);
	Pointer	wgpuDeviceCreateExternalTexture (Pointer device, WGPUExternalTextureDescriptor externalTextureDescriptor);
	Pointer	wgpuDeviceCreatePipelineLayout (Pointer device, WGPUPipelineLayoutDescriptor descriptor);
	Pointer	wgpuDeviceCreateQuerySet (Pointer device, WGPUQuerySetDescriptor descriptor);
	Pointer	wgpuDeviceCreateRenderBundleEncoder (Pointer device, WGPURenderBundleEncoderDescriptor descriptor);
	Pointer	wgpuDeviceCreateRenderPipeline (Pointer device, WGPURenderPipelineDescriptor descriptor);
	void	wgpuDeviceCreateRenderPipelineAsync (Pointer device, WGPURenderPipelineDescriptor descriptor, WGPUCreateRenderPipelineAsyncCallback callback, Pointer userdata);
	WGPUFuture	wgpuDeviceCreateRenderPipelineAsync2 (Pointer device, WGPURenderPipelineDescriptor descriptor, WGPUCreateRenderPipelineAsyncCallbackInfo2 callbackInfo);
	WGPUFuture	wgpuDeviceCreateRenderPipelineAsyncF (Pointer device, WGPURenderPipelineDescriptor descriptor, WGPUCreateRenderPipelineAsyncCallbackInfo callbackInfo);
	Pointer	wgpuDeviceCreateSampler (Pointer device, @Nullable WGPUSamplerDescriptor descriptor);
	Pointer	wgpuDeviceCreateShaderModule (Pointer device, WGPUShaderModuleDescriptor descriptor);
	Pointer	wgpuDeviceCreateSwapChain (Pointer device, Pointer surface, WGPUSwapChainDescriptor descriptor);
	Pointer	wgpuDeviceCreateTexture (Pointer device, WGPUTextureDescriptor descriptor);
	void	wgpuDeviceDestroy (Pointer device);
	long	wgpuDeviceEnumerateFeatures (Pointer device, Pointer features);
	void	wgpuDeviceForceLoss (Pointer device, WGPUDeviceLostReason type, String message);
	WGPUStatus	wgpuDeviceGetAHardwareBufferProperties (Pointer device, Pointer handle, WGPUAHardwareBufferProperties properties);
	Pointer	wgpuDeviceGetAdapter (Pointer device);
	WGPUStatus	wgpuDeviceGetLimits (Pointer device, WGPUSupportedLimits limits);
	Pointer	wgpuDeviceGetQueue (Pointer device);
	int	wgpuDeviceGetSupportedSurfaceUsage (Pointer device, Pointer surface);
	boolean	wgpuDeviceHasFeature (Pointer device, int feature);
	Pointer	wgpuDeviceImportSharedBufferMemory (Pointer device, WGPUSharedBufferMemoryDescriptor descriptor);
	Pointer	wgpuDeviceImportSharedFence (Pointer device, WGPUSharedFenceDescriptor descriptor);
	Pointer	wgpuDeviceImportSharedTextureMemory (Pointer device, WGPUSharedTextureMemoryDescriptor descriptor);
	void	wgpuDeviceInjectError (Pointer device, WGPUErrorType type, String message);
	void	wgpuDevicePopErrorScope (Pointer device, WGPUErrorCallback oldCallback, Pointer userdata);
	WGPUFuture	wgpuDevicePopErrorScope2 (Pointer device, WGPUPopErrorScopeCallbackInfo2 callbackInfo);
	WGPUFuture	wgpuDevicePopErrorScopeF (Pointer device, WGPUPopErrorScopeCallbackInfo callbackInfo);
	void	wgpuDevicePushErrorScope (Pointer device, WGPUErrorFilter filter);
	void	wgpuDeviceSetDeviceLostCallback (Pointer device, WGPUDeviceLostCallback callback, Pointer userdata);
	void	wgpuDeviceSetLabel (Pointer device, String label);
	void	wgpuDeviceSetLoggingCallback (Pointer device, WGPULoggingCallback callback, Pointer userdata);
	void	wgpuDeviceSetUncapturedErrorCallback (Pointer device, WGPUErrorCallback callback, Pointer userdata);
	void	wgpuDeviceTick (Pointer device);
	void	wgpuDeviceValidateTextureDescriptor (Pointer device, WGPUTextureDescriptor descriptor);
	void	wgpuDeviceAddRef (Pointer device);
	void	wgpuDeviceRelease (Pointer device);

	// Methods of ExternalTexture
	void	wgpuExternalTextureDestroy (Pointer externalTexture);
	void	wgpuExternalTextureExpire (Pointer externalTexture);
	void	wgpuExternalTextureRefresh (Pointer externalTexture);
	void	wgpuExternalTextureSetLabel (Pointer externalTexture, String label);
	void	wgpuExternalTextureAddRef (Pointer externalTexture);
	void	wgpuExternalTextureRelease (Pointer externalTexture);

	// Methods of Instance
	Pointer	wgpuInstanceCreateSurface (Pointer instance, WGPUSurfaceDescriptor descriptor);
	long	wgpuInstanceEnumerateWGSLLanguageFeatures (Pointer instance, Pointer features);
	boolean	wgpuInstanceHasWGSLLanguageFeature (Pointer instance, int feature);
	void	wgpuInstanceProcessEvents (Pointer instance);
	void	wgpuInstanceRequestAdapter (Pointer instance, @Nullable WGPURequestAdapterOptions options, WGPURequestAdapterCallback callback, Pointer userdata);
	WGPUFuture	wgpuInstanceRequestAdapter2 (Pointer instance, @Nullable WGPURequestAdapterOptions options, WGPURequestAdapterCallbackInfo2 callbackInfo);
	WGPUFuture	wgpuInstanceRequestAdapterF (Pointer instance, @Nullable WGPURequestAdapterOptions options, WGPURequestAdapterCallbackInfo callbackInfo);
	WGPUWaitStatus	wgpuInstanceWaitAny (Pointer instance, long futureCount, WGPUFutureWaitInfo futures, long timeoutNS);
	void	wgpuInstanceAddRef (Pointer instance);
	void	wgpuInstanceRelease (Pointer instance);

	// Methods of PipelineLayout
	void	wgpuPipelineLayoutSetLabel (Pointer pipelineLayout, String label);
	void	wgpuPipelineLayoutAddRef (Pointer pipelineLayout);
	void	wgpuPipelineLayoutRelease (Pointer pipelineLayout);

	// Methods of QuerySet
	void	wgpuQuerySetDestroy (Pointer querySet);
	int	wgpuQuerySetGetCount (Pointer querySet);
	WGPUQueryType	wgpuQuerySetGetType (Pointer querySet);
	void	wgpuQuerySetSetLabel (Pointer querySet, String label);
	void	wgpuQuerySetAddRef (Pointer querySet);
	void	wgpuQuerySetRelease (Pointer querySet);

	// Methods of Queue
	void	wgpuQueueCopyExternalTextureForBrowser (Pointer queue, WGPUImageCopyExternalTexture source, WGPUImageCopyTexture destination, WGPUExtent3D copySize, WGPUCopyTextureForBrowserOptions options);
	void	wgpuQueueCopyTextureForBrowser (Pointer queue, WGPUImageCopyTexture source, WGPUImageCopyTexture destination, WGPUExtent3D copySize, WGPUCopyTextureForBrowserOptions options);
	void	wgpuQueueOnSubmittedWorkDone (Pointer queue, WGPUQueueWorkDoneCallback callback, Pointer userdata);
	WGPUFuture	wgpuQueueOnSubmittedWorkDone2 (Pointer queue, WGPUQueueWorkDoneCallbackInfo2 callbackInfo);
	WGPUFuture	wgpuQueueOnSubmittedWorkDoneF (Pointer queue, WGPUQueueWorkDoneCallbackInfo callbackInfo);
	void	wgpuQueueSetLabel (Pointer queue, String label);
	void	wgpuQueueSubmit (Pointer queue, long commandCount, Pointer commands);
	void	wgpuQueueWriteBuffer (Pointer queue, Pointer buffer, long bufferOffset, Pointer data, long size);
	void	wgpuQueueWriteTexture (Pointer queue, WGPUImageCopyTexture destination, Pointer data, long dataSize, WGPUTextureDataLayout dataLayout, WGPUExtent3D writeSize);
	void	wgpuQueueAddRef (Pointer queue);
	void	wgpuQueueRelease (Pointer queue);

	// Methods of RenderBundle
	void	wgpuRenderBundleSetLabel (Pointer renderBundle, String label);
	void	wgpuRenderBundleAddRef (Pointer renderBundle);
	void	wgpuRenderBundleRelease (Pointer renderBundle);

	// Methods of RenderBundleEncoder
	void	wgpuRenderBundleEncoderDraw (Pointer renderBundleEncoder, int vertexCount, int instanceCount, int firstVertex, int firstInstance);
	void	wgpuRenderBundleEncoderDrawIndexed (Pointer renderBundleEncoder, int indexCount, int instanceCount, int firstIndex, int baseVertex, int firstInstance);
	void	wgpuRenderBundleEncoderDrawIndexedIndirect (Pointer renderBundleEncoder, Pointer indirectBuffer, long indirectOffset);
	void	wgpuRenderBundleEncoderDrawIndirect (Pointer renderBundleEncoder, Pointer indirectBuffer, long indirectOffset);
	Pointer	wgpuRenderBundleEncoderFinish (Pointer renderBundleEncoder, @Nullable WGPURenderBundleDescriptor descriptor);
	void	wgpuRenderBundleEncoderInsertDebugMarker (Pointer renderBundleEncoder, String markerLabel);
	void	wgpuRenderBundleEncoderPopDebugGroup (Pointer renderBundleEncoder);
	void	wgpuRenderBundleEncoderPushDebugGroup (Pointer renderBundleEncoder, String groupLabel);
	void	wgpuRenderBundleEncoderSetBindGroup (Pointer renderBundleEncoder, int groupIndex, @Nullable Pointer group, long dynamicOffsetCount, Pointer dynamicOffsets);
	void	wgpuRenderBundleEncoderSetIndexBuffer (Pointer renderBundleEncoder, Pointer buffer, WGPUIndexFormat format, long offset, long size);
	void	wgpuRenderBundleEncoderSetLabel (Pointer renderBundleEncoder, String label);
	void	wgpuRenderBundleEncoderSetPipeline (Pointer renderBundleEncoder, Pointer pipeline);
	void	wgpuRenderBundleEncoderSetVertexBuffer (Pointer renderBundleEncoder, int slot, @Nullable Pointer buffer, long offset, long size);
	void	wgpuRenderBundleEncoderAddRef (Pointer renderBundleEncoder);
	void	wgpuRenderBundleEncoderRelease (Pointer renderBundleEncoder);

	// Methods of RenderPassEncoder
	void	wgpuRenderPassEncoderBeginOcclusionQuery (Pointer renderPassEncoder, int queryIndex);
	void	wgpuRenderPassEncoderDraw (Pointer renderPassEncoder, int vertexCount, int instanceCount, int firstVertex, int firstInstance);
	void	wgpuRenderPassEncoderDrawIndexed (Pointer renderPassEncoder, int indexCount, int instanceCount, int firstIndex, int baseVertex, int firstInstance);
	void	wgpuRenderPassEncoderDrawIndexedIndirect (Pointer renderPassEncoder, Pointer indirectBuffer, long indirectOffset);
	void	wgpuRenderPassEncoderDrawIndirect (Pointer renderPassEncoder, Pointer indirectBuffer, long indirectOffset);
	void	wgpuRenderPassEncoderEnd (Pointer renderPassEncoder);
	void	wgpuRenderPassEncoderEndOcclusionQuery (Pointer renderPassEncoder);
	void	wgpuRenderPassEncoderExecuteBundles (Pointer renderPassEncoder, long bundleCount, Pointer bundles);
	void	wgpuRenderPassEncoderInsertDebugMarker (Pointer renderPassEncoder, String markerLabel);
	void	wgpuRenderPassEncoderPixelLocalStorageBarrier (Pointer renderPassEncoder);
	void	wgpuRenderPassEncoderPopDebugGroup (Pointer renderPassEncoder);
	void	wgpuRenderPassEncoderPushDebugGroup (Pointer renderPassEncoder, String groupLabel);
	void	wgpuRenderPassEncoderSetBindGroup (Pointer renderPassEncoder, int groupIndex, @Nullable Pointer group, long dynamicOffsetCount, Pointer dynamicOffsets);
	void	wgpuRenderPassEncoderSetBlendConstant (Pointer renderPassEncoder, WGPUColor color);
	void	wgpuRenderPassEncoderSetIndexBuffer (Pointer renderPassEncoder, Pointer buffer, WGPUIndexFormat format, long offset, long size);
	void	wgpuRenderPassEncoderSetLabel (Pointer renderPassEncoder, String label);
	void	wgpuRenderPassEncoderSetPipeline (Pointer renderPassEncoder, Pointer pipeline);
	void	wgpuRenderPassEncoderSetScissorRect (Pointer renderPassEncoder, int x, int y, int width, int height);
	void	wgpuRenderPassEncoderSetStencilReference (Pointer renderPassEncoder, int reference);
	void	wgpuRenderPassEncoderSetVertexBuffer (Pointer renderPassEncoder, int slot, @Nullable Pointer buffer, long offset, long size);
	void	wgpuRenderPassEncoderSetViewport (Pointer renderPassEncoder, float x, float y, float width, float height, float minDepth, float maxDepth);
	void	wgpuRenderPassEncoderWriteTimestamp (Pointer renderPassEncoder, Pointer querySet, int queryIndex);
	void	wgpuRenderPassEncoderAddRef (Pointer renderPassEncoder);
	void	wgpuRenderPassEncoderRelease (Pointer renderPassEncoder);

	// Methods of RenderPipeline
	Pointer	wgpuRenderPipelineGetBindGroupLayout (Pointer renderPipeline, int groupIndex);
	void	wgpuRenderPipelineSetLabel (Pointer renderPipeline, String label);
	void	wgpuRenderPipelineAddRef (Pointer renderPipeline);
	void	wgpuRenderPipelineRelease (Pointer renderPipeline);

	// Methods of Sampler
	void	wgpuSamplerSetLabel (Pointer sampler, String label);
	void	wgpuSamplerAddRef (Pointer sampler);
	void	wgpuSamplerRelease (Pointer sampler);

	// Methods of ShaderModule
	void	wgpuShaderModuleGetCompilationInfo (Pointer shaderModule, WGPUCompilationInfoCallback callback, Pointer userdata);
	WGPUFuture	wgpuShaderModuleGetCompilationInfo2 (Pointer shaderModule, WGPUCompilationInfoCallbackInfo2 callbackInfo);
	WGPUFuture	wgpuShaderModuleGetCompilationInfoF (Pointer shaderModule, WGPUCompilationInfoCallbackInfo callbackInfo);
	void	wgpuShaderModuleSetLabel (Pointer shaderModule, String label);
	void	wgpuShaderModuleAddRef (Pointer shaderModule);
	void	wgpuShaderModuleRelease (Pointer shaderModule);

	// Methods of SharedBufferMemory
	boolean	wgpuSharedBufferMemoryBeginAccess (Pointer sharedBufferMemory, Pointer buffer, WGPUSharedBufferMemoryBeginAccessDescriptor descriptor);
	Pointer	wgpuSharedBufferMemoryCreateBuffer (Pointer sharedBufferMemory, @Nullable WGPUBufferDescriptor descriptor);
	boolean	wgpuSharedBufferMemoryEndAccess (Pointer sharedBufferMemory, Pointer buffer, WGPUSharedBufferMemoryEndAccessState descriptor);
	WGPUStatus	wgpuSharedBufferMemoryGetProperties (Pointer sharedBufferMemory, WGPUSharedBufferMemoryProperties properties);
	boolean	wgpuSharedBufferMemoryIsDeviceLost (Pointer sharedBufferMemory);
	void	wgpuSharedBufferMemorySetLabel (Pointer sharedBufferMemory, String label);
	void	wgpuSharedBufferMemoryAddRef (Pointer sharedBufferMemory);
	void	wgpuSharedBufferMemoryRelease (Pointer sharedBufferMemory);

	// Methods of SharedFence
	void	wgpuSharedFenceExportInfo (Pointer sharedFence, WGPUSharedFenceExportInfo info);
	void	wgpuSharedFenceAddRef (Pointer sharedFence);
	void	wgpuSharedFenceRelease (Pointer sharedFence);

	// Methods of SharedTextureMemory
	boolean	wgpuSharedTextureMemoryBeginAccess (Pointer sharedTextureMemory, Pointer texture, WGPUSharedTextureMemoryBeginAccessDescriptor descriptor);
	Pointer	wgpuSharedTextureMemoryCreateTexture (Pointer sharedTextureMemory, @Nullable WGPUTextureDescriptor descriptor);
	boolean	wgpuSharedTextureMemoryEndAccess (Pointer sharedTextureMemory, Pointer texture, WGPUSharedTextureMemoryEndAccessState descriptor);
	WGPUStatus	wgpuSharedTextureMemoryGetProperties (Pointer sharedTextureMemory, WGPUSharedTextureMemoryProperties properties);
	boolean	wgpuSharedTextureMemoryIsDeviceLost (Pointer sharedTextureMemory);
	void	wgpuSharedTextureMemorySetLabel (Pointer sharedTextureMemory, String label);
	void	wgpuSharedTextureMemoryAddRef (Pointer sharedTextureMemory);
	void	wgpuSharedTextureMemoryRelease (Pointer sharedTextureMemory);

	// Methods of Surface
	void	wgpuSurfaceConfigure (Pointer surface, WGPUSurfaceConfiguration config);
	WGPUStatus	wgpuSurfaceGetCapabilities (Pointer surface, Pointer adapter, WGPUSurfaceCapabilities capabilities);
	void	wgpuSurfaceGetCurrentTexture (Pointer surface, WGPUSurfaceTexture surfaceTexture);
	WGPUTextureFormat	wgpuSurfaceGetPreferredFormat (Pointer surface, Pointer adapter);
	void	wgpuSurfacePresent (Pointer surface);
	void	wgpuSurfaceUnconfigure (Pointer surface);
	void	wgpuSurfaceAddRef (Pointer surface);
	void	wgpuSurfaceRelease (Pointer surface);

	// Methods of SwapChain
	Pointer	wgpuSwapChainGetCurrentTexture (Pointer swapChain);
	Pointer	wgpuSwapChainGetCurrentTextureView (Pointer swapChain);
	void	wgpuSwapChainPresent (Pointer swapChain);
	void	wgpuSwapChainAddRef (Pointer swapChain);
	void	wgpuSwapChainRelease (Pointer swapChain);

	// Methods of Texture
	Pointer	wgpuTextureCreateErrorView (Pointer texture, @Nullable WGPUTextureViewDescriptor descriptor);
	Pointer	wgpuTextureCreateView (Pointer texture, @Nullable WGPUTextureViewDescriptor descriptor);
	void	wgpuTextureDestroy (Pointer texture);
	int	wgpuTextureGetDepthOrArrayLayers (Pointer texture);
	WGPUTextureDimension	wgpuTextureGetDimension (Pointer texture);
	WGPUTextureFormat	wgpuTextureGetFormat (Pointer texture);
	int	wgpuTextureGetHeight (Pointer texture);
	int	wgpuTextureGetMipLevelCount (Pointer texture);
	int	wgpuTextureGetSampleCount (Pointer texture);
	int	wgpuTextureGetUsage (Pointer texture);
	int	wgpuTextureGetWidth (Pointer texture);
	void	wgpuTextureSetLabel (Pointer texture, String label);
	void	wgpuTextureAddRef (Pointer texture);
	void	wgpuTextureRelease (Pointer texture);

	// Methods of TextureView
	void	wgpuTextureViewSetLabel (Pointer textureView, String label);
	void	wgpuTextureViewAddRef (Pointer textureView);
	void	wgpuTextureViewRelease (Pointer textureView);
}