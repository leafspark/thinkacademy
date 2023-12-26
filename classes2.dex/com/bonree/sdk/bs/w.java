package com.bonree.sdk.bs;

public final class w {
    private String a;
    private int b;
    private int c;
    private int d;

    public w(String str) throws Exception {
        this.a = str;
        String[] split = str.split("/")[1].split("\\.");
        this.b = Integer.valueOf(split[0]).intValue();
        this.c = Integer.valueOf(split[1]).intValue();
        this.d = Integer.valueOf(split[2]).intValue();
    }

    private void d() throws Exception {
        String[] split = this.a.split("/")[1].split("\\.");
        this.b = Integer.valueOf(split[0]).intValue();
        this.c = Integer.valueOf(split[1]).intValue();
        this.d = Integer.valueOf(split[2]).intValue();
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }
}
