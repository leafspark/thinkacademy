package com.amazonaws.services.s3.model.inventory;

import com.alibaba.sdk.android.oss.model.CreateBucketRequest;

public enum InventoryOptionalField {
    Size("Size"),
    LastModifiedDate("LastModifiedDate"),
    StorageClass(CreateBucketRequest.TAB_STORAGECLASS),
    ETag("ETag"),
    IsMultipartUploaded("IsMultipartUploaded"),
    ReplicationStatus("ReplicationStatus");
    
    private final String field;

    private InventoryOptionalField(String str) {
        this.field = str;
    }

    public String toString() {
        return this.field;
    }
}
