package com.igexin.push.core.d;

import android.content.Context;

class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ e b;
    final /* synthetic */ a c;

    b(a aVar, Context context, e eVar) {
        this.c = aVar;
        this.a = context;
        this.b = eVar;
    }

    public void run() {
        this.c.a(this.a);
        this.b.a(a.e, a.g = this.c.d());
    }
}
