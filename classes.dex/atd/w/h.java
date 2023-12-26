package atd.w;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public final class h extends a {
    public String a() {
        return a.a(-138597258553920L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Boolean c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 18) {
            return Boolean.valueOf(e(context).isScanAlwaysAvailable());
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
