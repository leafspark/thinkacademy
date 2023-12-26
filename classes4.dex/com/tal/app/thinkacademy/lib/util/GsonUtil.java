package com.tal.app.thinkacademy.lib.util;

import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.google.gson.Gson;
import java.lang.reflect.Type;

public class GsonUtil {
    private static volatile GsonUtil instance;
    private Gson mGson = new Gson();

    private GsonUtil() {
    }

    public static GsonUtil getInstance() {
        if (instance == null) {
            synchronized (GsonUtil.class) {
                if (instance == null) {
                    instance = new GsonUtil();
                }
            }
        }
        return instance;
    }

    public <T> T fromJson(String str, Type type) {
        Gson gson = this.mGson;
        return !(gson instanceof Gson) ? gson.fromJson(str, type) : GsonInstrumentation.fromJson(gson, str, type);
    }

    public <T> T fromJson(String str, Class<T> cls) {
        Gson gson = this.mGson;
        return !(gson instanceof Gson) ? gson.fromJson(str, cls) : GsonInstrumentation.fromJson(gson, str, cls);
    }

    public String objToJson(Object obj) {
        try {
            Gson gson = this.mGson;
            return !(gson instanceof Gson) ? gson.toJson(obj) : GsonInstrumentation.toJson(gson, obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
