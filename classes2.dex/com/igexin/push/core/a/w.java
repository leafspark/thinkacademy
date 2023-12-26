package com.igexin.push.core.a;

import com.igexin.b.a.c.b;
import com.igexin.push.config.k;
import com.igexin.push.core.r;
import org.json.JSONObject;

public class w extends b {
    private static final String a = (k.a + "_SetTagResultAction");

    public boolean a(Object obj, JSONObject jSONObject) {
        b.a(a + "|set tag result resp data = " + jSONObject, new Object[0]);
        if (jSONObject == null) {
            return true;
        }
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("settag_result")) {
                return true;
            }
            r.a().a(jSONObject.getString("sn"), jSONObject.getString("error_code"));
            return true;
        } catch (Exception e) {
            b.a(a + "|" + e.toString(), new Object[0]);
            return true;
        }
    }
}
