package com.tal.app.thinkacademy.common.base.sharedata;

import android.content.Context;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.google.gson.Gson;
import com.tal.app.thinkacademy.lib.shareprefrence.SharePrefrenceCache;

public class ShareDataManager {
    public static int SHAREDATA_CAN_CLEAR = 4;
    public static int SHAREDATA_NOT_CLEAR = 2;
    public static int SHAREDATA_TOURIST = 3;
    public static int SHAREDATA_USER = 1;
    public static final String SPNAME_CAN_CLEAR = "xes_canclear_sp";
    public static final String SPNAME_NOT_CLEAR = "xes_notclear_sp";
    public static final String SPNAME_TOURIST = "xes_tourist_sp";
    public static final String SPNAME_USER = "xes_user_sp";
    private SharePrefrenceCache canclear_sharedata;
    private Context mContext;
    private String mUserId;
    private SharePrefrenceCache notclear_sharedata;
    private SharePrefrenceCache tourist_sharedata;
    private SharePrefrenceCache user_sharedata;

    public static ShareDataManager getInstance() {
        return InstanceHolder.mInstance;
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ShareDataManager mInstance = new ShareDataManager();

        private InstanceHolder() {
        }
    }

    private ShareDataManager() {
        this.notclear_sharedata = getSharePrefrenceCache(SPNAME_NOT_CLEAR);
    }

    public void initUserSP(String str) {
        String str2 = this.mUserId;
        if (str2 == null || !str2.equals(str) || this.user_sharedata == null) {
            this.mUserId = str;
            this.user_sharedata = getSharePrefrenceCache("xes_user_sp_" + str);
        }
    }

    public SharePrefrenceCache getUser_sharedata() {
        return this.user_sharedata;
    }

    public void initCanClearSP() {
        if (this.canclear_sharedata == null) {
            this.canclear_sharedata = getSharePrefrenceCache(SPNAME_CAN_CLEAR);
        }
    }

    public SharePrefrenceCache getCanclear_sharedata() {
        return this.canclear_sharedata;
    }

    public void clearUser_sharedata() {
        this.user_sharedata = null;
    }

    public void clearCanClear_sharedata() {
        SharePrefrenceCache sharePrefrenceCache = this.canclear_sharedata;
        if (sharePrefrenceCache != null) {
            sharePrefrenceCache.clear();
        }
        this.canclear_sharedata = null;
    }

    public SharePrefrenceCache getSelectSP(int i) {
        if (i == SHAREDATA_USER) {
            return getUser_sharedata();
        }
        if (i == SHAREDATA_NOT_CLEAR) {
            if (this.notclear_sharedata == null) {
                this.notclear_sharedata = getSharePrefrenceCache(SPNAME_NOT_CLEAR);
            }
            return this.notclear_sharedata;
        } else if (i == SHAREDATA_TOURIST) {
            if (this.tourist_sharedata == null) {
                this.tourist_sharedata = getSharePrefrenceCache(SPNAME_TOURIST);
            }
            return this.tourist_sharedata;
        } else if (i != SHAREDATA_CAN_CLEAR) {
            return getUser_sharedata();
        } else {
            initCanClearSP();
            return getCanclear_sharedata();
        }
    }

    public String getString(String str, String str2, int i) {
        return getString(str, str2, i, false);
    }

    public String getString(String str, String str2, int i, boolean z) {
        if (getSelectSP(i) == null) {
            return str2;
        }
        return getSelectSP(i).getString(str, str2, z);
    }

    public long getLong(String str, long j, int i) {
        return getLong(str, j, i, false);
    }

    public long getLong(String str, long j, int i, boolean z) {
        if (getSelectSP(i) == null) {
            return j;
        }
        return getSelectSP(i).getLong(str, j, z).longValue();
    }

    public float getFloat(String str, float f, int i) {
        return getFloat(str, f, i, false);
    }

    public float getFloat(String str, float f, int i, boolean z) {
        if (getSelectSP(i) == null) {
            return f;
        }
        return getSelectSP(i).getFloat(str, f, z).floatValue();
    }

    public int getInt(String str, int i, int i2) {
        return getInt(str, i, i2, false);
    }

    public int getInt(String str, int i, int i2, boolean z) {
        if (getSelectSP(i2) == null) {
            return i;
        }
        return getSelectSP(i2).getInt(str, i, z);
    }

    public boolean getBoolean(String str, boolean z, int i) {
        return getBoolean(str, z, i, false);
    }

    public boolean getBoolean(String str, boolean z, int i, boolean z2) {
        if (getSelectSP(i) == null) {
            return z;
        }
        return getSelectSP(i).getBoolean(str, z, z2).booleanValue();
    }

    public void put(String str, String str2, int i) {
        put(str, str2, i, false);
    }

    public void put(String str, String str2, int i, boolean z) {
        SharePrefrenceCache selectSP = getSelectSP(i);
        if (selectSP != null) {
            selectSP.putString(str, str2, z);
        }
    }

    public void put(String str, int i, int i2) {
        put(str, i, i2, false);
    }

    public void put(String str, int i, int i2, boolean z) {
        SharePrefrenceCache selectSP = getSelectSP(i2);
        if (selectSP != null) {
            selectSP.putInt(str, i, z);
        }
    }

    public void put(String str, float f, int i) {
        put(str, f, i, false);
    }

    public void put(String str, float f, int i, boolean z) {
        SharePrefrenceCache selectSP = getSelectSP(i);
        if (selectSP != null) {
            selectSP.putFloat(str, Float.valueOf(f), z);
        }
    }

    public void put(String str, long j, int i) {
        put(str, j, i, false);
    }

    public void put(String str, long j, int i, boolean z) {
        SharePrefrenceCache selectSP = getSelectSP(i);
        if (selectSP != null) {
            selectSP.putLong(str, Long.valueOf(j), z);
        }
    }

    public void put(String str, boolean z, int i) {
        put(str, z, i, false);
    }

    public void put(String str, boolean z, int i, boolean z2) {
        SharePrefrenceCache selectSP = getSelectSP(i);
        if (selectSP != null) {
            selectSP.putBoolean(str, Boolean.valueOf(z), z2);
        }
    }

    public boolean hasKey(String str, int i) {
        return getSelectSP(i).contains(str);
    }

    public void remove(int i, String... strArr) {
        if (strArr != null) {
            try {
                SharePrefrenceCache selectSP = getSelectSP(i);
                for (String remove : strArr) {
                    selectSP.remove(remove);
                }
            } catch (Exception unused) {
            }
        }
    }

    public <T> void saveCacheGsonEntity(T t, String str, int i) {
        saveCacheGsonEntity(t, str, i, false);
    }

    public <T> void saveCacheGsonEntity(T t, String str, int i, boolean z) {
        Gson gson = new Gson();
        try {
            put(str, !(gson instanceof Gson) ? gson.toJson(t) : GsonInstrumentation.toJson(gson, t), i, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T getCacheEntity(Class cls, String str, int i) {
        return getCacheEntity(cls, str, i, false);
    }

    public <T> T getCacheEntity(Class cls, String str, int i, boolean z) {
        String string = getString(str, "", i, z);
        Gson gson = new Gson();
        if (!TextUtils.isEmpty(string)) {
            return !(gson instanceof Gson) ? gson.fromJson(string, cls) : GsonInstrumentation.fromJson(gson, string, cls);
        }
        return null;
    }

    public SharePrefrenceCache getSharePrefrenceCache(String str) {
        try {
            return new SharePrefrenceCache(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
