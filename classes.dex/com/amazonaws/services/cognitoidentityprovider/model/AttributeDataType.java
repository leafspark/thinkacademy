package com.amazonaws.services.cognitoidentityprovider.model;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Map;

public enum AttributeDataType {
    String("String"),
    Number("Number"),
    DateTime(ExifInterface.TAG_DATETIME),
    Boolean("Boolean");
    
    private static final Map<String, AttributeDataType> enumMap = null;
    private String value;

    static {
        AttributeDataType attributeDataType;
        AttributeDataType attributeDataType2;
        AttributeDataType attributeDataType3;
        AttributeDataType attributeDataType4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("String", attributeDataType);
        hashMap.put("Number", attributeDataType2);
        hashMap.put(ExifInterface.TAG_DATETIME, attributeDataType3);
        hashMap.put("Boolean", attributeDataType4);
    }

    private AttributeDataType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static AttributeDataType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AttributeDataType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
