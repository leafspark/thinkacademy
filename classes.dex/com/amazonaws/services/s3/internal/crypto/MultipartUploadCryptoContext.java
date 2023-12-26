package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;

@Deprecated
class MultipartUploadCryptoContext extends MultipartUploadContext {
    private final ContentCryptoMaterial cekMaterial;
    private int partNumber;
    private volatile boolean partUploadInProgress;

    MultipartUploadCryptoContext(String str, String str2, ContentCryptoMaterial contentCryptoMaterial) {
        super(str, str2);
        this.cekMaterial = contentCryptoMaterial;
    }

    /* access modifiers changed from: package-private */
    public CipherLite getCipherLite() {
        return this.cekMaterial.getCipherLite();
    }

    /* access modifiers changed from: package-private */
    public ContentCryptoMaterial getContentCryptoMaterial() {
        return this.cekMaterial;
    }

    /* access modifiers changed from: package-private */
    public void beginPartUpload(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("part number must be at least 1");
        } else if (!this.partUploadInProgress) {
            synchronized (this) {
                if (i - this.partNumber <= 1) {
                    this.partNumber = i;
                    this.partUploadInProgress = true;
                } else {
                    throw new AmazonClientException("Parts are required to be uploaded in series (partNumber=" + this.partNumber + ", nextPartNumber=" + i + ")");
                }
            }
        } else {
            throw new AmazonClientException("Parts are required to be uploaded in series");
        }
    }

    /* access modifiers changed from: package-private */
    public void endPartUpload() {
        this.partUploadInProgress = false;
    }
}
