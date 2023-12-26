package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum RecoveryOptionNameType {
    Verified_email("verified_email"),
    Verified_phone_number("verified_phone_number"),
    Admin_only("admin_only");
    
    private static final Map<String, RecoveryOptionNameType> enumMap = null;
    private String value;

    static {
        RecoveryOptionNameType recoveryOptionNameType;
        RecoveryOptionNameType recoveryOptionNameType2;
        RecoveryOptionNameType recoveryOptionNameType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("verified_email", recoveryOptionNameType);
        hashMap.put("verified_phone_number", recoveryOptionNameType2);
        hashMap.put("admin_only", recoveryOptionNameType3);
    }

    private RecoveryOptionNameType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static RecoveryOptionNameType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, RecoveryOptionNameType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
