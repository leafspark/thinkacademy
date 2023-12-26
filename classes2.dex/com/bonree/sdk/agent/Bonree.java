package com.bonree.sdk.agent;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bonree.sdk.ac.c;
import com.bonree.sdk.agent.business.entity.NetworkCustomEventBean;
import com.bonree.sdk.agent.business.entity.SpeedTestInfo;
import com.bonree.sdk.agent.engine.external.AppStateInfo;
import com.bonree.sdk.agent.engine.external.ClassRewriter;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import com.bonree.sdk.ar.e;
import com.bonree.sdk.ba.p;
import com.bonree.sdk.be.d;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.aa;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.q;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.d.b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import ohos.aafwk.ability.AbilityPackage;
import ohos.data.usage.DataUsage;
import ohos.data.usage.MountState;
import ohos.system.version.SystemVersion;

public class Bonree {
    private static final int a = 33;
    private static final int b = 60000;
    private static int c = 64;
    private static final int d = 2083;
    private final com.bonree.sdk.d.a e;
    private Context f;
    private final f g;

    public interface AuthenticationCallBack {
        void requestPermission();
    }

    /* synthetic */ Bonree(byte b2) {
        this();
    }

    private Bonree() {
        this.e = com.bonree.sdk.d.a.k();
        this.g = com.bonree.sdk.be.a.a();
    }

    public static Bonree withAppID(String str) {
        a.a.e.f(str);
        return a.a;
    }

    private void a(String str) {
        this.e.f(str);
    }

    public static void stopSDK() {
        b a2;
        if (a.a.e != null && !Agent.isNullAgentImpl() && (a2 = Agent.a()) != null) {
            a2.a();
        }
    }

