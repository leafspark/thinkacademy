package com.bonree.sdk.au;

final class b implements Runnable {
    private /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bf, code lost:
        if (r8 != null) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00af A[Catch:{ all -> 0x00d4, all -> 0x00da }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            com.bonree.sdk.au.a r0 = r13.a
            boolean r0 = r0.a
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.bonree.sdk.d.a r0 = com.bonree.sdk.d.a.k()
            boolean r0 = r0.J()
            r1 = 15000(0x3a98, double:7.411E-320)
            if (r0 == 0) goto L_0x0027
            com.bonree.sdk.au.a r0 = r13.a
            boolean r0 = r0.a
            if (r0 == 0) goto L_0x0026
            com.bonree.sdk.au.a r0 = r13.a
            java.lang.Runnable r3 = r0.o
            r0.a((java.lang.Runnable) r3, 15000)
        L_0x0026:
            return
        L_0x0027:
            r0 = 0
            r3 = 3000(0xbb8, double:1.482E-320)
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a4 }
            com.bonree.sdk.au.a r7 = r13.a     // Catch:{ all -> 0x00a4 }
            com.bonree.sdk.be.f r7 = r7.c     // Catch:{ all -> 0x00a4 }
            java.lang.String r8 = "ping -> host: %s, port: %d ,interval: %d"
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x00a4 }
            com.bonree.sdk.au.a r10 = r13.a     // Catch:{ all -> 0x00a4 }
            java.lang.String r10 = r10.k     // Catch:{ all -> 0x00a4 }
            r11 = 0
            r9[r11] = r10     // Catch:{ all -> 0x00a4 }
            r10 = 1
            com.bonree.sdk.au.a r12 = r13.a     // Catch:{ all -> 0x00a4 }
            int r12 = r12.l     // Catch:{ all -> 0x00a4 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x00a4 }
            r9[r10] = r12     // Catch:{ all -> 0x00a4 }
            r10 = 2
            r12 = 15000(0x3a98, float:2.102E-41)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x00a4 }
            r9[r10] = r12     // Catch:{ all -> 0x00a4 }
            r7.c(r8, r9)     // Catch:{ all -> 0x00a4 }
            java.net.InetSocketAddress r7 = new java.net.InetSocketAddress     // Catch:{ all -> 0x00a4 }
            com.bonree.sdk.au.a r8 = r13.a     // Catch:{ all -> 0x00a4 }
            java.lang.String r8 = r8.k     // Catch:{ all -> 0x00a4 }
            com.bonree.sdk.au.a r9 = r13.a     // Catch:{ all -> 0x00a4 }
            int r9 = r9.l     // Catch:{ all -> 0x00a4 }
            r7.<init>(r8, r9)     // Catch:{ all -> 0x00a4 }
            java.net.Socket r8 = new java.net.Socket     // Catch:{ all -> 0x00a4 }
            r8.<init>()     // Catch:{ all -> 0x00a4 }
            r0 = 3000(0xbb8, float:4.204E-42)
            r8.connect(r7, r0)     // Catch:{ all -> 0x00a2 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a2 }
            long r9 = r9 - r5
            com.bonree.sdk.au.a r0 = r13.a     // Catch:{ all -> 0x00a2 }
            com.bonree.sdk.be.f r0 = r0.c     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = "ping result -> "
            r5.<init>(r6)     // Catch:{ all -> 0x00a2 }
            r5.append(r9)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00a2 }
            java.lang.Object[] r6 = new java.lang.Object[r11]     // Catch:{ all -> 0x00a2 }
            r0.c(r5, r6)     // Catch:{ all -> 0x00a2 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0099
            r9 = r3
        L_0x0099:
            com.bonree.sdk.au.a r0 = r13.a     // Catch:{ all -> 0x00a2 }
            r0.a((long) r9)     // Catch:{ all -> 0x00a2 }
        L_0x009e:
            r8.close()     // Catch:{ all -> 0x00c2 }
            goto L_0x00c2
        L_0x00a2:
            r0 = move-exception
            goto L_0x00a7
        L_0x00a4:
            r5 = move-exception
            r8 = r0
            r0 = r5
        L_0x00a7:
            com.bonree.sdk.au.a r5 = r13.a     // Catch:{ all -> 0x00d4 }
            com.bonree.sdk.be.f r5 = r5.c     // Catch:{ all -> 0x00d4 }
            if (r5 == 0) goto L_0x00ba
            com.bonree.sdk.au.a r5 = r13.a     // Catch:{ all -> 0x00d4 }
            com.bonree.sdk.be.f r5 = r5.c     // Catch:{ all -> 0x00d4 }
            java.lang.String r6 = "tcp ping failed : "
            r5.a((java.lang.String) r6, (java.lang.Throwable) r0)     // Catch:{ all -> 0x00d4 }
        L_0x00ba:
            com.bonree.sdk.au.a r0 = r13.a     // Catch:{ all -> 0x00d4 }
            r0.a((long) r3)     // Catch:{ all -> 0x00d4 }
            if (r8 == 0) goto L_0x00c2
            goto L_0x009e
        L_0x00c2:
            com.bonree.sdk.au.a r0 = r13.a
            boolean r0 = r0.a
            if (r0 == 0) goto L_0x00d3
            com.bonree.sdk.au.a r0 = r13.a
            java.lang.Runnable r3 = r0.o
            r0.a((java.lang.Runnable) r3, 15000)
        L_0x00d3:
            return
        L_0x00d4:
            r0 = move-exception
            if (r8 == 0) goto L_0x00da
            r8.close()     // Catch:{ all -> 0x00da }
        L_0x00da:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.au.b.run():void");
    }
}
