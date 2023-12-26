package com.tal.app.thinkacademy.lib.language;

import android.content.Context;
import android.content.SharedPreferences;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;

public class CommSharedUtil {
    private static final String SHARED_PATH = "app_info";
    private static CommSharedUtil helper;
    private SharedPreferences sharedPreferences;

    private CommSharedUtil(Context context) {
        this.sharedPreferences = !(context instanceof Context) ? context.getSharedPreferences(SHARED_PATH, 0) : XMLParseInstrumentation.getSharedPreferences(context, SHARED_PATH, 0);
    }

    public static CommSharedUtil getInstance(Context context) {
        if (helper == null) {
            helper = new CommSharedUtil(context);
        }
        return helper;
    }

    public void putInt(String str, int i) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public int getInt(String str) {
        return this.sharedPreferences.getInt(str, 0);
    }

    public void putString(String str, String str2) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public String getString(String str) {
        return this.sharedPreferences.getString(str, (String) null);
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.sharedPreferences.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        return this.sharedPreferences.getInt(str, i);
    }

    public void remove(String str) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.remove(str);
        edit.apply();
    }
}
