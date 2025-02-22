package com.monstrous.webgpu;

//typedef void (*WGPUQueueWorkDoneCallback)(WGPUQueueWorkDoneStatus status, void * userdata) WGPU_FUNCTION_ATTRIBUTE;

import jnr.ffi.Pointer;
import jnr.ffi.annotations.Delegate;

public interface WGPUErrorCallback {

    @Delegate
    void invoke(WGPUErrorType type, String message, Pointer userdata);
}
