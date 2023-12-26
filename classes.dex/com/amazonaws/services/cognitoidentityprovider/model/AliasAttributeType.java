package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum AliasAttributeType {
    Phone_number("phone_number"),
    Email("email"),
    Preferred_username("preferred_username");
    
    private static final Map<String, AliasAttributeType> enumMap = null;
    private String value;

    static {
        AliasAttributeType aliasAttributeType;
        AliasAttributeType aliasAttributeType2;
        AliasAttributeType aliasAttributeType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("phone_number", aliasAttributeType);
        hashMap.put("email", aliasAttributeType2);
        hashMap.put("preferred_username", aliasAttributeType3);
    }

    private AliasAttributeType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static AliasAttributeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AliasAttributeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
