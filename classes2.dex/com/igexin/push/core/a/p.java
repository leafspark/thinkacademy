package com.igexin.push.core.a;

import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.a;
import com.igexin.b.a.c.b;
import com.igexin.push.core.d;
import com.igexin.push.core.w;
import com.igexin.push.d.c.m;
import org.json.JSONObject;

public class p extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        e a;
        String str;
        try {
            m mVar = (m) obj;
            if (jSONObject.has("action") && jSONObject.getString("action").equals("pushmessage")) {
                byte[] bArr = null;
                if (mVar.f instanceof byte[]) {
                    bArr = (byte[]) mVar.f;
                }
                String string = jSONObject.getString("taskid");
                b.a("getui receive message : %s", jSONObject);
                if (bArr == null || !a.h(d.g)) {
                    w.a().a(jSONObject, bArr, true);
                } else {
                    com.igexin.push.core.b.d dVar = new com.igexin.push.core.b.d(d.g);
                    if (!dVar.a(string)) {
                        dVar.b(string);
                        w.a().a(jSONObject, bArr, true);
                        a = e.a();
                        str = "10";
                    } else {
                        a = e.a();
                        str = "1" + MessageManger.getInstance().getBrandCode(d.g);
                    }
                    a.a(jSONObject, str);
                }
            }
        } catch (Exception e) {
            b.a("PushmessageAction|" + e.toString(), new Object[0]);
        }
        return true;
    }
}
