package com.wushuangtech.myvideoimprove.codec.encoder;

import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.library.video.MediaCodecHelper;
import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;
import com.wushuangtech.myvideoimprove.codec.BaseCodecImpl;
import com.wushuangtech.myvideoimprove.codec.CodecLife;
import com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener;

public abstract class BaseEncoderImpl extends BaseCodecImpl implements BaseEncoder, OnCodecLifeListener, MediaCodecHelper.OnMediaCodecHelperCallBack {
    static final String ENCODER_TYPE = "video/avc";
    protected static final int OMNI_FORMAT_ABGR = 4;
    protected static final int OMNI_FORMAT_I420 = 5;
    protected static final int OMNI_FORMAT_NV21 = 1;
    protected static final int OMNI_FORMAT_RGBA = 3;
    protected String TAG;
    boolean mDualEncoder;
    int mEncodeHeight;
    int mEncodeWidth;
    boolean mEncoderParamsChanged;
    private long mLastPrintTime;
    int mVideoBitrate;
    int mVideoBitrateMode = 1;
    int mVideoFps;
    int mVideoGop;

    public void destroyEncoder() {
    }

    public void onVideoEncodedDataReport(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, long j) {
    }

    public BaseEncoderImpl(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    public void setTAG(String str) {
        this.TAG = str;
    }

    public void setDualEncoder(boolean z) {
        this.mDualEncoder = z;
    }

    public boolean initEncoder(String str) {
        this.mCodecLife = new CodecLife(str, this);
        return true;
    }

    public void setEncoderParams(int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && i3 != 0) {
            if (this.mVideoFps != i || this.mVideoBitrate != i2 || this.mVideoGop != i3) {
                synchronized (this.mCodecLife.getLock()) {
                    this.mVideoFps = i;
                    this.mVideoBitrate = i2;
                    this.mVideoGop = i3;
                    this.mEncoderParamsChanged = true;
                }
                String str = this.TAG;
                log(str, "Set the parameters of the encoder... fps : " + i + " | bitrate : " + i2 + " | gop : " + i3);
            }
        }
    }

    public void setVideoBitrateMode(int i) {
        this.mVideoBitrateMode = i;
    }

    /* access modifiers changed from: protected */
    public void printSlow(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastPrintTime > 2000) {
            log(str, str2);
            this.mLastPrintTime = currentTimeMillis;
        }
    }

    public CodecConfigureBean onSyncCodecStartConfigure(int i, int i2) {
        this.mEncodeWidth = i;
        this.mEncodeHeight = i2;
        return null;
    }

    public boolean onSyncCodecStartCheck() {
        if (this.mEncoderParamsChanged) {
            return true;
        }
        logE(this.TAG, "Codec config second check failed! size or params not setting or changed!");
        return false;
    }
}
