package com.igexin.push.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.igexin.b.a.c.b;
import com.igexin.b.b.a;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.x;

public class n {
    public static void a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("us")) {
                String b = a.b(intent.getStringExtra("us"), "");
                String str = (String) c(context, "us", "", new String[0]);
                if (!str.equals(b)) {
                    if (!CoreConsts.p.equals(b)) {
                        a(context, "us", b, new String[0]);
                    } else if (!TextUtils.isEmpty(str)) {
                        a(context, "us", "", new String[0]);
                    }
                }
            }
            if (intent.hasExtra("uis")) {
                String b2 = a.b(intent.getStringExtra("uis"), "");
                if (!((String) c(context, "uis", "", new String[0])).equals(b2)) {
                    a(context, "uis", b2, new String[0]);
                }
            }
            if (intent.hasExtra("ua")) {
                String d = x.a().d(context);
                String b3 = a.b(intent.getStringExtra("ua"), "");
                if (!d.equals(b3)) {
                    a(context, "ua", b3, new String[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, Object obj, String... strArr) {
        Context applicationContext = context.getApplicationContext();
        String str2 = (strArr == null || strArr.length != 1) ? "getui_sp" : strArr[0];
        SharedPreferences.Editor edit = (!(applicationContext instanceof Context) ? applicationContext.getSharedPreferences(str2, 0) : XMLParseInstrumentation.getSharedPreferences(applicationContext, str2, 0)).edit();
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
        edit.apply();
    }

    public static boolean a(Context context) {
        try {
            String str = (String) c(context, "us", "", new String[0]);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Class.forName(str);
            return true;
        } catch (Exception e) {
            b.a("SpUtils|" + e.toString(), new Object[0]);
            return false;
        }
    }

    public static void b(Context context, String str, Object obj, String... strArr) {
        Context applicationContext = context.getApplicationContext();
        String str2 = (strArr == null || strArr.length != 1) ? "getui_sp" : strArr[0];
        SharedPreferences.Editor edit = (!(applicationContext instanceof Context) ? applicationContext.getSharedPreferences(str2, 0) : XMLParseInstrumentation.getSharedPreferences(applicationContext, str2, 0)).edit();
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

    public static Object c(Context context, String str, Object obj, String... strArr) {
        Context applicationContext = context.getApplicationContext();
        String str2 = (strArr == null || strArr.length != 1) ? "getui_sp" : strArr[0];
        SharedPreferences sharedPreferences = !(applicationContext instanceof Context) ? applicationContext.getSharedPreferences(str2, 0) : XMLParseInstrumentation.getSharedPreferences(applicationContext, str2, 0);
        return obj instanceof String ? sharedPreferences.getString(str, (String) obj) : obj instanceof Integer ? Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : obj instanceof Float ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue())) : obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : obj;
    }
}
