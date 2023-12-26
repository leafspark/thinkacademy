package atd.w;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import atd.i.c;
import atd.i.d;
import java.util.Collections;
import java.util.List;

abstract class a extends d {
    a() {
    }

    /* access modifiers changed from: protected */
    public List<String> b() {
        return Collections.singletonList(atd.s0.a.a(-139387532536384L));
    }

    /* access modifiers changed from: package-private */
    public WifiInfo d(Context context) throws c {
        WifiInfo connectionInfo = e(context).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo;
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public WifiManager e(Context context) throws c {
        WifiManager wifiManager = (WifiManager) context.getSystemService(atd.s0.a.a(-138713222670912L));
        if (wifiManager != null) {
            return wifiManager;
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
