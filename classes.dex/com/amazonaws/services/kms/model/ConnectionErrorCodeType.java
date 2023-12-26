package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum ConnectionErrorCodeType {
    INVALID_CREDENTIALS("INVALID_CREDENTIALS"),
    CLUSTER_NOT_FOUND("CLUSTER_NOT_FOUND"),
    NETWORK_ERRORS("NETWORK_ERRORS"),
    INTERNAL_ERROR("INTERNAL_ERROR"),
    INSUFFICIENT_CLOUDHSM_HSMS("INSUFFICIENT_CLOUDHSM_HSMS"),
    USER_LOCKED_OUT("USER_LOCKED_OUT"),
    USER_NOT_FOUND("USER_NOT_FOUND"),
    USER_LOGGED_IN("USER_LOGGED_IN"),
    SUBNET_NOT_FOUND("SUBNET_NOT_FOUND");
    
    private static final Map<String, ConnectionErrorCodeType> enumMap = null;
    private String value;

    static {
        ConnectionErrorCodeType connectionErrorCodeType;
        ConnectionErrorCodeType connectionErrorCodeType2;
        ConnectionErrorCodeType connectionErrorCodeType3;
        ConnectionErrorCodeType connectionErrorCodeType4;
        ConnectionErrorCodeType connectionErrorCodeType5;
        ConnectionErrorCodeType connectionErrorCodeType6;
        ConnectionErrorCodeType connectionErrorCodeType7;
        ConnectionErrorCodeType connectionErrorCodeType8;
        ConnectionErrorCodeType connectionErrorCodeType9;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("INVALID_CREDENTIALS", connectionErrorCodeType);
        hashMap.put("CLUSTER_NOT_FOUND", connectionErrorCodeType2);
        hashMap.put("NETWORK_ERRORS", connectionErrorCodeType3);
        hashMap.put("INTERNAL_ERROR", connectionErrorCodeType4);
        hashMap.put("INSUFFICIENT_CLOUDHSM_HSMS", connectionErrorCodeType5);
        hashMap.put("USER_LOCKED_OUT", connectionErrorCodeType6);
        hashMap.put("USER_NOT_FOUND", connectionErrorCodeType7);
        hashMap.put("USER_LOGGED_IN", connectionErrorCodeType8);
        hashMap.put("SUBNET_NOT_FOUND", connectionErrorCodeType9);
    }

    private ConnectionErrorCodeType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ConnectionErrorCodeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ConnectionErrorCodeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
