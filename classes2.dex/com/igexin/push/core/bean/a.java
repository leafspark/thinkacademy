package com.igexin.push.core.bean;

import android.os.Build;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.igexin.push.config.l;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.d;
import com.igexin.push.core.x;
import com.igexin.push.util.m;
import org.json.JSONObject;

public class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f = "open";
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public long n;

    public a() {
        if (d.e != null) {
            this.f += ":" + d.e;
        }
        this.e = "4.4.3.1";
        this.b = d.x;
        this.c = d.w;
        this.d = d.z;
        this.a = d.y;
        this.h = "ANDROID";
        this.j = "android" + Build.VERSION.RELEASE;
        this.k = "MDP";
        this.g = d.A;
        this.n = System.currentTimeMillis();
        this.l = d.B;
        this.m = m.a();
        if (com.igexin.assist.sdk.a.i(d.g) && l.H) {
            StringBuilder sb = new StringBuilder();
            sb.append("FCM-");
            String str = this.m;
            sb.append(str == null ? "" : str);
            this.m = sb.toString();
        }
    }

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        String str = aVar.a;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        jSONObject.put("model", str);
        String str3 = aVar.b;
        if (str3 == null) {
            str3 = str2;
        }
        jSONObject.put("sim", str3);
        String str4 = aVar.c;
        if (str4 == null) {
            str4 = str2;
        }
        jSONObject.put("imei", str4);
        String str5 = aVar.d;
        if (str5 == null) {
            str5 = str2;
        }
        jSONObject.put("mac", str5);
        String str6 = aVar.e;
        if (str6 == null) {
            str6 = str2;
        }
        jSONObject.put("version", str6);
        String str7 = aVar.f;
        if (str7 == null) {
            str7 = str2;
        }
        jSONObject.put("channelid", str7);
        jSONObject.put(HummerStyleUtils.Hummer.TYPE, "ANDROID");
        String str8 = aVar.k;
        if (str8 == null) {
            str8 = str2;
        }
        jSONObject.put("app", str8);
        StringBuilder sb = new StringBuilder();
        sb.append("ANDROID-");
        String str9 = aVar.g;
        if (str9 == null) {
            str9 = str2;
        }
        sb.append(str9);
        jSONObject.put("deviceid", sb.toString());
        String str10 = aVar.l;
        if (str10 == null) {
            str10 = str2;
        }
        jSONObject.put("device_token", str10);
        String str11 = aVar.m;
        if (str11 == null) {
            str11 = str2;
        }
        jSONObject.put("brand", str11);
        String str12 = aVar.j;
        if (str12 == null) {
            str12 = str2;
        }
        jSONObject.put("system_version", str12);
        String str13 = aVar.i;
        if (str13 == null) {
            str13 = str2;
        }
        jSONObject.put("cell", str13);
        jSONObject.put("aid", str2);
        jSONObject.put("adid", str2);
        String name = x.a().b(d.g).getName();
        if (!CoreConsts.p.equals(name)) {
            jSONObject.put("us", name);
        }
        jSONObject.put("ua", x.a().d(d.g));
        if (d.ax != null) {
            str2 = d.ax;
        }
        jSONObject.put("oaid", str2);
        jSONObject.put("notification_enabled", com.igexin.push.util.a.b(d.g) ? 1 : 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("action", "addphoneinfo");
        jSONObject2.put("id", String.valueOf(aVar.n));
        jSONObject2.put("info", jSONObject);
        return !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
    }
}
