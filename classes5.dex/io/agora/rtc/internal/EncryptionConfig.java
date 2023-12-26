package io.agora.rtc.internal;

import java.util.Arrays;

public class EncryptionConfig {
    public final byte[] encryptionKdfSalt;
    public String encryptionKey = null;
    public EncryptionMode encryptionMode = EncryptionMode.AES_128_GCM2;

    public enum EncryptionMode {
        AES_128_XTS(1),
        AES_128_ECB(2),
        AES_256_XTS(3),
        SM4_128_ECB(4),
        AES_128_GCM(5),
        AES_256_GCM(6),
        AES_128_GCM2(7),
        AES_256_GCM2(8),
        MODE_END(9);
        
        private int value;

        private EncryptionMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public EncryptionConfig() {
        byte[] bArr = new byte[32];
        this.encryptionKdfSalt = bArr;
        Arrays.fill(bArr, (byte) 0);
    }
}
