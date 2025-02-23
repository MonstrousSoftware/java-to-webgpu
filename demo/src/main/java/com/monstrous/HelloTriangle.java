package com.monstrous;

import com.monstrous.webgpu.*;
import com.monstrous.wgpuUtils.WgpuJava;
import jnr.ffi.Pointer;


// Render a triangle in a window
//
// Following the tutorial WebGPU in C++ https://eliemichel.github.io/LearnWebGPU/


public class HelloTriangle {
    public final static int WIDTH = 640;
    public final static int HEIGHT = 480;

    private WGPUBackendType backend = WGPUBackendType.D3D12;        // or Vulkan, etc.
    private boolean vsyncEnabled = true;

    private WebGPU webGPU;
    private Pointer surface;
    private WGPUTextureFormat surfaceFormat;
    private Pointer device;
    private Pointer queue;
    private Pointer pipeline;

    public HelloTriangle() {

        WindowedApp winApp = new WindowedApp();

        // create a window
        winApp.openWindow(WIDTH, HEIGHT, "WebGPU: Hello Triangle!");

        initWebGPU(winApp.getWindowHandle());

        // render loop
        while (!winApp.getShouldClose()) {

            renderFrame();

            webGPU.wgpuDeviceTick(device);

            // Poll for window events.
            winApp.pollEvents();
        }

        exitWebGPU();
        winApp.closeWindow();
    }

    private void renderFrame() {

        Pointer targetView = getNextSurfaceTextureView();
        if (targetView.address() == 0) {
            System.out.println("*** Invalid target view");
            return;
        }

        Pointer commandEncoder = prepareEncoder();
        Pointer renderPass = prepareRenderPass(commandEncoder, targetView);

        render(renderPass); // do some rendering in this render pass

        webGPU.wgpuRenderPassEncoderEnd(renderPass);
        webGPU.wgpuRenderPassEncoderRelease(renderPass);

        finishEncoder(commandEncoder);

        // At the end of the frame
        webGPU.wgpuTextureViewRelease(targetView);
        webGPU.wgpuSurfacePresent(surface);
    }

    private void render(Pointer renderPass){
        // Select which render pipeline to use
        webGPU.wgpuRenderPassEncoderSetPipeline(renderPass, pipeline);

        // Draw 1 instance of a 3-vertices shape
        webGPU.wgpuRenderPassEncoderDraw(renderPass, 3, 1, 0, 0);
    }


    private void initWebGPU(long windowHandle) {
        webGPU = WgpuJava.init();

        Pointer instance = webGPU.wgpuCreateInstance();

        surface = WgpuJava.utils.glfwGetWGPUSurface(instance, windowHandle);

        device = initDevice(instance);

        webGPU.wgpuInstanceRelease(instance);       // we can release the instance now that we have the device

        queue = webGPU.wgpuDeviceGetQueue(device);

        initSwapChain(WIDTH, HEIGHT);
        pipeline = initPipeline();
    }


