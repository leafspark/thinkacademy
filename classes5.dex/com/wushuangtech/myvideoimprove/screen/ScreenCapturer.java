package com.wushuangtech.myvideoimprove.screen;

import com.wushuangtech.myvideoimprove.bean.ScreenCaptureConfig;

public interface ScreenCapturer {
    boolean init();

    boolean requestPermission();

    boolean startCapturing(ScreenCaptureConfig screenCaptureConfig);

    void stopCapturing();

    void unInit();
}
