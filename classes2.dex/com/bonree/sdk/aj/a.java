package com.bonree.sdk.aj;

import android.content.Context;
import com.bonree.sdk.bs.aa;

public final class a {
    private static final String f = "file_self_crash";
    private static final String g = "key_is_self_crash";
    private static final String h = "key_crash_sdk_version";
    private static final String i = "key_crash_app_version";
    private static final String j = "key_crash_sdk_crashtime";
    private static final String k = "key_crash_sdk_crashcauseby";
    public boolean a;
    public String b;
    public String c;
    public long d;
    public String e;

    public a() {
    }

    public a(boolean z, String str, String str2, long j2, String str3) {
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = j2;
        this.e = str3;
    }

    public static a a(Context context) {
        if (context == null) {
            return null;
        }
        boolean c2 = aa.c(context, f, g);
        if (!c2) {
            return new a(false, (String) null, (String) null, 0, (String) null);
        }
        return new a(c2, aa.d(context, f, h), aa.d(context, f, i), aa.b(context, f, j), aa.d(context, f, k));
    }

    public final boolean b(Context context) {
        if (context == null) {
            return false;
        }
        aa.a(context, f, g, this.a);
        aa.a(context, f, h, this.b);
        aa.a(context, f, i, this.c);
        aa.a(context, f, j, this.d);
        aa.a(context, f, k, this.e);
        return true;
    }
}
