package com.bonree.sdk.bd;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class d {
    private static final String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    private d() {
    }

    public static String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < (bArr.length + 2) / 3; i++) {
            short[] sArr = new short[3];
            short[] sArr2 = new short[4];
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = (i * 3) + i2;
                if (i3 < bArr.length) {
                    sArr[i2] = (short) (bArr[i3] & 255);
                } else {
                    sArr[i2] = -1;
                }
            }
            sArr2[0] = (short) (sArr[0] >> 2);
            if (sArr[1] == -1) {
                sArr2[1] = (short) ((sArr[0] & 3) << 4);
            } else {
                sArr2[1] = (short) (((sArr[0] & 3) << 4) + (sArr[1] >> 4));
            }
            if (sArr[1] == -1) {
                sArr2[3] = 64;
                sArr2[2] = 64;
            } else if (sArr[2] == -1) {
                sArr2[2] = (short) ((sArr[1] & 15) << 2);
                sArr2[3] = 64;
            } else {
                sArr2[2] = (short) (((sArr[1] & 15) << 2) + (sArr[2] >> 6));
                sArr2[3] = (short) (sArr[2] & 63);
            }
            for (int i4 = 0; i4 < 4; i4++) {
                byteArrayOutputStream.write(a.charAt(sArr2[i4]));
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static String a(byte[] bArr, int i, String str, boolean z) {
        String a2 = a(bArr);
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < a2.length()) {
            stringBuffer.append(str);
            int i3 = i2 + 64;
            if (i3 >= a2.length()) {
                stringBuffer.append(a2.substring(i2));
                if (z) {
                    stringBuffer.append(" )");
                }
            } else {
                stringBuffer.append(a2.substring(i2, i3));
                stringBuffer.append("\n");
            }
            i2 = i3;
        }
        return stringBuffer.toString();
    }

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (!Character.isWhitespace((char) bytes[i])) {
                byteArrayOutputStream.write(bytes[i]);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length % 4 != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i2 = 0; i2 < (byteArray.length + 3) / 4; i2++) {
            short[] sArr = new short[4];
            short[] sArr2 = new short[3];
            for (int i3 = 0; i3 < 4; i3++) {
                sArr[i3] = (short) a.indexOf(byteArray[(i2 << 2) + i3]);
            }
            sArr2[0] = (short) ((sArr[0] << 2) + (sArr[1] >> 4));
            if (sArr[2] == 64) {
                sArr2[2] = -1;
                sArr2[1] = -1;
                if ((sArr[1] & 15) != 0) {
                    return null;
                }
            } else if (sArr[3] == 64) {
                sArr2[1] = (short) (((sArr[1] << 4) + (sArr[2] >> 2)) & 255);
                sArr2[2] = -1;
                if ((sArr[2] & 3) != 0) {
                    return null;
                }
            } else {
                sArr2[1] = (short) (((sArr[1] << 4) + (sArr[2] >> 2)) & 255);
                sArr2[2] = (short) (((sArr[2] << 6) + sArr[3]) & 255);
            }
            int i4 = 0;
            while (i4 < 3) {
                try {
                    if (sArr2[i4] >= 0) {
                        dataOutputStream.writeByte(sArr2[i4]);
                    }
                    i4++;
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
