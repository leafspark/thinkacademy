package atd.g;

import atd.g0.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private final b a;
    private final String b;

    public a(JSONObject jSONObject) throws JSONException {
        this.a = b.a(jSONObject.getJSONObject(atd.s0.a.a(-86765593225792L)));
        b.a(jSONObject.getJSONObject(atd.s0.a.a(-86838607669824L)));
        this.b = jSONObject.getString(atd.s0.a.a(-86636744206912L));
    }

    public b a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
