package com.amazonaws.services.cognitoidentity.model;

import java.util.HashMap;
import java.util.Map;

public enum RoleMappingType {
    Token("Token"),
    Rules("Rules");
    
    private static final Map<String, RoleMappingType> enumMap = null;
    private String value;

    static {
        RoleMappingType roleMappingType;
        RoleMappingType roleMappingType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Token", roleMappingType);
        hashMap.put("Rules", roleMappingType2);
    }

    private RoleMappingType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static RoleMappingType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, RoleMappingType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
