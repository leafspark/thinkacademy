package com.bonree.sdk.bs;

public class f extends Thread {
    public f(String str) {
        this("BR-" + str + "-Thread", 5);
    }

    private f(String str, int i) {
        super(str);
        setPriority(5);
        setUncaughtExceptionHandler(g.a());
    }

    public static void a(int i) {
        if (i > 0) {
            try {
                Thread.sleep((long) i);
            } catch (Throwable unused) {
            }
        }
    }
}
