package io.ktor.client.plugins.cache;

import io.ktor.http.Headers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCache.kt */
/* synthetic */ class HttpCache$findResponse$requestHeaders$1 extends FunctionReferenceImpl implements Function1<String, String> {
    HttpCache$findResponse$requestHeaders$1(Object obj) {
        super(1, obj, Headers.class, "get", "get(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((Headers) this.receiver).get(str);
    }
}
