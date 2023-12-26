package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum DataKeySpec {
    AES_256("AES_256"),
    AES_128("AES_128");
    
    private static final Map<String, DataKeySpec> enumMap = null;
    private String value;

    static {
        DataKeySpec dataKeySpec;
        DataKeySpec dataKeySpec2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AES_256", dataKeySpec);
        hashMap.put("AES_128", dataKeySpec2);
    }

    private DataKeySpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static DataKeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, DataKeySpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
