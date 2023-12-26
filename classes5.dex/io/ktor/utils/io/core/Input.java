package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b&\u0018\u0000 \u00012\u00060\u0001j\u0002`\u0002:\u0002\u0001B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\u0010\tJ\u0010\u00107\u001a\u0002082\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0015\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u0004H\u0000¢\u0006\u0002\b;J\u0010\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0017H\u0002J\u0006\u0010A\u001a\u00020\u000fJ\b\u0010B\u001a\u000208H\u0016J\b\u0010C\u001a\u000208H$J\u000e\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0017J\u000e\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0006J\u0018\u0010F\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u0017H\u0002J\u0019\u0010F\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0006H\u0010J\u000e\u0010H\u001a\u0002082\u0006\u0010E\u001a\u00020\u0017J\n\u0010I\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010J\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u0006H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u00020\u0004H\u0001J\u001b\u0010K\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0010J\u0017\u0010N\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\bOJ\n\u0010P\u001a\u0004\u0018\u00010\u0004H\u0014J-\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\u0017H$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010UJ\u0015\u0010V\u001a\u0002082\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u0002082\u0006\u0010L\u001a\u00020\u0004H\u0002J \u0010Y\u001a\u0002082\u0006\u0010L\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00172\u0006\u0010[\u001a\u00020\u0017H\u0002J\u000e\u0010\\\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u0017J\b\u0010]\u001a\u000208H\u0004J\u0018\u0010^\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010_\u001a\u00020\u0017H\u0002J\u0010\u0010`\u001a\u00020?2\u0006\u0010a\u001a\u00020\u0017H\u0002J\u0010\u0010b\u001a\u00020?2\u0006\u0010E\u001a\u00020\u0017H\u0002JA\u0010c\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010d\u001a\u00020\u00062\b\b\u0002\u0010R\u001a\u00020\u00062\b\b\u0002\u0010@\u001a\u00020\u00062\b\b\u0002\u0010_\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\be\u0010fJ\u000e\u0010c\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u0004J\u0015\u0010h\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u0006H\u0000¢\u0006\u0002\biJ\u0018\u0010j\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u0017H\u0002J\u0012\u0010l\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u0017H\u0001J\u001a\u0010l\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0001J\u0017\u0010m\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u0017H\u0000¢\u0006\u0002\bnJ\u001b\u0010o\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0010J$\u0010p\u001a\u00020\u00172\n\u0010q\u001a\u00060rj\u0002`s2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010_\u001a\u00020\u0017H\u0002J)\u0010t\u001a\u00020\u00172\u0006\u0010u\u001a\u00020v2\u0006\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u0017H\u0010J%\u0010w\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020x2\u0006\u0010y\u001a\u00020\u00172\u0006\u0010z\u001a\u00020\u0017H\u0000¢\u0006\u0002\b{J\u0006\u0010|\u001a\u00020}J\b\u0010~\u001a\u00020}H\u0002J\u001b\u0010\u001a\u00030\u00012\b\b\u0002\u0010@\u001a\u00020\u00172\b\b\u0002\u0010_\u001a\u00020\u0017J&\u0010\u001a\u00020\u00172\n\u0010q\u001a\u00060rj\u0002`s2\b\b\u0002\u0010@\u001a\u00020\u00172\b\b\u0002\u0010_\u001a\u00020\u0017J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0017J\u001c\u0010\u0001\u001a\u0002082\n\u0010q\u001a\u00060rj\u0002`s2\u0007\u0010\u0001\u001a\u00020\u0017J%\u0010\u0001\u001a\u00020\u00172\n\u0010q\u001a\u00060rj\u0002`s2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010_\u001a\u00020\u0017H\u0002J\u0007\u0010\u0001\u001a\u000208J\u0017\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0003\b\u0001J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0003\b\u0001J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020\u0017J\u0017\u0010\u0001\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u0004H\u0000¢\u0006\u0003\b\u0001R\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00048@X\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0016\n\u0002\u0010$\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020\u00178\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001b\u0010)\u001a\u00020\u00178À\u0002X\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\u001aR\u000e\u0010,\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b/\u00100R,\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00068\u0000@@X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u0013\u001a\u0004\b4\u00100\"\u0004\b5\u00106\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Lio/ktor/utils/io/core/Input;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "head", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "remaining", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "newHead", "_head", "set_head", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "endOfInput", "", "getEndOfInput", "()Z", "getHead$annotations", "()V", "getHead", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "headEndExclusive", "", "getHeadEndExclusive$annotations", "getHeadEndExclusive", "()I", "setHeadEndExclusive", "(I)V", "headMemory", "Lio/ktor/utils/io/bits/Memory;", "getHeadMemory-SK3TCg8$annotations", "getHeadMemory-SK3TCg8", "()Ljava/nio/ByteBuffer;", "setHeadMemory-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "Ljava/nio/ByteBuffer;", "headPosition", "getHeadPosition$annotations", "getHeadPosition", "setHeadPosition", "headRemaining", "getHeadRemaining$annotations", "getHeadRemaining", "noMoreChunksAvailable", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "getRemaining", "()J", "newValue", "tailRemaining", "getTailRemaining$annotations", "getTailRemaining", "setTailRemaining", "(J)V", "afterRead", "", "append", "chain", "append$ktor_io", "appendView", "chunk", "atLeastMinCharactersRequire", "", "min", "canRead", "close", "closeSource", "discard", "n", "discardAsMuchAsPossible", "skipped", "discardExact", "doFill", "doPrefetch", "ensureNext", "current", "empty", "ensureNextHead", "ensureNextHead$ktor_io", "fill", "destination", "offset", "length", "fill-62zg_DM", "(Ljava/nio/ByteBuffer;II)I", "fixGapAfterRead", "fixGapAfterRead$ktor_io", "fixGapAfterReadFallback", "fixGapAfterReadFallbackUnreserved", "size", "overrun", "hasBytes", "markNoMoreChunksAvailable", "minShouldBeLess", "max", "minSizeIsTooBig", "minSize", "notEnoughBytesAvailable", "peekTo", "destinationOffset", "peekTo-9zorpBc", "(Ljava/nio/ByteBuffer;JJJJ)J", "buffer", "prefetch", "prefetch$ktor_io", "prematureEndOfStreamChars", "copied", "prepareRead", "prepareReadHead", "prepareReadHead$ktor_io", "prepareReadLoop", "readASCII", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readAsMuchAsPossible", "array", "", "readAvailableCharacters", "", "off", "len", "readAvailableCharacters$ktor_io", "readByte", "", "readByteSlow", "readText", "", "readTextExact", "exactCharacters", "readUtf8", "release", "releaseHead", "releaseHead$ktor_io", "steal", "steal$ktor_io", "stealAll", "stealAll$ktor_io", "tryPeek", "tryWriteAppend", "tryWriteAppend$ktor_io", "Companion", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Input.kt */
public abstract class Input implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ChunkBuffer _head;
    private int headEndExclusive;
    private ByteBuffer headMemory;
    private int headPosition;
    private boolean noMoreChunksAvailable;
    private final ObjectPool<ChunkBuffer> pool;
    private long tailRemaining;

    public Input() {
        this((ChunkBuffer) null, 0, (ObjectPool) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void getHead$annotations() {
    }

    public static /* synthetic */ void getHeadEndExclusive$annotations() {
    }

    /* renamed from: getHeadMemory-SK3TCg8$annotations  reason: not valid java name */
    public static /* synthetic */ void m221getHeadMemorySK3TCg8$annotations() {
    }

    public static /* synthetic */ void getHeadPosition$annotations() {
    }

    public static /* synthetic */ void getHeadRemaining$annotations() {
    }

    public static /* synthetic */ void getTailRemaining$annotations() {
    }

    /* access modifiers changed from: protected */
    public abstract void closeSource();

    /* access modifiers changed from: protected */
    /* renamed from: fill-62zg_DM  reason: not valid java name */
    public abstract int m223fill62zg_DM(ByteBuffer byteBuffer, int i, int i2);

    public Input(ChunkBuffer chunkBuffer, long j, ObjectPool<ChunkBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.pool = objectPool;
        this._head = chunkBuffer;
        this.headMemory = chunkBuffer.m184getMemorySK3TCg8();
        this.headPosition = chunkBuffer.getReadPosition();
        int writePosition = chunkBuffer.getWritePosition();
        this.headEndExclusive = writePosition;
        this.tailRemaining = j - ((long) (writePosition - this.headPosition));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Input(io.ktor.utils.io.core.internal.ChunkBuffer r1, long r2, io.ktor.utils.io.pool.ObjectPool<io.ktor.utils.io.core.internal.ChunkBuffer> r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L_0x000a
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r1 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = r1.getEmpty()
        L_0x000a:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x0012
            long r2 = io.ktor.utils.io.core.BuffersKt.remainingAll(r1)
        L_0x0012:
            r5 = r5 & 4
            if (r5 == 0) goto L_0x001c
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r4 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r4 = r4.getPool()
        L_0x001c:
            r0.<init>(r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.<init>(io.ktor.utils.io.core.internal.ChunkBuffer, long, io.ktor.utils.io.pool.ObjectPool, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ObjectPool<ChunkBuffer> getPool() {
        return this.pool;
    }

    private final void set_head(ChunkBuffer chunkBuffer) {
        this._head = chunkBuffer;
        this.headMemory = chunkBuffer.m184getMemorySK3TCg8();
        this.headPosition = chunkBuffer.getReadPosition();
        this.headEndExclusive = chunkBuffer.getWritePosition();
    }

    public final ChunkBuffer getHead() {
        ChunkBuffer chunkBuffer = this._head;
        chunkBuffer.discardUntilIndex$ktor_io(this.headPosition);
        return chunkBuffer;
    }

    /* renamed from: getHeadMemory-SK3TCg8  reason: not valid java name */
    public final ByteBuffer m224getHeadMemorySK3TCg8() {
        return this.headMemory;
    }

    /* renamed from: setHeadMemory-3GNKZMM  reason: not valid java name */
    public final void m226setHeadMemory3GNKZMM(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<set-?>");
        this.headMemory = byteBuffer;
    }

    public final int getHeadPosition() {
        return this.headPosition;
    }

    public final void setHeadPosition(int i) {
        this.headPosition = i;
    }

    public final int getHeadEndExclusive() {
        return this.headEndExclusive;
    }

    public final void setHeadEndExclusive(int i) {
        this.headEndExclusive = i;
    }

    public final long getTailRemaining() {
        return this.tailRemaining;
    }

    public final void setTailRemaining(long j) {
        if (j >= 0) {
            this.tailRemaining = j;
            return;
        }
        throw new IllegalArgumentException(("tailRemaining shouldn't be negative: " + j).toString());
    }

    public final int getHeadRemaining() {
        return getHeadEndExclusive() - getHeadPosition();
    }

    /* renamed from: peekTo-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ long m222peekTo9zorpBc$default(Input input, ByteBuffer byteBuffer, long j, long j2, long j3, long j4, int i, Object obj) {
        if (obj == null) {
            return input.m225peekTo9zorpBc(byteBuffer, j, (i & 4) != 0 ? 0 : j2, (i & 8) != 0 ? 1 : j3, (i & 16) != 0 ? Long.MAX_VALUE : j4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: peekTo-9zorpBc");
    }

    /* renamed from: peekTo-9zorpBc  reason: not valid java name */
    public final long m225peekTo9zorpBc(ByteBuffer byteBuffer, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(byteBuffer, "destination");
        prefetch$ktor_io(j3 + j2);
        ChunkBuffer head = getHead();
        long min = Math.min(j4, ((long) byteBuffer.limit()) - j);
        long j5 = j;
        ChunkBuffer chunkBuffer = head;
        long j6 = 0;
        long j7 = j2;
        while (j6 < j3 && j6 < min) {
            Buffer buffer = chunkBuffer;
            long writePosition = (long) (buffer.getWritePosition() - buffer.getReadPosition());
            if (writePosition > j7) {
                long min2 = Math.min(writePosition - j7, min - j6);
                Memory.m42copyToJT6ljtQ(chunkBuffer.m184getMemorySK3TCg8(), byteBuffer, ((long) chunkBuffer.getReadPosition()) + j7, min2, j5);
                j6 += min2;
                j5 += min2;
                j7 = 0;
            } else {
                j7 -= writePosition;
            }
            chunkBuffer = chunkBuffer.getNext();
            if (chunkBuffer == null) {
                break;
            }
        }
        return j6;
    }

    private final boolean doPrefetch(long j) {
        ChunkBuffer findTail = BuffersKt.findTail(this._head);
        long headEndExclusive2 = ((long) (getHeadEndExclusive() - getHeadPosition())) + this.tailRemaining;
        do {
            ChunkBuffer fill = fill();
            if (fill == null) {
                this.noMoreChunksAvailable = true;
                return false;
            }
            Buffer buffer = fill;
            int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
            if (findTail == ChunkBuffer.Companion.getEmpty()) {
                set_head(fill);
                findTail = fill;
            } else {
                findTail.setNext(fill);
                setTailRemaining(this.tailRemaining + ((long) writePosition));
            }
            headEndExclusive2 += (long) writePosition;
        } while (headEndExclusive2 < j);
        return true;
    }

    public final boolean canRead() {
        return (this.headPosition == this.headEndExclusive && this.tailRemaining == 0) ? false : true;
    }

    public final void release() {
        ChunkBuffer head = getHead();
        ChunkBuffer empty = ChunkBuffer.Companion.getEmpty();
        if (head != empty) {
            set_head(empty);
            setTailRemaining(0);
            BuffersKt.releaseAll(head, this.pool);
        }
    }

    public void close() {
        release();
        if (!this.noMoreChunksAvailable) {
            this.noMoreChunksAvailable = true;
        }
        closeSource();
    }

    public final ChunkBuffer stealAll$ktor_io() {
        ChunkBuffer head = getHead();
        ChunkBuffer empty = ChunkBuffer.Companion.getEmpty();
        if (head == empty) {
            return null;
        }
        set_head(empty);
        setTailRemaining(0);
        return head;
    }

    public final ChunkBuffer steal$ktor_io() {
        ChunkBuffer head = getHead();
        ChunkBuffer next = head.getNext();
        ChunkBuffer empty = ChunkBuffer.Companion.getEmpty();
        if (head == empty) {
            return null;
        }
        if (next == null) {
            set_head(empty);
            setTailRemaining(0);
        } else {
            set_head(next);
            Buffer buffer = next;
            setTailRemaining(this.tailRemaining - ((long) (buffer.getWritePosition() - buffer.getReadPosition())));
        }
        head.setNext((ChunkBuffer) null);
        return head;
    }

    public final void append$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "chain");
        if (chunkBuffer != ChunkBuffer.Companion.getEmpty()) {
            long remainingAll = BuffersKt.remainingAll(chunkBuffer);
            if (this._head == ChunkBuffer.Companion.getEmpty()) {
                set_head(chunkBuffer);
                setTailRemaining(remainingAll - ((long) (getHeadEndExclusive() - getHeadPosition())));
                return;
            }
            BuffersKt.findTail(this._head).setNext(chunkBuffer);
            setTailRemaining(this.tailRemaining + remainingAll);
        }
    }

    public final boolean tryWriteAppend$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "chain");
        ChunkBuffer findTail = BuffersKt.findTail(getHead());
        Buffer buffer = chunkBuffer;
        int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
        if (writePosition == 0) {
            return false;
        }
        Buffer buffer2 = findTail;
        if (buffer2.getLimit() - buffer2.getWritePosition() < writePosition) {
            return false;
        }
        BufferAppendKt.writeBufferAppend(buffer2, buffer, writePosition);
        if (getHead() == findTail) {
            this.headEndExclusive = findTail.getWritePosition();
            return true;
        }
        setTailRemaining(this.tailRemaining + ((long) writePosition));
        return true;
    }

    public final byte readByte() {
        int i = this.headPosition;
        int i2 = i + 1;
        if (i2 >= this.headEndExclusive) {
            return readByteSlow();
        }
        this.headPosition = i2;
        return this.headMemory.get(i);
    }

    private final byte readByteSlow() {
        int i = this.headPosition;
        if (i < this.headEndExclusive) {
            byte b = this.headMemory.get(i);
            this.headPosition = i;
            ChunkBuffer chunkBuffer = this._head;
            chunkBuffer.discardUntilIndex$ktor_io(i);
            ensureNext(chunkBuffer);
            return b;
        }
        ChunkBuffer prepareRead = prepareRead(1);
        if (prepareRead != null) {
            byte readByte = prepareRead.readByte();
            UnsafeKt.completeReadHead(this, prepareRead);
            return readByte;
        }
        StringsKt.prematureEndOfStream(1);
        throw new KotlinNothingValueException();
    }

    public final int discard(int i) {
        if (i >= 0) {
            return discardAsMuchAsPossible(i, 0);
        }
        throw new IllegalArgumentException(("Negative discard is not allowed: " + i).toString());
    }

    public final void discardExact(int i) {
        if (discard(i) != i) {
            throw new EOFException("Unable to discard " + i + " bytes due to end of packet");
        }
    }

    public final int tryPeek() {
        ChunkBuffer prepareReadLoop;
        ChunkBuffer head = getHead();
        if (getHeadEndExclusive() - getHeadPosition() > 0) {
            return head.tryPeekByte();
        }
        if ((this.tailRemaining != 0 || !this.noMoreChunksAvailable) && (prepareReadLoop = prepareReadLoop(1, head)) != null) {
            return prepareReadLoop.tryPeekByte();
        }
        return -1;
    }

    public final int peekTo(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "buffer");
        ChunkBuffer prepareReadHead$ktor_io = prepareReadHead$ktor_io(1);
        if (prepareReadHead$ktor_io == null) {
            return -1;
        }
        Buffer buffer = chunkBuffer;
        Buffer buffer2 = prepareReadHead$ktor_io;
        int min = Math.min(buffer.getLimit() - buffer.getWritePosition(), buffer2.getWritePosition() - buffer2.getReadPosition());
        BufferPrimitivesKt.writeFully(buffer, buffer2, min);
        return min;
    }

    public final long discard(long j) {
        if (j <= 0) {
            return 0;
        }
        return discardAsMuchAsPossible(j, 0);
    }

    public final int readAvailableCharacters$ktor_io(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "destination");
        if (getEndOfInput()) {
            return -1;
        }
        return readText(new Input$readAvailableCharacters$out$1(i, cArr), 0, i2);
    }

    public static /* synthetic */ int readText$default(Input input, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = Integer.MAX_VALUE;
            }
            return input.readText(appendable, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
    }

    public final int readText(Appendable appendable, int i, int i2) {
        Intrinsics.checkNotNullParameter(appendable, "out");
        if (((long) i2) < getRemaining()) {
            return readASCII(appendable, i, i2);
        }
        String readTextExactBytes$default = StringsKt.readTextExactBytes$default(this, (int) getRemaining(), (Charset) null, 2, (Object) null);
        appendable.append(readTextExactBytes$default);
        return readTextExactBytes$default.length();
    }

    public final void readTextExact(Appendable appendable, int i) {
        Intrinsics.checkNotNullParameter(appendable, "out");
        readText(appendable, i, i);
    }

    public static /* synthetic */ String readText$default(Input input, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = Integer.MAX_VALUE;
            }
            return input.readText(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
    }

    public final String readText(int i, int i2) {
        if (i == 0 && (i2 == 0 || getEndOfInput())) {
            return "";
        }
        long remaining = getRemaining();
        if (remaining > 0 && ((long) i2) >= remaining) {
            return StringsKt.readTextExactBytes$default(this, (int) remaining, (Charset) null, 2, (Object) null);
        }
        StringBuilder sb = new StringBuilder(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i, 16), i2));
        readASCII(sb, i, i2);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final String readTextExact(int i) {
        return readText(i, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
        r9.discardExact(r13 - r11);
        r4 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int readASCII(java.lang.Appendable r17, int r18, int r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r19
            r4 = 0
            if (r3 != 0) goto L_0x000e
            if (r2 != 0) goto L_0x000e
            return r4
        L_0x000e:
            boolean r5 = r16.getEndOfInput()
            if (r5 == 0) goto L_0x0020
            if (r2 != 0) goto L_0x0017
            return r4
        L_0x0017:
            r1.atLeastMinCharactersRequire(r2)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0020:
            if (r3 < r2) goto L_0x00a7
            r5 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r5)
            if (r6 != 0) goto L_0x002c
            r7 = r4
            goto L_0x0083
        L_0x002c:
            r7 = r4
            r8 = r7
        L_0x002e:
            r9 = r6
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x009f }
            java.nio.ByteBuffer r10 = r9.m184getMemorySK3TCg8()     // Catch:{ all -> 0x009f }
            int r11 = r9.getReadPosition()     // Catch:{ all -> 0x009f }
            int r12 = r9.getWritePosition()     // Catch:{ all -> 0x009f }
            r13 = r11
        L_0x003e:
            if (r13 >= r12) goto L_0x0064
            byte r14 = r10.get(r13)     // Catch:{ all -> 0x009f }
            r14 = r14 & 255(0xff, float:3.57E-43)
            r15 = r14 & 128(0x80, float:1.794E-43)
            r4 = 128(0x80, float:1.794E-43)
            if (r15 == r4) goto L_0x005e
            char r4 = (char) r14     // Catch:{ all -> 0x009f }
            if (r7 != r3) goto L_0x0051
            r4 = 0
            goto L_0x0057
        L_0x0051:
            r0.append(r4)     // Catch:{ all -> 0x009f }
            int r7 = r7 + 1
            r4 = r5
        L_0x0057:
            if (r4 != 0) goto L_0x005a
            goto L_0x005e
        L_0x005a:
            int r13 = r13 + 1
            r4 = 0
            goto L_0x003e
        L_0x005e:
            int r13 = r13 - r11
            r9.discardExact(r13)     // Catch:{ all -> 0x009f }
            r4 = 0
            goto L_0x0069
        L_0x0064:
            int r12 = r12 - r11
            r9.discardExact(r12)     // Catch:{ all -> 0x009f }
            r4 = r5
        L_0x0069:
            if (r4 == 0) goto L_0x006d
            r4 = r5
            goto L_0x0072
        L_0x006d:
            if (r7 != r3) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r8 = r5
        L_0x0071:
            r4 = 0
        L_0x0072:
            if (r4 != 0) goto L_0x0076
            r4 = r5
            goto L_0x007d
        L_0x0076:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r6)     // Catch:{ all -> 0x009c }
            if (r4 != 0) goto L_0x0099
            r4 = 0
        L_0x007d:
            if (r4 == 0) goto L_0x0082
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r6)
        L_0x0082:
            r4 = r8
        L_0x0083:
            if (r4 == 0) goto L_0x008d
            int r2 = r2 - r7
            int r3 = r3 - r7
            int r0 = r1.readUtf8(r0, r2, r3)
            int r7 = r7 + r0
            return r7
        L_0x008d:
            if (r7 < r2) goto L_0x0090
            return r7
        L_0x0090:
            r1.prematureEndOfStreamChars(r2, r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0099:
            r6 = r4
            r4 = 0
            goto L_0x002e
        L_0x009c:
            r0 = move-exception
            r4 = 0
            goto L_0x00a1
        L_0x009f:
            r0 = move-exception
            r4 = r5
        L_0x00a1:
            if (r4 == 0) goto L_0x00a6
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r6)
        L_0x00a6:
            throw r0
        L_0x00a7:
            r1.minShouldBeLess(r2, r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.readASCII(java.lang.Appendable, int, int):int");
    }

    private final Void atLeastMinCharactersRequire(int i) {
        throw new EOFException("at least " + i + " characters required but no bytes available");
    }

    private final Void minShouldBeLess(int i, int i2) {
        throw new IllegalArgumentException("min should be less or equal to max but min = " + i + ", max = " + i2);
    }

    private final Void prematureEndOfStreamChars(int i, int i2) {
        throw new MalformedUTF8InputException("Premature end of stream: expected at least " + i + " chars but had only " + i2);
    }

    private final long discardAsMuchAsPossible(long j, long j2) {
        ChunkBuffer prepareRead;
        while (j != 0 && (prepareRead = prepareRead(1)) != null) {
            Buffer buffer = prepareRead;
            int min = (int) Math.min((long) (buffer.getWritePosition() - buffer.getReadPosition()), j);
            prepareRead.discardExact(min);
            this.headPosition += min;
            afterRead(prepareRead);
            long j3 = (long) min;
            j -= j3;
            j2 += j3;
        }
        return j2;
    }

    private final int discardAsMuchAsPossible(int i, int i2) {
        while (i != 0) {
            ChunkBuffer prepareRead = prepareRead(1);
            if (prepareRead == null) {
                return i2;
            }
            Buffer buffer = prepareRead;
            int min = Math.min(buffer.getWritePosition() - buffer.getReadPosition(), i);
            prepareRead.discardExact(min);
            this.headPosition += min;
            afterRead(prepareRead);
            i -= min;
            i2 += min;
        }
        return i2;
    }

    private final int readAsMuchAsPossible(byte[] bArr, int i, int i2, int i3) {
        while (i2 != 0) {
            ChunkBuffer prepareRead = prepareRead(1);
            if (prepareRead == null) {
                return i3;
            }
            Buffer buffer = prepareRead;
            int min = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
            BufferPrimitivesKt.readFully(buffer, bArr, i, min);
            this.headPosition = prepareRead.getReadPosition();
            if (min == i2 && buffer.getWritePosition() - buffer.getReadPosition() != 0) {
                return i3 + min;
            }
            afterRead(prepareRead);
            i += min;
            i2 -= min;
            i3 += min;
        }
        return i3;
    }

    private final Void notEnoughBytesAvailable(int i) {
        throw new EOFException("Not enough data in packet (" + getRemaining() + ") to read " + i + " byte(s)");
    }

    public final ChunkBuffer prepareReadHead$ktor_io(int i) {
        return prepareReadLoop(i, getHead());
    }

    public final ChunkBuffer ensureNextHead$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "current");
        return ensureNext(chunkBuffer);
    }

    public final ChunkBuffer ensureNext(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "current");
        return ensureNext(chunkBuffer, ChunkBuffer.Companion.getEmpty());
    }

    public final void fixGapAfterRead$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "current");
        ChunkBuffer next = chunkBuffer.getNext();
        if (next == null) {
            fixGapAfterReadFallback(chunkBuffer);
            return;
        }
        Buffer buffer = chunkBuffer;
        int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
        int min = Math.min(writePosition, 8 - (buffer.getCapacity() - buffer.getLimit()));
        if (next.getStartGap() < min) {
            fixGapAfterReadFallback(chunkBuffer);
            return;
        }
        Buffer buffer2 = next;
        BufferKt.restoreStartGap(buffer2, min);
        if (writePosition > min) {
            chunkBuffer.releaseEndGap$ktor_io();
            this.headEndExclusive = chunkBuffer.getWritePosition();
            setTailRemaining(this.tailRemaining + ((long) min));
            return;
        }
        set_head(next);
        setTailRemaining(this.tailRemaining - ((long) ((buffer2.getWritePosition() - buffer2.getReadPosition()) - min)));
        chunkBuffer.cleanNext();
        chunkBuffer.release(this.pool);
    }

    private final void fixGapAfterReadFallback(ChunkBuffer chunkBuffer) {
        if (!this.noMoreChunksAvailable || chunkBuffer.getNext() != null) {
            Buffer buffer = chunkBuffer;
            int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
            int min = Math.min(writePosition, 8 - (buffer.getCapacity() - buffer.getLimit()));
            if (writePosition > min) {
                fixGapAfterReadFallbackUnreserved(chunkBuffer, writePosition, min);
            } else {
                ChunkBuffer borrow = this.pool.borrow();
                borrow.reserveEndGap(8);
                borrow.setNext(chunkBuffer.cleanNext());
                BufferAppendKt.writeBufferAppend(borrow, buffer, writePosition);
                set_head(borrow);
            }
            chunkBuffer.release(this.pool);
            return;
        }
        this.headPosition = chunkBuffer.getReadPosition();
        this.headEndExclusive = chunkBuffer.getWritePosition();
        setTailRemaining(0);
    }

    private final void fixGapAfterReadFallbackUnreserved(ChunkBuffer chunkBuffer, int i, int i2) {
        ChunkBuffer borrow = this.pool.borrow();
        ChunkBuffer borrow2 = this.pool.borrow();
        borrow.reserveEndGap(8);
        borrow2.reserveEndGap(8);
        borrow.setNext(borrow2);
        borrow2.setNext(chunkBuffer.cleanNext());
        Buffer buffer = chunkBuffer;
        BufferAppendKt.writeBufferAppend(borrow, buffer, i - i2);
        BufferAppendKt.writeBufferAppend(borrow2, buffer, i2);
        set_head(borrow);
        setTailRemaining(BuffersKt.remainingAll(borrow2));
    }

    private final ChunkBuffer ensureNext(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2) {
        while (chunkBuffer != chunkBuffer2) {
            ChunkBuffer cleanNext = chunkBuffer.cleanNext();
            chunkBuffer.release(this.pool);
            if (cleanNext == null) {
                set_head(chunkBuffer2);
                setTailRemaining(0);
                chunkBuffer = chunkBuffer2;
            } else {
                Buffer buffer = cleanNext;
                if (buffer.getWritePosition() > buffer.getReadPosition()) {
                    set_head(cleanNext);
                    setTailRemaining(this.tailRemaining - ((long) (buffer.getWritePosition() - buffer.getReadPosition())));
                    return cleanNext;
                }
                chunkBuffer = cleanNext;
            }
        }
        return doFill();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public ChunkBuffer fill() {
        ChunkBuffer borrow = this.pool.borrow();
        try {
            borrow.reserveEndGap(8);
            Buffer buffer = borrow;
            int r1 = m223fill62zg_DM(borrow.m184getMemorySK3TCg8(), borrow.getWritePosition(), buffer.getLimit() - buffer.getWritePosition());
            if (r1 == 0) {
                boolean z = true;
                this.noMoreChunksAvailable = true;
                Buffer buffer2 = borrow;
                if (buffer2.getWritePosition() <= buffer2.getReadPosition()) {
                    z = false;
                }
                if (!z) {
                    borrow.release(this.pool);
                    return null;
                }
            }
            borrow.commitWritten(r1);
            return borrow;
        } catch (Throwable th) {
            borrow.release(this.pool);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void markNoMoreChunksAvailable() {
        if (!this.noMoreChunksAvailable) {
            this.noMoreChunksAvailable = true;
        }
    }

    private final ChunkBuffer doFill() {
        if (this.noMoreChunksAvailable) {
            return null;
        }
        ChunkBuffer fill = fill();
        if (fill == null) {
            this.noMoreChunksAvailable = true;
            return null;
        }
        appendView(fill);
        return fill;
    }

    private final void appendView(ChunkBuffer chunkBuffer) {
        ChunkBuffer findTail = BuffersKt.findTail(this._head);
        if (findTail == ChunkBuffer.Companion.getEmpty()) {
            set_head(chunkBuffer);
            long j = 0;
            if (this.tailRemaining == 0) {
                ChunkBuffer next = chunkBuffer.getNext();
                if (next != null) {
                    j = BuffersKt.remainingAll(next);
                }
                setTailRemaining(j);
                return;
            }
            throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
        }
        findTail.setNext(chunkBuffer);
        setTailRemaining(this.tailRemaining + BuffersKt.remainingAll(chunkBuffer));
    }

    public final ChunkBuffer prepareRead(int i) {
        ChunkBuffer head = getHead();
        if (this.headEndExclusive - this.headPosition >= i) {
            return head;
        }
        return prepareReadLoop(i, head);
    }

    public final ChunkBuffer prepareRead(int i, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        if (this.headEndExclusive - this.headPosition >= i) {
            return chunkBuffer;
        }
        return prepareReadLoop(i, chunkBuffer);
    }

    private final Void minSizeIsTooBig(int i) {
        throw new IllegalStateException("minSize of " + i + " is too big (should be less than 8)");
    }

    private final void afterRead(ChunkBuffer chunkBuffer) {
        Buffer buffer = chunkBuffer;
        if (buffer.getWritePosition() - buffer.getReadPosition() == 0) {
            releaseHead$ktor_io(chunkBuffer);
        }
    }

    public final ChunkBuffer releaseHead$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        ChunkBuffer cleanNext = chunkBuffer.cleanNext();
        if (cleanNext == null) {
            cleanNext = ChunkBuffer.Companion.getEmpty();
        }
        set_head(cleanNext);
        Buffer buffer = cleanNext;
        setTailRemaining(this.tailRemaining - ((long) (buffer.getWritePosition() - buffer.getReadPosition())));
        chunkBuffer.release(this.pool);
        return cleanNext;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/core/Input$Companion;", "", "()V", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Input.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean getEndOfInput() {
        return getHeadEndExclusive() - getHeadPosition() == 0 && this.tailRemaining == 0 && (this.noMoreChunksAvailable || doFill() == null);
    }

    public final boolean prefetch$ktor_io(long j) {
        if (j <= 0) {
            return true;
        }
        long headEndExclusive2 = (long) (getHeadEndExclusive() - getHeadPosition());
        if (headEndExclusive2 >= j || headEndExclusive2 + this.tailRemaining >= j) {
            return true;
        }
        return doPrefetch(j);
    }

    public final long getRemaining() {
        return ((long) (getHeadEndExclusive() - getHeadPosition())) + this.tailRemaining;
    }

    public final boolean hasBytes(int i) {
        return ((long) (getHeadEndExclusive() - getHeadPosition())) + this.tailRemaining >= ((long) i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00dd, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r7.discardExact(((r12 - r10) - r15) + 1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int readUtf8(java.lang.Appendable r18, int r19, int r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r4)
            if (r5 != 0) goto L_0x0012
            r6 = 0
            goto L_0x0150
        L_0x0012:
            r7 = r4
            r8 = 0
        L_0x0014:
            r9 = r5
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x015c }
            int r10 = r9.getWritePosition()     // Catch:{ all -> 0x015c }
            int r9 = r9.getReadPosition()     // Catch:{ all -> 0x015c }
            int r10 = r10 - r9
            if (r10 < r7) goto L_0x011d
            r7 = r5
            io.ktor.utils.io.core.Buffer r7 = (io.ktor.utils.io.core.Buffer) r7     // Catch:{ all -> 0x0112 }
            java.nio.ByteBuffer r9 = r7.m184getMemorySK3TCg8()     // Catch:{ all -> 0x0112 }
            int r10 = r7.getReadPosition()     // Catch:{ all -> 0x0112 }
            int r11 = r7.getWritePosition()     // Catch:{ all -> 0x0112 }
            r12 = r10
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0035:
            r16 = -1
            if (r12 >= r11) goto L_0x00f4
            byte r6 = r9.get(r12)     // Catch:{ all -> 0x0112 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r4 = r6 & 128(0x80, float:1.794E-43)
            if (r4 != 0) goto L_0x0064
            if (r13 != 0) goto L_0x0057
            char r4 = (char) r6
            if (r8 != r3) goto L_0x004a
            r4 = 0
            goto L_0x0050
        L_0x004a:
            r0.append(r4)     // Catch:{ all -> 0x0060 }
            int r8 = r8 + 1
            r4 = 1
        L_0x0050:
            if (r4 != 0) goto L_0x00ef
            int r12 = r12 - r10
            r7.discardExact(r12)     // Catch:{ all -> 0x0060 }
            goto L_0x0086
        L_0x0057:
            io.ktor.utils.io.core.internal.UTF8Kt.malformedByteCount(r13)     // Catch:{ all -> 0x0060 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0060 }
            r0.<init>()     // Catch:{ all -> 0x0060 }
            throw r0     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r0 = move-exception
            r4 = 1
            goto L_0x0113
        L_0x0064:
            if (r13 != 0) goto L_0x008c
            r4 = 128(0x80, float:1.794E-43)
            r14 = r6
            r6 = 1
        L_0x006a:
            r15 = 7
            if (r6 >= r15) goto L_0x007a
            r15 = r14 & r4
            if (r15 == 0) goto L_0x007a
            int r15 = ~r4     // Catch:{ all -> 0x0060 }
            r14 = r14 & r15
            int r4 = r4 >> 1
            int r13 = r13 + 1
            int r6 = r6 + 1
            goto L_0x006a
        L_0x007a:
            int r4 = r13 + -1
            int r6 = r11 - r12
            if (r13 <= r6) goto L_0x0089
            int r12 = r12 - r10
            r7.discardExact(r12)     // Catch:{ all -> 0x0060 }
            r16 = r13
        L_0x0086:
            r4 = 1
            goto L_0x00fa
        L_0x0089:
            r15 = r13
            r13 = r4
            goto L_0x00ef
        L_0x008c:
            int r4 = r14 << 6
            r6 = r6 & 127(0x7f, float:1.78E-43)
            r14 = r4 | r6
            int r13 = r13 + -1
            if (r13 != 0) goto L_0x00ef
            boolean r4 = io.ktor.utils.io.core.internal.UTF8Kt.isBmpCodePoint(r14)     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x00b1
            char r4 = (char) r14     // Catch:{ all -> 0x0060 }
            if (r8 != r3) goto L_0x00a1
            r4 = 0
            goto L_0x00a7
        L_0x00a1:
            r0.append(r4)     // Catch:{ all -> 0x0060 }
            int r8 = r8 + 1
            r4 = 1
        L_0x00a7:
            if (r4 != 0) goto L_0x00da
            int r12 = r12 - r10
            int r12 = r12 - r15
            r4 = 1
            int r12 = r12 + r4
            r7.discardExact(r12)     // Catch:{ all -> 0x0060 }
            goto L_0x0086
        L_0x00b1:
            boolean r4 = io.ktor.utils.io.core.internal.UTF8Kt.isValidCodePoint(r14)     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x00e5
            int r4 = io.ktor.utils.io.core.internal.UTF8Kt.highSurrogate(r14)     // Catch:{ all -> 0x0060 }
            char r4 = (char) r4     // Catch:{ all -> 0x0060 }
            if (r8 != r3) goto L_0x00c0
            r4 = 0
            goto L_0x00c6
        L_0x00c0:
            r0.append(r4)     // Catch:{ all -> 0x0060 }
            int r8 = r8 + 1
            r4 = 1
        L_0x00c6:
            if (r4 == 0) goto L_0x00dd
            int r4 = io.ktor.utils.io.core.internal.UTF8Kt.lowSurrogate(r14)     // Catch:{ all -> 0x0060 }
            char r4 = (char) r4     // Catch:{ all -> 0x0060 }
            if (r8 != r3) goto L_0x00d1
            r4 = 0
            goto L_0x00d7
        L_0x00d1:
            r0.append(r4)     // Catch:{ all -> 0x0060 }
            int r8 = r8 + 1
            r4 = 1
        L_0x00d7:
            if (r4 != 0) goto L_0x00da
            goto L_0x00dd
        L_0x00da:
            r4 = 1
            r14 = 0
            goto L_0x00f0
        L_0x00dd:
            int r12 = r12 - r10
            int r12 = r12 - r15
            r4 = 1
            int r12 = r12 + r4
            r7.discardExact(r12)     // Catch:{ all -> 0x0112 }
            goto L_0x00fa
        L_0x00e5:
            r4 = 1
            io.ktor.utils.io.core.internal.UTF8Kt.malformedCodePoint(r14)     // Catch:{ all -> 0x0112 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0112 }
            r0.<init>()     // Catch:{ all -> 0x0112 }
            throw r0     // Catch:{ all -> 0x0112 }
        L_0x00ef:
            r4 = 1
        L_0x00f0:
            int r12 = r12 + 1
            goto L_0x0035
        L_0x00f4:
            int r11 = r11 - r10
            r7.discardExact(r11)     // Catch:{ all -> 0x0112 }
            r16 = 0
        L_0x00fa:
            if (r16 != 0) goto L_0x00fe
            r7 = r4
            goto L_0x0104
        L_0x00fe:
            if (r16 <= 0) goto L_0x0103
            r7 = r16
            goto L_0x0104
        L_0x0103:
            r7 = 0
        L_0x0104:
            r6 = r5
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x015c }
            int r9 = r6.getWritePosition()     // Catch:{ all -> 0x015c }
            int r6 = r6.getReadPosition()     // Catch:{ all -> 0x015c }
            int r10 = r9 - r6
            goto L_0x011d
        L_0x0112:
            r0 = move-exception
        L_0x0113:
            r2 = r5
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x015c }
            r2.getWritePosition()     // Catch:{ all -> 0x015c }
            r2.getReadPosition()     // Catch:{ all -> 0x015c }
            throw r0     // Catch:{ all -> 0x015c }
        L_0x011d:
            if (r10 != 0) goto L_0x0127
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch:{ all -> 0x0124 }
            goto L_0x0143
        L_0x0124:
            r0 = move-exception
            r4 = 0
            goto L_0x015d
        L_0x0127:
            if (r10 < r7) goto L_0x013c
            r6 = r5
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x0124 }
            int r9 = r6.getCapacity()     // Catch:{ all -> 0x0124 }
            int r6 = r6.getLimit()     // Catch:{ all -> 0x0124 }
            int r9 = r9 - r6
            r6 = 8
            if (r9 >= r6) goto L_0x013a
            goto L_0x013c
        L_0x013a:
            r6 = r5
            goto L_0x0143
        L_0x013c:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)     // Catch:{ all -> 0x0124 }
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r7)     // Catch:{ all -> 0x0124 }
        L_0x0143:
            if (r6 != 0) goto L_0x0147
            r4 = 0
            goto L_0x014a
        L_0x0147:
            r5 = r6
            if (r7 > 0) goto L_0x0014
        L_0x014a:
            if (r4 == 0) goto L_0x014f
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x014f:
            r6 = r8
        L_0x0150:
            if (r6 < r2) goto L_0x0153
            return r6
        L_0x0153:
            r1.prematureEndOfStreamChars(r2, r6)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x015c:
            r0 = move-exception
        L_0x015d:
            if (r4 == 0) goto L_0x0162
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L_0x0162:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.readUtf8(java.lang.Appendable, int, int):int");
    }

    private final ChunkBuffer prepareReadLoop(int i, ChunkBuffer chunkBuffer) {
        while (true) {
            int headEndExclusive2 = getHeadEndExclusive() - getHeadPosition();
            if (headEndExclusive2 >= i) {
                return chunkBuffer;
            }
            ChunkBuffer next = chunkBuffer.getNext();
            if (next == null && (next = doFill()) == null) {
                return null;
            }
            if (headEndExclusive2 == 0) {
                if (chunkBuffer != ChunkBuffer.Companion.getEmpty()) {
                    releaseHead$ktor_io(chunkBuffer);
                }
                chunkBuffer = next;
            } else {
                Buffer buffer = chunkBuffer;
                Buffer buffer2 = next;
                int writeBufferAppend = BufferAppendKt.writeBufferAppend(buffer, buffer2, i - headEndExclusive2);
                this.headEndExclusive = chunkBuffer.getWritePosition();
                setTailRemaining(this.tailRemaining - ((long) writeBufferAppend));
                if (!(buffer2.getWritePosition() > buffer2.getReadPosition())) {
                    chunkBuffer.setNext((ChunkBuffer) null);
                    chunkBuffer.setNext(next.cleanNext());
                    next.release(this.pool);
                } else {
                    next.reserveStartGap(writeBufferAppend);
                }
                if (buffer.getWritePosition() - buffer.getReadPosition() >= i) {
                    return chunkBuffer;
                }
                if (i > 8) {
                    minSizeIsTooBig(i);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }
}
