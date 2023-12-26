package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptedGetObjectRequest;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.ExtraMaterialsDescription;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectId;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

@Deprecated
class S3CryptoModuleAE extends S3CryptoModuleBase<MultipartUploadCryptoContext> {
    private static final int BIT_SIZE = 8;
    private static final int DEFAULT_BYTE_SIZE = 10240;

    /* access modifiers changed from: protected */
    public boolean isStrict() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void updateUploadContext(MultipartUploadCryptoContext multipartUploadCryptoContext, SdkFilterInputStream sdkFilterInputStream) {
    }

    /* access modifiers changed from: package-private */
    public final SdkFilterInputStream wrapForMultipart(CipherLiteInputStream cipherLiteInputStream, long j) {
        return cipherLiteInputStream;
    }

    static {
        CryptoRuntime.enableBouncyCastle();
    }

    S3CryptoModuleAE(AWSKMSClient aWSKMSClient, S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        super(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, cryptoConfiguration);
        CryptoMode cryptoMode = cryptoConfiguration.getCryptoMode();
        if (cryptoMode != CryptoMode.StrictAuthenticatedEncryption && cryptoMode != CryptoMode.AuthenticatedEncryption) {
            throw new IllegalArgumentException();
        }
    }

    S3CryptoModuleAE(S3Direct s3Direct, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this((AWSKMSClient) null, s3Direct, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfiguration);
    }

    S3CryptoModuleAE(AWSKMSClient aWSKMSClient, S3Direct s3Direct, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this(aWSKMSClient, s3Direct, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfiguration);
    }

    public S3Object getObjectSecurely(GetObjectRequest getObjectRequest) {
        appendUserAgent(getObjectRequest, AmazonS3EncryptionClient.USER_AGENT);
        long[] range = getObjectRequest.getRange();
        if (!isStrict() || (range == null && getObjectRequest.getPartNumber() == null)) {
            long[] adjustedCryptoRange = getAdjustedCryptoRange(range);
            if (adjustedCryptoRange != null) {
                getObjectRequest.setRange(adjustedCryptoRange[0], adjustedCryptoRange[1]);
            }
            S3Object object = this.s3.getObject(getObjectRequest);
            String str = null;
            if (object == null) {
                return null;
            }
            if (getObjectRequest instanceof EncryptedGetObjectRequest) {
                str = ((EncryptedGetObjectRequest) getObjectRequest).getInstructionFileSuffix();
            }
            String str2 = str;
            if (str2 != null) {
                try {
                    if (!str2.trim().isEmpty()) {
                        return decipherWithInstFileSuffix(getObjectRequest, range, adjustedCryptoRange, object, str2);
                    }
                } catch (RuntimeException e) {
                    IOUtils.closeQuietly(object, this.log);
                    throw e;
                } catch (Error e2) {
                    IOUtils.closeQuietly(object, this.log);
                    throw e2;
                }
            }
            return decipher(getObjectRequest, range, adjustedCryptoRange, object);
        }
        throw new SecurityException("Range get and getting a part are not allowed in strict crypto mode");
    }

    private S3Object decipher(GetObjectRequest getObjectRequest, long[] jArr, long[] jArr2, S3Object s3Object) {
        S3ObjectWrapper s3ObjectWrapper = new S3ObjectWrapper(s3Object, getObjectRequest.getS3ObjectId());
        if (s3ObjectWrapper.hasEncryptionInfo()) {
            return decipherWithMetadata(getObjectRequest, jArr, jArr2, s3ObjectWrapper);
        }
        S3ObjectWrapper fetchInstructionFile = fetchInstructionFile(getObjectRequest.getS3ObjectId(), (String) null);
        if (fetchInstructionFile != null) {
            try {
                if (fetchInstructionFile.isInstructionFile()) {
                    return decipherWithInstructionFile(getObjectRequest, jArr, jArr2, s3ObjectWrapper, fetchInstructionFile);
                }
                IOUtils.closeQuietly(fetchInstructionFile, this.log);
            } finally {
                IOUtils.closeQuietly(fetchInstructionFile, this.log);
            }
        }
        if (isStrict() || !this.cryptoConfig.isIgnoreMissingInstructionFile()) {
            IOUtils.closeQuietly(s3ObjectWrapper, this.log);
            throw new SecurityException("Instruction file not found for S3 object with bucket name: " + s3Object.getBucketName() + ", key: " + s3Object.getKey());
        }
        this.log.warn(String.format("Unable to detect encryption information for object '%s' in bucket '%s'. Returning object without decryption.", new Object[]{s3Object.getKey(), s3Object.getBucketName()}));
        return adjustToDesiredRange(s3ObjectWrapper, jArr, (Map<String, String>) null).getS3Object();
    }

