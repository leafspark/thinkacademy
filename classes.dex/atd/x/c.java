package atd.x;

import atd.g0.b;
import atd.r0.f;
import atd.y.a;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static b a(String str, ConfigParameters configParameters) {
        if (str == null || str.isEmpty()) {
            return a(configParameters);
        }
        return a(str);
    }

    private static b a(ConfigParameters configParameters) {
        f.a((Object) configParameters, a.CONFIG_PARAMETERS);
        try {
            return a(atd.r0.a.a().b(AdyenConfigParameters.getParamValue(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_PUBLIC_KEY)), AdyenConfigParameters.getParamValue(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_ID));
        } catch (JSONException e) {
            throw atd.y.c.UNKNOWN_DIRECTORY_SERVER.a(e);
        } catch (IllegalArgumentException unused) {
            throw a.CONFIG_PARAMETERS.a();
        }
    }

    private static b a(String str) {
        f.a(str, a.DIRECTORY_SERVER_ID);
        try {
            return a(new JSONObject(d.b(str)), str);
        } catch (JSONException e) {
            throw atd.y.c.UNKNOWN_DIRECTORY_SERVER.a(e);
        }
    }

    private static b a(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(atd.s0.a.a(-582151416113728L))) {
            jSONObject.put(atd.s0.a.a(-582168595982912L), str);
        }
        return b.a(jSONObject);
    }
}
