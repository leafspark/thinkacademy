package com.wushuangtech.myvideoimprove.capture;

import android.content.Context;
import com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean;
import com.wushuangtech.myvideoimprove.bean.VideoCapConfigureBean;
import com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl;
import com.wushuangtech.myvideoimprove.capture.camera.CameraImpl;
import com.wushuangtech.myvideoimprove.capture.camera.CameraOptionInter;
import com.wushuangtech.utils.OmniLog;

public class VideoCapCameraInterImpl implements VideoCap, CameraOptionInter, BaseCameraInterImpl.OnCameraErrorCallBack, BaseCameraInterImpl.OnCameraPreviewFrameCallBack {
    private static final String TAG = "VideoCapCameraInterImpl";
    private final OnCameraCaptureCallBack mOnCameraCaptureCallBack;
    private final BaseCameraInterImpl myCameraManager;

    public interface OnCameraCaptureCallBack {
        void onCameraError(int i);

        void onCameraPreviewFrameCallBack(VideoCapFrame videoCapFrame);
    }

    public void setContext(Context context) {
    }

    public VideoCapCameraInterImpl(OnCameraCaptureCallBack onCameraCaptureCallBack) {
        OmniLog.i(TAG, "VideoCapCameraInterImpl onCameraCaptureCallBack:" + onCameraCaptureCallBack);
        this.mOnCameraCaptureCallBack = onCameraCaptureCallBack;
        CameraImpl cameraImpl = new CameraImpl();
        this.myCameraManager = cameraImpl;
        cameraImpl.setOnCameraErrorCallBack(this);
        cameraImpl.setOnCameraPreviewFrameCallBack(this);
    }

    public int getCameraId() {
        return this.myCameraManager.getCameraId();
    }

    public boolean cameraInspectFunction(int i) {
        return this.myCameraManager.cameraInspectFunction(i);
    }

    public boolean setCameraOrientation(int i) {
        return this.myCameraManager.setCameraOrientation(i);
    }

    public boolean setCameraPreviewFps(int i) {
        return this.myCameraManager.setCameraPreviewFps(i);
    }

    public boolean setCameraParams(int i, int i2, int i3) {
        return this.myCameraManager.setCameraParams(i, i2, i3);
    }

    public BaseCameraInterImpl.CameraPreSize getCameraPreSize() {
        return this.myCameraManager.getCameraPreSize();
    }

    public int getCameraFps() {
        return this.myCameraManager.getCameraFps();
    }

    public int getCameraRotate() {
        return this.myCameraManager.getCameraRotate();
    }

    public int getCameraMaxZoom() {
        return this.myCameraManager.getCameraMaxZoom();
    }

    public boolean startPreview() {
        return this.myCameraManager.startPreview();
    }

    public boolean stopPreview() {
        return this.myCameraManager.stopPreview();
    }

    public VideoCapConfigureBean initVideoCapture() {
        return this.myCameraManager.initCamera();
    }

    public VideoCapConfigureBean startVideoCapture(VideoCapConfigureBean videoCapConfigureBean) {
        return this.myCameraManager.startCameraCap((VideoCapCameraConfigureBean) videoCapConfigureBean);
    }

    public void stopVideoCapture() {
        this.myCameraManager.releaseCamera();
    }

    public void resetStatus() {
        this.myCameraManager.resetStatus();
    }

    public boolean isVideoCaping() {
        return this.myCameraManager.isCameraOpened();
    }

    public int[] getVideoCapSize() {
        return this.myCameraManager.getCameraExpectSize();
    }

    public int getVideoCapFps() {
        return this.myCameraManager.getCameraFps();
    }

    public void onError(int i) {
        this.mOnCameraCaptureCallBack.onCameraError(i);
    }

    public void onPreviewFrame(VideoCapFrame videoCapFrame) {
        if (videoCapFrame != null) {
            this.mOnCameraCaptureCallBack.onCameraPreviewFrameCallBack(videoCapFrame);
        }
    }

    public void setCameraZoom(int i) {
        this.myCameraManager.setCameraZoom(i);
    }

    public void setCameraTorch(boolean z) {
        this.myCameraManager.setCameraTorch(z);
    }

    public void cameraSwitch() {
        this.myCameraManager.switchCamera();
    }
}
