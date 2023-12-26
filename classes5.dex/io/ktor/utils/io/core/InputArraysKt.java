package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0000\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\n\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a/\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a&\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001aj\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012K\u0010\u001b\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150\u001cH\b\u001a\u0001\u0010\u0019\u001a\u00020\t*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2`\u0010\u001b\u001a\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150\"H\bø\u0001\u0000\u001ar\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00012K\u0010\u001b\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150\u001cH\b\u001a\r\u0010&\u001a\u00020\u0015*\u00020\u0001H\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"readAvailable", "", "Lio/ktor/utils/io/core/Input;", "destination", "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", "length", "readAvailable-UAd2zVI", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;II)I", "", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;JJ)J", "dst", "Lio/ktor/utils/io/core/Buffer;", "", "offset", "", "", "", "", "", "readFully", "", "readFully-UAd2zVI", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;II)V", "(Lio/ktor/utils/io/core/Input;Ljava/nio/ByteBuffer;JJ)V", "readFullyBytesTemplate", "initialDstOffset", "readBlock", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "src", "dstOffset", "count", "Lkotlin/Function4;", "srcOffset", "readFullyTemplate", "componentSize", "requireNoRemaining", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputArrays.kt */
public final class InputArraysKt {
    public static /* synthetic */ void readFully$default(Input input, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(input, bArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        readFully(input, sArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        readFully(input, iArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        readFully(input, jArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        readFully(input, fArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Input input, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        readFully(input, dArr, i, i2);
    }

    /* renamed from: readFully-UAd2zVI  reason: not valid java name */
    public static final void m229readFullyUAd2zVI(Input input, ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(byteBuffer, "destination");
        m230readFullyUAd2zVI(input, byteBuffer, (long) i, (long) i2);
    }

    /* renamed from: readFully-UAd2zVI  reason: not valid java name */
    public static final void m230readFullyUAd2zVI(Input input, ByteBuffer byteBuffer, long j, long j2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(byteBuffer, "destination");
        if (m228readAvailableUAd2zVI(input, byteBuffer, j, j2) != j2) {
            StringsKt.prematureEndOfStream(j2);
            throw new KotlinNothingValueException();
        }
    }

    public static /* synthetic */ int readAvailable$default(Input input, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(input, bArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        return readAvailable(input, sArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        return readAvailable(input, iArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        return readAvailable(input, jArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        return readAvailable(input, fArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Input input, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        return readAvailable(input, dArr, i, i2);
    }

    /* renamed from: readAvailable-UAd2zVI  reason: not valid java name */
    public static final int m227readAvailableUAd2zVI(Input input, ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(byteBuffer, "destination");
        return (int) m228readAvailableUAd2zVI(input, byteBuffer, (long) i, (long) i2);
    }

    private static final void requireNoRemaining(int i) {
        if (i > 0) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void readFully(io.ktor.utils.io.core.Input r6, byte[] r7, int r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r0)
            if (r1 != 0) goto L_0x0012
            goto L_0x003c
        L_0x0012:
            r2 = 0
            r3 = r1
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3     // Catch:{ all -> 0x004d }
            int r4 = r3.getWritePosition()     // Catch:{ all -> 0x004d }
            int r5 = r3.getReadPosition()     // Catch:{ all -> 0x004d }
            int r4 = r4 - r5
            int r4 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x004d }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r3, (byte[]) r7, (int) r8, (int) r4)     // Catch:{ all -> 0x004d }
            int r9 = r9 - r4
            int r8 = r8 + r4
            if (r9 <= 0) goto L_0x002c
            r3 = r0
            goto L_0x002d
        L_0x002c:
            r3 = r2
        L_0x002d:
            if (r3 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r6, r1)     // Catch:{ all -> 0x004a }
            if (r3 != 0) goto L_0x0048
            r0 = r2
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x003c:
            if (r9 > 0) goto L_0x003f
            return
        L_0x003f:
            io.ktor.utils.io.core.StringsKt.prematureEndOfStream((int) r9)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L_0x0048:
            r1 = r3
            goto L_0x0012
        L_0x004a:
            r7 = move-exception
            r0 = r2
            goto L_0x004e
        L_0x004d:
            r7 = move-exception
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x0053:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFully(io.ktor.utils.io.core.Input, byte[], int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void readFully(io.ktor.utils.io.core.Input r6, short[] r7, int r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r0)
            if (r1 != 0) goto L_0x0013
            goto L_0x0089
        L_0x0013:
            r2 = r0
        L_0x0014:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0095 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5 - r4
            if (r5 < r2) goto L_0x0057
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004c }
            int r4 = r2.getWritePosition()     // Catch:{ all -> 0x004c }
            int r5 = r2.getReadPosition()     // Catch:{ all -> 0x004c }
            int r4 = r4 - r5
            r5 = 2
            int r4 = r4 / r5
            int r4 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x004c }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (short[]) r7, (int) r8, (int) r4)     // Catch:{ all -> 0x004c }
            int r9 = r9 - r4
            int r8 = r8 + r4
            if (r9 <= 0) goto L_0x003e
            r2 = r5
            goto L_0x003f
        L_0x003e:
            r2 = r3
        L_0x003f:
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0095 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5 - r4
            goto L_0x0057
        L_0x004c:
            r7 = move-exception
            r8 = r1
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x0095 }
            r8.getWritePosition()     // Catch:{ all -> 0x0095 }
            r8.getReadPosition()     // Catch:{ all -> 0x0095 }
            throw r7     // Catch:{ all -> 0x0095 }
        L_0x0057:
            if (r5 != 0) goto L_0x0061
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r6, r1)     // Catch:{ all -> 0x005e }
            goto L_0x007d
        L_0x005e:
            r7 = move-exception
            r0 = r3
            goto L_0x0096
        L_0x0061:
            if (r5 < r2) goto L_0x0076
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x005e }
            int r5 = r4.getCapacity()     // Catch:{ all -> 0x005e }
            int r4 = r4.getLimit()     // Catch:{ all -> 0x005e }
            int r5 = r5 - r4
            r4 = 8
            if (r5 >= r4) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r4 = r1
            goto L_0x007d
        L_0x0076:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)     // Catch:{ all -> 0x005e }
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r2)     // Catch:{ all -> 0x005e }
        L_0x007d:
            if (r4 != 0) goto L_0x0081
            r0 = r3
            goto L_0x0084
        L_0x0081:
            r1 = r4
            if (r2 > 0) goto L_0x0014
        L_0x0084:
            if (r0 == 0) goto L_0x0089
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x0089:
            if (r9 > 0) goto L_0x008c
            return
        L_0x008c:
            io.ktor.utils.io.core.StringsKt.prematureEndOfStream((int) r9)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L_0x0095:
            r7 = move-exception
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x009b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFully(io.ktor.utils.io.core.Input, short[], int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void readFully(io.ktor.utils.io.core.Input r6, int[] r7, int r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r0)
            if (r1 != 0) goto L_0x0013
            goto L_0x0089
        L_0x0013:
            r2 = r0
        L_0x0014:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0095 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5 - r4
            if (r5 < r2) goto L_0x0057
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004c }
            int r4 = r2.getWritePosition()     // Catch:{ all -> 0x004c }
            int r5 = r2.getReadPosition()     // Catch:{ all -> 0x004c }
            int r4 = r4 - r5
            r5 = 4
            int r4 = r4 / r5
            int r4 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x004c }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (int[]) r7, (int) r8, (int) r4)     // Catch:{ all -> 0x004c }
            int r9 = r9 - r4
            int r8 = r8 + r4
            if (r9 <= 0) goto L_0x003e
            r2 = r5
            goto L_0x003f
        L_0x003e:
            r2 = r3
        L_0x003f:
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0095 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5 - r4
            goto L_0x0057
        L_0x004c:
            r7 = move-exception
            r8 = r1
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x0095 }
            r8.getWritePosition()     // Catch:{ all -> 0x0095 }
            r8.getReadPosition()     // Catch:{ all -> 0x0095 }
            throw r7     // Catch:{ all -> 0x0095 }
        L_0x0057:
            if (r5 != 0) goto L_0x0061
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r6, r1)     // Catch:{ all -> 0x005e }
            goto L_0x007d
        L_0x005e:
            r7 = move-exception
            r0 = r3
            goto L_0x0096
        L_0x0061:
            if (r5 < r2) goto L_0x0076
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x005e }
            int r5 = r4.getCapacity()     // Catch:{ all -> 0x005e }
            int r4 = r4.getLimit()     // Catch:{ all -> 0x005e }
            int r5 = r5 - r4
            r4 = 8
            if (r5 >= r4) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r4 = r1
            goto L_0x007d
        L_0x0076:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)     // Catch:{ all -> 0x005e }
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r2)     // Catch:{ all -> 0x005e }
        L_0x007d:
            if (r4 != 0) goto L_0x0081
            r0 = r3
            goto L_0x0084
        L_0x0081:
            r1 = r4
            if (r2 > 0) goto L_0x0014
        L_0x0084:
            if (r0 == 0) goto L_0x0089
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x0089:
            if (r9 > 0) goto L_0x008c
            return
        L_0x008c:
            io.ktor.utils.io.core.StringsKt.prematureEndOfStream((int) r9)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L_0x0095:
            r7 = move-exception
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x009b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFully(io.ktor.utils.io.core.Input, int[], int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void readFully(io.ktor.utils.io.core.Input r7, long[] r8, int r9, int r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0013
            goto L_0x0089
        L_0x0013:
            r2 = r0
        L_0x0014:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0095 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5 - r4
            r4 = 8
            if (r5 < r2) goto L_0x0059
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004e }
            int r5 = r2.getWritePosition()     // Catch:{ all -> 0x004e }
            int r6 = r2.getReadPosition()     // Catch:{ all -> 0x004e }
            int r5 = r5 - r6
            int r5 = r5 / r4
            int r5 = java.lang.Math.min(r10, r5)     // Catch:{ all -> 0x004e }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (long[]) r8, (int) r9, (int) r5)     // Catch:{ all -> 0x004e }
            int r10 = r10 - r5
            int r9 = r9 + r5
            if (r10 <= 0) goto L_0x003f
            r2 = r4
            goto L_0x0040
        L_0x003f:
            r2 = r3
        L_0x0040:
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0095 }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r6 - r5
            goto L_0x0059
        L_0x004e:
            r8 = move-exception
            r9 = r1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x0095 }
            r9.getWritePosition()     // Catch:{ all -> 0x0095 }
            r9.getReadPosition()     // Catch:{ all -> 0x0095 }
            throw r8     // Catch:{ all -> 0x0095 }
        L_0x0059:
            if (r5 != 0) goto L_0x0063
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0060 }
            goto L_0x007d
        L_0x0060:
            r8 = move-exception
            r0 = r3
            goto L_0x0096
        L_0x0063:
            if (r5 < r2) goto L_0x0076
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0060 }
            int r6 = r5.getCapacity()     // Catch:{ all -> 0x0060 }
            int r5 = r5.getLimit()     // Catch:{ all -> 0x0060 }
            int r6 = r6 - r5
            if (r6 >= r4) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r4 = r1
            goto L_0x007d
        L_0x0076:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)     // Catch:{ all -> 0x0060 }
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r2)     // Catch:{ all -> 0x0060 }
        L_0x007d:
            if (r4 != 0) goto L_0x0081
            r0 = r3
            goto L_0x0084
        L_0x0081:
            r1 = r4
            if (r2 > 0) goto L_0x0014
        L_0x0084:
            if (r0 == 0) goto L_0x0089
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x0089:
            if (r10 > 0) goto L_0x008c
            return
        L_0x008c:
            io.ktor.utils.io.core.StringsKt.prematureEndOfStream((int) r10)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        L_0x0095:
            r8 = move-exception
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x009b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFully(io.ktor.utils.io.core.Input, long[], int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void readFully(io.ktor.utils.io.core.Input r6, float[] r7, int r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r0)
            if (r1 != 0) goto L_0x0013
            goto L_0x0089
        L_0x0013:
            r2 = r0
        L_0x0014:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0095 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5 - r4
            if (r5 < r2) goto L_0x0057
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004c }
            int r4 = r2.getWritePosition()     // Catch:{ all -> 0x004c }
            int r5 = r2.getReadPosition()     // Catch:{ all -> 0x004c }
            int r4 = r4 - r5
            r5 = 4
            int r4 = r4 / r5
            int r4 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x004c }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (float[]) r7, (int) r8, (int) r4)     // Catch:{ all -> 0x004c }
            int r9 = r9 - r4
            int r8 = r8 + r4
            if (r9 <= 0) goto L_0x003e
            r2 = r5
            goto L_0x003f
        L_0x003e:
            r2 = r3
        L_0x003f:
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0095 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5 - r4
            goto L_0x0057
        L_0x004c:
            r7 = move-exception
            r8 = r1
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8     // Catch:{ all -> 0x0095 }
            r8.getWritePosition()     // Catch:{ all -> 0x0095 }
            r8.getReadPosition()     // Catch:{ all -> 0x0095 }
            throw r7     // Catch:{ all -> 0x0095 }
        L_0x0057:
            if (r5 != 0) goto L_0x0061
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r6, r1)     // Catch:{ all -> 0x005e }
            goto L_0x007d
        L_0x005e:
            r7 = move-exception
            r0 = r3
            goto L_0x0096
        L_0x0061:
            if (r5 < r2) goto L_0x0076
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x005e }
            int r5 = r4.getCapacity()     // Catch:{ all -> 0x005e }
            int r4 = r4.getLimit()     // Catch:{ all -> 0x005e }
            int r5 = r5 - r4
            r4 = 8
            if (r5 >= r4) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r4 = r1
            goto L_0x007d
        L_0x0076:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)     // Catch:{ all -> 0x005e }
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r2)     // Catch:{ all -> 0x005e }
        L_0x007d:
            if (r4 != 0) goto L_0x0081
            r0 = r3
            goto L_0x0084
        L_0x0081:
            r1 = r4
            if (r2 > 0) goto L_0x0014
        L_0x0084:
            if (r0 == 0) goto L_0x0089
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x0089:
            if (r9 > 0) goto L_0x008c
            return
        L_0x008c:
            io.ktor.utils.io.core.StringsKt.prematureEndOfStream((int) r9)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L_0x0095:
            r7 = move-exception
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x009b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFully(io.ktor.utils.io.core.Input, float[], int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void readFully(io.ktor.utils.io.core.Input r7, double[] r8, int r9, int r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0013
            goto L_0x0089
        L_0x0013:
            r2 = r0
        L_0x0014:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0095 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5 - r4
            r4 = 8
            if (r5 < r2) goto L_0x0059
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004e }
            int r5 = r2.getWritePosition()     // Catch:{ all -> 0x004e }
            int r6 = r2.getReadPosition()     // Catch:{ all -> 0x004e }
            int r5 = r5 - r6
            int r5 = r5 / r4
            int r5 = java.lang.Math.min(r10, r5)     // Catch:{ all -> 0x004e }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (double[]) r8, (int) r9, (int) r5)     // Catch:{ all -> 0x004e }
            int r10 = r10 - r5
            int r9 = r9 + r5
            if (r10 <= 0) goto L_0x003f
            r2 = r4
            goto L_0x0040
        L_0x003f:
            r2 = r3
        L_0x0040:
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0095 }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x0095 }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x0095 }
            int r5 = r6 - r5
            goto L_0x0059
        L_0x004e:
            r8 = move-exception
            r9 = r1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x0095 }
            r9.getWritePosition()     // Catch:{ all -> 0x0095 }
            r9.getReadPosition()     // Catch:{ all -> 0x0095 }
            throw r8     // Catch:{ all -> 0x0095 }
        L_0x0059:
            if (r5 != 0) goto L_0x0063
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0060 }
            goto L_0x007d
        L_0x0060:
            r8 = move-exception
            r0 = r3
            goto L_0x0096
        L_0x0063:
            if (r5 < r2) goto L_0x0076
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0060 }
            int r6 = r5.getCapacity()     // Catch:{ all -> 0x0060 }
            int r5 = r5.getLimit()     // Catch:{ all -> 0x0060 }
            int r6 = r6 - r5
            if (r6 >= r4) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r4 = r1
            goto L_0x007d
        L_0x0076:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)     // Catch:{ all -> 0x0060 }
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r2)     // Catch:{ all -> 0x0060 }
        L_0x007d:
            if (r4 != 0) goto L_0x0081
            r0 = r3
            goto L_0x0084
        L_0x0081:
            r1 = r4
            if (r2 > 0) goto L_0x0014
        L_0x0084:
            if (r0 == 0) goto L_0x0089
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x0089:
            if (r10 > 0) goto L_0x008c
            return
        L_0x008c:
            io.ktor.utils.io.core.StringsKt.prematureEndOfStream((int) r10)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        L_0x0095:
            r8 = move-exception
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x009b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFully(io.ktor.utils.io.core.Input, double[], int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void readFully(io.ktor.utils.io.core.Input r6, io.ktor.utils.io.core.Buffer r7, int r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r0)
            if (r1 != 0) goto L_0x0012
            goto L_0x003b
        L_0x0012:
            r2 = 0
            r3 = r1
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3     // Catch:{ all -> 0x004c }
            int r4 = r3.getWritePosition()     // Catch:{ all -> 0x004c }
            int r5 = r3.getReadPosition()     // Catch:{ all -> 0x004c }
            int r4 = r4 - r5
            int r4 = java.lang.Math.min(r8, r4)     // Catch:{ all -> 0x004c }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully(r3, r7, r4)     // Catch:{ all -> 0x004c }
            int r8 = r8 - r4
            if (r8 <= 0) goto L_0x002b
            r3 = r0
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            if (r3 != 0) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r6, r1)     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x0047
            r0 = r2
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x003b:
            if (r8 > 0) goto L_0x003e
            return
        L_0x003e:
            io.ktor.utils.io.core.StringsKt.prematureEndOfStream((int) r8)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L_0x0047:
            r1 = r3
            goto L_0x0012
        L_0x0049:
            r7 = move-exception
            r0 = r2
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            if (r0 == 0) goto L_0x0052
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L_0x0052:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFully(io.ktor.utils.io.core.Input, io.ktor.utils.io.core.Buffer, int):void");
    }

    public static /* synthetic */ void readFully$default(Input input, Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer.getLimit() - buffer.getWritePosition();
        }
        readFully(input, buffer, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readAvailable(io.ktor.utils.io.core.Input r7, byte[] r8, int r9, int r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0013
            r2 = r10
            goto L_0x003e
        L_0x0013:
            r2 = r10
        L_0x0014:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0045 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0045 }
            int r6 = r4.getReadPosition()     // Catch:{ all -> 0x0045 }
            int r5 = r5 - r6
            int r5 = java.lang.Math.min(r2, r5)     // Catch:{ all -> 0x0045 }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r4, (byte[]) r8, (int) r9, (int) r5)     // Catch:{ all -> 0x0045 }
            int r2 = r2 - r5
            int r9 = r9 + r5
            if (r2 <= 0) goto L_0x002e
            r4 = r0
            goto L_0x002f
        L_0x002e:
            r4 = r3
        L_0x002f:
            if (r4 != 0) goto L_0x0032
            goto L_0x0039
        L_0x0032:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0042 }
            if (r4 != 0) goto L_0x0040
            r0 = r3
        L_0x0039:
            if (r0 == 0) goto L_0x003e
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x003e:
            int r10 = r10 - r2
            return r10
        L_0x0040:
            r1 = r4
            goto L_0x0014
        L_0x0042:
            r8 = move-exception
            r0 = r3
            goto L_0x0046
        L_0x0045:
            r8 = move-exception
        L_0x0046:
            if (r0 == 0) goto L_0x004b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x004b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, byte[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readAvailable(io.ktor.utils.io.core.Input r7, short[] r8, int r9, int r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0014
            r3 = r10
            goto L_0x008b
        L_0x0014:
            r3 = r10
            r2 = r0
        L_0x0016:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x008d }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x008d }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r6 - r5
            if (r6 < r2) goto L_0x0059
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004e }
            int r5 = r2.getWritePosition()     // Catch:{ all -> 0x004e }
            int r6 = r2.getReadPosition()     // Catch:{ all -> 0x004e }
            int r5 = r5 - r6
            r6 = 2
            int r5 = r5 / r6
            int r5 = java.lang.Math.min(r3, r5)     // Catch:{ all -> 0x004e }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (short[]) r8, (int) r9, (int) r5)     // Catch:{ all -> 0x004e }
            int r3 = r3 - r5
            int r9 = r9 + r5
            if (r3 <= 0) goto L_0x0040
            r2 = r6
            goto L_0x0041
        L_0x0040:
            r2 = r4
        L_0x0041:
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x008d }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x008d }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r6 - r5
            goto L_0x0059
        L_0x004e:
            r8 = move-exception
            r9 = r1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x008d }
            r9.getWritePosition()     // Catch:{ all -> 0x008d }
            r9.getReadPosition()     // Catch:{ all -> 0x008d }
            throw r8     // Catch:{ all -> 0x008d }
        L_0x0059:
            if (r6 != 0) goto L_0x0063
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0060 }
            goto L_0x007f
        L_0x0060:
            r8 = move-exception
            r0 = r4
            goto L_0x008e
        L_0x0063:
            if (r6 < r2) goto L_0x0078
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0060 }
            int r6 = r5.getCapacity()     // Catch:{ all -> 0x0060 }
            int r5 = r5.getLimit()     // Catch:{ all -> 0x0060 }
            int r6 = r6 - r5
            r5 = 8
            if (r6 >= r5) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r5 = r1
            goto L_0x007f
        L_0x0078:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)     // Catch:{ all -> 0x0060 }
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r2)     // Catch:{ all -> 0x0060 }
        L_0x007f:
            if (r5 != 0) goto L_0x0083
            r0 = r4
            goto L_0x0086
        L_0x0083:
            r1 = r5
            if (r2 > 0) goto L_0x0016
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x008b:
            int r10 = r10 - r3
            return r10
        L_0x008d:
            r8 = move-exception
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x0093:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, short[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readAvailable(io.ktor.utils.io.core.Input r7, int[] r8, int r9, int r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0014
            r3 = r10
            goto L_0x008b
        L_0x0014:
            r3 = r10
            r2 = r0
        L_0x0016:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x008d }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x008d }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r6 - r5
            if (r6 < r2) goto L_0x0059
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004e }
            int r5 = r2.getWritePosition()     // Catch:{ all -> 0x004e }
            int r6 = r2.getReadPosition()     // Catch:{ all -> 0x004e }
            int r5 = r5 - r6
            r6 = 4
            int r5 = r5 / r6
            int r5 = java.lang.Math.min(r3, r5)     // Catch:{ all -> 0x004e }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (int[]) r8, (int) r9, (int) r5)     // Catch:{ all -> 0x004e }
            int r3 = r3 - r5
            int r9 = r9 + r5
            if (r3 <= 0) goto L_0x0040
            r2 = r6
            goto L_0x0041
        L_0x0040:
            r2 = r4
        L_0x0041:
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x008d }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x008d }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r6 - r5
            goto L_0x0059
        L_0x004e:
            r8 = move-exception
            r9 = r1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x008d }
            r9.getWritePosition()     // Catch:{ all -> 0x008d }
            r9.getReadPosition()     // Catch:{ all -> 0x008d }
            throw r8     // Catch:{ all -> 0x008d }
        L_0x0059:
            if (r6 != 0) goto L_0x0063
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0060 }
            goto L_0x007f
        L_0x0060:
            r8 = move-exception
            r0 = r4
            goto L_0x008e
        L_0x0063:
            if (r6 < r2) goto L_0x0078
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0060 }
            int r6 = r5.getCapacity()     // Catch:{ all -> 0x0060 }
            int r5 = r5.getLimit()     // Catch:{ all -> 0x0060 }
            int r6 = r6 - r5
            r5 = 8
            if (r6 >= r5) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r5 = r1
            goto L_0x007f
        L_0x0078:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)     // Catch:{ all -> 0x0060 }
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r2)     // Catch:{ all -> 0x0060 }
        L_0x007f:
            if (r5 != 0) goto L_0x0083
            r0 = r4
            goto L_0x0086
        L_0x0083:
            r1 = r5
            if (r2 > 0) goto L_0x0016
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x008b:
            int r10 = r10 - r3
            return r10
        L_0x008d:
            r8 = move-exception
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x0093:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, int[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readAvailable(io.ktor.utils.io.core.Input r8, long[] r9, int r10, int r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r8, r0)
            if (r1 != 0) goto L_0x0014
            r3 = r11
            goto L_0x008b
        L_0x0014:
            r3 = r11
            r2 = r0
        L_0x0016:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x008d }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x008d }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r6 - r5
            r5 = 8
            if (r6 < r2) goto L_0x005b
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x0050 }
            int r6 = r2.getWritePosition()     // Catch:{ all -> 0x0050 }
            int r7 = r2.getReadPosition()     // Catch:{ all -> 0x0050 }
            int r6 = r6 - r7
            int r6 = r6 / r5
            int r6 = java.lang.Math.min(r3, r6)     // Catch:{ all -> 0x0050 }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (long[]) r9, (int) r10, (int) r6)     // Catch:{ all -> 0x0050 }
            int r3 = r3 - r6
            int r10 = r10 + r6
            if (r3 <= 0) goto L_0x0041
            r2 = r5
            goto L_0x0042
        L_0x0041:
            r2 = r4
        L_0x0042:
            r6 = r1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x008d }
            int r7 = r6.getWritePosition()     // Catch:{ all -> 0x008d }
            int r6 = r6.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r7 - r6
            goto L_0x005b
        L_0x0050:
            r9 = move-exception
            r10 = r1
            io.ktor.utils.io.core.Buffer r10 = (io.ktor.utils.io.core.Buffer) r10     // Catch:{ all -> 0x008d }
            r10.getWritePosition()     // Catch:{ all -> 0x008d }
            r10.getReadPosition()     // Catch:{ all -> 0x008d }
            throw r9     // Catch:{ all -> 0x008d }
        L_0x005b:
            if (r6 != 0) goto L_0x0065
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r8, r1)     // Catch:{ all -> 0x0062 }
            goto L_0x007f
        L_0x0062:
            r9 = move-exception
            r0 = r4
            goto L_0x008e
        L_0x0065:
            if (r6 < r2) goto L_0x0078
            r6 = r1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x0062 }
            int r7 = r6.getCapacity()     // Catch:{ all -> 0x0062 }
            int r6 = r6.getLimit()     // Catch:{ all -> 0x0062 }
            int r7 = r7 - r6
            if (r7 >= r5) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r5 = r1
            goto L_0x007f
        L_0x0078:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)     // Catch:{ all -> 0x0062 }
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r8, r2)     // Catch:{ all -> 0x0062 }
        L_0x007f:
            if (r5 != 0) goto L_0x0083
            r0 = r4
            goto L_0x0086
        L_0x0083:
            r1 = r5
            if (r2 > 0) goto L_0x0016
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L_0x008b:
            int r11 = r11 - r3
            return r11
        L_0x008d:
            r9 = move-exception
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L_0x0093:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, long[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readAvailable(io.ktor.utils.io.core.Input r7, float[] r8, int r9, int r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0014
            r3 = r10
            goto L_0x008b
        L_0x0014:
            r3 = r10
            r2 = r0
        L_0x0016:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x008d }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x008d }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r6 - r5
            if (r6 < r2) goto L_0x0059
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004e }
            int r5 = r2.getWritePosition()     // Catch:{ all -> 0x004e }
            int r6 = r2.getReadPosition()     // Catch:{ all -> 0x004e }
            int r5 = r5 - r6
            r6 = 4
            int r5 = r5 / r6
            int r5 = java.lang.Math.min(r3, r5)     // Catch:{ all -> 0x004e }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (float[]) r8, (int) r9, (int) r5)     // Catch:{ all -> 0x004e }
            int r3 = r3 - r5
            int r9 = r9 + r5
            if (r3 <= 0) goto L_0x0040
            r2 = r6
            goto L_0x0041
        L_0x0040:
            r2 = r4
        L_0x0041:
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x008d }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x008d }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r6 - r5
            goto L_0x0059
        L_0x004e:
            r8 = move-exception
            r9 = r1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x008d }
            r9.getWritePosition()     // Catch:{ all -> 0x008d }
            r9.getReadPosition()     // Catch:{ all -> 0x008d }
            throw r8     // Catch:{ all -> 0x008d }
        L_0x0059:
            if (r6 != 0) goto L_0x0063
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0060 }
            goto L_0x007f
        L_0x0060:
            r8 = move-exception
            r0 = r4
            goto L_0x008e
        L_0x0063:
            if (r6 < r2) goto L_0x0078
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x0060 }
            int r6 = r5.getCapacity()     // Catch:{ all -> 0x0060 }
            int r5 = r5.getLimit()     // Catch:{ all -> 0x0060 }
            int r6 = r6 - r5
            r5 = 8
            if (r6 >= r5) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r5 = r1
            goto L_0x007f
        L_0x0078:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)     // Catch:{ all -> 0x0060 }
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r2)     // Catch:{ all -> 0x0060 }
        L_0x007f:
            if (r5 != 0) goto L_0x0083
            r0 = r4
            goto L_0x0086
        L_0x0083:
            r1 = r5
            if (r2 > 0) goto L_0x0016
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x008b:
            int r10 = r10 - r3
            return r10
        L_0x008d:
            r8 = move-exception
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x0093:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, float[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readAvailable(io.ktor.utils.io.core.Input r8, double[] r9, int r10, int r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r8, r0)
            if (r1 != 0) goto L_0x0014
            r3 = r11
            goto L_0x008b
        L_0x0014:
            r3 = r11
            r2 = r0
        L_0x0016:
            r4 = 0
            r5 = r1
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch:{ all -> 0x008d }
            int r6 = r5.getWritePosition()     // Catch:{ all -> 0x008d }
            int r5 = r5.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r6 - r5
            r5 = 8
            if (r6 < r2) goto L_0x005b
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x0050 }
            int r6 = r2.getWritePosition()     // Catch:{ all -> 0x0050 }
            int r7 = r2.getReadPosition()     // Catch:{ all -> 0x0050 }
            int r6 = r6 - r7
            int r6 = r6 / r5
            int r6 = java.lang.Math.min(r3, r6)     // Catch:{ all -> 0x0050 }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully((io.ktor.utils.io.core.Buffer) r2, (double[]) r9, (int) r10, (int) r6)     // Catch:{ all -> 0x0050 }
            int r3 = r3 - r6
            int r10 = r10 + r6
            if (r3 <= 0) goto L_0x0041
            r2 = r5
            goto L_0x0042
        L_0x0041:
            r2 = r4
        L_0x0042:
            r6 = r1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x008d }
            int r7 = r6.getWritePosition()     // Catch:{ all -> 0x008d }
            int r6 = r6.getReadPosition()     // Catch:{ all -> 0x008d }
            int r6 = r7 - r6
            goto L_0x005b
        L_0x0050:
            r9 = move-exception
            r10 = r1
            io.ktor.utils.io.core.Buffer r10 = (io.ktor.utils.io.core.Buffer) r10     // Catch:{ all -> 0x008d }
            r10.getWritePosition()     // Catch:{ all -> 0x008d }
            r10.getReadPosition()     // Catch:{ all -> 0x008d }
            throw r9     // Catch:{ all -> 0x008d }
        L_0x005b:
            if (r6 != 0) goto L_0x0065
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r8, r1)     // Catch:{ all -> 0x0062 }
            goto L_0x007f
        L_0x0062:
            r9 = move-exception
            r0 = r4
            goto L_0x008e
        L_0x0065:
            if (r6 < r2) goto L_0x0078
            r6 = r1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x0062 }
            int r7 = r6.getCapacity()     // Catch:{ all -> 0x0062 }
            int r6 = r6.getLimit()     // Catch:{ all -> 0x0062 }
            int r7 = r7 - r6
            if (r7 >= r5) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r5 = r1
            goto L_0x007f
        L_0x0078:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)     // Catch:{ all -> 0x0062 }
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r8, r2)     // Catch:{ all -> 0x0062 }
        L_0x007f:
            if (r5 != 0) goto L_0x0083
            r0 = r4
            goto L_0x0086
        L_0x0083:
            r1 = r5
            if (r2 > 0) goto L_0x0016
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L_0x008b:
            int r11 = r11 - r3
            return r11
        L_0x008d:
            r9 = move-exception
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r8, r1)
        L_0x0093:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, double[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readAvailable(io.ktor.utils.io.core.Input r7, io.ktor.utils.io.core.Buffer r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0013
            r2 = r9
            goto L_0x003d
        L_0x0013:
            r2 = r9
        L_0x0014:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0044 }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x0044 }
            int r6 = r4.getReadPosition()     // Catch:{ all -> 0x0044 }
            int r5 = r5 - r6
            int r5 = java.lang.Math.min(r2, r5)     // Catch:{ all -> 0x0044 }
            io.ktor.utils.io.core.BufferPrimitivesKt.readFully(r4, r8, r5)     // Catch:{ all -> 0x0044 }
            int r2 = r2 - r5
            if (r2 <= 0) goto L_0x002d
            r4 = r0
            goto L_0x002e
        L_0x002d:
            r4 = r3
        L_0x002e:
            if (r4 != 0) goto L_0x0031
            goto L_0x0038
        L_0x0031:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            r0 = r3
        L_0x0038:
            if (r0 == 0) goto L_0x003d
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x003d:
            int r9 = r9 - r2
            return r9
        L_0x003f:
            r1 = r4
            goto L_0x0014
        L_0x0041:
            r8 = move-exception
            r0 = r3
            goto L_0x0045
        L_0x0044:
            r8 = move-exception
        L_0x0045:
            if (r0 == 0) goto L_0x004a
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x004a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readAvailable(io.ktor.utils.io.core.Input, io.ktor.utils.io.core.Buffer, int):int");
    }

    public static /* synthetic */ int readAvailable$default(Input input, Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer.getLimit() - buffer.getWritePosition();
        }
        return readAvailable(input, buffer, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* renamed from: readAvailable-UAd2zVI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long m228readAvailableUAd2zVI(io.ktor.utils.io.core.Input r19, java.nio.ByteBuffer r20, long r21, long r23) {
        /*
            r1 = r19
            java.lang.String r0 = "$this$readAvailable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "destination"
            r10 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r11 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r11)
            if (r0 != 0) goto L_0x0018
            r6 = r23
            goto L_0x0067
        L_0x0018:
            r14 = r21
            r6 = r23
            r8 = r0
        L_0x001d:
            r16 = 0
            r0 = r8
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.io.core.Buffer) r0     // Catch:{ all -> 0x0082 }
            int r2 = r0.getWritePosition()     // Catch:{ all -> 0x0082 }
            int r3 = r0.getReadPosition()     // Catch:{ all -> 0x0082 }
            int r2 = r2 - r3
            long r2 = (long) r2     // Catch:{ all -> 0x0082 }
            long r2 = java.lang.Math.min(r6, r2)     // Catch:{ all -> 0x0082 }
            int r9 = (int) r2     // Catch:{ all -> 0x0082 }
            java.nio.ByteBuffer r2 = r0.m184getMemorySK3TCg8()     // Catch:{ all -> 0x0082 }
            int r3 = r0.getReadPosition()     // Catch:{ all -> 0x0082 }
            long r4 = (long) r3
            long r11 = (long) r9
            r3 = r20
            r17 = r6
            r6 = r11
            r13 = r8
            r10 = r9
            r8 = r14
            io.ktor.utils.io.bits.Memory.m42copyToJT6ljtQ((java.nio.ByteBuffer) r2, (java.nio.ByteBuffer) r3, (long) r4, (long) r6, (long) r8)     // Catch:{ all -> 0x0080 }
            r0.discardExact(r10)     // Catch:{ all -> 0x0080 }
            long r6 = r17 - r11
            long r14 = r14 + r11
            r2 = 0
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0054
            r0 = 1
            goto L_0x0056
        L_0x0054:
            r0 = r16
        L_0x0056:
            if (r0 != 0) goto L_0x005a
            r11 = 1
            goto L_0x0062
        L_0x005a:
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r13)     // Catch:{ all -> 0x007c }
            if (r8 != 0) goto L_0x0078
            r11 = r16
        L_0x0062:
            if (r11 == 0) goto L_0x0067
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r13)
        L_0x0067:
            long r2 = r23 - r6
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0077
            boolean r0 = r19.getEndOfInput()
            if (r0 == 0) goto L_0x0077
            r2 = -1
        L_0x0077:
            return r2
        L_0x0078:
            r10 = r20
            r11 = 1
            goto L_0x001d
        L_0x007c:
            r0 = move-exception
            r11 = r16
            goto L_0x0085
        L_0x0080:
            r0 = move-exception
            goto L_0x0084
        L_0x0082:
            r0 = move-exception
            r13 = r8
        L_0x0084:
            r11 = 1
        L_0x0085:
            if (r11 == 0) goto L_0x008a
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r13)
        L_0x008a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.m228readAvailableUAd2zVI(io.ktor.utils.io.core.Input, java.nio.ByteBuffer, long, long):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int readFullyBytesTemplate(io.ktor.utils.io.core.Input r7, int r8, int r9, kotlin.jvm.functions.Function3<? super io.ktor.utils.io.core.Buffer, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> r10) {
        /*
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0008
            goto L_0x0040
        L_0x0008:
            r2 = 0
            r3 = r1
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3     // Catch:{ all -> 0x0045 }
            int r4 = r3.getWritePosition()     // Catch:{ all -> 0x0045 }
            int r5 = r3.getReadPosition()     // Catch:{ all -> 0x0045 }
            int r4 = r4 - r5
            int r4 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x0045 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0045 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0045 }
            r10.invoke(r3, r5, r6)     // Catch:{ all -> 0x0045 }
            int r9 = r9 - r4
            int r8 = r8 + r4
            if (r9 <= 0) goto L_0x002a
            r3 = r0
            goto L_0x002b
        L_0x002a:
            r3 = r2
        L_0x002b:
            if (r3 != 0) goto L_0x002f
            r2 = r0
            goto L_0x0035
        L_0x002f:
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0043 }
            if (r3 != 0) goto L_0x0041
        L_0x0035:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r2 == 0) goto L_0x003d
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x003d:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
        L_0x0040:
            return r9
        L_0x0041:
            r1 = r3
            goto L_0x0008
        L_0x0043:
            r8 = move-exception
            goto L_0x0047
        L_0x0045:
            r8 = move-exception
            r2 = r0
        L_0x0047:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r2 == 0) goto L_0x004f
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x004f:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFullyBytesTemplate(io.ktor.utils.io.core.Input, int, int, kotlin.jvm.functions.Function3):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final long readFullyBytesTemplate(io.ktor.utils.io.core.Input r9, long r10, long r12, kotlin.jvm.functions.Function4<? super io.ktor.utils.io.bits.Memory, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Integer, kotlin.Unit> r14) {
        /*
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r9, r0)
            if (r1 != 0) goto L_0x0008
            goto L_0x005b
        L_0x0008:
            r2 = 0
            r3 = r1
            io.ktor.utils.io.core.Buffer r3 = (io.ktor.utils.io.core.Buffer) r3     // Catch:{ all -> 0x0060 }
            int r4 = r3.getWritePosition()     // Catch:{ all -> 0x0060 }
            int r5 = r3.getReadPosition()     // Catch:{ all -> 0x0060 }
            int r4 = r4 - r5
            long r4 = (long) r4     // Catch:{ all -> 0x0060 }
            long r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x0060 }
            int r4 = (int) r4     // Catch:{ all -> 0x0060 }
            java.nio.ByteBuffer r5 = r3.m184getMemorySK3TCg8()     // Catch:{ all -> 0x0060 }
            io.ktor.utils.io.bits.Memory r5 = io.ktor.utils.io.bits.Memory.m39boximpl(r5)     // Catch:{ all -> 0x0060 }
            int r6 = r3.getReadPosition()     // Catch:{ all -> 0x0060 }
            long r6 = (long) r6     // Catch:{ all -> 0x0060 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0060 }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0060 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0060 }
            r14.invoke(r5, r6, r7, r8)     // Catch:{ all -> 0x0060 }
            r3.discardExact(r4)     // Catch:{ all -> 0x0060 }
            long r3 = (long) r4
            long r12 = r12 - r3
            long r10 = r10 + r3
            r3 = 0
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0045
            r3 = r0
            goto L_0x0046
        L_0x0045:
            r3 = r2
        L_0x0046:
            if (r3 != 0) goto L_0x004a
            r2 = r0
            goto L_0x0050
        L_0x004a:
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r9, r1)     // Catch:{ all -> 0x005e }
            if (r3 != 0) goto L_0x005c
        L_0x0050:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r2 == 0) goto L_0x0058
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r9, r1)
        L_0x0058:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
        L_0x005b:
            return r12
        L_0x005c:
            r1 = r3
            goto L_0x0008
        L_0x005e:
            r10 = move-exception
            goto L_0x0062
        L_0x0060:
            r10 = move-exception
            r2 = r0
        L_0x0062:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r2 == 0) goto L_0x006a
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r9, r1)
        L_0x006a:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFullyBytesTemplate(io.ktor.utils.io.core.Input, long, long, kotlin.jvm.functions.Function4):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int readFullyTemplate(io.ktor.utils.io.core.Input r7, int r8, int r9, int r10, kotlin.jvm.functions.Function3<? super io.ktor.utils.io.core.Buffer, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> r11) {
        /*
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r0)
            if (r1 != 0) goto L_0x0009
            goto L_0x0097
        L_0x0009:
            r2 = r0
        L_0x000a:
            r3 = 0
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x009b }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x009b }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x009b }
            int r5 = r5 - r4
            if (r5 < r2) goto L_0x0060
            r2 = r1
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2     // Catch:{ all -> 0x004f }
            int r4 = r2.getWritePosition()     // Catch:{ all -> 0x004f }
            int r5 = r2.getReadPosition()     // Catch:{ all -> 0x004f }
            int r4 = r4 - r5
            int r4 = r4 / r10
            int r4 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x004f }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x004f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x004f }
            r11.invoke(r2, r5, r6)     // Catch:{ all -> 0x004f }
            int r9 = r9 - r4
            int r8 = r8 + r4
            if (r9 <= 0) goto L_0x003b
            r2 = r10
            goto L_0x003c
        L_0x003b:
            r2 = r3
        L_0x003c:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)     // Catch:{ all -> 0x009b }
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x009b }
            int r5 = r4.getWritePosition()     // Catch:{ all -> 0x009b }
            int r4 = r4.getReadPosition()     // Catch:{ all -> 0x009b }
            int r5 = r5 - r4
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)     // Catch:{ all -> 0x009b }
            goto L_0x0060
        L_0x004f:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)     // Catch:{ all -> 0x009b }
            r9 = r1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch:{ all -> 0x009b }
            r9.getWritePosition()     // Catch:{ all -> 0x009b }
            r9.getReadPosition()     // Catch:{ all -> 0x009b }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)     // Catch:{ all -> 0x009b }
            throw r8     // Catch:{ all -> 0x009b }
        L_0x0060:
            if (r5 != 0) goto L_0x0069
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r7, r1)     // Catch:{ all -> 0x0067 }
            goto L_0x0085
        L_0x0067:
            r8 = move-exception
            goto L_0x009d
        L_0x0069:
            if (r5 < r2) goto L_0x007e
            r4 = r1
            io.ktor.utils.io.core.Buffer r4 = (io.ktor.utils.io.core.Buffer) r4     // Catch:{ all -> 0x0067 }
            int r5 = r4.getCapacity()     // Catch:{ all -> 0x0067 }
            int r4 = r4.getLimit()     // Catch:{ all -> 0x0067 }
            int r5 = r5 - r4
            r4 = 8
            if (r5 >= r4) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r4 = r1
            goto L_0x0085
        L_0x007e:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)     // Catch:{ all -> 0x0067 }
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r7, r2)     // Catch:{ all -> 0x0067 }
        L_0x0085:
            if (r4 != 0) goto L_0x0088
            goto L_0x008c
        L_0x0088:
            if (r2 > 0) goto L_0x0098
            r3 = r0
            r1 = r4
        L_0x008c:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r3 == 0) goto L_0x0094
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x0094:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
        L_0x0097:
            return r9
        L_0x0098:
            r1 = r4
            goto L_0x000a
        L_0x009b:
            r8 = move-exception
            r3 = r0
        L_0x009d:
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            if (r3 == 0) goto L_0x00a5
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r7, r1)
        L_0x00a5:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.readFullyTemplate(io.ktor.utils.io.core.Input, int, int, int, kotlin.jvm.functions.Function3):int");
    }
}
