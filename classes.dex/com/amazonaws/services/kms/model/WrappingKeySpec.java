package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum WrappingKeySpec {
    RSA_2048("RSA_2048");
    
    private static final Map<String, WrappingKeySpec> enumMap = null;
    private String value;

    static {
        WrappingKeySpec wrappingKeySpec;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", wrappingKeySpec);
    }

    private WrappingKeySpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static WrappingKeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, WrappingKeySpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
