package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum KeyManagerType {
    AWS("AWS"),
    CUSTOMER("CUSTOMER");
    
    private static final Map<String, KeyManagerType> enumMap = null;
    private String value;

    static {
        KeyManagerType keyManagerType;
        KeyManagerType keyManagerType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AWS", keyManagerType);
        hashMap.put("CUSTOMER", keyManagerType2);
    }

    private KeyManagerType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static KeyManagerType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeyManagerType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
