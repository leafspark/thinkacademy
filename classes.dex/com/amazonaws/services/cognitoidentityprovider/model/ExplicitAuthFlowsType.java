package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import java.util.HashMap;
import java.util.Map;

public enum ExplicitAuthFlowsType {
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    CUSTOM_AUTH_FLOW_ONLY("CUSTOM_AUTH_FLOW_ONLY"),
    USER_PASSWORD_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD),
    ALLOW_ADMIN_USER_PASSWORD_AUTH("ALLOW_ADMIN_USER_PASSWORD_AUTH"),
    ALLOW_CUSTOM_AUTH("ALLOW_CUSTOM_AUTH"),
    ALLOW_USER_PASSWORD_AUTH("ALLOW_USER_PASSWORD_AUTH"),
    ALLOW_USER_SRP_AUTH("ALLOW_USER_SRP_AUTH"),
    ALLOW_REFRESH_TOKEN_AUTH("ALLOW_REFRESH_TOKEN_AUTH");
    
    private static final Map<String, ExplicitAuthFlowsType> enumMap = null;
    private String value;

    static {
        ExplicitAuthFlowsType explicitAuthFlowsType;
        ExplicitAuthFlowsType explicitAuthFlowsType2;
        ExplicitAuthFlowsType explicitAuthFlowsType3;
        ExplicitAuthFlowsType explicitAuthFlowsType4;
        ExplicitAuthFlowsType explicitAuthFlowsType5;
        ExplicitAuthFlowsType explicitAuthFlowsType6;
        ExplicitAuthFlowsType explicitAuthFlowsType7;
        ExplicitAuthFlowsType explicitAuthFlowsType8;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("ADMIN_NO_SRP_AUTH", explicitAuthFlowsType);
        hashMap.put("CUSTOM_AUTH_FLOW_ONLY", explicitAuthFlowsType2);
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD, explicitAuthFlowsType3);
        hashMap.put("ALLOW_ADMIN_USER_PASSWORD_AUTH", explicitAuthFlowsType4);
        hashMap.put("ALLOW_CUSTOM_AUTH", explicitAuthFlowsType5);
        hashMap.put("ALLOW_USER_PASSWORD_AUTH", explicitAuthFlowsType6);
        hashMap.put("ALLOW_USER_SRP_AUTH", explicitAuthFlowsType7);
        hashMap.put("ALLOW_REFRESH_TOKEN_AUTH", explicitAuthFlowsType8);
    }

    private ExplicitAuthFlowsType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ExplicitAuthFlowsType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ExplicitAuthFlowsType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
