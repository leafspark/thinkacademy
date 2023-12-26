package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.event.ProgressListener;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public abstract class AbstractPutObjectRequest extends AmazonWebServiceRequest implements SSECustomerKeyProvider, SSEAwsKeyManagementParamsProvider, S3DataSource, Serializable {
    private AccessControlList accessControlList;
    private String bucketName;
    private CannedAccessControlList cannedAcl;
    private File file;
    private transient InputStream inputStream;
    private String key;
    private ObjectMetadata metadata;
    private String redirectLocation;
    private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
    private SSECustomerKey sseCustomerKey;
    private String storageClass;
    private ObjectTagging tagging;

    public AbstractPutObjectRequest(String str, String str2, File file2) {
        this.bucketName = str;
        this.key = str2;
        this.file = file2;
    }

    public AbstractPutObjectRequest(String str, String str2, String str3) {
        this.bucketName = str;
        this.key = str2;
        this.redirectLocation = str3;
    }

    protected AbstractPutObjectRequest(String str, String str2, InputStream inputStream2, ObjectMetadata objectMetadata) {
        this.bucketName = str;
        this.key = str2;
        this.inputStream = inputStream2;
        this.metadata = objectMetadata;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public <T extends AbstractPutObjectRequest> T withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public <T extends AbstractPutObjectRequest> T withKey(String str) {
        setKey(str);
        return this;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public <T extends AbstractPutObjectRequest> T withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public void setStorageClass(StorageClass storageClass2) {
        this.storageClass = storageClass2.toString();
    }

    public <T extends AbstractPutObjectRequest> T withStorageClass(StorageClass storageClass2) {
        setStorageClass(storageClass2);
        return this;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public <T extends AbstractPutObjectRequest> T withFile(File file2) {
        setFile(file2);
        return this;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public <T extends AbstractPutObjectRequest> T withMetadata(ObjectMetadata objectMetadata) {
        setMetadata(objectMetadata);
        return this;
    }

    public CannedAccessControlList getCannedAcl() {
        return this.cannedAcl;
    }

    public void setCannedAcl(CannedAccessControlList cannedAccessControlList) {
        this.cannedAcl = cannedAccessControlList;
    }

    public <T extends AbstractPutObjectRequest> T withCannedAcl(CannedAccessControlList cannedAccessControlList) {
        setCannedAcl(cannedAccessControlList);
        return this;
    }

    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }

    public void setAccessControlList(AccessControlList accessControlList2) {
        this.accessControlList = accessControlList2;
    }

    public <T extends AbstractPutObjectRequest> T withAccessControlList(AccessControlList accessControlList2) {
        setAccessControlList(accessControlList2);
        return this;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream2) {
        this.inputStream = inputStream2;
    }

    public <T extends AbstractPutObjectRequest> T withInputStream(InputStream inputStream2) {
        setInputStream(inputStream2);
        return this;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public <T extends AbstractPutObjectRequest> T withRedirectLocation(String str) {
        this.redirectLocation = str;
        return this;
    }

    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey == null || this.sseAwsKeyManagementParams == null) {
            this.sseCustomerKey = sSECustomerKey;
            return;
        }
        throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
    }

    public <T extends AbstractPutObjectRequest> T withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public ObjectTagging getTagging() {
        return this.tagging;
    }

    public void setTagging(ObjectTagging objectTagging) {
        this.tagging = objectTagging;
    }

    public <T extends AbstractPutObjectRequest> T withTagging(ObjectTagging objectTagging) {
        setTagging(objectTagging);
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
    public <T extends AbstractPutObjectRequest> T withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    public SSEAwsKeyManagementParams getSSEAwsKeyManagementParams() {
        return this.sseAwsKeyManagementParams;
    }

    public void setSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams == null || this.sseCustomerKey == null) {
            this.sseAwsKeyManagementParams = sSEAwsKeyManagementParams;
            return;
        }
        throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
    }

    public <T extends AbstractPutObjectRequest> T withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        setSSEAwsKeyManagementParams(sSEAwsKeyManagementParams);
        return this;
    }

    public AbstractPutObjectRequest clone() {
        return (AbstractPutObjectRequest) super.clone();
    }

    /* access modifiers changed from: protected */
    public final <T extends AbstractPutObjectRequest> T copyPutObjectBaseTo(T t) {
        ObjectMetadata objectMetadata;
        copyBaseTo(t);
        ObjectMetadata metadata2 = getMetadata();
        AbstractPutObjectRequest withInputStream = t.withAccessControlList(getAccessControlList()).withCannedAcl(getCannedAcl()).withInputStream(getInputStream());
        if (metadata2 == null) {
            objectMetadata = null;
        } else {
            objectMetadata = metadata2.clone();
        }
        return withInputStream.withMetadata(objectMetadata).withRedirectLocation(getRedirectLocation()).withStorageClass(getStorageClass()).withSSEAwsKeyManagementParams(getSSEAwsKeyManagementParams()).withSSECustomerKey(getSSECustomerKey());
    }
}
