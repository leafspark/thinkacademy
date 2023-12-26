package atd.v;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public final class l extends a0 {
    public String a() {
        return a.a(-139980238023232L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 19) {
            return d(context).getMmsUAProfUrl();
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
