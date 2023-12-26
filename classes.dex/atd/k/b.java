package atd.k;

import android.content.Context;
import android.os.Build;
import atd.i.c;
import atd.s0.a;
import org.json.JSONArray;

public class b implements atd.i.b {
    /* renamed from: b */
    public JSONArray a(Context context) throws c {
        if (Build.VERSION.SDK_INT >= 21) {
            JSONArray jSONArray = new JSONArray();
            String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
            if (strArr != null) {
                for (String put : strArr) {
                    jSONArray.put(put);
                }
            }
            return jSONArray;
        }
        throw new c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    public String a() {
        return a.a(-74146979310144L);
    }
}
