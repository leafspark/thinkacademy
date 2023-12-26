package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum UserImportJobStatusType {
    Created("Created"),
    Pending("Pending"),
    InProgress("InProgress"),
    Stopping("Stopping"),
    Expired("Expired"),
    Stopped("Stopped"),
    Failed("Failed"),
    Succeeded("Succeeded");
    
    private static final Map<String, UserImportJobStatusType> enumMap = null;
    private String value;

    static {
        UserImportJobStatusType userImportJobStatusType;
        UserImportJobStatusType userImportJobStatusType2;
        UserImportJobStatusType userImportJobStatusType3;
        UserImportJobStatusType userImportJobStatusType4;
        UserImportJobStatusType userImportJobStatusType5;
        UserImportJobStatusType userImportJobStatusType6;
        UserImportJobStatusType userImportJobStatusType7;
        UserImportJobStatusType userImportJobStatusType8;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Created", userImportJobStatusType);
        hashMap.put("Pending", userImportJobStatusType2);
        hashMap.put("InProgress", userImportJobStatusType3);
        hashMap.put("Stopping", userImportJobStatusType4);
        hashMap.put("Expired", userImportJobStatusType5);
        hashMap.put("Stopped", userImportJobStatusType6);
        hashMap.put("Failed", userImportJobStatusType7);
        hashMap.put("Succeeded", userImportJobStatusType8);
    }

    private UserImportJobStatusType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static UserImportJobStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, UserImportJobStatusType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
