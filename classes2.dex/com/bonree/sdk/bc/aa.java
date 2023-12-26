package com.bonree.sdk.bc;

import com.facebook.soloader.MinElf;

public final class aa {
    private static bc a = null;
    private static int b = 32768;

    static {
        bc bcVar = new bc("EDNS Flag", 3);
        a = bcVar;
        bcVar.b((int) MinElf.PN_XNUM);
        a.a("FLAG");
        a.a(true);
        a.a(32768, "do");
    }

    private aa() {
    }

    private static String a(int i) {
        return a.d(i);
    }

    private static int a(String str) {
        return a.b(str);
    }
}
