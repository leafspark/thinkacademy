package com.tal.app.thinkacademy.live.core.layout.impl;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.core.layout.ILiveAreaStrategy;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaType;
import java.lang.ref.WeakReference;

public abstract class AbsLiveAreaStrategy implements ILiveAreaStrategy {
    private static final String TAG = "AbsLiveAreaStrategy";
    public boolean isPad;
    private final ViewTreeObserver.OnGlobalLayoutListener mChangeListener = new AbsLiveAreaStrategy$$ExternalSyntheticLambda0(this);
    protected View mContentView;
    protected LiveAreaLayoutParams mFuncLp = new LiveAreaLayoutParams();
    protected LiveAreaLayoutParams mHeadLp = new LiveAreaLayoutParams();
    protected LiveAreaLayoutParams mMsgLp = new LiveAreaLayoutParams();
    protected LiveAreaLayoutParams mPptLp = new LiveAreaLayoutParams();
    protected LiveAreaLayoutParams mScreenLp = new LiveAreaLayoutParams();
    protected LiveAreaLayoutParams mTitleLp = new LiveAreaLayoutParams();
    protected LiveAreaLayoutParams mVisibleLp = new LiveAreaLayoutParams();
    protected WeakReference<FragmentActivity> mWeakActivity;

    /* access modifiers changed from: protected */
    public abstract boolean generateArea();

    public abstract LiveAreaType getLiveType();

    public /* synthetic */ void lambda$new$0$AbsLiveAreaStrategy() {
        WeakReference<FragmentActivity> weakReference = this.mWeakActivity;
        if (weakReference != null) {
            if ((((FragmentActivity) weakReference.get()).getResources().getConfiguration().orientation == 2) && generateArea()) {
                printArea();
                LiveAreaContext.get().layoutObserver.changed();
            }
        }
    }

    public AbsLiveAreaStrategy(FragmentActivity fragmentActivity) {
        this.mWeakActivity = new WeakReference<>(fragmentActivity);
        this.isPad = PadUtils.isPad(fragmentActivity);
    }

    public LiveAreaLayoutParams getTitleLp() {
        return this.mTitleLp;
    }

    public LiveAreaLayoutParams getPptLp() {
        return this.mPptLp;
    }

    public LiveAreaLayoutParams getHeadLp() {
        return this.mHeadLp;
    }

    public LiveAreaLayoutParams getMsgLp() {
        return this.mMsgLp;
    }

    public LiveAreaLayoutParams getFuncLp() {
        return this.mFuncLp;
    }

    public LiveAreaLayoutParams getVisibleLp() {
        return this.mVisibleLp;
    }

    public LiveAreaLayoutParams getScreenLp() {
        return this.mScreenLp;
    }

    public void destroy() {
        View view = this.mContentView;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mChangeListener);
        }
    }

    private void setupLayoutChangeListener() {
        WeakReference<FragmentActivity> weakReference = this.mWeakActivity;
        if (weakReference != null && weakReference.get() != null) {
            View findViewById = ((FragmentActivity) this.mWeakActivity.get()).findViewById(16908290);
            this.mContentView = findViewById;
            findViewById.postDelayed(new AbsLiveAreaStrategy$$ExternalSyntheticLambda1(this), 10);
        }
    }

    public /* synthetic */ void lambda$setupLayoutChangeListener$1$AbsLiveAreaStrategy() {
        this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(this.mChangeListener);
    }

    public void setupArea() {
        generateArea();
        setupLayoutChangeListener();
        printArea();
    }

    private void printArea() {
        String str = TAG;
        XesLog.it(str, new Object[]{"LiveType: " + getLiveType()});
        XesLog.it(str, new Object[]{"Screen: " + this.mScreenLp.toString()});
        XesLog.it(str, new Object[]{"Visible: " + this.mVisibleLp.toString()});
        XesLog.it(str, new Object[]{"Title: " + this.mTitleLp.toString()});
        XesLog.it(str, new Object[]{"Head: " + this.mHeadLp.toString()});
        XesLog.it(str, new Object[]{"Ppt: " + this.mPptLp.toString()});
        XesLog.it(str, new Object[]{"Msg: " + this.mMsgLp.toString()});
        XesLog.it(str, new Object[]{"Func: " + this.mFuncLp.toString()});
    }
}
