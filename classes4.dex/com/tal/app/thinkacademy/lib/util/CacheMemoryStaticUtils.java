package com.tal.app.thinkacademy.lib.util;

public final class CacheMemoryStaticUtils {
    private static CacheMemoryUtils sDefaultCacheMemoryUtils;

    public static void setDefaultCacheMemoryUtils(CacheMemoryUtils cacheMemoryUtils) {
        sDefaultCacheMemoryUtils = cacheMemoryUtils;
    }

    public static void put(String str, Object obj) {
        put(str, obj, getDefaultCacheMemoryUtils());
    }

    public static void put(String str, Object obj, int i) {
        put(str, obj, i, getDefaultCacheMemoryUtils());
    }

    public static <T> T get(String str) {
        return get(str, getDefaultCacheMemoryUtils());
    }

    public static <T> T get(String str, T t) {
        return get(str, t, getDefaultCacheMemoryUtils());
    }

    public static int getCacheCount() {
        return getCacheCount(getDefaultCacheMemoryUtils());
    }

    public static Object remove(String str) {
        return remove(str, getDefaultCacheMemoryUtils());
    }

    public static void clear() {
        clear(getDefaultCacheMemoryUtils());
    }

    public static void put(String str, Object obj, CacheMemoryUtils cacheMemoryUtils) {
        cacheMemoryUtils.put(str, obj);
    }

    public static void put(String str, Object obj, int i, CacheMemoryUtils cacheMemoryUtils) {
        cacheMemoryUtils.put(str, obj, i);
    }

    public static <T> T get(String str, CacheMemoryUtils cacheMemoryUtils) {
        return cacheMemoryUtils.get(str);
    }

    public static <T> T get(String str, T t, CacheMemoryUtils cacheMemoryUtils) {
        return cacheMemoryUtils.get(str, t);
    }

    public static int getCacheCount(CacheMemoryUtils cacheMemoryUtils) {
        return cacheMemoryUtils.getCacheCount();
    }

    public static Object remove(String str, CacheMemoryUtils cacheMemoryUtils) {
        return cacheMemoryUtils.remove(str);
    }

    public static void clear(CacheMemoryUtils cacheMemoryUtils) {
        cacheMemoryUtils.clear();
    }

    private static CacheMemoryUtils getDefaultCacheMemoryUtils() {
        CacheMemoryUtils cacheMemoryUtils = sDefaultCacheMemoryUtils;
        return cacheMemoryUtils != null ? cacheMemoryUtils : CacheMemoryUtils.getInstance();
    }
}
