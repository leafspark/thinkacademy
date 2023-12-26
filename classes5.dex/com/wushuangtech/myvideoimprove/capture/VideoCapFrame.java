package com.wushuangtech.myvideoimprove.capture;

public class VideoCapFrame {
    public byte[] mData;
    public boolean mDrop;
    public int mHeight;
    public int mRotate;
    public long mTimestamp;
    public int mWidth;

    public VideoCapFrame(byte[] bArr, int i, int i2, int i3, long j, boolean z) {
        this.mData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotate = i3;
        this.mTimestamp = j;
        this.mDrop = z;
    }

    public String toString() {
        return "VideoCapFrame{, mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mRotate=" + this.mRotate + '}';
    }
}
