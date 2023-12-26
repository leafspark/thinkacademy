package com.wushuangtech.library.video.bean;

public class HandleDataOutputBean {
    private byte[] mData;
    private boolean mDrop;
    private int mHeight;
    private int mRotate;
    private long mTimestamp;
    private boolean mUsed = true;
    private int mWidth;

    public void setUsed(boolean z) {
        this.mUsed = z;
    }

    public boolean isUsed() {
        return this.mUsed;
    }

    public boolean putData(byte[] bArr, int i, int i2, int i3, long j, boolean z) {
        this.mData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mUsed = false;
        this.mRotate = i3;
        this.mTimestamp = j;
        this.mDrop = z;
        return true;
    }

    public byte[] array() {
        return this.mData;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getRotate() {
        return this.mRotate;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public boolean isDrop() {
        return this.mDrop;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HandleDataOutputBean{mData=");
        byte[] bArr = this.mData;
        sb.append(bArr == null ? "null" : Integer.valueOf(bArr.length));
        sb.append(", mWidth=");
        sb.append(this.mWidth);
        sb.append(", mHeight=");
        sb.append(this.mHeight);
        sb.append(", mRotate=");
        sb.append(this.mRotate);
        sb.append(", mTimestamp=");
        sb.append(this.mTimestamp);
        sb.append(", mUsed=");
        sb.append(this.mUsed);
        sb.append(", mDrop=");
        sb.append(this.mDrop);
        sb.append('}');
        return sb.toString();
    }
}
