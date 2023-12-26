package io.ktor.http;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenBy$1<T> implements Comparator {
    final /* synthetic */ Comparator $this_thenBy;

    public HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenBy$1(Comparator comparator) {
        this.$this_thenBy = comparator;
    }

    public final int compare(T t, T t2) {
        int compare = this.$this_thenBy.compare(t, t2);
        if (compare != 0) {
            return compare;
        }
        ContentType parse = ContentType.Companion.parse(((HeaderValue) t).getValue());
        int i = 2;
        int i2 = Intrinsics.areEqual(parse.getContentType(), "*") ? 2 : 0;
        if (Intrinsics.areEqual(parse.getContentSubtype(), "*")) {
            i2++;
        }
        Comparable valueOf = Integer.valueOf(i2);
        ContentType parse2 = ContentType.Companion.parse(((HeaderValue) t2).getValue());
        if (!Intrinsics.areEqual(parse2.getContentType(), "*")) {
            i = 0;
        }
        if (Intrinsics.areEqual(parse2.getContentSubtype(), "*")) {
            i++;
        }
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
    }
}
