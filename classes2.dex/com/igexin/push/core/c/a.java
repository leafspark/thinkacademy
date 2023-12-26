package com.igexin.push.core.c;

import com.bonree.sdk.agent.engine.external.JSONArrayInstrumentation;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.n;
import com.igexin.push.core.a.r;
import com.igexin.push.core.b.i;
import com.igexin.push.f.a.b;
import com.igexin.push.util.g;
import org.json.JSONArray;

public class a extends b {
    public static JSONArray b;
    public final String a = getClass().getName();

    public a(String str, JSONArray jSONArray) {
        super(str);
        a(jSONArray);
    }

    public void a(Exception exc) {
        i.a().b(System.currentTimeMillis());
        com.igexin.b.a.c.b.a("-> get idc config " + exc.toString(), new Object[0]);
    }

    public void a(JSONArray jSONArray) {
        b = jSONArray;
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            try {
                String str = new String(com.igexin.b.b.a.c(g.a(bArr, 0)));
                com.igexin.b.a.c.b.a("->get idc config server resp data : " + str, new Object[0]);
                com.igexin.push.config.a.a().b(str);
                n.a(str, true);
                i.a().b(0);
                com.igexin.push.config.a a2 = com.igexin.push.config.a.a();
                JSONArray jSONArray = b;
                a2.a(!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray));
                SDKUrlConfig.setIdcConfigUrl(r.a(b));
            } catch (Exception e) {
                i.a().b(System.currentTimeMillis());
                throw e;
            }
        }
    }

    public int b_() {
        return 0;
    }
}
