package com.bonree.sdk.aq;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.business.entity.LaunchEventInfoBean;
import com.bonree.sdk.agent.engine.external.AppStateInfo;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.y.a;
import com.igexin.assist.control.fcm.GTJobService;

public final class c extends a {
    private static final int e = 15000;
    private static int f = 30000;
    private static int g = 35000;
    private volatile boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private long n;
    private Handler o;
    /* access modifiers changed from: private */
    public volatile boolean p;
    private final Runnable q = new d(this);

    public final void a(a aVar) {
    }

    public final /* bridge */ /* synthetic */ void a(com.bonree.sdk.aa.a aVar) {
        super.a(aVar);
    }

    public final /* bridge */ /* synthetic */ void a(e eVar) {
        super.a(eVar);
    }

    public final /* bridge */ /* synthetic */ void a(com.bonree.sdk.k.c cVar) {
        super.a(cVar);
    }

    c(g gVar) {
        super(gVar);
    }

    public final void a(b bVar) {
        String str = com.bonree.sdk.d.a.L() ? AppStateInfo.RECORD_LAUNCH_TIME_OHOS : AppStateInfo.RECORD_LAUNCH_TIME;
        if (bVar.e() == 0 && (str.equals(bVar.c()) || AppStateInfo.ATTACH_BASE_CONTEXT.equals(bVar.c()))) {
            if (str.equals(bVar.c())) {
                this.i = true;
            }
            this.h = true;
            this.c = bVar.q();
            if (this.l) {
                this.a.c();
            }
            this.o = new Handler(Looper.myLooper());
            if (!this.p) {
                this.p = this.o.postDelayed(this.q, GTJobService.WAIT_TIME);
            }
            a(bVar.r());
            LaunchEventInfoBean launchEventInfoBean = new LaunchEventInfoBean();
            launchEventInfoBean.mType = LaunchEventInfoBean.LAUNCH_TYPE_COLD;
            this.d.mEventInfo = launchEventInfoBean;
            com.bonree.sdk.ax.c.h().a(this.d);
        } else if ((1 == bVar.e() && (com.bonree.sdk.z.a.l.equals(bVar.c()) || AppStateInfo.ON_INITIALIZE.equals(bVar.c()))) || (1 == bVar.e() && str.equals(bVar.c()))) {
            this.m = bVar.f();
        }
    }

    public final boolean b(com.bonree.sdk.k.c cVar) {
        return this.h && cVar.f() - this.c > GTJobService.WAIT_TIME;
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        if (!this.h) {
            com.bonree.sdk.be.a.a().a("LaunchService ColdEvent ColdLaunch is false.", new Object[0]);
        } else if (!this.l && !this.k && aVar.e() == 0 && com.bonree.sdk.z.a.l.equals(aVar.c())) {
            e(aVar.f() - this.m);
            f(aVar.f() - this.c);
        } else if (1 == aVar.e() && com.bonree.sdk.z.a.n.equals(aVar.c())) {
            com.bonree.sdk.be.a.a().a("LaunchService ColdEvent onResume is end , isCustomColdEnd %s, launchThresholdMs %s, isOnResumeEnd %s.", Boolean.valueOf(this.l), Integer.valueOf(this.b), Boolean.valueOf(this.k));
            if (!this.l && !this.k) {
                if (Build.VERSION.SDK_INT >= 29 && this.o.hasCallbacks(this.q)) {
                    this.o.removeCallbacks(this.q);
                }
                this.n = aVar.f();
                if (this.b > 0) {
                    b(this.n);
                    d();
                }
                this.k = true;
            }
        }
    }

    private void e(long j2) {
        if (this.m > 0 && j2 >= 15000) {
            com.bonree.sdk.be.a.a().c("LaunchService ColdEvent background run time is %s.", Long.valueOf(j2));
            this.j = true;
        }
    }

    private void f(long j2) {
        if (this.m == 0 && this.i && j2 >= 15000) {
            com.bonree.sdk.be.a.a().c("LaunchService ColdEvent recordLaunchTime background run time is %s.", Long.valueOf(j2));
            this.j = true;
        }
    }

