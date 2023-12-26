package com.igexin.push.core.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

public class g implements c {
    protected static boolean c = false;
    private static String e;
    protected String a;
    protected String b;
    protected boolean d = false;
    private String[] f;

    public g(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    /* access modifiers changed from: protected */
    public void a(String[] strArr) {
        this.f = strArr;
    }

    public boolean a(Context context) {
        if (this.d) {
            return c;
        }
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            c = (packageManager == null || packageManager.resolveContentProvider(this.a, 0) == null) ? false : true;
        } catch (Throwable unused) {
            c = false;
        }
        this.d = true;
        return c;
    }

    public String b(Context context) {
        if (TextUtils.isEmpty(e)) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://" + this.a + "/" + this.b), (String[]) null, (String) null, this.f, (String) null);
                if (query != null) {
                    query.moveToFirst();
                    e = query.getString(query.getColumnIndex("value"));
                }
            } catch (Throwable unused) {
                e = null;
            }
        }
        return e;
    }

    public boolean c(Context context) {
        return true;
    }
}
