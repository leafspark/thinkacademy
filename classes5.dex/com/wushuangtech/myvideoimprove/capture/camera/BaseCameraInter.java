package com.wushuangtech.myvideoimprove.capture.camera;

import android.graphics.SurfaceTexture;
import com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean;
import com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl;

public interface BaseCameraInter {
    VideoCapCameraConfigureBean initCamera(BaseCameraInterImpl.CameraParams cameraParams);

    boolean isCameraOpened();

    VideoCapCameraConfigureBean openCamera(VideoCapCameraConfigureBean videoCapCameraConfigureBean, SurfaceTexture surfaceTexture);

    void releaseCamera();

    void switchCamera();
}
