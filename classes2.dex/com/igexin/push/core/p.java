package com.igexin.push.core;

import android.content.ContentValues;

class p implements Runnable {
    final /* synthetic */ ContentValues a;
    final /* synthetic */ n b;

    p(n nVar, ContentValues contentValues) {
        this.b = nVar;
        this.a = contentValues;
    }

    public void run() {
        c.a().k().a("message", this.a);
    }
}
