package com.igexin.push.extension.distribution.basic.g;

import android.content.Context;
import android.content.SharedPreferences;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;

public class g {
    public static void a(Context context, String str, Object obj) {
        Context applicationContext = context.getApplicationContext();
        SharedPreferences.Editor edit = (!(applicationContext instanceof Context) ? applicationContext.getSharedPreferences("getui_sp", 0) : XMLParseInstrumentation.getSharedPreferences(applicationContext, "getui_sp", 0)).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.commit();
    }

    public static Object b(Context context, String str, Object obj) {
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = !(applicationContext instanceof Context) ? applicationContext.getSharedPreferences("getui_sp", 0) : XMLParseInstrumentation.getSharedPreferences(applicationContext, "getui_sp", 0);
        return obj instanceof String ? sharedPreferences.getString(str, (String) obj) : obj instanceof Integer ? Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : obj instanceof Float ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue())) : obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : obj;
    }
}
