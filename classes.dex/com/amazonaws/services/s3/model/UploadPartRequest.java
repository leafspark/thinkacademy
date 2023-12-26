package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.event.ProgressListener;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public class UploadPartRequest extends AmazonWebServiceRequest implements SSECustomerKeyProvider, S3DataSource, Serializable {
    private static final long serialVersionUID = 1;
    private String bucketName;
    private File file;
    private long fileOffset;
    private int id;
    private transient InputStream inputStream;
    private boolean isLastPart;
    private boolean isRequesterPays;
    private String key;
    private int mainUploadId;
    private String md5Digest;
    private ObjectMetadata objectMetadata;
    private int partNumber;
    private long partSize;
    private SSECustomerKey sseCustomerKey;
    private String uploadId;

    public void setId(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public UploadPartRequest withId(int i) {
        this.id = i;
        return this;
    }

    public void setMainUploadId(int i) {
        this.mainUploadId = i;
    }

    public int getMainUploadId() {
        return this.mainUploadId;
    }

    public UploadPartRequest withMainUploadId(int i) {
        this.mainUploadId = i;
        return this;
    }

    public void setInputStream(InputStream inputStream2) {
        this.inputStream = inputStream2;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public UploadPartRequest withInputStream(InputStream inputStream2) {
        setInputStream(inputStream2);
        return this;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public UploadPartRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public UploadPartRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public UploadPartRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public UploadPartRequest withPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public UploadPartRequest withPartSize(long j) {
        this.partSize = j;
        return this;
    }

    public String getMd5Digest() {
        return this.md5Digest;
    }

    public void setMd5Digest(String str) {
        this.md5Digest = str;
    }

    public UploadPartRequest withMD5Digest(String str) {
        this.md5Digest = str;
        return this;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public UploadPartRequest withFile(File file2) {
        setFile(file2);
        return this;
    }

    public long getFileOffset() {
        return this.fileOffset;
    }

    public void setFileOffset(long j) {
        this.fileOffset = j;
    }

    public UploadPartRequest withFileOffset(long j) {
        setFileOffset(j);
        return this;
    }

    @Deprecated
    public void setProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    @Deprecated
    public ProgressListener getProgressListener() {
        ProgressListener generalProgressListener = getGeneralProgressListener();
        if (generalProgressListener instanceof LegacyS3ProgressListener) {
            return ((LegacyS3ProgressListener) generalProgressListener).unwrap();
        }
        return null;
    }

    @Deprecated
    public UploadPartRequest withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    public boolean isLastPart() {
        return this.isLastPart;
    }

    public void setLastPart(boolean z) {
        this.isLastPart = z;
    }

    public UploadPartRequest withLastPart(boolean z) {
        setLastPart(z);
        return this;
    }

    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sseCustomerKey = sSECustomerKey;
    }

    public UploadPartRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata2) {
        this.objectMetadata = objectMetadata2;
    }

    public UploadPartRequest withObjectMetadata(ObjectMetadata objectMetadata2) {
        setObjectMetadata(objectMetadata2);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public UploadPartRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }
}
