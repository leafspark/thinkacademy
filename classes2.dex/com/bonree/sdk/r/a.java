package com.bonree.sdk.r;

import java.util.EventObject;

public final class a extends EventObject {
    private static final long a = 1;
    private final long b;
    private final Exception c;

    public a(Object obj, long j, Exception exc) {
        super(obj);
        this.b = j;
        this.c = exc;
    }

    public a(Object obj, long j) {
        this(obj, j, (Exception) null);
    }

    public final long a() {
        return this.b;
    }

    public final Exception b() {
        return this.c;
    }

    private boolean c() {
        return this.c != null;
    }
}
