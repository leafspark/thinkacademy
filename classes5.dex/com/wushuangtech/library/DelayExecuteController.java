package com.wushuangtech.library;

import com.wushuangtech.utils.OmniLog;

public class DelayExecuteController<T> {
    private T mCacheT;
    private final T mDefT;
    private final Object mLock = new Object();
    private final OnDelayExecuteControllerCallBack<T> mOnDelayExecuteControllerCallBack;
    private boolean mStarted;

    public interface OnDelayExecuteControllerCallBack<T> {
        void execute(T t);
    }

    public DelayExecuteController(OnDelayExecuteControllerCallBack<T> onDelayExecuteControllerCallBack, T t) {
        this.mOnDelayExecuteControllerCallBack = onDelayExecuteControllerCallBack;
        this.mDefT = t;
        this.mCacheT = t;
    }

    public void startExecute() {
        synchronized (this.mLock) {
            testLog("startExecute -> start? " + this.mStarted + " | cache : " + this.mCacheT);
            this.mOnDelayExecuteControllerCallBack.execute(this.mCacheT);
            this.mCacheT = null;
            this.mStarted = true;
        }
    }

    public void invoked(T t) {
        synchronized (this.mLock) {
            testLog("invoked -> start? " + this.mStarted + " | cache : " + this.mCacheT + " | value : " + t);
            if (!this.mStarted) {
                this.mCacheT = t;
            } else {
                this.mOnDelayExecuteControllerCallBack.execute(t);
            }
        }
    }

    public void reset() {
        synchronized (this.mLock) {
            testLog("reset -> start? " + this.mStarted + " | cache : " + this.mCacheT);
            this.mStarted = false;
            this.mCacheT = this.mDefT;
        }
    }

    private void testLog(String str) {
        OmniLog.debugD("VOLUME_WATCH", str);
    }
}
