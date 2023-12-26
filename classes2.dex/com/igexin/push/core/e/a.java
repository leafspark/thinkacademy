package com.igexin.push.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.b.a.c.b;
import com.igexin.push.core.d;
import com.igexin.push.util.c;
import java.io.File;

class a implements c {
    static final byte[] a = {47, 115, 100, 99, 97, 114, 100, 47, 65, 110, 100, 114, 111, 105, 100, 47, 109, 101, 100, 105, 97, 47};
    private static final String b = ("gt" + Build.MODEL);
    private String c;
    private String d;

    protected a() {
        try {
            if (e(d.g)) {
                this.c = new String(a) + "." + Integer.toHexString(b.hashCode()).toUpperCase() + "/";
                StringBuilder sb = new StringBuilder();
                sb.append("AndroidQSDStorage|dir = ");
                sb.append(this.c);
                b.a(sb.toString(), new Object[0]);
                File file = new File(this.c);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
        } catch (Throwable th) {
            b.a("AndroidQSDStorage|e = " + th, new Object[0]);
        }
    }

    private String a(String str) {
        return com.igexin.b.a.c.a.a(com.igexin.b.a.a.a.d(str.getBytes(), b)).toUpperCase();
    }

    private String b(String str) {
        return new String(com.igexin.b.a.a.a.c(com.igexin.b.a.c.a.a(str), b));
    }

    private void d(Context context) {
        if (TextUtils.isEmpty(this.d)) {
            String upperCase = com.igexin.b.a.c.a.a(com.igexin.b.a.a.a.d(context.getPackageName().getBytes(), b)).toUpperCase();
            this.d = this.c + upperCase + "/";
        }
    }

    private boolean e(Context context) {
        return new com.igexin.sdk.a.b(context).c();
    }

    public String a(Context context) {
        if (!e(context)) {
            return null;
        }
        File file = new File(this.c + "di/");
        if (!file.exists()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            b.a("AndroidQSDStorage|getDeviceId() childs = NULL", new Object[0]);
            return null;
        }
        File file2 = listFiles[0];
        try {
            return b(file2.getName());
        } catch (Throwable unused) {
            file2.delete();
            return null;
        }
    }

    public void a(Context context, long j) {
        if (e(context)) {
            d(context);
            File file = new File(this.d + "ss");
            if (j == 0) {
                c.a(file, new String[0]);
                return;
            }
            String a2 = a(String.valueOf(j));
            File file2 = new File(file.getAbsolutePath() + "/" + a2);
            if (!file2.exists()) {
                boolean mkdirs = file2.mkdirs();
                if (mkdirs) {
                    c.a(file, a2);
                }
                b.a("AndroidQSDStorage|saveSession() isCreated = " + mkdirs, new Object[0]);
            }
        }
    }

    public void a(Context context, String str) {
        if (e(context) && !TextUtils.isEmpty(str)) {
            String a2 = a(str);
            File file = new File(this.c + "di");
            File file2 = new File(file.getAbsolutePath() + "/" + a2);
            if (!file2.exists()) {
                boolean mkdirs = file2.mkdirs();
                if (mkdirs) {
                    c.a(file, a2);
                }
                b.a("AndroidQSDStorage|saveDeviceId() isCreated = " + mkdirs, new Object[0]);
            }
        }
    }

    public String b(Context context) {
        if (!e(context)) {
            return null;
        }
        d(context);
        File file = new File(this.d + com.bonree.sdk.ao.c.b);
        if (!file.exists()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            b.a("AndroidQSDStorage|getCid() childs = NULL", new Object[0]);
            return null;
        }
        File file2 = listFiles[0];
        try {
            return b(file2.getName());
        } catch (Throwable unused) {
            file2.delete();
            return null;
        }
    }

    public void b(Context context, String str) {
        if (e(context)) {
            d(context);
            File file = new File(this.d + com.bonree.sdk.ao.c.b);
            if (TextUtils.isEmpty(str)) {
                c.a(file, new String[0]);
                return;
            }
            String a2 = a(str);
            File file2 = new File(file.getAbsolutePath() + "/" + a2);
            if (!file2.exists()) {
                boolean mkdirs = file2.mkdirs();
                if (mkdirs) {
                    c.a(file, a2);
                }
                b.a("AndroidQSDStorage|saveCid() isCreated = " + mkdirs, new Object[0]);
            }
        }
    }

    public long c(Context context) {
        if (!e(context)) {
            return 0;
        }
        d(context);
        File file = new File(this.d + "ss");
        if (!file.exists()) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            b.a("AndroidQSDStorage|getSession() childs = NULL", new Object[0]);
            return 0;
        }
        File file2 = listFiles[0];
        try {
            return Long.parseLong(b(file2.getName()));
        } catch (Throwable unused) {
            file2.delete();
            return 0;
        }
    }
}
