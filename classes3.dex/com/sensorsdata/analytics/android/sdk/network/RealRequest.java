package com.sensorsdata.analytics.android.sdk.network;

import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

class RealRequest {
    private static final int CONNECT_TIMEOUT = 30000;
    private static final int READ_TIMEOUT = 30000;
    private static final String TAG = "SA.HttpRequest";
    private static String sRequestURL;

    RealRequest() {
    }

    /* access modifiers changed from: package-private */
    public RealResponse getData(String str, Map<String, String> map) {
        try {
            SALog.i(TAG, String.format("url:%s,\nmethod:GET", new Object[]{str}));
            sRequestURL = str;
            HttpURLConnection httpURLConnection = getHttpURLConnection(str, "GET");
            if (map != null) {
                setHeader(httpURLConnection, map);
            }
            httpURLConnection.connect();
            return getRealResponse(httpURLConnection);
        } catch (Exception e) {
            return getExceptionResponse(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072 A[SYNTHETIC, Splitter:B:30:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d A[SYNTHETIC, Splitter:B:36:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.network.RealResponse postData(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            r6 = this;
            r0 = 0
            sRequestURL = r7     // Catch:{ Exception -> 0x006b }
            java.lang.String r1 = "SA.HttpRequest"
            java.lang.String r2 = "url:%s\nparams:%s\nmethod:POST"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x006b }
            r4 = 0
            r3[r4] = r7     // Catch:{ Exception -> 0x006b }
            r5 = 1
            r3[r5] = r8     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ Exception -> 0x006b }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r1 = "POST"
            java.net.HttpURLConnection r7 = r6.getHttpURLConnection(r7, r1)     // Catch:{ Exception -> 0x006b }
            r7.setDoOutput(r5)     // Catch:{ Exception -> 0x006b }
            r7.setUseCaches(r4)     // Catch:{ Exception -> 0x006b }
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x006b }
            if (r1 != 0) goto L_0x002e
            java.lang.String r1 = "Content-Type"
            r7.setRequestProperty(r1, r9)     // Catch:{ Exception -> 0x006b }
        L_0x002e:
            if (r10 == 0) goto L_0x0033
            r6.setHeader(r7, r10)     // Catch:{ Exception -> 0x006b }
        L_0x0033:
            r7.connect()     // Catch:{ Exception -> 0x006b }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x006b }
            if (r9 != 0) goto L_0x005a
            java.io.BufferedWriter r9 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x006b }
            java.io.OutputStreamWriter r10 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x006b }
            java.io.OutputStream r1 = r7.getOutputStream()     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = "UTF-8"
            r10.<init>(r1, r2)     // Catch:{ Exception -> 0x006b }
            r9.<init>(r10)     // Catch:{ Exception -> 0x006b }
            r9.write(r8)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r9.flush()     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r0 = r9
            goto L_0x005a
        L_0x0054:
            r7 = move-exception
            r0 = r9
            goto L_0x007b
        L_0x0057:
            r7 = move-exception
            r0 = r9
            goto L_0x006c
        L_0x005a:
            com.sensorsdata.analytics.android.sdk.network.RealResponse r7 = r6.getRealResponse(r7)     // Catch:{ Exception -> 0x006b }
            if (r0 == 0) goto L_0x0068
            r0.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x0068:
            return r7
        L_0x0069:
            r7 = move-exception
            goto L_0x007b
        L_0x006b:
            r7 = move-exception
        L_0x006c:
            com.sensorsdata.analytics.android.sdk.network.RealResponse r7 = r6.getExceptionResponse(r7)     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x007a
            r0.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x007a:
            return r7
        L_0x007b:
            if (r0 == 0) goto L_0x0085
            r0.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x0085:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.network.RealRequest.postData(java.lang.String, java.lang.String, java.lang.String, java.util.Map):com.sensorsdata.analytics.android.sdk.network.RealResponse");
    }

    private HttpURLConnection getHttpURLConnection(String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        if (str2.equals("POST")) {
            httpURLConnection.setDoOutput(true);
        }
        SAConfigOptions configOptions = SensorsDataAPI.getConfigOptions();
        if (!(configOptions == null || configOptions.mSSLSocketFactory == null || !(httpURLConnection instanceof HttpsURLConnection))) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(configOptions.mSSLSocketFactory);
        }
        return httpURLConnection;
    }

    private void setHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.setRequestProperty(next, map.get(next));
            }
        }
    }

    private RealResponse getRealResponse(HttpURLConnection httpURLConnection) {
        RealResponse realResponse = new RealResponse();
        try {
            realResponse.code = httpURLConnection.getResponseCode();
            if (HttpUtils.needRedirects(realResponse.code)) {
                realResponse.location = HttpUtils.getLocation(httpURLConnection, sRequestURL);
            }
            realResponse.contentLength = (long) httpURLConnection.getContentLength();
            if (realResponse.code < 400) {
                realResponse.result = HttpUtils.getRetString(httpURLConnection.getInputStream());
            } else {
                realResponse.errorMsg = HttpUtils.getRetString(httpURLConnection.getErrorStream());
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            SALog.i(TAG, realResponse.toString());
            return realResponse;
        } catch (IOException e) {
            RealResponse exceptionResponse = getExceptionResponse(e);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return exceptionResponse;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private RealResponse getExceptionResponse(Exception exc) {
        RealResponse realResponse = new RealResponse();
        realResponse.exception = exc;
        realResponse.errorMsg = exc.getMessage();
        SALog.i(TAG, realResponse.toString());
        return realResponse;
    }
}
