package com.igexin.push.config;

import com.igexin.b.a.c.b;
import com.igexin.push.c.i;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
    public static void a(String str, boolean z) {
        JSONObject jSONObject;
        String[] a;
        String[] a2;
        String[] a3;
        String[] a4;
        String[] a5;
        b.a("IDCConfigParse parse idc config data : " + str, new Object[0]);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            if (jSONObject.has("N")) {
                try {
                    SDKUrlConfig.setLocation(jSONObject.getString("N"));
                } catch (JSONException unused2) {
                }
            }
            if (jSONObject.has("X1") && (a5 = a(jSONObject, "X1")) != null && a5.length > 0 && !Arrays.equals(a5, SDKUrlConfig.getXfrAddress())) {
                SDKUrlConfig.setXfrAddressIps(a5);
                if (z) {
                    b.a("DT_IDCConfigParse xfr changed, reset and redetect ++++++", new Object[0]);
                    i.a().e();
                }
            }
            if (jSONObject.has("X2") && (a4 = a(jSONObject, "X2")) != null && a4.length > 0) {
                SDKUrlConfig.XFR_ADDRESS_BAK = a4;
            }
            if (jSONObject.has("B") && (a3 = a(jSONObject, "B")) != null && a3.length > 0) {
                SDKUrlConfig.BI_ADDRESS_IPS = a3;
            }
            if (jSONObject.has("C") && (a2 = a(jSONObject, "C")) != null && a2.length > 0) {
                SDKUrlConfig.CONFIG_ADDRESS_IPS = a2;
            }
            if (jSONObject.has("S") && (a = a(jSONObject, "S")) != null && a.length > 0) {
                SDKUrlConfig.STATE_ADDRESS_IPS = a;
            }
        }
    }

    private static String[] a(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                if (!str.equals("X1")) {
                    if (!str.equals("X2")) {
                        strArr[i] = "https://" + jSONArray.getString(i);
                    }
                }
                strArr[i] = "socket://" + jSONArray.getString(i);
            }
            return strArr;
        } catch (Exception unused) {
            return null;
        }
    }
}
