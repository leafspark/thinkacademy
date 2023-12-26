package com.igexin.sdk;

import android.app.Application;
import android.content.Context;
import com.igexin.push.core.g;

class d implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ PushManager b;

    d(PushManager pushManager, Context context) {
        this.b = pushManager;
        this.a = context;
    }

    public void run() {
        try {
            Application a2 = this.b.d(this.a);
            if (a2 != null) {
                synchronized (this) {
                    if (this.b.i == null) {
                        g unused = this.b.i = new g();
                        a2.registerActivityLifecycleCallbacks(this.b.i);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
