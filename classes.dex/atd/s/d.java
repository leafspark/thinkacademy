package atd.s;

import android.content.Context;
import android.provider.Settings;
import atd.i.b;
import atd.s0.a;

public class d implements b {
    /* renamed from: b */
    public Integer a(Context context) {
        try {
            return Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), a.a(-70685235669568L)));
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }

    public String a() {
        return a.a(-70672350767680L);
    }
}
