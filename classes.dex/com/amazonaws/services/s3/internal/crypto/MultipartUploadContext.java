package com.amazonaws.services.s3.internal.crypto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public abstract class MultipartUploadContext {
    private final String bucketName;
    private boolean hasFinalPartBeenSeen;
    private final String key;
    private Map<String, String> materialsDescription;

    protected MultipartUploadContext(String str, String str2) {
        this.bucketName = str;
        this.key = str2;
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public final String getKey() {
        return this.key;
    }

    public final boolean hasFinalPartBeenSeen() {
        return this.hasFinalPartBeenSeen;
    }

    public final void setHasFinalPartBeenSeen(boolean z) {
        this.hasFinalPartBeenSeen = z;
    }

    public final Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
    }

    public final void setMaterialsDescription(Map<String, String> map) {
        Map<String, String> map2;
        if (map == null) {
            map2 = null;
        } else {
            map2 = Collections.unmodifiableMap(new HashMap(map));
        }
        this.materialsDescription = map2;
    }
}
