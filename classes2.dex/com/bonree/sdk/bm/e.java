package com.bonree.sdk.bm;

import com.bonree.sdk.az.a;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class e extends a {
    public static final d b = new e();
    private static int c = 2000;
    private static final Logger d = Logger.getLogger(e.class.getName());
    private static final String e = "/etc/resolv.conf";
    private static final Pattern f = Pattern.compile("^nameserver\\s+(.*)$");
    private static List<String> g;
    private static long h;

    private e() {
        super("e", 2000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085 A[SYNTHETIC, Splitter:B:34:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096 A[SYNTHETIC, Splitter:B:42:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> c() {
        /*
            r9 = this;
            java.lang.String r0 = "Could not close reader"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/etc/resolv.conf"
            r1.<init>(r2)
            boolean r2 = r1.exists()
            r3 = 0
            if (r2 != 0) goto L_0x0011
            return r3
        L_0x0011:
            long r4 = r1.lastModified()
            long r6 = h
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0020
            java.util.List<java.lang.String> r2 = g
            if (r2 == 0) goto L_0x0020
            return r2
        L_0x0020:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            r8.<init>(r1)     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            r7.<init>(r8, r1)     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
        L_0x0036:
            java.lang.String r1 = r6.readLine()     // Catch:{ IOException -> 0x0074 }
            if (r1 == 0) goto L_0x0055
            java.util.regex.Pattern r7 = f     // Catch:{ IOException -> 0x0074 }
            java.util.regex.Matcher r1 = r7.matcher(r1)     // Catch:{ IOException -> 0x0074 }
            boolean r7 = r1.matches()     // Catch:{ IOException -> 0x0074 }
            if (r7 == 0) goto L_0x0036
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch:{ IOException -> 0x0074 }
            java.lang.String r1 = r1.trim()     // Catch:{ IOException -> 0x0074 }
            r2.add(r1)     // Catch:{ IOException -> 0x0074 }
            goto L_0x0036
        L_0x0055:
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x0061
        L_0x0059:
            r1 = move-exception
            java.util.logging.Logger r6 = d
            java.util.logging.Level r7 = java.util.logging.Level.WARNING
            r6.log(r7, r0, r1)
        L_0x0061:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x006f
            java.util.logging.Logger r0 = d
            java.lang.String r1 = "Could not find any nameservers in /etc/resolv.conf"
            r0.fine(r1)
            return r3
        L_0x006f:
            g = r2
            h = r4
            return r2
        L_0x0074:
            r1 = move-exception
            goto L_0x007a
        L_0x0076:
            r1 = move-exception
            goto L_0x0094
        L_0x0078:
            r1 = move-exception
            r6 = r3
        L_0x007a:
            java.util.logging.Logger r2 = d     // Catch:{ all -> 0x0092 }
            java.util.logging.Level r4 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0092 }
            java.lang.String r5 = "Could not read from /etc/resolv.conf"
            r2.log(r4, r5, r1)     // Catch:{ all -> 0x0092 }
            if (r6 == 0) goto L_0x0091
            r6.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x0091
        L_0x0089:
            r1 = move-exception
            java.util.logging.Logger r2 = d
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            r2.log(r4, r0, r1)
        L_0x0091:
            return r3
        L_0x0092:
            r1 = move-exception
            r3 = r6
        L_0x0094:
            if (r3 == 0) goto L_0x00a2
            r3.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00a2
        L_0x009a:
            r2 = move-exception
            java.util.logging.Logger r3 = d
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            r3.log(r4, r0, r2)
        L_0x00a2:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bm.e.c():java.util.List");
    }

    public final boolean d() {
        if (a.e()) {
            return false;
        }
        try {
            return new File(e).exists();
        } catch (SecurityException e2) {
            d.log(Level.FINE, "Access to /etc/resolv.conf not possible", e2);
            return false;
        }
    }
}
