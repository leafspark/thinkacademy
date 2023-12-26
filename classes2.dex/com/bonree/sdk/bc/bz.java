package com.bonree.sdk.bc;

import com.facebook.soloader.MinElf;

public final class bz {
    private static bc a = new bc("DNS Rcode", 2);
    private static bc b = new bc("TSIG rcode", 2);
    private static int c = 0;
    private static int d = 1;
    private static int e = 2;
    private static int f = 3;
    private static int g = 4;
    private static int h = 4;
    private static int i = 5;
    private static int j = 6;
    private static int k = 7;
    private static int l = 8;
    private static int m = 9;
    private static int n = 10;
    private static int o = 16;
    private static int p = 16;
    private static int q = 17;
    private static int r = 18;
    private static int s = 19;

    static {
        a.b(4095);
        a.a("RESERVED");
        a.a(true);
        a.a(0, "NOERROR");
        a.a(1, "FORMERR");
        a.a(2, "SERVFAIL");
        a.a(3, "NXDOMAIN");
        a.a(4, "NOTIMP");
        a.b(4, "NOTIMPL");
        a.a(5, "REFUSED");
        a.a(6, "YXDOMAIN");
        a.a(7, "YXRRSET");
        a.a(8, "NXRRSET");
        a.a(9, "NOTAUTH");
        a.a(10, "NOTZONE");
        a.a(16, "BADVERS");
        b.b((int) MinElf.PN_XNUM);
        b.a("RESERVED");
        b.a(true);
        b.a(a);
        b.a(16, "BADSIG");
        b.a(17, "BADKEY");
        b.a(18, "BADTIME");
        b.a(19, "BADMODE");
    }

    private bz() {
    }

    public static String a(int i2) {
        return a.d(i2);
    }

    public static String b(int i2) {
        return b.d(i2);
    }

    private static int a(String str) {
        return a.b(str);
    }
}
