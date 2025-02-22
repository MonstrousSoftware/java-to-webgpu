package com.monstrous;

import com.monstrous.webgpu.WebGPU;
import com.monstrous.wgpuUtils.WgpuJava;
import jnr.ffi.LibraryLoader;
import jnr.ffi.Pointer;
import jnr.ffi.Runtime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class HelloTriangle {

    private WebGPU webGPU;
    private Pointer instance;
    private Pointer surface;
    private Pointer device;
    private Pointer queue;

    public static void main(String[] args) {
        new HelloTriangle();
    }

    public HelloTriangle() {
        WindowedApp winApp = new WindowedApp();
        // create a window
        winApp.openWindow(640, 480, "Hello Triangle!");

        initWebGPU(winApp.getWindowHandle());

        // render loop
        while (!winApp.getShouldClose()) {


            // Poll for window events.
            winApp.pollEvents();
        }

        exitWebGPU();
        winApp.closeWindow();
    }


    private void initWebGPU(long windowHandle) {
        webGPU = LibraryLoader.create(WebGPU.class).load("wrapper"); // load the library

        Runtime runtime = Runtime.getRuntime(webGPU);
        WgpuJava.setRuntime(runtime);


        instance = webGPU.CreateInstance();
        System.out.println("instance = " + instance);

        System.out.println("window = " + Long.toString(windowHandle, 16));
        surface = webGPU.glfwGetWGPUSurface(instance, windowHandle);
        System.out.println("surface = " + surface);

        //device = initDevice();

//        gpuTiming = new GPUTiming(LibGPU.device, configuration.enableGPUtiming);
    }

    private void exitWebGPU() {
//        gpuTiming.dispose();
//
//        terminateSwapChain();
//        terminateDepthBuffer();
//        terminateDevice();

        webGPU.SurfaceRelease(surface);
        webGPU.InstanceRelease(instance);
    }
}
