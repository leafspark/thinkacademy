package com.bonree.sdk.agent.engine.state;

import android.net.NetworkInfo;
import com.bonree.sdk.agent.engine.state.b;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class m extends com.bonree.sdk.g.a<k, j> {
    private static final String a = "StateEngine-";
    private static String d = "NaN";
    private static String e = "WiFi";
    protected k b;
    protected String c;
    private final AtomicBoolean f = new AtomicBoolean(false);

    public abstract void b();

    public abstract void c();

    public synchronized String a() {
        if (ad.a(this.c) || "NaN".equals(this.c)) {
            this.c = ad.a.a();
        }
        return this.c;
    }

    public final void a(int i) {
        this.b.a(i);
        this.b.a("WiFi");
        this.c = "WiFi";
    }

    public final void f() {
        this.b.a(-1);
        this.b.a((NetworkInfo) null);
        this.b.a("NaN");
        this.c = "NaN";
    }

    public final void a(int i, String str) {
        if (ad.a(str)) {
            this.b.a(-1);
            this.b.a("NaN");
            this.c = "NaN";
            f a2 = com.bonree.sdk.be.a.a();
            a2.c("StateEngine- standard exception. standard:" + str, new Object[0]);
            return;
        }
        this.b.a(i);
        this.b.a(str);
        this.c = str;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final m a = (com.bonree.sdk.d.a.L() ? g.d() : b.a.a);

        private a() {
        }
    }

    public static m g() {
        return a.a;
    }

    /* renamed from: a */
    public final void registerService(j jVar) {
        super.registerService(jVar);
        if (this.services.size() == 1 || !this.f.get()) {
            com.bonree.sdk.be.a.a().c("StateEngine- is start.", new Object[0]);
            this.f.set(true);
            b();
            return;
        }
        jVar.a(this.b);
    }

    public void stopEngine() {
        super.stopEngine();
        com.bonree.sdk.be.a.a().c("StateEngine- is stop.", new Object[0]);
        c();
        this.f.set(false);
        this.c = "NaN";
    }

    /* renamed from: a */
    public final void notifyService(k kVar) {
        try {
            this.readWriteLock.readLock().lock();
            if (kVar != null) {
                for (j a2 : this.services) {
                    a2.a(kVar);
                }
            }
        } catch (Throwable unused) {
        }
        this.readWriteLock.readLock().unlock();
    }

    public final boolean h() {
        return this.f.get();
    }
}
