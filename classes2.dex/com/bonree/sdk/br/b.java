package com.bonree.sdk.br;

public final class b {
    private static final String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static final String b = "==";

    private b() {
    }

    public static String a(byte[] bArr) {
        int length = (3 - (bArr.length % 3)) % 3;
        byte[] bArr2 = new byte[(bArr.length + length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 3) {
            int i2 = ((bArr2[i] & 255) << 16) + ((bArr2[i + 1] & 255) << 8) + (bArr2[i + 2] & 255);
            sb.append(a.charAt((i2 >> 18) & 63));
            sb.append(a.charAt((i2 >> 12) & 63));
            sb.append(a.charAt((i2 >> 6) & 63));
            sb.append(a.charAt(i2 & 63));
        }
        return sb.substring(0, sb.length() - length) + b.substring(0, length);
    }
}
