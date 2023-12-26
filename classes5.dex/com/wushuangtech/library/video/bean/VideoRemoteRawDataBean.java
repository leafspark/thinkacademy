package com.wushuangtech.library.video.bean;

import java.nio.ByteBuffer;

public class VideoRemoteRawDataBean {
    public ByteBuffer mBuffer;
    public byte[] mData;
    public String mDeviceId;
    public int mHeight;
    public boolean mIsKeyFrame;
    public int mLineSizeU;
    public int mLineSizeV;
    public int mLineSizeY;
    public long mPts;
    public int mWidth;

    public VideoRemoteRawDataBean(String str, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, boolean z, long j) {
        this.mDeviceId = str;
        this.mData = null;
        this.mBuffer = byteBuffer;
        this.mWidth = i;
        this.mHeight = i2;
        this.mLineSizeY = i3;
        this.mLineSizeU = i4;
        this.mLineSizeV = i5;
        this.mIsKeyFrame = z;
        this.mPts = j;
    }

    public VideoRemoteRawDataBean(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5, boolean z, long j) {
        this.mDeviceId = str;
        this.mBuffer = null;
        this.mData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mLineSizeY = i3;
        this.mLineSizeU = i4;
        this.mLineSizeV = i5;
        this.mIsKeyFrame = z;
        this.mPts = j;
    }

    public String toString() {
        return "VideoRemoteRawDataBean{mDeviceId='" + this.mDeviceId + '\'' + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + '}';
    }
}
