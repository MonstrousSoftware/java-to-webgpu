package com.monstrous.utils;



import com.monstrous.webgpu.WGPUDeviceDescriptor;
import com.monstrous.webgpu.WGPURequestAdapterOptions;
import jnr.ffi.Pointer;

/**
 * A representation in Java of the native C interface for wgpuUtils.dll.
 */
public interface WebGPUUtils_JNI {

    /**
     * Bridge between GLFW and WebGPU: Provides a Surface corresponding to a GLFW window.
     */
    Pointer glfwGetWGPUSurface(Pointer instance, long HWND);

    Pointer RequestAdapterSync(Pointer instance, WGPURequestAdapterOptions options);
    Pointer RequestDeviceSync(Pointer adapter, WGPUDeviceDescriptor descriptor);
}