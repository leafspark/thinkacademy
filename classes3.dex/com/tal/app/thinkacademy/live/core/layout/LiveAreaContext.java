package com.tal.app.thinkacademy.live.core.layout;

import com.tal.app.thinkacademy.live.core.layout.impl.AbsLiveAreaStrategy;

public class LiveAreaContext {
    private static final LiveAreaLayoutParams DEF = new LiveAreaLayoutParams();
    private boolean isPad;
    public LayoutLiveData layoutObserver;
    private LiveAreaType mCurrentType;
    private ILiveAreaStrategy mLiveAreaStrategy;

    public static LiveAreaContext get() {
        return LazyHolder.mInstance;
    }

    private static class LazyHolder {
        /* access modifiers changed from: private */
        public static final LiveAreaContext mInstance = new LiveAreaContext();

        private LazyHolder() {
        }
    }

    private LiveAreaContext() {
        this.layoutObserver = new LayoutLiveData();
        this.isPad = false;
    }

    public void setupStrategy(AbsLiveAreaStrategy absLiveAreaStrategy) {
        this.mLiveAreaStrategy = absLiveAreaStrategy;
        this.isPad = absLiveAreaStrategy.isPad;
        absLiveAreaStrategy.setupArea();
        this.mCurrentType = absLiveAreaStrategy.getLiveType();
    }

    public boolean isPad() {
        return this.isPad;
    }

    public LiveAreaType getCurrentType() {
        return this.mCurrentType;
    }

    public LiveAreaLayoutParams getScreenLp() {
        ILiveAreaStrategy iLiveAreaStrategy = this.mLiveAreaStrategy;
        return iLiveAreaStrategy == null ? DEF : iLiveAreaStrategy.getScreenLp().clone();
    }

    public LiveAreaLayoutParams getVisibleLp() {
        ILiveAreaStrategy iLiveAreaStrategy = this.mLiveAreaStrategy;
        return iLiveAreaStrategy == null ? DEF : iLiveAreaStrategy.getVisibleLp().clone();
    }

    public LiveAreaLayoutParams getTitleLp() {
        ILiveAreaStrategy iLiveAreaStrategy = this.mLiveAreaStrategy;
        return iLiveAreaStrategy == null ? DEF : iLiveAreaStrategy.getTitleLp().clone();
    }

    public LiveAreaLayoutParams getPptLp() {
        ILiveAreaStrategy iLiveAreaStrategy = this.mLiveAreaStrategy;
        return iLiveAreaStrategy == null ? DEF : iLiveAreaStrategy.getPptLp().clone();
    }

    public LiveAreaLayoutParams getHeadLp() {
        ILiveAreaStrategy iLiveAreaStrategy = this.mLiveAreaStrategy;
        return iLiveAreaStrategy == null ? DEF : iLiveAreaStrategy.getHeadLp().clone();
    }

    public LiveAreaLayoutParams getFuncLp() {
        ILiveAreaStrategy iLiveAreaStrategy = this.mLiveAreaStrategy;
        return iLiveAreaStrategy == null ? DEF : iLiveAreaStrategy.getFuncLp().clone();
    }

    public LiveAreaLayoutParams getMsgLp() {
        ILiveAreaStrategy iLiveAreaStrategy = this.mLiveAreaStrategy;
        return iLiveAreaStrategy == null ? DEF : iLiveAreaStrategy.getMsgLp().clone();
    }

    public void destroy() {
        ILiveAreaStrategy iLiveAreaStrategy = this.mLiveAreaStrategy;
        if (iLiveAreaStrategy != null) {
            iLiveAreaStrategy.destroy();
            this.mLiveAreaStrategy = null;
        }
    }
}
