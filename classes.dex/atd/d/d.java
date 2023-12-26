package atd.d;

import atd.e.c;
import atd.s0.a;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends i {
    private final c h;
    private final String i;

    public d(String str, String str2, String str3, String str4, String str5, c cVar, String str6) {
        super(atd.e.d.ERROR, str, str2, str3, str4, str5);
        this.h = cVar;
        this.i = str6;
    }

    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        a.put(a.a(-98280400546368L), this.h.a());
        a.put(a.a(-98306170350144L), this.h.b());
        a.put(a.a(-98379184794176L), this.h.c());
        a.put(a.a(-98168731396672L), this.h.d());
        a.put(a.a(-98267515644480L), this.i);
        return a;
    }

    public boolean i() {
        return false;
    }
}
