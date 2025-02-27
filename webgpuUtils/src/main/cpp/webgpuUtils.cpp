/*******************************************************************************
 * Copyright 2025 Monstrous Software
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/    

#define DAWN

#if __cplusplus < 201103L
  #error This library needs at least a C++11 compliant compiler
#endif

#include <stdio.h>
#include <cassert>
#include <iostream>
#include <stdalign.h>

#define LOG(x)

using namespace std;


// Include WebGPU header

#ifdef DAWN
#include "dawn/webgpu.h"
#else
#include "webgpu/webgpu.h"
#endif

#if defined(_WIN32)
#   define EXPORT __declspec(dllexport)
#endif

#define GLFW_EXPOSE_NATIVE_WIN32
#include <GLFW/glfw3.h>
#include <GLFW/glfw3native.h>

#ifdef __cplusplus
extern "C" {
#endif


/**
* Get WGPU Surface for a GLFW window.
*/
EXPORT    WGPUSurface glfwGetWGPUSurface(WGPUInstance instance, void * hwnd){
            LOG( printf("getting surface from GLFW window %p (HWND)\n", hwnd); )
            LOG( printf("instance => %p\n", instance); )
            if(hwnd == nullptr)
                printf("** Window handle (HWND) is NULL!\n");
            HINSTANCE hinstance = GetModuleHandle(NULL);

            WGPUSurfaceDescriptorFromWindowsHWND fromWindowsHWND;
            fromWindowsHWND.chain.next = NULL;
            fromWindowsHWND.chain.sType = WGPUSType_SurfaceDescriptorFromWindowsHWND;
            fromWindowsHWND.hinstance = hinstance;
            fromWindowsHWND.hwnd = hwnd;

            WGPUSurfaceDescriptor surfaceDescriptor;
            surfaceDescriptor.nextInChain = &fromWindowsHWND.chain;
            surfaceDescriptor.label = NULL;

            WGPUSurface s = wgpuInstanceCreateSurface(instance, &surfaceDescriptor);
            LOG( printf("surface => %p\n", s); )
            return s;
    }
#ifdef __cplusplus
} // extern "C"
#endif
