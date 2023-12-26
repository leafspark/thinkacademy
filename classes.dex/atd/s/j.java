package atd.s;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import atd.i.b;
import atd.s0.a;
import org.json.JSONArray;

public class j implements b {
    public String a() {
        return a.a(-140487044164160L);
    }

    public Object a(Context context) {
        JSONArray jSONArray = new JSONArray();
        String string = Settings.Secure.getString(context.getContentResolver(), a.a(-140499929066048L));
        if (!TextUtils.isEmpty(string)) {
            for (String put : string.split(a.a(-140585828411968L))) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }
}
