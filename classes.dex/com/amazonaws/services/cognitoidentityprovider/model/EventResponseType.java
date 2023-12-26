package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum EventResponseType {
    Success("Success"),
    Failure("Failure");
    
    private static final Map<String, EventResponseType> enumMap = null;
    private String value;

    static {
        EventResponseType eventResponseType;
        EventResponseType eventResponseType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Success", eventResponseType);
        hashMap.put("Failure", eventResponseType2);
    }

    private EventResponseType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static EventResponseType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, EventResponseType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
