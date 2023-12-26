package com.amazonaws.services.s3.internal.crypto;

import java.security.Key;
import java.security.Provider;

@Deprecated
class S3KeyWrapScheme {
    public static final String AES_WRAP = "AESWrap";
    static final S3KeyWrapScheme NONE = new S3KeyWrapScheme() {
        /* access modifiers changed from: package-private */
        public String getKeyWrapAlgorithm(Key key, Provider provider) {
            return null;
        }

        public String toString() {
            return "NONE";
        }
    };
    public static final String RSA_ECB_OAEP_WITH_SHA256_AND_MGF1_PADDING = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    public String toString() {
        return "S3KeyWrapScheme";
    }

    S3KeyWrapScheme() {
    }

    /* access modifiers changed from: package-private */
    public String getKeyWrapAlgorithm(Key key, Provider provider) {
        String algorithm = key.getAlgorithm();
        if (JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM.equals(algorithm)) {
            return AES_WRAP;
        }
        if (!"RSA".equals(algorithm) || !CryptoRuntime.isRsaKeyWrapAvailable(provider)) {
            return null;
        }
        return RSA_ECB_OAEP_WITH_SHA256_AND_MGF1_PADDING;
    }
}
