package com.amazonaws.services.cognitoidentity.model;

import java.util.HashMap;
import java.util.Map;

public enum MappingRuleMatchType {
    Equals("Equals"),
    Contains("Contains"),
    StartsWith("StartsWith"),
    NotEqual("NotEqual");
    
    private static final Map<String, MappingRuleMatchType> enumMap = null;
    private String value;

    static {
        MappingRuleMatchType mappingRuleMatchType;
        MappingRuleMatchType mappingRuleMatchType2;
        MappingRuleMatchType mappingRuleMatchType3;
        MappingRuleMatchType mappingRuleMatchType4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Equals", mappingRuleMatchType);
        hashMap.put("Contains", mappingRuleMatchType2);
        hashMap.put("StartsWith", mappingRuleMatchType3);
        hashMap.put("NotEqual", mappingRuleMatchType4);
    }

    private MappingRuleMatchType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static MappingRuleMatchType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, MappingRuleMatchType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
