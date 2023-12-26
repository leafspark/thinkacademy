package io.ktor.http.parsing;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\t\u001a\u00020\u0004R \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/ktor/http/parsing/ParseResult;", "", "mapping", "", "", "", "(Ljava/util/Map;)V", "contains", "", "key", "get", "getAll", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Parser.kt */
public final class ParseResult {
    private final Map<String, List<String>> mapping;

    public ParseResult(Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(map, "mapping");
        this.mapping = map;
    }

    public final String get(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        List list = this.mapping.get(str);
        if (list != null) {
            return (String) CollectionsKt.firstOrNull(list);
        }
        return null;
    }

    public final List<String> getAll(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        List<String> list = this.mapping.get(str);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.mapping.containsKey(str);
    }
}
