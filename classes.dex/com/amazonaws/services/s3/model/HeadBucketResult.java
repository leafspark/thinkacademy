package com.amazonaws.services.s3.model;

public class HeadBucketResult {
    private String bucketRegion;

    public String getBucketRegion() {
        return this.bucketRegion;
    }

    public void setBucketRegion(String str) {
        this.bucketRegion = str;
    }

    public HeadBucketResult withBucketRegion(String str) {
        setBucketRegion(str);
        return this;
    }
}
