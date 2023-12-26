package com.igexin.push.extension.distribution.basic.stub;

import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.c.c;

class a implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ PushExtension b;

    a(PushExtension pushExtension, boolean z) {
        this.b = pushExtension;
        this.a = z;
    }

    public void run() {
        if (this.a) {
            c.a().e();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException unused) {
        }
        if (d.n) {
            com.igexin.push.extension.distribution.basic.a.d.a().a(d.n);
        }
    }
}
