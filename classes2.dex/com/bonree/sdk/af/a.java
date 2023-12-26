package com.bonree.sdk.af;

import android.os.Looper;
import android.text.TextUtils;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.business.entity.CrashEventInfoBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean;
import com.bonree.sdk.agent.engine.crash.NativeCrashEngine;
import com.bonree.sdk.agent.engine.crash.b;
import com.bonree.sdk.agent.engine.crash.c;
import com.bonree.sdk.bf.d;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.d.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReadWriteLock;

public final class a extends f implements b, c {
    private static final String h = "CrashService";
    private static final byte i = 0;
    private static final byte j = 1;
    private static final byte k = 2;
    private static final int l = 200;
    private static final int m = 1000;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private static final int q = 4;
    private volatile EventBean A = new EventBean();
    public volatile boolean g;
    private final String r = "Crash";
    private byte s = i;
    private final AtomicBoolean t = new AtomicBoolean(true);
    private final AtomicBoolean u = new AtomicBoolean(true);
    private final AtomicBoolean v = new AtomicBoolean(true);
    private final AtomicLong w = new AtomicLong(86400000);
    private com.bonree.sdk.ak.a x;
    private com.bonree.sdk.aj.a y;
    private ReadWriteLock z;

    /* renamed from: com.bonree.sdk.af.a$a  reason: collision with other inner class name */
    public interface C0004a {
        void a();

        void b();

        void c();

        d d();
    }

    private static String b(String str) {
        return str == null ? "" : str;
    }

    public a(e eVar) {
        super(eVar);
        this.f = Collections.synchronizedList(new ArrayList());
    }

    public final CrashEventInfoBean a(CrashEventInfoBean crashEventInfoBean) {
        if (crashEventInfoBean != null) {
            try {
                if (!ad.a(crashEventInfoBean.nativeCrashLogPath)) {
                    n();
                    return this.x.a(crashEventInfoBean);
                }
            } catch (Throwable th) {
                this.c.a("CrashService updateCrashEvent error %s", th);
                return crashEventInfoBean;
            }
        }
        this.c.c("CrashServiceupdateCrashEventBean null", new Object[0]);
        return null;
    }

    public final EventBean e() {
        return c(2);
    }

