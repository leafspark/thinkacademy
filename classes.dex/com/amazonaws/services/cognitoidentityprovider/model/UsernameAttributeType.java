package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum UsernameAttributeType {
    Phone_number("phone_number"),
    Email("email");
    
    private static final Map<String, UsernameAttributeType> enumMap = null;
    private String value;

    static {
        UsernameAttributeType usernameAttributeType;
        UsernameAttributeType usernameAttributeType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("phone_number", usernameAttributeType);
        hashMap.put("email", usernameAttributeType2);
    }

    private UsernameAttributeType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static UsernameAttributeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, UsernameAttributeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
