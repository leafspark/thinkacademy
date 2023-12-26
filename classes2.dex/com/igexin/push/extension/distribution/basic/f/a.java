package com.igexin.push.extension.distribution.basic.f;

import android.os.Process;
import com.amazonaws.services.s3.util.Mimetypes;
import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import com.didi.hummer.adapter.http.IHttpAdapter;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.b;
import com.igexin.b.a.d.e;
import com.igexin.push.extension.distribution.basic.g.h;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

public class a extends e {
    public d a;
    public HttpURLConnection b;
    public boolean c;
    private boolean d;

    public a(d dVar) {
        super(0);
        this.a = dVar;
        b.a("AsyncHttpTask|httpPlugin = " + dVar, new Object[0]);
    }

    private b a(String str) {
        try {
            HttpURLConnection b2 = b(str);
            this.b = b2;
            byte[] a2 = a(b2);
            if (a2 != null) {
                b b3 = b(this.b, a2);
                i();
                return b3;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            i();
            throw th;
        }
        i();
        return new b(this, false, (byte[]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d7, code lost:
        if (r6 == null) goto L_0x00dc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e9 A[SYNTHETIC, Splitter:B:42:0x00e9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.push.extension.distribution.basic.f.b a(java.lang.String r5, byte[] r6) {
        /*
            r4 = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "AsyncHttpTask|call httpPost start ###"
            com.igexin.b.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r1)
            r1 = 0
            boolean r2 = r4.b((byte[]) r6)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            if (r2 == 0) goto L_0x0018
            com.igexin.push.extension.distribution.basic.f.b r5 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r5.<init>(r4, r0, r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r4.i()
            return r5
        L_0x0018:
            java.net.HttpURLConnection r5 = r4.b((java.lang.String) r5, (byte[]) r6)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r4.b = r5     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r5.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r2 = "AsyncHttpTask|httpPost() src body len = "
            r5.append(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            int r2 = r6.length     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r5.append(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.net.HttpURLConnection r5 = r4.b     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            byte[] r5 = r4.a((byte[]) r6, (java.net.HttpURLConnection) r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            if (r5 != 0) goto L_0x004e
            java.lang.String r5 = "AsyncHttpTask|httpPost() getEncHttpData body = null"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            com.igexin.push.extension.distribution.basic.f.b r5 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r6 = 1
            r5.<init>(r4, r6, r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r4.i()
            return r5
        L_0x004e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r6.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r2 = "AsyncHttpTask|httpPost() getEncHttpData len = "
            r6.append(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            int r2 = r5.length     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r6.append(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            com.igexin.b.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.net.HttpURLConnection r6 = r4.b     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r6.connect()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.net.HttpURLConnection r2 = r4.b     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            java.io.OutputStream r2 = r2.getOutputStream()     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00b9 }
            int r2 = r5.length     // Catch:{ Exception -> 0x00b7 }
            r6.write(r5, r0, r2)     // Catch:{ Exception -> 0x00b7 }
            r6.flush()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r5 = "AsyncHttpTask|httpPost() write and flush"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00b7 }
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x00b7 }
            java.net.HttpURLConnection r5 = r4.b     // Catch:{ Exception -> 0x00b7 }
            byte[] r5 = r4.a((java.net.HttpURLConnection) r5)     // Catch:{ Exception -> 0x00b7 }
            if (r5 == 0) goto L_0x00af
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r2.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = "AsyncHttpTask|httpPost() server resp len ="
            r2.append(r3)     // Catch:{ Exception -> 0x00b7 }
            int r3 = r5.length     // Catch:{ Exception -> 0x00b7 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b7 }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00b7 }
            com.igexin.b.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x00b7 }
            java.net.HttpURLConnection r2 = r4.b     // Catch:{ Exception -> 0x00b7 }
            com.igexin.push.extension.distribution.basic.f.b r5 = r4.b((java.net.HttpURLConnection) r2, (byte[]) r5)     // Catch:{ Exception -> 0x00b7 }
            r6.close()     // Catch:{ Exception -> 0x00ab }
        L_0x00ab:
            r4.i()
            return r5
        L_0x00af:
            java.lang.String r5 = "AsyncHttpTask|httpPost() server resp is null"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x00b7 }
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00d9
        L_0x00b7:
            r5 = move-exception
            goto L_0x00bd
        L_0x00b9:
            r5 = move-exception
            goto L_0x00e7
        L_0x00bb:
            r5 = move-exception
            r6 = r1
        L_0x00bd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r2.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = "AsyncHttpTask httpPost|error|"
            r2.append(r3)     // Catch:{ all -> 0x00e5 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x00e5 }
            r2.append(r5)     // Catch:{ all -> 0x00e5 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x00e5 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x00e5 }
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ all -> 0x00e5 }
            if (r6 == 0) goto L_0x00dc
        L_0x00d9:
            r6.close()     // Catch:{ Exception -> 0x00dc }
        L_0x00dc:
            r4.i()
            com.igexin.push.extension.distribution.basic.f.b r5 = new com.igexin.push.extension.distribution.basic.f.b
            r5.<init>(r4, r0, r1)
            return r5
        L_0x00e5:
            r5 = move-exception
            r1 = r6
        L_0x00e7:
            if (r1 == 0) goto L_0x00ec
            r1.close()     // Catch:{ Exception -> 0x00ec }
        L_0x00ec:
            r4.i()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.f.a.a(java.lang.String, byte[]):com.igexin.push.extension.distribution.basic.f.b");
    }

    private Method a(String str, Class<?>... clsArr) {
        try {
            return Class.forName("com.igexin.push.util.EncryptUtils").getMethod(str, clsArr);
        } catch (Exception unused) {
            b.a(this.l + "invokeMethod error", new Object[0]);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte[]} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=java.lang.Object, for r9v0, types: [byte[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.net.HttpURLConnection r8, java.lang.Object r9) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            byte[] r1 = new byte[r0]
            if (r9 == 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            r9 = r1
        L_0x000a:
            r1 = 1
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "GT_C_T"
            r8.addRequestProperty(r3, r2)
            java.lang.String r2 = new java.lang.String
            java.lang.Class[] r3 = new java.lang.Class[r0]
            java.lang.String r4 = "getRSAKeyId"
            java.lang.reflect.Method r3 = r7.a((java.lang.String) r4, (java.lang.Class<?>[]) r3)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r5 = 0
            java.lang.Object r3 = r3.invoke(r5, r4)
            byte[] r3 = (byte[]) r3
            byte[] r3 = (byte[]) r3
            r2.<init>(r3)
            java.lang.String r3 = "GT_C_K"
            r8.addRequestProperty(r3, r2)
            java.lang.Class[] r2 = new java.lang.Class[r0]
            java.lang.String r3 = "getHttpGTCV"
            java.lang.reflect.Method r2 = r7.a((java.lang.String) r3, (java.lang.Class<?>[]) r2)
            java.lang.Object[] r3 = new java.lang.Object[r0]
            java.lang.Object r2 = r2.invoke(r5, r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "GT_C_V"
            r8.addRequestProperty(r3, r2)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r4[r0] = r6
            java.lang.Class<byte[]> r6 = byte[].class
            r4[r1] = r6
            java.lang.String r6 = "getHttpSignature"
            java.lang.reflect.Method r4 = r7.a((java.lang.String) r6, (java.lang.Class<?>[]) r4)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r0] = r2
            r3[r1] = r9
            java.lang.Object r9 = r4.invoke(r5, r3)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r0 = "GT_T"
            r8.addRequestProperty(r0, r2)
            java.lang.String r0 = "GT_C_S"
            r8.addRequestProperty(r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.f.a.a(java.net.HttpURLConnection, byte[]):void");
    }

    private void a(byte[] bArr) {
        this.a.a(bArr);
        c.b().a((Object) this.a);
        c.b().c();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:21|22)|23|24|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|(2:9|(1:11)(1:51))|12|(2:14|15)|16|17|18) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x004d A[SYNTHETIC, Splitter:B:43:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0052 A[SYNTHETIC, Splitter:B:47:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.net.HttpURLConnection r5) {
        /*
            r4 = this;
            r0 = 0
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0040, all -> 0x003c }
            r2.<init>()     // Catch:{ Exception -> 0x0040, all -> 0x003c }
            int r5 = r5.getResponseCode()     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r5 != r3) goto L_0x002f
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
        L_0x0016:
            int r0 = r1.read(r5)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r3 = -1
            if (r0 == r3) goto L_0x0022
            r3 = 0
            r2.write(r5, r3, r0)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            goto L_0x0016
        L_0x0022:
            byte[] r5 = r2.toByteArray()     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            r2.close()     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            return r5
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r2.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            return r0
        L_0x0038:
            r5 = move-exception
            goto L_0x003e
        L_0x003a:
            r5 = move-exception
            goto L_0x0042
        L_0x003c:
            r5 = move-exception
            r2 = r0
        L_0x003e:
            r0 = r1
            goto L_0x004b
        L_0x0040:
            r5 = move-exception
            r2 = r0
        L_0x0042:
            r0 = r1
            goto L_0x0049
        L_0x0044:
            r5 = move-exception
            r2 = r0
            goto L_0x004b
        L_0x0047:
            r5 = move-exception
            r2 = r0
        L_0x0049:
            throw r5     // Catch:{ all -> 0x004a }
        L_0x004a:
            r5 = move-exception
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            if (r2 == 0) goto L_0x0055
            r2.close()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.f.a.a(java.net.HttpURLConnection):byte[]");
    }

    private byte[] a(byte[] bArr, HttpURLConnection httpURLConnection) {
        Class<byte[]> cls = byte[].class;
        try {
            b.a("AsyncHttpTask|getEncHttpData|isUseAES = |" + this.c, new Object[0]);
            if (!this.c) {
                return h.a(bArr);
            }
            String requestProperty = httpURLConnection.getRequestProperty("GT_C_S");
            if (requestProperty != null) {
                return (byte[]) a("aesEncHttp", (Class<?>[]) new Class[]{cls, cls}).invoke((Object) null, new Object[]{bArr, a("md5", (Class<?>[]) new Class[]{cls}).invoke((Object) null, new Object[]{requestProperty.getBytes()})});
            }
            return null;
        } catch (Throwable th) {
            b.a("AsyncHttpTask|getEncHttpData|error|" + th.getMessage(), new Object[0]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.push.extension.distribution.basic.f.b b(java.net.HttpURLConnection r11, byte[] r12) {
        /*
            r10 = this;
            java.lang.Class<byte[]> r0 = byte[].class
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "AsyncHttpTask|authAndDecResp start ~~~"
            com.igexin.b.a.c.b.a((java.lang.String) r3, (java.lang.Object[]) r2)
            r2 = 0
            r3 = 1
            boolean r4 = r10.c     // Catch:{ all -> 0x0125 }
            if (r4 == 0) goto L_0x0107
            java.lang.String r4 = "GT_ERR"
            java.lang.String r4 = r11.getHeaderField(r4)     // Catch:{ all -> 0x0125 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r5.<init>()     // Catch:{ all -> 0x0125 }
            java.lang.String r6 = r10.l     // Catch:{ all -> 0x0125 }
            r5.append(r6)     // Catch:{ all -> 0x0125 }
            java.lang.String r6 = "|GT_ERR = "
            r5.append(r6)     // Catch:{ all -> 0x0125 }
            r5.append(r4)     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0125 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x0125 }
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x0125 }
            if (r4 == 0) goto L_0x0101
            java.lang.String r5 = "0"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0125 }
            if (r4 != 0) goto L_0x003d
            goto L_0x0101
        L_0x003d:
            java.lang.String r4 = "GT_T"
            java.lang.String r4 = r11.getHeaderField(r4)     // Catch:{ all -> 0x0125 }
            if (r4 != 0) goto L_0x0063
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r11.<init>()     // Catch:{ all -> 0x0125 }
            java.lang.String r12 = r10.l     // Catch:{ all -> 0x0125 }
            r11.append(r12)     // Catch:{ all -> 0x0125 }
            java.lang.String r12 = "|GT_T = null"
            r11.append(r12)     // Catch:{ all -> 0x0125 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0125 }
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ all -> 0x0125 }
            com.igexin.b.a.c.b.a((java.lang.String) r11, (java.lang.Object[]) r12)     // Catch:{ all -> 0x0125 }
            com.igexin.push.extension.distribution.basic.f.b r11 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ all -> 0x0125 }
            r11.<init>(r10, r3, r2)     // Catch:{ all -> 0x0125 }
            return r11
        L_0x0063:
            java.lang.String r5 = "GT_C_S"
            java.lang.String r11 = r11.getHeaderField(r5)     // Catch:{ all -> 0x0125 }
            if (r11 != 0) goto L_0x0089
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r11.<init>()     // Catch:{ all -> 0x0125 }
            java.lang.String r12 = r10.l     // Catch:{ all -> 0x0125 }
            r11.append(r12)     // Catch:{ all -> 0x0125 }
            java.lang.String r12 = "|GT_C_S = null"
            r11.append(r12)     // Catch:{ all -> 0x0125 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0125 }
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ all -> 0x0125 }
            com.igexin.b.a.c.b.a((java.lang.String) r11, (java.lang.Object[]) r12)     // Catch:{ all -> 0x0125 }
            com.igexin.push.extension.distribution.basic.f.b r11 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ all -> 0x0125 }
            r11.<init>(r10, r3, r2)     // Catch:{ all -> 0x0125 }
            return r11
        L_0x0089:
            java.lang.String r5 = "aesDecHttp"
            r6 = 2
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x0125 }
            r7[r1] = r0     // Catch:{ all -> 0x0125 }
            r7[r3] = r0     // Catch:{ all -> 0x0125 }
            java.lang.reflect.Method r5 = r10.a((java.lang.String) r5, (java.lang.Class<?>[]) r7)     // Catch:{ all -> 0x0125 }
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0125 }
            r7[r1] = r12     // Catch:{ all -> 0x0125 }
            java.lang.String r12 = "md5"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ all -> 0x0125 }
            r8[r1] = r0     // Catch:{ all -> 0x0125 }
            java.lang.reflect.Method r12 = r10.a((java.lang.String) r12, (java.lang.Class<?>[]) r8)     // Catch:{ all -> 0x0125 }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x0125 }
            byte[] r9 = r4.getBytes()     // Catch:{ all -> 0x0125 }
            r8[r1] = r9     // Catch:{ all -> 0x0125 }
            java.lang.Object r12 = r12.invoke(r2, r8)     // Catch:{ all -> 0x0125 }
            r7[r3] = r12     // Catch:{ all -> 0x0125 }
            java.lang.Object r12 = r5.invoke(r2, r7)     // Catch:{ all -> 0x0125 }
            byte[] r12 = (byte[]) r12     // Catch:{ all -> 0x0125 }
            byte[] r12 = (byte[]) r12     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = "getHttpSignature"
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x0125 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r1] = r8     // Catch:{ all -> 0x0125 }
            r7[r3] = r0     // Catch:{ all -> 0x0125 }
            java.lang.reflect.Method r0 = r10.a((java.lang.String) r5, (java.lang.Class<?>[]) r7)     // Catch:{ all -> 0x0125 }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ all -> 0x0125 }
            r5[r1] = r4     // Catch:{ all -> 0x0125 }
            r5[r3] = r12     // Catch:{ all -> 0x0125 }
            java.lang.Object r0 = r0.invoke(r2, r5)     // Catch:{ all -> 0x0125 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0125 }
            if (r0 == 0) goto L_0x00e3
            boolean r11 = r0.equals(r11)     // Catch:{ all -> 0x0125 }
            if (r11 != 0) goto L_0x00dd
            goto L_0x00e3
        L_0x00dd:
            com.igexin.push.extension.distribution.basic.f.b r11 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ all -> 0x0125 }
            r11.<init>(r10, r1, r12)     // Catch:{ all -> 0x0125 }
            return r11
        L_0x00e3:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r11.<init>()     // Catch:{ all -> 0x0125 }
            java.lang.String r12 = r10.l     // Catch:{ all -> 0x0125 }
            r11.append(r12)     // Catch:{ all -> 0x0125 }
            java.lang.String r12 = "|signature = null or error"
            r11.append(r12)     // Catch:{ all -> 0x0125 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0125 }
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ all -> 0x0125 }
            com.igexin.b.a.c.b.a((java.lang.String) r11, (java.lang.Object[]) r12)     // Catch:{ all -> 0x0125 }
            com.igexin.push.extension.distribution.basic.f.b r11 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ all -> 0x0125 }
            r11.<init>(r10, r3, r2)     // Catch:{ all -> 0x0125 }
            return r11
        L_0x0101:
            com.igexin.push.extension.distribution.basic.f.b r11 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ all -> 0x0125 }
            r11.<init>(r10, r3, r2)     // Catch:{ all -> 0x0125 }
            return r11
        L_0x0107:
            com.igexin.push.extension.distribution.basic.f.d r11 = r10.a     // Catch:{ all -> 0x0125 }
            boolean r11 = r11.e()     // Catch:{ all -> 0x0125 }
            if (r11 == 0) goto L_0x0113
            byte[] r12 = android.util.Base64.decode(r12, r1)     // Catch:{ all -> 0x0125 }
        L_0x0113:
            com.igexin.push.extension.distribution.basic.f.d r11 = r10.a     // Catch:{ all -> 0x0125 }
            boolean r11 = r11.d()     // Catch:{ all -> 0x0125 }
            if (r11 == 0) goto L_0x011f
            byte[] r12 = com.igexin.push.extension.distribution.basic.g.h.b(r12)     // Catch:{ all -> 0x0125 }
        L_0x011f:
            com.igexin.push.extension.distribution.basic.f.b r11 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ all -> 0x0125 }
            r11.<init>(r10, r1, r12)     // Catch:{ all -> 0x0125 }
            return r11
        L_0x0125:
            r11 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "AsyncHttpTask|authAndDecResp|error|"
            r12.append(r0)
            java.lang.String r11 = r11.getMessage()
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            java.lang.Object[] r12 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r11, (java.lang.Object[]) r12)
            com.igexin.push.extension.distribution.basic.f.b r11 = new com.igexin.push.extension.distribution.basic.f.b
            r11.<init>(r10, r3, r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.f.a.b(java.net.HttpURLConnection, byte[]):com.igexin.push.extension.distribution.basic.f.b");
    }

    private HttpURLConnection b(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(str).openConnection());
        this.b = httpURLConnection;
        httpURLConnection.setConnectTimeout(20000);
        this.b.setReadTimeout(20000);
        this.b.setRequestMethod(IHttpAdapter.METHOD_GET);
        this.b.setDoInput(true);
        if (this.c) {
            a(this.b, (byte[]) null);
        }
        return this.b;
    }

    private HttpURLConnection b(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(str).openConnection());
        this.b = httpURLConnection;
        httpURLConnection.setDoInput(true);
        this.b.setDoOutput(true);
        this.b.setRequestMethod(IHttpAdapter.METHOD_POST);
        this.b.setUseCaches(false);
        this.b.setInstanceFollowRedirects(true);
        this.b.setRequestProperty("Content-Type", Mimetypes.MIMETYPE_OCTET_STREAM);
        this.b.setConnectTimeout(20000);
        this.b.setReadTimeout(20000);
        if (this.c) {
            a(this.b, bArr);
        }
        return this.b;
    }

    private boolean b(byte[] bArr) {
        if (bArr == null || bArr.length / PictureFileUtils.KB <= com.igexin.push.extension.distribution.basic.c.e.j) {
            return false;
        }
        b.a(this.l + "|http body size exceed " + com.igexin.push.extension.distribution.basic.c.e.j, new Object[0]);
        return true;
    }

    private void i() {
        b.a("AsyncHttpTask call closeHttpURLConnection", new Object[0]);
        HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.b = null;
            } catch (Exception unused) {
            }
        }
    }

    private boolean j() {
        return this.a.e && com.igexin.push.extension.distribution.basic.g.b.a();
    }

    public final void b() {
        String b2;
        super.b();
        if (this.d) {
            p();
            return;
        }
        this.d = true;
        Process.setThreadPriority(10);
        d dVar = this.a;
        if (dVar != null && (b2 = dVar.b()) != null) {
            boolean j = j();
            this.c = j;
            if (!j || ((Boolean) a("isLoadSuccess", (Class<?>[]) new Class[0]).invoke((Object) null, new Object[0])).booleanValue()) {
                if (this.c && this.a.c() != null && this.a.c().length > 0) {
                    d dVar2 = this.a;
                    dVar2.b(com.igexin.b.a.b.e.a(dVar2.c()));
                }
                try {
                    b a2 = this.a.c() == null ? a(b2) : a(b2, this.a.c());
                    if (a2.a) {
                        Exception exc = new Exception("http server resp decode header error");
                        this.a.a(exc);
                        throw exc;
                    } else if (a2.b != null) {
                        a(a2.b);
                    } else {
                        Exception exc2 = new Exception("Http response exception");
                        this.a.a(exc2);
                        throw exc2;
                    }
                } catch (Exception e) {
                    b.a("AsyncHttpTask|run() post or get error = " + e.getMessage(), new Object[0]);
                    this.a.a(e);
                    throw e;
                } catch (Exception e2) {
                    b.a("AsyncHttpTask|run() error = " + e2.getMessage(), new Object[0]);
                    throw e2;
                }
            } else {
                b.a(this.l + "|so load failed! AsyncHttpTask return!", new Object[0]);
            }
        }
    }

    public final int b_() {
        return -2147483639;
    }

    public void d() {
        this.m = true;
        b.a("AsyncHttpTask initTask()|isBloker = " + this.m + "|isCycle = " + this.n, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    public void f() {
        b.a("AsyncHttpTask|dispose()|closeHttpURLConnection", new Object[0]);
        super.f();
        i();
    }
}
