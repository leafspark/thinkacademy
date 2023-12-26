package io.ktor.util;

import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010 \n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0011\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J \u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001f0\u001e0\u001dH\u0016J\u0013\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, d2 = {"Lio/ktor/util/StringValuesBuilderImpl;", "Lio/ktor/util/StringValuesBuilder;", "caseInsensitiveName", "", "size", "", "(ZI)V", "getCaseInsensitiveName", "()Z", "values", "", "", "", "getValues", "()Ljava/util/Map;", "append", "", "name", "value", "appendAll", "stringValues", "Lio/ktor/util/StringValues;", "", "appendMissing", "build", "clear", "contains", "ensureListForKey", "entries", "", "", "", "get", "getAll", "isEmpty", "names", "remove", "removeKeysWithNoEntries", "set", "validateName", "validateValue", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringValues.kt */
public class StringValuesBuilderImpl implements StringValuesBuilder {
    private final boolean caseInsensitiveName;
    private final Map<String, List<String>> values;

    public StringValuesBuilderImpl() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void validateName(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
    }

    /* access modifiers changed from: protected */
    public void validateValue(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
    }

    public StringValuesBuilderImpl(boolean z, int i) {
        this.caseInsensitiveName = z;
        this.values = z ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap<>(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StringValuesBuilderImpl(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 8 : i);
    }

    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    /* access modifiers changed from: protected */
    public final Map<String, List<String>> getValues() {
        return this.values;
    }

    public List<String> getAll(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return this.values.get(str);
    }

    public boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return this.values.containsKey(str);
    }

    public boolean contains(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        List list = this.values.get(str);
        if (list != null) {
            return list.contains(str2);
        }
        return false;
    }

    public Set<String> names() {
        return this.values.keySet();
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public Set<Map.Entry<String, List<String>>> entries() {
        return CollectionsJvmKt.unmodifiable(this.values.entrySet());
    }

    public void set(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        validateValue(str2);
        List<String> ensureListForKey = ensureListForKey(str);
        ensureListForKey.clear();
        ensureListForKey.add(str2);
    }

    public String get(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        List<String> all = getAll(str);
        if (all != null) {
            return (String) CollectionsKt.firstOrNull(all);
        }
        return null;
    }

    public void append(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        validateValue(str2);
        ensureListForKey(str).add(str2);
    }

    public void appendAll(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.forEach(new StringValuesBuilderImpl$appendAll$1(this));
    }

    public void appendMissing(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.forEach(new StringValuesBuilderImpl$appendMissing$1(this));
    }

    public void appendAll(String str, Iterable<String> iterable) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(iterable, "values");
        List<String> ensureListForKey = ensureListForKey(str);
        for (String next : iterable) {
            validateValue(next);
            ensureListForKey.add(next);
        }
    }

    public void appendMissing(String str, Iterable<String> iterable) {
        Set set;
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(iterable, "values");
        List list = this.values.get(str);
        if (list == null || (set = CollectionsKt.toSet(list)) == null) {
            set = SetsKt.emptySet();
        }
        Collection arrayList = new ArrayList();
        for (String next : iterable) {
            if (!set.contains(next)) {
                arrayList.add(next);
            }
        }
        appendAll(str, (List) arrayList);
    }

    public void remove(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        this.values.remove(str);
    }

    public void removeKeysWithNoEntries() {
        Map<String, List<String>> map = this.values;
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (((List) next.getValue()).isEmpty()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (Map.Entry key : linkedHashMap.entrySet()) {
            remove((String) key.getKey());
        }
    }

    public boolean remove(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        List list = this.values.get(str);
        if (list != null) {
            return list.remove(str2);
        }
        return false;
    }

    public void clear() {
        this.values.clear();
    }

    public StringValues build() {
        return new StringValuesImpl(this.caseInsensitiveName, this.values);
    }

    private final List<String> ensureListForKey(String str) {
        List<String> list = this.values.get(str);
        if (list != null) {
            return list;
        }
        List<String> arrayList = new ArrayList<>();
        validateName(str);
        this.values.put(str, arrayList);
        return arrayList;
    }
}
