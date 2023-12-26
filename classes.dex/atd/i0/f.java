package atd.i0;

import atd.r0.a;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private static final a b = a.a();
    private final byte[] a;

    protected f(byte[] bArr) {
        this.a = (byte[]) bArr.clone();
    }

    /* access modifiers changed from: protected */
    public final a a() {
        return b;
    }

    public final byte[] b() {
        return (byte[]) this.a.clone();
    }

    public final String c() {
        return a().d(this.a);
    }

    public final JSONObject d() throws JSONException {
        return new JSONObject(new String(b(), a().b()));
    }

    protected f(String str) {
        this.a = a().a(str);
    }
}
