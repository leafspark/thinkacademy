package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum OriginType {
    AWS_KMS("AWS_KMS"),
    EXTERNAL("EXTERNAL"),
    AWS_CLOUDHSM("AWS_CLOUDHSM");
    
    private static final Map<String, OriginType> enumMap = null;
    private String value;

    static {
        OriginType originType;
        OriginType originType2;
        OriginType originType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AWS_KMS", originType);
        hashMap.put("EXTERNAL", originType2);
        hashMap.put("AWS_CLOUDHSM", originType3);
    }

    private OriginType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static OriginType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, OriginType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
