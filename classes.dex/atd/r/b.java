package atd.r;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.i.c;
import atd.s0.a;

public class b implements atd.i.b {
    /* renamed from: b */
    public Integer a(Context context) throws c {
        int i = Build.VERSION.SDK_INT;
        if (i < 17 || i >= 26) {
            throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
        try {
            return Integer.valueOf(Settings.Global.getInt(context.getContentResolver(), a.a(-71355250567744L)));
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }

    public String a() {
        return a.a(-71342365665856L);
    }
}
