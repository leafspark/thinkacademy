package com.igexin.push.core.a;

import android.text.TextUtils;
import com.igexin.b.a.d.e;
import com.igexin.push.config.k;
import com.igexin.push.d.c.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class j extends a {
    private static final String a = k.a;
    private static Map<String, b> b;

    public j() {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("redirect_server", new r());
        b.put("response_deviceid", new u());
        b.put("pushmessage", new p());
        b.put("received", new q());
        b.put("sendmessage_feedback", new v());
        b.put("block_client", new d());
        b.put("settag_result", new w());
        b.put("response_bind", new c());
        b.put("response_unbind", new x());
    }

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        b bVar;
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (!mVar.b() || mVar.e == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) mVar.e);
            String optString = jSONObject.optString("action");
            if (!optString.equals("received") && !optString.equals("redirect_server") && jSONObject.has("id")) {
                e.a().a(jSONObject.getString("id"));
            }
            if (TextUtils.isEmpty(optString) || (bVar = b.get(optString)) == null) {
                return false;
            }
            return bVar.a(obj, jSONObject);
        } catch (Exception unused) {
            return false;
        }
    }
}
