package com.bonree.sdk.ba;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.k;
import java.util.Map;

public final class j extends e {
    private static long b = 50;
    private final Map<Integer, a> c = new k();
    private String d;

    j(o oVar) {
        super(oVar);
    }

    public final void a(com.bonree.sdk.aa.a aVar) {
        a aVar2;
        int e = aVar.e();
        if (e != 0) {
            if (e == 1 && (aVar2 = this.c.get(Integer.valueOf(aVar.q()))) != null) {
                if (com.bonree.sdk.aa.a.l.equals(aVar.c()) || com.bonree.sdk.aa.a.o.equals(aVar.c())) {
                    long unused = aVar2.h = aVar.f();
                    long unused2 = aVar2.i = aVar.j();
                }
                if (com.bonree.sdk.aa.a.p.equals(aVar.c()) && aVar2.f <= 0) {
                    long unused3 = aVar2.f = aVar.f();
                    long unused4 = aVar2.g = aVar.j();
                    a(aVar2, aVar.j(), false);
                    int unused5 = aVar2.k = 2;
                }
            }
        } else if (com.bonree.sdk.aa.a.l.equals(aVar.c()) || com.bonree.sdk.aa.a.o.equals(aVar.c()) || com.bonree.sdk.aa.a.p.equals(aVar.c())) {
            a d2 = d(aVar);
            if (d2.d <= 0) {
                long unused6 = d2.d = aVar.f();
                long unused7 = d2.e = aVar.j();
                int unused8 = d2.k = 1;
                a(d2, d2.e);
            }
        }
    }

    private void b(com.bonree.sdk.aa.a aVar) {
        if (com.bonree.sdk.aa.a.l.equals(aVar.c()) || com.bonree.sdk.aa.a.o.equals(aVar.c()) || com.bonree.sdk.aa.a.p.equals(aVar.c())) {
            a d2 = d(aVar);
            if (d2.d <= 0) {
                long unused = d2.d = aVar.f();
                long unused2 = d2.e = aVar.j();
                int unused3 = d2.k = 1;
                a(d2, d2.e);
            }
        }
    }

    private void c(com.bonree.sdk.aa.a aVar) {
        a aVar2 = this.c.get(Integer.valueOf(aVar.q()));
        if (aVar2 != null) {
            if (com.bonree.sdk.aa.a.l.equals(aVar.c()) || com.bonree.sdk.aa.a.o.equals(aVar.c())) {
                long unused = aVar2.h = aVar.f();
                long unused2 = aVar2.i = aVar.j();
            }
            if (com.bonree.sdk.aa.a.p.equals(aVar.c()) && aVar2.f <= 0) {
                long unused3 = aVar2.f = aVar.f();
                long unused4 = aVar2.g = aVar.j();
                a(aVar2, aVar.j(), false);
                int unused5 = aVar2.k = 2;
            }
        }
    }

