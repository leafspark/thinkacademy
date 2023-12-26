package com.wushuangtech.utils;

import com.tekartik.sqflite.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtil {
    public static final int DEF_TIMEOUT_MILLIS = 2000;

    public static abstract class CallBack {
        protected String mUUID;

        public abstract void onRequestComplete(String str);

        public abstract void onRequestError(String str);

        protected CallBack(String str) {
            this.mUUID = str;
        }
    }

    public static void doGetAsyn(final String str, final int i, final CallBack callBack) {
        new Thread() {
            public void run() {
                HttpUtil.doGet(str, callBack, i);
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ef A[Catch:{ all -> 0x012b }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x010b A[Catch:{ all -> 0x012b }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0116 A[SYNTHETIC, Splitter:B:82:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011e A[Catch:{ IOException -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x012e A[SYNTHETIC, Splitter:B:93:0x012e] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0136 A[Catch:{ IOException -> 0x0132 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doGet(java.lang.String r8, com.wushuangtech.utils.HttpUtil.CallBack r9, int r10) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00e8, all -> 0x00e4 }
            r2.<init>(r8)     // Catch:{ IOException -> 0x00e8, all -> 0x00e4 }
            java.net.URLConnection r8 = r2.openConnection()     // Catch:{ IOException -> 0x00e8, all -> 0x00e4 }
            java.net.URLConnection r8 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r8)     // Catch:{ IOException -> 0x00e8, all -> 0x00e4 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ IOException -> 0x00e8, all -> 0x00e4 }
            float r10 = (float) r10
            r2 = 1077936128(0x40400000, float:3.0)
            float r10 = r10 / r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 * r10
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            float r10 = r10 + r3
            int r2 = (int) r2
            r3 = 500(0x1f4, float:7.0E-43)
            if (r2 != 0) goto L_0x0023
            r2 = r3
        L_0x0023:
            int r10 = (int) r10
            if (r10 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r3 = r10
        L_0x0028:
            r8.setReadTimeout(r2)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            r8.setConnectTimeout(r3)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            java.lang.String r10 = "GET"
            r8.setRequestMethod(r10)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            java.lang.String r10 = "accept"
            java.lang.String r4 = "*/*"
            r8.setRequestProperty(r10, r4)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            java.lang.String r10 = "connection"
            java.lang.String r4 = "Keep-Alive"
            r8.setRequestProperty(r10, r4)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            int r10 = r8.getResponseCode()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            r4 = 200(0xc8, float:2.8E-43)
            if (r10 != r4) goto L_0x007e
            java.io.InputStream r4 = r8.getInputStream()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0079, all -> 0x0074 }
            r5.<init>()     // Catch:{ IOException -> 0x0079, all -> 0x0074 }
            r1 = 128(0x80, float:1.794E-43)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
        L_0x0056:
            int r6 = r4.read(r1)     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
            r7 = -1
            if (r6 == r7) goto L_0x0062
            r7 = 0
            r5.write(r1, r7, r6)     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
            goto L_0x0056
        L_0x0062:
            r5.flush()     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
            java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
            if (r9 == 0) goto L_0x006e
            r9.onRequestComplete(r1)     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
        L_0x006e:
            r1 = r4
            goto L_0x00a4
        L_0x0070:
            r9 = move-exception
            goto L_0x0076
        L_0x0072:
            r10 = move-exception
            goto L_0x007b
        L_0x0074:
            r9 = move-exception
            r5 = r1
        L_0x0076:
            r1 = r4
            goto L_0x012c
        L_0x0079:
            r10 = move-exception
            r5 = r1
        L_0x007b:
            r1 = r4
            goto L_0x00eb
        L_0x007e:
            boolean r4 = com.wushuangtech.library.GlobalConfig.mIsAuthAlwaysSuccess     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            if (r4 == 0) goto L_0x0087
            org.json.JSONObject r4 = buildSuccessReport()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            goto L_0x008b
        L_0x0087:
            org.json.JSONObject r4 = buildFailedReport(r10)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
        L_0x008b:
            if (r9 == 0) goto L_0x00a3
            if (r4 != 0) goto L_0x0091
            r4 = r0
            goto L_0x00a0
        L_0x0091:
            boolean r5 = r4 instanceof org.json.JSONObject     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            if (r5 != 0) goto L_0x009a
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            goto L_0x00a0
        L_0x009a:
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            java.lang.String r4 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r4)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
        L_0x00a0:
            r9.onRequestComplete(r4)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
        L_0x00a3:
            r5 = r1
        L_0x00a4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00dc }
            r4.<init>()     // Catch:{ IOException -> 0x00dc }
            java.lang.String r6 = "room watcher -> Authentication result readTimeout : "
            r4.append(r6)     // Catch:{ IOException -> 0x00dc }
            r4.append(r2)     // Catch:{ IOException -> 0x00dc }
            java.lang.String r2 = " | connectTimeout : "
            r4.append(r2)     // Catch:{ IOException -> 0x00dc }
            r4.append(r3)     // Catch:{ IOException -> 0x00dc }
            java.lang.String r2 = " | responseCode : "
            r4.append(r2)     // Catch:{ IOException -> 0x00dc }
            r4.append(r10)     // Catch:{ IOException -> 0x00dc }
            java.lang.String r10 = r4.toString()     // Catch:{ IOException -> 0x00dc }
            com.wushuangtech.utils.OmniLog.i(r10)     // Catch:{ IOException -> 0x00dc }
            if (r1 == 0) goto L_0x00d0
            r1.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00d0
        L_0x00ce:
            r9 = move-exception
            goto L_0x00d6
        L_0x00d0:
            if (r5 == 0) goto L_0x00d9
            r5.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00d9
        L_0x00d6:
            r9.printStackTrace()
        L_0x00d9:
            if (r8 == 0) goto L_0x012a
            goto L_0x0127
        L_0x00dc:
            r10 = move-exception
            goto L_0x00eb
        L_0x00de:
            r9 = move-exception
            r5 = r1
            goto L_0x012c
        L_0x00e1:
            r10 = move-exception
            r5 = r1
            goto L_0x00eb
        L_0x00e4:
            r9 = move-exception
            r8 = r1
            r5 = r8
            goto L_0x012c
        L_0x00e8:
            r10 = move-exception
            r8 = r1
            r5 = r8
        L_0x00eb:
            boolean r2 = com.wushuangtech.library.GlobalConfig.mIsAuthAlwaysSuccess     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x010b
            org.json.JSONObject r10 = buildSuccessReport()     // Catch:{ all -> 0x012b }
            if (r9 == 0) goto L_0x0114
            if (r10 != 0) goto L_0x00f8
            goto L_0x0107
        L_0x00f8:
            boolean r0 = r10 instanceof org.json.JSONObject     // Catch:{ all -> 0x012b }
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x012b }
            goto L_0x0107
        L_0x0101:
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ all -> 0x012b }
            java.lang.String r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r10)     // Catch:{ all -> 0x012b }
        L_0x0107:
            r9.onRequestComplete(r0)     // Catch:{ all -> 0x012b }
            goto L_0x0114
        L_0x010b:
            if (r9 == 0) goto L_0x0114
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch:{ all -> 0x012b }
            r9.onRequestError(r10)     // Catch:{ all -> 0x012b }
        L_0x0114:
            if (r1 == 0) goto L_0x011c
            r1.close()     // Catch:{ IOException -> 0x011a }
            goto L_0x011c
        L_0x011a:
            r9 = move-exception
            goto L_0x0122
        L_0x011c:
            if (r5 == 0) goto L_0x0125
            r5.close()     // Catch:{ IOException -> 0x011a }
            goto L_0x0125
        L_0x0122:
            r9.printStackTrace()
        L_0x0125:
            if (r8 == 0) goto L_0x012a
        L_0x0127:
            r8.disconnect()
        L_0x012a:
            return
        L_0x012b:
            r9 = move-exception
        L_0x012c:
            if (r1 == 0) goto L_0x0134
            r1.close()     // Catch:{ IOException -> 0x0132 }
            goto L_0x0134
        L_0x0132:
            r10 = move-exception
            goto L_0x013a
        L_0x0134:
            if (r5 == 0) goto L_0x013d
            r5.close()     // Catch:{ IOException -> 0x0132 }
            goto L_0x013d
        L_0x013a:
            r10.printStackTrace()
        L_0x013d:
            if (r8 == 0) goto L_0x0142
            r8.disconnect()
        L_0x0142:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.utils.HttpUtil.doGet(java.lang.String, com.wushuangtech.utils.HttpUtil$CallBack, int):void");
    }

    private static JSONObject buildSuccessReport() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constant.PARAM_ERROR_CODE, 0);
            jSONObject.put(Constant.PARAM_ERROR_MESSAGE, "authority success!");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(Constant.PARAM_ERROR_DATA, jSONObject2);
            jSONObject2.put("token", "");
            jSONObject2.put("remain", 3600);
            jSONObject2.put("mask", 32767);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static JSONObject buildFailedReport(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constant.PARAM_ERROR_CODE, i);
            jSONObject.put(Constant.PARAM_ERROR_MESSAGE, "authority failed!");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(Constant.PARAM_ERROR_DATA, jSONObject2);
            jSONObject2.put("token", "");
            jSONObject2.put("remain", 3600);
            jSONObject2.put("mask", 32767);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
