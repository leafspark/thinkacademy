package atd.d;

import atd.e.c;
import atd.e.d;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class j extends k {
    private final d a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final List<h> f;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.e.d[] r0 = atd.e.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                atd.e.d r1 = atd.e.d.CHALLENGE_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.d r1 = atd.e.d.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.d.j.a.<clinit>():void");
        }
    }

    j(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        try {
            this.a = d.a(b(jSONObject, atd.s0.a.a(-95630405724736L)));
            this.b = b(jSONObject, atd.s0.a.a(-95407067425344L));
            this.c = c(jSONObject, atd.s0.a.a(-95480081869376L));
            this.d = g(jSONObject, atd.s0.a.a(-94737052527168L));
            this.e = c(jSONObject, atd.s0.a.a(-94792887102016L));
            JSONArray optJSONArray = jSONObject.optJSONArray(atd.s0.a.a(-94573843769920L));
            List<h> a2 = optJSONArray != null ? h.a(optJSONArray) : null;
            this.f = a2;
            if (a2 == null) {
                return;
            }
            if (a2.size() > 10) {
                throw new atd.a0.a(String.format(Locale.ENGLISH, atd.s0.a.a(-94638268279360L), new Object[]{Integer.valueOf(a2.size())}), c.DATA_ELEMENT_INVALID_FORMAT);
            }
        } catch (JSONException e2) {
            throw new atd.a0.a(atd.s0.a.a(-95007635466816L), e2, c.DATA_ELEMENT_MISSING);
        }
    }

    public static j a(JSONObject jSONObject) throws atd.a0.a {
        try {
            String string = jSONObject.getString(atd.s0.a.a(-95346937883200L));
            int i = a.a[d.a(string).ordinal()];
            if (i == 1) {
                return new c(jSONObject);
            }
            if (i == 2) {
                return new e(jSONObject);
            }
            throw new atd.a0.a(atd.s0.a.a(-95527326509632L) + string, c.MESSAGE_RECEIVED_INVALID);
        } catch (JSONException e2) {
            throw new atd.a0.a(atd.s0.a.a(-95123599583808L), e2, c.MESSAGE_RECEIVED_INVALID);
        }
    }

    public d b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.c;
    }

    public abstract boolean f();

    /* access modifiers changed from: package-private */
    public abstract String g(JSONObject jSONObject, String str) throws atd.a0.a, JSONException;

    public String a() {
        return this.d;
    }
}
