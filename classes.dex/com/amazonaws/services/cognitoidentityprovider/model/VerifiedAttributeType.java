package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum VerifiedAttributeType {
    Phone_number("phone_number"),
    Email("email");
    
    private static final Map<String, VerifiedAttributeType> enumMap = null;
    private String value;

    static {
        VerifiedAttributeType verifiedAttributeType;
        VerifiedAttributeType verifiedAttributeType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("phone_number", verifiedAttributeType);
        hashMap.put("email", verifiedAttributeType2);
    }

    private VerifiedAttributeType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static VerifiedAttributeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, VerifiedAttributeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
