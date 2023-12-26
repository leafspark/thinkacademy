package com.igexin.push.core.a;

import com.igexin.b.a.c.b;
import com.igexin.push.config.k;
import com.igexin.push.core.b.i;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import org.json.JSONObject;

public class u extends b {
    private static final String a = k.a;

    public boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("response_deviceid")) {
                return true;
            }
            String string = jSONObject.getString("deviceid");
            b.a(a + " get devid resp, devid : " + string + ", save 2db and file", new Object[0]);
            i.a().b(string);
            if (d.A != null) {
                c.a().j().e();
            }
            b.a("deviceidRsp|" + d.A, new Object[0]);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
