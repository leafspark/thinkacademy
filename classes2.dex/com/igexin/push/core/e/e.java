package com.igexin.push.core.e;

import android.content.Context;
import android.os.Build;
import com.igexin.b.a.c.b;

class e implements c {
    private final c a;

    protected e() {
        this.a = Build.VERSION.SDK_INT >= 30 ? new a() : new b();
        b.a("SDCardWrapper|SDCardWrapper.mBase = " + this.a.getClass(), new Object[0]);
    }

    public String a(Context context) {
        try {
            return this.a.a(context);
        } catch (Throwable th) {
            b.a("SDCardWrapper|getDeviceId()|" + th.toString(), new Object[0]);
            return null;
        }
    }

    public void a(Context context, long j) {
        try {
            this.a.a(context, j);
        } catch (Throwable th) {
            b.a("SDCardWrapper|saveSession()|" + th.toString(), new Object[0]);
        }
    }

    public void a(Context context, String str) {
        try {
            this.a.a(context, str);
        } catch (Throwable th) {
            b.a("SDCardWrapper|saveDeviceId()|" + th.toString(), new Object[0]);
        }
    }

    public String b(Context context) {
        try {
            return this.a.b(context);
        } catch (Throwable th) {
            b.a("SDCardWrapper|getCid()|" + th.toString(), new Object[0]);
            return null;
        }
    }

    public void b(Context context, String str) {
        try {
            this.a.b(context, str);
        } catch (Throwable th) {
            b.a("SDCardWrapper|saveCid()|" + th.toString(), new Object[0]);
        }
    }

    public long c(Context context) {
        try {
            return this.a.c(context);
        } catch (Throwable th) {
            b.a("SDCardWrapper|getSession()|" + th.toString(), new Object[0]);
            return 0;
        }
    }
}
