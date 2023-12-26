package io.ktor.utils.io.core;

import com.wushuangtech.library.GlobalVideoConfig;
import io.agora.rtc.Constants;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.ChunkBufferKt;
import io.ktor.utils.io.core.internal.NumbersKt;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b&\u0018\u00002\u00060\u0001j\u0002`\u00022\u00060\u0003j\u0002`\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020(H\u0001J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-H\u0016J\"\u0010+\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fJ\u0012\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u000102H\u0016J\"\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0016J\u0015\u00105\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\bH\u0000¢\u0006\u0002\b6J \u00107\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\fH\u0002J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020\bH\u0002J\u0015\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\bH\u0000¢\u0006\u0002\b?J\u0006\u0010@\u001a\u00020(J\b\u0010A\u001a\u00020(H$J\u0006\u0010B\u001a\u00020(J-\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\fH$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020(H\u0002J\u0015\u0010I\u001a\u00020(2\u0006\u0010>\u001a\u00020\bH\u0010¢\u0006\u0002\bJJ\u0010\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\fH\u0001J\u0006\u0010M\u001a\u00020(J\u000f\u0010N\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bOJ(\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\f0SH\bø\u0001\u0003J\u000e\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020WJ\u0010\u0010X\u001a\u00020(2\u0006\u0010V\u001a\u00020WH\u0002J\u0015\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020\bH\u0000¢\u0006\u0002\b[J\u000e\u0010\\\u001a\u00020(2\u0006\u0010]\u001a\u00020^J\u0016\u0010\\\u001a\u00020(2\u0006\u0010_\u001a\u00020^2\u0006\u0010L\u001a\u00020\fJ\u0016\u0010\\\u001a\u00020(2\u0006\u0010_\u001a\u00020^2\u0006\u0010L\u001a\u00020`J&\u0010a\u001a\u00020(2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0018\u0010d\u001a\u00020(2\u0006\u0010c\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8DX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R%\u0010\u001b\u001a\u00020\u001cX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0019R\u0015\u0010%\u001a\u00020\f8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000e\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006e"}, d2 = {"Lio/ktor/utils/io/core/Output;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "()V", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "_head", "_size", "", "get_size", "()I", "_tail", "chainedSize", "head", "getHead$ktor_io", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "tailEndExclusive", "getTailEndExclusive$ktor_io", "setTailEndExclusive$ktor_io", "(I)V", "tailInitialPosition", "tailMemory", "Lio/ktor/utils/io/bits/Memory;", "getTailMemory-SK3TCg8$ktor_io", "()Ljava/nio/ByteBuffer;", "setTailMemory-3GNKZMM$ktor_io", "(Ljava/nio/ByteBuffer;)V", "Ljava/nio/ByteBuffer;", "tailPosition", "getTailPosition$ktor_io", "setTailPosition$ktor_io", "tailRemaining", "getTailRemaining$ktor_io", "afterBytesStolen", "", "afterBytesStolen$ktor_io", "afterHeadWrite", "append", "value", "", "csq", "", "start", "end", "", "startIndex", "endIndex", "appendChain", "appendChain$ktor_io", "appendChainImpl", "newTail", "chainedSizeDelta", "appendCharFallback", "c", "appendNewChunk", "appendSingleChunk", "buffer", "appendSingleChunk$ktor_io", "close", "closeDestination", "flush", "source", "offset", "length", "flush-62zg_DM", "(Ljava/nio/ByteBuffer;II)V", "flushChain", "last", "last$ktor_io", "prepareWriteHead", "n", "release", "stealAll", "stealAll$ktor_io", "write", "size", "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "writeByte", "v", "", "writeByteFallback", "writeChunkBuffer", "chunkBuffer", "writeChunkBuffer$ktor_io", "writePacket", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "p", "", "writePacketMerging", "tail", "foreignStolen", "writePacketSlowPrepend", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Output.kt */
public abstract class Output implements Appendable, Closeable {
    private ChunkBuffer _head;
    private ChunkBuffer _tail;
    private int chainedSize;
    private final ObjectPool<ChunkBuffer> pool;
    private int tailEndExclusive;
    private int tailInitialPosition;
    private ByteBuffer tailMemory;
    private int tailPosition;

    /* access modifiers changed from: protected */
    public abstract void closeDestination();

    /* access modifiers changed from: protected */
    /* renamed from: flush-62zg_DM  reason: not valid java name */
    public abstract void m255flush62zg_DM(ByteBuffer byteBuffer, int i, int i2);

    public Output(ObjectPool<ChunkBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.pool = objectPool;
        this.tailMemory = Memory.Companion.m56getEmptySK3TCg8();
    }

    /* access modifiers changed from: protected */
    public final ObjectPool<ChunkBuffer> getPool() {
        return this.pool;
    }

    public Output() {
        this(ChunkBuffer.Companion.getPool());
    }

    /* access modifiers changed from: protected */
    public final int get_size() {
        return this.chainedSize + (this.tailPosition - this.tailInitialPosition);
    }

    public final ChunkBuffer getHead$ktor_io() {
        ChunkBuffer chunkBuffer = this._head;
        return chunkBuffer == null ? ChunkBuffer.Companion.getEmpty() : chunkBuffer;
    }

    /* renamed from: getTailMemory-SK3TCg8$ktor_io  reason: not valid java name */
    public final ByteBuffer m256getTailMemorySK3TCg8$ktor_io() {
        return this.tailMemory;
    }

    /* renamed from: setTailMemory-3GNKZMM$ktor_io  reason: not valid java name */
    public final void m257setTailMemory3GNKZMM$ktor_io(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<set-?>");
        this.tailMemory = byteBuffer;
    }

    public final int getTailPosition$ktor_io() {
        return this.tailPosition;
    }

    public final void setTailPosition$ktor_io(int i) {
        this.tailPosition = i;
    }

    public final int getTailEndExclusive$ktor_io() {
        return this.tailEndExclusive;
    }

    public final void setTailEndExclusive$ktor_io(int i) {
        this.tailEndExclusive = i;
    }

    public final int getTailRemaining$ktor_io() {
        return getTailEndExclusive$ktor_io() - getTailPosition$ktor_io();
    }

    public final void flush() {
        flushChain();
    }

    private final void flushChain() {
        ChunkBuffer stealAll$ktor_io = stealAll$ktor_io();
        if (stealAll$ktor_io != null) {
            ChunkBuffer chunkBuffer = stealAll$ktor_io;
            do {
                try {
                    Buffer buffer = chunkBuffer;
                    m255flush62zg_DM(chunkBuffer.m184getMemorySK3TCg8(), chunkBuffer.getReadPosition(), buffer.getWritePosition() - buffer.getReadPosition());
                    chunkBuffer = chunkBuffer.getNext();
                } finally {
                    BuffersKt.releaseAll(stealAll$ktor_io, this.pool);
                }
            } while (chunkBuffer != null);
        }
    }

    public final ChunkBuffer stealAll$ktor_io() {
        ChunkBuffer chunkBuffer = this._head;
        if (chunkBuffer == null) {
            return null;
        }
        ChunkBuffer chunkBuffer2 = this._tail;
        if (chunkBuffer2 != null) {
            chunkBuffer2.commitWrittenUntilIndex(this.tailPosition);
        }
        this._head = null;
        this._tail = null;
        this.tailPosition = 0;
        this.tailEndExclusive = 0;
        this.tailInitialPosition = 0;
        this.chainedSize = 0;
        this.tailMemory = Memory.Companion.m56getEmptySK3TCg8();
        return chunkBuffer;
    }

    public final void appendSingleChunk$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "buffer");
        if (chunkBuffer.getNext() == null) {
            appendChainImpl(chunkBuffer, chunkBuffer, 0);
            return;
        }
        throw new IllegalStateException("It should be a single buffer chunk.".toString());
    }

    public final void appendChain$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        ChunkBuffer findTail = BuffersKt.findTail(chunkBuffer);
        Buffer buffer = findTail;
        long remainingAll = BuffersKt.remainingAll(chunkBuffer) - ((long) (buffer.getWritePosition() - buffer.getReadPosition()));
        if (remainingAll < 2147483647L) {
            appendChainImpl(chunkBuffer, findTail, (int) remainingAll);
        } else {
            NumbersKt.failLongToIntConversion(remainingAll, "total size increase");
            throw new KotlinNothingValueException();
        }
    }

    private final ChunkBuffer appendNewChunk() {
        ChunkBuffer borrow = this.pool.borrow();
        borrow.reserveEndGap(8);
        appendSingleChunk$ktor_io(borrow);
        return borrow;
    }

    private final void appendChainImpl(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, int i) {
        ChunkBuffer chunkBuffer3 = this._tail;
        if (chunkBuffer3 == null) {
            this._head = chunkBuffer;
            this.chainedSize = 0;
        } else {
            chunkBuffer3.setNext(chunkBuffer);
            int i2 = this.tailPosition;
            chunkBuffer3.commitWrittenUntilIndex(i2);
            this.chainedSize += i2 - this.tailInitialPosition;
        }
        this._tail = chunkBuffer2;
        this.chainedSize += i;
        this.tailMemory = chunkBuffer2.m184getMemorySK3TCg8();
        this.tailPosition = chunkBuffer2.getWritePosition();
        this.tailInitialPosition = chunkBuffer2.getReadPosition();
        this.tailEndExclusive = chunkBuffer2.getLimit();
    }

    public final void writeByte(byte b) {
        int i = this.tailPosition;
        if (i < this.tailEndExclusive) {
            this.tailPosition = i + 1;
            this.tailMemory.put(i, b);
            return;
        }
        writeByteFallback(b);
    }

    private final void writeByteFallback(byte b) {
        appendNewChunk().writeByte(b);
        this.tailPosition++;
    }

    public final void close() {
        try {
            flush();
        } finally {
            closeDestination();
        }
    }

    public Output append(char c) {
        int i = this.tailPosition;
        int i2 = 3;
        if (this.tailEndExclusive - i >= 3) {
            ByteBuffer byteBuffer = this.tailMemory;
            boolean z = true;
            if (c >= 0 && c < 128) {
                byteBuffer.put(i, (byte) c);
                i2 = 1;
            } else {
                if (128 <= c && c < 2048) {
                    byteBuffer.put(i, (byte) (((c >> 6) & 31) | 192));
                    byteBuffer.put(i + 1, (byte) ((c & '?') | 128));
                    i2 = 2;
                } else {
                    if (2048 <= c && c < 0) {
                        byteBuffer.put(i, (byte) (((c >> 12) & 15) | 224));
                        byteBuffer.put(i + 1, (byte) (((c >> 6) & 63) | Constants.ERR_WATERMARK_ARGB));
                        byteBuffer.put(i + 2, (byte) ((c & '?') | 128));
                    } else {
                        if (0 > c || c >= 0) {
                            z = false;
                        }
                        if (z) {
                            byteBuffer.put(i, (byte) (((c >> 18) & 7) | GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH));
                            byteBuffer.put(i + 1, (byte) (((c >> 12) & 63) | Constants.ERR_WATERMARK_ARGB));
                            byteBuffer.put(i + 2, (byte) (((c >> 6) & 63) | Constants.ERR_WATERMARK_ARGB));
                            byteBuffer.put(i + 3, (byte) ((c & '?') | 128));
                            i2 = 4;
                        } else {
                            UTF8Kt.malformedCodePoint(c);
                            throw new KotlinNothingValueException();
                        }
                    }
                }
            }
            this.tailPosition = i + i2;
            return this;
        }
        appendCharFallback(c);
        return this;
    }

    public Output append(CharSequence charSequence) {
        if (charSequence == null) {
            append((CharSequence) "null", 0, 4);
        } else {
            append(charSequence, 0, charSequence.length());
        }
        return this;
    }

    public Output append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return append((CharSequence) "null", i, i2);
        }
        StringsKt.writeText(this, charSequence, i, i2, Charsets.UTF_8);
        return this;
    }

    public final void writePacket(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        ChunkBuffer stealAll$ktor_io = byteReadPacket.stealAll$ktor_io();
        if (stealAll$ktor_io == null) {
            byteReadPacket.release();
            return;
        }
        ChunkBuffer chunkBuffer = this._tail;
        if (chunkBuffer == null) {
            appendChain$ktor_io(stealAll$ktor_io);
        } else {
            writePacketMerging(chunkBuffer, stealAll$ktor_io, byteReadPacket.getPool());
        }
    }

    public final void writeChunkBuffer$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "chunkBuffer");
        ChunkBuffer chunkBuffer2 = this._tail;
        if (chunkBuffer2 == null) {
            appendChain$ktor_io(chunkBuffer);
        } else {
            writePacketMerging(chunkBuffer2, chunkBuffer, this.pool);
        }
    }

    private final void writePacketMerging(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, ObjectPool<ChunkBuffer> objectPool) {
        chunkBuffer.commitWrittenUntilIndex(this.tailPosition);
        Buffer buffer = chunkBuffer;
        int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
        Buffer buffer2 = chunkBuffer2;
        int writePosition2 = buffer2.getWritePosition() - buffer2.getReadPosition();
        int packet_max_copy_size = PacketJVMKt.getPACKET_MAX_COPY_SIZE();
        if (writePosition2 >= packet_max_copy_size || writePosition2 > (buffer.getCapacity() - buffer.getLimit()) + (buffer.getLimit() - buffer.getWritePosition())) {
            writePosition2 = -1;
        }
        if (writePosition >= packet_max_copy_size || writePosition > chunkBuffer2.getStartGap() || !ChunkBufferKt.isExclusivelyOwned(chunkBuffer2)) {
            writePosition = -1;
        }
        if (writePosition2 == -1 && writePosition == -1) {
            appendChain$ktor_io(chunkBuffer2);
        } else if (writePosition == -1 || writePosition2 <= writePosition) {
            BufferAppendKt.writeBufferAppend(buffer, buffer2, (buffer.getLimit() - buffer.getWritePosition()) + (buffer.getCapacity() - buffer.getLimit()));
            afterHeadWrite();
            ChunkBuffer cleanNext = chunkBuffer2.cleanNext();
            if (cleanNext != null) {
                appendChain$ktor_io(cleanNext);
            }
            chunkBuffer2.release(objectPool);
        } else if (writePosition2 == -1 || writePosition < writePosition2) {
            writePacketSlowPrepend(chunkBuffer2, chunkBuffer);
        } else {
            throw new IllegalStateException("prep = " + writePosition + ", app = " + writePosition2);
        }
    }

    private final void writePacketSlowPrepend(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2) {
        BufferAppendKt.writeBufferPrepend(chunkBuffer, chunkBuffer2);
        ChunkBuffer chunkBuffer3 = this._head;
        if (chunkBuffer3 != null) {
            if (chunkBuffer3 == chunkBuffer2) {
                this._head = chunkBuffer;
            } else {
                while (true) {
                    ChunkBuffer next = chunkBuffer3.getNext();
                    Intrinsics.checkNotNull(next);
                    if (next == chunkBuffer2) {
                        break;
                    }
                    chunkBuffer3 = next;
                }
                chunkBuffer3.setNext(chunkBuffer);
            }
            chunkBuffer2.release(this.pool);
            this._tail = BuffersKt.findTail(chunkBuffer);
            return;
        }
        throw new IllegalStateException("head should't be null since it is already handled in the fast-path".toString());
    }

    public final void writePacket(ByteReadPacket byteReadPacket, int i) {
        int readPosition;
        int writePosition;
        Intrinsics.checkNotNullParameter(byteReadPacket, "p");
        while (i > 0) {
            Input input = byteReadPacket;
            int headEndExclusive = input.getHeadEndExclusive() - input.getHeadPosition();
            if (headEndExclusive <= i) {
                i -= headEndExclusive;
                ChunkBuffer steal$ktor_io = byteReadPacket.steal$ktor_io();
                if (steal$ktor_io != null) {
                    appendSingleChunk$ktor_io(steal$ktor_io);
                } else {
                    throw new EOFException("Unexpected end of packet");
                }
            } else {
                ChunkBuffer prepareRead = input.prepareRead(1);
                if (prepareRead != null) {
                    int readPosition2 = prepareRead.getReadPosition();
                    try {
                        OutputKt.writeFully(this, prepareRead, i);
                        if (readPosition < readPosition2) {
                            throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                        } else if (readPosition != writePosition) {
                            input.setHeadPosition(readPosition);
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        readPosition = prepareRead.getReadPosition();
                        if (readPosition >= readPosition2) {
                            if (readPosition == prepareRead.getWritePosition()) {
                                input.ensureNext(prepareRead);
                            } else {
                                input.setHeadPosition(readPosition);
                            }
                            throw th;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                } else {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    public final void writePacket(ByteReadPacket byteReadPacket, long j) {
        int readPosition;
        int writePosition;
        Intrinsics.checkNotNullParameter(byteReadPacket, "p");
        while (j > 0) {
            Input input = byteReadPacket;
            long headEndExclusive = (long) (input.getHeadEndExclusive() - input.getHeadPosition());
            if (headEndExclusive <= j) {
                j -= headEndExclusive;
                ChunkBuffer steal$ktor_io = byteReadPacket.steal$ktor_io();
                if (steal$ktor_io != null) {
                    appendSingleChunk$ktor_io(steal$ktor_io);
                } else {
                    throw new EOFException("Unexpected end of packet");
                }
            } else {
                ChunkBuffer prepareRead = input.prepareRead(1);
                if (prepareRead != null) {
                    int readPosition2 = prepareRead.getReadPosition();
                    try {
                        OutputKt.writeFully(this, prepareRead, (int) j);
                        if (readPosition < readPosition2) {
                            throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                        } else if (readPosition != writePosition) {
                            input.setHeadPosition(readPosition);
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        readPosition = prepareRead.getReadPosition();
                        if (readPosition >= readPosition2) {
                            if (readPosition == prepareRead.getWritePosition()) {
                                input.ensureNext(prepareRead);
                            } else {
                                input.setHeadPosition(readPosition);
                            }
                            throw th;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                } else {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    public final Appendable append(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "csq");
        StringsKt.writeText(this, cArr, i, i2, Charsets.UTF_8);
        return this;
    }

    public final void release() {
        close();
    }

    public final void afterHeadWrite() {
        ChunkBuffer chunkBuffer = this._tail;
        if (chunkBuffer != null) {
            this.tailPosition = chunkBuffer.getWritePosition();
        }
    }

    public final int write(int i, Function1<? super Buffer, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            int intValue = ((Number) function1.invoke(prepareWriteHead(i))).intValue();
            if (intValue >= 0) {
                return intValue;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            InlineMarker.finallyStart(1);
            afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    public void last$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "buffer");
        appendSingleChunk$ktor_io(chunkBuffer);
    }

    public final void afterBytesStolen$ktor_io() {
        ChunkBuffer head$ktor_io = getHead$ktor_io();
        if (head$ktor_io != ChunkBuffer.Companion.getEmpty()) {
            if (head$ktor_io.getNext() == null) {
                head$ktor_io.resetForWrite();
                head$ktor_io.reserveEndGap(8);
                int writePosition = head$ktor_io.getWritePosition();
                this.tailPosition = writePosition;
                this.tailInitialPosition = writePosition;
                this.tailEndExclusive = head$ktor_io.getLimit();
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    private final void appendCharFallback(char c) {
        int i = 3;
        try {
            Buffer prepareWriteHead = prepareWriteHead(3);
            ByteBuffer r2 = prepareWriteHead.m184getMemorySK3TCg8();
            int writePosition = prepareWriteHead.getWritePosition();
            boolean z = true;
            if (c >= 0 && c < 128) {
                r2.put(writePosition, (byte) c);
                i = 1;
            } else {
                if (128 <= c && c < 2048) {
                    r2.put(writePosition, (byte) (((c >> 6) & 31) | 192));
                    r2.put(writePosition + 1, (byte) ((c & '?') | 128));
                    i = 2;
                } else {
                    if (2048 <= c && c < 0) {
                        r2.put(writePosition, (byte) (((c >> 12) & 15) | 224));
                        r2.put(writePosition + 1, (byte) (((c >> 6) & 63) | Constants.ERR_WATERMARK_ARGB));
                        r2.put(writePosition + 2, (byte) ((c & '?') | 128));
                    } else {
                        if (0 <= c && c < 0) {
                            r2.put(writePosition, (byte) (((c >> 18) & 7) | GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH));
                            r2.put(writePosition + 1, (byte) (((c >> 12) & 63) | Constants.ERR_WATERMARK_ARGB));
                            r2.put(writePosition + 2, (byte) (((c >> 6) & 63) | Constants.ERR_WATERMARK_ARGB));
                            r2.put(writePosition + 3, (byte) ((c & '?') | 128));
                            i = 4;
                        } else {
                            UTF8Kt.malformedCodePoint(c);
                            throw new KotlinNothingValueException();
                        }
                    }
                }
            }
            prepareWriteHead.commitWritten(i);
            if (i < 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("The returned value shouldn't be negative".toString());
            }
        } finally {
            afterHeadWrite();
        }
    }

    public final ChunkBuffer prepareWriteHead(int i) {
        ChunkBuffer chunkBuffer;
        if (getTailEndExclusive$ktor_io() - getTailPosition$ktor_io() < i || (chunkBuffer = this._tail) == null) {
            return appendNewChunk();
        }
        chunkBuffer.commitWrittenUntilIndex(this.tailPosition);
        return chunkBuffer;
    }
}
