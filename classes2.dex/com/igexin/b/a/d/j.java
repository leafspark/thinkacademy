package com.igexin.b.a.d;

final class j extends Thread {
    volatile boolean a = true;
    g b;
    final /* synthetic */ f c;

    public j(f fVar) {
        this.c = fVar;
        setName("TS-processor");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r11.b != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r11.b = new com.igexin.b.a.d.g(r11.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        if (r5.o == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0082, code lost:
        r5.z = 0;
        r0.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ca, code lost:
        if (r5.o == false) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            r0 = -2
            android.os.Process.setThreadPriority(r0)
            com.igexin.b.a.d.f r0 = r11.c
            com.igexin.b.a.d.d<com.igexin.b.a.d.e> r0 = r0.k
            r1 = -1
            r2 = 0
            r3 = 1
        L_0x000b:
            r5 = r2
        L_0x000c:
            r4 = r3
        L_0x000d:
            boolean r6 = r11.a
            if (r6 == 0) goto L_0x0120
            r6 = 0
            if (r4 == r1) goto L_0x001c
            if (r4 == 0) goto L_0x0065
            if (r4 == r3) goto L_0x00cd
            r6 = 2
            if (r4 == r6) goto L_0x00e2
            goto L_0x000d
        L_0x001c:
            r5.d()     // Catch:{ Exception -> 0x0103 }
            boolean r4 = r5.q()     // Catch:{ Exception -> 0x0103 }
            if (r4 == 0) goto L_0x0038
            com.igexin.b.a.d.g r4 = r11.b     // Catch:{ Exception -> 0x0103 }
            if (r4 != 0) goto L_0x0032
            com.igexin.b.a.d.g r4 = new com.igexin.b.a.d.g     // Catch:{ Exception -> 0x0103 }
            com.igexin.b.a.d.f r7 = r11.c     // Catch:{ Exception -> 0x0103 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x0103 }
            r11.b = r4     // Catch:{ Exception -> 0x0103 }
        L_0x0032:
            com.igexin.b.a.d.g r4 = r11.b     // Catch:{ Exception -> 0x0103 }
            r4.a((com.igexin.b.a.d.e) r5)     // Catch:{ Exception -> 0x0103 }
            goto L_0x000b
        L_0x0038:
            boolean r4 = r5.n     // Catch:{ Exception -> 0x0103 }
            if (r4 == 0) goto L_0x0065
            long r7 = r5.t     // Catch:{ Exception -> 0x0103 }
            r9 = 0
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x0065
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103 }
            r4.<init>()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r7 = "TaskService|"
            r4.append(r7)     // Catch:{ Exception -> 0x0103 }
            r4.append(r5)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r7 = "|isBlock = false|cycyle = true|doTime = 0, "
            r4.append(r7)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r7 = "invalid ###########"
            r4.append(r7)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0103 }
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0103 }
            com.igexin.b.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r7)     // Catch:{ Exception -> 0x0103 }
            goto L_0x000c
        L_0x0065:
            r5.b()     // Catch:{ Exception -> 0x008c }
            r5.g()     // Catch:{ Exception -> 0x008c }
            r5.e_()     // Catch:{ Exception -> 0x008c }
            com.igexin.b.a.d.f r4 = r11.c
            r4.g()
            boolean r4 = r5.s
            if (r4 != 0) goto L_0x007a
            r5.c()
        L_0x007a:
            boolean r4 = r5.j
            if (r4 != 0) goto L_0x0087
            boolean r4 = r5.o
            if (r4 != 0) goto L_0x0087
        L_0x0082:
            r5.z = r6
            r0.a(r5)
        L_0x0087:
            r5 = r2
            r4 = r3
            goto L_0x00cd
        L_0x008a:
            r1 = move-exception
            goto L_0x00e9
        L_0x008c:
            r4 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r7.<init>()     // Catch:{ all -> 0x008a }
            java.lang.String r8 = "TaskService|SERVICE_PROCESSING|error|"
            r7.append(r8)     // Catch:{ all -> 0x008a }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x008a }
            r7.append(r8)     // Catch:{ all -> 0x008a }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008a }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x008a }
            com.igexin.b.a.c.b.a((java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ all -> 0x008a }
            r5.s = r3     // Catch:{ all -> 0x008a }
            r5.A = r4     // Catch:{ all -> 0x008a }
            r5.t()     // Catch:{ all -> 0x008a }
            r5.p()     // Catch:{ all -> 0x008a }
            com.igexin.b.a.d.f r4 = r11.c     // Catch:{ all -> 0x008a }
            com.igexin.b.a.d.c r4 = r4.j     // Catch:{ all -> 0x008a }
            r4.a(r5)     // Catch:{ all -> 0x008a }
            com.igexin.b.a.d.f r4 = r11.c
            r4.g()
            boolean r4 = r5.s
            if (r4 != 0) goto L_0x00c4
            r5.c()
        L_0x00c4:
            boolean r4 = r5.j
            if (r4 != 0) goto L_0x0087
            boolean r4 = r5.o
            if (r4 != 0) goto L_0x0087
            goto L_0x0082
        L_0x00cd:
            com.igexin.b.a.d.e r5 = r0.c()     // Catch:{ InterruptedException -> 0x00d1 }
        L_0x00d1:
            if (r5 == 0) goto L_0x00e2
            boolean r6 = r5.j
            if (r6 != 0) goto L_0x00df
            boolean r6 = r5.k
            if (r6 == 0) goto L_0x00dc
            goto L_0x00df
        L_0x00dc:
            r4 = r1
            goto L_0x000d
        L_0x00df:
            r5 = r2
            goto L_0x000d
        L_0x00e2:
            com.igexin.b.a.d.f r4 = r11.c
            r4.g()
            goto L_0x000c
        L_0x00e9:
            com.igexin.b.a.d.f r2 = r11.c
            r2.g()
            boolean r2 = r5.s
            if (r2 != 0) goto L_0x00f5
            r5.c()
        L_0x00f5:
            boolean r2 = r5.j
            if (r2 != 0) goto L_0x0102
            boolean r2 = r5.o
            if (r2 != 0) goto L_0x0102
            r5.z = r6
            r0.a(r5)
        L_0x0102:
            throw r1
        L_0x0103:
            r4 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TaskService|TASK_INIT|error|"
            r7.append(r8)
            java.lang.String r4 = r4.toString()
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.igexin.b.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r6)
            goto L_0x000c
        L_0x0120:
            r0.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.j.run():void");
    }
}
