package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum AdvancedSecurityModeType {
    OFF("OFF"),
    AUDIT("AUDIT"),
    ENFORCED("ENFORCED");
    
    private static final Map<String, AdvancedSecurityModeType> enumMap = null;
    private String value;

    static {
        AdvancedSecurityModeType advancedSecurityModeType;
        AdvancedSecurityModeType advancedSecurityModeType2;
        AdvancedSecurityModeType advancedSecurityModeType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("OFF", advancedSecurityModeType);
        hashMap.put("AUDIT", advancedSecurityModeType2);
        hashMap.put("ENFORCED", advancedSecurityModeType3);
    }

    private AdvancedSecurityModeType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static AdvancedSecurityModeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AdvancedSecurityModeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
