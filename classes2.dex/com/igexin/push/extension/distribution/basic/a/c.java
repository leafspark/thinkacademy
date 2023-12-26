package com.igexin.push.extension.distribution.basic.a;

enum c {
    BIG_IMAGE(1),
    LONG_TEXT(2);
    
    private int c;

    private c(int i) {
        this.c = i;
    }

    public int a() {
        return this.c;
    }
}
