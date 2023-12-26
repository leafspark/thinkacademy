package atd.w;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public final class f extends a {
    public String a() {
        return a.a(-138571488750144L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Boolean c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 21) {
            return Boolean.valueOf(e(context).isP2pSupported());
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
