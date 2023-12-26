package com.bonree.sdk.au;

import android.text.TextUtils;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.d.e;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class a extends com.bonree.sdk.ad.a {
    private static final String n = "BR-Ping-Thread";
    private final String f;
    private final List<Long> g;
    private volatile String h;
    private volatile AtomicLong i;
    private final List<String> j;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public int l;
    private final int m;
    /* access modifiers changed from: private */
    public final Runnable o;

    /* synthetic */ a(byte b) {
        this();
    }

    public final void a(long j2) {
        if (this.g.size() >= 5) {
            this.g.remove(0);
        }
        this.g.add(Long.valueOf(j2));
        this.i.getAndSet(0);
        for (Long longValue : this.g) {
            this.i.getAndSet(this.i.get() + longValue.longValue());
        }
    }

    private a() {
        super((e) null);
        this.f = "tcpping";
        this.g = Collections.synchronizedList(new ArrayList(5));
        this.i = new AtomicLong(0);
        this.j = Collections.synchronizedList(new ArrayList());
        this.k = "www.baidu.com";
        this.l = 80;
        this.m = 15000;
        this.o = new b(this);
    }

    public final long a() {
        int size = this.g.size();
        if (size != 0) {
            return this.i.get() / ((long) size);
        }
        return 0;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00bd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r10) {
        /*
            r9 = this;
            com.bonree.sdk.be.f r0 = r9.c
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r10
            java.lang.String r4 = "tcpping setTcpPingAddress: %s "
            r0.c(r4, r2)
            if (r10 == 0) goto L_0x00da
            java.lang.String r0 = r10.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001b
            goto L_0x00da
        L_0x001b:
            java.lang.String r0 = "\\,"
            java.lang.String[] r10 = r10.split(r0)
            int r0 = r10.length
            r2 = r3
        L_0x0023:
            if (r2 >= r0) goto L_0x0035
            r4 = r10[r2]
            boolean r5 = r9.c((java.lang.String) r4)
            if (r5 == 0) goto L_0x0032
            java.util.List<java.lang.String> r5 = r9.j
            r5.add(r4)
        L_0x0032:
            int r2 = r2 + 1
            goto L_0x0023
        L_0x0035:
            java.util.List<java.lang.String> r10 = r9.j
            int r10 = r10.size()
            if (r10 <= 0) goto L_0x00d6
            java.util.List<java.lang.String> r10 = r9.j
            java.lang.Object r10 = r10.get(r3)
            java.lang.String r10 = (java.lang.String) r10
            r9.h = r10
            r10 = 65535(0xffff, float:9.1834E-41)
            r0 = 80
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x007f }
            java.lang.String r4 = r9.h     // Catch:{ all -> 0x007f }
            r2.<init>(r4)     // Catch:{ all -> 0x007f }
            java.lang.String r4 = r2.getHost()     // Catch:{ all -> 0x007f }
            r9.k = r4     // Catch:{ all -> 0x007f }
            int r4 = r2.getPort()     // Catch:{ all -> 0x007f }
            r5 = -1
            if (r4 != r5) goto L_0x006f
            java.lang.String r2 = r9.h     // Catch:{ all -> 0x007f }
            java.lang.String r4 = "https://"
            boolean r2 = r2.startsWith(r4)     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x006d
            r2 = 443(0x1bb, float:6.21E-43)
            goto L_0x0073
        L_0x006d:
            r2 = r0
            goto L_0x0073
        L_0x006f:
            int r2 = r2.getPort()     // Catch:{ all -> 0x007f }
        L_0x0073:
            r9.l = r2     // Catch:{ all -> 0x007f }
            if (r2 < 0) goto L_0x0079
            if (r2 <= r10) goto L_0x007b
        L_0x0079:
            r9.l = r0     // Catch:{ all -> 0x007f }
        L_0x007b:
            r9.g()
            goto L_0x00d9
        L_0x007f:
            r2 = move-exception
            com.bonree.sdk.be.f r4 = r9.c     // Catch:{ all -> 0x00d1 }
            java.lang.String r5 = "ad: %s ,tcpping host parse filed: %s"
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x00d1 }
            java.lang.String r8 = r9.h     // Catch:{ all -> 0x00d1 }
            r7[r3] = r8     // Catch:{ all -> 0x00d1 }
            r7[r1] = r2     // Catch:{ all -> 0x00d1 }
            r4.e(r5, r7)     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = "((\\d+\\.){3}\\d+)|((\\d+\\.){3}\\d+)\\:(\\d+)"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = r9.h     // Catch:{ all -> 0x00c0 }
            java.util.regex.Matcher r2 = r2.matcher(r4)     // Catch:{ all -> 0x00c0 }
            boolean r4 = r2.find()     // Catch:{ all -> 0x00c0 }
            if (r4 == 0) goto L_0x007b
            java.lang.String r4 = r2.group(r1)     // Catch:{ all -> 0x00c0 }
            r9.k = r4     // Catch:{ all -> 0x00c0 }
            java.lang.String r2 = r2.group(r6)     // Catch:{ all -> 0x00c0 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x00bd }
            r9.l = r2     // Catch:{ NumberFormatException -> 0x00bd }
            if (r2 < 0) goto L_0x00b7
            if (r2 > r10) goto L_0x00b7
            goto L_0x007b
        L_0x00b7:
            java.lang.NumberFormatException r10 = new java.lang.NumberFormatException     // Catch:{ NumberFormatException -> 0x00bd }
            r10.<init>()     // Catch:{ NumberFormatException -> 0x00bd }
            throw r10     // Catch:{ NumberFormatException -> 0x00bd }
        L_0x00bd:
            r9.l = r0     // Catch:{ all -> 0x00c0 }
            goto L_0x007b
        L_0x00c0:
            r10 = move-exception
            com.bonree.sdk.be.f r0 = r9.c     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = "ad: %s ,tcpping ip  parse filed: %s"
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ all -> 0x00d1 }
            java.lang.String r5 = r9.h     // Catch:{ all -> 0x00d1 }
            r4[r3] = r5     // Catch:{ all -> 0x00d1 }
            r4[r1] = r10     // Catch:{ all -> 0x00d1 }
            r0.e(r2, r4)     // Catch:{ all -> 0x00d1 }
            goto L_0x007b
        L_0x00d1:
            r10 = move-exception
            r9.g()
            throw r10
        L_0x00d6:
            r9.g()
        L_0x00d9:
            return
        L_0x00da:
            r9.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.au.a.b(java.lang.String):void");
    }

    private boolean c(String str) {
        try {
            URL url = new URL(str);
            url.getHost();
            if (url.getPort() == -1) {
                str.startsWith("https://");
            } else {
                url.getPort();
            }
            return true;
        } catch (NumberFormatException unused) {
        } catch (Throwable th) {
            this.c.e("ad: %s ,tcpping ip  parse filed: %s", str, th);
        }
        return false;
        return true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0078 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r9 = this;
            r0 = 65535(0xffff, float:9.1834E-41)
            r1 = 80
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = r9.h     // Catch:{ all -> 0x0038 }
            r2.<init>(r3)     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = r2.getHost()     // Catch:{ all -> 0x0038 }
            r9.k = r3     // Catch:{ all -> 0x0038 }
            int r3 = r2.getPort()     // Catch:{ all -> 0x0038 }
            r4 = -1
            if (r3 != r4) goto L_0x0028
            java.lang.String r2 = r9.h     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = "https://"
            boolean r2 = r2.startsWith(r3)     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x0026
            r2 = 443(0x1bb, float:6.21E-43)
            goto L_0x002c
        L_0x0026:
            r2 = r1
            goto L_0x002c
        L_0x0028:
            int r2 = r2.getPort()     // Catch:{ all -> 0x0038 }
        L_0x002c:
            r9.l = r2     // Catch:{ all -> 0x0038 }
            if (r2 < 0) goto L_0x0032
            if (r2 <= r0) goto L_0x0034
        L_0x0032:
            r9.l = r1     // Catch:{ all -> 0x0038 }
        L_0x0034:
            r9.g()
            return
        L_0x0038:
            r2 = move-exception
            com.bonree.sdk.be.f r3 = r9.c     // Catch:{ all -> 0x008f }
            java.lang.String r4 = "ad: %s ,tcpping host parse filed: %s"
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x008f }
            java.lang.String r7 = r9.h     // Catch:{ all -> 0x008f }
            r8 = 0
            r6[r8] = r7     // Catch:{ all -> 0x008f }
            r7 = 1
            r6[r7] = r2     // Catch:{ all -> 0x008f }
            r3.e(r4, r6)     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "((\\d+\\.){3}\\d+)|((\\d+\\.){3}\\d+)\\:(\\d+)"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ all -> 0x007b }
            java.lang.String r3 = r9.h     // Catch:{ all -> 0x007b }
            java.util.regex.Matcher r2 = r2.matcher(r3)     // Catch:{ all -> 0x007b }
            boolean r3 = r2.find()     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x008b
            java.lang.String r3 = r2.group(r7)     // Catch:{ all -> 0x007b }
            r9.k = r3     // Catch:{ all -> 0x007b }
            java.lang.String r2 = r2.group(r5)     // Catch:{ all -> 0x007b }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0078 }
            r9.l = r2     // Catch:{ NumberFormatException -> 0x0078 }
            if (r2 < 0) goto L_0x0072
            if (r2 > r0) goto L_0x0072
            goto L_0x008b
        L_0x0072:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException     // Catch:{ NumberFormatException -> 0x0078 }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x0078 }
            throw r0     // Catch:{ NumberFormatException -> 0x0078 }
        L_0x0078:
            r9.l = r1     // Catch:{ all -> 0x007b }
            goto L_0x008b
        L_0x007b:
            r0 = move-exception
            com.bonree.sdk.be.f r1 = r9.c     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "ad: %s ,tcpping ip  parse filed: %s"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r9.h     // Catch:{ all -> 0x008f }
            r3[r8] = r4     // Catch:{ all -> 0x008f }
            r3[r7] = r0     // Catch:{ all -> 0x008f }
            r1.e(r2, r3)     // Catch:{ all -> 0x008f }
        L_0x008b:
            r9.g()
            return
        L_0x008f:
            r0 = move-exception
            r9.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.au.a.e():void");
    }

    private void g() {
        if (TextUtils.isEmpty(this.k)) {
            this.k = "www.baidu.com";
        }
        if (this.l == 0) {
            this.l = 80;
        }
    }

    public final synchronized boolean b() {
        try {
            if (!this.a) {
                a("tcpping", a.d.a);
                this.a = true;
                a(n);
                a(this.o, 0);
                a("tcpping", a.d.c);
            }
        } catch (Throwable th) {
            if (this.c != null) {
                this.c.a("tcp ping service start error. %s ", th);
            }
            c();
        }
        return true;
    }

    public final synchronized boolean c() {
        try {
            if (this.a) {
                a("tcpping", a.d.d);
                this.a = false;
                f();
                List<Long> list = this.g;
                if (list != null && list.size() > 0) {
                    this.g.clear();
                }
                if (this.i != null) {
                    this.i.getAndSet(0);
                }
                a("tcpping", a.d.e);
            } else {
                this.c.d("TcpPingService no need stop!", new Object[0]);
            }
        } catch (Throwable th) {
            if (this.c != null) {
                this.c.a("tcp ping service stop error. ", th);
            }
        }
        return true;
    }

    public static a d() {
        return C0007a.a;
    }

    /* renamed from: com.bonree.sdk.au.a$a  reason: collision with other inner class name */
    static class C0007a {
        /* access modifiers changed from: private */
        public static final a a = new a((byte) 0);

        private C0007a() {
        }
    }
}
