package com.igexin.push.util;

import java.io.UnsupportedEncodingException;

public class g {
    static final /* synthetic */ boolean a = true;

    private g() {
    }

    public static byte[] a(String str, int i) {
        return a(str.getBytes(), i);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        i iVar = new i(i3, new byte[((i2 * 3) / 4)]);
        if (!iVar.a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (iVar.b == iVar.a.length) {
            return iVar.a;
        } else {
            byte[] bArr2 = new byte[iVar.b];
            System.arraycopy(iVar.a, 0, bArr2, 0, iVar.b);
            return bArr2;
        }
    }

    public static String b(byte[] bArr, int i) {
        try {
            return new String(c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        j jVar = new j(i3, (byte[]) null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!jVar.d) {
            int i6 = i2 % 3;
            if (i6 == 1) {
                i4 += 2;
            } else if (i6 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (jVar.e && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!jVar.f) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        jVar.a = new byte[i4];
        jVar.a(bArr, i, i2, true);
        if (a || jVar.b == i4) {
            return jVar.a;
        }
        throw new AssertionError();
    }

    public static byte[] c(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }
}
