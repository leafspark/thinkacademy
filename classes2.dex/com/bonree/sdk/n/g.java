package com.bonree.sdk.n;

public final class g {
    private int a;
    private long b;
    private boolean c;

    public g(int i, long j, boolean z) {
        this.a = i;
        this.b = j;
        this.c = z;
    }

    public final int a() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final long b() {
        return this.b;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final boolean c() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final String toString() {
        return "SocketReceivePacketData{receiveByte=" + this.a + ", receiveEndTimeMs=" + this.b + ", flag=" + this.c + '}';
    }
}
