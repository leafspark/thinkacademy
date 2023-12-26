package com.bonree.sdk.bc;

public final class ac {
    private static bc a = null;
    private static byte b = 0;
    private static byte c = 5;
    private static byte d = 6;
    private static byte e = 7;
    private static byte f = 8;
    private static byte g = 10;
    private static byte h = 11;
    private static int i = 32768;

    static {
        bc bcVar = new bc("DNS Header Flag", 3);
        a = bcVar;
        bcVar.b(15);
        a.a("FLAG");
        a.a(true);
        a.a(0, "qr");
        a.a(5, "aa");
        a.a(6, "tc");
        a.a(7, "rd");
        a.a(8, "ra");
        a.a(10, "ad");
        a.a(11, "cd");
    }

    private ac() {
    }

    public static String a(int i2) {
        return a.d(i2);
    }

    private static int a(String str) {
        return a.b(str);
    }

    public static boolean b(int i2) {
        a.a(i2);
        return (i2 <= 0 || i2 > 4) && i2 < 12;
    }
}
