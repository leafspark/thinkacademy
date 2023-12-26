package com.bonree.sdk.aq;

import com.bonree.sdk.agent.business.entity.LaunchEventInfoBean;
import com.bonree.sdk.k.c;
import com.bonree.sdk.y.a;

public final class e extends a {
    private static final int e = 30000;
    private volatile boolean f;
    private long g;
    private String h;

    public final void a(a aVar) {
    }

    public final /* bridge */ /* synthetic */ void a(com.bonree.sdk.aa.a aVar) {
        super.a(aVar);
    }

    public final /* bridge */ /* synthetic */ void a(b bVar) {
        super.a(bVar);
    }

    public final /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    e(g gVar) {
        super(gVar);
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        if (aVar.e() == 0) {
            if (this.g <= 0) {
                return;
            }
            if (com.bonree.sdk.z.a.l.equals(aVar.c()) || com.bonree.sdk.z.a.o.equals(aVar.c())) {
                this.c = aVar.f();
                this.h = aVar.a();
                a(aVar.j());
                LaunchEventInfoBean launchEventInfoBean = new LaunchEventInfoBean();
                launchEventInfoBean.mType = LaunchEventInfoBean.LAUNCH_TYPE_HOT;
                this.d.mEventInfo = launchEventInfoBean;
                com.bonree.sdk.ax.c.h().a(this.d);
            }
        } else if (1 == aVar.e() && com.bonree.sdk.z.a.n.equals(aVar.c())) {
            b(aVar.f());
            a();
        }
    }

    public final void a(com.bonree.sdk.agent.engine.state.e eVar) {
        if (eVar == com.bonree.sdk.agent.engine.state.e.BACKGROUND) {
            this.g = com.bonree.sdk.d.a.b();
        } else if (eVar == com.bonree.sdk.agent.engine.state.e.FOREGROUND) {
            d(com.bonree.sdk.d.a.b());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(long r8) {
        /*
            r7 = this;
            long r0 = r7.c
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            r4 = 0
            if (r0 <= 0) goto L_0x001a
            long r5 = r7.g
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x001a
            long r2 = r8 - r5
            r5 = 30000(0x7530, double:1.4822E-319)
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x001a
            r0 = r1
            goto L_0x001b
        L_0x001a:
            r0 = r4
        L_0x001b:
            r7.f = r0
            com.bonree.sdk.aq.g r0 = r7.a
            if (r0 == 0) goto L_0x004c
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r7.h
            r2[r4] = r3
            long r3 = r7.g
            long r8 = r8 - r3
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r2[r1] = r8
            r8 = 2
            boolean r9 = r7.f
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r2[r8] = r9
            r8 = 3
            long r3 = r7.c
            java.lang.Long r9 = java.lang.Long.valueOf(r3)
            r2[r8] = r9
            java.lang.String r8 = "LaunchService activity is %s, background time is %s isHotLaunch %s. mLaunchStartTimeMs %s"
            r0.c(r8, r2)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.aq.e.d(long):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f     // Catch:{ all -> 0x007f }
            if (r0 == 0) goto L_0x007d
            com.bonree.sdk.agent.business.entity.EventBean r0 = r7.d     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x000a
            goto L_0x007d
        L_0x000a:
            super.b(r8)     // Catch:{ all -> 0x007f }
            com.bonree.sdk.agent.business.entity.EventBean r0 = r7.d     // Catch:{ all -> 0x007f }
            com.bonree.sdk.agent.business.entity.BaseEventInfo r0 = r0.mEventInfo     // Catch:{ all -> 0x007f }
            com.bonree.sdk.agent.business.entity.LaunchEventInfoBean r0 = (com.bonree.sdk.agent.business.entity.LaunchEventInfoBean) r0     // Catch:{ all -> 0x007f }
            java.lang.Integer r1 = com.bonree.sdk.agent.business.entity.LaunchEventInfoBean.LAUNCH_TYPE_HOT     // Catch:{ all -> 0x007f }
            r0.mType = r1     // Catch:{ all -> 0x007f }
            long r1 = r7.c     // Catch:{ all -> 0x007f }
            long r1 = r8 - r1
            long r1 = com.bonree.sdk.bs.ad.a((long) r1)     // Catch:{ all -> 0x007f }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x007f }
            r0.mLoadTime = r1     // Catch:{ all -> 0x007f }
            java.lang.Long r1 = r0.mLoadTime     // Catch:{ all -> 0x007f }
            long r1 = r1.longValue()     // Catch:{ all -> 0x007f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            boolean r1 = r7.c(r1)     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0046
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x007f }
            r0.mIsSlow = r1     // Catch:{ all -> 0x007f }
            com.bonree.sdk.aq.g r1 = r7.a     // Catch:{ all -> 0x007f }
            com.bonree.sdk.aq.j r1 = r1.d()     // Catch:{ all -> 0x007f }
            long r2 = r7.c     // Catch:{ all -> 0x007f }
            java.util.List r1 = r1.b(r2, r8)     // Catch:{ all -> 0x007f }
            r0.mThreadMethodInfo = r1     // Catch:{ all -> 0x007f }
        L_0x0046:
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x007f }
            java.lang.String r1 = "LaunchService HotEvent eventTime %s, loadtime-start-elapsedRealtime %s loadtime-end-elapsedRealtime %s, name %s"
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x007f }
            com.bonree.sdk.agent.business.entity.EventBean r3 = r7.d     // Catch:{ all -> 0x007f }
            long r3 = r3.mEventTime     // Catch:{ all -> 0x007f }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x007f }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x007f }
            r3 = 1
            long r5 = r7.c     // Catch:{ all -> 0x007f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x007f }
            r2[r3] = r5     // Catch:{ all -> 0x007f }
            r3 = 2
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x007f }
            r2[r3] = r8     // Catch:{ all -> 0x007f }
            r8 = 3
            java.lang.String r9 = r7.h     // Catch:{ all -> 0x007f }
            r2[r8] = r9     // Catch:{ all -> 0x007f }
            r0.c(r1, r2)     // Catch:{ all -> 0x007f }
            com.bonree.sdk.aq.g r8 = r7.a     // Catch:{ all -> 0x007f }
            com.bonree.sdk.agent.business.entity.EventBean r9 = r7.d     // Catch:{ all -> 0x007f }
            r8.a((com.bonree.sdk.agent.business.entity.EventBean) r9)     // Catch:{ all -> 0x007f }
            r7.f = r4     // Catch:{ all -> 0x007f }
            monitor-exit(r7)
            return
        L_0x007d:
            monitor-exit(r7)
            return
        L_0x007f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.aq.e.b(long):void");
    }

    public final void a(long j, long j2) {
        d(com.bonree.sdk.d.a.b());
        b(j);
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        if (aVar.e() == 0) {
            if (this.g <= 0) {
                return;
            }
            if (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.n.equals(aVar.c())) {
                this.c = aVar.f();
                this.h = aVar.a();
                a(aVar.j());
            }
        } else if (1 == aVar.e() && com.bonree.sdk.x.a.m.equals(aVar.c())) {
            b(aVar.f());
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        this.c = 0;
        this.g = 0;
        this.f = false;
    }
}
