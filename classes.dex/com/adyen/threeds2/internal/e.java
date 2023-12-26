package com.adyen.threeds2.internal;

import android.content.Context;
import atd.k0.a;
import atd.r0.g;
import java.util.UUID;

public final class e {
    private final a a;
    private String b;

    static {
        atd.s0.a.a(-104112966134336L);
    }

    private e(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = aVar;
        b(applicationContext);
    }

    public static e a(Context context, a aVar) {
        return new e(context, aVar);
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return a(atd.s0.a.a(-105328441879104L));
    }

    /* access modifiers changed from: package-private */
    public void c(Context context) {
        this.b = a(context);
    }

    private void b(Context context) {
        String a2 = this.a.a(context, atd.s0.a.a(-104937599855168L));
        if (a2 == null) {
            a2 = a(context);
        }
        this.b = a2;
    }

    public String a() {
        return a(this.b);
    }

    private String a(Context context) {
        String b2 = b(UUID.randomUUID().toString());
        this.a.a(context, atd.s0.a.a(-104800160901696L), b2);
        return b2;
    }

    private String a(String str) {
        return g.a(str);
    }

    private String b(String str) {
        return g.b(str);
    }
}
