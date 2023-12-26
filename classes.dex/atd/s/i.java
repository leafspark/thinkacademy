package atd.s;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.i.b;
import atd.i.c;
import atd.s0.a;

public final class i implements b {
    static {
        a.a(-140663137823296L);
    }

    public String a() {
        return a.a(-140242231028288L);
    }

    public Object a(Context context) throws c {
        if (Build.VERSION.SDK_INT <= 23) {
            Class<Settings.Secure> cls = Settings.Secure.class;
            try {
                return Settings.Secure.getString(context.getContentResolver(), (String) cls.getField(a.a(-140289475668544L)).get((Object) null));
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
