package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum SigningAlgorithmSpec {
    RSASSA_PSS_SHA_256("RSASSA_PSS_SHA_256"),
    RSASSA_PSS_SHA_384("RSASSA_PSS_SHA_384"),
    RSASSA_PSS_SHA_512("RSASSA_PSS_SHA_512"),
    RSASSA_PKCS1_V1_5_SHA_256("RSASSA_PKCS1_V1_5_SHA_256"),
    RSASSA_PKCS1_V1_5_SHA_384("RSASSA_PKCS1_V1_5_SHA_384"),
    RSASSA_PKCS1_V1_5_SHA_512("RSASSA_PKCS1_V1_5_SHA_512"),
    ECDSA_SHA_256("ECDSA_SHA_256"),
    ECDSA_SHA_384("ECDSA_SHA_384"),
    ECDSA_SHA_512("ECDSA_SHA_512");
    
    private static final Map<String, SigningAlgorithmSpec> enumMap = null;
    private String value;

    static {
        SigningAlgorithmSpec signingAlgorithmSpec;
        SigningAlgorithmSpec signingAlgorithmSpec2;
        SigningAlgorithmSpec signingAlgorithmSpec3;
        SigningAlgorithmSpec signingAlgorithmSpec4;
        SigningAlgorithmSpec signingAlgorithmSpec5;
        SigningAlgorithmSpec signingAlgorithmSpec6;
        SigningAlgorithmSpec signingAlgorithmSpec7;
        SigningAlgorithmSpec signingAlgorithmSpec8;
        SigningAlgorithmSpec signingAlgorithmSpec9;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSASSA_PSS_SHA_256", signingAlgorithmSpec);
        hashMap.put("RSASSA_PSS_SHA_384", signingAlgorithmSpec2);
        hashMap.put("RSASSA_PSS_SHA_512", signingAlgorithmSpec3);
        hashMap.put("RSASSA_PKCS1_V1_5_SHA_256", signingAlgorithmSpec4);
        hashMap.put("RSASSA_PKCS1_V1_5_SHA_384", signingAlgorithmSpec5);
        hashMap.put("RSASSA_PKCS1_V1_5_SHA_512", signingAlgorithmSpec6);
        hashMap.put("ECDSA_SHA_256", signingAlgorithmSpec7);
        hashMap.put("ECDSA_SHA_384", signingAlgorithmSpec8);
        hashMap.put("ECDSA_SHA_512", signingAlgorithmSpec9);
    }

    private SigningAlgorithmSpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static SigningAlgorithmSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, SigningAlgorithmSpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
