package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum RiskLevelType {
    Low("Low"),
    Medium("Medium"),
    High("High");
    
    private static final Map<String, RiskLevelType> enumMap = null;
    private String value;

    static {
        RiskLevelType riskLevelType;
        RiskLevelType riskLevelType2;
        RiskLevelType riskLevelType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Low", riskLevelType);
        hashMap.put("Medium", riskLevelType2);
        hashMap.put("High", riskLevelType3);
    }

    private RiskLevelType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static RiskLevelType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, RiskLevelType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
