package com.bonree.sdk.agent.business.util;

import java.net.InetAddress;

public final class a {
    private static long a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            if (str.length() == 0) {
                return -1;
            }
            byte[] b = b(str);
            return (long) (((b[0] << 24) & -16777216) | (b[3] & 255) | ((b[2] << 8) & 65280) | ((b[1] << 16) & 16711680));
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static long a(byte[] bArr) {
        return (long) (((bArr[0] << 24) & -16777216) | (bArr[3] & 255) | ((bArr[2] << 8) & 65280) | ((bArr[1] << 16) & 16711680));
    }

    private static byte[] b(String str) {
        try {
            return InetAddress.getByName(str).getAddress();
        } catch (Throwable unused) {
            throw new IllegalArgumentException(str + " is invalid IP");
        }
    }
}
