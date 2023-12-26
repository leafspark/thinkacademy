package atd.d;

import atd.e.a;
import atd.e.b;
import atd.e.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends j {
    private final int g;
    private final a h;
    private final e i;
    private final a j;

    c(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        e eVar;
        try {
            this.g = a(jSONObject, atd.s0.a.a(-98851631196736L));
            a a = a.a(b(jSONObject, atd.s0.a.a(-98890285902400L)));
            this.h = a;
            if (a.a()) {
                eVar = e.a(d(jSONObject, atd.s0.a.a(-98722782177856L)));
            } else {
                eVar = e.a(b(jSONObject, atd.s0.a.a(-98774321785408L)));
            }
            this.i = eVar;
            if (a.a()) {
                b.a(b(jSONObject, atd.s0.a.a(-98001227672128L)));
            } else {
                b.a(d(jSONObject, atd.s0.a.a(-98061357214272L)));
            }
            this.j = a.a() ? a.a(jSONObject) : null;
        } catch (JSONException e) {
            throw new atd.a0.a(atd.s0.a.a(-98087127018048L), e, atd.e.c.DATA_ELEMENT_MISSING);
        }
    }

    public boolean f() {
        return true;
    }

    public int g() {
        return this.g;
    }

    public a h() {
        return this.j;
    }

    public String i() {
        return this.i.a();
    }

    public boolean j() {
        return this.h.b();
    }

    /* access modifiers changed from: package-private */
    public String g(JSONObject jSONObject, String str) throws atd.a0.a, JSONException {
        return c(jSONObject, str);
    }
}
