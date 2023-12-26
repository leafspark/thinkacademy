package com.igexin.push.core.a.a;

import android.content.Intent;
import android.text.TextUtils;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.igexin.push.config.k;
import com.igexin.push.core.a;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.j;
import com.igexin.push.core.d;
import com.igexin.push.util.b;
import org.json.JSONObject;

public class f implements a {
    private static final String a = k.a;

    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        j jVar = (j) baseAction;
        try {
            Intent a2 = b.a(jVar.a(), 0);
            a2.setPackage(d.g.getPackageName());
            a2.addFlags(268435456);
            if (com.igexin.push.util.a.b(a2, d.g)) {
                return a.a;
            }
            com.igexin.b.a.c.b.a(a + "|execute failed, activity not exist", new Object[0]);
            e.a().a(pushTaskBean.getId(), pushTaskBean.getMessageId(), jVar.b());
            return a.stop;
        } catch (Throwable th) {
            com.igexin.b.a.c.b.a(a + "|execute exception = " + th.toString(), new Object[0]);
            e.a().a(pushTaskBean.getId(), pushTaskBean.getMessageId(), jVar.b());
            return a.stop;
        }
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has(HummerStyleUtils.Hummer.TYPE) || !jSONObject.has("uri") || !jSONObject.has("do_failed")) {
                return null;
            }
            String optString = jSONObject.optString("uri");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            j jVar = new j();
            jVar.setType("startmyactivity");
            jVar.setActionId(jSONObject.getString("actionid"));
            jVar.setDoActionId(jSONObject.getString("do"));
            jVar.a(optString);
            jVar.b(jSONObject.optString("do_failed"));
            return jVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        e a2;
        String id;
        String messageId;
        String b;
        j jVar = (j) baseAction;
        try {
            Intent a3 = b.a(jVar.a(), 0);
            a3.setPackage(d.g.getPackageName());
            a3.addFlags(268435456);
            if (com.igexin.push.util.a.b(a3, d.g)) {
                d.g.startActivity(a3);
                a2 = e.a();
                id = pushTaskBean.getTaskId();
                messageId = pushTaskBean.getMessageId();
                b = jVar.getDoActionId();
            } else {
                com.igexin.b.a.c.b.a(a + "|execute failed, activity not exist", new Object[0]);
                a2 = e.a();
                id = pushTaskBean.getId();
                messageId = pushTaskBean.getMessageId();
                b = jVar.b();
            }
            a2.a(id, messageId, b);
            return true;
        } catch (Throwable th) {
            com.igexin.b.a.c.b.a(a + "|execute exception = " + th.getMessage(), new Object[0]);
            e.a().a(pushTaskBean.getId(), pushTaskBean.getMessageId(), jVar.b());
            return true;
        }
    }
}
