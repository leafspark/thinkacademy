package com.wushuangtech.wstechapi;

import com.wushuangtech.wstechapi.bean.VideoBitrateMode;

public interface OmniRtcEngineExtend {
    int forceVideoDecodeSoftware(boolean z);

    int forceVideoEncodeSoftware(boolean z);

    int muteRtmpPublishAudioStream(boolean z);

    boolean resetRecordScreenSize(boolean z);

    int setExternalVideoProfile(int i, int i2, int i3, int i4);

    int setHardwareDecoderSize(int i);

    int setVideoEncoderBitrateMode(VideoBitrateMode videoBitrateMode);
}
