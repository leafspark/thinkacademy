package com.bonree.sdk.bd;

public final class e {
    private static final char[] a = "0123456789ABCDEF".toCharArray();

    private static String a(String str, byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2 + "b");
        if (str != null) {
            stringBuffer.append(" (" + str + ")");
        }
        stringBuffer.append(':');
        int length = (stringBuffer.toString().length() + 8) & -8;
        stringBuffer.append(9);
        int i3 = (80 - length) / 3;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 != 0 && i4 % i3 == 0) {
                stringBuffer.append(10);
                for (int i5 = 0; i5 < length / 8; i5++) {
                    stringBuffer.append(9);
                }
            }
            byte b = bArr[i4] & 255;
            char[] cArr = a;
            stringBuffer.append(cArr[b >> 4]);
            stringBuffer.append(cArr[b & 15]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(10);
        return stringBuffer.toString();
    }

    public static String a(String str, byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(length + "b");
        if (str != null) {
            stringBuffer.append(" (" + str + ")");
        }
        stringBuffer.append(':');
        int length2 = (stringBuffer.toString().length() + 8) & -8;
        stringBuffer.append(9);
        int i = (80 - length2) / 3;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0 && i2 % i == 0) {
                stringBuffer.append(10);
                for (int i3 = 0; i3 < length2 / 8; i3++) {
                    stringBuffer.append(9);
                }
            }
            byte b = bArr[i2] & 255;
            char[] cArr = a;
            stringBuffer.append(cArr[b >> 4]);
            stringBuffer.append(cArr[b & 15]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(10);
        return stringBuffer.toString();
    }
}
