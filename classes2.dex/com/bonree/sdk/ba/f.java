package com.bonree.sdk.ba;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.ViewEventInfoBean;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class f extends e {
    private String b = "";
    private long c;
    private long d;
    private int e;
    private EventBean f;
    private boolean g = false;
    private final Map<String, a> h = Collections.synchronizedMap(new LinkedHashMap());

    f(o oVar) {
        super(oVar);
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        int e2 = aVar.e();
        boolean z = true;
        if (e2 == 0) {
            if (com.bonree.sdk.z.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.z.a.n.equals(aVar.c())) {
                this.b = aVar.a();
            }
            if (!com.bonree.sdk.z.a.l.equals(aVar.c()) && !com.bonree.sdk.z.a.o.equals(aVar.c())) {
                if (this.c != 0) {
                    return;
                }
                if (!com.bonree.sdk.z.a.m.equals(aVar.c()) && !com.bonree.sdk.z.a.n.equals(aVar.c())) {
                    return;
                }
            }
            this.e = 1;
            this.c = aVar.f();
            a(aVar.j());
        } else if (e2 == 1) {
            if (com.bonree.sdk.z.a.n.equals(aVar.c())) {
                this.d = aVar.f();
                String a2 = aVar.a();
                long f2 = aVar.f();
                long j = aVar.j();
                if (this.c != 0) {
                    z = false;
                }
                a(a2, f2, j, 1, z);
                this.e = 2;
            } else if (com.bonree.sdk.z.a.p.equals(aVar.c())) {
                if (this.a != null) {
                    this.a.d().c();
                }
                a(false, aVar.f(), aVar.j());
            }
        }
    }

    private void b(com.bonree.sdk.z.a aVar) {
        if (com.bonree.sdk.z.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.z.a.n.equals(aVar.c())) {
            this.b = aVar.a();
        }
        if (!com.bonree.sdk.z.a.l.equals(aVar.c()) && !com.bonree.sdk.z.a.o.equals(aVar.c())) {
            if (this.c != 0) {
                return;
            }
            if (!com.bonree.sdk.z.a.m.equals(aVar.c()) && !com.bonree.sdk.z.a.n.equals(aVar.c())) {
                return;
            }
        }
        this.e = 1;
        this.c = aVar.f();
        a(aVar.j());
    }

    public final void a() {
        this.f = null;
        this.e = 2;
        this.c = 0;
        this.d = 0;
    }

    private void c(com.bonree.sdk.z.a aVar) {
        if (com.bonree.sdk.z.a.n.equals(aVar.c())) {
            this.d = aVar.f();
            a(aVar.a(), aVar.f(), aVar.j(), 1, this.c == 0);
            this.e = 2;
        } else if (com.bonree.sdk.z.a.p.equals(aVar.c())) {
            if (this.a != null) {
                this.a.d().c();
            }
            a(false, aVar.f(), aVar.j());
        }
    }

    private void a(ViewEventInfoBean viewEventInfoBean, long j) {
        a aVar = new a((byte) 0);
        aVar.e = viewEventInfoBean.mCorrelationId;
        aVar.d = viewEventInfoBean.mName;
        aVar.b = viewEventInfoBean.mLoadTimeUs;
        aVar.a = j;
        aVar.c = viewEventInfoBean.mIsSlow.booleanValue();
        if (((long) this.h.size()) >= 50) {
            this.h.remove(this.h.keySet().iterator().next());
        }
        this.h.put(viewEventInfoBean.mName, aVar);
    }

    private a a(String str) {
        a aVar;
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
            com.bonree.sdk.be.a.a().e("ViewService ActivityEvent onStartPackage is error %s.", e2.getMessage());
        }
        return this.f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x014c, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a A[Catch:{ Exception -> 0x014f }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a1 A[Catch:{ Exception -> 0x014f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd A[Catch:{ Exception -> 0x014f }] */
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
            com.bonree.sdk.agent.business.entity.EventBean r0 = r15.a((long) r4)     // Catch:{ Exception -> 0x014f }
            goto L_0x000f
        L_0x000d:
            com.bonree.sdk.agent.business.entity.EventBean r0 = r1.f     // Catch:{ Exception -> 0x014f }
        L_0x000f:
            if (r0 == 0) goto L_0x014b
            com.bonree.sdk.ba.o r4 = r1.a     // Catch:{ Exception -> 0x014f }
            if (r4 != 0) goto L_0x0017
            goto L_0x014b
        L_0x0017:
            boolean r4 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x014f }
            if (r4 == 0) goto L_0x0026
            com.bonree.sdk.z.b r4 = com.bonree.sdk.z.b.a()     // Catch:{ Exception -> 0x014f }
            java.lang.String r4 = r4.b()     // Catch:{ Exception -> 0x014f }
            goto L_0x0028
        L_0x0026:
            r4 = r16
        L_0x0028:
            com.bonree.sdk.agent.business.entity.ViewEventInfoBean r5 = new com.bonree.sdk.agent.business.entity.ViewEventInfoBean     // Catch:{ Exception -> 0x014f }
            r5.<init>()     // Catch:{ Exception -> 0x014f }
            r6 = r21
            r5.mModel = r6     // Catch:{ Exception -> 0x014f }
            r7 = 2
            r5.mType = r7     // Catch:{ Exception -> 0x014f }
            r5.mName = r4     // Catch:{ Exception -> 0x014f }
            r5.isCustom = r3     // Catch:{ Exception -> 0x014f }
            java.lang.Boolean r8 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x014f }
            r5.mIsSlow = r8     // Catch:{ Exception -> 0x014f }
            r0.mEventInfo = r5     // Catch:{ Exception -> 0x014f }
            int r8 = r5.mModel     // Catch:{ Exception -> 0x014f }
            if (r8 != r2) goto L_0x00ea
            java.util.UUID r8 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x014f }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x014f }
            r5.mCorrelationId = r8     // Catch:{ Exception -> 0x014f }
            long r8 = r1.c     // Catch:{ Exception -> 0x014f }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0062
            long r12 = r1.d     // Catch:{ Exception -> 0x014f }
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 == 0) goto L_0x0062
            long r12 = r12 - r8
            long r8 = com.bonree.sdk.bs.ad.a((long) r12)     // Catch:{ Exception -> 0x014f }
            r5.mLoadTimeUs = r8     // Catch:{ Exception -> 0x014f }
            goto L_0x0066
        L_0x0062:
            r8 = 999(0x3e7, double:4.936E-321)
            r5.mLoadTimeUs = r8     // Catch:{ Exception -> 0x014f }
        L_0x0066:
            long r8 = r5.mLoadTimeUs     // Catch:{ Exception -> 0x014f }
            r12 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 / r12
            com.bonree.sdk.ba.o r12 = r1.a     // Catch:{ Exception -> 0x014f }
            int r12 = r12.a()     // Catch:{ Exception -> 0x014f }
            long r12 = (long) r12     // Catch:{ Exception -> 0x014f }
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a1
            long r8 = r1.c     // Catch:{ Exception -> 0x014f }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a1
            long r8 = r1.d     // Catch:{ Exception -> 0x014f }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a1
            com.bonree.sdk.ba.o r8 = r1.a     // Catch:{ Exception -> 0x014f }
            com.bonree.sdk.ba.q r8 = r8.d()     // Catch:{ Exception -> 0x014f }
            if (r8 == 0) goto L_0x00a1
            r1.g = r2     // Catch:{ Exception -> 0x014f }
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x014f }
            r5.mIsSlow = r8     // Catch:{ Exception -> 0x014f }
            com.bonree.sdk.ba.o r8 = r1.a     // Catch:{ Exception -> 0x014f }
            com.bonree.sdk.ba.q r8 = r8.d()     // Catch:{ Exception -> 0x014f }
            long r9 = r1.c     // Catch:{ Exception -> 0x014f }
            long r11 = r1.d     // Catch:{ Exception -> 0x014f }
            java.util.List r8 = r8.b((long) r9, (long) r11)     // Catch:{ Exception -> 0x014f }
            r5.mThreadMethodInfo = r8     // Catch:{ Exception -> 0x014f }
            goto L_0x00a3
        L_0x00a1:
            r1.g = r3     // Catch:{ Exception -> 0x014f }
        L_0x00a3:
            long r8 = r1.d     // Catch:{ Exception -> 0x014f }
            com.bonree.sdk.ba.f$a r10 = new com.bonree.sdk.ba.f$a     // Catch:{ Exception -> 0x014f }
            r10.<init>(r3)     // Catch:{ Exception -> 0x014f }
            java.lang.String r11 = r5.mCorrelationId     // Catch:{ Exception -> 0x014f }
            r10.e = r11     // Catch:{ Exception -> 0x014f }
            java.lang.String r11 = r5.mName     // Catch:{ Exception -> 0x014f }
            r10.d = r11     // Catch:{ Exception -> 0x014f }
            long r11 = r5.mLoadTimeUs     // Catch:{ Exception -> 0x014f }
            r10.b = r11     // Catch:{ Exception -> 0x014f }
            r10.a = r8     // Catch:{ Exception -> 0x014f }
            java.lang.Boolean r8 = r5.mIsSlow     // Catch:{ Exception -> 0x014f }
            boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x014f }
            r10.c = r8     // Catch:{ Exception -> 0x014f }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r8 = r1.h     // Catch:{ Exception -> 0x014f }
            int r8 = r8.size()     // Catch:{ Exception -> 0x014f }
            long r8 = (long) r8     // Catch:{ Exception -> 0x014f }
            r11 = 50
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 < 0) goto L_0x00e2
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r8 = r1.h     // Catch:{ Exception -> 0x014f }
            java.util.Set r8 = r8.keySet()     // Catch:{ Exception -> 0x014f }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x014f }
            java.lang.Object r8 = r8.next()     // Catch:{ Exception -> 0x014f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x014f }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r9 = r1.h     // Catch:{ Exception -> 0x014f }
            r9.remove(r8)     // Catch:{ Exception -> 0x014f }
        L_0x00e2:
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r8 = r1.h     // Catch:{ Exception -> 0x014f }
            java.lang.String r5 = r5.mName     // Catch:{ Exception -> 0x014f }
            r8.put(r5, r10)     // Catch:{ Exception -> 0x014f }
            goto L_0x0115
        L_0x00ea:
            int r8 = r5.mModel     // Catch:{ Exception -> 0x014f }
            if (r8 != r7) goto L_0x0115
            com.bonree.sdk.ba.f$a r8 = r15.a((java.lang.String) r4)     // Catch:{ Exception -> 0x014f }
            if (r8 == 0) goto L_0x0115
            long r9 = r8.b     // Catch:{ Exception -> 0x014f }
            r5.mLoadTimeUs = r9     // Catch:{ Exception -> 0x014f }
            java.lang.String r9 = r8.e     // Catch:{ Exception -> 0x014f }
            r5.mCorrelationId = r9     // Catch:{ Exception -> 0x014f }
            long r8 = r8.a     // Catch:{ Exception -> 0x014f }
            long r8 = r17 - r8
            long r8 = com.bonree.sdk.bs.ad.a((long) r8)     // Catch:{ Exception -> 0x014f }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x014f }
            r5.mStayTimeUs = r8     // Catch:{ Exception -> 0x014f }
            boolean r8 = r1.g     // Catch:{ Exception -> 0x014f }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x014f }
            r5.mIsSlow = r8     // Catch:{ Exception -> 0x014f }
            r15.b((java.lang.String) r4)     // Catch:{ Exception -> 0x014f }
        L_0x0115:
            com.bonree.sdk.be.f r5 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x014f }
            java.lang.String r8 = "ViewService ActivityEvent model %d, ct %d st %d et %d name %s"
            r9 = 5
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x014f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r21)     // Catch:{ Exception -> 0x014f }
            r9[r3] = r6     // Catch:{ Exception -> 0x014f }
            long r10 = r1.c     // Catch:{ Exception -> 0x014f }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x014f }
            r9[r2] = r6     // Catch:{ Exception -> 0x014f }
            long r10 = r1.d     // Catch:{ Exception -> 0x014f }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x014f }
            r9[r7] = r6     // Catch:{ Exception -> 0x014f }
            r6 = 3
            java.lang.Long r7 = java.lang.Long.valueOf(r17)     // Catch:{ Exception -> 0x014f }
            r9[r6] = r7     // Catch:{ Exception -> 0x014f }
            r6 = 4
            r9[r6] = r4     // Catch:{ Exception -> 0x014f }
            r5.c(r8, r9)     // Catch:{ Exception -> 0x014f }
            r0.uploadStateKey()     // Catch:{ Exception -> 0x014f }
            com.bonree.sdk.ba.o r4 = r1.a     // Catch:{ Exception -> 0x014f }
            r4.b(r0)     // Catch:{ Exception -> 0x014f }
            monitor-exit(r15)
            return
        L_0x014b:
            monitor-exit(r15)
            return
        L_0x014d:
            r0 = move-exception
            goto L_0x0163
        L_0x014f:
            r0 = move-exception
            com.bonree.sdk.be.f r4 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x014d }
            java.lang.String r5 = "ViewService ActivityEvent is error %s."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x014d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x014d }
            r2[r3] = r0     // Catch:{ all -> 0x014d }
            r4.e(r5, r2)     // Catch:{ all -> 0x014d }
            monitor-exit(r15)
            return
        L_0x0163:
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.f.a(java.lang.String, long, long, int, boolean):void");
    }

    public final void a(long j, long j2) {
        a(true, j, j2);
    }

    private boolean c() {
        return this.c == 0 && this.d == 0;
    }

    private synchronized void d() {
        this.c = 0;
        this.d = 0;
        if (!(this.a == null || this.a.d() == null)) {
            this.a.d().c();
        }
    }

    static class a {
        long a;
        long b;
        boolean c;
        String d;
        String e;
        private long f;

        private a() {
            this.b = 999;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d A[Catch:{ Exception -> 0x00ca }, LOOP:0: B:21:0x0067->B:23:0x006d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7 A[Catch:{ Exception -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A[Catch:{ Exception -> 0x00ca }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r15, long r16, long r18) {
        /*
            r14 = this;
            r9 = r14
            monitor-enter(r14)
            r10 = 0
            r11 = 1
            long r0 = r9.c     // Catch:{ Exception -> 0x00ca }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0014
            long r0 = r9.d     // Catch:{ Exception -> 0x00ca }
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
            int r0 = r9.e     // Catch:{ Exception -> 0x00ca }
            if (r0 != r11) goto L_0x0030
            r12 = r16
            r9.d = r12     // Catch:{ Exception -> 0x00ca }
            java.lang.String r2 = r9.b     // Catch:{ Exception -> 0x00ca }
            r7 = 1
            r8 = 0
            r1 = r14
            r3 = r16
            r5 = r18
            r1.a(r2, r3, r5, r7, r8)     // Catch:{ Exception -> 0x00ca }
            goto L_0x0032
        L_0x0030:
            r12 = r16
        L_0x0032:
            java.lang.String r2 = r9.b     // Catch:{ Exception -> 0x00ca }
            r7 = 2
            r8 = 1
            r1 = r14
            r3 = r16
            r5 = r18
            r1.a(r2, r3, r5, r7, r8)     // Catch:{ Exception -> 0x00ca }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r1 = "ViewService ActivityEvent onViewEndMakePackages isCrash %s, model %s, activity %s."
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00ca }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)     // Catch:{ Exception -> 0x00ca }
            r2[r10] = r3     // Catch:{ Exception -> 0x00ca }
            int r3 = r9.e     // Catch:{ Exception -> 0x00ca }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00ca }
            r2[r11] = r3     // Catch:{ Exception -> 0x00ca }
            java.lang.String r3 = r9.b     // Catch:{ Exception -> 0x00ca }
            r4 = 2
            r2[r4] = r3     // Catch:{ Exception -> 0x00ca }
            r0.c(r1, r2)     // Catch:{ Exception -> 0x00ca }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r0 = r9.h     // Catch:{ Exception -> 0x00ca }
            java.util.Set r0 = r0.keySet()     // Catch:{ Exception -> 0x00ca }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00ca }
        L_0x0067:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008d
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00ca }
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r3 = "ViewService ActivityEvent onViewEndMakePackages cacheActivityDatas size %s, activity %s."
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00ca }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r6 = r9.h     // Catch:{ Exception -> 0x00ca }
            int r6 = r6.size()     // Catch:{ Exception -> 0x00ca }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00ca }
            r5[r10] = r6     // Catch:{ Exception -> 0x00ca }
            r5[r11] = r1     // Catch:{ Exception -> 0x00ca }
            r2.c(r3, r5)     // Catch:{ Exception -> 0x00ca }
            goto L_0x0067
        L_0x008d:
            if (r15 == 0) goto L_0x00bb
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r0 = r9.h     // Catch:{ Exception -> 0x00ca }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x00ca }
            if (r0 != 0) goto L_0x00bb
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r0 = r9.h     // Catch:{ Exception -> 0x00ca }
            java.util.Set r0 = r0.keySet()     // Catch:{ Exception -> 0x00ca }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00ca }
        L_0x00a1:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x00bb
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x00ca }
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00ca }
            if (r2 == 0) goto L_0x00a1
            r7 = 2
            r8 = 1
            r1 = r14
            r3 = r16
            r5 = r18
            r1.a(r2, r3, r5, r7, r8)     // Catch:{ Exception -> 0x00ca }
            goto L_0x00a1
        L_0x00bb:
            java.util.Map<java.lang.String, com.bonree.sdk.ba.f$a> r0 = r9.h     // Catch:{ Exception -> 0x00ca }
            int r0 = r0.size()     // Catch:{ Exception -> 0x00ca }
            if (r0 != 0) goto L_0x00c6
            r14.d()     // Catch:{ Exception -> 0x00ca }
        L_0x00c6:
            monitor-exit(r14)
            return
        L_0x00c8:
            r0 = move-exception
            goto L_0x00da
        L_0x00ca:
            r0 = move-exception
            com.bonree.sdk.be.f r1 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00c8 }
            java.lang.String r2 = "ViewService ActivityEvent onViewEndMakePackages is error %s."
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ all -> 0x00c8 }
            r3[r10] = r0     // Catch:{ all -> 0x00c8 }
            r1.c(r2, r3)     // Catch:{ all -> 0x00c8 }
            monitor-exit(r14)
            return
        L_0x00da:
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.f.a(boolean, long, long):void");
    }
}
