package com.luck.picture.lib.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.luck.picture.lib.tools.SPUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class PictureLanguageUtils {
    private static final String KEY_LOCALE = "KEY_LOCALE";
    private static final String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private PictureLanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setAppLanguage(Context context, int i) {
        WeakReference weakReference = new WeakReference(context);
        if (i >= 0) {
            applyLanguage((Context) weakReference.get(), LocaleTransform.getLanguage(i));
        } else {
            setDefaultLanguage((Context) weakReference.get());
        }
    }

    private static void applyLanguage(Context context, Locale locale) {
        applyLanguage(context, locale, false);
    }

    private static void applyLanguage(Context context, Locale locale, boolean z) {
        if (z) {
            SPUtils.getPictureSpUtils().put(KEY_LOCALE, VALUE_FOLLOW_SYSTEM);
        } else {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            SPUtils pictureSpUtils = SPUtils.getPictureSpUtils();
            pictureSpUtils.put(KEY_LOCALE, language + "$" + country);
        }
        updateLanguage(context, locale);
    }

    private static void updateLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        if (!equals(locale2.getLanguage(), locale.getLanguage()) || !equals(locale2.getCountry(), locale.getCountry())) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.setLocale(locale);
            context.createConfigurationContext(configuration);
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    private static void setDefaultLanguage(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(Locale.getDefault());
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
