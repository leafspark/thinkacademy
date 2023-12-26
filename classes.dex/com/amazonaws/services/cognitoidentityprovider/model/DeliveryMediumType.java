package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum DeliveryMediumType {
    SMS("SMS"),
    EMAIL("EMAIL");
    
    private static final Map<String, DeliveryMediumType> enumMap = null;
    private String value;

    static {
        DeliveryMediumType deliveryMediumType;
        DeliveryMediumType deliveryMediumType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SMS", deliveryMediumType);
        hashMap.put("EMAIL", deliveryMediumType2);
    }

    private DeliveryMediumType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static DeliveryMediumType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, DeliveryMediumType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
