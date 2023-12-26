package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import java.util.HashMap;
import java.util.Map;

public enum StatusType {
    Enabled("Enabled"),
    Disabled(BucketLifecycleConfiguration.DISABLED);
    
    private static final Map<String, StatusType> enumMap = null;
    private String value;

    static {
        StatusType statusType;
        StatusType statusType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Enabled", statusType);
        hashMap.put(BucketLifecycleConfiguration.DISABLED, statusType2);
    }

    private StatusType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static StatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, StatusType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
