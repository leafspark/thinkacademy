package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public enum AnalyticsS3ExportFileFormat implements Serializable {
    CSV("CSV");
    
    private final String format;

    private AnalyticsS3ExportFileFormat(String str) {
        this.format = str;
    }

    public String toString() {
        return this.format;
    }
}
