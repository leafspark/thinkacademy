package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum TimeUnitsType {
    Seconds("seconds"),
    Minutes("minutes"),
    Hours("hours"),
    Days("days");
    
    private static final Map<String, TimeUnitsType> enumMap = null;
    private String value;

    static {
        TimeUnitsType timeUnitsType;
        TimeUnitsType timeUnitsType2;
        TimeUnitsType timeUnitsType3;
        TimeUnitsType timeUnitsType4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("seconds", timeUnitsType);
        hashMap.put("minutes", timeUnitsType2);
        hashMap.put("hours", timeUnitsType3);
        hashMap.put("days", timeUnitsType4);
    }

    private TimeUnitsType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static TimeUnitsType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, TimeUnitsType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
