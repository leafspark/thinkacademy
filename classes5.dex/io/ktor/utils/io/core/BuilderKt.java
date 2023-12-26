package io.ktor.utils.io.core;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006\b"}, d2 = {"buildPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "", "Lkotlin/ExtensionFunctionType;", "reset", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Builder.kt */
public final class BuilderKt {
    public static final ByteReadPacket buildPacket(Function1<? super BytePacketBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            function1.invoke(bytePacketBuilder);
            return bytePacketBuilder.build();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final void reset(BytePacketBuilder bytePacketBuilder) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        bytePacketBuilder.release();
    }
}
