package atd.s;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.s0.a;

public class b implements atd.i.b {
    /* renamed from: b */
    public Integer a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return Integer.valueOf(Settings.Global.getInt(contentResolver, a.a(-70384587958848L)));
            }
            return Integer.valueOf(Settings.Secure.getInt(contentResolver, a.a(-70431832599104L)));
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }

    public String a() {
        return a.a(-70612221225536L);
    }
}
