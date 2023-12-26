package com.wushuangtech.myvideoimprove.codec;

import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;
import com.wushuangtech.utils.OmniLog;

public class BaseCodecImpl implements BaseCodec {
    protected CodecLife mCodecLife;
    private final String mLogWatcher;
    protected OnCodecEventCallBack mOnCodecEventCallBack;

    public interface OnCodecEventCallBack {
        void onEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j);

        void onRestartCodec();
    }

    public BaseCodecImpl(String str) {
        this.mLogWatcher = str;
    }

    public void setOnCodecRestartCallBack(OnCodecEventCallBack onCodecEventCallBack) {
        this.mOnCodecEventCallBack = onCodecEventCallBack;
    }

    public boolean open(CodecConfigureBean codecConfigureBean) {
        return this.mCodecLife.open(codecConfigureBean);
    }

    public int restart(CodecConfigureBean codecConfigureBean) {
        return this.mCodecLife.restart(codecConfigureBean);
    }

    public boolean pause() {
        return this.mCodecLife.pause();
    }

    public boolean resume() {
        return this.mCodecLife.resume();
    }

    public boolean release() {
        return this.mCodecLife.release();
    }

    /* access modifiers changed from: protected */
    public void log(String str, String str2) {
        OmniLog.i(this.mLogWatcher, str, str2);
    }

    /* access modifiers changed from: protected */
    public void logW(String str, String str2) {
        OmniLog.w(this.mLogWatcher, str, str2);
    }

    /* access modifiers changed from: protected */
    public void logE(String str, String str2) {
        OmniLog.e(this.mLogWatcher, str, str2);
    }
}
