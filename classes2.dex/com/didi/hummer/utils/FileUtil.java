package com.didi.hummer.utils;

import java.io.File;

public class FileUtil {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[SYNTHETIC, Splitter:B:19:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047 A[SYNTHETIC, Splitter:B:26:0x0047] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFile(java.lang.String r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0032 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0032 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r4 = "utf-8"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0032 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            r4.<init>(r2)     // Catch:{ Exception -> 0x002d, all -> 0x002a }
        L_0x0017:
            java.lang.String r1 = r4.readLine()     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            if (r1 == 0) goto L_0x0026
            r0.append(r1)     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            java.lang.String r1 = "\n"
            r0.append(r1)     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            goto L_0x0017
        L_0x0026:
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x002a:
            r4 = move-exception
            r1 = r2
            goto L_0x0045
        L_0x002d:
            r4 = move-exception
            r1 = r2
            goto L_0x0033
        L_0x0030:
            r4 = move-exception
            goto L_0x0045
        L_0x0032:
            r4 = move-exception
        L_0x0033:
            r4.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0040:
            java.lang.String r4 = r0.toString()
            return r4
        L_0x0045:
            if (r1 == 0) goto L_0x004f
            r1.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.utils.FileUtil.readFile(java.lang.String):java.lang.String");
    }

    public static String readFile(File file) {
        return readFile(file.getAbsolutePath());
    }
}
