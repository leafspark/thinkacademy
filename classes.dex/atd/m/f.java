package atd.m;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import atd.i.b;
import atd.s0.a;
import java.util.Locale;

public final class f implements b {
    static {
        a.a(-72669510560320L);
    }

    /* renamed from: b */
    public String a(Context context) {
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            locale = configuration.getLocales().get(0);
        } else {
            locale = configuration.locale;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return locale.toLanguageTag();
        }
        return String.format(Locale.ENGLISH, a.a(-72626560887360L), new Object[]{locale.getLanguage(), locale.getCountry()});
    }

    public String a() {
        return a.a(-72613675985472L);
    }
}
