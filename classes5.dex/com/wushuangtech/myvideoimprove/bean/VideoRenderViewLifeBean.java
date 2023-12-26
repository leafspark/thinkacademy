package com.wushuangtech.myvideoimprove.bean;

public class VideoRenderViewLifeBean {
    public String mDeviceId;
    public int mHeight;
    public Object mRenderView;
    public Object mSurface;
    public int mWidth;

    public String toString() {
        return "VideoRenderViewLifeBean{mDeviceId='" + this.mDeviceId + '\'' + ", mRenderView=" + this.mRenderView + ", mSurface=" + this.mSurface + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + '}';
    }
}
