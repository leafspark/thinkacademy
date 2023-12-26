package com.bonree.sdk.bc;

public final class bq {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 4;
    private static int e = 5;
    private static bc f;

    static {
        bc bcVar = new bc("DNS Opcode", 2);
        f = bcVar;
        bcVar.b(15);
        f.a("RESERVED");
        f.a(true);
        f.a(0, "QUERY");
        f.a(1, "IQUERY");
        f.a(2, "STATUS");
        f.a(4, "NOTIFY");
        f.a(5, "UPDATE");
    }

    private bq() {
    }

    public static String a(int i) {
        return f.d(i);
    }

    private static int a(String str) {
        return f.b(str);
    }
}
