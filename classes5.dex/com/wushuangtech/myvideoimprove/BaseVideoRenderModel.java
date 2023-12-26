package com.wushuangtech.myvideoimprove;

import android.content.Context;
import com.wushuangtech.myvideoimprove.bean.BaseVideoModelConfigureBean;
import com.wushuangtech.utils.OmniLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BaseVideoRenderModel {
    Context mContext;
    final Lock mLock = new ReentrantLock();
    volatile boolean mModelInited;
    volatile boolean mStartRendered;
    String mTag;
    String mWatcher;

    public abstract boolean createVideoRenderer(BaseVideoModelConfigureBean baseVideoModelConfigureBean);

    public abstract void destroyVideoRenderer(BaseVideoModelConfigureBean baseVideoModelConfigureBean);

    public abstract boolean startVideoRender(BaseVideoModelConfigureBean baseVideoModelConfigureBean);

    public abstract void stopVideoRender();

    public BaseVideoRenderModel(String str, String str2) {
        this.mTag = str2;
        this.mWatcher = str;
    }

    /* access modifiers changed from: package-private */
    public boolean checkModelStatus() {
        this.mLock.lock();
        try {
            return !this.mModelInited;
        } finally {
            this.mLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void logI(String str) {
        OmniLog.i(this.mWatcher, this.mTag, str);
    }

    /* access modifiers changed from: package-private */
    public void logE(String str) {
        OmniLog.e(this.mWatcher, this.mTag, str);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }
}