    public final EventBean g() {
        return c(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.agent.business.entity.EventBean c(int r7) {
        /*
            r6 = this;
            com.bonree.sdk.agent.business.entity.EventBean r0 = r6.A
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r6)
            com.bonree.sdk.agent.business.entity.EventBean r0 = r6.A     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r6)     // Catch:{ all -> 0x004a }
            return r1
        L_0x000d:
            com.bonree.sdk.agent.business.entity.EventBean r0 = r6.A     // Catch:{ all -> 0x004a }
            long r2 = r0.mEventTime     // Catch:{ all -> 0x004a }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0024
            com.bonree.sdk.agent.business.entity.EventBean r0 = r6.A     // Catch:{ all -> 0x004a }
            com.bonree.sdk.agent.business.entity.EventBean r2 = r6.A     // Catch:{ all -> 0x004a }
            long r2 = r2.mEventTime     // Catch:{ all -> 0x004a }
            long r2 = r6.d(r2)     // Catch:{ all -> 0x004a }
            r0.correctEventTime(r2)     // Catch:{ all -> 0x004a }
        L_0x0024:
            com.bonree.sdk.agent.business.entity.EventBean r0 = r6.A     // Catch:{ all -> 0x004a }
            com.bonree.sdk.agent.business.entity.BaseEventInfo r0 = r0.mEventInfo     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0048
            com.bonree.sdk.agent.business.entity.EventBean r0 = r6.A     // Catch:{ all -> 0x004a }
            com.bonree.sdk.agent.business.entity.BaseEventInfo r0 = r0.mEventInfo     // Catch:{ all -> 0x004a }
            boolean r0 = r0 instanceof com.bonree.sdk.agent.business.entity.CrashEventInfoBean     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0048
            com.bonree.sdk.agent.business.entity.EventBean r0 = r6.A     // Catch:{ all -> 0x004a }
            com.bonree.sdk.agent.business.entity.BaseEventInfo r0 = r0.mEventInfo     // Catch:{ all -> 0x004a }
            com.bonree.sdk.agent.business.entity.CrashEventInfoBean r0 = (com.bonree.sdk.agent.business.entity.CrashEventInfoBean) r0     // Catch:{ all -> 0x004a }
            java.lang.Integer r0 = r0.crashPlatform     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0048
            int r0 = r0.intValue()     // Catch:{ all -> 0x004a }
            if (r0 != r7) goto L_0x0048
            com.bonree.sdk.agent.business.entity.EventBean r7 = r6.A     // Catch:{ all -> 0x004a }
            r6.A = r1     // Catch:{ all -> 0x004a }
            monitor-exit(r6)     // Catch:{ all -> 0x004a }
            return r7
        L_0x0048:
            monitor-exit(r6)     // Catch:{ all -> 0x004a }
            return r1
        L_0x004a:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.af.a.c(int):com.bonree.sdk.agent.business.entity.EventBean");
    }

    public final synchronized List<EventBean> h() {
        d();
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f);
        this.f.clear();
        return arrayList;
    }

    private void a(boolean z2) {
        this.v.getAndSet(z2);
        n();
        this.x.a(z2);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0051=Splitter:B:29:0x0051, B:33:0x0061=Splitter:B:33:0x0061, B:19:0x0029=Splitter:B:19:0x0029} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.bonree.sdk.aj.a i() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.bonree.sdk.aj.a r0 = r10.y     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r10)
            return r0
        L_0x0007:
            com.bonree.sdk.d.e r0 = r10.b     // Catch:{ all -> 0x0078 }
            r1 = 0
            if (r0 == 0) goto L_0x0061
            com.bonree.sdk.d.e r0 = r10.b     // Catch:{ all -> 0x0078 }
            android.content.Context r0 = r0.c()     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0015
            goto L_0x0061
        L_0x0015:
            com.bonree.sdk.d.e r0 = r10.b     // Catch:{ all -> 0x0078 }
            android.content.Context r0 = r0.c()     // Catch:{ all -> 0x0078 }
            com.bonree.sdk.aj.a r0 = com.bonree.sdk.aj.a.a(r0)     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0029
            boolean r2 = r0.a     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0029
            r10.y = r0     // Catch:{ all -> 0x0078 }
            monitor-exit(r10)
            return r0
        L_0x0029:
            r10.n()     // Catch:{ all -> 0x0078 }
            com.bonree.sdk.ak.a r0 = r10.x     // Catch:{ all -> 0x0078 }
            boolean r0 = r0.b()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0051
            com.bonree.sdk.be.f r0 = r10.c     // Catch:{ all -> 0x0078 }
            java.lang.String r2 = "native crash has occurs!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0078 }
            r0.d(r2, r1)     // Catch:{ all -> 0x0078 }
            com.bonree.sdk.d.e r0 = r10.b     // Catch:{ all -> 0x0078 }
            android.content.Context r0 = r0.c()     // Catch:{ all -> 0x0078 }
            com.bonree.sdk.aj.a r0 = com.bonree.sdk.aj.a.a(r0)     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0051
            boolean r1 = r0.a     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x0051
            r10.y = r0     // Catch:{ all -> 0x0078 }
            monitor-exit(r10)
            return r0
        L_0x0051:
            com.bonree.sdk.aj.a r0 = new com.bonree.sdk.aj.a     // Catch:{ all -> 0x0078 }
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ all -> 0x0078 }
            r10.y = r0     // Catch:{ all -> 0x0078 }
            monitor-exit(r10)
            return r0
        L_0x0061:
            com.bonree.sdk.be.f r0 = r10.c     // Catch:{ all -> 0x0078 }
            java.lang.String r2 = "check agent context fail when checking self crash state"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0078 }
            r0.d(r2, r1)     // Catch:{ all -> 0x0078 }
            com.bonree.sdk.aj.a r0 = new com.bonree.sdk.aj.a     // Catch:{ all -> 0x0078 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ all -> 0x0078 }
            monitor-exit(r10)
            return r0
        L_0x0078:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.af.a.i():com.bonree.sdk.aj.a");
    }

    public final synchronized void j() {
        if (this.b != null) {
            if (this.b.c() != null) {
                com.bonree.sdk.aj.a aVar = new com.bonree.sdk.aj.a(false, (String) null, (String) null, 0, (String) null);
                this.y = aVar;
                aVar.b(this.b.c());
                return;
            }
        }
        this.c.d("check agent context fail when reseting self crash state", new Object[0]);
    }

    private void b(boolean z2) {
        this.u.getAndSet(z2);
    }

    public final void b(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.w.getAndSet((long) (i2 * 60 * 60 * 1000));
    }

    private synchronized String l() {
        return NativeCrashEngine.getInstance().getBrCrashVersion();
    }

    public final void a(com.bonree.sdk.ah.c cVar) {
        this.c.d("native crash callback! data: %s ", cVar);
        if (o()) {
            this.c.d("native crash callback will be returned! isStop:true", new Object[0]);
        } else if (cVar != null && !ad.a(cVar.a)) {
            a((long) cVar.b, cVar.c, (com.bonree.sdk.ai.a) null, cVar.a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException unused) {
            }
        }
    }

    private void b(com.bonree.sdk.ah.c cVar) {
        if (cVar != null && !ad.a(cVar.a)) {
            a((long) cVar.b, cVar.c, (com.bonree.sdk.ai.a) null, cVar.a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException unused) {
            }
        }
    }

    private void a(long j2, String str, com.bonree.sdk.ai.a aVar, String str2) {
        CrashEventInfoBean crashEventInfoBean;
        com.bonree.sdk.ai.a aVar2 = aVar;
        if (j2 >= 0 && !ad.a(str)) {
            synchronized (this) {
                if (this.A == null) {
                    this.A = new EventBean();
                }
                this.A.mEventType = "crash";
                this.A.mStateIndex = this.A.getStateIndex();
                if (aVar2 != null) {
                    crashEventInfoBean = m();
                    crashEventInfoBean.crashPlatform = 2;
                } else {
                    crashEventInfoBean = new CrashEventInfoBean();
                    crashEventInfoBean.crashPlatform = 1;
                }
                CrashEventInfoBean crashEventInfoBean2 = crashEventInfoBean;
                this.A.mEventTime = a();
                crashEventInfoBean2.appLaunchTime = com.bonree.sdk.d.a.d();
                crashEventInfoBean2.setAppStateBackground(com.bonree.sdk.d.a.k().J());
                this.A.mEventInfo = crashEventInfoBean2;
                if (aVar2 != null && aVar2.f) {
                    a(com.bonree.sdk.d.a.c(this.A.mEventTime), aVar2.c);
                    this.g = aVar2.f;
                }
                crashEventInfoBean2.mainThreadId = String.valueOf(Looper.getMainLooper().getThread().getId());
                crashEventInfoBean2.threadDumpInfo = new ArrayList();
                Map<Thread, StackTraceElement[]> map = null;
                try {
                    map = com.bonree.sdk.an.a.a(j2);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (map.isEmpty() && !map.containsKey(thread)) {
                        map.put(thread, thread.getStackTrace());
                    }
                } catch (Throwable th) {
                    this.c.e(h, "handleCrashParts: getAllStackTraces error!!!", th);
                }
                Map<Thread, StackTraceElement[]> map2 = map;
                crashEventInfoBean2.crashThreadId = a(aVar, crashEventInfoBean2, j2, str, str2, map2);
                crashEventInfoBean2.threadDumpInfo.addAll(com.bonree.sdk.an.a.b(map2, str));
                if (aVar2 != null) {
                    crashEventInfoBean2.causedBy = aVar2.c;
                    crashEventInfoBean2.type = aVar2.a;
                }
                this.A.uploadStateKey();
                this.A.mTraceInfoList = com.bonree.sdk.ax.c.h().e();
                if (crashEventInfoBean2.crashPlatform.intValue() == 1) {
                    com.bonree.sdk.ax.c.h().g();
                }
                b(a.b.CRASH, this.A);
                this.c.c("CrashService deal crash event finish!!!!", new Object[0]);
            }
        }
    }

    private static String a(com.bonree.sdk.ai.a aVar, CrashEventInfoBean crashEventInfoBean, long j2, String str, String str2, Map<Thread, StackTraceElement[]> map) {
        ThreadDumpInfoBean threadDumpInfoBean = new ThreadDumpInfoBean();
        ThreadDumpInfoBean threadDumpInfoBean2 = null;
        if (aVar != null) {
            if (!ad.a(aVar.b)) {
                threadDumpInfoBean.mDumpInfo = b(aVar.b);
            }
            crashEventInfoBean.nativeCrashLogPath = null;
        } else {
            crashEventInfoBean.nativeCrashLogPath = str2;
            ThreadDumpInfoBean a = com.bonree.sdk.an.a.a(map, str);
            if (a == null && "main".equals(str)) {
                a = com.bonree.sdk.an.a.a(map, true);
            }
            threadDumpInfoBean2 = a;
            if (threadDumpInfoBean2 != null && !ad.a(threadDumpInfoBean2.mDumpInfo)) {
                threadDumpInfoBean.mDumpInfo = threadDumpInfoBean2.mDumpInfo;
            }
        }
        if ("main".equals(str)) {
            threadDumpInfoBean.mThreadId = String.valueOf(Looper.getMainLooper().getThread().getId());
        } else if (aVar != null || threadDumpInfoBean2 == null || ad.a(String.valueOf(threadDumpInfoBean2.mThreadId))) {
            threadDumpInfoBean.mThreadId = String.valueOf(j2);
        } else {
            threadDumpInfoBean.mThreadId = threadDumpInfoBean2.mThreadId;
        }
        threadDumpInfoBean.mThreadName = str;
        if (crashEventInfoBean.threadDumpInfo != null) {
            crashEventInfoBean.threadDumpInfo.add(threadDumpInfoBean);
        }
        return String.valueOf(threadDumpInfoBean.mThreadId);
    }

    private void a(long j2, String str) {
        if (this.b == null || this.b.c() == null) {
            this.c.d("check agent context fail while handling self crash occurs", new Object[0]);
            return;
        }
        String agentVersion = Agent.getAgentVersion();
        String b = this.b.b();
        if (!ad.a(str)) {
            this.c.c("self java crash time:%s,crash causeby:%s", Long.valueOf(j2), str);
        }
        new com.bonree.sdk.aj.a(true, agentVersion, b, j2, str).b(this.b.c());
    }

    private CrashEventInfoBean m() {
        CrashEventInfoBean crashEventInfoBean = new CrashEventInfoBean();
        if (this.t.get()) {
            this.c.c("try to get logcat...", new Object[0]);
            crashEventInfoBean.systemLog = ad.a(400);
            if (ad.a(crashEventInfoBean.systemLog)) {
                crashEventInfoBean.systemLog = null;
            }
            this.c.c("get logcat end", new Object[0]);
        } else {
            crashEventInfoBean.systemLog = null;
        }
        return crashEventInfoBean;
    }

    public final void a(com.bonree.sdk.ah.b bVar) {
        this.c.d("java crash callback! data:%s", bVar);
        if (o()) {
            this.c.d("java crash callback will be returned! isStop:true", new Object[0]);
        } else if (bVar != null && bVar.b != null) {
            com.bonree.sdk.ai.a a = new com.bonree.sdk.ai.b(this.v.get()).a(bVar.b);
            this.c.a("parse crash result:%s", a);
            a(bVar.a.getId(), bVar.a.getName(), a, (String) null);
        }
    }

    private void b(com.bonree.sdk.ah.b bVar) {
        if (bVar != null && bVar.b != null) {
            com.bonree.sdk.ai.a a = new com.bonree.sdk.ai.b(this.v.get()).a(bVar.b);
            this.c.a("parse crash result:%s", a);
            a(bVar.a.getId(), bVar.a.getName(), a, (String) null);
        }
    }

    public final void a(String str, String str2, String str3) {
        if (p() && !TextUtils.isEmpty(str)) {
            if (l <= this.f.size()) {
                this.c.c("CrashService size:%d >limit:%d", Integer.valueOf(this.f.size()), Integer.valueOf(l));
                EventBean eventBean = (EventBean) this.f.get(0);
                if (eventBean == null || !(eventBean.mEventInfo instanceof CrashEventInfoBean) || !((CrashEventInfoBean) eventBean.mEventInfo).iscustom) {
                    this.f.remove(1);
                } else {
                    this.f.remove(0);
                }
            }
            EventBean eventBean2 = new EventBean();
            eventBean2.mEventTime = a();
            eventBean2.mEventType = "crash";
            eventBean2.mStateIndex = eventBean2.getStateIndex();
            CrashEventInfoBean crashEventInfoBean = new CrashEventInfoBean();
            crashEventInfoBean.type = str;
            crashEventInfoBean.causedBy = str2;
            crashEventInfoBean.param = str3;
            crashEventInfoBean.iscustom = true;
            crashEventInfoBean.crashThreadId = String.valueOf(Thread.currentThread().getId());
            crashEventInfoBean.setAppStateBackground(com.bonree.sdk.d.a.k().J());
            crashEventInfoBean.appLaunchTime = com.bonree.sdk.d.a.d();
            eventBean2.mEventInfo = crashEventInfoBean;
            eventBean2.uploadStateKey();
            eventBean2.mTraceInfoList = com.bonree.sdk.ax.c.h().e();
            this.f.add(eventBean2);
            b(a.b.CRASH, eventBean2);
        }
    }

    public final void a(long j2, String str, String str2, String str3) {
        a(j2, str, str2, str3, 3);
    }

    public final void b(long j2, String str, String str2, String str3) {
        a(j2, str, str2, str3, 4);
    }

    private void a(long j2, String str, String str2, String str3, int i2) {
        try {
            if (!p()) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                EventBean eventBean = new EventBean();
                eventBean.mEventTime = (-j2) * 1000;
                eventBean.mEventType = "crash";
                eventBean.mStateIndex = eventBean.getStateIndex();
                CrashEventInfoBean crashEventInfoBean = new CrashEventInfoBean();
                crashEventInfoBean.type = str;
                crashEventInfoBean.causedBy = str2;
                if (!TextUtils.isEmpty(str3)) {
                    crashEventInfoBean.threadDumpInfo = new ArrayList();
                    ThreadDumpInfoBean threadDumpInfoBean = new ThreadDumpInfoBean();
                    if (str3.length() > 10000) {
                        str3 = str3.substring(0, 10000);
                    }
                    threadDumpInfoBean.mDumpInfo = str3;
                    threadDumpInfoBean.mThreadId = String.valueOf(Thread.currentThread().getId());
                    threadDumpInfoBean.mThreadName = Thread.currentThread().getName();
                    crashEventInfoBean.threadDumpInfo.add(threadDumpInfoBean);
                }
                crashEventInfoBean.crashThreadId = String.valueOf(Thread.currentThread().getId());
                crashEventInfoBean.mainThreadId = String.valueOf(Looper.getMainLooper().getThread().getId());
                crashEventInfoBean.crashPlatform = Integer.valueOf(i2);
                crashEventInfoBean.iscustom = false;
                crashEventInfoBean.setAppStateBackground(com.bonree.sdk.d.a.k().J());
                crashEventInfoBean.appLaunchTime = com.bonree.sdk.d.a.d();
                eventBean.mEventInfo = crashEventInfoBean;
                if (l <= this.f.size()) {
                    this.c.c("CrashService size:%d >limit:%d", Integer.valueOf(this.f.size()), Integer.valueOf(l));
                    EventBean eventBean2 = (EventBean) this.f.get(0);
                    if (eventBean2 == null || !(eventBean2.mEventInfo instanceof CrashEventInfoBean) || !((CrashEventInfoBean) eventBean2.mEventInfo).iscustom) {
                        this.f.remove(1);
                    } else {
                        this.f.remove(0);
                    }
                }
                eventBean.uploadStateKey();
                eventBean.mTraceInfoList = com.bonree.sdk.ax.c.h().e();
                a(eventBean);
                b(a.b.CRASH, eventBean);
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.f fVar = this.c;
            fVar.e("CrashService addOtherCrash error:" + th.toString(), new Object[0]);
        }
    }

    private void n() {
        if (this.x == null) {
            this.x = new com.bonree.sdk.ak.a(this.b.c().getFilesDir().getAbsolutePath());
        }
    }

    public final synchronized boolean b() {
        if (p()) {
            a("Crash", a.d.b);
            return false;
        }
        a("Crash", a.d.a);
        this.s = j;
        n();
        com.bonree.sdk.agent.engine.crash.d.a().registerService(this);
        NativeCrashEngine.getInstance().initEngine(false, this.x.a());
        NativeCrashEngine.getInstance().registerService((c) this);
        this.x.c();
        a("Crash", a.d.c);
        return true;
    }

    public final synchronized boolean c() {
        if (!q()) {
            if (!o()) {
                a("Crash", a.d.d);
                this.s = k;
                com.bonree.sdk.agent.engine.crash.d.a().unRegisterService(this);
                NativeCrashEngine.getInstance().unRegisterService(this);
                this.f.clear();
                this.x.d();
                a("Crash", a.d.e);
                return true;
            }
        }
        this.c.d("CrashService no need stoped! isInit:%b, isStop:%b", Boolean.valueOf(q()), Boolean.valueOf(o()));
        return false;
    }

    private synchronized boolean o() {
        return this.s == 2;
    }

    private synchronized boolean p() {
        return this.s == 1;
    }

    private synchronized boolean q() {
        return this.s == 0;
    }

    public final boolean k() {
        return this.g;
    }
}