    private Pointer initDevice( Pointer instance) {

        // Select an Adapter
        //
        WGPURequestAdapterOptions options = WGPURequestAdapterOptions.createDirect();
        options.setNextInChain();
        options.setCompatibleSurface(surface);
        options.setBackendType(backend);
        options.setPowerPreference(WGPUPowerPreference.HighPerformance);

        // Get Adapter
        Pointer adapter = WgpuJava.getUtils().RequestAdapterSync(instance, options);

        WGPUSupportedLimits supportedLimits = WGPUSupportedLimits.createDirect();
        webGPU.wgpuAdapterGetLimits(adapter, supportedLimits);
//        System.out.println("adapter maxVertexAttributes " + supportedLimits.getLimits().getMaxVertexAttributes());
//        System.out.println("adapter maxBindGroups " + supportedLimits.getLimits().getMaxBindGroups());
//
//        System.out.println("maxTextureDimension1D " + supportedLimits.getLimits().getMaxTextureDimension1D());
//        System.out.println("maxTextureDimension2D " + supportedLimits.getLimits().getMaxTextureDimension2D());
//        System.out.println("maxTextureDimension3D " + supportedLimits.getLimits().getMaxTextureDimension3D());
//        System.out.println("maxTextureArrayLayers " + supportedLimits.getLimits().getMaxTextureArrayLayers());


        WGPUAdapterProperties adapterProperties = WGPUAdapterProperties.createDirect();
        adapterProperties.setNextInChain();

        webGPU.wgpuAdapterGetProperties(adapter, adapterProperties);

        System.out.println("VendorID: " + adapterProperties.getVendorID());
        System.out.println("Vendor name: " + adapterProperties.getVendorName());
        System.out.println("Device ID: " + adapterProperties.getDeviceID());
        System.out.println("Back end: " + adapterProperties.getBackendType());
        System.out.println("Description: " + adapterProperties.getDriverDescription());


        WGPURequiredLimits requiredLimits = WGPURequiredLimits.createDirect();
        setDefaultLimits(requiredLimits.getLimits());

        // Get a Device
        //
        WGPUDeviceDescriptor deviceDescriptor = WGPUDeviceDescriptor.createDirect();
        deviceDescriptor.setNextInChain();
        deviceDescriptor.setLabel("My Device");
        deviceDescriptor.setRequiredLimits(requiredLimits);
        deviceDescriptor.setRequiredFeatureCount(0);
        deviceDescriptor.setRequiredFeatures(null);

        Pointer device = WgpuJava.getUtils().RequestDeviceSync(adapter, deviceDescriptor);

        // use a lambda expression to define a callback function
        WGPUErrorCallback deviceCallback = (WGPUErrorType type, String message, Pointer userdata) -> {
            System.out.println("*** Device error: " + type + " : " + message);
            System.exit(-1);
        };
        webGPU.wgpuDeviceSetUncapturedErrorCallback(device, deviceCallback, null);

        webGPU.wgpuDeviceGetLimits(device, supportedLimits);
//        System.out.println("device maxVertexAttributes " + supportedLimits.getLimits().getMaxVertexAttributes());
//
//        System.out.println("maxTextureDimension1D " + supportedLimits.getLimits().getMaxTextureDimension1D());
//        System.out.println("maxTextureDimension2D " + supportedLimits.getLimits().getMaxTextureDimension2D());
//        System.out.println("maxTextureDimension3D " + supportedLimits.getLimits().getMaxTextureDimension3D());
//        System.out.println("maxTextureArrayLayers " + supportedLimits.getLimits().getMaxTextureArrayLayers());

        WGPUSurfaceCapabilities caps = WGPUSurfaceCapabilities.createDirect();
        webGPU.wgpuSurfaceGetCapabilities(surface, adapter, caps);
        Pointer formats = caps.getFormats();
        int format = formats.getInt(0);
        surfaceFormat = WGPUTextureFormat.values()[format];

        webGPU.wgpuAdapterRelease(adapter);       // we can release our adapter as soon as we have a device
        return device;
    }


    private void initSwapChain(int width, int height){
        // configure the surface
        WGPUSurfaceConfiguration config = WGPUSurfaceConfiguration.createDirect();
        config.setNextInChain();

        config.setWidth(width);
        config.setHeight(height);

        config.setFormat(surfaceFormat);
        // And we do not need any particular view format:
        config.setViewFormatCount(0);
        config.setViewFormats(WgpuJava.createNullPointer());
        config.setUsage(WGPUTextureUsage.RenderAttachment);
        config.setDevice(device);
        config.setPresentMode(vsyncEnabled ? WGPUPresentMode.Fifo : WGPUPresentMode.Immediate);
        config.setAlphaMode(WGPUCompositeAlphaMode.Auto);

        webGPU.wgpuSurfaceConfigure(surface, config);
    }


