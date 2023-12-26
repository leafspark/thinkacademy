package atd.g0;

import atd.c0.c;
import atd.f0.f;
import atd.i0.b;
import atd.i0.g;
import atd.s0.a;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends c {
    private final RSAPublicKey b;
    private final RSAPrivateKey c;

    static {
        a.a(-798080896920128L);
    }

    d(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        atd.r0.a a = atd.r0.a.a();
        BigInteger a2 = b.a(a.a(jSONObject.getString(a.a(-797977817705024L))));
        BigInteger a3 = b.a(a.a(jSONObject.getString(a.a(-798003587508800L))));
        RSAPrivateKey rSAPrivateKey = null;
        BigInteger a4 = jSONObject.has(a.a(-797994997574208L)) ? b.a(a.a(jSONObject.getString(a.a(-798020767377984L)))) : null;
        this.b = g.b(a2, a3);
        this.c = a4 != null ? g.a(a2, a4) : rSAPrivateKey;
    }

    public atd.f0.a a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String b2 = b();
        if (b2 != null && !b2.isEmpty()) {
            jSONObject.put(a.a(-798063717050944L), b2);
        }
        f fVar = new f(atd.d0.g.c, c.a, jSONObject);
        return new atd.f0.a(fVar, fVar.f().a(fVar, this), this);
    }

    /* renamed from: e */
    public RSAPrivateKey d() {
        return this.c;
    }

    public RSAPublicKey f() {
        return this.b;
    }
}
