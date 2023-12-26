package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum UserPoolMfaType {
    OFF("OFF"),
    ON("ON"),
    OPTIONAL("OPTIONAL");
    
    private static final Map<String, UserPoolMfaType> enumMap = null;
    private String value;

    static {
        UserPoolMfaType userPoolMfaType;
        UserPoolMfaType userPoolMfaType2;
        UserPoolMfaType userPoolMfaType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("OFF", userPoolMfaType);
        hashMap.put("ON", userPoolMfaType2);
        hashMap.put("OPTIONAL", userPoolMfaType3);
    }

    private UserPoolMfaType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static UserPoolMfaType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, UserPoolMfaType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
