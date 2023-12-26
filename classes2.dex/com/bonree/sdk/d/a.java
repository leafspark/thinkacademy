package com.bonree.sdk.d;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.Bonree;
import com.bonree.sdk.agent.business.entity.AppStateInfoBean;
import com.bonree.sdk.agent.business.entity.DataFusionInfo;
import com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean;
import com.bonree.sdk.agent.engine.state.m;
import com.bonree.sdk.be.e;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    private static long G = SystemClock.elapsedRealtime();
    private static final long H = (SystemClock.elapsedRealtime() * 1000);
    private static long I = (System.currentTimeMillis() * 1000);
    private static long J = 0;
    private static long M = 0;
    private static long N = 0;
    private static long O = 0;
    private static long P = 0;
    private static long Q = 0;
    private static volatile Bonree.AuthenticationCallBack R = null;
    public static final f a = (!ac ? new com.bonree.sdk.be.b() : new e());
    private static final boolean ab = ad.k();
    private static final boolean ac = ad.l();
    public static final String b = (File.separator + "bonreeSdk");
    public static final String c = UUID.randomUUID().toString();
    public static Lock d = new ReentrantLock();
    public static int e = 24;
    public static volatile int f = c.c;
    public static volatile int g = C0019a.a;
    private static String h = ".0.0.0";
    private static String i = "SDKConfig.properties";
    private static final String j = "https://sdkupload.bonree.com/config/";
    private final AtomicBoolean A = new AtomicBoolean(false);
    private final AtomicBoolean B = new AtomicBoolean(false);
    private final AtomicBoolean C = new AtomicBoolean(false);
    private final AtomicBoolean D = new AtomicBoolean(true);
    private String E;
    private List<String> F = null;
    /* access modifiers changed from: private */
    public SharedPreferences K = null;
    /* access modifiers changed from: private */
    public SharedPreferences.Editor L = null;
    private long S = TimeUnit.SECONDS.toMillis(15);
    private long T;
    private String[] U;
    private String[] V;
    private String[] W;
    private String[] X;
    private String[] Y;
    private final AtomicBoolean Z = new AtomicBoolean(true);
    private ConfigResponseBean aa;
    private long ad = 0;
    private long ae = SystemClock.elapsedRealtime();
    private String af;
    private boolean ag;
    private Map<String, String> ah;
    private final AtomicBoolean k = new AtomicBoolean(false);
    private String l;
    private String m = j;
    private String n;
    private String o;
    private String p;
    private DataFusionInfo q;
    private final AtomicBoolean r = new AtomicBoolean(false);
    private boolean s;
    private final int t = 40;
    private final int u = 5;
    private final int v = 2000;
    private final int w = 5000;
    private final int x = 2000;
    private int y = 5;
    private final int z = 20;

    public static int o() {
        return 2000;
    }

    public static int p() {
        return 5000;
    }

    public static int q() {
        return 2000;
    }

    public static int r() {
        return 20;
    }

    public final int t() {
        return 40;
    }

    public final int u() {
        return 5;
    }

    public final DataFusionInfo a() {
        return this.q;
    }

    public final void a(DataFusionInfo dataFusionInfo) {
        this.q = dataFusionInfo;
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static void c() {
        G = Math.min(G, SystemClock.elapsedRealtime() - SystemClock.currentThreadTimeMillis());
    }

    private static long d(long j2) {
        return (j2 - G) * 1000;
    }

    public static long d() {
        return (SystemClock.elapsedRealtime() - G) * 1000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(long r10) {
        /*
            java.lang.Class<com.bonree.sdk.d.a> r0 = com.bonree.sdk.d.a.class
            monitor-enter(r0)
            r1 = 0
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            long r3 = M     // Catch:{ all -> 0x00aa }
            int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0028
            M = r10     // Catch:{ all -> 0x00aa }
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = "eventTime parse:MAX_EVENT_TIME_IN_SESSION update %d "
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x00aa }
            long r8 = M     // Catch:{ all -> 0x00aa }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00aa }
            r7[r4] = r8     // Catch:{ all -> 0x00aa }
            r3.a((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ all -> 0x00aa }
        L_0x0028:
            long r6 = P     // Catch:{ all -> 0x00aa }
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0044
            P = r10     // Catch:{ all -> 0x00aa }
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = "eventTime parse:MIN_EVENT_TIME_CURRENT_UPLOAD create %d "
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x00aa }
            long r8 = P     // Catch:{ all -> 0x00aa }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00aa }
            r7[r4] = r8     // Catch:{ all -> 0x00aa }
            r3.a((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ all -> 0x00aa }
            goto L_0x005d
        L_0x0044:
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x005d
            P = r10     // Catch:{ all -> 0x00aa }
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = "eventTime parse:MIN_EVENT_TIME_CURRENT_UPLOAD update! %d "
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x00aa }
            long r8 = P     // Catch:{ all -> 0x00aa }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00aa }
            r7[r4] = r8     // Catch:{ all -> 0x00aa }
            r3.a((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ all -> 0x00aa }
        L_0x005d:
            long r6 = N     // Catch:{ all -> 0x00aa }
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x007a
            N = r10     // Catch:{ all -> 0x00aa }
            com.bonree.sdk.be.f r10 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00aa }
            java.lang.String r11 = "eventTime parse:MIN_EVENT_TIME_IN_SESSION create %d "
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x00aa }
            long r2 = N     // Catch:{ all -> 0x00aa }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00aa }
            r1[r4] = r2     // Catch:{ all -> 0x00aa }
            r10.a((java.lang.String) r11, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00aa }
            monitor-exit(r0)
            return
        L_0x007a:
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x00a8
            long r8 = O     // Catch:{ all -> 0x00aa }
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00a8
            long r1 = Q     // Catch:{ all -> 0x00aa }
            long r6 = r6 - r10
            long r1 = r1 + r6
            Q = r1     // Catch:{ all -> 0x00aa }
            N = r10     // Catch:{ all -> 0x00aa }
            com.bonree.sdk.be.f r10 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00aa }
            java.lang.String r11 = "eventTime parse:MIN_EVENT_TIME_IN_SESSION update！ eventTime: %d,NEED_LACK_TIME: %d "
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00aa }
            long r2 = N     // Catch:{ all -> 0x00aa }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00aa }
            r1[r4] = r2     // Catch:{ all -> 0x00aa }
            long r2 = Q     // Catch:{ all -> 0x00aa }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00aa }
            r1[r5] = r2     // Catch:{ all -> 0x00aa }
            r10.a((java.lang.String) r11, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00aa }
        L_0x00a8:
            monitor-exit(r0)
            return
        L_0x00aa:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.d.a.a(long):void");
    }

    public static synchronized long e() {
        long j2;
        long max;
        long j3;
        synchronized (a.class) {
            long j4 = O;
            if (j4 <= 0) {
                long j5 = P;
                if (j5 > 0) {
                    j2 = M - j5;
                    com.bonree.sdk.be.a.a().a("usd Calculation:MAX_EVENT_TIME_IN_SESSION %d - MIN_EVENT_TIME_CURRENT_UPLOAD %d ", Long.valueOf(M), Long.valueOf(P));
                    max = Math.max(0, j2) + Q;
                    j3 = M;
                    if (j3 > 0 && j3 > O) {
                        O = j3;
                    }
                    P = 0;
                    M = 0;
                    Q = 0;
                }
            }
            if (j4 > 0) {
                j2 = M - j4;
                com.bonree.sdk.be.a.a().a("usd Calculation:MAX_EVENT_TIME_IN_SESSION %d - MAX_EVENT_TIME_LAST_UPLOAD %d ", Long.valueOf(M), Long.valueOf(O));
            } else {
                M = 0;
                com.bonree.sdk.be.a.a().a("usd Calculation:NO EVENT  MAX_EVENT_TIME_IN_SESSION=0, usd=0 ", new Object[0]);
                j2 = 0;
            }
            max = Math.max(0, j2) + Q;
            j3 = M;
            O = j3;
            P = 0;
            M = 0;
            Q = 0;
        }
        return max;
    }

    public static void f() {
        O = 0;
        N = P;
        com.bonree.sdk.be.a.a().a("NewSession:resetFlag MAX_EVENT_TIME_LAST_UPLOAD 000   And  MIN_EVENT_TIME_IN_SESSION :%d ", Long.valueOf(N));
    }

    public static void g() {
        g = C0019a.d;
        if (R != null) {
            R.requestPermission();
        }
    }

    public final void a(int i2) {
        if (i2 > 0) {
            this.S = TimeUnit.SECONDS.toMillis((long) i2);
        }
    }

    public final long h() {
        return this.S;
    }

    public final AppStateInfoBean i() {
        AppStateInfoBean appStateInfoBean = new AppStateInfoBean();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.ae;
        long j3 = j2 <= 0 ? this.ad : (elapsedRealtime - j2) + this.ad;
        this.ad = 0;
        if (j2 != 0) {
            this.ae = elapsedRealtime;
        }
        appStateInfoBean.mPeriodicForegroundTimeUs = j3 * 1000;
        long j4 = (elapsedRealtime - G) * 1000;
        appStateInfoBean.mPeriodicProcessLifeTimeUs = j4 - this.T;
        this.T = j4;
        return appStateInfoBean;
    }

    /* renamed from: com.bonree.sdk.d.a$a  reason: collision with other inner class name */
    public enum C0019a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;

        static {
            e = new int[]{1, 2, 3, 4};
        }

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    public static void a(boolean z2) {
        g = z2 ? C0019a.c : C0019a.b;
    }

    public static void a(Bonree.AuthenticationCallBack authenticationCallBack) {
        R = authenticationCallBack;
    }

    public static void b(long j2) {
        long j3 = 0;
        if (J <= 0) {
            J = I;
            if (j2 > 0) {
                j3 = 1000 * SystemClock.elapsedRealtime();
                I = j2 - (j3 - H);
            }
            com.bonree.sdk.be.a.a().c("agent init time us %d: ,interval us: %d ,server time: %d ,current interval us: %d,calibration agent init time us: %d", Long.valueOf(J), Long.valueOf(H), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(I));
        }
    }

    public final String j() {
        return "?v=" + Agent.PROTOCOL_VERSION + "&a=" + this.n + "&d=" + F();
    }

    public static a k() {
        return d.a;
    }

    public static long l() {
        long elapsedRealtime = I + ((SystemClock.elapsedRealtime() * 1000) - H);
        return J > 0 ? elapsedRealtime : -elapsedRealtime;
    }

    public static long c(long j2) {
        if (J <= 0) {
            return Math.abs(j2);
        }
        return I + (Math.abs(j2) - J);
    }

    private void b(ConfigResponseBean configResponseBean) {
        this.aa = configResponseBean;
    }

    public final ConfigResponseBean m() {
        return this.aa;
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        if (com.bonree.sdk.bs.a.a() == null) {
            return false;
        }
        SharedPreferences sharedPreferences = com.bonree.sdk.bs.a.a().getSharedPreferences("configuration", 0);
        this.K = sharedPreferences;
        this.L = sharedPreferences.edit();
        String a2 = b.a("config_resp");
        if (TextUtils.isEmpty(a2)) {
            return true;
        }
        ConfigResponseBean configResponseBean = (ConfigResponseBean) new Gson().fromJson(a2, ConfigResponseBean.class);
        this.aa = configResponseBean;
        a(configResponseBean);
        return true;
    }

    public static boolean s() {
        return f == c.b;
    }

    public final String v() {
        return this.n;
    }

    public final boolean w() {
        boolean z2 = TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n);
        if (z2) {
            f fVar = a;
            fVar.e("invalid parameter config url :  " + this.m + " application app iD : " + this.n, new Object[0]);
        }
        return z2;
    }

    public enum c {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{1, 2, 3};
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    public final List<String> x() {
        return this.F;
    }

    public static long y() {
        return I;
    }

    public final boolean z() {
        return this.r.get();
    }

    public final boolean A() {
        return this.s;
    }

    public final void b(boolean z2) {
        this.s = z2;
    }

    public final void a(String str) {
        if (h(str)) {
            this.E = str;
        }
    }

    public final boolean B() {
        return this.C.get();
    }

    public final void c(boolean z2) {
        this.C.getAndSet(z2);
    }

    public final boolean C() {
        return this.D.get();
    }

    public final void d(boolean z2) {
        this.D.getAndSet(z2);
    }

    public final String D() {
        return this.o;
    }

    public final String E() {
        return this.p;
    }

    public final String F() {
        if (TextUtils.isEmpty(this.p)) {
            return com.bonree.sdk.am.f.d();
        }
        return this.p;
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() <= 64) {
            this.o = str;
        }
    }

    public final void c(String str) {
        if (h(str) && ad.e(str)) {
            this.p = str;
        }
    }

    public final String G() {
        if (TextUtils.isEmpty(this.E)) {
            return null;
        }
        return this.E;
    }

    public final void e(boolean z2) {
        this.A.getAndSet(z2);
    }

    public final boolean H() {
        return this.A.get();
    }

    public final boolean I() {
        return this.B.get();
    }

    public final boolean J() {
        return !this.Z.get();
    }

    public static boolean K() {
        return ab;
    }

    public static boolean L() {
        return ac;
    }

    private long e(long j2) {
        long j3 = this.ae;
        long j4 = j3 <= 0 ? this.ad : (j2 - j3) + this.ad;
        this.ad = 0;
        if (j3 != 0) {
            this.ae = j2;
        }
        return j4 * 1000;
    }

    public final void f(boolean z2) {
        if (!z2) {
            if (this.ae >= 0) {
                this.ad += SystemClock.elapsedRealtime() - this.ae;
                this.ae = 0;
            }
        } else if (this.ae == 0) {
            this.ae = SystemClock.elapsedRealtime();
        }
        this.Z.getAndSet(z2);
    }

    public final String M() {
        return this.m;
    }

    public final void d(String str) {
        this.n = str;
    }

    public final void e(String str) {
        this.m = str;
    }

    public final void f(String str) {
        if (TextUtils.isEmpty(this.n) && h(str)) {
            this.n = str;
        }
    }

    public final void g(String str) {
        if ((TextUtils.isEmpty(this.m) || j.equals(this.m)) && !TextUtils.isEmpty(str) && str.length() <= 2083) {
            this.m = str;
        }
    }

    private static boolean h(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 256;
    }

    public final String N() {
        return this.l;
    }

    public final String O() {
        if (!TextUtils.isEmpty(this.l)) {
            return this.l;
        }
        ConfigResponseBean configResponseBean = this.aa;
        return configResponseBean != null ? configResponseBean.mUploadAddress : this.l;
    }

    private void i(String str) {
        this.l = str;
    }

    public final boolean P() {
        return this.k.get();
    }

    public final void g(boolean z2) {
        this.k.getAndSet(z2);
    }

    public final void a(ConfigResponseBean configResponseBean) {
        if (configResponseBean != null) {
            e = configResponseBean.mSaveTime;
            this.aa = configResponseBean;
            this.l = configResponseBean.mUploadAddress;
            b(configResponseBean.mCustomBusinessHeaderKeys);
            d(configResponseBean.mCustomBusinessBodyKeys);
            e(configResponseBean.mCustomBusinessQueryKeys);
            f(configResponseBean.mResponseHeaderTraceKeys);
            g(configResponseBean.mRequestHeaderTraceKeys);
            if (configResponseBean.mNetworkTraceConfig != null) {
                this.af = new Gson().toJson((Object) configResponseBean.mNetworkTraceConfig);
            }
            this.ag = configResponseBean.mOpenDataMerge;
        }
    }

    public final boolean Q() {
        return this.ag && this.af != null;
    }

    public final String R() {
        return this.af;
    }

    public final String[] S() {
        return this.U;
    }

    public final String[] T() {
        return this.V;
    }

    public final String[] U() {
        return this.W;
    }

    public final String[] V() {
        return this.X;
    }

    public final String[] W() {
        return this.Y;
    }

    public final String X() {
        String str;
        String[] strArr = this.V;
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 == 0) {
                sb.append("[");
            }
            sb.append("'");
            sb.append(strArr[i2]);
            sb.append("'");
            if (i2 >= strArr.length - 1) {
                str = "";
            } else {
                str = ",";
            }
            sb.append(str);
            if (i2 == strArr.length - 1) {
                sb.append("]");
            }
        }
        String sb2 = sb.toString();
        com.bonree.sdk.be.a.a().a("js inject getCustomBusinessBodyKeys : %s", sb2);
        return sb2;
    }

    private static String[] c(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        if (strArr.length < 64) {
            return strArr;
        }
        return (String[]) Arrays.copyOf(strArr, 64);
    }

    public final void b(String... strArr) {
        try {
            this.U = null;
            if (strArr != null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (String str : strArr) {
                    if (h(str) && ad.e(str)) {
                        linkedHashSet.add(str);
                        if (linkedHashSet.size() >= 64) {
                            break;
                        }
                    }
                }
                if (linkedHashSet.size() > 0) {
                    this.U = (String[]) linkedHashSet.toArray(new String[0]);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void d(String... strArr) {
        try {
            this.V = null;
            if (strArr != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (h(str) && ad.e(str)) {
                        arrayList.add(str);
                        if (arrayList.size() >= 64) {
                            break;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.V = (String[]) arrayList.toArray(new String[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void e(String... strArr) {
        try {
            this.W = null;
            if (strArr != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (h(str) && ad.e(str)) {
                        arrayList.add(str);
                        if (arrayList.size() >= 64) {
                            break;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.W = (String[]) arrayList.toArray(new String[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void f(String... strArr) {
        try {
            this.X = null;
            if (strArr != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (h(str) && ad.e(str)) {
                        arrayList.add(str);
                        if (arrayList.size() >= 64) {
                            break;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.X = (String[]) arrayList.toArray(new String[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void g(String... strArr) {
        try {
            this.Y = null;
            if (strArr != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (h(str) && ad.e(str)) {
                        arrayList.add(str);
                        if (arrayList.size() >= 64) {
                            break;
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.Y = (String[]) arrayList.toArray(new String[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void h(boolean z2) {
        this.r.set(z2);
    }

    public final void i(boolean z2) {
        this.B.set(z2);
    }

    public static String Z() {
        try {
            if (m.g().h()) {
                return m.g().a();
            }
            return ad.a.a();
        } catch (Throwable unused) {
            return "NaN";
        }
    }

    public final void b(int i2) {
        if (i2 > 0 && i2 <= 30) {
            this.y = i2;
        }
    }

    public final int aa() {
        return this.y;
    }

    static class d {
        /* access modifiers changed from: private */
        public static final a a = new a();

        private d() {
        }
    }

    public static class b {
        private static String a = "configuration";
        private static String b = "config_resp";
        private int c;
        private long d;
        private boolean e;

        public b() {
        }

        private static void a(String str, String[] strArr) {
            if (Build.VERSION.SDK_INT >= 11) {
                a(str, strArr, false);
            } else {
                b(str, strArr, false);
            }
        }

        private static void b(String str, String[] strArr) {
            a(str, strArr, false);
        }

        private static void c(String str, String[] strArr) {
            b(str, strArr, false);
        }

        private static void a(String str, String[] strArr, boolean z) {
            String[] b2;
            SharedPreferences.Editor a2 = a.k().L;
            if (a2 == null) {
                return;
            }
            if (!z || (b2 = b(str)) == null) {
                HashSet hashSet = new HashSet();
                for (String add : strArr) {
                    hashSet.add(add);
                }
                a2.putStringSet(str, hashSet);
                a2.commit();
                return;
            }
            a2.putStringSet(str, a(b2, strArr));
            a2.commit();
        }

        private static void b(String str, String[] strArr, boolean z) {
            SharedPreferences.Editor a2;
            String[] c2 = c(str);
            int length = strArr.length;
            String str2 = "";
            for (int i = 0; i < length; i++) {
                String str3 = strArr[i];
                if (z) {
                    int length2 = c2.length;
                    int i2 = 0;
                    while (i2 < length2 && !c2[i2].equals(str3)) {
                        i2++;
                    }
                    if (!"".equals(str2)) {
                        str2 = str2 + "#" + str3;
                    }
                } else if (!"".equals(str2)) {
                    str2 = str2 + "#" + str3;
                }
                str2 = str3;
            }
            if (!"".equals(str2) && (a2 = a.k().L) != null) {
                a2.putString(str, str2);
                a2.commit();
            }
        }

        private static String[] b(String str) {
            SharedPreferences b2 = a.k().K;
            if (b2 == null) {
                return new String[0];
            }
            Set<String> stringSet = b2.getStringSet(str, (Set) null);
            if (stringSet == null) {
                return null;
            }
            String[] strArr = new String[stringSet.size()];
            for (int i = 0; i < stringSet.size(); i++) {
                String next = stringSet.iterator().next();
                if (next != null) {
                    strArr[i] = next;
                }
            }
            return strArr;
        }

        private static Set<String> a(String[] strArr, String[] strArr2) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, strArr);
            Collections.addAll(hashSet, strArr2);
            return hashSet;
        }

        private static String[] c(String str) {
            String a2 = a(str);
            String[] strArr = new String[1];
            if (a2.contains("#")) {
                return a2.split("#");
            }
            strArr[0] = a2;
            return strArr;
        }

        public static String a(String str) {
            SharedPreferences b2 = a.k().K;
            if (b2 != null) {
                return b2.getString(str, "");
            }
            return "";
        }

        private static void c(String str, String[] strArr, boolean z) {
            if (Build.VERSION.SDK_INT >= 11) {
                a(str, strArr, z);
            } else {
                b(str, strArr, z);
            }
        }

        private static void d() {
            SharedPreferences.Editor a2 = a.k().L;
            if (a2 != null) {
                a2.clear();
            }
        }

        private static void a(String str, boolean z) {
            SharedPreferences.Editor a2 = a.k().L;
            if (a2 != null) {
                a2.putBoolean(str, z);
                a2.commit();
            }
        }

        private static boolean d(String str) {
            SharedPreferences b2 = a.k().K;
            if (b2 != null) {
                return b2.getBoolean(str, false);
            }
            return false;
        }

        private static boolean b(String str, boolean z) {
            SharedPreferences b2 = a.k().K;
            if (b2 != null) {
                return b2.getBoolean(str, z);
            }
            return false;
        }

        private static void a(String str, String str2) {
            SharedPreferences.Editor a2 = a.k().L;
            if (a2 != null) {
                a2.putString(str, str2);
                a2.commit();
            }
        }

        private static void a(String str, long j, boolean z) {
            SharedPreferences.Editor a2 = a.k().L;
            if (a2 != null) {
                a2.putLong(str, j);
                if (z) {
                    a2.commit();
                } else {
                    a2.apply();
                }
            }
        }

        private static long e(String str) {
            SharedPreferences b2 = a.k().K;
            if (b2 != null) {
                return b2.getLong(str, 0);
            }
            return 0;
        }

        private static void f(String str) {
            SharedPreferences.Editor a2 = a.k().L;
            if (a2 != null) {
                a2.remove(str);
                a2.commit();
            }
        }

        public b(int i, long j, boolean z) {
            this.c = i;
            this.d = j;
            this.e = z;
        }

        public int a() {
            return this.c;
        }

        public void a(int i) {
            this.c = i;
        }

        public long b() {
            return this.d;
        }

        public void a(long j) {
            this.d = j;
        }

        public boolean c() {
            return this.e;
        }

        public void a(boolean z) {
            this.e = z;
        }

        public String toString() {
            return "SocketReceivePacketData{receiveByte=" + this.c + ", receiveEndTimeMs=" + this.d + ", flag=" + this.e + '}';
        }
    }

    public final void a(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        if (map != null && map.size() > 0) {
            HashMap hashMap = null;
            for (String next : map.keySet()) {
                if (next != null) {
                    if (!(next instanceof String)) {
                        str = next;
                    } else {
                        str = next;
                    }
                    if (!TextUtils.isEmpty(str) && str.length() <= 256 && (str2 = map.get(next)) != null) {
                        if (!(str2 instanceof String)) {
                            str3 = str2;
                        } else {
                            str3 = str2;
                        }
                        if (!TextUtils.isEmpty(str3) && str3.length() <= 512) {
                            if (hashMap == null) {
                                hashMap = new HashMap();
                            }
                            hashMap.put(str, str3);
                            if (hashMap.size() >= 64) {
                                break;
                            }
                        }
                    }
                }
            }
            this.ah = hashMap;
        }
    }

    public final Map<String, String> ab() {
        return this.ah;
    }

    public final String toString() {
        String str;
        if (this.aa == null || !com.bonree.sdk.be.a.b()) {
            str = "";
        } else {
            str = "config module backup: " + this.aa.mModuleConfiguration;
        }
        return "Bonree AppID=" + this.n + "\nuse ConfigAddress=" + this.m + " ,channel id=" + this.E + "\n,toastEnable=" + this.C + ",logEnable=" + this.D + ",allLaunch=" + this.s + "\n,syncStart=" + this.k + " ,box= " + this.r + " ,define app v= " + this.o + " ,define dev id =" + this.p + " \r\n " + str;
    }

    public final void a(String... strArr) {
        if (strArr == null) {
            strArr = null;
        } else {
            try {
                if (strArr.length >= 64) {
                    strArr = (String[]) Arrays.copyOf(strArr, 64);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        this.F = Arrays.asList(strArr);
    }

    public final boolean Y() {
        ConfigResponseBean configResponseBean = this.aa;
        if (configResponseBean != null && configResponseBean.mUploadScenario == 1) {
            String Z2 = Z();
            if (!TextUtils.isEmpty(Z2)) {
                com.bonree.sdk.be.a.a().a("Upload invalid ::: netStandard %s", Z2);
                return !"WiFi".equals(Z2) && !"NaN".equals(Z2);
            }
        }
    }
}
