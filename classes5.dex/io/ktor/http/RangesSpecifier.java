package io.ktor.http;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\bHÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\b2\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u001c\u0010\u0016\u001a\u00020\u00122\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0015J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\bH\u0016J\u001f\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u0005\"\u0004\b\u0000\u0010!*\u0004\u0018\u0001H!H\u0002¢\u0006\u0002\u0010\"R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lio/ktor/http/RangesSpecifier;", "", "unit", "Lio/ktor/http/RangeUnits;", "ranges", "", "Lio/ktor/http/ContentRange;", "(Lio/ktor/http/RangeUnits;Ljava/util/List;)V", "", "(Ljava/lang/String;Ljava/util/List;)V", "getRanges", "()Ljava/util/List;", "getUnit", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isValid", "rangeUnitPredicate", "Lkotlin/Function1;", "merge", "Lkotlin/ranges/LongRange;", "length", "", "maxRangeCount", "mergeToSingle", "toString", "toList", "T", "(Ljava/lang/Object;)Ljava/util/List;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RangesSpecifier.kt */
public final class RangesSpecifier {
    private final List<ContentRange> ranges;
    private final String unit;

    public static /* synthetic */ RangesSpecifier copy$default(RangesSpecifier rangesSpecifier, String str, List<ContentRange> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rangesSpecifier.unit;
        }
        if ((i & 2) != 0) {
            list = rangesSpecifier.ranges;
        }
        return rangesSpecifier.copy(str, list);
    }

    public final String component1() {
        return this.unit;
    }

    public final List<ContentRange> component2() {
        return this.ranges;
    }

    public final RangesSpecifier copy(String str, List<? extends ContentRange> list) {
        Intrinsics.checkNotNullParameter(str, "unit");
        Intrinsics.checkNotNullParameter(list, "ranges");
        return new RangesSpecifier(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RangesSpecifier)) {
            return false;
        }
        RangesSpecifier rangesSpecifier = (RangesSpecifier) obj;
        return Intrinsics.areEqual(this.unit, rangesSpecifier.unit) && Intrinsics.areEqual(this.ranges, rangesSpecifier.ranges);
    }

    public int hashCode() {
        return (this.unit.hashCode() * 31) + this.ranges.hashCode();
    }

    public RangesSpecifier(String str, List<? extends ContentRange> list) {
        Intrinsics.checkNotNullParameter(str, "unit");
        Intrinsics.checkNotNullParameter(list, "ranges");
        this.unit = str;
        this.ranges = list;
        if (!(!list.isEmpty())) {
            throw new IllegalArgumentException("It should be at least one range".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RangesSpecifier(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RangeUnits.Bytes.getUnitToken() : str, (List<? extends ContentRange>) list);
    }

    public final List<ContentRange> getRanges() {
        return this.ranges;
    }

    public final String getUnit() {
        return this.unit;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RangesSpecifier(RangeUnits rangeUnits, List<? extends ContentRange> list) {
        this(rangeUnits.getUnitToken(), list);
        Intrinsics.checkNotNullParameter(rangeUnits, "unit");
        Intrinsics.checkNotNullParameter(list, "ranges");
    }

    public static /* synthetic */ boolean isValid$default(RangesSpecifier rangesSpecifier, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = (Function1) RangesSpecifier$isValid$1.INSTANCE;
        }
        return rangesSpecifier.isValid(function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (r2.getTo() >= r2.getFrom()) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        if (((io.ktor.http.ContentRange.TailFrom) r2).getFrom() < 0) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (((io.ktor.http.ContentRange.Suffix) r2).getLastCount() < 0) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0076, code lost:
        continue;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isValid(kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.Boolean> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "rangeUnitPredicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = r8.unit
            java.lang.Object r9 = r9.invoke(r0)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L_0x0083
            java.util.List<io.ktor.http.ContentRange> r9 = r8.ranges
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            boolean r2 = r9 instanceof java.util.Collection
            if (r2 == 0) goto L_0x0028
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0028
        L_0x0026:
            r9 = r1
            goto L_0x0080
        L_0x0028:
            java.util.Iterator r9 = r9.iterator()
        L_0x002c:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r9.next()
            io.ktor.http.ContentRange r2 = (io.ktor.http.ContentRange) r2
            boolean r3 = r2 instanceof io.ktor.http.ContentRange.Bounded
            r4 = 0
            if (r3 == 0) goto L_0x0056
            io.ktor.http.ContentRange$Bounded r2 = (io.ktor.http.ContentRange.Bounded) r2
            long r6 = r2.getFrom()
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 < 0) goto L_0x0054
            long r3 = r2.getTo()
            long r5 = r2.getFrom()
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0065
        L_0x0054:
            r2 = r1
            goto L_0x0076
        L_0x0056:
            boolean r3 = r2 instanceof io.ktor.http.ContentRange.TailFrom
            if (r3 == 0) goto L_0x0067
            io.ktor.http.ContentRange$TailFrom r2 = (io.ktor.http.ContentRange.TailFrom) r2
            long r2 = r2.getFrom()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0065
            goto L_0x0054
        L_0x0065:
            r2 = r0
            goto L_0x0076
        L_0x0067:
            boolean r3 = r2 instanceof io.ktor.http.ContentRange.Suffix
            if (r3 == 0) goto L_0x007a
            io.ktor.http.ContentRange$Suffix r2 = (io.ktor.http.ContentRange.Suffix) r2
            long r2 = r2.getLastCount()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0065
            goto L_0x0054
        L_0x0076:
            if (r2 == 0) goto L_0x002c
            r9 = r0
            goto L_0x0080
        L_0x007a:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L_0x0080:
            if (r9 == 0) goto L_0x0083
            r0 = r1
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.RangesSpecifier.isValid(kotlin.jvm.functions.Function1):boolean");
    }

    public static /* synthetic */ List merge$default(RangesSpecifier rangesSpecifier, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 50;
        }
        return rangesSpecifier.merge(j, i);
    }

    public final List<LongRange> merge(long j, int i) {
        if (this.ranges.size() > i) {
            return toList(mergeToSingle(j));
        }
        return merge(j);
    }

    public final List<LongRange> merge(long j) {
        return RangesKt.mergeRangesKeepOrder(RangesKt.toLongRanges(this.ranges, j));
    }

    public final LongRange mergeToSingle(long j) {
        Object obj;
        List<LongRange> longRanges = RangesKt.toLongRanges(this.ranges, j);
        Object obj2 = null;
        if (longRanges.isEmpty()) {
            return null;
        }
        Iterable iterable = longRanges;
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            obj = it.next();
            if (it.hasNext()) {
                long longValue = ((LongRange) obj).getStart().longValue();
                do {
                    Object next = it.next();
                    long longValue2 = ((LongRange) next).getStart().longValue();
                    if (longValue > longValue2) {
                        obj = next;
                        longValue = longValue2;
                    }
                } while (it.hasNext());
            }
        }
        Intrinsics.checkNotNull(obj);
        long longValue3 = ((LongRange) obj).getStart().longValue();
        Iterator it2 = iterable.iterator();
        if (it2.hasNext()) {
            obj2 = it2.next();
            if (it2.hasNext()) {
                long longValue4 = ((LongRange) obj2).getEndInclusive().longValue();
                do {
                    Object next2 = it2.next();
                    long longValue5 = ((LongRange) next2).getEndInclusive().longValue();
                    if (longValue4 < longValue5) {
                        obj2 = next2;
                        longValue4 = longValue5;
                    }
                } while (it2.hasNext());
            }
        }
        Intrinsics.checkNotNull(obj2);
        return new LongRange(longValue3, RangesKt.coerceAtMost(((LongRange) obj2).getEndInclusive().longValue(), j - 1));
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.ranges, ",", this.unit + '=', (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null);
    }

    private final <T> List<T> toList(T t) {
        return t == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(t);
    }
}
