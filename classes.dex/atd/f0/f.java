package atd.f0;

import atd.c0.b;
import atd.d0.g;
import atd.s0.a;
import atd.y.c;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends atd.i0.f {
    private final atd.d0.f c;
    private final b d;

    public f(atd.d0.f fVar, b bVar, JSONObject jSONObject) {
        super(a(fVar, bVar, jSONObject));
        this.c = fVar;
        this.d = bVar;
    }

    private static byte[] a(atd.d0.f fVar, b bVar, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(a.a(-798583408093760L), fVar.a());
            jSONObject2.put(a.a(-798600587962944L), bVar.a());
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
            return (!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).getBytes(com.adyen.threeds2.internal.b.a);
        } catch (JSONException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }

    public b e() {
        return this.d;
    }

    public atd.d0.f f() {
        return this.c;
    }

    f(String str) {
        super(str);
        try {
            JSONObject d2 = d();
            this.c = g.a(d2.getString(a.a(-798617767832128L)));
            this.d = atd.c0.c.a(d2.getString(a.a(-798634947701312L)));
        } catch (JSONException e) {
            throw c.CRYPTO_FAILURE.a(e);
        }
    }
}
