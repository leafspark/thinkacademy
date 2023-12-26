package com.igexin.push.c;

import com.igexin.b.a.c.b;
import com.igexin.push.config.SDKUrlConfig;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class k {
    /* access modifiers changed from: private */
    public static final String a = ("DT_" + k.class.getName());
    private static ThreadPoolExecutor b;
    private Future<j> c;
    /* access modifiers changed from: private */
    public j d;
    /* access modifiers changed from: private */
    public r e;
    private boolean f;

    public static void a() {
        ThreadPoolExecutor threadPoolExecutor;
        if (SDKUrlConfig.getXfrAddress().length == 1 && (threadPoolExecutor = b) != null) {
            try {
                threadPoolExecutor.shutdownNow();
                b = null;
            } catch (Throwable unused) {
            }
        }
    }

    private void g() {
        if (b == null) {
            b = new ThreadPoolExecutor(0, 12, 60, TimeUnit.SECONDS, new SynchronousQueue());
        }
        this.c = b.submit(new l(this));
    }

    /* access modifiers changed from: private */
    public String h() {
        return this.d.a() + "|" + this.d.c();
    }

    private void i() {
        try {
            Future<j> future = this.c;
            if (future != null && !future.isCancelled() && !this.c.isDone()) {
                this.c.cancel(true);
                this.c = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(j jVar) {
        this.d = jVar;
    }

    public void a(r rVar) {
        synchronized (r.class) {
            this.e = rVar;
        }
    }

    public void a(boolean z) {
        this.f = z;
    }

    public j b() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public void c() {
        synchronized (r.class) {
            if (this.e != null) {
                g();
            }
        }
    }

    public void d() {
        b.a(a + "|stop " + h() + " task", new Object[0]);
        i();
    }

    public void e() {
        a((r) null);
        i();
    }
}
