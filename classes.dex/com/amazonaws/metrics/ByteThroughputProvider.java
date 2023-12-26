package com.amazonaws.metrics;

public abstract class ByteThroughputProvider {
    private int byteCount;
    private long duration;
    private final ThroughputMetricType throughputType;

    protected ByteThroughputProvider(ThroughputMetricType throughputMetricType) {
        this.throughputType = throughputMetricType;
    }

    public ThroughputMetricType getThroughputMetricType() {
        return this.throughputType;
    }

    public int getByteCount() {
        return this.byteCount;
    }

    public long getDurationNano() {
        return this.duration;
    }

    public String getProviderId() {
        return super.toString();
    }

    /* access modifiers changed from: protected */
    public void increment(int i, long j) {
        this.byteCount += i;
        this.duration += System.nanoTime() - j;
    }

    /* access modifiers changed from: protected */
    public void reset() {
        this.byteCount = 0;
        this.duration = 0;
    }

    public String toString() {
        return String.format("providerId=%s, throughputType=%s, byteCount=%d, duration=%d", new Object[]{getProviderId(), this.throughputType, Integer.valueOf(this.byteCount), Long.valueOf(this.duration)});
    }
}
