package atd.d;

import atd.a0.a;
import atd.e.c;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends j {
    private final String g;
    private final String h;
    private final String i;

    e(JSONObject jSONObject) throws a {
        super(jSONObject);
        try {
            this.g = b(jSONObject, atd.s0.a.a(-97494421531200L));
            b(jSONObject, atd.s0.a.a(-97520191334976L));
            this.h = b(jSONObject, atd.s0.a.a(-97318327872064L));
            this.i = b(jSONObject, atd.s0.a.a(-97382752381504L));
            b(jSONObject, atd.s0.a.a(-97434291989056L));
        } catch (JSONException e) {
            throw new a(atd.s0.a.a(-97773594405440L), e, c.DATA_ELEMENT_MISSING);
        }
    }

    public boolean f() {
        return false;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public String g(JSONObject jSONObject, String str) throws a {
        return f(jSONObject, str);
    }
}
