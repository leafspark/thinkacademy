package com.bonree.sdk.bd;

import com.bumptech.glide.load.Key;
import com.igexin.assist.sdk.AssistPushConsts;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c {
    private String a;
    private boolean b;
    private boolean c;

    private static int a(int i) {
        if (i == 1) {
            return 6;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 5 ? -1 : 0;
        }
        return 1;
    }

    private static int b(int i) {
        if (i == 0) {
            return 5;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 3) {
            return 3;
        }
        if (i != 4) {
            return i != 6 ? -1 : 1;
        }
        return 2;
    }

    public static class a {
        private static String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=";
        private static String b = "0123456789ABCDEFGHIJKLMNOPQRSTUV=";

        private a() {
        }
    }

    public c(String str, boolean z, boolean z2) {
        this.a = str;
        this.b = false;
        this.c = false;
    }

    public final String a(byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < (bArr2.length + 4) / 5; i2++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i3 = 5;
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = (i2 * 5) + i4;
                if (i5 < bArr2.length) {
                    sArr[i4] = (short) (bArr2[i5] & 255);
                } else {
                    sArr[i4] = 0;
                    i3--;
                }
            }
            int i6 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? -1 : 0 : 1 : 3 : 4 : 6;
            iArr[0] = (byte) ((sArr[0] >> 3) & 31);
            iArr[1] = (byte) (((sArr[0] & 7) << 2) | ((sArr[1] >> 6) & 3));
            iArr[2] = (byte) ((sArr[1] >> 1) & 31);
            iArr[3] = (byte) (((sArr[1] & 1) << 4) | ((sArr[2] >> 4) & 15));
            iArr[4] = (byte) (((sArr[3] >> 7) & 1) | ((sArr[2] & 15) << 1));
            iArr[5] = (byte) ((sArr[3] >> 2) & 31);
            iArr[6] = (byte) (((sArr[4] >> 5) & 7) | ((sArr[3] & 3) << 3));
            iArr[7] = (byte) (sArr[4] & 31);
            int i7 = 0;
            while (true) {
                i = 8 - i6;
                if (i7 >= i) {
                    break;
                }
                char charAt = this.a.charAt(iArr[i7]);
                if (this.c) {
                    charAt = Character.toLowerCase(charAt);
                }
                byteArrayOutputStream.write(charAt);
                i7++;
            }
            if (this.b) {
                while (i < 8) {
                    byteArrayOutputStream.write(61);
                    i++;
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public final byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes();
        for (byte b2 : bytes) {
            char c2 = (char) b2;
            if (!Character.isWhitespace(c2)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c2));
            }
        }
        char c3 = '=';
        if (!this.b) {
            while (byteArrayOutputStream.size() % 8 != 0) {
                byteArrayOutputStream.write(61);
            }
        } else if (byteArrayOutputStream.size() % 8 != 0) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i = 0;
        for (int i2 = 8; i < byteArray.length / i2; i2 = 8) {
            short[] sArr = new short[i2];
            int[] iArr = new int[5];
            int i3 = i2;
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = (i << 3) + i4;
                if (((char) byteArray[i5]) == c3) {
                    break;
                }
                sArr[i4] = (short) this.a.indexOf(byteArray[i5]);
                if (sArr[i4] < 0) {
                    return null;
                }
                i3--;
            }
            int i6 = i3 != 0 ? i3 != 1 ? i3 != 3 ? i3 != 4 ? i3 != 6 ? -1 : 1 : 2 : 3 : 4 : 5;
            if (i6 < 0) {
                return null;
            }
            iArr[0] = (sArr[0] << 3) | (sArr[1] >> 2);
            iArr[1] = ((sArr[1] & 3) << 6) | (sArr[2] << 1) | (sArr[3] >> 4);
            iArr[2] = ((sArr[3] & 15) << 4) | ((sArr[4] >> 1) & 15);
            iArr[3] = (sArr[4] << 7) | (sArr[5] << 2) | (sArr[6] >> 3);
            iArr[4] = ((sArr[6] & 7) << 5) | sArr[7];
            int i7 = 0;
            while (i7 < i6) {
                try {
                    dataOutputStream.writeByte((byte) iArr[i7]);
                    i7++;
                } catch (IOException unused) {
                }
            }
            i++;
            c3 = '=';
        }
        return byteArrayOutputStream.toByteArray();
    }

    public c() {
    }

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
        String b2 = b(str);
        String[] strArr = {b2.substring(0, 8), b2.substring(8, 16), b2.substring(16, 24), b2.substring(24, 32)};
        long[] jArr = {c(strArr[0]), c(strArr[1]), c(strArr[2]), c(strArr[3])};
        return (j << 32) + ((long) ((int) (jArr[0] * jArr[1] * jArr[2] * jArr[3])));
    }

    private static String b(String str) {
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

    private static long c(String str) {
        String[] strArr = {"a", "b", com.bonree.sdk.ao.c.b, "d", "e", "f"};
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
