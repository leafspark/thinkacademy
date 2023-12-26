package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum ChallengeName {
    Password("Password"),
    Mfa("Mfa");
    
    private static final Map<String, ChallengeName> enumMap = null;
    private String value;

    static {
        ChallengeName challengeName;
        ChallengeName challengeName2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Password", challengeName);
        hashMap.put("Mfa", challengeName2);
    }

    private ChallengeName(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ChallengeName fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ChallengeName> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
