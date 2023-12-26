package com.sensorsdata.analytics.android.sdk.util;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
    public static String optionalStringKey(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    private static void addIndentBlank(StringBuilder sb, int i) {
        int i2 = 0;
        while (i2 < i) {
            try {
                sb.append(9);
                i2++;
            } catch (Exception e) {
                SALog.printStackTrace(e);
                return;
            }
        }
    }

    public static String formatJson(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    char c = 0;
                    boolean z = false;
                    int i2 = 0;
                    while (i < str.length()) {
                        char charAt = str.charAt(i);
                        if (charAt == '\"') {
                            if (c != '\\') {
                                z = !z;
                            }
                            sb.append(charAt);
                        } else if (charAt != ',') {
                            if (charAt != '{') {
                                if (charAt != '}') {
                                    switch (charAt) {
                                        case '[':
                                            break;
                                        case '\\':
                                            break;
                                        case ']':
                                            break;
                                        default:
                                            sb.append(charAt);
                                            break;
                                    }
                                }
                                if (!z) {
                                    sb.append(10);
                                    i2--;
                                    addIndentBlank(sb, i2);
                                }
                                sb.append(charAt);
                            }
                            sb.append(charAt);
                            if (!z) {
                                sb.append(10);
                                i2++;
                                addIndentBlank(sb, i2);
                            }
                        } else {
                            sb.append(charAt);
                            if (c != '\\' && !z) {
                                sb.append(10);
                                addIndentBlank(sb, i2);
                            }
                        }
                        i++;
                        c = charAt;
                    }
                    return sb.toString();
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
        return "";
    }

    public static Map<String, String> json2Map(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        return hashMap;
    }

    public static void mergeDistinctProperty(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject2.has(next)) {
                    Object obj = jSONObject.get(next);
                    if (!(obj instanceof Date) || "$time".equals(next)) {
                        jSONObject2.put(next, obj);
                    } else {
                        jSONObject2.put(next, TimeUtils.formatDate((Date) obj, Locale.CHINA));
                    }
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
