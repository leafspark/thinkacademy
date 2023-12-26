package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a0\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a)\u0010\u000e\u001a\u00020\u0001*\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\u0012H\b\u001aA\u0010\u000e\u001a\u00020\u0001*\u00020\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a9\u0010\u0015\u001a\u00020\u0001*\u00020\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a\u001c\u0010\u0018\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a,\u0010\u0019\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a$\u0010\u001a\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001a\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a$\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a$\u0010\u001c\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001c\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000¨\u0006\u001d"}, d2 = {"discardUntilDelimiterImplArrays", "", "buffer", "Lio/ktor/utils/io/core/Buffer;", "delimiter", "", "discardUntilDelimitersImplArrays", "delimiter1", "delimiter2", "readUntilDelimiterArrays", "dst", "", "offset", "length", "copyUntilArrays", "predicate", "Lkotlin/Function1;", "", "Lio/ktor/utils/io/core/Output;", "Ljava/nio/ByteBuffer;", "bufferOffset", "copyUntilDirect", "discardUntilDelimiterImpl", "discardUntilDelimitersImpl", "readUntilDelimiterDirect", "readUntilDelimiterImpl", "readUntilDelimitersArrays", "readUntilDelimitersDirect", "readUntilDelimitersImpl", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScannerJVM.kt */
public final class ScannerJVMKt {
    public static final int discardUntilDelimiterImpl(Buffer buffer, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (ByteBuffersKt.hasArray(buffer)) {
            return discardUntilDelimiterImplArrays(buffer, b);
        }
        return ScannerKt.discardUntilDelimiterImplMemory(buffer, b);
    }

    private static final int discardUntilDelimiterImplArrays(Buffer buffer, byte b) {
        int i;
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        byte[] array = r0.array();
        int arrayOffset = r0.arrayOffset() + r0.position() + buffer.getReadPosition();
        int writePosition = (buffer.getWritePosition() - buffer.getReadPosition()) + arrayOffset;
        if (writePosition <= array.length) {
            i = arrayOffset;
            while (i < writePosition && array[i] != b) {
                i++;
            }
        } else {
            i = arrayOffset;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - arrayOffset;
    }

    public static final int discardUntilDelimitersImpl(Buffer buffer, byte b, byte b2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (ByteBuffersKt.hasArray(buffer)) {
            return discardUntilDelimitersImplArrays(buffer, b, b2);
        }
        return ScannerKt.discardUntilDelimitersImplMemory(buffer, b, b2);
    }

    private static final int discardUntilDelimitersImplArrays(Buffer buffer, byte b, byte b2) {
        int i;
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        byte[] array = r0.array();
        int arrayOffset = r0.arrayOffset() + r0.position() + buffer.getReadPosition();
        int writePosition = (buffer.getWritePosition() - buffer.getReadPosition()) + arrayOffset;
        if (writePosition <= array.length) {
            i = arrayOffset;
            while (i < writePosition) {
                byte b3 = array[i];
                if (b3 == b || b3 == b2) {
                    break;
                }
                i++;
            }
        } else {
            i = arrayOffset;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - arrayOffset;
    }

    public static final int readUntilDelimiterImpl(Buffer buffer, byte b, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "dst");
        int length = bArr.length;
        if (ByteBuffersKt.hasArray(buffer)) {
            return readUntilDelimiterArrays(buffer, b, bArr, i, i2);
        }
        return readUntilDelimiterDirect(buffer, b, bArr, i, i2);
    }

    private static final int readUntilDelimiterArrays(Buffer buffer, byte b, byte[] bArr, int i, int i2) {
        int i3;
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        int min = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
        byte[] array = r0.array();
        int position = readPosition + r0.position() + r0.arrayOffset();
        int min2 = Math.min(min, r0.remaining()) + position;
        if (min2 <= array.length) {
            i3 = position;
            while (i3 < min2) {
                if (array[i3] == b) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = position;
        }
        int i4 = i3 - position;
        System.arraycopy(array, position, bArr, i, i4);
        buffer.discardExact(i4);
        return i4;
    }

    public static final int readUntilDelimitersImpl(Buffer buffer, byte b, byte b2, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "dst");
        int length = bArr.length;
        if (ByteBuffersKt.hasArray(buffer)) {
            return readUntilDelimitersArrays(buffer, b, b2, bArr, i, i2);
        }
        return readUntilDelimitersDirect(buffer, b, b2, bArr, i, i2);
    }

    private static final int readUntilDelimitersArrays(Buffer buffer, byte b, byte b2, byte[] bArr, int i, int i2) {
        int i3;
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        int min = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
        byte[] array = r0.array();
        int position = readPosition + r0.position() + r0.arrayOffset();
        int min2 = Math.min(min, r0.remaining()) + position;
        if (min2 <= array.length) {
            i3 = position;
            while (i3 < min2) {
                byte b3 = array[i3];
                if (b3 == b || b3 == b2) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = position;
        }
        int i4 = i3 - position;
        System.arraycopy(array, position, bArr, i, i4);
        buffer.discardExact(i4);
        return i4;
    }

    public static final int readUntilDelimiterImpl(Buffer buffer, byte b, Output output) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(output, "dst");
        if (ByteBuffersKt.hasArray(buffer)) {
            return readUntilDelimiterArrays(buffer, b, output);
        }
        return readUntilDelimiterDirect(buffer, b, output);
    }

    public static final int readUntilDelimitersImpl(Buffer buffer, byte b, byte b2, Output output) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(output, "dst");
        if (ByteBuffersKt.hasArray(buffer)) {
            return readUntilDelimitersArrays(buffer, b, b2, output);
        }
        return readUntilDelimitersDirect(buffer, b, b2, output);
    }

