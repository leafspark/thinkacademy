package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import java.io.Serializable;

public class SetBucketAnalyticsConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsConfiguration analyticsConfiguration;
    private String bucketName;

    public SetBucketAnalyticsConfigurationRequest() {
    }

    public SetBucketAnalyticsConfigurationRequest(String str, AnalyticsConfiguration analyticsConfiguration2) {
        this.bucketName = str;
        this.analyticsConfiguration = analyticsConfiguration2;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public SetBucketAnalyticsConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public AnalyticsConfiguration getAnalyticsConfiguration() {
        return this.analyticsConfiguration;
    }

    public void setAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration2) {
        this.analyticsConfiguration = analyticsConfiguration2;
    }

    public SetBucketAnalyticsConfigurationRequest withAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration2) {
        setAnalyticsConfiguration(analyticsConfiguration2);
        return this;
    }
}
