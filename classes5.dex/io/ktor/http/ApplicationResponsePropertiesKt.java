package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"etag", "", "Lio/ktor/http/HeadersBuilder;", "entityTag", "", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApplicationResponseProperties.kt */
public final class ApplicationResponsePropertiesKt {
    public static final void etag(HeadersBuilder headersBuilder, String str) {
        Intrinsics.checkNotNullParameter(headersBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "entityTag");
        headersBuilder.set(HttpHeaders.INSTANCE.getETag(), str);
    }
}
