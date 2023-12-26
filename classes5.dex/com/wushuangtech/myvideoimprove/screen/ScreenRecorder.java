package com.wushuangtech.myvideoimprove.screen;

import android.app.Activity;
import com.wushuangtech.myvideoimprove.bean.ScreenCaptureConfig;
import com.wushuangtech.myvideoimprove.screen.ScreenCapturerController;

public class ScreenRecorder implements ScreenCapturer, ScreenCapturerController.OnScreenCapturerControllerCallBack {
    private static final String TAG = "ScreenCapturer";
    private ScreenCapturerController mController;
    private ScreenCodec mScreenCodec;
    private ScreenOpenGLRender mScreenOpenGLRender;

    public boolean executeStopCapturing() {
        return false;
    }

    public boolean executeUninit() {
        return false;
    }

    public ScreenRecorder(Activity activity) {
        this.mController = new ScreenCapturerController(this, activity);
    }

    public boolean requestPermission() {
        return this.mController.requestPermission();
    }

    public boolean init() {
        return this.mController.init();
    }

    public void unInit() {
        this.mController.unInit();
    }

    public boolean startCapturing(ScreenCaptureConfig screenCaptureConfig) {
        return this.mController.startCapturing(screenCaptureConfig);
    }

    public void stopCapturing() {
        this.mController.stopCapturing();
    }

    public boolean executeInit() {
        ScreenOpenGLRender screenOpenGLRender = new ScreenOpenGLRender();
        this.mScreenOpenGLRender = screenOpenGLRender;
        screenOpenGLRender.init();
        ScreenCodec screenCodec = new ScreenCodec(this.mScreenOpenGLRender);
        this.mScreenCodec = screenCodec;
        screenCodec.init();
        return true;
    }

    public boolean executeStartCapturing(ScreenCaptureConfig screenCaptureConfig) {
        this.mScreenOpenGLRender.setParams(screenCaptureConfig);
        this.mScreenCodec.setParams(screenCaptureConfig);
        this.mScreenOpenGLRender.startRending();
        this.mScreenCodec.startEncode();
        return false;
    }
}
