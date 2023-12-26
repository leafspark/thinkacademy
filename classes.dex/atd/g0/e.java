package atd.g0;

import atd.s0.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends b {
    private final byte[] b;

    static {
        a.a(-797316392741440L);
    }

    e(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.b = atd.r0.a.a().a(jSONObject.getString(a.a(-798098076789312L)));
    }

    public byte[] c() {
        return (byte[]) this.b.clone();
    }

    public e(String str, byte[] bArr) {
        super(str, a.a(-797299212872256L));
        this.b = (byte[]) bArr.clone();
    }
}
