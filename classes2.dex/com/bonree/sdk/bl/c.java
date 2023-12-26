package com.bonree.sdk.bl;

import com.bonree.sdk.bj.a;

public abstract class c {
    private static /* synthetic */ boolean d = true;
    public final com.bonree.sdk.bj.a a;
    private int b;
    private com.bonree.sdk.bj.a c;

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;

        static {
            h = new int[]{1, 2, 3, 4, 5, 6, 7};
        }

        public static int[] a() {
            return (int[]) h.clone();
        }
    }

    protected c(int i, com.bonree.sdk.bj.a aVar, com.bonree.sdk.bj.a aVar2) {
        boolean z = d;
        if (!z && i == 0) {
            throw new AssertionError();
        } else if (!z && aVar == null) {
            throw new AssertionError();
        } else if (z || aVar2 != null) {
            this.b = i;
            this.c = aVar;
            this.a = aVar2;
        } else {
            throw new AssertionError();
        }
    }

    public String toString() {
        return this.a.toString();
    }

    public final boolean a() {
        return this.a.c == a.c.NO_ERROR;
    }
}
