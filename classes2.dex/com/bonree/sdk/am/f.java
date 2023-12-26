package com.bonree.sdk.am;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.bonree.sdk.be.a;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.json.HTTP;
import java.lang.reflect.Method;

public abstract class f {
    private static final String m = "android.os.SystemProperties";
    private static final String n = "get";
    private static final String o = "ro.product.cpu.abi";
    private static final String p = "NullInstructionSet";
    private static final String q = "/proc/meminfo";
    private static final String r = "/proc/cpuinfo";
    private static final String s = "arm";
    private static final String t = "intel";
    private static final String u = "\\s+";
    private static String v = "user";
    private static volatile String w = "";
    private Method A;
    private com.bonree.sdk.be.f B = a.a();
    private TelephonyManager C;
    protected String a = "";
    protected String b = "";
    protected String c = "";
    protected String d = "";
    protected String e = "";
    protected String f = "";
    protected String g = "";
    protected String h = "";
    protected String i = "";
    protected String j;
    protected int k;
    protected Context l = com.bonree.sdk.bs.a.a();
    private int x = 1;
    private final int y = 3;
    private int z;

    public abstract float c();

    public f() {
        a();
    }

    public void a() {
        if (com.bonree.sdk.d.a.K()) {
            this.x = 3;
        }
        this.z = (int) Math.ceil((double) t());
    }

