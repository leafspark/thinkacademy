package io.ktor.websocket;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"RawWebSocket", "Lio/ktor/websocket/WebSocketSession;", "input", "Lio/ktor/utils/io/ByteReadChannel;", "output", "Lio/ktor/utils/io/ByteWriteChannel;", "maxFrameSize", "", "masking", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "ktor-websockets"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RawWebSocketJvm.kt */
public final class RawWebSocketJvmKt {
    public static /* synthetic */ WebSocketSession RawWebSocket$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 2147483647L;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = false;
        }
        return RawWebSocket(byteReadChannel, byteWriteChannel, j2, z, coroutineContext);
    }

    public static final WebSocketSession RawWebSocket(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "input");
        Intrinsics.checkNotNullParameter(byteWriteChannel, "output");
        CoroutineContext coroutineContext2 = coroutineContext;
        Intrinsics.checkNotNullParameter(coroutineContext2, "coroutineContext");
        return new RawWebSocketJvm(byteReadChannel, byteWriteChannel, j, z, coroutineContext2, (ObjectPool) null, 32, (DefaultConstructorMarker) null);
    }
}
