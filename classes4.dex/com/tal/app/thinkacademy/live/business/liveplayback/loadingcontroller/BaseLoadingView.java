package com.tal.app.thinkacademy.live.business.liveplayback.loadingcontroller;

import android.content.Context;
import android.util.AttributeSet;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public abstract class BaseLoadingView extends BaseLivePluginView {
    /* access modifiers changed from: package-private */
    public abstract void hideView();

    /* access modifiers changed from: package-private */
    public abstract void setClickListener(IOnClickListener iOnClickListener);

    /* access modifiers changed from: package-private */
    public abstract void showBufferLoad();

    /* access modifiers changed from: package-private */
    public abstract void showError(boolean z, String str);

    public abstract void showLoading();

    /* access modifiers changed from: package-private */
    public abstract void showReplay();

    public BaseLoadingView(Context context) {
        super(context);
    }

    public BaseLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
