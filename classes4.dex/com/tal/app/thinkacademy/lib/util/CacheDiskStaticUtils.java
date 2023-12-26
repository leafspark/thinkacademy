package com.tal.app.thinkacademy.lib.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDiskStaticUtils {
    private static CacheDiskUtils sDefaultCacheDiskUtils;

    public static void setDefaultCacheDiskUtils(CacheDiskUtils cacheDiskUtils) {
        sDefaultCacheDiskUtils = cacheDiskUtils;
    }

    public static void put(String str, byte[] bArr) {
        put(str, bArr, getDefaultCacheDiskUtils());
    }

    public static void put(String str, byte[] bArr, int i) {
        put(str, bArr, i, getDefaultCacheDiskUtils());
    }

    public static byte[] getBytes(String str) {
        return getBytes(str, getDefaultCacheDiskUtils());
    }

    public static byte[] getBytes(String str, byte[] bArr) {
        return getBytes(str, bArr, getDefaultCacheDiskUtils());
    }

    public static void put(String str, String str2) {
        put(str, str2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, String str2, int i) {
        put(str, str2, i, getDefaultCacheDiskUtils());
    }

    public static String getString(String str) {
        return getString(str, getDefaultCacheDiskUtils());
    }

    public static String getString(String str, String str2) {
        return getString(str, str2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONObject jSONObject) {
        put(str, jSONObject, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONObject jSONObject, int i) {
        put(str, jSONObject, i, getDefaultCacheDiskUtils());
    }

    public static JSONObject getJSONObject(String str) {
        return getJSONObject(str, getDefaultCacheDiskUtils());
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject) {
        return getJSONObject(str, jSONObject, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONArray jSONArray) {
        put(str, jSONArray, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONArray jSONArray, int i) {
        put(str, jSONArray, i, getDefaultCacheDiskUtils());
    }

    public static JSONArray getJSONArray(String str) {
        return getJSONArray(str, getDefaultCacheDiskUtils());
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray) {
        return getJSONArray(str, jSONArray, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Bitmap bitmap) {
        put(str, bitmap, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Bitmap bitmap, int i) {
        put(str, bitmap, i, getDefaultCacheDiskUtils());
    }

    public static Bitmap getBitmap(String str) {
        return getBitmap(str, getDefaultCacheDiskUtils());
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap) {
        return getBitmap(str, bitmap, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Drawable drawable) {
        put(str, drawable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Drawable drawable, int i) {
        put(str, drawable, i, getDefaultCacheDiskUtils());
    }

    public static Drawable getDrawable(String str) {
        return getDrawable(str, getDefaultCacheDiskUtils());
    }

    public static Drawable getDrawable(String str, Drawable drawable) {
        return getDrawable(str, drawable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Parcelable parcelable) {
        put(str, parcelable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Parcelable parcelable, int i) {
        put(str, parcelable, i, getDefaultCacheDiskUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        return getParcelable(str, creator, getDefaultCacheDiskUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t) {
        return getParcelable(str, creator, t, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Serializable serializable) {
        put(str, serializable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Serializable serializable, int i) {
        put(str, serializable, i, getDefaultCacheDiskUtils());
    }

    public static Object getSerializable(String str) {
        return getSerializable(str, getDefaultCacheDiskUtils());
    }

    public static Object getSerializable(String str, Object obj) {
        return getSerializable(str, obj, getDefaultCacheDiskUtils());
    }

    public static long getCacheSize() {
        return getCacheSize(getDefaultCacheDiskUtils());
    }

    public static int getCacheCount() {
        return getCacheCount(getDefaultCacheDiskUtils());
    }

    public static boolean remove(String str) {
        return remove(str, getDefaultCacheDiskUtils());
    }

    public static boolean clear() {
        return clear(getDefaultCacheDiskUtils());
    }

    public static void put(String str, byte[] bArr, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, bArr);
    }

    public static void put(String str, byte[] bArr, int i, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, bArr, i);
    }

    public static byte[] getBytes(String str, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBytes(str);
    }

    public static byte[] getBytes(String str, byte[] bArr, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBytes(str, bArr);
    }

    public static void put(String str, String str2, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, str2);
    }

    public static void put(String str, String str2, int i, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, str2, i);
    }

    public static String getString(String str, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getString(str);
    }

    public static String getString(String str, String str2, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getString(str, str2);
    }

    public static void put(String str, JSONObject jSONObject, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, jSONObject);
    }

    public static void put(String str, JSONObject jSONObject, int i, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, jSONObject, i);
    }

    public static JSONObject getJSONObject(String str, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONObject(str);
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONObject(str, jSONObject);
    }

    public static void put(String str, JSONArray jSONArray, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, jSONArray);
    }

    public static void put(String str, JSONArray jSONArray, int i, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, jSONArray, i);
    }

    public static JSONArray getJSONArray(String str, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONArray(str);
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONArray(str, jSONArray);
    }

    public static void put(String str, Bitmap bitmap, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, bitmap);
    }

    public static void put(String str, Bitmap bitmap, int i, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, bitmap, i);
    }

    public static Bitmap getBitmap(String str, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBitmap(str);
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBitmap(str, bitmap);
    }

    public static void put(String str, Drawable drawable, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, drawable);
    }

    public static void put(String str, Drawable drawable, int i, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, drawable, i);
    }

    public static Drawable getDrawable(String str, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getDrawable(str);
    }

    public static Drawable getDrawable(String str, Drawable drawable, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getDrawable(str, drawable);
    }

    public static void put(String str, Parcelable parcelable, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, parcelable);
    }

    public static void put(String str, Parcelable parcelable, int i, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, parcelable, i);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getParcelable(str, creator);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getParcelable(str, creator, t);
    }

    public static void put(String str, Serializable serializable, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, serializable);
    }

    public static void put(String str, Serializable serializable, int i, CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(str, serializable, i);
    }

    public static Object getSerializable(String str, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getSerializable(str);
    }

    public static Object getSerializable(String str, Object obj, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getSerializable(str, obj);
    }

    public static long getCacheSize(CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getCacheSize();
    }

    public static int getCacheCount(CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getCacheCount();
    }

    public static boolean remove(String str, CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.remove(str);
    }

    public static boolean clear(CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.clear();
    }

    private static CacheDiskUtils getDefaultCacheDiskUtils() {
        CacheDiskUtils cacheDiskUtils = sDefaultCacheDiskUtils;
        return cacheDiskUtils != null ? cacheDiskUtils : CacheDiskUtils.getInstance();
    }
}
