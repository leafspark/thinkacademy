package com.igexin.push.core;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.b.a.c.b;
import com.igexin.push.util.a;
import com.igexin.push.util.c;

class y implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;
    final /* synthetic */ x c;

    y(x xVar, Context context, Intent intent) {
        this.c = xVar;
        this.a = context;
        this.b = intent;
    }

    private void a() {
        b.a("ServiceManager|startPService by bind", new Object[0]);
        Intent intent = this.b;
        intent.setType("PB-" + System.nanoTime());
        Intent intent2 = this.b;
        Context context = this.a;
        intent2.setClass(context, this.c.b(context));
        this.a.getApplicationContext().bindService(this.b, this.c.g, 1);
    }

    public void run() {
        if (TextUtils.isEmpty(this.c.f)) {
            String unused = this.c.f = d.f;
            if (TextUtils.isEmpty(this.c.f)) {
                String unused2 = this.c.f = c.c(this.a);
            }
        }
        this.b.putExtra("sc", this.c.f);
        try {
            if (Build.VERSION.SDK_INT < 26 || !a.j()) {
                this.a.getApplicationContext().startService(this.b);
            } else {
                a();
            }
        } catch (Throwable th) {
            b.a("ServiceManager|startPService err：" + th.toString(), new Object[0]);
            if (th instanceof IllegalStateException) {
                a();
            }
        }
    }
}
