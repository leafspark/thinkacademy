package com.igexin.push.core;

import android.os.HandlerThread;

public class f extends HandlerThread {
    public f() {
        super("CoreThread");
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        c.a().c();
    }
}
