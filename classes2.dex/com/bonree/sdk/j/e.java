package com.bonree.sdk.j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class e extends Handler {
    private /* synthetic */ b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e(b bVar, Looper looper) {
        super(looper);
        this.a = bVar;
    }

    public final void handleMessage(Message message) {
        if (message.obj != null && message.what == 0) {
            this.a.a(((Long) message.obj).longValue());
        }
    }
}
