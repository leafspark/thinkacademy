package com.bonree.sdk.be;

import android.util.Log;
import com.bonree.sdk.d.a;

public final class b implements f {
    private static final String f = "BRSDK-Agent";
    private static final String g = "ZJR";
    private int h = 5;

    public final void a(String str, Object... objArr) {
        if (a.k().C() && this.h == 5) {
            a("d", str, objArr);
        }
    }

    private static void a(String str, String str2, Object... objArr) {
        String str3;
        try {
            str3 = String.format(str2, objArr);
        } catch (Throwable th) {
            str3 = th.toString();
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 100:
                if (str.equals("d")) {
                    c = 0;
                    break;
                }
                break;
            case 101:
                if (str.equals("e")) {
                    c = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c = 2;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    c = 3;
                    break;
                }
                break;
            case 119:
                if (str.equals("w")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Log.d(f, str3);
                return;
            case 1:
                Log.e(f, str3);
                return;
            case 2:
                Log.i(f, str3);
                return;
            case 3:
                Log.v(f, str3);
                return;
            case 4:
                Log.w(f, str3);
                return;
            default:
                return;
        }
    }

    public final void b(String str, Object... objArr) {
        if (a.k().C() && this.h >= 4) {
            a("v", str, objArr);
        }
    }

    public final void c(String str, Object... objArr) {
        if (a.k().C() && this.h >= 3) {
            a("i", str, objArr);
        }
    }

    public final void a(String str) {
        if (a.k().C() && this.h >= 3) {
            Log.i(g, str);
        }
    }

    public final void d(String str, Object... objArr) {
        if (a.k().C() && this.h >= 2) {
            a("w", str, objArr);
        }
    }

    public final void e(String str, Object... objArr) {
        if (a.k().C() && this.h > 0) {
            a("e", str, objArr);
        }
    }

    public final void a(String str, Throwable th) {
        if (a.k().C() && this.h > 0) {
            Log.e(f, str, th);
        }
    }

    public final int a() {
        return this.h;
    }

    public final void a(int i) {
        if (i > 5 || i <= 0) {
            throw new IllegalArgumentException("Log level is not between ERROR and DEBUG");
        }
        this.h = i;
    }
}
