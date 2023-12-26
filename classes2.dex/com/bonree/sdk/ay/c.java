package com.bonree.sdk.ay;

import android.net.TrafficStats;
import android.os.Process;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c {
    private static final String c = "/proc/uid_stat/";
    private static final String d = "tcp_rcv";
    private static final String e = "tcp_snd";
    private static int o = -1;
    private static int p = 0;
    private static int q = 1;
    long a;
    long b;
    private Queue<Long> f;
    private long g;
    private long h;
    private long i;
    private long j;
    private int k;
    private boolean l;
    private int m;
    private boolean n;

    /* synthetic */ c(byte b2) {
        this();
    }

    private c() {
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.l = false;
        this.m = -1;
        this.n = true;
        this.f = new ConcurrentLinkedQueue();
    }

    static c a() {
        return a.a;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        int myUid = Process.myUid();
        this.k = myUid;
        long[] c2 = c(myUid);
        if (c2.length == 2) {
            this.g = c2[0];
            this.h = c2[1];
        }
        if (this.g <= 0 || this.h <= 0) {
            this.l = true;
            this.g = TrafficStats.getUidRxBytes(this.k);
            this.h = TrafficStats.getUidTxBytes(this.k);
        }
        this.m = i2;
    }

    private static long[] b(int i2) {
        return c(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7 A[SYNTHETIC, Splitter:B:35:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf A[Catch:{ all -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long[] c(int r9) {
        /*
            java.lang.String r0 = "/proc/uid_stat/"
            java.lang.String r1 = "Traffic:Exception getTotalBytesManual BufferedReader: %s"
            r2 = 2
            long[] r2 = new long[r2]
            r2 = {-1, -1} // fill-array
            r3 = 0
            r4 = 0
            r5 = 1
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00a2 }
            r6.<init>(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String[] r6 = r6.list()     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x00a1
            int r7 = r6.length     // Catch:{ all -> 0x00a2 }
            if (r7 != 0) goto L_0x001d
            goto L_0x00a1
        L_0x001d:
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ all -> 0x00a2 }
            java.lang.String r7 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00a2 }
            boolean r6 = r6.contains(r7)     // Catch:{ all -> 0x00a2 }
            if (r6 != 0) goto L_0x002c
            return r2
        L_0x002c:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r7.<init>(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00a2 }
            r7.append(r9)     // Catch:{ all -> 0x00a2 }
            java.lang.String r9 = r7.toString()     // Catch:{ all -> 0x00a2 }
            r6.<init>(r9)     // Catch:{ all -> 0x00a2 }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = "tcp_rcv"
            r9.<init>(r6, r0)     // Catch:{ all -> 0x00a2 }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00a2 }
            java.lang.String r7 = "tcp_snd"
            r0.<init>(r6, r7)     // Catch:{ all -> 0x00a2 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x00a2 }
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ all -> 0x00a2 }
            r7.<init>(r9)     // Catch:{ all -> 0x00a2 }
            r6.<init>(r7)     // Catch:{ all -> 0x00a2 }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ all -> 0x009d }
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ all -> 0x009d }
            r7.<init>(r0)     // Catch:{ all -> 0x009d }
            r9.<init>(r7)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = r6.readLine()     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x0073
            java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x009b }
            long r7 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x009b }
            r2[r4] = r7     // Catch:{ all -> 0x009b }
        L_0x0073:
            java.lang.String r0 = r9.readLine()     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x0083
            java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x009b }
            long r7 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x009b }
            r2[r5] = r7     // Catch:{ all -> 0x009b }
        L_0x0083:
            r6.close()     // Catch:{ all -> 0x008a }
            r9.close()     // Catch:{ all -> 0x008a }
            goto L_0x009a
        L_0x008a:
            r9 = move-exception
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r9 = r9.toString()
            r3[r4] = r9
            r0.d(r1, r3)
        L_0x009a:
            return r2
        L_0x009b:
            r0 = move-exception
            goto L_0x009f
        L_0x009d:
            r0 = move-exception
            r9 = r3
        L_0x009f:
            r3 = r6
            goto L_0x00a4
        L_0x00a1:
            return r2
        L_0x00a2:
            r0 = move-exception
            r9 = r3
        L_0x00a4:
            com.bonree.sdk.be.f r6 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00d3 }
            java.lang.String r7 = "Traffic:Exception getTotalBytesManual :%s"
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x00d3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00d3 }
            r8[r4] = r0     // Catch:{ all -> 0x00d3 }
            r6.d(r7, r8)     // Catch:{ all -> 0x00d3 }
            if (r3 == 0) goto L_0x00bd
            r3.close()     // Catch:{ all -> 0x00bb }
            goto L_0x00bd
        L_0x00bb:
            r9 = move-exception
            goto L_0x00c3
        L_0x00bd:
            if (r9 == 0) goto L_0x00d2
            r9.close()     // Catch:{ all -> 0x00bb }
            goto L_0x00d2
        L_0x00c3:
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r9 = r9.toString()
            r3[r4] = r9
            r0.d(r1, r3)
        L_0x00d2:
            return r2
        L_0x00d3:
            r0 = move-exception
            if (r3 == 0) goto L_0x00dc
            r3.close()     // Catch:{ all -> 0x00da }
            goto L_0x00dc
        L_0x00da:
            r9 = move-exception
            goto L_0x00e2
        L_0x00dc:
            if (r9 == 0) goto L_0x00f1
            r9.close()     // Catch:{ all -> 0x00da }
            goto L_0x00f1
        L_0x00e2:
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r9 = r9.toString()
            r3[r4] = r9
            r2.d(r1, r3)
        L_0x00f1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ay.c.c(int):long[]");
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        long j2;
        long j3;
        if (this.l) {
            j3 = TrafficStats.getUidRxBytes(this.k);
            j2 = TrafficStats.getUidTxBytes(this.k);
        } else {
            long[] c2 = c(this.k);
            if (c2.length == 2) {
                j3 = c2[0];
                j2 = c2[1];
            } else {
                j3 = 0;
                j2 = 0;
            }
        }
        long j4 = j3 - this.g;
        long j5 = j2 - this.h;
        this.g = j3;
        this.h = j2;
        if (com.bonree.sdk.at.c.m().l()) {
            this.b = 0;
            this.a = j4 + j5;
            return;
        }
        this.b = j4 + j5;
        this.a = 0;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.m = 0;
        if (this.l) {
            this.i = TrafficStats.getUidRxBytes(this.k);
            this.j = TrafficStats.getUidTxBytes(this.k);
        } else {
            long[] c2 = c(this.k);
            if (c2.length == 2) {
                this.i = c2[0];
                this.j = c2[1];
            }
        }
        if (com.bonree.sdk.at.c.m().i() <= 0 && this.n) {
            this.i = this.g;
            this.j = this.h;
        }
        this.n = false;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        long j2;
        if (this.m == 0) {
            long j3 = 0;
            if (this.l) {
                j3 = TrafficStats.getUidRxBytes(this.k);
                j2 = TrafficStats.getUidTxBytes(this.k);
            } else {
                long[] c2 = c(this.k);
                if (c2.length == 2) {
                    j3 = c2[0];
                    j2 = c2[1];
                } else {
                    j2 = 0;
                }
            }
            this.f.add(Long.valueOf((j3 - this.i) + (j2 - this.j)));
            this.m = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        this.m = -1;
    }

    public final int f() {
        return this.m;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final c a = new c((byte) 0);

        private a() {
        }
    }
}
