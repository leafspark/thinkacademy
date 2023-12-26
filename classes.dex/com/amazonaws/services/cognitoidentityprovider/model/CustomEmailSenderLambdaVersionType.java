package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum CustomEmailSenderLambdaVersionType {
    V1_0("V1_0");
    
    private static final Map<String, CustomEmailSenderLambdaVersionType> enumMap = null;
    private String value;

    static {
        CustomEmailSenderLambdaVersionType customEmailSenderLambdaVersionType;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("V1_0", customEmailSenderLambdaVersionType);
    }

    private CustomEmailSenderLambdaVersionType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static CustomEmailSenderLambdaVersionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, CustomEmailSenderLambdaVersionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
