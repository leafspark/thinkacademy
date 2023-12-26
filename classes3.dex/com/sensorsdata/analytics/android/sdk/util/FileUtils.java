package com.sensorsdata.analytics.android.sdk.util;

public class FileUtils {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x001f A[SYNTHETIC, Splitter:B:16:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC, Splitter:B:21:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToFile(java.io.File r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0019 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0019 }
            byte[] r2 = r3.getBytes()     // Catch:{ Exception -> 0x0014, all -> 0x0011 }
            r1.write(r2)     // Catch:{ Exception -> 0x0014, all -> 0x0011 }
            r1.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0011:
            r2 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0014:
            r2 = move-exception
            r0 = r1
            goto L_0x001a
        L_0x0017:
            r2 = move-exception
            goto L_0x0028
        L_0x0019:
            r2 = move-exception
        L_0x001a:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0027
            r0.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)
        L_0x0027:
            return
        L_0x0028:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r3 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)
        L_0x0032:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.FileUtils.writeToFile(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0049 A[SYNTHETIC, Splitter:B:36:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x005d A[SYNTHETIC, Splitter:B:49:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFileToString(java.io.File r7) {
        /*
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0066 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0066 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0066 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0066 }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
            r7.<init>()     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch:{ IOException -> 0x0035 }
        L_0x0014:
            r4 = 0
            int r5 = r1.read(r3, r4, r2)     // Catch:{ IOException -> 0x0035 }
            r6 = -1
            if (r5 == r6) goto L_0x0020
            r7.write(r3, r4, r5)     // Catch:{ IOException -> 0x0035 }
            goto L_0x0014
        L_0x0020:
            java.lang.String r2 = r7.toString()     // Catch:{ IOException -> 0x0035 }
            r1.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x0066 }
        L_0x002c:
            r7.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)     // Catch:{ Exception -> 0x0066 }
        L_0x0034:
            return r2
        L_0x0035:
            r2 = move-exception
            goto L_0x003c
        L_0x0037:
            r2 = move-exception
            r7 = r0
            goto L_0x0053
        L_0x003a:
            r2 = move-exception
            r7 = r0
        L_0x003c:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)     // Catch:{ all -> 0x0052 }
            r1.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x0066 }
        L_0x0047:
            if (r7 == 0) goto L_0x0051
            r7.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)     // Catch:{ Exception -> 0x0066 }
        L_0x0051:
            return r0
        L_0x0052:
            r2 = move-exception
        L_0x0053:
            r1.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x0066 }
        L_0x005b:
            if (r7 == 0) goto L_0x0065
            r7.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)     // Catch:{ Exception -> 0x0066 }
        L_0x0065:
            throw r2     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.FileUtils.readFileToString(java.io.File):java.lang.String");
    }
}
