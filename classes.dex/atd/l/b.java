package atd.l;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public class b implements atd.i.b {
    /* renamed from: b */
    public String a(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 23) {
            return Build.VERSION.SECURITY_PATCH;
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    public String a() {
        return a.a(-74185634015808L);
    }
}
