package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteOrder;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0013\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0013\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a.\u0010\u001a\u001a\u00020\t*\u00020\u00022\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t0\u001c¢\u0006\u0002\b\u001eHHø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a>\u0010 \u001a\u00020\t*\u00020\u00022'\u0010\u001b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\"\u0012\u0006\u0012\u0004\u0018\u00010#0!¢\u0006\u0002\b\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010$\u001a\u001d\u0010%\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a%\u0010%\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*\u001a\u001d\u0010(\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0002\u0010,\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"close", "", "Lio/ktor/utils/io/ByteWriteChannel;", "writeAvailable", "", "src", "", "(Lio/ktor/utils/io/ByteWriteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeBoolean", "", "b", "(Lio/ktor/utils/io/ByteWriteChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeByte", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeChar", "ch", "", "(Lio/ktor/utils/io/ByteWriteChannel;CLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "writeInt", "i", "", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/ByteWriteChannel;JLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacket", "builder", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacketSuspend", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "s", "(Lio/ktor/utils/io/ByteWriteChannel;ILio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeStringUtf8", "", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/CharSequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteWriteChannel.kt */
public final class ByteWriteChannelKt {
    public static final Object writeAvailable(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Integer> continuation) {
        return byteWriteChannel.writeAvailable(bArr, 0, bArr.length, continuation);
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Object writeFully = byteWriteChannel.writeFully(bArr, 0, bArr.length, continuation);
        return writeFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFully : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object writeShort = byteWriteChannel.writeShort((short) (i & 65535), continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, int i, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        Object writeShort = ChannelLittleEndianKt.writeShort(byteWriteChannel, (short) (i & 65535), byteOrder, continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    public static final Object writeByte(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object writeByte = byteWriteChannel.writeByte((byte) (i & 255), continuation);
        return writeByte == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeByte : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        Object writeInt = byteWriteChannel.writeInt((int) j, continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, long j, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        Object writeInt = ChannelLittleEndianKt.writeInt(byteWriteChannel, (int) j, byteOrder, continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    public static final boolean close(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return byteWriteChannel.close((Throwable) null);
    }

    public static final Object writeBoolean(ByteWriteChannel byteWriteChannel, boolean z, Continuation<? super Unit> continuation) {
        Object writeByte = byteWriteChannel.writeByte(z ? (byte) 1 : 0, continuation);
        return writeByte == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeByte : Unit.INSTANCE;
    }

    public static final Object writeChar(ByteWriteChannel byteWriteChannel, char c, Continuation<? super Unit> continuation) {
        Object writeShort = writeShort(byteWriteChannel, c, continuation);
        return writeShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeShort : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object writePacketSuspend(io.ktor.utils.io.ByteWriteChannel r6, kotlin.jvm.functions.Function2<? super io.ktor.utils.io.core.BytePacketBuilder, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 r0 = (io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006b
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.core.BytePacketBuilder r7 = (io.ktor.utils.io.core.BytePacketBuilder) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0042 }
            goto L_0x005a
        L_0x0042:
            r6 = move-exception
            goto L_0x0070
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.utils.io.core.BytePacketBuilder r8 = new io.ktor.utils.io.core.BytePacketBuilder
            r8.<init>(r5, r4, r5)
            r0.L$0 = r8     // Catch:{ all -> 0x006e }
            r0.L$1 = r6     // Catch:{ all -> 0x006e }
            r0.label = r4     // Catch:{ all -> 0x006e }
            java.lang.Object r7 = r7.invoke(r8, r0)     // Catch:{ all -> 0x006e }
            if (r7 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r7 = r8
        L_0x005a:
            io.ktor.utils.io.core.ByteReadPacket r7 = r7.build()     // Catch:{ all -> 0x0042 }
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.writePacket(r7, r0)
            if (r6 != r1) goto L_0x006b
            return r1
        L_0x006b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x006e:
            r6 = move-exception
            r7 = r8
        L_0x0070:
            r7.release()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteWriteChannelKt.writePacketSuspend(io.ktor.utils.io.ByteWriteChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, CharSequence charSequence, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            StringsKt.writeText$default((Output) bytePacketBuilder, charSequence, 0, 0, (Charset) null, 14, (Object) null);
            Object writePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, String str, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            StringsKt.writeText$default((Output) bytePacketBuilder, (CharSequence) str, 0, 0, (Charset) null, 14, (Object) null);
            Object writePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final Object writePacket(ByteWriteChannel byteWriteChannel, Function1<? super BytePacketBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            function1.invoke(bytePacketBuilder);
            Object writePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    private static final Object writePacket$$forInline(ByteWriteChannel byteWriteChannel, Function1<? super BytePacketBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            function1.invoke(bytePacketBuilder);
            ByteReadPacket build = bytePacketBuilder.build();
            InlineMarker.mark(0);
            byteWriteChannel.writePacket(build, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
