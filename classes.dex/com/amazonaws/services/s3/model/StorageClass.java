package com.amazonaws.services.s3.model;

public enum StorageClass {
    Standard("STANDARD"),
    ReducedRedundancy("REDUCED_REDUNDANCY"),
    Glacier("GLACIER"),
    StandardInfrequentAccess("STANDARD_IA"),
    OneZoneInfrequentAccess("ONEZONE_IA"),
    IntelligentTiering("INTELLIGENT_TIERING");
    
    private final String storageClassId;

    public static StorageClass fromValue(String str) throws IllegalArgumentException {
        for (StorageClass storageClass : values()) {
            if (storageClass.toString().equals(str)) {
                return storageClass;
            }
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    private StorageClass(String str) {
        this.storageClassId = str;
    }

    public String toString() {
        return this.storageClassId;
    }
}
