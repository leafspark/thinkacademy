package com.bonree.sdk.ba;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.k;
import java.util.Map;

public final class c extends e {
    private static long b = 50;
    private final Map<Integer, a> c = new k();

    public final void a(com.bonree.sdk.k.c cVar) {
    }

    c(o oVar) {
        super(oVar);
    }

    public final void a(com.bonree.sdk.y.a aVar) {
        a aVar2;
        int e = aVar.e();
        if (e != 0) {
            if (e == 1 && (aVar2 = this.c.get(Integer.valueOf(aVar.q()))) != null) {
                if (com.bonree.sdk.y.a.l.equals(aVar.c()) || com.bonree.sdk.y.a.o.equals(aVar.c())) {
                    long unused = aVar2.h = aVar.f();
                    long unused2 = aVar2.i = aVar.j();
                }
                if (com.bonree.sdk.y.a.n.equals(aVar.c()) && aVar2.f <= 0) {
                    long unused3 = aVar2.f = aVar.f();
                    long unused4 = aVar2.g = aVar.j();
                    a(aVar2, aVar.j(), false);
                    int unused5 = aVar2.k = 2;
                }
            }
        } else if (com.bonree.sdk.y.a.l.equals(aVar.c()) || com.bonree.sdk.y.a.n.equals(aVar.c()) || com.bonree.sdk.y.a.o.equals(aVar.c())) {
            a d = d(aVar);
            if (d.d <= 0) {
                long unused6 = d.d = aVar.f();
                long unused7 = d.e = aVar.j();
                int unused8 = d.k = 1;
                a(d, d.e);
            }
        }
    }

    private void b(com.bonree.sdk.y.a aVar) {
        if (com.bonree.sdk.y.a.l.equals(aVar.c()) || com.bonree.sdk.y.a.n.equals(aVar.c()) || com.bonree.sdk.y.a.o.equals(aVar.c())) {
            a d = d(aVar);
            if (d.d <= 0) {
                long unused = d.d = aVar.f();
                long unused2 = d.e = aVar.j();
                int unused3 = d.k = 1;
                a(d, d.e);
            }
        }
    }

