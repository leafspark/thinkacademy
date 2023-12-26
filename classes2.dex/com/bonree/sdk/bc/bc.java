package com.bonree.sdk.bc;

import java.util.HashMap;

class bc {
    private static Integer[] a = new Integer[64];
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private HashMap e = new HashMap();
    private HashMap f = new HashMap();
    private String g;
    private int h;
    private String i;
    private int j = Integer.MAX_VALUE;
    private boolean k;

    static {
        int i2 = 0;
        while (true) {
            Integer[] numArr = a;
            if (i2 < numArr.length) {
                numArr[i2] = Integer.valueOf(i2);
                i2++;
            } else {
                return;
            }
        }
    }

    public bc(String str, int i2) {
        this.g = str;
        this.h = i2;
    }

    public final void b(int i2) {
        this.j = i2;
    }

    public final void a(String str) {
        this.i = c(str);
    }

    public final void a(boolean z) {
        this.k = z;
    }

    public static Integer c(int i2) {
        if (i2 >= 0) {
            Integer[] numArr = a;
            if (i2 < numArr.length) {
                return numArr[i2];
            }
        }
        return Integer.valueOf(i2);
    }

    public void a(int i2) {
        if (i2 < 0 || i2 > this.j) {
            throw new IllegalArgumentException(this.g + " " + i2 + "is out of range");
        }
    }

    private String c(String str) {
        int i2 = this.h;
        if (i2 == 2) {
            return str.toUpperCase();
        }
        return i2 == 3 ? str.toLowerCase() : str;
    }

    private int d(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0 || parseInt > this.j) {
                return -1;
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final void a(int i2, String str) {
        a(i2);
        Integer c2 = c(i2);
        String c3 = c(str);
        this.e.put(c3, c2);
        this.f.put(c2, c3);
    }

    public final void b(int i2, String str) {
        a(i2);
        Integer c2 = c(i2);
        this.e.put(c(str), c2);
    }

    public final void a(bc bcVar) {
        if (this.h == bcVar.h) {
            this.e.putAll(bcVar.e);
            this.f.putAll(bcVar.f);
            return;
        }
        throw new IllegalArgumentException(bcVar.g + ": wordcases do not match");
    }

    public final String d(int i2) {
        a(i2);
        String str = (String) this.f.get(c(i2));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i2);
        if (this.i == null) {
            return num;
        }
        return this.i + num;
    }

    public final int b(String str) {
        int d2;
        String c2 = c(str);
        Integer num = (Integer) this.e.get(c2);
        if (num != null) {
            return num.intValue();
        }
        String str2 = this.i;
        if (str2 != null && c2.startsWith(str2) && (d2 = d(c2.substring(this.i.length()))) >= 0) {
            return d2;
        }
        if (this.k) {
            return d(c2);
        }
        return -1;
    }
}
