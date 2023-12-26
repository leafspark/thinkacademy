package com.igexin.push.extension.distribution.basic.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.igexin.b.a.c.b;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.e.a;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;

public class c {
    private static final String a = ("EXT-" + com.bonree.sdk.ao.c.b);
    private static c d;
    private a b;
    private Context c;
    private final String e = "/sdcard/libs//com.getui.sdk.deviceId.db";

    private c(Context context) {
        this.c = context;
    }

    public static c a() {
        if (d == null) {
            d = new c(e.a);
        }
        return d;
    }

    private void a(File file) {
        for (File file2 : file.listFiles()) {
            while (file2.exists()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (!file2.delete()) {
                    a(file2);
                }
            }
        }
        file.delete();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009c, code lost:
        if (r3 != null) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c7, code lost:
        if (r3 != null) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cd A[SYNTHETIC, Splitter:B:32:0x00cd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = a
            r0.append(r1)
            java.lang.String r2 = "|save deviceId = "
            r0.append(r2)
            r0.append(r7)
            java.lang.String r2 = " to "
            r0.append(r2)
            java.lang.String r2 = r6.e
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = new java.util.concurrent.locks.ReentrantReadWriteLock
            r0.<init>()
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r3 = 0
            boolean r4 = r0.tryLock()     // Catch:{ Exception -> 0x00a7 }
            if (r4 == 0) goto L_0x009c
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r5 = r6.e     // Catch:{ Exception -> 0x00a7 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00a7 }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x00a7 }
            if (r5 != 0) goto L_0x006f
            boolean r5 = r4.createNewFile()     // Catch:{ Exception -> 0x00a7 }
            if (r5 != 0) goto L_0x006f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r7.<init>()     // Catch:{ Exception -> 0x00a7 }
            r7.append(r1)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "|create file "
            r7.append(r1)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x00a7 }
            r7.append(r1)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = " failed"
            r7.append(r1)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00a7 }
            com.igexin.b.a.c.b.a((java.lang.String) r7, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x00a7 }
            r0.unlock()
            return
        L_0x006f:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r4 = r6.e     // Catch:{ Exception -> 0x00a7 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r3.<init>()     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            java.lang.String r4 = "V1|"
            r3.append(r4)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r3.append(r7)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            java.lang.String r3 = "utf-8"
            byte[] r7 = r7.getBytes(r3)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            byte[] r7 = com.igexin.b.b.a.b(r7)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r1.write(r7)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r3 = r1
            goto L_0x009c
        L_0x0096:
            r7 = move-exception
            r3 = r1
            goto L_0x00cb
        L_0x0099:
            r7 = move-exception
            r3 = r1
            goto L_0x00a8
        L_0x009c:
            if (r3 == 0) goto L_0x00a1
        L_0x009e:
            r3.close()     // Catch:{ Exception -> 0x00a1 }
        L_0x00a1:
            r0.unlock()
            goto L_0x00ca
        L_0x00a5:
            r7 = move-exception
            goto L_0x00cb
        L_0x00a7:
            r7 = move-exception
        L_0x00a8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = a     // Catch:{ all -> 0x00a5 }
            r1.append(r4)     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = "|"
            r1.append(r4)     // Catch:{ all -> 0x00a5 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a5 }
            r1.append(r7)     // Catch:{ all -> 0x00a5 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x00a5 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a5 }
            com.igexin.b.a.c.b.a((java.lang.String) r7, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00a5 }
            if (r3 == 0) goto L_0x00a1
            goto L_0x009e
        L_0x00ca:
            return
        L_0x00cb:
            if (r3 == 0) goto L_0x00d0
            r3.close()     // Catch:{ Exception -> 0x00d0 }
        L_0x00d0:
            r0.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.c.c.b(java.lang.String):void");
    }

    private void c(String str) {
        try {
            if (e.l.a()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", 2);
                contentValues.put("value", str);
                e.l.a("runtime", (String) null, contentValues);
                e.l.close();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:2|(9:3|4|5|6|(3:7|8|(1:10)(1:48))|11|(2:15|16)|17|18)|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0073, code lost:
        if (r3 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[SYNTHETIC, Splitter:B:30:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068 A[SYNTHETIC, Splitter:B:34:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070 A[SYNTHETIC, Splitter:B:42:0x0070] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String g() {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r7.e
            r0.<init>(r1)
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 == 0) goto L_0x0076
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            java.lang.String r3 = r7.e     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            r3.<init>()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
        L_0x001e:
            int r4 = r2.read(r0)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L_0x002a
            r3.write(r0, r6, r4)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            goto L_0x001e
        L_0x002a:
            byte[] r0 = r3.toByteArray()     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            byte[] r0 = com.igexin.b.b.a.c(r0)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            java.lang.String r5 = "utf-8"
            r4.<init>(r0, r5)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            java.lang.String r0 = "\\|"
            java.lang.String[] r0 = r4.split(r0)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            int r4 = r0.length     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            r5 = 1
            if (r4 <= r5) goto L_0x0050
            java.lang.String r4 = "V1"
            r6 = r0[r6]     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            if (r4 == 0) goto L_0x0050
            r0 = r0[r5]     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            r1 = r0
        L_0x0050:
            r2.close()     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            r3.close()     // Catch:{ Exception -> 0x0076 }
            goto L_0x0076
        L_0x0057:
            r0 = move-exception
            goto L_0x005b
        L_0x0059:
            r0 = move-exception
            r3 = r1
        L_0x005b:
            r1 = r2
            goto L_0x0061
        L_0x005d:
            r3 = r1
            goto L_0x006e
        L_0x005f:
            r0 = move-exception
            r3 = r1
        L_0x0061:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            if (r3 == 0) goto L_0x006b
            r3.close()     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            throw r0
        L_0x006c:
            r2 = r1
            r3 = r2
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            if (r3 == 0) goto L_0x0076
            goto L_0x0053
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.c.c.g():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        if (r8 != null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0088, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0089, code lost:
        if (r8 != null) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        if (r8 != null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088 A[ExcHandler: all (r12v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r8 
      PHI: (r8v3 android.database.Cursor) = (r8v0 android.database.Cursor), (r8v5 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:1:0x000d, B:5:0x0020, B:12:0x0041] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e A[EDGE_INSN: B:29:0x007e->B:16:0x007e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026 A[Catch:{ Exception -> 0x0080, all -> 0x0088 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "imageurl"
            java.lang.String r1 = ""
            com.igexin.push.extension.distribution.basic.e.a r2 = r11.b()
            r11.b = r2
            r8 = 0
            java.lang.String r3 = "image"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            r10 = 0
            r5[r10] = r12     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            r6 = 0
            r7 = 0
            android.database.Cursor r8 = r2.a(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            if (r8 == 0) goto L_0x0082
        L_0x001f:
            r2 = r1
        L_0x0020:
            boolean r3 = r8.moveToNext()     // Catch:{ Exception -> 0x0080, all -> 0x0088 }
            if (r3 == 0) goto L_0x007e
            java.lang.String r3 = "imagesrc"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0080, all -> 0x0088 }
            java.lang.String r2 = r8.getString(r3)     // Catch:{ Exception -> 0x0080, all -> 0x0088 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0080, all -> 0x0088 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0080, all -> 0x0088 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0080, all -> 0x0088 }
            if (r4 == 0) goto L_0x0041
            boolean r3 = r3.canRead()     // Catch:{ Exception -> 0x0080, all -> 0x0088 }
            if (r3 != 0) goto L_0x0020
        L_0x0041:
            com.igexin.push.extension.distribution.basic.e.a r2 = r11.b     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            java.lang.String r3 = "image"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            r5[r10] = r12     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            r2.a((java.lang.String) r3, (java.lang.String[]) r4, (java.lang.String[]) r5)     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            android.content.Context r2 = r11.c     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            android.content.Context r4 = r11.c     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            int r2 = r2.checkPermission(r3, r4)     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            if (r2 == 0) goto L_0x001f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            r2.<init>()     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            android.content.Context r3 = r11.c     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            java.io.File r3 = r3.getCacheDir()     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            r2.append(r3)     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            java.lang.String r3 = "/ImgCache/"
            r2.append(r3)     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            com.igexin.push.extension.distribution.basic.c.e.k = r2     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
            goto L_0x001f
        L_0x007e:
            r1 = r2
            goto L_0x0082
        L_0x0080:
            r1 = r2
            goto L_0x008f
        L_0x0082:
            if (r8 == 0) goto L_0x0092
        L_0x0084:
            r8.close()
            goto L_0x0092
        L_0x0088:
            r12 = move-exception
            if (r8 == 0) goto L_0x008e
            r8.close()
        L_0x008e:
            throw r12
        L_0x008f:
            if (r8 == 0) goto L_0x0092
            goto L_0x0084
        L_0x0092:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.c.c.a(java.lang.String):java.lang.String");
    }

    public a b() {
        if (this.b == null) {
            this.b = new a(this.c);
        }
        return this.b;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis() - 604800000;
        Cursor cursor = null;
        try {
            cursor = b().a(PictureMimeType.MIME_TYPE_PREFIX_IMAGE, new String[]{"taskid"}, "createtime <= " + String.valueOf(currentTimeMillis));
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("taskid"));
                    b().a(PictureMimeType.MIME_TYPE_PREFIX_IMAGE, new String[]{"taskid"}, new String[]{string});
                    File file = new File(e.k + string);
                    if (file.exists()) {
                        a(file);
                    }
                }
            }
            if (cursor == null) {
                return;
            }
        } catch (Exception unused) {
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    public void d() {
        File file = new File(CoreConsts.e);
        if (file.exists()) {
            for (File file2 : file.listFiles(new d(this))) {
                if (file2.exists()) {
                    a(file2);
                }
            }
        }
    }

    public void e() {
        String g = g();
        StringBuilder sb = new StringBuilder();
        String str = a;
        sb.append(str);
        sb.append("|read from com.getui.sdk.deviceId.db = ");
        sb.append(g);
        sb.append("; CoreRuntimeInfo.deviceId = ");
        sb.append(d.A);
        b.a(sb.toString(), new Object[0]);
        if (g != null) {
            if (!g.equals(d.A)) {
                d.A = g;
                c(g);
            }
        } else if (d.A != null) {
            b(d.A);
        } else {
            b.a(str + "|updateDeviceId new file deviceId and CoreRuntimeInfo deviceId is null return", new Object[0]);
        }
    }

    public void f() {
    }
}
