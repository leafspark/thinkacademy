package com.igexin.push.core.d;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;

public class o extends f {
    private String a;
    private String b;

    public o() {
        super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "OUID";
    }

    public /* bridge */ /* synthetic */ boolean a(Context context) {
        return super.a(context);
    }

    public /* bridge */ /* synthetic */ String b(Context context) {
        return super.b(context);
    }

    public /* bridge */ /* synthetic */ boolean c(Context context) {
        return super.c(context);
    }

    /* access modifiers changed from: protected */
    public String d(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        return this.b;
    }

    /* access modifiers changed from: protected */
    public String e(Context context) {
        if (TextUtils.isEmpty(this.a)) {
            try {
                this.b = d(context);
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                    }
                    this.a = sb.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return this.a;
    }
}
