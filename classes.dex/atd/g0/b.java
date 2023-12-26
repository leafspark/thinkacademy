package atd.g0;

import atd.s0.a;
import atd.y.c;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private final String a;

    b(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.optString(a.a(-798201156004416L));
        jSONObject.getString(a.a(-798218335873600L));
    }

    public static b a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString(a.a(-798128141560384L));
        if (a.a(-798145321429568L).equals(string)) {
            return new d(jSONObject);
        }
        if (a.a(-798162501298752L).equals(string)) {
            return new a(jSONObject);
        }
        if (a.a(-798183976135232L).equals(string)) {
            return new e(jSONObject);
        }
        throw c.CRYPTO_FAILURE.a();
    }

    public String b() {
        return this.a;
    }

    b(String str, String str2) {
        this.a = str;
    }

    public static void a(b bVar, Class<? extends b> cls) {
        if (!cls.isInstance(bVar)) {
            throw c.CRYPTO_FAILURE.a();
        }
    }
}
