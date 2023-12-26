package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import java.util.HashMap;
import java.util.Map;

public enum ChallengeNameType {
    SMS_MFA("SMS_MFA"),
    SOFTWARE_TOKEN_MFA(CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA),
    SELECT_MFA_TYPE(CognitoServiceConstants.CHLG_TYPE_SELECT_MFA_TYPE),
    MFA_SETUP(CognitoServiceConstants.CHLG_TYPE_MFA_SETUP),
    PASSWORD_VERIFIER(CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER),
    CUSTOM_CHALLENGE(CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE),
    DEVICE_SRP_AUTH(CognitoServiceConstants.CHLG_TYPE_DEVICE_SRP_AUTH),
    DEVICE_PASSWORD_VERIFIER(CognitoServiceConstants.CHLG_TYPE_DEVICE_PASSWORD_VERIFIER),
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    NEW_PASSWORD_REQUIRED(CognitoServiceConstants.CHLG_TYPE_NEW_PASSWORD_REQUIRED);
    
    private static final Map<String, ChallengeNameType> enumMap = null;
    private String value;

    static {
        ChallengeNameType challengeNameType;
        ChallengeNameType challengeNameType2;
        ChallengeNameType challengeNameType3;
        ChallengeNameType challengeNameType4;
        ChallengeNameType challengeNameType5;
        ChallengeNameType challengeNameType6;
        ChallengeNameType challengeNameType7;
        ChallengeNameType challengeNameType8;
        Object obj;
        ChallengeNameType challengeNameType9;
        Object obj2;
        Object obj3;
        ChallengeNameType challengeNameType10;
        Object obj4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SMS_MFA", challengeNameType);
        hashMap.put(CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA, challengeNameType2);
        hashMap.put(CognitoServiceConstants.CHLG_TYPE_SELECT_MFA_TYPE, challengeNameType3);
        hashMap.put(CognitoServiceConstants.CHLG_TYPE_MFA_SETUP, challengeNameType4);
        hashMap.put(obj4, challengeNameType5);
        hashMap.put(obj3, challengeNameType6);
        hashMap.put(obj, challengeNameType7);
        hashMap.put(obj2, challengeNameType8);
        hashMap.put("ADMIN_NO_SRP_AUTH", challengeNameType9);
        hashMap.put(CognitoServiceConstants.CHLG_TYPE_NEW_PASSWORD_REQUIRED, challengeNameType10);
    }

    private ChallengeNameType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ChallengeNameType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ChallengeNameType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
