package com.bonree.sdk.ba;

import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.ab.i;
import com.bonree.sdk.ad.g;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.MethodInfoBean;
import com.bonree.sdk.agent.business.entity.ThreadMethodInfoBean;
import com.bonree.sdk.agent.business.entity.ViewEventInfoBean;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.ba.h;
import com.bonree.sdk.ba.m;
import com.bonree.sdk.ba.p;
import com.bonree.sdk.d.a;
import com.bonree.sdk.k.c;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class o extends g<p> {
    private static int b = 0;
    private static int c = 1;
    private static int d = 999;
    private static int e = 10000000;
    private static int f = 1;
    private static int g = 2;
    private static int h = 3;
    private static int i = 4;
    private static int j = 5;
    private static int k = 6;
    private static int l = 7;
    private static int m = 8;
    private static int n = 9;
    private static int o = 1001;
    private final AtomicInteger A = new AtomicInteger(0);
    private final AtomicInteger p = new AtomicInteger(2000);
    private final AtomicBoolean q = new AtomicBoolean(false);
    private final f r = new f(this);
    private final a s = new a(this);
    private final j t = new j(this);
    private final c u = new c(this);
    private final l v = new l(this);
    private final h w = new h(this);
    private final m x = new m(this);
    private final i y = new i(this);
    private final q z = new q(this);

    /* access modifiers changed from: package-private */
    public final h.a a(boolean z2, String str, String str2) {
        h.a aVar = new h.a();
        if (z2) {
            aVar.a = true;
            aVar.b = UUID.randomUUID().toString();
        }
        aVar.c = a.b();
        aVar.d = a(0);
        aVar.e = str;
        aVar.f = str2;
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final List<EventBean> a(boolean z2) {
        ArrayList arrayList;
        synchronized (this.a) {
            if (z2) {
                long b2 = a.b();
                long a = a(0);
                com.bonree.sdk.be.a.a().c("ViewService ViewEvent happen Crash timeStamp is %s, elapsedRealtime is %s.", Long.valueOf(a), Long.valueOf(b2));
                this.z.a(b2, a);
                this.v.a(b2, a);
                this.t.a(b2, a);
                this.r.a(b2, a);
                this.s.a(b2, a);
                this.u.a(b2, a);
            }
            e();
            arrayList = new ArrayList(this.a);
            c();
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final long a(long j2) {
        if (j2 == 0) {
            j2 = a.l();
        }
        if (j2 < 0) {
            this.A.incrementAndGet();
        } else {
            e();
        }
        return j2;
    }

    private void e() {
        if (!this.a.isEmpty() && this.A.get() > 0) {
            synchronized (this.a) {
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    EventBean eventBean = (EventBean) this.a.get(i2);
                    ViewEventInfoBean viewEventInfoBean = (ViewEventInfoBean) eventBean.mEventInfo;
                    if (eventBean.mEventTime < 0) {
                        this.A.decrementAndGet();
                        eventBean.correctEventTime(a.c(eventBean.mEventTime));
                    }
                    if (!(viewEventInfoBean == null || viewEventInfoBean.mThreadMethodInfo == null)) {
                        for (ThreadMethodInfoBean threadMethodInfoBean : viewEventInfoBean.mThreadMethodInfo) {
                            for (MethodInfoBean next : threadMethodInfoBean.mMethodInfo) {
                                if (next.mStartTimeUs <= 0) {
                                    next.mStartTimeUs = a.c(next.mStartTimeUs);
                                    next.mEndTimeUs = a.c(next.mEndTimeUs);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.p.set(i2);
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.p.get();
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z2) {
        this.q.set(z2);
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.q.get();
    }

    public final void a(Message message) {
        try {
            Object obj = message.obj;
            if (obj != null) {
                switch (message.what) {
                    case 1:
                        com.bonree.sdk.z.a aVar = (com.bonree.sdk.z.a) obj;
                        this.z.a(aVar);
                        this.v.a(aVar);
                        this.t.a(aVar);
                        this.r.a(aVar);
                        return;
                    case 2:
                        com.bonree.sdk.aa.a aVar2 = (com.bonree.sdk.aa.a) obj;
                        this.z.a(aVar2);
                        this.t.a(aVar2);
                        return;
                    case 3:
                        this.z.a((c) obj);
                        return;
                    case 4:
                        this.v.a((i) obj);
                        return;
                    case 5:
                        this.w.a((h.a) obj);
                        return;
                    case 6:
                        m.a aVar3 = (m.a) obj;
                        if (aVar3 != null && aVar3.f == 0) {
                            this.x.a(aVar3);
                            return;
                        } else if (aVar3 != null && aVar3.f == 1) {
                            this.y.b(aVar3);
                            return;
                        } else {
                            return;
                        }
                    case 7:
                        e eVar = (e) obj;
                        this.x.a(eVar);
                        this.y.a(eVar);
                        return;
                    case 8:
                        com.bonree.sdk.x.a aVar4 = (com.bonree.sdk.x.a) obj;
                        this.z.a(aVar4);
                        this.v.a(aVar4);
                        this.u.a(aVar4);
                        this.s.a(aVar4);
                        return;
                    case 9:
                        com.bonree.sdk.y.a aVar5 = (com.bonree.sdk.y.a) obj;
                        this.z.a(aVar5);
                        this.u.a(aVar5);
                        return;
                    default:
                        return;
                }
            } else if (message.what == 1001) {
                this.s.a();
                this.r.a();
                this.v.a();
                this.t.a();
                this.u.a();
                this.w.a();
                this.x.a();
                this.y.a();
                this.z.c();
                if (this.a == null) {
                    return;
                }
                if (!this.a.isEmpty()) {
                    this.a.clear();
                }
            }
        } catch (Exception e2) {
            com.bonree.sdk.be.a.a().a("ViewService handleWork error %s.", (Throwable) e2);
        }
    }

    private void f() {
        this.s.a();
        this.r.a();
        this.v.a();
        this.t.a();
        this.u.a();
        this.w.a();
        this.x.a();
        this.y.a();
        this.z.c();
        if (this.a != null && !this.a.isEmpty()) {
            this.a.clear();
        }
    }

    private void a(com.bonree.sdk.z.a aVar) {
        this.z.a(aVar);
        this.v.a(aVar);
        this.t.a(aVar);
        this.r.a(aVar);
    }

    private void a(com.bonree.sdk.x.a aVar) {
        this.z.a(aVar);
        this.v.a(aVar);
        this.u.a(aVar);
        this.s.a(aVar);
    }

    private void a(com.bonree.sdk.aa.a aVar) {
        this.z.a(aVar);
        this.t.a(aVar);
    }

    private void a(com.bonree.sdk.y.a aVar) {
        this.z.a(aVar);
        this.u.a(aVar);
    }

    private void a(c cVar) {
        this.z.a(cVar);
    }

    private void a(i iVar) {
        this.v.a(iVar);
    }

    private void a(h.a aVar) {
        this.w.a(aVar);
    }

    private void a(m.a aVar) {
        if (aVar != null && aVar.f == 0) {
            this.x.a(aVar);
        } else if (aVar != null && aVar.f == 1) {
            this.y.b(aVar);
        }
    }

    private void g() {
        long b2 = a.b();
        long a = a(0);
        com.bonree.sdk.be.a.a().c("ViewService ViewEvent happen Crash timeStamp is %s, elapsedRealtime is %s.", Long.valueOf(a), Long.valueOf(b2));
        this.z.a(b2, a);
        this.v.a(b2, a);
        this.t.a(b2, a);
        this.r.a(b2, a);
        this.s.a(b2, a);
        this.u.a(b2, a);
    }

    private void a(e eVar) {
        this.x.a(eVar);
        this.y.a(eVar);
    }

    /* access modifiers changed from: package-private */
    public final q d() {
        return this.z;
    }

    o(Looper looper) {
        super(looper, p.a.a);
    }
}
