package com.bonree.sdk.bf;

import java.util.logging.Logger;

public class q {
    static final String a;
    private static final Logger b;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[SYNTHETIC, Splitter:B:18:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A[SYNTHETIC, Splitter:B:23:0x0054] */
    static {
        /*
            java.lang.Class<com.bonree.sdk.bf.q> r0 = com.bonree.sdk.bf.q.class
            java.lang.String r1 = "IOException closing stream"
            java.lang.String r2 = r0.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            b = r2
            r2 = 0
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = "org.minidns/version"
            java.io.InputStream r0 = r0.getResourceAsStream(r3)     // Catch:{ Exception -> 0x003e }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003e }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003e }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x003e }
            r4.<init>(r0, r5)     // Catch:{ Exception -> 0x003e }
            r3.<init>(r4)     // Catch:{ Exception -> 0x003e }
            java.lang.String r0 = r3.readLine()     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            r3.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r2 = move-exception
            java.util.logging.Logger r3 = b
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            r3.log(r4, r1, r2)
            goto L_0x004f
        L_0x0036:
            r0 = move-exception
            r2 = r3
            goto L_0x0052
        L_0x0039:
            r0 = move-exception
            r2 = r3
            goto L_0x003f
        L_0x003c:
            r0 = move-exception
            goto L_0x0052
        L_0x003e:
            r0 = move-exception
        L_0x003f:
            java.util.logging.Logger r3 = b     // Catch:{ all -> 0x003c }
            java.util.logging.Level r4 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x003c }
            java.lang.String r5 = "Could not determine MiniDNS version"
            r3.log(r4, r5, r0)     // Catch:{ all -> 0x003c }
            java.lang.String r0 = "unkown"
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ IOException -> 0x002d }
        L_0x004f:
            a = r0
            return
        L_0x0052:
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x0060
        L_0x0058:
            r2 = move-exception
            java.util.logging.Logger r3 = b
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            r3.log(r4, r1, r2)
        L_0x0060:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bf.q.<clinit>():void");
    }
}