    public final void a(boolean z) {
        if (this.h && this.d != null) {
            if (z) {
                this.n = (this.c > 0 ? this.c : com.bonree.sdk.d.a.b()) + GTJobService.WAIT_TIME;
            } else {
                this.n = com.bonree.sdk.d.a.b();
            }
            com.bonree.sdk.be.a.a().a("LaunchService ColdEvent onCustomColdEnd isTimeout %s", Boolean.valueOf(z));
            b(this.n);
            d();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d(long j2) {
        if (this.h) {
            b(j2);
            d();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 1
            r1 = 0
            android.os.Handler r2 = r7.o     // Catch:{ Exception -> 0x00d8 }
            if (r2 == 0) goto L_0x000e
            java.lang.Runnable r3 = r7.q     // Catch:{ Exception -> 0x00d8 }
            r2.removeCallbacks(r3)     // Catch:{ Exception -> 0x00d8 }
            r7.p = r1     // Catch:{ Exception -> 0x00d8 }
        L_0x000e:
            boolean r2 = r7.h     // Catch:{ Exception -> 0x00d8 }
            if (r2 == 0) goto L_0x00d4
            com.bonree.sdk.agent.business.entity.EventBean r2 = r7.d     // Catch:{ Exception -> 0x00d8 }
            if (r2 != 0) goto L_0x0018
            goto L_0x00d4
        L_0x0018:
            super.b(r8)     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.agent.business.entity.EventBean r2 = r7.d     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.agent.business.entity.BaseEventInfo r2 = r2.mEventInfo     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.agent.business.entity.LaunchEventInfoBean r2 = (com.bonree.sdk.agent.business.entity.LaunchEventInfoBean) r2     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.d.e r3 = com.bonree.sdk.d.e.d()     // Catch:{ Exception -> 0x00d8 }
            boolean r3 = r3.x()     // Catch:{ Exception -> 0x00d8 }
            if (r3 == 0) goto L_0x0030
            java.lang.Integer r3 = com.bonree.sdk.agent.business.entity.LaunchEventInfoBean.LAUNCH_TYPE_FIRST     // Catch:{ Exception -> 0x00d8 }
            r2.mType = r3     // Catch:{ Exception -> 0x00d8 }
            goto L_0x0034
        L_0x0030:
            java.lang.Integer r3 = com.bonree.sdk.agent.business.entity.LaunchEventInfoBean.LAUNCH_TYPE_COLD     // Catch:{ Exception -> 0x00d8 }
            r2.mType = r3     // Catch:{ Exception -> 0x00d8 }
        L_0x0034:
            long r3 = r7.c     // Catch:{ Exception -> 0x00d8 }
            long r3 = r8 - r3
            long r3 = com.bonree.sdk.bs.ad.a((long) r3)     // Catch:{ Exception -> 0x00d8 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x00d8 }
            r2.mLoadTime = r3     // Catch:{ Exception -> 0x00d8 }
            java.lang.Long r3 = r2.mLoadTime     // Catch:{ Exception -> 0x00d8 }
            long r3 = r3.longValue()     // Catch:{ Exception -> 0x00d8 }
            r5 = 35000000(0x2160ec0, double:1.72922976E-316)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            int r3 = r7.b     // Catch:{ Exception -> 0x00d8 }
            double r3 = (double) r3     // Catch:{ Exception -> 0x00d8 }
            r5 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r3 = r3 * r5
            double r3 = java.lang.Math.ceil(r3)     // Catch:{ Exception -> 0x00d8 }
            long r3 = (long) r3     // Catch:{ Exception -> 0x00d8 }
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0068
            long r3 = com.bonree.sdk.bs.ad.a((long) r3)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x006a
        L_0x0068:
            r3 = 999(0x3e7, double:4.936E-321)
        L_0x006a:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x00d8 }
            r2.mLoadTime = r3     // Catch:{ Exception -> 0x00d8 }
            goto L_0x0092
        L_0x0071:
            java.lang.Long r3 = r2.mLoadTime     // Catch:{ Exception -> 0x00d8 }
            long r3 = r3.longValue()     // Catch:{ Exception -> 0x00d8 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            boolean r3 = r7.c(r3)     // Catch:{ Exception -> 0x00d8 }
            if (r3 == 0) goto L_0x0092
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00d8 }
            r2.mIsSlow = r3     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.aq.g r3 = r7.a     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.aq.j r3 = r3.d()     // Catch:{ Exception -> 0x00d8 }
            long r4 = r7.c     // Catch:{ Exception -> 0x00d8 }
            java.util.List r3 = r3.b(r4, r8)     // Catch:{ Exception -> 0x00d8 }
            r2.mThreadMethodInfo = r3     // Catch:{ Exception -> 0x00d8 }
        L_0x0092:
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r3 = "LaunchService ColdEvent eventTime %s, loadtime-start-elapsedRealtime %s loadtime-end-elapsedRealtime %s, name %s."
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.agent.business.entity.EventBean r5 = r7.d     // Catch:{ Exception -> 0x00d8 }
            long r5 = r5.mEventTime     // Catch:{ Exception -> 0x00d8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00d8 }
            r4[r1] = r5     // Catch:{ Exception -> 0x00d8 }
            long r5 = r7.c     // Catch:{ Exception -> 0x00d8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00d8 }
            r4[r0] = r5     // Catch:{ Exception -> 0x00d8 }
            r5 = 2
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x00d8 }
            r4[r5] = r8     // Catch:{ Exception -> 0x00d8 }
            r8 = 3
            com.bonree.sdk.aq.g r9 = r7.a     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r9 = r9.a     // Catch:{ Exception -> 0x00d8 }
            r4[r8] = r9     // Catch:{ Exception -> 0x00d8 }
            r2.c(r3, r4)     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.aq.g r8 = r7.a     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.agent.business.entity.EventBean r9 = r7.d     // Catch:{ Exception -> 0x00d8 }
            r8.a((com.bonree.sdk.agent.business.entity.EventBean) r9)     // Catch:{ Exception -> 0x00d8 }
            r7.h = r1     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.aq.g r8 = r7.a     // Catch:{ Exception -> 0x00d8 }
            com.bonree.sdk.aq.j r8 = r8.d()     // Catch:{ Exception -> 0x00d8 }
            java.util.concurrent.atomic.AtomicBoolean r8 = r8.a     // Catch:{ Exception -> 0x00d8 }
            r8.set(r1)     // Catch:{ Exception -> 0x00d8 }
            monitor-exit(r7)
            return
        L_0x00d4:
            monitor-exit(r7)
            return
        L_0x00d6:
            r8 = move-exception
            goto L_0x00ec
        L_0x00d8:
            r8 = move-exception
            com.bonree.sdk.be.f r9 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "LaunchService ColdEvent onClosePackage is error %s."
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00d6 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00d6 }
            r0[r1] = r8     // Catch:{ all -> 0x00d6 }
            r9.e(r2, r0)     // Catch:{ all -> 0x00d6 }
            monitor-exit(r7)
            return
        L_0x00ec:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.aq.c.b(long):void");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.k && this.h && !this.l) {
            b(this.n);
            com.bonree.sdk.be.a.a().a("LaunchService ColdEvent is ClosePackage when setColdLaunchThreshold, isCustomColdEnd %s, launchThresholdMs %s ", Boolean.valueOf(this.l), Integer.valueOf(this.b));
            d();
        }
    }

    public final void a(long j2, long j3) {
        if (this.h) {
            this.n = j2;
            b(j2);
        }
        d();
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        if (!this.h) {
            com.bonree.sdk.be.a.a().a("LaunchService ColdEvent ColdLaunch is false.", new Object[0]);
        } else if (!this.l && !this.k && aVar.e() == 0 && com.bonree.sdk.x.a.l.equals(aVar.c())) {
            e(aVar.f() - this.m);
            f(aVar.f() - this.c);
        } else if (1 == aVar.e() && com.bonree.sdk.x.a.m.equals(aVar.c())) {
            com.bonree.sdk.be.a.a().a("LaunchService ColdEvent onResume is end , isCustomColdEnd %s, launchThresholdMs %s, isOnResumeEnd %s.", Boolean.valueOf(this.l), Integer.valueOf(this.b), Boolean.valueOf(this.k));
            if (!this.l && !this.k) {
                if (Build.VERSION.SDK_INT >= 29 && this.o.hasCallbacks(this.q)) {
                    this.o.removeCallbacks(this.q);
                }
                this.n = aVar.f();
                if (this.b > 0) {
                    b(this.n);
                    d();
                }
                this.k = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final long b() {
        return this.c;
    }

    public final void c() {
        this.l = true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d() {
        this.h = false;
        this.c = 0;
        this.m = 0;
        this.n = 0;
        this.k = false;
        this.j = false;
        this.l = false;
        if (this.o != null && this.p) {
            this.o.removeCallbacks(this.q);
        }
        this.o = null;
    }
}
