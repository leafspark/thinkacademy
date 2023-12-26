package com.amazonaws.services.s3.model;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EncryptedPutObjectRequest extends PutObjectRequest implements MaterialsDescriptionProvider, Serializable {
    private Map<String, String> materialsDescription;

    public EncryptedPutObjectRequest(String str, String str2, File file) {
        super(str, str2, file);
    }

    public EncryptedPutObjectRequest(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public EncryptedPutObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        super(str, str2, inputStream, objectMetadata);
    }

    public Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
    }

    public void setMaterialsDescription(Map<String, String> map) {
        Map<String, String> map2;
        if (map == null) {
            map2 = null;
        } else {
            map2 = Collections.unmodifiableMap(new HashMap(map));
        }
        this.materialsDescription = map2;
    }

    public EncryptedPutObjectRequest withMaterialsDescription(Map<String, String> map) {
        setMaterialsDescription(map);
        return this;
    }

    public EncryptedPutObjectRequest clone() {
        HashMap hashMap;
        EncryptedPutObjectRequest encryptedPutObjectRequest = new EncryptedPutObjectRequest(getBucketName(), getKey(), getFile());
        super.copyPutObjectBaseTo(encryptedPutObjectRequest);
        Map<String, String> materialsDescription2 = getMaterialsDescription();
        if (materialsDescription2 == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(materialsDescription2);
        }
        encryptedPutObjectRequest.withMaterialsDescription(hashMap);
        return encryptedPutObjectRequest;
    }
}
