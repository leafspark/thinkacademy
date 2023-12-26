package com.igexin.push.util;

import android.content.Context;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.b.a.a.a;
import com.igexin.b.a.c.b;
import com.igexin.push.config.l;
import com.igexin.push.core.d;
import com.igexin.push.core.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c {
    private static final Object a = new Object();

    public static void a() {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(d.V);
            if (file.exists() || file.createNewFile()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(d.V);
                try {
                    fileOutputStream2.write(a.d((("v01" + d.z) + d.t + "|" + d.a + "|" + d.u + "|" + x.a().d(d.g)).getBytes(), d.E));
                    k.a(fileOutputStream2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        b.a("FileUtils | " + e.toString(), new Object[0]);
                        k.a(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        k.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    k.a(fileOutputStream);
                    throw th;
                }
            } else {
                b.a("FileUtils | create file : " + file.toString() + " failed !!!", new Object[0]);
                k.a((Closeable) null);
            }
        } catch (Exception e2) {
            e = e2;
            b.a("FileUtils | " + e.toString(), new Object[0]);
            k.a(fileOutputStream);
        }
    }

    public static void a(File file, String... strArr) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            List list = null;
            if (strArr != null) {
                list = Arrays.asList(strArr);
            }
            for (File file2 : listFiles) {
                if (list == null || !list.contains(file2.getName())) {
                    file2.delete();
                }
            }
        }
    }

    private static void a(List<File> list, File file, String str) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File a2 : file.listFiles()) {
                    a(list, a2, str);
                }
            } else if (file.getName().startsWith(str)) {
                list.add(file);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001a A[SYNTHETIC, Splitter:B:13:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0020 A[SYNTHETIC, Splitter:B:19:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(byte[] r3, java.lang.String r4, boolean r5) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            r1.write(r3)     // Catch:{ Exception -> 0x0015, all -> 0x0012 }
            r1.close()     // Catch:{ Exception -> 0x0023 }
            goto L_0x0023
        L_0x0012:
            r3 = move-exception
            r0 = r1
            goto L_0x0018
        L_0x0015:
            r0 = r1
            goto L_0x001e
        L_0x0017:
            r3 = move-exception
        L_0x0018:
            if (r0 == 0) goto L_0x001d
            r0.close()     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            throw r3
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.c.a(byte[], java.lang.String, boolean):void");
    }

    public static boolean a(Context context) {
        return !new com.igexin.sdk.a.c(context).b();
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
    public static byte[] a(java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0029
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "FileUtils|get data from file = "
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
            java.lang.String r5 = "FileUtils|"
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
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.c.a(java.lang.String):byte[]");
    }

    public static String b() {
        return com.igexin.push.core.e.d.a().b(d.g);
    }

    public static void b(Context context) {
        if (!l.m) {
            b.a("FileUtils|isReportInitialize = false", new Object[0]);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d.as < 1000) {
            b.a("FileUtils|not allowed to save initialization twice within 1s", new Object[0]);
            return;
        }
        d.as = currentTimeMillis;
        if (d.h.get()) {
            com.igexin.b.a.b.c.b().a(new e(context, currentTimeMillis), false, true);
            return;
        }
        Thread thread = new Thread(new f(context, currentTimeMillis));
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str) {
        if (context != null && str != null) {
            String str2 = context.getFilesDir().getPath() + "/" + "init_c1.pid";
            synchronized (a) {
                if (str.length() == 0) {
                    a(str.getBytes(), str2, false);
                } else {
                    a((str + "|").getBytes(), str2, true);
                }
            }
        }
    }

    public static boolean b(String str) {
        boolean z;
        File[] listFiles;
        b.a("FileUtils|removeExt " + str, new Object[0]);
        try {
            File file = new File(d.X);
            if (!file.exists() || (listFiles = file.listFiles(new d(str))) == null) {
                z = false;
            } else {
                z = false;
                for (File delete : listFiles) {
                    z |= delete.delete();
                }
            }
            String substring = com.igexin.b.b.a.a(str).substring(12, 20);
            b.a("FileUtils|removeExt renamedExtName = " + substring, new Object[0]);
            File file2 = new File(d.X + "/" + substring);
            if (file2.exists()) {
                b.a("FileUtils|removeExt, delete ext rename Ext path = " + file2.getAbsolutePath(), new Object[0]);
                b.a("FileUtils|removeExt, delete ext renamedExt succeed = " + file2.delete(), new Object[0]);
            }
            ArrayList<File> arrayList = new ArrayList<>();
            a((List<File>) arrayList, new File(d.X + "/oat"), str);
            for (File delete2 : arrayList) {
                delete2.delete();
            }
            return z;
        } catch (Throwable th) {
            b.a("FileUtils|" + th.toString(), new Object[0]);
            return false;
        }
    }

    public static String c() {
        return com.igexin.push.core.e.d.a().a(d.g);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009c, code lost:
        r7 = r2;
        r2 = r0;
        r0 = r7;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00af, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00af A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0034] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.content.Context r8) {
        /*
            r0 = 0
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            r4.<init>()     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.io.File r8 = r8.getFilesDir()     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.lang.String r8 = r8.getPath()     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            r4.append(r8)     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.lang.String r8 = "/"
            r4.append(r8)     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.lang.String r8 = "gt_safe.pid"
            r4.append(r8)     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.lang.String r8 = r4.toString()     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            r3.<init>(r8)     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.lang.String r8 = "rw"
            r2.<init>(r3, r8)     // Catch:{ Exception -> 0x00c5, all -> 0x00c0 }
            java.nio.channels.FileChannel r8 = r2.getChannel()     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            java.nio.channels.FileLock r8 = r8.lock()     // Catch:{ Exception -> 0x00bc, all -> 0x00b7 }
            boolean r3 = r8.isValid()     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            if (r3 == 0) goto L_0x00a0
            r3 = 128(0x80, float:1.794E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            r4.<init>()     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
        L_0x0043:
            int r5 = r2.read(r3)     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            r6 = -1
            if (r5 == r6) goto L_0x004e
            r4.write(r3, r1, r5)     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            goto L_0x0043
        L_0x004e:
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            byte[] r4 = r4.toByteArray()     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            r0.<init>()     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            java.lang.String r4 = "FileUtils|old safeCode = "
            r0.append(r4)     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            r0.append(r3)     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r4)     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            if (r0 == 0) goto L_0x0099
            r0 = 16
            java.lang.String r0 = com.igexin.push.util.o.a(r0)     // Catch:{ Exception -> 0x009b, all -> 0x00af }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            r3.<init>()     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            java.lang.String r4 = "FileUtils|new safeCode = "
            r3.append(r4)     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            r3.append(r0)     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            com.igexin.b.a.c.b.a((java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            java.lang.String r3 = "utf-8"
            byte[] r3 = r0.getBytes(r3)     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            r2.write(r3)     // Catch:{ Exception -> 0x00b1, all -> 0x00af }
            goto L_0x00a0
        L_0x0099:
            r0 = r3
            goto L_0x00a0
        L_0x009b:
            r0 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x00c9
        L_0x00a0:
            com.igexin.push.util.k.a(r2)
            if (r8 == 0) goto L_0x00f2
            boolean r1 = r8.isValid()
            if (r1 == 0) goto L_0x00f2
            r8.release()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x00f2
        L_0x00af:
            r0 = move-exception
            goto L_0x00f6
        L_0x00b1:
            r3 = move-exception
            r7 = r3
            r3 = r0
            r0 = r2
            r2 = r7
            goto L_0x00c9
        L_0x00b7:
            r8 = move-exception
            r7 = r0
            r0 = r8
            r8 = r7
            goto L_0x00f6
        L_0x00bc:
            r3 = move-exception
            r8 = r0
            r0 = r2
            goto L_0x00c7
        L_0x00c0:
            r8 = move-exception
            r2 = r0
            r0 = r8
            r8 = r2
            goto L_0x00f6
        L_0x00c5:
            r3 = move-exception
            r8 = r0
        L_0x00c7:
            r2 = r3
            r3 = r8
        L_0x00c9:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            r4.<init>()     // Catch:{ all -> 0x00f3 }
            java.lang.String r5 = "FileUtils|get safeCode err = "
            r4.append(r5)     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00f3 }
            r4.append(r2)     // Catch:{ all -> 0x00f3 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00f3 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00f3 }
            com.igexin.b.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00f3 }
            com.igexin.push.util.k.a(r0)
            if (r8 == 0) goto L_0x00f1
            boolean r0 = r8.isValid()
            if (r0 == 0) goto L_0x00f1
            r8.release()     // Catch:{ IOException -> 0x00f1 }
        L_0x00f1:
            r0 = r3
        L_0x00f2:
            return r0
        L_0x00f3:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x00f6:
            com.igexin.push.util.k.a(r2)
            if (r8 == 0) goto L_0x0104
            boolean r1 = r8.isValid()
            if (r1 == 0) goto L_0x0104
            r8.release()     // Catch:{ IOException -> 0x0104 }
        L_0x0104:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.c.c(android.content.Context):java.lang.String");
    }

    public static long d() {
        return com.igexin.push.core.e.d.a().c(d.g);
    }

    public static String d(Context context) {
        return context.getExternalFilesDir("gtpush") + "/log/";
    }

    public static void e() {
        com.igexin.push.core.e.d.a().a(d.g, d.A);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[SYNTHETIC, Splitter:B:26:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = com.igexin.push.core.d.g
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r1 = r1.getPath()
            r0.append(r1)
            java.lang.String r1 = "/init.pid"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x005a }
            r3.<init>(r0)     // Catch:{ Exception -> 0x005a }
            boolean r3 = r3.exists()     // Catch:{ Exception -> 0x005a }
            if (r3 == 0) goto L_0x0052
            java.lang.String r3 = com.igexin.push.core.d.u     // Catch:{ Exception -> 0x005a }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x005a }
            int r4 = r3.length     // Catch:{ Exception -> 0x005a }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x005a }
            r5 = r1
        L_0x0032:
            int r6 = r3.length     // Catch:{ Exception -> 0x005a }
            if (r5 >= r6) goto L_0x0042
            byte r6 = r3[r5]     // Catch:{ Exception -> 0x005a }
            byte[] r7 = com.igexin.push.core.d.aa     // Catch:{ Exception -> 0x005a }
            byte r7 = r7[r5]     // Catch:{ Exception -> 0x005a }
            r6 = r6 ^ r7
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x005a }
            r4[r5] = r6     // Catch:{ Exception -> 0x005a }
            int r5 = r5 + 1
            goto L_0x0032
        L_0x0042:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005a }
            r3.<init>(r0)     // Catch:{ Exception -> 0x005a }
            r3.write(r4)     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            r2 = r3
            goto L_0x0052
        L_0x004c:
            r0 = move-exception
            r2 = r3
            goto L_0x0079
        L_0x004f:
            r0 = move-exception
            r2 = r3
            goto L_0x005b
        L_0x0052:
            if (r2 == 0) goto L_0x0078
        L_0x0054:
            r2.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x0078
        L_0x0058:
            r0 = move-exception
            goto L_0x0079
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r3.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "FileUtils|"
            r3.append(r4)     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0058 }
            r3.append(r0)     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0058 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0058 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0078
            goto L_0x0054
        L_0x0078:
            return
        L_0x0079:
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ Exception -> 0x007e }
        L_0x007e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.c.f():void");
    }
}
