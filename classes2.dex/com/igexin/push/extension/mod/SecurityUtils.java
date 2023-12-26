package com.igexin.push.extension.mod;

import android.util.Log;
import com.igexin.a.d;
import com.igexin.a.h;
import com.igexin.b.a.c.a.f;
import com.igexin.b.a.c.b;
import com.igexin.push.core.x;
import com.igexin.sdk.PushConsts;

public class SecurityUtils {
    public static final String a = "com.igexin.push.extension.mod.SecurityUtils";
    public static boolean b = false;
    public static String c = "";

    static {
        String name = SecurityUtils.class.getName();
        try {
            b.a(name + "|load so by system start #######", new Object[0]);
            System.loadLibrary("getuiext3");
            b = true;
            f.a().a("load so = getuiext3 by system success");
            b.a(name + "|load so by system success ^_^", new Object[0]);
        } catch (UnsatisfiedLinkError e) {
            Log.e(PushConsts.KEY_CLIENT_ID, "load1 so error = " + e.toString());
            StringBuilder sb = new StringBuilder();
            String str = a;
            sb.append(str);
            sb.append("|load so by system error = ");
            sb.append(e.toString());
            b.a(sb.toString(), new Object[0]);
            c = e.getMessage() + " + ";
            b.a(str + "|load so by new start !!", new Object[0]);
            if (x.a == null) {
                b.a(str + "|load so by new context = null ~~~~", new Object[0]);
                b = false;
                c = e.getMessage();
                return;
            }
            d.a((h) null).a().b().a(x.a, "getuiext3", (String) null, new a());
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = a;
            sb2.append(str2);
            sb2.append("|load so error not UnsatisfiedLinkError");
            b.a(sb2.toString(), new Object[0]);
            b.a(str2 + "|load so error e = " + th.toString(), new Object[0]);
            b = false;
            c += th.toString() + " + " + th.getMessage();
        }
    }

    public static native byte[] a();

    public static native byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] d(byte[] bArr);

    public static native byte[] e();

    public static native byte[] f(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] g(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] h(byte[] bArr);

    public static native byte[] i(byte[] bArr);

    public static native byte[] j();

    public static native byte[] k();

    public static native byte[] l(byte[] bArr, byte[] bArr2);

    public static native byte[] m(byte[] bArr, byte[] bArr2);
}
