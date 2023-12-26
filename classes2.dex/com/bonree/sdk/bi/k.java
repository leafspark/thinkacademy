package com.bonree.sdk.bi;

import com.bonree.sdk.bo.c;
import java.util.Locale;

public abstract class k extends i {
    private static /* synthetic */ boolean b = true;

    protected k(String str) {
        super(str);
    }

    protected static d g(String str) {
        if (!b && !str.toLowerCase(Locale.US).startsWith("xn--")) {
            throw new AssertionError();
        } else if (str.equals(c.b(str))) {
            return new c(str);
        } else {
            return new a(str);
        }
    }

    private static boolean i(String str) {
        if (!c(str)) {
            return false;
        }
        return h(str);
    }

    static boolean h(String str) {
        return str.substring(0, 2).toLowerCase(Locale.US).equals("xn");
    }
}
