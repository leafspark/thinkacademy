package com.igexin.push.core.d;

import android.content.Context;
import android.text.TextUtils;

public class r implements c {
    private static String b;
    private Class a = null;

    public boolean a(Context context) {
        try {
            this.a = Class.forName("com.android.id.impl.IdProviderImpl");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public String b(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                Object newInstance = this.a.newInstance();
                b = String.valueOf(this.a.getMethod("getOAID", new Class[]{Context.class}).invoke(newInstance, new Object[]{context}));
            } catch (Throwable unused) {
                b = null;
            }
        }
        return b;
    }

    public boolean c(Context context) {
        return true;
    }
}
