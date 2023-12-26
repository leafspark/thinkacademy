package com.sensorsdata.analytics.android.sdk.encrypt;

public class SecreteKey {
    public String asymmetricEncryptType;
    public String key;
    public String symmetricEncryptType;
    public int version;

    public SecreteKey(String str, int i, String str2, String str3) {
        this.key = str;
        this.version = i;
        this.symmetricEncryptType = str2;
        this.asymmetricEncryptType = str3;
    }

    public String toString() {
        return "{\"key\":\"" + this.key + "\",\"version\":\"" + this.version + "\",\"symmetricEncryptType\":\"" + this.symmetricEncryptType + "\",\"asymmetricEncryptType\":\"" + this.asymmetricEncryptType + "\"}";
    }
}
