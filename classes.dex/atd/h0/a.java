package atd.h0;

import atd.e0.c;
import atd.e0.d;
import atd.i0.f;
import atd.i0.h;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends f {
    private final c c;
    private final List<X509Certificate> d;

    a(String str) {
        super(str);
        try {
            JSONObject d2 = d();
            this.c = d.a(d2.getString(atd.s0.a.a(-797333572610624L)));
            this.d = new ArrayList();
            JSONArray jSONArray = d2.getJSONArray(atd.s0.a.a(-797350752479808L));
            for (int i = 0; i < jSONArray.length(); i++) {
                this.d.add(h.a(jSONArray.getString(i)));
            }
        } catch (CertificateException | JSONException e) {
            throw atd.y.c.CRYPTO_FAILURE.a(e);
        }
    }

    public List<X509Certificate> e() {
        return new ArrayList(this.d);
    }

    public c f() {
        return this.c;
    }
}
