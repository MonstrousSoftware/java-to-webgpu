package com.monstrous.utils;

import com.monstrous.webgpu.WGPUDeviceDescriptor;
import com.monstrous.webgpu.WGPURequestAdapterOptions;
import jnr.ffi.Pointer;


public interface WebGPUUtils_JNI { // A representation of the C interface in Java

    Pointer glfwGetWGPUSurface(Pointer instance, long HWND);

    Pointer RequestAdapterSync(Pointer instance, WGPURequestAdapterOptions options);
    Pointer RequestDeviceSync(Pointer adapter, WGPUDeviceDescriptor descriptor);
}