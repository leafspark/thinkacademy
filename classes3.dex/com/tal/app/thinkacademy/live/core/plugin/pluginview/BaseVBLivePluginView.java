package com.tal.app.thinkacademy.live.core.plugin.pluginview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;

public abstract class BaseVBLivePluginView<VB extends ViewBinding> extends BaseLivePluginView {
    protected VB mBinding;

    /* access modifiers changed from: protected */
    public abstract VB createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z);

    @Deprecated
    public final int getLayoutId() {
        return 0;
    }

    public boolean isAttach() {
        return true;
    }

    public BaseVBLivePluginView(Context context) {
        super(context);
    }

    public BaseVBLivePluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseVBLivePluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public View inflate() {
        this.mBinding = createViewBinding(LayoutInflater.from(getContext()), this, isAttach());
        return this;
    }
}
