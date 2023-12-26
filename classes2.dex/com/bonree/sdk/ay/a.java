package com.bonree.sdk.ay;

import com.bonree.sdk.agent.business.entity.TrafficUsageBean;
import com.bonree.sdk.ay.c;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.d.e;
import java.util.ArrayList;
import java.util.List;

public final class a extends e {
    private c k;

    public a(e eVar) {
        super((e) null);
    }

    public final void b(int i) {
        super.b(i);
        c a = c.a.a;
        this.k = a;
        a.a(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x021c, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r13, boolean r14, com.bonree.sdk.ay.e r15) {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x021d }
            if (r0 != 0) goto L_0x021b
            if (r15 != 0) goto L_0x000b
            goto L_0x021b
        L_0x000b:
            boolean r0 = r15 instanceof com.bonree.sdk.ay.a     // Catch:{ all -> 0x021d }
            if (r0 == 0) goto L_0x0219
            com.bonree.sdk.ay.a r15 = (com.bonree.sdk.ay.a) r15     // Catch:{ all -> 0x021d }
            com.bonree.sdk.ay.c r0 = r15.k     // Catch:{ all -> 0x021d }
            r0.b()     // Catch:{ all -> 0x021d }
            com.bonree.sdk.ay.c r1 = r15.k     // Catch:{ all -> 0x021d }
            int r1 = r1.f()     // Catch:{ all -> 0x021d }
            com.bonree.sdk.be.f r2 = r12.c     // Catch:{ all -> 0x021d }
            java.lang.String r3 = "%s computeTraffic standard = %s, beforeNetType = %d"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x021d }
            java.lang.String r5 = "Traffic-"
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x021d }
            r5 = 1
            r4[r5] = r13     // Catch:{ all -> 0x021d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x021d }
            r7 = 2
            r4[r7] = r1     // Catch:{ all -> 0x021d }
            r2.c(r3, r4)     // Catch:{ all -> 0x021d }
            com.bonree.sdk.ay.c r1 = r15.k     // Catch:{ all -> 0x021d }
            int r1 = r1.f()     // Catch:{ all -> 0x021d }
            r2 = -1
            if (r1 == 0) goto L_0x0137
            com.bonree.sdk.ay.c r1 = r15.k     // Catch:{ all -> 0x021d }
            int r1 = r1.f()     // Catch:{ all -> 0x021d }
            if (r1 != r2) goto L_0x0050
            java.lang.String r1 = "WiFi"
            boolean r1 = r1.equals(r13)     // Catch:{ all -> 0x021d }
            if (r1 == 0) goto L_0x0050
            goto L_0x0137
        L_0x0050:
            com.bonree.sdk.ay.c r1 = r15.k     // Catch:{ all -> 0x021d }
            int r1 = r1.f()     // Catch:{ all -> 0x021d }
            if (r1 == r5) goto L_0x0080
            com.bonree.sdk.ay.c r1 = r15.k     // Catch:{ all -> 0x021d }
            int r1 = r1.f()     // Catch:{ all -> 0x021d }
            if (r1 != r2) goto L_0x0071
            java.lang.String r1 = "WiFi"
            boolean r1 = r1.equals(r13)     // Catch:{ all -> 0x021d }
            if (r1 != 0) goto L_0x0071
            java.lang.String r1 = "NaN"
            boolean r1 = r1.equals(r13)     // Catch:{ all -> 0x021d }
            if (r1 != 0) goto L_0x0071
            goto L_0x0080
        L_0x0071:
            com.bonree.sdk.be.f r0 = r15.c     // Catch:{ all -> 0x021d }
            java.lang.String r1 = "%s traffic is unknown"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x021d }
            java.lang.String r3 = "Traffic-"
            r2[r6] = r3     // Catch:{ all -> 0x021d }
            r0.c(r1, r2)     // Catch:{ all -> 0x021d }
            goto L_0x019b
        L_0x0080:
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r1 = r15.j     // Catch:{ all -> 0x021d }
            if (r1 != 0) goto L_0x009b
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r1 = new com.bonree.sdk.agent.business.entity.TrafficUsageBean     // Catch:{ all -> 0x021d }
            r1.<init>()     // Catch:{ all -> 0x021d }
            long r3 = r0.a     // Catch:{ all -> 0x021d }
            long r3 = a((long) r3)     // Catch:{ all -> 0x021d }
            long r8 = r0.b     // Catch:{ all -> 0x021d }
            long r8 = a((long) r8)     // Catch:{ all -> 0x021d }
            long r3 = r3 + r8
            r1.mTrafficUsage = r3     // Catch:{ all -> 0x021d }
            r15.j = r1     // Catch:{ all -> 0x021d }
            goto L_0x00ad
        L_0x009b:
            long r3 = r1.mTrafficUsage     // Catch:{ all -> 0x021d }
            long r8 = r0.a     // Catch:{ all -> 0x021d }
            long r8 = a((long) r8)     // Catch:{ all -> 0x021d }
            long r10 = r0.b     // Catch:{ all -> 0x021d }
            long r10 = a((long) r10)     // Catch:{ all -> 0x021d }
            long r8 = r8 + r10
            long r3 = r3 + r8
            r1.mTrafficUsage = r3     // Catch:{ all -> 0x021d }
        L_0x00ad:
            com.bonree.sdk.ay.c r0 = r15.k     // Catch:{ all -> 0x021d }
            int r0 = r0.f()     // Catch:{ all -> 0x021d }
            if (r0 != r2) goto L_0x00d8
            java.lang.String r0 = "WiFi"
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x021d }
            if (r0 != 0) goto L_0x00d8
            java.lang.String r0 = "NaN"
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x021d }
            if (r0 != 0) goto L_0x00d8
            java.lang.String r0 = r15.g     // Catch:{ all -> 0x021d }
            boolean r0 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ all -> 0x021d }
            if (r0 == 0) goto L_0x00d8
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x021d }
            r15.g = r0     // Catch:{ all -> 0x021d }
            goto L_0x0102
        L_0x00d8:
            com.bonree.sdk.ay.c r0 = r15.k     // Catch:{ all -> 0x021d }
            int r0 = r0.f()     // Catch:{ all -> 0x021d }
            if (r0 != r5) goto L_0x0102
            java.lang.String r0 = "WiFi"
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x021d }
            if (r0 != 0) goto L_0x0102
            java.lang.String r0 = "NaN"
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x021d }
            if (r0 != 0) goto L_0x0102
            java.lang.String r0 = r15.g     // Catch:{ all -> 0x021d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x021d }
            if (r0 == 0) goto L_0x0102
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x021d }
            r15.g = r0     // Catch:{ all -> 0x021d }
        L_0x0102:
            java.lang.String r0 = r15.g     // Catch:{ all -> 0x021d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x021d }
            if (r0 != 0) goto L_0x010f
            java.lang.String r0 = r15.g     // Catch:{ all -> 0x021d }
            r1.netStateInfoKey = r0     // Catch:{ all -> 0x021d }
            goto L_0x0125
        L_0x010f:
            java.lang.String r0 = r1.netStateInfoKey     // Catch:{ all -> 0x021d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x021d }
            if (r0 == 0) goto L_0x0125
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x021d }
            r15.g = r0     // Catch:{ all -> 0x021d }
            java.lang.String r0 = r15.g     // Catch:{ all -> 0x021d }
            r1.netStateInfoKey = r0     // Catch:{ all -> 0x021d }
        L_0x0125:
            com.bonree.sdk.be.f r0 = r15.c     // Catch:{ all -> 0x021d }
            java.lang.String r1 = "%s traffic is mobile, key =%s"
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ all -> 0x021d }
            java.lang.String r3 = "Traffic-"
            r2[r6] = r3     // Catch:{ all -> 0x021d }
            java.lang.String r3 = r15.g     // Catch:{ all -> 0x021d }
            r2[r5] = r3     // Catch:{ all -> 0x021d }
            r0.c(r1, r2)     // Catch:{ all -> 0x021d }
            goto L_0x019b
        L_0x0137:
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r1 = r15.i     // Catch:{ all -> 0x021d }
            if (r1 != 0) goto L_0x0152
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r1 = new com.bonree.sdk.agent.business.entity.TrafficUsageBean     // Catch:{ all -> 0x021d }
            r1.<init>()     // Catch:{ all -> 0x021d }
            long r3 = r0.a     // Catch:{ all -> 0x021d }
            long r3 = a((long) r3)     // Catch:{ all -> 0x021d }
            long r8 = r0.b     // Catch:{ all -> 0x021d }
            long r8 = a((long) r8)     // Catch:{ all -> 0x021d }
            long r3 = r3 + r8
            r1.mTrafficUsage = r3     // Catch:{ all -> 0x021d }
            r15.i = r1     // Catch:{ all -> 0x021d }
            goto L_0x0164
        L_0x0152:
            long r3 = r1.mTrafficUsage     // Catch:{ all -> 0x021d }
            long r8 = r0.a     // Catch:{ all -> 0x021d }
            long r8 = a((long) r8)     // Catch:{ all -> 0x021d }
            long r10 = r0.b     // Catch:{ all -> 0x021d }
            long r10 = a((long) r10)     // Catch:{ all -> 0x021d }
            long r8 = r8 + r10
            long r3 = r3 + r8
            r1.mTrafficUsage = r3     // Catch:{ all -> 0x021d }
        L_0x0164:
            com.bonree.sdk.ay.c r0 = r15.k     // Catch:{ all -> 0x021d }
            int r0 = r0.f()     // Catch:{ all -> 0x021d }
            if (r0 != r2) goto L_0x0186
            java.lang.String r0 = "WiFi"
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x021d }
            if (r0 == 0) goto L_0x0186
            java.lang.String r0 = r15.f     // Catch:{ all -> 0x021d }
            boolean r0 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ all -> 0x021d }
            if (r0 == 0) goto L_0x0186
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r0 = r0.e()     // Catch:{ all -> 0x021d }
            r15.f = r0     // Catch:{ all -> 0x021d }
        L_0x0186:
            java.lang.String r0 = r15.f     // Catch:{ all -> 0x021d }
            r1.netStateInfoKey = r0     // Catch:{ all -> 0x021d }
            com.bonree.sdk.be.f r0 = r15.c     // Catch:{ all -> 0x021d }
            java.lang.String r1 = "%s traffic is wifi, before key = %s"
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ all -> 0x021d }
            java.lang.String r3 = "Traffic-"
            r2[r6] = r3     // Catch:{ all -> 0x021d }
            java.lang.String r3 = r15.f     // Catch:{ all -> 0x021d }
            r2[r5] = r3     // Catch:{ all -> 0x021d }
            r0.c(r1, r2)     // Catch:{ all -> 0x021d }
        L_0x019b:
            if (r14 == 0) goto L_0x01ee
            java.lang.String r14 = "WiFi"
            boolean r14 = r14.equals(r13)     // Catch:{ all -> 0x021d }
            if (r14 == 0) goto L_0x01c2
            com.bonree.sdk.at.c r14 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r0 = r15.f     // Catch:{ all -> 0x021d }
            r14.a((java.lang.String) r0, (boolean) r5)     // Catch:{ all -> 0x021d }
            com.bonree.sdk.at.c r14 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r14 = r14.e()     // Catch:{ all -> 0x021d }
            r15.f = r14     // Catch:{ all -> 0x021d }
            com.bonree.sdk.at.c r14 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r15 = r15.f     // Catch:{ all -> 0x021d }
            r14.b((java.lang.String) r15)     // Catch:{ all -> 0x021d }
            goto L_0x01ee
        L_0x01c2:
            java.lang.String r14 = "WiFi"
            boolean r14 = r14.equals(r13)     // Catch:{ all -> 0x021d }
            if (r14 != 0) goto L_0x01ee
            java.lang.String r14 = "NaN"
            boolean r14 = r14.equals(r13)     // Catch:{ all -> 0x021d }
            if (r14 != 0) goto L_0x01ee
            com.bonree.sdk.at.c r14 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r0 = r15.g     // Catch:{ all -> 0x021d }
            r14.a((java.lang.String) r0, (boolean) r5)     // Catch:{ all -> 0x021d }
            com.bonree.sdk.at.c r14 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r14 = r14.e()     // Catch:{ all -> 0x021d }
            r15.g = r14     // Catch:{ all -> 0x021d }
            com.bonree.sdk.at.c r14 = com.bonree.sdk.at.c.m()     // Catch:{ all -> 0x021d }
            java.lang.String r15 = r15.g     // Catch:{ all -> 0x021d }
            r14.b((java.lang.String) r15)     // Catch:{ all -> 0x021d }
        L_0x01ee:
            java.lang.String r14 = "WiFi"
            boolean r14 = r14.equals(r13)     // Catch:{ all -> 0x021d }
            if (r14 == 0) goto L_0x01ff
            com.bonree.sdk.ay.c r13 = com.bonree.sdk.ay.c.a.a     // Catch:{ all -> 0x021d }
            r13.c()     // Catch:{ all -> 0x021d }
            monitor-exit(r12)
            return
        L_0x01ff:
            java.lang.String r14 = "NaN"
            boolean r13 = r14.equals(r13)     // Catch:{ all -> 0x021d }
            if (r13 == 0) goto L_0x0210
            com.bonree.sdk.ay.c r13 = com.bonree.sdk.ay.c.a.a     // Catch:{ all -> 0x021d }
            r13.e()     // Catch:{ all -> 0x021d }
            monitor-exit(r12)
            return
        L_0x0210:
            com.bonree.sdk.ay.c r13 = com.bonree.sdk.ay.c.a.a     // Catch:{ all -> 0x021d }
            r13.d()     // Catch:{ all -> 0x021d }
            monitor-exit(r12)
            return
        L_0x0219:
            monitor-exit(r12)
            return
        L_0x021b:
            monitor-exit(r12)
            return
        L_0x021d:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ay.a.a(java.lang.String, boolean, com.bonree.sdk.ay.e):void");
    }

    public final synchronized List<TrafficUsageBean> a() {
        String j = com.bonree.sdk.at.c.m().j();
        if (j == null) {
            int i = com.bonree.sdk.at.c.m().i();
            j = i == -1 ? "NaN" : i == 0 ? "WiFi" : ad.a.a(i);
        }
        a(j, false, this);
        if (this.j != null) {
            this.h.add(this.j);
        }
        if (this.i != null) {
            this.h.add(this.i);
        }
        if (this.h.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.h);
        this.h.clear();
        this.i = null;
        this.j = null;
        return arrayList;
    }

    public final void c(String str) {
        this.c.c("%s onNetStateChange standard=%s  time=%d", "Traffic-", str, Long.valueOf(System.currentTimeMillis()));
        if (!"NaN".equals(str)) {
            a(1, (Object) str);
        }
    }

    public static a d() {
        return C0010a.a;
    }

    /* renamed from: com.bonree.sdk.ay.a$a  reason: collision with other inner class name */
    static class C0010a {
        /* access modifiers changed from: private */
        public static final a a = new a((e) null);

        private C0010a() {
        }
    }
}
