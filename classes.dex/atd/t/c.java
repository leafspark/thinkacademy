package atd.t;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.i.b;
import atd.i.c;
import atd.s0.a;

public class c implements b {
    /* renamed from: b */
    public Integer a(Context context) throws atd.i.c {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                return Integer.valueOf(Settings.System.getInt(context.getContentResolver(), a.a(-139881453775424L)));
            } catch (Settings.SettingNotFoundException unused) {
                return null;
            }
        } else {
            throw new atd.i.c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
    }

    public String a() {
        return a.a(-139868568873536L);
    }
}
