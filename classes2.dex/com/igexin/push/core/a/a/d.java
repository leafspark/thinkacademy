package com.igexin.push.core.a.a;

import com.igexin.push.core.a;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.f;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements a {
    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.a;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            f fVar = new f();
            fVar.setType("goto");
            fVar.setActionId(jSONObject.getString("actionid"));
            fVar.setDoActionId(jSONObject.getString("do"));
            return fVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (pushTaskBean == null || baseAction == null || baseAction.getDoActionId() == null || baseAction.getDoActionId().equals("")) {
            return true;
        }
        e.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
