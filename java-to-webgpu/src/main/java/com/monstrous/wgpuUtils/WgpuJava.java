package com.monstrous.wgpuUtils;


import jnr.ffi.Pointer;
import jnr.ffi.Runtime;

import java.nio.ByteBuffer;

public class WgpuJava {

    /**
     * The function bindings generated by jnr-ffi
     */
    //public static WgpuJNI wgpuNative;
    private static Runtime runtime;

    /**
     * Loads the given file and creates the bindings in {@link WgpuJNI}. It will then setup the log with the
     * default log callback, and a log level of WARN.
     */
//    public static void init(File nativeFile) {
//        var loader = LibraryLoader.create(WgpuJNI.class);
//
//        wgpuNative = loader.load(nativeFile.getAbsolutePath());
//        runtime = Runtime.getRuntime(wgpuNative);
//
//        wgpuNative.wgpu_set_log_callback(LogCallback.createDefault());
//        wgpuNative.wgpu_set_log_level(WgpuLogLevel.WARN);
//    }



    /**
     * Sets the log level for the Rust wgpu library.
     * @param level the minimum level to log
     */
//    public static void setWgpuLogLevel(WgpuLogLevel level){
//        wgpuNative.wgpu_set_log_level(level);
//    }

    /**
     * returns a string of the Wgpu-native library version in the format
     * "major.minor.patch"
     */
//    public static String getWgpuNativeVersion(){
//        int version = wgpuNative.wgpu_get_version();
//        int major = (version >> 16) & 0xFF;
//        int minor = (version >> 8) & 0xFF;
//        int patch = version & 0xff;
//
//        return String.format("%d.%d.%d", major, minor, patch);
//    }

    /**
     * Wraps a series of long values in a pointer in direct memory.
     */
    public static Pointer createLongArrayPointer(long[] longs){
        Pointer ptr = WgpuJava.createDirectPointer(longs.length * Long.BYTES);

        for(int i = 0; i < longs.length; i++){
            ptr.putLongLong(i * Long.BYTES, longs[i]);
        }

        return ptr;
    }

    /**
     * Wraps a series of integer values in a pointer in direct memory.
     */
    public static Pointer createIntegerArrayPointer(int[] ints){
        Pointer ptr = WgpuJava.createDirectPointer(ints.length * Integer.BYTES);

        for(int i = 0; i < ints.length; i++){
            ptr.putInt(i * Integer.BYTES, ints[i]);
        }

        return ptr;
    }

    /**
     * Wraps a series of float values in a pointer in direct memory.
     */
    public static Pointer createFloatArrayPointer(float[] floats){
        Pointer ptr = WgpuJava.createDirectPointer(floats.length * Float.BYTES);

        for(int i = 0; i < floats.length; i++){
            ptr.putFloat(i * Float.BYTES, floats[i]);   // MM said Integer
        }

        return ptr;
    }

    /**
     * Copies the given data into a DirectByteBuffer and
     * then returns the buffer's pointer
     *
     * @see ByteBuffer#allocateDirect(int)
     */
    public static Pointer createByteArrayPointer(byte[] bytes){
        var dataBuffer = ByteBuffer.allocateDirect(bytes.length).put(bytes);
        dataBuffer.rewind();

        return WgpuJava.createByteBufferPointer(dataBuffer);
    }

    /**
     * returns a null pointer
     */
    public static Pointer createNullPointer(){
        return Pointer.wrap(runtime, 0x00);
    }

    /**
     * returns the pointer to the provided byte buffer.
     *
     * @throws IllegalArgumentException if buffer isn't using direct memory, or buffer.position != 0
     */
    public static Pointer createByteBufferPointer(ByteBuffer buffer) {
        if(!buffer.isDirect()){
            throw new IllegalArgumentException("Buffer must be direct!");
        }

        if(buffer.position() > 0){
            throw new IllegalArgumentException("Buffer should have a position of zero!");
        }

        return Pointer.wrap(runtime, buffer);
    }

    /**
     * a pointer in direct memory with the given size
     *
     * @param size (in bytes) space allocated for the pointer
     */
    public static Pointer createDirectPointer(int size) {
        return runtime.getMemoryManager().allocateDirect(size);
    }

    /**
     * Used for unit testing only!
     */
    public static void setRuntime(Runtime runtime) {
        WgpuJava.runtime = runtime;
    }

    public static Runtime getRuntime() {
        return runtime;
    }
}
