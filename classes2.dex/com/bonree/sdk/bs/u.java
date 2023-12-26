package com.bonree.sdk.bs;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.text.TextUtils;
import com.bonree.sdk.be.g;
import com.bonree.sdk.common.json.HTTP;
import com.didi.hummer.adapter.http.impl.DefaultHttpAdapter;
import com.igexin.assist.sdk.AssistPushConsts;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class u {
    private static String A = "data:";
    private static String B = "chromewebdata";
    private static String C = "br_request_id";
    private static String D = "br_interactive_uuid";
    private static final Pattern E = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern F = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern G = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    private static final String[] H = {"application/", "text/", "image/", "audio/", "video/", "multipart/", "message/", "x-world/"};
    private static final String I = "^.*(image/jpeg|image/gif|image/png|image/x-ms-bmp|image/ico).*";
    private static int J = 64;
    private static int a = 8192;
    private static String b = "content-type";
    private static final int c = 128;
    private static final String d = "*/*";
    private static final String e = ".";
    private static String f = "HTTP/";
    private static String g = "http/";
    private static String h = "br-resp-key";
    private static String i = "br-req-key";
    private static String j = "x-br-response";
    private static String k = "traceresponse";
    private static String l = "traceparent";
    private static String m = "content-length";
    private static String n = "host";
    private static String o = ":";
    private static String p = "http://";
    private static String q = "https://";
    private static String r = "h2://";
    private static String s = "h2c://";
    private static String t = "ws://";
    private static String u = "wss://";
    private static String v = "unknown://";
    private static String w = "unknowns://";
    private static String x = "file://";
    private static String y = "about:blank";
    private static String z = "scheme://";

    public static class a {
        public String a;
        public String b = "";
        public boolean c = false;
    }

    private static boolean h(String str) {
        return E.matcher(str).matches();
    }

    private static boolean i(String str) {
        return F.matcher(str).matches();
    }

    private static boolean j(String str) {
        return G.matcher(str).matches();
    }

    private static String b(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        try {
            String str3 = str + "=";
            String lowerCase = str2.toLowerCase();
            String lowerCase2 = str.toLowerCase();
            String lowerCase3 = str3.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                return "";
            }
            String[] split = str2.split("\\,");
            for (String str4 : split) {
                if (str4.toLowerCase().contains(lowerCase3)) {
                    return str4.replace("[", "").replace("]", "").replace(str3, "").replace(" ", "");
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str, String str2) {
        if (str2 == null || str == null) {
            return "";
        }
        try {
            String c2 = c(str + ":", str2);
            if (ad.a(c2)) {
                c2 = c("\n" + str + ":", str2);
            }
            if (ad.a(c2)) {
                c2 = c(str + " :", str2);
            }
            if (!ad.a(c2)) {
                return c2;
            }
            return c("\n" + str + " :", str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String c(String str, String str2) {
        if (!ad.a(str) && !ad.a(str2)) {
            String lowerCase = str2.toLowerCase();
            String lowerCase2 = str.toLowerCase();
            if (lowerCase.contains(lowerCase2)) {
                String replace = str2.substring(lowerCase.indexOf(lowerCase2)).replace(str, "");
                if (replace.contains(HTTP.CRLF)) {
                    String trim = replace.substring(0, replace.indexOf(HTTP.CRLF)).trim();
                    if (trim.contains("\n")) {
                        return trim.substring(0, trim.indexOf("\n")).trim();
                    }
                    return trim.trim();
                } else if (replace.contains("\n")) {
                    return replace.substring(0, replace.indexOf("\n")).trim();
                } else {
                    return replace.trim();
                }
            }
        }
        return "";
    }

    private static String l(String str) {
        try {
            String a2 = a(DefaultHttpAdapter.CONTENT_TYPE, str.toLowerCase());
            if (a2 != null) {
                if (a2.length() != 0) {
                    for (String str2 : a2.split(";")) {
                        if (str2 != null && str2.contains("/") && str2.length() < c) {
                            return str2;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return d;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String trim = str.toLowerCase().trim();
        if (trim.indexOf("https://") == 0) {
            return str.trim().substring(8);
        }
        return trim.indexOf("http://") == 0 ? str.trim().substring(7) : str;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String trim = str.trim();
        if (trim.indexOf("https://") >= 0) {
            trim = trim.trim().substring(8);
        } else if (trim.indexOf("http://") >= 0) {
            trim = trim.trim().substring(7);
        }
        if (trim.indexOf("/") >= 0) {
            trim = trim.substring(trim.indexOf("/"));
        }
        return trim.indexOf("?") >= 0 ? trim.substring(0, trim.indexOf("?")) : trim;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String trim = str.toLowerCase().trim();
        if (trim.indexOf("https://") >= 0) {
            trim = trim.trim().substring(8);
        } else if (trim.indexOf("http://") >= 0) {
            trim = trim.trim().substring(7);
        }
        if (trim.indexOf("/") >= 0) {
            trim = trim.substring(0, trim.indexOf("/"));
        }
        if (trim.indexOf("::") < 0) {
            return trim.indexOf(":") >= 0 ? trim.substring(0, trim.indexOf(":")) : trim;
        }
        if (trim.indexOf("]") > 0) {
            return trim.substring(trim.indexOf("[") + 1, trim.indexOf("]"));
        }
        return trim;
    }

    private static short a(byte[] bArr) {
        short s2 = -1;
        if (bArr != null && bArr.length > 0) {
            for (int i2 = 0; i2 < 2; i2++) {
                s2 = (short) (s2 | ((bArr[i2] & 255) << ((2 - i2) << 3)));
            }
        }
        return s2;
    }

    private static int b(byte[] bArr) {
        long j2 = -1;
        if (bArr != null && bArr.length > 0) {
            for (int i2 = 0; i2 < 4; i2++) {
                j2 |= (long) ((bArr[i2] & 255) << ((4 - i2) << 3));
            }
        }
        return (int) j2;
    }

    private static long c(byte[] bArr) {
        if (bArr == null || bArr.length != 4) {
            return 0;
        }
        return ((long) ((bArr[0] << 24) & -16777216)) | ((long) ((bArr[1] << 16) & -65536)) | ((long) ((bArr[2] << 8) & -256)) | ((long) bArr[3]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x005f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m(java.lang.String r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "."
            java.lang.String[] r4 = r4.split(r1)     // Catch:{ all -> 0x005f }
            int r1 = r4.length     // Catch:{ all -> 0x005f }
            r2 = 4
            if (r1 != r2) goto L_0x005f
            r1 = r4[r0]     // Catch:{ all -> 0x005f }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x005f }
            r2 = 1
            if (r1 != 0) goto L_0x0032
            r1 = r4[r2]     // Catch:{ all -> 0x005f }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x005f }
            if (r1 != 0) goto L_0x005f
            r1 = 2
            r1 = r4[r1]     // Catch:{ all -> 0x005f }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x005f }
            if (r1 != 0) goto L_0x005f
            r1 = 3
            r4 = r4[r1]     // Catch:{ all -> 0x005f }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ all -> 0x005f }
            if (r4 != 0) goto L_0x005f
            return r2
        L_0x0032:
            r3 = 10
            if (r1 == r3) goto L_0x005e
            r3 = 100
            if (r1 != r3) goto L_0x003b
            goto L_0x005e
        L_0x003b:
            r3 = 172(0xac, float:2.41E-43)
            if (r1 != r3) goto L_0x004e
            r4 = r4[r2]     // Catch:{ all -> 0x005f }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ all -> 0x005f }
            r1 = 15
            if (r4 < r1) goto L_0x005f
            r1 = 31
            if (r4 > r1) goto L_0x005f
            return r2
        L_0x004e:
            r3 = 192(0xc0, float:2.69E-43)
            if (r1 != r3) goto L_0x005d
            r4 = r4[r2]     // Catch:{ all -> 0x005f }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ all -> 0x005f }
            r1 = 168(0xa8, float:2.35E-43)
            if (r4 != r1) goto L_0x005f
            return r2
        L_0x005d:
            return r0
        L_0x005e:
            return r2
        L_0x005f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.u.m(java.lang.String):boolean");
    }

    private static int n(String str) {
        if (str == null) {
            return 0;
        }
        try {
            if (!str.contains(e)) {
                return 0;
            }
            String[] split = str.split("\\.");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]) << 8;
            return (Integer.parseInt(split[3]) << 24) | parseInt | parseInt2 | (Integer.parseInt(split[2]) << 16);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int o(String str) {
        String str2;
        if (!(str == null || str.trim().length() == 0)) {
            while (true) {
                try {
                    if (!str.startsWith("HTTP/")) {
                        if (!str.startsWith("http/")) {
                            break;
                        }
                    }
                    str = str.substring(str.indexOf(32)).trim();
                } catch (Throwable unused) {
                }
            }
            String trim = str.trim();
            int indexOf = trim.indexOf(10);
            if (indexOf != -1) {
                trim = trim.substring(0, indexOf);
            }
            int indexOf2 = trim.indexOf(32);
            if (indexOf2 != -1) {
                str2 = trim.substring(0, indexOf2);
            } else {
                str2 = trim.trim();
            }
            return Integer.parseInt(str2);
        }
        return 0;
    }

    private static int p(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        String a2 = a("content-length", str.toLowerCase());
        if (a2 == null || "".equals(a2)) {
            a2 = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE;
        }
        try {
            return Integer.parseInt(a2);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private static String q(String str) {
        if (str == null) {
            return "";
        }
        try {
            String a2 = a(DefaultHttpAdapter.CONTENT_TYPE, str.toLowerCase());
            if (a2 == null || a2.length() == 0) {
                a2 = d;
            }
            String[] strArr = H;
            int i2 = 0;
            while (true) {
                if (i2 >= 8) {
                    break;
                }
                int indexOf = a2.indexOf(strArr[i2]);
                if (indexOf != -1) {
                    a2 = a2.substring(indexOf).trim();
                    int indexOf2 = a2.indexOf(";");
                    if (indexOf2 != -1) {
                        return a2.substring(0, indexOf2);
                    }
                    int indexOf3 = a2.indexOf(32);
                    if (indexOf3 != -1) {
                        return a2.substring(0, indexOf3);
                    }
                } else {
                    i2++;
                }
            }
            if (a2.length() < c) {
                return a2;
            }
            return d;
        } catch (Throwable unused) {
        }
    }

    private static boolean r(String str) {
        if (str != null) {
            return str.matches(I);
        }
        return false;
    }

    public static String d(String str) {
        return (str == null || str.trim().length() == 0) ? "" : a("br-resp-key", str.toLowerCase());
    }

    public static String e(String str) {
        return (str == null || str.trim().length() == 0) ? "" : a("x-br-response", str);
    }

    public static String f(String str) {
        return (str == null || str.trim().length() == 0) ? "" : a("traceresponse", str);
    }

    public static String a(Map<String, String> map) {
        return a("br-resp-key", map);
    }

    public static String b(Map<String, String> map) {
        return a("x-br-response", map);
    }

    public static String c(Map<String, String> map) {
        return a("traceresponse", map);
    }

    private static String a(String str, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                hashMap.put(((String) next.getKey()).toLowerCase(), next.getValue());
            }
        }
        return (String) hashMap.get(str.toLowerCase());
    }

    private static String s(String str) {
        return (str == null || str.trim().length() == 0) ? "" : b("br-resp-key", str.toLowerCase());
    }

    private static String t(String str) {
        return (str == null || str.trim().length() == 0) ? "" : a("br-req-key", str.toLowerCase());
    }

    private static String u(String str) {
        return (str == null || str.trim().length() == 0) ? "" : a("host", str.toLowerCase());
    }

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static int g(String str) {
        if (a()) {
            return 0;
        }
        try {
            long b2 = com.bonree.sdk.d.a.b();
            InetAddress.getAllByName(str);
            return (int) (com.bonree.sdk.d.a.b() - b2);
        } catch (UnknownHostException unused) {
            g.a("dns parse fail", new Object[0]);
            return 0;
        }
    }

    private static NetworkInfo a(Context context) {
        if (context == null || !ad.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return null;
        }
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static Map<String, String> d(Map<String, List<String>> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            List list = (List) next.getValue();
            if (list != null && list.size() > 0 && !TextUtils.isEmpty((CharSequence) next.getKey()) && !TextUtils.isEmpty((CharSequence) list.get(0))) {
                linkedHashMap.put(next.getKey(), list.get(0));
            }
        }
        return linkedHashMap;
    }

    public static Map<String, Object> e(Map<String, Object> map) {
        k kVar;
        try {
            int size = map.size();
            HashMap hashMap = new HashMap(map);
            if (!hashMap.containsKey((Object) null)) {
                if (!hashMap.containsValue((Object) null)) {
                    if (size <= 64) {
                        kVar = new k(hashMap);
                    } else if (size < 64 || size > c) {
                        kVar = new k();
                        Iterator it = hashMap.entrySet().iterator();
                        while (it.hasNext() && kVar.size() < 64) {
                            Map.Entry entry = (Map.Entry) it.next();
                            kVar.put(entry.getKey(), entry.getValue());
                        }
                    } else {
                        kVar = new k(hashMap);
                        Iterator it2 = kVar.keySet().iterator();
                        while (it2.hasNext() && kVar.size() > 64) {
                            it2.next();
                            it2.remove();
                        }
                    }
                    return kVar;
                }
            }
            kVar = new k();
            Iterator it3 = hashMap.entrySet().iterator();
            while (it3.hasNext() && kVar.size() < 64) {
                Map.Entry entry2 = (Map.Entry) it3.next();
                if (!(entry2.getKey() == null || entry2.getValue() == null)) {
                    kVar.put(entry2.getKey(), entry2.getValue());
                }
            }
            return kVar;
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("NetUtil", th);
            return null;
        }
    }

    public static a f(Map<String, List<String>> map) {
        List list;
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a aVar = new a();
        for (String next : map.keySet()) {
            if (!TextUtils.isEmpty(next) && (list = map.get(next)) != null) {
                if (next.equals("X-Android-Selected-Protocol") && list.size() > 0) {
                    aVar.b = list.get(0).toString();
                }
                if (next.equals("X-Android-Response-Source") && list.size() > 0) {
                    String obj = list.get(0).toString();
                    if (obj != null) {
                        if (obj.toLowerCase().contains("cache") && !obj.toLowerCase().contains("conditional_cache")) {
                            aVar.c = true;
                        }
                    }
                }
                if (list.size() > 0) {
                    sb.append(next);
                    sb.append(" : ");
                    sb.append(list.get(0));
                    sb.append(HTTP.CRLF);
                }
            }
        }
        aVar.a = sb.toString();
        return aVar;
    }

    private static boolean k(String str) {
        return F.matcher(str).matches() || G.matcher(str).matches();
    }
}
