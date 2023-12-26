package com.wushuangtech.api;

import com.wushuangtech.api.ExternalVideoModuleCallback;

public interface ExternalVideoDecoderPluginCallback {
    void receiveSeiDataDecoderPlugin(byte[] bArr, long j, String str);

    void receiveVideoDataDecoderPlugin(byte[] bArr, String str, long j, int i, int i2, ExternalVideoModuleCallback.VideoFrameType videoFrameType);
}
