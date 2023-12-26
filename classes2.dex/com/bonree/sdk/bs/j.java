package com.bonree.sdk.bs;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bonree.sdk.d.a;

public class j {
    private static String a = "android.app.ActivityThread";
    private static int b = 28;
    private static int c = 18;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[SYNTHETIC, Splitter:B:15:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static java.lang.String a(int r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0030 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = "/proc/"
            r3.<init>(r4)     // Catch:{ all -> 0x0030 }
            r3.append(r5)     // Catch:{ all -> 0x0030 }
            java.lang.String r5 = "/cmdline"
            r3.append(r5)     // Catch:{ all -> 0x0030 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0030 }
            r2.<init>(r5)     // Catch:{ all -> 0x0030 }
            r1.<init>(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r5 = r1.readLine()     // Catch:{ all -> 0x0031 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0031 }
            if (r2 != 0) goto L_0x002c
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x0031 }
        L_0x002c:
            r1.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r5
        L_0x0030:
            r1 = r0
        L_0x0031:
            if (r1 == 0) goto L_0x0036
            r1.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.j.a(int):java.lang.String");
    }

    private static String a() {
        if (a.L()) {
            return (String) a("android.app.Application", "getProcessName", (Class<?>[]) null, (Object[]) null);
        }
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        return Application.getProcessName();
    }

    protected static Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        String str;
        if (a.L()) {
            str = (String) a("android.app.Application", "getProcessName", (Class<?>[]) null, (Object[]) null);
        } else if (Build.VERSION.SDK_INT < 28) {
            str = null;
        } else {
            str = Application.getProcessName();
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "currentProcessName";
        if (!a.L() && Build.VERSION.SDK_INT < 18) {
            str2 = "currentPackageName";
        }
        Object a2 = a("android.app.ActivityThread", str2, (Class<?>[]) null, (Object[]) null);
        String str3 = a2 != null ? (String) a2 : "";
        return (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str3)) ? a(Process.myPid()) : str3;
    }
}
