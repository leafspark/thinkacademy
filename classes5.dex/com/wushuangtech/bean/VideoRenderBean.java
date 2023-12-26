package com.wushuangtech.bean;

import com.wushuangtech.inter.OnVideoDecoderSettingSizeToViewCallBack;

public class VideoRenderBean {
    public String mDeviceId;
    public OnVideoDecoderSettingSizeToViewCallBack mOnVideoDecoderSettingSizeToViewCallBack;
    public String mTextureAddress;
    public boolean mTextureSetting;
    public long mUserId;
    public String mVideoDecoderAddress;
    public int mVideoHeight;
    public boolean mVideoSizeSetting;
    public int mVideoWidth;
    public String mViewAddress;

    public String toString() {
        return "VideoRenderBean{mUserId=" + this.mUserId + ", mDeviceId='" + this.mDeviceId + '\'' + ", mViewAddress='" + this.mViewAddress + '\'' + ", mVideoDecoderAddress='" + this.mVideoDecoderAddress + '\'' + ", mVideoSizeSetting=" + this.mVideoSizeSetting + ", mTextureAddress='" + this.mTextureAddress + '\'' + ", mTextureSetting=" + this.mTextureSetting + ", mVideoWidth=" + this.mVideoWidth + ", mVideoHeight=" + this.mVideoHeight + ", mOnVideoDecoderSettingSizeToViewCallBack=" + this.mOnVideoDecoderSettingSizeToViewCallBack + '}';
    }
}
