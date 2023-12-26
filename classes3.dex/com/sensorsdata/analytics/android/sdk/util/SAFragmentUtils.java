package com.sensorsdata.analytics.android.sdk.util;

public class SAFragmentUtils {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0058 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isFragmentVisible(java.lang.Object r4) {
        /*
            r0 = 0
            java.lang.Class r1 = r4.getClass()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r2 = "getParentFragment"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0014 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ Exception -> 0x0014 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0014 }
            java.lang.Object r1 = r1.invoke(r4, r2)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0019
        L_0x0014:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            r1 = 0
        L_0x0019:
            r2 = 1
            if (r1 != 0) goto L_0x002f
            boolean r1 = fragmentIsHidden(r4)     // Catch:{ Exception -> 0x0054 }
            if (r1 != 0) goto L_0x0058
            boolean r1 = fragmentGetUserVisibleHint(r4)     // Catch:{ Exception -> 0x0054 }
            if (r1 == 0) goto L_0x0058
            boolean r4 = fragmentIsResumed(r4)     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0058
            return r2
        L_0x002f:
            boolean r3 = fragmentIsHidden(r4)     // Catch:{ Exception -> 0x0054 }
            if (r3 != 0) goto L_0x0058
            boolean r3 = fragmentGetUserVisibleHint(r4)     // Catch:{ Exception -> 0x0054 }
            if (r3 == 0) goto L_0x0058
            boolean r4 = fragmentIsResumed(r4)     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0058
            boolean r4 = fragmentIsHidden(r1)     // Catch:{ Exception -> 0x0054 }
            if (r4 != 0) goto L_0x0058
            boolean r4 = fragmentGetUserVisibleHint(r1)     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0058
            boolean r4 = fragmentIsResumed(r1)     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0058
            return r2
        L_0x0054:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragmentVisible(java.lang.Object):boolean");
    }

    public static boolean fragmentGetUserVisibleHint(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("getUserVisibleHint", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean fragmentIsHidden(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isHidden", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isFragment(Object obj) {
        Class<?> cls;
        Class<?> cls2;
        if (obj == null) {
            return false;
        }
        Class<?> cls3 = null;
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (Exception unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("androidx.fragment.app.Fragment");
        } catch (Exception unused2) {
            cls2 = null;
        }
        try {
            cls3 = Class.forName("androidx.fragment.app.Fragment");
        } catch (Exception unused3) {
        }
        if (cls2 == null && cls3 == null && cls == null) {
            return false;
        }
        if (cls2 != null) {
            try {
                if (cls2.isInstance(obj)) {
                    return true;
                }
            } catch (Exception unused4) {
            }
        }
        if (cls3 != null && cls3.isInstance(obj)) {
            return true;
        }
        if (cls == null || !cls.isInstance(obj)) {
            return false;
        }
        return true;
    }

    public static boolean fragmentIsResumed(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isResumed", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
