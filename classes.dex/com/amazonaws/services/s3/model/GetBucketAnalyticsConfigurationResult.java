package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import java.io.Serializable;

public class GetBucketAnalyticsConfigurationResult implements Serializable {
    private AnalyticsConfiguration analyticsConfiguration;

    public AnalyticsConfiguration getAnalyticsConfiguration() {
        return this.analyticsConfiguration;
    }

    public void setAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration2) {
        this.analyticsConfiguration = analyticsConfiguration2;
    }

    public GetBucketAnalyticsConfigurationResult withAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration2) {
        setAnalyticsConfiguration(analyticsConfiguration2);
        return this;
    }
}
