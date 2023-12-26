package atd.s;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.i.b;
import atd.i.c;
import atd.s0.a;

public class e implements b {
    /* renamed from: b */
    public Integer a(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), a.a(-140345310243392L)));
            } catch (Settings.SettingNotFoundException unused) {
                return null;
            }
        } else {
            throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
    }

    public String a() {
        return a.a(-140332425341504L);
    }
}
