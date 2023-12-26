package atd.s;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.i.b;
import atd.i.c;
import atd.s0.a;

public class g implements b {
    /* renamed from: b */
    public Integer a(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), a.a(-140435504556608L)));
            } catch (Settings.SettingNotFoundException unused) {
                return null;
            }
        } else {
            throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
    }

    public String a() {
        return a.a(-140422619654720L);
    }
}
