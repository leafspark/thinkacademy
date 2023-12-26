package com.eaydu.omni.fullLog;

import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import com.bumptech.glide.load.Key;
import com.didi.hummer.adapter.http.IHttpAdapter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class NetworkNewUtil_rtc {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
        if (r7 == null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
        r7.disconnect();
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c7, code lost:
        if (r7 == null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ca, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b8 A[SYNTHETIC, Splitter:B:48:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c0 A[Catch:{ Exception -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00cf A[SYNTHETIC, Splitter:B:60:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d7 A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String get(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            r1.<init>(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.net.URLConnection r7 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r7)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.util.Set r8 = r8.entrySet()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
        L_0x0018:
            boolean r1 = r8.hasNext()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r8.next()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.Object r2 = r1.getKey()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r7.addRequestProperty(r2, r1)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            goto L_0x0018
        L_0x0034:
            java.lang.String r8 = "GET"
            r7.setRequestMethod(r8)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r8 = 15000(0x3a98, float:2.102E-41)
            r7.setConnectTimeout(r8)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r8 = 60000(0xea60, float:8.4078E-41)
            r7.setReadTimeout(r8)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r7.connect()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.io.InputStream r8 = r7.getInputStream()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r8, r3)     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            r1.<init>(r2)     // Catch:{ Exception -> 0x009f, all -> 0x009a }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0094, all -> 0x008e }
            r2.<init>()     // Catch:{ Exception -> 0x0094, all -> 0x008e }
            r3 = 1
        L_0x005d:
            java.lang.String r4 = r1.readLine()     // Catch:{ Exception -> 0x0094, all -> 0x008e }
            if (r4 == 0) goto L_0x0074
            r2.append(r4)     // Catch:{ Exception -> 0x0094, all -> 0x008e }
            java.lang.String r4 = "\r\n"
            r2.append(r4)     // Catch:{ Exception -> 0x0094, all -> 0x008e }
            int r4 = r2.length()     // Catch:{ Exception -> 0x0094, all -> 0x008e }
            r5 = 1048576(0x100000, float:1.469368E-39)
            if (r4 <= r5) goto L_0x005d
            r3 = 0
        L_0x0074:
            if (r3 == 0) goto L_0x007a
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0094, all -> 0x008e }
        L_0x007a:
            r1.close()     // Catch:{ Exception -> 0x0083 }
            if (r8 == 0) goto L_0x0087
            r8.close()     // Catch:{ Exception -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0087:
            if (r7 == 0) goto L_0x00ca
        L_0x0089:
            r7.disconnect()
            goto L_0x00ca
        L_0x008e:
            r0 = move-exception
            r6 = r1
            r1 = r8
            r8 = r0
            r0 = r6
            goto L_0x00cd
        L_0x0094:
            r2 = move-exception
            r6 = r1
            r1 = r8
            r8 = r2
            r2 = r6
            goto L_0x00b3
        L_0x009a:
            r1 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L_0x00cd
        L_0x009f:
            r1 = move-exception
            r2 = r0
            r6 = r1
            r1 = r8
            r8 = r6
            goto L_0x00b3
        L_0x00a5:
            r8 = move-exception
            r1 = r0
            goto L_0x00cd
        L_0x00a8:
            r8 = move-exception
            r1 = r0
            goto L_0x00b2
        L_0x00ab:
            r8 = move-exception
            r7 = r0
            r1 = r7
            goto L_0x00cd
        L_0x00af:
            r8 = move-exception
            r7 = r0
            r1 = r7
        L_0x00b2:
            r2 = r1
        L_0x00b3:
            r8.printStackTrace()     // Catch:{ all -> 0x00cb }
            if (r2 == 0) goto L_0x00be
            r2.close()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00be
        L_0x00bc:
            r8 = move-exception
            goto L_0x00c4
        L_0x00be:
            if (r1 == 0) goto L_0x00c7
            r1.close()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c7
        L_0x00c4:
            r8.printStackTrace()
        L_0x00c7:
            if (r7 == 0) goto L_0x00ca
            goto L_0x0089
        L_0x00ca:
            return r0
        L_0x00cb:
            r8 = move-exception
            r0 = r2
        L_0x00cd:
            if (r0 == 0) goto L_0x00d5
            r0.close()     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00d5
        L_0x00d3:
            r0 = move-exception
            goto L_0x00db
        L_0x00d5:
            if (r1 == 0) goto L_0x00de
            r1.close()     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00de
        L_0x00db:
            r0.printStackTrace()
        L_0x00de:
            if (r7 == 0) goto L_0x00e3
            r7.disconnect()
        L_0x00e3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.fullLog.NetworkNewUtil_rtc.get(java.lang.String, java.util.Map):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[SYNTHETIC, Splitter:B:28:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009d A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A[SYNTHETIC, Splitter:B:38:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00aa A[Catch:{ Exception -> 0x00ad }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Post(java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.net.URLConnection r5 = r1.openConnection()     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.net.URLConnection r5 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r5)     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.lang.String r1 = ""
            r2 = 1
            r5.setDoInput(r2)     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            r5.setDoOutput(r2)     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.util.Set r7 = r7.entrySet()     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
        L_0x001f:
            boolean r3 = r7.hasNext()     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r7.next()     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            r5.addRequestProperty(r4, r3)     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            goto L_0x001f
        L_0x003b:
            java.io.PrintWriter r7 = new java.io.PrintWriter     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.io.OutputStream r3 = r5.getOutputStream()     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            r7.<init>(r3)     // Catch:{ Exception -> 0x00a1, all -> 0x0094 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            r3.<init>()     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            java.lang.String r4 = "content="
            r3.append(r4)     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            r3.append(r6)     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            r7.print(r6)     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            r7.flush()     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0091, all -> 0x008d }
            r6.<init>(r3)     // Catch:{ Exception -> 0x0091, all -> 0x008d }
        L_0x0069:
            java.lang.String r5 = r6.readLine()     // Catch:{ Exception -> 0x0092, all -> 0x008b }
            if (r5 == 0) goto L_0x0084
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0092, all -> 0x008b }
            r0.<init>()     // Catch:{ Exception -> 0x0092, all -> 0x008b }
            r0.append(r1)     // Catch:{ Exception -> 0x0092, all -> 0x008b }
            r0.append(r5)     // Catch:{ Exception -> 0x0092, all -> 0x008b }
            java.lang.String r5 = "\n"
            r0.append(r5)     // Catch:{ Exception -> 0x0092, all -> 0x008b }
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x0092, all -> 0x008b }
            goto L_0x0069
        L_0x0084:
            r7.close()     // Catch:{ Exception -> 0x008a }
            r6.close()     // Catch:{ Exception -> 0x008a }
        L_0x008a:
            return r2
        L_0x008b:
            r5 = move-exception
            goto L_0x008f
        L_0x008d:
            r5 = move-exception
            r6 = r0
        L_0x008f:
            r0 = r7
            goto L_0x0096
        L_0x0091:
            r6 = r0
        L_0x0092:
            r0 = r7
            goto L_0x00a2
        L_0x0094:
            r5 = move-exception
            r6 = r0
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            r0.close()     // Catch:{ Exception -> 0x00a0 }
        L_0x009b:
            if (r6 == 0) goto L_0x00a0
            r6.close()     // Catch:{ Exception -> 0x00a0 }
        L_0x00a0:
            throw r5
        L_0x00a1:
            r6 = r0
        L_0x00a2:
            r5 = 0
            if (r0 == 0) goto L_0x00a8
            r0.close()     // Catch:{ Exception -> 0x00ad }
        L_0x00a8:
            if (r6 == 0) goto L_0x00ad
            r6.close()     // Catch:{ Exception -> 0x00ad }
        L_0x00ad:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.fullLog.NetworkNewUtil_rtc.Post(java.lang.String, java.lang.String, java.util.Map):boolean");
    }

    public static boolean sendPostRequest(String str, String str2, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(str).openConnection());
            for (Map.Entry next : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            httpURLConnection.setRequestMethod(IHttpAdapter.METHOD_POST);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str2.getBytes());
            outputStream.flush();
            outputStream.close();
            httpURLConnection.getResponseCode();
            new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Key.STRING_CHARSET_NAME)).readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008e A[SYNTHETIC, Splitter:B:35:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0093 A[Catch:{ Exception -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009a A[SYNTHETIC, Splitter:B:43:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009f A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean postLiberal(java.lang.String r5, byte[] r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.net.URLConnection r5 = r1.openConnection()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.net.URLConnection r5 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r5)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.String r1 = ""
            r2 = 1
            r5.setDoInput(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r5.setDoOutput(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.util.Set r7 = r7.entrySet()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
        L_0x001f:
            boolean r3 = r7.hasNext()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r7.next()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r5.addRequestProperty(r4, r3)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            goto L_0x001f
        L_0x003b:
            java.io.OutputStream r7 = r5.getOutputStream()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r7.write(r6)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r7.flush()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r3.<init>(r5)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r6.<init>(r3)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
        L_0x0053:
            java.lang.String r5 = r6.readLine()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            if (r5 == 0) goto L_0x006e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r0.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r0.append(r1)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r0.append(r5)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r5 = "\n"
            r0.append(r5)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            goto L_0x0053
        L_0x006e:
            if (r7 == 0) goto L_0x0073
            r7.close()     // Catch:{ Exception -> 0x0076 }
        L_0x0073:
            r6.close()     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            return r2
        L_0x0077:
            r5 = move-exception
            goto L_0x007d
        L_0x0079:
            r5 = move-exception
            goto L_0x0081
        L_0x007b:
            r5 = move-exception
            r6 = r0
        L_0x007d:
            r0 = r7
            goto L_0x0098
        L_0x007f:
            r5 = move-exception
            r6 = r0
        L_0x0081:
            r0 = r7
            goto L_0x0088
        L_0x0083:
            r5 = move-exception
            r6 = r0
            goto L_0x0098
        L_0x0086:
            r5 = move-exception
            r6 = r0
        L_0x0088:
            r5.printStackTrace()     // Catch:{ all -> 0x0097 }
            r5 = 0
            if (r0 == 0) goto L_0x0091
            r0.close()     // Catch:{ Exception -> 0x0096 }
        L_0x0091:
            if (r6 == 0) goto L_0x0096
            r6.close()     // Catch:{ Exception -> 0x0096 }
        L_0x0096:
            return r5
        L_0x0097:
            r5 = move-exception
        L_0x0098:
            if (r0 == 0) goto L_0x009d
            r0.close()     // Catch:{ Exception -> 0x00a2 }
        L_0x009d:
            if (r6 == 0) goto L_0x00a2
            r6.close()     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.fullLog.NetworkNewUtil_rtc.postLiberal(java.lang.String, byte[], java.util.Map):boolean");
    }
}
