package com.tal.app.thinkacademy.common.business.browser.cache;

import android.os.MessageQueue;

public final /* synthetic */ class HwWebViewCacheManager$$ExternalSyntheticLambda0 implements MessageQueue.IdleHandler {
    public final /* synthetic */ HwWebViewCacheManager f$0;

    public /* synthetic */ HwWebViewCacheManager$$ExternalSyntheticLambda0(HwWebViewCacheManager hwWebViewCacheManager) {
        this.f$0 = hwWebViewCacheManager;
    }

    public final boolean queueIdle() {
        return HwWebViewCacheManager.m8preLoadWeb$lambda0(this.f$0);
    }
}
