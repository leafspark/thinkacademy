package com.wushuangtech.api;

public interface ExternalRtmpPublishModuleCallback {

    public enum RtmpErrorType {
        RtmpErrorType_InitError,
        RtmpErrorType_OpenError,
        RtmpErrorType_AudioNoBuf,
        RtmpErrorType_VideoNoBuf,
        RtmpErrorType_LinkFailed,
        RtmpErrorType_LinkSuccessed
    }

    void receiveRtmpStatus(RtmpErrorType rtmpErrorType);
}
