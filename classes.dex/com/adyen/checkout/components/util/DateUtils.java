package com.adyen.checkout.components.util;

import com.adyen.checkout.core.log.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/adyen/checkout/components/util/DateUtils;", "", "()V", "matchesFormat", "", "date", "", "format", "parseDateToView", "month", "year", "toServerDateFormat", "calendar", "Ljava/util/Calendar;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DateUtils.kt */
public final class DateUtils {
    public static final DateUtils INSTANCE = new DateUtils();

    private DateUtils() {
    }

    @JvmStatic
    public static final String parseDateToView(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "month");
        Intrinsics.checkNotNullParameter(str2, "year");
        return str + '/' + StringsKt.takeLast(str2, 2);
    }

    @JvmStatic
    public static final String toServerDateFormat(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "serverDateFormat.format(calendar.time)");
        return format;
    }

    public final boolean matchesFormat(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "date");
        Intrinsics.checkNotNullParameter(str2, "format");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(str);
            return true;
        } catch (ParseException unused) {
            Logger.e("DateUtil", "Provided date " + str + " does not match the given format " + str2);
            return false;
        }
    }
}
