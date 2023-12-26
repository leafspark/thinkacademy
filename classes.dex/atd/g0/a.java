package atd.g0;

import atd.c0.c;
import atd.d0.g;
import atd.f0.f;
import atd.i0.b;
import atd.i0.d;
import atd.i0.e;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends c {
    private final d b;
    private final ECPublicKey c;
    private final ECPrivateKey d;

    static {
        atd.s0.a.a(-798141026462272L);
    }

    public a(String str, d dVar) {
        super(str, atd.s0.a.a(-797960637835840L));
        this.b = dVar;
        KeyPair a = e.a(dVar);
        this.c = (ECPublicKey) a.getPublic();
        this.d = (ECPrivateKey) a.getPrivate();
    }

    public atd.f0.a a() throws JSONException {
        a aVar = new a(b(), d.P256);
        JSONObject jSONObject = new JSONObject();
        String b2 = aVar.b();
        if (b2 != null && !b2.isEmpty()) {
            jSONObject.put(atd.s0.a.a(-797831788816960L), b2);
        }
        jSONObject.put(atd.s0.a.a(-798123846593088L), aVar.g());
        f fVar = new f(g.b, c.a, jSONObject);
        byte[] a = aVar.a((String) null, (String) null, b(), f());
        return new atd.f0.a(fVar, g.a.a(c.a, a), new e(b(), a));
    }

    /* renamed from: e */
    public ECPrivateKey d() {
        return this.d;
    }

    public ECPublicKey f() {
        return this.c;
    }

    public JSONObject g() {
        ECPoint w = this.c.getW();
        atd.r0.a a = atd.r0.a.a();
        String d2 = a.d(b.a(w.getAffineX()));
        String d3 = a.d(b.a(w.getAffineY()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(atd.s0.a.a(-797758774372928L), atd.s0.a.a(-797775954242112L));
            jSONObject.put(atd.s0.a.a(-797797429078592L), this.b.a());
            jSONObject.put(atd.s0.a.a(-797814608947776L), d2);
            jSONObject.put(atd.s0.a.a(-797806019013184L), d3);
            return jSONObject;
        } catch (JSONException e) {
            throw atd.y.c.CRYPTO_FAILURE.a(e);
        }
    }

    a(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        atd.r0.a a = atd.r0.a.a();
        BigInteger a2 = b.a(a.a(jSONObject.getString(atd.s0.a.a(-797707234765376L))));
        BigInteger a3 = b.a(a.a(jSONObject.getString(atd.s0.a.a(-797698644830784L))));
        ECPrivateKey eCPrivateKey = null;
        BigInteger a4 = jSONObject.has(atd.s0.a.a(-797724414634560L)) ? b.a(a.a(jSONObject.getString(atd.s0.a.a(-797715824699968L)))) : null;
        d a5 = d.a(jSONObject.getString(atd.s0.a.a(-797741594503744L)));
        this.b = a5;
        this.c = e.a(a5, a2, a3);
        this.d = a4 != null ? e.a(a5, a4) : eCPrivateKey;
    }

    public byte[] a(String str, String str2, String str3, ECPublicKey eCPublicKey) {
        byte[] a = e.a(eCPublicKey, this.d);
        return atd.i0.c.a(a, a.length * 8, str, str2, str3);
    }
}
