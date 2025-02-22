# Calling WebGPU from Java

Trying to build a Java wrapper for WebGPU.
October 2024.

## Modules
- ```assets```  Assets folder used by tests
- ```docs```  Some documentation
- ```libGPU``` Java library to call WebGPU
- ```tests```   Tests and samples of using LibGPU
- ```triangle```    Sample C++ app to render a triangle using webgpu. For reference.
- ```wrapper``` C++ code of wrapper.dll providing native functions

## Switching between Native WGPU and DAWN
This turned out to be very easy. Just drop the DAWN dll to be linked by the C wrapper and use the header file from Dawn (which 
seems very similar).  A preprocessor #define selects which backend to use.

Use compileDawn.bat to compile the wrapper with Dawn or compile.bat for the Rust based dll.

The advantage of Dawn is that it gives much better error messages.  Also the source code is online, so you can look at the code which 
warns of an error to better understand it. 

## Using HWND
There is some interaction between GLFW and WebGPU in order to get a surface corresponding to the window created by GLFW.
Elie Michel the following function for the conversion.
```/**
 * Get a WGPUSurface from a GLFW window.
 */
WGPUSurface glfwGetWGPUSurface(WGPUInstance instance, GLFWwindow* window);
```

This didn't really work from the Java layer by regarding HWND as a pointer.  It is better to regard it as an integer, get the HWND
for the GLFW Window at Java level and pass that to a C util function to get a surface.



## GLTF support

We can load and display GLTF models now.
Not supported: skins, animation, camera.
GLTF Separate and GLB formats are supported, not GTLF embedded.
Normal maps and Emissive maps are supported.
