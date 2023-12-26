package atd.v;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public final class e extends a0 {
    public String a() {
        return a.a(-140096202140224L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Boolean c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 23) {
            return Boolean.valueOf(d(context).isHearingAidCompatibilitySupported());
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
