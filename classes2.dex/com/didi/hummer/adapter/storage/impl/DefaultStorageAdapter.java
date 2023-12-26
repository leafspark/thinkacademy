package com.didi.hummer.adapter.storage.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.storage.IStorageAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultStorageAdapter implements IStorageAdapter {
    private static final String KEY_VERSION = "_#_hummer_shared_preferences_version_#_";
    private static final String SP_NAME = "HummerStorage";
    private static final int version = 1;
    private String namespace;
    private SharedPreferences sp;

    private SharedPreferences getSP() {
        if (this.sp == null) {
            Context context = HummerSDK.appContext;
            String spName = getSpName(this.namespace);
            SharedPreferences sharedPreferences = !(context instanceof Context) ? context.getSharedPreferences(spName, 0) : XMLParseInstrumentation.getSharedPreferences(context, spName, 0);
            this.sp = sharedPreferences;
            checkUpgrade(sharedPreferences);
        }
        return this.sp;
    }

    private String getSpName(String str) {
        if (str == null || HummerSDK.NAMESPACE_DEFAULT.equals(str)) {
            return "HummerStorage_default";
        }
        return "HummerStorage_" + str;
    }

    private void checkUpgrade(SharedPreferences sharedPreferences) {
        try {
            if (1 > sharedPreferences.getInt(KEY_VERSION, 0)) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                Context context = HummerSDK.appContext;
                SharedPreferences sharedPreferences2 = !(context instanceof Context) ? context.getSharedPreferences(SP_NAME, 0) : XMLParseInstrumentation.getSharedPreferences(context, SP_NAME, 0);
                for (String next : sharedPreferences2.getAll().keySet()) {
                    if (next != null && !next.equals(KEY_VERSION)) {
                        try {
                            edit.putString(next, sharedPreferences2.getString(next, ""));
                        } catch (Exception unused) {
                        }
                    }
                }
                edit.putInt(KEY_VERSION, 1);
                edit.apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void set(String str, Object obj) {
        if (obj instanceof String) {
            getSP().edit().putString(str, (String) obj).apply();
        }
    }

    public Object get(String str) {
        return getSP().getString(str, "");
    }

    public void remove(String str) {
        getSP().edit().remove(str).apply();
    }

    public void removeAll() {
        getSP().edit().clear().putInt(KEY_VERSION, 1).apply();
    }

    public Map<String, Object> getAll() {
        HashMap hashMap = new HashMap(getSP().getAll());
        hashMap.remove(KEY_VERSION);
        return hashMap;
    }

    public List<String> allKeys() {
        ArrayList arrayList = new ArrayList(getSP().getAll().keySet());
        arrayList.remove(KEY_VERSION);
        return arrayList;
    }

    public boolean exist(String str) {
        return getSP().contains(str);
    }
}
