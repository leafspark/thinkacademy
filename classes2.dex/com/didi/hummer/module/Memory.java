package com.didi.hummer.module;

import android.text.TextUtils;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.context.HummerContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("Memory")
public class Memory {
    private static Map<String, Map<String, Object>> memoryStoreMap = new ConcurrentHashMap();

    @JsMethod("set")
    public static void set(HummerContext hummerContext, String str, Object obj) {
        set(hummerContext.getNamespace(), str, obj);
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

    private static String checkNamespace(String str) {
        return TextUtils.isEmpty(str) ? HummerSDK.NAMESPACE_DEFAULT : str;
    }

    public static void set(String str, String str2, Object obj) {
        String checkNamespace = checkNamespace(str);
        Map map = memoryStoreMap.get(checkNamespace);
        if (map == null) {
            map = new ConcurrentHashMap();
            memoryStoreMap.put(checkNamespace, map);
        }
        map.put(str2, obj);
    }

    public static Object get(String str, String str2) {
        Map map = memoryStoreMap.get(checkNamespace(str));
        if (map == null) {
            return null;
        }
        return map.get(str2);
    }

    public static void remove(String str, String str2) {
        Map map = memoryStoreMap.get(checkNamespace(str));
        if (map != null) {
            map.remove(str2);
        }
    }

    public static void removeAll(String str) {
        Map map = memoryStoreMap.get(checkNamespace(str));
        if (map != null) {
            map.clear();
        }
    }

    public static Map<String, Object> getAll(String str) {
        return memoryStoreMap.get(checkNamespace(str));
    }

    public static List<String> allKeys(String str) {
        return new ArrayList(memoryStoreMap.get(checkNamespace(str)).keySet());
    }

    public static boolean exist(String str, String str2) {
        Map map = memoryStoreMap.get(checkNamespace(str));
        if (map == null) {
            return false;
        }
        return map.containsKey(str2);
    }
}
