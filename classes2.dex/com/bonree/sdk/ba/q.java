package com.bonree.sdk.ba;

import com.bonree.sdk.ab.i;
import com.bonree.sdk.ad.c;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.ba.m;
import com.bonree.sdk.g.b;
import com.bonree.sdk.z.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class q extends c implements n {
    private boolean a;
    private final AtomicBoolean b = new AtomicBoolean(true);
    private final AtomicInteger c = new AtomicInteger(0);
    private final o d;

    public final void a(i iVar) {
    }

    public final void a(e eVar) {
    }

    public final void a(m.a aVar) {
    }

    public final void a_() {
    }

    public final void b(m.a aVar) {
    }

    q(o oVar) {
        this.d = oVar;
    }

    public final void a(a aVar) {
        if (aVar.e() == 0) {
            if (com.bonree.sdk.aa.a.l.equals(aVar.c()) || a.o.equals(aVar.c())) {
                this.b.set(false);
                this.c.set(0);
            } else if (this.b.get() && (com.bonree.sdk.aa.a.o.equals(aVar.c()) || a.n.equals(aVar.c()))) {
                this.b.set(false);
                this.c.set(0);
            }
        }
        a((b) aVar);
        if (aVar.e() == 1 && a.n.equals(aVar.c())) {
            this.b.set(true);
        }
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        if (aVar.e() == 0) {
            if (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.n.equals(aVar.c())) {
                this.b.set(false);
                this.c.set(0);
            } else if (this.b.get() && (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.m.equals(aVar.c()))) {
                this.b.set(false);
                this.c.set(0);
            }
        }
        a((b) aVar);
        if (aVar.e() == 1 && com.bonree.sdk.x.a.m.equals(aVar.c())) {
            this.b.set(true);
        }
    }

    public final void a(com.bonree.sdk.y.a aVar) {
        if (aVar.e() == 0) {
            if (com.bonree.sdk.x.a.l.equals(aVar.c())) {
                this.c.incrementAndGet();
                this.a = true;
            }
            if (this.c.get() == 0 && com.bonree.sdk.x.a.m.equals(aVar.c())) {
                this.c.incrementAndGet();
                this.a = true;
            } else if (!this.a && (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.m.equals(aVar.c()))) {
                this.c.incrementAndGet();
            }
        }
        a((b) aVar);
        if (this.c.get() > 0 && aVar.e() == 1 && com.bonree.sdk.x.a.m.equals(aVar.c())) {
            this.c.decrementAndGet();
        }
    }

    public final void a(com.bonree.sdk.aa.a aVar) {
        if (aVar.e() == 0) {
            if (com.bonree.sdk.aa.a.l.equals(aVar.c())) {
                this.c.incrementAndGet();
                this.a = true;
            } else if (!this.a && (com.bonree.sdk.aa.a.o.equals(aVar.c()) || a.n.equals(aVar.c()))) {
                this.c.incrementAndGet();
            }
        }
        a((b) aVar);
        if (aVar.e() == 1 && a.n.equals(aVar.c())) {
            this.c.decrementAndGet();
        }
    }

    public final void a(com.bonree.sdk.k.c cVar) {
        a((b) cVar);
    }

    public final void a(long j, long j2) {
        super.a(j, j2);
    }

    /* access modifiers changed from: protected */
    public final boolean b(b bVar) {
        if (!this.b.get() || this.c.get() > 0) {
            o oVar = this.d;
            if (oVar != null) {
                oVar.b(false);
            }
            return false;
        }
        com.bonree.sdk.be.a.a().a("ViewService isViewLoadEnd filter data is %s", bVar);
        o oVar2 = this.d;
        if (oVar2 != null) {
            oVar2.b(true);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final long a(long j) {
        return this.d.a(j);
    }

    public final void c() {
        super.c();
        super.b();
        this.a = false;
    }
}
