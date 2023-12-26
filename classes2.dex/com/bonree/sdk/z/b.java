package com.bonree.sdk.z;

import android.os.Looper;
import com.bonree.sdk.ac.c;
import com.bonree.sdk.agent.engine.state.f;
import com.bonree.sdk.bs.ad;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b extends com.bonree.sdk.g.a<a, d> {
    private String a;
    private AtomicBoolean b;
    private AtomicBoolean c;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        this.a = "";
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
    }

    public static b a() {
        return a.a;
    }

    /* access modifiers changed from: protected */
    public final void startEngine() {
        super.startEngine();
        com.bonree.sdk.be.a.a().c("activity engine is start.", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public final void stopEngine() {
        super.stopEngine();
        com.bonree.sdk.be.a.a().c("activity engine is stop.", new Object[0]);
    }

    public final void a(String str) {
        a(str, a.l, 0);
    }

    public final void b(String str) {
        a(str, a.l, 1);
    }

    public final void c(String str) {
        a(str, a.m, 0);
    }

    public final void d(String str) {
        a(str, a.m, 1);
    }

    public final void e(String str) {
        a(str, a.n, 0);
    }

    public final void f(String str) {
        a(str, a.n, 1);
        c();
    }

    public final void g(String str) {
        a(str, a.p, 0);
    }

    public final void h(String str) {
        a(str, a.p, 1);
    }

    public final void i(String str) {
        a(str, a.q, 0);
    }

    public final void j(String str) {
        a(str, a.o, 0);
    }

    public final void k(String str) {
        a(str, a.o, 1);
    }

    private void a(String str, String str2, int i) {
        if (!isEmptyServices()) {
            notifyService(b(str, str2, i));
        }
    }

    private a b(String str, String str2, int i) {
        this.a = str;
        a aVar = new a();
        aVar.a(str);
        aVar.c(str2);
        aVar.b(i);
        aVar.a(com.bonree.sdk.d.a.b());
        aVar.b(com.bonree.sdk.d.a.l());
        boolean z = false;
        aVar.a(0);
        aVar.d(Thread.currentThread().getName());
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z = true;
        }
        aVar.a(z);
        return aVar;
    }

    /* renamed from: a */
    public final void registerService(d dVar) {
        super.registerService(dVar);
        if (dVar instanceof c) {
            this.b.set(true);
            c();
        }
    }

    /* renamed from: b */
    public final void unRegisterService(d dVar) {
        super.unRegisterService(dVar);
        if (dVar instanceof c) {
            this.b.set(false);
            if (this.c.get()) {
                this.c.set(!com.bonree.sdk.w.a.b());
            }
        }
    }

    private void c() {
        if (this.b.get() && !this.c.get() && !com.bonree.sdk.d.a.L()) {
            this.c.set(com.bonree.sdk.w.a.a());
        }
    }

    private void d() {
        if (this.c.get()) {
            this.c.set(!com.bonree.sdk.w.a.b());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void notifyService(a aVar) {
        this.readWriteLock.readLock().lock();
        try {
            for (d a2 : this.services) {
                a2.a(aVar);
            }
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public final String b() {
        if (!ad.a(this.a)) {
            return this.a;
        }
        return f.getEngine().getViewName();
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((byte) 0);

        private a() {
        }
    }
}
