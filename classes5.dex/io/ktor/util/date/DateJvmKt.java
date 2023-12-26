package io.ktor.util.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000f\u001a\u0006\u0010\u0010\u001a\u00020\u000e\u001a\u0019\u0010\u0011\u001a\u00020\u0004*\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0004\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"GMT_TIMEZONE", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "GMTDate", "Lio/ktor/util/date/GMTDate;", "seconds", "", "minutes", "hours", "dayOfMonth", "month", "Lio/ktor/util/date/Month;", "year", "timestamp", "", "(Ljava/lang/Long;)Lio/ktor/util/date/GMTDate;", "getTimeMillis", "toDate", "Ljava/util/Calendar;", "(Ljava/util/Calendar;Ljava/lang/Long;)Lio/ktor/util/date/GMTDate;", "toJvmDate", "Ljava/util/Date;", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DateJvm.kt */
public final class DateJvmKt {
    private static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");

    public static /* synthetic */ GMTDate GMTDate$default(Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return GMTDate(l);
    }

    public static final GMTDate GMTDate(Long l) {
        Calendar instance = Calendar.getInstance(GMT_TIMEZONE, Locale.ROOT);
        Intrinsics.checkNotNull(instance);
        return toDate(instance, l);
    }

    public static final GMTDate GMTDate(int i, int i2, int i3, int i4, Month month, int i5) {
        Intrinsics.checkNotNullParameter(month, "month");
        Calendar instance = Calendar.getInstance(GMT_TIMEZONE, Locale.ROOT);
        Intrinsics.checkNotNull(instance);
        instance.set(1, i5);
        instance.set(2, month.ordinal());
        instance.set(5, i4);
        instance.set(11, i3);
        instance.set(12, i2);
        instance.set(13, i);
        instance.set(14, 0);
        return toDate(instance, (Long) null);
    }

    public static final GMTDate toDate(Calendar calendar, Long l) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return new GMTDate(calendar.get(13), calendar.get(12), calendar.get(11), WeekDay.Companion.from(((calendar.get(7) + 7) - 2) % 7), calendar.get(5), calendar.get(6), Month.Companion.from(calendar.get(2)), calendar.get(1), calendar.getTimeInMillis());
    }

    public static final Date toJvmDate(GMTDate gMTDate) {
        Intrinsics.checkNotNullParameter(gMTDate, "<this>");
        return new Date(gMTDate.getTimestamp());
    }

    public static final long getTimeMillis() {
        return System.currentTimeMillis();
    }
}
