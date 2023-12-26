package io.ktor.utils.io;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 [2\u00020\u0001:\u0001[J\u0011\u0010\u0012\u001a\u00020\u0013H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H&J\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J,\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u0002H\u001b0\u001d¢\u0006\u0002\b\u001fH'¢\u0006\u0002\u0010 J@\u0010!\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2'\u0010\u001c\u001a#\b\u0001\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0$\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"¢\u0006\u0002\b\u001fH§@ø\u0001\u0000¢\u0006\u0002\u0010%JG\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000f2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000fH¦@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J/\u0010.\u001a\u00020\u00132\b\b\u0002\u0010+\u001a\u00020\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00130\u001dH¦@ø\u0001\u0000¢\u0006\u0002\u00101J\u0019\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000204H¦@ø\u0001\u0000¢\u0006\u0002\u00105J\u0019\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000200H¦@ø\u0001\u0000¢\u0006\u0002\u00106J)\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u0002072\u0006\u0010*\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u00109J&\u00102\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00130\u001dH&J\u0011\u0010;\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0011\u0010<\u001a\u00020=H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0011\u0010>\u001a\u00020?H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0011\u0010@\u001a\u00020AH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J!\u0010B\u001a\u00020\u00132\u0006\u00103\u001a\u0002042\u0006\u0010C\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010DJ\u0019\u0010B\u001a\u00020\u00032\u0006\u00103\u001a\u000200H¦@ø\u0001\u0000¢\u0006\u0002\u00106J)\u0010B\u001a\u00020\u00132\u0006\u00103\u001a\u0002072\u0006\u0010*\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u00109J\u0011\u0010E\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0011\u0010F\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u001b\u0010K\u001a\u00020H2\b\b\u0002\u0010L\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J!\u0010M\u001a\u00020\u00132\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00130\u001d¢\u0006\u0002\b\u001fH'J\u0011\u0010O\u001a\u00020PH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J:\u0010Q\u001a\u00020\u00132'\u0010/\u001a#\b\u0001\u0012\u0004\u0012\u00020R\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130$\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"¢\u0006\u0002\b\u001fH§@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001b\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010L\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010JJ/\u0010U\u001a\u00020\u000b\"\f\b\u0000\u0010V*\u00060Wj\u0002`X2\u0006\u0010Y\u001a\u0002HV2\u0006\u0010L\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010ZR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\\"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "availableForRead", "", "getAvailableForRead", "()I", "closedCause", "", "getClosedCause", "()Ljava/lang/Throwable;", "isClosedForRead", "", "()Z", "isClosedForWrite", "totalBytesRead", "", "getTotalBytesRead", "()J", "awaitContent", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "cause", "discard", "max", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookAhead", "R", "visitor", "Lkotlin/Function1;", "Lio/ktor/utils/io/LookAheadSession;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "lookAheadSuspend", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "destination", "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", "offset", "min", "peekTo-lBXzO7A", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "consumer", "Ljava/nio/ByteBuffer;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "dst", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "length", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "readBoolean", "readByte", "", "readDouble", "", "readFloat", "", "readFully", "n", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readInt", "readLong", "readPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "size", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemaining", "limit", "readSession", "Lio/ktor/utils/io/ReadSession;", "readShort", "", "readSuspendableSession", "Lio/ktor/utils/io/SuspendableReadSession;", "readUTF8Line", "", "readUTF8LineTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteReadChannelJVM.kt */
public interface ByteReadChannel {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object awaitContent(Continuation<? super Unit> continuation);

    boolean cancel(Throwable th);

    Object discard(long j, Continuation<? super Long> continuation);

    int getAvailableForRead();

    Throwable getClosedCause();

    long getTotalBytesRead();

    boolean isClosedForRead();

    boolean isClosedForWrite();

    @Deprecated(message = "Use read { } instead.")
    <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> function1);

    @Deprecated(message = "Use read { } instead.")
    <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation);

    /* renamed from: peekTo-lBXzO7A  reason: not valid java name */
    Object m27peekTolBXzO7A(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation<? super Long> continuation);

    Object read(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation);

    int readAvailable(int i, Function1<? super ByteBuffer, Unit> function1);

    Object readAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation);

    Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation);

    Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation);

    Object readBoolean(Continuation<? super Boolean> continuation);

    Object readByte(Continuation<? super Byte> continuation);

    Object readDouble(Continuation<? super Double> continuation);

    Object readFloat(Continuation<? super Float> continuation);

    Object readFully(ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation);

    Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation);

    Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation);

    Object readInt(Continuation<? super Integer> continuation);

    Object readLong(Continuation<? super Long> continuation);

    Object readPacket(int i, Continuation<? super ByteReadPacket> continuation);

    Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation);

    @Deprecated(message = "Use read { } instead.")
    void readSession(Function1<? super ReadSession, Unit> function1);

    Object readShort(Continuation<? super Short> continuation);

    @Deprecated(message = "Use read { } instead.")
    Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    Object readUTF8Line(int i, Continuation<? super String> continuation);

    <A extends Appendable> Object readUTF8LineTo(A a, int i, Continuation<? super Boolean> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ByteReadChannelJVM.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ int readAvailable$default(ByteReadChannel byteReadChannel, int i, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return byteReadChannel.readAvailable(i, (Function1<? super ByteBuffer, Unit>) function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAvailable");
        }

        public static /* synthetic */ Object readRemaining$default(ByteReadChannel byteReadChannel, long j, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = HttpTimeout.INFINITE_TIMEOUT_MS;
                }
                return byteReadChannel.readRemaining(j, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readRemaining");
        }

        public static /* synthetic */ Object read$default(ByteReadChannel byteReadChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return byteReadChannel.read(i, function1, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: read");
        }

        /* renamed from: peekTo-lBXzO7A$default  reason: not valid java name */
        public static /* synthetic */ Object m28peekTolBXzO7A$default(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return byteReadChannel.m27peekTolBXzO7A(byteBuffer, j, (i & 4) != 0 ? 0 : j2, (i & 8) != 0 ? 1 : j3, (i & 16) != 0 ? Long.MAX_VALUE : j4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: peekTo-lBXzO7A");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/ByteReadChannel;", "getEmpty", "()Lio/ktor/utils/io/ByteReadChannel;", "Empty$delegate", "Lkotlin/Lazy;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ByteReadChannelJVM.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Lazy<ByteChannel> Empty$delegate = LazyKt.lazy(ByteReadChannel$Companion$Empty$2.INSTANCE);

        private Companion() {
        }

        public final ByteReadChannel getEmpty() {
            return Empty$delegate.getValue();
        }
    }
}
