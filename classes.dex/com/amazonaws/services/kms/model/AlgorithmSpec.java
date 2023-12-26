package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum AlgorithmSpec {
    RSAES_PKCS1_V1_5("RSAES_PKCS1_V1_5"),
    RSAES_OAEP_SHA_1("RSAES_OAEP_SHA_1"),
    RSAES_OAEP_SHA_256("RSAES_OAEP_SHA_256");
    
    private static final Map<String, AlgorithmSpec> enumMap = null;
    private String value;

    static {
        AlgorithmSpec algorithmSpec;
        AlgorithmSpec algorithmSpec2;
        AlgorithmSpec algorithmSpec3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSAES_PKCS1_V1_5", algorithmSpec);
        hashMap.put("RSAES_OAEP_SHA_1", algorithmSpec2);
        hashMap.put("RSAES_OAEP_SHA_256", algorithmSpec3);
    }

    private AlgorithmSpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static AlgorithmSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AlgorithmSpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