    private Pointer getNextSurfaceTextureView() {
        // [...] Get the next surface texture
        WGPUSurfaceTexture surfaceTexture = WGPUSurfaceTexture.createDirect();
        webGPU.wgpuSurfaceGetCurrentTexture(surface, surfaceTexture);
        //System.out.println("get current texture: "+surfaceTexture.status.get());
        if(surfaceTexture.getStatus() != WGPUSurfaceGetCurrentTextureStatus.Success){
            System.out.println("*** No current texture");
            return WgpuJava.createNullPointer();
        }
        // [...] Create surface texture view
        WGPUTextureViewDescriptor viewDescriptor = WGPUTextureViewDescriptor.createDirect();
        viewDescriptor.setNextInChain();
        viewDescriptor.setLabel("Surface texture view");
        Pointer tex = surfaceTexture.getTexture();
        WGPUTextureFormat format = webGPU.wgpuTextureGetFormat(tex);
        //System.out.println("Set format "+format);
        viewDescriptor.setFormat(format);
        viewDescriptor.setDimension(WGPUTextureViewDimension._2D);
        viewDescriptor.setBaseMipLevel(0);
        viewDescriptor.setMipLevelCount(1);
        viewDescriptor.setBaseArrayLayer(0);
        viewDescriptor.setArrayLayerCount(1);
        viewDescriptor.setAspect(WGPUTextureAspect.All);
        Pointer view =  webGPU.wgpuTextureCreateView(surfaceTexture.getTexture(), viewDescriptor);

        // we can release the texture now as the texture view now has its own reference to it
        webGPU.wgpuTextureRelease(surfaceTexture.getTexture());
        return view;
    }

    private Pointer prepareEncoder() {
        WGPUCommandEncoderDescriptor encoderDescriptor = WGPUCommandEncoderDescriptor.createDirect();
        encoderDescriptor.setNextInChain();
        encoderDescriptor.setLabel("My Encoder");

        return webGPU.wgpuDeviceCreateCommandEncoder(device, encoderDescriptor);
    }

    private void exitWebGPU() {
        webGPU.wgpuRenderPipelineRelease(pipeline);
        webGPU.wgpuSurfaceUnconfigure(surface);
        webGPU.wgpuQueueRelease(queue);
        webGPU.wgpuDeviceRelease(device);
        webGPU.wgpuSurfaceRelease(surface);

    }


    private Pointer prepareRenderPass(Pointer encoder, Pointer targetView){

        WGPURenderPassColorAttachment renderPassColorAttachment = WGPURenderPassColorAttachment.createDirect();
        renderPassColorAttachment.setNextInChain();
        renderPassColorAttachment.setView(targetView);
        renderPassColorAttachment.setResolveTarget(WgpuJava.createNullPointer());
        renderPassColorAttachment.setLoadOp(WGPULoadOp.Clear);
        renderPassColorAttachment.setStoreOp(WGPUStoreOp.Store);

        // background colour
        renderPassColorAttachment.getClearValue().setR(0.9);
        renderPassColorAttachment.getClearValue().setG(0.1);
        renderPassColorAttachment.getClearValue().setB(0.2);
        renderPassColorAttachment.getClearValue().setA(1.0);

        renderPassColorAttachment.setDepthSlice( -1L ); // undefined

        WGPURenderPassDescriptor renderPassDescriptor = WGPURenderPassDescriptor.createDirect();
        renderPassDescriptor.setNextInChain();

        renderPassDescriptor.setLabel("Main Render Pass");

        renderPassDescriptor.setColorAttachmentCount(1);
        renderPassDescriptor.setColorAttachments( renderPassColorAttachment );
        renderPassDescriptor.setOcclusionQuerySet(WgpuJava.createNullPointer());
        renderPassDescriptor.setDepthStencilAttachment();       // no depth buffer or stencil buffer

        return webGPU.wgpuCommandEncoderBeginRenderPass(encoder, renderPassDescriptor);
    }

