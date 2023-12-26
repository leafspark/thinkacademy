package atd.l;

import android.content.Context;
import android.os.Build;
import atd.i.b;
import atd.i.c;

public class a implements b {
    /* renamed from: b */
    public Integer a(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 23) {
            return Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT);
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    public String a() {
        return atd.s0.a.a(-74172749113920L);
    }
}
