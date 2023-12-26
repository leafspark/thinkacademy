package com.igexin.push.f.a;

import android.os.Process;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.b;
import com.igexin.b.a.d.e;
import com.igexin.push.config.l;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.net.HttpURLConnection;

public class a extends e {
    public static final String a = "com.igexin.push.f.a.a";
    public b b;
    private HttpURLConnection c;

    public a(b bVar) {
        super(0);
        this.b = bVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:(2:22|23)|49|50|51|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|(2:9|(1:11)(1:54))|12|(2:14|15)|16|17|18|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0086, code lost:
        if (r1 == null) goto L_0x008b;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0088 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073 A[SYNTHETIC, Splitter:B:32:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078 A[SYNTHETIC, Splitter:B:36:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083 A[SYNTHETIC, Splitter:B:45:0x0083] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            r1.<init>(r7)     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.net.URLConnection r7 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r7)     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            r6.c = r7     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r7.setConnectTimeout(r1)     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.net.HttpURLConnection r7 = r6.c     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            r7.setReadTimeout(r1)     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.net.HttpURLConnection r7 = r6.c     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.lang.String r1 = "GET"
            r7.setRequestMethod(r1)     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.net.HttpURLConnection r7 = r6.c     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            r1 = 1
            r7.setDoInput(r1)     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.net.HttpURLConnection r7 = r6.c     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x007f, all -> 0x006d }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x006b, all -> 0x0066 }
            r1.<init>()     // Catch:{ Exception -> 0x006b, all -> 0x0066 }
            java.net.HttpURLConnection r2 = r6.c     // Catch:{ Exception -> 0x0081, all -> 0x0064 }
            int r2 = r2.getResponseCode()     // Catch:{ Exception -> 0x0081, all -> 0x0064 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L_0x005e
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0081, all -> 0x0064 }
        L_0x0042:
            int r3 = r7.read(r2)     // Catch:{ Exception -> 0x0081, all -> 0x0064 }
            r4 = -1
            if (r3 == r4) goto L_0x004e
            r4 = 0
            r1.write(r2, r4, r3)     // Catch:{ Exception -> 0x0081, all -> 0x0064 }
            goto L_0x0042
        L_0x004e:
            byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x0081, all -> 0x0064 }
            if (r7 == 0) goto L_0x0057
            r7.close()     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            r1.close()     // Catch:{ Exception -> 0x005a }
        L_0x005a:
            r6.i()
            return r0
        L_0x005e:
            if (r7 == 0) goto L_0x0088
            r7.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x0088
        L_0x0064:
            r0 = move-exception
            goto L_0x0071
        L_0x0066:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0071
        L_0x006b:
            r1 = r0
            goto L_0x0081
        L_0x006d:
            r7 = move-exception
            r1 = r0
            r0 = r7
            r7 = r1
        L_0x0071:
            if (r7 == 0) goto L_0x0076
            r7.close()     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            if (r1 == 0) goto L_0x007b
            r1.close()     // Catch:{ Exception -> 0x007b }
        L_0x007b:
            r6.i()
            throw r0
        L_0x007f:
            r7 = r0
            r1 = r7
        L_0x0081:
            if (r7 == 0) goto L_0x0086
            r7.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            if (r1 == 0) goto L_0x008b
        L_0x0088:
            r1.close()     // Catch:{ Exception -> 0x008b }
        L_0x008b:
            r6.i()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.a.a(java.lang.String):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:10|11|(2:12|(1:14)(1:72))|15|(2:16|17)|(2:20|21)|22|23|24|26) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0089 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab A[SYNTHETIC, Splitter:B:41:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b0 A[SYNTHETIC, Splitter:B:45:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b5 A[SYNTHETIC, Splitter:B:49:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c1 A[SYNTHETIC, Splitter:B:59:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c6 A[SYNTHETIC, Splitter:B:63:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cb A[SYNTHETIC, Splitter:B:67:0x00cb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r8, byte[] r9) {
        /*
            r7 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.URLConnection r8 = r1.openConnection()     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.URLConnection r8 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r8)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r7.c = r8     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r1 = 1
            r8.setDoInput(r1)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r8.setDoOutput(r1)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.lang.String r2 = "POST"
            r8.setRequestMethod(r2)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r2 = 0
            r8.setUseCaches(r2)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r8.setInstanceFollowRedirects(r1)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.lang.String r1 = "Content-Type"
            java.lang.String r3 = "application/octet-stream"
            r8.setRequestProperty(r1, r3)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r8.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r8.setReadTimeout(r1)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r8.connect()     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.net.HttpURLConnection r1 = r7.c     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            java.io.OutputStream r1 = r1.getOutputStream()     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x00bc, all -> 0x00a4 }
            int r1 = r9.length     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            r8.write(r9, r2, r1)     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            r8.flush()     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            java.net.HttpURLConnection r9 = r7.c     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            int r9 = r9.getResponseCode()     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            r1 = 200(0xc8, float:2.8E-43)
            if (r9 != r1) goto L_0x0099
            java.net.HttpURLConnection r9 = r7.c     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0097, all -> 0x0092 }
            r1.<init>()     // Catch:{ Exception -> 0x0097, all -> 0x0092 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x00bf, all -> 0x0090 }
        L_0x0072:
            int r4 = r9.read(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x0090 }
            r5 = -1
            if (r4 == r5) goto L_0x007d
            r1.write(r3, r2, r4)     // Catch:{ Exception -> 0x00bf, all -> 0x0090 }
            goto L_0x0072
        L_0x007d:
            byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x00bf, all -> 0x0090 }
            r8.close()     // Catch:{ Exception -> 0x0084 }
        L_0x0084:
            if (r9 == 0) goto L_0x0089
            r9.close()     // Catch:{ Exception -> 0x0089 }
        L_0x0089:
            r1.close()     // Catch:{ Exception -> 0x008c }
        L_0x008c:
            r7.i()
            return r0
        L_0x0090:
            r0 = move-exception
            goto L_0x00a9
        L_0x0092:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00a9
        L_0x0097:
            r1 = r0
            goto L_0x00bf
        L_0x0099:
            r8.close()     // Catch:{ Exception -> 0x00ce }
            goto L_0x00ce
        L_0x009d:
            r9 = move-exception
            r1 = r0
            r0 = r9
            r9 = r1
            goto L_0x00a9
        L_0x00a2:
            r9 = r0
            goto L_0x00be
        L_0x00a4:
            r8 = move-exception
            r9 = r0
            r1 = r9
            r0 = r8
            r8 = r1
        L_0x00a9:
            if (r8 == 0) goto L_0x00ae
            r8.close()     // Catch:{ Exception -> 0x00ae }
        L_0x00ae:
            if (r9 == 0) goto L_0x00b3
            r9.close()     // Catch:{ Exception -> 0x00b3 }
        L_0x00b3:
            if (r1 == 0) goto L_0x00b8
            r1.close()     // Catch:{ Exception -> 0x00b8 }
        L_0x00b8:
            r7.i()
            throw r0
        L_0x00bc:
            r8 = r0
            r9 = r8
        L_0x00be:
            r1 = r9
        L_0x00bf:
            if (r8 == 0) goto L_0x00c4
            r8.close()     // Catch:{ Exception -> 0x00c4 }
        L_0x00c4:
            if (r9 == 0) goto L_0x00c9
            r9.close()     // Catch:{ Exception -> 0x00c9 }
        L_0x00c9:
            if (r1 == 0) goto L_0x00ce
            r1.close()     // Catch:{ Exception -> 0x00ce }
        L_0x00ce:
            r7.i()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.a.a(java.lang.String, byte[]):byte[]");
    }

    private void i() {
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.c = null;
            } catch (Exception unused) {
            }
        }
    }

    public final void b() {
        super.b();
        Process.setThreadPriority(10);
        b bVar = this.b;
        if (bVar == null || bVar.c == null || (this.b.d != null && this.b.d.length > l.w * PictureFileUtils.KB)) {
            p();
            b.a(a + "|run return ###", new Object[0]);
            return;
        }
        try {
            byte[] a2 = this.b.d == null ? a(this.b.c) : a(this.b.c, this.b.d);
            if (a2 != null) {
                try {
                    this.b.a(a2);
                    c.b().a((Object) this.b);
                    c.b().c();
                } catch (Exception e) {
                    this.b.a(e);
                    throw e;
                }
            } else {
                Exception exc = new Exception("Http response ＝＝ null");
                this.b.a(exc);
                throw exc;
            }
        } catch (Exception e2) {
            this.b.a(e2);
            throw e2;
        }
    }

    public final int b_() {
        return -2147483639;
    }

    public void d() {
        this.m = true;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    public void f() {
        super.f();
        i();
    }
}
