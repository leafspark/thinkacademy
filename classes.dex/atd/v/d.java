package atd.v;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;

public final class d extends t {
    public String a() {
        return a.a(-140083317238336L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String c(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 26) {
            return d(context).getImei();
        }
        return d(context).getDeviceId();
    }
}
