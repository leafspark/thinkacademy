package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValues;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a0\u00190\u0018H\u0016J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\u0019\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lio/ktor/http/UrlDecodedParametersBuilder;", "Lio/ktor/http/ParametersBuilder;", "encodedParametersBuilder", "(Lio/ktor/http/ParametersBuilder;)V", "caseInsensitiveName", "", "getCaseInsensitiveName", "()Z", "append", "", "name", "", "value", "appendAll", "stringValues", "Lio/ktor/util/StringValues;", "values", "", "appendMissing", "build", "Lio/ktor/http/Parameters;", "clear", "contains", "entries", "", "", "", "get", "getAll", "isEmpty", "names", "remove", "removeKeysWithNoEntries", "set", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UrlDecodedParametersBuilder.kt */
public final class UrlDecodedParametersBuilder implements ParametersBuilder {
    private final boolean caseInsensitiveName;
    private final ParametersBuilder encodedParametersBuilder;

    public UrlDecodedParametersBuilder(ParametersBuilder parametersBuilder) {
        Intrinsics.checkNotNullParameter(parametersBuilder, "encodedParametersBuilder");
        this.encodedParametersBuilder = parametersBuilder;
        this.caseInsensitiveName = parametersBuilder.getCaseInsensitiveName();
    }

    public Parameters build() {
        return UrlDecodedParametersBuilderKt.decodeParameters(this.encodedParametersBuilder);
    }

    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public List<String> getAll(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        List<String> all = this.encodedParametersBuilder.getAll(CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null));
        if (all == null) {
            return null;
        }
        Iterable<String> iterable = all;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String decodeURLQueryComponent$default : iterable) {
            arrayList.add(CodecsKt.decodeURLQueryComponent$default(decodeURLQueryComponent$default, 0, 0, true, (Charset) null, 11, (Object) null));
        }
        return (List) arrayList;
    }

    public boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return this.encodedParametersBuilder.contains(CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null));
    }

    public boolean contains(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        return this.encodedParametersBuilder.contains(CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null), CodecsKt.encodeURLParameterValue(str2));
    }

    public Set<String> names() {
        Iterable<String> names = this.encodedParametersBuilder.names();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(names, 10));
        for (String decodeURLQueryComponent$default : names) {
            arrayList.add(CodecsKt.decodeURLQueryComponent$default(decodeURLQueryComponent$default, 0, 0, false, (Charset) null, 15, (Object) null));
        }
        return CollectionsKt.toSet((List) arrayList);
    }

    public boolean isEmpty() {
        return this.encodedParametersBuilder.isEmpty();
    }

    public Set<Map.Entry<String, List<String>>> entries() {
        return UrlDecodedParametersBuilderKt.decodeParameters(this.encodedParametersBuilder).entries();
    }

    public void set(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        this.encodedParametersBuilder.set(CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null), CodecsKt.encodeURLParameterValue(str2));
    }

    public String get(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        String str2 = this.encodedParametersBuilder.get(CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null));
        if (str2 != null) {
            return CodecsKt.decodeURLQueryComponent$default(str2, 0, 0, true, (Charset) null, 11, (Object) null);
        }
        return null;
    }

    public void append(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        this.encodedParametersBuilder.append(CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null), CodecsKt.encodeURLParameterValue(str2));
    }

    public void appendAll(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        UrlDecodedParametersBuilderKt.appendAllEncoded(this.encodedParametersBuilder, stringValues);
    }

    public void appendAll(String str, Iterable<String> iterable) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(iterable, "values");
        ParametersBuilder parametersBuilder = this.encodedParametersBuilder;
        String encodeURLParameter$default = CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String encodeURLParameterValue : iterable) {
            arrayList.add(CodecsKt.encodeURLParameterValue(encodeURLParameterValue));
        }
        parametersBuilder.appendAll(encodeURLParameter$default, (List) arrayList);
    }

    public void appendMissing(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        this.encodedParametersBuilder.appendMissing(UrlDecodedParametersBuilderKt.encodeParameters(stringValues).build());
    }

    public void appendMissing(String str, Iterable<String> iterable) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(iterable, "values");
        ParametersBuilder parametersBuilder = this.encodedParametersBuilder;
        String encodeURLParameter$default = CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String encodeURLParameterValue : iterable) {
            arrayList.add(CodecsKt.encodeURLParameterValue(encodeURLParameterValue));
        }
        parametersBuilder.appendMissing(encodeURLParameter$default, (List) arrayList);
    }

    public void remove(String str) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        this.encodedParametersBuilder.remove(CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null));
    }

    public boolean remove(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        return this.encodedParametersBuilder.remove(CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null), CodecsKt.encodeURLParameterValue(str2));
    }

    public void removeKeysWithNoEntries() {
        this.encodedParametersBuilder.removeKeysWithNoEntries();
    }

    public void clear() {
        this.encodedParametersBuilder.clear();
    }
}
