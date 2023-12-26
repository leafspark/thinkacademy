package com.igexin.b.a.c;

import android.util.Log;
import com.igexin.push.config.o;
import com.igexin.push.core.d;
import com.igexin.push.f.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class b {
    public static boolean a = o.a.equals("debug");

    public static void a(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, Object... objArr) {
        if (a || (d.O && d.P >= System.currentTimeMillis())) {
            if (objArr != null && objArr.length > 0) {
                str = String.format(str, objArr);
            }
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
            a.i().a(format + "|" + str);
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }
}
