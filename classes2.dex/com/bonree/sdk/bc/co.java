package com.bonree.sdk.bc;

public final class co {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 0;
    private static int f = 1;
    private static int g = 2;
    private static bc h;
    private static String[] i = new String[4];
    private static String[] j = new String[4];

    static {
        bc bcVar = new bc("Message Section", 3);
        h = bcVar;
        bcVar.b(3);
        h.a(true);
        h.a(0, "qd");
        h.a(1, "an");
        h.a(2, "au");
        h.a(3, "ad");
        String[] strArr = i;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = j;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    private co() {
    }

    public static String a(int i2) {
        return h.d(i2);
    }

    public static String b(int i2) {
        h.a(i2);
        return i[i2];
    }

    public static String c(int i2) {
        h.a(i2);
        return j[i2];
    }

    private static int a(String str) {
        return h.b(str);
    }
}
