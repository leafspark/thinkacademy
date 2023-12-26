package com.didi.hummer.adapter;

import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.http.IHttpAdapter;
import com.didi.hummer.adapter.imageloader.IImageLoaderAdapter;
import com.didi.hummer.adapter.navigator.INavigatorAdapter;
import com.didi.hummer.adapter.scriptloader.IScriptLoaderAdapter;
import com.didi.hummer.adapter.storage.IStorageAdapter;
import com.didi.hummer.adapter.tracker.ITrackerAdapter;

public class HummerAdapter {
    public static IHttpAdapter getHttpAdapter() {
        return getHttpAdapter((String) null);
    }

    public static IHttpAdapter getHttpAdapter(String str) {
        return HummerSDK.getHummerConfig(str).getHttpAdapter();
    }

    public static IImageLoaderAdapter getImageLoaderAdapter() {
        return getImageLoaderAdapter((String) null);
    }

    public static IImageLoaderAdapter getImageLoaderAdapter(String str) {
        return HummerSDK.getHummerConfig(str).getImageLoaderAdapter();
    }

    public static IStorageAdapter getStorageAdapter() {
        return getStorageAdapter((String) null);
    }

    public static IStorageAdapter getStorageAdapter(String str) {
        return HummerSDK.getHummerConfig(str).getStorageAdapter();
    }

    public static INavigatorAdapter getNavigatorAdapter() {
        return getNavigatorAdapter((String) null);
    }

    public static INavigatorAdapter getNavigatorAdapter(String str) {
        return HummerSDK.getHummerConfig(str).getNavAdapter();
    }

    public static IScriptLoaderAdapter getScriptLoaderAdapter() {
        return getScriptLoaderAdapter((String) null);
    }

    public static IScriptLoaderAdapter getScriptLoaderAdapter(String str) {
        return HummerSDK.getHummerConfig(str).getScriptLoaderAdapter();
    }

    public static ITrackerAdapter getTrackerAdapter() {
        return getTrackerAdapter((String) null);
    }

    public static ITrackerAdapter getTrackerAdapter(String str) {
        return HummerSDK.getHummerConfig(str).getTrackerAdapter();
    }
}
