package com.wushuangtech.myvideoimprove.bean;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;

public class VideoCapCameraConfigureBean extends VideoCapConfigureBean {
    public Camera mCamera;
    public int mCameraOpenResult;
    public SurfaceTexture mCameraTexture;

    public String toString() {
        return "VideoCapCameraConfigureBean{mCamera=" + this.mCamera + ", mCameraTexture=" + this.mCameraTexture + ", mCameraOpenResult=" + this.mCameraOpenResult + ", mPreviewWidth=" + this.mPreviewWidth + ", mPreviewHeight=" + this.mPreviewHeight + '}';
    }
}
