package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import java.util.HashMap;
import java.util.Map;

public enum AuthFlowType {
    USER_SRP_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_SRP),
    REFRESH_TOKEN_AUTH(CognitoServiceConstants.AUTH_TYPE_REFRESH_TOKEN),
    REFRESH_TOKEN(CognitoServiceConstants.AUTH_PARAM_REFRESH_TOKEN),
    CUSTOM_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH),
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    USER_PASSWORD_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD),
    ADMIN_USER_PASSWORD_AUTH("ADMIN_USER_PASSWORD_AUTH");
    
    private static final Map<String, AuthFlowType> enumMap = null;
    private String value;

    static {
        AuthFlowType authFlowType;
        AuthFlowType authFlowType2;
        AuthFlowType authFlowType3;
        AuthFlowType authFlowType4;
        AuthFlowType authFlowType5;
        AuthFlowType authFlowType6;
        AuthFlowType authFlowType7;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_SRP, authFlowType);
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_REFRESH_TOKEN, authFlowType2);
        hashMap.put(CognitoServiceConstants.AUTH_PARAM_REFRESH_TOKEN, authFlowType3);
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH, authFlowType4);
        hashMap.put("ADMIN_NO_SRP_AUTH", authFlowType5);
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD, authFlowType6);
        hashMap.put("ADMIN_USER_PASSWORD_AUTH", authFlowType7);
    }

    private AuthFlowType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static AuthFlowType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AuthFlowType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
