package com.bonree.sdk.agent.business.util;

import com.bonree.sdk.common.json.JSONArray;
import com.bonree.sdk.common.json.JSONException;
import com.bonree.sdk.common.json.JSONObject;

public final class j {
    public static String a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static long b(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getLong(str);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static JSONArray c(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int d(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static double e(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return 0.0d;
        }
    }

    private static boolean h(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static float f(JSONObject jSONObject, String str) {
        try {
            return (float) jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return 0.0f;
        }
    }

    public static Object g(JSONObject jSONObject, String str) {
        try {
            return jSONObject.get(str);
        } catch (JSONException unused) {
            return "";
        }
    }
}
