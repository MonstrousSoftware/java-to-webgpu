package com.monstrous.webgpu;


import jnr.ffi.Pointer;
import jnr.ffi.annotations.Delegate;

public interface WGPUBufferMapCallback {

    @Delegate
    void invoke(WGPUBufferMapAsyncStatus status, Pointer userdata);
}
