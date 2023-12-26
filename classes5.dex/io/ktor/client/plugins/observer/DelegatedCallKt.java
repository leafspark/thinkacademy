package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0007"}, d2 = {"wrapWithContent", "Lio/ktor/client/call/HttpClientCall;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "shouldCloseOrigin", "", "Lio/ktor/client/statement/HttpResponse;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DelegatedCall.kt */
public final class DelegatedCallKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Parameter [shouldCloseOrigin] is deprecated", replaceWith = @ReplaceWith(expression = "wrapWithContent(content)", imports = {}))
    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, ByteReadChannel byteReadChannel, boolean z) {
        Intrinsics.checkNotNullParameter(httpClientCall, "<this>");
        Intrinsics.checkNotNullParameter(byteReadChannel, "content");
        return wrapWithContent(httpClientCall, byteReadChannel);
    }

    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(httpClientCall, "<this>");
        Intrinsics.checkNotNullParameter(byteReadChannel, "content");
        return new DelegatedCall(httpClientCall.getClient(), byteReadChannel, httpClientCall);
    }

    public static final HttpResponse wrapWithContent(HttpResponse httpResponse, ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(byteReadChannel, "content");
        return new DelegatedResponse(httpResponse.getCall(), byteReadChannel, httpResponse);
    }
}
