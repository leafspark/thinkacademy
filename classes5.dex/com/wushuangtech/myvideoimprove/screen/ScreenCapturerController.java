package com.wushuangtech.myvideoimprove.screen;

import android.app.Activity;
import android.os.Build;
import com.wushuangtech.myvideoimprove.bean.ScreenCaptureConfig;
import com.wushuangtech.myvideoimprove.screen.ScreenEnvironment;
import java.lang.ref.WeakReference;

class ScreenCapturerController implements ScreenCapturer, ScreenEnvironment.ScreenEnvironmentCallBack {
    private boolean mCapturing;
    private boolean mCreateDisplayResult;
    private final WeakReference<OnScreenCapturerControllerCallBack> mLifeCallBackRef;
    private ScreenCaptureConfig mScreenCaptureConfig;
    private ScreenEnvironment mScreenEnvironment;
    private volatile boolean mWaitServiceStartedAndExecute;

    public interface OnScreenCapturerControllerCallBack {
        boolean executeInit();

        boolean executeStartCapturing(ScreenCaptureConfig screenCaptureConfig);

        boolean executeStopCapturing();

        boolean executeUninit();
    }

    public void onServiceDisconnected() {
    }

    public ScreenCapturerController(OnScreenCapturerControllerCallBack onScreenCapturerControllerCallBack, Activity activity) {
        this.mLifeCallBackRef = new WeakReference<>(onScreenCapturerControllerCallBack);
        ScreenEnvironment screenEnvironment = new ScreenEnvironment(activity);
        this.mScreenEnvironment = screenEnvironment;
        screenEnvironment.setScreenEnvironmentCallBack(this);
    }

    public boolean requestPermission() {
        if (this.mCapturing) {
            return true;
        }
        return this.mScreenEnvironment.requestPermission();
    }

    public boolean init() {
        OnScreenCapturerControllerCallBack onScreenCapturerControllerCallBack = (OnScreenCapturerControllerCallBack) this.mLifeCallBackRef.get();
        if (onScreenCapturerControllerCallBack == null) {
            return false;
        }
        return onScreenCapturerControllerCallBack.executeInit();
    }

    public void unInit() {
        OnScreenCapturerControllerCallBack onScreenCapturerControllerCallBack = (OnScreenCapturerControllerCallBack) this.mLifeCallBackRef.get();
        if (onScreenCapturerControllerCallBack != null) {
            onScreenCapturerControllerCallBack.executeUninit();
        }
    }

    public boolean startCapturing(ScreenCaptureConfig screenCaptureConfig) {
        boolean z;
        if (this.mCapturing) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            z = handleStartCaptureForQ(screenCaptureConfig);
        } else {
            z = handleStartCapture(screenCaptureConfig);
        }
        if (!z) {
            return false;
        }
        this.mCapturing = true;
        return true;
    }

    public void stopCapturing() {
        OnScreenCapturerControllerCallBack onScreenCapturerControllerCallBack;
        if (this.mCapturing && (onScreenCapturerControllerCallBack = (OnScreenCapturerControllerCallBack) this.mLifeCallBackRef.get()) != null) {
            onScreenCapturerControllerCallBack.executeStopCapturing();
            this.mCapturing = false;
        }
    }

    public void onServiceConnected() {
        int i = this.mScreenCaptureConfig.mWidth;
        int i2 = this.mScreenCaptureConfig.mHeight;
        this.mCreateDisplayResult = this.mScreenEnvironment.createDisplay(this.mScreenCaptureConfig.mIntent, i, i2);
        this.mWaitServiceStartedAndExecute = false;
    }

    private boolean handleStartCaptureForQ(ScreenCaptureConfig screenCaptureConfig) {
        OnScreenCapturerControllerCallBack onScreenCapturerControllerCallBack = (OnScreenCapturerControllerCallBack) this.mLifeCallBackRef.get();
        if (onScreenCapturerControllerCallBack == null) {
            return false;
        }
        this.mScreenCaptureConfig = screenCaptureConfig;
        this.mWaitServiceStartedAndExecute = true;
        if (!this.mScreenEnvironment.startService()) {
            return false;
        }
        if (this.mWaitServiceStartedAndExecute) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!this.mCreateDisplayResult) {
            return false;
        }
        return onScreenCapturerControllerCallBack.executeStartCapturing(screenCaptureConfig);
    }

    private boolean handleStartCapture(ScreenCaptureConfig screenCaptureConfig) {
        OnScreenCapturerControllerCallBack onScreenCapturerControllerCallBack = (OnScreenCapturerControllerCallBack) this.mLifeCallBackRef.get();
        if (onScreenCapturerControllerCallBack == null) {
            return false;
        }
        int i = screenCaptureConfig.mWidth;
        int i2 = screenCaptureConfig.mHeight;
        if (!this.mScreenEnvironment.createDisplay(screenCaptureConfig.mIntent, i, i2)) {
            return false;
        }
        return onScreenCapturerControllerCallBack.executeStartCapturing(screenCaptureConfig);
    }
}
