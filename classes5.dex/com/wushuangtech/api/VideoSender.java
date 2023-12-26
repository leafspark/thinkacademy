package com.wushuangtech.api;

import com.wushuangtech.api.ExternalVideoModuleCallback;
import java.util.ArrayList;

public interface VideoSender {
    void pushDualEncodedVideoData(ArrayList<byte[]> arrayList, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j);

    void pushDualEncodedVideoData(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j);

    void pushEncodedVideoData(ArrayList<byte[]> arrayList, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j);

    void pushEncodedVideoData(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j);
}
