package io.ktor.util;

import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aH\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00040\u00032\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00040\u0003H\u0002\u001a0\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00040\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0002\u001a\u0006\u0010\f\u001a\u00020\r\u001aM\u0010\f\u001a\u00020\r26\u0010\u000e\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00100\u000f\"\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0001¢\u0006\u0002\u0010\u0012\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a&\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a*\u0010\f\u001a\u00020\r2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180\u00172\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a\u0012\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a\u001a6\u0010\u001c\u001a\u00020\u001d*\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010!\u001a\u001a\u0010\"\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005\u001a\u001a\u0010#\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005\u001a.\u0010$\u001a\u00020\r*\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010!\u001a\u001c\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00100\u0006*\u00020\r\u001a$\u0010&\u001a\u00020\u001d*\u00020\r2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0!\u001a\u001c\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0017*\u00020\r¨\u0006)"}, d2 = {"entriesEquals", "", "a", "", "", "", "", "b", "entriesHashCode", "", "entries", "seed", "valuesOf", "Lio/ktor/util/StringValues;", "pairs", "", "Lkotlin/Pair;", "caseInsensitiveKey", "([Lkotlin/Pair;Z)Lio/ktor/util/StringValues;", "name", "value", "values", "map", "", "", "appendAll", "Lio/ktor/util/StringValuesBuilder;", "builder", "appendFiltered", "", "source", "keepEmpty", "predicate", "Lkotlin/Function2;", "appendIfNameAbsent", "appendIfNameAndValueAbsent", "filter", "flattenEntries", "flattenForEach", "block", "toMap", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringValues.kt */
public final class StringValuesKt {
    public static /* synthetic */ StringValues valuesOf$default(Pair[] pairArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return valuesOf((Pair<String, ? extends List<String>>[]) pairArr, z);
    }

    public static final StringValues valuesOf(Pair<String, ? extends List<String>>[] pairArr, boolean z) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return new StringValuesImpl(z, MapsKt.toMap(ArraysKt.asList(pairArr)));
    }

    public static /* synthetic */ StringValues valuesOf$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return valuesOf(str, str2, z);
    }

    public static final StringValues valuesOf(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        return new StringValuesSingleImpl(z, str, CollectionsKt.listOf(str2));
    }

    public static /* synthetic */ StringValues valuesOf$default(String str, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return valuesOf(str, (List<String>) list, z);
    }

    public static final StringValues valuesOf(String str, List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(list, "values");
        return new StringValuesSingleImpl(z, str, list);
    }

    public static final StringValues valuesOf() {
        return StringValues.Companion.getEmpty();
    }

    public static /* synthetic */ StringValues valuesOf$default(Map map, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return valuesOf((Map<String, ? extends Iterable<String>>) map, z);
    }

    public static final StringValues valuesOf(Map<String, ? extends Iterable<String>> map, boolean z) {
        Intrinsics.checkNotNullParameter(map, "map");
        int size = map.size();
        if (size == 1) {
            Map.Entry entry = (Map.Entry) CollectionsKt.single(map.entrySet());
            return new StringValuesSingleImpl(z, (String) entry.getKey(), CollectionsKt.toList((Iterable) entry.getValue()));
        }
        Map caseInsensitiveMap = z ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(size);
        for (Map.Entry entry2 : map.entrySet()) {
            caseInsensitiveMap.put(entry2.getKey(), CollectionsKt.toList((Iterable) entry2.getValue()));
        }
        return new StringValuesImpl(z, caseInsensitiveMap);
    }

    public static final Map<String, List<String>> toMap(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Map<String, List<String>> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry entry : stringValues.entries()) {
            linkedHashMap.put((String) entry.getKey(), CollectionsKt.toList((Iterable) entry.getValue()));
        }
        return linkedHashMap;
    }

    public static final List<Pair<String, String>> flattenEntries(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Collection arrayList = new ArrayList();
        for (Map.Entry entry : stringValues.entries()) {
            Iterable<String> iterable = (Iterable) entry.getValue();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String str : iterable) {
                arrayList2.add(TuplesKt.to(entry.getKey(), str));
            }
            CollectionsKt.addAll(arrayList, (List) arrayList2);
        }
        return (List) arrayList;
    }

    public static final void flattenForEach(StringValues stringValues, Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        stringValues.forEach(new StringValuesKt$flattenForEach$1(function2));
    }

    public static /* synthetic */ StringValues filter$default(StringValues stringValues, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return filter(stringValues, z, function2);
    }

    public static final StringValues filter(StringValues stringValues, boolean z, Function2<? super String, ? super String, Boolean> function2) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Set<Map.Entry<String, List<String>>> entries = stringValues.entries();
        Map caseInsensitiveMap = stringValues.getCaseInsensitiveName() ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(entries.size());
        for (Map.Entry entry : entries) {
            Collection arrayList = new ArrayList(((List) entry.getValue()).size());
            for (Object next : (Iterable) entry.getValue()) {
                if (((Boolean) function2.invoke(entry.getKey(), (String) next)).booleanValue()) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            if (z || (!arrayList2.isEmpty())) {
                caseInsensitiveMap.put(entry.getKey(), arrayList2);
            }
        }
        return new StringValuesImpl(stringValues.getCaseInsensitiveName(), caseInsensitiveMap);
    }

    public static /* synthetic */ void appendFiltered$default(StringValuesBuilder stringValuesBuilder, StringValues stringValues, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        appendFiltered(stringValuesBuilder, stringValues, z, function2);
    }

    public static final void appendFiltered(StringValuesBuilder stringValuesBuilder, StringValues stringValues, boolean z, Function2<? super String, ? super String, Boolean> function2) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(stringValues, "source");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        stringValues.forEach(new StringValuesKt$appendFiltered$1(z, stringValuesBuilder, function2));
    }

    public static final StringValuesBuilder appendAll(StringValuesBuilder stringValuesBuilder, StringValuesBuilder stringValuesBuilder2) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(stringValuesBuilder2, "builder");
        for (Map.Entry entry : stringValuesBuilder2.entries()) {
            stringValuesBuilder.appendAll((String) entry.getKey(), (List) entry.getValue());
        }
        return stringValuesBuilder;
    }

    public static final StringValuesBuilder appendIfNameAbsent(StringValuesBuilder stringValuesBuilder, String str, String str2) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        if (!stringValuesBuilder.contains(str)) {
            stringValuesBuilder.append(str, str2);
        }
        return stringValuesBuilder;
    }

    public static final StringValuesBuilder appendIfNameAndValueAbsent(StringValuesBuilder stringValuesBuilder, String str, String str2) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        if (!stringValuesBuilder.contains(str, str2)) {
            stringValuesBuilder.append(str, str2);
        }
        return stringValuesBuilder;
    }

    /* access modifiers changed from: private */
    public static final boolean entriesEquals(Set<? extends Map.Entry<String, ? extends List<String>>> set, Set<? extends Map.Entry<String, ? extends List<String>>> set2) {
        return Intrinsics.areEqual(set, set2);
    }

    /* access modifiers changed from: private */
    public static final int entriesHashCode(Set<? extends Map.Entry<String, ? extends List<String>>> set, int i) {
        return (i * 31) + set.hashCode();
    }
}
