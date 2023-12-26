package io.ktor.client.network.sockets;

import io.ktor.client.request.HttpRequestData;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"ByteChannelWithMappedExceptions", "Lio/ktor/utils/io/ByteChannel;", "request", "Lio/ktor/client/request/HttpRequestData;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeoutExceptions.kt */
public final class TimeoutExceptionsKt {
    public static final ByteChannel ByteChannelWithMappedExceptions(HttpRequestData httpRequestData) {
        Intrinsics.checkNotNullParameter(httpRequestData, "request");
        return ByteChannelKt.ByteChannel$default(false, new TimeoutExceptionsKt$ByteChannelWithMappedExceptions$1(httpRequestData), 1, (Object) null);
    }
}
