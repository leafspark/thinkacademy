package com.igexin.push.f;

import android.text.TextUtils;
import com.igexin.b.a.b.c;
import com.igexin.b.a.d.e;
import com.igexin.push.core.d;
import java.util.ArrayList;

public class a extends e {
    private static a e;
    private ArrayList<String> a = new ArrayList<>();
    private ArrayList<String> b = new ArrayList<>();
    private long c = System.currentTimeMillis();
    private String d;

    private a() {
        super(-2147483637);
    }

    public static a i() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                    c.b().a(e, true, true);
                }
            }
        }
        return e;
    }

    public static void k() {
        a aVar = e;
        if (aVar != null) {
            aVar.j();
        }
    }

    private long u() {
        long currentTimeMillis = System.currentTimeMillis() - this.c;
        if ((currentTimeMillis >= 60000 && this.a.size() > 0) || this.a.size() >= 10) {
            return 0;
        }
        if (this.a.size() <= 0) {
            return Long.MAX_VALUE;
        }
        return 60000 - currentTimeMillis;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0 = new java.io.FileOutputStream(r3, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00de, code lost:
        if (r2 != null) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00eb, code lost:
        if (r2 == null) goto L_0x00ee;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0098 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v() {
        /*
            r6 = this;
            android.content.Context r0 = com.igexin.push.core.d.g
            if (r0 == 0) goto L_0x00fd
            java.lang.String r0 = com.igexin.push.core.d.E
            if (r0 != 0) goto L_0x000a
            goto L_0x00fd
        L_0x000a:
            monitor-enter(r6)
            java.util.ArrayList<java.lang.String> r0 = r6.b     // Catch:{ all -> 0x00fa }
            java.util.ArrayList<java.lang.String> r1 = r6.a     // Catch:{ all -> 0x00fa }
            r0.addAll(r1)     // Catch:{ all -> 0x00fa }
            java.util.ArrayList<java.lang.String> r0 = r6.a     // Catch:{ all -> 0x00fa }
            r0.clear()     // Catch:{ all -> 0x00fa }
            monitor-exit(r6)     // Catch:{ all -> 0x00fa }
            r6.w()
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r6.d
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x002f
            boolean r0 = r0.mkdirs()
            if (r0 != 0) goto L_0x002f
            return
        L_0x002f:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "yyyy-MM-dd"
            java.util.Locale r2 = java.util.Locale.getDefault()
            r0.<init>(r1, r2)
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            java.lang.String r0 = r0.format(r1)
            java.lang.String r1 = com.igexin.push.core.d.e
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r4.<init>()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r5 = r6.d     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r4.append(r5)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r5 = "/"
            r4.append(r5)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r4.append(r1)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r4.append(r0)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r0 = ".log"
            r4.append(r0)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            if (r0 != 0) goto L_0x007e
            boolean r0 = r3.createNewFile()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            if (r0 != 0) goto L_0x007b
            return
        L_0x007b:
            com.igexin.b.a.c.a.a()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
        L_0x007e:
            byte[] r0 = com.igexin.b.a.c.a.b()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            if (r0 != 0) goto L_0x008a
            com.igexin.b.a.c.a.a()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r3.delete()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
        L_0x008a:
            javax.crypto.spec.SecretKeySpec r0 = new javax.crypto.spec.SecretKeySpec     // Catch:{ all -> 0x0098 }
            byte[] r1 = com.igexin.push.core.d.aw     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "AES"
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0098 }
            javax.crypto.CipherOutputStream r0 = com.igexin.b.a.c.a.a(r3, r0)     // Catch:{ all -> 0x0098 }
            goto L_0x009e
        L_0x0098:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r1 = 1
            r0.<init>(r3, r1)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
        L_0x009e:
            r2 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r0.<init>()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.util.ArrayList<java.lang.String> r1 = r6.b     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
        L_0x00aa:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            if (r3 == 0) goto L_0x00cb
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r4.<init>()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r4.append(r3)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r3 = "\r\n"
            r4.append(r3)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r0.append(r3)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            goto L_0x00aa
        L_0x00cb:
            int r1 = r0.length()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            if (r1 <= 0) goto L_0x00de
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
            r2.write(r0)     // Catch:{ Exception -> 0x00eb, all -> 0x00e4 }
        L_0x00de:
            if (r2 == 0) goto L_0x00ee
        L_0x00e0:
            r2.close()     // Catch:{ IOException -> 0x00ee }
            goto L_0x00ee
        L_0x00e4:
            r0 = move-exception
            if (r2 == 0) goto L_0x00ea
            r2.close()     // Catch:{ IOException -> 0x00ea }
        L_0x00ea:
            throw r0
        L_0x00eb:
            if (r2 == 0) goto L_0x00ee
            goto L_0x00e0
        L_0x00ee:
            long r0 = java.lang.System.currentTimeMillis()
            r6.c = r0
            java.util.ArrayList<java.lang.String> r0 = r6.b
            r0.clear()
            return
        L_0x00fa:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00fa }
            throw r0
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.v():void");
    }

    private void w() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = com.igexin.push.util.c.d(d.g);
        }
    }

    public synchronized void a(String str) {
        this.a.add(str);
        try {
            if (this.a.size() <= 1 || this.a.size() >= 10) {
                notify();
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        super.b();
        while (true) {
            try {
                synchronized (this) {
                    while (true) {
                        long u = u();
                        if (u == 0) {
                            break;
                        }
                        wait(u);
                    }
                    while (true) {
                    }
                }
                v();
            } catch (Throwable unused) {
                v();
                return;
            }
        }
    }

    public int b_() {
        return -2147483637;
    }

    public void d() {
        super.d();
        this.m = true;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    /* access modifiers changed from: protected */
    public void e_() {
        super.e_();
        e = null;
    }

    public void j() {
        if (s() != null) {
            s().interrupt();
        }
    }
}
