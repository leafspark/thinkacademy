package com.tal.user.global.trade.image;

public class TalTradeImageRequest {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A[SYNTHETIC, Splitter:B:29:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f A[Catch:{ IOException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00aa A[SYNTHETIC, Splitter:B:41:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b2 A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5 A[SYNTHETIC, Splitter:B:51:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cd A[Catch:{ IOException -> 0x00c9 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x0090=Splitter:B:38:0x0090, B:26:0x005f=Splitter:B:26:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap downloadBitmapFromUrl(java.lang.String r9) {
        /*
            java.lang.String r0 = "downImage"
            java.lang.String r1 = "TalGlobalTrade"
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x008d, IOException -> 0x005c, all -> 0x0056 }
            r3.<init>(r9)     // Catch:{ MalformedURLException -> 0x008d, IOException -> 0x005c, all -> 0x0056 }
            java.net.URLConnection r9 = r3.openConnection()     // Catch:{ MalformedURLException -> 0x008d, IOException -> 0x005c, all -> 0x0056 }
            java.net.URLConnection r9 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r9)     // Catch:{ MalformedURLException -> 0x008d, IOException -> 0x005c, all -> 0x0056 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ MalformedURLException -> 0x008d, IOException -> 0x005c, all -> 0x0056 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ MalformedURLException -> 0x0053, IOException -> 0x0050, all -> 0x004a }
            java.io.InputStream r4 = r9.getInputStream()     // Catch:{ MalformedURLException -> 0x0053, IOException -> 0x0050, all -> 0x004a }
            r5 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r4, r5)     // Catch:{ MalformedURLException -> 0x0053, IOException -> 0x0050, all -> 0x004a }
            android.graphics.Bitmap r2 = com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation.decodeStream(r3)     // Catch:{ MalformedURLException -> 0x0048, IOException -> 0x0046 }
            r3.close()     // Catch:{ IOException -> 0x002d }
            if (r9 == 0) goto L_0x00c1
            r9.disconnect()     // Catch:{ IOException -> 0x002d }
            goto L_0x00c1
        L_0x002d:
            r9 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0037:
            r3.append(r0)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            r1.i(r9)
            goto L_0x00c1
        L_0x0046:
            r4 = move-exception
            goto L_0x005f
        L_0x0048:
            r4 = move-exception
            goto L_0x0090
        L_0x004a:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L_0x00c3
        L_0x0050:
            r4 = move-exception
            r3 = r2
            goto L_0x005f
        L_0x0053:
            r4 = move-exception
            r3 = r2
            goto L_0x0090
        L_0x0056:
            r9 = move-exception
            r3 = r2
            r2 = r9
            r9 = r3
            goto L_0x00c3
        L_0x005c:
            r4 = move-exception
            r9 = r2
            r3 = r9
        L_0x005f:
            com.tal.user.global.trade.util.TalTradeLogger r5 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)     // Catch:{ all -> 0x00c2 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            r6.<init>()     // Catch:{ all -> 0x00c2 }
            r6.append(r0)     // Catch:{ all -> 0x00c2 }
            r6.append(r4)     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00c2 }
            r5.i(r4)     // Catch:{ all -> 0x00c2 }
            if (r3 == 0) goto L_0x007d
            r3.close()     // Catch:{ IOException -> 0x007b }
            goto L_0x007d
        L_0x007b:
            r9 = move-exception
            goto L_0x0083
        L_0x007d:
            if (r9 == 0) goto L_0x00c1
            r9.disconnect()     // Catch:{ IOException -> 0x007b }
            goto L_0x00c1
        L_0x0083:
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0037
        L_0x008d:
            r4 = move-exception
            r9 = r2
            r3 = r9
        L_0x0090:
            com.tal.user.global.trade.util.TalTradeLogger r5 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)     // Catch:{ all -> 0x00c2 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            r6.<init>()     // Catch:{ all -> 0x00c2 }
            java.lang.String r7 = "downImage:"
            r6.append(r7)     // Catch:{ all -> 0x00c2 }
            r6.append(r4)     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00c2 }
            r5.i(r4)     // Catch:{ all -> 0x00c2 }
            if (r3 == 0) goto L_0x00b0
            r3.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00b0
        L_0x00ae:
            r9 = move-exception
            goto L_0x00b6
        L_0x00b0:
            if (r9 == 0) goto L_0x00c1
            r9.disconnect()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00c1
        L_0x00b6:
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0037
        L_0x00c1:
            return r2
        L_0x00c2:
            r2 = move-exception
        L_0x00c3:
            if (r3 == 0) goto L_0x00cb
            r3.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00cb
        L_0x00c9:
            r9 = move-exception
            goto L_0x00d1
        L_0x00cb:
            if (r9 == 0) goto L_0x00e7
            r9.disconnect()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00e7
        L_0x00d1:
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            r1.i(r9)
        L_0x00e7:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.image.TalTradeImageRequest.downloadBitmapFromUrl(java.lang.String):android.graphics.Bitmap");
    }
}
