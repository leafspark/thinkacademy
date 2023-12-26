package com.igexin.push.core.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a {
    private static final c a = d.a(Build.MANUFACTURER.toUpperCase());
    private static volatile a b = null;
    private static Context c = null;
    private static boolean d = false;
    /* access modifiers changed from: private */
    public static boolean e = false;
    private static ThreadPoolExecutor f = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* access modifiers changed from: private */
    public static String g;

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        c cVar = a;
        if (cVar != null && context != null) {
            c = context.getApplicationContext();
            boolean c2 = c();
            e = c2;
            if (c2) {
                d = cVar.c(c);
            }
        }
    }

    private boolean c() {
        c cVar;
        try {
            Context context = c;
            if (context == null || (cVar = a) == null) {
                return false;
            }
            return cVar.a(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public String d() {
        c cVar;
        try {
            Context context = c;
            if (context == null || (cVar = a) == null) {
                return null;
            }
            if (!d) {
                return null;
            }
            return cVar.b(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(Context context, e eVar) {
        if (TextUtils.isEmpty(g) || eVar == null) {
            try {
                f.execute(new b(this, context, eVar));
            } catch (Throwable unused) {
            }
        } else {
            eVar.a(true, g);
        }
    }
}
