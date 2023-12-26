package atd.d;

import atd.a0.a;
import atd.e.c;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class h extends k {
    private static final Collection<String> e = Collections.emptyList();
    private final String a;
    private final String b;
    private final boolean c;
    private final JSONObject d;

    h(JSONObject jSONObject) throws a {
        super(jSONObject);
        try {
            String b2 = b(jSONObject, atd.s0.a.a(-97125054343744L));
            this.a = b2;
            if (b2.length() <= 64) {
                String b3 = b(jSONObject, atd.s0.a.a(-96429269641792L));
                this.b = b3;
                if (b3.length() <= 64) {
                    boolean z = jSONObject.getBoolean(atd.s0.a.a(-96257470949952L));
                    this.c = z;
                    if (z) {
                        if (!e.contains(b3)) {
                            throw new a(atd.s0.a.a(-96339075328576L), c.MESSAGE_EXTENSION_MISSING);
                        }
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject(atd.s0.a.a(-96506579053120L));
                    this.d = jSONObject2;
                    if ((!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).length() > 8059) {
                        throw new a(atd.s0.a.a(-96519463955008L), c.DATA_ELEMENT_INVALID_FORMAT);
                    }
                    return;
                }
                throw new a(atd.s0.a.a(-96416384739904L), c.DATA_ELEMENT_INVALID_FORMAT);
            }
            throw new a(atd.s0.a.a(-97137939245632L), c.DATA_ELEMENT_INVALID_FORMAT);
        } catch (JSONException e2) {
            throw new a(atd.s0.a.a(-95810794351168L), e2, c.DATA_ELEMENT_MISSING);
        }
    }

    static List<h> a(JSONArray jSONArray) throws JSONException, a {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new h(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }
}
