package atd.m;

import android.content.Context;
import atd.i.b;
import atd.i.c;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public final class a implements b {
    /* renamed from: b */
    public String a(Context context) throws c {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
        } catch (Throwable th) {
            throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, th);
        }
    }

    public String a() {
        return atd.s0.a.a(-73958000749120L);
    }
}
