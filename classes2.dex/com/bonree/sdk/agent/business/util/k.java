package com.bonree.sdk.agent.business.util;

import android.content.Context;
import android.content.res.AssetManager;
import com.bonree.sdk.be.f;
import com.didi.hummer.adapter.http.IHttpAdapter;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class k {
    private static String a = "http://";
    private static String b = "https://";
    private static String c = "Br-Content-Encoding";
    private static String d = "gzip";
    private static final String e = "URLConnectionUtil";
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private int n;
    private int o;
    /* access modifiers changed from: private */
    public X509Certificate p;
    /* access modifiers changed from: private */
    public String q;
    /* access modifiers changed from: private */
    public f r;
    private HostnameVerifier s;
    private X509TrustManager t;

    /* synthetic */ k(byte b2) {
        this();
    }

    public final HostnameVerifier a() {
        return this.s;
    }

    private k() {
        this.f = IHttpAdapter.METHOD_GET;
        this.g = IHttpAdapter.METHOD_POST;
        this.h = "ProtoType";
        this.i = "json";
        this.j = "Content-Type";
        this.k = "application/json";
        this.l = "Host";
        this.m = "brkey";
        this.n = 10000;
        this.o = 10000;
        this.r = com.bonree.sdk.be.a.a();
        this.s = new l(this);
        this.t = new m(this);
        try {
            Context a2 = com.bonree.sdk.bs.a.a();
            if (a2 != null) {
                AssetManager assets = a2.getAssets();
                this.q = a((InputStream) new BufferedInputStream(assets.open("customer_hostname.dat")));
                this.p = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new BufferedInputStream(assets.open("customer_server.crt")));
            }
        } catch (IOException unused) {
        } catch (CertificateException e2) {
            this.r.a("handle customer Certificate Exception", (Throwable) e2);
        } catch (Throwable th) {
            this.r.a("handle customer Certificate Exception", th);
        }
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{this.t}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Throwable th2) {
            com.bonree.sdk.be.a.a().a(e, th2);
        }
    }

    private void c() {
        try {
            Context a2 = com.bonree.sdk.bs.a.a();
            if (a2 != null) {
                AssetManager assets = a2.getAssets();
                this.q = a((InputStream) new BufferedInputStream(assets.open("customer_hostname.dat")));
                this.p = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new BufferedInputStream(assets.open("customer_server.crt")));
            }
        } catch (IOException unused) {
        } catch (CertificateException e2) {
            this.r.a("handle customer Certificate Exception", (Throwable) e2);
        } catch (Throwable th) {
            this.r.a("handle customer Certificate Exception", th);
        }
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{this.t}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Throwable th2) {
            com.bonree.sdk.be.a.a().a(e, th2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.lang.StringBuilder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.io.InputStream r13) {
        /*
            r12 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            r3 = 3
            r4 = 0
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0043, all -> 0x003e }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r13, r6)     // Catch:{ IOException -> 0x0043, all -> 0x003e }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0033 }
            r7.<init>()     // Catch:{ IOException -> 0x0033 }
        L_0x0016:
            java.lang.String r8 = r6.readLine()     // Catch:{ IOException -> 0x0031 }
            if (r8 == 0) goto L_0x0025
            r7.append(r8)     // Catch:{ IOException -> 0x0031 }
            java.lang.String r8 = "\n"
            r7.append(r8)     // Catch:{ IOException -> 0x0031 }
            goto L_0x0016
        L_0x0025:
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r6
            r3[r1] = r5
            r3[r0] = r13
            com.bonree.sdk.bs.ad.a((java.io.Closeable[]) r3)
            goto L_0x0059
        L_0x0031:
            r8 = move-exception
            goto L_0x0047
        L_0x0033:
            r8 = move-exception
            r7 = r4
            goto L_0x0047
        L_0x0036:
            r6 = move-exception
            r11 = r6
            r6 = r4
            r4 = r11
            goto L_0x0062
        L_0x003b:
            r8 = move-exception
            r6 = r4
            goto L_0x0046
        L_0x003e:
            r5 = move-exception
            r6 = r4
            r4 = r5
            r5 = r6
            goto L_0x0062
        L_0x0043:
            r8 = move-exception
            r5 = r4
            r6 = r5
        L_0x0046:
            r7 = r6
        L_0x0047:
            com.bonree.sdk.be.f r9 = r12.r     // Catch:{ all -> 0x0061 }
            java.lang.String r10 = "InputStream parsing String Throwable "
            r9.a((java.lang.String) r10, (java.lang.Throwable) r8)     // Catch:{ all -> 0x0061 }
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r6
            r3[r1] = r5
            r3[r0] = r13
            com.bonree.sdk.bs.ad.a((java.io.Closeable[]) r3)
        L_0x0059:
            if (r7 != 0) goto L_0x005c
            return r4
        L_0x005c:
            java.lang.String r13 = r7.toString()
            return r13
        L_0x0061:
            r4 = move-exception
        L_0x0062:
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r6
            r3[r1] = r5
            r3[r0] = r13
            com.bonree.sdk.bs.ad.a((java.io.Closeable[]) r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.business.util.k.a(java.io.InputStream):java.lang.String");
    }

    public static k b() {
        return b.a;
    }

    private a a(String str, int i2) {
        if (str != null) {
            return a(false, str, (byte[]) null, (String) null, i2, (Map<String, String>) null);
        }
        f fVar = this.r;
        fVar.d("URLConnectionUtildoGet ;address is null? " + str, new Object[0]);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0234 A[SYNTHETIC, Splitter:B:123:0x0234] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x023c A[Catch:{ all -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0241 A[Catch:{ all -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0246 A[Catch:{ all -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.agent.business.util.k.a a(boolean r21, java.lang.String r22, byte[] r23, java.lang.String r24, int r25, java.util.Map<java.lang.String, java.lang.String> r26) {
        /*
            r20 = this;
            r1 = r20
            r2 = r22
            r3 = r23
            r0 = r24
            r4 = r25
            java.lang.String r5 = "gzip"
            java.lang.String r6 = "Br-Content-Encoding"
            java.lang.String r7 = "URLConnectionUtil"
            com.bonree.sdk.be.f r8 = r1.r
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]
            r11 = 0
            r10[r11] = r2
            java.lang.String r12 = "URLConnectionUtilsend url: %s"
            r8.a((java.lang.String) r12, (java.lang.Object[]) r10)
            long r12 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0200 }
            com.bonree.sdk.be.f r10 = r1.r     // Catch:{ all -> 0x0200 }
            java.lang.String r14 = "br sender start ->"
            java.lang.Object[] r15 = new java.lang.Object[r11]     // Catch:{ all -> 0x0200 }
            r10.c(r14, r15)     // Catch:{ all -> 0x0200 }
            java.lang.String r10 = "http://"
            boolean r10 = r2.startsWith(r10)     // Catch:{ all -> 0x0200 }
            r14 = r21
            java.net.URLConnection r14 = r1.a((java.lang.String) r2, (boolean) r10, (boolean) r14, (int) r4)     // Catch:{ all -> 0x01fb }
            if (r0 == 0) goto L_0x0045
            java.lang.String r15 = "brkey"
            r14.setRequestProperty(r15, r0)     // Catch:{ all -> 0x003e }
            goto L_0x0045
        L_0x003e:
            r0 = move-exception
            r6 = r7
        L_0x0040:
            r3 = 0
            r7 = 0
            r8 = 0
            goto L_0x0207
        L_0x0045:
            r14.setRequestProperty(r6, r5)     // Catch:{ all -> 0x01f5 }
            if (r26 == 0) goto L_0x007e
            int r0 = r26.size()     // Catch:{ all -> 0x0076 }
            if (r0 <= 0) goto L_0x007e
            java.util.Set r0 = r26.entrySet()     // Catch:{ all -> 0x0076 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0076 }
        L_0x0058:
            boolean r15 = r0.hasNext()     // Catch:{ all -> 0x0076 }
            if (r15 == 0) goto L_0x007e
            java.lang.Object r15 = r0.next()     // Catch:{ all -> 0x0076 }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ all -> 0x0076 }
            java.lang.Object r16 = r15.getKey()     // Catch:{ all -> 0x0076 }
            r8 = r16
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0076 }
            java.lang.Object r15 = r15.getValue()     // Catch:{ all -> 0x0076 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0076 }
            r14.setRequestProperty(r8, r15)     // Catch:{ all -> 0x0076 }
            goto L_0x0058
        L_0x0076:
            r0 = move-exception
            com.bonree.sdk.be.f r8 = r1.r     // Catch:{ all -> 0x003e }
            java.lang.String r15 = "br sender setRequestProperty error %s"
            r8.a((java.lang.String) r15, (java.lang.Throwable) r0)     // Catch:{ all -> 0x003e }
        L_0x007e:
            com.bonree.sdk.be.f r0 = r1.r     // Catch:{ all -> 0x01f5 }
            java.lang.String r8 = "br sender start connect %d ms: "
            java.lang.Object[] r15 = new java.lang.Object[r9]     // Catch:{ all -> 0x01f5 }
            long r17 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01f5 }
            long r17 = r17 - r12
            java.lang.Long r16 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x01f5 }
            r15[r11] = r16     // Catch:{ all -> 0x01f5 }
            r0.c(r8, r15)     // Catch:{ all -> 0x01f5 }
            r14.connect()     // Catch:{ all -> 0x01f5 }
            com.bonree.sdk.be.f r0 = r1.r     // Catch:{ all -> 0x01f5 }
            java.lang.String r8 = "br sender start connect successful, write datas:-> %d ms"
            java.lang.Object[] r15 = new java.lang.Object[r9]     // Catch:{ all -> 0x01f5 }
            long r17 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01f5 }
            long r17 = r17 - r12
            java.lang.Long r16 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x01f5 }
            r15[r11] = r16     // Catch:{ all -> 0x01f5 }
            r0.c(r8, r15)     // Catch:{ all -> 0x01f5 }
            if (r3 == 0) goto L_0x00b8
            java.io.OutputStream r8 = r14.getOutputStream()     // Catch:{ all -> 0x003e }
            r8.write(r3)     // Catch:{ all -> 0x00c3 }
            r8.flush()     // Catch:{ all -> 0x00c3 }
            goto L_0x00b9
        L_0x00b8:
            r8 = 0
        L_0x00b9:
            if (r10 == 0) goto L_0x00c7
            r0 = r14
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x00c3 }
            int r0 = r0.getResponseCode()     // Catch:{ all -> 0x00c3 }
            goto L_0x00ce
        L_0x00c3:
            r0 = move-exception
            r6 = r7
            goto L_0x01f2
        L_0x00c7:
            r0 = r14
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ all -> 0x01ec }
            int r0 = r0.getResponseCode()     // Catch:{ all -> 0x01ec }
        L_0x00ce:
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 == r3) goto L_0x0104
            com.bonree.sdk.be.f r3 = r1.r     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = "br sender http response code error: %d"
            java.lang.Object[] r6 = new java.lang.Object[r9]     // Catch:{ all -> 0x00c3 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00c3 }
            r6[r11] = r0     // Catch:{ all -> 0x00c3 }
            r3.e(r5, r6)     // Catch:{ all -> 0x00c3 }
            if (r8 == 0) goto L_0x00e9
            r8.close()     // Catch:{ all -> 0x00e7 }
            goto L_0x00e9
        L_0x00e7:
            r0 = move-exception
            goto L_0x00f9
        L_0x00e9:
            if (r14 == 0) goto L_0x0102
            if (r10 == 0) goto L_0x00f3
            java.net.HttpURLConnection r14 = (java.net.HttpURLConnection) r14     // Catch:{ all -> 0x00e7 }
            r14.disconnect()     // Catch:{ all -> 0x00e7 }
            goto L_0x0102
        L_0x00f3:
            javax.net.ssl.HttpsURLConnection r14 = (javax.net.ssl.HttpsURLConnection) r14     // Catch:{ all -> 0x00e7 }
            r14.disconnect()     // Catch:{ all -> 0x00e7 }
            goto L_0x0102
        L_0x00f9:
            com.bonree.sdk.be.f r2 = r1.r
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r3[r11] = r0
            r2.c(r7, r3)
        L_0x0102:
            r2 = 0
            return r2
        L_0x0104:
            com.bonree.sdk.be.f r3 = r1.r     // Catch:{ all -> 0x01ec }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ec }
            java.lang.String r9 = "br sender write successful,getInputStream:->"
            r15.<init>(r9)     // Catch:{ all -> 0x01ec }
            long r17 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01ec }
            r19 = r10
            long r9 = r17 - r12
            r15.append(r9)     // Catch:{ all -> 0x01e5 }
            java.lang.String r9 = r15.toString()     // Catch:{ all -> 0x01e5 }
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ all -> 0x01e5 }
            r3.c(r9, r10)     // Catch:{ all -> 0x01e5 }
            java.io.InputStream r3 = r14.getInputStream()     // Catch:{ all -> 0x01e5 }
            com.bonree.sdk.be.f r9 = r1.r     // Catch:{ all -> 0x01de }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01de }
            java.lang.String r15 = "br sender start readResponse:->"
            r10.<init>(r15)     // Catch:{ all -> 0x01de }
            long r17 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01de }
            r15 = r7
            r21 = r8
            long r7 = r17 - r12
            r10.append(r7)     // Catch:{ all -> 0x01d9 }
            java.lang.String r7 = r10.toString()     // Catch:{ all -> 0x01d9 }
            java.lang.Object[] r8 = new java.lang.Object[r11]     // Catch:{ all -> 0x01d9 }
            r9.c(r7, r8)     // Catch:{ all -> 0x01d9 }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x01d9 }
            r7.<init>()     // Catch:{ all -> 0x01d9 }
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x01d2 }
        L_0x014c:
            int r9 = r3.read(r8)     // Catch:{ all -> 0x01d2 }
            r10 = -1
            if (r9 == r10) goto L_0x015d
            r7.write(r8, r11, r9)     // Catch:{ all -> 0x0157 }
            goto L_0x014c
        L_0x0157:
            r0 = move-exception
            r8 = r21
            r6 = r15
            goto L_0x01d6
        L_0x015d:
            byte[] r8 = r7.toByteArray()     // Catch:{ all -> 0x01d2 }
            if (r8 == 0) goto L_0x0173
            java.lang.String r6 = r14.getHeaderField(r6)     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x0173
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x0157 }
            if (r5 == 0) goto L_0x0173
            byte[] r8 = com.bonree.sdk.bc.t.b((byte[]) r8)     // Catch:{ all -> 0x0157 }
        L_0x0173:
            com.bonree.sdk.be.f r5 = r1.r     // Catch:{ all -> 0x01d2 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            java.lang.String r9 = "br sender  readResponse end:->"
            r6.<init>(r9)     // Catch:{ all -> 0x01d2 }
            long r9 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01d2 }
            long r9 = r9 - r12
            r6.append(r9)     // Catch:{ all -> 0x01d2 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01d2 }
            java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ all -> 0x01d2 }
            r5.c(r6, r9)     // Catch:{ all -> 0x01d2 }
            com.bonree.sdk.be.f r5 = r1.r     // Catch:{ all -> 0x01d2 }
            java.lang.String r6 = "br sender  process data complete, time: %d"
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x01d2 }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01d2 }
            long r17 = r17 - r12
            java.lang.Long r9 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x01d2 }
            r10[r11] = r9     // Catch:{ all -> 0x01d2 }
            r5.c(r6, r10)     // Catch:{ all -> 0x01d2 }
            com.bonree.sdk.agent.business.util.k$a r5 = new com.bonree.sdk.agent.business.util.k$a     // Catch:{ all -> 0x01d2 }
            r5.<init>(r0, r8)     // Catch:{ all -> 0x01d2 }
            r7.close()     // Catch:{ all -> 0x01c5 }
            if (r3 == 0) goto L_0x01b0
            r3.close()     // Catch:{ all -> 0x01c5 }
        L_0x01b0:
            if (r21 == 0) goto L_0x01b5
            r21.close()     // Catch:{ all -> 0x01c5 }
        L_0x01b5:
            if (r14 == 0) goto L_0x01d1
            if (r19 == 0) goto L_0x01bf
            java.net.HttpURLConnection r14 = (java.net.HttpURLConnection) r14     // Catch:{ all -> 0x01c5 }
            r14.disconnect()     // Catch:{ all -> 0x01c5 }
            goto L_0x01d1
        L_0x01bf:
            javax.net.ssl.HttpsURLConnection r14 = (javax.net.ssl.HttpsURLConnection) r14     // Catch:{ all -> 0x01c5 }
            r14.disconnect()     // Catch:{ all -> 0x01c5 }
            goto L_0x01d1
        L_0x01c5:
            r0 = move-exception
            com.bonree.sdk.be.f r2 = r1.r
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r11] = r0
            r6 = r15
            r2.c(r6, r3)
        L_0x01d1:
            return r5
        L_0x01d2:
            r0 = move-exception
            r6 = r15
            r8 = r21
        L_0x01d6:
            r10 = r19
            goto L_0x0207
        L_0x01d9:
            r0 = move-exception
            r6 = r15
            r8 = r21
            goto L_0x01e2
        L_0x01de:
            r0 = move-exception
            r6 = r7
            r21 = r8
        L_0x01e2:
            r10 = r19
            goto L_0x01f3
        L_0x01e5:
            r0 = move-exception
            r6 = r7
            r21 = r8
            r10 = r19
            goto L_0x01f2
        L_0x01ec:
            r0 = move-exception
            r6 = r7
            r21 = r8
            r19 = r10
        L_0x01f2:
            r3 = 0
        L_0x01f3:
            r7 = 0
            goto L_0x0207
        L_0x01f5:
            r0 = move-exception
            r6 = r7
            r19 = r10
            goto L_0x0040
        L_0x01fb:
            r0 = move-exception
            r6 = r7
            r19 = r10
            goto L_0x0203
        L_0x0200:
            r0 = move-exception
            r6 = r7
            r10 = r11
        L_0x0203:
            r3 = 0
            r7 = 0
            r8 = 0
            r14 = 0
        L_0x0207:
            com.bonree.sdk.be.f r5 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0260 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
            java.lang.String r12 = "URLConnectionUtil URL: "
            r9.<init>(r12)     // Catch:{ all -> 0x0260 }
            r9.append(r2)     // Catch:{ all -> 0x0260 }
            java.lang.String r2 = "    timeOut:"
            r9.append(r2)     // Catch:{ all -> 0x0260 }
            r9.append(r4)     // Catch:{ all -> 0x0260 }
            java.lang.String r2 = "\r\n"
            r9.append(r2)     // Catch:{ all -> 0x0260 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0260 }
            r9.append(r0)     // Catch:{ all -> 0x0260 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0260 }
            java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ all -> 0x0260 }
            r5.e(r0, r2)     // Catch:{ all -> 0x0260 }
            if (r7 == 0) goto L_0x023a
            r7.close()     // Catch:{ all -> 0x0238 }
            goto L_0x023a
        L_0x0238:
            r0 = move-exception
            goto L_0x0254
        L_0x023a:
            if (r3 == 0) goto L_0x023f
            r3.close()     // Catch:{ all -> 0x0238 }
        L_0x023f:
            if (r8 == 0) goto L_0x0244
            r8.close()     // Catch:{ all -> 0x0238 }
        L_0x0244:
            if (r14 == 0) goto L_0x025e
            if (r10 == 0) goto L_0x024e
            java.net.HttpURLConnection r14 = (java.net.HttpURLConnection) r14     // Catch:{ all -> 0x0238 }
            r14.disconnect()     // Catch:{ all -> 0x0238 }
            goto L_0x025e
        L_0x024e:
            javax.net.ssl.HttpsURLConnection r14 = (javax.net.ssl.HttpsURLConnection) r14     // Catch:{ all -> 0x0238 }
            r14.disconnect()     // Catch:{ all -> 0x0238 }
            goto L_0x025e
        L_0x0254:
            com.bonree.sdk.be.f r2 = r1.r
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r11] = r0
            r2.c(r6, r3)
        L_0x025e:
            r2 = 0
            return r2
        L_0x0260:
            r0 = move-exception
            r2 = r0
            if (r7 == 0) goto L_0x026a
            r7.close()     // Catch:{ all -> 0x0268 }
            goto L_0x026a
        L_0x0268:
            r0 = move-exception
            goto L_0x0284
        L_0x026a:
            if (r3 == 0) goto L_0x026f
            r3.close()     // Catch:{ all -> 0x0268 }
        L_0x026f:
            if (r8 == 0) goto L_0x0274
            r8.close()     // Catch:{ all -> 0x0268 }
        L_0x0274:
            if (r14 == 0) goto L_0x028e
            if (r10 == 0) goto L_0x027e
            java.net.HttpURLConnection r14 = (java.net.HttpURLConnection) r14     // Catch:{ all -> 0x0268 }
            r14.disconnect()     // Catch:{ all -> 0x0268 }
            goto L_0x028e
        L_0x027e:
            javax.net.ssl.HttpsURLConnection r14 = (javax.net.ssl.HttpsURLConnection) r14     // Catch:{ all -> 0x0268 }
            r14.disconnect()     // Catch:{ all -> 0x0268 }
            goto L_0x028e
        L_0x0284:
            com.bonree.sdk.be.f r3 = r1.r
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r11] = r0
            r3.c(r6, r4)
        L_0x028e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.business.util.k.a(boolean, java.lang.String, byte[], java.lang.String, int, java.util.Map):com.bonree.sdk.agent.business.util.k$a");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|(3:9|10|(2:12|(2:15|13)))|16|17|18|19|(3:20|21|(2:23|24)(1:26))|27|(3:29|30|31)(3:32|33|34)|35|(2:(2:38|39)|(1:(2:44|150)(2:45|151))(1:149))(20:47|48|49|50|51|52|53|54|55|56|(2:57|(1:59)(1:147))|60|(1:66)|67|68|69|(1:71)|(1:73)|(1:(1:76)(1:77))|80)) */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01f8, code lost:
        r1.r.c(e, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0204, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0205, code lost:
        r12 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0242, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0246, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x024b, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0250, code lost:
        if (r7 != false) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0252, code lost:
        ((java.net.HttpURLConnection) r11).disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0258, code lost:
        ((javax.net.ssl.HttpsURLConnection) r11).disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x025e, code lost:
        r1.r.c(e, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x023e A[SYNTHETIC, Splitter:B:117:0x023e] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0246 A[Catch:{ all -> 0x0242 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x024b A[Catch:{ all -> 0x0242 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0250 A[Catch:{ all -> 0x0242 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a6 A[SYNTHETIC, Splitter:B:23:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad A[EDGE_INSN: B:26:0x00ad->B:27:? ?: BREAK  , SYNTHETIC, Splitter:B:26:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb A[SYNTHETIC, Splitter:B:47:0x00eb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bonree.sdk.agent.business.util.k.a a(boolean r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, java.util.Map<java.lang.String, java.lang.String> r24) {
        /*
            r18 = this;
            r1 = r18
            r2 = r20
            java.lang.String r0 = "gzip"
            java.lang.String r3 = "Br-Content-Encoding"
            java.lang.String r4 = "URLConnectionUtil"
            com.bonree.sdk.be.f r5 = r1.r
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r8 = 0
            r7[r8] = r2
            java.lang.String r9 = "URLConnectionUtilsend url: %s"
            r5.a((java.lang.String) r9, (java.lang.Object[]) r7)
            long r9 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x020e }
            com.bonree.sdk.be.f r7 = r1.r     // Catch:{ all -> 0x020e }
            java.lang.String r11 = "br sender start ->"
            java.lang.Object[] r12 = new java.lang.Object[r8]     // Catch:{ all -> 0x020e }
            r7.c(r11, r12)     // Catch:{ all -> 0x020e }
            java.lang.String r7 = "http://"
            boolean r7 = r2.startsWith(r7)     // Catch:{ all -> 0x020e }
            r11 = 60000(0xea60, float:8.4078E-41)
            java.net.URLConnection r11 = r1.a((java.lang.String) r2, (boolean) r7, (boolean) r6, (int) r11)     // Catch:{ all -> 0x020c }
            r11.setRequestProperty(r3, r0)     // Catch:{ all -> 0x0208 }
            if (r24 == 0) goto L_0x0060
            int r12 = r24.size()     // Catch:{ all -> 0x0060 }
            if (r12 <= 0) goto L_0x0060
            java.util.Set r12 = r24.entrySet()     // Catch:{ all -> 0x0060 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x0060 }
        L_0x0044:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0060 }
            if (r13 == 0) goto L_0x0060
            java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x0060 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ all -> 0x0060 }
            java.lang.Object r14 = r13.getKey()     // Catch:{ all -> 0x0060 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x0060 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ all -> 0x0060 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0060 }
            r11.setRequestProperty(r14, r13)     // Catch:{ all -> 0x0060 }
            goto L_0x0044
        L_0x0060:
            com.bonree.sdk.be.f r12 = r1.r     // Catch:{ all -> 0x0208 }
            java.lang.String r13 = "br sender start connect %d ms: "
            java.lang.Object[] r14 = new java.lang.Object[r6]     // Catch:{ all -> 0x0208 }
            long r15 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0208 }
            long r15 = r15 - r9
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0208 }
            r14[r8] = r15     // Catch:{ all -> 0x0208 }
            r12.c(r13, r14)     // Catch:{ all -> 0x0208 }
            r11.connect()     // Catch:{ all -> 0x0208 }
            com.bonree.sdk.be.f r12 = r1.r     // Catch:{ all -> 0x0208 }
            java.lang.String r13 = "br sender start connect successful, write datas:-> %d ms"
            java.lang.Object[] r14 = new java.lang.Object[r6]     // Catch:{ all -> 0x0208 }
            long r15 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0208 }
            long r15 = r15 - r9
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0208 }
            r14[r8] = r15     // Catch:{ all -> 0x0208 }
            r12.c(r13, r14)     // Catch:{ all -> 0x0208 }
            java.io.OutputStream r12 = r11.getOutputStream()     // Catch:{ all -> 0x0208 }
            java.io.File r13 = new java.io.File     // Catch:{ IOException -> 0x01c4 }
            r14 = r21
            r13.<init>(r14)     // Catch:{ IOException -> 0x01c4 }
            java.io.FileInputStream r14 = new java.io.FileInputStream     // Catch:{ IOException -> 0x01c4 }
            r14.<init>(r13)     // Catch:{ IOException -> 0x01c4 }
            r13 = 10240(0x2800, float:1.4349E-41)
            byte[] r13 = new byte[r13]     // Catch:{ IOException -> 0x01c4 }
        L_0x009f:
            int r15 = r14.read(r13)     // Catch:{ IOException -> 0x01c4 }
            r5 = -1
            if (r15 == r5) goto L_0x00ad
            r12.write(r13, r8, r15)     // Catch:{ IOException -> 0x01c4 }
            goto L_0x009f
        L_0x00aa:
            r0 = move-exception
            goto L_0x01c1
        L_0x00ad:
            r14.close()     // Catch:{ IOException -> 0x01c4 }
            r12.flush()     // Catch:{ IOException -> 0x01c4 }
            if (r7 == 0) goto L_0x00bd
            r13 = r11
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ all -> 0x00aa }
            int r13 = r13.getResponseCode()     // Catch:{ all -> 0x00aa }
            goto L_0x00c4
        L_0x00bd:
            r13 = r11
            javax.net.ssl.HttpsURLConnection r13 = (javax.net.ssl.HttpsURLConnection) r13     // Catch:{ all -> 0x01be }
            int r13 = r13.getResponseCode()     // Catch:{ all -> 0x01be }
        L_0x00c4:
            r14 = 200(0xc8, float:2.8E-43)
            if (r13 == r14) goto L_0x00eb
            if (r12 == 0) goto L_0x00d0
            r12.close()     // Catch:{ all -> 0x00ce }
            goto L_0x00d0
        L_0x00ce:
            r0 = move-exception
            goto L_0x00e0
        L_0x00d0:
            if (r11 == 0) goto L_0x00e9
            if (r7 == 0) goto L_0x00da
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x00ce }
            r11.disconnect()     // Catch:{ all -> 0x00ce }
            goto L_0x00e9
        L_0x00da:
            javax.net.ssl.HttpsURLConnection r11 = (javax.net.ssl.HttpsURLConnection) r11     // Catch:{ all -> 0x00ce }
            r11.disconnect()     // Catch:{ all -> 0x00ce }
            goto L_0x00e9
        L_0x00e0:
            com.bonree.sdk.be.f r2 = r1.r
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r3[r8] = r0
            r2.c(r4, r3)
        L_0x00e9:
            r2 = 0
            return r2
        L_0x00eb:
            com.bonree.sdk.be.f r14 = r1.r     // Catch:{ all -> 0x01be }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x01be }
            java.lang.String r6 = "br sender write successful,getInputStream:->"
            r15.<init>(r6)     // Catch:{ all -> 0x01be }
            long r16 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01be }
            long r5 = r16 - r9
            r15.append(r5)     // Catch:{ all -> 0x01be }
            java.lang.String r5 = r15.toString()     // Catch:{ all -> 0x01be }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x01be }
            r14.c(r5, r6)     // Catch:{ all -> 0x01be }
            java.io.InputStream r5 = r11.getInputStream()     // Catch:{ all -> 0x01be }
            com.bonree.sdk.be.f r6 = r1.r     // Catch:{ all -> 0x01ba }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ba }
            java.lang.String r15 = "br sender start readResponse:->"
            r14.<init>(r15)     // Catch:{ all -> 0x01ba }
            long r15 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01ba }
            r23 = r12
            r17 = r13
            long r12 = r15 - r9
            r14.append(r12)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x01b6 }
            java.lang.Object[] r13 = new java.lang.Object[r8]     // Catch:{ all -> 0x01b6 }
            r6.c(r12, r13)     // Catch:{ all -> 0x01b6 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x01b6 }
            r6.<init>()     // Catch:{ all -> 0x01b6 }
            r12 = 1024(0x400, float:1.435E-42)
            byte[] r12 = new byte[r12]     // Catch:{ all -> 0x01b2 }
        L_0x0132:
            int r13 = r5.read(r12)     // Catch:{ all -> 0x01b2 }
            r14 = -1
            if (r13 == r14) goto L_0x013d
            r6.write(r12, r8, r13)     // Catch:{ all -> 0x01b2 }
            goto L_0x0132
        L_0x013d:
            byte[] r12 = r6.toByteArray()     // Catch:{ all -> 0x01b2 }
            if (r12 == 0) goto L_0x0153
            java.lang.String r3 = r11.getHeaderField(r3)     // Catch:{ all -> 0x01b2 }
            if (r3 == 0) goto L_0x0153
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x01b2 }
            if (r0 == 0) goto L_0x0153
            byte[] r12 = com.bonree.sdk.bc.t.b((byte[]) r12)     // Catch:{ all -> 0x01b2 }
        L_0x0153:
            com.bonree.sdk.be.f r0 = r1.r     // Catch:{ all -> 0x01b2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b2 }
            java.lang.String r13 = "br sender  readResponse end:->"
            r3.<init>(r13)     // Catch:{ all -> 0x01b2 }
            long r13 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x01b2 }
            long r13 = r13 - r9
            r3.append(r13)     // Catch:{ all -> 0x01b2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01b2 }
            java.lang.Object[] r13 = new java.lang.Object[r8]     // Catch:{ all -> 0x01b2 }
            r0.c(r3, r13)     // Catch:{ all -> 0x01b2 }
            com.bonree.sdk.be.f r0 = r1.r     // Catch:{ all -> 0x01b2 }
            java.lang.String r3 = "br sender  process data complete, time: %d"
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]     // Catch:{ all -> 0x01b2 }
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01b2 }
            long r15 = r15 - r9
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x01b2 }
            r14[r8] = r9     // Catch:{ all -> 0x01b2 }
            r0.c(r3, r14)     // Catch:{ all -> 0x01b2 }
            com.bonree.sdk.agent.business.util.k$a r3 = new com.bonree.sdk.agent.business.util.k$a     // Catch:{ all -> 0x01b2 }
            r13 = r17
            r3.<init>(r13, r12)     // Catch:{ all -> 0x01b2 }
            r6.close()     // Catch:{ all -> 0x01a6 }
            if (r5 == 0) goto L_0x0191
            r5.close()     // Catch:{ all -> 0x01a6 }
        L_0x0191:
            if (r23 == 0) goto L_0x0196
            r23.close()     // Catch:{ all -> 0x01a6 }
        L_0x0196:
            if (r11 == 0) goto L_0x01b1
            if (r7 == 0) goto L_0x01a0
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x01a6 }
            r11.disconnect()     // Catch:{ all -> 0x01a6 }
            goto L_0x01b1
        L_0x01a0:
            javax.net.ssl.HttpsURLConnection r11 = (javax.net.ssl.HttpsURLConnection) r11     // Catch:{ all -> 0x01a6 }
            r11.disconnect()     // Catch:{ all -> 0x01a6 }
            goto L_0x01b1
        L_0x01a6:
            r0 = move-exception
            com.bonree.sdk.be.f r2 = r1.r
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            r2.c(r4, r5)
        L_0x01b1:
            return r3
        L_0x01b2:
            r0 = move-exception
            r12 = r23
            goto L_0x0214
        L_0x01b6:
            r0 = move-exception
            r12 = r23
            goto L_0x01c2
        L_0x01ba:
            r0 = move-exception
            r23 = r12
            goto L_0x01c2
        L_0x01be:
            r0 = move-exception
            r23 = r12
        L_0x01c1:
            r5 = 0
        L_0x01c2:
            r6 = 0
            goto L_0x0214
        L_0x01c4:
            r0 = move-exception
            r23 = r12
            com.bonree.sdk.be.f r3 = r1.r     // Catch:{ all -> 0x0204 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
            java.lang.String r6 = "URLConnectionUtil doFile upload error:"
            r5.<init>(r6)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0204 }
            r5.append(r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0204 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0204 }
            r3.e(r0, r5)     // Catch:{ all -> 0x0204 }
            if (r23 == 0) goto L_0x01e8
            r23.close()     // Catch:{ all -> 0x01e6 }
            goto L_0x01e8
        L_0x01e6:
            r0 = move-exception
            goto L_0x01f8
        L_0x01e8:
            if (r11 == 0) goto L_0x0202
            if (r7 == 0) goto L_0x01f2
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x01e6 }
            r11.disconnect()     // Catch:{ all -> 0x01e6 }
            goto L_0x0202
        L_0x01f2:
            javax.net.ssl.HttpsURLConnection r11 = (javax.net.ssl.HttpsURLConnection) r11     // Catch:{ all -> 0x01e6 }
            r11.disconnect()     // Catch:{ all -> 0x01e6 }
            goto L_0x0202
        L_0x01f8:
            com.bonree.sdk.be.f r2 = r1.r
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r8] = r0
            r2.c(r4, r3)
        L_0x0202:
            r2 = 0
            return r2
        L_0x0204:
            r0 = move-exception
            r12 = r23
            goto L_0x01c1
        L_0x0208:
            r0 = move-exception
            r5 = 0
            r6 = 0
            goto L_0x0213
        L_0x020c:
            r0 = move-exception
            goto L_0x0210
        L_0x020e:
            r0 = move-exception
            r7 = r8
        L_0x0210:
            r5 = 0
            r6 = 0
            r11 = 0
        L_0x0213:
            r12 = 0
        L_0x0214:
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x026a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x026a }
            java.lang.String r10 = "URLConnectionUtil URL: "
            r9.<init>(r10)     // Catch:{ all -> 0x026a }
            r9.append(r2)     // Catch:{ all -> 0x026a }
            java.lang.String r2 = "    timeOut:60000"
            r9.append(r2)     // Catch:{ all -> 0x026a }
            java.lang.String r2 = "\r\n"
            r9.append(r2)     // Catch:{ all -> 0x026a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x026a }
            r9.append(r0)     // Catch:{ all -> 0x026a }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x026a }
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x026a }
            r3.e(r0, r2)     // Catch:{ all -> 0x026a }
            if (r6 == 0) goto L_0x0244
            r6.close()     // Catch:{ all -> 0x0242 }
            goto L_0x0244
        L_0x0242:
            r0 = move-exception
            goto L_0x025e
        L_0x0244:
            if (r5 == 0) goto L_0x0249
            r5.close()     // Catch:{ all -> 0x0242 }
        L_0x0249:
            if (r12 == 0) goto L_0x024e
            r12.close()     // Catch:{ all -> 0x0242 }
        L_0x024e:
            if (r11 == 0) goto L_0x0268
            if (r7 == 0) goto L_0x0258
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x0242 }
            r11.disconnect()     // Catch:{ all -> 0x0242 }
            goto L_0x0268
        L_0x0258:
            javax.net.ssl.HttpsURLConnection r11 = (javax.net.ssl.HttpsURLConnection) r11     // Catch:{ all -> 0x0242 }
            r11.disconnect()     // Catch:{ all -> 0x0242 }
            goto L_0x0268
        L_0x025e:
            com.bonree.sdk.be.f r2 = r1.r
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r8] = r0
            r2.c(r4, r3)
        L_0x0268:
            r2 = 0
            return r2
        L_0x026a:
            r0 = move-exception
            r2 = r0
            if (r6 == 0) goto L_0x0274
            r6.close()     // Catch:{ all -> 0x0272 }
            goto L_0x0274
        L_0x0272:
            r0 = move-exception
            goto L_0x028e
        L_0x0274:
            if (r5 == 0) goto L_0x0279
            r5.close()     // Catch:{ all -> 0x0272 }
        L_0x0279:
            if (r12 == 0) goto L_0x027e
            r12.close()     // Catch:{ all -> 0x0272 }
        L_0x027e:
            if (r11 == 0) goto L_0x0298
            if (r7 == 0) goto L_0x0288
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x0272 }
            r11.disconnect()     // Catch:{ all -> 0x0272 }
            goto L_0x0298
        L_0x0288:
            javax.net.ssl.HttpsURLConnection r11 = (javax.net.ssl.HttpsURLConnection) r11     // Catch:{ all -> 0x0272 }
            r11.disconnect()     // Catch:{ all -> 0x0272 }
            goto L_0x0298
        L_0x028e:
            com.bonree.sdk.be.f r3 = r1.r
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            r3.c(r4, r5)
        L_0x0298:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.business.util.k.a(boolean, java.lang.String, java.lang.String, java.lang.String, int, java.util.Map):com.bonree.sdk.agent.business.util.k$a");
    }

    private URLConnection a(String str, boolean z, boolean z2, int i2) {
        URLConnection uRLConnection = null;
        try {
            URL url = new URL(str);
            uRLConnection = new URLConnectionOpen().getURLConnectionOpen(url);
            String str2 = IHttpAdapter.METHOD_POST;
            if (!z2) {
                str2 = IHttpAdapter.METHOD_GET;
            } else {
                uRLConnection.setDoInput(true);
                uRLConnection.setDoOutput(true);
            }
            if (z) {
                ((HttpURLConnection) uRLConnection).setRequestMethod(str2);
            } else {
                ((HttpsURLConnection) uRLConnection).setHostnameVerifier(this.s);
                ((HttpsURLConnection) uRLConnection).setRequestMethod(str2);
            }
            uRLConnection.setRequestProperty("ProtoType", "json");
            uRLConnection.setRequestProperty("Content-Type", "application/json");
            uRLConnection.setRequestProperty("Host", url.getHost());
            uRLConnection.setConnectTimeout(i2);
            uRLConnection.setReadTimeout(i2);
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a(e, th);
        }
        return uRLConnection;
    }

    public final a a(byte[] bArr, String str, String str2, int i2) {
        if (bArr != null && str != null) {
            return a(true, str, bArr, (String) null, 30000, (Map<String, String>) null);
        }
        f fVar = this.r;
        fVar.d("URLConnectionUtildoPost datas is null ? " + bArr + " ;address is null? " + str, new Object[0]);
        return null;
    }

    public final a b(byte[] bArr, String str, String str2, int i2) {
        if (bArr == null || str == null) {
            f fVar = this.r;
            fVar.d("URLConnectionUtildoPost datas is null ? " + bArr + " ;address is null? " + str, new Object[0]);
            return null;
        }
        return a(true, str, bArr, str2, i2, com.bonree.sdk.d.a.k().ab());
    }

    private boolean d() {
        return (this.p == null || this.q == null) ? false : true;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final k a = new k((byte) 0);

        private b() {
        }
    }

    public static class a {
        public byte[] a;
        private int b;

        public a() {
        }

        public a(int i, byte[] bArr) {
            this.b = i;
            this.a = bArr;
        }

        public final String toString() {
            return "HttpResult{responseCode=" + this.b + ", responseEntity=" + Arrays.toString(this.a) + '}';
        }
    }

    static /* synthetic */ boolean a(k kVar) {
        return (kVar.p == null || kVar.q == null) ? false : true;
    }
}
