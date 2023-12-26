package com.tal.app.thinkacademy.live.core.plugin.pluginview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;

public abstract class BaseLivePluginView extends FrameLayout {
    protected View RootView;
    public Context mContext;
    public int viewLevelTag;

    public abstract int getLayoutId();

    public void initData() {
    }

    public void initViews() {
    }

    public BaseLivePluginView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public BaseLivePluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public BaseLivePluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.RootView = inflate();
        initViews();
        initData();
    }

    /* access modifiers changed from: package-private */
    public View inflate() {
        LayoutInflater from = LayoutInflater.from(getContext());
        int layoutId = getLayoutId();
        return !(from instanceof LayoutInflater) ? from.inflate(layoutId, this) : XMLParseInstrumentation.inflate(from, layoutId, this);
    }

    public View getInflateView() {
        return this.RootView;
    }
}
