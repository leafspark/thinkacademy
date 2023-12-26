package com.igexin.push.core.a.a;

import com.didi.hummer.render.style.HummerStyleUtils;
import com.igexin.push.core.a;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.d;
import org.json.JSONObject;

public class b implements a {
    private boolean a(String str) {
        try {
            return d.g.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.a;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has(HummerStyleUtils.Hummer.TYPE) || !jSONObject.has("actionid")) {
                return null;
            }
            com.igexin.push.core.bean.b bVar = new com.igexin.push.core.bean.b();
            bVar.setType("checkapp");
            bVar.setActionId(jSONObject.getString("actionid"));
            if (!jSONObject.has("appstartupid")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("appstartupid");
            if (!jSONObject2.has("android")) {
                return null;
            }
            bVar.a(jSONObject2.getString("android"));
            if (!jSONObject.has("do_installed")) {
                if (!jSONObject.has("do_uninstalled")) {
                    return null;
                }
            }
            if (jSONObject.has("do_installed")) {
                bVar.b(jSONObject.getString("do_installed"));
            }
            if (jSONObject.has("do_uninstalled")) {
                bVar.c(jSONObject.getString("do_uninstalled"));
            }
            return bVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        String str;
        e eVar;
        com.igexin.push.core.bean.b bVar = (com.igexin.push.core.bean.b) baseAction;
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        if (a(bVar.a())) {
            if (bVar.b() == null || bVar.b().equals("")) {
                return true;
            }
            eVar = e.a();
            str = bVar.b();
        } else if (bVar.c() == null || bVar.c().equals("")) {
            return true;
        } else {
            eVar = e.a();
            str = bVar.c();
        }
        eVar.a(taskId, messageId, str);
        return true;
    }
}
