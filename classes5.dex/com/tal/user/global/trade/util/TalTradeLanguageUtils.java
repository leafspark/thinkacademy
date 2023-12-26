package com.tal.user.global.trade.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.tal.user.global.trade.api.TalTradeSdk;
import java.util.Locale;
import kbuild.autoconf;

public class TalTradeLanguageUtils {
    public static String locale2Str(Locale locale) {
        if (locale == null) {
            return autoconf.jvCONFIG_BUILD_CONFIG_NAME;
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static Locale getSystemPreferredLanguage(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return context.getApplicationContext().getResources().getConfiguration().getLocales().get(0);
            }
            return context.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return Locale.getDefault();
        }
    }

    public static Context updateResources(Context context, Locale locale) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList forLanguageTags = LocaleList.forLanguageTags(locale.getLanguage());
            LocaleList.setDefault(forLanguageTags);
            configuration.setLocales(forLanguageTags);
        } else {
            configuration.locale = locale;
        }
        configuration.locale = locale;
        configuration.setLocale(locale);
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
        TalTradeSdk.getInstance().setLocaleStr(locale2Str(locale));
        return createConfigurationContext;
    }
}
