package com.didi.hummer.module;

import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.context.HummerContext;
import java.util.List;
import java.util.Map;

@Component("Storage")
public class Storage {
    @JsMethod("set")
    public static void set(HummerContext hummerContext, String str, String str2) {
        set(hummerContext.getNamespace(), str, str2);
    }

    @JsMethod("get")
    public static Object get(HummerContext hummerContext, String str) {
        return get(hummerContext.getNamespace(), str);
    }

    @JsMethod("remove")
    public static void remove(HummerContext hummerContext, String str) {
        remove(hummerContext.getNamespace(), str);
    }

    @JsMethod("removeAll")
    public static void removeAll(HummerContext hummerContext) {
        removeAll(hummerContext.getNamespace());
    }

    @JsMethod("getAll")
    public static Map<String, Object> getAll(HummerContext hummerContext) {
        return getAll(hummerContext.getNamespace());
    }

    @JsMethod("allKeys")
    public static List<String> allKeys(HummerContext hummerContext) {
        return allKeys(hummerContext.getNamespace());
    }

    @JsMethod("exist")
    public static boolean exist(HummerContext hummerContext, String str) {
        return exist(hummerContext.getNamespace(), str);
    }

    public static void set(String str, String str2, String str3) {
        HummerAdapter.getStorageAdapter(str).set(str2, str3);
    }

    public static Object get(String str, String str2) {
        return HummerAdapter.getStorageAdapter(str).get(str2);
    }

    public static void remove(String str, String str2) {
        HummerAdapter.getStorageAdapter(str).remove(str2);
    }

    public static void removeAll(String str) {
        HummerAdapter.getStorageAdapter(str).removeAll();
    }

    public static Map<String, Object> getAll(String str) {
        return HummerAdapter.getStorageAdapter(str).getAll();
    }

    public static List<String> allKeys(String str) {
        return HummerAdapter.getStorageAdapter(str).allKeys();
    }

    public static boolean exist(String str, String str2) {
        return HummerAdapter.getStorageAdapter(str).exist(str2);
    }
}
