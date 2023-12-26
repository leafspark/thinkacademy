package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0013\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u0018\u001a\u00020\u0014H&J/\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00140\u001cH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H¦@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001dH¦@ø\u0001\u0000¢\u0006\u0002\u0010#J)\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010'J&\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00140\u001cH&J\u0019\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H¦@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0019\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H¦@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0019\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H¦@ø\u0001\u0000¢\u0006\u0002\u00103J1\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J\u0019\u00104\u001a\u00020\u00142\u0006\u0010 \u001a\u00020;H¦@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0019\u00104\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001dH¦@ø\u0001\u0000¢\u0006\u0002\u0010#J)\u00104\u001a\u00020\u00142\u0006\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010?J\u0019\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u0019\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020EH¦@ø\u0001\u0000¢\u0006\u0002\u0010FJ\u0019\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020IH¦@ø\u0001\u0000¢\u0006\u0002\u0010JJ:\u0010K\u001a\u00020\u00142'\u0010L\u001a#\b\u0001\u0012\u0004\u0012\u00020N\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140O\u0012\u0006\u0012\u0004\u0018\u00010\u00010M¢\u0006\u0002\bPH§@ø\u0001\u0000¢\u0006\u0002\u0010QJ%\u0010R\u001a\u00020\u00142\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00030\u001cH¦@ø\u0001\u0000¢\u0006\u0002\u0010SR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006T"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "autoFlush", "", "getAutoFlush", "()Z", "availableForWrite", "", "getAvailableForWrite", "()I", "closedCause", "", "getClosedCause", "()Ljava/lang/Throwable;", "isClosedForWrite", "totalBytesWritten", "", "getTotalBytesWritten", "()J", "awaitFreeSpace", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "cause", "flush", "write", "min", "block", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeAvailable", "src", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "offset", "length", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeByte", "b", "", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeDouble", "d", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloat", "f", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "memory", "Lio/ktor/utils/io/bits/Memory;", "startIndex", "endIndex", "writeFully-JT6ljtQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/Buffer;", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeInt", "i", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLong", "l", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacket", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "s", "", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSuspendSession", "visitor", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterSuspendSession;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteWriteChannel.kt */
public interface ByteWriteChannel {
    Object awaitFreeSpace(Continuation<? super Unit> continuation);

    boolean close(Throwable th);

    void flush();

    boolean getAutoFlush();

    int getAvailableForWrite();

    Throwable getClosedCause();

    long getTotalBytesWritten();

    boolean isClosedForWrite();

    Object write(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation);

    int writeAvailable(int i, Function1<? super ByteBuffer, Unit> function1);

    Object writeAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation);

    Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation);

    Object writeAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation);

    Object writeByte(byte b, Continuation<? super Unit> continuation);

    Object writeDouble(double d, Continuation<? super Unit> continuation);

    Object writeFloat(float f, Continuation<? super Unit> continuation);

    Object writeFully(Buffer buffer, Continuation<? super Unit> continuation);

    Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation);

    Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation);

    /* renamed from: writeFully-JT6ljtQ  reason: not valid java name */
    Object m29writeFullyJT6ljtQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation);

    Object writeInt(int i, Continuation<? super Unit> continuation);

    Object writeLong(long j, Continuation<? super Unit> continuation);

    Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation);

    Object writeShort(short s, Continuation<? super Unit> continuation);

    @Deprecated(message = "Use write { } instead.")
    Object writeSuspendSession(Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    Object writeWhile(Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ByteWriteChannel.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ int writeAvailable$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return byteWriteChannel.writeAvailable(i, (Function1<? super ByteBuffer, Unit>) function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeAvailable");
        }

        public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return byteWriteChannel.write(i, function1, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
    }
}
