package com.igexin.push.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import com.google.protobuf.CodedOutputStream;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.b.a.c.b;
import com.igexin.b.b.a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.o;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.util.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class d {
    public static String A = null;
    public static String B = null;
    public static String C = null;
    public static String D = null;
    public static String E = null;
    public static long F = -1;
    public static long G = 0;
    public static long H = -1;
    public static long I = 0;
    public static long J = 0;
    public static long K = 0;
    public static long L = 0;
    public static long M = 0;
    public static String N = null;
    public static boolean O = o.a.equals("debug");
    public static long P = 0;
    public static long Q = 0;
    public static String R = null;
    public static long S = 0;
    public static int T = 0;
    public static String U = null;
    public static String V = null;
    public static String W = null;
    public static String X = null;
    public static long Y = 0;
    public static String Z = null;
    public static String a = "";
    public static byte[] aa = null;
    public static boolean ab = false;
    public static boolean ac = false;
    public static boolean ad = false;
    public static Map<String, PushTaskBean> ae = null;
    public static Map<String, Integer> af = null;
    public static HashMap<String, Long> ag = null;
    public static int ah = 0;
    public static int ai = 0;
    public static int aj = 0;
    public static String ak = null;
    public static long al = 0;
    public static String am = null;
    public static String an = null;
    public static String ao = null;
    public static String ap = null;
    public static String aq = null;
    public static String ar = null;
    public static long as = 0;
    public static boolean at = false;
    public static int au = 0;
    public static int av = 0;
    public static byte[] aw = null;
    public static String ax = null;
    private static Map<String, Integer> ay = null;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static Context g;
    public static AtomicBoolean h = new AtomicBoolean(false);
    public static boolean i = true;
    public static volatile boolean j = false;
    public static volatile boolean k;
    public static volatile boolean l = true;
    public static boolean m = true;
    public static volatile boolean n;
    public static volatile boolean o;
    public static boolean p = true;
    public static int q = 0;
    public static int r = 0;
    public static int s = 0;
    public static long t = 0;
    public static String u;
    public static String v;
    public static String w;
    public static String x;
    public static String y = Build.MODEL;
    public static String z;

    public static int a(String str, boolean z2) {
        int intValue;
        synchronized (d.class) {
            if (ay.get(str) == null) {
                ay.put(str, 0);
            }
            intValue = ay.get(str).intValue();
            if (z2) {
                intValue--;
                ay.put(str, Integer.valueOf(intValue));
                if (intValue == 0) {
                    ay.remove(str);
                }
            }
        }
        return intValue;
    }

    public static String a() {
        return SDKUrlConfig.getConfigServiceUrl();
    }

    public static void a(long j2) {
        t = j2;
        u = a.a(String.valueOf(j2));
    }

    public static boolean a(Context context) {
        g = context;
        e = context.getPackageName();
        f = c.c(context);
        if (!d()) {
            b.a("CoreRuntimeInfo|parseManifests failed", new Object[0]);
            return false;
        }
        aa = a.a(a + c + b + context.getPackageName()).getBytes();
        c();
        b();
        i = com.igexin.push.util.a.h();
        ae = new ConcurrentHashMap();
        af = new ConcurrentHashMap();
        ag = new HashMap<>();
        k = new com.igexin.sdk.a.d(context).c();
        ay = new HashMap();
        e();
        at = true;
        b.a("CoreRuntimeInfo|getui sdk init success, isPushOn = " + k, new Object[0]);
        return true;
    }

    public static boolean a(String str, Integer num, boolean z2) {
        synchronized (d.class) {
            int intValue = num.intValue();
            if (!z2 || ay.get(str) == null || (intValue = ay.get(str).intValue() + num.intValue()) != 0) {
                ay.put(str, Integer.valueOf(intValue));
                return true;
            }
            ay.remove(str);
            return false;
        }
    }

    private static void b() {
        File[] listFiles;
        try {
            File file = new File("/sdcard/libs/");
            if (file.exists() && file.isFile()) {
                b.a("CoreRuntimeInfo|libs is file not directory, delete libs file ++++", new Object[0]);
                file.delete();
            }
            if (!file.exists() && !file.mkdir()) {
                b.a("CoreRuntimeInfo|create libs directory failed ++++++", new Object[0]);
            }
            g.getFilesDir();
            File file2 = new File(CoreConsts.c + "/system/tmp/local");
            if (file2.exists() && (listFiles = file2.listFiles(new e())) != null && listFiles.length > 0) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        } catch (Throwable th) {
            b.a("CoreRuntimeInfo|initFile exception = " + th.toString(), new Object[0]);
            return;
        }
        X = g.getFilesDir().getPath();
        V = "/sdcard/libs//" + e + ".db";
        W = "/sdcard/libs//com.igexin.sdk.deviceId.db";
        U = "/sdcard/libs//" + e + ".properties";
        Z = "/sdcard/libs//" + e + ".bin";
    }

    private static void c() {
        try {
            PackageInfo packageInfo = g.getPackageManager().getPackageInfo(e, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (packageInfo != null && packageInfo.requestedPermissions != null) {
                for (String str : packageInfo.requestedPermissions) {
                }
            }
        } catch (Exception e2) {
            b.a("CoreRuntimeInfo|init exception : " + e2.toString(), new Object[0]);
        }
    }

    private static boolean d() {
        String a2 = com.igexin.push.core.b.a.a(g);
        String b2 = com.igexin.push.core.b.a.b(g);
        String c2 = com.igexin.push.core.b.a.c(g);
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(c2) || TextUtils.isEmpty(b2)) {
            try {
                ApplicationInfo applicationInfo = g.getPackageManager().getApplicationInfo(e, 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    String string = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID);
                    c2 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPSECRET);
                    String string2 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPKEY);
                    if (string != null) {
                        string = string.trim();
                    }
                    if (c2 != null) {
                        c2 = c2.trim();
                    }
                    if (string2 != null) {
                        string2 = string2.trim();
                    }
                    String str = string;
                    b2 = string2;
                    a2 = str;
                }
                return false;
            } catch (Throwable th) {
                b.a("CoreRuntimeInfo|get ApplicationInfo meta data exception :" + th.toString(), new Object[0]);
                return false;
            }
        }
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(c2) || TextUtils.isEmpty(b2)) {
            b.a("CoreRuntimeInfo|getui sdk init error, missing parm #####", new Object[0]);
            return false;
        }
        a = a2;
        b = b2;
        c = c2;
        d = SDKUrlConfig.getLocation();
        return true;
    }

    private static void e() {
        Cursor cursor = null;
        try {
            cursor = c.a().k().a("message", (String[]) null, (String[]) null, (String[]) null, (String) null);
            if (cursor != null) {
                av = cursor.getCount();
            }
            if (cursor == null) {
                return;
            }
        } catch (Throwable unused) {
            if (0 == 0) {
                return;
            }
        }
        cursor.close();
    }
}
