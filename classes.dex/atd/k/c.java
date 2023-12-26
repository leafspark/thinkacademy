package atd.k;

import android.content.Context;
import android.os.Build;
import atd.i.b;
import atd.i.c;
import atd.s0.a;
import org.json.JSONArray;

public class c implements b {
    /* renamed from: b */
    public JSONArray a(Context context) throws atd.i.c {
        if (Build.VERSION.SDK_INT >= 21) {
            JSONArray jSONArray = new JSONArray();
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr != null) {
                for (String put : strArr) {
                    jSONArray.put(put);
                }
            }
            return jSONArray;
        }
        throw new atd.i.c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    public String a() {
        return a.a(-74159864212032L);
    }
}
