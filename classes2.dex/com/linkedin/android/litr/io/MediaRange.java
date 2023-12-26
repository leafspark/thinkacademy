package com.linkedin.android.litr.io;

public class MediaRange {
    private final long end;
    private final long start;

    public MediaRange(long j, long j2) {
        this.start = j;
        this.end = j2;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }
}
