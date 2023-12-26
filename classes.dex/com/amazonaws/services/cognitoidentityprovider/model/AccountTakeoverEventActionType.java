package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum AccountTakeoverEventActionType {
    BLOCK("BLOCK"),
    MFA_IF_CONFIGURED("MFA_IF_CONFIGURED"),
    MFA_REQUIRED("MFA_REQUIRED"),
    NO_ACTION("NO_ACTION");
    
    private static final Map<String, AccountTakeoverEventActionType> enumMap = null;
    private String value;

    static {
        AccountTakeoverEventActionType accountTakeoverEventActionType;
        AccountTakeoverEventActionType accountTakeoverEventActionType2;
        AccountTakeoverEventActionType accountTakeoverEventActionType3;
        AccountTakeoverEventActionType accountTakeoverEventActionType4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("BLOCK", accountTakeoverEventActionType);
        hashMap.put("MFA_IF_CONFIGURED", accountTakeoverEventActionType2);
        hashMap.put("MFA_REQUIRED", accountTakeoverEventActionType3);
        hashMap.put("NO_ACTION", accountTakeoverEventActionType4);
    }

    private AccountTakeoverEventActionType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static AccountTakeoverEventActionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AccountTakeoverEventActionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
