package com.bonree.sdk.m;

import android.text.TextUtils;
import com.bonree.sdk.be.g;
import com.bonree.sdk.d.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import okhttp3.Request;

public class o {
    private String a;
    private long b;
    private boolean c;

    public o() {
    }

    private static void b(Request request, String str, String str2) throws Exception {
        Field declaredField = request.getClass().getDeclaredField("headers");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(request);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("namesAndValues");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 instanceof String[]) {
                ArrayList arrayList = new ArrayList(Arrays.asList((String[]) obj2));
                int indexOf = arrayList.indexOf(str);
                if (indexOf < 0) {
                    arrayList.add(str);
                    arrayList.add(str2);
                } else {
                    arrayList.set(indexOf + 1, str2);
                }
                declaredField2.set(obj, (String[]) arrayList.toArray(new String[0]));
            }
        }
    }

    private static void b(Request request, String str) throws Exception {
        Field declaredField = request.getClass().getDeclaredField("headers");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(request);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("namesAndValues");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 instanceof String[]) {
                ArrayList arrayList = new ArrayList(Arrays.asList((String[]) obj2));
                arrayList.remove(str);
                arrayList.remove(request.header(str));
                declaredField2.set(obj, (String[]) arrayList.toArray(new String[0]));
            }
        }
    }

    private static void b(Request request, Object obj) throws Exception {
        Field declaredField = request.getClass().getDeclaredField("tags");
        declaredField.setAccessible(true);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Object.class, obj);
        declaredField.set(request, linkedHashMap);
    }

    public static String a() {
        String str;
        try {
            Method declaredMethod = Class.forName("okhttp3.internal.Version").getDeclaredMethod("userAgent", new Class[0]);
            declaredMethod.setAccessible(true);
            str = (String) declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Field declaredField = Class.forName("okhttp3.internal.Version").getDeclaredField("userAgent");
            declaredField.setAccessible(true);
            str = (String) declaredField.get((Object) null);
        } catch (Throwable unused2) {
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Field declaredField2 = Class.forName("okhttp3.OkHttp").getDeclaredField("VERSION");
            declaredField2.setAccessible(true);
            return (String) declaredField2.get((Object) null);
        } catch (Throwable unused3) {
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6 A[Catch:{ all -> 0x0117 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7 A[Catch:{ all -> 0x0117 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b() {
        /*
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "/"
            java.lang.String r3 = "userAgent"
            java.lang.String r4 = "okhttp3.internal.Version"
            r5 = 0
            r6 = 2
            r7 = 0
            r8 = 1
            if (r1 == 0) goto L_0x0056
            java.lang.Class r1 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0044 }
            java.lang.Class[] r9 = new java.lang.Class[r7]     // Catch:{ all -> 0x0044 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r9)     // Catch:{ all -> 0x0044 }
            r1.setAccessible(r8)     // Catch:{ all -> 0x0044 }
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ all -> 0x0044 }
            java.lang.Object r1 = r1.invoke(r5, r9)     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0044 }
            boolean r9 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0044 }
            if (r9 != 0) goto L_0x0056
            com.bonree.sdk.be.f r9 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0044 }
            java.lang.String r10 = "Current okhttp3 version is method: %s"
            java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ all -> 0x0044 }
            r11[r7] = r1     // Catch:{ all -> 0x0044 }
            r9.c(r10, r11)     // Catch:{ all -> 0x0044 }
            java.lang.String[] r1 = r1.split(r2)     // Catch:{ all -> 0x0044 }
            int r9 = r1.length     // Catch:{ all -> 0x0044 }
            if (r9 < r6) goto L_0x0056
            r0 = r1[r8]     // Catch:{ all -> 0x0044 }
            goto L_0x0056
        L_0x0044:
            r1 = move-exception
            com.bonree.sdk.be.f r9 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r10 = new java.lang.Object[r8]
            java.lang.String r1 = r1.getMessage()
            r10[r7] = r1
            java.lang.String r1 = "Okhttp3 version parse Version.userAgent():error %s!"
            r9.d(r1, r10)
        L_0x0056:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x009c
            java.lang.Class r1 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x008a }
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch:{ all -> 0x008a }
            r1.setAccessible(r8)     // Catch:{ all -> 0x008a }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x008a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x008a }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x008a }
            if (r3 != 0) goto L_0x009c
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x008a }
            java.lang.String r4 = "Current okhttp3 version is field: %s"
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x008a }
            r9[r7] = r1     // Catch:{ all -> 0x008a }
            r3.c(r4, r9)     // Catch:{ all -> 0x008a }
            java.lang.String[] r1 = r1.split(r2)     // Catch:{ all -> 0x008a }
            int r2 = r1.length     // Catch:{ all -> 0x008a }
            if (r2 < r6) goto L_0x009c
            r0 = r1[r8]     // Catch:{ all -> 0x008a }
            goto L_0x009c
        L_0x008a:
            r1 = move-exception
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.String r1 = r1.getMessage()
            r3[r7] = r1
            java.lang.String r1 = "Okhttp3 version parse Version.userAgent:error %s!"
            r2.d(r1, r3)
        L_0x009c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x00dd
            java.lang.String r1 = "okhttp3.OkHttp"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = "VERSION"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ all -> 0x00c7 }
            r1.setAccessible(r8)     // Catch:{ all -> 0x00c7 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00c7 }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00c5 }
            java.lang.String r2 = "Current okhttp3 version is VERSION: %s"
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ all -> 0x00c5 }
            r3[r7] = r1     // Catch:{ all -> 0x00c5 }
            r0.c(r2, r3)     // Catch:{ all -> 0x00c5 }
            goto L_0x00dc
        L_0x00c5:
            r0 = move-exception
            goto L_0x00cb
        L_0x00c7:
            r1 = move-exception
            r12 = r1
            r1 = r0
            r0 = r12
        L_0x00cb:
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.String r0 = r0.getMessage()
            r3[r7] = r0
            java.lang.String r0 = "Okhttp3 version parse  okhttp3.OkHttp.VERSION:error %s!"
            r2.d(r0, r3)
        L_0x00dc:
            r0 = r1
        L_0x00dd:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r0.split(r1)     // Catch:{ all -> 0x0117 }
            int r2 = r1.length     // Catch:{ all -> 0x0117 }
            if (r2 >= r6) goto L_0x00e7
            return r7
        L_0x00e7:
            r2 = r1[r7]     // Catch:{ all -> 0x0117 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0117 }
            r1 = r1[r8]     // Catch:{ all -> 0x0117 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0117 }
            r3 = 4
            r4 = 3
            if (r2 >= r3) goto L_0x00fd
            if (r2 < r4) goto L_0x012b
            r3 = 11
            if (r1 < r3) goto L_0x012b
        L_0x00fd:
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0117 }
            java.lang.String r5 = "Current okhttp3 version support eventListener,versionStr %s ,first: %s ,second: %s "
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0117 }
            r4[r7] = r0     // Catch:{ all -> 0x0117 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0117 }
            r4[r8] = r2     // Catch:{ all -> 0x0117 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0117 }
            r4[r6] = r1     // Catch:{ all -> 0x0117 }
            r3.c(r5, r4)     // Catch:{ all -> 0x0117 }
            return r8
        L_0x0117:
            r1 = move-exception
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r3[r7] = r0
            java.lang.String r0 = r1.toString()
            r3[r8] = r0
            java.lang.String r0 = "Current okhttp3 version not support EventListener supportVersion ,versionStr %s parse:error %s!"
            r2.d(r0, r3)
        L_0x012b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.m.o.b():boolean");
    }

    public static void a(Request request, String str, String str2) {
        try {
            Field declaredField = request.getClass().getDeclaredField("headers");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(request);
            if (obj != null) {
                Field declaredField2 = obj.getClass().getDeclaredField("namesAndValues");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 instanceof String[]) {
                    ArrayList arrayList = new ArrayList(Arrays.asList((String[]) obj2));
                    int indexOf = arrayList.indexOf(str);
                    if (indexOf < 0) {
                        arrayList.add(str);
                        arrayList.add(str2);
                    } else {
                        arrayList.set(indexOf + 1, str2);
                    }
                    declaredField2.set(obj, (String[]) arrayList.toArray(new String[0]));
                }
            }
        } catch (Throwable th) {
            g.b("OkHttp3 Exception addHeader error:" + th);
        }
    }

    public static void a(Request request, String str) {
        try {
            Field declaredField = request.getClass().getDeclaredField("headers");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(request);
            if (obj != null) {
                Field declaredField2 = obj.getClass().getDeclaredField("namesAndValues");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 instanceof String[]) {
                    ArrayList arrayList = new ArrayList(Arrays.asList((String[]) obj2));
                    arrayList.remove(str);
                    arrayList.remove(request.header(str));
                    declaredField2.set(obj, (String[]) arrayList.toArray(new String[0]));
                }
            }
        } catch (Throwable th) {
            g.b("OkHttp3 Exception removeOk3Header error:" + th);
        }
    }

    public static void a(Request request, Object obj) {
        try {
            Field declaredField = request.getClass().getDeclaredField("tags");
            declaredField.setAccessible(true);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(Object.class, obj);
            declaredField.set(request, linkedHashMap);
        } catch (Throwable th) {
            g.b("OkHttp3 Exception addOk3Tag error:" + th);
        }
    }

    public o(String str) {
        this.a = str;
        this.b = a.l();
        this.c = a.k().J();
    }

    public String c() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public long d() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    public boolean e() {
        return this.c;
    }
}
