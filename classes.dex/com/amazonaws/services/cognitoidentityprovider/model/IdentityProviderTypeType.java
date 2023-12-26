package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum IdentityProviderTypeType {
    SAML("SAML"),
    Facebook("Facebook"),
    Google("Google"),
    LoginWithAmazon("LoginWithAmazon"),
    SignInWithApple("SignInWithApple"),
    OIDC("OIDC");
    
    private static final Map<String, IdentityProviderTypeType> enumMap = null;
    private String value;

    static {
        IdentityProviderTypeType identityProviderTypeType;
        IdentityProviderTypeType identityProviderTypeType2;
        IdentityProviderTypeType identityProviderTypeType3;
        IdentityProviderTypeType identityProviderTypeType4;
        IdentityProviderTypeType identityProviderTypeType5;
        IdentityProviderTypeType identityProviderTypeType6;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SAML", identityProviderTypeType);
        hashMap.put("Facebook", identityProviderTypeType2);
        hashMap.put("Google", identityProviderTypeType3);
        hashMap.put("LoginWithAmazon", identityProviderTypeType4);
        hashMap.put("SignInWithApple", identityProviderTypeType5);
        hashMap.put("OIDC", identityProviderTypeType6);
    }

    private IdentityProviderTypeType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static IdentityProviderTypeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, IdentityProviderTypeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
