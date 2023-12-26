package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a*\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a/\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a/\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0017\u001a\u001c\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00182\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001a2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a[\u0010\u001f\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072<\u0010 \u001a8\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0!H\b\u001a\u0001\u0010\u001f\u001a\u00020\u000b*\u00020\u00032\u0006\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2`\u0010 \u001a\\\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0'H\bø\u0001\u0000\u001ac\u0010*\u001a\u00020\u000b*\u00020\u00032\u0006\u0010+\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072<\u0010 \u001a8\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0!H\b\u001a$\u0010,\u001a\u00020\u000b*\u00020\u00032\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020.0-H\bø\u0001\u0002\u001a.\u0010/\u001a\u00020\u000b*\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00072\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070-H\bø\u0001\u0002\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u00061"}, d2 = {"append", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lio/ktor/utils/io/core/Output;", "csq", "", "start", "", "end", "", "fill", "", "times", "", "value", "", "writeFully", "src", "Lio/ktor/utils/io/bits/Memory;", "offset", "length", "writeFully-UAd2zVI", "(Lio/ktor/utils/io/core/Output;Ljava/nio/ByteBuffer;II)V", "(Lio/ktor/utils/io/core/Output;Ljava/nio/ByteBuffer;JJ)V", "Lio/ktor/utils/io/core/Buffer;", "", "", "", "", "", "", "writeFullyBytesTemplate", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "currentOffset", "count", "initialOffset", "Lkotlin/Function4;", "destination", "destinationOffset", "writeFullyTemplate", "componentSize", "writeWhile", "Lkotlin/Function1;", "", "writeWhileSize", "initialSize", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Output.kt */
public final class OutputKt {
    public static /* synthetic */ Appendable append$default(Output output, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return append(output, charSequence, i, i2);
    }

    public static final Appendable append(Output output, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "csq");
        return output.append(charSequence, i, i2);
    }

    public static /* synthetic */ Appendable append$default(Output output, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return append(output, cArr, i, i2);
    }

    public static final Appendable append(Output output, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "csq");
        return output.append(cArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        writeFully(output, bArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFully(output, sArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFully(output, iArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFully(output, jArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFully(output, fArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFully(output, dArr, i, i2);
    }

    /* renamed from: writeFully-UAd2zVI  reason: not valid java name */
    public static final void m258writeFullyUAd2zVI(Output output, ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(byteBuffer, "src");
        m259writeFullyUAd2zVI(output, byteBuffer, (long) i, (long) i2);
    }

    public static /* synthetic */ void fill$default(Output output, long j, byte b, int i, Object obj) {
        if ((i & 2) != 0) {
            b = 0;
        }
        fill(output, j, b);
    }

    public static final void writeWhile(Output output, Function1<? super Buffer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (((Boolean) function1.invoke(prepareWriteHead)).booleanValue()) {
            try {
                prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static /* synthetic */ void writeWhileSize$default(Output output, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, i, (ChunkBuffer) null);
        while (true) {
            try {
                int intValue = ((Number) function1.invoke(prepareWriteHead)).intValue();
                if (intValue > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, intValue, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static final void writeWhileSize(Output output, int i, Function1<? super Buffer, Integer> function1) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, i, (ChunkBuffer) null);
        while (true) {
            try {
                int intValue = ((Number) function1.invoke(prepareWriteHead)).intValue();
                if (intValue > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, intValue, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static final void writeFully(Output output, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min(i2, buffer.getLimit() - buffer.getWritePosition());
                BufferPrimitivesKt.writeFully(buffer, bArr, i, min);
                i += min;
                i2 -= min;
                if (i2 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 2, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min(i2, buffer.getLimit() - buffer.getWritePosition());
                BufferPrimitivesKt.writeFully(buffer, sArr, i, min);
                i += min;
                i2 -= min;
                int i3 = i2 * 2;
                if (i3 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min(i2, buffer.getLimit() - buffer.getWritePosition());
                BufferPrimitivesKt.writeFully(buffer, iArr, i, min);
                i += min;
                i2 -= min;
                int i3 = i2 * 4;
                if (i3 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min(i2, buffer.getLimit() - buffer.getWritePosition());
                BufferPrimitivesKt.writeFully(buffer, jArr, i, min);
                i += min;
                i2 -= min;
                int i3 = i2 * 8;
                if (i3 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min(i2, buffer.getLimit() - buffer.getWritePosition());
                BufferPrimitivesKt.writeFully(buffer, fArr, i, min);
                i += min;
                i2 -= min;
                int i3 = i2 * 4;
                if (i3 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min(i2, buffer.getLimit() - buffer.getWritePosition());
                BufferPrimitivesKt.writeFully(buffer, dArr, i, min);
                i += min;
                i2 -= min;
                int i3 = i2 * 8;
                if (i3 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "src");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer2 = prepareWriteHead;
                int min = Math.min(i, buffer2.getLimit() - buffer2.getWritePosition());
                BufferPrimitivesKt.writeFully(buffer2, buffer, min);
                i -= min;
                if (i > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static /* synthetic */ void writeFully$default(Output output, Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer.getWritePosition() - buffer.getReadPosition();
        }
        writeFully(output, buffer, i);
    }

    /* renamed from: writeFully-UAd2zVI  reason: not valid java name */
    public static final void m259writeFullyUAd2zVI(Output output, ByteBuffer byteBuffer, long j, long j2) {
        Output output2 = output;
        Intrinsics.checkNotNullParameter(output2, "$this$writeFully");
        Intrinsics.checkNotNullParameter(byteBuffer, "src");
        long j3 = j;
        long j4 = j2;
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output2, 1, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                long min = Math.min(j4, (long) (buffer.getLimit() - buffer.getWritePosition()));
                Memory.m42copyToJT6ljtQ(byteBuffer, buffer.m184getMemorySK3TCg8(), j3, min, (long) buffer.getWritePosition());
                long j5 = min;
                buffer.commitWritten((int) j5);
                j3 += j5;
                j4 -= j5;
                if (j4 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output2, 1, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void fill(Output output, long j, byte b) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        long j2 = 0;
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = (int) Math.min((long) (buffer.getLimit() - buffer.getWritePosition()), j - j2);
                BufferCompatibilityKt.fill(buffer, min, b);
                j2 += (long) min;
                if (j2 < j) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    private static final void writeFullyBytesTemplate(Output output, int i, int i2, Function3<? super Buffer, ? super Integer, ? super Integer, Unit> function3) {
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min(i2, buffer.getLimit() - buffer.getWritePosition());
                function3.invoke(buffer, Integer.valueOf(i), Integer.valueOf(min));
                i += min;
                i2 -= min;
                if (i2 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private static final void writeFullyBytesTemplate(Output output, long j, long j2, Function4<? super Memory, ? super Long, ? super Long, ? super Long, Unit> function4) {
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                long min = Math.min(j2, (long) (buffer.getLimit() - buffer.getWritePosition()));
                function4.invoke(Memory.m39boximpl(buffer.m184getMemorySK3TCg8()), Long.valueOf((long) buffer.getWritePosition()), Long.valueOf(j), Long.valueOf(min));
                buffer.commitWritten((int) min);
                j += min;
                j2 -= min;
                if (j2 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private static final void writeFullyTemplate(Output output, int i, int i2, int i3, Function3<? super Buffer, ? super Integer, ? super Integer, Unit> function3) {
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, i, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min(i3, buffer.getLimit() - buffer.getWritePosition());
                function3.invoke(buffer, Integer.valueOf(i2), Integer.valueOf(min));
                i2 += min;
                i3 -= min;
                int i4 = i3 * i;
                if (i4 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i4, prepareWriteHead);
                } else {
                    return;
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }
}
