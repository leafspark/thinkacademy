package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001aK\u0010\u0000\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u00020\u00022!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u00030\u0005H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"preview", "Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "R", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tmp", "(Lio/ktor/utils/io/core/BytePacketBuilder;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Preview.kt */
public final class PreviewKt {
    public static final <R> R preview(BytePacketBuilder bytePacketBuilder, Function1<? super ByteReadPacket, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ByteReadPacket preview = preview(bytePacketBuilder);
        try {
            return function1.invoke(preview);
        } finally {
            InlineMarker.finallyStart(1);
            preview.release();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final ByteReadPacket preview(BytePacketBuilder bytePacketBuilder) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        ChunkBuffer head$ktor_io = bytePacketBuilder.getHead$ktor_io();
        if (head$ktor_io == ChunkBuffer.Companion.getEmpty()) {
            return ByteReadPacket.Companion.getEmpty();
        }
        return new ByteReadPacket(BuffersKt.copyAll(head$ktor_io), bytePacketBuilder.get_pool());
    }
}
