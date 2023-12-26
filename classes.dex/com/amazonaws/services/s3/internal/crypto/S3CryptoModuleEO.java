package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.io.File;

@Deprecated
class S3CryptoModuleEO extends S3CryptoModuleBase<MultipartUploadCbcContext> {
    S3CryptoModuleEO(AWSKMSClient aWSKMSClient, S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        super(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, cryptoConfiguration);
        if (cryptoConfiguration.getCryptoMode() != CryptoMode.EncryptionOnly) {
            throw new IllegalArgumentException();
        }
    }

    S3CryptoModuleEO(S3Direct s3Direct, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this((AWSKMSClient) null, s3Direct, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfiguration);
    }

    S3CryptoModuleEO(AWSKMSClient aWSKMSClient, S3Direct s3Direct, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this(aWSKMSClient, s3Direct, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfiguration);
    }

    public S3Object getObjectSecurely(GetObjectRequest getObjectRequest) {
        throw new IllegalStateException();
    }

    public ObjectMetadata getObjectSecurely(GetObjectRequest getObjectRequest, File file) {
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public final MultipartUploadCbcContext newUploadContext(InitiateMultipartUploadRequest initiateMultipartUploadRequest, ContentCryptoMaterial contentCryptoMaterial) {
        MultipartUploadCbcContext multipartUploadCbcContext = new MultipartUploadCbcContext(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), contentCryptoMaterial);
        multipartUploadCbcContext.setNextInitializationVector(contentCryptoMaterial.getCipherLite().getIV());
        return multipartUploadCbcContext;
    }

    /* access modifiers changed from: package-private */
    public final void updateUploadContext(MultipartUploadCbcContext multipartUploadCbcContext, SdkFilterInputStream sdkFilterInputStream) {
        multipartUploadCbcContext.setNextInitializationVector(((ByteRangeCapturingInputStream) sdkFilterInputStream).getBlock());
    }

    /* access modifiers changed from: package-private */
    public final ByteRangeCapturingInputStream wrapForMultipart(CipherLiteInputStream cipherLiteInputStream, long j) {
        return new ByteRangeCapturingInputStream(cipherLiteInputStream, j - ((long) this.contentCryptoScheme.getBlockSizeInBytes()), j);
    }

    /* access modifiers changed from: package-private */
    public final long computeLastPartSize(UploadPartRequest uploadPartRequest) {
        long j;
        if (uploadPartRequest.getFile() != null) {
            if (uploadPartRequest.getPartSize() > 0) {
                j = uploadPartRequest.getPartSize();
            } else {
                j = uploadPartRequest.getFile().length();
            }
        } else if (uploadPartRequest.getInputStream() == null) {
            return -1;
        } else {
            j = uploadPartRequest.getPartSize();
        }
        long blockSizeInBytes = (long) this.contentCryptoScheme.getBlockSizeInBytes();
        return j + (blockSizeInBytes - (j % blockSizeInBytes));
    }

    /* access modifiers changed from: package-private */
    public final CipherLite cipherLiteForNextPart(MultipartUploadCbcContext multipartUploadCbcContext) {
        return multipartUploadCbcContext.getCipherLite().createUsingIV(multipartUploadCbcContext.getNextInitializationVector());
    }

    /* access modifiers changed from: protected */
    public final long ciphertextLength(long j) {
        long blockSizeInBytes = (long) this.contentCryptoScheme.getBlockSizeInBytes();
        return j + (blockSizeInBytes - (j % blockSizeInBytes));
    }
}
