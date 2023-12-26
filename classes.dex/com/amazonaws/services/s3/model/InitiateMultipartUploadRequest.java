package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class InitiateMultipartUploadRequest extends AmazonWebServiceRequest implements SSECustomerKeyProvider, SSEAwsKeyManagementParamsProvider, Serializable {
    private AccessControlList accessControlList;
    private String bucketName;
    private CannedAccessControlList cannedACL;
    private boolean isRequesterPays;
    private String key;
    public ObjectMetadata objectMetadata;
    private String redirectLocation;
    private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
    private SSECustomerKey sseCustomerKey;
    private StorageClass storageClass;
    private ObjectTagging tagging;

    public InitiateMultipartUploadRequest(String str, String str2) {
        this.bucketName = str;
        this.key = str2;
    }

    public InitiateMultipartUploadRequest(String str, String str2, ObjectMetadata objectMetadata2) {
        this.bucketName = str;
        this.key = str2;
        this.objectMetadata = objectMetadata2;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public InitiateMultipartUploadRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public InitiateMultipartUploadRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public CannedAccessControlList getCannedACL() {
        return this.cannedACL;
    }

    public void setCannedACL(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
    }

    public InitiateMultipartUploadRequest withCannedACL(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
        return this;
    }

    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }

    public void setAccessControlList(AccessControlList accessControlList2) {
        this.accessControlList = accessControlList2;
    }

    public InitiateMultipartUploadRequest withAccessControlList(AccessControlList accessControlList2) {
        setAccessControlList(accessControlList2);
        return this;
    }

    public StorageClass getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(StorageClass storageClass2) {
        this.storageClass = storageClass2;
    }

    public InitiateMultipartUploadRequest withStorageClass(StorageClass storageClass2) {
        this.storageClass = storageClass2;
        return this;
    }

    public InitiateMultipartUploadRequest withStorageClass(String str) {
        if (str != null) {
            this.storageClass = StorageClass.fromValue(str);
        } else {
            this.storageClass = null;
        }
        return this;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata2) {
        this.objectMetadata = objectMetadata2;
    }

    public InitiateMultipartUploadRequest withObjectMetadata(ObjectMetadata objectMetadata2) {
        setObjectMetadata(objectMetadata2);
        return this;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public InitiateMultipartUploadRequest withRedirectLocation(String str) {
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

    public InitiateMultipartUploadRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
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

    public InitiateMultipartUploadRequest withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        setSSEAwsKeyManagementParams(sSEAwsKeyManagementParams);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public InitiateMultipartUploadRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }

    public ObjectTagging getTagging() {
        return this.tagging;
    }

    public void setTagging(ObjectTagging objectTagging) {
        this.tagging = objectTagging;
    }

    public InitiateMultipartUploadRequest withTagging(ObjectTagging objectTagging) {
        setTagging(objectTagging);
        return this;
    }
}
