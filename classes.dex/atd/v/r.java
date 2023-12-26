package atd.v;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public final class r extends a0 {
    public String a() {
        return a.a(-139267273452096L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Integer c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 23) {
            return Integer.valueOf(d(context).getPhoneCount());
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