    private static final int copyUntilDirect(ByteBuffer byteBuffer, Function1<? super Byte, Boolean> function1, byte[] bArr, int i, int i2) {
        int position = byteBuffer.position();
        int i3 = i2 + position;
        int i4 = position;
        while (i4 < byteBuffer.limit() && i4 < i3 && !((Boolean) function1.invoke(Byte.valueOf(byteBuffer.get(i4)))).booleanValue()) {
            i4++;
        }
        int i5 = i4 - position;
        byteBuffer.get(bArr, i, i5);
        return i5;
    }

    private static final int copyUntilArrays(ByteBuffer byteBuffer, Function1<? super Byte, Boolean> function1, int i, byte[] bArr, int i2, int i3) {
        int i4;
        byte[] array = byteBuffer.array();
        int position = i + byteBuffer.position() + byteBuffer.arrayOffset();
        int min = Math.min(i3, byteBuffer.remaining()) + position;
        if (min <= array.length) {
            i4 = position;
            while (i4 < min && !((Boolean) function1.invoke(Byte.valueOf(array[i4]))).booleanValue()) {
                i4++;
            }
        } else {
            i4 = position;
        }
        int i5 = i4 - position;
        System.arraycopy(array, position, bArr, i2, i5);
        return i5;
    }

    /* JADX INFO: finally extract failed */
    private static final int copyUntilArrays(Buffer buffer, Function1<? super Byte, Boolean> function1, Output output) {
        int i;
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        byte[] array = r0.array();
        int position = r0.position() + r0.arrayOffset() + buffer.getReadPosition();
        int position2 = r0.position() + r0.arrayOffset() + buffer.getWritePosition();
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        int i2 = 0;
        while (true) {
            try {
                Buffer buffer2 = prepareWriteHead;
                int min = Math.min((buffer2.getLimit() - buffer2.getWritePosition()) + position, position2);
                if (min <= array.length) {
                    i = position;
                    while (i < min && !((Boolean) function1.invoke(Byte.valueOf(array[i]))).booleanValue()) {
                        i++;
                    }
                } else {
                    i = position;
                }
                int i3 = i - position;
                Intrinsics.checkNotNullExpressionValue(array, "array");
                BufferPrimitivesKt.writeFully(buffer2, array, position, i3);
                i2 += i3;
                if (!(buffer2.getLimit() > buffer2.getWritePosition()) && i < position2) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                    position = i;
                } else {
                    InlineMarker.finallyStart(1);
                    output.afterHeadWrite();
                    InlineMarker.finallyEnd(1);
                    buffer.discardUntilIndex$ktor_io(i);
                    return i2;
                }
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    private static final int readUntilDelimiterDirect(Buffer buffer, byte b, byte[] bArr, int i, int i2) {
        int readPosition = buffer.getReadPosition();
        int min = Math.min(buffer.getWritePosition(), i2 + readPosition);
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int i3 = readPosition;
        while (true) {
            if (i3 >= min) {
                break;
            }
            if (r1.get(i3) == b) {
                min = i3;
                break;
            }
            i3++;
        }
        int i4 = min - readPosition;
        MemoryJvmKt.m59copyTo9zorpBc(r1, bArr, readPosition, i4, i);
        buffer.discardExact(i4);
        return i4;
    }

    private static final int readUntilDelimitersDirect(Buffer buffer, byte b, byte b2, byte[] bArr, int i, int i2) {
        int readPosition = buffer.getReadPosition();
        int min = Math.min(buffer.getWritePosition(), i2 + readPosition);
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int i3 = readPosition;
        while (true) {
            if (i3 >= min) {
                break;
            }
            byte b3 = r1.get(i3);
            if (b3 == b || b3 == b2) {
                min = i3;
                break;
            }
            i3++;
        }
        int i4 = min - readPosition;
        MemoryJvmKt.m59copyTo9zorpBc(r1, bArr, readPosition, i4, i);
        buffer.discardExact(i4);
        return i4;
    }

    public static final int readUntilDelimiterDirect(Buffer buffer, byte b, Output output) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(output, "dst");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer r2 = buffer.m184getMemorySK3TCg8();
        while (readPosition != writePosition) {
            if (r2.get(readPosition) == b) {
                break;
            }
            readPosition++;
        }
        int readPosition2 = readPosition - buffer.getReadPosition();
        OutputKt.writeFully(output, buffer, readPosition2);
        return readPosition2;
    }

    /* JADX INFO: finally extract failed */
    public static final int readUntilDelimiterArrays(Buffer buffer, byte b, Output output) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(output, "dst");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        byte[] array = r0.array();
        int position = r0.position() + r0.arrayOffset() + buffer.getReadPosition();
        int position2 = r0.position() + r0.arrayOffset() + buffer.getWritePosition();
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        int i2 = 0;
        while (true) {
            try {
                Buffer buffer2 = prepareWriteHead;
                int min = Math.min((buffer2.getLimit() - buffer2.getWritePosition()) + position, position2);
                if (min <= array.length) {
                    i = position;
                    while (i < min) {
                        if (array[i] == b) {
                            break;
                        }
                        i++;
                    }
                } else {
                    i = position;
                }
                int i3 = i - position;
                Intrinsics.checkNotNullExpressionValue(array, "array");
                BufferPrimitivesKt.writeFully(buffer2, array, position, i3);
                i2 += i3;
                if (!(buffer2.getLimit() > buffer2.getWritePosition()) && i < position2) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                    position = i;
                } else {
                    output.afterHeadWrite();
                    buffer.discardUntilIndex$ktor_io(i);
                    return i2;
                }
            } catch (Throwable th) {
                output.afterHeadWrite();
                throw th;
            }
        }
    }

    public static final int readUntilDelimitersDirect(Buffer buffer, byte b, byte b2, Output output) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(output, "dst");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer r2 = buffer.m184getMemorySK3TCg8();
        while (readPosition != writePosition) {
            byte b3 = r2.get(readPosition);
            if (b3 == b || b3 == b2) {
                break;
            }
            readPosition++;
        }
        int readPosition2 = readPosition - buffer.getReadPosition();
        OutputKt.writeFully(output, buffer, readPosition2);
        return readPosition2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059 A[Catch:{ all -> 0x008b }, LOOP:1: B:6:0x004b->B:14:0x0059, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005d A[EDGE_INSN: B:33:0x005d->B:16:0x005d ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readUntilDelimitersArrays(io.ktor.utils.io.core.Buffer r11, byte r12, byte r13, io.ktor.utils.io.core.Output r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.nio.ByteBuffer r0 = r11.m184getMemorySK3TCg8()
            byte[] r1 = r0.array()
            int r2 = r0.position()
            int r3 = r0.arrayOffset()
            int r2 = r2 + r3
            int r3 = r11.getReadPosition()
            int r2 = r2 + r3
            int r3 = r0.position()
            int r0 = r0.arrayOffset()
            int r3 = r3 + r0
            int r0 = r11.getWritePosition()
            int r3 = r3 + r0
            r0 = 1
            r4 = 0
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r14, r0, r4)
            r5 = 0
            r6 = r5
        L_0x0036:
            r7 = r4
            io.ktor.utils.io.core.Buffer r7 = (io.ktor.utils.io.core.Buffer) r7     // Catch:{ all -> 0x008b }
            int r8 = r7.getLimit()     // Catch:{ all -> 0x008b }
            int r9 = r7.getWritePosition()     // Catch:{ all -> 0x008b }
            int r8 = r8 - r9
            int r8 = r8 + r2
            int r8 = java.lang.Math.min(r8, r3)     // Catch:{ all -> 0x008b }
            int r9 = r1.length     // Catch:{ all -> 0x008b }
            if (r8 > r9) goto L_0x005c
            r9 = r2
        L_0x004b:
            if (r9 >= r8) goto L_0x005d
            byte r10 = r1[r9]     // Catch:{ all -> 0x008b }
            if (r10 == r12) goto L_0x0056
            if (r10 != r13) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r10 = r5
            goto L_0x0057
        L_0x0056:
            r10 = r0
        L_0x0057:
            if (r10 != 0) goto L_0x005d
            int r9 = r9 + 1
            goto L_0x004b
        L_0x005c:
            r9 = r2
        L_0x005d:
            int r8 = r9 - r2
            java.lang.String r10 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r10)     // Catch:{ all -> 0x008b }
            io.ktor.utils.io.core.BufferPrimitivesKt.writeFully((io.ktor.utils.io.core.Buffer) r7, (byte[]) r1, (int) r2, (int) r8)     // Catch:{ all -> 0x008b }
            int r6 = r6 + r8
            int r2 = r7.getLimit()     // Catch:{ all -> 0x008b }
            int r7 = r7.getWritePosition()     // Catch:{ all -> 0x008b }
            if (r2 <= r7) goto L_0x0074
            r2 = r0
            goto L_0x0075
        L_0x0074:
            r2 = r5
        L_0x0075:
            if (r2 != 0) goto L_0x007b
            if (r9 >= r3) goto L_0x007b
            r2 = r0
            goto L_0x007c
        L_0x007b:
            r2 = r5
        L_0x007c:
            if (r2 == 0) goto L_0x0084
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r14, r0, r4)     // Catch:{ all -> 0x008b }
            r2 = r9
            goto L_0x0036
        L_0x0084:
            r14.afterHeadWrite()
            r11.discardUntilIndex$ktor_io(r9)
            return r6
        L_0x008b:
            r11 = move-exception
            r14.afterHeadWrite()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.ScannerJVMKt.readUntilDelimitersArrays(io.ktor.utils.io.core.Buffer, byte, byte, io.ktor.utils.io.core.Output):int");
    }
}
