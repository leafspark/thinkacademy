package atd.s;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.i.b;
import atd.i.c;

public class h implements b {
    public String a() {
        return "A067";
    }

    /* renamed from: b */
    public Integer a(Context context) throws c {
        if (Build.VERSION.SDK_INT < 26) {
            try {
                return Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), "speak_password"));
            } catch (Settings.SettingNotFoundException unused) {
                return null;
            }
        } else {
            throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
    }
}
