package com.bonree.sdk.bs;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.business.entity.UserTrackBean;
import com.bonree.sdk.am.g;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bj.a;
import com.bonree.sdk.bl.d;
import com.bonree.sdk.bp.v;
import com.bonree.sdk.bq.a;
import com.bonree.sdk.bq.c;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.common.json.HTTP;
import com.bonree.sdk.common.json.JSONArray;
import com.bonree.sdk.common.json.JSONObject;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import ohos.agp.components.webengine.ResourceError;
import ohos.agp.components.webengine.ResourceRequest;
import org.json.JSONException;

public final class ad {
    /* access modifiers changed from: private */
    public static String a = "Utils";
    private static int b = 53;
    private static String c = ";";
    private static String d = "@";
    private static String e = "\\.";
    private static String f = "/";
    private static String g = "_";
    private static String h = "&";
    private static String i = "####";
    private static String j = "\r\n";
    private static final int k = 10000;
    private static final Pattern l = Pattern.compile("/");
    private static final Pattern m = Pattern.compile("^[:0-9a-zA-Z_-]{1,}$");
    private static final Pattern n = Pattern.compile("[0-9]*");
    private static final Pattern o = Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");
    private static String p = "   ";

    public static long a(long j2) {
        return j2 * 1000;
    }

    public static String j(String str) {
        return str == null ? "" : str;
    }

    private static boolean b(List list) {
        return list == null || list.size() <= 0;
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || str.toLowerCase().equals("null");
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean c(String str) {
        return !a(str);
    }

    public static String a(String str, String str2) {
        String str3 = null;
        if (str != null) {
            try {
                str3 = "(" + str;
            } catch (Exception unused) {
            }
        }
        if (str == null || str2 == null) {
            if (str == null && str2 != null) {
                str3 = "(" + str2 + ")";
            }
            return str3;
        }
        return str3 + "," + str2 + ")";
    }

    public static String a() {
        return String.format("  [Thread name: %s, id: %s]  ", new Object[]{Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId())});
    }

