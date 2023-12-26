package com.bonree.sdk.bs;

public final class l extends Exception {
    public l(String str, Throwable th) {
        super(str, th);
    }

    public l(String str) {
        this(str, (Throwable) null);
    }

    public l(Throwable th) {
        super(th);
    }
}