    public static void setRequestExtraInfo(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            e.a(str, str2, str3);
        }
    }

    public static void setCustomEventWithLabel(String str, String str2, String str3) {
        setCustomEventWithLabel(str, str2, str3, (String) null);
    }

    public static void setCustomEventWithLabel(String str, String str2, String str3, String str4) {
        com.bonree.sdk.al.b.g().a(str, str2, str4, str3);
    }

    public static void setCustomEvent(String str, String str2, String str3) {
        com.bonree.sdk.al.b.g().a(str, str2, str3, (String) null);
    }

    public static void setCustomEvent(String str, String str2) {
        setCustomEvent(str, str2, (String) null);
    }

    public static void setCustomEventStart(String str, String str2, String str3, String str4) {
        com.bonree.sdk.al.b.g().b(str, str2, str4, str3);
    }

    public static void setCustomEventStart(String str, String str2, String str3) {
        setCustomEventStart(str, str2, str3, (String) null);
    }

    public static void setCustomEventStart(String str, String str2) {
        setCustomEventStart(str, str2, (String) null, (String) null);
    }

    public static void setCustomEventEnd(String str, String str2, String str3, String str4) {
        com.bonree.sdk.al.b.g().c(str, str2, str4, str3);
    }

    public static void setCustomEventEnd(String str, String str2, String str3) {
        setCustomEventEnd(str, str2, str3, (String) null);
    }

    public static void setCustomEventEnd(String str, String str2) {
        setCustomEventEnd(str, str2, (String) null, (String) null);
    }

    public static void setCustomLog(String str, String str2) {
        com.bonree.sdk.al.b.g().a(str, str2);
    }

    public static void setCustomLog(String str) {
        com.bonree.sdk.al.b.g().a(str, (String) null);
    }

    public static void setCustomMetric(String str, long j, String str2) {
        com.bonree.sdk.al.b.g().a(str, j, str2);
    }

    public static void setCustomMetric(String str, long j) {
        com.bonree.sdk.al.b.g().a(str, j, (String) null);
    }

    public static void setCustomSpeedTest(String str, List<SpeedTestInfo> list) {
        if (!TextUtils.isEmpty(str) && str.length() <= 256 && list != null && list.size() > 0 && list.size() <= 1000) {
            com.bonree.sdk.aw.a.g().a(str, list);
        }
    }

    public static void setUserID(String str) {
        if (!ad.a(str) && str.length() <= 256 && ad.e(str)) {
            com.bonree.sdk.az.b.h().c(str);
            com.bonree.sdk.av.a.e().b(str);
        }
    }

    public static void setExtraInfo(Map<String, Object> map) {
        String str;
        if (map != null) {
            try {
                if (map.size() != 0) {
                    Map<String, Object> e2 = u.e(map);
                    if (e2 != null) {
                        if (e2.size() != 0) {
                            str = ad.d(e2);
                            com.bonree.sdk.az.b.h().d(str);
                            com.bonree.sdk.av.a.e().c(str);
                        }
                    }
                    str = null;
                    com.bonree.sdk.az.b.h().d(str);
                    com.bonree.sdk.av.a.e().c(str);
                }
            } catch (Exception e3) {
                com.bonree.sdk.be.a.a().a("BonreesetExtraInfo:e", (Throwable) e3);
                str = "";
            }
        }
    }

    public Bonree withSDKRequestHeaders(Map<String, String> map) {
        this.e.a(map);
        return this;
    }

    public static String getDeviceID() {
        String F = com.bonree.sdk.d.a.k().F();
        return F == null ? "" : F;
    }

    public static String getSdkVersion() {
        return Agent.getAgentVersion();
    }

    public static void recordLaunchTime(Application application) {
        AppStateInfo.recordLaunchTime(application);
    }

    public static void recordLaunchTime(Application application, Context context) {
        AppStateInfo.recordLaunchTime(application, context);
    }

    public static void recordLaunchTimeOhos(AbilityPackage abilityPackage) {
        AppStateInfo.recordLaunchTime(abilityPackage);
    }

    public static void recordLaunchTimeOhos(AbilityPackage abilityPackage, ohos.app.Context context) {
        AppStateInfo.recordLaunchTime(abilityPackage, context);
    }

    public static void recordCustomLaunchEnd() {
        AppStateInfo.recordCustomLaunchEnd();
    }

    public static void authorizeOnlineTracking(boolean z) {
        com.bonree.sdk.d.a.a(z);
    }

    public static void setOnlineTrackingAuthenticationCallBack(AuthenticationCallBack authenticationCallBack) {
        com.bonree.sdk.d.a.a(authenticationCallBack);
    }

    public static void setCustomPageStart(String str, String str2) {
        if (b(str)) {
            p.a(str, c(str2));
        }
    }

    private static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 256;
    }

    private static String c(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 256) ? str : str.substring(0, WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT);
    }

    public static void setCustomPageEnd(String str, String str2) {
        if (b(str)) {
            p.b(str, c(str2));
        }
    }

    public static void setCustomMethodStart(String str, String str2) {
        if (b(str)) {
            MethodInfo.onCustomMethodStart(str, c(str2));
        }
    }

    public static void setCustomMethodStart(String str) {
        setCustomMethodStart(str, (String) null);
    }

    public static void setCustomMethodEnd(String str, String str2) {
        if (b(str)) {
            MethodInfo.onCustomMethodEnd(str, c(str2));
        }
    }

    public static void setCustomMethodEnd(String str) {
        setCustomMethodEnd(str, (String) null);
    }

    public static void setCustomException(Throwable th) {
        if (th != null) {
            try {
                setCustomException(ad.b(th), ad.c(th), ad.a(th));
            } catch (Throwable unused) {
            }
        }
    }

    public static void setCustomException(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && str.length() <= 256) {
            if (!TextUtils.isEmpty(str2) && str2.length() > 512) {
                str2 = str2.substring(0, 512);
            }
            if (!TextUtils.isEmpty(str3) && str3.length() > 10000) {
                str3 = str3.substring(0, 10000);
            }
            com.bonree.sdk.d.e.d().f().a(str, str2, str3);
        }
    }

    public static void setCustomNetwork(NetworkCustomEventBean networkCustomEventBean) {
        e j;
        if (networkCustomEventBean != null && !TextUtils.isEmpty(networkCustomEventBean.getmRequestUrl()) && networkCustomEventBean.getmRequestUrl().length() <= 2083 && (j = com.bonree.sdk.d.e.d().j()) != null) {
            j.a(networkCustomEventBean);
        }
    }

    public static Context getApplicationContext() {
        return a.a.f;
    }

    public static ohos.app.Context getOhosApplicationContext() {
        return q.a();
    }

    public Bonree withUsemPaas(boolean z) {
        this.e.e(z);
        return this;
    }

    public Bonree withUseCustomLaunch(boolean z) {
        this.e.i(z);
        return this;
    }

    public Bonree withAppVersion(String str) {
        this.e.b(str);
        return this;
    }

    public Bonree withDeviceID(String str) {
        this.e.c(str);
        return this;
    }

    public Bonree withCustomBusinessHeaders(String... strArr) {
        this.e.b(strArr);
        return this;
    }

    public Bonree withConfigAddress(String str) {
        this.e.g(str);
        return this;
    }

    public Bonree withChannelID(String str) {
        this.e.a(str);
        return this;
    }

    public Bonree withAndroidBoxEnabled(boolean z) {
        this.e.h(z);
        return this;
    }

    public Bonree withSyncStart(boolean z) {
        this.e.g(z);
        return this;
    }

    public Bonree withToastEnabled(boolean z) {
        this.e.c(z);
        return this;
    }

    public Bonree withDeviceStateRefreshCycle(int i) {
        this.e.a(i);
        return this;
    }

    public Bonree traceProcessList(String... strArr) {
        this.e.a(strArr);
        return this;
    }

    public Bonree withDropFrameTime(int i) {
        this.e.b(i);
        return this;
    }

    public Bonree withAllLaunch(boolean z) {
        this.e.b(z);
        return this;
    }

    public void startOhos(ohos.app.Context context) {
        q.a(context);
        int majorVersion = SystemVersion.getMajorVersion();
        if (majorVersion > 2) {
            com.bonree.sdk.d.a.a.e("not support harmony version %d", Integer.valueOf(majorVersion));
            this.g.c("not support harmony version %d", Integer.valueOf(majorVersion));
            return;
        }
        start(com.bonree.sdk.bs.a.a());
    }

    public void start() {
        start(com.bonree.sdk.bs.a.a());
    }

    /* JADX WARNING: type inference failed for: r16v7, types: [boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0272 A[SYNTHETIC, Splitter:B:100:0x0272] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x030e A[SYNTHETIC, Splitter:B:123:0x030e] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0314 A[SYNTHETIC, Splitter:B:126:0x0314] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0391 A[SYNTHETIC, Splitter:B:147:0x0391] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0397 A[SYNTHETIC, Splitter:B:150:0x0397] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x022d A[Catch:{ all -> 0x043a, all -> 0x0458, all -> 0x0457 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0240 A[SYNTHETIC, Splitter:B:87:0x0240] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0246 A[SYNTHETIC, Splitter:B:90:0x0246] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:79:0x01f8=Splitter:B:79:0x01f8, B:170:0x041a=Splitter:B:170:0x041a} */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start(android.content.Context r20) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            java.lang.String r2 = "invalid %s process! Bonree sdk exit!"
            java.lang.String r3 = "configuration_version"
            java.lang.String r4 = "Not detect Bonree rewriter version! Bonree agent exit!"
            java.lang.String r5 = "Not detect Bonree code! Bonree agent exit!"
            java.lang.String r6 = "not support android version %d"
            java.lang.String r7 = "Bonree is already running !"
            java.lang.String r8 = "configuration"
            java.lang.String r9 = ":"
            long r10 = android.os.SystemClock.uptimeMillis()
            com.bonree.sdk.d.a r12 = com.bonree.sdk.d.a.k()
            boolean r12 = r12.w()
            r13 = 0
            if (r12 == 0) goto L_0x0044
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Config or Token is invalid ! SDK Stop! "
            r2.<init>(r3)
            int r3 = android.os.Process.myPid()
            r2.append(r3)
            java.lang.String r3 = com.bonree.sdk.bs.ad.a()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r13]
            r0.e(r2, r3)
            return
        L_0x0044:
            java.util.concurrent.locks.Lock r12 = com.bonree.sdk.d.a.d
            boolean r12 = r12.tryLock()
            if (r12 == 0) goto L_0x045f
            int r12 = com.bonree.sdk.d.a.f
            int r14 = com.bonree.sdk.d.a.c.c
            if (r12 == r14) goto L_0x005c
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a
            java.lang.Object[] r2 = new java.lang.Object[r13]
            java.lang.String r3 = "Do not repeat startup.!"
            r0.d(r3, r2)
            return
        L_0x005c:
            int r12 = com.bonree.sdk.d.a.c.a
            com.bonree.sdk.d.a.f = r12
            java.lang.Class<com.bonree.sdk.agent.Bonree> r12 = com.bonree.sdk.agent.Bonree.class
            java.lang.ClassLoader r12 = r12.getClassLoader()     // Catch:{ all -> 0x043a }
            if (r12 == 0) goto L_0x0083
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x043a }
            java.lang.String r14 = "com.qihoo360.replugin.PluginDexClassLoader"
            boolean r12 = r12.contains(r14)     // Catch:{ all -> 0x043a }
            if (r12 == 0) goto L_0x0083
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.String r2 = "plugin no need init sdk!"
            java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ all -> 0x043a }
            r0.d(r2, r3)     // Catch:{ all -> 0x043a }
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x0082 }
            r0.unlock()     // Catch:{ all -> 0x0082 }
        L_0x0082:
            return
        L_0x0083:
            if (r0 == 0) goto L_0x041a
            java.lang.String r14 = "android.app.ContextImpl"
            java.lang.Class r15 = r20.getClass()     // Catch:{ all -> 0x043a }
            java.lang.String r15 = r15.getName()     // Catch:{ all -> 0x043a }
            boolean r14 = r14.equals(r15)     // Catch:{ all -> 0x043a }
            if (r14 == 0) goto L_0x0097
            goto L_0x041a
        L_0x0097:
            boolean r14 = r0 instanceof android.app.Application     // Catch:{ all -> 0x043a }
            if (r14 != 0) goto L_0x009f
            android.content.Context r0 = r20.getApplicationContext()     // Catch:{ all -> 0x043a }
        L_0x009f:
            r1.f = r0     // Catch:{ all -> 0x043a }
            com.bonree.sdk.bs.a.a((android.content.Context) r0)     // Catch:{ all -> 0x043a }
            boolean r0 = com.bonree.sdk.d.a.L()     // Catch:{ all -> 0x01f3 }
            java.lang.String r14 = "Illegal environment state : "
            r15 = 0
            if (r0 == 0) goto L_0x00de
            ohos.app.Context r0 = com.bonree.sdk.bs.q.a()     // Catch:{ all -> 0x01f3 }
            java.lang.String r16 = r0.getBundleName()     // Catch:{ all -> 0x01f3 }
            java.io.File r0 = r0.getExternalFilesDir(r15)     // Catch:{ all -> 0x01f3 }
            java.lang.String r15 = com.bonree.sdk.bs.a.c()     // Catch:{ all -> 0x01f3 }
            ohos.data.usage.MountState r12 = ohos.data.usage.DataUsage.getDiskMountedStatus()     // Catch:{ all -> 0x01f3 }
            ohos.data.usage.MountState r13 = ohos.data.usage.MountState.DISK_UNMOUNTED     // Catch:{ all -> 0x01f3 }
            if (r12 == r13) goto L_0x00c9
            ohos.data.usage.MountState r13 = ohos.data.usage.MountState.DISK_REMOVED     // Catch:{ all -> 0x01f3 }
            if (r12 != r13) goto L_0x0106
        L_0x00c9:
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x01f3 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f3 }
            r9.<init>(r14)     // Catch:{ all -> 0x01f3 }
            r9.append(r12)     // Catch:{ all -> 0x01f3 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01f3 }
            r12 = 0
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ all -> 0x01f3 }
            r0.c(r9, r13)     // Catch:{ all -> 0x01f3 }
            goto L_0x010e
        L_0x00de:
            android.content.Context r0 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x01f3 }
            java.lang.String r16 = r0.getPackageName()     // Catch:{ all -> 0x01f3 }
            java.io.File r0 = r0.getExternalFilesDir(r15)     // Catch:{ all -> 0x01f3 }
            java.lang.String r15 = com.bonree.sdk.bs.a.c()     // Catch:{ all -> 0x01f3 }
            java.lang.String r12 = android.os.Environment.getExternalStorageState()     // Catch:{ all -> 0x01f3 }
            boolean r13 = android.os.Environment.isExternalStorageRemovable()     // Catch:{ all -> 0x01f3 }
            r20 = r0
            java.lang.String r0 = "mounted"
            boolean r0 = r0.equals(r12)     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x01d0
            if (r13 == 0) goto L_0x0104
            goto L_0x01d0
        L_0x0104:
            r0 = r20
        L_0x0106:
            r12 = r16
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x01f3 }
            if (r13 == 0) goto L_0x0114
        L_0x010e:
            r16 = r3
            r17 = r10
            goto L_0x0212
        L_0x0114:
            if (r0 != 0) goto L_0x0117
            goto L_0x010e
        L_0x0117:
            boolean r13 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x01f3 }
            if (r13 != 0) goto L_0x0123
            boolean r13 = r12.equals(r15)     // Catch:{ all -> 0x01f3 }
            if (r13 == 0) goto L_0x0125
        L_0x0123:
            java.lang.String r15 = ""
        L_0x0125:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f3 }
            r13.<init>()     // Catch:{ all -> 0x01f3 }
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x01f3 }
            r13.append(r0)     // Catch:{ all -> 0x01f3 }
            java.lang.String r0 = com.bonree.sdk.d.a.b     // Catch:{ all -> 0x01f3 }
            r13.append(r0)     // Catch:{ all -> 0x01f3 }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x01f3 }
            java.lang.String r13 = d(r0)     // Catch:{ all -> 0x01f3 }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x01f3 }
            if (r14 == 0) goto L_0x0145
            goto L_0x010e
        L_0x0145:
            java.lang.String r14 = "_"
            if (r15 == 0) goto L_0x017e
            boolean r16 = r15.contains(r9)     // Catch:{ all -> 0x01f3 }
            if (r16 == 0) goto L_0x017e
            r17 = r10
            int r10 = r15.indexOf(r9)     // Catch:{ all -> 0x0179 }
            r16 = r3
            r11 = 0
            java.lang.String r3 = r15.substring(r11, r10)     // Catch:{ all -> 0x01f1 }
            boolean r3 = r12.equals(r3)     // Catch:{ all -> 0x01f1 }
            if (r3 == 0) goto L_0x0168
            r3 = 1
            int r10 = r10 + r3
            java.lang.String r15 = r15.substring(r10)     // Catch:{ all -> 0x01f1 }
        L_0x0168:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f1 }
            r3.<init>(r14)     // Catch:{ all -> 0x01f1 }
            java.lang.String r9 = r15.replaceAll(r9, r14)     // Catch:{ all -> 0x01f1 }
            r3.append(r9)     // Catch:{ all -> 0x01f1 }
            java.lang.String r15 = r3.toString()     // Catch:{ all -> 0x01f1 }
            goto L_0x0182
        L_0x0179:
            r0 = move-exception
            r16 = r3
            goto L_0x01f8
        L_0x017e:
            r16 = r3
            r17 = r10
        L_0x0182:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f1 }
            r3.<init>()     // Catch:{ all -> 0x01f1 }
            r3.append(r0)     // Catch:{ all -> 0x01f1 }
            java.lang.String r0 = java.io.File.separator     // Catch:{ all -> 0x01f1 }
            r3.append(r0)     // Catch:{ all -> 0x01f1 }
            r3.append(r12)     // Catch:{ all -> 0x01f1 }
            r3.append(r15)     // Catch:{ all -> 0x01f1 }
            r3.append(r14)     // Catch:{ all -> 0x01f1 }
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x01f1 }
            java.lang.String r9 = "MM-dd_HH-mm-ss"
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch:{ all -> 0x01f1 }
            r0.<init>(r9, r10)     // Catch:{ all -> 0x01f1 }
            java.util.Date r9 = new java.util.Date     // Catch:{ all -> 0x01f1 }
            r9.<init>()     // Catch:{ all -> 0x01f1 }
            java.lang.String r0 = r0.format(r9)     // Catch:{ all -> 0x01f1 }
            r3.append(r0)     // Catch:{ all -> 0x01f1 }
            java.lang.String r0 = ".log"
            r3.append(r0)     // Catch:{ all -> 0x01f1 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01f1 }
            com.bonree.sdk.be.d r3 = new com.bonree.sdk.be.d     // Catch:{ all -> 0x01f1 }
            r3.<init>(r0)     // Catch:{ all -> 0x01f1 }
            com.bonree.sdk.be.a.a((com.bonree.sdk.be.f) r3)     // Catch:{ all -> 0x01f1 }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x01f1 }
            java.lang.String r3 = "local properties: %s"
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x01f1 }
            r9 = 0
            r10[r9] = r13     // Catch:{ all -> 0x01f1 }
            r0.c(r3, r10)     // Catch:{ all -> 0x01f1 }
            goto L_0x0212
        L_0x01d0:
            r16 = r3
            r17 = r10
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x01f1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f1 }
            r3.<init>(r14)     // Catch:{ all -> 0x01f1 }
            r3.append(r12)     // Catch:{ all -> 0x01f1 }
            java.lang.String r9 = " removable: "
            r3.append(r9)     // Catch:{ all -> 0x01f1 }
            r3.append(r13)     // Catch:{ all -> 0x01f1 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01f1 }
            r9 = 0
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x01f1 }
            r0.c(r3, r10)     // Catch:{ all -> 0x01f1 }
            goto L_0x0212
        L_0x01f1:
            r0 = move-exception
            goto L_0x01f8
        L_0x01f3:
            r0 = move-exception
            r16 = r3
            r17 = r10
        L_0x01f8:
            com.bonree.sdk.be.f r3 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x043a }
            java.lang.String r10 = "initLogger error:"
            r9.<init>(r10)     // Catch:{ all -> 0x043a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x043a }
            r9.append(r0)     // Catch:{ all -> 0x043a }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x043a }
            r9 = 0
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x043a }
            r3.c(r0, r10)     // Catch:{ all -> 0x043a }
        L_0x0212:
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.String r3 = "Brsdk is starting... (%s)"
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x043a }
            int r9 = android.os.Process.myPid()     // Catch:{ all -> 0x043a }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x043a }
            r11 = 0
            r10[r11] = r9     // Catch:{ all -> 0x043a }
            r0.c(r3, r10)     // Catch:{ all -> 0x043a }
            boolean r0 = com.bonree.sdk.d.a.s()     // Catch:{ all -> 0x043a }
            if (r0 == 0) goto L_0x023d
            com.bonree.sdk.be.f r0 = r1.g     // Catch:{ all -> 0x043a }
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ all -> 0x043a }
            r0.c(r7, r3)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ all -> 0x043a }
            r0.e(r7, r3)     // Catch:{ all -> 0x043a }
            r0 = 1
            goto L_0x023e
        L_0x023d:
            r0 = 0
        L_0x023e:
            if (r0 == 0) goto L_0x0246
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x0245 }
            r0.unlock()     // Catch:{ all -> 0x0245 }
        L_0x0245:
            return
        L_0x0246:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x043a }
            r3 = 33
            if (r0 > r3) goto L_0x0253
            r3 = 19
            if (r0 >= r3) goto L_0x0251
            goto L_0x0253
        L_0x0251:
            r0 = 1
            goto L_0x0270
        L_0x0253:
            com.bonree.sdk.be.f r3 = r1.g     // Catch:{ all -> 0x043a }
            r7 = 1
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ all -> 0x043a }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x043a }
            r11 = 0
            r9[r11] = r10     // Catch:{ all -> 0x043a }
            r3.c(r6, r9)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.be.f r3 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ all -> 0x043a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x043a }
            r9[r11] = r0     // Catch:{ all -> 0x043a }
            r3.e(r6, r9)     // Catch:{ all -> 0x043a }
            r0 = 0
        L_0x0270:
            if (r0 != 0) goto L_0x0278
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x0277 }
            r0.unlock()     // Catch:{ all -> 0x0277 }
        L_0x0277:
            return
        L_0x0278:
            java.lang.Class<com.bonree.sdk.agent.Agent> r0 = com.bonree.sdk.agent.Agent.class
            java.lang.Class<com.bonree.sdk.agent.engine.external.ClassRewriter> r3 = com.bonree.sdk.agent.engine.external.ClassRewriter.class
            boolean r0 = r0.isAnnotationPresent(r3)     // Catch:{ all -> 0x043a }
            java.lang.String r3 = "SDK启动失败\nAPP嵌码失败，退出"
            if (r0 == 0) goto L_0x02f9
            java.lang.Class<com.bonree.sdk.agent.Agent> r0 = com.bonree.sdk.agent.Agent.class
            java.lang.Class<com.bonree.sdk.agent.engine.external.ClassRewriter> r5 = com.bonree.sdk.agent.engine.external.ClassRewriter.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r5)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.agent.engine.external.ClassRewriter r0 = (com.bonree.sdk.agent.engine.external.ClassRewriter) r0     // Catch:{ all -> 0x043a }
            java.lang.String r5 = "Null"
            if (r0 == 0) goto L_0x0297
            java.lang.String r6 = r0.version()     // Catch:{ all -> 0x043a }
            goto L_0x0298
        L_0x0297:
            r6 = r5
        L_0x0298:
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x043a }
            if (r5 == 0) goto L_0x02b1
            com.bonree.sdk.be.f r0 = r1.g     // Catch:{ all -> 0x043a }
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x043a }
            r0.e(r4, r6)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.bs.ad.f(r3)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x043a }
            r0.e(r4, r3)     // Catch:{ all -> 0x043a }
            goto L_0x030b
        L_0x02b1:
            com.bonree.sdk.be.f r3 = r1.g     // Catch:{ all -> 0x043a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x043a }
            java.lang.String r5 = "Rewriter activity "
            r4.<init>(r5)     // Catch:{ all -> 0x043a }
            boolean r5 = r0.activity()     // Catch:{ all -> 0x043a }
            r4.append(r5)     // Catch:{ all -> 0x043a }
            java.lang.String r5 = " click "
            r4.append(r5)     // Catch:{ all -> 0x043a }
            boolean r5 = r0.click()     // Catch:{ all -> 0x043a }
            r4.append(r5)     // Catch:{ all -> 0x043a }
            java.lang.String r5 = " webview "
            r4.append(r5)     // Catch:{ all -> 0x043a }
            boolean r5 = r0.webview()     // Catch:{ all -> 0x043a }
            r4.append(r5)     // Catch:{ all -> 0x043a }
            java.lang.String r5 = "  hap: "
            r4.append(r5)     // Catch:{ all -> 0x043a }
            boolean r5 = r0.isHap()     // Catch:{ all -> 0x043a }
            r4.append(r5)     // Catch:{ all -> 0x043a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x043a }
            r5 = 0
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x043a }
            r3.c(r4, r7)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.agent.Agent.CLASSREWRITER_VERSION = r6     // Catch:{ all -> 0x043a }
            boolean r0 = r0.isHap()     // Catch:{ all -> 0x043a }
            com.bonree.sdk.agent.Agent.IS_HAP = r0     // Catch:{ all -> 0x043a }
            r0 = 1
            goto L_0x030c
        L_0x02f9:
            com.bonree.sdk.be.f r0 = r1.g     // Catch:{ all -> 0x043a }
            r4 = 0
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x043a }
            r0.e(r5, r6)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x043a }
            r0.e(r5, r6)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.bs.ad.f(r3)     // Catch:{ all -> 0x043a }
        L_0x030b:
            r0 = 0
        L_0x030c:
            if (r0 != 0) goto L_0x0314
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x0313 }
            r0.unlock()     // Catch:{ all -> 0x0313 }
        L_0x0313:
            return
        L_0x0314:
            java.lang.String r0 = com.bonree.sdk.bs.a.c()     // Catch:{ all -> 0x043a }
            com.bonree.sdk.d.a r3 = r1.e     // Catch:{ all -> 0x043a }
            java.util.List r3 = r3.x()     // Catch:{ all -> 0x043a }
            android.content.Context r4 = r1.f     // Catch:{ all -> 0x043a }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x043a }
            com.bonree.sdk.d.a r5 = r1.e     // Catch:{ all -> 0x043a }
            boolean r5 = r5.A()     // Catch:{ all -> 0x043a }
            boolean r6 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ all -> 0x043a }
            if (r6 != 0) goto L_0x033d
            com.bonree.sdk.be.f r6 = r1.g     // Catch:{ all -> 0x043a }
            java.lang.String r7 = "*************currentProcess is %s ********************"
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x043a }
            r9 = 0
            r10[r9] = r0     // Catch:{ all -> 0x043a }
            r6.d(r7, r10)     // Catch:{ all -> 0x043a }
        L_0x033d:
            if (r5 != 0) goto L_0x038e
            if (r3 == 0) goto L_0x0368
            int r5 = r3.size()     // Catch:{ all -> 0x043a }
            if (r5 <= 0) goto L_0x0368
            boolean r5 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ all -> 0x043a }
            if (r5 != 0) goto L_0x0368
            boolean r3 = r3.contains(r0)     // Catch:{ all -> 0x043a }
            if (r3 != 0) goto L_0x038e
            com.bonree.sdk.be.f r3 = r1.g     // Catch:{ all -> 0x043a }
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x043a }
            r6 = 0
            r5[r6] = r0     // Catch:{ all -> 0x043a }
            r3.e(r2, r5)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.be.f r3 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x043a }
            r5[r6] = r0     // Catch:{ all -> 0x043a }
            r3.e(r2, r5)     // Catch:{ all -> 0x043a }
            goto L_0x038c
        L_0x0368:
            boolean r2 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ all -> 0x043a }
            if (r2 != 0) goto L_0x038e
            boolean r2 = r4.equals(r0)     // Catch:{ all -> 0x043a }
            if (r2 != 0) goto L_0x038e
            com.bonree.sdk.be.f r2 = r1.g     // Catch:{ all -> 0x043a }
            java.lang.String r3 = "Only start main process! Bonree sdk exit current process %s!"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x043a }
            r6 = 0
            r5[r6] = r0     // Catch:{ all -> 0x043a }
            r2.d(r3, r5)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.be.f r2 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.String r3 = "Only start main process! Bonree sdk exit current process %s !"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x043a }
            r5[r6] = r0     // Catch:{ all -> 0x043a }
            r2.d(r3, r5)     // Catch:{ all -> 0x043a }
        L_0x038c:
            r0 = 0
            goto L_0x038f
        L_0x038e:
            r0 = 1
        L_0x038f:
            if (r0 != 0) goto L_0x0397
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x0396 }
            r0.unlock()     // Catch:{ all -> 0x0396 }
        L_0x0396:
            return
        L_0x0397:
            boolean r0 = r19.f()     // Catch:{ all -> 0x043a }
            if (r0 != 0) goto L_0x03a3
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x03a2 }
            r0.unlock()     // Catch:{ all -> 0x03a2 }
        L_0x03a2:
            return
        L_0x03a3:
            java.lang.String r0 = com.bonree.sdk.agent.Agent.getAgentVersion()     // Catch:{ all -> 0x043a }
            android.content.Context r2 = r1.f     // Catch:{ all -> 0x043a }
            r3 = r16
            java.lang.String r2 = com.bonree.sdk.bs.aa.d(r2, r8, r3)     // Catch:{ all -> 0x043a }
            boolean r4 = r0.equals(r2)     // Catch:{ all -> 0x043a }
            if (r4 != 0) goto L_0x03cc
            com.bonree.sdk.be.f r4 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.String r5 = "Install this version for the first time, the previous version is %s ,clear config..."
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x043a }
            r6 = 0
            r7[r6] = r2     // Catch:{ all -> 0x043a }
            r4.d(r5, r7)     // Catch:{ all -> 0x043a }
            android.content.Context r2 = r1.f     // Catch:{ all -> 0x043a }
            com.bonree.sdk.bs.aa.a(r2, r8)     // Catch:{ all -> 0x043a }
            android.content.Context r2 = r1.f     // Catch:{ all -> 0x043a }
            com.bonree.sdk.bs.aa.a((android.content.Context) r2, (java.lang.String) r8, (java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x043a }
        L_0x03cc:
            android.content.Context r0 = r1.f     // Catch:{ all -> 0x043a }
            com.bonree.sdk.d.a r2 = r1.e     // Catch:{ all -> 0x043a }
            boolean r0 = com.bonree.sdk.d.e.a((android.content.Context) r0, (com.bonree.sdk.d.a) r2)     // Catch:{ all -> 0x043a }
            com.bonree.sdk.be.f r2 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.String r3 = "BRAgent enable %d appStartedTimeMs is %d ，Startup mode: %s ,Start result: %b"
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x043a }
            long r5 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x043a }
            long r5 = r5 - r17
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x043a }
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x043a }
            long r5 = com.bonree.sdk.d.a.l()     // Catch:{ all -> 0x043a }
            long r5 = -r5
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x043a }
            r6 = 1
            r4[r6] = r5     // Catch:{ all -> 0x043a }
            r5 = 2
            com.bonree.sdk.d.a r6 = r1.e     // Catch:{ all -> 0x043a }
            boolean r6 = r6.P()     // Catch:{ all -> 0x043a }
            if (r6 == 0) goto L_0x0400
            java.lang.String r6 = "sync"
            goto L_0x0402
        L_0x0400:
            java.lang.String r6 = "async"
        L_0x0402:
            r4[r5] = r6     // Catch:{ all -> 0x043a }
            r5 = 3
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x043a }
            r4[r5] = r6     // Catch:{ all -> 0x043a }
            r2.c(r3, r4)     // Catch:{ all -> 0x043a }
            if (r0 != 0) goto L_0x0414
            int r0 = com.bonree.sdk.d.a.c.c     // Catch:{ all -> 0x043a }
            com.bonree.sdk.d.a.f = r0     // Catch:{ all -> 0x043a }
        L_0x0414:
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x0419 }
            r0.unlock()     // Catch:{ all -> 0x0419 }
        L_0x0419:
            return
        L_0x041a:
            com.bonree.sdk.be.f r2 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x043a }
            java.lang.String r3 = "Please pass in the correct Context,application or activity, this is %s "
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x043a }
            if (r0 != 0) goto L_0x0426
            java.lang.String r0 = " Null"
            goto L_0x042e
        L_0x0426:
            java.lang.Class r0 = r20.getClass()     // Catch:{ all -> 0x043a }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x043a }
        L_0x042e:
            r5 = 0
            r4[r5] = r0     // Catch:{ all -> 0x043a }
            r2.e(r3, r4)     // Catch:{ all -> 0x043a }
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x0439 }
            r0.unlock()     // Catch:{ all -> 0x0439 }
        L_0x0439:
            return
        L_0x043a:
            r0 = move-exception
            int r2 = com.bonree.sdk.d.a.c.c     // Catch:{ all -> 0x0458 }
            com.bonree.sdk.d.a.f = r2     // Catch:{ all -> 0x0458 }
            com.bonree.sdk.be.f r2 = r1.g     // Catch:{ all -> 0x0458 }
            java.lang.String r3 = "Error occurred while starting the BRAgent !  "
            r2.a((java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0458 }
            com.bonree.sdk.be.f r2 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0458 }
            java.lang.String r3 = "BRAgent disable ! "
            r2.a((java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0458 }
            java.lang.String r0 = "SDK启动失败,详情查看控制台日志:BRAgent disable"
            com.bonree.sdk.bs.ad.f(r0)     // Catch:{ all -> 0x0458 }
            java.util.concurrent.locks.Lock r0 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x0457 }
            r0.unlock()     // Catch:{ all -> 0x0457 }
        L_0x0457:
            return
        L_0x0458:
            r0 = move-exception
            java.util.concurrent.locks.Lock r2 = com.bonree.sdk.d.a.d     // Catch:{ all -> 0x045e }
            r2.unlock()     // Catch:{ all -> 0x045e }
        L_0x045e:
            throw r0
        L_0x045f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.Bonree.start(android.content.Context):void");
    }

    public static void recordCustomActionEnd() {
        c.e().d();
    }

    private void a() {
        String str;
        String str2;
        File file;
        try {
            if (com.bonree.sdk.d.a.L()) {
                ohos.app.Context a2 = q.a();
                str = a2.getBundleName();
                file = a2.getExternalFilesDir((String) null);
                str2 = com.bonree.sdk.bs.a.c();
                MountState diskMountedStatus = DataUsage.getDiskMountedStatus();
                if (diskMountedStatus == MountState.DISK_UNMOUNTED || diskMountedStatus == MountState.DISK_REMOVED) {
                    com.bonree.sdk.d.a.a.c("Illegal environment state : " + diskMountedStatus, new Object[0]);
                    return;
                }
            } else {
                Context a3 = com.bonree.sdk.bs.a.a();
                str = a3.getPackageName();
                file = a3.getExternalFilesDir((String) null);
                str2 = com.bonree.sdk.bs.a.c();
                String externalStorageState = Environment.getExternalStorageState();
                boolean isExternalStorageRemovable = Environment.isExternalStorageRemovable();
                if ("mounted".equals(externalStorageState)) {
                    if (isExternalStorageRemovable) {
                    }
                }
                com.bonree.sdk.d.a.a.c("Illegal environment state : " + externalStorageState + " removable: " + isExternalStorageRemovable, new Object[0]);
                return;
            }
            if (!TextUtils.isEmpty(str) && file != null) {
                if (TextUtils.isEmpty(str2) || str.equals(str2)) {
                    str2 = "";
                }
                String str3 = file.getPath() + com.bonree.sdk.d.a.b;
                String d2 = d(str3);
                if (!TextUtils.isEmpty(d2)) {
                    if (str2 != null) {
                        if (str2.contains(":")) {
                            int indexOf = str2.indexOf(":");
                            if (str.equals(str2.substring(0, indexOf))) {
                                str2 = str2.substring(indexOf + 1);
                            }
                            str2 = "_" + str2.replaceAll(":", "_");
                        }
                    }
                    com.bonree.sdk.be.a.a((f) new d(str3 + File.separator + str + str2 + "_" + new SimpleDateFormat("MM-dd_HH-mm-ss", Locale.getDefault()).format(new Date()) + ".log"));
                    com.bonree.sdk.be.a.a().c("local properties: %s", d2);
                }
            }
        } catch (Throwable th) {
            com.bonree.sdk.d.a.a.c("initLogger error:" + th.toString(), new Object[0]);
        }
    }

    private boolean b() {
        if (!com.bonree.sdk.d.a.s()) {
            return false;
        }
        this.g.c("Bonree is already running !", new Object[0]);
        com.bonree.sdk.d.a.a.e("Bonree is already running !", new Object[0]);
        return true;
    }

    private boolean c() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 33 && i >= 19) {
            return true;
        }
        this.g.c("not support android version %d", Integer.valueOf(i));
        com.bonree.sdk.d.a.a.e("not support android version %d", Integer.valueOf(i));
        return false;
    }

    private boolean d() {
        String str;
        if (Agent.class.isAnnotationPresent(ClassRewriter.class)) {
            ClassRewriter classRewriter = (ClassRewriter) Agent.class.getAnnotation(ClassRewriter.class);
            if (classRewriter != null) {
                str = classRewriter.version();
            } else {
                str = "Null";
            }
            if ("Null".equals(str)) {
                this.g.e("Not detect Bonree rewriter version! Bonree agent exit!", new Object[0]);
                ad.f("SDK启动失败\nAPP嵌码失败，退出");
                com.bonree.sdk.d.a.a.e("Not detect Bonree rewriter version! Bonree agent exit!", new Object[0]);
                return false;
            }
            f fVar = this.g;
            fVar.c("Rewriter activity " + classRewriter.activity() + " click " + classRewriter.click() + " webview " + classRewriter.webview() + "  hap: " + classRewriter.isHap(), new Object[0]);
            Agent.CLASSREWRITER_VERSION = str;
            Agent.IS_HAP = classRewriter.isHap();
            return true;
        }
        this.g.e("Not detect Bonree code! Bonree agent exit!", new Object[0]);
        com.bonree.sdk.d.a.a.e("Not detect Bonree code! Bonree agent exit!", new Object[0]);
        ad.f("SDK启动失败\nAPP嵌码失败，退出");
        return false;
    }

    private boolean e() {
        String c2 = com.bonree.sdk.bs.a.c();
        List<String> x = this.e.x();
        String packageName = this.f.getPackageName();
        boolean A = this.e.A();
        if (!ad.a(c2)) {
            this.g.d("*************currentProcess is %s ********************", c2);
        }
        if (A) {
            return true;
        }
        if (x == null || x.size() <= 0 || ad.a(c2)) {
            if (ad.a(c2) || packageName.equals(c2)) {
                return true;
            }
            this.g.d("Only start main process! Bonree sdk exit current process %s!", c2);
            com.bonree.sdk.d.a.a.d("Only start main process! Bonree sdk exit current process %s !", c2);
            return false;
        } else if (x.contains(c2)) {
            return true;
        } else {
            this.g.e("invalid %s process! Bonree sdk exit!", c2);
            com.bonree.sdk.d.a.a.e("invalid %s process! Bonree sdk exit!", c2);
            return false;
        }
    }

    private boolean f() {
        try {
            int a2 = aa.a(this.f, "configuration", "rateOfLaunch");
            long b2 = aa.b(this.f, "configuration", "startTime");
            int a3 = aa.a(this.f, "configuration", "rateOfLaunchValidTime");
            if (a2 > 0 && a2 <= 100) {
                if (System.currentTimeMillis() - b2 <= ((long) (a3 * b))) {
                    if (new Random().nextInt(100) + 1 <= a2) {
                        return true;
                    }
                    ad.f("SDK启动失败\n" + a2 + "概率不开启sdk");
                    f fVar = com.bonree.sdk.d.a.a;
                    fVar.e("SDK启动失败\n" + a2 + "概率不开启sdk", new Object[0]);
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            aa.a(this.f, "configuration");
            return true;
        }
    }

    private void g() {
        String agentVersion = Agent.getAgentVersion();
        String d2 = aa.d(this.f, "configuration", "configuration_version");
        if (!agentVersion.equals(d2)) {
            com.bonree.sdk.d.a.a.d("Install this version for the first time, the previous version is %s ,clear config...", d2);
            aa.a(this.f, "configuration");
            aa.a(this.f, "configuration", "configuration_version", agentVersion);
        }
    }

    private static String d(String str) {
        if (str == null || !new File(str).exists()) {
            return null;
        }
        File file = new File(str + File.separator + "SDKConfig.properties");
        if (file.exists()) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                com.bonree.sdk.d.a.k().d(((Boolean) ad.a(properties, "LOGCAT", Boolean.valueOf(com.bonree.sdk.d.a.k().C()))).booleanValue());
                com.bonree.sdk.be.a.a(((Integer) ad.a(properties, "LEVEL", 3)).intValue());
                String str2 = (String) ad.a(properties, "5pyJ57yY5Lq65YqgUTg1NDQ2MzExMg", "");
                if (!TextUtils.isEmpty(str2)) {
                    com.bonree.sdk.d.a.k().e(str2);
                }
                String str3 = (String) ad.a(properties, "6L+Z5Y+q5piv5Liq6YWN572u5LiN6KaB5LuL5oSP", "");
                if (!TextUtils.isEmpty(str3)) {
                    com.bonree.sdk.d.a.k().d(str3);
                }
                return properties.toString();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final Bonree a = new Bonree((byte) 0);

        private a() {
        }
    }
}
