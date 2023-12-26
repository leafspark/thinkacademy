package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum CompromisedCredentialsEventActionType {
    BLOCK("BLOCK"),
    NO_ACTION("NO_ACTION");
    
    private static final Map<String, CompromisedCredentialsEventActionType> enumMap = null;
    private String value;

    static {
        CompromisedCredentialsEventActionType compromisedCredentialsEventActionType;
        CompromisedCredentialsEventActionType compromisedCredentialsEventActionType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("BLOCK", compromisedCredentialsEventActionType);
        hashMap.put("NO_ACTION", compromisedCredentialsEventActionType2);
    }

    private CompromisedCredentialsEventActionType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static CompromisedCredentialsEventActionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, CompromisedCredentialsEventActionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
