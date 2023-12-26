package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022:\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\u000bHHø\u0001\u0000¢\u0006\u0002\u0010\f*j\u0010\r\"2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u000422\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"consumeEachBufferRange", "", "Lio/ktor/utils/io/ByteReadChannel;", "visitor", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "", "last", "Lio/ktor/utils/io/ConsumeEachBufferVisitor;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ConsumeEachBufferVisitor", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConsumeEach.kt */
public final class ConsumeEachKt {
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00db A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e1 A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f7 A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f9 A[Catch:{ all -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object consumeEachBufferRange(io.ktor.utils.io.ByteReadChannel r18, kotlin.jvm.functions.Function2<? super java.nio.ByteBuffer, ? super java.lang.Boolean, java.lang.Boolean> r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1 r1 = (io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1 r1 = new io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x008b
            if (r3 == r7) goto L_0x006d
            if (r3 == r5) goto L_0x0041
            if (r3 == r4) goto L_0x0038
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            java.lang.Object r1 = r1.L$0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x015e
        L_0x0041:
            int r3 = r1.I$0
            java.lang.Object r3 = r1.L$5
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3
            java.lang.Object r9 = r1.L$4
            io.ktor.utils.io.ByteReadChannel r9 = (io.ktor.utils.io.ByteReadChannel) r9
            java.lang.Object r10 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r12 = r1.L$1
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            java.lang.Object r13 = r1.L$0
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0065 }
            r3 = r1
            r9 = r2
            r2 = r11
            r1 = r12
            r0 = r13
            goto L_0x012e
        L_0x0065:
            r0 = move-exception
        L_0x0066:
            r17 = r1
            r1 = r0
            r0 = r17
            goto L_0x0148
        L_0x006d:
            java.lang.Object r3 = r1.L$4
            io.ktor.utils.io.ByteReadChannel r3 = (io.ktor.utils.io.ByteReadChannel) r3
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r12 = r1.L$0
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r17 = r9
            r9 = r3
            r3 = r10
            r10 = r17
            goto L_0x00be
        L_0x008b:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r3 = new kotlin.jvm.internal.Ref$BooleanRef
            r3.<init>()
            r9 = r2
            r10 = r3
            r2 = r0
            r3 = r1
            r0 = r18
            r1 = r19
        L_0x00a0:
            r2.element = r6
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r2
            r3.L$3 = r10
            r3.L$4 = r0
            r3.L$5 = r8
            r3.label = r7
            java.lang.Object r11 = io.ktor.utils.io.ReadSessionKt.requestBuffer(r0, r7, r3)
            if (r11 != r9) goto L_0x00b7
            return r9
        L_0x00b7:
            r12 = r0
            r0 = r11
            r11 = r1
            r1 = r3
            r3 = r2
            r2 = r9
            r9 = r12
        L_0x00be:
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.io.core.Buffer) r0
            if (r0 != 0) goto L_0x00c8
            io.ktor.utils.io.core.Buffer$Companion r0 = io.ktor.utils.io.core.Buffer.Companion
            io.ktor.utils.io.core.Buffer r0 = r0.getEmpty()
        L_0x00c8:
            r13 = r0
            java.nio.ByteBuffer r0 = r13.m184getMemorySK3TCg8()     // Catch:{ all -> 0x0144 }
            int r14 = r13.getReadPosition()     // Catch:{ all -> 0x0144 }
            long r14 = (long) r14     // Catch:{ all -> 0x0144 }
            int r7 = r13.getWritePosition()     // Catch:{ all -> 0x0144 }
            long r6 = (long) r7     // Catch:{ all -> 0x0144 }
            int r16 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x00e1
            long r6 = r6 - r14
            java.nio.ByteBuffer r0 = io.ktor.utils.io.bits.Memory.m51slice87lwejk((java.nio.ByteBuffer) r0, (long) r14, (long) r6)     // Catch:{ all -> 0x0144 }
            goto L_0x00e7
        L_0x00e1:
            io.ktor.utils.io.bits.Memory$Companion r0 = io.ktor.utils.io.bits.Memory.Companion     // Catch:{ all -> 0x0144 }
            java.nio.ByteBuffer r0 = r0.m56getEmptySK3TCg8()     // Catch:{ all -> 0x0144 }
        L_0x00e7:
            int r6 = r0.remaining()     // Catch:{ all -> 0x0144 }
            int r7 = r12.getAvailableForRead()     // Catch:{ all -> 0x0144 }
            if (r6 != r7) goto L_0x00f9
            boolean r6 = r12.isClosedForWrite()     // Catch:{ all -> 0x0144 }
            if (r6 == 0) goto L_0x00f9
            r6 = 1
            goto L_0x00fa
        L_0x00f9:
            r6 = 0
        L_0x00fa:
            r10.element = r6     // Catch:{ all -> 0x0144 }
            boolean r6 = r10.element     // Catch:{ all -> 0x0144 }
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ all -> 0x0144 }
            java.lang.Object r6 = r11.invoke(r0, r6)     // Catch:{ all -> 0x0144 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0144 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x0144 }
            r3.element = r6     // Catch:{ all -> 0x0144 }
            int r0 = r0.position()     // Catch:{ all -> 0x0144 }
            r1.L$0 = r12     // Catch:{ all -> 0x0144 }
            r1.L$1 = r11     // Catch:{ all -> 0x0144 }
            r1.L$2 = r3     // Catch:{ all -> 0x0144 }
            r1.L$3 = r10     // Catch:{ all -> 0x0144 }
            r1.L$4 = r9     // Catch:{ all -> 0x0144 }
            r1.L$5 = r13     // Catch:{ all -> 0x0144 }
            r1.I$0 = r0     // Catch:{ all -> 0x0144 }
            r1.label = r5     // Catch:{ all -> 0x0144 }
            java.lang.Object r0 = io.ktor.utils.io.ReadSessionKt.completeReadingFromBuffer(r9, r13, r0, r1)     // Catch:{ all -> 0x0144 }
            if (r0 != r2) goto L_0x0129
            return r2
        L_0x0129:
            r9 = r2
            r2 = r3
            r0 = r12
            r3 = r1
            r1 = r11
        L_0x012e:
            boolean r6 = r10.element
            if (r6 == 0) goto L_0x0139
            boolean r6 = r0.isClosedForRead()
            if (r6 == 0) goto L_0x0139
            goto L_0x013d
        L_0x0139:
            boolean r6 = r2.element
            if (r6 != 0) goto L_0x0140
        L_0x013d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0140:
            r6 = 0
            r7 = 1
            goto L_0x00a0
        L_0x0144:
            r0 = move-exception
            r3 = r13
            goto L_0x0066
        L_0x0148:
            r0.L$0 = r1
            r0.L$1 = r8
            r0.L$2 = r8
            r0.L$3 = r8
            r0.L$4 = r8
            r0.L$5 = r8
            r0.label = r4
            r4 = 0
            java.lang.Object r0 = io.ktor.utils.io.ReadSessionKt.completeReadingFromBuffer(r9, r3, r4, r0)
            if (r0 != r2) goto L_0x015e
            return r2
        L_0x015e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ConsumeEachKt.consumeEachBufferRange(io.ktor.utils.io.ByteReadChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object consumeEachBufferRange$$forInline(ByteReadChannel byteReadChannel, Function2<? super ByteBuffer, ? super Boolean, Boolean> function2, Continuation<? super Unit> continuation) {
        ByteBuffer byteBuffer;
        boolean booleanValue;
        do {
            int i = false;
            InlineMarker.mark(i ? 1 : 0);
            Object requestBuffer = ReadSessionKt.requestBuffer(byteReadChannel, 1, continuation);
            InlineMarker.mark(1);
            Buffer buffer = (Buffer) requestBuffer;
            if (buffer == null) {
                buffer = Buffer.Companion.getEmpty();
            }
            try {
                ByteBuffer r3 = buffer.m184getMemorySK3TCg8();
                long readPosition = (long) buffer.getReadPosition();
                long writePosition = (long) buffer.getWritePosition();
                if (writePosition > readPosition) {
                    byteBuffer = Memory.m51slice87lwejk(r3, readPosition, writePosition - readPosition);
                } else {
                    byteBuffer = Memory.Companion.m56getEmptySK3TCg8();
                }
                boolean z = (byteBuffer.remaining() != byteReadChannel.getAvailableForRead() || !byteReadChannel.isClosedForWrite()) ? i : true;
                booleanValue = ((Boolean) function2.invoke(byteBuffer, Boolean.valueOf(z))).booleanValue();
                i = byteBuffer.position();
                if (z && byteReadChannel.isClosedForRead()) {
                    break;
                }
            } finally {
                InlineMarker.mark(i);
                ReadSessionKt.completeReadingFromBuffer(byteReadChannel, buffer, i, continuation);
                InlineMarker.mark(1);
            }
        } while (booleanValue);
        return Unit.INSTANCE;
    }
}
