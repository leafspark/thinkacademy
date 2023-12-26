package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum FeedbackValueType {
    Valid("Valid"),
    Invalid("Invalid");
    
    private static final Map<String, FeedbackValueType> enumMap = null;
    private String value;

    static {
        FeedbackValueType feedbackValueType;
        FeedbackValueType feedbackValueType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Valid", feedbackValueType);
        hashMap.put("Invalid", feedbackValueType2);
    }

    private FeedbackValueType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static FeedbackValueType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, FeedbackValueType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
