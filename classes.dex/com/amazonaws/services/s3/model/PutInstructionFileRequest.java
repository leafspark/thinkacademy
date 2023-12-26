package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class PutInstructionFileRequest extends AmazonWebServiceRequest implements MaterialsDescriptionProvider, EncryptionMaterialsFactory {
    private AccessControlList accessControlList;
    private CannedAccessControlList cannedAcl;
    private final EncryptionMaterials encryptionMaterials;
    private final Map<String, String> matDesc;
    private String redirectLocation;
    private final S3ObjectId s3ObjectId;
    private String storageClass;
    private final String suffix;

    public PutInstructionFileRequest(S3ObjectId s3ObjectId2, Map<String, String> map, String str) {
        Map<String, String> map2;
        if (s3ObjectId2 == null || (s3ObjectId2 instanceof InstructionFileId)) {
            throw new IllegalArgumentException("Invalid s3 object id");
        } else if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("suffix must be specified");
        } else {
            this.s3ObjectId = s3ObjectId2;
            if (map == null) {
                map2 = Collections.EMPTY_MAP;
            } else {
                map2 = Collections.unmodifiableMap(new HashMap(map));
            }
            this.matDesc = map2;
            this.suffix = str;
            this.encryptionMaterials = null;
        }
    }

    public PutInstructionFileRequest(S3ObjectId s3ObjectId2, EncryptionMaterials encryptionMaterials2, String str) {
        if (s3ObjectId2 == null || (s3ObjectId2 instanceof InstructionFileId)) {
            throw new IllegalArgumentException("Invalid s3 object id");
        } else if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("suffix must be specified");
        } else if (encryptionMaterials2 != null) {
            this.s3ObjectId = s3ObjectId2;
            this.suffix = str;
            this.encryptionMaterials = encryptionMaterials2;
            this.matDesc = null;
        } else {
            throw new IllegalArgumentException("encryption materials must be specified");
        }
    }

    public S3ObjectId getS3ObjectId() {
        return this.s3ObjectId;
    }

    public Map<String, String> getMaterialsDescription() {
        Map<String, String> map = this.matDesc;
        return map == null ? this.encryptionMaterials.getMaterialsDescription() : map;
    }

    public EncryptionMaterials getEncryptionMaterials() {
        return this.encryptionMaterials;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public CannedAccessControlList getCannedAcl() {
        return this.cannedAcl;
    }

    public void setCannedAcl(CannedAccessControlList cannedAccessControlList) {
        this.cannedAcl = cannedAccessControlList;
    }

    public PutInstructionFileRequest withCannedAcl(CannedAccessControlList cannedAccessControlList) {
        setCannedAcl(cannedAccessControlList);
        return this;
    }

    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }

    public void setAccessControlList(AccessControlList accessControlList2) {
        this.accessControlList = accessControlList2;
    }

    public PutInstructionFileRequest withAccessControlList(AccessControlList accessControlList2) {
        setAccessControlList(accessControlList2);
        return this;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public PutInstructionFileRequest withRedirectLocation(String str) {
        this.redirectLocation = str;
        return this;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public PutInstructionFileRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public void setStorageClass(StorageClass storageClass2) {
        this.storageClass = storageClass2.toString();
    }

    public PutInstructionFileRequest withStorageClass(StorageClass storageClass2) {
        setStorageClass(storageClass2);
        return this;
    }

    public PutObjectRequest createPutObjectRequest(S3Object s3Object) {
        if (!s3Object.getBucketName().equals(this.s3ObjectId.getBucket()) || !s3Object.getKey().equals(this.s3ObjectId.getKey())) {
            throw new IllegalArgumentException("s3Object passed inconsistent with the instruction file being created");
        }
        InstructionFileId instructionFileId = this.s3ObjectId.instructionFileId(this.suffix);
        return (PutObjectRequest) new PutObjectRequest(instructionFileId.getBucket(), instructionFileId.getKey(), this.redirectLocation).withAccessControlList(this.accessControlList).withCannedAcl(this.cannedAcl).withStorageClass(this.storageClass).withGeneralProgressListener(getGeneralProgressListener()).withRequestMetricCollector(getRequestMetricCollector());
    }
}
