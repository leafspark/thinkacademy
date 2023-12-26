package com.tal100.chatsdk.utils;

import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class GsonUtils {
    private GsonUtils() {
    }

    public static String toJson(Object obj) {
        try {
            Gson gson = new Gson();
            return !(gson instanceof Gson) ? gson.toJson(obj) : GsonInstrumentation.toJson(gson, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toJson(String str, Object obj) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(str, obj);
            Gson gson = new Gson();
            return !(gson instanceof Gson) ? gson.toJson(hashMap) : GsonInstrumentation.toJson(gson, hashMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object fromJsonToObject(String str, Type type) {
        try {
            Gson gson = new Gson();
            return !(gson instanceof Gson) ? gson.fromJson(str, type) : GsonInstrumentation.fromJson(gson, str, type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object fromJsonToObject(String str, Class cls) {
        try {
            Gson gson = new Gson();
            return !(gson instanceof Gson) ? gson.fromJson(str, cls) : GsonInstrumentation.fromJson(gson, str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void test() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Object>>() {
        }.getType();
        String str = (String) (!(gson instanceof Gson) ? gson.fromJson("", type) : GsonInstrumentation.fromJson(gson, "", type));
    }
}
