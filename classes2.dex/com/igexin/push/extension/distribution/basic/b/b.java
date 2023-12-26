package com.igexin.push.extension.distribution.basic.b;

import android.text.TextUtils;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.igexin.push.core.bean.BaseAction;
import org.json.JSONObject;

public class b extends BaseAction {
    private long a;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("actionid")) {
            bVar.setActionId(jSONObject.getString("actionid"));
        }
        if (jSONObject.has(HummerStyleUtils.Hummer.TYPE)) {
            bVar.setType(jSONObject.getString(HummerStyleUtils.Hummer.TYPE));
        }
        if (jSONObject.has("do")) {
            bVar.setDoActionId(jSONObject.getString("do"));
        }
        if (jSONObject.has("delay")) {
            double d = jSONObject.getDouble("delay");
            if (d > 0.0d) {
                bVar.a((long) (d * 1000.0d));
                return bVar;
            }
        }
        bVar.a(200);
        return bVar;
    }

    public long a() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }
}
