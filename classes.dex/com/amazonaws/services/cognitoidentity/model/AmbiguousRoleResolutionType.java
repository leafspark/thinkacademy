package com.amazonaws.services.cognitoidentity.model;

import java.util.HashMap;
import java.util.Map;

public enum AmbiguousRoleResolutionType {
    AuthenticatedRole("AuthenticatedRole"),
    Deny("Deny");
    
    private static final Map<String, AmbiguousRoleResolutionType> enumMap = null;
    private String value;

    static {
        AmbiguousRoleResolutionType ambiguousRoleResolutionType;
        AmbiguousRoleResolutionType ambiguousRoleResolutionType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AuthenticatedRole", ambiguousRoleResolutionType);
        hashMap.put("Deny", ambiguousRoleResolutionType2);
    }

    private AmbiguousRoleResolutionType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static AmbiguousRoleResolutionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AmbiguousRoleResolutionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
