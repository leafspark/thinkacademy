package com.bonree.sdk.ac;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.ac.a;
import com.bonree.sdk.ac.c;
import com.bonree.sdk.ac.f;
import com.bonree.sdk.ad.g;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.k.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class b extends g<c> {
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 4;
    private static int f = 5;
    private static int g = 6;
    private static int h = 7;
    private static int i = 8;
    private final d j = new d(this);
    private final e k = new e(this);
    private final f l = new f(this);
    private final int m = 10;
    private final AtomicInteger n = new AtomicInteger(0);

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        try {
            Object obj = message.obj;
            if (obj != null || message.what == 7) {
                switch (message.what) {
                    case 1:
                        this.j.a((c) obj);
                        return;
                    case 2:
                        this.k.a((com.bonree.sdk.v.g) obj);
                        return;
                    case 3:
                        this.l.a((f.a) obj);
                        return;
                    case 4:
                        a.b.a.a(this, (com.bonree.sdk.g.b) obj);
                        return;
                    case 5:
                        a.b.a.a((EventBean) obj, (Handler) this);
                        return;
                    case 6:
                        a.b.a.a((EventBean) obj);
                        return;
                    case 7:
                        a.b.a.a(this);
                        return;
                    case 8:
                        a.b.a.a((e) obj);
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e2) {
            com.bonree.sdk.be.a.a().a("ActionService handleWork is error %s.", (Throwable) e2);
        }
    }

    public final void a() {
        this.j.a();
        synchronized (this.a) {
            this.a.clear();
        }
    }

    private void a(c cVar) {
        this.j.a(cVar);
    }

    private void a(com.bonree.sdk.v.g gVar) {
        this.k.a(gVar);
    }

    private void a(f.a aVar) {
        this.l.a(aVar);
    }

    public final List<EventBean> a(boolean z) {
        ArrayList arrayList;
        synchronized (this.a) {
            if (z) {
                long b2 = com.bonree.sdk.d.a.b();
                a(0);
                this.j.a(b2);
            }
            d();
            arrayList = new ArrayList(this.a);
            c();
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final long a(long j2) {
        if (j2 == 0) {
            j2 = com.bonree.sdk.d.a.l();
        }
        if (j2 < 0) {
            this.n.incrementAndGet();
        } else {
            d();
        }
        return j2;
    }

    private void d() {
        if (!this.a.isEmpty() && this.n.get() > 0) {
            synchronized (this.a) {
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    EventBean eventBean = (EventBean) this.a.get(i2);
                    if (eventBean.mEventTime < 0) {
                        this.n.decrementAndGet();
                        eventBean.correctEventTime(com.bonree.sdk.d.a.c(eventBean.mEventTime));
                    }
                }
            }
        }
    }

    private void e() {
        long b2 = com.bonree.sdk.d.a.b();
        a(0);
        this.j.a(b2);
    }

    public b(Looper looper) {
        super(looper, c.a.a);
    }

    private static void a(e eVar) {
        a.b.a.a(eVar);
    }

    public static void a(int i2, int i3, int i4) {
        a.b.a.b(i2);
        a.b.a.a(i3);
        a.b.a.c(i4);
    }

    public final void b() {
        a.b.a.a(this);
    }

    private void a(com.bonree.sdk.g.b bVar) {
        a.b.a.a(this, bVar);
    }

    private void c(EventBean eventBean) {
        a.b.a.a(eventBean, (Handler) this);
    }

    public static void a(EventBean eventBean) {
        a.b.a.a(eventBean);
    }
}
