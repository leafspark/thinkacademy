package com.tencent.mm.opensdk.diffdev.a;

public final class e {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r4v37 */
    /* JADX WARNING: type inference failed for: r4v40 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0078 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0107 A[SYNTHETIC, Splitter:B:101:0x0107] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x010c A[SYNTHETIC, Splitter:B:105:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0129 A[SYNTHETIC, Splitter:B:115:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x012e A[SYNTHETIC, Splitter:B:119:0x012e] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0133 A[SYNTHETIC, Splitter:B:123:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x013b A[SYNTHETIC, Splitter:B:130:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0140 A[SYNTHETIC, Splitter:B:134:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0145 A[SYNTHETIC, Splitter:B:138:0x0145] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00db A[SYNTHETIC, Splitter:B:79:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00e0 A[SYNTHETIC, Splitter:B:83:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00e5 A[SYNTHETIC, Splitter:B:87:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0102 A[SYNTHETIC, Splitter:B:97:0x0102] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:112:0x0114=Splitter:B:112:0x0114, B:76:0x00c6=Splitter:B:76:0x00c6, B:94:0x00ed=Splitter:B:94:0x00ed} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r9) {
        /*
            java.lang.String r0 = "httpGet ex:"
            java.lang.String r1 = "MicroMsg.SDK.NetUtil"
            r2 = 0
            if (r9 == 0) goto L_0x0149
            int r3 = r9.length()
            if (r3 != 0) goto L_0x000f
            goto L_0x0149
        L_0x000f:
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0110, IOException -> 0x00e9, Exception -> 0x00c2, all -> 0x00bd }
            r3.<init>(r9)     // Catch:{ MalformedURLException -> 0x0110, IOException -> 0x00e9, Exception -> 0x00c2, all -> 0x00bd }
            java.net.URLConnection r9 = r3.openConnection()     // Catch:{ MalformedURLException -> 0x0110, IOException -> 0x00e9, Exception -> 0x00c2, all -> 0x00bd }
            java.net.URLConnection r9 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r9)     // Catch:{ MalformedURLException -> 0x0110, IOException -> 0x00e9, Exception -> 0x00c2, all -> 0x00bd }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ MalformedURLException -> 0x0110, IOException -> 0x00e9, Exception -> 0x00c2, all -> 0x00bd }
            if (r9 != 0) goto L_0x002b
            java.lang.String r3 = "open connection failed."
            com.tencent.mm.opensdk.utils.Log.e(r1, r3)     // Catch:{ MalformedURLException -> 0x00ba, IOException -> 0x00b7, Exception -> 0x00b4, all -> 0x00af }
            if (r9 == 0) goto L_0x002a
            r9.disconnect()     // Catch:{ all -> 0x002a }
        L_0x002a:
            return r2
        L_0x002b:
            java.lang.String r3 = "GET"
            r9.setRequestMethod(r3)     // Catch:{ MalformedURLException -> 0x00ba, IOException -> 0x00b7, Exception -> 0x00b4, all -> 0x00af }
            r3 = 60000(0xea60, float:8.4078E-41)
            r9.setConnectTimeout(r3)     // Catch:{ MalformedURLException -> 0x00ba, IOException -> 0x00b7, Exception -> 0x00b4, all -> 0x00af }
            r9.setReadTimeout(r3)     // Catch:{ MalformedURLException -> 0x00ba, IOException -> 0x00b7, Exception -> 0x00b4, all -> 0x00af }
            int r3 = r9.getResponseCode()     // Catch:{ MalformedURLException -> 0x00ba, IOException -> 0x00b7, Exception -> 0x00b4, all -> 0x00af }
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 < r4) goto L_0x004c
            java.lang.String r3 = "httpURLConnectionGet 300"
            com.tencent.mm.opensdk.utils.Log.e(r1, r3)     // Catch:{ MalformedURLException -> 0x00ba, IOException -> 0x00b7, Exception -> 0x00b4, all -> 0x00af }
            if (r9 == 0) goto L_0x004b
            r9.disconnect()     // Catch:{ all -> 0x004b }
        L_0x004b:
            return r2
        L_0x004c:
            java.io.InputStream r3 = r9.getInputStream()     // Catch:{ MalformedURLException -> 0x00ba, IOException -> 0x00b7, Exception -> 0x00b4, all -> 0x00af }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00a8, IOException -> 0x00a2, Exception -> 0x009c, all -> 0x0097 }
            r4.<init>()     // Catch:{ MalformedURLException -> 0x00a8, IOException -> 0x00a2, Exception -> 0x009c, all -> 0x0097 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x0089, Exception -> 0x0082, all -> 0x007c }
        L_0x0059:
            int r6 = r3.read(r5)     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x0089, Exception -> 0x0082, all -> 0x007c }
            r7 = -1
            if (r6 == r7) goto L_0x0065
            r7 = 0
            r4.write(r5, r7, r6)     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x0089, Exception -> 0x0082, all -> 0x007c }
            goto L_0x0059
        L_0x0065:
            byte[] r5 = r4.toByteArray()     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x0089, Exception -> 0x0082, all -> 0x007c }
            java.lang.String r6 = "httpGet end"
            com.tencent.mm.opensdk.utils.Log.d(r1, r6)     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x0089, Exception -> 0x0082, all -> 0x007c }
            if (r9 == 0) goto L_0x0073
            r9.disconnect()     // Catch:{ all -> 0x0073 }
        L_0x0073:
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r4.close()     // Catch:{ all -> 0x007b }
        L_0x007b:
            return r5
        L_0x007c:
            r0 = move-exception
            r2 = r9
            r5 = r4
            r4 = r3
            goto L_0x0139
        L_0x0082:
            r5 = move-exception
            r8 = r4
            r4 = r3
            r3 = r5
            r5 = r8
            goto L_0x00c6
        L_0x0089:
            r5 = move-exception
            r8 = r4
            r4 = r3
            r3 = r5
            r5 = r8
            goto L_0x00ed
        L_0x0090:
            r5 = move-exception
            r8 = r4
            r4 = r3
            r3 = r5
            r5 = r8
            goto L_0x0114
        L_0x0097:
            r0 = move-exception
            r5 = r2
            r4 = r3
            goto L_0x0138
        L_0x009c:
            r4 = move-exception
            r5 = r2
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x00c6
        L_0x00a2:
            r4 = move-exception
            r5 = r2
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x00ed
        L_0x00a8:
            r4 = move-exception
            r5 = r2
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x0114
        L_0x00af:
            r0 = move-exception
            r4 = r2
            r5 = r4
            goto L_0x0138
        L_0x00b4:
            r3 = move-exception
            r4 = r2
            goto L_0x00c5
        L_0x00b7:
            r3 = move-exception
            r4 = r2
            goto L_0x00ec
        L_0x00ba:
            r3 = move-exception
            r4 = r2
            goto L_0x0113
        L_0x00bd:
            r0 = move-exception
            r4 = r2
            r5 = r4
            goto L_0x0139
        L_0x00c2:
            r3 = move-exception
            r9 = r2
            r4 = r9
        L_0x00c5:
            r5 = r4
        L_0x00c6:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r6.<init>(r0)     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = r3.getMessage()     // Catch:{ all -> 0x0137 }
            r6.append(r0)     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0137 }
            com.tencent.mm.opensdk.utils.Log.e(r1, r0)     // Catch:{ all -> 0x0137 }
            if (r9 == 0) goto L_0x00de
            r9.disconnect()     // Catch:{ all -> 0x00de }
        L_0x00de:
            if (r4 == 0) goto L_0x00e3
            r4.close()     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            if (r5 == 0) goto L_0x00e8
            r5.close()     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            return r2
        L_0x00e9:
            r3 = move-exception
            r9 = r2
            r4 = r9
        L_0x00ec:
            r5 = r4
        L_0x00ed:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r6.<init>(r0)     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = r3.getMessage()     // Catch:{ all -> 0x0137 }
            r6.append(r0)     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0137 }
            com.tencent.mm.opensdk.utils.Log.e(r1, r0)     // Catch:{ all -> 0x0137 }
            if (r9 == 0) goto L_0x0105
            r9.disconnect()     // Catch:{ all -> 0x0105 }
        L_0x0105:
            if (r4 == 0) goto L_0x010a
            r4.close()     // Catch:{ all -> 0x010a }
        L_0x010a:
            if (r5 == 0) goto L_0x010f
            r5.close()     // Catch:{ all -> 0x010f }
        L_0x010f:
            return r2
        L_0x0110:
            r3 = move-exception
            r9 = r2
            r4 = r9
        L_0x0113:
            r5 = r4
        L_0x0114:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r6.<init>(r0)     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = r3.getMessage()     // Catch:{ all -> 0x0137 }
            r6.append(r0)     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0137 }
            com.tencent.mm.opensdk.utils.Log.e(r1, r0)     // Catch:{ all -> 0x0137 }
            if (r9 == 0) goto L_0x012c
            r9.disconnect()     // Catch:{ all -> 0x012c }
        L_0x012c:
            if (r4 == 0) goto L_0x0131
            r4.close()     // Catch:{ all -> 0x0131 }
        L_0x0131:
            if (r5 == 0) goto L_0x0136
            r5.close()     // Catch:{ all -> 0x0136 }
        L_0x0136:
            return r2
        L_0x0137:
            r0 = move-exception
        L_0x0138:
            r2 = r9
        L_0x0139:
            if (r2 == 0) goto L_0x013e
            r2.disconnect()     // Catch:{ all -> 0x013e }
        L_0x013e:
            if (r4 == 0) goto L_0x0143
            r4.close()     // Catch:{ all -> 0x0143 }
        L_0x0143:
            if (r5 == 0) goto L_0x0148
            r5.close()     // Catch:{ all -> 0x0148 }
        L_0x0148:
            throw r0
        L_0x0149:
            java.lang.String r9 = "httpGet, url is null"
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.e.a(java.lang.String):byte[]");
    }
}