    public static synchronized String d() {
        String str;
        synchronized (f.class) {
            if (ad.a(w)) {
                Context a2 = com.bonree.sdk.bs.a.a();
                if (a2 == null) {
                    w = "";
                } else {
                    String string = Settings.Secure.getString(a2.getContentResolver(), "android_id");
                    if (string == null || "unknown".equals(string) || "null".equals(string)) {
                        string = "";
                    }
                    w = string;
                    StackTraceElement[] stackTrace = new Exception().getStackTrace();
                    StringBuilder sb = new StringBuilder();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString());
                        sb.append(HTTP.CRLF);
                    }
                    a.a().c("调用Android ID接口 %s", string);
                    a.a().c("调用堆栈 %s", sb);
                }
            }
            str = w;
        }
        return str;
    }

    public static void a(String str) {
        w = str;
    }

    public final int e() {
        return this.x;
    }

    private static void s() {
        Context a2 = com.bonree.sdk.bs.a.a();
        String str = "";
        if (a2 == null) {
            w = str;
            return;
        }
        String string = Settings.Secure.getString(a2.getContentResolver(), "android_id");
        if (string != null && !"unknown".equals(string) && !"null".equals(string)) {
            str = string;
        }
        w = str;
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString());
            sb.append(HTTP.CRLF);
        }
        a.a().c("调用Android ID接口 %s", str);
        a.a().c("调用堆栈 %s", sb);
    }

    public final String f() {
        try {
            Method method = Class.forName(m).getMethod(n, new Class[]{String.class, String.class});
            this.A = method;
            return (String) method.invoke((Object) null, new Object[]{o, p});
        } catch (Throwable unused) {
            return p;
        }
    }

    public String b() {
        return this.i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.FileReader} */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008f, code lost:
        if (com.igexin.assist.sdk.AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE.equals(r0) != false) goto L_0x0091;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e9 A[SYNTHETIC, Splitter:B:64:0x00e9] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ee A[Catch:{ IOException -> 0x00f1 }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f7 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            r1 = 0
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x00cc }
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch:{ all -> 0x00cc }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x00c8 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r3, r5)     // Catch:{ all -> 0x00c8 }
            java.lang.String r11 = r11.trim()     // Catch:{ all -> 0x00c6 }
            java.lang.String r11 = r11.toLowerCase()     // Catch:{ all -> 0x00c6 }
            java.lang.String r2 = "arm"
            boolean r11 = r11.contains(r2)     // Catch:{ all -> 0x00c6 }
            java.lang.String r2 = ":"
            r5 = 2
            r6 = 1
            if (r11 == 0) goto L_0x0055
            java.lang.String r11 = r4.readLine()     // Catch:{ all -> 0x00c6 }
            if (r11 == 0) goto L_0x004f
            java.lang.String r7 = "\\s+"
            java.lang.String[] r11 = r11.split(r7)     // Catch:{ all -> 0x00c6 }
            r7 = r5
        L_0x0033:
            int r8 = r11.length     // Catch:{ all -> 0x00c6 }
            if (r7 >= r8) goto L_0x004f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c6 }
            r8.<init>()     // Catch:{ all -> 0x00c6 }
            r8.append(r0)     // Catch:{ all -> 0x00c6 }
            r9 = r11[r7]     // Catch:{ all -> 0x00c6 }
            r8.append(r9)     // Catch:{ all -> 0x00c6 }
            java.lang.String r9 = " "
            r8.append(r9)     // Catch:{ all -> 0x00c6 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x00c6 }
            int r7 = r7 + 1
            goto L_0x0033
        L_0x004f:
            java.lang.String r11 = r0.trim()     // Catch:{ all -> 0x00c6 }
        L_0x0053:
            r0 = r11
            goto L_0x0083
        L_0x0055:
            r11 = r1
        L_0x0056:
            java.lang.String r7 = r4.readLine()     // Catch:{ all -> 0x00c6 }
            if (r7 == 0) goto L_0x0083
            int r8 = r7.length()     // Catch:{ all -> 0x00c6 }
            if (r8 <= 0) goto L_0x0083
            int r11 = r11 + r6
            r8 = 10
            if (r11 > r8) goto L_0x0083
            java.lang.String[] r7 = r7.split(r2)     // Catch:{ all -> 0x00c6 }
            int r8 = r7.length     // Catch:{ all -> 0x00c6 }
            if (r8 < r5) goto L_0x0056
            r8 = r7[r6]     // Catch:{ all -> 0x00c6 }
            java.lang.String r8 = r8.trim()     // Catch:{ all -> 0x00c6 }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ all -> 0x00c6 }
            java.lang.String r9 = "intel"
            boolean r8 = r8.startsWith(r9)     // Catch:{ all -> 0x00c6 }
            if (r8 == 0) goto L_0x0056
            r11 = r7[r6]     // Catch:{ all -> 0x00c6 }
            goto L_0x0053
        L_0x0083:
            boolean r11 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ all -> 0x00c6 }
            java.lang.String r7 = "0"
            if (r11 != 0) goto L_0x0091
            boolean r11 = r7.equals(r0)     // Catch:{ all -> 0x00c6 }
            if (r11 == 0) goto L_0x00b1
        L_0x0091:
            java.lang.String r11 = r4.readLine()     // Catch:{ all -> 0x00c6 }
            java.lang.String r8 = "Hardware"
            if (r11 == 0) goto L_0x009f
            boolean r9 = r11.contains(r8)     // Catch:{ all -> 0x00c6 }
            if (r9 == 0) goto L_0x0091
        L_0x009f:
            if (r11 == 0) goto L_0x00b1
            boolean r8 = r11.contains(r8)     // Catch:{ all -> 0x00c6 }
            if (r8 == 0) goto L_0x00b1
            java.lang.String[] r11 = r11.split(r2)     // Catch:{ all -> 0x00c6 }
            int r2 = r11.length     // Catch:{ all -> 0x00c6 }
            if (r2 < r5) goto L_0x00b1
            r11 = r11[r6]     // Catch:{ all -> 0x00c6 }
            r0 = r11
        L_0x00b1:
            boolean r11 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ all -> 0x00c6 }
            if (r11 != 0) goto L_0x00bd
            boolean r11 = r7.equals(r0)     // Catch:{ all -> 0x00c6 }
            if (r11 == 0) goto L_0x00bf
        L_0x00bd:
            java.lang.String r0 = android.os.Build.BOARD     // Catch:{ all -> 0x00c6 }
        L_0x00bf:
            r4.close()     // Catch:{ IOException -> 0x00f1 }
            r3.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f1
        L_0x00c6:
            r11 = move-exception
            goto L_0x00ca
        L_0x00c8:
            r11 = move-exception
            r4 = r2
        L_0x00ca:
            r2 = r3
            goto L_0x00ce
        L_0x00cc:
            r11 = move-exception
            r4 = r2
        L_0x00ce:
            com.bonree.sdk.be.f r3 = r10.B     // Catch:{ all -> 0x00fa }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            java.lang.String r6 = "DeviceInfo getCpuInfo e:"
            r5.<init>(r6)     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fa }
            r5.append(r11)     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = r5.toString()     // Catch:{ all -> 0x00fa }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00fa }
            r3.e(r11, r1)     // Catch:{ all -> 0x00fa }
            if (r4 == 0) goto L_0x00ec
            r4.close()     // Catch:{ IOException -> 0x00f1 }
        L_0x00ec:
            if (r2 == 0) goto L_0x00f1
            r2.close()     // Catch:{ IOException -> 0x00f1 }
        L_0x00f1:
            boolean r11 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)
            if (r11 == 0) goto L_0x00f9
            java.lang.String r0 = "unknown"
        L_0x00f9:
            return r0
        L_0x00fa:
            r11 = move-exception
            if (r4 == 0) goto L_0x0100
            r4.close()     // Catch:{ IOException -> 0x0105 }
        L_0x0100:
            if (r2 == 0) goto L_0x0105
            r2.close()     // Catch:{ IOException -> 0x0105 }
        L_0x0105:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.am.f.b(java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.FileReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[SYNTHETIC, Splitter:B:26:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080 A[Catch:{ IOException -> 0x0083 }, DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float t() {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "/proc/meminfo"
            r3.<init>(r4)     // Catch:{ all -> 0x005c }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0057 }
            r5 = 200(0xc8, float:2.8E-43)
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = "\\s+"
            java.lang.String[] r2 = r2.split(r5)     // Catch:{ all -> 0x0055 }
            r5 = 1
            if (r2 == 0) goto L_0x002d
            int r6 = r2.length     // Catch:{ all -> 0x0055 }
            r7 = 2
            if (r6 <= r7) goto L_0x002d
            r2 = r2[r5]     // Catch:{ all -> 0x0055 }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ all -> 0x0055 }
            float r2 = r2.floatValue()     // Catch:{ all -> 0x0055 }
            goto L_0x002e
        L_0x002d:
            r2 = r1
        L_0x002e:
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x0055 }
            java.lang.String r7 = "%.2f"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0055 }
            r8 = 1149239296(0x44800000, float:1024.0)
            float r2 = r2 / r8
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ all -> 0x0055 }
            r5[r0] = r2     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = java.lang.String.format(r6, r7, r5)     // Catch:{ all -> 0x0055 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ all -> 0x0055 }
            double r5 = (double) r2     // Catch:{ all -> 0x0055 }
            double r5 = java.lang.Math.ceil(r5)     // Catch:{ all -> 0x0055 }
            int r2 = (int) r5     // Catch:{ all -> 0x0055 }
            r10.z = r2     // Catch:{ all -> 0x0055 }
            float r0 = (float) r2
            r4.close()     // Catch:{ IOException -> 0x0054 }
            r3.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            return r0
        L_0x0055:
            r2 = move-exception
            goto L_0x0060
        L_0x0057:
            r4 = move-exception
            r9 = r4
            r4 = r2
            r2 = r9
            goto L_0x0060
        L_0x005c:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
        L_0x0060:
            com.bonree.sdk.be.f r5 = r10.B     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            java.lang.String r7 = "DeviceInfo getTotalMemoryInfo e:"
            r6.<init>(r7)     // Catch:{ all -> 0x0084 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0084 }
            r6.append(r2)     // Catch:{ all -> 0x0084 }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0084 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0084 }
            r5.e(r2, r0)     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x007e
            r4.close()     // Catch:{ IOException -> 0x0083 }
        L_0x007e:
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ IOException -> 0x0083 }
        L_0x0083:
            return r1
        L_0x0084:
            r0 = move-exception
            if (r4 == 0) goto L_0x008a
            r4.close()     // Catch:{ IOException -> 0x008f }
        L_0x008a:
            if (r3 == 0) goto L_0x008f
            r3.close()     // Catch:{ IOException -> 0x008f }
        L_0x008f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.am.f.t():float");
    }

    private static boolean c(String str) {
        if (ad.a(str)) {
            return true;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '0') {
                i2++;
            }
        }
        return i2 == str.length();
    }

    public final String g() {
        return this.c;
    }

    public final String h() {
        return this.a;
    }

    public final String i() {
        return this.b;
    }

    public final String j() {
        return this.d;
    }

    public final String k() {
        return this.e;
    }

    public final String l() {
        return this.f;
    }

    public final String m() {
        return this.g;
    }

    private void d(String str) {
        this.g = str;
    }

    public final String n() {
        return this.h;
    }

    public final String o() {
        return b();
    }

    public final String p() {
        return this.j;
    }

    public final int q() {
        return this.z;
    }

    private Method u() {
        return this.A;
    }

    private Context v() {
        return this.l;
    }

    public final int r() {
        return this.k;
    }

    private com.bonree.sdk.be.f w() {
        return this.B;
    }

    public String toString() {
        return "DeviceInfo{osMajorVersion='" + this.c + '\'' + ", osCustomVersion='" + this.j + '\'' + ", mBrandName='" + this.a + '\'' + ", mModel='" + this.b + '\'' + ", mCpuModel='" + this.d + '\'' + ", mCpuInstructionSet='" + this.e + '\'' + ", mCpuHardware='" + this.f + '\'' + ", authority=" + this.g + '\'' + ", mDisplaySize='" + this.h + '\'' + ", mLanguage='" + this.i + '\'' + ", mCustomizedOsVersion='" + this.j + '\'' + ", mTotalMemory=" + this.z + '\'' + ", mSysPropGet=" + this.A + '\'' + ", mContext=" + this.l + '\'' + ", mLog=" + this.B + '\'' + '}';
    }
}
