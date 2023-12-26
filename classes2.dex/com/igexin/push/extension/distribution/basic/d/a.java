package com.igexin.push.extension.distribution.basic.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.igexin.push.extension.distribution.basic.c.e;

public class a {
    public static a a;
    private SharedPreferences b;

    private a() {
        Context context = e.a;
        this.b = !(context instanceof Context) ? context.getSharedPreferences("gx_sp", 0) : XMLParseInstrumentation.getSharedPreferences(context, "gx_sp", 0);
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static String b() {
        Context context = e.a;
        return (!(context instanceof Context) ? context.getSharedPreferences("getui_sp", 0) : XMLParseInstrumentation.getSharedPreferences(context, "getui_sp", 0)).getString("us", "");
    }

    public static String c() {
        Context context = e.a;
        return (!(context instanceof Context) ? context.getSharedPreferences("getui_sp", 0) : XMLParseInstrumentation.getSharedPreferences(context, "getui_sp", 0)).getString("uis", "");
    }
}
