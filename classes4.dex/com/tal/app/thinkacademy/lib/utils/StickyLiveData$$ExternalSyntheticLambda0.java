package com.tal.app.thinkacademy.lib.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class StickyLiveData$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ StickyLiveData f$0;

    public /* synthetic */ StickyLiveData$$ExternalSyntheticLambda0(StickyLiveData stickyLiveData) {
        this.f$0 = stickyLiveData;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        StickyLiveData.m132observerSticky$lambda0(this.f$0, lifecycleOwner, event);
    }
}
