package com.didi.hummer.core.util;

import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class HMGsonUtil {
    private static CustomizedObjectTypeAdapter adapter = new CustomizedObjectTypeAdapter();
    private static Gson sGson = new GsonBuilder().registerTypeAdapter(Map.class, adapter).registerTypeAdapter(List.class, adapter).registerTypeAdapter(new TypeToken<Map<String, Object>>() {
    }.getType(), adapter).registerTypeAdapter(new TypeToken<List<Object>>() {
    }.getType(), adapter).registerTypeAdapterFactory(new GsonTypeAdapterFactory()).create();

    public static Gson gson() {
        return sGson;
    }

    public static <T> T fromJson(String str, Type type) {
        try {
            Gson gson = sGson;
            return !(gson instanceof Gson) ? gson.fromJson(str, type) : GsonInstrumentation.fromJson(gson, str, type);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toJson(Object obj) {
        try {
            Gson gson = sGson;
            return !(gson instanceof Gson) ? gson.toJson(obj) : GsonInstrumentation.toJson(gson, obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isValidJsonString(String str) {
        try {
            Gson gson = sGson;
            Class<Object> cls = Object.class;
            return (!(gson instanceof Gson) ? gson.fromJson(str, cls) : GsonInstrumentation.fromJson(gson, str, cls)) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isJsonPrimitive(String str) {
        try {
            return new JsonParser().parse(str).isJsonPrimitive();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isJsonObject(String str) {
        try {
            return new JsonParser().parse(str).isJsonObject();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isJsonArray(String str) {
        try {
            return new JsonParser().parse(str).isJsonArray();
        } catch (Exception unused) {
            return false;
        }
    }
}
