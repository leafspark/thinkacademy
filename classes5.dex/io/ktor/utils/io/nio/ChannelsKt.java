package io.ktor.utils.io.nio;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0010\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u0011\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002\u001a3\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0007\u001a%\u0010\u001a\u001a\u0004\u0018\u00010\f*\u00020\u00152\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c¢\u0006\u0002\b\u001f\u001a\u0012\u0010\u001a\u001a\u00020 *\u00020\u00152\u0006\u0010!\u001a\u00020\f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"read", "", "Ljava/nio/channels/ReadableByteChannel;", "destination", "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", "maxLength", "read-UAd2zVI", "(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;II)I", "buffer", "Lio/ktor/utils/io/core/Buffer;", "readPacketAtLeast", "Lio/ktor/utils/io/core/ByteReadPacket;", "n", "", "readPacketAtMost", "readPacketExact", "readPacketImpl", "min", "max", "write", "Ljava/nio/channels/WritableByteChannel;", "source", "sourceOffset", "write-UAd2zVI", "(Ljava/nio/channels/WritableByteChannel;Ljava/nio/ByteBuffer;II)I", "writePacket", "builder", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "", "Lkotlin/ExtensionFunctionType;", "", "p", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Channels.kt */
public final class ChannelsKt {
    public static final boolean writePacket(WritableByteChannel writableByteChannel, ByteReadPacket byteReadPacket) {
        Input input;
        ChunkBuffer prepareRead;
        int readPosition;
        int write;
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(byteReadPacket, "p");
        do {
            try {
                input = byteReadPacket;
                prepareRead = input.prepareRead(1);
                if (prepareRead != null) {
                    readPosition = prepareRead.getReadPosition();
                    Buffer buffer = prepareRead;
                    ByteBuffer r6 = buffer.m184getMemorySK3TCg8();
                    int readPosition2 = buffer.getReadPosition();
                    int writePosition = buffer.getWritePosition() - readPosition2;
                    ByteBuffer r62 = Memory.m50slice87lwejk(r6, readPosition2, writePosition);
                    write = writableByteChannel.write(r62);
                    if (r62.limit() == writePosition) {
                        buffer.discardExact(r62.position());
                        int readPosition3 = prepareRead.getReadPosition();
                        if (readPosition3 >= readPosition) {
                            if (readPosition3 == prepareRead.getWritePosition()) {
                                input.ensureNext(prepareRead);
                            } else {
                                input.setHeadPosition(readPosition3);
                            }
                            if (byteReadPacket.getEndOfInput()) {
                                return true;
                            }
                        } else {
                            throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                        }
                    } else {
                        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                    }
                } else {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                byteReadPacket.release();
                throw th;
            }
        } while (write != 0);
        return false;
    }

    public static final ByteReadPacket readPacketExact(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, j, j);
    }

