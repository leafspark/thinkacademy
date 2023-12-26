package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum GrantOperation {
    Decrypt("Decrypt"),
    Encrypt("Encrypt"),
    GenerateDataKey("GenerateDataKey"),
    GenerateDataKeyWithoutPlaintext("GenerateDataKeyWithoutPlaintext"),
    ReEncryptFrom("ReEncryptFrom"),
    ReEncryptTo("ReEncryptTo"),
    Sign("Sign"),
    Verify("Verify"),
    GetPublicKey("GetPublicKey"),
    CreateGrant("CreateGrant"),
    RetireGrant("RetireGrant"),
    DescribeKey("DescribeKey"),
    GenerateDataKeyPair("GenerateDataKeyPair"),
    GenerateDataKeyPairWithoutPlaintext("GenerateDataKeyPairWithoutPlaintext");
    
    private static final Map<String, GrantOperation> enumMap = null;
    private String value;

    static {
        GrantOperation grantOperation;
        GrantOperation grantOperation2;
        GrantOperation grantOperation3;
        GrantOperation grantOperation4;
        GrantOperation grantOperation5;
        GrantOperation grantOperation6;
        GrantOperation grantOperation7;
        GrantOperation grantOperation8;
        GrantOperation grantOperation9;
        GrantOperation grantOperation10;
        GrantOperation grantOperation11;
        GrantOperation grantOperation12;
        GrantOperation grantOperation13;
        GrantOperation grantOperation14;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Decrypt", grantOperation);
        hashMap.put("Encrypt", grantOperation2);
        hashMap.put("GenerateDataKey", grantOperation3);
        hashMap.put("GenerateDataKeyWithoutPlaintext", grantOperation4);
        hashMap.put("ReEncryptFrom", grantOperation5);
        hashMap.put("ReEncryptTo", grantOperation6);
        hashMap.put("Sign", grantOperation7);
        hashMap.put("Verify", grantOperation8);
        hashMap.put("GetPublicKey", grantOperation9);
        hashMap.put("CreateGrant", grantOperation10);
        hashMap.put("RetireGrant", grantOperation11);
        hashMap.put("DescribeKey", grantOperation12);
        hashMap.put("GenerateDataKeyPair", grantOperation13);
        hashMap.put("GenerateDataKeyPairWithoutPlaintext", grantOperation14);
    }

    private GrantOperation(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static GrantOperation fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, GrantOperation> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
