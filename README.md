# Java-to-WebGPU

Java wrapper for WebGPU.


![screenshot.png](screenshot.png)

## Introduction

This is a library to use native WebGPU libraries using Java.

## How to

Before using any WebGPU functions call:

    WebGPU_JNI webGPU = WguJava.init();

Then use the webGPU object to call the different WebGPU functions. For example:

    Pointer instance = webGPU.wgpuCreateInstance(null);

Which is the equivalent of the following C++ code:

    // We create the instance using this descriptor
    WGPUInstance instance = wgpuCreateInstance(nullptr)

The native utility library can be accessed as follows

    WebGPUUtils_JNI utils = WgpuJava.getUtils();

This library provide asynchronous methods to obtain an Adapter and a Device and a method to get a WGPUSurface from a GLFW window.


## Modules
- ```java-to-webgpu```  Java library to call WebGPU
- ```demo``` Sample application
- ```jnrgen``` Generator to create the Java interface from a C++ header file
- ```webgpuUtils```   Native library with utility functions (C++)


## Coding caveats
The triangle demo follows the tutorial of WebGPU for C++ by Elie Michel (https://eliemichel.github.io/LearnWebGPU/)

Some difference will be apparent between the Java and C++ version.

Any resource provided by WebGPU, such as an Adapter, a Device, a Texture, a Buffer, 
etcetera, is represented by a Pointer object.  In the C++ code there are different pointer types 
defined such as WGPUAdapter, WGPUDevice, etc. which helps keep the code more readable, but Java does
not support the typedef mechanism for this.

In C++ it is very easy to create and fill a descriptor object:

``` WGPUDeviceDescriptor deviceDesc = {};
	deviceDesc.nextInChain = nullptr;
	deviceDesc.label = "My Device"; // anything works here, that's your call
	deviceDesc.requiredFeatureCount = 0; // we do not require any specific feature
	deviceDesc.requiredLimits = nullptr; // we do not require any specific limit
	deviceDesc.defaultQueue.nextInChain = nullptr;
	deviceDesc.defaultQueue.label = "The default queue";
```
 
In Java, we have to do a bit more work in order to put the data in native memory so that the object can be passed to the driver:

```  
  WGPUDeviceDescriptor deviceDesc = WGPUDeviceDescriptor.createDirect();
  deviceDesc.setNextInChain();
  deviceDesc.setLabel("My Device");
  // etc.
```

The `createDirect()` method is used to create an object in native memory. Access to its members is exclusively via getters and setters.




## Generating the API files

The API files were generated from a C++ header file.  The header file is a simplified version of `webgpu.h`.
Running the `jnrgen` application regenerates those files into `jnrgen\src\generated`. 
(The directory needs to be empty first).  
These files need to be copied across to `java-to-webgpu\src\main\java\com\monstrous\webgpu`.  
This is left as a manual step to avoid accidental overwriting. 

The generator is based on work from Noah Charlton (https://github.com/kgpu/wgpu-java) but was heavily modified.
And when I say modified, I mean hacked with kludge upon kludge.

Future work: fix the generator to accept the original webgpu.h header file.

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


