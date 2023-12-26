package com.bonree.sdk.bi;

public class i extends d {
    private static /* synthetic */ boolean b = true;

    protected i(String str) {
        super(str);
        if (!b && !f(str)) {
            throw new AssertionError();
        }
    }

    public static boolean e(String str) {
        if (!c(str)) {
            return false;
        }
        return f(str);
    }

    static boolean f(String str) {
        return str.length() >= 4 && str.charAt(2) == '-' && str.charAt(3) == '-';
    }
}
