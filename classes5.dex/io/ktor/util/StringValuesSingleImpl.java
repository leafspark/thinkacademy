package io.ktor.util;

import androidx.window.embedding.ActivityRule$;
import io.ktor.http.ContentDisposition;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J \u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00130\u0012H\u0016J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J(\u0010\u0017\u001a\u00020\u00182\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0004\u0012\u00020\u00180\u001aH\u0016J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lio/ktor/util/StringValuesSingleImpl;", "Lio/ktor/util/StringValues;", "caseInsensitiveName", "", "name", "", "values", "", "(ZLjava/lang/String;Ljava/util/List;)V", "getCaseInsensitiveName", "()Z", "getName", "()Ljava/lang/String;", "getValues", "()Ljava/util/List;", "contains", "value", "entries", "", "", "equals", "other", "", "forEach", "", "body", "Lkotlin/Function2;", "get", "getAll", "hashCode", "", "isEmpty", "names", "toString", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringValues.kt */
public class StringValuesSingleImpl implements StringValues {
    private final boolean caseInsensitiveName;
    private final String name;
    private final List<String> values;

    public boolean isEmpty() {
        return false;
    }

    public StringValuesSingleImpl(boolean z, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(list, "values");
        this.caseInsensitiveName = z;
        this.name = str;
        this.values = list;
    }

    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getValues() {
        return this.values;
    }

    public List<String> getAll(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        if (StringsKt.equals(this.name, str, getCaseInsensitiveName())) {
            return this.values;
        }
        return null;
    }

    public Set<Map.Entry<String, List<String>>> entries() {
        return SetsKt.setOf(new StringValuesSingleImpl$entries$1(this));
    }

    public Set<String> names() {
        return SetsKt.setOf(this.name);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StringValues(case=");
        sb.append(!getCaseInsensitiveName());
        sb.append(") ");
        sb.append(entries());
        return sb.toString();
    }

    public int hashCode() {
        return StringValuesKt.entriesHashCode(entries(), ActivityRule$.ExternalSyntheticBackport0.m(getCaseInsensitiveName()) * 31);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringValues)) {
            return false;
        }
        StringValues stringValues = (StringValues) obj;
        if (getCaseInsensitiveName() != stringValues.getCaseInsensitiveName()) {
            return false;
        }
        return StringValuesKt.entriesEquals(entries(), stringValues.entries());
    }

    public void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        function2.invoke(this.name, this.values);
    }

    public String get(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        if (StringsKt.equals(str, this.name, getCaseInsensitiveName())) {
            return (String) CollectionsKt.firstOrNull(this.values);
        }
        return null;
    }

    public boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return StringsKt.equals(str, this.name, getCaseInsensitiveName());
    }

    public boolean contains(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        return StringsKt.equals(str, this.name, getCaseInsensitiveName()) && this.values.contains(str2);
    }
}
