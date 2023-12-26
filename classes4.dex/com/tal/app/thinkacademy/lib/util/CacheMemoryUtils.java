package com.tal.app.thinkacademy.lib.util;

import androidx.collection.LruCache;
import com.tal.app.thinkacademy.lib.util.constant.CacheConstants;
import java.util.HashMap;
import java.util.Map;

public final class CacheMemoryUtils implements CacheConstants {
    private static final Map<String, CacheMemoryUtils> CACHE_MAP = new HashMap();
    private static final int DEFAULT_MAX_COUNT = 256;
    private final String mCacheKey;
    private final LruCache<String, CacheValue> mMemoryCache;

    public static CacheMemoryUtils getInstance() {
        return getInstance(DEFAULT_MAX_COUNT);
    }

    public static CacheMemoryUtils getInstance(int i) {
        return getInstance(String.valueOf(i), i);
    }

    public static CacheMemoryUtils getInstance(String str, int i) {
        Map<String, CacheMemoryUtils> map = CACHE_MAP;
        CacheMemoryUtils cacheMemoryUtils = map.get(str);
        if (cacheMemoryUtils == null) {
            synchronized (CacheMemoryUtils.class) {
                cacheMemoryUtils = map.get(str);
                if (cacheMemoryUtils == null) {
                    cacheMemoryUtils = new CacheMemoryUtils(str, new LruCache(i));
                    map.put(str, cacheMemoryUtils);
                }
            }
        }
        return cacheMemoryUtils;
    }

    private CacheMemoryUtils(String str, LruCache<String, CacheValue> lruCache) {
        this.mCacheKey = str;
        this.mMemoryCache = lruCache;
    }

    public String toString() {
        return this.mCacheKey + "@" + Integer.toHexString(hashCode());
    }

    public void put(String str, Object obj) {
        put(str, obj, -1);
    }

    public void put(String str, Object obj, int i) {
        if (obj != null) {
            this.mMemoryCache.put(str, new CacheValue(i < 0 ? -1 : System.currentTimeMillis() + ((long) (i * 1000)), obj));
        }
    }

    public <T> T get(String str) {
        return get(str, (Object) null);
    }

    public <T> T get(String str, T t) {
        CacheValue cacheValue = (CacheValue) this.mMemoryCache.get(str);
        if (cacheValue == null) {
            return t;
        }
        if (cacheValue.dueTime == -1 || cacheValue.dueTime >= System.currentTimeMillis()) {
            return cacheValue.value;
        }
        this.mMemoryCache.remove(str);
        return t;
    }

    public int getCacheCount() {
        return this.mMemoryCache.size();
    }

    public Object remove(String str) {
        CacheValue cacheValue = (CacheValue) this.mMemoryCache.remove(str);
        if (cacheValue == null) {
            return null;
        }
        return cacheValue.value;
    }

    public void clear() {
        this.mMemoryCache.evictAll();
    }

    private static final class CacheValue {
        long dueTime;
        Object value;

        CacheValue(long j, Object obj) {
            this.dueTime = j;
            this.value = obj;
        }
    }
}
