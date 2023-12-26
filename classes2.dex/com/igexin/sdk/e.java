package com.igexin.sdk;

import android.app.Application;
import android.content.Context;
import com.igexin.push.core.g;

class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ PushManager b;

    e(PushManager pushManager, Context context) {
        this.b = pushManager;
        this.a = context;
    }

    public void run() {
        try {
            Application a2 = this.b.d(this.a);
            if (a2 != null) {
                a2.unregisterActivityLifecycleCallbacks(this.b.i);
                g unused = this.b.i = null;
            }
        } catch (Throwable unused2) {
        }
    }
}
