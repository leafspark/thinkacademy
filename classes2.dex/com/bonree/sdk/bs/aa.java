package com.bonree.sdk.bs;

import android.content.Context;
import android.content.SharedPreferences;

public final class aa {
    private static String A = "logUserInfo";
    private static String B = "logUserId";
    private static String C = "logExtraInfo";
    private static String D = "logAppId";
    private static String E = "logDeviceId";
    private static String F = "CrashRequestHead";
    private static String G = "crashHead";
    private static String a = "configuration";
    private static String b = "rateOfLaunch";
    private static String c = "startTime";
    private static String d = "rateOfLaunchValidTime";
    private static String e = "configuration_version";
    private static String f = "data_save_time";
    private static String g = "errorStreamSize";
    private static String h = "activityTrackSize";
    private static String i = "catonThreshold";
    private static String j = "interactThreshold";
    private static String k = "activityThreshold";
    private static String l = "appLaunchThreshold";
    private static String m = "warmBootThreshold";
    private static String n = "ConfigInterval";
    private static String o = "nextConfigInterval";
    private static String p = "AppVersion";
    private static String q = "version";
    private static String r = "PreAppVersion";
    private static String s = "preVersion";
    private static String t = "GrayID";
    private static String u = "mGrayID";
    private static String v = "netInfo";
    private static String w = "ip";
    private static String x = "standard";
    private static String y = "dns";
    private static String z = "getIpAddress";

    public static void a(Context context, String str, String str2, int i2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i2);
        edit.commit();
    }

    public static int a(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getInt(str2, -1);
    }

    public static void a(Context context, String str, String str2, long j2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j2);
        edit.commit();
    }

    public static long b(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getLong(str2, -1);
    }

    public static void a(Context context, String str, String str2, boolean z2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str2, z2);
        edit.commit();
    }

    public static boolean c(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, false);
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public static String d(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void a(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
