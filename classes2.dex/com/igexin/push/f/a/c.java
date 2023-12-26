package com.igexin.push.f.a;

import android.os.Process;
import com.amazonaws.services.s3.util.Mimetypes;
import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import com.didi.hummer.adapter.http.IHttpAdapter;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.b.a.c.b;
import com.igexin.b.a.d.e;
import com.igexin.push.config.l;
import com.igexin.push.util.EncryptUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class c extends e {
    public b a;
    private HttpURLConnection b;

    public c(b bVar) {
        super(0);
        this.a = bVar;
    }

    private d a(String str) {
        try {
            HttpURLConnection b2 = b(str);
            this.b = b2;
            byte[] a2 = a(b2);
            if (a2 != null) {
                d b3 = b(this.b, a2);
                i();
                return b3;
            }
        } catch (Throwable unused) {
        }
        i();
        return new d(this, false, (byte[]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r5 != null) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.push.f.a.d a(java.lang.String r4, byte[] r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            java.net.HttpURLConnection r4 = r3.b((java.lang.String) r4, (byte[]) r5)     // Catch:{ all -> 0x0044 }
            r3.b = r4     // Catch:{ all -> 0x0044 }
            byte[] r4 = r3.a((byte[]) r5, (java.net.HttpURLConnection) r4)     // Catch:{ all -> 0x0044 }
            if (r4 != 0) goto L_0x0018
            com.igexin.push.f.a.d r4 = new com.igexin.push.f.a.d     // Catch:{ all -> 0x0044 }
            r5 = 1
            r4.<init>(r3, r5, r1)     // Catch:{ all -> 0x0044 }
            r3.i()
            return r4
        L_0x0018:
            java.net.HttpURLConnection r5 = r3.b     // Catch:{ all -> 0x0044 }
            r5.connect()     // Catch:{ all -> 0x0044 }
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch:{ all -> 0x0044 }
            java.net.HttpURLConnection r2 = r3.b     // Catch:{ all -> 0x0044 }
            java.io.OutputStream r2 = r2.getOutputStream()     // Catch:{ all -> 0x0044 }
            r5.<init>(r2)     // Catch:{ all -> 0x0044 }
            int r2 = r4.length     // Catch:{ all -> 0x0045 }
            r5.write(r4, r0, r2)     // Catch:{ all -> 0x0045 }
            r5.flush()     // Catch:{ all -> 0x0045 }
            java.net.HttpURLConnection r4 = r3.b     // Catch:{ all -> 0x0045 }
            byte[] r4 = r3.a((java.net.HttpURLConnection) r4)     // Catch:{ all -> 0x0045 }
            if (r4 == 0) goto L_0x0047
            java.net.HttpURLConnection r2 = r3.b     // Catch:{ all -> 0x0045 }
            com.igexin.push.f.a.d r4 = r3.b((java.net.HttpURLConnection) r2, (byte[]) r4)     // Catch:{ all -> 0x0045 }
            r5.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            r3.i()
            return r4
        L_0x0044:
            r5 = r1
        L_0x0045:
            if (r5 == 0) goto L_0x004a
        L_0x0047:
            r5.close()     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            r3.i()
            com.igexin.push.f.a.d r4 = new com.igexin.push.f.a.d
            r4.<init>(r3, r0, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.c.a(java.lang.String, byte[]):com.igexin.push.f.a.d");
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (httpURLConnection != null) {
            byte[] bArr2 = new byte[0];
            if (bArr == null) {
                bArr = bArr2;
            }
            httpURLConnection.addRequestProperty("GT_C_T", String.valueOf(1));
            httpURLConnection.addRequestProperty("GT_C_K", new String(EncryptUtils.getRSAKeyId()));
            httpURLConnection.addRequestProperty("GT_C_V", EncryptUtils.getHttpGTCV());
            String valueOf = String.valueOf(System.currentTimeMillis());
            String httpSignature = EncryptUtils.getHttpSignature(valueOf, bArr);
            httpURLConnection.addRequestProperty("GT_T", valueOf);
            httpURLConnection.addRequestProperty("GT_C_S", httpSignature);
        }
    }

    private void a(byte[] bArr) {
        this.a.a(bArr);
        com.igexin.b.a.b.c.b().a((Object) this.a);
        com.igexin.b.a.b.c.b().c();
    }

    private byte[] a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (httpURLConnection.getResponseCode() == 200) {
                    byte[] bArr = new byte[PictureFileUtils.KB];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception unused) {
                        }
                    }
                    return byteArray;
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
                return null;
            } catch (Exception e) {
                e = e;
                inputStream = inputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            throw e;
        }
    }

    private byte[] a(byte[] bArr, HttpURLConnection httpURLConnection) {
        String requestProperty;
        try {
            if (!httpURLConnection.getRequestProperties().containsKey("GT_C_S") || (requestProperty = httpURLConnection.getRequestProperty("GT_C_S")) == null) {
                return null;
            }
            return EncryptUtils.aesEncHttp(bArr, EncryptUtils.md5(requestProperty.getBytes()));
        } catch (Throwable th) {
            b.a("_HttpTask|" + th.toString(), new Object[0]);
            return null;
        }
    }

    private d b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            String headerField = httpURLConnection.getHeaderField("GT_ERR");
            b.a("_HttpTask|GT_ERR = " + headerField, new Object[0]);
            if (headerField != null) {
                if (headerField.equals(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE)) {
                    String headerField2 = httpURLConnection.getHeaderField("GT_T");
                    if (headerField2 == null) {
                        b.a("_HttpTask|GT_T = null", new Object[0]);
                        return new d(this, true, (byte[]) null);
                    }
                    String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
                    if (headerField3 == null) {
                        b.a("_HttpTask|GT_C_S = null", new Object[0]);
                        return new d(this, true, (byte[]) null);
                    }
                    byte[] aesDecHttp = EncryptUtils.aesDecHttp(bArr, EncryptUtils.md5(headerField2.getBytes()));
                    String httpSignature = EncryptUtils.getHttpSignature(headerField2, aesDecHttp);
                    if (httpSignature != null) {
                        if (httpSignature.equals(headerField3)) {
                            return new d(this, false, aesDecHttp);
                        }
                    }
                    b.a("_HttpTask|signature = null or error", new Object[0]);
                    return new d(this, true, (byte[]) null);
                }
            }
            return new d(this, true, (byte[]) null);
        } catch (Throwable th) {
            b.a("_HttpTask|" + th.toString(), new Object[0]);
            return new d(this, true, (byte[]) null);
        }
    }

    private HttpURLConnection b(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(str).openConnection());
        this.b = httpURLConnection;
        httpURLConnection.setConnectTimeout(20000);
        this.b.setReadTimeout(20000);
        this.b.setRequestMethod(IHttpAdapter.METHOD_GET);
        this.b.setDoInput(true);
        a(this.b, (byte[]) null);
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
        a(this.b, bArr);
        return this.b;
    }

    private void i() {
        HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.b = null;
            } catch (Exception unused) {
            }
        }
    }

    public final void b() {
        super.b();
        Process.setThreadPriority(10);
        b bVar = this.a;
        int i = 0;
        if (bVar == null || bVar.c == null || (this.a.d != null && this.a.d.length > l.w * PictureFileUtils.KB)) {
            p();
            b.a("_HttpTask|run return ###", new Object[0]);
            return;
        }
        if (this.a.d != null && this.a.d.length > 0) {
            b bVar2 = this.a;
            bVar2.d = com.igexin.b.a.b.e.c(bVar2.d);
        }
        while (i < 3) {
            d a2 = this.a.d == null ? a(this.a.c) : a(this.a.c, this.a.d);
            if (a2.a) {
                throw new Exception("http server resp decode header error");
            } else if (a2.b != null) {
                a(a2.b);
                return;
            } else if (i != 2) {
                i++;
            } else {
                this.a.a(new Exception("try up to limit"));
                throw new Exception("http request exception, try times = " + (i + 1));
            }
        }
    }

    public final int b_() {
        return -2147483638;
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
