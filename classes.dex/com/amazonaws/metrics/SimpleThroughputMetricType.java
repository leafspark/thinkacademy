package com.amazonaws.metrics;

public class SimpleThroughputMetricType extends SimpleServiceMetricType implements ThroughputMetricType {
    private final ServiceMetricType byteCountMetricType;

    public SimpleThroughputMetricType(String str, String str2, String str3) {
        super(str, str2);
        this.byteCountMetricType = new SimpleServiceMetricType(str3, str2);
    }

    public ServiceMetricType getByteCountMetricType() {
        return this.byteCountMetricType;
    }
}
