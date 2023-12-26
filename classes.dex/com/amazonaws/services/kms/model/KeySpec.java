package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum KeySpec {
    RSA_2048("RSA_2048"),
    RSA_3072("RSA_3072"),
    RSA_4096("RSA_4096"),
    ECC_NIST_P256("ECC_NIST_P256"),
    ECC_NIST_P384("ECC_NIST_P384"),
    ECC_NIST_P521("ECC_NIST_P521"),
    ECC_SECG_P256K1("ECC_SECG_P256K1"),
    SYMMETRIC_DEFAULT("SYMMETRIC_DEFAULT");
    
    private static final Map<String, KeySpec> enumMap = null;
    private String value;

    static {
        KeySpec keySpec;
        KeySpec keySpec2;
        KeySpec keySpec3;
        KeySpec keySpec4;
        KeySpec keySpec5;
        KeySpec keySpec6;
        KeySpec keySpec7;
        KeySpec keySpec8;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", keySpec);
        hashMap.put("RSA_3072", keySpec2);
        hashMap.put("RSA_4096", keySpec3);
        hashMap.put("ECC_NIST_P256", keySpec4);
        hashMap.put("ECC_NIST_P384", keySpec5);
        hashMap.put("ECC_NIST_P521", keySpec6);
        hashMap.put("ECC_SECG_P256K1", keySpec7);
        hashMap.put("SYMMETRIC_DEFAULT", keySpec8);
    }

    private KeySpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static KeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeySpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
