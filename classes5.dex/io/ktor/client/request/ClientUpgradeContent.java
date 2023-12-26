package io.ktor.client.request;

import io.ktor.http.Headers;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.InternalAPI;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H&R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/ktor/client/request/ClientUpgradeContent;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "()V", "content", "Lio/ktor/utils/io/ByteChannel;", "getContent", "()Lio/ktor/utils/io/ByteChannel;", "content$delegate", "Lkotlin/Lazy;", "output", "Lio/ktor/utils/io/ByteWriteChannel;", "getOutput", "()Lio/ktor/utils/io/ByteWriteChannel;", "pipeTo", "", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verify", "headers", "Lio/ktor/http/Headers;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalAPI
/* compiled from: ClientUpgradeContent.kt */
public abstract class ClientUpgradeContent extends OutgoingContent.NoContent {
    private final Lazy content$delegate = LazyKt.lazy(ClientUpgradeContent$content$2.INSTANCE);

    public abstract void verify(Headers headers);

    private final ByteChannel getContent() {
        return (ByteChannel) this.content$delegate.getValue();
    }

    public final ByteWriteChannel getOutput() {
        return getContent();
    }

    public final Object pipeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        Object copyAndClose$default = ByteReadChannelKt.copyAndClose$default(getContent(), byteWriteChannel, 0, continuation, 2, (Object) null);
        return copyAndClose$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? copyAndClose$default : Unit.INSTANCE;
    }
}
