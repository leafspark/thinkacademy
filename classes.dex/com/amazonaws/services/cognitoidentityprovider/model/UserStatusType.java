package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum UserStatusType {
    UNCONFIRMED("UNCONFIRMED"),
    CONFIRMED("CONFIRMED"),
    ARCHIVED("ARCHIVED"),
    COMPROMISED("COMPROMISED"),
    RESET_REQUIRED("RESET_REQUIRED"),
    FORCE_CHANGE_PASSWORD("FORCE_CHANGE_PASSWORD");
    
    private static final Map<String, UserStatusType> enumMap = null;
    private String value;

    static {
        UserStatusType userStatusType;
        UserStatusType userStatusType2;
        UserStatusType userStatusType3;
        UserStatusType userStatusType4;
        UserStatusType userStatusType5;
        UserStatusType userStatusType6;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("UNCONFIRMED", userStatusType);
        hashMap.put("CONFIRMED", userStatusType2);
        hashMap.put("ARCHIVED", userStatusType3);
        hashMap.put("COMPROMISED", userStatusType4);
        hashMap.put("RESET_REQUIRED", userStatusType5);
        hashMap.put("FORCE_CHANGE_PASSWORD", userStatusType6);
    }

    private UserStatusType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static UserStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, UserStatusType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
