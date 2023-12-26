package com.bonree.sdk.br;

public final class j {
    private static Boolean a;

    public static boolean a() {
        if (a == null) {
            try {
                Class.forName("android.Manifest");
                a = Boolean.TRUE;
            } catch (Exception unused) {
                a = Boolean.FALSE;
            }
        }
        return a.booleanValue();
    }
}
