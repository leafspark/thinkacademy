package io.ktor.util.date;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\"\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\u0007\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"minus", "Lio/ktor/util/date/GMTDate;", "milliseconds", "", "duration", "Lkotlin/time/Duration;", "minus-HG0u8IE", "(Lio/ktor/util/date/GMTDate;J)Lio/ktor/util/date/GMTDate;", "plus", "plus-HG0u8IE", "truncateToSeconds", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Date.kt */
public final class DateKt {
    public static final GMTDate plus(GMTDate gMTDate, long j) {
        Intrinsics.checkNotNullParameter(gMTDate, "<this>");
        return DateJvmKt.GMTDate(Long.valueOf(gMTDate.getTimestamp() + j));
    }

    public static final GMTDate minus(GMTDate gMTDate, long j) {
        Intrinsics.checkNotNullParameter(gMTDate, "<this>");
        return DateJvmKt.GMTDate(Long.valueOf(gMTDate.getTimestamp() - j));
    }

    /* renamed from: plus-HG0u8IE  reason: not valid java name */
    public static final GMTDate m19plusHG0u8IE(GMTDate gMTDate, long j) {
        Intrinsics.checkNotNullParameter(gMTDate, "$this$plus");
        return DateJvmKt.GMTDate(Long.valueOf(gMTDate.getTimestamp() + Duration.m715getInWholeMillisecondsimpl(j)));
    }

    /* renamed from: minus-HG0u8IE  reason: not valid java name */
    public static final GMTDate m18minusHG0u8IE(GMTDate gMTDate, long j) {
        Intrinsics.checkNotNullParameter(gMTDate, "$this$minus");
        return DateJvmKt.GMTDate(Long.valueOf(gMTDate.getTimestamp() - Duration.m715getInWholeMillisecondsimpl(j)));
    }

    public static final GMTDate truncateToSeconds(GMTDate gMTDate) {
        Intrinsics.checkNotNullParameter(gMTDate, "<this>");
        return DateJvmKt.GMTDate(gMTDate.getSeconds(), gMTDate.getMinutes(), gMTDate.getHours(), gMTDate.getDayOfMonth(), gMTDate.getMonth(), gMTDate.getYear());
    }
}
