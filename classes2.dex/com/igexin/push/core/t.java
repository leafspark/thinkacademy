package com.igexin.push.core;

import android.os.Handler;
import android.os.HandlerThread;

final class t {
    final /* synthetic */ r a;
    private final Handler b;

    t(r rVar) {
        this.a = rVar;
        HandlerThread handlerThread = new HandlerThread("GTIS-HANDLER");
        handlerThread.start();
        this.b = new u(this, handlerThread.getLooper(), rVar);
    }

    /* access modifiers changed from: package-private */
    public Handler a() {
        return this.b;
    }
}
