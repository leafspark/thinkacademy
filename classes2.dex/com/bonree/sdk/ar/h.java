package com.bonree.sdk.ar;

import android.os.Build;
import android.text.TextUtils;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.igexin.assist.sdk.AssistPushConsts;
import java.net.InetAddress;
import java.util.Properties;

public final class h {
    private static f a = a.a();
    private static int b = 0;
    private static int c = 1;
    private static int d = 2;
    private static int e = 3;
    private static int f = 5;
    private static int g = 6;
    private static int h = 7;
    private static int i = 11;
    private static String j = "GET";

    static boolean a(int i2) {
        return i2 == 659;
    }

    static boolean b(int i2) {
        return i2 == 652;
    }

    static boolean c(int i2) {
        return i2 == 653;
    }

    static boolean d(int i2) {
        return i2 == 641;
    }

    static boolean e(int i2) {
        return i2 == 642;
    }

    static boolean a(String str) {
        return Build.VERSION.SDK_INT > 26 && str.startsWith("https://");
    }

    static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("https://") || str.startsWith("wss://")) {
            return true;
        }
        return false;
    }

    static String a() {
        Properties properties = System.getProperties();
        String property = properties.getProperty("http.proxyHost");
        String property2 = properties.getProperty("http.proxyPort");
        String property3 = properties.getProperty("https.proxyHost");
        String property4 = properties.getProperty("https.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            return property + property2;
        } else if (TextUtils.isEmpty(property3)) {
            return null;
        } else {
            return property3 + property4;
        }
    }

    static int a(String str, String str2) {
        if (ad.a(str)) {
            return 0;
        }
        if (ad.a(str2)) {
            return c(str);
        }
        if (str2.contains("http") && !str2.contains("quic/")) {
            return str.startsWith("https://") ? 2 : 1;
        }
        if ("h2".equals(str2)) {
            return 3;
        }
        if ("ws".equals(str2) || "ws_send".equals(str2)) {
            return 5;
        }
        if ("wss".equals(str2) || "wss_send".equals(str2)) {
            return 6;
        }
        if (str2.contains("quic/") || str2.contains("h3-")) {
            return 11;
        }
        return c(str);
    }

    static int c(String str) {
        if (ad.a(str)) {
            return 0;
        }
        if (str.startsWith("http://")) {
            return 1;
        }
        if (str.startsWith("https://")) {
            return 2;
        }
        if (str.startsWith("h2://")) {
            return 3;
        }
        if (str.startsWith("ws://")) {
            return 5;
        }
        if (str.startsWith("wss://")) {
            return 6;
        }
        return 0;
    }

    public static String[] b(String str, String str2) {
        String str3;
        String[] strArr = {"", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE};
        if (!ad.a(str) && !ad.a(str2)) {
            long b2 = com.bonree.sdk.d.a.b();
            if (str.startsWith("http://")) {
                strArr[1] = "80";
            } else if (str.startsWith("https://")) {
                strArr[1] = "443";
            }
            try {
                if (str2.contains("::") || !str2.contains(":")) {
                    str3 = str2;
                } else {
                    String[] split = str2.split(":");
                    str3 = split[0];
                    if (ad.k(split[1])) {
                        strArr[1] = split[1];
                    }
                }
                strArr[0] = InetAddress.getByName(str3).getHostAddress();
            } catch (Throwable th) {
                a.a("getIPAndPortByDomain error", th);
            }
            if (strArr[0] == null || !str2.contains(strArr[0])) {
                strArr[2] = String.valueOf(com.bonree.sdk.d.a.b() - b2);
            } else {
                strArr[2] = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE;
            }
        }
        return strArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0 = com.bonree.sdk.bs.ad.n(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r5.containsKey(r4) != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0 == null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r0.isEmpty() != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r5.put(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        monitor-exit(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<java.lang.String> a(java.lang.String r4, java.util.Map<java.lang.String, java.util.List> r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = com.bonree.sdk.bs.ad.a((java.lang.String) r4)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.String r1 = ":"
            boolean r1 = r4.contains(r1)
            if (r1 == 0) goto L_0x001d
            java.lang.String r1 = ":"
            java.lang.String[] r4 = r4.split(r1)
            r1 = 0
            r4 = r4[r1]
        L_0x001d:
            monitor-enter(r5)     // Catch:{ all -> 0x004b }
            boolean r1 = r5.containsKey(r4)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r5.get(r4)     // Catch:{ all -> 0x0048 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            return r1
        L_0x002c:
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            java.util.List r0 = com.bonree.sdk.bs.ad.n(r4)     // Catch:{ all -> 0x004b }
            boolean r1 = r5.containsKey(r4)     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x005f
            if (r0 == 0) goto L_0x005f
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x005f
            monitor-enter(r5)     // Catch:{ all -> 0x004b }
            r5.put(r4, r0)     // Catch:{ all -> 0x0045 }
            monitor-exit(r5)     // Catch:{ all -> 0x0045 }
            goto L_0x005f
        L_0x0045:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0045 }
            throw r1     // Catch:{ all -> 0x004b }
        L_0x0048:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            throw r1     // Catch:{ all -> 0x004b }
        L_0x004b:
            r5 = move-exception
            com.bonree.sdk.be.f r1 = a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "get CNAME Array by domain error,domain ="
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r1.a((java.lang.String) r4, (java.lang.Throwable) r5)
        L_0x005f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.h.a(java.lang.String, java.util.Map):java.util.List");
    }

    static void d(String str) {
        try {
            InetAddress.getByName(str).getHostAddress();
        } catch (Throwable th) {
            a.a("getIPByDomain:", th);
        }
    }

    static boolean e(String str) {
        if (ad.a(str)) {
            return false;
        }
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ws://") || str.startsWith("wss://") || str.startsWith("h2c://") || str.startsWith("h2://") || str.startsWith("file://")) {
            return true;
        }
        return false;
    }

    static boolean c(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        if ((str + "/").equals(str2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("/");
        return str.equals(sb.toString());
    }
}
