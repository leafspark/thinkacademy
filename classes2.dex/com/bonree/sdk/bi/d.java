package com.bonree.sdk.bi;

public abstract class d extends b {
    private static /* synthetic */ boolean b = true;

    protected d(String str) {
        super(str);
    }

    public static boolean c(String str) {
        if (str.isEmpty() || e.c(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt < '0' || charAt > '9') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    protected static d d(String str) {
        if (!b && !c(str)) {
            throw new AssertionError();
        } else if (!i.e(str)) {
            return new g(str);
        } else {
            if (k.h(str)) {
                return k.g(str);
            }
            return new i(str);
        }
    }
}