    private void finishEncoder(Pointer encoder){
        // Finish the command encoder, which gives us the command buffer
        WGPUCommandBufferDescriptor bufferDescriptor =  WGPUCommandBufferDescriptor.createDirect();
        bufferDescriptor.setNextInChain();
        bufferDescriptor.setLabel("Command Buffer");
        Pointer commandBuffer = webGPU.wgpuCommandEncoderFinish(encoder, bufferDescriptor);

        // Release the command encoder
        webGPU.wgpuCommandEncoderRelease(encoder);

        // Submit the command buffer to the queue
        Pointer bufferPtr = WgpuJava.createLongArrayPointer(new long[]{commandBuffer.address() });
        webGPU.wgpuQueueSubmit(queue, 1, bufferPtr);

        // Now we can release the command buffer
        webGPU.wgpuCommandBufferRelease(commandBuffer);
    }


    private Pointer initPipeline(){

        Pointer shaderModule = makeShaderModule();

        WGPURenderPipelineDescriptor pipelineDesc = WGPURenderPipelineDescriptor.createDirect();
        pipelineDesc.setNextInChain();
        pipelineDesc.setLabel( "my pipeline" );

        pipelineDesc.getVertex().setBufferCount(0); // no vertex buffer, because we define it in the shader
        pipelineDesc.getVertex().setBuffers();

        pipelineDesc.getVertex().setModule(shaderModule);
        pipelineDesc.getVertex().setEntryPoint("vs_main");
        pipelineDesc.getVertex().setConstantCount(0);
        pipelineDesc.getVertex().setConstants();

        pipelineDesc.getPrimitive().setTopology(WGPUPrimitiveTopology.TriangleList);
        pipelineDesc.getPrimitive().setStripIndexFormat(WGPUIndexFormat.Undefined);
        pipelineDesc.getPrimitive().setFrontFace(WGPUFrontFace.CCW);
        pipelineDesc.getPrimitive().setCullMode(WGPUCullMode.None);

        WGPUFragmentState fragmentState = WGPUFragmentState.createDirect();
        fragmentState.setNextInChain();
        fragmentState.setModule(shaderModule);
        fragmentState.setEntryPoint("fs_main");
        fragmentState.setConstantCount(0);
        fragmentState.setConstants();

        // blending
        WGPUBlendState blendState = WGPUBlendState.createDirect();
        blendState.getColor().setSrcFactor(WGPUBlendFactor.SrcAlpha);
        blendState.getColor().setDstFactor(WGPUBlendFactor.OneMinusSrcAlpha);
        blendState.getColor().setOperation(WGPUBlendOperation.Add);
        blendState.getAlpha().setSrcFactor(WGPUBlendFactor.One);
        blendState.getAlpha().setDstFactor(WGPUBlendFactor.Zero);
        blendState.getAlpha().setOperation(WGPUBlendOperation.Add);

        WGPUColorTargetState colorTarget = WGPUColorTargetState.createDirect();

        colorTarget.setFormat(surfaceFormat);       // match output surface
        colorTarget.setBlend(blendState);
        colorTarget.setWriteMask(WGPUColorWriteMask.All);

        fragmentState.setTargetCount(1);
        fragmentState.setTargets(colorTarget);

        pipelineDesc.setFragment(fragmentState);

        pipelineDesc.setDepthStencil(); // no depth or stencil buffer

        pipelineDesc.getMultisample().setCount(1);
        pipelineDesc.getMultisample().setMask( -1L );
        pipelineDesc.getMultisample().setAlphaToCoverageEnabled(0);

        pipelineDesc.setLayout(WgpuJava.createNullPointer());
        pipeline = webGPU.wgpuDeviceCreateRenderPipeline(device, pipelineDesc);
        if(pipeline == null)
            throw new RuntimeException("Pipeline creation failed");

        // We no longer need to access the shader module
        webGPU.wgpuShaderModuleRelease(shaderModule);
        return pipeline;
    }


