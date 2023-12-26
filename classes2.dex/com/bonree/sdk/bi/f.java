package com.bonree.sdk.bi;

public abstract class f extends b {
    protected f(String str) {
        super(str);
    }

    protected static b d(String str) {
        boolean z = false;
        if (str.charAt(0) == '_') {
            z = true;
        }
        if (z) {
            return new j(str);
        }
        if (e.c(str)) {
            return new e(str);
        }
        return new h(str);
    }
}
