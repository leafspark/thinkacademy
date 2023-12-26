package com.sensorsdata.analytics.android.sdk.encrypt;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

class SAECEncrypt implements SAEncryptListener {
    byte[] aesKey;
    String mEncryptKey;

    public String asymmetricEncryptType() {
        return "EC";
    }

    public String symmetricEncryptType() {
        return "AES";
    }

    SAECEncrypt() {
    }

    static {
        try {
            Security.addProvider((Provider) Class.forName("org.spongycastle.jce.provider.BouncyCastleProvider").newInstance());
        } catch (Exception e) {
            SALog.i("SA.SAECEncrypt", e.toString());
        }
    }

    public String encryptEvent(byte[] bArr) {
        return EncryptUtils.symmetricEncrypt(this.aesKey, bArr, SymmetricEncryptMode.AES);
    }

    public String encryptSymmetricKeyWithPublicKey(String str) {
        if (this.mEncryptKey == null) {
            try {
                byte[] generateSymmetricKey = EncryptUtils.generateSymmetricKey(SymmetricEncryptMode.AES);
                this.aesKey = generateSymmetricKey;
                this.mEncryptKey = EncryptUtils.encryptAESKey(str, generateSymmetricKey, "EC");
            } catch (NoSuchAlgorithmException e) {
                SALog.printStackTrace(e);
                return null;
            }
        }
        return this.mEncryptKey;
    }
}
