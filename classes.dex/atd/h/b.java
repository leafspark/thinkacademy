package atd.h;

import android.content.Context;
import atd.i.c;
import atd.y.c;
import com.adyen.threeds2.Warning;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private final Map<a, JSONObject> a = new LinkedHashMap();

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
                atd.h.a[] r0 = atd.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                atd.h.a r1 = atd.h.a.V1_1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.h.a r1 = atd.h.a.V1_4     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.h.b.a.<clinit>():void");
        }
    }

    private b(Context context, ConfigParameters configParameters, List<Warning> list) throws InvalidInputException {
        JSONArray a2 = a(list);
        for (a next : a.a()) {
            try {
                JSONObject a3 = a(context, next, configParameters);
                a3.put(atd.s0.a.a(-85910894733888L), a2);
                this.a.put(next, a3);
            } catch (JSONException e) {
                throw c.DEVICE_DATA_FAILURE.a(e);
            }
        }
    }

    public static b a(Context context, ConfigParameters configParameters, List<Warning> list) throws InvalidInputException {
        return new b(context.getApplicationContext(), configParameters, list);
    }

    private boolean b(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof JSONArray) && ((JSONArray) obj).length() == 0) {
            return true;
        }
        if (!(obj instanceof JSONObject) || ((JSONObject) obj).length() != 0) {
            return false;
        }
        return true;
    }

    public JSONObject a(a aVar) {
        if (aVar.c()) {
            JSONObject jSONObject = this.a.get(aVar);
            if (jSONObject != null) {
                return jSONObject;
            }
            throw c.DEVICE_DATA_FAILURE.a();
        }
        throw c.DEVICE_DATA_FAILURE.a();
    }

    private JSONObject a(Context context, a aVar, ConfigParameters configParameters) throws JSONException, InvalidInputException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        List<atd.i.b> b = f.a(aVar).b();
        Collection<String> paramValues = AdyenConfigParameters.getParamValues(configParameters, AdyenConfigParameters.DEVICE_PARAMETER_BLOCK_LIST);
        for (atd.i.b next : b) {
            String a2 = next.a();
            if (paramValues == null || !paramValues.contains(a2)) {
                try {
                    Object a3 = next.a(context);
                    if (b(a3)) {
                        int i = a.a[aVar.ordinal()];
                        if (i == 1) {
                            jSONObject.put(a2, a(a3));
                        } else if (i != 2) {
                            throw new InvalidInputException(atd.s0.a.a(-85932369570368L) + aVar.toString(), (Throwable) null);
                        } else {
                            throw new atd.i.c(c.a.PARAMETER_NULL_OR_BLANK, (Throwable) null);
                        }
                    } else {
                        if (aVar == a.V1_4 && !(a3 instanceof JSONArray)) {
                            a3 = a3.toString();
                        }
                        jSONObject.put(a2, a3);
                    }
                } catch (atd.i.c e) {
                    jSONObject2.put(a2, e.a());
                }
            } else {
                jSONObject2.put(a2, c.a.MARKET_OR_REGIONAL_RESTRICTION.a());
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(atd.s0.a.a(-86035448785472L), aVar.b());
        jSONObject3.put(atd.s0.a.a(-86022563883584L), jSONObject);
        jSONObject3.put(atd.s0.a.a(-85769160813120L), jSONObject2);
        return jSONObject3;
    }

    private JSONArray a(List<Warning> list) {
        JSONArray jSONArray = new JSONArray();
        for (Warning id : list) {
            jSONArray.put(id.getID());
        }
        return jSONArray;
    }

    private Object a(Object obj) {
        if (obj == null || !(obj instanceof JSONArray) || ((JSONArray) obj).length() != 0) {
            return atd.s0.a.a(-85782045715008L);
        }
        return obj;
    }
}
