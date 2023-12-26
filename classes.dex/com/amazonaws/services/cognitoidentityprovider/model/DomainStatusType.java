package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum DomainStatusType {
    CREATING("CREATING"),
    DELETING("DELETING"),
    UPDATING("UPDATING"),
    ACTIVE("ACTIVE"),
    FAILED("FAILED");
    
    private static final Map<String, DomainStatusType> enumMap = null;
    private String value;

    static {
        DomainStatusType domainStatusType;
        DomainStatusType domainStatusType2;
        DomainStatusType domainStatusType3;
        DomainStatusType domainStatusType4;
        DomainStatusType domainStatusType5;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CREATING", domainStatusType);
        hashMap.put("DELETING", domainStatusType2);
        hashMap.put("UPDATING", domainStatusType3);
        hashMap.put("ACTIVE", domainStatusType4);
        hashMap.put("FAILED", domainStatusType5);
    }

    private DomainStatusType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static DomainStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, DomainStatusType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
