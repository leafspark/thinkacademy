package com.igexin.push.core.a.a;

import com.igexin.b.a.c.b;
import com.igexin.push.core.a;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.d;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements a {
    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.a;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            BaseAction baseAction = new BaseAction();
            baseAction.setType("null");
            baseAction.setActionId(jSONObject.getString("actionid"));
            return baseAction;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        String a = e.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId());
        b.a("EndAction execute, remove key = " + a, new Object[0]);
        try {
            d.ae.remove(a);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
