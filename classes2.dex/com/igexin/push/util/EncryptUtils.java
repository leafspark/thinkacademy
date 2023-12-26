package com.igexin.push.util;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import com.igexin.b.a.a.a;
import com.igexin.b.a.b.e;
import com.igexin.b.a.c.b;
import com.igexin.push.core.d;
import com.igexin.push.extension.mod.SecurityUtils;
import java.security.MessageDigest;

public class EncryptUtils {
    private static final String a = "com.igexin.push.util.EncryptUtils";
    private static boolean b = false;
    private static int c = 0;
    private static byte[] d = null;
    private static byte[] e = null;
    public static String errorMsg = "";

    static {
        try {
            if (SecurityUtils.b) {
                d = initSocketAESKey();
                byte[] initHttpAESKey = initHttpAESKey();
                e = initHttpAESKey;
                b = (d == null || initHttpAESKey == null || getSocketAESKey() == null || getHttpAESKey() == null || getRSAKeyId() == null || getVersion() == null) ? false : true;
            }
        } catch (Throwable th) {
            b.a(a + "|load so error = " + th.toString(), new Object[0]);
            b = false;
            errorMsg = th.getMessage();
        }
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg = SecurityUtils.c;
        }
        if (!b) {
            b.a(a + "|load so error ++++++++", new Object[0]);
            if (TextUtils.isEmpty(errorMsg)) {
                errorMsg = "value = null, normal error";
                return;
            }
            return;
        }
        b.a(a + "|load so success ~~~~~~~", new Object[0]);
    }

    public static byte[] aesDecHttp(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.c(e, bArr, bArr2);
    }

    public static byte[] aesDecSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.g(d, bArr, bArr2);
    }

    public static byte[] aesEncHttp(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.b(e, bArr, bArr2);
    }

    public static byte[] aesEncSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.f(d, bArr, bArr2);
    }

    public static byte[] altAesDecSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m(bArr, bArr2);
    }

    public static byte[] altAesEncSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.l(bArr, bArr2);
    }

    public static byte[] getBytesEncrypted(byte[] bArr) {
        return a.d(bArr, d.E);
    }

    public static byte[] getHttpAESKey() {
        return SecurityUtils.d(e);
    }

    public static String getHttpGTCV() {
        byte[] httpAESKey = getHttpAESKey();
        byte[] bytes = o.a(16).getBytes();
        byte[] bArr = new byte[(bytes.length + httpAESKey.length)];
        e.a(httpAESKey, 0, bArr, e.a(bytes, 0, bArr, 0, bytes.length), httpAESKey.length);
        return g.b(bArr, 2);
    }

    public static String getHttpSignature(String str, byte[] bArr) {
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length)];
        int a2 = e.a(bytes, 0, bArr2, 0, bytes.length);
        if (bArr.length > 0) {
            e.a(bArr, 0, bArr2, a2, bArr.length);
        }
        return g.b(sha1(bArr2), 2);
    }

    public static byte[] getIV(byte[] bArr) {
        return md5(bArr);
    }

    public static int getPacketId() {
        int i = c;
        c = i + 1;
        return i;
    }

    public static byte[] getRSAKeyId() {
        return SecurityUtils.j();
    }

    public static byte[] getSocketAESKey() {
        return SecurityUtils.h(d);
    }

    public static byte[] getSocketSignature(com.igexin.push.d.c.a aVar, int i, int i2) {
        byte[] bArr = new byte[(aVar.a + 11)];
        int a2 = e.a(i, bArr, 0);
        int a3 = a2 + e.a(i2, bArr, a2);
        int b2 = a3 + e.b((short) aVar.a, bArr, a3);
        e.a(aVar.e, 0, bArr, b2 + e.c(aVar.b, bArr, b2), aVar.a);
        return sha1(bArr);
    }

    public static String getVersion() {
        byte[] k = SecurityUtils.k();
        if (k == null) {
            return null;
        }
        String str = new String(k);
        b.a(a + "| so version is " + str, new Object[0]);
        return str;
    }

    public static byte[] initHttpAESKey() {
        return SecurityUtils.a();
    }

    public static byte[] initSocketAESKey() {
        return SecurityUtils.e();
    }

    public static boolean isLoadSuccess() {
        return b;
    }

    public static byte[] md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean reset() {
        try {
            if (SecurityUtils.b) {
                d = initSocketAESKey();
                byte[] initHttpAESKey = initHttpAESKey();
                e = initHttpAESKey;
                b = (d == null || initHttpAESKey == null || getSocketAESKey() == null || getHttpAESKey() == null || getRSAKeyId() == null || getVersion() == null) ? false : true;
            }
        } catch (Throwable th) {
            b.a(a + "|load so error = " + th.toString(), new Object[0]);
            b = false;
        }
        if (!b) {
            b.a(a + "|load so error ++++++++", new Object[0]);
        } else {
            b.a(a + "|load so success ~~~~~~~", new Object[0]);
        }
        return b;
    }

    public static byte[] rsaEnc(byte[] bArr) {
        int length = bArr.length;
        if (length <= 214) {
            return SecurityUtils.i(bArr);
        }
        int i = length % 200 == 0 ? length / 200 : (length / 200) + 1;
        byte[] bArr2 = new byte[(i * WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 < i + -1 ? 200 : length - (i2 * 200);
            byte[] bArr3 = new byte[i4];
            e.a(bArr, i2 * 200, bArr3, 0, i4);
            byte[] i5 = SecurityUtils.i(bArr3);
            i3 += e.a(i5, 0, bArr2, i3, i5.length);
            i2++;
        }
        return bArr2;
    }

    public static byte[] sha1(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
