package com.bonree.sdk.be;

public final class a {
    private static final c a = new c();
    private static int b = 3;
    private static boolean c = false;

    public static void a(int i) {
        if (i <= 5 && i > 0) {
            b = i;
        }
    }

    public static f a() {
        return a;
    }

    public static boolean b() {
        return c;
    }

    public static void a(f fVar) {
        fVar.a(b);
        a.a(fVar);
        c = fVar instanceof d;
    }
}
