package com.wushuangtech.library.video.codec;

import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.utils.OmniLog;

public class NativeVideoEncodeHelper {
    private static final int FORMAT_NV21 = 4;
    private static final int X264_CSP_I420 = 1;
    private final String TAG = "LVE - NativeVideoEncodeHelper";
    private int mHeight;
    private OnNativeVideoEncodeCallBack mOnNativeVideoEncodeCallBack;
    private int mWidth;
    private long mlencoder = Initialize(this);

    public interface OnNativeVideoEncodeCallBack {
        void onVideoDataEncoded(Object... objArr);
    }

    private native long Initialize(NativeVideoEncodeHelper nativeVideoEncodeHelper);

    private native void Uninitialize(long j);

    private native void changeSoftEncParams(long j, int i, int i2, int i3, int i4, int i5);

    private native void closeSoftEncoder(long j);

    private native void encodeYuvFrame(long j, byte[] bArr, long j2);

    private native boolean openSoftEncoder(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private native void setBitRate(long j, int i);

    public void setOnNativeVideoEncodeCallBack(OnNativeVideoEncodeCallBack onNativeVideoEncodeCallBack) {
        this.mOnNativeVideoEncodeCallBack = onNativeVideoEncodeCallBack;
    }

    public boolean openSoftEncoder(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i5;
        if (this.mlencoder == 0) {
            return false;
        }
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Open soft encoder params, size : ");
        sb.append(i);
        sb.append(" * ");
        sb.append(i2);
        sb.append(" | fps : ");
        sb.append(i3);
        sb.append("  | ");
        sb.append(i4);
        sb.append(" | ");
        sb.append(i10);
        sb.append(" ｜ bSlicedThreads:");
        int i11 = i6;
        sb.append(i11);
        sb.append(" | ");
        sb.append(Thread.currentThread().getId());
        OmniLog.i(OmniLog.VIDEO_ENCODER_WATCH, str, sb.toString());
        this.mWidth = i7;
        this.mHeight = i8;
        int i12 = i10 * i9;
        return openSoftEncoder(this.mlencoder, i, i2, i3, i4, i12, 1, i11);
    }

    public void closeSoftEncoder() {
        if (this.mlencoder != 0) {
            String str = this.TAG;
            OmniLog.i(OmniLog.VIDEO_ENCODER_WATCH, str, "Close soft encoder... " + Thread.currentThread().getId());
            closeSoftEncoder(this.mlencoder);
        }
    }

    public void setDynamicBitrate(int i) {
        long j = this.mlencoder;
        if (j != 0) {
            setBitRate(j, i);
        }
    }

    public void unInitialize() {
        long j = this.mlencoder;
        if (j != 0) {
            Uninitialize(j);
            this.mlencoder = 0;
        }
    }

    public void encodeYuvFrame(byte[] bArr, long j) {
        encodeYuvFrame(this.mlencoder, bArr, j);
    }

    private void OnYuvFrameEncoded(byte[] bArr, int i, int i2, long j) {
        long j2 = j / 1000;
        byte b = (byte) (bArr[4] & 31);
        int i3 = i - 4;
        Object obj = new byte[i3];
        System.arraycopy(bArr, 4, obj, 0, i3);
        if (b == 7) {
            this.mOnNativeVideoEncodeCallBack.onVideoDataEncoded(obj, Integer.valueOf(ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I.ordinal()), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Long.valueOf(j2));
            return;
        }
        this.mOnNativeVideoEncodeCallBack.onVideoDataEncoded(obj, Integer.valueOf(ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_P.ordinal()), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Long.valueOf(j2));
    }
}
