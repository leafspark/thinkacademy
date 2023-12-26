package com.adyen.checkout.core.util;

import android.content.Context;
import android.os.Build;
import java.util.IllformedLocaleException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0007¨\u0006\u000e"}, d2 = {"Lcom/adyen/checkout/core/util/LocaleUtil;", "", "()V", "fromLanguageTag", "Ljava/util/Locale;", "tag", "", "getLocale", "context", "Landroid/content/Context;", "isValidLocale", "", "locale", "toLanguageTag", "checkout-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LocaleUtil.kt */
public final class LocaleUtil {
    public static final LocaleUtil INSTANCE = new LocaleUtil();

    private LocaleUtil() {
    }

    @JvmStatic
    public static final Locale getLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = context.getResources().getConfiguration().getLocales().get(0);
            Intrinsics.checkNotNullExpressionValue(locale, "{\n            context.resources.configuration.locales[0]\n        }");
            return locale;
        }
        Locale locale2 = context.getResources().getConfiguration().locale;
        Intrinsics.checkNotNullExpressionValue(locale2, "{\n            @Suppress(\"DEPRECATION\")\n            context.resources.configuration.locale\n        }");
        return locale2;
    }

    @JvmStatic
    public static final String toLanguageTag(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "locale.toLanguageTag()");
        return languageTag;
    }

    @JvmStatic
    public static final Locale fromLanguageTag(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Locale forLanguageTag = Locale.forLanguageTag(str);
        Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(tag)");
        return forLanguageTag;
    }

    @JvmStatic
    public static final boolean isValidLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            new Locale.Builder().setLocale(locale).build();
            return true;
        } catch (IllformedLocaleException unused) {
            return false;
        }
    }
}
