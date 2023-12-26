package com.amazonaws.mobileconnectors.s3.transferutility;

import androidx.core.util.ObjectsCompat;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;

public final class UploadOptions {
    private final String bucket;
    private final CannedAccessControlList cannedAcl;
    private final TransferListener listener;
    private final ObjectMetadata metadata;

    public UploadOptions(Builder builder) {
        this.bucket = builder.bucket;
        this.metadata = builder.metadata;
        this.cannedAcl = builder.cannedAcl;
        this.listener = builder.listener;
    }

    public String getBucket() {
        return this.bucket;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public CannedAccessControlList getCannedAcl() {
        return this.cannedAcl;
    }

    public TransferListener getTransferListener() {
        return this.listener;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String bucket;
        /* access modifiers changed from: private */
        public CannedAccessControlList cannedAcl;
        /* access modifiers changed from: private */
        public TransferListener listener;
        /* access modifiers changed from: private */
        public ObjectMetadata metadata;

        private Builder() {
        }

        public Builder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public Builder objectMetadata(ObjectMetadata objectMetadata) {
            this.metadata = objectMetadata;
            return this;
        }

        public Builder cannedAcl(CannedAccessControlList cannedAccessControlList) {
            this.cannedAcl = cannedAccessControlList;
            return this;
        }

        public Builder transferListener(TransferListener transferListener) {
            this.listener = transferListener;
            return this;
        }

        public UploadOptions build() {
            return new UploadOptions(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String toString() {
        return "UploadOptions{bucket='" + this.bucket + '\'' + ", metadata=" + this.metadata + ", cannedAcl=" + this.cannedAcl + ", listener=" + this.listener + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UploadOptions uploadOptions = (UploadOptions) obj;
        if (!ObjectsCompat.equals(this.bucket, uploadOptions.bucket) || !ObjectsCompat.equals(this.metadata, uploadOptions.metadata) || this.cannedAcl != uploadOptions.cannedAcl || !ObjectsCompat.equals(this.listener, uploadOptions.listener)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.bucket, this.metadata, this.cannedAcl, this.listener);
    }
}
