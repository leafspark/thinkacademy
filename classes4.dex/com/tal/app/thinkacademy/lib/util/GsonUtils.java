package com.tal.app.thinkacademy.lib.util;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class GsonUtils {
    private static final Map<String, Gson> GSONS = new ConcurrentHashMap();
    private static final String KEY_DEFAULT = "defaultGson";
    private static final String KEY_DELEGATE = "delegateGson";
    private static final String KEY_LOG_UTILS = "logUtilsGson";

    private GsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setGsonDelegate(Gson gson) {
        if (gson != null) {
            GSONS.put(KEY_DELEGATE, gson);
        }
    }

    public static void setGson(String str, Gson gson) {
        if (!TextUtils.isEmpty(str) && gson != null) {
            GSONS.put(str, gson);
        }
    }

    public static Gson getGson(String str) {
        return GSONS.get(str);
    }

    public static Gson getGson() {
        Map<String, Gson> map = GSONS;
        Gson gson = map.get(KEY_DELEGATE);
        if (gson != null) {
            return gson;
        }
        Gson gson2 = map.get(KEY_DEFAULT);
        if (gson2 != null) {
            return gson2;
        }
        Gson createGson = createGson();
        map.put(KEY_DEFAULT, createGson);
        return createGson;
    }

    public static String toJson(Object obj) {
        return toJson(getGson(), obj);
    }

    public static String toJson(Object obj, Type type) {
        return toJson(getGson(), obj, type);
    }

    public static String toJson(Gson gson, Object obj) {
        return !(gson instanceof Gson) ? gson.toJson(obj) : GsonInstrumentation.toJson(gson, obj);
    }

    public static String toJson(Gson gson, Object obj, Type type) {
        return !(gson instanceof Gson) ? gson.toJson(obj, type) : GsonInstrumentation.toJson(gson, obj, type);
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return fromJson(getGson(), str, cls);
    }

    public static <T> T fromJson(String str, Type type) {
        return fromJson(getGson(), str, type);
    }

    public static <T> T fromJson(Reader reader, Class<T> cls) {
        return fromJson(getGson(), reader, cls);
    }

    public static <T> T fromJson(Reader reader, Type type) {
        return fromJson(getGson(), reader, type);
    }

    public static <T> T fromJson(Gson gson, String str, Class<T> cls) {
        return !(gson instanceof Gson) ? gson.fromJson(str, cls) : GsonInstrumentation.fromJson(gson, str, cls);
    }

    public static <T> T fromJson(Gson gson, String str, Type type) {
        return !(gson instanceof Gson) ? gson.fromJson(str, type) : GsonInstrumentation.fromJson(gson, str, type);
    }

    public static <T> T fromJson(Gson gson, Reader reader, Class<T> cls) {
        return !(gson instanceof Gson) ? gson.fromJson(reader, cls) : GsonInstrumentation.fromJson(gson, reader, cls);
    }

    public static <T> T fromJson(Gson gson, Reader reader, Type type) {
        return !(gson instanceof Gson) ? gson.fromJson(reader, type) : GsonInstrumentation.fromJson(gson, reader, type);
    }

    public static Type getListType(Type type) {
        return TypeToken.getParameterized(List.class, new Type[]{type}).getType();
    }

    public static Type getSetType(Type type) {
        return TypeToken.getParameterized(Set.class, new Type[]{type}).getType();
    }

    public static Type getMapType(Type type, Type type2) {
        return TypeToken.getParameterized(Map.class, new Type[]{type, type2}).getType();
    }

    public static Type getArrayType(Type type) {
        return TypeToken.getArray(type).getType();
    }

    public static Type getType(Type type, Type... typeArr) {
        return TypeToken.getParameterized(type, typeArr).getType();
    }

    static Gson getGson4LogUtils() {
        Map<String, Gson> map = GSONS;
        Gson gson = map.get(KEY_LOG_UTILS);
        if (gson != null) {
            return gson;
        }
        Gson create = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        map.put(KEY_LOG_UTILS, create);
        return create;
    }

    private static Gson createGson() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }
}
