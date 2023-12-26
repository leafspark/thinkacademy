package com.bonree.sdk.aq;

import android.os.Message;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.external.AppStateInfo;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.ap.a;
import com.bonree.sdk.k.c;
import com.igexin.assist.control.fcm.GTJobService;
import java.util.concurrent.atomic.AtomicInteger;

public class g {
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 4;
    private static int f = 5;
    private static int g = 6;
    private static int h = 7;
    private static int i = 8;
    private static int j = 9;
    String a;
    private final h k;
    private final c l;
    private final e m;
    private final j n;
    private EventBean o;
    private volatile boolean p;
    private final AtomicInteger q = new AtomicInteger(0);

    g(h hVar) {
        this.k = hVar;
        this.l = new c(this);
        this.m = new e(this);
        this.n = new j(this);
    }

    /* access modifiers changed from: package-private */
    public final void a(EventBean eventBean) {
        synchronized (a.class) {
            if (this.o == null) {
                this.o = eventBean;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final EventBean a(boolean z) {
        EventBean eventBean;
        synchronized (a.class) {
            if (z) {
                long b2 = com.bonree.sdk.d.a.b();
                long a2 = a(0);
                com.bonree.sdk.be.a.a().c("LaunchService LaunchEvent happen Crash timeStamp is %s, elapsedRealtime is %s.", Long.valueOf(a2), Long.valueOf(b2));
                this.n.a(b2, a2);
                this.l.a(b2, a2);
                this.m.a(b2, a2);
            }
            g();
            eventBean = this.o;
            i();
        }
        return eventBean;
    }

    /* access modifiers changed from: package-private */
    public final long a(long j2) {
        if (j2 == 0) {
            j2 = com.bonree.sdk.d.a.l();
        }
        if (j2 < 0) {
            this.q.incrementAndGet();
        } else {
            g();
        }
        return j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r8 = this;
            com.bonree.sdk.agent.business.entity.EventBean r0 = r8.o
            if (r0 == 0) goto L_0x007d
            java.util.concurrent.atomic.AtomicInteger r0 = r8.q
            int r0 = r0.get()
            if (r0 > 0) goto L_0x000d
            goto L_0x007d
        L_0x000d:
            java.lang.Class<com.bonree.sdk.aq.g> r0 = com.bonree.sdk.aq.g.class
            monitor-enter(r0)
            com.bonree.sdk.agent.business.entity.EventBean r1 = r8.o     // Catch:{ all -> 0x007a }
            if (r1 != 0) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            return
        L_0x0016:
            long r1 = r1.mEventTime     // Catch:{ all -> 0x007a }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x002e
            java.util.concurrent.atomic.AtomicInteger r1 = r8.q     // Catch:{ all -> 0x007a }
            r1.decrementAndGet()     // Catch:{ all -> 0x007a }
            com.bonree.sdk.agent.business.entity.EventBean r1 = r8.o     // Catch:{ all -> 0x007a }
            long r5 = r1.mEventTime     // Catch:{ all -> 0x007a }
            long r5 = com.bonree.sdk.d.a.c((long) r5)     // Catch:{ all -> 0x007a }
            r1.correctEventTime(r5)     // Catch:{ all -> 0x007a }
        L_0x002e:
            com.bonree.sdk.agent.business.entity.EventBean r1 = r8.o     // Catch:{ all -> 0x007a }
            com.bonree.sdk.agent.business.entity.BaseEventInfo r1 = r1.mEventInfo     // Catch:{ all -> 0x007a }
            com.bonree.sdk.agent.business.entity.LaunchEventInfoBean r1 = (com.bonree.sdk.agent.business.entity.LaunchEventInfoBean) r1     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x0078
            java.util.List<com.bonree.sdk.agent.business.entity.ThreadMethodInfoBean> r2 = r1.mThreadMethodInfo     // Catch:{ all -> 0x007a }
            if (r2 != 0) goto L_0x003b
            goto L_0x0078
        L_0x003b:
            java.util.List<com.bonree.sdk.agent.business.entity.ThreadMethodInfoBean> r1 = r1.mThreadMethodInfo     // Catch:{ all -> 0x007a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x007a }
        L_0x0041:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0076
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x007a }
            com.bonree.sdk.agent.business.entity.ThreadMethodInfoBean r2 = (com.bonree.sdk.agent.business.entity.ThreadMethodInfoBean) r2     // Catch:{ all -> 0x007a }
            java.util.List<com.bonree.sdk.agent.business.entity.MethodInfoBean> r2 = r2.mMethodInfo     // Catch:{ all -> 0x007a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x007a }
        L_0x0053:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x007a }
            if (r5 == 0) goto L_0x0041
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x007a }
            com.bonree.sdk.agent.business.entity.MethodInfoBean r5 = (com.bonree.sdk.agent.business.entity.MethodInfoBean) r5     // Catch:{ all -> 0x007a }
            long r6 = r5.mStartTimeUs     // Catch:{ all -> 0x007a }
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0053
            long r6 = r5.mStartTimeUs     // Catch:{ all -> 0x007a }
            long r6 = com.bonree.sdk.d.a.c((long) r6)     // Catch:{ all -> 0x007a }
            r5.mStartTimeUs = r6     // Catch:{ all -> 0x007a }
            long r6 = r5.mEndTimeUs     // Catch:{ all -> 0x007a }
            long r6 = com.bonree.sdk.d.a.c((long) r6)     // Catch:{ all -> 0x007a }
            r5.mEndTimeUs = r6     // Catch:{ all -> 0x007a }
            goto L_0x0053
        L_0x0076:
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            return
        L_0x0078:
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            return
        L_0x007a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            throw r1
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.aq.g.g():void");
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.n.a.get();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.n.b.get();
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        try {
            Object obj = message.obj;
            switch (message.what) {
                case 1:
                    if (obj != null) {
                        b bVar = (b) obj;
                        this.n.a(bVar);
                        this.l.a(bVar);
                        if (AppStateInfo.RECORD_CUSTOM_LAUNCH_END.equals(bVar.c())) {
                            b(false);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (obj != null) {
                        com.bonree.sdk.z.a aVar = (com.bonree.sdk.z.a) obj;
                        this.a = aVar.a();
                        this.n.a(aVar);
                        this.l.a(aVar);
                        this.m.a(aVar);
                        return;
                    }
                    return;
                case 3:
                    if (obj != null) {
                        com.bonree.sdk.aa.a aVar2 = (com.bonree.sdk.aa.a) obj;
                        this.n.a(aVar2);
                        this.l.a(aVar2);
                        this.m.a(aVar2);
                        return;
                    }
                    return;
                case 4:
                    if (obj != null) {
                        c cVar = (c) obj;
                        this.n.a(cVar);
                        this.l.a(cVar);
                        this.m.a(cVar);
                        return;
                    }
                    return;
                case 5:
                    this.l.a();
                    return;
                case 6:
                    b(true);
                    return;
                case 7:
                    if (obj != null) {
                        e eVar = (e) obj;
                        this.n.a(eVar);
                        this.m.a(eVar);
                        return;
                    }
                    return;
                case 8:
                    if (obj != null) {
                        com.bonree.sdk.x.a aVar3 = (com.bonree.sdk.x.a) obj;
                        this.a = aVar3.a();
                        this.n.a(aVar3);
                        this.l.a(aVar3);
                        this.m.a(aVar3);
                        return;
                    }
                    return;
                case 9:
                    if (obj != null) {
                        com.bonree.sdk.y.a aVar4 = (com.bonree.sdk.y.a) obj;
                        this.n.a(aVar4);
                        this.l.a(aVar4);
                        this.m.a(aVar4);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e2) {
            com.bonree.sdk.be.a.a().a("LaunchService handleWork is error %s.", (Throwable) e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        try {
            if (!this.p) {
                long b2 = this.l.b();
                long j2 = 0;
                if (b2 > 0) {
                    j2 = com.bonree.sdk.d.a.b() - b2;
                }
                long j3 = GTJobService.WAIT_TIME - j2;
                this.k.a(6, j3);
                this.p = true;
                com.bonree.sdk.be.a.a().c("LaunchService startCustomLaunchEnd Timeout Listener, delayTime is %d.", Long.valueOf(j3));
            }
        } catch (Exception e2) {
            com.bonree.sdk.be.a.a().e("LaunchService startCustomLaunchEnd Timeout Listener error %s.", e2.toString());
        }
    }

    private void b(boolean z) {
        h hVar;
        if (!z && (hVar = this.k) != null) {
            hVar.a(6);
        }
        com.bonree.sdk.be.a.a().a("LaunchService handleColdLaunchEnd is Timeout %b.", Boolean.valueOf(z));
        this.n.d();
        this.l.a(z);
    }

    private void a(b bVar) {
        this.n.a(bVar);
        this.l.a(bVar);
        if (AppStateInfo.RECORD_CUSTOM_LAUNCH_END.equals(bVar.c())) {
            b(false);
        }
    }

    private void a(com.bonree.sdk.z.a aVar) {
        this.a = aVar.a();
        this.n.a(aVar);
        this.l.a(aVar);
        this.m.a(aVar);
    }

    private void a(com.bonree.sdk.x.a aVar) {
        this.a = aVar.a();
        this.n.a(aVar);
        this.l.a(aVar);
        this.m.a(aVar);
    }

    private void a(com.bonree.sdk.y.a aVar) {
        this.n.a(aVar);
        this.l.a(aVar);
        this.m.a(aVar);
    }

    private void a(com.bonree.sdk.aa.a aVar) {
        this.n.a(aVar);
        this.l.a(aVar);
        this.m.a(aVar);
    }

    private void b(c cVar) {
        this.n.a(cVar);
        this.l.a(cVar);
        this.m.a(cVar);
    }

    private void a(e eVar) {
        this.n.a(eVar);
        this.m.a(eVar);
    }

    private void h() {
        long b2 = com.bonree.sdk.d.a.b();
        long a2 = a(0);
        com.bonree.sdk.be.a.a().c("LaunchService LaunchEvent happen Crash timeStamp is %s, elapsedRealtime is %s.", Long.valueOf(a2), Long.valueOf(b2));
        this.n.a(b2, a2);
        this.l.a(b2, a2);
        this.m.a(b2, a2);
    }

    /* access modifiers changed from: package-private */
    public final j d() {
        return this.n;
    }

    private void i() {
        if (this.o != null) {
            synchronized (a.class) {
                this.o = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.l.a(i2);
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        this.m.a(i2);
    }

    public final void e() {
        c();
        this.l.c();
        this.n.e();
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        i();
        this.p = false;
        this.l.d();
        this.m.a();
        this.n.c();
    }

    public final void b(long j2) {
        this.l.d(j2);
    }

    public final boolean a(c cVar) {
        return this.l.b(cVar);
    }
}
