package atd.d;

import atd.c.c;
import atd.e.d;
import atd.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends i {
    private final c h;
    private final String i;

    public b(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, (c) null, (String) null);
    }

    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        c cVar = this.h;
        if (cVar != null) {
            a = a.a(a, cVar.a());
        }
        a.putOpt(atd.s0.a.a(-98465084140096L), this.i);
        return a;
    }

    public boolean i() {
        return true;
    }

    public c j() {
        return this.h;
    }

    public b(String str, String str2, String str3, String str4, String str5, c cVar, String str6) {
        super(d.CHALLENGE_REQUEST, str, str2, str3, str4, str5);
        this.h = cVar;
        this.i = str6;
    }
}
