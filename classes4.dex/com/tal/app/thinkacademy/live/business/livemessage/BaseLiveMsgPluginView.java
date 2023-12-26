package com.tal.app.thinkacademy.live.business.livemessage;

import android.content.Context;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

abstract class BaseLiveMsgPluginView extends BaseLivePluginView {
    protected LiveMsgPluginDriver mLiveMsgPluginDriver;

    public abstract int getView();

    public BaseLiveMsgPluginView(Context context, LiveMsgPluginDriver liveMsgPluginDriver) {
        super(context);
        this.mLiveMsgPluginDriver = liveMsgPluginDriver;
    }

    public void initViews() {
        BaseLiveMsgPluginView.super.initViews();
    }

    public int getLayoutId() {
        return getView();
    }

    /* access modifiers changed from: protected */
    public void sendHotWord(String str) {
        this.mLiveMsgPluginDriver.sendHotWord(str);
    }
}
