package io.ktor.client.plugins.cache;

import io.ktor.http.URLProtocol;
import io.ktor.http.content.OutgoingContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001aN\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00070\u0001H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"mergedHeadersLookup", "Lkotlin/Function1;", "", "content", "Lio/ktor/http/content/OutgoingContent;", "headerExtractor", "allHeadersExtractor", "", "canStore", "", "Lio/ktor/http/URLProtocol;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCache.kt */
public final class HttpCacheKt {
    /* access modifiers changed from: private */
    public static final Function1<String, String> mergedHeadersLookup(OutgoingContent outgoingContent, Function1<? super String, String> function1, Function1<? super String, ? extends List<String>> function12) {
        return (Function1) new HttpCacheKt$mergedHeadersLookup$1(outgoingContent, function1, function12);
    }

    /* access modifiers changed from: private */
    public static final boolean canStore(URLProtocol uRLProtocol) {
        return Intrinsics.areEqual(uRLProtocol.getName(), "http") || Intrinsics.areEqual(uRLProtocol.getName(), "https");
    }
}
