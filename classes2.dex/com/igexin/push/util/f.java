package com.igexin.push.util;

import android.content.Context;

final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ long b;

    f(Context context, long j) {
        this.a = context;
        this.b = j;
    }

    public void run() {
        c.b(this.a, String.valueOf(this.b));
    }
}
