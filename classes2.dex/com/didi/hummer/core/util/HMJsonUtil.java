package com.didi.hummer.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HMJsonUtil {
    public static Map<String, Object> toMap(String str) {
        try {
            return toMap(new JSONObject(str));
        } catch (Exception unused) {
            return new HashMap();
        }
    }

    public static List<Object> toList(String str) {
        try {
            return toList(new JSONArray(str));
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || jSONObject == JSONObject.NULL)) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONArray) {
                    obj = toList((JSONArray) obj);
                } else if (obj instanceof JSONObject) {
                    obj = toMap((JSONObject) obj);
                }
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!(jSONArray == null || arrayList == JSONObject.NULL)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONArray) {
                    obj = toList((JSONArray) obj);
                } else if (obj instanceof JSONObject) {
                    obj = toMap((JSONObject) obj);
                }
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
