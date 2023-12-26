package io.ktor.util;

import androidx.window.embedding.ActivityRule$;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J \u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u00120\u0011H\u0016J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J(\u0010\u0016\u001a\u00020\u00172\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0004\u0012\u00020\u00170\u0019H\u0016J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lio/ktor/util/StringValuesImpl;", "Lio/ktor/util/StringValues;", "caseInsensitiveName", "", "values", "", "", "", "(ZLjava/util/Map;)V", "getCaseInsensitiveName", "()Z", "getValues", "()Ljava/util/Map;", "contains", "name", "value", "entries", "", "", "equals", "other", "", "forEach", "", "body", "Lkotlin/Function2;", "get", "getAll", "hashCode", "", "isEmpty", "listForKey", "names", "toString", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringValues.kt */
public class StringValuesImpl implements StringValues {
    private final boolean caseInsensitiveName;
    private final Map<String, List<String>> values;

    public StringValuesImpl() {
        this(false, (Map) null, 3, (DefaultConstructorMarker) null);
    }

    public StringValuesImpl(boolean z, Map<String, ? extends List<String>> map) {
        Map<String, List<String>> map2;
        Intrinsics.checkNotNullParameter(map, "values");
        this.caseInsensitiveName = z;
        if (z) {
            map2 = CollectionsKt.caseInsensitiveMap();
        } else {
            map2 = new LinkedHashMap<>();
        }
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add((String) list.get(i));
            }
            map2.put(str, arrayList);
        }
        this.values = map2;
    }

    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StringValuesImpl(boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    /* access modifiers changed from: protected */
    public final Map<String, List<String>> getValues() {
        return this.values;
    }

    public String get(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        List<String> listForKey = listForKey(str);
        if (listForKey != null) {
            return (String) CollectionsKt.firstOrNull(listForKey);
        }
        return null;
    }

    public List<String> getAll(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return listForKey(str);
    }

    public boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return listForKey(str) != null;
    }

    public boolean contains(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        List<String> listForKey = listForKey(str);
        if (listForKey != null) {
            return listForKey.contains(str2);
        }
        return false;
    }

    public Set<String> names() {
        return CollectionsJvmKt.unmodifiable(this.values.keySet());
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public Set<Map.Entry<String, List<String>>> entries() {
        return CollectionsJvmKt.unmodifiable(this.values.entrySet());
    }

    public void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        for (Map.Entry next : this.values.entrySet()) {
            function2.invoke((String) next.getKey(), (List) next.getValue());
        }
    }

    private final List<String> listForKey(String str) {
        return this.values.get(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StringValues(case=");
        sb.append(!this.caseInsensitiveName);
        sb.append(") ");
        sb.append(entries());
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringValues)) {
            return false;
        }
        StringValues stringValues = (StringValues) obj;
        if (this.caseInsensitiveName != stringValues.getCaseInsensitiveName()) {
            return false;
        }
        return StringValuesKt.entriesEquals(entries(), stringValues.entries());
    }

    public int hashCode() {
        return StringValuesKt.entriesHashCode(entries(), ActivityRule$.ExternalSyntheticBackport0.m(this.caseInsensitiveName) * 31);
    }
}
