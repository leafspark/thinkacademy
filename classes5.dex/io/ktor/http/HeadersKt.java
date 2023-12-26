package io.ktor.http;

import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001aC\u0010\u0000\u001a\u00020\u000126\u0010\u0002\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00040\u0003\"\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0006¨\u0006\u000b"}, d2 = {"headersOf", "Lio/ktor/http/Headers;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Lio/ktor/http/Headers;", "name", "value", "values", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Headers.kt */
public final class HeadersKt {
    public static final Headers headersOf() {
        return Headers.Companion.getEmpty();
    }

    public static final Headers headersOf(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        return new HeadersSingleImpl(str, CollectionsKt.listOf(str2));
    }

    public static final Headers headersOf(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(list, "values");
        return new HeadersSingleImpl(str, list);
    }

    public static final Headers headersOf(Pair<String, ? extends List<String>>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return new HeadersImpl(MapsKt.toMap(ArraysKt.asList(pairArr)));
    }
}
