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


## Switching between Native WGPU and DAWN
to do 

Notes:
Makes use of LWJGL to create a window.
Uses JNR-FFI to call native functions.