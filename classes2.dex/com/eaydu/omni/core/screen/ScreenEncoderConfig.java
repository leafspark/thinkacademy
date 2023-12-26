package com.eaydu.omni.core.screen;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.linkedin.android.litr.utils.CodecUtils;
import java.io.File;

public class ScreenEncoderConfig {
    final int mBitRate;
    int mBitrateMode;
    final float mBottomCropped;
    EGLContext mEglContext;
    final int mFrameRate;
    int mHeight;
    final int mIFrameInterval;
    final String mMinType;
    final File mOutputFile;
    final float mTopCropped;
    int mWidth;

    public ScreenEncoderConfig(File file, int i, int i2, int i3, int i4, int i5) {
        this(file, i, i2, 0.0f, 0.0f, i3, i4, i5, CodecUtils.MIME_TYPE_VIDEO_AVC, EGL14.eglGetCurrentContext(), 1);
    }

    public ScreenEncoderConfig(File file, int i, int i2, int i3, int i4, int i5, int i6) {
        this(file, i, i2, 0.0f, 0.0f, i3, i4, i5, CodecUtils.MIME_TYPE_VIDEO_AVC, EGL14.eglGetCurrentContext(), i6);
    }

    private ScreenEncoderConfig(File file, int i, int i2, float f, float f2, int i3, int i4, int i5, String str, EGLContext eGLContext, int i6) {
        this.mOutputFile = file;
        this.mWidth = i;
        this.mHeight = i2;
        this.mTopCropped = f;
        this.mBottomCropped = f2;
        this.mBitRate = i3;
        this.mFrameRate = i4;
        this.mIFrameInterval = i5;
        this.mMinType = str;
        this.mEglContext = eGLContext;
        this.mBitrateMode = i6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EncoderConfig: ");
        sb.append(this.mWidth);
        sb.append("x");
        sb.append(this.mHeight);
        sb.append(", Crop with: ");
        sb.append(this.mTopCropped);
        sb.append(" and ");
        sb.append(this.mBottomCropped);
        sb.append("@ mBitRate : ");
        sb.append(this.mBitRate);
        sb.append(" | mFrameRate : ");
        sb.append(this.mFrameRate);
        sb.append(" | mIFrameInterval : ");
        sb.append(this.mIFrameInterval);
        sb.append(" | mMinType : ");
        sb.append(this.mMinType);
        sb.append(" to '");
        File file = this.mOutputFile;
        sb.append(file == null ? "null" : file.toString());
        sb.append("' ctxt=");
        sb.append(this.mEglContext);
        return sb.toString();
    }
}
