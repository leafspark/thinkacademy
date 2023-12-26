package com.bonree.sdk.bo;

public final class c {
    private static b a = new a();

    public static String a(String str) {
        return a.a(str);
    }

    public static String b(String str) {
        return a.b(str);
    }

    private static void a(b bVar) {
        if (bVar != null) {
            a = bVar;
            return;
        }
        throw new IllegalArgumentException();
    }
}
