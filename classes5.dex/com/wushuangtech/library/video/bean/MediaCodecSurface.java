package com.wushuangtech.library.video.bean;

import android.view.Surface;
import java.util.UUID;

public class MediaCodecSurface {
    private int mFlag;
    private String mId = UUID.randomUUID().toString();
    private Surface mSurface;

    public MediaCodecSurface(Surface surface, int i) {
        this.mSurface = surface;
        this.mFlag = i;
    }

    public String getId() {
        return this.mId;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public int getFlag() {
        return this.mFlag;
    }

    public void release() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
    }

    public String toString() {
        return "MediaCodecSurface{mId='" + this.mId + '\'' + ", mSurface=" + this.mSurface + ", mFlag=" + this.mFlag + '}';
    }
}
