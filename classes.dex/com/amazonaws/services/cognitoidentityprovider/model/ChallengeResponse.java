package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum ChallengeResponse {
    Success("Success"),
    Failure("Failure");
    
    private static final Map<String, ChallengeResponse> enumMap = null;
    private String value;

    static {
        ChallengeResponse challengeResponse;
        ChallengeResponse challengeResponse2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Success", challengeResponse);
        hashMap.put("Failure", challengeResponse2);
    }

    private ChallengeResponse(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ChallengeResponse fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ChallengeResponse> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
