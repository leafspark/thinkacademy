package com.bonree.sdk.am;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.location.LocationManager;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import android.provider.Settings;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public abstract class i {
    private static final int C = 100;
    private static final String F = "/sys/devices/system/cpu/cpu";
    private static final String G = "/cpufreq/scaling_available_frequencies";
    private static final String H = "/cpufreq/scaling_cur_freq";
    private static final String I = "/cpufreq/stats/time_in_state";
    private static final String J = "/proc/%s/stat";
    private static final String j = "DeviceStateInfo";
    private static String k = "utf-8";
    private static byte l = 1;
    private static byte m = 2;
    private static final int n = 5000;
    private final f A = a.a();
    private boolean B = true;
    private long D = 0;
    private long[] E = new long[2];
    private final Pattern K = Pattern.compile("[0-9]\\d*.\\d*%|0\\.\\d*[0-9]\\d*%|[0-9]\\d*%");
    private final Pattern L = Pattern.compile("[0-9]\\d*.\\d*\\s|0\\.\\d*[0-9]\\d*|[0-9]\\d*");
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public byte h = 1;
    public long i;
    private int o = -1;
    private int p = -1;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private volatile boolean t = false;
    private ContentResolver u;
    private long v = 0;
    /* access modifiers changed from: private */
    public LocationManager w;
    private ContentObserver x;
    private ActivityManager y;
    private volatile boolean z = false;

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public void e() {
    }

    /* access modifiers changed from: package-private */
    public void f() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:3|4|5|6|(1:8)|9|(3:11|(1:13)(1:14)|15)|16|17|(1:19)|20|(3:22|(1:26)|(1:28))|29|30|34) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A[Catch:{ all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[Catch:{ all -> 0x006b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r6 = this;
            long r0 = com.bonree.sdk.d.a.b()     // Catch:{ all -> 0x0082 }
            long r2 = r6.v     // Catch:{ all -> 0x0082 }
            long r2 = r0 - r2
            r4 = 5000(0x1388, double:2.4703E-320)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0081
            r6.j()     // Catch:{ all -> 0x0082 }
            r6.a()     // Catch:{ all -> 0x0082 }
            r6.b()     // Catch:{ all -> 0x0082 }
            r2 = 1
            r3 = 0
            android.content.ContentResolver r4 = r6.u     // Catch:{ all -> 0x0038 }
            if (r4 != 0) goto L_0x0027
            android.content.Context r4 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x0038 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0038 }
            r6.u = r4     // Catch:{ all -> 0x0038 }
        L_0x0027:
            android.content.ContentResolver r4 = r6.u     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x0038
            java.lang.String r5 = "accelerometer_rotation"
            int r4 = android.provider.Settings.System.getInt(r4, r5)     // Catch:{ all -> 0x0038 }
            if (r4 != 0) goto L_0x0035
            r4 = r2
            goto L_0x0036
        L_0x0035:
            r4 = r3
        L_0x0036:
            r6.g = r4     // Catch:{ all -> 0x0038 }
        L_0x0038:
            int[] r2 = new int[r2]     // Catch:{ all -> 0x006b }
            int r4 = android.os.Process.myPid()     // Catch:{ all -> 0x006b }
            r2[r3] = r4     // Catch:{ all -> 0x006b }
            android.app.ActivityManager r4 = r6.y     // Catch:{ all -> 0x006b }
            if (r4 != 0) goto L_0x0052
            android.content.Context r4 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x006b }
            java.lang.String r5 = "activity"
            java.lang.Object r4 = r4.getSystemService(r5)     // Catch:{ all -> 0x006b }
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4     // Catch:{ all -> 0x006b }
            r6.y = r4     // Catch:{ all -> 0x006b }
        L_0x0052:
            android.app.ActivityManager r4 = r6.y     // Catch:{ all -> 0x006b }
            if (r4 == 0) goto L_0x006b
            android.os.Debug$MemoryInfo[] r2 = r4.getProcessMemoryInfo(r2)     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x0065
            int r4 = r2.length     // Catch:{ all -> 0x006b }
            if (r4 <= 0) goto L_0x0065
            r2 = r2[r3]     // Catch:{ all -> 0x006b }
            int r3 = r2.getTotalPss()     // Catch:{ all -> 0x006b }
        L_0x0065:
            if (r3 < 0) goto L_0x006b
            int r3 = r3 / 1024
            r6.a = r3     // Catch:{ all -> 0x006b }
        L_0x006b:
            r6.c()     // Catch:{ all -> 0x0082 }
            r6.d()     // Catch:{ all -> 0x0082 }
            com.bonree.sdk.d.e r2 = com.bonree.sdk.d.e.d()     // Catch:{ all -> 0x0082 }
            com.bonree.sdk.au.a r2 = r2.m()     // Catch:{ all -> 0x0082 }
            long r2 = r2.a()     // Catch:{ all -> 0x0082 }
            r6.i = r2     // Catch:{ all -> 0x0082 }
            r6.v = r0     // Catch:{ all -> 0x0082 }
        L_0x0081:
            return
        L_0x0082:
            r0 = move-exception
            com.bonree.sdk.be.f r1 = r6.A
            java.lang.String r2 = "DeviceStateInfo update Exception "
            r1.a((java.lang.String) r2, (java.lang.Throwable) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.am.i.h():void");
    }

    public final long i() {
        return this.i;
    }

    private void t() {
        try {
            if (this.u == null) {
                this.u = com.bonree.sdk.bs.a.a().getContentResolver();
            }
            ContentResolver contentResolver = this.u;
            if (contentResolver != null) {
                this.g = Settings.System.getInt(contentResolver, "accelerometer_rotation") == 0;
            }
        } catch (Throwable unused) {
        }
    }

    private void u() {
        try {
            int i2 = 0;
            int[] iArr = {Process.myPid()};
            if (this.y == null) {
                this.y = (ActivityManager) com.bonree.sdk.bs.a.a().getSystemService("activity");
            }
            ActivityManager activityManager = this.y;
            if (activityManager != null) {
                Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                    i2 = processMemoryInfo[0].getTotalPss();
                }
                if (i2 >= 0) {
                    this.a = i2 / PictureFileUtils.KB;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void j() {
        this.p = -1;
        if (!A()) {
            y();
            v();
        }
    }

    private void v() {
        try {
            long x2 = x();
            long[] w2 = w();
            long j2 = this.D;
            if (j2 == 0) {
                this.D = x2;
                this.E = w2;
                return;
            }
            long j3 = x2 - j2;
            long j4 = w2[0];
            long[] jArr = this.E;
            w2[0] = j4 - jArr[0];
            w2[1] = w2[1] - jArr[1];
            if (j3 > 0) {
                this.p = (int) Math.round((double) ((((float) (w2[0] + w2[1])) * 100.0f) / ((float) j3)));
                this.D += j3;
                long[] jArr2 = this.E;
                jArr2[0] = jArr2[0] + w2[0];
                jArr2[1] = jArr2[1] + w2[1];
            }
        } catch (Throwable th) {
            this.A.a(j, th);
        }
    }

    private static long[] w() throws IOException {
        long[] jArr = new long[2];
        File file = new File(String.format(J, new Object[]{Integer.valueOf(Process.myPid())}));
        if (file.exists()) {
            String[] split = com.bonree.sdk.bb.f.b(file.getAbsolutePath()).split(" ");
            if (split.length >= 15) {
                jArr[0] = Long.parseLong(split[13].replaceAll(" ", ""));
                jArr[1] = Long.parseLong(split[14].replaceAll(" ", ""));
            }
        }
        return jArr;
    }

    private static long x() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(F + i2);
            if (file.exists() && file.isDirectory()) {
                String b2 = com.bonree.sdk.bb.f.b(new File(file.getAbsolutePath() + I).getAbsolutePath());
                if (b2.length() > 0) {
                    String[] split = b2.replace("\r", " ").replace("\n", " ").split(" ");
                    for (int i3 = 0; i3 < split.length; i3 += 3) {
                        j2 += Long.parseLong(split[i3 + 1].replaceAll(" ", ""));
                    }
                }
            }
        }
        return j2;
    }

    private void z() {
        if (this.w == null) {
            this.w = (LocationManager) com.bonree.sdk.bs.a.a().getSystemService(FirebaseAnalytics.Param.LOCATION);
        }
        if (this.w != null && this.x == null) {
            this.x = new j(this, (Handler) null);
        }
    }

    private boolean A() {
        long[] B2 = B();
        if (B2 == null || B2.length <= 0 || B2[0] == -1) {
            return false;
        }
        if (this.q == 0 && this.r == 0) {
            long j2 = B2[0];
            long C2 = C();
            if (j2 >= 0 && C2 >= 0) {
                this.q = B2[0];
                this.r = C();
                this.s = B2[1];
            }
            return true;
        }
        long j3 = B2[0];
        long C3 = C();
        long j4 = B2[1];
        if (j3 == -1 || C3 == -1) {
            this.A.e("get total cpu time error", new Object[0]);
            return true;
        }
        long j5 = this.r;
        if (C3 > j5) {
            long j6 = this.q;
            if (j3 > j6) {
                this.p = (int) Math.ceil((double) ((((float) (C3 - j5)) * 100.0f) / ((float) (j3 - j6))));
                long j7 = this.q;
                this.o = (int) Math.ceil((double) ((((float) ((j3 - j7) - (j4 - this.s))) * 100.0f) / ((float) (j3 - j7))));
                this.q = j3;
                this.r = C3;
                this.s = j4;
                return true;
            }
        }
        return true;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0090 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long[] B() {
        /*
            r13 = this;
            boolean r0 = r13.B
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 2
            long[] r2 = new long[r0]
            r3 = -1
            r5 = 0
            r2[r5] = r3
            java.lang.String r3 = "/proc/stat"
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0090 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0090 }
            boolean r4 = r4.canRead()     // Catch:{ IOException -> 0x0090 }
            if (r4 != 0) goto L_0x0021
            r13.B = r5     // Catch:{ IOException -> 0x0090 }
            com.bonree.sdk.bs.ad.a((java.io.Closeable) r1)
            return r1
        L_0x0021:
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0090 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0090 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0090 }
            r7.<init>(r3)     // Catch:{ IOException -> 0x0090 }
            java.lang.String r3 = "utf-8"
            r6.<init>(r7, r3)     // Catch:{ IOException -> 0x0090 }
            r3 = 100
            r4.<init>(r6, r3)     // Catch:{ IOException -> 0x0090 }
            java.lang.String r1 = r4.readLine()     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            if (r1 == 0) goto L_0x0085
            int r3 = r1.length()     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            if (r3 <= 0) goto L_0x0085
            java.lang.String r3 = " "
            java.lang.String[] r1 = r1.split(r3)     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            int r3 = r1.length     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            r6 = 8
            if (r3 <= r6) goto L_0x0085
            r3 = 5
            r3 = r1[r3]     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r7 = java.lang.Long.parseLong(r3)     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            r0 = r1[r0]     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r9 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            r0 = 3
            r0 = r1[r0]     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r11 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r9 = r9 + r11
            r0 = 4
            r0 = r1[r0]     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r11 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r9 = r9 + r11
            long r9 = r9 + r7
            r0 = 6
            r0 = r1[r0]     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r11 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r9 = r9 + r11
            r0 = 7
            r0 = r1[r0]     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r11 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r9 = r9 + r11
            r0 = r1[r6]     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            long r9 = r9 + r0
            r2[r5] = r9     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
            r0 = 1
            r2[r0] = r7     // Catch:{ IOException -> 0x008c, all -> 0x0089 }
        L_0x0085:
            com.bonree.sdk.bs.ad.a((java.io.Closeable) r4)
            return r2
        L_0x0089:
            r0 = move-exception
            r1 = r4
            goto L_0x0096
        L_0x008c:
            r1 = r4
            goto L_0x0090
        L_0x008e:
            r0 = move-exception
            goto L_0x0096
        L_0x0090:
            r13.B = r5     // Catch:{ all -> 0x008e }
            com.bonree.sdk.bs.ad.a((java.io.Closeable) r1)
            return r2
        L_0x0096:
            com.bonree.sdk.bs.ad.a((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.am.i.B():long[]");
    }

    private static long C() {
        long j2 = 1;
        BufferedReader bufferedReader = null;
        try {
            int myPid = Process.myPid();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + myPid + "/stat"), "utf-8"), 100);
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine != null && readLine.length() > 0) {
                    String[] split = readLine.split(" ");
                    if (split.length > 16) {
                        j2 = Long.parseLong(split[16]) + Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]);
                    }
                }
                ad.a((Closeable) bufferedReader2);
                return j2;
            } catch (IOException unused) {
                bufferedReader = bufferedReader2;
                ad.a((Closeable) bufferedReader);
                return 1;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                ad.a((Closeable) bufferedReader);
                throw th;
            }
        } catch (IOException unused2) {
            ad.a((Closeable) bufferedReader);
            return 1;
        } catch (Throwable th2) {
            th = th2;
            ad.a((Closeable) bufferedReader);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final int k() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public final int l() {
        if (this.p < 0) {
            v();
        }
        if (this.p < 0) {
            this.p = 0;
        }
        if (this.p > 100) {
            this.p = 100;
        }
        return this.p;
    }

    private static float D() {
        float random = (float) Math.random();
        double d2 = (double) random;
        if (d2 < 0.1d) {
            random = (float) (d2 + 0.1d);
        }
        try {
            return ((float) Math.round((random * 10.0f) * 100.0f)) / 100.0f;
        } catch (Throwable unused) {
            return 1.1f;
        }
    }

    /* access modifiers changed from: package-private */
    public final int m() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final int n() {
        if (this.o < 0) {
            y();
        }
        if (this.o < 0) {
            this.o = 0;
        }
        if (this.o > 100) {
            this.o = 100;
        }
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public final int o() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.b;
    }

    public final byte p() {
        return this.h;
    }

    public final boolean q() {
        return this.f;
    }

    public final boolean r() {
        return this.e;
    }

    public final boolean s() {
        return this.g;
    }

    private long E() {
        return this.q;
    }

    private long F() {
        return this.r;
    }

    private long G() {
        return this.s;
    }

    private boolean H() {
        return this.t;
    }

    private ContentResolver I() {
        return this.u;
    }

    private long J() {
        return this.v;
    }

    private LocationManager K() {
        return this.w;
    }

    private ContentObserver L() {
        return this.x;
    }

    private boolean M() {
        return this.z;
    }

    public String toString() {
        return "DeviceStateInfo{mSystemCpu=" + this.o + ", mAppCpu=" + this.p + ", mAppMemory=" + this.a + ", mAvailableBattery=" + this.b + ", mSystemAvailableStorage=" + this.c + ", mSystemAvailableSysMem=" + this.d + ", mBluetoothOpen=" + this.e + ", mGpsOpen=" + this.f + ", mOrientationLock=" + this.g + ", mOrientation=" + this.h + ", mSignal=" + this.i + '}';
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void y() {
        /*
            r12 = this;
            com.bonree.sdk.am.e r0 = com.bonree.sdk.am.e.b.a
            boolean r0 = r0.a()
            r1 = 0
            r2 = r1
        L_0x000a:
            r3 = 100
            if (r2 >= r3) goto L_0x00dd
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            boolean r4 = r3.exists()
            if (r4 == 0) goto L_0x00dd
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto L_0x00dd
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r3.getAbsolutePath()
            r5.append(r6)
            java.lang.String r6 = "/cpufreq/scaling_available_frequencies"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            java.lang.String r5 = "/cpufreq/scaling_cur_freq"
            java.lang.String r6 = " "
            java.lang.String r7 = "\n"
            java.lang.String r8 = "\r"
            java.lang.String r9 = ""
            if (r0 == 0) goto L_0x0082
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{  }
            r4.<init>()     // Catch:{  }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{  }
            r4.append(r3)     // Catch:{  }
            r4.append(r5)     // Catch:{  }
            java.lang.String r3 = r4.toString()     // Catch:{  }
            java.lang.String r3 = com.bonree.sdk.bb.f.b(r3)     // Catch:{  }
            com.bonree.sdk.am.e r4 = com.bonree.sdk.am.e.b.a     // Catch:{ IOException -> 0x00d9 }
            java.lang.String r3 = r3.replace(r8, r9)     // Catch:{ IOException -> 0x00d9 }
            java.lang.String r3 = r3.replace(r7, r9)     // Catch:{ IOException -> 0x00d9 }
            java.lang.String r3 = r3.replace(r6, r9)     // Catch:{ IOException -> 0x00d9 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ IOException -> 0x00d9 }
            r4.a(r2, r3)     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00d9
        L_0x0082:
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{  }
            java.lang.String r4 = com.bonree.sdk.bb.f.b(r4)     // Catch:{  }
            int r10 = r4.length()     // Catch:{  }
            if (r10 <= 0) goto L_0x00d9
            java.lang.String r4 = r4.replace(r8, r9)     // Catch:{  }
            java.lang.String r4 = r4.replace(r7, r9)     // Catch:{  }
            java.lang.String[] r4 = r4.split(r6)     // Catch:{  }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{  }
            r10.<init>()     // Catch:{  }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{  }
            r10.append(r3)     // Catch:{  }
            r10.append(r5)     // Catch:{  }
            java.lang.String r3 = r10.toString()     // Catch:{  }
            java.lang.String r3 = com.bonree.sdk.bb.f.b(r3)     // Catch:{  }
            com.bonree.sdk.am.e r5 = com.bonree.sdk.am.e.b.a     // Catch:{ IOException -> 0x00d9 }
            r10 = r4[r1]     // Catch:{ IOException -> 0x00d9 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ IOException -> 0x00d9 }
            int r11 = r4.length     // Catch:{ IOException -> 0x00d9 }
            int r11 = r11 + -1
            r4 = r4[r11]     // Catch:{ IOException -> 0x00d9 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x00d9 }
            java.lang.String r3 = r3.replace(r8, r9)     // Catch:{ IOException -> 0x00d9 }
            java.lang.String r3 = r3.replace(r7, r9)     // Catch:{ IOException -> 0x00d9 }
            java.lang.String r3 = r3.replace(r6, r9)     // Catch:{ IOException -> 0x00d9 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ IOException -> 0x00d9 }
            r5.a(r10, r4, r3)     // Catch:{ IOException -> 0x00d9 }
        L_0x00d9:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x00dd:
            com.bonree.sdk.am.e r0 = com.bonree.sdk.am.e.b.a
            int r0 = r0.b()
            r12.o = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.am.i.y():void");
    }
}
