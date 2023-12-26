package com.amazonaws.services.s3.metrics;

import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.SimpleMetricType;
import com.amazonaws.metrics.ThroughputMetricType;
import com.amazonaws.services.s3.internal.Constants;

public class S3ServiceMetric extends SimpleMetricType implements ServiceMetricType {
    public static final S3ThroughputMetric S3_DOWLOAD_THROUGHPUT;
    public static final S3ServiceMetric S3_DOWNLOAD_BYTE_COUNT;
    public static final S3ServiceMetric S3_UPLOAD_BYTE_COUNT;
    public static final S3ThroughputMetric S3_UPLOAD_THROUGHPUT;
    static final String SERVICE_NAME_PREFIX = "S3";
    private static final S3ServiceMetric[] VALUES;
    private final String name;

    public String getServiceName() {
        return Constants.S3_SERVICE_DISPLAY_NAME;
    }

    private static final String metricName(String str) {
        return SERVICE_NAME_PREFIX + str;
    }

    static {
        AnonymousClass1 r0 = new S3ThroughputMetric(metricName(ServiceMetricType.DOWNLOAD_THROUGHPUT_NAME_SUFFIX)) {
            public ServiceMetricType getByteCountMetricType() {
                return S3_DOWNLOAD_BYTE_COUNT;
            }
        };
        S3_DOWLOAD_THROUGHPUT = r0;
        S3ServiceMetric s3ServiceMetric = new S3ServiceMetric(metricName(ServiceMetricType.DOWNLOAD_BYTE_COUNT_NAME_SUFFIX));
        S3_DOWNLOAD_BYTE_COUNT = s3ServiceMetric;
        AnonymousClass2 r2 = new S3ThroughputMetric(metricName(ServiceMetricType.UPLOAD_THROUGHPUT_NAME_SUFFIX)) {
            public ServiceMetricType getByteCountMetricType() {
                return S3_UPLOAD_BYTE_COUNT;
            }
        };
        S3_UPLOAD_THROUGHPUT = r2;
        S3ServiceMetric s3ServiceMetric2 = new S3ServiceMetric(metricName(ServiceMetricType.UPLOAD_BYTE_COUNT_NAME_SUFFIX));
        S3_UPLOAD_BYTE_COUNT = s3ServiceMetric2;
        VALUES = new S3ServiceMetric[]{r0, s3ServiceMetric, r2, s3ServiceMetric2};
    }

    private S3ServiceMetric(String str) {
        this.name = str;
    }

    public String name() {
        return this.name;
    }

    private static abstract class S3ThroughputMetric extends S3ServiceMetric implements ThroughputMetricType {
        private S3ThroughputMetric(String str) {
            super(str);
        }
    }

    public static S3ServiceMetric[] values() {
        return (S3ServiceMetric[]) VALUES.clone();
    }

    public static S3ServiceMetric valueOf(String str) {
        for (S3ServiceMetric s3ServiceMetric : values()) {
            if (s3ServiceMetric.name().equals(str)) {
                return s3ServiceMetric;
            }
        }
        throw new IllegalArgumentException("No S3ServiceMetric defined for the name " + str);
    }
}
