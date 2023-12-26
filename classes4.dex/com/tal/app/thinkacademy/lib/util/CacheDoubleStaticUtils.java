package com.tal.app.thinkacademy.lib.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDoubleStaticUtils {
    private static CacheDoubleUtils sDefaultCacheDoubleUtils;

    public static void setDefaultCacheDoubleUtils(CacheDoubleUtils cacheDoubleUtils) {
        sDefaultCacheDoubleUtils = cacheDoubleUtils;
    }

    public static void put(String str, byte[] bArr) {
        put(str, bArr, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, byte[] bArr, int i) {
        put(str, bArr, i, getDefaultCacheDoubleUtils());
    }

    public static byte[] getBytes(String str) {
        return getBytes(str, getDefaultCacheDoubleUtils());
    }

    public static byte[] getBytes(String str, byte[] bArr) {
        return getBytes(str, bArr, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, String str2) {
        put(str, str2, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, String str2, int i) {
        put(str, str2, i, getDefaultCacheDoubleUtils());
    }

    public static String getString(String str) {
        return getString(str, getDefaultCacheDoubleUtils());
    }

    public static String getString(String str, String str2) {
        return getString(str, str2, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, JSONObject jSONObject) {
        put(str, jSONObject, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, JSONObject jSONObject, int i) {
        put(str, jSONObject, i, getDefaultCacheDoubleUtils());
    }

    public static JSONObject getJSONObject(String str) {
        return getJSONObject(str, getDefaultCacheDoubleUtils());
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject) {
        return getJSONObject(str, jSONObject, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, JSONArray jSONArray) {
        put(str, jSONArray, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, JSONArray jSONArray, int i) {
        put(str, jSONArray, i, getDefaultCacheDoubleUtils());
    }

    public static JSONArray getJSONArray(String str) {
        return getJSONArray(str, getDefaultCacheDoubleUtils());
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray) {
        return getJSONArray(str, jSONArray, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Bitmap bitmap) {
        put(str, bitmap, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Bitmap bitmap, int i) {
        put(str, bitmap, i, getDefaultCacheDoubleUtils());
    }

    public static Bitmap getBitmap(String str) {
        return getBitmap(str, getDefaultCacheDoubleUtils());
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap) {
        return getBitmap(str, bitmap, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Drawable drawable) {
        put(str, drawable, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Drawable drawable, int i) {
        put(str, drawable, i, getDefaultCacheDoubleUtils());
    }

    public static Drawable getDrawable(String str) {
        return getDrawable(str, getDefaultCacheDoubleUtils());
    }

    public static Drawable getDrawable(String str, Drawable drawable) {
        return getDrawable(str, drawable, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Parcelable parcelable) {
        put(str, parcelable, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Parcelable parcelable, int i) {
        put(str, parcelable, i, getDefaultCacheDoubleUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        return getParcelable(str, creator, getDefaultCacheDoubleUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t) {
        return getParcelable(str, creator, t, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Serializable serializable) {
        put(str, serializable, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Serializable serializable, int i) {
        put(str, serializable, i, getDefaultCacheDoubleUtils());
    }

    public static Object getSerializable(String str) {
        return getSerializable(str, getDefaultCacheDoubleUtils());
    }

    public static Object getSerializable(String str, Object obj) {
        return getSerializable(str, obj, getDefaultCacheDoubleUtils());
    }

    public static long getCacheDiskSize() {
        return getCacheDiskSize(getDefaultCacheDoubleUtils());
    }

    public static int getCacheDiskCount() {
        return getCacheDiskCount(getDefaultCacheDoubleUtils());
    }

    public static int getCacheMemoryCount() {
        return getCacheMemoryCount(getDefaultCacheDoubleUtils());
    }

    public static void remove(String str) {
        remove(str, getDefaultCacheDoubleUtils());
    }

    public static void clear() {
        clear(getDefaultCacheDoubleUtils());
    }

    public static void put(String str, byte[] bArr, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, bArr);
    }

    public static void put(String str, byte[] bArr, int i, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, bArr, i);
    }

    public static byte[] getBytes(String str, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getBytes(str);
    }

    public static byte[] getBytes(String str, byte[] bArr, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getBytes(str, bArr);
    }

    public static void put(String str, String str2, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, str2);
    }

    public static void put(String str, String str2, int i, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, str2, i);
    }

    public static String getString(String str, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getString(str);
    }

    public static String getString(String str, String str2, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getString(str, str2);
    }

    public static void put(String str, JSONObject jSONObject, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, jSONObject);
    }

    public static void put(String str, JSONObject jSONObject, int i, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, jSONObject, i);
    }

    public static JSONObject getJSONObject(String str, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getJSONObject(str);
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getJSONObject(str, jSONObject);
    }

    public static void put(String str, JSONArray jSONArray, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, jSONArray);
    }

    public static void put(String str, JSONArray jSONArray, int i, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, jSONArray, i);
    }

    public static JSONArray getJSONArray(String str, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getJSONArray(str);
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getJSONArray(str, jSONArray);
    }

    public static void put(String str, Bitmap bitmap, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, bitmap);
    }

    public static void put(String str, Bitmap bitmap, int i, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, bitmap, i);
    }

    public static Bitmap getBitmap(String str, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getBitmap(str);
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getBitmap(str, bitmap);
    }

    public static void put(String str, Drawable drawable, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, drawable);
    }

    public static void put(String str, Drawable drawable, int i, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, drawable, i);
    }

    public static Drawable getDrawable(String str, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getDrawable(str);
    }

    public static Drawable getDrawable(String str, Drawable drawable, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getDrawable(str, drawable);
    }

    public static void put(String str, Parcelable parcelable, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, parcelable);
    }

    public static void put(String str, Parcelable parcelable, int i, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, parcelable, i);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getParcelable(str, creator);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getParcelable(str, creator, t);
    }

    public static void put(String str, Serializable serializable, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, serializable);
    }

    public static void put(String str, Serializable serializable, int i, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.put(str, serializable, i);
    }

    public static Object getSerializable(String str, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getSerializable(str);
    }

    public static Object getSerializable(String str, Object obj, CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getSerializable(str, obj);
    }

    public static long getCacheDiskSize(CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getCacheDiskSize();
    }

    public static int getCacheDiskCount(CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getCacheDiskCount();
    }

    public static int getCacheMemoryCount(CacheDoubleUtils cacheDoubleUtils) {
        return cacheDoubleUtils.getCacheMemoryCount();
    }

    public static void remove(String str, CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.remove(str);
    }

    public static void clear(CacheDoubleUtils cacheDoubleUtils) {
        cacheDoubleUtils.clear();
    }

    private static CacheDoubleUtils getDefaultCacheDoubleUtils() {
        CacheDoubleUtils cacheDoubleUtils = sDefaultCacheDoubleUtils;
        return cacheDoubleUtils != null ? cacheDoubleUtils : CacheDoubleUtils.getInstance();
    }
}
