package com.bonree.sdk.ba;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.ViewEventInfoBean;
import com.bonree.sdk.k.c;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a extends e {
    private String b = "";
    private long c;
    private long d;
    private int e;
    private EventBean f;
    private boolean g = false;
    private final Map<String, C0011a> h = Collections.synchronizedMap(new LinkedHashMap());

    public final void a(c cVar) {
    }

    public final void a(com.bonree.sdk.y.a aVar) {
    }

    a(o oVar) {
        super(oVar);
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        int e2 = aVar.e();
        boolean z = true;
        if (e2 == 0) {
            if (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.m.equals(aVar.c())) {
                this.b = aVar.a();
            }
            if (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.n.equals(aVar.c()) || (this.c == 0 && com.bonree.sdk.x.a.m.equals(aVar.c()))) {
                this.e = 1;
                this.c = aVar.f();
                a(aVar.j());
            }
        } else if (e2 == 1) {
            if (com.bonree.sdk.x.a.m.equals(aVar.c())) {
                this.d = aVar.f();
                String a = aVar.a();
                long f2 = aVar.f();
                long j = aVar.j();
                if (this.c != 0) {
                    z = false;
                }
                a(a, f2, j, 1, z);
                this.e = 2;
            } else if (com.bonree.sdk.x.a.o.equals(aVar.c())) {
                if (this.a != null) {
                    this.a.d().c();
                }
                a(false, aVar.f(), aVar.j());
            }
        }
    }

    private void b(com.bonree.sdk.x.a aVar) {
        if (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.m.equals(aVar.c())) {
            this.b = aVar.a();
        }
        if (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.n.equals(aVar.c()) || (this.c == 0 && com.bonree.sdk.x.a.m.equals(aVar.c()))) {
            this.e = 1;
            this.c = aVar.f();
            a(aVar.j());
        }
    }

    public final void a() {
        this.f = null;
        this.e = 2;
        this.c = 0;
        this.d = 0;
    }

    private void c(com.bonree.sdk.x.a aVar) {
        if (com.bonree.sdk.x.a.m.equals(aVar.c())) {
            this.d = aVar.f();
            a(aVar.a(), aVar.f(), aVar.j(), 1, this.c == 0);
            this.e = 2;
        } else if (com.bonree.sdk.x.a.o.equals(aVar.c())) {
            if (this.a != null) {
                this.a.d().c();
            }
            a(false, aVar.f(), aVar.j());
        }
    }

    private void a(ViewEventInfoBean viewEventInfoBean, long j) {
        C0011a aVar = new C0011a((byte) 0);
        aVar.e = viewEventInfoBean.mCorrelationId;
        aVar.d = viewEventInfoBean.mName;
        aVar.b = viewEventInfoBean.mLoadTimeUs;
        aVar.a = j;
        aVar.c = viewEventInfoBean.mIsSlow.booleanValue();
        if (((long) this.h.size()) >= 50) {
            this.h.remove(this.h.keySet().iterator().next());
        }
        this.h.put(aVar.d, aVar);
        String str = this.b;
        if (str == null || str.length() == 0) {
            this.b = aVar.d;
        }
    }

    private C0011a a(String str) {
        C0011a aVar;
        synchronized (this.h) {
            aVar = this.h.get(str);
        }
        return aVar;
    }

    private void b(String str) {
        synchronized (this.h) {
            Iterator<String> it = this.h.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.equals(str)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    private EventBean a(long j) {
        try {
            EventBean eventBean = new EventBean();
            this.f = eventBean;
            eventBean.mEventTime = this.a.a(j);
            this.f.mEventType = BaseEventInfo.EVENT_TYPE_VIEW;
            EventBean eventBean2 = this.f;
            eventBean2.mStateIndex = eventBean2.getStateIndex();
        } catch (Exception e2) {
            com.bonree.sdk.be.a.a().e("ViewService AbilityEvent onStartPackage is error %s.", e2.getMessage());
        }
        return this.f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015c, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008c A[Catch:{ Exception -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3 A[Catch:{ Exception -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[Catch:{ Exception -> 0x015f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(java.lang.String r16, long r17, long r19, int r21, boolean r22) {
        /*
            r15 = this;
            r1 = r15
            monitor-enter(r15)
            r2 = 1
            r3 = 0
            if (r22 == 0) goto L_0x000d
            r4 = r19
            com.bonree.sdk.agent.business.entity.EventBean r0 = r15.a((long) r4)     // Catch:{ Exception -> 0x015f }
            goto L_0x000f
        L_0x000d:
            com.bonree.sdk.agent.business.entity.EventBean r0 = r1.f     // Catch:{ Exception -> 0x015f }
        L_0x000f:
            if (r0 == 0) goto L_0x015b
            com.bonree.sdk.ba.o r4 = r1.a     // Catch:{ Exception -> 0x015f }
            if (r4 != 0) goto L_0x0017
            goto L_0x015b
        L_0x0017:
            com.bonree.sdk.agent.business.entity.ViewEventInfoBean r4 = new com.bonree.sdk.agent.business.entity.ViewEventInfoBean     // Catch:{ Exception -> 0x015f }
            r4.<init>()     // Catch:{ Exception -> 0x015f }
            boolean r5 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x015f }
            if (r5 == 0) goto L_0x002b
            com.bonree.sdk.x.b r5 = com.bonree.sdk.x.b.a()     // Catch:{ Exception -> 0x015f }
            java.lang.String r5 = r5.b()     // Catch:{ Exception -> 0x015f }
            goto L_0x002d
        L_0x002b:
            r5 = r16
        L_0x002d:
            r6 = r21
            r4.mModel = r6     // Catch:{ Exception -> 0x015f }
            r7 = 8
            r4.mType = r7     // Catch:{ Exception -> 0x015f }
            r4.mName = r5     // Catch:{ Exception -> 0x015f }
            r4.isCustom = r3     // Catch:{ Exception -> 0x015f }
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x015f }
            r4.mIsSlow = r7     // Catch:{ Exception -> 0x015f }
            r0.mEventInfo = r4     // Catch:{ Exception -> 0x015f }
            int r7 = r4.mModel     // Catch:{ Exception -> 0x015f }
            r8 = 2
            if (r7 != r2) goto L_0x00fa
            java.util.UUID r7 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x015f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x015f }
            r4.mCorrelationId = r7     // Catch:{ Exception -> 0x015f }
            long r9 = r1.c     // Catch:{ Exception -> 0x015f }
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0064
            long r13 = r1.d     // Catch:{ Exception -> 0x015f }
            int r7 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0064
            long r13 = r13 - r9
            long r9 = com.bonree.sdk.bs.ad.a((long) r13)     // Catch:{ Exception -> 0x015f }
            r4.mLoadTimeUs = r9     // Catch:{ Exception -> 0x015f }
            goto L_0x0068
        L_0x0064:
            r9 = 999(0x3e7, double:4.936E-321)
            r4.mLoadTimeUs = r9     // Catch:{ Exception -> 0x015f }
        L_0x0068:
            long r9 = r4.mLoadTimeUs     // Catch:{ Exception -> 0x015f }
            r13 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 / r13
            com.bonree.sdk.ba.o r7 = r1.a     // Catch:{ Exception -> 0x015f }
            int r7 = r7.a()     // Catch:{ Exception -> 0x015f }
            long r13 = (long) r7     // Catch:{ Exception -> 0x015f }
            int r7 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r7 <= 0) goto L_0x00a3
            long r9 = r1.c     // Catch:{ Exception -> 0x015f }
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x00a3
            long r9 = r1.d     // Catch:{ Exception -> 0x015f }
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x00a3
            com.bonree.sdk.ba.o r7 = r1.a     // Catch:{ Exception -> 0x015f }
            com.bonree.sdk.ba.q r7 = r7.d()     // Catch:{ Exception -> 0x015f }
            if (r7 == 0) goto L_0x00a3
            r1.g = r2     // Catch:{ Exception -> 0x015f }
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x015f }
            r4.mIsSlow = r7     // Catch:{ Exception -> 0x015f }
            com.bonree.sdk.ba.o r7 = r1.a     // Catch:{ Exception -> 0x015f }
            com.bonree.sdk.ba.q r7 = r7.d()     // Catch:{ Exception -> 0x015f }
            long r9 = r1.c     // Catch:{ Exception -> 0x015f }
            long r11 = r1.d     // Catch:{ Exception -> 0x015f }
            java.util.List r7 = r7.b((long) r9, (long) r11)     // Catch:{ Exception -> 0x015f }
            r4.mThreadMethodInfo = r7     // Catch:{ Exception -> 0x015f }
            goto L_0x00a5
        L_0x00a3:
            r1.g = r3     // Catch:{ Exception -> 0x015f }
        L_0x00a5:
            long r9 = r1.d     // Catch:{ Exception -> 0x015f }
            com.bonree.sdk.ba.a$a r7 = new com.bonree.sdk.ba.a$a     // Catch:{ Exception -> 0x015f }
            r7.<init>(r3)     // Catch:{ Exception -> 0x015f }
            java.lang.String r11 = r4.mCorrelationId     // Catch:{ Exception -> 0x015f }
            r7.e = r11     // Catch:{ Exception -> 0x015f }
            java.lang.String r11 = r4.mName     // Catch:{ Exception -> 0x015f }
            r7.d = r11     // Catch:{ Exception -> 0x015f }
            long r11 = r4.mLoadTimeUs     // Catch:{ Exception -> 0x015f }
            r7.b = r11     // Catch:{ Exception -> 0x015f }
            r7.a = r9     // Catch:{ Exception -> 0x015f }
            java.lang.Boolean r4 = r4.mIsSlow     // Catch:{ Exception -> 0x015f }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x015f }
            r7.c = r4     // Catch:{ Exception -> 0x015f }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r4 = r1.h     // Catch:{ Exception -> 0x015f }
            int r4 = r4.size()     // Catch:{ Exception -> 0x015f }
            long r9 = (long) r4     // Catch:{ Exception -> 0x015f }
            r11 = 50
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 < 0) goto L_0x00e4
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r4 = r1.h     // Catch:{ Exception -> 0x015f }
            java.util.Set r4 = r4.keySet()     // Catch:{ Exception -> 0x015f }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x015f }
            java.lang.Object r4 = r4.next()     // Catch:{ Exception -> 0x015f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x015f }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r9 = r1.h     // Catch:{ Exception -> 0x015f }
            r9.remove(r4)     // Catch:{ Exception -> 0x015f }
        L_0x00e4:
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r4 = r1.h     // Catch:{ Exception -> 0x015f }
            java.lang.String r9 = r7.d     // Catch:{ Exception -> 0x015f }
            r4.put(r9, r7)     // Catch:{ Exception -> 0x015f }
            java.lang.String r4 = r1.b     // Catch:{ Exception -> 0x015f }
            if (r4 == 0) goto L_0x00f5
            int r4 = r4.length()     // Catch:{ Exception -> 0x015f }
            if (r4 != 0) goto L_0x0125
        L_0x00f5:
            java.lang.String r4 = r7.d     // Catch:{ Exception -> 0x015f }
            r1.b = r4     // Catch:{ Exception -> 0x015f }
            goto L_0x0125
        L_0x00fa:
            int r7 = r4.mModel     // Catch:{ Exception -> 0x015f }
            if (r7 != r8) goto L_0x0125
            com.bonree.sdk.ba.a$a r7 = r15.a((java.lang.String) r5)     // Catch:{ Exception -> 0x015f }
            if (r7 == 0) goto L_0x0125
            long r9 = r7.b     // Catch:{ Exception -> 0x015f }
            r4.mLoadTimeUs = r9     // Catch:{ Exception -> 0x015f }
            java.lang.String r9 = r7.e     // Catch:{ Exception -> 0x015f }
            r4.mCorrelationId = r9     // Catch:{ Exception -> 0x015f }
            long r9 = r7.a     // Catch:{ Exception -> 0x015f }
            long r9 = r17 - r9
            long r9 = com.bonree.sdk.bs.ad.a((long) r9)     // Catch:{ Exception -> 0x015f }
            java.lang.Long r7 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x015f }
            r4.mStayTimeUs = r7     // Catch:{ Exception -> 0x015f }
            boolean r7 = r1.g     // Catch:{ Exception -> 0x015f }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ Exception -> 0x015f }
            r4.mIsSlow = r7     // Catch:{ Exception -> 0x015f }
            r15.b((java.lang.String) r5)     // Catch:{ Exception -> 0x015f }
        L_0x0125:
            com.bonree.sdk.be.f r4 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x015f }
            java.lang.String r7 = "ViewService AbilityEvent model %d, ct %d st %d et %d name %s"
            r9 = 5
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x015f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x015f }
            r9[r3] = r6     // Catch:{ Exception -> 0x015f }
            long r10 = r1.c     // Catch:{ Exception -> 0x015f }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x015f }
            r9[r2] = r6     // Catch:{ Exception -> 0x015f }
            long r10 = r1.d     // Catch:{ Exception -> 0x015f }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x015f }
            r9[r8] = r6     // Catch:{ Exception -> 0x015f }
            r6 = 3
            java.lang.Long r8 = java.lang.Long.valueOf(r17)     // Catch:{ Exception -> 0x015f }
            r9[r6] = r8     // Catch:{ Exception -> 0x015f }
            r6 = 4
            r9[r6] = r5     // Catch:{ Exception -> 0x015f }
            r4.c(r7, r9)     // Catch:{ Exception -> 0x015f }
            r0.uploadStateKey()     // Catch:{ Exception -> 0x015f }
            com.bonree.sdk.ba.o r4 = r1.a     // Catch:{ Exception -> 0x015f }
            r4.b(r0)     // Catch:{ Exception -> 0x015f }
            monitor-exit(r15)
            return
        L_0x015b:
            monitor-exit(r15)
            return
        L_0x015d:
            r0 = move-exception
            goto L_0x0173
        L_0x015f:
            r0 = move-exception
            com.bonree.sdk.be.f r4 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x015d }
            java.lang.String r5 = "ViewService AbilityEvent is error %s."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x015d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x015d }
            r2[r3] = r0     // Catch:{ all -> 0x015d }
            r4.e(r5, r2)     // Catch:{ all -> 0x015d }
            monitor-exit(r15)
            return
        L_0x0173:
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.a.a(java.lang.String, long, long, int, boolean):void");
    }

    public final void a(long j, long j2) {
        a(true, j, j2);
    }

    private boolean c() {
        return this.c == 0 && this.d == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            r2.c = r0     // Catch:{ all -> 0x0023 }
            r2.d = r0     // Catch:{ all -> 0x0023 }
            com.bonree.sdk.ba.o r0 = r2.a     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0021
            com.bonree.sdk.ba.o r0 = r2.a     // Catch:{ all -> 0x0023 }
            com.bonree.sdk.ba.q r0 = r0.d()     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0014
            goto L_0x0021
        L_0x0014:
            if (r3 != 0) goto L_0x001f
            com.bonree.sdk.ba.o r3 = r2.a     // Catch:{ all -> 0x0023 }
            com.bonree.sdk.ba.q r3 = r3.d()     // Catch:{ all -> 0x0023 }
            r3.c()     // Catch:{ all -> 0x0023 }
        L_0x001f:
            monitor-exit(r2)
            return
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.a.a(boolean):void");
    }

    /* renamed from: com.bonree.sdk.ba.a$a  reason: collision with other inner class name */
    static class C0011a {
        long a;
        long b;
        boolean c;
        String d;
        String e;

        private C0011a() {
            this.b = 999;
        }

        /* synthetic */ C0011a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00db, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081 A[Catch:{ Exception -> 0x00de }, LOOP:0: B:26:0x007b->B:28:0x0081, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb A[Catch:{ Exception -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7 A[Catch:{ Exception -> 0x00de }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r15, long r16, long r18) {
        /*
            r14 = this;
            r9 = r14
            monitor-enter(r14)
            r10 = 0
            r11 = 1
            long r0 = r9.c     // Catch:{ Exception -> 0x00de }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0014
            long r0 = r9.d     // Catch:{ Exception -> 0x00de }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0014
            r0 = r11
            goto L_0x0015
        L_0x0014:
            r0 = r10
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            monitor-exit(r14)
            return
        L_0x0019:
            if (r15 == 0) goto L_0x0030
            int r0 = r9.e     // Catch:{ Exception -> 0x00de }
            if (r0 != r11) goto L_0x0030
            r12 = r16
            r9.d = r12     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = r9.b     // Catch:{ Exception -> 0x00de }
            r7 = 1
            r8 = 0
            r1 = r14
            r3 = r16
            r5 = r18
            r1.a(r2, r3, r5, r7, r8)     // Catch:{ Exception -> 0x00de }
            goto L_0x0032
        L_0x0030:
            r12 = r16
        L_0x0032:
            java.lang.String r0 = r9.b     // Catch:{ Exception -> 0x00de }
            if (r0 == 0) goto L_0x003c
            int r0 = r0.length()     // Catch:{ Exception -> 0x00de }
            if (r0 != 0) goto L_0x0046
        L_0x003c:
            com.bonree.sdk.agent.engine.state.f r0 = com.bonree.sdk.agent.engine.state.HarmonyAppStateEngine.getEngine()     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = r0.getViewName()     // Catch:{ Exception -> 0x00de }
            r9.b = r0     // Catch:{ Exception -> 0x00de }
        L_0x0046:
            java.lang.String r2 = r9.b     // Catch:{ Exception -> 0x00de }
            r7 = 2
            r8 = 1
            r1 = r14
            r3 = r16
            r5 = r18
            r1.a(r2, r3, r5, r7, r8)     // Catch:{ Exception -> 0x00de }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x00de }
            java.lang.String r1 = "ViewService AbilityEvent onViewEndMakePackages isCrash %s, model %s, activity %s."
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00de }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)     // Catch:{ Exception -> 0x00de }
            r2[r10] = r3     // Catch:{ Exception -> 0x00de }
            int r3 = r9.e     // Catch:{ Exception -> 0x00de }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00de }
            r2[r11] = r3     // Catch:{ Exception -> 0x00de }
            java.lang.String r3 = r9.b     // Catch:{ Exception -> 0x00de }
            r4 = 2
            r2[r4] = r3     // Catch:{ Exception -> 0x00de }
            r0.c(r1, r2)     // Catch:{ Exception -> 0x00de }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r0 = r9.h     // Catch:{ Exception -> 0x00de }
            java.util.Set r0 = r0.keySet()     // Catch:{ Exception -> 0x00de }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00de }
        L_0x007b:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x00de }
            if (r1 == 0) goto L_0x00a1
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x00de }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00de }
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x00de }
            java.lang.String r3 = "ViewService AbilityEvent onViewEndMakePackages cacheAbilityDatas size %s, activity %s."
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00de }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r6 = r9.h     // Catch:{ Exception -> 0x00de }
            int r6 = r6.size()     // Catch:{ Exception -> 0x00de }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00de }
            r5[r10] = r6     // Catch:{ Exception -> 0x00de }
            r5[r11] = r1     // Catch:{ Exception -> 0x00de }
            r2.c(r3, r5)     // Catch:{ Exception -> 0x00de }
            goto L_0x007b
        L_0x00a1:
            if (r15 == 0) goto L_0x00cf
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r0 = r9.h     // Catch:{ Exception -> 0x00de }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x00de }
            if (r0 != 0) goto L_0x00cf
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r0 = r9.h     // Catch:{ Exception -> 0x00de }
            java.util.Set r0 = r0.keySet()     // Catch:{ Exception -> 0x00de }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00de }
        L_0x00b5:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x00de }
            if (r1 == 0) goto L_0x00cf
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x00de }
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00de }
            if (r2 == 0) goto L_0x00b5
            r7 = 2
            r8 = 1
            r1 = r14
            r3 = r16
            r5 = r18
            r1.a(r2, r3, r5, r7, r8)     // Catch:{ Exception -> 0x00de }
            goto L_0x00b5
        L_0x00cf:
            java.util.Map<java.lang.String, com.bonree.sdk.ba.a$a> r0 = r9.h     // Catch:{ Exception -> 0x00de }
            int r0 = r0.size()     // Catch:{ Exception -> 0x00de }
            if (r0 != 0) goto L_0x00da
            r14.a((boolean) r15)     // Catch:{ Exception -> 0x00de }
        L_0x00da:
            monitor-exit(r14)
            return
        L_0x00dc:
            r0 = move-exception
            goto L_0x00ee
        L_0x00de:
            r0 = move-exception
            com.bonree.sdk.be.f r1 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00dc }
            java.lang.String r2 = "ViewService AbilityEvent onViewEndMakePackages is error %s."
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ all -> 0x00dc }
            r3[r10] = r0     // Catch:{ all -> 0x00dc }
            r1.c(r2, r3)     // Catch:{ all -> 0x00dc }
            monitor-exit(r14)
            return
        L_0x00ee:
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.a.a(boolean, long, long):void");
    }
}