    private S3Object decipherWithInstFileSuffix(GetObjectRequest getObjectRequest, long[] jArr, long[] jArr2, S3Object s3Object, String str) {
        S3ObjectId s3ObjectId = getObjectRequest.getS3ObjectId();
        S3ObjectWrapper fetchInstructionFile = fetchInstructionFile(s3ObjectId, str);
        if (fetchInstructionFile != null) {
            try {
                if (fetchInstructionFile.isInstructionFile()) {
                    return decipherWithInstructionFile(getObjectRequest, jArr, jArr2, new S3ObjectWrapper(s3Object, s3ObjectId), fetchInstructionFile);
                }
                throw new AmazonClientException("Invalid Instruction file with suffix " + str + " detected for " + s3Object);
            } finally {
                IOUtils.closeQuietly(fetchInstructionFile, this.log);
            }
        } else {
            throw new AmazonClientException("Instruction file with suffix " + str + " is not found for " + s3Object);
        }
    }

    private S3Object decipherWithInstructionFile(GetObjectRequest getObjectRequest, long[] jArr, long[] jArr2, S3ObjectWrapper s3ObjectWrapper, S3ObjectWrapper s3ObjectWrapper2) {
        ExtraMaterialsDescription extraMaterialsDescription = ExtraMaterialsDescription.NONE;
        boolean isStrict = isStrict();
        if (getObjectRequest instanceof EncryptedGetObjectRequest) {
            EncryptedGetObjectRequest encryptedGetObjectRequest = (EncryptedGetObjectRequest) getObjectRequest;
            extraMaterialsDescription = encryptedGetObjectRequest.getExtraMaterialDescription();
            if (!isStrict) {
                isStrict = encryptedGetObjectRequest.isKeyWrapExpected();
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(JsonUtils.jsonToMap(s3ObjectWrapper2.toJsonString()));
        Map map = unmodifiableMap;
        ContentCryptoMaterial fromInstructionFile = ContentCryptoMaterial.fromInstructionFile(map, this.kekMaterialsProvider, this.cryptoConfig.getCryptoProvider(), jArr2, extraMaterialsDescription, isStrict, this.kms);
        securityCheck(fromInstructionFile, s3ObjectWrapper);
        return adjustToDesiredRange(decrypt(s3ObjectWrapper, fromInstructionFile, jArr2), jArr, unmodifiableMap).getS3Object();
    }

    private S3Object decipherWithMetadata(GetObjectRequest getObjectRequest, long[] jArr, long[] jArr2, S3ObjectWrapper s3ObjectWrapper) {
        ExtraMaterialsDescription extraMaterialsDescription = ExtraMaterialsDescription.NONE;
        boolean isStrict = isStrict();
        if (getObjectRequest instanceof EncryptedGetObjectRequest) {
            EncryptedGetObjectRequest encryptedGetObjectRequest = (EncryptedGetObjectRequest) getObjectRequest;
            extraMaterialsDescription = encryptedGetObjectRequest.getExtraMaterialDescription();
            if (!isStrict) {
                isStrict = encryptedGetObjectRequest.isKeyWrapExpected();
            }
        }
        ContentCryptoMaterial fromObjectMetadata = ContentCryptoMaterial.fromObjectMetadata(s3ObjectWrapper.getObjectMetadata(), this.kekMaterialsProvider, this.cryptoConfig.getCryptoProvider(), jArr2, extraMaterialsDescription, isStrict, this.kms);
        securityCheck(fromObjectMetadata, s3ObjectWrapper);
        return adjustToDesiredRange(decrypt(s3ObjectWrapper, fromObjectMetadata, jArr2), jArr, (Map<String, String>) null).getS3Object();
    }

    /* access modifiers changed from: protected */
    public final S3ObjectWrapper adjustToDesiredRange(S3ObjectWrapper s3ObjectWrapper, long[] jArr, Map<String, String> map) {
        if (jArr == null) {
            return s3ObjectWrapper;
        }
        long instanceLength = (s3ObjectWrapper.getObjectMetadata().getInstanceLength() - ((long) (s3ObjectWrapper.encryptionSchemeOf(map).getTagLengthInBits() / 8))) - 1;
        if (jArr[1] > instanceLength) {
            jArr[1] = instanceLength;
            if (jArr[0] > jArr[1]) {
                IOUtils.closeQuietly(s3ObjectWrapper.getObjectContent(), this.log);
                s3ObjectWrapper.setObjectContent((InputStream) new ByteArrayInputStream(new byte[0]));
                return s3ObjectWrapper;
            }
        }
        if (jArr[0] > jArr[1]) {
            return s3ObjectWrapper;
        }
        try {
            s3ObjectWrapper.setObjectContent(new S3ObjectInputStream(new AdjustedRangeInputStream(s3ObjectWrapper.getObjectContent(), jArr[0], jArr[1])));
            return s3ObjectWrapper;
        } catch (IOException e) {
            throw new AmazonClientException("Error adjusting output to desired byte range: " + e.getMessage());
        }
    }

    public ObjectMetadata getObjectSecurely(GetObjectRequest getObjectRequest, File file) {
        assertParameterNotNull(file, "The destination file parameter must be specified when downloading an object directly to a file");
        S3Object objectSecurely = getObjectSecurely(getObjectRequest);
        BufferedOutputStream bufferedOutputStream = null;
        if (objectSecurely == null) {
            return null;
        }
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[DEFAULT_BYTE_SIZE];
                while (true) {
                    int read = objectSecurely.getObjectContent().read(bArr);
                    if (read > -1) {
                        bufferedOutputStream2.write(bArr, 0, read);
                    } else {
                        IOUtils.closeQuietly(bufferedOutputStream2, this.log);
                        IOUtils.closeQuietly(objectSecurely.getObjectContent(), this.log);
                        return objectSecurely.getObjectMetadata();
                    }
                }
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(bufferedOutputStream, this.log);
                    IOUtils.closeQuietly(objectSecurely.getObjectContent(), this.log);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                IOUtils.closeQuietly(bufferedOutputStream, this.log);
                IOUtils.closeQuietly(objectSecurely.getObjectContent(), this.log);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final MultipartUploadCryptoContext newUploadContext(InitiateMultipartUploadRequest initiateMultipartUploadRequest, ContentCryptoMaterial contentCryptoMaterial) {
        return new MultipartUploadCryptoContext(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), contentCryptoMaterial);
    }

    /* access modifiers changed from: package-private */
    public final CipherLite cipherLiteForNextPart(MultipartUploadCryptoContext multipartUploadCryptoContext) {
        return multipartUploadCryptoContext.getCipherLite();
    }

    /* access modifiers changed from: package-private */
    public final long computeLastPartSize(UploadPartRequest uploadPartRequest) {
        return uploadPartRequest.getPartSize() + ((long) (this.contentCryptoScheme.getTagLengthInBits() / 8));
    }

    private S3ObjectWrapper decrypt(S3ObjectWrapper s3ObjectWrapper, ContentCryptoMaterial contentCryptoMaterial, long[] jArr) {
        s3ObjectWrapper.setObjectContent(new S3ObjectInputStream(new CipherLiteInputStream(s3ObjectWrapper.getObjectContent(), contentCryptoMaterial.getCipherLite(), 2048)));
        return s3ObjectWrapper;
    }

    private void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* access modifiers changed from: protected */
    public final long ciphertextLength(long j) {
        return j + ((long) (this.contentCryptoScheme.getTagLengthInBits() / 8));
    }
}
