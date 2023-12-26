package atd.w;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public final class i extends a {
    public String a() {
        return a.a(-138610143455808L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Boolean c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 21) {
            return Boolean.valueOf(e(context).isTdlsSupported());
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
