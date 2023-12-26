package atd.d;

import atd.e.d;
import atd.f.b;
import atd.s0.a;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i implements b {
    private final d a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private int f;
    private String g;

    public i(d dVar, String str, String str2, String str3, String str4, String str5) {
        this.a = dVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.g = str5;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(a.a(-95660470495808L), this.a.a());
        jSONObject.put(a.a(-95712010103360L), this.b);
        jSONObject.put(a.a(-95785024547392L), this.c);
        jSONObject.put(a.a(-96141506832960L), this.d);
        jSONObject.put(a.a(-96197341407808L), this.e);
        jSONObject.put(a.a(-95978298075712L), String.format(Locale.ROOT, a.a(-96051312519744L), new Object[]{Integer.valueOf(this.f)}));
        jSONObject.putOpt(a.a(-96064197421632L), this.g);
        return jSONObject;
    }

    public String b() {
        return this.d;
    }

    public d c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.f;
    }

    public String f() {
        return this.e;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.c;
    }

    public abstract boolean i();

    public void a(int i) {
        this.f = i;
    }
}
