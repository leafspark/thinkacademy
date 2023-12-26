package com.igexin.push.core.a;

import com.igexin.b.a.c.b;
import com.igexin.push.config.k;
import com.igexin.push.core.r;
import org.json.JSONObject;

public class x extends b {
    private static final String a = (k.a + "_UnBindAliasResultAction");

    public boolean a(Object obj, JSONObject jSONObject) {
        b.a(a + "|unbind alias result resp data = " + jSONObject, new Object[0]);
        if (jSONObject == null) {
            return true;
        }
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("response_unbind")) {
                return true;
            }
            r.a().c(jSONObject.getString("sn"), jSONObject.getString("result"));
            return true;
        } catch (Exception e) {
            b.a(a + "|" + e.toString(), new Object[0]);
            return true;
        }
    }
}
