package com.bonree.sdk.ad;

import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.d.a;
import com.bonree.sdk.d.e;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class f extends a {
    protected List<EventBean> f;
    private AtomicInteger g = new AtomicInteger(0);

    public abstract boolean b();

    public abstract boolean c();

    public f(e eVar) {
        super(eVar);
    }

    public synchronized void a(EventBean eventBean) {
        this.g.incrementAndGet();
        this.f.add(eventBean);
    }

    /* access modifiers changed from: protected */
    public synchronized long a() {
        long l;
        l = a.l();
        if (l < 0) {
            this.g.incrementAndGet();
        } else {
            d();
        }
        return l;
    }

    /* access modifiers changed from: protected */
    public final long d(long j) {
        long c = a.c(j);
        this.g.decrementAndGet();
        return c;
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (this.g.get() > 0) {
            synchronized (this.f) {
                for (EventBean next : this.f) {
                    if (next.mEventTime < 0) {
                        next.correctEventTime(d(next.mEventTime));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(EventBean eventBean) {
        if (eventBean != null && eventBean.mEventTime < 0) {
            eventBean.correctEventTime(d(eventBean.mEventTime));
        }
    }
}
