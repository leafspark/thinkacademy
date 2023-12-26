package org.libpag;

abstract class b {
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a7 A[SYNTHETIC, Splitter:B:49:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c1 A[SYNTHETIC, Splitter:B:63:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] a(java.lang.String r8) {
        /*
            java.lang.String r0 = "NetworkFetcher"
            byte[] r1 = org.libpag.PAGDiskCache.ReadFile(r8)
            if (r1 == 0) goto L_0x000c
            int r2 = r1.length
            if (r2 <= 0) goto L_0x000c
            return r1
        L_0x000c:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x0087, all -> 0x0084 }
            r3.<init>(r8)     // Catch:{ IOException -> 0x0087, all -> 0x0084 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x0087, all -> 0x0084 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0087, all -> 0x0084 }
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r3.connect()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            int r4 = r3.getResponseCode()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            int r5 = r4 / 100
            r6 = 2
            if (r5 == r6) goto L_0x004e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r8.<init>()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            java.lang.String r5 = "Error: HTTP response code "
            r8.append(r5)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r8.append(r4)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            android.util.Log.e(r0, r8)     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r1.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r8 = move-exception
            r8.printStackTrace()
        L_0x004a:
            r3.disconnect()
            return r2
        L_0x004e:
            java.io.InputStream r4 = r3.getInputStream()     // Catch:{ IOException -> 0x0081, all -> 0x007f }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x007d }
        L_0x0056:
            int r6 = r4.read(r5)     // Catch:{ IOException -> 0x007d }
            r7 = -1
            if (r6 == r7) goto L_0x0062
            r7 = 0
            r1.write(r5, r7, r6)     // Catch:{ IOException -> 0x007d }
            goto L_0x0056
        L_0x0062:
            byte[] r5 = r1.toByteArray()     // Catch:{ IOException -> 0x007d }
            org.libpag.PAGDiskCache.WriteFile(r8, r5)     // Catch:{ IOException -> 0x007d }
            r4.close()     // Catch:{ Exception -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0071:
            r1.close()     // Catch:{ Exception -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0079:
            r3.disconnect()
            return r5
        L_0x007d:
            r8 = move-exception
            goto L_0x008a
        L_0x007f:
            r8 = move-exception
            goto L_0x00bf
        L_0x0081:
            r8 = move-exception
            r4 = r2
            goto L_0x008a
        L_0x0084:
            r8 = move-exception
            r3 = r2
            goto L_0x00bf
        L_0x0087:
            r8 = move-exception
            r3 = r2
            r4 = r3
        L_0x008a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r5.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = "Error: "
            r5.append(r6)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = r8.getMessage()     // Catch:{ all -> 0x00bd }
            r5.append(r6)     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00bd }
            android.util.Log.e(r0, r5)     // Catch:{ all -> 0x00bd }
            r8.printStackTrace()     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x00af
            r4.close()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00af:
            r1.close()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00b7:
            if (r3 == 0) goto L_0x00bc
            r3.disconnect()
        L_0x00bc:
            return r2
        L_0x00bd:
            r8 = move-exception
            r2 = r4
        L_0x00bf:
            if (r2 == 0) goto L_0x00c9
            r2.close()     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00c9:
            r1.close()     // Catch:{ Exception -> 0x00cd }
            goto L_0x00d1
        L_0x00cd:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d1:
            if (r3 == 0) goto L_0x00d6
            r3.disconnect()
        L_0x00d6:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.b.a(java.lang.String):byte[]");
    }
}
