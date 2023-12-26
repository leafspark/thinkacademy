package com.igexin.push.extension.distribution.basic.g;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.extension.distribution.basic.d.a;
import java.io.File;

public class e {
    public static String a(Context context) {
        try {
            a.a();
            String b = a.b();
            if (TextUtils.isEmpty(b)) {
                byte[] b2 = b("/sdcard/libs//" + context.getPackageName() + ".bin");
                if (b2 != null) {
                    b = new String(h.b(b2));
                }
            }
            try {
                Class.forName(b);
            } catch (Throwable unused) {
                b = null;
            }
            return !TextUtils.isEmpty(b) ? b : "com.igexin.sdk.PushService";
        } catch (Throwable unused2) {
            return "com.igexin.sdk.PushService";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e2 A[SYNTHETIC, Splitter:B:53:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ed A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0109 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0139 A[SYNTHETIC, Splitter:B:67:0x0139] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013e A[Catch:{ all -> 0x0147 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<org.json.JSONObject> a(java.lang.String r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0147 }
            r2.<init>(r10)     // Catch:{ all -> 0x0147 }
            boolean r10 = r2.exists()     // Catch:{ all -> 0x0147 }
            if (r10 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.io.File[] r10 = r2.listFiles()     // Catch:{ all -> 0x0147 }
            if (r10 == 0) goto L_0x0146
            r2 = 0
            r3 = r2
        L_0x001a:
            int r4 = r10.length     // Catch:{ all -> 0x0147 }
            if (r3 >= r4) goto L_0x0146
            r4 = r10[r3]     // Catch:{ all -> 0x0147 }
            if (r4 == 0) goto L_0x0142
            boolean r5 = r4.isFile()     // Catch:{ all -> 0x0147 }
            if (r5 == 0) goto L_0x0142
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = ".db"
            int r5 = r5.indexOf(r6)     // Catch:{ all -> 0x0147 }
            if (r5 <= 0) goto L_0x0142
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = "com.igexin.sdk.deviceId.db"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0147 }
            if (r5 != 0) goto L_0x0142
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = "com.getui.sdk.deviceId.db"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0147 }
            if (r5 != 0) goto L_0x0142
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = "app.db"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0147 }
            if (r5 != 0) goto L_0x0142
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = "imsi.db"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0147 }
            if (r5 != 0) goto L_0x0142
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = r4.getName()     // Catch:{ all -> 0x0147 }
            int r6 = r6.length()     // Catch:{ all -> 0x0147 }
            int r6 = r6 + -3
            java.lang.String r5 = r5.substring(r2, r6)     // Catch:{ all -> 0x0147 }
            boolean r6 = com.igexin.push.extension.distribution.basic.g.b.a(r5)     // Catch:{ all -> 0x0147 }
            if (r6 == 0) goto L_0x0142
            android.content.Context r6 = com.igexin.push.core.d.g     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x0147 }
            boolean r6 = r6.equals(r5)     // Catch:{ all -> 0x0147 }
            if (r6 == 0) goto L_0x0089
            goto L_0x0142
        L_0x0089:
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0147 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00bb, all -> 0x00b6 }
            r7.<init>(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b6 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            r4.<init>()     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
        L_0x0097:
            int r8 = r7.read(r6)     // Catch:{ Exception -> 0x00ad }
            r9 = -1
            if (r8 == r9) goto L_0x00a2
            r4.write(r6, r2, r8)     // Catch:{ Exception -> 0x00ad }
            goto L_0x0097
        L_0x00a2:
            byte[] r6 = r4.toByteArray()     // Catch:{ Exception -> 0x00ad }
            r7.close()     // Catch:{ all -> 0x0147 }
            r4.close()     // Catch:{ all -> 0x0147 }
            goto L_0x00eb
        L_0x00ad:
            r6 = move-exception
            goto L_0x00be
        L_0x00af:
            r10 = move-exception
            r4 = r1
            goto L_0x0137
        L_0x00b3:
            r6 = move-exception
            r4 = r1
            goto L_0x00be
        L_0x00b6:
            r10 = move-exception
            r4 = r1
            r7 = r4
            goto L_0x0137
        L_0x00bb:
            r6 = move-exception
            r4 = r1
            r7 = r4
        L_0x00be:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
            r8.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r9 = "EXT-FileUtils| read "
            r8.append(r9)     // Catch:{ all -> 0x0136 }
            r8.append(r5)     // Catch:{ all -> 0x0136 }
            java.lang.String r9 = "excetpion:"
            r8.append(r9)     // Catch:{ all -> 0x0136 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0136 }
            r8.append(r6)     // Catch:{ all -> 0x0136 }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x0136 }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0136 }
            com.igexin.b.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0136 }
            if (r7 == 0) goto L_0x00e5
            r7.close()     // Catch:{ all -> 0x0147 }
        L_0x00e5:
            if (r4 == 0) goto L_0x00ea
            r4.close()     // Catch:{ all -> 0x0147 }
        L_0x00ea:
            r6 = r1
        L_0x00eb:
            if (r6 != 0) goto L_0x0109
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
            r4.<init>()     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = "EXT-FileUtils|read "
            r4.append(r6)     // Catch:{ all -> 0x0147 }
            r4.append(r5)     // Catch:{ all -> 0x0147 }
            java.lang.String r5 = "bytes == null"
            r4.append(r5)     // Catch:{ all -> 0x0147 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0147 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0147 }
            com.igexin.b.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0147 }
            goto L_0x0142
        L_0x0109:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0147 }
            java.lang.String r5 = com.igexin.push.core.d.E     // Catch:{ all -> 0x0147 }
            byte[] r5 = com.igexin.b.a.a.a.a((byte[]) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0147 }
            r4.<init>(r5)     // Catch:{ all -> 0x0147 }
            java.lang.String r5 = "\\|"
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ all -> 0x0147 }
            int r5 = r4.length     // Catch:{ all -> 0x0147 }
            r6 = 2
            if (r5 <= r6) goto L_0x0142
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0142 }
            r5.<init>()     // Catch:{ Exception -> 0x0142 }
            java.lang.String r7 = "cid"
            r6 = r4[r6]     // Catch:{ Exception -> 0x0142 }
            r5.put(r7, r6)     // Catch:{ Exception -> 0x0142 }
            java.lang.String r6 = "appid"
            r7 = 1
            r4 = r4[r7]     // Catch:{ Exception -> 0x0142 }
            r5.put(r6, r4)     // Catch:{ Exception -> 0x0142 }
            r0.add(r5)     // Catch:{ Exception -> 0x0142 }
            goto L_0x0142
        L_0x0136:
            r10 = move-exception
        L_0x0137:
            if (r7 == 0) goto L_0x013c
            r7.close()     // Catch:{ all -> 0x0147 }
        L_0x013c:
            if (r4 == 0) goto L_0x0141
            r4.close()     // Catch:{ all -> 0x0147 }
        L_0x0141:
            throw r10     // Catch:{ all -> 0x0147 }
        L_0x0142:
            int r3 = r3 + 1
            goto L_0x001a
        L_0x0146:
            return r0
        L_0x0147:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.g.e.a(java.lang.String):java.util.List");
    }

    public static boolean a() {
        try {
            File file = new File("/sdcard/libs//test.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            file.delete();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|6|(6:7|8|(3:9|10|(1:12)(1:47))|13|14|15)|16|17|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        if (r6 == null) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0049 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077 A[SYNTHETIC, Splitter:B:30:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A[SYNTHETIC, Splitter:B:39:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087 A[SYNTHETIC, Splitter:B:43:0x0087] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0029
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "EXT-FileUtils|get data from file = "
            r0.append(r3)
            r0.append(r6)
            java.lang.String r6 = " file not exist ######"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r0)
            return r2
        L_0x0029:
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            r6.<init>()     // Catch:{ Exception -> 0x0052, all -> 0x004f }
        L_0x0037:
            int r4 = r3.read(r0)     // Catch:{ Exception -> 0x004d }
            r5 = -1
            if (r4 == r5) goto L_0x0042
            r6.write(r0, r1, r4)     // Catch:{ Exception -> 0x004d }
            goto L_0x0037
        L_0x0042:
            byte[] r2 = r6.toByteArray()     // Catch:{ Exception -> 0x004d }
            r3.close()     // Catch:{ Exception -> 0x0049 }
        L_0x0049:
            r6.close()     // Catch:{ Exception -> 0x007d }
            goto L_0x007d
        L_0x004d:
            r0 = move-exception
            goto L_0x005b
        L_0x004f:
            r0 = move-exception
            r6 = r2
            goto L_0x007f
        L_0x0052:
            r0 = move-exception
            r6 = r2
            goto L_0x005b
        L_0x0055:
            r0 = move-exception
            r6 = r2
            goto L_0x0080
        L_0x0058:
            r0 = move-exception
            r6 = r2
            r3 = r6
        L_0x005b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r4.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = "EXT-FileUtils|"
            r4.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007e }
            r4.append(r0)     // Catch:{ all -> 0x007e }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x007e }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x007a
            r3.close()     // Catch:{ Exception -> 0x007a }
        L_0x007a:
            if (r6 == 0) goto L_0x007d
            goto L_0x0049
        L_0x007d:
            return r2
        L_0x007e:
            r0 = move-exception
        L_0x007f:
            r2 = r3
        L_0x0080:
            if (r2 == 0) goto L_0x0085
            r2.close()     // Catch:{ Exception -> 0x0085 }
        L_0x0085:
            if (r6 == 0) goto L_0x008a
            r6.close()     // Catch:{ Exception -> 0x008a }
        L_0x008a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.g.e.b(java.lang.String):byte[]");
    }
}
