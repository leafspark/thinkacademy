package com.wushuangtech.myvideoimprove.capture.camera;

import com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl;

public interface CameraOptionInter {
    boolean cameraInspectFunction(int i);

    int getCameraFps();

    int getCameraId();

    int getCameraMaxZoom();

    BaseCameraInterImpl.CameraPreSize getCameraPreSize();

    int getCameraRotate();

    void resetStatus();

    boolean setCameraOrientation(int i);

    boolean setCameraParams(int i, int i2, int i3);

    boolean setCameraPreviewFps(int i);

    void setCameraTorch(boolean z);

    void setCameraZoom(int i);

    boolean startPreview();

    boolean stopPreview();
}
