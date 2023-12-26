package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum MessageActionType {
    RESEND("RESEND"),
    SUPPRESS("SUPPRESS");
    
    private static final Map<String, MessageActionType> enumMap = null;
    private String value;

    static {
        MessageActionType messageActionType;
        MessageActionType messageActionType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RESEND", messageActionType);
        hashMap.put("SUPPRESS", messageActionType2);
    }

    private MessageActionType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static MessageActionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, MessageActionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
