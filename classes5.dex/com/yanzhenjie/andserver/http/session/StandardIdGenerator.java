package com.yanzhenjie.andserver.http.session;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class StandardIdGenerator implements IdGenerator {
    private static final int ID_LENGTH = 30;
    private SecureRandom mRandom = createSecureRandom();

    public String generateId() {
        byte[] bArr = new byte[16];
        StringBuilder sb = new StringBuilder(80);
        int i = 0;
        while (i < 30) {
            this.mRandom.nextBytes(bArr);
            for (int i2 = 0; i2 < 16 && i < 30; i2++) {
                byte b = (byte) ((bArr[i2] & 240) >> 4);
                byte b2 = (byte) (bArr[i2] & 15);
                if (b < 10) {
                    sb.append((char) (b + 48));
                } else {
                    sb.append((char) ((b - 10) + 65));
                }
                if (b2 < 10) {
                    sb.append((char) (b2 + 48));
                } else {
                    sb.append((char) ((b2 - 10) + 65));
                }
                i++;
            }
        }
        return sb.toString();
    }

    private SecureRandom createSecureRandom() {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            secureRandom = new SecureRandom();
        }
        secureRandom.nextInt();
        return secureRandom;
    }
}
