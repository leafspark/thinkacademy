package com.tal.app.thinkacademy.lib.shareprefrence;

import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.util.ProcessUtils;
import com.tencent.mmkv.MMKV;

public final class SharePrefrenceCache {
    private static final String TAG = "SharePrefrenceCache";
    private MMKV mmkv;
    private MMKV processMMkv;

    public SharePrefrenceCache(String str) {
        str = TextUtils.isEmpty(str) ? "SP" : str;
        this.mmkv = MMKV.mmkvWithID(str + "_" + ProcessUtils.getCurrentProcessName());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_multi_process");
        this.processMMkv = MMKV.mmkvWithID(sb.toString(), 2);
    }

    private MMKV getMMkv(boolean z) {
        return z ? this.processMMkv : this.mmkv;
    }

    public synchronized void putString(String str, String str2, boolean z) {
        getMMkv(z).encode(CacheSDKManager.getCacheKey(str), str2);
    }

    public synchronized void putBoolean(String str, Boolean bool, boolean z) {
        getMMkv(z).encode(CacheSDKManager.getCacheKey(str), bool.booleanValue());
    }

    public synchronized void putInt(String str, int i, boolean z) {
        getMMkv(z).encode(CacheSDKManager.getCacheKey(str), i);
    }

    public synchronized void putFloat(String str, Float f, boolean z) {
        getMMkv(z).encode(CacheSDKManager.getCacheKey(str), f.floatValue());
    }

    public synchronized void putLong(String str, Long l, boolean z) {
        getMMkv(z).encode(CacheSDKManager.getCacheKey(str), l.longValue());
    }

    public String getString(String str, String str2, boolean z) {
        return getMMkv(z).getString(CacheSDKManager.getCacheKey(str), str2);
    }

    public Long getLong(String str, long j, boolean z) {
        return Long.valueOf(getMMkv(z).getLong(CacheSDKManager.getCacheKey(str), j));
    }

    public int getInt(String str, int i, boolean z) {
        return getMMkv(z).getInt(CacheSDKManager.getCacheKey(str), i);
    }

    public Float getFloat(String str, float f, boolean z) {
        return Float.valueOf(getMMkv(z).getFloat(CacheSDKManager.getCacheKey(str), f));
    }

    public Boolean getBoolean(String str, boolean z, boolean z2) {
        return Boolean.valueOf(getMMkv(z2).getBoolean(CacheSDKManager.getCacheKey(str), z));
    }

    public synchronized boolean remove(Object obj) {
        if (this.mmkv.contains(CacheSDKManager.getCacheKey((String) obj))) {
            this.mmkv.remove(CacheSDKManager.getCacheKey((String) obj));
            return true;
        } else if (!this.processMMkv.contains(CacheSDKManager.getCacheKey((String) obj))) {
            return false;
        } else {
            this.processMMkv.remove(CacheSDKManager.getCacheKey((String) obj));
            return true;
        }
    }

    public void clear() {
        MMKV mmkv2 = this.mmkv;
        if (mmkv2 != null) {
            mmkv2.clear();
        }
        MMKV mmkv3 = this.processMMkv;
        if (mmkv3 != null) {
            mmkv3.clear();
        }
    }

    public boolean contains(String str) {
        return this.mmkv.contains(CacheSDKManager.getCacheKey(str)) || this.processMMkv.contains(CacheSDKManager.getCacheKey(str));
    }
}
