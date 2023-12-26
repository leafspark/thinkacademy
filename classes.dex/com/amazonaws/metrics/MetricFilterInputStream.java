package com.amazonaws.metrics;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MetricFilterInputStream extends SdkFilterInputStream {
    private final ByteThroughputHelper helper;

    public final boolean isMetricActivated() {
        return true;
    }

    public MetricFilterInputStream(ThroughputMetricType throughputMetricType, InputStream inputStream) {
        super(inputStream);
        this.helper = new ByteThroughputHelper(throughputMetricType);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        abortIfNeeded();
        long startTiming = this.helper.startTiming();
        int read = this.in.read(bArr, i, i2);
        if (read > 0) {
            this.helper.increment(read, startTiming);
        }
        return read;
    }

    public void close() throws IOException {
        this.helper.reportMetrics();
        this.in.close();
        abortIfNeeded();
    }
}
