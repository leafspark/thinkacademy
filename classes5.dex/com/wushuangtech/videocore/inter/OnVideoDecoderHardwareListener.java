package com.wushuangtech.videocore.inter;

import com.wushuangtech.videocore.bean.VideoDecoderHardwareBean;

public interface OnVideoDecoderHardwareListener {
    void hardwareDecoderCreated(VideoDecoderHardwareBean videoDecoderHardwareBean);

    void hardwareDecoderDestory(VideoDecoderHardwareBean videoDecoderHardwareBean);

    void hardwareDecoderStopFailed(VideoDecoderHardwareBean videoDecoderHardwareBean);
}
