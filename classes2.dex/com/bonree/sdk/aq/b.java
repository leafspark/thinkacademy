package com.bonree.sdk.aq;

public final class b extends com.bonree.sdk.g.b {
    private long l;
    private long m;

    public final long q() {
        return this.l;
    }

    public final void c(long j) {
        this.l = j;
    }

    public final long r() {
        return this.m;
    }

    public final void d(long j) {
        this.m = j;
    }

    public final String toString() {
        return "ApplicationData{mColdLaunchTimeMs=" + this.l + ", mColdLaunchStampTimeUs=" + this.m + ", activityName='" + this.a + '\'' + ", fragmentName='" + this.b + '\'' + ", methodName='" + this.c + '\'' + ", methodType=" + this.d + ", methodStatus=" + this.e + ", methodTime=" + this.f + ", methodTimeStamp=" + this.g + ", threadId='" + this.h + '\'' + ", threadName='" + this.i + '\'' + ", isMain=" + this.j + '}';
    }
}
