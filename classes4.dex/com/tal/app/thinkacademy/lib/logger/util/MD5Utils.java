package com.tal.app.thinkacademy.lib.logger.util;

import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            try {
                instance.update(str.getBytes("utf-8"));
                return new String(encodeHex(instance.digest()));
            } catch (UnsupportedEncodingException unused) {
                throw new IllegalStateException("System doesn't support your  EncodingException.");
            }
        } catch (NoSuchAlgorithmException unused2) {
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }
    }

    public static String md5sum(String str) {
        try {
            return md5Stream(new FileInputStream(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String md5Stream(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                } else {
                    inputStream.close();
                    return new String(encodeHex(instance.digest()));
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static char[] encodeHex(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = DIGITS;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return cArr;
    }

    public static String disgest(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    sb.append(EnterRoomMuteData.STATUS_UN_MUTE);
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
