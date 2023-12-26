package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.Metadata;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\b\bH\b¢\u0006\u0002\u0010\t\u001aU\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\b\bH\b¢\u0006\u0002\u0010\f\u001aD\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u001d\u0010\u0013\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\bH\b\u001aD\u0010\r\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u001d\u0010\u0013\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\bH\b\u001a\u001a\u0010\u0016\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0017\u001a\u001a\u0010\u0019\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u001a\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020 2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020!2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\"2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020#2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020&2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020 2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020!2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\"2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020#2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010,\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020&2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010-\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u001d\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010.\u001a\u001a\u0010/\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u00100\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0010\u001a\u0012\u00100\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0010\u001a\u001a\u00101\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u0002022\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u00103\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u000202\u001a\u0012\u00103\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u000202\u001a\u001a\u00104\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u0002052\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u00106\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0004\u001a\u000205\u001a\u0012\u00106\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0004\u001a\u000205\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"writePrimitiveTemplate", "", "T", "", "value", "write", "Lkotlin/Function1;", "reverse", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Ljava/lang/Object;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "writeArrayTemplate", "Lio/ktor/utils/io/core/Buffer;", "offset", "", "length", "componentSize", "writeComponent", "Lkotlin/Function2;", "Lio/ktor/utils/io/core/Output;", "writeDouble", "", "writeDoubleLittleEndian", "writeFloat", "", "writeFloatLittleEndian", "writeFullyLittleEndian", "source", "", "", "", "", "", "Lkotlin/UIntArray;", "writeFullyLittleEndian-o2ZM2JE", "(Lio/ktor/utils/io/core/Buffer;[III)V", "Lkotlin/ULongArray;", "writeFullyLittleEndian-pqYNikA", "(Lio/ktor/utils/io/core/Buffer;[JII)V", "Lkotlin/UShortArray;", "writeFullyLittleEndian-Wt3Bwxc", "(Lio/ktor/utils/io/core/Buffer;[SII)V", "(Lio/ktor/utils/io/core/Output;[III)V", "(Lio/ktor/utils/io/core/Output;[JII)V", "(Lio/ktor/utils/io/core/Output;[SII)V", "writeInt", "writeIntLittleEndian", "writeLong", "", "writeLongLittleEndian", "writeShort", "", "writeShortLittleEndian", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutputLittleEndian.kt */
public final class OutputLittleEndianKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OutputLittleEndian.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ByteOrder.values().length];
            iArr[ByteOrder.BIG_ENDIAN.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: writeFullyLittleEndian-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ void m263writeFullyLittleEndianWt3Bwxc$default(Output output, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        m261writeFullyLittleEndianWt3Bwxc(output, sArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-Wt3Bwxc  reason: not valid java name */
    public static final void m261writeFullyLittleEndianWt3Bwxc(Output output, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(sArr, "source");
        writeFullyLittleEndian(output, sArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ void m262writeFullyLittleEndianWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        m260writeFullyLittleEndianWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-Wt3Bwxc  reason: not valid java name */
    public static final void m260writeFullyLittleEndianWt3Bwxc(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(sArr, "source");
        writeFullyLittleEndian(buffer, sArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFullyLittleEndian(output, sArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ void m267writeFullyLittleEndiano2ZM2JE$default(Output output, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        m265writeFullyLittleEndiano2ZM2JE(output, iArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-o2ZM2JE  reason: not valid java name */
    public static final void m265writeFullyLittleEndiano2ZM2JE(Output output, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(iArr, "source");
        writeFullyLittleEndian(output, iArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFullyLittleEndian(output, iArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ void m271writeFullyLittleEndianpqYNikA$default(Output output, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        m269writeFullyLittleEndianpqYNikA(output, jArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-pqYNikA  reason: not valid java name */
    public static final void m269writeFullyLittleEndianpqYNikA(Output output, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(jArr, "source");
        writeFullyLittleEndian(output, jArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFullyLittleEndian(output, jArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFullyLittleEndian(output, fArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Output output, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFullyLittleEndian(output, dArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFullyLittleEndian(buffer, sArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ void m266writeFullyLittleEndiano2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        m264writeFullyLittleEndiano2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-o2ZM2JE  reason: not valid java name */
    public static final void m264writeFullyLittleEndiano2ZM2JE(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(iArr, "source");
        writeFullyLittleEndian(buffer, iArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFullyLittleEndian(buffer, iArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ void m270writeFullyLittleEndianpqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        m268writeFullyLittleEndianpqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: writeFullyLittleEndian-pqYNikA  reason: not valid java name */
    public static final void m268writeFullyLittleEndianpqYNikA(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeFullyLittleEndian");
        Intrinsics.checkNotNullParameter(jArr, "source");
        writeFullyLittleEndian(buffer, jArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFullyLittleEndian(buffer, jArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFullyLittleEndian(buffer, fArr, i, i2);
    }

    public static /* synthetic */ void writeFullyLittleEndian$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFullyLittleEndian(buffer, dArr, i, i2);
    }

    private static final <T> void writePrimitiveTemplate(T t, Function1<? super T, Unit> function1, Function1<? super T, ? extends T> function12) {
        function1.invoke(function12.invoke(t));
    }

    private static final <T> void writePrimitiveTemplate(T t, ByteOrder byteOrder, Function1<? super T, Unit> function1, Function1<? super T, ? extends T> function12) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            t = function12.invoke(t);
        }
        function1.invoke(t);
    }

    public static final void writeShort(Output output, short s, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            s = Short.reverseBytes(s);
        }
        OutputPrimitivesKt.writeShort(output, s);
    }

    public static final void writeInt(Output output, int i, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            i = Integer.reverseBytes(i);
        }
        OutputPrimitivesKt.writeInt(output, i);
    }

    public static final void writeLong(Output output, long j, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            j = Long.reverseBytes(j);
        }
        OutputPrimitivesKt.writeLong(output, j);
    }

    public static final void writeFloat(Output output, float f, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            f = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
        }
        OutputPrimitivesKt.writeFloat(output, f);
    }

    public static final void writeDouble(Output output, double d, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 1) {
            d = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
        }
        OutputPrimitivesKt.writeDouble(output, d);
    }

    public static final void writeShortLittleEndian(Output output, short s) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeShort(output, Short.reverseBytes(s));
    }

    public static final void writeIntLittleEndian(Output output, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeInt(output, Integer.reverseBytes(i));
    }

    public static final void writeLongLittleEndian(Output output, long j) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeLong(output, Long.reverseBytes(j));
    }

    public static final void writeFloatLittleEndian(Output output, float f) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeFloat(output, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f))));
    }

    public static final void writeDoubleLittleEndian(Output output, double d) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        OutputPrimitivesKt.writeDouble(output, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d))));
    }

    public static final void writeShortLittleEndian(Buffer buffer, short s) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeShort(buffer, Short.reverseBytes(s));
    }

    public static final void writeIntLittleEndian(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeInt(buffer, Integer.reverseBytes(i));
    }

    public static final void writeLongLittleEndian(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeLong(buffer, Long.reverseBytes(j));
    }

    public static final void writeFloatLittleEndian(Buffer buffer, float f) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeFloat(buffer, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f))));
    }

    public static final void writeDoubleLittleEndian(Buffer buffer, double d) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        BufferPrimitivesKt.writeDouble(buffer, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d))));
    }

    public static final void writeFullyLittleEndian(Output output, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "source");
        int i3 = i2 + i;
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 2, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min((buffer.getLimit() - buffer.getWritePosition()) / 2, i3 - i) + i;
                int i4 = min - 1;
                if (i <= i4) {
                    while (true) {
                        BufferPrimitivesKt.writeShort(buffer, Short.reverseBytes(sArr[i]));
                        if (i == i4) {
                            break;
                        }
                        i++;
                    }
                }
                int i5 = min < i3 ? 2 : 0;
                if (i5 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i5, prepareWriteHead);
                    i = min;
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFullyLittleEndian(Output output, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "source");
        int i3 = i2 + i;
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min((buffer.getLimit() - buffer.getWritePosition()) / 4, i3 - i) + i;
                int i4 = min - 1;
                if (i <= i4) {
                    while (true) {
                        BufferPrimitivesKt.writeInt(buffer, Integer.reverseBytes(iArr[i]));
                        if (i == i4) {
                            break;
                        }
                        i++;
                    }
                }
                int i5 = min < i3 ? 4 : 0;
                if (i5 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i5, prepareWriteHead);
                    i = min;
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFullyLittleEndian(Output output, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "source");
        int i3 = i2 + i;
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min((buffer.getLimit() - buffer.getWritePosition()) / 8, i3 - i) + i;
                int i4 = min - 1;
                if (i <= i4) {
                    while (true) {
                        BufferPrimitivesKt.writeLong(buffer, Long.reverseBytes(jArr[i]));
                        if (i == i4) {
                            break;
                        }
                        i++;
                    }
                }
                int i5 = min < i3 ? 8 : 0;
                if (i5 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i5, prepareWriteHead);
                    i = min;
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFullyLittleEndian(Output output, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "source");
        int i3 = i2 + i;
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min((buffer.getLimit() - buffer.getWritePosition()) / 4, i3 - i) + i;
                int i4 = min - 1;
                if (i <= i4) {
                    while (true) {
                        BufferPrimitivesKt.writeFloat(buffer, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i]))));
                        if (i == i4) {
                            break;
                        }
                        i++;
                    }
                }
                int i5 = min < i3 ? 4 : 0;
                if (i5 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i5, prepareWriteHead);
                    i = min;
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFullyLittleEndian(Output output, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "source");
        int i3 = i2 + i;
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min((buffer.getLimit() - buffer.getWritePosition()) / 8, i3 - i) + i;
                int i4 = min - 1;
                if (i <= i4) {
                    while (true) {
                        BufferPrimitivesKt.writeDouble(buffer, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i]))));
                        if (i == i4) {
                            break;
                        }
                        i++;
                    }
                }
                int i5 = min < i3 ? 8 : 0;
                if (i5 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i5, prepareWriteHead);
                    i = min;
                } else {
                    return;
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "source");
        int min = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 2, (i2 + i) - i) + i) - 1;
        if (i <= min) {
            while (true) {
                BufferPrimitivesKt.writeShort(buffer, Short.reverseBytes(sArr[i]));
                if (i != min) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "source");
        int min = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 4, (i2 + i) - i) + i) - 1;
        if (i <= min) {
            while (true) {
                BufferPrimitivesKt.writeInt(buffer, Integer.reverseBytes(iArr[i]));
                if (i != min) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "source");
        int min = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 8, (i2 + i) - i) + i) - 1;
        if (i <= min) {
            while (true) {
                BufferPrimitivesKt.writeLong(buffer, Long.reverseBytes(jArr[i]));
                if (i != min) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "source");
        int min = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 4, (i2 + i) - i) + i) - 1;
        if (i <= min) {
            while (true) {
                BufferPrimitivesKt.writeFloat(buffer, Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i]))));
                if (i != min) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final void writeFullyLittleEndian(Buffer buffer, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "source");
        int min = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / 8, (i2 + i) - i) + i) - 1;
        if (i <= min) {
            while (true) {
                BufferPrimitivesKt.writeDouble(buffer, Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i]))));
                if (i != min) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static final void writeArrayTemplate(Output output, int i, int i2, int i3, Function2<? super Buffer, ? super Integer, Unit> function2) {
        int i4 = i2 + i;
        ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, (ChunkBuffer) null);
        while (true) {
            try {
                Buffer buffer = prepareWriteHead;
                int min = Math.min((buffer.getLimit() - buffer.getWritePosition()) / i3, i4 - i) + i;
                int i5 = min - 1;
                if (i <= i5) {
                    while (true) {
                        function2.invoke(buffer, Integer.valueOf(i));
                        if (i == i5) {
                            break;
                        }
                        i++;
                    }
                }
                int i6 = min < i4 ? i3 : 0;
                if (i6 > 0) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, i6, prepareWriteHead);
                    i = min;
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

    private static final void writeArrayTemplate(Buffer buffer, int i, int i2, int i3, Function2<? super Buffer, ? super Integer, Unit> function2) {
        int min = (Math.min((buffer.getLimit() - buffer.getWritePosition()) / i3, (i2 + i) - i) + i) - 1;
        if (i <= min) {
            while (true) {
                function2.invoke(buffer, Integer.valueOf(i));
                if (i != min) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
