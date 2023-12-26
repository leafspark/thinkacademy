package io.ktor.websocket;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "io/ktor/utils/io/core/ByteReadPacketExtensionsKt$ByteReadPacket$1", "io/ktor/utils/io/core/ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteReadPacketExtensions.kt */
public final class RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ byte[] $array;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommonKt$writeFrame$$inlined$ByteReadPacket$default$1(byte[] bArr) {
        super(1);
        this.$array = bArr;
    }

    public final void invoke(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ByteBuffer) obj);
        return Unit.INSTANCE;
    }
}
