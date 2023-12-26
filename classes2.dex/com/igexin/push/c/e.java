package com.igexin.push.c;

import org.json.JSONObject;

public final class e {
    public String a;
    public long b;

    public e a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this;
        }
        try {
            this.a = jSONObject.getString("address");
            this.b = jSONObject.getLong("outdateTime");
        } catch (Exception unused) {
        }
        return this;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("address", this.a);
            jSONObject.put("outdateTime", this.b);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        return "ServerAddress{address='" + this.a + '\'' + ", outdateTime=" + this.b + '}';
    }
}
