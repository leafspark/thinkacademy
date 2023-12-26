package com.igexin.push.core.a;

import com.igexin.push.a.a.c;
import com.igexin.push.config.a;
import com.igexin.push.config.l;
import org.json.JSONObject;

public class d extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("block_client") || !jSONObject.has("duration")) {
                return true;
            }
            long j = jSONObject.getLong("duration") * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            if (j == 0) {
                return true;
            }
            l.c = currentTimeMillis + j;
            a.a().e();
            c.c().d();
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
