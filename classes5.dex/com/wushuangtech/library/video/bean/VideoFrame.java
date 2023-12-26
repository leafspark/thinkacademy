package com.wushuangtech.library.video.bean;

import com.wushuangtech.api.ExternalVideoModuleCallback;

public class VideoFrame {
    public byte[] data;
    public int format;
    public ExternalVideoModuleCallback.VideoFrameType frameType;
    public int height;
    public int mRotate;
    public int recvFrameRate;
    public long timeStamp;
    public int width;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoFrame{frameType=");
        sb.append(this.frameType);
        sb.append(", data=");
        byte[] bArr = this.data;
        sb.append(bArr == null ? "null" : Integer.valueOf(bArr.length));
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", rotate=");
        sb.append(this.mRotate);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append('}');
        return sb.toString();
    }
}
