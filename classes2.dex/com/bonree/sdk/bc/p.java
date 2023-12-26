package com.bonree.sdk.bc;

import com.bonree.sdk.bc.w;

public final class p {
    private static int a = 1;
    private static int b = 3;
    private static int c = 3;
    private static int d = 4;
    private static int e = 4;
    private static int f = 254;
    private static int g = 255;
    private static bc h;

    static class a extends bc {
        public a() {
            super("DClass", 2);
            a("CLASS");
        }

        public final void a(int i) {
            p.a(i);
        }
    }

    static {
        a aVar = new a();
        h = aVar;
        aVar.a(1, "IN");
        h.a(3, "CH");
        h.b(3, "CHAOS");
        h.a(4, "HS");
        h.b(4, "HESIOD");
        h.a(254, "NONE");
        h.a(255, "ANY");
    }

    private p() {
    }

    public static void a(int i) {
        if (i < 0 || i > 65535) {
            throw new w.d(i);
        }
    }

    public static String b(int i) {
        return h.d(i);
    }

    public static int a(String str) {
        return h.b(str);
    }
}
