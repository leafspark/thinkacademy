package com.bonree.sdk.n;

public final class i {
    private int a;
    private long b;
    private long c;

    public i(int i, long j, long j2) {
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final String toString() {
        return "SocketSendPacketData{sendByte=" + this.a + ", sendStartTimeMs=" + this.b + ", sendEndTimeMs=" + this.c + '}';
    }
}
