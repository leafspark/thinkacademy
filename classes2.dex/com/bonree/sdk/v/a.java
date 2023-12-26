package com.bonree.sdk.v;

public final class a extends RuntimeException {
    private a(String str, Throwable th) {
        super(str, (Throwable) null);
    }

    public a(Throwable th) {
        super(th);
    }

    public a(String str) {
        this(str, (Throwable) null);
    }
}