    public static boolean d(String str) {
        if (!TextUtils.isEmpty(str) && Pattern.compile("[一-龥]").matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    public static boolean e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            boolean matches = m.matcher(str).matches();
            if (!matches) {
                f fVar = com.bonree.sdk.d.a.a;
                fVar.d("don`t matches: " + str, new Object[0]);
            }
            return matches;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if (charSequence instanceof String) {
            return charSequence.equals(charSequence2);
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static String a(int i2) {
        try {
            c cVar = new c(400, new ae());
            cVar.a();
            if (cVar.a != null) {
                return (String) cVar.a;
            }
            return "";
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a(a, th);
            return "";
        }
    }

    private static void b(InputStream inputStream) {
        new Thread(new af(inputStream)).start();
    }

    public static void f(String str) {
        g(str);
    }

    public static void g(String str) {
        try {
            if (com.bonree.sdk.d.a.k().B()) {
                a.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    private static String a(String str, int i2) {
        try {
            c cVar = new c(i2, new ag(str));
            cVar.a();
            if (cVar.a != null) {
                return (String) cVar.a;
            }
            return "";
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a(a, th);
            return "";
        }
    }

    public static String b() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            return Environment.getExternalStorageDirectory().getCanonicalPath();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Object a(byte[] bArr, Class<?> cls) {
        return a(new String(bArr), cls);
    }

    public static Object a(String str, Class<?> cls) {
        return new Gson().fromJson(str, cls);
    }

    private static byte[] b(Object obj) {
        return new Gson().toJson(obj).getBytes();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0033 A[SYNTHETIC, Splitter:B:9:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(java.lang.Object r5) {
        /*
            java.lang.String r0 = "dc"
            java.lang.String r1 = "ci"
            com.bonree.sdk.common.gson.GsonBuilder r2 = new com.bonree.sdk.common.gson.GsonBuilder     // Catch:{ all -> 0x003f }
            r2.<init>()     // Catch:{ all -> 0x003f }
            com.bonree.sdk.common.gson.GsonBuilder r2 = r2.serializeNulls()     // Catch:{ all -> 0x003f }
            com.bonree.sdk.common.gson.Gson r2 = r2.create()     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r2.toJson((java.lang.Object) r5)     // Catch:{ all -> 0x003f }
            com.bonree.sdk.common.json.JSONObject r3 = new com.bonree.sdk.common.json.JSONObject     // Catch:{ all -> 0x003f }
            r3.<init>((java.lang.String) r2)     // Catch:{ all -> 0x003f }
            java.lang.String r2 = "cr"
            com.bonree.sdk.common.json.JSONObject r2 = r3.getJSONObject(r2)     // Catch:{ all -> 0x003f }
            boolean r4 = r2.has(r1)     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x002d
            com.bonree.sdk.common.json.JSONArray r1 = r2.getJSONArray(r1)     // Catch:{ all -> 0x002d }
            a((com.bonree.sdk.common.json.JSONArray) r1)     // Catch:{ all -> 0x002d }
        L_0x002d:
            boolean r1 = r2.has(r0)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003a
            com.bonree.sdk.common.json.JSONArray r0 = r2.getJSONArray(r0)     // Catch:{ all -> 0x003a }
            a((com.bonree.sdk.common.json.JSONArray) r0)     // Catch:{ all -> 0x003a }
        L_0x003a:
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x003f }
            return r5
        L_0x003f:
            com.bonree.sdk.common.gson.GsonBuilder r0 = new com.bonree.sdk.common.gson.GsonBuilder
            r0.<init>()
            com.bonree.sdk.common.gson.GsonBuilder r0 = r0.serializeNulls()
            com.bonree.sdk.common.gson.Gson r0 = r0.create()
            java.lang.String r5 = r0.toJson((java.lang.Object) r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.c(java.lang.Object):java.lang.String");
    }

    private static void a(JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            JSONArray jSONArray2 = jSONObject.getJSONArray("ut");
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put((Object) UserTrackBean.KEYS);
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                jSONArray3.put((Object) UserTrackBean.getUserTrackValues(jSONArray2.getJSONObject(i3)));
            }
            jSONObject.remove("ut");
            jSONObject.put("ut", (Object) jSONArray3);
        }
    }

    private static byte[] e(Map<String, Object> map) {
        return new Gson().toJsonTree(map).getAsJsonObject().toString().getBytes();
    }

    public static String h(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '[' || charAt == '{') {
                int i4 = i3 - 1;
                if (i4 > 0 && str.charAt(i4) == ':') {
                    stringBuffer.append(10);
                    stringBuffer.append(b(i2));
                }
                stringBuffer.append(charAt);
                stringBuffer.append(10);
                i2++;
                stringBuffer.append(b(i2));
            } else if (charAt == ']' || charAt == '}') {
                stringBuffer.append(10);
                i2--;
                stringBuffer.append(b(i2));
                stringBuffer.append(charAt);
                int i5 = i3 + 1;
                if (i5 < length && str.charAt(i5) != ',') {
                    stringBuffer.append(10);
                }
            } else if (charAt == ',') {
                stringBuffer.append(charAt);
                stringBuffer.append(10);
                stringBuffer.append(b(i2));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    private static String b(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(p);
        }
        return stringBuffer.toString();
    }

    private static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static <T> T a(Properties properties, String str, T t) {
        if (!properties.containsKey(str)) {
            return t;
        }
        String property = properties.getProperty(str);
        if (a(property) || t == null) {
            return t;
        }
        T trim = property.trim();
        Class<?> cls = t.getClass();
        if (cls == String.class) {
            return trim;
        }
        if (cls == Boolean.class) {
            return new Boolean(trim);
        }
        if (cls == Integer.class) {
            return new Integer(trim);
        }
        if (cls == Float.class) {
            return new Float(trim);
        }
        if (cls == Long.class) {
            return new Long(trim);
        }
        return cls == Double.class ? new Double(trim) : t;
    }

    private static boolean a(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) || charSequence.toString().trim().length() == 0;
    }

    private static boolean a(String[] strArr, String[] strArr2, String[] strArr3) {
        if (!(strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0)) {
            for (String str : strArr) {
                if (!a(str) && !a(str, (String[]) null) && a(str, strArr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(String str, String[] strArr) {
        if (!(a(str) || strArr == null || strArr.length == 0)) {
            for (String equals : strArr) {
                if (str.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String a(String str, String str2, String str3) {
        if (!(a(str) || str2 == null || str3 == null)) {
            int length = str.length();
            int length2 = str2.length();
            int length3 = str3.length();
            if (length > length2 && length > length3) {
                int i2 = 0;
                if (length2 != 0 && (i2 = str.indexOf(str2)) == -1) {
                    return null;
                }
                if (length3 == 0 || (length = str.indexOf(str3, i2 + length2)) != -1) {
                    return str.substring(i2 + length2, length);
                }
                return null;
            }
        }
        return null;
    }

    public static void a(Closeable... closeableArr) {
        for (int i2 = 0; i2 < 3; i2++) {
            a(closeableArr[i2]);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.InputStreamReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> b(android.content.Context r8, java.lang.String r9) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            r3 = 3
            r4 = 0
            java.io.FileInputStream r8 = r8.openFileInput(r9)     // Catch:{ all -> 0x0036 }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ all -> 0x0034 }
            r9.<init>(r8)     // Catch:{ all -> 0x0034 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0032 }
            r5.<init>(r9)     // Catch:{ all -> 0x0032 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0039 }
            r6.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r7 = r5.readLine()     // Catch:{ all -> 0x0039 }
        L_0x001c:
            if (r7 == 0) goto L_0x0026
            r6.add(r7)     // Catch:{ all -> 0x0039 }
            java.lang.String r7 = r5.readLine()     // Catch:{ all -> 0x0039 }
            goto L_0x001c
        L_0x0026:
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r8
            r3[r1] = r9
            r3[r0] = r5
            a((java.io.Closeable[]) r3)
            return r6
        L_0x0032:
            r5 = r4
            goto L_0x0039
        L_0x0034:
            r9 = r4
            goto L_0x0038
        L_0x0036:
            r8 = r4
            r9 = r8
        L_0x0038:
            r5 = r9
        L_0x0039:
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r8
            r3[r1] = r9
            r3[r0] = r5
            a((java.io.Closeable[]) r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.b(android.content.Context, java.lang.String):java.util.List");
    }

    private static void c(Context context, String str) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static String c() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String c(String str, String str2) {
        return b(str, str2, (String) null);
    }

    private static String b(String str, String str2, String str3) {
        if (str2 == null) {
            return null;
        }
        if (str2.startsWith("http:") || str2.startsWith("https:")) {
            return str2;
        }
        if (str2.contains("://") && !str2.startsWith("://") && str2.contains("?")) {
            String[] split = str2.split("\\?");
            if (split.length > 0 && split[0].contains("://") && !split[0].startsWith("://")) {
                return str2;
            }
        }
        if (str == null) {
            return null;
        }
        try {
            URL url = new URL(str);
            StringBuilder sb = new StringBuilder();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(url.getHost());
            int port = url.getPort();
            if (port != -1) {
                sb.append(":");
                sb.append(String.valueOf(port));
            }
            if (!str2.startsWith("/")) {
                String replaceFirst = url.getPath().replaceFirst("/", "");
                if (replaceFirst.endsWith("/")) {
                    replaceFirst = replaceFirst + "*";
                }
                LinkedList linkedList = new LinkedList();
                String[] split2 = replaceFirst.split("/");
                if (split2.length > 0) {
                    Collections.addAll(linkedList, split2);
                }
                if (!TextUtils.isEmpty(str2) && !str2.startsWith("?") && !str2.contains(".html") && !TextUtils.isEmpty((CharSequence) linkedList.getLast()) && ((String) linkedList.getLast()).contains(".html")) {
                    linkedList.removeLast();
                }
                while (true) {
                    if (!str2.startsWith("../") && !str2.startsWith("./") && !str2.startsWith("/")) {
                        break;
                    }
                    if (str2.startsWith("../")) {
                        try {
                            linkedList.pollLast();
                        } catch (Throwable unused) {
                        }
                        str2 = str2.replaceFirst("../", "");
                        if (linkedList.size() > 0) {
                            linkedList.removeLast();
                        }
                    }
                    if (str2.startsWith("./")) {
                        str2 = str2.replaceFirst("./", "");
                        if (linkedList.size() > 0) {
                            linkedList.removeLast();
                        }
                    }
                    if (str2.startsWith("/")) {
                        str2 = str2.replaceFirst("/", "");
                        if (linkedList.size() > 0) {
                            linkedList.removeLast();
                        }
                    }
                }
                sb.append("/");
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    sb.append((String) linkedList.get(i2));
                    sb.append("/");
                }
                if (!TextUtils.isEmpty(str2) && str2.startsWith("?")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(str2);
                return sb.toString();
            } else if (str2.startsWith("//")) {
                while (str2.startsWith("/")) {
                    str2 = str2.replaceFirst("/", "");
                }
                return url.getProtocol() + "://" + str2;
            } else {
                sb.append(str2);
                return sb.toString();
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Class<?> a(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return null;
        }
        Class<Object> cls3 = Object.class;
        Class<?> cls4 = cls2;
        while (!cls.equals(cls2)) {
            Class<? super Object> superclass = cls2.getSuperclass();
            if (cls3.equals(superclass)) {
                return cls2;
            }
            Class<? super Object> cls5 = superclass;
            cls4 = cls2;
            cls2 = cls5;
        }
        return cls4;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class<?>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.Class<?> r4, java.lang.Class<?> r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0043
            if (r5 != 0) goto L_0x0006
            goto L_0x0043
        L_0x0006:
            boolean r1 = r4.equals(r5)
            if (r1 == 0) goto L_0x000d
            return r0
        L_0x000d:
            boolean r1 = r4.isInterface()
            if (r1 != 0) goto L_0x0043
            boolean r1 = r5.isInterface()
            if (r1 == 0) goto L_0x001a
            goto L_0x0043
        L_0x001a:
            java.lang.Class r5 = r5.getSuperclass()
            boolean r1 = r4.equals(r5)
            r2 = 1
            if (r1 == 0) goto L_0x0026
            return r2
        L_0x0026:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r3 = r1.equals(r4)
            if (r3 == 0) goto L_0x002f
            return r2
        L_0x002f:
            if (r5 == 0) goto L_0x0043
            boolean r3 = r1.equals(r5)
            if (r3 != 0) goto L_0x0043
            boolean r3 = r4.equals(r5)
            if (r3 == 0) goto L_0x003e
            return r2
        L_0x003e:
            java.lang.Class r5 = r5.getSuperclass()
            goto L_0x002f
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.b(java.lang.Class, java.lang.Class):boolean");
    }

    public static Class<?> i(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean n() {
        return !a(d("ro.miui.ui.version.name", ""));
    }

    public static boolean d() {
        return !a(d("ro.build.version.emui", ""));
    }

    private static boolean o() {
        return !a(d("ro.build.version.opporom", ""));
    }

    private static boolean p() {
        return !a(d("ro.vivo.os.version", ""));
    }

    private static boolean q() {
        return d("ro.build.display.id", "").toUpperCase().contains("FLYME");
    }

    private static boolean r() {
        return !a(d("ro.lenovo.series", ""));
    }

    private static boolean s() {
        return !a(d("ro.smartisan.version", ""));
    }

    private static boolean t() {
        return !a(d("ro.build.nubia.rom.name", ""));
    }

    private static boolean u() {
        return d("ro.build.display.id", "").toUpperCase().contains("ONEPLUS");
    }

    private static boolean v() {
        return !a(d("htc.build.stage", "")) || d("ro.product.manufacturer", "").toUpperCase().contains("HTC");
    }

    private static boolean w() {
        String d2 = d("ro.build.display.id", "");
        return d2.contains("QIKU") || d2.contains("360");
    }

    private static boolean x() {
        return d("ro.product.manufacturer", "").contains("samsung");
    }

    private static boolean y() {
        return d("ro.product.manufacturer", "").toUpperCase().contains("ZTE");
    }

    private static boolean z() {
        return !a(d("ro.yulong.version.release", ""));
    }

    private static boolean A() {
        return d("ro.product.manufacturer", "").contains("Gree");
    }

    private static boolean B() {
        return !a(d("ro.sony.irremote.protocol_type", "")) || d("ro.product.manufacturer", "").contains("Sony");
    }

    private static boolean r(String str) {
        if (a(str)) {
            return false;
        }
        return n.matcher(str).matches();
    }

    private static String C() {
        boolean z;
        String d2 = d("ro.build.version.incremental", "");
        if (a(d2) || d2.startsWith("MIUI")) {
            return d2;
        }
        if (d2.startsWith("V") || d2.startsWith("v")) {
            d2 = d2.substring(1);
        }
        int lastIndexOf = d2.lastIndexOf(".");
        if (lastIndexOf != -1) {
            String substring = d2.substring(lastIndexOf + 1);
            if (!a(substring)) {
                if (a(substring)) {
                    z = false;
                } else {
                    z = n.matcher(substring).matches();
                }
                if (!z) {
                    d2 = d2.substring(0, lastIndexOf) + "(" + substring + ")";
                }
            }
        }
        return "MIUI " + d2;
    }

    private static String D() {
        String d2 = d("ro.build.version.emui", "");
        if (a(d2)) {
            return "";
        }
        if (d2.startsWith("EMUI")) {
            return d2;
        }
        String[] split = d2.split("_");
        String str = split[split.length - 1];
        return "EMUI " + str;
    }

    private static String E() {
        String d2 = d("ro.build.version.opporom", "");
        if (a(d2)) {
            return "";
        }
        if (d2.startsWith("ColorOs")) {
            return d2;
        }
        return "ColorOs " + d2;
    }

    private static String F() {
        return d("ro.vivo.os.build.display.id", "");
    }

    private static String G() {
        String d2 = d("ro.smartisan.version", "");
        if (a(d2)) {
            return "";
        }
        String str = d2.split("-")[0];
        if (str.startsWith("smartisan os")) {
            return str;
        }
        if (!str.startsWith("v")) {
            str = "v" + str;
        }
        return "smartisan os " + str;
    }

    private static String H() {
        String d2 = d("ro.build.rom.id", "");
        if (a(d2)) {
            return "";
        }
        if (d2.startsWith("nubia UI")) {
            return d2;
        }
        return "nubia UI " + d2;
    }

    private static String I() {
        String d2 = d("ro.rom.version", "");
        if (a(d2)) {
            return "";
        }
        if (d2.startsWith("H2OS")) {
            return d2;
        }
        return "H2OS " + d2;
    }

    private static String J() {
        String d2 = d("ro.build.sense.version", "");
        if (a(d2)) {
            return "";
        }
        if (d2.startsWith("HTC Sense")) {
            return d2;
        }
        return "HTC Sense " + d2;
    }

    public static String e() {
        return d("hw_sc.build.platform.version", "");
    }

    public static String f() {
        return d("ro.huawei.build.display.id", "");
    }

    private static String K() {
        return d("ro.build.display.id", "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x028c, code lost:
        if ((!a(d("ro.sony.irremote.protocol_type", "")) || d("ro.product.manufacturer", "").contains("Sony")) != false) goto L_0x0291;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g() {
        /*
            boolean r0 = d()
            java.lang.String r1 = "ro.build.display.id"
            r2 = 0
            r3 = 1
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = "ro.build.version.emui"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r5 = a((java.lang.String) r0)
            if (r5 == 0) goto L_0x001a
            goto L_0x028f
        L_0x001a:
            java.lang.String r5 = "EMUI"
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L_0x0295
            java.lang.String r5 = "_"
            java.lang.String[] r0 = r0.split(r5)
            int r5 = r0.length
            int r5 = r5 - r3
            r0 = r0[r5]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "EMUI "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            goto L_0x0295
        L_0x003c:
            boolean r0 = n()
            java.lang.String r5 = "v"
            if (r0 == 0) goto L_0x00c0
            java.lang.String r0 = "ro.build.version.incremental"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r6 = a((java.lang.String) r0)
            if (r6 != 0) goto L_0x0295
            java.lang.String r6 = "MIUI"
            boolean r6 = r0.startsWith(r6)
            if (r6 != 0) goto L_0x0295
            java.lang.String r6 = "V"
            boolean r6 = r0.startsWith(r6)
            if (r6 != 0) goto L_0x0066
            boolean r5 = r0.startsWith(r5)
            if (r5 == 0) goto L_0x006a
        L_0x0066:
            java.lang.String r0 = r0.substring(r3)
        L_0x006a:
            java.lang.String r5 = "."
            int r5 = r0.lastIndexOf(r5)
            r6 = -1
            if (r5 == r6) goto L_0x00b0
            int r6 = r5 + 1
            java.lang.String r6 = r0.substring(r6)
            boolean r7 = a((java.lang.String) r6)
            if (r7 != 0) goto L_0x00b0
            boolean r7 = a((java.lang.String) r6)
            if (r7 == 0) goto L_0x0087
            r7 = r2
            goto L_0x0091
        L_0x0087:
            java.util.regex.Pattern r7 = n
            java.util.regex.Matcher r7 = r7.matcher(r6)
            boolean r7 = r7.matches()
        L_0x0091:
            if (r7 != 0) goto L_0x00b0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = r0.substring(r2, r5)
            r7.append(r0)
            java.lang.String r0 = "("
            r7.append(r0)
            r7.append(r6)
            java.lang.String r0 = ")"
            r7.append(r0)
            java.lang.String r0 = r7.toString()
        L_0x00b0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "MIUI "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            goto L_0x0295
        L_0x00c0:
            java.lang.String r0 = "ro.build.version.opporom"
            java.lang.String r6 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r6 = a((java.lang.String) r6)
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x00f1
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r5 = a((java.lang.String) r0)
            if (r5 == 0) goto L_0x00d9
            goto L_0x028f
        L_0x00d9:
            java.lang.String r5 = "ColorOs"
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L_0x0295
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "ColorOs "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            goto L_0x0295
        L_0x00f1:
            java.lang.String r0 = "ro.vivo.os.version"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r0 = a((java.lang.String) r0)
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0106
            java.lang.String r0 = "ro.vivo.os.build.display.id"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            goto L_0x0295
        L_0x0106:
            java.lang.String r0 = "ro.smartisan.version"
            java.lang.String r6 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r6 = a((java.lang.String) r6)
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x0151
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r6 = a((java.lang.String) r0)
            if (r6 == 0) goto L_0x011f
            goto L_0x028f
        L_0x011f:
            java.lang.String r6 = "-"
            java.lang.String[] r0 = r0.split(r6)
            r0 = r0[r2]
            java.lang.String r6 = "smartisan os"
            boolean r6 = r0.startsWith(r6)
            if (r6 != 0) goto L_0x0295
            boolean r6 = r0.startsWith(r5)
            if (r6 != 0) goto L_0x0141
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
        L_0x0141:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "smartisan os "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            goto L_0x0295
        L_0x0151:
            java.lang.String r0 = "ro.build.nubia.rom.name"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r0 = a((java.lang.String) r0)
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0184
            java.lang.String r0 = "ro.build.rom.id"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r5 = a((java.lang.String) r0)
            if (r5 == 0) goto L_0x016c
            goto L_0x028f
        L_0x016c:
            java.lang.String r5 = "nubia UI"
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L_0x0295
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "nubia UI "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            goto L_0x0295
        L_0x0184:
            java.lang.String r0 = d((java.lang.String) r1, (java.lang.String) r4)
            java.lang.String r0 = r0.toUpperCase()
            java.lang.String r5 = "ONEPLUS"
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x01ba
            java.lang.String r0 = "ro.rom.version"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r5 = a((java.lang.String) r0)
            if (r5 == 0) goto L_0x01a2
            goto L_0x028f
        L_0x01a2:
            java.lang.String r5 = "H2OS"
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L_0x0295
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "H2OS "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            goto L_0x0295
        L_0x01ba:
            java.lang.String r0 = "htc.build.stage"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r0 = a((java.lang.String) r0)
            java.lang.String r5 = "ro.product.manufacturer"
            if (r0 == 0) goto L_0x01db
            java.lang.String r0 = d((java.lang.String) r5, (java.lang.String) r4)
            java.lang.String r0 = r0.toUpperCase()
            java.lang.String r6 = "HTC"
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            r0 = r2
            goto L_0x01dc
        L_0x01db:
            r0 = r3
        L_0x01dc:
            if (r0 == 0) goto L_0x0204
            java.lang.String r0 = "ro.build.sense.version"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r5 = a((java.lang.String) r0)
            if (r5 == 0) goto L_0x01ec
            goto L_0x028f
        L_0x01ec:
            java.lang.String r5 = "HTC Sense"
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L_0x0295
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "HTC Sense "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            goto L_0x0295
        L_0x0204:
            java.lang.String r0 = d((java.lang.String) r1, (java.lang.String) r4)
            java.lang.String r0 = r0.toUpperCase()
            java.lang.String r6 = "FLYME"
            boolean r0 = r0.contains(r6)
            if (r0 != 0) goto L_0x0291
            java.lang.String r0 = "ro.lenovo.series"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r0 = a((java.lang.String) r0)
            r0 = r0 ^ r3
            if (r0 != 0) goto L_0x0291
            java.lang.String r0 = d((java.lang.String) r1, (java.lang.String) r4)
            java.lang.String r6 = "QIKU"
            boolean r6 = r0.contains(r6)
            if (r6 != 0) goto L_0x0238
            java.lang.String r6 = "360"
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x0236
            goto L_0x0238
        L_0x0236:
            r0 = r2
            goto L_0x0239
        L_0x0238:
            r0 = r3
        L_0x0239:
            if (r0 != 0) goto L_0x0291
            java.lang.String r0 = d((java.lang.String) r5, (java.lang.String) r4)
            java.lang.String r6 = "samsung"
            boolean r0 = r0.contains(r6)
            if (r0 != 0) goto L_0x0291
            java.lang.String r0 = d((java.lang.String) r5, (java.lang.String) r4)
            java.lang.String r0 = r0.toUpperCase()
            java.lang.String r6 = "ZTE"
            boolean r0 = r0.contains(r6)
            if (r0 != 0) goto L_0x0291
            java.lang.String r0 = "ro.yulong.version.release"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r0 = a((java.lang.String) r0)
            r0 = r0 ^ r3
            if (r0 != 0) goto L_0x0291
            java.lang.String r0 = d((java.lang.String) r5, (java.lang.String) r4)
            java.lang.String r6 = "Gree"
            boolean r0 = r0.contains(r6)
            if (r0 != 0) goto L_0x0291
            java.lang.String r0 = "ro.sony.irremote.protocol_type"
            java.lang.String r0 = d((java.lang.String) r0, (java.lang.String) r4)
            boolean r0 = a((java.lang.String) r0)
            if (r0 == 0) goto L_0x028b
            java.lang.String r0 = d((java.lang.String) r5, (java.lang.String) r4)
            java.lang.String r5 = "Sony"
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x0289
            goto L_0x028b
        L_0x0289:
            r0 = r2
            goto L_0x028c
        L_0x028b:
            r0 = r3
        L_0x028c:
            if (r0 == 0) goto L_0x028f
            goto L_0x0291
        L_0x028f:
            r0 = r4
            goto L_0x0295
        L_0x0291:
            java.lang.String r0 = d((java.lang.String) r1, (java.lang.String) r4)
        L_0x0295:
            boolean r5 = a((java.lang.String) r0)
            if (r5 == 0) goto L_0x02cb
            java.lang.String r0 = d((java.lang.String) r1, (java.lang.String) r4)
            com.bonree.sdk.be.f r1 = com.bonree.sdk.be.a.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "get manufacturer os version from ro.build.display.id:"
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r1.d(r4, r5)
            boolean r1 = a((java.lang.String) r0)
            if (r1 == 0) goto L_0x02cb
            java.lang.String r0 = android.os.Build.DISPLAY
            com.bonree.sdk.be.f r1 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r0
            java.lang.String r2 = "get manufacturer os version from Build.DISPLAY:%s"
            r1.d(r2, r3)
        L_0x02cb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.g():java.lang.String");
    }

    public static boolean k(String str) {
        return o.matcher(str).matches();
    }

    public static long a(double d2, double d3) {
        return new BigDecimal(d2).setScale(20, 4).multiply(new BigDecimal(1.0d)).longValue();
    }

    private static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return (!str.contains("::") || !str.contains(".") || !str.startsWith("::ffff:")) ? str : str.replace("::ffff:", "");
    }

    private static String t(String str) {
        if (str == null) {
            return null;
        }
        try {
            URL url = new URL(str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(url.getProtocol());
            stringBuffer.append("://");
            stringBuffer.append(url.getHost());
            if (url.getPort() != -1) {
                stringBuffer.append(":");
                stringBuffer.append(url.getPort());
            }
            stringBuffer.append(url.getPath());
            return stringBuffer.toString();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0026 A[Catch:{ all -> 0x0049 }, LOOP:0: B:6:0x0026->B:9:0x002f, LOOP_START, PHI: r4 
      PHI: (r4v1 int) = (r4v0 int), (r4v3 int) binds: [B:5:?, B:9:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String l(java.lang.String r6) {
        /*
            boolean r0 = a((java.lang.String) r6)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = "/"
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            int r6 = r0.indexOf(r6)     // Catch:{ all -> 0x0049 }
            java.util.regex.Pattern r2 = l     // Catch:{ all -> 0x0049 }
            java.util.regex.Matcher r2 = r2.matcher(r0)     // Catch:{ all -> 0x0049 }
            r3 = 0
            r4 = r3
        L_0x0026:
            boolean r5 = r2.find()     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0031
            int r4 = r4 + 1
            r5 = 3
            if (r4 != r5) goto L_0x0026
        L_0x0031:
            if (r4 != 0) goto L_0x0034
            goto L_0x0038
        L_0x0034:
            int r3 = r2.start()     // Catch:{ all -> 0x0049 }
        L_0x0038:
            if (r3 <= 0) goto L_0x0049
            int r6 = r6 + 2
            if (r3 < r6) goto L_0x0049
            int r2 = r0.length()     // Catch:{ all -> 0x0049 }
            if (r3 >= r2) goto L_0x0049
            java.lang.String r6 = r0.substring(r6, r3)     // Catch:{ all -> 0x0049 }
            return r6
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.l(java.lang.String):java.lang.String");
    }

    public static void h() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
                declaredField.setAccessible(true);
                declaredField.setBoolean(invoke, true);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean m(String str) {
        PackageManager packageManager;
        try {
            Context a2 = a.a();
            if (a2 == null || (packageManager = a2.getPackageManager()) == null || packageManager.checkPermission(str, a2.getPackageName()) == -1) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    public static ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            if (Build.VERSION.SDK_INT >= 25 && z) {
                arrayList.addAll(a(a.a()));
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(L());
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private static ArrayList<String> a(Context context) {
        List<InetAddress> dnsServers;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 21) {
                for (Network network : connectivityManager.getAllNetworks()) {
                    if (connectivityManager.getNetworkInfo(network).isConnected() && (dnsServers = connectivityManager.getLinkProperties(network).getDnsServers()) != null) {
                        for (InetAddress hostAddress : dnsServers) {
                            arrayList.add(hostAddress.getHostAddress());
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private static ArrayList<String> L() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 1; i2 <= 4; i2++) {
            String d2 = d("net.dns" + i2, "");
            if (!".0.0.0".equals(d2) && ((d2.matches("^\\d+(\\.\\d+){3}$") || d2.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(d2))) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    public static String d(String str, String str2) {
        if (a(str)) {
            return str2;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", new Class[]{String.class, String.class});
            method.setAccessible(true);
            return (String) method.invoke(cls, new Object[]{str, str2});
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("get system property exception", th);
            return str2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        com.bonree.sdk.be.a.a().e("check permission is error:  %s", r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0027
            r1 = 1
            boolean r2 = a((java.lang.String) r4)     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x0027
            android.content.pm.PackageManager r2 = r3.getPackageManager()     // Catch:{ all -> 0x001a }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x001a }
            int r3 = r2.checkPermission(r4, r3)     // Catch:{ all -> 0x001a }
            if (r3 != 0) goto L_0x0019
            return r1
        L_0x0019:
            return r0
        L_0x001a:
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = "check permission is error:  %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0027 }
            r1[r0] = r4     // Catch:{ all -> 0x0027 }
            r3.e(r2, r1)     // Catch:{ all -> 0x0027 }
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.a(android.content.Context, java.lang.String):boolean");
    }

    public static String a(WebResourceError webResourceError, WebResourceRequest webResourceRequest) {
        Integer num;
        CharSequence charSequence;
        if (webResourceError == null && webResourceRequest == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (webResourceError == null) {
                num = "";
            } else {
                num = Integer.valueOf(webResourceError.getErrorCode());
            }
            Objects.toString(num);
            if (webResourceError == null) {
                charSequence = "";
            } else {
                charSequence = webResourceError.getDescription();
            }
            sb.append(charSequence);
            if (webResourceRequest != null) {
                a(webResourceRequest.getRequestHeaders());
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String next : map.keySet()) {
                sb.append(next);
                sb.append(":");
                sb.append(map.get(next));
                sb.append(HTTP.CRLF);
            }
            sb.append("\r\n\r\n");
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return "";
        }
        try {
            AtomicReference atomicReference = new AtomicReference(new StringBuilder());
            StringBuilder sb = (StringBuilder) atomicReference.get();
            sb.append(webResourceResponse.getStatusCode());
            sb.append(" ");
            sb.append(webResourceResponse.getReasonPhrase());
            sb.append(HTTP.CRLF);
            sb.append(a(webResourceResponse.getResponseHeaders()));
            return atomicReference.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static List<String> n(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a(str, g.k().i()));
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    private static List<String> a(String str, Set<String> set) {
        f a2 = com.bonree.sdk.be.a.a();
        a2.c("javaDNS: domain -> " + str + ", ns:" + set, new Object[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!(str == null || set == null)) {
            if (set.isEmpty()) {
                set.add("114.114.114.114");
            }
            c cVar = new c();
            cVar.a(a.C0017a.udpTcp);
            for (String next : set) {
                f a3 = com.bonree.sdk.be.a.a();
                a3.c("javaDNS: use " + next + " to resolver", new Object[0]);
                try {
                    d c2 = cVar.a(com.bonree.sdk.bj.a.f().a(new com.bonree.sdk.bj.c((CharSequence) str, v.b.A)).a(new Random().nextInt()).c(true).b(true).a(a.b.QUERY).a(a.c.NO_ERROR).a(false).b(), InetAddress.getByName(next), b);
                    if (c2 == null) {
                        continue;
                    } else {
                        if (c2.a.c == a.c.NO_ERROR) {
                            for (v next2 : c2.a.l) {
                                if (next2.b == v.b.CNAME) {
                                    String obj = next2.f.toString();
                                    if (!obj.isEmpty()) {
                                        if (obj.endsWith(".")) {
                                            obj = obj.substring(0, obj.length() - 1);
                                        }
                                        arrayList.add(obj);
                                    }
                                }
                            }
                            f a4 = com.bonree.sdk.be.a.a();
                            a4.c("javaDNS: resolver ok, cnameList:" + arrayList, new Object[0]);
                            return arrayList;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            com.bonree.sdk.be.a.a().c("javaDNS: miss", new Object[0]);
        }
        return arrayList;
    }

    private static com.bonree.sdk.bj.a a(com.bonree.sdk.bj.c cVar) {
        return com.bonree.sdk.bj.a.f().a(cVar).a(new Random().nextInt()).c(true).b(true).a(a.b.QUERY).a(a.c.NO_ERROR).a(false).b();
    }

    private static Field d(Class<?> cls, Class<?> cls2) {
        Field[] declaredFields;
        if (cls == null || cls2 == null || (declaredFields = cls.getDeclaredFields()) == null || declaredFields.length == 0) {
            return null;
        }
        for (Field field : declaredFields) {
            if (field.getType().equals(cls2)) {
                return field;
            }
        }
        return null;
    }

    private static Field e(Class<?> cls, Class<?> cls2) {
        Field[] fields;
        if (cls == null || cls2 == null || (fields = cls.getFields()) == null || fields.length == 0) {
            return null;
        }
        for (Field field : fields) {
            if (field.getType().equals(cls2)) {
                return field;
            }
        }
        return null;
    }

    private static long b(long j2) {
        return (j2 - System.currentTimeMillis()) + SystemClock.uptimeMillis();
    }

    public static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            if (!(obj instanceof List)) {
                return o(obj.toString());
            }
            List list = (List) obj;
            if (list.size() == 1) {
                return o(list.get(0).toString());
            }
            return o(Arrays.toString(list.toArray()));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return android.net.Uri.decode(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o(java.lang.String r1) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = java.net.URLDecoder.decode(r1, r0)     // Catch:{ all -> 0x0007 }
            goto L_0x000b
        L_0x0007:
            java.lang.String r1 = android.net.Uri.decode(r1)     // Catch:{ all -> 0x000b }
        L_0x000b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.o(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return android.net.Uri.encode(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String p(java.lang.String r1) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r0)     // Catch:{ all -> 0x0007 }
            goto L_0x000b
        L_0x0007:
            java.lang.String r1 = android.net.Uri.encode(r1)     // Catch:{ all -> 0x000b }
        L_0x000b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.p(java.lang.String):java.lang.String");
    }

    public static String b(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (Map.Entry next : map.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), (String) next.getValue());
            } catch (JSONException unused) {
            }
        }
        sb.append(jSONObject.toString());
        return sb.toString();
    }

    public static String c(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int size = map.size();
            int i2 = 0;
            for (Map.Entry next : map.entrySet()) {
                i2++;
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
                if (i2 != size) {
                    sb.append("&");
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.contains(".") ? str.substring(str.lastIndexOf(".") + 1) : str;
    }

    public static String d(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (str != null && value != null && !(value instanceof String) && !(value instanceof Number)) {
                value = value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString();
            }
            try {
                jSONObject.put(str, value);
            } catch (JSONException unused) {
            }
        }
        sb.append(jSONObject.toString());
        return sb.toString();
    }

    public static String i() {
        if (Build.VERSION.SDK_INT >= 21) {
            return TextUtils.join(",", Build.SUPPORTED_ABIS);
        }
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "," + str2;
    }

    public static String j() {
        String str;
        if (n()) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Method declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
                str = (String) declaredMethod.invoke(cls, new Object[]{"ro.product.marketname", ""});
                try {
                    if (TextUtils.isEmpty(str)) {
                        str = (String) declaredMethod.invoke(cls, new Object[]{"ro.product.model", ""});
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str = "";
            }
        } else {
            str = Build.MODEL;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement valueOf : stackTrace) {
                String valueOf2 = String.valueOf(valueOf);
                if (stringBuffer.length() + valueOf2.length() >= k) {
                    break;
                }
                stringBuffer.append("at ");
                stringBuffer.append(valueOf2);
                stringBuffer.append(HTTP.CRLF);
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.getClass().getSimpleName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return "Caused by: " + th.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static class a {
        private static int a = -1;
        private static int b;
        private static ConnectivityManager c;

        public static String a(int i) {
            switch (i) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "CDMA - EvDo rev. 0";
                case 6:
                    return "CDMA - EvDo rev. A";
                case 7:
                    return "CDMA - 1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDEN";
                case 12:
                    return "CDMA - EvDo rev. B";
                case 13:
                    return "LTE";
                case 14:
                    return "CDMA - eHRPD";
                case 15:
                    return "HSPA+";
                case 16:
                    return "GSM";
                case 17:
                    return "TD_SCDMA";
                case 18:
                    return "IWLAN";
                case 19:
                    return "LTE_CA";
                case 20:
                    return "NR";
                default:
                    return "UNKNOWN";
            }
        }

        public static String b(int i) {
            switch (i) {
                case 1:
                    return "GSM";
                case 2:
                    return "CDMA - 1xRTT";
                case 3:
                    return "UMTS";
                case 4:
                    return "HSPA";
                case 5:
                    return "HSPA+";
                case 6:
                    return "TD_SCDMA";
                case 7:
                    return "CDMA - EvDo rev. 0";
                case 8:
                    return "CDMA - eHRPD";
                case 9:
                    return "LTE";
                case 10:
                    return "LTE_CA";
                case 11:
                    return "IWLAN";
                case 12:
                    return "NR";
                default:
                    return "UNKNOWN";
            }
        }

        public static String a() {
            if (c == null) {
                c = (ConnectivityManager) a.a().getSystemService("connectivity");
            }
            if (ad.a(a.a(), "android.permission.ACCESS_NETWORK_STATE")) {
                if (Build.VERSION.SDK_INT < 24 || !ad.a(a.a(), "android.permission.READ_PHONE_STATE")) {
                    NetworkInfo activeNetworkInfo = c.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        if (activeNetworkInfo.getType() == 1) {
                            return "WiFi";
                        }
                        if (!ad.a(activeNetworkInfo.getSubtypeName())) {
                            return activeNetworkInfo.getSubtypeName();
                        }
                        f a2 = com.bonree.sdk.be.a.a();
                        a2.c(ad.a + " standard exception. type=" + activeNetworkInfo.getType() + " standard=" + activeNetworkInfo.getSubtypeName(), new Object[0]);
                        return "NaN";
                    }
                } else {
                    int b2 = b();
                    if (b2 == -1) {
                        return "NaN";
                    }
                    if (b2 == 0) {
                        return "WiFi";
                    }
                    return a(b2);
                }
            }
            return "NaN";
        }

        public static int b() {
            if (!ad.a(a.a(), "android.permission.READ_PHONE_STATE")) {
                return -1;
            }
            if (c == null) {
                c = (ConnectivityManager) a.a().getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = c;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            TelephonyManager telephonyManager = (TelephonyManager) a.a().getSystemService("phone");
            if (!(networkCapabilities == null || telephonyManager == null)) {
                if (networkCapabilities.hasTransport(1)) {
                    return 0;
                }
                if (networkCapabilities.hasTransport(0)) {
                    int dataNetworkType = telephonyManager.getDataNetworkType();
                    if (dataNetworkType == 20) {
                        return dataNetworkType;
                    }
                    int c2 = c(dataNetworkType);
                    if (c2 == 0) {
                        return -2;
                    }
                    return c2;
                }
            }
            return -1;
        }

        private static int c(int i) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (ad.d()) {
                    i = b(a.a());
                }
                f a2 = com.bonree.sdk.be.a.a();
                a2.c(ad.a + " check5GNetworknetWorkType " + i, new Object[0]);
                if (i == 20) {
                    return i;
                }
                if (i == 0 || i == 13) {
                    i = a(a.a());
                }
                f a3 = com.bonree.sdk.be.a.a();
                a3.c(ad.a + " check5GNetwork: netWorkType3 " + i, new Object[0]);
            } else {
                f a4 = com.bonree.sdk.be.a.a();
                a4.c(ad.a + " check5GNetwork: SDK_INT < SDK_VERSION_Q", new Object[0]);
            }
            return i;
        }

        private static int a(Context context) {
            int i = 0;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                int c2 = c();
                if (c2 == -1) {
                    i = telephonyManager.getNetworkType();
                } else {
                    Object a2 = z.a(telephonyManager, "android.telephony.TelephonyManager", "getDataNetworkType", new Class[]{Integer.TYPE}, Integer.valueOf(c2));
                    if (a2 instanceof Integer) {
                        i = ((Integer) a2).intValue();
                    }
                    if (i == 0) {
                        i = telephonyManager.getNetworkType();
                    }
                }
            } catch (Throwable unused) {
            }
            return i == 13 ? a(context, i) : i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.telephony.ServiceState} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int a(android.content.Context r8, int r9) {
            /*
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x006b }
                r1 = 24
                if (r0 < r1) goto L_0x006b
                java.lang.String r0 = "android.permission.READ_PHONE_STATE"
                int r0 = r8.checkSelfPermission(r0)     // Catch:{ all -> 0x006b }
                if (r0 != 0) goto L_0x006b
                java.lang.String r0 = "phone"
                java.lang.Object r8 = r8.getSystemService(r0)     // Catch:{ all -> 0x006b }
                android.telephony.TelephonyManager r8 = (android.telephony.TelephonyManager) r8     // Catch:{ all -> 0x006b }
                r0 = 0
                int r1 = c()     // Catch:{ all -> 0x006b }
                r2 = -1
                r3 = 0
                r4 = 1
                if (r1 != r2) goto L_0x0025
                android.telephony.ServiceState r8 = r8.getServiceState()     // Catch:{ all -> 0x006b }
                goto L_0x004a
            L_0x0025:
                java.lang.String r2 = "android.telephony.TelephonyManager"
                java.lang.String r5 = "getServiceStateForSubscriber"
                java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ all -> 0x006b }
                java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x006b }
                r6[r3] = r7     // Catch:{ all -> 0x006b }
                java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x006b }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x006b }
                r7[r3] = r1     // Catch:{ all -> 0x006b }
                java.lang.Object r1 = com.bonree.sdk.bs.z.a(r8, r2, r5, r6, r7)     // Catch:{ all -> 0x006b }
                boolean r2 = r1 instanceof android.telephony.ServiceState     // Catch:{ all -> 0x006b }
                if (r2 == 0) goto L_0x0042
                r0 = r1
                android.telephony.ServiceState r0 = (android.telephony.ServiceState) r0     // Catch:{ all -> 0x006b }
            L_0x0042:
                if (r0 != 0) goto L_0x0049
                android.telephony.ServiceState r8 = r8.getServiceState()     // Catch:{ all -> 0x006b }
                goto L_0x004a
            L_0x0049:
                r8 = r0
            L_0x004a:
                if (r8 == 0) goto L_0x006b
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x006b }
                boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x006b }
                if (r0 != 0) goto L_0x0067
                java.lang.String r0 = "nrState=NOT_RESTRICTED"
                boolean r0 = r8.contains(r0)     // Catch:{ all -> 0x006b }
                if (r0 != 0) goto L_0x0066
                java.lang.String r0 = "nrState=CONNECTED"
                boolean r8 = r8.contains(r0)     // Catch:{ all -> 0x006b }
                if (r8 == 0) goto L_0x0067
            L_0x0066:
                r3 = r4
            L_0x0067:
                if (r3 == 0) goto L_0x006b
                r9 = 20
            L_0x006b:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.a.a(android.content.Context, int):int");
        }

        private static boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
        }

        private static int c() {
            if (Build.VERSION.SDK_INT >= 24) {
                return SubscriptionManager.getDefaultDataSubscriptionId();
            }
            return -1;
        }

        private static int b(Context context) {
            ServiceState serviceState;
            try {
                if (!ad.a(context, "android.permission.READ_PHONE_STATE")) {
                    return 0;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                int defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
                if (defaultDataSubscriptionId < 0) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, new Object[]{Integer.valueOf(defaultDataSubscriptionId)});
                }
                Method method = ServiceState.class.getMethod("getHwNetworkType", new Class[0]);
                method.setAccessible(true);
                Integer num = (Integer) method.invoke(serviceState, new Object[0]);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            } catch (Throwable th) {
                f a2 = com.bonree.sdk.be.a.a();
                a2.e(ad.a + " netStateChange: getHwNetworkType " + th, new Object[0]);
                return 0;
            }
        }
    }

    public static long a(double d2) {
        try {
            return Double.valueOf(d2).longValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int b(double d2) {
        try {
            return Double.valueOf(d2).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static double a(long j2, long j3, int i2) {
        if (i2 >= 0) {
            return new BigDecimal(Long.toString(j2)).divide(new BigDecimal(Long.toString(j3)), i2, 7).doubleValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static boolean k() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean l() {
        if (k()) {
            return Agent.IS_HAP || q.a() != null;
        }
        return false;
    }

    public static String a(ResourceError resourceError, ResourceRequest resourceRequest) {
        Integer num;
        CharSequence charSequence;
        if (resourceError == null && resourceRequest == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (resourceError == null) {
                num = "";
            } else {
                num = Integer.valueOf(resourceError.getErrorCode());
            }
            Objects.toString(num);
            if (resourceError == null) {
                charSequence = "";
            } else {
                charSequence = resourceError.getInfo();
            }
            sb.append(charSequence);
            if (resourceRequest != null) {
                a((Map<String, String>) resourceRequest.getHeaders());
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|(1:14)(0)|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        if (r6 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0098, code lost:
        if (r6 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009a, code lost:
        r6.exitValue();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085 A[SYNTHETIC, Splitter:B:34:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095 A[SYNTHETIC, Splitter:B:45:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.util.List<java.lang.String> r6) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0092, all -> 0x0081 }
            int r3 = r6.size()     // Catch:{ IOException -> 0x0092, all -> 0x0081 }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ IOException -> 0x0092, all -> 0x0081 }
            java.lang.Object[] r6 = r6.toArray(r3)     // Catch:{ IOException -> 0x0092, all -> 0x0081 }
            java.lang.String[] r6 = (java.lang.String[]) r6     // Catch:{ IOException -> 0x0092, all -> 0x0081 }
            java.lang.Process r6 = r2.exec(r6)     // Catch:{ IOException -> 0x0092, all -> 0x0081 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0093, all -> 0x007f }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0093, all -> 0x007f }
            java.io.InputStream r4 = r6.getInputStream()     // Catch:{ IOException -> 0x0093, all -> 0x007f }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0093, all -> 0x007f }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0093, all -> 0x007f }
            java.io.InputStream r1 = r6.getErrorStream()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            java.lang.String r3 = "\n"
            if (r1 == 0) goto L_0x0053
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            java.io.InputStream r4 = r6.getErrorStream()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            r1.<init>(r4)     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            r4.<init>(r1)     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            r1.<init>()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
        L_0x0043:
            java.lang.String r5 = r4.readLine()     // Catch:{ all -> 0x0050 }
            if (r5 == 0) goto L_0x0050
            r1.append(r5)     // Catch:{ all -> 0x0050 }
            r1.append(r3)     // Catch:{ all -> 0x0050 }
            goto L_0x0043
        L_0x0050:
            r4.close()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
        L_0x0053:
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            if (r1 == 0) goto L_0x0069
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            r4.<init>(r3)     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            r4.append(r1)     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            r0.append(r1)     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            goto L_0x0053
        L_0x0069:
            int r1 = r0.length()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            if (r1 <= 0) goto L_0x0074
            r1 = 0
            r3 = 1
            r0.delete(r1, r3)     // Catch:{ IOException -> 0x007d, all -> 0x007a }
        L_0x0074:
            r2.close()     // Catch:{ all -> 0x009e }
            if (r6 == 0) goto L_0x00a1
            goto L_0x009a
        L_0x007a:
            r0 = move-exception
            r1 = r2
            goto L_0x0083
        L_0x007d:
            r1 = r2
            goto L_0x0093
        L_0x007f:
            r0 = move-exception
            goto L_0x0083
        L_0x0081:
            r0 = move-exception
            r6 = r1
        L_0x0083:
            if (r1 == 0) goto L_0x0088
            r1.close()     // Catch:{ all -> 0x008e }
        L_0x0088:
            if (r6 == 0) goto L_0x0091
            r6.exitValue()     // Catch:{ all -> 0x008e }
            goto L_0x0091
        L_0x008e:
            r6.destroy()
        L_0x0091:
            throw r0
        L_0x0092:
            r6 = r1
        L_0x0093:
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ all -> 0x009e }
        L_0x0098:
            if (r6 == 0) goto L_0x00a1
        L_0x009a:
            r6.exitValue()     // Catch:{ all -> 0x009e }
            goto L_0x00a1
        L_0x009e:
            r6.destroy()
        L_0x00a1:
            java.lang.String r6 = r0.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.a(java.util.List):java.lang.String");
    }

    private static boolean b(CharSequence charSequence) {
        return !(TextUtils.isEmpty(charSequence) || charSequence.toString().trim().length() == 0);
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0)) {
            for (String str : strArr) {
                if (!a(str) && !a(str, (String[]) null) && a(str, strArr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Field c(java.lang.Class<?> r7, java.lang.Class<?> r8) {
        /*
            r0 = 0
            r1 = 0
            if (r7 == 0) goto L_0x0025
            if (r8 != 0) goto L_0x0007
            goto L_0x0025
        L_0x0007:
            java.lang.reflect.Field[] r2 = r7.getDeclaredFields()
            if (r2 == 0) goto L_0x0025
            int r3 = r2.length
            if (r3 != 0) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            int r3 = r2.length
            r4 = r0
        L_0x0013:
            if (r4 >= r3) goto L_0x0025
            r5 = r2[r4]
            java.lang.Class r6 = r5.getType()
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0025:
            r5 = r1
        L_0x0026:
            if (r5 != 0) goto L_0x004c
            if (r7 == 0) goto L_0x004d
            if (r8 != 0) goto L_0x002d
            goto L_0x004d
        L_0x002d:
            java.lang.reflect.Field[] r7 = r7.getFields()
            if (r7 == 0) goto L_0x004d
            int r2 = r7.length
            if (r2 != 0) goto L_0x0037
            goto L_0x004d
        L_0x0037:
            int r2 = r7.length
        L_0x0038:
            if (r0 >= r2) goto L_0x004b
            r3 = r7[r0]
            java.lang.Class r4 = r3.getType()
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0048
            r1 = r3
            goto L_0x004b
        L_0x0048:
            int r0 = r0 + 1
            goto L_0x0038
        L_0x004b:
            return r1
        L_0x004c:
            r1 = r5
        L_0x004d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.ad.c(java.lang.Class, java.lang.Class):java.lang.reflect.Field");
    }
}
