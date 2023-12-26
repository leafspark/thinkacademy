package com.tal.app.thinkacademy.lib.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import com.tal.app.thinkacademy.lib.util.constant.CacheConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDoubleUtils implements CacheConstants {
    private static final Map<String, CacheDoubleUtils> CACHE_MAP = new HashMap();
    private final CacheDiskUtils mCacheDiskUtils;
    private final CacheMemoryUtils mCacheMemoryUtils;

    public static CacheDoubleUtils getInstance() {
        return getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance());
    }

    public static CacheDoubleUtils getInstance(CacheMemoryUtils cacheMemoryUtils, CacheDiskUtils cacheDiskUtils) {
        String str = cacheDiskUtils.toString() + "_" + cacheMemoryUtils.toString();
        Map<String, CacheDoubleUtils> map = CACHE_MAP;
        CacheDoubleUtils cacheDoubleUtils = map.get(str);
        if (cacheDoubleUtils == null) {
            synchronized (CacheDoubleUtils.class) {
                cacheDoubleUtils = map.get(str);
                if (cacheDoubleUtils == null) {
                    cacheDoubleUtils = new CacheDoubleUtils(cacheMemoryUtils, cacheDiskUtils);
                    map.put(str, cacheDoubleUtils);
                }
            }
        }
        return cacheDoubleUtils;
    }

    private CacheDoubleUtils(CacheMemoryUtils cacheMemoryUtils, CacheDiskUtils cacheDiskUtils) {
        this.mCacheMemoryUtils = cacheMemoryUtils;
        this.mCacheDiskUtils = cacheDiskUtils;
    }

    public void put(String str, byte[] bArr) {
        put(str, bArr, -1);
    }

    public void put(String str, byte[] bArr, int i) {
        this.mCacheMemoryUtils.put(str, bArr, i);
        this.mCacheDiskUtils.put(str, bArr, i);
    }

    public byte[] getBytes(String str) {
        return getBytes(str, (byte[]) null);
    }

    public byte[] getBytes(String str, byte[] bArr) {
        byte[] bArr2 = (byte[]) this.mCacheMemoryUtils.get(str);
        if (bArr2 != null) {
            return bArr2;
        }
        return this.mCacheDiskUtils.getBytes(str, bArr);
    }

    public void put(String str, String str2) {
        put(str, str2, -1);
    }

    public void put(String str, String str2, int i) {
        this.mCacheMemoryUtils.put(str, str2, i);
        this.mCacheDiskUtils.put(str, str2, i);
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        String str3 = (String) this.mCacheMemoryUtils.get(str);
        if (str3 != null) {
            return str3;
        }
        return this.mCacheDiskUtils.getString(str, str2);
    }

    public void put(String str, JSONObject jSONObject) {
        put(str, jSONObject, -1);
    }

    public void put(String str, JSONObject jSONObject, int i) {
        this.mCacheMemoryUtils.put(str, jSONObject, i);
        this.mCacheDiskUtils.put(str, jSONObject, i);
    }

    public JSONObject getJSONObject(String str) {
        return getJSONObject(str, (JSONObject) null);
    }

    public JSONObject getJSONObject(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = (JSONObject) this.mCacheMemoryUtils.get(str);
        if (jSONObject2 != null) {
            return jSONObject2;
        }
        return this.mCacheDiskUtils.getJSONObject(str, jSONObject);
    }

    public void put(String str, JSONArray jSONArray) {
        put(str, jSONArray, -1);
    }

    public void put(String str, JSONArray jSONArray, int i) {
        this.mCacheMemoryUtils.put(str, jSONArray, i);
        this.mCacheDiskUtils.put(str, jSONArray, i);
    }

    public JSONArray getJSONArray(String str) {
        return getJSONArray(str, (JSONArray) null);
    }

    public JSONArray getJSONArray(String str, JSONArray jSONArray) {
        JSONArray jSONArray2 = (JSONArray) this.mCacheMemoryUtils.get(str);
        if (jSONArray2 != null) {
            return jSONArray2;
        }
        return this.mCacheDiskUtils.getJSONArray(str, jSONArray);
    }

    public void put(String str, Bitmap bitmap) {
        put(str, bitmap, -1);
    }

    public void put(String str, Bitmap bitmap, int i) {
        this.mCacheMemoryUtils.put(str, bitmap, i);
        this.mCacheDiskUtils.put(str, bitmap, i);
    }

    public Bitmap getBitmap(String str) {
        return getBitmap(str, (Bitmap) null);
    }

    public Bitmap getBitmap(String str, Bitmap bitmap) {
        Bitmap bitmap2 = (Bitmap) this.mCacheMemoryUtils.get(str);
        if (bitmap2 != null) {
            return bitmap2;
        }
        return this.mCacheDiskUtils.getBitmap(str, bitmap);
    }

    public void put(String str, Drawable drawable) {
        put(str, drawable, -1);
    }

    public void put(String str, Drawable drawable, int i) {
        this.mCacheMemoryUtils.put(str, drawable, i);
        this.mCacheDiskUtils.put(str, drawable, i);
    }

    public Drawable getDrawable(String str) {
        return getDrawable(str, (Drawable) null);
    }

    public Drawable getDrawable(String str, Drawable drawable) {
        Drawable drawable2 = (Drawable) this.mCacheMemoryUtils.get(str);
        if (drawable2 != null) {
            return drawable2;
        }
        return this.mCacheDiskUtils.getDrawable(str, drawable);
    }

    public void put(String str, Parcelable parcelable) {
        put(str, parcelable, -1);
    }

    public void put(String str, Parcelable parcelable, int i) {
        this.mCacheMemoryUtils.put(str, parcelable, i);
        this.mCacheDiskUtils.put(str, parcelable, i);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        return getParcelable(str, creator, (Object) null);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t) {
        T t2 = this.mCacheMemoryUtils.get(str);
        if (t2 != null) {
            return t2;
        }
        return this.mCacheDiskUtils.getParcelable(str, creator, t);
    }

    public void put(String str, Serializable serializable) {
        put(str, serializable, -1);
    }

    public void put(String str, Serializable serializable, int i) {
        this.mCacheMemoryUtils.put(str, serializable, i);
        this.mCacheDiskUtils.put(str, serializable, i);
    }

    public Object getSerializable(String str) {
        return getSerializable(str, (Object) null);
    }

    public Object getSerializable(String str, Object obj) {
        Object obj2 = this.mCacheMemoryUtils.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return this.mCacheDiskUtils.getSerializable(str, obj);
    }

    public long getCacheDiskSize() {
        return this.mCacheDiskUtils.getCacheSize();
    }

    public int getCacheDiskCount() {
        return this.mCacheDiskUtils.getCacheCount();
    }

    public int getCacheMemoryCount() {
        return this.mCacheMemoryUtils.getCacheCount();
    }

    public void remove(String str) {
        this.mCacheMemoryUtils.remove(str);
        this.mCacheDiskUtils.remove(str);
    }

    public void clear() {
        this.mCacheMemoryUtils.clear();
        this.mCacheDiskUtils.clear();
    }
}
