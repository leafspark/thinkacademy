package com.bonree.sdk.bs;

import ohos.app.Context;

public final class q extends j {
    private static Context a;

    public static Context a() {
        return a;
    }

    public static void a(Context context) {
        if (context != null) {
            a = context;
        }
    }

    private static String c(Context context) {
        if (context != null) {
            return context.getBundleName();
        }
        Context context2 = a;
        return context2 != null ? context2.getBundleName() : "";
    }

    public static boolean b(Context context) {
        String str;
        if (context == null) {
            return false;
        }
        if (context != null) {
            try {
                str = context.getBundleName();
            } catch (Throwable unused) {
            }
        } else {
            Context context2 = a;
            str = context2 != null ? context2.getBundleName() : "";
        }
        if (str != null) {
            if (str.trim().length() != 0) {
                return str.equals(c());
            }
        }
        return false;
    }
}
