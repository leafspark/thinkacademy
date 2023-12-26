package com.bonree.sdk.bs;

import android.os.Build;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.igexin.assist.sdk.AssistPushConsts;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class n {
    private static byte[] a = {1, 2, 3, 4, 5, 6, 7, 8};

    private static byte[] a(byte[] bArr, String str) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("utf-8"), "DES");
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return i.c(instance.doFinal(bArr), 0);
    }

    private static byte[] b(byte[] bArr, String str) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("utf-8"), "DES");
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(i.a(bArr, 0));
    }

    private static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            if (Build.VERSION.SDK_INT >= 19) {
                instance.update(str.getBytes(StandardCharsets.UTF_8));
            } else {
                instance.update(str.getBytes(Key.STRING_CHARSET_NAME));
            }
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
                }
                sb.append(hexString);
            }
            str2 = sb.toString();
        } catch (Throwable unused) {
            str2 = "";
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
