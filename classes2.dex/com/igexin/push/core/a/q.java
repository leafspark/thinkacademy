package com.igexin.push.core.a;

import com.igexin.b.a.c.b;
import com.igexin.push.core.b.e;
import org.json.JSONObject;

public class q extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("received")) {
                String string = jSONObject.getString("id");
                b.a("ReceivedAction received, cmd id :" + string, new Object[0]);
                try {
                    e.a().a(Long.parseLong(string), true, false);
                    e.a().c();
                } catch (NumberFormatException e) {
                    b.a("ReceivedAction|" + e.toString(), new Object[0]);
                }
            }
        } catch (Exception e2) {
            b.a("ReceivedAction|" + e2.toString(), new Object[0]);
        }
        return true;
    }
}
