package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum ExpirationModelType {
    KEY_MATERIAL_EXPIRES("KEY_MATERIAL_EXPIRES"),
    KEY_MATERIAL_DOES_NOT_EXPIRE("KEY_MATERIAL_DOES_NOT_EXPIRE");
    
    private static final Map<String, ExpirationModelType> enumMap = null;
    private String value;

    static {
        ExpirationModelType expirationModelType;
        ExpirationModelType expirationModelType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("KEY_MATERIAL_EXPIRES", expirationModelType);
        hashMap.put("KEY_MATERIAL_DOES_NOT_EXPIRE", expirationModelType2);
    }

    private ExpirationModelType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ExpirationModelType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ExpirationModelType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