    public static final ByteReadPacket readPacketAtLeast(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, j, HttpTimeout.INFINITE_TIMEOUT_MS);
    }

    public static final ByteReadPacket readPacketAtMost(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, 1, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e6, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064 A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0067 A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076 A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089 A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0106 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final io.ktor.utils.io.core.ByteReadPacket readPacketImpl(java.nio.channels.ReadableByteChannel r18, long r19, long r21) {
        /*
            r0 = r19
            r2 = r21
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x000c
            r9 = 1
            goto L_0x000d
        L_0x000c:
            r9 = 0
        L_0x000d:
            if (r9 == 0) goto L_0x0154
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 > 0) goto L_0x0015
            r9 = 1
            goto L_0x0016
        L_0x0015:
            r9 = 0
        L_0x0016:
            if (r9 == 0) goto L_0x0131
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x0023
            io.ktor.utils.io.core.ByteReadPacket$Companion r0 = io.ktor.utils.io.core.ByteReadPacket.Companion
            io.ktor.utils.io.core.ByteReadPacket r0 = r0.getEmpty()
            return r0
        L_0x0023:
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r9 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.pool.ObjectPool r9 = r9.getPool()
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r10 = io.ktor.utils.io.core.internal.ChunkBuffer.Companion
            io.ktor.utils.io.core.internal.ChunkBuffer r10 = r10.getEmpty()
            r11 = r10
            r12 = r11
        L_0x0031:
            int r13 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r13 < 0) goto L_0x0040
            if (r13 != 0) goto L_0x003a
            if (r6 != 0) goto L_0x003a
            goto L_0x0040
        L_0x003a:
            io.ktor.utils.io.core.ByteReadPacket r0 = new io.ktor.utils.io.core.ByteReadPacket
            r0.<init>(r11, r9)
            return r0
        L_0x0040:
            long r13 = r2 - r4
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r7 = kotlin.ranges.RangesKt.coerceAtMost(r13, r7)     // Catch:{ all -> 0x012a }
            int r7 = (int) r7     // Catch:{ all -> 0x012a }
            r8 = r12
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x012a }
            int r13 = r8.getLimit()     // Catch:{ all -> 0x012a }
            int r8 = r8.getWritePosition()     // Catch:{ all -> 0x012a }
            int r13 = r13 - r8
            r8 = 200(0xc8, float:2.8E-43)
            if (r13 > r8) goto L_0x005f
            if (r13 < r7) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r8 = 0
            goto L_0x0060
        L_0x005f:
            r8 = 1
        L_0x0060:
            if (r8 == 0) goto L_0x0064
            r8 = r12
            goto L_0x0065
        L_0x0064:
            r8 = 0
        L_0x0065:
            if (r8 != 0) goto L_0x0074
            java.lang.Object r8 = r9.borrow()     // Catch:{ all -> 0x012a }
            r13 = r8
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = (io.ktor.utils.io.core.internal.ChunkBuffer) r13     // Catch:{ all -> 0x012a }
            if (r11 != r10) goto L_0x0072
            r11 = r13
            r12 = r11
        L_0x0072:
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = (io.ktor.utils.io.core.internal.ChunkBuffer) r8     // Catch:{ all -> 0x012a }
        L_0x0074:
            if (r12 == r8) goto L_0x007a
            r12.setNext(r8)     // Catch:{ all -> 0x012a }
            r12 = r8
        L_0x007a:
            r13 = r8
            io.ktor.utils.io.core.Buffer r13 = (io.ktor.utils.io.core.Buffer) r13     // Catch:{ all -> 0x012a }
            int r14 = r13.getLimit()     // Catch:{ all -> 0x012a }
            int r13 = r13.getWritePosition()     // Catch:{ all -> 0x012a }
            int r14 = r14 - r13
            r13 = 1
            if (r13 > r14) goto L_0x008b
            r13 = 1
            goto L_0x008c
        L_0x008b:
            r13 = 0
        L_0x008c:
            if (r13 == 0) goto L_0x0106
            java.nio.ByteBuffer r13 = r8.m184getMemorySK3TCg8()     // Catch:{ all -> 0x012a }
            java.nio.ByteBuffer r13 = r13.duplicate()     // Catch:{ all -> 0x012a }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ all -> 0x012a }
            int r15 = r8.getWritePosition()     // Catch:{ all -> 0x012a }
            r16 = r6
            int r6 = r8.getLimit()     // Catch:{ all -> 0x012a }
            r13.limit(r6)     // Catch:{ all -> 0x012a }
            r13.position(r15)     // Catch:{ all -> 0x012a }
            int r6 = r13.limit()     // Catch:{ all -> 0x012a }
            r17 = r10
            int r10 = r13.remaining()     // Catch:{ all -> 0x012a }
            if (r10 <= r7) goto L_0x00bd
            int r10 = r13.position()     // Catch:{ all -> 0x012a }
            int r10 = r10 + r7
            r13.limit(r10)     // Catch:{ all -> 0x012a }
        L_0x00bd:
            r7 = r18
            int r10 = r7.read(r13)     // Catch:{ all -> 0x012a }
            r7 = -1
            if (r10 == r7) goto L_0x00e7
            r13.limit(r6)     // Catch:{ all -> 0x012a }
            long r6 = (long) r10     // Catch:{ all -> 0x012a }
            long r4 = r4 + r6
            int r6 = r13.position()     // Catch:{ all -> 0x012a }
            int r6 = r6 - r15
            if (r6 < 0) goto L_0x00dd
            if (r6 > r14) goto L_0x00dd
            r8.commitWritten(r6)     // Catch:{ all -> 0x012a }
            r6 = r16
            r10 = r17
            goto L_0x0031
        L_0x00dd:
            r0 = 1
            io.ktor.utils.io.internal.jvm.ErrorsKt.wrongBufferPositionChangeError(r6, r0)     // Catch:{ all -> 0x012a }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x012a }
            r0.<init>()     // Catch:{ all -> 0x012a }
            throw r0     // Catch:{ all -> 0x012a }
        L_0x00e7:
            java.io.EOFException r2 = new java.io.EOFException     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r3.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r6 = "Premature end of stream: was read "
            r3.append(r6)     // Catch:{ all -> 0x012a }
            r3.append(r4)     // Catch:{ all -> 0x012a }
            java.lang.String r4 = " bytes of "
            r3.append(r4)     // Catch:{ all -> 0x012a }
            r3.append(r0)     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x012a }
            r2.<init>(r0)     // Catch:{ all -> 0x012a }
            throw r2     // Catch:{ all -> 0x012a }
        L_0x0106:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r0.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r1 = "size "
            r0.append(r1)     // Catch:{ all -> 0x012a }
            r1 = 1
            r0.append(r1)     // Catch:{ all -> 0x012a }
            java.lang.String r1 = " is greater than buffer's remaining capacity "
            r0.append(r1)     // Catch:{ all -> 0x012a }
            r0.append(r14)     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x012a }
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x012a }
            r1.<init>(r0)     // Catch:{ all -> 0x012a }
            throw r1     // Catch:{ all -> 0x012a }
        L_0x012a:
            r0 = move-exception
            io.ktor.utils.io.core.internal.ChunkBuffer r11 = (io.ktor.utils.io.core.internal.ChunkBuffer) r11
            io.ktor.utils.io.core.BuffersKt.releaseAll(r11, r9)
            throw r0
        L_0x0131:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "min shouldn't be greater than max: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = " > "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0154:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "min shouldn't be negative: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.nio.ChannelsKt.readPacketImpl(java.nio.channels.ReadableByteChannel, long, long):io.ktor.utils.io.core.ByteReadPacket");
    }

    /* renamed from: read-UAd2zVI  reason: not valid java name */
    public static final int m310readUAd2zVI(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "$this$read");
        Intrinsics.checkNotNullParameter(byteBuffer, "destination");
        return readableByteChannel.read(MemoryJvmKt.sliceSafe(byteBuffer, i, i2));
    }

    /* renamed from: write-UAd2zVI  reason: not valid java name */
    public static final int m312writeUAd2zVI(WritableByteChannel writableByteChannel, ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(writableByteChannel, "$this$write");
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        return writableByteChannel.write(MemoryJvmKt.sliceSafe(byteBuffer, i, i2));
    }

    public static final ByteReadPacket writePacket(WritableByteChannel writableByteChannel, Function1<? super BytePacketBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builder");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            function1.invoke(bytePacketBuilder);
            ByteReadPacket build = bytePacketBuilder.build();
            try {
                if (writePacket(writableByteChannel, build)) {
                    return null;
                }
                return build;
            } catch (Throwable th) {
                build.release();
                throw th;
            }
        } catch (Throwable th2) {
            bytePacketBuilder.release();
            throw th2;
        }
    }

    @Deprecated(message = "Use read(Memory) instead.")
    public static final int read(ReadableByteChannel readableByteChannel, Buffer buffer) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.getLimit() - buffer.getWritePosition() == 0) {
            return 0;
        }
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int read = readableByteChannel.read(MemoryJvmKt.sliceSafe(r0, writePosition, buffer.getLimit() - writePosition));
        if (read == -1) {
            return -1;
        }
        buffer.commitWritten(read);
        return read;
    }

    /* renamed from: read-UAd2zVI$default  reason: not valid java name */
    public static /* synthetic */ int m311readUAd2zVI$default(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteBuffer.limit() - i;
        }
        return m310readUAd2zVI(readableByteChannel, byteBuffer, i, i2);
    }

    @Deprecated(message = "Use write(Memory) instead.")
    public static final int write(WritableByteChannel writableByteChannel, Buffer buffer) {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        int write = writableByteChannel.write(MemoryJvmKt.sliceSafe(r0, readPosition, buffer.getWritePosition() - readPosition));
        buffer.discardExact(write);
        return write;
    }

    /* renamed from: write-UAd2zVI$default  reason: not valid java name */
    public static /* synthetic */ int m313writeUAd2zVI$default(WritableByteChannel writableByteChannel, ByteBuffer byteBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteBuffer.limit() - i;
        }
        return m312writeUAd2zVI(writableByteChannel, byteBuffer, i, i2);
    }
}
