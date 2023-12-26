package com.bonree.sdk.h;

import android.os.Build;
import com.bonree.sdk.i.c;
import com.bonree.sdk.i.g;
import com.bonree.sdk.i.i;
import com.bonree.sdk.i.k;
import com.bonree.sdk.i.n;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b extends com.bonree.sdk.g.a<c, f> {
    private static final String a = "BatteryEngine";
    private h b;
    private a c;
    private g d;
    private e e;
    private i f;
    private final AtomicBoolean g = new AtomicBoolean(false);

    /* access modifiers changed from: protected */
    public final void startEngine() {
        super.startEngine();
        this.b = new h();
        i.a().a((k.a) this.b);
        this.c = new a();
        com.bonree.sdk.i.a.a().a((k.a) this.c);
        this.d = new g();
        g.a().a((k.a) this.d);
        if (Build.VERSION.SDK_INT < 26) {
            com.bonree.sdk.be.a.a().d("BatteryEngine only support >= android 8.0 for the moment", new Object[0]);
        } else {
            this.e = new e();
            c.a().a((k.a) this.e);
        }
        this.f = new i();
        n.a().a((k.a) this.f);
        com.bonree.sdk.be.a.a().c("battery engine is start.", new Object[0]);
    }

    private void b() {
        this.b = new h();
        i.a().a((k.a) this.b);
    }

    private void c() {
        i.a().b(this.b);
    }

    private void d() {
        this.c = new a();
        com.bonree.sdk.i.a.a().a((k.a) this.c);
    }

    private void e() {
        com.bonree.sdk.i.a.a().b(this.c);
    }

    private void f() {
        this.d = new g();
        g.a().a((k.a) this.d);
    }

    private void g() {
        g.a().b(this.d);
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 26) {
            com.bonree.sdk.be.a.a().d("BatteryEngine only support >= android 8.0 for the moment", new Object[0]);
            return;
        }
        this.e = new e();
        c.a().a((k.a) this.e);
    }

    private void i() {
        this.f = new i();
        n.a().a((k.a) this.f);
    }

    private void j() {
        n.a().b(this.f);
    }

    /* access modifiers changed from: package-private */
    public final void a(d dVar, int i) {
        a(dVar, 4, 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(d dVar, int i, int i2) {
        c cVar = new c();
        cVar.a(com.bonree.sdk.d.a.b());
        cVar.b(com.bonree.sdk.d.a.l());
        cVar.a(dVar);
        cVar.b(i);
        cVar.a(i2);
        notifyService(cVar);
    }

    private void k() {
        c.a().b(this.e);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void notifyService(c cVar) {
        this.readWriteLock.readLock().lock();
        try {
            for (f a2 : this.services) {
                a2.a(cVar);
            }
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    /* renamed from: a */
    public final void registerService(f fVar) {
        super.registerService(fVar);
        if (this.services.size() == 1 || !this.g.get()) {
            com.bonree.sdk.be.a.a().c("BatteryEngine is start.", new Object[0]);
            this.g.set(true);
        }
    }

    /* renamed from: b */
    public final void unRegisterService(f fVar) {
        super.unRegisterService(fVar);
        if (isEmptyServices()) {
            com.bonree.sdk.be.a.a().c("BatteryEngine is stop.", new Object[0]);
            this.g.set(false);
        }
    }

    /* access modifiers changed from: protected */
    public final void stopEngine() {
        super.stopEngine();
        i.a().b(this.b);
        com.bonree.sdk.i.a.a().b(this.c);
        g.a().b(this.d);
        c.a().b(this.e);
        n.a().b(this.f);
        com.bonree.sdk.be.a.a().c("BatteryEngine is stop.", new Object[0]);
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.a;
    }
}