    private String source = "@vertex\n" +
            "fn vs_main(@builtin(vertex_index) in_vertex_index: u32) -> @builtin(position) vec4f {\n" +
            "    var p = vec2f(0.0, 0.0);\n" +
            "    if (in_vertex_index == 0u) {\n" +
            "        p = vec2f(-0.5, -0.5);\n" +
            "    } else if (in_vertex_index == 1u) {\n" +
            "        p = vec2f(0.5, -0.5);\n" +
            "    } else {\n" +
            "        p = vec2f(0.0, 0.5);\n" +
            "    }\n" +
            "    return vec4f(p, 0.0, 1.0);\n" +
            "}\n" +
            "\n" +
            "@fragment\n" +
            "fn fs_main() -> @location(0) vec4f {\n" +
            "    return vec4f(0.0, 0.4, 1.0, 1.0);\n" +
            "}\n";

    private Pointer makeShaderModule(){
        // Create Shader Module
        WGPUShaderModuleDescriptor shaderDesc = WGPUShaderModuleDescriptor.createDirect();
        shaderDesc.setLabel("triangle shader");

        WGPUShaderModuleWGSLDescriptor shaderCodeDesc = WGPUShaderModuleWGSLDescriptor.createDirect();
        shaderCodeDesc.getChain().setNext();
        shaderCodeDesc.getChain().setSType(WGPUSType.ShaderModuleWGSLDescriptor);
        shaderCodeDesc.setCode(source);

        shaderDesc.getNextInChain().set(shaderCodeDesc.getPointerTo());

        Pointer shaderModule = webGPU.wgpuDeviceCreateShaderModule(device, shaderDesc);
        if(shaderModule == null)
            throw new RuntimeException("ShaderModule: compile failed.");
        return shaderModule;
    }


    final static long WGPU_LIMIT_U32_UNDEFINED = 4294967295L;
    final static long WGPU_LIMIT_U64_UNDEFINED = Long.MAX_VALUE;
    // should be 2^64-1 (18446744073709551615L) but Java longs are signed, so it is half that. It seems to work though.

    public void setDefaultLimits(WGPULimits limits) {
        limits.setMaxTextureDimension1D(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxTextureDimension2D(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxTextureDimension3D(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxTextureArrayLayers(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxBindGroups(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxBindGroupsPlusVertexBuffers(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxBindingsPerBindGroup(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxDynamicUniformBuffersPerPipelineLayout(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxDynamicStorageBuffersPerPipelineLayout(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxSampledTexturesPerShaderStage(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxSamplersPerShaderStage(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxStorageBuffersPerShaderStage(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxStorageTexturesPerShaderStage(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxUniformBuffersPerShaderStage(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxUniformBufferBindingSize(WGPU_LIMIT_U64_UNDEFINED);
        limits.setMaxStorageBufferBindingSize(WGPU_LIMIT_U64_UNDEFINED);
        limits.setMinUniformBufferOffsetAlignment(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMinStorageBufferOffsetAlignment(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxVertexBuffers(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxBufferSize(WGPU_LIMIT_U64_UNDEFINED);
        limits.setMaxVertexAttributes(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxVertexBufferArrayStride(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxInterStageShaderComponents(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxInterStageShaderVariables(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxColorAttachments(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxColorAttachmentBytesPerSample(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxComputeWorkgroupStorageSize(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxComputeInvocationsPerWorkgroup(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxComputeWorkgroupSizeX(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxComputeWorkgroupSizeY(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxComputeWorkgroupSizeZ(WGPU_LIMIT_U32_UNDEFINED);
        limits.setMaxComputeWorkgroupsPerDimension(WGPU_LIMIT_U32_UNDEFINED);
    }
}
