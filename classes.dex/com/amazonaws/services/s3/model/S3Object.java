package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class S3Object implements Closeable, Serializable, S3RequesterChargedResult {
    private String bucketName = null;
    private boolean isRequesterCharged;
    private String key = null;
    private ObjectMetadata metadata = new ObjectMetadata();
    private transient S3ObjectInputStream objectContent;
    private String redirectLocation;
    private Integer taggingCount;

    public ObjectMetadata getObjectMetadata() {
        return this.metadata;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public S3ObjectInputStream getObjectContent() {
        return this.objectContent;
    }

    public void setObjectContent(S3ObjectInputStream s3ObjectInputStream) {
        this.objectContent = s3ObjectInputStream;
    }

    public void setObjectContent(InputStream inputStream) {
        setObjectContent(new S3ObjectInputStream(inputStream));
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public Integer getTaggingCount() {
        return this.taggingCount;
    }

    public void setTaggingCount(Integer num) {
        this.taggingCount = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("S3Object [key=");
        sb.append(getKey());
        sb.append(",bucket=");
        String str = this.bucketName;
        if (str == null) {
            str = "<Unknown>";
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    public void close() throws IOException {
        if (getObjectContent() != null) {
            getObjectContent().close();
        }
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }
}
