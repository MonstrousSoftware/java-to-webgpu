package com.monstrous.webgpu;


/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
import jnr.ffi.Pointer;
import jnr.ffi.types.*;
import jnr.ffi.annotations.Delegate;

public interface WGPURequestAdapterCallback2 {

	@Delegate
	void invoke(WGPURequestAdapterStatus status, Pointer adapter, String message, Pointer userdata1, Pointer userdata2);
}
