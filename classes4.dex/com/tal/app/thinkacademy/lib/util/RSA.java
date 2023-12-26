package com.tal.app.thinkacademy.lib.util;

import android.util.Base64;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class RSA {
    private static final String ALGORITHM = "RSA";
    private static String RSA_PUBLICE = "";

    private static PublicKey getPublicKeyFromX509(String str, String str2) {
        try {
            return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("获取公约异常");
            return null;
        }
    }

    public static void setRsaPublicKey(String str) {
        RSA_PUBLICE = str;
    }

    public static String encryptByPublic(String str) {
        byte[] bArr;
        try {
            PublicKey publicKeyFromX509 = getPublicKeyFromX509(ALGORITHM, RSA_PUBLICE);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKeyFromX509);
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    if (i3 > 117) {
                        bArr = instance.doFinal(bytes, i, 117);
                    } else {
                        bArr = instance.doFinal(bytes, i, i3);
                    }
                    byteArrayOutputStream.write(bArr, 0, bArr.length);
                    i2++;
                    i = i2 * 117;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return new String(Base64.encode(byteArray, 2));
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String decryptByPublic(String str) {
        byte[] bArr;
        try {
            PublicKey publicKeyFromX509 = getPublicKeyFromX509(ALGORITHM, RSA_PUBLICE);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, publicKeyFromX509);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), "utf-8");
                }
                if (128 == read) {
                    bArr = bArr2;
                } else {
                    bArr = new byte[read];
                    for (int i = 0; i < read; i++) {
                        bArr[i] = bArr2[i];
                    }
                }
                byteArrayOutputStream.write(instance.doFinal(bArr));
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
