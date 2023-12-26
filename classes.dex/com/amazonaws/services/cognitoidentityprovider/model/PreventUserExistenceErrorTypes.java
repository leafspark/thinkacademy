package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum PreventUserExistenceErrorTypes {
    LEGACY("LEGACY"),
    ENABLED("ENABLED");
    
    private static final Map<String, PreventUserExistenceErrorTypes> enumMap = null;
    private String value;

    static {
        PreventUserExistenceErrorTypes preventUserExistenceErrorTypes;
        PreventUserExistenceErrorTypes preventUserExistenceErrorTypes2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("LEGACY", preventUserExistenceErrorTypes);
        hashMap.put("ENABLED", preventUserExistenceErrorTypes2);
    }

    private PreventUserExistenceErrorTypes(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static PreventUserExistenceErrorTypes fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, PreventUserExistenceErrorTypes> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