    private void c(com.bonree.sdk.y.a aVar) {
        a aVar2 = this.c.get(Integer.valueOf(aVar.q()));
        if (aVar2 != null) {
            if (com.bonree.sdk.y.a.l.equals(aVar.c()) || com.bonree.sdk.y.a.o.equals(aVar.c())) {
                long unused = aVar2.h = aVar.f();
                long unused2 = aVar2.i = aVar.j();
            }
            if (com.bonree.sdk.y.a.n.equals(aVar.c()) && aVar2.f <= 0) {
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
            com.bonree.sdk.be.a.a().e("ViewService AbilitySliceEvent onStartPackage error %s.", th.getMessage());
            return null;
        }
        return aVar.n;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0115, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.bonree.sdk.ba.c.a r8, long r9, boolean r11) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 != 0) goto L_0x0005
            monitor-exit(r7)
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L_0x000e
            com.bonree.sdk.agent.business.entity.EventBean r9 = r7.a((com.bonree.sdk.ba.c.a) r8, (long) r9)     // Catch:{ all -> 0x0116 }
            goto L_0x0012
        L_0x000e:
            com.bonree.sdk.agent.business.entity.EventBean r9 = r8.n     // Catch:{ all -> 0x0116 }
        L_0x0012:
            if (r9 == 0) goto L_0x0114
            com.bonree.sdk.ba.o r10 = r7.a     // Catch:{ all -> 0x0116 }
            if (r10 != 0) goto L_0x001a
            goto L_0x0114
        L_0x001a:
            com.bonree.sdk.agent.business.entity.ViewEventInfoBean r10 = new com.bonree.sdk.agent.business.entity.ViewEventInfoBean     // Catch:{ all -> 0x0116 }
            r10.<init>()     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = r8.l     // Catch:{ all -> 0x0116 }
            r10.mCorrelationId = r11     // Catch:{ all -> 0x0116 }
            int r11 = r8.k     // Catch:{ all -> 0x0116 }
            r10.mModel = r11     // Catch:{ all -> 0x0116 }
            r11 = 9
            r10.mType = r11     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = r8.c     // Catch:{ all -> 0x0116 }
            r10.mParentView = r11     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = r8.b     // Catch:{ all -> 0x0116 }
            r10.mName = r11     // Catch:{ all -> 0x0116 }
            r10.isCustom = r0     // Catch:{ all -> 0x0116 }
            boolean r11 = r8.m     // Catch:{ all -> 0x0116 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x0116 }
            r10.mIsSlow = r11     // Catch:{ all -> 0x0116 }
            long r2 = r8.f     // Catch:{ all -> 0x0116 }
            long r4 = r8.d     // Catch:{ all -> 0x0116 }
            long r2 = r2 - r4
            long r2 = com.bonree.sdk.bs.ad.a((long) r2)     // Catch:{ all -> 0x0116 }
            r10.mLoadTimeUs = r2     // Catch:{ all -> 0x0116 }
            long r2 = r10.mLoadTimeUs     // Catch:{ all -> 0x0116 }
            r4 = 10000000(0x989680, double:4.9406565E-317)
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 > 0) goto L_0x0067
            long r2 = r10.mLoadTimeUs     // Catch:{ all -> 0x0116 }
            r4 = 0
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 > 0) goto L_0x0072
        L_0x0067:
            r2 = 999(0x3e7, double:4.936E-321)
            r10.mLoadTimeUs = r2     // Catch:{ all -> 0x0116 }
            long r2 = r8.d     // Catch:{ all -> 0x0116 }
            long unused = r8.f = r2     // Catch:{ all -> 0x0116 }
        L_0x0072:
            int r11 = r8.k     // Catch:{ all -> 0x0116 }
            r2 = 2
            if (r11 != r1) goto L_0x00b8
            java.util.UUID r11 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0116 }
            java.lang.String unused = r8.l = r11     // Catch:{ all -> 0x0116 }
            long r3 = r10.mLoadTimeUs     // Catch:{ all -> 0x0116 }
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            com.bonree.sdk.ba.o r11 = r7.a     // Catch:{ all -> 0x0116 }
            int r11 = r11.a()     // Catch:{ all -> 0x0116 }
            long r5 = (long) r11     // Catch:{ all -> 0x0116 }
            int r11 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r11 <= 0) goto L_0x00d1
            com.bonree.sdk.ba.o r11 = r7.a     // Catch:{ all -> 0x0116 }
            com.bonree.sdk.ba.q r11 = r11.d()     // Catch:{ all -> 0x0116 }
            if (r11 == 0) goto L_0x00d1
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0116 }
            r10.mIsSlow = r11     // Catch:{ all -> 0x0116 }
            boolean unused = r8.m = true     // Catch:{ all -> 0x0116 }
            com.bonree.sdk.ba.o r11 = r7.a     // Catch:{ all -> 0x0116 }
            com.bonree.sdk.ba.q r11 = r11.d()     // Catch:{ all -> 0x0116 }
            long r3 = r8.d     // Catch:{ all -> 0x0116 }
            long r5 = r8.f     // Catch:{ all -> 0x0116 }
            java.util.List r11 = r11.b((long) r3, (long) r5)     // Catch:{ all -> 0x0116 }
            r10.mThreadMethodInfo = r11     // Catch:{ all -> 0x0116 }
            goto L_0x00d1
        L_0x00b8:
            int r11 = r8.k     // Catch:{ all -> 0x0116 }
            if (r11 != r2) goto L_0x00d1
            long r3 = r8.j     // Catch:{ all -> 0x0116 }
            long r5 = r8.f     // Catch:{ all -> 0x0116 }
            long r3 = r3 - r5
            long r3 = com.bonree.sdk.bs.ad.a((long) r3)     // Catch:{ all -> 0x0116 }
            java.lang.Long r11 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0116 }
            r10.mStayTimeUs = r11     // Catch:{ all -> 0x0116 }
        L_0x00d1:
            java.lang.String r11 = r8.l     // Catch:{ all -> 0x0116 }
            r10.mCorrelationId = r11     // Catch:{ all -> 0x0116 }
            r9.mEventInfo = r10     // Catch:{ all -> 0x0116 }
            com.bonree.sdk.be.f r10 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = "ViewService AbilitySliceEvent model %s, ct %s st %s name %s"
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0116 }
            int r4 = r8.k     // Catch:{ all -> 0x0116 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0116 }
            r3[r0] = r4     // Catch:{ all -> 0x0116 }
            long r4 = r8.d     // Catch:{ all -> 0x0116 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0116 }
            r3[r1] = r4     // Catch:{ all -> 0x0116 }
            long r4 = r8.f     // Catch:{ all -> 0x0116 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0116 }
            r3[r2] = r4     // Catch:{ all -> 0x0116 }
            r2 = 3
            java.lang.String r8 = r8.b     // Catch:{ all -> 0x0116 }
            r3[r2] = r8     // Catch:{ all -> 0x0116 }
            r10.c(r11, r3)     // Catch:{ all -> 0x0116 }
            r9.uploadStateKey()     // Catch:{ all -> 0x0116 }
            com.bonree.sdk.ba.o r8 = r7.a     // Catch:{ all -> 0x0116 }
            r8.b(r9)     // Catch:{ all -> 0x0116 }
            monitor-exit(r7)
            return
        L_0x0114:
            monitor-exit(r7)
            return
        L_0x0116:
            r8 = move-exception
            com.bonree.sdk.be.f r9 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x012a }
            java.lang.String r10 = "ViewService AbilitySliceEvent onMakePackage error %s."
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ all -> 0x012a }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x012a }
            r11[r0] = r8     // Catch:{ all -> 0x012a }
            r9.e(r10, r11)     // Catch:{ all -> 0x012a }
            monitor-exit(r7)
            return
        L_0x012a:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.c.a(com.bonree.sdk.ba.c$a, long, boolean):void");
    }

    private a d(com.bonree.sdk.y.a aVar) {
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

    public final void a(com.bonree.sdk.x.a aVar) {
        if (com.bonree.sdk.x.a.o.equals(aVar.c()) && 1 == aVar.e()) {
            a(aVar.f(), aVar.j(), aVar.a());
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
            return "AbilitySliceEventData{hashCode=" + this.a + ", mAbilitySliceName='" + this.b + '\'' + ", mAbilityName='" + this.c + '\'' + ", mCreateTimeMs=" + this.d + ", mCreateTimeStampUs=" + this.e + ", mStartTimeMs=" + this.f + ", mStartTimeStampUs=" + this.g + ", mEndTimeMs=" + this.j + ", mModel=" + this.k + ", mIsSlow=" + this.m + ", mEvent=" + this.n + '}';
        }
    }
}
