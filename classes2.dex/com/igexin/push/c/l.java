package com.igexin.push.c;

import java.util.concurrent.Callable;

class l implements Callable<j> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fa, code lost:
        if (r5.isClosed() == false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0169, code lost:
        if (r5.isClosed() == false) goto L_0x00fc;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.c.j call() {
        /*
            r12 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r0 = r0.isInterrupted()
            if (r0 != 0) goto L_0x017d
            r0 = 0
            r1 = 0
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            boolean r2 = r2.isInterrupted()     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            if (r2 == 0) goto L_0x0017
            return r1
        L_0x0017:
            java.lang.Class<com.igexin.push.c.r> r2 = com.igexin.push.c.r.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            com.igexin.push.c.k r3 = r12.a     // Catch:{ all -> 0x0106 }
            com.igexin.push.c.r r3 = r3.e     // Catch:{ all -> 0x0106 }
            if (r3 == 0) goto L_0x0031
            com.igexin.push.c.k r3 = r12.a     // Catch:{ all -> 0x0106 }
            com.igexin.push.c.r r3 = r3.e     // Catch:{ all -> 0x0106 }
            com.igexin.push.c.k r4 = r12.a     // Catch:{ all -> 0x0106 }
            com.igexin.push.c.j r4 = r4.d     // Catch:{ all -> 0x0106 }
            r3.a(r4)     // Catch:{ all -> 0x0106 }
        L_0x0031:
            monitor-exit(r2)     // Catch:{ all -> 0x0106 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            com.igexin.push.c.k r4 = r12.a     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            com.igexin.push.c.j r4 = r4.d     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            java.lang.String r4 = r4.a()     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            java.lang.String[] r4 = com.igexin.b.a.b.e.a((java.lang.String) r4)     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            java.net.Socket r5 = new java.net.Socket     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            r5.<init>()     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
            java.net.InetSocketAddress r1 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x0104 }
            r6 = 1
            r4 = r4[r6]     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.k r6 = r12.a     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.j r6 = r6.d     // Catch:{ Exception -> 0x0104 }
            int r6 = r6.d()     // Catch:{ Exception -> 0x0104 }
            r1.<init>(r4, r6)     // Catch:{ Exception -> 0x0104 }
            r4 = 2500(0x9c4, float:3.503E-42)
            r5.connect(r1, r4)     // Catch:{ Exception -> 0x0104 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.k r1 = r12.a     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.j r6 = r1.d     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r1.<init>()     // Catch:{ Exception -> 0x0104 }
            java.lang.String r4 = "socket://"
            r1.append(r4)     // Catch:{ Exception -> 0x0104 }
            java.net.InetAddress r4 = r5.getInetAddress()     // Catch:{ Exception -> 0x0104 }
            java.lang.String r4 = r4.getHostAddress()     // Catch:{ Exception -> 0x0104 }
            r1.append(r4)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r4 = ":"
            r1.append(r4)     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.k r4 = r12.a     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.j r4 = r4.d     // Catch:{ Exception -> 0x0104 }
            int r4 = r4.d()     // Catch:{ Exception -> 0x0104 }
            r1.append(r4)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r7 = r1.toString()     // Catch:{ Exception -> 0x0104 }
            long r8 = r10 - r2
            r6.a(r7, r8, r10)     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r1.<init>()     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = com.igexin.push.c.k.a     // Catch:{ Exception -> 0x0104 }
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = "|detect "
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.k r2 = r12.a     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x0104 }
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = "|time = "
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.k r2 = r12.a     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.j r2 = r2.d     // Catch:{ Exception -> 0x0104 }
            long r2 = r2.e()     // Catch:{ Exception -> 0x0104 }
            r1.append(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0104 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0104 }
            com.igexin.b.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.Class<com.igexin.push.c.r> r1 = com.igexin.push.c.r.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0104 }
            com.igexin.push.c.k r2 = r12.a     // Catch:{ all -> 0x0101 }
            com.igexin.push.c.r r2 = r2.e     // Catch:{ all -> 0x0101 }
            if (r2 == 0) goto L_0x00f5
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0101 }
            boolean r2 = r2.isInterrupted()     // Catch:{ all -> 0x0101 }
            if (r2 != 0) goto L_0x00f5
            com.igexin.push.c.k r2 = r12.a     // Catch:{ all -> 0x0101 }
            com.igexin.push.c.r r2 = r2.e     // Catch:{ all -> 0x0101 }
            com.igexin.push.c.g r3 = com.igexin.push.c.g.SUCCESS     // Catch:{ all -> 0x0101 }
            com.igexin.push.c.k r4 = r12.a     // Catch:{ all -> 0x0101 }
            com.igexin.push.c.j r4 = r4.d     // Catch:{ all -> 0x0101 }
            r2.a(r3, r4)     // Catch:{ all -> 0x0101 }
        L_0x00f5:
            monitor-exit(r1)     // Catch:{ all -> 0x0101 }
            boolean r0 = r5.isClosed()
            if (r0 != 0) goto L_0x017d
        L_0x00fc:
            r5.close()     // Catch:{ Exception -> 0x017d }
            goto L_0x017d
        L_0x0101:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0101 }
            throw r2     // Catch:{ Exception -> 0x0104 }
        L_0x0104:
            r1 = move-exception
            goto L_0x010e
        L_0x0106:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0106 }
            throw r3     // Catch:{ Exception -> 0x010b, all -> 0x0109 }
        L_0x0109:
            r0 = move-exception
            goto L_0x0171
        L_0x010b:
            r2 = move-exception
            r5 = r1
            r1 = r2
        L_0x010e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x016f }
            r2.<init>()     // Catch:{ all -> 0x016f }
            java.lang.String r3 = com.igexin.push.c.k.a     // Catch:{ all -> 0x016f }
            r2.append(r3)     // Catch:{ all -> 0x016f }
            java.lang.String r3 = "|detect "
            r2.append(r3)     // Catch:{ all -> 0x016f }
            com.igexin.push.c.k r3 = r12.a     // Catch:{ all -> 0x016f }
            java.lang.String r3 = r3.h()     // Catch:{ all -> 0x016f }
            r2.append(r3)     // Catch:{ all -> 0x016f }
            java.lang.String r3 = "thread -->"
            r2.append(r3)     // Catch:{ all -> 0x016f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x016f }
            r2.append(r1)     // Catch:{ all -> 0x016f }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x016f }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x016f }
            com.igexin.b.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r0)     // Catch:{ all -> 0x016f }
            java.lang.Class<com.igexin.push.c.r> r0 = com.igexin.push.c.r.class
            monitor-enter(r0)     // Catch:{ all -> 0x016f }
            com.igexin.push.c.k r1 = r12.a     // Catch:{ all -> 0x016c }
            com.igexin.push.c.r r1 = r1.e     // Catch:{ all -> 0x016c }
            if (r1 == 0) goto L_0x0162
            com.igexin.push.c.k r1 = r12.a     // Catch:{ all -> 0x016c }
            com.igexin.push.c.j r1 = r1.d     // Catch:{ all -> 0x016c }
            r1.b()     // Catch:{ all -> 0x016c }
            com.igexin.push.c.k r1 = r12.a     // Catch:{ all -> 0x016c }
            com.igexin.push.c.r r1 = r1.e     // Catch:{ all -> 0x016c }
            com.igexin.push.c.g r2 = com.igexin.push.c.g.EXCEPTION     // Catch:{ all -> 0x016c }
            com.igexin.push.c.k r3 = r12.a     // Catch:{ all -> 0x016c }
            com.igexin.push.c.j r3 = r3.d     // Catch:{ all -> 0x016c }
            r1.a(r2, r3)     // Catch:{ all -> 0x016c }
        L_0x0162:
            monitor-exit(r0)     // Catch:{ all -> 0x016c }
            if (r5 == 0) goto L_0x017d
            boolean r0 = r5.isClosed()
            if (r0 != 0) goto L_0x017d
            goto L_0x00fc
        L_0x016c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x016c }
            throw r1     // Catch:{ all -> 0x016f }
        L_0x016f:
            r0 = move-exception
            r1 = r5
        L_0x0171:
            if (r1 == 0) goto L_0x017c
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto L_0x017c
            r1.close()     // Catch:{ Exception -> 0x017c }
        L_0x017c:
            throw r0
        L_0x017d:
            com.igexin.push.c.k r0 = r12.a
            com.igexin.push.c.j r0 = r0.d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.l.call():com.igexin.push.c.j");
    }
}
