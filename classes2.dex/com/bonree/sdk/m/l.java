package com.bonree.sdk.m;

import com.bonree.sdk.agent.engine.external.BonreeFlutterBridge;

final class l implements Runnable {
    private /* synthetic */ Class a;
    private /* synthetic */ k b;

    l(k kVar, Class cls) {
        this.b = kVar;
        this.a = cls;
    }

    public final void run() {
        BonreeFlutterBridge.setNetworkTraceConfig(this.a, this.b.r);
    }
}
