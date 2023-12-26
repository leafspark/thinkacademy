package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum VerifySoftwareTokenResponseType {
    SUCCESS("SUCCESS"),
    ERROR("ERROR");
    
    private static final Map<String, VerifySoftwareTokenResponseType> enumMap = null;
    private String value;

    static {
        VerifySoftwareTokenResponseType verifySoftwareTokenResponseType;
        VerifySoftwareTokenResponseType verifySoftwareTokenResponseType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SUCCESS", verifySoftwareTokenResponseType);
        hashMap.put("ERROR", verifySoftwareTokenResponseType2);
    }

    private VerifySoftwareTokenResponseType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static VerifySoftwareTokenResponseType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, VerifySoftwareTokenResponseType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
