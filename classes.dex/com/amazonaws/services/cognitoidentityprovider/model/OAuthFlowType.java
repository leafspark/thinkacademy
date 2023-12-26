package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum OAuthFlowType {
    Code("code"),
    Implicit("implicit"),
    Client_credentials("client_credentials");
    
    private static final Map<String, OAuthFlowType> enumMap = null;
    private String value;

    static {
        OAuthFlowType oAuthFlowType;
        OAuthFlowType oAuthFlowType2;
        OAuthFlowType oAuthFlowType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("code", oAuthFlowType);
        hashMap.put("implicit", oAuthFlowType2);
        hashMap.put("client_credentials", oAuthFlowType3);
    }

    private OAuthFlowType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static OAuthFlowType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, OAuthFlowType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
