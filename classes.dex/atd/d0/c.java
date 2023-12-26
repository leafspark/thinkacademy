package atd.d0;

import atd.c0.d;
import atd.f0.f;
import atd.g0.b;
import atd.i0.e;
import atd.s0.a;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import org.json.JSONException;
import org.json.JSONObject;

final class c extends d {
    static {
        a.a(-799712984492608L);
    }

    c() {
    }

    public String a() {
        return a.a(-799644265015872L);
    }

    public d a(f fVar, b bVar) throws JSONException {
        b.a(bVar, atd.g0.a.class);
        atd.c0.b e = fVar.e();
        atd.g0.a aVar = new atd.g0.a((String) null, atd.i0.d.P256);
        ECPublicKey f = ((atd.g0.a) bVar).f();
        ECPrivateKey e2 = aVar.d();
        JSONObject d = fVar.d();
        return a(e, d.optString(a.a(-799678624754240L), (String) null), d.optString(a.a(-799695804623424L), (String) null), f, e2);
    }

    public d a(atd.c0.b bVar, String str, String str2, ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        return new d(atd.i0.c.a(e.a(eCPublicKey, eCPrivateKey), bVar.f(), bVar.a(), str, str2), bVar);
    }
}
