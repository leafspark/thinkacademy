package com.tal.app.thinkacademy.lib.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.tal.app.thinkacademy.lib.pay.PayManager;
import java.util.Locale;

public class LanguageUtil {
    public static final String COUNTRY_CN = "CN";
    public static final String COUNTRY_HK = "HK";
    public static final String COUNTRY_MO = "MO";
    public static final String COUNTRY_SINGAPORE = "SG";
    public static final String COUNTRY_TW = "TW";
    public static final String COUNTRY_UK = "GB";
    public static final String COUNTRY_USA = "US";
    public static final String EN = "en";
    private static final String LOCALE_COUNTRY = "country";
    private static final String LOCALE_LANGUAGE = "language";
    public static final String ZH = "zh";
    private static String mAppLocalCountry = "";
    private static String mAppLocalLanguage = "";
    private static String systemCountry = "";
    private static String systemLanguage = "";

    public static void changeLanguage(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            saveLanguageSetting(str, str2);
            return;
        }
        Locale locale = new Locale(str, str2);
        setAppLanguage(context, locale);
        saveLanguageSetting(locale);
        PayManager.INSTANCE.setLanguage(locale);
    }

    public static void setAppLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            configuration.setLocales(new LocaleList(new Locale[]{locale}));
            context.createConfigurationContext(configuration);
            resources.updateConfiguration(configuration, displayMetrics);
        } else if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, displayMetrics);
        } else {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public static void setAppLanguage(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            setAppLanguage(context, new Locale(str, str2));
        }
    }

    public static void setChosenLanguage(Context context) {
        setAppLanguage(context, getChosenLanguage(context), getChosenCountry(context));
    }

    public static void getSystemLocaleInfo(Context context) {
        Locale appLocale = getAppLocale(context);
        systemLanguage = appLocale.getLanguage();
        systemCountry = appLocale.getCountry();
    }

    public static void setSystemLanguage(Context context) {
        if (!TextUtils.isEmpty(systemLanguage) && !TextUtils.isEmpty(systemCountry)) {
            setAppLanguage(context, new Locale(systemLanguage, systemCountry));
        }
    }

    public static Context attachBaseContext(Context context) {
        setChosenLanguage(context);
        return context;
    }

    public static boolean isSameWithSetting(Context context) {
        Locale appLocale = getAppLocale(context);
        return appLocale.getLanguage().equals(getChosenLanguage(context)) && appLocale.getCountry().equals(getChosenCountry(context));
    }

    public static void saveLanguageSetting(Locale locale) {
        mAppLocalCountry = locale.getCountry();
        mAppLocalLanguage = locale.getLanguage();
    }

    public static void saveLanguageSetting(String str, String str2) {
        mAppLocalCountry = str2;
        mAppLocalLanguage = str;
    }

    public static boolean transferLanguageData(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        saveLanguageSetting(str, str2);
        return true;
    }

    public static Locale getAppLocale(Context context) {
        Locale locale;
        try {
            locale = Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale;
        } catch (Exception unused) {
            locale = null;
        }
        return locale == null ? new Locale(EN, COUNTRY_USA) : locale;
    }

    public static LocaleListCompat getSystemLanguage() {
        return ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
    }

    public static String getChosenLanguage(Context context) {
        return mAppLocalLanguage;
    }

    public static String getChosenCountry(Context context) {
        return mAppLocalCountry;
    }

    public static String getStringByChinese(Context context, int i) {
        return getStringByCountry(context, i, ZH, COUNTRY_CN);
    }

    public static String getStringByCountry(Context context, int i, String str, String str2) {
        try {
            Resources resourcesForApplication = context.getApplicationContext().getPackageManager().getResourcesForApplication(context.getPackageName());
            Configuration configuration = resourcesForApplication.getConfiguration();
            configuration.locale = new Locale(str, str2);
            resourcesForApplication.updateConfiguration(configuration, (DisplayMetrics) null);
            return resourcesForApplication.getString(i);
        } catch (Exception unused) {
            return "";
        }
    }
}
