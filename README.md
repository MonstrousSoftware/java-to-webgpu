# Java-to-WebGPU

Java wrapper for WebGPU.


![screenshot.png](screenshot.png)

## Introduction

This is a library to use native WebGPU libraries using Java.

## How to

Before using any WebGPU functions call:

    WebGPU webGPU = WguJava.init();

Then use the webGPU object to call the different WebGPU functions. For example:

    Pointer instance = webGPU.CreateInstance();

Which is the equivalent of the following C++ code:

    // We create the instance using this descriptor
    WGPUInstance instance = wgpuCreateInstance(nullptr)


## Modules
- ```java-to-webgpu```  Java library to call WebGPU
- ```demo``` Sample application
- ```webgpuUtils```   Native library with utility functions (C++)


## Switching between Native WGPU and DAWN
to do 

Notes:
Makes use of LWJGL to create a window.
Uses JNR-FFI to call native functions.

todo:
- should we include dll in resources and copy on startup?
- can we link project to dawn.dll or do we need to copy inside?
- can we move the 2 Request calls from wrapper to Java?
- clean up the logic of WgpuJava and the start-up sequence.
- using wgpu_native.dll causes crash in RequestAdapterSync
- is there no way we can remove wgpu prefix from function names because we now also have an object name.
- why is wrapper not smaller? 1.6 Mb
- which version of webgpu are we using? version of dawn?
- can we select driver on startup?
- license
- official header file seems to be at: https://github.com/webgpu-native/webgpu-headers


if on laptop you request backend Undefined it chooses D3D12 but issues a warning:

Description: D3D12 driver version 30.0.101.1122
Warning: Disable Intel Vulkan adapter on Windows driver version 101.1122. See https://crbug.com/1338622.
- While initializing adapter (backend=BackendType::Vulkan)
  at InitializeImpl (D:\a\webgpu-dawn-binaries\webgpu-dawn-binaries\build\_deps\dawn-src\src\dawn\native\vulkan\PhysicalDeviceVk.cpp:130)
Otherwise only D3D11 and D3D12 are supported.

Versioning:
Gradle 8.0
Java version 17
LWJGL version:3.3.4+7
JNR-FFI

wgpu-native binaries: https://github.com/gfx-rs/wgpu-native/releases
