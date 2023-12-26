package atd.g0;

import atd.f0.b;
import java.security.PrivateKey;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c extends b implements b {
    c(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public void c() {
        try {
            PrivateKey d = d();
            if (d != null) {
                d.destroy();
            }
        } catch (Throwable unused) {
        }
    }

    public abstract PrivateKey d();

    c(String str, String str2) {
        super(str, str2);
    }
}
