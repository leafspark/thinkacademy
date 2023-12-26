package com.wushuangtech.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtils {
    private static final String TAG = "EncryptUtils";

    public static String AESEncrypt(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String str3 = TAG;
            OmniLog.e(str3, "AESEncrypt -> args empty! sSrc : " + str + " | sKey : " + str2);
            return null;
        } else if (str2.length() != 16) {
            String str4 = TAG;
            OmniLog.e(str4, "AESEncrypt -> sKey len error! " + str2);
            return null;
        } else {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                String str5 = TAG;
                OmniLog.e(str5, "AESEncrypt -> sSrc UnsupportedEncodingException msg : " + e.getLocalizedMessage());
                bArr = null;
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "AES");
                try {
                    Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    if (instance == null) {
                        OmniLog.e(TAG, "AESEncrypt -> Cipher is null!");
                        return null;
                    }
                    try {
                        instance.init(1, secretKeySpec);
                        try {
                            byte[] doFinal = instance.doFinal(bArr);
                            if (doFinal == null) {
                                OmniLog.e(TAG, "AESEncrypt -> doFinal failed! encrypted is null!");
                                return null;
                            }
                            String replaceAll = Base64.encodeToString(doFinal, 0).replaceAll("\n", "");
                            String str6 = TAG;
                            OmniLog.d(str6, "AESEncrypt -> encode successfully! result : " + replaceAll);
                            return replaceAll;
                        } catch (BadPaddingException e2) {
                            String str7 = TAG;
                            OmniLog.e(str7, "AESEncrypt -> BadPaddingException msg : " + e2.getLocalizedMessage());
                            return null;
                        } catch (IllegalBlockSizeException e3) {
                            String str8 = TAG;
                            OmniLog.e(str8, "AESEncrypt -> IllegalBlockSizeException msg : " + e3.getLocalizedMessage());
                            return null;
                        }
                    } catch (InvalidKeyException e4) {
                        String str9 = TAG;
                        OmniLog.e(str9, "AESEncrypt -> InvalidKeyException msg : " + e4.getLocalizedMessage());
                        return null;
                    }
                } catch (NoSuchAlgorithmException e5) {
                    String str10 = TAG;
                    OmniLog.e(str10, "AESEncrypt -> NoSuchAlgorithmException msg : " + e5.getLocalizedMessage());
                    return null;
                } catch (NoSuchPaddingException e6) {
                    String str11 = TAG;
                    OmniLog.e(str11, "AESEncrypt -> NoSuchPaddingException msg : " + e6.getLocalizedMessage());
                    return null;
                }
            } catch (UnsupportedEncodingException e7) {
                String str12 = TAG;
                OmniLog.e(str12, "AESEncrypt -> sKey UnsupportedEncodingException msg : " + e7.getLocalizedMessage());
                return null;
            }
        }
    }
}
