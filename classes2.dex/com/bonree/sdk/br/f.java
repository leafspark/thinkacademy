package com.bonree.sdk.br;

public final class f {
    public static StringBuilder a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length << 1);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X ", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return sb;
    }
}
