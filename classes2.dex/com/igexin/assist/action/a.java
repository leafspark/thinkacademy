package com.igexin.assist.action;

import com.igexin.push.core.d;

class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ MessageManger c;

    a(MessageManger messageManger, String str, boolean z) {
        this.c = messageManger;
        this.a = str;
        this.b = z;
    }

    public void run() {
        if (d.h.get()) {
            this.c.a(this.a, this.b);
        }
    }
}
