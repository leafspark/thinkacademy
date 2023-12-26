package com.sensorsdata.analytics.android.sdk.encrypt;

enum SymmetricEncryptMode {
    AES("AES", "AES/CBC/PKCS5Padding"),
    SM4("SM4", "SM4/CBC/PKCS5Padding");
    
    public String algorithm;
    public String transformation;

    private SymmetricEncryptMode(String str, String str2) {
        this.algorithm = str;
        this.transformation = str2;
    }
}
