package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public enum CustomerMasterKeySpec {
    RSA_2048("RSA_2048"),
    RSA_3072("RSA_3072"),
    RSA_4096("RSA_4096"),
    ECC_NIST_P256("ECC_NIST_P256"),
    ECC_NIST_P384("ECC_NIST_P384"),
    ECC_NIST_P521("ECC_NIST_P521"),
    ECC_SECG_P256K1("ECC_SECG_P256K1"),
    SYMMETRIC_DEFAULT("SYMMETRIC_DEFAULT");
    
    private static final Map<String, CustomerMasterKeySpec> enumMap = null;
    private String value;

    static {
        CustomerMasterKeySpec customerMasterKeySpec;
        CustomerMasterKeySpec customerMasterKeySpec2;
        CustomerMasterKeySpec customerMasterKeySpec3;
        CustomerMasterKeySpec customerMasterKeySpec4;
        CustomerMasterKeySpec customerMasterKeySpec5;
        CustomerMasterKeySpec customerMasterKeySpec6;
        CustomerMasterKeySpec customerMasterKeySpec7;
        CustomerMasterKeySpec customerMasterKeySpec8;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", customerMasterKeySpec);
        hashMap.put("RSA_3072", customerMasterKeySpec2);
        hashMap.put("RSA_4096", customerMasterKeySpec3);
        hashMap.put("ECC_NIST_P256", customerMasterKeySpec4);
        hashMap.put("ECC_NIST_P384", customerMasterKeySpec5);
        hashMap.put("ECC_NIST_P521", customerMasterKeySpec6);
        hashMap.put("ECC_SECG_P256K1", customerMasterKeySpec7);
        hashMap.put("SYMMETRIC_DEFAULT", customerMasterKeySpec8);
    }

    private CustomerMasterKeySpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static CustomerMasterKeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, CustomerMasterKeySpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
