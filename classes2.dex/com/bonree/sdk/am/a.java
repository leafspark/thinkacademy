package com.bonree.sdk.am;

import android.graphics.Rect;
import android.os.Build;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bonree.sdk.bs.ad;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public final class a extends f {
    private static final String m = "/system/bin/su";
    private static final String n = "/system/xbin/su";
    private static final String o = "/su/bin/su";
    private static final String p = "root";
    private static final int q = 31;

    public a() {
        this.l = com.bonree.sdk.bs.a.a();
        a();
    }

    public final void a() {
        super.a();
        this.e = f();
        if (Build.VERSION.SDK_INT >= 31) {
            this.f = Build.SOC_MANUFACTURER;
        } else {
            this.f = Build.HARDWARE;
        }
        this.i = b();
        if (com.bonree.sdk.d.a.K()) {
            this.c = ad.e();
            this.j = ad.f();
        } else {
            this.c = Build.VERSION.RELEASE;
            this.j = ad.g();
        }
        this.a = c(Build.BRAND);
        this.b = c(Build.MODEL);
        this.h = t();
        this.d = s();
        this.k = (int) Math.ceil((double) c());
        if (u()) {
            this.g = p;
        } else {
            this.g = "user";
        }
    }

    private String s() {
        if (Build.VERSION.SDK_INT >= 31) {
            return Build.SOC_MODEL;
        }
        return b(this.e);
    }

    public final String b() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = this.l.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = this.l.getResources().getConfiguration().locale;
        }
        return locale != null ? locale.getLanguage() : "zh";
    }

    private static String c(String str) {
        if (ad.a(str)) {
            return "";
        }
        return (Charset.forName("GBK").newEncoder().canEncode(str) || Build.VERSION.SDK_INT < 19) ? str : new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    private String t() {
        if (Build.VERSION.SDK_INT >= 31) {
            Rect bounds = ((WindowManager) this.l.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
            int i = bounds.right - bounds.left;
            int i2 = bounds.bottom - bounds.top;
            return i + "*" + i2;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) this.l.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        return i3 + "*" + i4;
    }

    public final float c() {
        StatFs statFs = new StatFs(this.l.getCacheDir().getAbsolutePath());
        return (float) (((((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1000) / 1000);
    }

    private static boolean u() {
        try {
            return new File(m).exists() || new File(n).exists() || new File(o).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean d(String str) {
        if (ad.a(str)) {
            return true;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '0') {
                i++;
            }
        }
        return i == str.length();
    }
}
