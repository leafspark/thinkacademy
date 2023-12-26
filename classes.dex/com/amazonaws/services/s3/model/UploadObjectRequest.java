package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.UploadObjectObserver;
import com.amazonaws.services.s3.internal.MultiFileOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class UploadObjectRequest extends AbstractPutObjectRequest implements MaterialsDescriptionProvider, Serializable {
    static final int MIN_PART_SIZE = 5242880;
    private static final long serialVersionUID = 1;
    private long diskLimit = Long.MAX_VALUE;
    private transient ExecutorService executorService;
    private Map<String, String> materialsDescription;
    private transient MultiFileOutputStream multiFileOutputStream;
    private long partSize = 5242880;
    private transient UploadObjectObserver uploadObjectObserver;
    private ObjectMetadata uploadPartMetadata;

    public UploadObjectRequest(String str, String str2, File file) {
        super(str, str2, file);
    }

    public UploadObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        super(str, str2, inputStream, objectMetadata);
    }

    public long getPartSize() {
        return this.partSize;
    }

    public UploadObjectRequest withPartSize(long j) {
        if (j >= 5242880) {
            this.partSize = j;
            return this;
        }
        throw new IllegalArgumentException("partSize must be at least 5242880");
    }

    public long getDiskLimit() {
        return this.diskLimit;
    }

    public UploadObjectRequest withDiskLimit(long j) {
        this.diskLimit = j;
        return this;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public UploadObjectRequest withExecutorService(ExecutorService executorService2) {
        this.executorService = executorService2;
        return this;
    }

    public MultiFileOutputStream getMultiFileOutputStream() {
        return this.multiFileOutputStream;
    }

    public UploadObjectRequest withMultiFileOutputStream(MultiFileOutputStream multiFileOutputStream2) {
        this.multiFileOutputStream = multiFileOutputStream2;
        return this;
    }

    public UploadObjectObserver getUploadObjectObserver() {
        return this.uploadObjectObserver;
    }

    public UploadObjectRequest withUploadObjectObserver(UploadObjectObserver uploadObjectObserver2) {
        this.uploadObjectObserver = uploadObjectObserver2;
        return this;
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

    public UploadObjectRequest withMaterialsDescription(Map<String, String> map) {
        setMaterialsDescription(map);
        return this;
    }

    public ObjectMetadata getUploadPartMetadata() {
        return this.uploadPartMetadata;
    }

    public void setUploadPartMetadata(ObjectMetadata objectMetadata) {
        this.uploadPartMetadata = objectMetadata;
    }

    public <T extends UploadObjectRequest> T withUploadPartMetadata(ObjectMetadata objectMetadata) {
        setUploadPartMetadata(objectMetadata);
        return this;
    }

    public UploadObjectRequest clone() {
        HashMap hashMap;
        UploadObjectRequest uploadObjectRequest = (UploadObjectRequest) super.clone();
        super.copyPutObjectBaseTo(uploadObjectRequest);
        Map<String, String> materialsDescription2 = getMaterialsDescription();
        ObjectMetadata uploadPartMetadata2 = getUploadPartMetadata();
        ObjectMetadata objectMetadata = null;
        if (materialsDescription2 == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(materialsDescription2);
        }
        UploadObjectRequest withUploadObjectObserver = uploadObjectRequest.withMaterialsDescription(hashMap).withDiskLimit(getDiskLimit()).withExecutorService(getExecutorService()).withPartSize(getPartSize()).withUploadObjectObserver(getUploadObjectObserver());
        if (uploadPartMetadata2 != null) {
            objectMetadata = uploadPartMetadata2.clone();
        }
        return withUploadObjectObserver.withUploadPartMetadata(objectMetadata);
    }
}
