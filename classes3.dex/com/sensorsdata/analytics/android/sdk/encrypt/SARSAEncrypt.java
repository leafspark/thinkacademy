package com.sensorsdata.analytics.android.sdk.encrypt;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.security.NoSuchAlgorithmException;

class SARSAEncrypt implements SAEncryptListener {
    byte[] aesKey;
    String mEncryptKey;

    public String asymmetricEncryptType() {
        return "RSA";
    }

    public String symmetricEncryptType() {
        return "AES";
    }

    SARSAEncrypt() {
    }

    public String encryptEvent(byte[] bArr) {
        return EncryptUtils.symmetricEncrypt(this.aesKey, bArr, SymmetricEncryptMode.AES);
    }

    public String encryptSymmetricKeyWithPublicKey(String str) {
        if (this.mEncryptKey == null) {
            try {
                byte[] generateSymmetricKey = EncryptUtils.generateSymmetricKey(SymmetricEncryptMode.AES);
                this.aesKey = generateSymmetricKey;
                this.mEncryptKey = EncryptUtils.encryptAESKey(str, generateSymmetricKey, "RSA");
            } catch (NoSuchAlgorithmException e) {
                SALog.printStackTrace(e);
                return null;
            }
        }
        return this.mEncryptKey;
    }
}
