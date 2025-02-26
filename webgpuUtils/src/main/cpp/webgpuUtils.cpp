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
 * Utility function to get a WebGPU adapter, so that
 *     WGPUAdapter adapter = requestAdapterSync(options);
 * is roughly equivalent to
 *     const adapter = await navigator.gpu.requestAdapter(options);
 */
EXPORT WGPUAdapter RequestAdapterSync(WGPUInstance instance, WGPURequestAdapterOptions const * options) {

//    WGPURequestAdapterOptions theOptions, *options;
//    options = &theOptions;
//    theOptions.nextInChain = nullptr;
//    theOptions.compatibleSurface = nullptr;
//    theOptions.powerPreference = WGPUPowerPreference_Undefined;
//    theOptions.backendType = WGPUBackendType_D3D12; // WGPUBackendType_D3D12; //WGPUBackendType_Vulkan;
//    theOptions.forceFallbackAdapter = false;
//    theOptions.compatibilityMode = false;

    // A simple structure holding the local information shared with the
    // onAdapterRequestEnded callback.
    struct UserData {
        WGPUAdapter adapter = nullptr;
        bool requestEnded = false;
    };
    UserData userData;
    LOG( printf("RequestAdapterSync\n"); )
    LOG( printf("instance %p\n", instance); )

    // Callback called by wgpuInstanceRequestAdapter when the request returns
    // This is a C++ lambda function, but could be any function defined in the
    // global scope. It must be non-capturing (the brackets [] are empty) so
    // that it behaves like a regular C function pointer, which is what
    // wgpuInstanceRequestAdapter expects (WebGPU being a C API). The workaround
    // is to convey what we want to capture through the pUserData pointer,
    // provided as the last argument of wgpuInstanceRequestAdapter and received
    // by the callback as its last argument.
    auto onAdapterRequestEnded = [](WGPURequestAdapterStatus status, WGPUAdapter adapter, char const * message, void * pUserData) {
        //std::cout << "onAdapterRequestEnded : " << status << std::endl;
        UserData& userData = *reinterpret_cast<UserData*>(pUserData);
        if (status == WGPURequestAdapterStatus_Success) {
            userData.adapter = adapter;
        } else {
            std::cout << "Could not get WebGPU adapter: " << message << std::endl;
        }
        userData.requestEnded = true;
    };

//    printf("backend: %d\n", options->backendType);
//    printf("power: %d\n", options->powerPreference);
//    printf("fallback: %d\n", options->forceFallbackAdapter);
//    printf("surface: %p\n", options->compatibleSurface);

    LOG( printf("wgpuInstanceRequestAdapter\n"); )

    // Call to the WebGPU request adapter procedure
    wgpuInstanceRequestAdapter(
        instance /* equivalent of navigator.gpu */,
        options,
        onAdapterRequestEnded,
        (void*)&userData
    );

    // We wait until userData.requestEnded gets true
    // [...] Wait for request to end

    LOG( printf("requested ended? %d\n", (int)userData.requestEnded); )
    LOG( printf("requested adapter %p\n", userData.adapter); )

    assert(userData.requestEnded);
    return userData.adapter;
}

/**
 * Utility function to get a WebGPU device, so that
 *     WGPUAdapter device = requestDeviceSync(adapter, options);
 * is roughly equivalent to
 *     const device = await adapter.requestDevice(descriptor);
 * It is very similar to requestAdapter
 */
EXPORT WGPUDevice RequestDeviceSync(WGPUAdapter adapter, WGPUDeviceDescriptor const * descriptor) {
    struct UserData {
        WGPUDevice device = nullptr;
        bool requestEnded = false;
    };
    UserData userData;


    auto onDeviceRequestEnded = [](WGPURequestDeviceStatus status, WGPUDevice device, char const * message, void * pUserData) {
        UserData& userData = *reinterpret_cast<UserData*>(pUserData);
        if (status == WGPURequestDeviceStatus_Success) {
            userData.device = device;
        } else {
            std::cout << "Could not get WebGPU device: " << message << std::endl;
        }
        userData.requestEnded = true;
    };

    wgpuAdapterRequestDevice(
        adapter,
        descriptor,
        onDeviceRequestEnded,
        (void*)&userData
    );

    assert(userData.requestEnded);
    return userData.device;
}

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
