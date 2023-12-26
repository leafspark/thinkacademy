package atd.v;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import atd.i.c;
import atd.s0.a;

public final class b extends a0 {
    public String a() {
        return a.a(-139748309789248L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String c(Context context) throws c {
        TelephonyManager d = d(context);
        if (Build.VERSION.SDK_INT >= 18 && d.getPhoneType() == 1) {
            return d.getGroupIdLevel1();
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
