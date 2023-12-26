package com.bonree.sdk.bi;

public final class e extends f {
    protected e(String str) {
        super(str);
    }

    protected static boolean c(String str) {
        if (str.isEmpty()) {
            return false;
        }
        if (str.charAt(0) == '-' || str.charAt(str.length() - 1) == '-') {
            return true;
        }
        return false;
    }
}
