package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum ConnectionStateType {
    CONNECTED("CONNECTED"),
    CONNECTING("CONNECTING"),
    FAILED("FAILED"),
    DISCONNECTED("DISCONNECTED"),
    DISCONNECTING("DISCONNECTING");
    
    private static final Map<String, ConnectionStateType> enumMap = null;
    private String value;

    static {
        ConnectionStateType connectionStateType;
        ConnectionStateType connectionStateType2;
        ConnectionStateType connectionStateType3;
        ConnectionStateType connectionStateType4;
        ConnectionStateType connectionStateType5;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CONNECTED", connectionStateType);
        hashMap.put("CONNECTING", connectionStateType2);
        hashMap.put("FAILED", connectionStateType3);
        hashMap.put("DISCONNECTED", connectionStateType4);
        hashMap.put("DISCONNECTING", connectionStateType5);
    }

    private ConnectionStateType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ConnectionStateType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ConnectionStateType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
