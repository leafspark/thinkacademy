package com.igexin.b.a.a;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;

public class a {
    public static void a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static boolean a(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0 || length > 256) {
            return false;
        }
        int i = 0;
        for (byte b : bArr) {
            if ((b & 255) == 14 && (i = i + 1) > 3) {
                return false;
            }
        }
        return true;
    }

    public static byte[] a(byte[] bArr, String str) {
        return c(bArr, str);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (!a(bArr2)) {
            throw new IllegalArgumentException("key is fail!");
        } else if (bArr.length >= 1) {
            int[] iArr = new int[WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT];
            for (int i = 0; i < 256; i++) {
                iArr[i] = i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 256; i3++) {
                i2 = ((i2 + iArr[i3]) + (bArr2[i3 % bArr2.length] & 255)) % WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT;
                a(iArr, i3, i2);
            }
            int length = bArr.length;
            byte[] bArr3 = new byte[length];
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                i4 = (i4 + 1) % WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT;
                i5 = (i5 + iArr[i4]) % WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT;
                a(iArr, i4, i5);
                bArr3[i6] = (byte) (iArr[(iArr[i4] + iArr[i5]) % WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT] ^ bArr[i6]);
            }
            return bArr3;
        } else {
            throw new IllegalArgumentException("data is fail!");
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        return d(bArr, str);
    }

    public static byte[] c(byte[] bArr, String str) {
        return a(bArr, str.getBytes());
    }

    public static byte[] d(byte[] bArr, String str) {
        return a(bArr, str.getBytes());
    }
}
