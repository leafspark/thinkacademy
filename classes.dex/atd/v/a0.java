package atd.v;

import android.content.Context;
import android.telephony.TelephonyManager;
import atd.i.c;
import atd.i.d;
import atd.s0.a;
import java.util.Collections;
import java.util.List;

abstract class a0 extends d {
    a0() {
    }

    /* access modifiers changed from: protected */
    public List<String> b() {
        return Collections.singletonList(a.a(-139164194236992L));
    }

    /* access modifiers changed from: package-private */
    public TelephonyManager d(Context context) throws c {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(a.a(-139593690966592L));
        if (telephonyManager != null) {
            return telephonyManager;
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
