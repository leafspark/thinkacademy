package atd.t;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.i.b;
import atd.i.c;

public class a implements b {
    /* renamed from: b */
    public Integer a(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                return Integer.valueOf(Settings.System.getInt(context.getContentResolver(), atd.s0.a.a(-139795554429504L)));
            } catch (Settings.SettingNotFoundException unused) {
                return null;
            }
        } else {
            throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
    }

    public String a() {
        return atd.s0.a.a(-139782669527616L);
    }
}
