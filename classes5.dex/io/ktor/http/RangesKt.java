package io.ktor.http;

import io.ktor.http.ContentRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"parseRangesSpecifier", "Lio/ktor/http/RangesSpecifier;", "rangeSpec", "", "mergeRangesKeepOrder", "", "Lkotlin/ranges/LongRange;", "toLongRanges", "Lio/ktor/http/ContentRange;", "contentLength", "", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Ranges.kt */
public final class RangesKt {
    public static final List<LongRange> toLongRanges(List<? extends ContentRange> list, long j) {
        LongRange longRange;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterable<ContentRange> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ContentRange contentRange : iterable) {
            if (contentRange instanceof ContentRange.Bounded) {
                ContentRange.Bounded bounded = (ContentRange.Bounded) contentRange;
                longRange = new LongRange(bounded.getFrom(), kotlin.ranges.RangesKt.coerceAtMost(bounded.getTo(), j - 1));
            } else if (contentRange instanceof ContentRange.TailFrom) {
                longRange = kotlin.ranges.RangesKt.until(((ContentRange.TailFrom) contentRange).getFrom(), j);
            } else if (contentRange instanceof ContentRange.Suffix) {
                longRange = kotlin.ranges.RangesKt.until(kotlin.ranges.RangesKt.coerceAtLeast(j - ((ContentRange.Suffix) contentRange).getLastCount(), 0), j);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(longRange);
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            if (!((LongRange) next).isEmpty()) {
                arrayList2.add(next);
            }
        }
        return (List) arrayList2;
    }

    public static final List<LongRange> mergeRangesKeepOrder(List<LongRange> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(list.size());
        for (LongRange longRange : CollectionsKt.sortedWith(list, new RangesKt$mergeRangesKeepOrder$$inlined$sortedBy$1())) {
            if (arrayList.isEmpty()) {
                arrayList.add(longRange);
            } else {
                List list2 = arrayList;
                if (((LongRange) CollectionsKt.last(list2)).getEndInclusive().longValue() < longRange.getStart().longValue() - 1) {
                    arrayList.add(longRange);
                } else {
                    LongRange longRange2 = (LongRange) CollectionsKt.last(list2);
                    arrayList.set(CollectionsKt.getLastIndex(list2), new LongRange(longRange2.getStart().longValue(), Math.max(longRange2.getEndInclusive().longValue(), longRange.getEndInclusive().longValue())));
                }
            }
        }
        LongRange[] longRangeArr = new LongRange[list.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LongRange longRange3 = (LongRange) it.next();
            int i = 0;
            int size = list.size();
            while (true) {
                if (i >= size) {
                    break;
                }
                Intrinsics.checkNotNullExpressionValue(longRange3, "range");
                if (io.ktor.util.RangesKt.contains(longRange3, list.get(i))) {
                    longRangeArr[i] = longRange3;
                    break;
                }
                i++;
            }
        }
        return ArraysKt.filterNotNull(longRangeArr);
    }

    public static final RangesSpecifier parseRangesSpecifier(String str) {
        ContentRange contentRange;
        Pair pair;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "rangeSpec");
        try {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, "=", 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                return null;
            }
            boolean z = false;
            String substring = str2.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = str2.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            Pair pair2 = TuplesKt.to(substring, substring2);
            String str3 = (String) pair2.component1();
            Iterable<String> split$default = StringsKt.split$default((CharSequence) (String) pair2.component2(), new char[]{','}, false, 0, 6, (Object) null);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str4 : split$default) {
                if (StringsKt.startsWith$default(str4, "-", false, 2, (Object) null)) {
                    contentRange = new ContentRange.Suffix(Long.parseLong(StringsKt.removePrefix(str4, (CharSequence) "-")));
                } else {
                    int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str4, "-", 0, false, 6, (Object) null);
                    if (indexOf$default2 == -1) {
                        pair = TuplesKt.to("", "");
                    } else {
                        String substring3 = str4.substring(0, indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                        String substring4 = str4.substring(indexOf$default2 + 1);
                        Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String).substring(startIndex)");
                        pair = TuplesKt.to(substring3, substring4);
                    }
                    String str5 = (String) pair.component1();
                    String str6 = (String) pair.component2();
                    if (str6.length() > 0) {
                        contentRange = new ContentRange.Bounded(Long.parseLong(str5), Long.parseLong(str6));
                    } else {
                        contentRange = new ContentRange.TailFrom(Long.parseLong(str5));
                    }
                }
                arrayList.add(contentRange);
            }
            List list = (List) arrayList;
            if (list.isEmpty()) {
                return null;
            }
            if (str3.length() == 0) {
                z = true;
            }
            if (z) {
                return null;
            }
            RangesSpecifier rangesSpecifier = new RangesSpecifier(str3, (List<? extends ContentRange>) list);
            if (RangesSpecifier.isValid$default(rangesSpecifier, (Function1) null, 1, (Object) null)) {
                return rangesSpecifier;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
