package com.igexin.push.core.d;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

public class n extends g {
    private static String e;

    public n() {
        super("cn.nubia.identity", "identity");
    }

    public String b(Context context) {
        Bundle bundle;
        if (TextUtils.isEmpty(e)) {
            try {
                Uri parse = Uri.parse("content://" + this.a + "/" + this.b);
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                    if (acquireContentProviderClient != null) {
                        bundle = acquireContentProviderClient.call("getOAID", (String) null, (Bundle) null);
                        if (Build.VERSION.SDK_INT >= 24) {
                            Class.forName("android.content.ContentProviderClient").getMethod("close", new Class[0]).invoke(acquireContentProviderClient, new Object[0]);
                        } else {
                            acquireContentProviderClient.release();
                        }
                    } else {
                        bundle = null;
                    }
                } else {
                    bundle = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
                }
                if (bundle == null) {
                    return null;
                }
                if (bundle.getInt("code", -1) != 0) {
                    bundle.getString("message");
                } else {
                    e = bundle.getString("id");
                }
            } catch (Throwable unused) {
            }
        }
        return e;
    }
}
