package com.bonree.sdk.bc;

import com.bonree.sdk.ab.i;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class cg {
    private static bn a = bn.b("in-addr.arpa.");
    private static bn b = bn.b("ip6.arpa.");

    private cg() {
    }

    private static bn a(byte[] bArr) {
        if (bArr.length == 4 || bArr.length == 16) {
            StringBuffer stringBuffer = new StringBuffer();
            if (bArr.length == 4) {
                for (int length = bArr.length - 1; length >= 0; length--) {
                    stringBuffer.append(bArr[length] & 255);
                    if (length > 0) {
                        stringBuffer.append(".");
                    }
                }
            } else {
                int[] iArr = new int[2];
                for (int length2 = bArr.length - 1; length2 >= 0; length2--) {
                    iArr[0] = (bArr[length2] & 255) >> 4;
                    iArr[1] = bArr[length2] & 255 & 15;
                    for (int i = 1; i >= 0; i--) {
                        stringBuffer.append(Integer.toHexString(iArr[i]));
                        if (length2 > 0 || i > 0) {
                            stringBuffer.append(".");
                        }
                    }
                }
            }
            try {
                if (bArr.length == 4) {
                    return bn.a(stringBuffer.toString(), a);
                }
                return bn.a(stringBuffer.toString(), b);
            } catch (dc unused) {
                throw new IllegalStateException("name cannot be invalid");
            }
        } else {
            throw new IllegalArgumentException("array must contain 4 or 16 elements");
        }
    }

    private static bn a(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 0 || iArr[i] > 255) {
                throw new IllegalArgumentException("array must contain values between 0 and 255");
            }
            bArr[i] = (byte) iArr[i];
        }
        return a(bArr);
    }

    public static bn a(InetAddress inetAddress) {
        return a(inetAddress.getAddress());
    }

    private static bn a(String str, int i) throws UnknownHostException {
        byte[] a2 = i.a(str, i);
        if (a2 != null) {
            return a(a2);
        }
        throw new UnknownHostException("Invalid IP address");
    }

    private static bn a(String str) throws UnknownHostException {
        byte[] a2 = i.a(str, 1);
        if (a2 == null) {
            a2 = i.a(str, 2);
        }
        if (a2 != null) {
            return a(a2);
        }
        throw new UnknownHostException("Invalid IP address");
    }
}
