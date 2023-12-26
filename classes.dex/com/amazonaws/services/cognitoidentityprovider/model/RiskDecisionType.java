package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum RiskDecisionType {
    NoRisk("NoRisk"),
    AccountTakeover("AccountTakeover"),
    Block("Block");
    
    private static final Map<String, RiskDecisionType> enumMap = null;
    private String value;

    static {
        RiskDecisionType riskDecisionType;
        RiskDecisionType riskDecisionType2;
        RiskDecisionType riskDecisionType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("NoRisk", riskDecisionType);
        hashMap.put("AccountTakeover", riskDecisionType2);
        hashMap.put("Block", riskDecisionType3);
    }

    private RiskDecisionType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static RiskDecisionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, RiskDecisionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
