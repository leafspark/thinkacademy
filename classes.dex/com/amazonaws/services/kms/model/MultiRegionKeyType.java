package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum MultiRegionKeyType {
    PRIMARY("PRIMARY"),
    REPLICA("REPLICA");
    
    private static final Map<String, MultiRegionKeyType> enumMap = null;
    private String value;

    static {
        MultiRegionKeyType multiRegionKeyType;
        MultiRegionKeyType multiRegionKeyType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("PRIMARY", multiRegionKeyType);
        hashMap.put("REPLICA", multiRegionKeyType2);
    }

    private MultiRegionKeyType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static MultiRegionKeyType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, MultiRegionKeyType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
