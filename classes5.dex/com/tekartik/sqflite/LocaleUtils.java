package com.tekartik.sqflite;

import android.os.Build;
import java.util.Locale;

public class LocaleUtils {
    static Locale localeForLanguateTag(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return localeForLanguageTag21(str);
        }
        return localeForLanguageTagPre21(str);
    }

    static Locale localeForLanguageTag21(String str) {
        return Locale.forLanguageTag(str);
    }

    static Locale localeForLanguageTagPre21(String str) {
        String str2;
        String str3;
        String[] split = str.split("-");
        String str4 = "";
        if (split.length > 0) {
            String str5 = split[0];
            if (split.length > 1) {
                str3 = split[1];
                if (split.length > 2) {
                    str4 = split[split.length - 1];
                }
                str2 = str4;
            } else {
                str2 = str4;
                str3 = str2;
            }
            str4 = str5;
        } else {
            str2 = str4;
            str3 = str2;
        }
        return new Locale(str4, str3, str2);
    }
}
