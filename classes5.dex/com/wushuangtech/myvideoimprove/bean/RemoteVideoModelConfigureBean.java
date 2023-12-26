package com.wushuangtech.myvideoimprove.bean;

import com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;

public class RemoteVideoModelConfigureBean extends BaseVideoModelConfigureBean {
    public String mChannelName;
    public String mDeviceId;
    public int mHeight;
    public int mMirrorMode;
    public RemoteVideoRenderer mRemoteVideoRenderer;
    public int mRenderMode;
    public long mUid;
    public VideoRenderView mVideoRenderView;
    public int mWidth;
    public Object mWindow;

    public String toString() {
        return "RemoteVideoModelConfigureBean{mChannelName=" + this.mChannelName + "mUid=" + this.mUid + ", mDeviceId='" + this.mDeviceId + '\'' + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mWindow=" + this.mWindow + ", mVideoRenderView=" + this.mVideoRenderView + '}';
    }
}
