package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum EventFilterType {
    SIGN_IN("SIGN_IN"),
    PASSWORD_CHANGE("PASSWORD_CHANGE"),
    SIGN_UP("SIGN_UP");
    
    private static final Map<String, EventFilterType> enumMap = null;
    private String value;

    static {
        EventFilterType eventFilterType;
        EventFilterType eventFilterType2;
        EventFilterType eventFilterType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SIGN_IN", eventFilterType);
        hashMap.put("PASSWORD_CHANGE", eventFilterType2);
        hashMap.put("SIGN_UP", eventFilterType3);
    }

    private EventFilterType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static EventFilterType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, EventFilterType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
