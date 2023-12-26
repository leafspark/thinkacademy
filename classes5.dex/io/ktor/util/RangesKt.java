package io.ktor.util;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"length", "", "Lkotlin/ranges/LongRange;", "getLength$annotations", "(Lkotlin/ranges/LongRange;)V", "getLength", "(Lkotlin/ranges/LongRange;)J", "contains", "", "other", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Ranges.kt */
public final class RangesKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Not supported anymore.")
    public static /* synthetic */ void getLength$annotations(LongRange longRange) {
    }

    public static final long getLength(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return kotlin.ranges.RangesKt.coerceAtLeast((longRange.getEndInclusive().longValue() - longRange.getStart().longValue()) + 1, 0);
    }

    public static final boolean contains(LongRange longRange, LongRange longRange2) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        Intrinsics.checkNotNullParameter(longRange2, "other");
        return longRange2.getStart().longValue() >= longRange.getStart().longValue() && longRange2.getEndInclusive().longValue() <= longRange.getEndInclusive().longValue();
    }
}
