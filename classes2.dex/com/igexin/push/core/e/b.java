package com.igexin.push.core.e;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.igexin.b.a.a.a;
import com.igexin.push.core.d;
import com.igexin.push.util.c;
import com.igexin.push.util.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class b implements c {
    private String a;
    private long b = 0;

    b() {
    }

    private boolean a() {
        try {
            boolean z = true;
            if (!TextUtils.isEmpty(this.a)) {
                if (this.b != 0) {
                    if (this.a.equals(d.u) && this.b == d.t) {
                        z = false;
                    }
                }
            }
            return z;
        } finally {
            this.a = d.u;
            this.b = d.t;
        }
    }

    public String a(Context context) {
        String str = null;
        try {
            com.igexin.b.a.c.b.a("BasicSDStorage|get device id from file : " + d.W, new Object[0]);
            byte[] a2 = c.a(d.W);
            if (a2 == null) {
                com.igexin.b.a.c.b.a("BasicSDStorage|read file device id = null", new Object[0]);
                return null;
            }
            String str2 = new String(a2, Key.STRING_CHARSET_NAME);
            try {
                com.igexin.b.a.c.b.a("BasicSDStorage|read file device id = " + str2, new Object[0]);
                return str2;
            } catch (Exception e) {
                e = e;
                str = str2;
            }
        } catch (Exception e2) {
            e = e2;
            com.igexin.b.a.c.b.a("BasicSDStorage|get device id from file : " + e.toString(), new Object[0]);
            return str;
        }
    }

    public void a(Context context, long j) {
        if (a()) {
            c.a();
        }
    }

    public void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            com.igexin.b.a.c.b.a("BasicSDStorage|save device id to file : " + d.W, new Object[0]);
            FileOutputStream fileOutputStream = null;
            ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
            try {
                if (writeLock.tryLock()) {
                    File file = new File(d.W);
                    if (file.exists() || file.createNewFile()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(d.W);
                        try {
                            fileOutputStream2.write(str.getBytes(Key.STRING_CHARSET_NAME));
                            fileOutputStream = fileOutputStream2;
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            try {
                                com.igexin.b.a.c.b.a("BasicSDStorage|" + e.toString(), new Object[0]);
                                k.a(fileOutputStream);
                                writeLock.unlock();
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            k.a(fileOutputStream);
                            writeLock.unlock();
                            throw th;
                        }
                    } else {
                        com.igexin.b.a.c.b.a("BasicSDStorage|create file : " + file.toString() + " failed !!!", new Object[0]);
                        k.a((Closeable) null);
                        writeLock.unlock();
                        return;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.igexin.b.a.c.b.a("BasicSDStorage|" + e.toString(), new Object[0]);
                k.a(fileOutputStream);
                writeLock.unlock();
            }
            k.a(fileOutputStream);
            writeLock.unlock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r1.equals("null") != false) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(android.content.Context r5) {
        /*
            r4 = this;
            r5 = 0
            r0 = 0
            java.lang.String r1 = com.igexin.push.core.d.V     // Catch:{ Exception -> 0x0035 }
            byte[] r1 = com.igexin.push.util.c.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0035 }
            if (r1 != 0) goto L_0x0012
            java.lang.String r1 = "BasicSDStorage | read file cid id = null"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0035 }
            com.igexin.b.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0035 }
            return r0
        L_0x0012:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0035 }
            java.lang.String r3 = com.igexin.push.core.d.E     // Catch:{ Exception -> 0x0035 }
            byte[] r1 = com.igexin.b.a.a.a.c(r1, r3)     // Catch:{ Exception -> 0x0035 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "\\|"
            java.lang.String[] r1 = r2.split(r1)     // Catch:{ Exception -> 0x0035 }
            int r2 = r1.length     // Catch:{ Exception -> 0x0035 }
            r3 = 2
            if (r2 <= r3) goto L_0x0035
            r1 = r1[r3]     // Catch:{ Exception -> 0x0035 }
            if (r1 == 0) goto L_0x0034
            java.lang.String r2 = "null"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x0034 }
            if (r2 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "BasicSDStorage|get cid from file cid = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            com.igexin.b.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.e.b.b(android.content.Context):java.lang.String");
    }

    public void b(Context context, String str) {
        if (a()) {
            c.a();
        }
    }

    public long c(Context context) {
        long j = 0;
        try {
            byte[] a2 = c.a(d.V);
            if (a2 == null) {
                com.igexin.b.a.c.b.a("BasicSDStorage|read session from file, not exist", new Object[0]);
                return 0;
            }
            String str = new String(a.c(a2, d.E));
            String substring = str.contains("null") ? str.substring(7) : str.substring(20);
            int indexOf = substring.indexOf("|");
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            long parseLong = Long.parseLong(substring);
            if (parseLong != 0) {
                j = parseLong;
            }
            com.igexin.b.a.c.b.a("BasicSDStorage|session : " + j, new Object[0]);
            return j;
        } catch (Exception e) {
            com.igexin.b.a.c.b.a("BasicSDStorage|" + e.toString(), new Object[0]);
        }
    }
}
