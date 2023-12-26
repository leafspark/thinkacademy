package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u0017*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a6\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a6\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a6\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u001a6\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a\"\u0010*\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a\"\u0010.\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u0017H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001a\"\u00101\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u001aH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001a\"\u00104\u001a\u00020\u0001*\u00020 2\u0006\u0010+\u001a\u00020\u001dH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"readFully", "", "Lio/ktor/utils/io/core/Input;", "dst", "Lkotlin/UByteArray;", "offset", "", "length", "readFully-o1GoV1E", "(Lio/ktor/utils/io/core/Input;[BII)V", "Lkotlin/UIntArray;", "readFully-o2ZM2JE", "(Lio/ktor/utils/io/core/Input;[III)V", "Lkotlin/ULongArray;", "readFully-pqYNikA", "(Lio/ktor/utils/io/core/Input;[JII)V", "Lkotlin/UShortArray;", "readFully-Wt3Bwxc", "(Lio/ktor/utils/io/core/Input;[SII)V", "readUByte", "Lkotlin/UByte;", "(Lio/ktor/utils/io/core/Input;)B", "readUInt", "Lkotlin/UInt;", "(Lio/ktor/utils/io/core/Input;)I", "readULong", "Lkotlin/ULong;", "(Lio/ktor/utils/io/core/Input;)J", "readUShort", "Lkotlin/UShort;", "(Lio/ktor/utils/io/core/Input;)S", "writeFully", "Lio/ktor/utils/io/core/Output;", "array", "writeFully-o1GoV1E", "(Lio/ktor/utils/io/core/Output;[BII)V", "writeFully-o2ZM2JE", "(Lio/ktor/utils/io/core/Output;[III)V", "writeFully-pqYNikA", "(Lio/ktor/utils/io/core/Output;[JII)V", "writeFully-Wt3Bwxc", "(Lio/ktor/utils/io/core/Output;[SII)V", "writeUByte", "v", "writeUByte-EK-6454", "(Lio/ktor/utils/io/core/Output;B)V", "writeUInt", "writeUInt-Qn1smSk", "(Lio/ktor/utils/io/core/Output;I)V", "writeULong", "writeULong-2TYgG_w", "(Lio/ktor/utils/io/core/Output;J)V", "writeUShort", "writeUShort-i8woANY", "(Lio/ktor/utils/io/core/Output;S)V", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnsignedTypes.kt */
public final class UnsignedTypesKt {
    public static final byte readUByte(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UByte.m338constructorimpl(input.readByte());
    }

    public static final short readUShort(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UShort.m598constructorimpl(InputPrimitivesKt.readShort(input));
    }

    public static final int readUInt(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return UInt.m414constructorimpl(InputPrimitivesKt.readInt(input));
    }

    public static final long readULong(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return ULong.m492constructorimpl(InputPrimitivesKt.readLong(input));
    }

    /* renamed from: readFully-o1GoV1E$default  reason: not valid java name */
    public static /* synthetic */ void m275readFullyo1GoV1E$default(Input input, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m396getSizeimpl(bArr) - i;
        }
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(bArr, "dst");
        InputArraysKt.readFully(input, bArr, i, i2);
    }

    /* renamed from: readFully-o1GoV1E  reason: not valid java name */
    public static final void m274readFullyo1GoV1E(Input input, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(bArr, "dst");
        InputArraysKt.readFully(input, bArr, i, i2);
    }

    /* renamed from: readFully-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ void m273readFullyWt3Bwxc$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        InputArraysKt.readFully(input, sArr, i, i2);
    }

    /* renamed from: readFully-Wt3Bwxc  reason: not valid java name */
    public static final void m272readFullyWt3Bwxc(Input input, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        InputArraysKt.readFully(input, sArr, i, i2);
    }

    /* renamed from: readFully-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ void m277readFullyo2ZM2JE$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        InputArraysKt.readFully(input, iArr, i, i2);
    }

    /* renamed from: readFully-o2ZM2JE  reason: not valid java name */
    public static final void m276readFullyo2ZM2JE(Input input, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        InputArraysKt.readFully(input, iArr, i, i2);
    }

    /* renamed from: readFully-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ void m279readFullypqYNikA$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        InputArraysKt.readFully(input, jArr, i, i2);
    }

    /* renamed from: readFully-pqYNikA  reason: not valid java name */
    public static final void m278readFullypqYNikA(Input input, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFully");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        InputArraysKt.readFully(input, jArr, i, i2);
    }

    /* renamed from: writeUByte-EK-6454  reason: not valid java name */
    public static final void m288writeUByteEK6454(Output output, byte b) {
        Intrinsics.checkNotNullParameter(output, "$this$writeUByte");
        output.writeByte(b);
    }

    /* renamed from: writeUShort-i8woANY  reason: not valid java name */
    public static final void m291writeUShorti8woANY(Output output, short s) {
        Intrinsics.checkNotNullParameter(output, "$this$writeUShort");
        OutputPrimitivesKt.writeShort(output, s);
    }

    /* renamed from: writeUInt-Qn1smSk  reason: not valid java name */
    public static final void m289writeUIntQn1smSk(Output output, int i) {
        Intrinsics.checkNotNullParameter(output, "$this$writeUInt");
        OutputPrimitivesKt.writeInt(output, i);
    }

    /* renamed from: writeULong-2TYgG_w  reason: not valid java name */
    public static final void m290writeULong2TYgG_w(Output output, long j) {
        Intrinsics.checkNotNullParameter(output, "$this$writeULong");
        OutputPrimitivesKt.writeLong(output, j);
    }

    /* renamed from: writeFully-o1GoV1E$default  reason: not valid java name */
    public static /* synthetic */ void m283writeFullyo1GoV1E$default(Output output, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m396getSizeimpl(bArr) - i;
        }
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(bArr, "array");
        OutputKt.writeFully(output, bArr, i, i2);
    }

    /* renamed from: writeFully-o1GoV1E  reason: not valid java name */
    public static final void m282writeFullyo1GoV1E(Output output, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(bArr, "array");
        OutputKt.writeFully(output, bArr, i, i2);
    }

    /* renamed from: writeFully-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ void m281writeFullyWt3Bwxc$default(Output output, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(sArr, "array");
        OutputKt.writeFully(output, sArr, i, i2);
    }

    /* renamed from: writeFully-Wt3Bwxc  reason: not valid java name */
    public static final void m280writeFullyWt3Bwxc(Output output, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(sArr, "array");
        OutputKt.writeFully(output, sArr, i, i2);
    }

    /* renamed from: writeFully-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ void m285writeFullyo2ZM2JE$default(Output output, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(iArr, "array");
        OutputKt.writeFully(output, iArr, i, i2);
    }

    /* renamed from: writeFully-o2ZM2JE  reason: not valid java name */
    public static final void m284writeFullyo2ZM2JE(Output output, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(iArr, "array");
        OutputKt.writeFully(output, iArr, i, i2);
    }

    /* renamed from: writeFully-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ void m287writeFullypqYNikA$default(Output output, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(jArr, "array");
        OutputKt.writeFully(output, jArr, i, i2);
    }

    /* renamed from: writeFully-pqYNikA  reason: not valid java name */
    public static final void m286writeFullypqYNikA(Output output, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "$this$writeFully");
        Intrinsics.checkNotNullParameter(jArr, "array");
        OutputKt.writeFully(output, jArr, i, i2);
    }
}
