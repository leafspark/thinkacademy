package com.wushuangtech.library;

public class DelayExecuteMultiController {
    private Object mCacheObj;
    private final Object mLock = new Object();
    private final OnDelayExecuteMultiControllerCallBack mOnDelayExecuteMultiControllerCallBack;
    private boolean mStarted;

    public interface OnDelayExecuteMultiControllerCallBack {
        void execute(int i, Object obj);
    }

    public DelayExecuteMultiController(OnDelayExecuteMultiControllerCallBack onDelayExecuteMultiControllerCallBack) {
        this.mOnDelayExecuteMultiControllerCallBack = onDelayExecuteMultiControllerCallBack;
    }

    public void startExecute(int i) {
        synchronized (this.mLock) {
            this.mOnDelayExecuteMultiControllerCallBack.execute(i, this.mCacheObj);
            this.mCacheObj = null;
            this.mStarted = true;
        }
    }

    public void invoked(int i, Object obj) {
        synchronized (this.mLock) {
            if (!this.mStarted) {
                this.mCacheObj = obj;
            } else {
                this.mOnDelayExecuteMultiControllerCallBack.execute(i, obj);
            }
        }
    }

    public void reset() {
        synchronized (this.mLock) {
            this.mStarted = false;
        }
    }
}
