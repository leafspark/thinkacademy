package com.amazonaws.metrics;

public class SimpleServiceMetricType extends SimpleMetricType implements ServiceMetricType {
    private final String name;
    private final String serviceName;

    public SimpleServiceMetricType(String str, String str2) {
        this.name = str;
        this.serviceName = str2;
    }

    public String name() {
        return this.name;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
