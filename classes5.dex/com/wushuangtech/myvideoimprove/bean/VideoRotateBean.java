package com.wushuangtech.myvideoimprove.bean;

public class VideoRotateBean {
    public int mEncodeHeight;
    public int mEncodeWidth;
    public int mRotation;

    public VideoRotateBean(int i) {
        this.mRotation = i;
    }

    public VideoRotateBean(int i, int i2, int i3) {
        this.mRotation = i;
        this.mEncodeWidth = i2;
        this.mEncodeHeight = i3;
    }
}
