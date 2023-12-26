package com.igexin.push.core.a;

import com.igexin.push.core.b.d;
import com.igexin.push.f.b;
import java.util.Iterator;
import org.json.JSONObject;

class n extends b {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    /* access modifiers changed from: protected */
    public void a() {
        try {
            d dVar = new d(com.igexin.push.core.d.g);
            JSONObject c = dVar.c();
            if (c != null) {
                Iterator<String> keys = c.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = c.getJSONObject(next);
                    com.igexin.b.a.c.b.a("LoginResultAction|send unFeedback taskid = " + next, new Object[0]);
                    jSONObject.put("appid", com.igexin.push.core.d.a);
                    jSONObject.put("appkey", com.igexin.push.core.d.b);
                    e.a().a(jSONObject, jSONObject.getString("multaid"));
                    keys.remove();
                }
                dVar.d();
            }
        } catch (Throwable th) {
            com.igexin.b.a.c.b.a("LoginResultAction|feedbackMultiBrandPushMessage exception :" + th.toString(), new Object[0]);
        }
    }
}