    private synchronized EventBean a(a aVar, long j) {
        try {
            EventBean unused = aVar.n = new EventBean();
            aVar.n.mEventType = BaseEventInfo.EVENT_TYPE_VIEW;
            aVar.n.mEventTime = this.a.a(j);
            aVar.n.mStateIndex = aVar.n.getStateIndex();
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().e("ViewService FragmentEvent onStartPackage error %s.", th.getMessage());
            return null;
        }
        return aVar.n;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0113, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.bonree.sdk.ba.j.a r9, long r10, boolean r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r9 != 0) goto L_0x0005
            monitor-exit(r8)
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r12 == 0) goto L_0x000e
            com.bonree.sdk.agent.business.entity.EventBean r10 = r8.a((com.bonree.sdk.ba.j.a) r9, (long) r10)     // Catch:{ all -> 0x0114 }
            goto L_0x0012
        L_0x000e:
            com.bonree.sdk.agent.business.entity.EventBean r10 = r9.n     // Catch:{ all -> 0x0114 }
        L_0x0012:
            if (r10 == 0) goto L_0x0112
            com.bonree.sdk.ba.o r11 = r8.a     // Catch:{ all -> 0x0114 }
            if (r11 != 0) goto L_0x001a
            goto L_0x0112
        L_0x001a:
            com.bonree.sdk.agent.business.entity.ViewEventInfoBean r11 = new com.bonree.sdk.agent.business.entity.ViewEventInfoBean     // Catch:{ all -> 0x0114 }
            r11.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r12 = r9.l     // Catch:{ all -> 0x0114 }
            r11.mCorrelationId = r12     // Catch:{ all -> 0x0114 }
            int r12 = r9.k     // Catch:{ all -> 0x0114 }
            r11.mModel = r12     // Catch:{ all -> 0x0114 }
            r12 = 3
            r11.mType = r12     // Catch:{ all -> 0x0114 }
            java.lang.String r2 = r9.c     // Catch:{ all -> 0x0114 }
            r11.mParentView = r2     // Catch:{ all -> 0x0114 }
            java.lang.String r2 = r9.b     // Catch:{ all -> 0x0114 }
            r11.mName = r2     // Catch:{ all -> 0x0114 }
            r11.isCustom = r0     // Catch:{ all -> 0x0114 }
            boolean r2 = r9.m     // Catch:{ all -> 0x0114 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0114 }
            r11.mIsSlow = r2     // Catch:{ all -> 0x0114 }
            long r2 = r9.f     // Catch:{ all -> 0x0114 }
            long r4 = r9.d     // Catch:{ all -> 0x0114 }
            long r2 = r2 - r4
            long r2 = com.bonree.sdk.bs.ad.a((long) r2)     // Catch:{ all -> 0x0114 }
            r11.mLoadTimeUs = r2     // Catch:{ all -> 0x0114 }
            long r2 = r11.mLoadTimeUs     // Catch:{ all -> 0x0114 }
            r4 = 10000000(0x989680, double:4.9406565E-317)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0066
            long r2 = r11.mLoadTimeUs     // Catch:{ all -> 0x0114 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0071
        L_0x0066:
            r2 = 999(0x3e7, double:4.936E-321)
            r11.mLoadTimeUs = r2     // Catch:{ all -> 0x0114 }
            long r2 = r9.d     // Catch:{ all -> 0x0114 }
            long unused = r9.f = r2     // Catch:{ all -> 0x0114 }
        L_0x0071:
            int r2 = r9.k     // Catch:{ all -> 0x0114 }
            r3 = 2
            if (r2 != r1) goto L_0x00b7
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0114 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0114 }
            java.lang.String unused = r9.l = r2     // Catch:{ all -> 0x0114 }
            long r4 = r11.mLoadTimeUs     // Catch:{ all -> 0x0114 }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            com.bonree.sdk.ba.o r2 = r8.a     // Catch:{ all -> 0x0114 }
            int r2 = r2.a()     // Catch:{ all -> 0x0114 }
            long r6 = (long) r2     // Catch:{ all -> 0x0114 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d0
            com.bonree.sdk.ba.o r2 = r8.a     // Catch:{ all -> 0x0114 }
            com.bonree.sdk.ba.q r2 = r2.d()     // Catch:{ all -> 0x0114 }
            if (r2 == 0) goto L_0x00d0
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0114 }
            r11.mIsSlow = r2     // Catch:{ all -> 0x0114 }
            boolean unused = r9.m = true     // Catch:{ all -> 0x0114 }
            com.bonree.sdk.ba.o r2 = r8.a     // Catch:{ all -> 0x0114 }
            com.bonree.sdk.ba.q r2 = r2.d()     // Catch:{ all -> 0x0114 }
            long r4 = r9.d     // Catch:{ all -> 0x0114 }
            long r6 = r9.f     // Catch:{ all -> 0x0114 }
            java.util.List r2 = r2.b((long) r4, (long) r6)     // Catch:{ all -> 0x0114 }
            r11.mThreadMethodInfo = r2     // Catch:{ all -> 0x0114 }
            goto L_0x00d0
        L_0x00b7:
            int r2 = r9.k     // Catch:{ all -> 0x0114 }
            if (r2 != r3) goto L_0x00d0
            long r4 = r9.j     // Catch:{ all -> 0x0114 }
            long r6 = r9.f     // Catch:{ all -> 0x0114 }
            long r4 = r4 - r6
            long r4 = com.bonree.sdk.bs.ad.a((long) r4)     // Catch:{ all -> 0x0114 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0114 }
            r11.mStayTimeUs = r2     // Catch:{ all -> 0x0114 }
        L_0x00d0:
            java.lang.String r2 = r9.l     // Catch:{ all -> 0x0114 }
            r11.mCorrelationId = r2     // Catch:{ all -> 0x0114 }
            r10.mEventInfo = r11     // Catch:{ all -> 0x0114 }
            com.bonree.sdk.be.f r11 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0114 }
            java.lang.String r2 = "ViewService FragmentEvent model %s, ct %s st %s name %s"
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0114 }
            int r5 = r9.k     // Catch:{ all -> 0x0114 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0114 }
            r4[r0] = r5     // Catch:{ all -> 0x0114 }
            long r5 = r9.d     // Catch:{ all -> 0x0114 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0114 }
            r4[r1] = r5     // Catch:{ all -> 0x0114 }
            long r5 = r9.f     // Catch:{ all -> 0x0114 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0114 }
            r4[r3] = r5     // Catch:{ all -> 0x0114 }
            java.lang.String r9 = r9.b     // Catch:{ all -> 0x0114 }
            r4[r12] = r9     // Catch:{ all -> 0x0114 }
            r11.c(r2, r4)     // Catch:{ all -> 0x0114 }
            r10.uploadStateKey()     // Catch:{ all -> 0x0114 }
            com.bonree.sdk.ba.o r9 = r8.a     // Catch:{ all -> 0x0114 }
            r9.b(r10)     // Catch:{ all -> 0x0114 }
            monitor-exit(r8)
            return
        L_0x0112:
            monitor-exit(r8)
            return
        L_0x0114:
            r9 = move-exception
            com.bonree.sdk.be.f r10 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0128 }
            java.lang.String r11 = "ViewService FragmentEvent onMakePackage error %s."
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ all -> 0x0128 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0128 }
            r12[r0] = r9     // Catch:{ all -> 0x0128 }
            r10.e(r11, r12)     // Catch:{ all -> 0x0128 }
            monitor-exit(r8)
            return
        L_0x0128:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.j.a(com.bonree.sdk.ba.j$a, long, boolean):void");
    }

    private a d(com.bonree.sdk.aa.a aVar) {
        a aVar2;
        synchronized (this.c) {
            aVar2 = this.c.get(Integer.valueOf(aVar.q()));
            if (aVar2 == null) {
                aVar2 = new a((byte) 0);
                String unused = aVar2.c = aVar.a();
                String unused2 = aVar2.b = aVar.b();
                int unused3 = aVar2.a = aVar.q();
                if (((long) this.c.size()) >= 50) {
                    this.c.remove(this.c.keySet().iterator().next());
                }
                this.c.put(Integer.valueOf(aVar.q()), aVar2);
            }
        }
        return aVar2;
    }

    public final void a(long j, long j2) {
        a(j, j2, (String) null);
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(this.d) && !TextUtils.equals(this.d, aVar.a())) {
                synchronized (this.c) {
                    this.c.clear();
                }
            }
            this.d = aVar.a();
            if (com.bonree.sdk.z.a.p.equals(aVar.c()) && 1 == aVar.e()) {
                a(aVar.f(), aVar.j(), aVar.a());
            }
        }
    }

    private void a(long j, long j2, String str) {
        if (!this.c.isEmpty()) {
            synchronized (this.c) {
                if (!this.c.isEmpty()) {
                    for (Map.Entry next : this.c.entrySet()) {
                        a aVar = (a) next.getValue();
                        if (ad.a(str) || TextUtils.equals(str, aVar.c)) {
                            long unused = aVar.j = j;
                            if (aVar.f > 0 || aVar.e == 0) {
                                a(aVar, j2, true);
                            } else {
                                long unused2 = aVar.f = aVar.h;
                                long unused3 = aVar.g = aVar.i;
                                a(aVar, aVar.e, false);
                            }
                            if (aVar.k == 1) {
                                int unused4 = aVar.k = 2;
                                a(aVar, j2, true);
                            }
                            a(((Integer) next.getKey()).intValue());
                        }
                    }
                }
            }
        }
    }

    private void a(int i) {
        if (!this.c.isEmpty()) {
            synchronized (this.c) {
                this.c.remove(Integer.valueOf(i));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        if (!this.c.isEmpty()) {
            synchronized (this.c) {
                this.c.clear();
                this.d = null;
            }
        }
    }

    static class a {
        /* access modifiers changed from: private */
        public int a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public long d;
        /* access modifiers changed from: private */
        public long e;
        /* access modifiers changed from: private */
        public long f;
        /* access modifiers changed from: private */
        public long g;
        /* access modifiers changed from: private */
        public long h;
        /* access modifiers changed from: private */
        public long i;
        /* access modifiers changed from: private */
        public long j;
        /* access modifiers changed from: private */
        public int k;
        /* access modifiers changed from: private */
        public String l;
        /* access modifiers changed from: private */
        public boolean m;
        /* access modifiers changed from: private */
        public EventBean n;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final String toString() {
            return "FragmentEventData{hashCode=" + this.a + ", mFragmentName='" + this.b + '\'' + ", mActivityName='" + this.c + '\'' + ", mCreateTimeMs=" + this.d + ", mCreateTimeStampUs=" + this.e + ", mStartTimeMs=" + this.f + ", mStartTimeStampUs=" + this.g + ", mEndTimeMs=" + this.j + ", mModel=" + this.k + ", mIsSlow=" + this.m + ", mEvent=" + this.n + '}';
        }
    }
}
