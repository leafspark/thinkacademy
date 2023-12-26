package com.bonree.sdk.m;

import com.bonree.sdk.m.a;
import com.bonree.sdk.n.c;
import com.bonree.sdk.v.f;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g extends com.bonree.sdk.g.a<c, e> {
    private boolean a;
    private AtomicBoolean b;
    private AtomicBoolean c;

    /* synthetic */ g(byte b2) {
        this();
    }

    private g() {
        this.a = false;
        this.c = new AtomicBoolean(true);
        this.b = new AtomicBoolean(false);
    }

    static class a {
        /* access modifiers changed from: private */
        public static final g a = new g((byte) 0);

        private a() {
        }
    }

    public static g a() {
        return a.a;
    }

    /* renamed from: a */
    public final void registerService(e eVar) {
        super.registerService(eVar);
        com.bonree.sdk.be.g.a("network engine register add", new Object[0]);
        if (this.c.get()) {
            this.c.set(false);
            f.a();
            a.C0023a.a.b();
        }
        this.b.set(true);
    }

    /* renamed from: b */
    public final void unRegisterService(e eVar) {
        super.unRegisterService(eVar);
        if (this.services.isEmpty()) {
            com.bonree.sdk.be.g.a("network engine stop", new Object[0]);
            a.C0023a.a.c();
            a.C0023a.a.d();
            this.b.set(false);
            this.a = false;
        }
    }

    public final boolean b() {
        return this.b.get();
    }

    /* renamed from: a */
    public final void notifyService(c cVar) {
        this.readWriteLock.readLock().lock();
        if (cVar != null) {
            try {
                for (e a2 : this.services) {
                    a2.a(cVar);
                }
            } catch (Throwable th) {
                this.readWriteLock.readLock().unlock();
                throw th;
            }
        }
        this.readWriteLock.readLock().unlock();
    }

    public final boolean c() {
        return this.a;
    }

    public final void a(boolean z) {
        this.a = z;
    }
}
