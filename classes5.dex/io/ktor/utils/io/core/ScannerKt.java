package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.MemoryJvmKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a,\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\bø\u0001\u0000\u001a<\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\bø\u0001\u0000\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\u0015\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a\u001a\u0010\u0016\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a.\u0010\u0016\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a\"\u0010\u0017\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a6\u0010\u0017\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"discardUntilDelimiterImplMemory", "", "buffer", "Lio/ktor/utils/io/core/Buffer;", "delimiter", "", "discardUntilDelimitersImplMemory", "delimiter1", "delimiter2", "copyUntil", "predicate", "Lkotlin/Function1;", "", "dst", "Lio/ktor/utils/io/core/Output;", "", "offset", "length", "discardUntilDelimiter", "", "Lio/ktor/utils/io/core/Input;", "discardUntilDelimiters", "readUntilDelimiter", "readUntilDelimiters", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scanner.kt */
public final class ScannerKt {
    public static /* synthetic */ int readUntilDelimiter$default(Input input, byte b, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        return readUntilDelimiter(input, b, bArr, i, i2);
    }

    public static /* synthetic */ int readUntilDelimiters$default(Input input, byte b, byte b2, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = bArr.length;
        }
        return readUntilDelimiters(input, b, b2, bArr, i4, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readUntilDelimiters(io.ktor.utils.io.core.Input r17, byte r18, byte r19, byte[] r20, int r21, int r22) {
        /*
            r1 = r17
            r0 = r18
            r8 = r20
            r9 = r21
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            r10 = r19
            if (r0 != r10) goto L_0x001d
            r2 = r22
            int r0 = readUntilDelimiter(r1, r0, r8, r9, r2)
            return r0
        L_0x001d:
            r2 = r22
            r11 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r11)
            if (r3 != 0) goto L_0x0028
            r14 = r9
            goto L_0x0063
        L_0x0028:
            r12 = r2
            r13 = r3
            r14 = r9
        L_0x002b:
            r15 = 0
            r16 = r13
            io.ktor.utils.io.core.Buffer r16 = (io.ktor.utils.io.core.Buffer) r16     // Catch:{ all -> 0x006a }
            r2 = r16
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r14
            r7 = r12
            int r2 = io.ktor.utils.io.core.ScannerJVMKt.readUntilDelimitersImpl(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006a }
            int r14 = r14 + r2
            int r12 = r12 - r2
            int r2 = r16.getWritePosition()     // Catch:{ all -> 0x006a }
            int r3 = r16.getReadPosition()     // Catch:{ all -> 0x006a }
            if (r2 <= r3) goto L_0x004c
            r2 = r11
            goto L_0x004d
        L_0x004c:
            r2 = r15
        L_0x004d:
            if (r2 != 0) goto L_0x0053
            if (r12 <= 0) goto L_0x0053
            r2 = r11
            goto L_0x0054
        L_0x0053:
            r2 = r15
        L_0x0054:
            if (r2 != 0) goto L_0x0057
            goto L_0x005e
        L_0x0057:
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r13)     // Catch:{ all -> 0x0067 }
            if (r3 != 0) goto L_0x0065
            r11 = r15
        L_0x005e:
            if (r11 == 0) goto L_0x0063
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r13)
        L_0x0063:
            int r14 = r14 - r9
            return r14
        L_0x0065:
            r13 = r3
            goto L_0x002b
        L_0x0067:
            r0 = move-exception
            r11 = r15
            goto L_0x006b
        L_0x006a:
            r0 = move-exception
        L_0x006b:
            if (r11 == 0) goto L_0x0070
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r13)
        L_0x0070:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.ScannerKt.readUntilDelimiters(io.ktor.utils.io.core.Input, byte, byte, byte[], int, int):int");
    }

    public static final int discardUntilDelimiterImplMemory(Buffer buffer, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer r2 = buffer.m184getMemorySK3TCg8();
        int i = readPosition;
        while (i < writePosition && r2.get(i) != b) {
            i++;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - readPosition;
    }

    public static final int discardUntilDelimitersImplMemory(Buffer buffer, byte b, byte b2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer r2 = buffer.m184getMemorySK3TCg8();
        int i = readPosition;
        while (i < writePosition) {
            byte b3 = r2.get(i);
            if (b3 == b || b3 == b2) {
                break;
            }
            i++;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - readPosition;
    }

    public static final int copyUntil(Buffer buffer, Function1<? super Byte, Boolean> function1, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Intrinsics.checkNotNullParameter(bArr, "dst");
        int readPosition = buffer.getReadPosition();
        int min = Math.min(buffer.getWritePosition(), i2 + readPosition);
        ByteBuffer r3 = buffer.m184getMemorySK3TCg8();
        int i3 = readPosition;
        while (true) {
            if (i3 >= min) {
                break;
            } else if (((Boolean) function1.invoke(Byte.valueOf(r3.get(i3)))).booleanValue()) {
                min = i3;
                break;
            } else {
                i3++;
            }
        }
        int i4 = min - readPosition;
        MemoryJvmKt.m59copyTo9zorpBc(r3, bArr, readPosition, i4, i);
        return i4;
    }

    public static final int copyUntil(Buffer buffer, Function1<? super Byte, Boolean> function1, Output output) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Intrinsics.checkNotNullParameter(output, "dst");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer r2 = buffer.m184getMemorySK3TCg8();
        while (readPosition != writePosition && !((Boolean) function1.invoke(Byte.valueOf(r2.get(readPosition)))).booleanValue()) {
            readPosition++;
        }
        int readPosition2 = readPosition - buffer.getReadPosition();
        OutputKt.writeFully(output, buffer, readPosition2);
        return readPosition2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[SYNTHETIC, Splitter:B:14:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0037 A[EDGE_INSN: B:28:0x0037->B:18:0x0037 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long discardUntilDelimiter(io.ktor.utils.io.core.Input r9, byte r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r9, r0)
            r2 = 0
            if (r1 != 0) goto L_0x000f
            goto L_0x003c
        L_0x000f:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0042 }
            int r6 = io.ktor.utils.io.core.ScannerJVMKt.discardUntilDelimiterImpl(r5, r10)     // Catch:{ all -> 0x0042 }
            long r7 = (long) r6     // Catch:{ all -> 0x0042 }
            long r2 = r2 + r7
            if (r6 <= 0) goto L_0x002c
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x0042 }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x0042 }
            if (r6 <= r5) goto L_0x0027
            r5 = r0
            goto L_0x0028
        L_0x0027:
            r5 = r4
        L_0x0028:
            if (r5 != 0) goto L_0x002c
            r5 = r0
            goto L_0x002d
        L_0x002c:
            r5 = r4
        L_0x002d:
            if (r5 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r9, r1)     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x003d
            r0 = r4
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r9, r1)
        L_0x003c:
            return r2
        L_0x003d:
            r1 = r5
            goto L_0x000f
        L_0x003f:
            r10 = move-exception
            r0 = r4
            goto L_0x0043
        L_0x0042:
            r10 = move-exception
        L_0x0043:
            if (r0 == 0) goto L_0x0048
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r9, r1)
        L_0x0048:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.ScannerKt.discardUntilDelimiter(io.ktor.utils.io.core.Input, byte):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[SYNTHETIC, Splitter:B:14:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0037 A[EDGE_INSN: B:28:0x0037->B:18:0x0037 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long discardUntilDelimiters(io.ktor.utils.io.core.Input r9, byte r10, byte r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r9, r0)
            r2 = 0
            if (r1 != 0) goto L_0x000f
            goto L_0x003c
        L_0x000f:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0042 }
            int r6 = io.ktor.utils.io.core.ScannerJVMKt.discardUntilDelimitersImpl(r5, r10, r11)     // Catch:{ all -> 0x0042 }
            long r7 = (long) r6     // Catch:{ all -> 0x0042 }
            long r2 = r2 + r7
            if (r6 <= 0) goto L_0x002c
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x0042 }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x0042 }
            if (r6 <= r5) goto L_0x0027
            r5 = r0
            goto L_0x0028
        L_0x0027:
            r5 = r4
        L_0x0028:
            if (r5 != 0) goto L_0x002c
            r5 = r0
            goto L_0x002d
        L_0x002c:
            r5 = r4
        L_0x002d:
            if (r5 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r9, r1)     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x003d
            r0 = r4
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r9, r1)
        L_0x003c:
            return r2
        L_0x003d:
            r1 = r5
            goto L_0x000f
        L_0x003f:
            r10 = move-exception
            r0 = r4
            goto L_0x0043
        L_0x0042:
            r10 = move-exception
        L_0x0043:
            if (r0 == 0) goto L_0x0048
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r9, r1)
        L_0x0048:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.ScannerKt.discardUntilDelimiters(io.ktor.utils.io.core.Input, byte, byte):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[SYNTHETIC, Splitter:B:16:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003c A[EDGE_INSN: B:31:0x003c->B:20:0x003c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readUntilDelimiter(io.ktor.utils.io.core.Input r6, byte r7, byte[] r8, int r9, int r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r0)
            if (r1 != 0) goto L_0x0013
            r2 = r9
            goto L_0x0041
        L_0x0013:
            r2 = r9
        L_0x0014:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0048 }
            int r5 = io.ktor.utils.io.core.ScannerJVMKt.readUntilDelimiterImpl(r4, r7, r8, r2, r10)     // Catch:{ all -> 0x0048 }
            int r2 = r2 + r5
            int r10 = r10 - r5
            if (r10 <= 0) goto L_0x0031
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0048 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0048 }
            if (r5 <= r4) goto L_0x002c
            r4 = r0
            goto L_0x002d
        L_0x002c:
            r4 = r3
        L_0x002d:
            if (r4 != 0) goto L_0x0031
            r4 = r0
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            if (r4 != 0) goto L_0x0035
            goto L_0x003c
        L_0x0035:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r6, r1)     // Catch:{ all -> 0x0045 }
            if (r4 != 0) goto L_0x0043
            r0 = r3
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x0041:
            int r2 = r2 - r9
            return r2
        L_0x0043:
            r1 = r4
            goto L_0x0014
        L_0x0045:
            r7 = move-exception
            r0 = r3
            goto L_0x0049
        L_0x0048:
            r7 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x004e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.ScannerKt.readUntilDelimiter(io.ktor.utils.io.core.Input, byte, byte[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long readUntilDelimiter(io.ktor.utils.io.core.Input r8, byte r9, io.ktor.utils.io.core.Output r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r8, r0)
            r2 = 0
            if (r1 != 0) goto L_0x0014
            goto L_0x003b
        L_0x0014:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0041 }
            int r6 = io.ktor.utils.io.core.ScannerJVMKt.readUntilDelimiterImpl(r5, r9, r10)     // Catch:{ all -> 0x0041 }
            long r6 = (long) r6     // Catch:{ all -> 0x0041 }
            long r2 = r2 + r6
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x0041 }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x0041 }
            if (r6 <= r5) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r4
        L_0x002b:
            r5 = r5 ^ r0
            if (r5 != 0) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r8, r1)     // Catch:{ all -> 0x003e }
            if (r5 != 0) goto L_0x003c
            r0 = r4
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L_0x003b:
            return r2
        L_0x003c:
            r1 = r5
            goto L_0x0014
        L_0x003e:
            r9 = move-exception
            r0 = r4
            goto L_0x0042
        L_0x0041:
            r9 = move-exception
        L_0x0042:
            if (r0 == 0) goto L_0x0047
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L_0x0047:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.ScannerKt.readUntilDelimiter(io.ktor.utils.io.core.Input, byte, io.ktor.utils.io.core.Output):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long readUntilDelimiters(io.ktor.utils.io.core.Input r8, byte r9, byte r10, io.ktor.utils.io.core.Output r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r8, r0)
            r2 = 0
            if (r1 != 0) goto L_0x0014
            goto L_0x003b
        L_0x0014:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0041 }
            int r6 = io.ktor.utils.io.core.ScannerJVMKt.readUntilDelimitersImpl(r5, r9, r10, r11)     // Catch:{ all -> 0x0041 }
            long r6 = (long) r6     // Catch:{ all -> 0x0041 }
            long r2 = r2 + r6
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x0041 }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x0041 }
            if (r6 <= r5) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r4
        L_0x002b:
            r5 = r5 ^ r0
            if (r5 != 0) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r8, r1)     // Catch:{ all -> 0x003e }
            if (r5 != 0) goto L_0x003c
            r0 = r4
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L_0x003b:
            return r2
        L_0x003c:
            r1 = r5
            goto L_0x0014
        L_0x003e:
            r9 = move-exception
            r0 = r4
            goto L_0x0042
        L_0x0041:
            r9 = move-exception
        L_0x0042:
            if (r0 == 0) goto L_0x0047
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L_0x0047:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.ScannerKt.readUntilDelimiters(io.ktor.utils.io.core.Input, byte, byte, io.ktor.utils.io.core.Output):long");
    }
}
