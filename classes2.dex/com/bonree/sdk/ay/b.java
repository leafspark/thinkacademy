package com.bonree.sdk.ay;

import com.bonree.sdk.agent.business.entity.TrafficUsageBean;
import com.bonree.sdk.bs.q;
import com.bonree.sdk.d.e;
import java.util.ArrayList;
import java.util.List;
import ohos.app.Context;
import ohos.net.DataFlowStatistics;

public final class b extends e {
    private Context k;
    private volatile long l = 0;
    private volatile long m = 0;
    private volatile int n;

    public b(e eVar) {
        super((e) null);
    }

    public final void b(int i) {
        super.b(i);
        Context a2 = q.a();
        this.k = a2;
        try {
            int uidByBundleName = a2.getBundleManager().getUidByBundleName(this.k.getBundleName(), 0);
            this.l = a(DataFlowStatistics.getUidRxBytes(uidByBundleName));
            this.m = a(DataFlowStatistics.getUidTxBytes(uidByBundleName));
        } catch (Throwable th) {
            this.c.e("Traffic-", " getUidByBundleName error: ", th);
        }
        this.n = i;
    }

    private static int b(String str) {
        if ("WiFi".equals(str)) {
            return 0;
        }
        return "NaN".equals(str) ? -1 : 1;
    }

    public final synchronized List<TrafficUsageBean> a() {
        a(com.bonree.sdk.d.a.Z(), false, (e) null);
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

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r16, boolean r17, com.bonree.sdk.ay.e r18) {
        /*
            r15 = this;
            r1 = r15
            java.lang.String r2 = "Traffic-"
            int r3 = b((java.lang.String) r16)
            r4 = 0
            r6 = 2
            r7 = 0
            r8 = 1
            ohos.app.Context r0 = r1.k     // Catch:{ all -> 0x002f }
            ohos.bundle.IBundleManager r0 = r0.getBundleManager()     // Catch:{ all -> 0x002f }
            ohos.app.Context r9 = r1.k     // Catch:{ all -> 0x002f }
            java.lang.String r9 = r9.getBundleName()     // Catch:{ all -> 0x002f }
            int r0 = r0.getUidByBundleName(r9, r7)     // Catch:{ all -> 0x002f }
            long r9 = ohos.net.DataFlowStatistics.getUidRxBytes(r0)     // Catch:{ all -> 0x002f }
            long r9 = a((long) r9)     // Catch:{ all -> 0x002f }
            long r11 = ohos.net.DataFlowStatistics.getUidTxBytes(r0)     // Catch:{ all -> 0x002d }
            long r4 = a((long) r11)     // Catch:{ all -> 0x002d }
            goto L_0x003e
        L_0x002d:
            r0 = move-exception
            goto L_0x0031
        L_0x002f:
            r0 = move-exception
            r9 = r4
        L_0x0031:
            com.bonree.sdk.be.f r11 = r1.c
            java.lang.Object[] r12 = new java.lang.Object[r6]
            java.lang.String r13 = " getUidByBundleName error: "
            r12[r7] = r13
            r12[r8] = r0
            r11.e(r2, r12)
        L_0x003e:
            long r11 = r1.l
            long r11 = r9 - r11
            long r11 = a((long) r11)
            long r13 = r1.m
            long r13 = r4 - r13
            long r13 = a((long) r13)
            r1.l = r9
            r1.m = r4
            int r0 = r1.n
            r4 = -1
            if (r0 == 0) goto L_0x00bd
            if (r3 != 0) goto L_0x005e
            int r0 = r1.n
            if (r4 != r0) goto L_0x005e
            goto L_0x00bd
        L_0x005e:
            int r0 = r1.n
            if (r8 == r0) goto L_0x0076
            int r0 = r1.n
            if (r4 != r0) goto L_0x0069
            if (r8 != r3) goto L_0x0069
            goto L_0x0076
        L_0x0069:
            com.bonree.sdk.be.f r0 = r1.c
            java.lang.Object[] r4 = new java.lang.Object[r8]
            r4[r7] = r2
            java.lang.String r2 = "%s traffic is unknown"
            r0.c(r2, r4)
            goto L_0x0103
        L_0x0076:
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = r1.j
            if (r0 != 0) goto L_0x0087
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = new com.bonree.sdk.agent.business.entity.TrafficUsageBean
            r0.<init>()
            r1.j = r0
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = r1.j
            long r11 = r11 + r13
            r0.mTrafficUsage = r11
            goto L_0x008f
        L_0x0087:
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = r1.j
            long r9 = r0.mTrafficUsage
            long r11 = r11 + r13
            long r9 = r9 + r11
            r0.mTrafficUsage = r9
        L_0x008f:
            int r0 = r1.n
            if (r4 != r0) goto L_0x00a7
            if (r8 != r3) goto L_0x00a7
            java.lang.String r0 = r1.g
            boolean r0 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x00a7
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            java.lang.String r0 = r0.e()
            r1.g = r0
        L_0x00a7:
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = r1.j
            java.lang.String r4 = r1.g
            r0.netStateInfoKey = r4
            com.bonree.sdk.be.f r0 = r1.c
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r7] = r2
            java.lang.String r2 = r1.g
            r4[r8] = r2
            java.lang.String r2 = "%s traffic is mobile, key =%s"
            r0.c(r2, r4)
            goto L_0x0103
        L_0x00bd:
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = r1.i
            if (r0 != 0) goto L_0x00ce
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = new com.bonree.sdk.agent.business.entity.TrafficUsageBean
            r0.<init>()
            r1.i = r0
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = r1.i
            long r11 = r11 + r13
            r0.mTrafficUsage = r11
            goto L_0x00d6
        L_0x00ce:
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = r1.i
            long r9 = r0.mTrafficUsage
            long r11 = r11 + r13
            long r9 = r9 + r11
            r0.mTrafficUsage = r9
        L_0x00d6:
            if (r3 != 0) goto L_0x00ee
            int r0 = r1.n
            if (r4 != r0) goto L_0x00ee
            java.lang.String r0 = r1.f
            boolean r0 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x00ee
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            java.lang.String r0 = r0.e()
            r1.f = r0
        L_0x00ee:
            com.bonree.sdk.agent.business.entity.TrafficUsageBean r0 = r1.i
            java.lang.String r4 = r1.f
            r0.netStateInfoKey = r4
            com.bonree.sdk.be.f r0 = r1.c
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r7] = r2
            java.lang.String r2 = r1.f
            r4[r8] = r2
            java.lang.String r2 = "%s traffic is wifi, before key =%s"
            r0.c(r2, r4)
        L_0x0103:
            if (r17 == 0) goto L_0x0146
            if (r3 != 0) goto L_0x0124
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            java.lang.String r2 = r1.f
            r0.a((java.lang.String) r2, (boolean) r8)
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            java.lang.String r0 = r0.e()
            r1.f = r0
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            java.lang.String r2 = r1.f
            r0.b((java.lang.String) r2)
            goto L_0x0144
        L_0x0124:
            if (r8 != r3) goto L_0x0144
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            java.lang.String r2 = r1.g
            r0.a((java.lang.String) r2, (boolean) r8)
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            java.lang.String r0 = r0.e()
            r1.g = r0
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            r2 = r18
            java.lang.String r2 = r2.g
            r0.b((java.lang.String) r2)
        L_0x0144:
            r1.n = r3
        L_0x0146:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ay.b.a(java.lang.String, boolean, com.bonree.sdk.ay.e):void");
    }

    public static b d() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((e) null);

        private a() {
        }
    }
}
