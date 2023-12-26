package com.bonree.sdk.aq;

import com.bonree.sdk.ad.c;
import com.bonree.sdk.agent.business.entity.ThreadMethodInfoBean;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.g.b;
import com.bonree.sdk.z.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class j extends c implements f {
    AtomicBoolean a = new AtomicBoolean(false);
    AtomicBoolean b = new AtomicBoolean(false);
    private final g c;
    private boolean d;
    private long e;

    j(g gVar) {
        this.c = gVar;
    }

    public final void a(b bVar) {
        this.a.set(true);
        a((b) bVar);
    }

    public final void a(a aVar) {
        if (this.e > 0 && aVar.e() == 0 && (a.o.equals(aVar.c()) || a.l.equals(aVar.c()))) {
            this.b.set(true);
        }
        a((b) aVar);
        if (aVar.e() == 1 && a.n.equals(aVar.c())) {
            this.b.set(false);
        }
    }

    public final void a(com.bonree.sdk.aa.a aVar) {
        a((b) aVar);
    }

    public final void a(com.bonree.sdk.y.a aVar) {
        a((b) aVar);
    }

    public final void a(com.bonree.sdk.k.c cVar) {
        a((b) cVar);
    }

    public final void a(long j, long j2) {
        super.a(j, j2);
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        if (this.e > 0 && aVar.e() == 0 && (com.bonree.sdk.x.a.n.equals(aVar.c()) || com.bonree.sdk.x.a.l.equals(aVar.c()))) {
            this.b.set(true);
        }
        a((b) aVar);
        if (aVar.e() == 1 && com.bonree.sdk.x.a.m.equals(aVar.c())) {
            this.b.set(false);
        }
    }

    public final void a(e eVar) {
        if (eVar == e.BACKGROUND) {
            c();
            this.e = com.bonree.sdk.d.a.b();
        }
    }

    public final void d() {
        this.a.set(false);
    }

    /* access modifiers changed from: protected */
    public final boolean b(b bVar) {
        if (this.a.get() || this.b.get()) {
            return false;
        }
        com.bonree.sdk.be.a.a().a("LaunchService isViewLoadEnd filter data is %s", bVar);
        return true;
    }

    public final List<ThreadMethodInfoBean> a() {
        List<ThreadMethodInfoBean> a2 = super.a();
        b();
        return a2;
    }

    public final List<ThreadMethodInfoBean> b(long j, long j2) {
        List<ThreadMethodInfoBean> b2 = super.b(j, j2);
        b();
        return b2;
    }

    public final void e() {
        this.d = true;
    }

    /* access modifiers changed from: protected */
    public final long a(long j) {
        return this.c.a(j);
    }

    public final void c() {
        super.c();
        this.e = 0;
    }
}
