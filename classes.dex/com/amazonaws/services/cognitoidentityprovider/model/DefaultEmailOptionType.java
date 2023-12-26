package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum DefaultEmailOptionType {
    CONFIRM_WITH_LINK("CONFIRM_WITH_LINK"),
    CONFIRM_WITH_CODE("CONFIRM_WITH_CODE");
    
    private static final Map<String, DefaultEmailOptionType> enumMap = null;
    private String value;

    static {
        DefaultEmailOptionType defaultEmailOptionType;
        DefaultEmailOptionType defaultEmailOptionType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CONFIRM_WITH_LINK", defaultEmailOptionType);
        hashMap.put("CONFIRM_WITH_CODE", defaultEmailOptionType2);
    }

    private DefaultEmailOptionType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static DefaultEmailOptionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, DefaultEmailOptionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
