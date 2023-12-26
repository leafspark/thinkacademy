package atd.c;

import atd.f.b;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<T> implements b {
    private final String a;
    private final T b;

    public c(String str, T t) {
        this.a = str;
        this.b = t;
    }

    private String b() {
        return this.a;
    }

    private T c() {
        return this.b;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (a(c())) {
            jSONObject.put(b(), c());
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(T t);
}
