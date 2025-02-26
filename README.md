# Java-to-WebGPU

Java bindings for WebGPU, allowing you to develop native WebGPU applications from Java.


![screenshot.png](screenshot.png)

## Introduction

This is a library to use native WebGPU libraries using Java.

## How to

Before using any WebGPU functions call:

    WebGPU_JNI webGPU = WguJava.init();

Then use the returned object to call the different WebGPU functions. For example:
```java
    Pointer instance = webGPU.wgpuCreateInstance(null);
    webGPU.wgpuInstanceRelease(instance);
```
Which is the equivalent of the following C++ code:
```C
    // We create the instance using this descriptor
    WGPUInstance instance = wgpuCreateInstance(nullptr);
    wgpuInstanceRelease(instance);
```
At some point you will need some auxiliary functions which are not provided by webgpu itself. For this there is a utility library.
The native utility library can be accessed as follows
```java
    WebGPUUtils_JNI utils = WgpuJava.getUtils();
```
This library provide asynchronous methods to obtain an Adapter and a Device and a method to get a WGPUSurface from a GLFW window.


## Modules
- `java-to-webgpu`  Java library to call WebGPU
- `demo` Sample application
- `jnrgen` Generator to create the Java interface from a C++ header file
- `native-libs` Shared native libraries (DLL files).
- `webgpuUtils`   Source of native utility library (C++)


## Coding caveats
The triangle demo follows the tutorial of WebGPU for C++ by Elie Michel (https://eliemichel.github.io/LearnWebGPU/), which is an excellent tutorial for creating native WebGPU applications (i.e. not in a browser).

Some difference will be apparent between the Java and C++ version.

### Resource handles
Any resource provided by WebGPU, such as an Adapter, a Device, a Texture, a Buffer, 
etcetera, is represented by a Pointer object.  Don't think of this as a pointer that you can dereference in any meaningful way. Just treat it as an identifier that you can pass to other functions.

In the C++ code there are different types defined for the different resources such as WGPUAdapter, WGPUDevice, etc. which helps keep the code more readable, but Java does not support the typedef mechanism for this.  

## Creating structures
Many WebGPU functions rely on a descriptor parameter to pass the relevant options, instead of using individual function parameters. So a regular pattern, you will encounter is to create a descriptor object of some particular type, fill all its content and then pass it to the function you want to call.

In C++ it is very easy to create and fill a descriptor object:

```C
 	// Configure the surface
	WGPUSurfaceConfiguration config = {};
	config.nextInChain = nullptr;
	config.width = 640;
	config.height = 480;
	config.usage = WGPUTextureUsage_RenderAttachment;
	// etc.

	wgpuSurfaceConfigure(surface, &config);
```
 
In Java, we have to do a bit more work in order to put the data in native memory with the proper layout so that the object can be passed to the driver:

```java  
        WGPUSurfaceConfiguration config = WGPUSurfaceConfiguration.createDirect();
        config.setNextInChain();
        config.setWidth(640);
        config.setHeight(480);
	config.setUsage(WGPUTextureUsage.RenderAttachment);
	// etc.	
        webGPU.wgpuSurfaceConfigure(surface, config);
```

The `createDirect()` method is used to create an object in native memory. Access to its members is exclusively via getters and setters.


## Gradle commands
To run the triangle demo: triangle/application/run

To compile the utility library: wgpuUtils/build (requires a C compiler to be installed, e.g. MSVC).

To regenerate the bindings: jnrgen/application/run

## Generating the bindings

The Java bindings were generated automatically from a C++ header file.  This header file is a slightly simplified version of `webgpu.h`, e.g. with some preprocessor commands removed.  The official C++ header file for WebGPU is maintained at [https://github.com/webgpu-native/webgpu-headers](https://github.com/webgpu-native/webgpu-headers).

Running the `jnrgen` application regenerates those files into `jnrgen\src\generated`. 
(The directory needs to be empty first, otherwise you will get an error message).  
These files need to be manually copied across to `java-to-webgpu\src\main\java\com\monstrous\webgpu`.  
This is left as a manual step to avoid accidental overwriting. 

The generator is based on work from Noah Charlton (https://github.com/kgpu/wgpu-java) but was heavily modified.

Future work: fix the generator to accept the original `webgpu.h` header file, so that any official updates can be reflected with minimal effort.


## Under the hood
This library makes use of [JNR-FFI](https://github.com/jnr/jnr-ffi) to call native functions and uses Google's WebGPU implementation ([DAWN](https://dawn.googlesource.com/dawn)) as backend.

The demo makes use of [LWJGL3](https://github.com/LWJGL/lwjgl3) to create a window which in turn uses [GLFW](https://www.glfw.org/).


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


Versioning:
Gradle 8.0
Java version 17
LWJGL version:3.3.4+7
JNR-FFI


