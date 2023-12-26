package com.bonree.sdk.bi;

public final class g extends d {
    private static /* synthetic */ boolean b = true;

    protected g(String str) {
        super(str);
        if (!b && !f(str)) {
            throw new AssertionError();
        }
    }

    private static boolean e(String str) {
        if (!c(str)) {
            return false;
        }
        return f(str);
    }

    private static boolean f(String str) {
        return !i.f(str);
    }
}
