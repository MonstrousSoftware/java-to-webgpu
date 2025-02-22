package com.monstrous.webgpu;

//typedef struct WGPUSupportedFeatures {
//    WGPUChainedStructOut * nextInChain;
//    size_t featureCount;
//    WGPUFeatureName const * features;
//} WGPUSupportedFeatures WGPU_STRUCTURE_ATTRIBUTE;

import com.monstrous.wgpuUtils.WgpuJavaStruct;

public class WGPUSupportedFeatures extends WgpuJavaStruct {
    public final Pointer nextInChain = new Pointer();
    public final size_t featureCount = new size_t();
    public final Pointer features = new Pointer();        // todo map to array?
}
