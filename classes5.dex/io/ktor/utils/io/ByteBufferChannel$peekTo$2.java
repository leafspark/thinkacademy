package io.ktor.utils.io;

import io.ktor.utils.io.bits.MemoryJvmKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "nioBuffer", "Ljava/nio/ByteBuffer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteBufferChannel.kt */
final class ByteBufferChannel$peekTo$2 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ Ref.IntRef $bytesCopied;
    final /* synthetic */ ByteBuffer $destination;
    final /* synthetic */ long $destinationOffset;
    final /* synthetic */ long $max;
    final /* synthetic */ long $offset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$peekTo$2(long j, long j2, ByteBuffer byteBuffer, long j3, Ref.IntRef intRef) {
        super(1);
        this.$offset = j;
        this.$max = j2;
        this.$destination = byteBuffer;
        this.$destinationOffset = j3;
        this.$bytesCopied = intRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ByteBuffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "nioBuffer");
        if (((long) byteBuffer.remaining()) > this.$offset) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            Intrinsics.checkNotNull(duplicate);
            duplicate.position(duplicate.position() + ((int) this.$offset));
            int limit = duplicate.limit();
            duplicate.limit((int) Math.min((long) duplicate.limit(), Math.min(this.$max, ((long) this.$destination.limit()) - this.$destinationOffset) + this.$offset));
            this.$bytesCopied.element = duplicate.remaining();
            MemoryJvmKt.m61copyToSG11BkQ(duplicate, this.$destination, (int) this.$destinationOffset);
            duplicate.limit(limit);
        }
    }
}
