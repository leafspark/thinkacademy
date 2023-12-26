package com.igexin.push.core.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.b;
import com.igexin.b.a.d.e;
import com.igexin.b.b.a;
import com.igexin.push.core.d;
import com.igexin.push.f.b.f;
import com.igexin.push.util.EncryptUtils;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

public class i implements b {
    private static final String a = "com.igexin.push.core.b.i";
    private static i b;
    private Map<String, String> c = new TreeMap();
    private boolean d;

    private i() {
    }

    public static i a() {
        if (b == null) {
            b = new i();
        }
        return b;
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", str);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.replace("runtime", (String) null, contentValues);
        } else {
            SQLiteInstrumentation.replace(sQLiteDatabase, "runtime", (String) null, contentValues);
        }
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", bArr);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.replace("runtime", (String) null, contentValues);
        } else {
            SQLiteInstrumentation.replace(sQLiteDatabase, "runtime", (String) null, contentValues);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        if (r11 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (r11 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(android.database.sqlite.SQLiteDatabase r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r3 = "runtime"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            r2.<init>()     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            java.lang.String r5 = "id="
            r2.append(r5)     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            r2.append(r12)     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r12 = r11 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            if (r12 != 0) goto L_0x002c
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            goto L_0x0033
        L_0x002c:
            r2 = r11
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            android.database.Cursor r11 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
        L_0x0033:
            if (r11 == 0) goto L_0x0053
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x005e, all -> 0x004f }
            if (r12 == 0) goto L_0x0053
            int r12 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x005e, all -> 0x004f }
            byte[] r12 = r11.getBlob(r12)     // Catch:{ Exception -> 0x005e, all -> 0x004f }
            java.lang.String r0 = com.igexin.push.core.d.E     // Catch:{ Exception -> 0x005e, all -> 0x004f }
            byte[] r12 = com.igexin.b.a.a.a.c(r12, r0)     // Catch:{ Exception -> 0x005e, all -> 0x004f }
            if (r11 == 0) goto L_0x004e
            r11.close()
        L_0x004e:
            return r12
        L_0x004f:
            r12 = move-exception
            r1 = r11
            r11 = r12
            goto L_0x0057
        L_0x0053:
            if (r11 == 0) goto L_0x0063
            goto L_0x0060
        L_0x0056:
            r11 = move-exception
        L_0x0057:
            if (r1 == 0) goto L_0x005c
            r1.close()
        L_0x005c:
            throw r11
        L_0x005d:
            r11 = r1
        L_0x005e:
            if (r11 == 0) goto L_0x0063
        L_0x0060:
            r11.close()
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.i.a(android.database.sqlite.SQLiteDatabase, int):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r11 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r11 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(android.database.sqlite.SQLiteDatabase r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r3 = "runtime"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            r2.<init>()     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            java.lang.String r5 = "id="
            r2.append(r5)     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            r2.append(r12)     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r12 = r11 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            if (r12 != 0) goto L_0x002c
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            goto L_0x0033
        L_0x002c:
            r2 = r11
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
            android.database.Cursor r11 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0057, all -> 0x0050 }
        L_0x0033:
            if (r11 == 0) goto L_0x004d
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x0058, all -> 0x0049 }
            if (r12 == 0) goto L_0x004d
            int r12 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x0058, all -> 0x0049 }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x0058, all -> 0x0049 }
            if (r11 == 0) goto L_0x0048
            r11.close()
        L_0x0048:
            return r12
        L_0x0049:
            r12 = move-exception
            r1 = r11
            r11 = r12
            goto L_0x0051
        L_0x004d:
            if (r11 == 0) goto L_0x005d
            goto L_0x005a
        L_0x0050:
            r11 = move-exception
        L_0x0051:
            if (r1 == 0) goto L_0x0056
            r1.close()
        L_0x0056:
            throw r11
        L_0x0057:
            r11 = r1
        L_0x0058:
            if (r11 == 0) goto L_0x005d
        L_0x005a:
            r11.close()
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.i.b(android.database.sqlite.SQLiteDatabase, int):java.lang.String");
    }

    private void e() {
        String str = d.w;
        if (TextUtils.isEmpty(str) || str.length() <= 8) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("V");
                sb.append(a.a(h() + d.e + UUID.randomUUID()));
                str = sb.toString();
            } catch (Throwable th) {
                b.a(a + "|" + th.toString(), new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("V");
                sb2.append(h());
                str = sb2.toString();
            }
        }
        d.D = "A-" + str + "-" + System.currentTimeMillis();
        if (d.D.length() >= 64) {
            try {
                d.D = d.D.substring(0, 62);
            } catch (Throwable th2) {
                b.a(a + "|" + th2.toString(), new Object[0]);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r1 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        if (r1 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        if (com.igexin.push.core.d.E != null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (com.igexin.push.core.d.w != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        r11 = "cantgetimei";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        r11 = com.igexin.push.core.d.w;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        com.igexin.push.core.d.E = com.igexin.b.b.a.a(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(android.database.sqlite.SQLiteDatabase r11) {
        /*
            r10 = this;
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r3 = "runtime"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            java.lang.String r5 = "id=?"
            java.lang.String r2 = "25"
            java.lang.String[] r6 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r2 = r11 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            if (r2 != 0) goto L_0x0021
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            goto L_0x0028
        L_0x0021:
            r2 = r11
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            android.database.Cursor r11 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
        L_0x0028:
            r1 = r11
            if (r1 == 0) goto L_0x004e
            boolean r11 = r1.moveToFirst()     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            if (r11 == 0) goto L_0x004e
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            byte[] r0 = r1.getBlob(r0)     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            android.content.Context r2 = com.igexin.push.core.d.g     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            java.lang.String r2 = com.igexin.b.b.a.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            byte[] r0 = com.igexin.b.a.a.a.c(r0, r2)     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            r11.<init>(r0)     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            com.igexin.push.core.d.E = r11     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
        L_0x004e:
            if (r1 == 0) goto L_0x005d
            goto L_0x005a
        L_0x0051:
            r11 = move-exception
            if (r1 == 0) goto L_0x0057
            r1.close()
        L_0x0057:
            throw r11
        L_0x0058:
            if (r1 == 0) goto L_0x005d
        L_0x005a:
            r1.close()
        L_0x005d:
            java.lang.String r11 = com.igexin.push.core.d.E
            if (r11 != 0) goto L_0x0070
            java.lang.String r11 = com.igexin.push.core.d.w
            if (r11 != 0) goto L_0x0068
            java.lang.String r11 = "cantgetimei"
            goto L_0x006a
        L_0x0068:
            java.lang.String r11 = com.igexin.push.core.d.w
        L_0x006a:
            java.lang.String r11 = com.igexin.b.b.a.a((java.lang.String) r11)
            com.igexin.push.core.d.E = r11
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.i.e(android.database.sqlite.SQLiteDatabase):void");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        String b2 = b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(b2)) {
            if (b2.equals("null")) {
                b2 = null;
            }
            d.A = b2;
        }
    }

    private boolean f() {
        return c.b().a(new aa(this), false, true);
    }

    /* access modifiers changed from: private */
    public void g() {
        com.igexin.push.core.e.d.a().b(d.g, d.u);
        com.igexin.push.core.e.d.a().a(d.g, d.t);
        String c2 = com.igexin.push.util.c.c();
        if (c2 == null || c2.length() <= 5) {
            com.igexin.push.util.c.e();
        }
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        String b2 = b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(b2)) {
            if (b2.equals("null")) {
                b2 = null;
            }
            d.B = b2;
        }
    }

    private String h() {
        Random random = new Random(Math.abs(new Random().nextLong()));
        String str = "";
        for (int i = 0; i < 15; i++) {
            str = str + random.nextInt(10);
        }
        return str;
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        String b2 = b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(b2)) {
            if (b2.equals("null")) {
                b2 = null;
            }
            d.C = b2;
        }
    }

    /* access modifiers changed from: private */
    public byte[] h(String str) {
        return EncryptUtils.getBytesEncrypted(str.getBytes());
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        String b2 = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(b2)) {
            if (b2.equals("null")) {
                b2 = null;
            }
            d.D = b2;
        }
    }

    private void j(SQLiteDatabase sQLiteDatabase) {
        byte[] a2 = a(sQLiteDatabase, 1);
        if (a2 != null) {
            try {
                String str = new String(a2);
                d.t = str.equals("null") ? 0 : Long.parseLong(str);
            } catch (Exception unused) {
            }
            b.a(a + "|db version changed, save session = " + d.t, new Object[0]);
        }
    }

    private void k(SQLiteDatabase sQLiteDatabase) {
        byte[] a2 = a(sQLiteDatabase, 20);
        if (a2 != null) {
            String str = new String(a2);
            if (str.equals("null")) {
                str = null;
            }
            d.v = str;
            d.u = str;
            b.a(a + "|db version changed, save cid = " + str, new Object[0]);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public boolean a(int i) {
        d.T = i;
        return c.b().a(new p(this), false, true);
    }

    public boolean a(long j) {
        d.a(j);
        return c.b().a(new ab(this), false, true);
    }

    public boolean a(String str) {
        return c.b().a(new z(this, str), false, true);
    }

    public boolean a(String str, String str2, long j) {
        d.t = j;
        if (TextUtils.isEmpty(d.A)) {
            d.A = str2;
        }
        d.u = str;
        return f();
    }

    public boolean a(String str, boolean z) {
        c b2;
        e rVar;
        if (str == null) {
            return false;
        }
        String str2 = null;
        if (z) {
            if (!str.equals(d.ao)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                d.ao = str2;
                b2 = c.b();
                rVar = new q(this, str);
            }
            return false;
        }
        if (!str.equals(d.ap)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            d.ap = str2;
            b2 = c.b();
            rVar = new r(this, str);
        }
        return false;
        return b2.a(rVar, false, true);
    }

    public boolean a(boolean z) {
        if (d.O == z) {
            return false;
        }
        d.O = z;
        if (!z) {
            com.igexin.push.f.a.k();
        }
        return c.b().a(new n(this), false, true);
    }

    public void b() {
        c.b().a(new j(this), false, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r15v1 */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r15v6 */
    /* JADX WARNING: type inference failed for: r15v8 */
    /* JADX WARNING: type inference failed for: r15v9 */
    /* JADX WARNING: type inference failed for: r15v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:190:?, code lost:
        com.igexin.push.core.d.t = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x035f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0360, code lost:
        r18 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0363, code lost:
        if (r2 != null) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0366, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0367, code lost:
        if (r18 != null) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0369, code lost:
        r18.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x036c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:?, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0372, code lost:
        if (r2 == null) goto L_0x0377;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0374, code lost:
        r2.close();
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x037b, code lost:
        if (com.igexin.push.core.d.t != 0) goto L_0x0396;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x037d, code lost:
        r2 = com.igexin.push.util.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0383, code lost:
        if (r2 == 0) goto L_0x0396;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0385, code lost:
        com.igexin.push.core.d.t = r2;
        a(r10, r14, com.igexin.push.util.EncryptUtils.getBytesEncrypted(java.lang.String.valueOf(r2).getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0398, code lost:
        if (com.igexin.push.core.d.u != null) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x039a, code lost:
        r0 = com.igexin.push.util.c.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x039e, code lost:
        if (r0 == null) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x03a0, code lost:
        com.igexin.push.core.d.v = r0;
        com.igexin.push.core.d.u = r0;
        a(r10, r12, com.igexin.push.util.EncryptUtils.getBytesEncrypted(com.igexin.push.core.d.u.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x03b3, code lost:
        if (com.igexin.push.core.d.u != null) goto L_0x03d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x03b9, code lost:
        if (com.igexin.push.core.d.t == 0) goto L_0x03d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03bb, code lost:
        com.igexin.push.core.d.v = com.igexin.b.b.a.a(java.lang.String.valueOf(com.igexin.push.core.d.t));
        com.igexin.push.core.d.a(com.igexin.push.core.d.t);
        a(r10, r12, com.igexin.push.util.EncryptUtils.getBytesEncrypted(com.igexin.push.core.d.u.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x03e1, code lost:
        if ("cfcd208495d565ef66e7dff9f98764da".equals(com.igexin.push.core.d.u) != false) goto L_0x03f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x03e5, code lost:
        if (com.igexin.push.core.d.u == null) goto L_0x040e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x03ef, code lost:
        if (com.igexin.push.core.d.u.matches("([a-f]|[0-9]){32}") != false) goto L_0x040e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x03f5, code lost:
        if (com.igexin.push.core.d.t == 0) goto L_0x0408;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x03f7, code lost:
        a().a(com.igexin.push.core.d.t);
        com.igexin.push.core.d.v = com.igexin.push.core.d.u;
        com.igexin.push.util.c.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0408, code lost:
        com.igexin.push.core.d.v = null;
        com.igexin.push.core.d.u = "null";
        com.igexin.push.core.d.t = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0414, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.ak) != false) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x041c, code lost:
        if ("null".equals(com.igexin.push.core.d.ak) == false) goto L_0x0433;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x041e, code lost:
        com.igexin.push.core.d.ak = com.igexin.b.b.a.a(32);
        a(r10, 14, com.igexin.push.util.EncryptUtils.getBytesEncrypted(com.igexin.push.core.d.ak.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0433, code lost:
        r0 = com.igexin.push.util.c.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x043a, code lost:
        if (com.igexin.push.core.d.A != null) goto L_0x044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x043c, code lost:
        if (r0 == null) goto L_0x044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0442, code lost:
        if (r0.length() <= 5) goto L_0x044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0444, code lost:
        com.igexin.push.core.d.A = r0;
        a(r10, 2, com.igexin.push.core.d.A);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x044e, code lost:
        if (com.igexin.push.core.d.D != null) goto L_0x0471;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0450, code lost:
        e();
        a(r10, 3, com.igexin.push.core.d.D);
        com.igexin.b.a.c.b.a(a, "new registerId : " + com.igexin.push.core.d.D);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0475, code lost:
        if (com.igexin.push.config.l.H == false) goto L_0x0497;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0477, code lost:
        r0 = new com.igexin.push.core.b.d(com.igexin.push.core.d.g).e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0486, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x0497;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x048e, code lost:
        if (r0.equals(com.igexin.push.core.d.B) != false) goto L_0x0497;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0490, code lost:
        com.igexin.push.core.d.B = r0;
        a(r10, 46, com.igexin.push.core.d.B);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0499, code lost:
        if (r1.d == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x049b, code lost:
        r1.d = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x04a3, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.E) != false) goto L_0x04be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x04a5, code lost:
        a(r10, 25, com.igexin.b.a.a.a.d(com.igexin.push.core.d.E.getBytes(), com.igexin.b.b.a.a(com.igexin.push.core.d.g.getPackageName())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x04c2, code lost:
        if (com.igexin.push.core.d.t == 0) goto L_0x04d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x04c4, code lost:
        a(r10, r14, com.igexin.push.util.EncryptUtils.getBytesEncrypted(java.lang.String.valueOf(com.igexin.push.core.d.t).getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x04db, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.u) != false) goto L_0x04ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x04dd, code lost:
        a(r10, r12, com.igexin.push.util.EncryptUtils.getBytesEncrypted(com.igexin.push.core.d.u.getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x04f0, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.A) != false) goto L_0x0500;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x04f8, code lost:
        if (com.igexin.push.core.d.A.length() <= 5) goto L_0x0500;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x04fa, code lost:
        a(r10, 2, com.igexin.push.core.d.A);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0506, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.D) != false) goto L_0x050e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0508, code lost:
        a(r10, 3, com.igexin.push.core.d.D);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0514, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.B) != false) goto L_0x051b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0516, code lost:
        a(r10, 46, com.igexin.push.core.d.B);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0521, code lost:
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.d.C) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0523, code lost:
        a(r10, 48, com.igexin.push.core.d.C);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r15v5, types: [int] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:189:0x0339 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x035f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0366 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0369  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.database.sqlite.SQLiteDatabase r28) {
        /*
            r27 = this;
            r1 = r27
            r10 = r28
            java.lang.String r11 = "null"
            r27.e((android.database.sqlite.SQLiteDatabase) r28)
            r13 = 14
            r9 = 20
            r8 = 1
            r7 = 0
            r16 = 0
            r18 = 0
            java.lang.String r20 = "runtime"
            java.lang.String r0 = "id"
            java.lang.String r2 = "value"
            java.lang.String[] r21 = new java.lang.String[]{r0, r2}     // Catch:{ Exception -> 0x036d, all -> 0x0366 }
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            java.lang.String r26 = "id"
            boolean r0 = r10 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x036d, all -> 0x0366 }
            if (r0 != 0) goto L_0x0043
            r5 = 0
            r6 = 0
            r0 = 0
            r19 = 0
            r2 = r28
            r3 = r20
            r4 = r21
            r15 = r7
            r7 = r0
            r14 = r8
            r8 = r19
            r12 = r9
            r9 = r26
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0370, all -> 0x0366 }
            goto L_0x004e
        L_0x0043:
            r15 = r7
            r14 = r8
            r12 = r9
            r19 = r10
            android.database.sqlite.SQLiteDatabase r19 = (android.database.sqlite.SQLiteDatabase) r19     // Catch:{ Exception -> 0x0370, all -> 0x0366 }
            android.database.Cursor r0 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.query(r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x0370, all -> 0x0366 }
        L_0x004e:
            r2 = r0
            if (r2 == 0) goto L_0x0363
        L_0x0051:
            boolean r0 = r2.moveToNext()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x0363
            int r0 = r2.getInt(r15)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r3 = 31
            r4 = 30
            if (r0 == r14) goto L_0x008a
            if (r0 == r13) goto L_0x008a
            r5 = 19
            if (r0 == r5) goto L_0x008a
            if (r0 == r12) goto L_0x008a
            r5 = 23
            if (r0 == r5) goto L_0x008a
            r5 = 25
            if (r0 == r5) goto L_0x008a
            r5 = 22
            if (r0 == r5) goto L_0x008a
            if (r0 == r3) goto L_0x008a
            if (r0 == r4) goto L_0x008a
            r5 = 49
            if (r0 == r5) goto L_0x008a
            r5 = 50
            if (r0 != r5) goto L_0x0082
            goto L_0x008a
        L_0x0082:
            java.lang.String r5 = r2.getString(r14)     // Catch:{ all -> 0x033d }
            r6 = r5
            r5 = r18
            goto L_0x0098
        L_0x008a:
            byte[] r5 = r2.getBlob(r14)     // Catch:{ all -> 0x033d }
            if (r5 == 0) goto L_0x0096
            java.lang.String r6 = com.igexin.push.core.d.E     // Catch:{ all -> 0x033d }
            byte[] r5 = com.igexin.b.a.a.a.c(r5, r6)     // Catch:{ all -> 0x033d }
        L_0x0096:
            r6 = r18
        L_0x0098:
            if (r5 != 0) goto L_0x009d
            if (r6 != 0) goto L_0x009d
            goto L_0x0051
        L_0x009d:
            if (r0 == r14) goto L_0x0323
            r7 = 2
            if (r0 == r7) goto L_0x0317
            r7 = 3
            if (r0 == r7) goto L_0x030b
            r7 = 4
            if (r0 == r7) goto L_0x02f7
            r7 = 6
            if (r0 == r7) goto L_0x02e6
            r7 = 8
            if (r0 == r7) goto L_0x02d5
            r7 = 40
            if (r0 == r7) goto L_0x02bd
            if (r0 == r4) goto L_0x028f
            if (r0 == r3) goto L_0x0261
            switch(r0) {
                case 11: goto L_0x0250;
                case 12: goto L_0x023f;
                case 13: goto L_0x0233;
                case 14: goto L_0x022a;
                case 15: goto L_0x021c;
                case 16: goto L_0x020b;
                case 17: goto L_0x01ff;
                case 18: goto L_0x01ef;
                case 19: goto L_0x01de;
                case 20: goto L_0x01cb;
                case 21: goto L_0x01ba;
                case 22: goto L_0x018c;
                case 23: goto L_0x015e;
                default: goto L_0x00ba;
            }
        L_0x00ba:
            switch(r0) {
                case 46: goto L_0x0152;
                case 47: goto L_0x0142;
                case 48: goto L_0x0136;
                case 49: goto L_0x0108;
                case 50: goto L_0x00da;
                case 51: goto L_0x00c9;
                case 52: goto L_0x00be;
                default: goto L_0x00bd;
            }
        L_0x00bd:
            goto L_0x0051
        L_0x00be:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x00c6
            r6 = r18
        L_0x00c6:
            com.igexin.push.core.d.ax = r6     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x00c9:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x00d2
            r3 = r16
            goto L_0x00d6
        L_0x00d2:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x00d6:
            com.igexin.push.core.d.Y = r3     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x00da:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r3 == 0) goto L_0x00e7
            r0 = r18
        L_0x00e7:
            com.igexin.push.core.d.ar = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = "|read last mobileRedirectCmList = "
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = com.igexin.push.core.d.ar     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0108:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r3 == 0) goto L_0x0115
            r0 = r18
        L_0x0115:
            com.igexin.push.core.d.aq = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = "|read last wifiRedirectCmList = "
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = com.igexin.push.core.d.aq     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0136:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x013e
            r6 = r18
        L_0x013e:
            com.igexin.push.core.d.C = r6     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0142:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x014a
            r7 = r15
            goto L_0x014e
        L_0x014a:
            int r7 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x014e:
            com.igexin.push.core.d.au = r7     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0152:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x015a
            r6 = r18
        L_0x015a:
            com.igexin.push.core.d.B = r6     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x015e:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r3 == 0) goto L_0x016b
            r0 = r18
        L_0x016b:
            com.igexin.push.core.d.am = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = "|DT_ read last mobile result = "
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = com.igexin.push.core.d.am     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x018c:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r3 == 0) goto L_0x0199
            r0 = r18
        L_0x0199:
            com.igexin.push.core.d.an = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = "|DT_ read last wifi result = "
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = com.igexin.push.core.d.an     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x01ba:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x01c3
            r3 = r16
            goto L_0x01c7
        L_0x01c3:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x01c7:
            com.igexin.push.core.d.al = r3     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x01cb:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r3 == 0) goto L_0x01d8
            r0 = r18
        L_0x01d8:
            com.igexin.push.core.d.v = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.push.core.d.u = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x01de:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r3 == 0) goto L_0x01eb
            r0 = r18
        L_0x01eb:
            com.igexin.push.core.d.z = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x01ef:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x01f7
            r7 = r15
            goto L_0x01fb
        L_0x01f7:
            int r7 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x01fb:
            com.igexin.push.core.d.T = r7     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x01ff:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x0207
            r6 = r18
        L_0x0207:
            com.igexin.push.core.d.R = r6     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x020b:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x0214
            r3 = r16
            goto L_0x0218
        L_0x0214:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x0218:
            com.igexin.push.core.d.P = r3     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x021c:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 != 0) goto L_0x0051
            boolean r0 = java.lang.Boolean.parseBoolean(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.push.core.d.O = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x022a:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.push.core.d.ak = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0233:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x023b
            r6 = r18
        L_0x023b:
            com.igexin.push.core.d.N = r6     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x023f:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x0248
            r3 = r16
            goto L_0x024c
        L_0x0248:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x024c:
            com.igexin.push.core.d.M = r3     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0250:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x0259
            r3 = r16
            goto L_0x025d
        L_0x0259:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x025d:
            com.igexin.push.core.d.L = r3     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0261:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r3 == 0) goto L_0x026e
            r0 = r18
        L_0x026e:
            com.igexin.push.core.d.ao = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = "|DT_ read last domainMobileStatus = "
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = com.igexin.push.core.d.ao     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x028f:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r3 == 0) goto L_0x029c
            r0 = r18
        L_0x029c:
            com.igexin.push.core.d.ap = r0     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = "|DT_ read last domainWifiStatus = "
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r3 = com.igexin.push.core.d.ap     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.append(r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x02bd:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 != 0) goto L_0x02cb
            boolean r0 = java.lang.Boolean.parseBoolean(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x02cb
            r8 = r14
            goto L_0x02cc
        L_0x02cb:
            r8 = r15
        L_0x02cc:
            com.igexin.push.d.b r0 = com.igexin.push.d.b.a()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.a((boolean) r8)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x02d5:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x02de
            r3 = r16
            goto L_0x02e2
        L_0x02de:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x02e2:
            com.igexin.push.core.d.J = r3     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x02e6:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x02ef
            r3 = r16
            goto L_0x02f3
        L_0x02ef:
            long r3 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
        L_0x02f3:
            com.igexin.push.core.d.I = r3     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x02f7:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 != 0) goto L_0x0306
            boolean r0 = java.lang.Boolean.parseBoolean(r6)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x0304
            goto L_0x0306
        L_0x0304:
            r8 = r15
            goto L_0x0307
        L_0x0306:
            r8 = r14
        L_0x0307:
            com.igexin.push.core.d.m = r8     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x030b:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x0313
            r6 = r18
        L_0x0313:
            com.igexin.push.core.d.D = r6     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0317:
            boolean r0 = r6.equals(r11)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            if (r0 == 0) goto L_0x031f
            r6 = r18
        L_0x031f:
            com.igexin.push.core.d.A = r6     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x0323:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            boolean r3 = r0.equals(r11)     // Catch:{ Exception -> 0x0339, all -> 0x035f }
            if (r3 == 0) goto L_0x0331
            r3 = r16
            goto L_0x0335
        L_0x0331:
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0339, all -> 0x035f }
        L_0x0335:
            com.igexin.push.core.d.t = r3     // Catch:{ Exception -> 0x0339, all -> 0x035f }
            goto L_0x0051
        L_0x0339:
            com.igexin.push.core.d.t = r16     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x033d:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r3.<init>()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r4 = a     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r3.append(r4)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r4 = "|"
            r3.append(r4)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            r3.append(r0)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0372, all -> 0x035f }
            goto L_0x0051
        L_0x035f:
            r0 = move-exception
            r18 = r2
            goto L_0x0367
        L_0x0363:
            if (r2 == 0) goto L_0x0377
            goto L_0x0374
        L_0x0366:
            r0 = move-exception
        L_0x0367:
            if (r18 == 0) goto L_0x036c
            r18.close()
        L_0x036c:
            throw r0
        L_0x036d:
            r15 = r7
            r14 = r8
            r12 = r9
        L_0x0370:
            r2 = r18
        L_0x0372:
            if (r2 == 0) goto L_0x0377
        L_0x0374:
            r2.close()
        L_0x0377:
            long r2 = com.igexin.push.core.d.t
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x0396
            long r2 = com.igexin.push.util.c.d()
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0396
            com.igexin.push.core.d.t = r2
            java.lang.String r0 = java.lang.String.valueOf(r2)
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r14, (byte[]) r0)
        L_0x0396:
            java.lang.String r0 = com.igexin.push.core.d.u
            if (r0 != 0) goto L_0x03b1
            java.lang.String r0 = com.igexin.push.util.c.b()
            if (r0 == 0) goto L_0x03b1
            com.igexin.push.core.d.v = r0
            com.igexin.push.core.d.u = r0
            java.lang.String r0 = com.igexin.push.core.d.u
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r12, (byte[]) r0)
        L_0x03b1:
            java.lang.String r0 = com.igexin.push.core.d.u
            if (r0 != 0) goto L_0x03d9
            long r2 = com.igexin.push.core.d.t
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x03d9
            long r2 = com.igexin.push.core.d.t
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r0 = com.igexin.b.b.a.a((java.lang.String) r0)
            com.igexin.push.core.d.v = r0
            long r2 = com.igexin.push.core.d.t
            com.igexin.push.core.d.a((long) r2)
            java.lang.String r0 = com.igexin.push.core.d.u
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r12, (byte[]) r0)
        L_0x03d9:
            java.lang.String r0 = com.igexin.push.core.d.u
            java.lang.String r2 = "cfcd208495d565ef66e7dff9f98764da"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x03f1
            java.lang.String r0 = com.igexin.push.core.d.u
            if (r0 == 0) goto L_0x040e
            java.lang.String r0 = com.igexin.push.core.d.u
            java.lang.String r2 = "([a-f]|[0-9]){32}"
            boolean r0 = r0.matches(r2)
            if (r0 != 0) goto L_0x040e
        L_0x03f1:
            long r2 = com.igexin.push.core.d.t
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0408
            com.igexin.push.core.b.i r0 = a()
            long r2 = com.igexin.push.core.d.t
            r0.a((long) r2)
            java.lang.String r0 = com.igexin.push.core.d.u
            com.igexin.push.core.d.v = r0
            com.igexin.push.util.c.f()
            goto L_0x040e
        L_0x0408:
            com.igexin.push.core.d.v = r18
            com.igexin.push.core.d.u = r11
            com.igexin.push.core.d.t = r16
        L_0x040e:
            java.lang.String r0 = com.igexin.push.core.d.ak
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x041e
            java.lang.String r0 = com.igexin.push.core.d.ak
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x0433
        L_0x041e:
            r0 = 32
            java.lang.String r0 = com.igexin.b.b.a.a((int) r0)
            com.igexin.push.core.d.ak = r0
            java.lang.String r0 = com.igexin.push.core.d.ak
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r13, (byte[]) r0)
        L_0x0433:
            java.lang.String r0 = com.igexin.push.util.c.c()
            java.lang.String r2 = com.igexin.push.core.d.A
            r3 = 5
            if (r2 != 0) goto L_0x044c
            if (r0 == 0) goto L_0x044c
            int r2 = r0.length()
            if (r2 <= r3) goto L_0x044c
            com.igexin.push.core.d.A = r0
            java.lang.String r0 = com.igexin.push.core.d.A
            r2 = 2
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r2, (java.lang.String) r0)
        L_0x044c:
            java.lang.String r0 = com.igexin.push.core.d.D
            if (r0 != 0) goto L_0x0471
            r27.e()
            java.lang.String r0 = com.igexin.push.core.d.D
            r2 = 3
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r2, (java.lang.String) r0)
            java.lang.String r0 = a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "new registerId : "
            r2.append(r4)
            java.lang.String r4 = com.igexin.push.core.d.D
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.String) r2)
        L_0x0471:
            boolean r0 = com.igexin.push.config.l.H
            r2 = 46
            if (r0 == 0) goto L_0x0497
            com.igexin.push.core.b.d r0 = new com.igexin.push.core.b.d
            android.content.Context r4 = com.igexin.push.core.d.g
            r0.<init>(r4)
            java.lang.String r0 = r0.e()
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x0497
            java.lang.String r4 = com.igexin.push.core.d.B
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x0497
            com.igexin.push.core.d.B = r0
            java.lang.String r0 = com.igexin.push.core.d.B
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r2, (java.lang.String) r0)
        L_0x0497:
            boolean r0 = r1.d
            if (r0 == 0) goto L_0x052a
            r1.d = r15
            java.lang.String r0 = com.igexin.push.core.d.E
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04be
            java.lang.String r0 = com.igexin.push.core.d.E
            byte[] r0 = r0.getBytes()
            android.content.Context r4 = com.igexin.push.core.d.g
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r4 = com.igexin.b.b.a.a((java.lang.String) r4)
            byte[] r0 = com.igexin.b.a.a.a.d(r0, r4)
            r4 = 25
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r4, (byte[]) r0)
        L_0x04be:
            long r4 = com.igexin.push.core.d.t
            int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x04d5
            long r4 = com.igexin.push.core.d.t
            java.lang.String r0 = java.lang.String.valueOf(r4)
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r14, (byte[]) r0)
        L_0x04d5:
            java.lang.String r0 = com.igexin.push.core.d.u
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04ea
            java.lang.String r0 = com.igexin.push.core.d.u
            byte[] r0 = r0.getBytes()
            byte[] r0 = com.igexin.push.util.EncryptUtils.getBytesEncrypted(r0)
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r12, (byte[]) r0)
        L_0x04ea:
            java.lang.String r0 = com.igexin.push.core.d.A
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0500
            java.lang.String r0 = com.igexin.push.core.d.A
            int r0 = r0.length()
            if (r0 <= r3) goto L_0x0500
            java.lang.String r0 = com.igexin.push.core.d.A
            r3 = 2
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r3, (java.lang.String) r0)
        L_0x0500:
            java.lang.String r0 = com.igexin.push.core.d.D
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x050e
            java.lang.String r0 = com.igexin.push.core.d.D
            r3 = 3
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r3, (java.lang.String) r0)
        L_0x050e:
            java.lang.String r0 = com.igexin.push.core.d.B
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x051b
            java.lang.String r0 = com.igexin.push.core.d.B
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r2, (java.lang.String) r0)
        L_0x051b:
            java.lang.String r0 = com.igexin.push.core.d.C
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x052a
            r0 = 48
            java.lang.String r2 = com.igexin.push.core.d.C
            r1.a((android.database.sqlite.SQLiteDatabase) r10, (int) r0, (java.lang.String) r2)
        L_0x052a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.i.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public boolean b(int i) {
        if (d.au == i) {
            return false;
        }
        d.au = i;
        return c.b().a(new v(this), false, true);
    }

    public boolean b(long j) {
        d.al = j;
        b.a(a + "|save idc config failed time : " + j, new Object[0]);
        return c.b().a(new k(this, j), false, true);
    }

    public boolean b(String str) {
        d.A = str;
        return c.b().a(new ac(this), false, true);
    }

    public boolean b(String str, boolean z) {
        c b2;
        e tVar;
        if (str == null) {
            return false;
        }
        String str2 = null;
        if (z) {
            if (!str.equals(d.am)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                d.am = str2;
                b2 = c.b();
                tVar = new s(this, str);
            }
            return false;
        }
        if (!str.equals(d.an)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            d.an = str2;
            b2 = c.b();
            tVar = new t(this, str);
        }
        return false;
        return b2.a(tVar, false, true);
    }

    public boolean b(boolean z) {
        return c.b().a(new w(this, z), false, true);
    }

    public void c() {
        d.t = 0;
        d.u = "null";
        f();
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, 1, com.igexin.b.a.a.a.d(String.valueOf(d.t).getBytes(), d.E));
        a(sQLiteDatabase, 4, String.valueOf(d.m));
        a(sQLiteDatabase, 8, String.valueOf(d.J));
        a(sQLiteDatabase, 3, d.D);
        a(sQLiteDatabase, 11, String.valueOf(d.L));
        a(sQLiteDatabase, 12, String.valueOf(d.M));
        a(sQLiteDatabase, 20, com.igexin.b.a.a.a.d(d.u.getBytes(), d.E));
        a(sQLiteDatabase, 2, d.A);
        a(sQLiteDatabase, 25, com.igexin.b.a.a.a.d(d.E.getBytes(), a.a(d.g.getPackageName())));
    }

    public boolean c(long j) {
        if (d.L == j) {
            return false;
        }
        d.L = j;
        return c.b().a(new l(this), false, true);
    }

    public boolean c(String str) {
        d.B = str;
        return c.b().a(new ad(this), false, true);
    }

    public boolean c(String str, boolean z) {
        if (str == null) {
            return false;
        }
        String str2 = str.equals("null") ? null : str;
        if (z && !TextUtils.equals(d.ar, str)) {
            d.ar = str2;
        } else if (z || TextUtils.equals(d.aq, str)) {
            return false;
        } else {
            d.aq = str2;
        }
        b.a(a + "|saveLastRedirectCmList isMobile = " + z + ", lastRedirectCmList = " + str, new Object[0]);
        return c.b().a(new y(this, z, str), false, true);
    }

    public void d() {
        b.a(a + "| found a duplicate cid " + d.u, new Object[0]);
        d.D = null;
        e();
        a().a(d.D);
        a().c();
        d.q = 0;
        f.i().a(SystemClock.elapsedRealtime());
    }

    public void d(SQLiteDatabase sQLiteDatabase) {
        this.d = true;
        e(sQLiteDatabase);
        j(sQLiteDatabase);
        k(sQLiteDatabase);
        i(sQLiteDatabase);
        f(sQLiteDatabase);
        g(sQLiteDatabase);
        h(sQLiteDatabase);
    }

    public boolean d(long j) {
        if (d.I == j) {
            return false;
        }
        d.I = j;
        return c.b().a(new u(this), false, true);
    }

    public boolean d(String str) {
        d.C = str;
        return c.b().a(new ae(this), false, true);
    }

    public boolean e(String str) {
        if (str == null || str.equals(d.N)) {
            return false;
        }
        d.N = str;
        c.b().a(new m(this), false, true);
        return true;
    }

    public boolean f(String str) {
        if (str.equals(d.R)) {
            return false;
        }
        d.R = str;
        return c.b().a(new o(this), false, true);
    }

    public boolean g(String str) {
        d.ax = str;
        return c.b().a(new x(this, str), false, true);
    }
}
