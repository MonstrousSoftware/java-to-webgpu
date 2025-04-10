package com.monstrous.utils;

import jnr.ffi.Pointer;


/**
 * A representation in Java of the native C interface for wgpuUtils.dll.
 */
public interface WebGPUUtils_JNI {

    /**
     * Bridge between GLFW and WebGPU: Provides a Surface corresponding to a GLFW window.
     */
    Pointer glfwGetWGPUSurface( Pointer instance, long HWND);

    /**
     * Image file handling
     */
    Pointer gdx2d_load ( Pointer buffer,  int len);
    void gdx2d_free( Pointer pixmapInfo);

    /** write an image to a PNG file.
     *
     * @param filename
     * @param width
     * @param height
     * @param numComponents     number of channels, e.g. 4 for an RGBA8Unorm format
     * @param data              Pointer to the pixel data
     * @param stride_in_bytes   bytes per row, normally numComponents * width
     * @return  1 for success, 0 for failure
     */
    int write_png(String filename, int width, int height, int numComponents, Pointer data, int stride_in_bytes);

}