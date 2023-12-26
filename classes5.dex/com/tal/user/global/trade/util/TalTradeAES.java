package com.tal.user.global.trade.util;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

public class TalTradeAES {
    public static final String aesPWD = "adfd32dfasdfDkjdaf23D814jsdl34z3";

    public static String aesDecode(String str) throws Exception {
        String key = JNISecurity.getKey();
        String substring = disgest(key).substring(8, 24);
        String substring2 = key.substring(0, 32);
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(substring2.getBytes(), "AES");
        byte[] base64Decode = base64Decode(str.getBytes());
        instance.init(2, secretKeySpec, new IvParameterSpec(substring.getBytes()));
        return new String(instance.doFinal(base64Decode)).trim();
    }

    public static String aesPasswordDecode(String str) throws Exception {
        Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(MD5Utils.disgest(aesPWD).toLowerCase().getBytes(), "AES");
        byte[] base64Decode = base64Decode(str.getBytes());
        instance.init(2, secretKeySpec);
        return new String(instance.doFinal(base64Decode)).trim();
    }

    public static String aesEncode(String str) throws Exception {
        String pkcs7padding = pkcs7padding(str);
        String substring = JNISecurity.getKey().substring(0, 32);
        String substring2 = disgest(substring).substring(8, 24);
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        int blockSize = instance.getBlockSize();
        byte[] bytes = pkcs7padding.getBytes();
        int length = bytes.length;
        int i = length % blockSize;
        if (i != 0) {
            length += blockSize - i;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        instance.init(1, new SecretKeySpec(substring.getBytes("utf-8"), "AES"), new IvParameterSpec(substring2.getBytes()));
        return contentPostHandler(base64Encode(instance.doFinal(bArr)));
    }

    private static byte[] base64Decode(byte[] bArr) {
        return Base64.decode(bArr, 0);
    }

    private static String base64Encode(byte[] bArr) {
        return new String(Base64.encode(bArr, 0));
    }

    private static String contentPreHandler(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length() % 4; i++) {
            sb.append("=");
        }
        return sb.toString().replaceAll("-", "+").replaceAll("_", "/");
    }

    private static String pkcs7padding(String str) {
        int length = 16 - (str.length() % 16);
        String str2 = "";
        for (int i = 0; i < length; i++) {
            str2 = str2 + ((char) length);
        }
        return str + str2;
    }

    private static String contentPostHandler(String str) {
        return str.replaceAll("\\+", "-").replaceAll("/", "_").replaceAll("=", "");
    }

    public static String disgest(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() < 2) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
