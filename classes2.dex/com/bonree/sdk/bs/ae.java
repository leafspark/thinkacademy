package com.bonree.sdk.bs;

import com.bonree.sdk.bs.c;

final class ae implements c.a {
    ae() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4 A[SYNTHETIC, Splitter:B:35:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2 A[SYNTHETIC, Splitter:B:42:0x00d2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a() {
        /*
            r8 = this;
            java.lang.String r0 = "logcat"
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00c0 }
            r3.<init>()     // Catch:{ all -> 0x00c0 }
            r3.add(r0)     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = "-d"
            r3.add(r4)     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = "-v"
            r3.add(r4)     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = "time"
            r3.add(r4)     // Catch:{ all -> 0x00c0 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00c0 }
            r4.<init>()     // Catch:{ all -> 0x00c0 }
            r4.add(r0)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = "-c"
            r4.add(r0)     // Catch:{ all -> 0x00c0 }
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x00c0 }
            int r5 = r3.size()     // Catch:{ all -> 0x00c0 }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x00c0 }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ all -> 0x00c0 }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ all -> 0x00c0 }
            java.lang.Process r0 = r0.exec(r3)     // Catch:{ all -> 0x00c0 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x00be }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x00be }
            java.io.InputStream r6 = r0.getInputStream()     // Catch:{ all -> 0x00be }
            r5.<init>(r6)     // Catch:{ all -> 0x00be }
            r3.<init>(r5)     // Catch:{ all -> 0x00be }
            java.io.InputStream r5 = r0.getErrorStream()     // Catch:{ all -> 0x00ba }
            if (r5 == 0) goto L_0x005b
            java.io.InputStream r5 = r0.getErrorStream()     // Catch:{ all -> 0x00ba }
            new java.lang.Thread(new com.bonree.sdk.bs.af(r5)).start()     // Catch:{ all -> 0x00ba }
        L_0x005b:
            java.lang.String r5 = r3.readLine()     // Catch:{ all -> 0x00ba }
            if (r5 == 0) goto L_0x0076
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r6.<init>()     // Catch:{ all -> 0x00ba }
            r6.append(r5)     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = "\n"
            r6.append(r5)     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x00ba }
            r1.append(r5)     // Catch:{ all -> 0x00ba }
            goto L_0x005b
        L_0x0076:
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x00ba }
            int r6 = r4.size()     // Catch:{ all -> 0x00ba }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x00ba }
            java.lang.Object[] r4 = r4.toArray(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ all -> 0x00ba }
            java.lang.Process r2 = r5.exec(r4)     // Catch:{ all -> 0x00ba }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x00a4
            java.io.InputStream r4 = r2.getErrorStream()     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x00a4
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ all -> 0x00ba }
            new java.lang.Thread(new com.bonree.sdk.bs.af(r4)).start()     // Catch:{ all -> 0x00ba }
            java.io.InputStream r4 = r2.getErrorStream()     // Catch:{ all -> 0x00ba }
            new java.lang.Thread(new com.bonree.sdk.bs.af(r4)).start()     // Catch:{ all -> 0x00ba }
        L_0x00a4:
            r3.close()     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x00b0
            r0.exitValue()     // Catch:{ all -> 0x00ad }
            goto L_0x00b0
        L_0x00ad:
            r0.destroy()
        L_0x00b0:
            if (r2 == 0) goto L_0x00d9
            r2.destroy()     // Catch:{ all -> 0x00b6 }
            goto L_0x00d9
        L_0x00b6:
            r2.destroy()
            goto L_0x00d9
        L_0x00ba:
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x00c2
        L_0x00be:
            r3 = r2
            goto L_0x00c2
        L_0x00c0:
            r0 = r2
            r3 = r0
        L_0x00c2:
            if (r2 == 0) goto L_0x00c7
            r2.close()     // Catch:{ all -> 0x00cd }
        L_0x00c7:
            if (r0 == 0) goto L_0x00d0
            r0.exitValue()     // Catch:{ all -> 0x00cd }
            goto L_0x00d0
        L_0x00cd:
            r0.destroy()
        L_0x00d0:
            if (r3 == 0) goto L_0x00d9
            r3.destroy()     // Catch:{ all -> 0x00d6 }
            goto L_0x00d9
        L_0x00d6:
            r3.destroy()
        L_0x00d9:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ae.a():java.lang.Object");
    }
}
