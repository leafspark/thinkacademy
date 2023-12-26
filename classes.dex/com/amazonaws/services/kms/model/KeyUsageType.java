package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum KeyUsageType {
    SIGN_VERIFY("SIGN_VERIFY"),
    ENCRYPT_DECRYPT("ENCRYPT_DECRYPT");
    
    private static final Map<String, KeyUsageType> enumMap = null;
    private String value;

    static {
        KeyUsageType keyUsageType;
        KeyUsageType keyUsageType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SIGN_VERIFY", keyUsageType);
        hashMap.put("ENCRYPT_DECRYPT", keyUsageType2);
    }

    private KeyUsageType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static KeyUsageType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeyUsageType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
