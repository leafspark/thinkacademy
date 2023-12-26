package com.bonree.sdk.ap;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.LagEventInfoBean;
import com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean;
import com.bonree.sdk.agent.engine.state.f;
import com.bonree.sdk.ax.c;
import com.bonree.sdk.bs.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    private static final int D = 0;
    private static final int E = 1;
    private static final String a = "BR-LagHandler-Thread";
    private static int h = 1;
    private static int i = 2;
    private static final int j = 50;
    private static final int k = 15;
    private static final int m = 1000;
    /* access modifiers changed from: private */
    public static volatile Handler w;
    private long A;
    private long B = 0;
    private long C = 0;
    /* access modifiers changed from: private */
    public boolean F = false;
    private long G;
    /* access modifiers changed from: private */
    public long H = 0;
    /* access modifiers changed from: private */
    public long I = 0;
    private final Runnable J = new b(this);
    private final Runnable K = new c(this);
    private final Runnable L = new d(this);
    /* access modifiers changed from: private */
    public final AtomicInteger b = new AtomicInteger(40);
    /* access modifiers changed from: private */
    public final AtomicInteger c = new AtomicInteger(5);
    /* access modifiers changed from: private */
    public final AtomicInteger d = new AtomicInteger(5);
    /* access modifiers changed from: private */
    public final AtomicInteger e = new AtomicInteger(0);
    private final AtomicBoolean f = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final e g;
    /* access modifiers changed from: private */
    public volatile int l;
    private long n;
    private final List<EventBean> o;
    private LagEventInfoBean p;
    private String q = "";
    private String r = "";
    /* access modifiers changed from: private */
    public volatile ThreadDumpInfoBean s;
    /* access modifiers changed from: private */
    public volatile ThreadDumpInfoBean t;
    /* access modifiers changed from: private */
    public volatile ThreadDumpInfoBean u;
    private final ArrayList<String> v = new ArrayList<>(Arrays.asList(new String[]{"android.app.Activity", "android.support.v", "android.os.MessageQueue.nativePollOnce", "android.os.BinderProxy.transactNative", "android.graphics.HardwareRenderer.nSyncAndDrawFrame", "com.bonree.sdk", "android.view."}));
    private final double x;
    private long y;
    private long z = 0;

    a(e eVar, List<EventBean> list) {
        this.g = eVar;
        this.o = list;
        this.x = 16.6d;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        com.bonree.sdk.be.a.a().c("LagHandler values, mFrameIntervalNanos %f, mLagFpsThreshold %d.", Double.valueOf(16.6d), Integer.valueOf(this.b.get()));
        this.n = 0;
        Looper a2 = d.a().a(a);
        e();
        Handler handler = new Handler(a2);
        w = handler;
        handler.postDelayed(this.J, (long) (1000 / this.b.get()));
        w.postDelayed(this.K, (long) (10000 / this.b.get()));
    }

    private void e() {
        if (w != null) {
            w.removeCallbacks(this.J);
            w.removeCallbacks(this.K);
            w.removeCallbacks(this.L);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        com.bonree.sdk.be.a.a().c("LagHandler values, mFrameIntervalNanos %f, mLagFpsThreshold %d.", Double.valueOf(16.6d), Integer.valueOf(this.b.get()));
        this.n = 0;
        if (w != null && d.a().a(a, w)) {
            w.postDelayed(this.J, (long) (1000 / this.b.get()));
            w.postDelayed(this.K, (long) (10000 / this.b.get()));
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c() {
        e();
        d.a().b(a);
        i();
        j();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(long j2) {
        long j3 = j2;
        synchronized (this) {
            if (w != null && d.a().a(a, w)) {
                if (!this.F) {
                    w.removeCallbacks(this.J);
                    w.postDelayed(this.J, (long) (1000 / this.b.get()));
                }
                w.removeCallbacks(this.K);
                w.postDelayed(this.K, (long) (10000 / this.b.get()));
            }
            if (this.n == 0) {
                this.n = j3;
                this.y = 0;
                this.A = 0;
                this.B = 0;
                this.z = 0;
                return;
            }
            long convert = TimeUnit.MILLISECONDS.convert(j3 - this.n, TimeUnit.NANOSECONDS);
            this.y = (long) (((double) this.y) + (((double) (((int) (((double) convert) / 16.6d)) + 1)) * 16.6d));
            this.A++;
            if (this.f.get() && this.F) {
                this.z = this.y;
                this.B = this.A;
                this.n = j3;
            } else if (!this.f.get() || this.u != null) {
                long j4 = this.A - this.B;
                long j5 = this.y - this.z;
                if (convert >= ((long) (this.c.get() * 1000))) {
                    this.e.getAndAdd((int) ((j5 + this.C) / 1000));
                    this.f.set(true);
                    ThreadDumpInfoBean threadDumpInfoBean = this.u == null ? this.s : this.u;
                    long j6 = this.H;
                    if (j6 == 0) {
                        j6 = this.I;
                    }
                    a(0, threadDumpInfoBean, j6);
                } else {
                    long j7 = this.C;
                    if (j5 >= 1000 - j7) {
                        int i2 = (int) ((j7 + j5) / 1000);
                        int min = (int) Math.min(60.24096385542168d, (double) j4);
                        if (i2 > 1) {
                            this.e.getAndAdd(i2);
                            if (this.e.get() >= this.c.get()) {
                                this.f.set(true);
                                ThreadDumpInfoBean threadDumpInfoBean2 = this.u == null ? this.s : this.u;
                                long j8 = this.H;
                                if (j8 == 0) {
                                    j8 = this.I;
                                }
                                a(min, threadDumpInfoBean2, j8);
                            }
                            this.C = (j5 + this.C) % 1000;
                        } else {
                            this.C = 0;
                            if (min < this.b.get()) {
                                this.e.incrementAndGet();
                                if (this.e.get() >= this.c.get() && !this.f.get()) {
                                    this.f.set(true);
                                    ThreadDumpInfoBean threadDumpInfoBean3 = this.u == null ? this.s : this.u;
                                    long j9 = this.H;
                                    if (j9 == 0) {
                                        j9 = this.I;
                                    }
                                    a(min, threadDumpInfoBean3, j9);
                                }
                            } else {
                                this.e.set(0);
                                this.H = 0;
                                this.I = 0;
                            }
                        }
                        this.z = this.y;
                        this.B = this.A;
                    }
                }
                this.n = j3;
            } else {
                this.z = this.y;
                this.B = this.A;
                this.n = j3;
            }
        }
    }

    private void d(int i2) {
        if (i2 < this.b.get()) {
            this.e.incrementAndGet();
            if (this.e.get() >= this.c.get() && !this.f.get()) {
                this.f.set(true);
                ThreadDumpInfoBean threadDumpInfoBean = this.u == null ? this.s : this.u;
                long j2 = this.H;
                if (j2 == 0) {
                    j2 = this.I;
                }
                a(i2, threadDumpInfoBean, j2);
                return;
            }
            return;
        }
        this.e.set(0);
        this.H = 0;
        this.I = 0;
    }

    private void a(int i2, ThreadDumpInfoBean threadDumpInfoBean, long j2) {
        String str;
        if (threadDumpInfoBean != null) {
            if (threadDumpInfoBean != null && a(threadDumpInfoBean)) {
                return;
            }
            if (j2 == 0 || i2 >= this.b.get()) {
                this.u = null;
                this.s = null;
                return;
            }
            synchronized (a.class) {
                if (this.p == null) {
                    this.p = new LagEventInfoBean();
                }
                if (com.bonree.sdk.d.a.L()) {
                    str = ad.a(this.r) ? f.getEngine().getViewName() : this.r;
                } else {
                    str = ad.a(this.q) ? f.getEngine().getViewName() : this.q;
                }
                com.bonree.sdk.be.f a2 = com.bonree.sdk.be.a.a();
                Object[] objArr = new Object[6];
                objArr[0] = Boolean.valueOf(this.f.get());
                objArr[1] = str;
                objArr[2] = String.valueOf(this.u != null);
                objArr[3] = Integer.valueOf(this.e.get());
                objArr[4] = Integer.valueOf(this.c.get());
                objArr[5] = Integer.valueOf(this.b.get());
                a2.a("LagService isHappenLag %b, viewName is %s, isImportant %b, mCountLags %d, mDropFrameTime %d, mLagFpsThreshold %d.", objArr);
                this.p.mFps = i2;
                this.p.mLagTimeUs = j2;
                if (!ad.a(str)) {
                    this.p.mViewName = str;
                }
                this.p.mType = 1;
                this.p.mThreadDumpInfo = threadDumpInfoBean;
            }
            if (this.u != null) {
                this.F = true;
            }
            com.bonree.sdk.be.a.a().c("LagService cache lag not always upload, isHappenLags is %b, lagEvent is %s!", Boolean.valueOf(this.f.get()), this.p);
        }
    }

    private void a(ThreadDumpInfoBean threadDumpInfoBean, LagEventInfoBean lagEventInfoBean) {
        String str;
        if (threadDumpInfoBean != null) {
            if (threadDumpInfoBean == null || !a(threadDumpInfoBean)) {
                if (lagEventInfoBean == null) {
                    lagEventInfoBean = new LagEventInfoBean();
                }
                lagEventInfoBean.mFps = 0;
                if (com.bonree.sdk.d.a.L()) {
                    str = ad.a(this.r) ? f.getEngine().getViewName() : this.r;
                } else {
                    str = ad.a(this.q) ? f.getEngine().getViewName() : this.q;
                }
                if (!ad.a(str)) {
                    lagEventInfoBean.mViewName = str;
                }
                lagEventInfoBean.mThreadDumpInfo = threadDumpInfoBean;
                com.bonree.sdk.be.a.a().c("LagService cache main thread lag not always upload, lagEvent is %s!", lagEventInfoBean);
                a(0, lagEventInfoBean);
                return;
            }
            com.bonree.sdk.be.a.a().c("LagService cache main thread lag isInValid", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public boolean a(ThreadDumpInfoBean threadDumpInfoBean) {
        if (threadDumpInfoBean == null) {
            return true;
        }
        String a2 = com.bonree.sdk.an.a.a(threadDumpInfoBean.mDumpInfo);
        String str = threadDumpInfoBean.mDumpInfo;
        if (ad.a(a2) || ad.a(str)) {
            return true;
        }
        for (int i2 = 0; i2 < this.v.size(); i2++) {
            if (a2.contains(this.v.get(i2))) {
                return true;
            }
        }
        return false;
    }

    private void a(int i2, LagEventInfoBean lagEventInfoBean) {
        boolean z2;
        if (lagEventInfoBean == null) {
            try {
                com.bonree.sdk.be.f a2 = com.bonree.sdk.be.a.a();
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(lagEventInfoBean == null);
                a2.a("onMakePackage() eventInfoBean is inValid eventInfoBean is null %b.", objArr);
            } catch (Exception e2) {
                com.bonree.sdk.be.a.a().e("LagService onMakePackage is error %s.", e2.getMessage());
            }
        } else if (lagEventInfoBean.mThreadDumpInfo == null) {
            com.bonree.sdk.be.f a3 = com.bonree.sdk.be.a.a();
            Object[] objArr2 = new Object[1];
            objArr2[0] = Boolean.valueOf(lagEventInfoBean.mThreadDumpInfo == null);
            a3.a("onMakePackage() eventInfoBean is inValid eventInfoBean.mThreadDumpInfo is null %b.", objArr2);
        } else {
            e eVar = this.g;
            if (eVar != null && eVar.e()) {
                if (w != null) {
                    lagEventInfoBean.mType = i2;
                    EventBean eventBean = new EventBean();
                    eventBean.mEventType = BaseEventInfo.EVENT_TYPE_LAG;
                    eventBean.mEventTime = lagEventInfoBean.mLagTimeUs;
                    eventBean.mStateIndex = eventBean.getStateIndex();
                    eventBean.mEventInfo = lagEventInfoBean;
                    if (this.o.size() >= 50) {
                        this.o.remove(0);
                    }
                    eventBean.uploadStateKey();
                    eventBean.mTraceInfoList = c.h().e();
                    this.o.add(eventBean);
                    if (i2 == 1) {
                        z2 = true;
                    } else {
                        z2 = this.f.get();
                    }
                    com.bonree.sdk.be.a.a().c("LagService Lag makePackage always upload, isHappenLags is %b, type is %d, lagEvent is %s!", Boolean.valueOf(z2), Integer.valueOf(i2), eventBean);
                }
            }
        }
    }

    private void f() {
        if (this.f.get()) {
            synchronized (a.class) {
                if (this.f.get()) {
                    a(1, this.p);
                    this.f.set(false);
                    this.F = false;
                }
            }
        }
    }

    public final void a(int i2) {
        this.b.set(i2);
    }

    public final void b(int i2) {
        this.c.set(i2);
    }

    public final void c(int i2) {
        this.d.set(i2);
        this.l = this.d.get() >= 10 ? 1000 : 15;
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        if (message != null) {
            if (message.what == 1 || message.what == 2) {
                f();
                j();
            }
        }
    }

    private void g() {
        f();
        j();
    }

    private void h() {
        f();
        j();
    }

    /* access modifiers changed from: package-private */
    public final List<EventBean> a(boolean z2) {
        ArrayList arrayList;
        synchronized (a.class) {
            if (z2) {
                f();
                j();
            }
            e eVar = this.g;
            if (eVar != null) {
                eVar.d();
            }
            arrayList = new ArrayList(this.o);
            i();
        }
        return arrayList;
    }

    private void i() {
        if (!this.o.isEmpty()) {
            synchronized (a.class) {
                this.o.clear();
            }
        }
    }

    private void j() {
        this.e.set(0);
        this.H = 0;
        this.I = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.C = 0;
        this.f.set(false);
        this.F = false;
        if (this.p != null) {
            synchronized (a.class) {
                this.p = null;
            }
        }
    }

    public final void a(String str) {
        this.q = str;
    }

    public final void b(String str) {
        this.r = str;
    }

    /* access modifiers changed from: package-private */
    public final void b(long j2) {
        if (w != null && d.a().a(a, w)) {
            this.G = j2;
            w.postDelayed(this.L, (long) ((this.d.get() * 1000) - this.l));
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(long j2) {
        if (w != null) {
            w.removeCallbacks(this.L);
            long j3 = this.G;
            if (j3 >= 0 && j2 - j3 > ((long) (this.d.get() * 1000)) && this.t != null) {
                com.bonree.sdk.be.a.a().a("BrLagPrinter the main thread block  %s ms, mMainThreadLagTime %s s, viewName is %s.", Long.valueOf(j2 - this.G), Integer.valueOf(this.d.get()), com.bonree.sdk.d.a.L() ? this.r : this.q);
            }
        }
    }

    static /* synthetic */ void a(a aVar, ThreadDumpInfoBean threadDumpInfoBean, LagEventInfoBean lagEventInfoBean) {
        String str;
        if (threadDumpInfoBean == null) {
            return;
        }
        if (threadDumpInfoBean == null || !aVar.a(threadDumpInfoBean)) {
            if (lagEventInfoBean == null) {
                lagEventInfoBean = new LagEventInfoBean();
            }
            lagEventInfoBean.mFps = 0;
            if (com.bonree.sdk.d.a.L()) {
                str = ad.a(aVar.r) ? f.getEngine().getViewName() : aVar.r;
            } else {
                str = ad.a(aVar.q) ? f.getEngine().getViewName() : aVar.q;
            }
            if (!ad.a(str)) {
                lagEventInfoBean.mViewName = str;
            }
            lagEventInfoBean.mThreadDumpInfo = threadDumpInfoBean;
            com.bonree.sdk.be.a.a().c("LagService cache main thread lag not always upload, lagEvent is %s!", lagEventInfoBean);
            aVar.a(0, lagEventInfoBean);
            return;
        }
        com.bonree.sdk.be.a.a().c("LagService cache main thread lag isInValid", new Object[0]);
    }
}
