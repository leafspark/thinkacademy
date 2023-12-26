package com.igexin.push.core.a;

import com.didi.hummer.render.event.base.TraceEvent;
import com.igexin.b.a.c.b;
import com.igexin.push.core.r;
import org.json.JSONObject;

public class v extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("sendmessage_feedback")) {
                return true;
            }
            String string = jSONObject.getString("appid");
            String string2 = jSONObject.getString("taskid");
            String string3 = jSONObject.getString("actionid");
            String string4 = jSONObject.getString("result");
            long j = jSONObject.getLong(TraceEvent.TIMESTAMP);
            b.a("SendMessageFeedbackAction|appid:" + string + "|taskid:" + string2 + "|actionid:" + string3, new Object[0]);
            r.a().a(string, string2, string3, string4, j);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
