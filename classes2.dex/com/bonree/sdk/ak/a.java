package com.bonree.sdk.ak;

import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.business.entity.CrashEventInfoBean;
import com.bonree.sdk.ai.b;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.d.e;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class a {
    private static final String a = "CrashStorage";
    private static final String b = "/brcrash/crashlogs";
    private static String c = "/brcrash/nativecrashs";
    private static final String d = "/brcrash/NativeCrashMapping.properties";
    private Properties e;
    private String f;
    private String g;
    private File h;
    private List<File> i;
    private f j;
    private AtomicBoolean k;
    private AtomicBoolean l;
    private AtomicBoolean m;

    public a(String str) {
        if (!ad.a(str)) {
            this.j = com.bonree.sdk.be.a.a();
            this.k = new AtomicBoolean(true);
            this.l = new AtomicBoolean(false);
            this.m = new AtomicBoolean(false);
            this.f = str + b;
            this.g = str + "/brcrash/nativecrashs";
            this.h = new File(str + d);
            File file = new File(this.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.g);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            try {
                this.l.getAndSet(com.bonree.sdk.bb.f.a(this.h.getAbsolutePath()));
            } catch (IOException e2) {
                this.j.a("create native crash mapping file fail", (Throwable) e2);
                this.l.getAndSet(false);
            }
            if (this.l.get()) {
                this.e = new Properties();
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(this.h);
                    try {
                        this.e.load(fileInputStream2);
                        ad.a((Closeable) fileInputStream2);
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        ad.a((Closeable) fileInputStream);
                        this.i = new ArrayList();
                        return;
                    }
                } catch (Throwable unused2) {
                    ad.a((Closeable) fileInputStream);
                    this.i = new ArrayList();
                    return;
                }
                this.i = new ArrayList();
                return;
            }
            return;
        }
        throw new RuntimeException("crash storage base path is empty!");
    }

    private void a(String str) {
        if (!ad.a(str)) {
            this.j = com.bonree.sdk.be.a.a();
            this.k = new AtomicBoolean(true);
            this.l = new AtomicBoolean(false);
            this.m = new AtomicBoolean(false);
            this.f = str + b;
            this.g = str + "/brcrash/nativecrashs";
            this.h = new File(str + d);
            File file = new File(this.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.g);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            try {
                this.l.getAndSet(com.bonree.sdk.bb.f.a(this.h.getAbsolutePath()));
            } catch (IOException e2) {
                this.j.a("create native crash mapping file fail", (Throwable) e2);
                this.l.getAndSet(false);
            }
            if (this.l.get()) {
                this.e = new Properties();
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(this.h);
                    try {
                        this.e.load(fileInputStream2);
                        ad.a((Closeable) fileInputStream2);
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        ad.a((Closeable) fileInputStream);
                        this.i = new ArrayList();
                        return;
                    }
                } catch (Throwable unused2) {
                    ad.a((Closeable) fileInputStream);
                    this.i = new ArrayList();
                    return;
                }
                this.i = new ArrayList();
                return;
            }
            return;
        }
        throw new RuntimeException("crash storage base path is empty!");
    }

    private void e() {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(this.h);
            try {
                this.e.store(fileOutputStream, (String) null);
                ad.a((Closeable) fileOutputStream);
            } catch (FileNotFoundException unused) {
                fileOutputStream2 = fileOutputStream;
                ad.a((Closeable) fileOutputStream2);
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                ad.a((Closeable) fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                ad.a((Closeable) fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            ad.a((Closeable) fileOutputStream2);
        } catch (IOException unused4) {
            ad.a((Closeable) fileOutputStream2);
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream = null;
            th = th4;
            ad.a((Closeable) fileOutputStream);
            throw th;
        }
    }

    private String b(String str) {
        if (!this.l.get() || ad.a(str)) {
            return "unknown path";
        }
        return this.f + File.separator + str;
    }

    public final String a() {
        if (!this.l.get()) {
            return "";
        }
        return this.g;
    }

    private boolean a(String str, CrashEventInfoBean crashEventInfoBean, String str2) {
        if (!this.l.get() || ad.a(str) || crashEventInfoBean == null) {
            this.j.d("save crashlog fail! initSuccess:%b,fileName:%s,crash log:%s", Boolean.valueOf(this.l.get()), str, crashEventInfoBean);
            return false;
        }
        String str3 = this.f + File.separator + str;
        try {
            if (!com.bonree.sdk.bb.f.a(str3)) {
                this.j.d("make sure file exist fail when save crash log! filePath:%s", str3);
                return false;
            }
            if (!ad.a(str2)) {
                this.j.c("native crash save crashlog and native dump", new Object[0]);
                synchronized (this.e) {
                    this.e.setProperty(str3, str2);
                    e();
                }
            }
            String json = new Gson().toJson((Object) crashEventInfoBean);
            try {
                this.j.c("create file write crashLogJson", new Object[0]);
                return com.bonree.sdk.bb.f.a(str3, json);
            } catch (IOException e2) {
                this.j.a("an exception occurs when save crash log", (Throwable) e2);
                return false;
            }
        } catch (IOException e3) {
            this.j.a("create new file exception when save crash log", (Throwable) e3);
            return false;
        }
    }

    public final void a(boolean z) {
        this.k.getAndSet(z);
    }

    private static CrashEventInfoBean c(String str) {
        String str2;
        Gson gson = new Gson();
        try {
            str2 = com.bonree.sdk.bb.f.b(str);
        } catch (IOException unused) {
            str2 = null;
        }
        return (CrashEventInfoBean) gson.fromJson(str2, CrashEventInfoBean.class);
    }

    private List<CrashEventInfoBean> a(int i2, long j2, int i3) {
        ArrayList arrayList;
        long j3;
        File[] fileArr;
        int i4 = i2;
        int i5 = i3;
        int i6 = 1;
        if (i4 <= 0 || j2 <= 0 || i5 <= 0) {
            this.j.d("illegal args! maxSize:%d, crashSaveExpireTime:%d, dumpMaxLine:%d", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3));
            return new ArrayList();
        } else if (!this.l.get()) {
            return new ArrayList();
        } else {
            File[] listFiles = new File(this.f).listFiles();
            if (listFiles == null || listFiles.length == 0) {
                this.j.d("no crash log!", new Object[0]);
                return new ArrayList();
            }
            synchronized (this.i) {
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<File> arrayList2 = new ArrayList<>();
                arrayList = new ArrayList();
                b bVar = new b(this.k.get());
                Gson gson = new Gson();
                int length = listFiles.length - 1;
                int i7 = 0;
                int i8 = 0;
                while (length >= 0) {
                    File file = listFiles[length];
                    if (currentTimeMillis - file.lastModified() > j2) {
                        arrayList2.add(file);
                        String absolutePath = file.getAbsolutePath();
                        f fVar = this.j;
                        fileArr = listFiles;
                        j3 = currentTimeMillis;
                        Object[] objArr = new Object[i6];
                        objArr[0] = absolutePath;
                        fVar.d("will remove expire time crashlog,path:%s", objArr);
                        String property = this.e.getProperty(absolutePath);
                        if (!ad.a(property)) {
                            arrayList2.add(new File(property));
                            f fVar2 = this.j;
                            Object[] objArr2 = new Object[i6];
                            objArr2[0] = property;
                            fVar2.d("will remove corresponding native crash,path:%s", objArr2);
                        }
                    } else {
                        fileArr = listFiles;
                        j3 = currentTimeMillis;
                        if (i7 >= i4) {
                            String str = (String) this.e.remove(file.getAbsolutePath());
                            arrayList2.add(file);
                            f fVar3 = this.j;
                            Object[] objArr3 = new Object[i6];
                            objArr3[0] = file;
                            fVar3.d("will remove left crashlog,path:%s", objArr3);
                            if (!ad.a(str)) {
                                arrayList2.add(new File(str));
                                f fVar4 = this.j;
                                Object[] objArr4 = new Object[i6];
                                objArr4[0] = str;
                                fVar4.d("will remove corresponding native crash,path:%s", objArr4);
                            }
                        } else {
                            try {
                                String absolutePath2 = file.getAbsolutePath();
                                String property2 = this.e.getProperty(absolutePath2);
                                CrashEventInfoBean crashEventInfoBean = (CrashEventInfoBean) gson.fromJson(com.bonree.sdk.bb.f.b(absolutePath2), CrashEventInfoBean.class);
                                if (!ad.a(property2)) {
                                    String b2 = com.bonree.sdk.bb.f.b(property2);
                                    if (ad.a(b2)) {
                                        f fVar5 = this.j;
                                        Object[] objArr5 = new Object[i6];
                                        objArr5[0] = property2;
                                        fVar5.d("not found native crash record!file:%s", objArr5);
                                        this.e.remove(absolutePath2);
                                        try {
                                            arrayList2.add(file);
                                            arrayList2.add(new File(property2));
                                            i8 = i6;
                                        } catch (Throwable th) {
                                            th = th;
                                            i8 = i6;
                                            this.j.a("read local crash logs exception", th);
                                            length--;
                                            i4 = i2;
                                            i5 = i3;
                                            listFiles = fileArr;
                                            currentTimeMillis = j3;
                                            i6 = 1;
                                        }
                                    } else {
                                        com.bonree.sdk.ai.a a2 = bVar.a(b2, i5);
                                        if (a2 == null) {
                                            this.j.d("parse native crash record error!file:%s,dump:%s", property2, b2);
                                            this.e.remove(absolutePath2);
                                            try {
                                                arrayList2.add(file);
                                                arrayList2.add(new File(property2));
                                                i8 = 1;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                i8 = 1;
                                                this.j.a("read local crash logs exception", th);
                                                length--;
                                                i4 = i2;
                                                i5 = i3;
                                                listFiles = fileArr;
                                                currentTimeMillis = j3;
                                                i6 = 1;
                                            }
                                        } else {
                                            crashEventInfoBean.causedBy = a2.c;
                                        }
                                    }
                                }
                                if (crashEventInfoBean != null) {
                                    arrayList.add(crashEventInfoBean);
                                } else {
                                    this.j.c("Json analysis is error, CrashLogBean is null!", new Object[0]);
                                }
                                if (!this.i.contains(file)) {
                                    this.j.c("upload add crash file name%s", file);
                                    this.i.add(file);
                                }
                                i7++;
                            } catch (Throwable th3) {
                                th = th3;
                                this.j.a("read local crash logs exception", th);
                                length--;
                                i4 = i2;
                                i5 = i3;
                                listFiles = fileArr;
                                currentTimeMillis = j3;
                                i6 = 1;
                            }
                        }
                    }
                    length--;
                    i4 = i2;
                    i5 = i3;
                    listFiles = fileArr;
                    currentTimeMillis = j3;
                    i6 = 1;
                }
                if (arrayList2.size() > 0) {
                    for (File file2 : arrayList2) {
                        if (!file2.exists() || !file2.isFile() || !file2.delete()) {
                            this.j.d("delete local crash record fail!file:%s", file2.getAbsolutePath());
                        } else {
                            this.j.c("delete local crash record success.file:%s", file2.getAbsolutePath());
                        }
                    }
                }
                if (i8 != 0) {
                    e();
                }
            }
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0118 A[SYNTHETIC, Splitter:B:64:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0187  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bonree.sdk.agent.business.entity.CrashEventInfoBean a(com.bonree.sdk.agent.business.entity.CrashEventInfoBean r13) {
        /*
            r12 = this;
            java.lang.String r0 = "CrashStorage"
            com.bonree.sdk.be.f r1 = r12.j
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "CrashStorage addNativeCrashInfo"
            r1.c(r4, r3)
            java.lang.String r1 = r13.nativeCrashLogPath
            boolean r1 = com.bonree.sdk.bs.ad.c((java.lang.String) r1)
            if (r1 == 0) goto L_0x0245
            java.lang.String r1 = r13.crashThreadId
            boolean r1 = com.bonree.sdk.bs.ad.c((java.lang.String) r1)
            if (r1 == 0) goto L_0x0245
            java.lang.String r1 = r13.type
            boolean r1 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)
            if (r1 == 0) goto L_0x0028
            java.lang.String r1 = "Native Crash"
            r13.type = r1
        L_0x0028:
            com.bonree.sdk.ai.b r1 = new com.bonree.sdk.ai.b
            java.util.concurrent.atomic.AtomicBoolean r3 = r12.k
            boolean r3 = r3.get()
            r1.<init>(r3)
            java.util.List<com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean> r3 = r13.threadDumpInfo
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r5 = r4
            r6 = r5
        L_0x003c:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0073
            java.lang.Object r7 = r3.next()
            com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean r7 = (com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean) r7
            java.lang.String r8 = r13.crashThreadId
            boolean r8 = com.bonree.sdk.bs.ad.a((java.lang.String) r8)
            if (r8 != 0) goto L_0x005f
            java.lang.String r8 = r13.crashThreadId
            java.lang.String r9 = r7.mThreadId
            java.lang.String r9 = java.lang.String.valueOf(r9)
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x005f
            r5 = r7
        L_0x005f:
            java.lang.String r8 = r7.mThreadName
            boolean r8 = com.bonree.sdk.bs.ad.a((java.lang.String) r8)
            if (r8 != 0) goto L_0x003c
            java.lang.String r8 = r7.mThreadName
            java.lang.String r9 = "main"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x003c
            r6 = r7
            goto L_0x003c
        L_0x0073:
            if (r5 != 0) goto L_0x0076
            return r4
        L_0x0076:
            java.lang.String r3 = r5.mDumpInfo
            boolean r3 = com.bonree.sdk.bs.ad.a((java.lang.String) r3)
            r7 = 1
            if (r3 == 0) goto L_0x008a
            com.bonree.sdk.be.f r3 = r12.j
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.String r9 = "CrashStorage addNativeCrashInfo crashDumpInfo is null"
            r3.c(r9, r8)
            r3 = r2
            goto L_0x008b
        L_0x008a:
            r3 = r7
        L_0x008b:
            java.io.File r8 = new java.io.File
            java.lang.String r9 = r13.nativeCrashLogPath
            r8.<init>(r9)
            boolean r9 = r8.exists()
            if (r9 == 0) goto L_0x00a2
            long r8 = r8.length()
            r10 = 0
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 > 0) goto L_0x00b1
        L_0x00a2:
            com.bonree.sdk.be.f r8 = r12.j
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r10 = "CrashStorage addNativeCrashInfo nativeCrashDump is null"
            r8.c(r10, r9)
            if (r3 != 0) goto L_0x00b1
            r12.b((com.bonree.sdk.agent.business.entity.CrashEventInfoBean) r13)
            return r4
        L_0x00b1:
            java.lang.String r8 = r13.nativeCrashLogPath     // Catch:{ Exception -> 0x00c8 }
            r9 = 100
            com.bonree.sdk.ai.a r1 = r1.a(r8, r9)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r8 = r1.e     // Catch:{ Exception -> 0x00c6 }
            boolean r8 = com.bonree.sdk.bs.ad.c((java.lang.String) r8)     // Catch:{ Exception -> 0x00c6 }
            if (r8 == 0) goto L_0x00cf
            java.lang.String r8 = r1.e     // Catch:{ Exception -> 0x00c6 }
            r13.systemLog = r8     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00cf
        L_0x00c6:
            r8 = move-exception
            goto L_0x00ca
        L_0x00c8:
            r8 = move-exception
            r1 = r4
        L_0x00ca:
            com.bonree.sdk.be.f r9 = r12.j
            r9.a((java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x00cf:
            if (r1 == 0) goto L_0x00e9
            java.lang.String r8 = r1.b
            boolean r8 = com.bonree.sdk.bs.ad.a((java.lang.String) r8)
            if (r8 == 0) goto L_0x00f8
            java.lang.String r8 = r1.e
            boolean r8 = com.bonree.sdk.bs.ad.a((java.lang.String) r8)
            if (r8 == 0) goto L_0x00f8
            java.lang.String r8 = r1.d
            boolean r8 = com.bonree.sdk.bs.ad.a((java.lang.String) r8)
            if (r8 == 0) goto L_0x00f8
        L_0x00e9:
            com.bonree.sdk.be.f r8 = r12.j
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r10 = "CrashStorage addNativeCrashInfo result info is null"
            r8.c(r10, r9)
            if (r3 != 0) goto L_0x00f8
            r12.b((com.bonree.sdk.agent.business.entity.CrashEventInfoBean) r13)
            return r4
        L_0x00f8:
            java.lang.String r8 = ""
            if (r6 == 0) goto L_0x013f
            java.lang.String r9 = r6.mThreadId
            boolean r9 = com.bonree.sdk.bs.ad.c((java.lang.String) r9)
            if (r9 == 0) goto L_0x013f
            java.lang.String r9 = r5.mThreadId
            boolean r9 = com.bonree.sdk.bs.ad.a((java.lang.String) r9)
            if (r9 != 0) goto L_0x0118
            java.lang.String r9 = r5.mThreadId
            java.lang.String r10 = r6.mThreadId
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0118
            r6 = r4
            goto L_0x013f
        L_0x0118:
            java.lang.String r4 = r13.nativeCrashLogPath     // Catch:{ Exception -> 0x011f }
            java.lang.String r4 = com.bonree.sdk.bb.f.b(r4)     // Catch:{ Exception -> 0x011f }
            goto L_0x013a
        L_0x011f:
            r4 = move-exception
            com.bonree.sdk.be.f r9 = r12.j
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "CrashStorage read e="
            r10.<init>(r11)
            java.lang.String r4 = r4.toString()
            r10.append(r4)
            java.lang.String r4 = r10.toString()
            java.lang.Object[] r10 = new java.lang.Object[r2]
            r9.e(r4, r10)
            r4 = r8
        L_0x013a:
            java.lang.String r4 = com.bonree.sdk.ai.b.b((java.lang.String) r4)
            goto L_0x0140
        L_0x013f:
            r4 = r8
        L_0x0140:
            java.lang.String r9 = "\r\n"
            if (r1 == 0) goto L_0x0181
            java.lang.String r10 = r1.a
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0150
            java.lang.String r10 = r1.a
            r13.type = r10
        L_0x0150:
            java.lang.String r10 = r1.c
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0181
            java.lang.String r10 = r1.c
            r13.causedBy = r10
            java.lang.String r10 = r1.b
            boolean r10 = com.bonree.sdk.bs.ad.a((java.lang.String) r10)
            if (r10 != 0) goto L_0x017d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r1.c
            r10.append(r11)
            r10.append(r9)
            java.lang.String r11 = r1.b
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r1.b = r10
            goto L_0x0181
        L_0x017d:
            java.lang.String r10 = r1.c
            r1.b = r10
        L_0x0181:
            if (r3 == 0) goto L_0x0185
            java.lang.String r8 = r5.mDumpInfo
        L_0x0185:
            if (r1 == 0) goto L_0x020e
            java.lang.String r3 = r1.d
            boolean r3 = com.bonree.sdk.bs.ad.c((java.lang.String) r3)
            if (r3 == 0) goto L_0x01c8
            java.lang.String r3 = r1.b
            boolean r3 = com.bonree.sdk.bs.ad.a((java.lang.String) r3)
            if (r3 != 0) goto L_0x01b2
            java.lang.String r3 = r1.b
            boolean r3 = r3.endsWith(r9)
            if (r3 != 0) goto L_0x01b2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = r1.b
            r3.append(r8)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r1.b = r3
        L_0x01b2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = r1.b
            r3.append(r8)
            java.lang.String r1 = r1.d
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r5.mDumpInfo = r1
            goto L_0x020e
        L_0x01c8:
            boolean r3 = com.bonree.sdk.bs.ad.c((java.lang.String) r8)
            if (r3 == 0) goto L_0x020a
            java.lang.String r3 = r1.b
            boolean r3 = com.bonree.sdk.bs.ad.a((java.lang.String) r3)
            if (r3 != 0) goto L_0x01f1
            java.lang.String r3 = r1.b
            boolean r3 = r3.endsWith(r9)
            if (r3 != 0) goto L_0x01f1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r10 = r1.b
            r3.append(r10)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r1.b = r3
        L_0x01f1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = r1.b
            r3.append(r1)
            java.lang.String r1 = "java stack:\r\n"
            r3.append(r1)
            r3.append(r8)
            java.lang.String r1 = r3.toString()
            r5.mDumpInfo = r1
            goto L_0x020e
        L_0x020a:
            java.lang.String r1 = r1.b
            r5.mDumpInfo = r1
        L_0x020e:
            boolean r1 = com.bonree.sdk.bs.ad.c((java.lang.String) r4)
            if (r1 == 0) goto L_0x0237
            if (r6 == 0) goto L_0x0237
            java.lang.String r1 = r6.mDumpInfo
            boolean r3 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)
            if (r3 != 0) goto L_0x0235
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            java.lang.String r4 = "\r\njava stack:\r\n"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r6.mDumpInfo = r1
            goto L_0x0237
        L_0x0235:
            r6.mDumpInfo = r4
        L_0x0237:
            r12.b((com.bonree.sdk.agent.business.entity.CrashEventInfoBean) r13)
            com.bonree.sdk.be.f r1 = r12.j
            java.lang.Object[] r3 = new java.lang.Object[r7]
            java.lang.String r4 = "addNativeCrashInfo success"
            r3[r2] = r4
            r1.c(r0, r3)
        L_0x0245:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ak.a.a(com.bonree.sdk.agent.business.entity.CrashEventInfoBean):com.bonree.sdk.agent.business.entity.CrashEventInfoBean");
    }

    private com.bonree.sdk.aj.a a(long j2, String str) {
        if (!b()) {
            return new com.bonree.sdk.aj.a(false, (String) null, (String) null, 0, (String) null);
        } else if (e.d() == null) {
            return new com.bonree.sdk.aj.a(false, (String) null, (String) null, 0, (String) null);
        } else {
            com.bonree.sdk.aj.a aVar = new com.bonree.sdk.aj.a(true, Agent.getAgentVersion(), e.d().b(), j2, str);
            aVar.b(e.d().c());
            if (!ad.a(str)) {
                this.j.c("self native crash time:%s,crash causeby:%s", Long.valueOf(j2), str);
            }
            return aVar;
        }
    }

    private static int a(String str, String str2) {
        if (str == null || str2 == null || str.length() < str2.length()) {
            return -1;
        }
        if (str.equals(str2)) {
            return 1;
        }
        int i2 = 0;
        while (Pattern.compile(str2, 2).matcher(str).find()) {
            i2++;
        }
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf != -1 && lastIndexOf + str2.length() <= str.length()) {
            i2++;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    private void d(String str) {
        String str2;
        if (!ad.a(str)) {
            if (!this.l.get() || ad.a(str)) {
                str2 = "unknown path";
            } else {
                str2 = this.f + File.separator + str;
            }
            File file = new File(str2);
            if (file.exists() && file.isFile()) {
                boolean delete = file.delete();
                this.j.c("delete crash log success.file:%s state=" + delete, str);
            }
        }
    }

    private void b(CrashEventInfoBean crashEventInfoBean) {
        if (!ad.a(crashEventInfoBean.nativeCrashLogPath)) {
            File file = new File(crashEventInfoBean.nativeCrashLogPath);
            if (file.exists() && file.isFile()) {
                boolean delete = file.delete();
                f fVar = this.j;
                fVar.c("delete crash log success.file:%s state=" + delete, crashEventInfoBean.nativeCrashLogPath);
            }
            crashEventInfoBean.nativeCrashLogPath = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008d, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f() {
        /*
            r10 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r10.l
            boolean r0 = r0.get()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.util.List<java.io.File> r0 = r10.i
            monitor-enter(r0)
            java.util.List<java.io.File> r2 = r10.i     // Catch:{ all -> 0x008e }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return r1
        L_0x0017:
            java.util.List<java.io.File> r2 = r10.i     // Catch:{ all -> 0x008e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x008e }
            r3 = r1
            r4 = r3
        L_0x001f:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0087
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x008e }
            java.io.File r5 = (java.io.File) r5     // Catch:{ all -> 0x008e }
            boolean r6 = r5.exists()     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x001f
            boolean r6 = r5.isFile()     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x001f
            boolean r4 = r5.delete()     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x001f
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x008e }
            com.bonree.sdk.be.f r6 = r10.j     // Catch:{ all -> 0x008e }
            java.lang.String r7 = "delete crash log success.file:%s"
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x008e }
            r9[r1] = r5     // Catch:{ all -> 0x008e }
            r6.c(r7, r9)     // Catch:{ all -> 0x008e }
            java.util.Properties r6 = r10.e     // Catch:{ all -> 0x008e }
            java.lang.String r6 = r6.getProperty(r5)     // Catch:{ all -> 0x008e }
            boolean r7 = com.bonree.sdk.bs.ad.a((java.lang.String) r6)     // Catch:{ all -> 0x008e }
            if (r7 != 0) goto L_0x001f
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x008e }
            r7.<init>(r6)     // Catch:{ all -> 0x008e }
            boolean r9 = r7.exists()     // Catch:{ all -> 0x008e }
            if (r9 == 0) goto L_0x001f
            boolean r9 = r7.isFile()     // Catch:{ all -> 0x008e }
            if (r9 == 0) goto L_0x001f
            boolean r4 = r7.delete()     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x001f
            com.bonree.sdk.be.f r3 = r10.j     // Catch:{ all -> 0x008e }
            java.lang.String r7 = "delete native crash success.file:%s"
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x008e }
            r9[r1] = r6     // Catch:{ all -> 0x008e }
            r3.c(r7, r9)     // Catch:{ all -> 0x008e }
            java.util.Properties r3 = r10.e     // Catch:{ all -> 0x008e }
            java.lang.Object r3 = r3.remove(r5)     // Catch:{ all -> 0x008e }
            if (r3 == 0) goto L_0x0085
            r3 = r8
            goto L_0x001f
        L_0x0085:
            r3 = r1
            goto L_0x001f
        L_0x0087:
            if (r3 == 0) goto L_0x008c
            r10.e()     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return r4
        L_0x008e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ak.a.f():boolean");
    }

    public final boolean b() {
        File[] listFiles;
        if (!(!this.l.get() || (listFiles = new File(this.g).listFiles()) == null || listFiles.length == 0)) {
            b bVar = new b(this.k.get());
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                try {
                    if (bVar.a(com.bonree.sdk.bb.f.b(listFiles[i2].getAbsolutePath()))) {
                        return true;
                    }
                    i2++;
                } catch (IOException e2) {
                    this.j.a("CrashStorage ergodic native dumps error:", (Throwable) e2);
                }
            }
        }
        return false;
    }

    public final boolean c() {
        if (!this.l.get()) {
            return false;
        }
        if (!this.m.get()) {
            this.j.d("no need load crash storage resource!", new Object[0]);
            return false;
        }
        this.m.getAndSet(false);
        synchronized (this.i) {
            this.j.c("load crash stroage resource...", new Object[0]);
            try {
                this.e.load(new FileInputStream(this.h));
            } catch (FileNotFoundException | IOException unused) {
                return false;
            }
        }
        return true;
    }

    public final boolean d() {
        if (!this.l.get()) {
            return false;
        }
        this.m.getAndSet(true);
        synchronized (this.i) {
            this.e.clear();
            if (this.i.isEmpty()) {
                return false;
            }
            this.i.clear();
            return true;
        }
    }

    public a() {
    }

    public static <T> T a(Set<T> set, Random random) {
        int nextInt = random.nextInt(set.size());
        Iterator<T> it = set.iterator();
        for (int i2 = 0; i2 < nextInt && it.hasNext(); i2++) {
            it.next();
        }
        return it.next();
    }
}
