package com.igexin.push.core.a;

import com.igexin.push.core.bean.PushTaskBean;

class i implements Runnable {
    final /* synthetic */ PushTaskBean a;
    final /* synthetic */ String b;
    final /* synthetic */ e c;

    i(e eVar, PushTaskBean pushTaskBean, String str) {
        this.c = eVar;
        this.a = pushTaskBean;
        this.b = str;
    }

    public void run() {
        this.c.b(this.a, this.b);
    }
}
