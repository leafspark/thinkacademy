package com.bonree.sdk.bs;

import com.bonree.sdk.ao.c;
import com.bumptech.glide.load.Key;
import com.igexin.assist.sdk.AssistPushConsts;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ab {
    private static long a(String str, long j) {
        if (str == null) {
            return -1;
        }
        if (str != null) {
            try {
                if (str.indexOf("?") >= 0) {
                    str = str.substring(0, str.indexOf("?"));
                }
            } catch (Throwable unused) {
                return 0;
            }
        }
        String a = a(str);
        String[] strArr = {a.substring(0, 8), a.substring(8, 16), a.substring(16, 24), a.substring(24, 32)};
        long[] jArr = {b(strArr[0]), b(strArr[1]), b(strArr[2]), b(strArr[3])};
        return (j << 32) + ((long) ((int) (jArr[0] * jArr[1] * jArr[2] * jArr[3])));
    }

    private static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(Key.STRING_CHARSET_NAME));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                if (Integer.toHexString(digest[i] & 255).length() == 1) {
                    stringBuffer.append(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
                    stringBuffer.append(Integer.toHexString(digest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i] & 255));
                }
            }
            return stringBuffer.toString();
        } catch (IOException | NoSuchAlgorithmException unused) {
            return str;
        }
    }

    private static long b(String str) {
        String[] strArr = {"a", "b", c.b, "d", "e", "f"};
        int i = 1;
        long j = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            String substring = str.substring(length, length + 1);
            for (int i2 = 0; i2 < 6; i2++) {
                if (substring.equalsIgnoreCase(strArr[i2])) {
                    substring = "1" + String.valueOf(i2);
                }
            }
            j += Long.parseLong(substring) * ((long) i);
            i <<= 4;
        }
        return j;
    }
}
