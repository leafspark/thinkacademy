package com.bonree.sdk.agent.business.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.transfer.HeartbeatRequestBean;
import com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.g;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.n.b;
import com.didi.hummer.adapter.http.IHttpAdapter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public class c {
    private static final String h = "SocketException: Failed host lookup";
    private static final String i = "SocketException: OS Error: Connection timed out";
    private static final String j = "SocketException: HTTP connection timed out afte";
    private static final String k = "HandshakeException: Handshake error in client";
    private static final String l = "ERR_CERT_AUTHORITY_INVALID";
    private static final String m = "ERR_SSL_PROTOCOL_ERROR";
    private static final String n = "ERR_SSL_OBSOLETE_VERSION";
    private static final String o = "ERR_NAME_NOT_RESOLVED";
    private static final String p = "ERR_CONNECTION_REFUSED";
    private static final String q = "ERR_CONNECTION_TIMED_OUT";
    private HttpURLConnection a;
    private final Gson b;
    private final Type c;
    private final Type d;
    private final Type e;
    private final URL f;
    private final long g;

    public c(String str) throws MalformedURLException {
        this.c = new d(this).getType();
        this.d = new e(this).getType();
        this.e = new f(this).getType();
        this.g = TimeUnit.MINUTES.toMillis(1);
        this.b = new Gson();
        this.f = new URL(str);
    }

    private void a() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) this.f.openConnection();
        this.a = httpURLConnection;
        httpURLConnection.setDoInput(true);
        this.a.setDoOutput(true);
        this.a.setRequestProperty("Connection", "Keep-Alive");
        this.a.setRequestMethod(IHttpAdapter.METHOD_POST);
        this.a.setConnectTimeout(2500);
        this.a.setReadTimeout(2500);
    }

    public final HeartbeatResponseDataBean a(HeartbeatRequestBean heartbeatRequestBean, long j2, long j3) {
        while (true) {
            try {
                HeartbeatResponseDataBean a2 = a(heartbeatRequestBean);
                if (a2 != null) {
                    return a2;
                }
            } catch (Exception e2) {
                a.a().a("heartbeat send error %s", (Throwable) e2);
            }
            if (com.bonree.sdk.d.a.b() - j2 > this.g) {
                return null;
            }
            a.a().e("heartbeat send retry interval %d ms...", Long.valueOf(j3));
            SystemClock.sleep(j3);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean} */
    /* JADX WARNING: type inference failed for: r5v5, types: [com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean] */
    /* JADX WARNING: type inference failed for: r12v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r5v7, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r3v12, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01bc A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c1 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c6 A[DONT_GENERATE] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean a(com.bonree.sdk.agent.business.entity.transfer.HeartbeatRequestBean r18) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "tl"
            java.lang.String r2 = "data"
            java.net.URL r3 = r1.f
            java.net.URLConnection r3 = r3.openConnection()
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            r1.a = r3
            r4 = 1
            r3.setDoInput(r4)
            java.net.HttpURLConnection r3 = r1.a
            r3.setDoOutput(r4)
            java.net.HttpURLConnection r3 = r1.a
            java.lang.String r5 = "Connection"
            java.lang.String r6 = "Keep-Alive"
            r3.setRequestProperty(r5, r6)
            java.net.HttpURLConnection r3 = r1.a
            java.lang.String r5 = "POST"
            r3.setRequestMethod(r5)
            java.net.HttpURLConnection r3 = r1.a
            r5 = 2500(0x9c4, float:3.503E-42)
            r3.setConnectTimeout(r5)
            java.net.HttpURLConnection r3 = r1.a
            r3.setReadTimeout(r5)
            java.net.HttpURLConnection r3 = r1.a
            r3.connect()
            com.bonree.sdk.common.gson.Gson r3 = r1.b
            r5 = r18
            java.lang.String r3 = r3.toJson((java.lang.Object) r5)
            com.bonree.sdk.be.f r5 = com.bonree.sdk.be.a.a()
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]
            com.bonree.sdk.be.f$a r8 = com.bonree.sdk.be.f.a.JSON
            r9 = 0
            r7[r9] = r8
            r7[r4] = r3
            java.lang.String r8 = "Heartbeat send request data: \n %s"
            r5.a((java.lang.String) r8, (java.lang.Object[]) r7)
            r5 = 0
            java.net.HttpURLConnection r7 = r1.a     // Catch:{ all -> 0x01a6 }
            java.io.OutputStream r7 = r7.getOutputStream()     // Catch:{ all -> 0x01a6 }
            java.io.BufferedWriter r8 = new java.io.BufferedWriter     // Catch:{ all -> 0x019e }
            java.io.OutputStreamWriter r10 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x019e }
            r10.<init>(r7)     // Catch:{ all -> 0x019e }
            r11 = 512(0x200, float:7.175E-43)
            r8.<init>(r10, r11)     // Catch:{ all -> 0x019e }
            r8.write(r3)     // Catch:{ all -> 0x0198 }
            r8.flush()     // Catch:{ all -> 0x0198 }
            java.net.HttpURLConnection r3 = r1.a     // Catch:{ all -> 0x0198 }
            int r3 = r3.getResponseCode()     // Catch:{ all -> 0x0198 }
            r10 = 200(0xc8, float:2.8E-43)
            if (r3 == r10) goto L_0x0092
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0198 }
            java.lang.String r2 = "Heartbeat send http code is %d !"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0198 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0198 }
            r6[r9] = r3     // Catch:{ all -> 0x0198 }
            r0.e(r2, r6)     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x008e
            r7.close()
        L_0x008e:
            r8.close()
            return r5
        L_0x0092:
            java.net.HttpURLConnection r3 = r1.a     // Catch:{ all -> 0x0198 }
            java.io.InputStream r3 = r3.getInputStream()     // Catch:{ all -> 0x0198 }
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0193 }
            r12.<init>()     // Catch:{ all -> 0x0193 }
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x018f }
        L_0x009f:
            int r13 = r3.read(r11)     // Catch:{ all -> 0x018f }
            r14 = -1
            if (r13 == r14) goto L_0x00aa
            r12.write(r11, r9, r13)     // Catch:{ all -> 0x018f }
            goto L_0x009f
        L_0x00aa:
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x018f }
            com.bonree.sdk.be.f r13 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x018f }
            java.lang.String r14 = "Heartbeat send response data: \n %s"
            java.lang.Object[] r15 = new java.lang.Object[r6]     // Catch:{ all -> 0x018f }
            com.bonree.sdk.be.f$a r16 = com.bonree.sdk.be.f.a.JSON     // Catch:{ all -> 0x018f }
            r15[r9] = r16     // Catch:{ all -> 0x018f }
            r15[r4] = r11     // Catch:{ all -> 0x018f }
            r13.a((java.lang.String) r14, (java.lang.Object[]) r15)     // Catch:{ all -> 0x018f }
            com.bonree.sdk.common.gson.JsonElement r13 = com.bonree.sdk.common.gson.JsonParser.parseString(r11)     // Catch:{ all -> 0x018f }
            com.bonree.sdk.common.gson.JsonObject r13 = r13.getAsJsonObject()     // Catch:{ all -> 0x018f }
            com.bonree.sdk.common.gson.Gson r14 = r1.b     // Catch:{ all -> 0x018f }
            java.lang.Class<com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseBean> r15 = com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseBean.class
            java.lang.Object r14 = r14.fromJson((com.bonree.sdk.common.gson.JsonElement) r13, r15)     // Catch:{ all -> 0x018f }
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseBean r14 = (com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseBean) r14     // Catch:{ all -> 0x018f }
            if (r14 == 0) goto L_0x0157
            int r15 = r14.getCode()     // Catch:{ all -> 0x018f }
            if (r15 == r10) goto L_0x00db
            goto L_0x0157
        L_0x00db:
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean r5 = r14.getHeartbeatResponseDataBean()     // Catch:{ all -> 0x018f }
            boolean r6 = r13.has(r2)     // Catch:{ all -> 0x018f }
            if (r6 == 0) goto L_0x0145
            com.bonree.sdk.common.gson.JsonElement r2 = r13.get(r2)     // Catch:{ all -> 0x018f }
            com.bonree.sdk.common.gson.JsonObject r2 = r2.getAsJsonObject()     // Catch:{ all -> 0x018f }
            boolean r6 = r2.has(r0)     // Catch:{ all -> 0x018f }
            if (r6 == 0) goto L_0x0145
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x018f }
            r6.<init>()     // Catch:{ all -> 0x018f }
            r5.setTaskList(r6)     // Catch:{ all -> 0x018f }
            com.bonree.sdk.common.gson.JsonArray r0 = r2.getAsJsonArray(r0)     // Catch:{ all -> 0x018f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x018f }
        L_0x0103:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x018f }
            if (r2 == 0) goto L_0x0145
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x018f }
            com.bonree.sdk.common.gson.JsonElement r2 = (com.bonree.sdk.common.gson.JsonElement) r2     // Catch:{ all -> 0x018f }
            com.bonree.sdk.common.gson.JsonObject r2 = r2.getAsJsonObject()     // Catch:{ all -> 0x018f }
            java.lang.String r6 = "t"
            com.bonree.sdk.common.gson.JsonElement r6 = r2.get(r6)     // Catch:{ all -> 0x018f }
            int r6 = r6.getAsInt()     // Catch:{ all -> 0x018f }
            com.bonree.sdk.common.gson.Gson r10 = r1.b     // Catch:{ all -> 0x018f }
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean$TaskConfiguration$OrderType r11 = com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean.TaskConfiguration.OrderType.PING     // Catch:{ all -> 0x018f }
            int r11 = r11.ordinal()     // Catch:{ all -> 0x018f }
            if (r6 != r11) goto L_0x012a
            java.lang.reflect.Type r6 = r1.c     // Catch:{ all -> 0x018f }
            goto L_0x0137
        L_0x012a:
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean$TaskConfiguration$OrderType r11 = com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean.TaskConfiguration.OrderType.GET_LOG     // Catch:{ all -> 0x018f }
            int r11 = r11.ordinal()     // Catch:{ all -> 0x018f }
            if (r6 != r11) goto L_0x0135
            java.lang.reflect.Type r6 = r1.d     // Catch:{ all -> 0x018f }
            goto L_0x0137
        L_0x0135:
            java.lang.reflect.Type r6 = r1.e     // Catch:{ all -> 0x018f }
        L_0x0137:
            java.lang.Object r2 = r10.fromJson((com.bonree.sdk.common.gson.JsonElement) r2, (java.lang.reflect.Type) r6)     // Catch:{ all -> 0x018f }
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean$TaskConfiguration r2 = (com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean.TaskConfiguration) r2     // Catch:{ all -> 0x018f }
            java.util.List r6 = r5.getTaskList()     // Catch:{ all -> 0x018f }
            r6.add(r2)     // Catch:{ all -> 0x018f }
            goto L_0x0103
        L_0x0145:
            if (r7 == 0) goto L_0x014a
            r7.close()
        L_0x014a:
            r8.close()
            if (r3 == 0) goto L_0x0152
            r3.close()
        L_0x0152:
            r12.close()
            goto L_0x01ca
        L_0x0157:
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x018f }
            java.lang.String r2 = "Heartbeat response data error,origin data: %s"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x018f }
            com.bonree.sdk.be.f$a r10 = com.bonree.sdk.be.f.a.JSON     // Catch:{ all -> 0x018f }
            r6[r9] = r10     // Catch:{ all -> 0x018f }
            r6[r4] = r11     // Catch:{ all -> 0x018f }
            r0.e(r2, r6)     // Catch:{ all -> 0x018f }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x018f }
            java.lang.String r2 = "Heartbeat response data  error: %s"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x018f }
            if (r14 == 0) goto L_0x0177
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x018f }
            goto L_0x0179
        L_0x0177:
            java.lang.String r10 = " NULL!!!"
        L_0x0179:
            r6[r9] = r10     // Catch:{ all -> 0x018f }
            r0.e(r2, r6)     // Catch:{ all -> 0x018f }
            if (r7 == 0) goto L_0x0183
            r7.close()
        L_0x0183:
            r8.close()
            if (r3 == 0) goto L_0x018b
            r3.close()
        L_0x018b:
            r12.close()
            return r5
        L_0x018f:
            r0 = move-exception
            r2 = r0
            r0 = r5
            goto L_0x01a4
        L_0x0193:
            r0 = move-exception
            r2 = r0
            r0 = r5
            r12 = r0
            goto L_0x01a4
        L_0x0198:
            r0 = move-exception
            r2 = r0
            r0 = r5
            r3 = r0
            r12 = r3
            goto L_0x01a4
        L_0x019e:
            r0 = move-exception
            r2 = r0
            r0 = r5
            r3 = r0
            r8 = r3
            r12 = r8
        L_0x01a4:
            r5 = r7
            goto L_0x01ac
        L_0x01a6:
            r0 = move-exception
            r2 = r0
            r0 = r5
            r3 = r0
            r8 = r3
            r12 = r8
        L_0x01ac:
            com.bonree.sdk.be.f r6 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x01d8 }
            java.lang.String r7 = "Signal heartbeat send error: "
            r6.a((java.lang.String) r7, (java.lang.Throwable) r2)     // Catch:{ all -> 0x01d8 }
            if (r5 == 0) goto L_0x01ba
            r5.close()
        L_0x01ba:
            if (r8 == 0) goto L_0x01bf
            r8.close()
        L_0x01bf:
            if (r3 == 0) goto L_0x01c4
            r3.close()
        L_0x01c4:
            if (r12 == 0) goto L_0x01c9
            r12.close()
        L_0x01c9:
            r5 = r0
        L_0x01ca:
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r9] = r5
            java.lang.String r3 = "Signal heartbeat send success ,response data: %s "
            r0.a((java.lang.String) r3, (java.lang.Object[]) r2)
            return r5
        L_0x01d8:
            r0 = move-exception
            if (r5 == 0) goto L_0x01de
            r5.close()
        L_0x01de:
            if (r8 == 0) goto L_0x01e3
            r8.close()
        L_0x01e3:
            if (r3 == 0) goto L_0x01e8
            r3.close()
        L_0x01e8:
            if (r12 == 0) goto L_0x01ed
            r12.close()
        L_0x01ed:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.business.util.c.a(com.bonree.sdk.agent.business.entity.transfer.HeartbeatRequestBean):com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean");
    }

    public c() {
    }

    public static void a(b bVar, Exception exc) {
        if (exc != null) {
            int a2 = a((Throwable) exc, (com.bonree.sdk.n.c) bVar);
            bVar.a(a2, a(a2, (Throwable) exc));
            bVar.d(exc.toString());
        }
    }

    public static void a(b bVar, Throwable th) {
        if (th != null) {
            int a2 = a(th, (com.bonree.sdk.n.c) bVar);
            bVar.a(a2, a(a2, th));
            bVar.d(th.toString());
        }
    }

    public static int a(Throwable th, com.bonree.sdk.n.c cVar) {
        String message;
        String message2;
        g.a(" throwle message:" + th, new Object[0]);
        if (th instanceof UnknownHostException) {
            cVar.a = 2;
            return 659;
        } else if (th instanceof SocketTimeoutException) {
            String message3 = th.getMessage();
            if (message3 == null || !message3.contains("SSL handshake")) {
                cVar.a = 3;
                return 652;
            }
            cVar.a = 1;
            return 653;
        } else if (th instanceof ConnectException) {
            cVar.a = 3;
            return 652;
        } else if (th instanceof MalformedURLException) {
            cVar.a = 3;
            return 641;
        } else if (th instanceof SSLException) {
            cVar.a = 1;
            return 653;
        } else if (th instanceof UnknownServiceException) {
            cVar.a = 4;
            return 660;
        } else if ((th instanceof SocketException) && (message2 = th.getMessage()) != null && (message2.contains("Connection reset") || message2.contains("recvfrom failed: ECONNRESET (Connection reset by peer)"))) {
            cVar.a = 3;
            return 652;
        } else if (!(th instanceof IOException) || (message = th.getMessage()) == null || !message.contains("ftruncate failed: ENOENT (No such file or directory)")) {
            cVar.a = 4;
            return 600;
        } else {
            cVar.a = 3;
            return 641;
        }
    }

    public static int a(String str) {
        g.a(" throw message:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return 4;
        }
        if (str.contains(h)) {
            return 2;
        }
        if (str.contains(i) || str.contains(j)) {
            return 3;
        }
        if (str.contains(k)) {
            return 1;
        }
        return 4;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 4;
        }
        if (str.contains(l) || str.contains(m) || str.contains(n)) {
            return 1;
        }
        if (str.contains(o)) {
            return 2;
        }
        if (!str.contains(q) && !str.contains(p)) {
            return 4;
        }
        return 3;
    }

    public static int a(int i2, Throwable th) {
        int a2 = a(th);
        if (i2 != 652) {
            if (i2 != 653) {
                if (i2 != 659) {
                    if (i2 != 660) {
                        switch (i2) {
                            case 641:
                                if (a2 != 0) {
                                    return a2;
                                }
                                return 641;
                            case 642:
                                if (a2 != 0) {
                                    return a2;
                                }
                                return 642;
                            case 643:
                                if (a2 != 0) {
                                    return a2;
                                }
                                return 643;
                            default:
                                return 600;
                        }
                    } else if (a2 != 0) {
                        return a2;
                    } else {
                        return 600;
                    }
                } else if (a2 != 0) {
                    return a2;
                } else {
                    return 659;
                }
            } else if (a2 != 0) {
                return a2;
            } else {
                return 653;
            }
        } else if (a2 != 0) {
            return a2;
        } else {
            return 110;
        }
    }

    private static int a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return 110;
        }
        String message = th.getMessage();
        if (message == null) {
            return 0;
        }
        if (message.contains("ftruncate failed: ENOENT (No such file or directory)")) {
            return 641;
        }
        if (message.contains("recvfrom failed: ECONNRESET (Connection reset by peer)")) {
            return 104;
        }
        if (message.contains("connect failed: ETIMEDOUT (Connection timed out)")) {
            return 110;
        }
        if (message.contains("Connection to") && message.contains("refused")) {
            return 111;
        }
        if (message.contains("Connection reset")) {
            return 102;
        }
        if (message.contains("dns No address associated with hostname")) {
            return 659;
        }
        if (message.contains("Handshake failed")) {
            return 653;
        }
        if (message.contains("ftruncate failed: ENOENT (No such file or directory)")) {
            return 641;
        }
        return 0;
    }
}
