package com.bonree.sdk.bd;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class b {
    private static final String a = "0123456789ABCDEF";

    private b() {
    }

    public static String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b : bArr) {
            short s = (short) (b & 255);
            byteArrayOutputStream.write(a.charAt((byte) (s >> 4)));
            byteArrayOutputStream.write(a.charAt((byte) (s & 15)));
        }
        return new String(byteArrayOutputStream.toByteArray());
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
        if (byteArray.length % 2 != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i2 = 0; i2 < byteArray.length; i2 += 2) {
            try {
                dataOutputStream.writeByte((((byte) a.indexOf(Character.toUpperCase((char) byteArray[i2]))) << 4) + ((byte) a.indexOf(Character.toUpperCase((char) byteArray[i2 + 1]))));
            } catch (IOException unused) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
