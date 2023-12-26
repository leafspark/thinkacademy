package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class AnalyticsConfiguration implements Serializable {
    private AnalyticsFilter filter;
    private String id;
    private StorageClassAnalysis storageClassAnalysis;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public AnalyticsConfiguration withId(String str) {
        setId(str);
        return this;
    }

    public AnalyticsFilter getFilter() {
        return this.filter;
    }

    public void setFilter(AnalyticsFilter analyticsFilter) {
        this.filter = analyticsFilter;
    }

    public AnalyticsConfiguration withFilter(AnalyticsFilter analyticsFilter) {
        setFilter(analyticsFilter);
        return this;
    }

    public StorageClassAnalysis getStorageClassAnalysis() {
        return this.storageClassAnalysis;
    }

    public void setStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis2) {
        this.storageClassAnalysis = storageClassAnalysis2;
    }

    public AnalyticsConfiguration withStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis2) {
        setStorageClassAnalysis(storageClassAnalysis2);
        return this;
    }
}
