package com.sensorsdata.analytics.android.sdk.network;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class HttpUtils {
    private static final int HTTP_307 = 307;

    static boolean needRedirects(int i) {
        return i == 301 || i == 302 || i == HTTP_307;
    }

    HttpUtils() {
    }

    static String getLocation(HttpURLConnection httpURLConnection, String str) throws MalformedURLException {
        if (httpURLConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (TextUtils.isEmpty(headerField)) {
            return null;
        }
        if (headerField.startsWith("http://") || headerField.startsWith("https://")) {
            return headerField;
        }
        URL url = new URL(str);
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004b A[SYNTHETIC, Splitter:B:27:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0055 A[SYNTHETIC, Splitter:B:32:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0063 A[SYNTHETIC, Splitter:B:38:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006d A[SYNTHETIC, Splitter:B:43:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String getRetString(java.io.InputStream r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r5, r3)     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003b }
            r0.<init>()     // Catch:{ Exception -> 0x003b }
        L_0x0012:
            java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x0021
            r0.append(r2)     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch:{ Exception -> 0x003b }
            goto L_0x0012
        L_0x0021:
            r5.close()     // Catch:{ Exception -> 0x003b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x003b }
            r1.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
        L_0x0030:
            if (r5 == 0) goto L_0x003a
            r5.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x003a:
            return r0
        L_0x003b:
            r0 = move-exception
            goto L_0x0046
        L_0x003d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0061
        L_0x0042:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0046:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0053:
            if (r5 == 0) goto L_0x005d
            r5.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x005d:
            java.lang.String r5 = ""
            return r5
        L_0x0060:
            r0 = move-exception
        L_0x0061:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
        L_0x006b:
            if (r5 == 0) goto L_0x0075
            r5.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x0075:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.network.HttpUtils.getRetString(java.io.InputStream):java.lang.String");
    }
}
