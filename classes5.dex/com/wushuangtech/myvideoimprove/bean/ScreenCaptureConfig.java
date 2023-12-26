package com.wushuangtech.myvideoimprove.bean;

import android.content.Intent;
import java.io.File;

public class ScreenCaptureConfig {
    public final int mBitRate;
    public int mBitrateMode;
    public final int mFrameRate;
    public int mHeight;
    public final int mIFrameInterval;
    public Intent mIntent;
    public final File mOutputFile;
    public int mWidth;

    public ScreenCaptureConfig(Intent intent, int i, int i2, int i3, int i4, int i5) {
        this((File) null, intent, i, i2, i3, i4, i5, 1);
    }

    public ScreenCaptureConfig(Intent intent, int i, int i2, int i3, int i4, int i5, int i6) {
        this((File) null, intent, i, i2, i3, i4, i5, i6);
    }

    public ScreenCaptureConfig(File file, Intent intent, int i, int i2, int i3, int i4, int i5) {
        this(file, intent, i, i2, i3, i4, i5, 1);
    }

    private ScreenCaptureConfig(File file, Intent intent, int i, int i2, int i3, int i4, int i5, int i6) {
        this.mOutputFile = file;
        this.mIntent = intent;
        this.mWidth = i;
        this.mHeight = i2;
        this.mBitRate = i3;
        this.mFrameRate = i4;
        this.mIFrameInterval = i5;
        this.mBitrateMode = i6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EncoderConfig: ");
        sb.append(this.mWidth);
        sb.append("x");
        sb.append(this.mHeight);
        sb.append("@ mBitRate : ");
        sb.append(this.mBitRate);
        sb.append(" | mFrameRate : ");
        sb.append(this.mFrameRate);
        sb.append(" | mIFrameInterval : ");
        sb.append(this.mIFrameInterval);
        sb.append(" to '");
        File file = this.mOutputFile;
        sb.append(file == null ? "null" : file.toString());
        return sb.toString();
    }
}
