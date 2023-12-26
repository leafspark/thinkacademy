package atd.v;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public final class m extends a0 {
    public String a() {
        return a.a(-139993122925120L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 19) {
            return d(context).getMmsUserAgent();
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
