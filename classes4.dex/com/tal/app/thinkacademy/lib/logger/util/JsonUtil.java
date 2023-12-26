package com.tal.app.thinkacademy.lib.logger.util;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    private static Gson sGson = new Gson();

    public static String objectToJson(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            Gson gson = sGson;
            return !(gson instanceof Gson) ? gson.toJson(obj) : GsonInstrumentation.toJson(gson, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static <T> T jsonToObject(String str, Type type) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Gson gson = sGson;
            return !(gson instanceof Gson) ? gson.fromJson(str, type) : GsonInstrumentation.fromJson(gson, str, type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T getEntityFromJson(String str, Class<T> cls) {
        try {
            Gson gson = new Gson();
            return !(gson instanceof Gson) ? gson.fromJson(str, cls) : GsonInstrumentation.fromJson(gson, str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> jsonToList(String str, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                arrayList.add(getEntityFromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), cls));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<Map<String, Object>> getListKeyMaps(String str) {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Map<String, Object>>>() {
            }.getType();
            return (List) (!(gson instanceof Gson) ? gson.fromJson(str, type) : GsonInstrumentation.fromJson(gson, str, type));
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static <T> ArrayList<T> fromJsonList(String str, Class<T> cls) {
        Gson gson = new Gson();
        ArrayList<T> arrayList = new ArrayList<>();
        Iterator it = new JsonParser().parse(str).getAsJsonArray().iterator();
        while (it.hasNext()) {
            JsonElement jsonElement = (JsonElement) it.next();
            arrayList.add(!(gson instanceof Gson) ? gson.fromJson(jsonElement, cls) : GsonInstrumentation.fromJson(gson, jsonElement, cls));
        }
        return arrayList;
    }

    public static Map<String, String> jsonToMap(String str) {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            return (Map) (!(gson instanceof Gson) ? gson.fromJson(str, type) : GsonInstrumentation.fromJson(gson, str, type));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toJson(Object obj) {
        try {
            Gson create = new GsonBuilder().disableHtmlEscaping().create();
            return !(create instanceof Gson) ? create.toJson(obj) : GsonInstrumentation.toJson(create, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
