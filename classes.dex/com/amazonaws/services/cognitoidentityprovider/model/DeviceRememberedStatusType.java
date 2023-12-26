package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum DeviceRememberedStatusType {
    Remembered("remembered"),
    Not_remembered("not_remembered");
    
    private static final Map<String, DeviceRememberedStatusType> enumMap = null;
    private String value;

    static {
        DeviceRememberedStatusType deviceRememberedStatusType;
        DeviceRememberedStatusType deviceRememberedStatusType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("remembered", deviceRememberedStatusType);
        hashMap.put("not_remembered", deviceRememberedStatusType2);
    }

    private DeviceRememberedStatusType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static DeviceRememberedStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, DeviceRememberedStatusType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
