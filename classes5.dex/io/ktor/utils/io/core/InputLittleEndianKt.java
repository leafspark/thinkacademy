package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\b¢\u0006\u0002\u0010\b\u001aG\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\b¢\u0006\u0002\u0010\u000b\u001a&\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00142\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a3\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00172\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a3\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001d2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a&\u0010\f\u001a\u00020\r*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010\f\u001a\u00020\r*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010\f\u001a\u00020\r*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00142\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010\f\u001a\u00020\r*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010\f\u001a\u00020\r*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a3\u0010\f\u001a\u00020\r*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00172\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010!\u001a3\u0010\f\u001a\u00020\r*\u00020 2\u0006\u0010\u000f\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\"\u001a3\u0010\f\u001a\u00020\r*\u00020 2\u0006\u0010\u000f\u001a\u00020\u001d2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010#\u001a\u0012\u0010$\u001a\u00020%*\u00020 2\u0006\u0010\t\u001a\u00020\n\u001a\n\u0010&\u001a\u00020%*\u00020\u000e\u001a\n\u0010&\u001a\u00020%*\u00020 \u001a\u0012\u0010'\u001a\u00020(*\u00020 2\u0006\u0010\t\u001a\u00020\n\u001a\n\u0010)\u001a\u00020(*\u00020\u000e\u001a\n\u0010)\u001a\u00020(*\u00020 \u001a&\u0010*\u001a\u00020+*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010*\u001a\u00020+*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010*\u001a\u00020+*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00142\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010*\u001a\u00020+*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010*\u001a\u00020+*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a3\u0010*\u001a\u00020+*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00172\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a3\u0010*\u001a\u00020+*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a3\u0010*\u001a\u00020+*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001d2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001a&\u0010*\u001a\u00020+*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010*\u001a\u00020+*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010*\u001a\u00020+*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00142\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010*\u001a\u00020+*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a&\u0010*\u001a\u00020+*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r\u001a3\u0010*\u001a\u00020+*\u00020 2\u0006\u0010\u000f\u001a\u00020\u00172\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u00102\u001a3\u0010*\u001a\u00020+*\u00020 2\u0006\u0010\u000f\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u00103\u001a3\u0010*\u001a\u00020+*\u00020 2\u0006\u0010\u000f\u001a\u00020\u001d2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00104\u001a\u0012\u00105\u001a\u00020\r*\u00020 2\u0006\u0010\t\u001a\u00020\n\u001a\n\u00106\u001a\u00020\r*\u00020\u000e\u001a\n\u00106\u001a\u00020\r*\u00020 \u001a\u0012\u00107\u001a\u000208*\u00020 2\u0006\u0010\t\u001a\u00020\n\u001a\n\u00109\u001a\u000208*\u00020\u000e\u001a\n\u00109\u001a\u000208*\u00020 \u001a\u0012\u0010:\u001a\u00020;*\u00020 2\u0006\u0010\t\u001a\u00020\n\u001a\n\u0010<\u001a\u00020;*\u00020\u000e\u001a\n\u0010<\u001a\u00020;*\u00020 \u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"readPrimitiveTemplate", "T", "", "read", "Lkotlin/Function0;", "reverse", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/core/ByteOrder;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "readAvailableLittleEndian", "", "Lio/ktor/utils/io/core/Buffer;", "dst", "", "offset", "length", "", "", "", "", "Lkotlin/UIntArray;", "readAvailableLittleEndian-o2ZM2JE", "(Lio/ktor/utils/io/core/Buffer;[III)I", "Lkotlin/ULongArray;", "readAvailableLittleEndian-pqYNikA", "(Lio/ktor/utils/io/core/Buffer;[JII)I", "Lkotlin/UShortArray;", "readAvailableLittleEndian-Wt3Bwxc", "(Lio/ktor/utils/io/core/Buffer;[SII)I", "Lio/ktor/utils/io/core/Input;", "(Lio/ktor/utils/io/core/Input;[III)I", "(Lio/ktor/utils/io/core/Input;[JII)I", "(Lio/ktor/utils/io/core/Input;[SII)I", "readDouble", "", "readDoubleLittleEndian", "readFloat", "", "readFloatLittleEndian", "readFullyLittleEndian", "", "readFullyLittleEndian-o2ZM2JE", "(Lio/ktor/utils/io/core/Buffer;[III)V", "readFullyLittleEndian-pqYNikA", "(Lio/ktor/utils/io/core/Buffer;[JII)V", "readFullyLittleEndian-Wt3Bwxc", "(Lio/ktor/utils/io/core/Buffer;[SII)V", "(Lio/ktor/utils/io/core/Input;[III)V", "(Lio/ktor/utils/io/core/Input;[JII)V", "(Lio/ktor/utils/io/core/Input;[SII)V", "readInt", "readIntLittleEndian", "readLong", "", "readLongLittleEndian", "readShort", "", "readShortLittleEndian", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputLittleEndian.kt */
public final class InputLittleEndianKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InputLittleEndian.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ByteOrder.values().length];
            iArr[ByteOrder.BIG_ENDIAN.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final short readShortLittleEndian(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return Short.reverseBytes(InputPrimitivesKt.readShort(input));
    }

    public static final int readIntLittleEndian(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return Integer.reverseBytes(InputPrimitivesKt.readInt(input));
    }

    public static final long readLongLittleEndian(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return Long.reverseBytes(InputPrimitivesKt.readLong(input));
    }

    public static final float readFloatLittleEndian(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(InputPrimitivesKt.readFloat(input))));
    }

    public static final double readDoubleLittleEndian(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(InputPrimitivesKt.readDouble(input))));
    }

    public static final short readShortLittleEndian(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return Short.reverseBytes(BufferPrimitivesKt.readShort(buffer));
    }

    public static final int readIntLittleEndian(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return Integer.reverseBytes(BufferPrimitivesKt.readInt(buffer));
    }

    public static final long readLongLittleEndian(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return Long.reverseBytes(BufferPrimitivesKt.readLong(buffer));
    }

    public static final float readFloatLittleEndian(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(BufferPrimitivesKt.readFloat(buffer))));
    }

    public static final double readDoubleLittleEndian(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(BufferPrimitivesKt.readDouble(buffer))));
    }

    /* renamed from: readFullyLittleEndian-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ void m246readFullyLittleEndianWt3Bwxc$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        m244readFullyLittleEndianWt3Bwxc(input, sArr, i, i2);
    }

    /* renamed from: readFullyLittleEndian-Wt3Bwxc  reason: not valid java name */
    public static final void m244readFullyLittleEndianWt3Bwxc(Input input, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFullyLittleEndian");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        readFullyLittleEndian(input, sArr, i, i2);
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        readFullyLittleEndian(input, sArr, i, i2);
    }

    public static final void readFullyLittleEndian(Input input, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        InputArraysKt.readFully(input, sArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                sArr[i] = Short.reverseBytes(sArr[i]);
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: readFullyLittleEndian-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ void m250readFullyLittleEndiano2ZM2JE$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        m248readFullyLittleEndiano2ZM2JE(input, iArr, i, i2);
    }

    /* renamed from: readFullyLittleEndian-o2ZM2JE  reason: not valid java name */
    public static final void m248readFullyLittleEndiano2ZM2JE(Input input, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFullyLittleEndian");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        readFullyLittleEndian(input, iArr, i, i2);
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        readFullyLittleEndian(input, iArr, i, i2);
    }

    public static final void readFullyLittleEndian(Input input, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        InputArraysKt.readFully(input, iArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                iArr[i] = Integer.reverseBytes(iArr[i]);
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: readFullyLittleEndian-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ void m254readFullyLittleEndianpqYNikA$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        m252readFullyLittleEndianpqYNikA(input, jArr, i, i2);
    }

    /* renamed from: readFullyLittleEndian-pqYNikA  reason: not valid java name */
    public static final void m252readFullyLittleEndianpqYNikA(Input input, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readFullyLittleEndian");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        readFullyLittleEndian(input, jArr, i, i2);
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        readFullyLittleEndian(input, jArr, i, i2);
    }

    public static final void readFullyLittleEndian(Input input, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        InputArraysKt.readFully(input, jArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                jArr[i] = Long.reverseBytes(jArr[i]);
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Input input, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        readFullyLittleEndian(input, fArr, i, i2);
    }

    public static final void readFullyLittleEndian(Input input, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "dst");
        InputArraysKt.readFully(input, fArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                fArr[i] = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i])));
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Input input, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        readFullyLittleEndian(input, dArr, i, i2);
    }

    public static final void readFullyLittleEndian(Input input, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "dst");
        InputArraysKt.readFully(input, dArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                dArr[i] = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i])));
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: readAvailableLittleEndian-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ int m234readAvailableLittleEndianWt3Bwxc$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        return m232readAvailableLittleEndianWt3Bwxc(input, sArr, i, i2);
    }

    /* renamed from: readAvailableLittleEndian-Wt3Bwxc  reason: not valid java name */
    public static final int m232readAvailableLittleEndianWt3Bwxc(Input input, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readAvailableLittleEndian");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        return readAvailableLittleEndian(input, sArr, i, i2);
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Input input, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        return readAvailableLittleEndian(input, sArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Input input, short[] sArr, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        int readAvailable = InputArraysKt.readAvailable(input, sArr, i, i2);
        if (readAvailable > 0 && i <= (i + readAvailable) - 1) {
            while (true) {
                sArr[i] = Short.reverseBytes(sArr[i]);
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    /* renamed from: readAvailableLittleEndian-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ int m238readAvailableLittleEndiano2ZM2JE$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        return m236readAvailableLittleEndiano2ZM2JE(input, iArr, i, i2);
    }

    /* renamed from: readAvailableLittleEndian-o2ZM2JE  reason: not valid java name */
    public static final int m236readAvailableLittleEndiano2ZM2JE(Input input, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readAvailableLittleEndian");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        return readAvailableLittleEndian(input, iArr, i, i2);
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Input input, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        return readAvailableLittleEndian(input, iArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Input input, int[] iArr, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        int readAvailable = InputArraysKt.readAvailable(input, iArr, i, i2);
        if (readAvailable > 0 && i <= (i + readAvailable) - 1) {
            while (true) {
                iArr[i] = Integer.reverseBytes(iArr[i]);
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    /* renamed from: readAvailableLittleEndian-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ int m242readAvailableLittleEndianpqYNikA$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        return m240readAvailableLittleEndianpqYNikA(input, jArr, i, i2);
    }

    /* renamed from: readAvailableLittleEndian-pqYNikA  reason: not valid java name */
    public static final int m240readAvailableLittleEndianpqYNikA(Input input, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "$this$readAvailableLittleEndian");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        return readAvailableLittleEndian(input, jArr, i, i2);
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Input input, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        return readAvailableLittleEndian(input, jArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Input input, long[] jArr, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        int readAvailable = InputArraysKt.readAvailable(input, jArr, i, i2);
        if (readAvailable > 0 && i <= (i + readAvailable) - 1) {
            while (true) {
                jArr[i] = Long.reverseBytes(jArr[i]);
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Input input, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        return readAvailableLittleEndian(input, fArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Input input, float[] fArr, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "dst");
        int readAvailable = InputArraysKt.readAvailable(input, fArr, i, i2);
        if (readAvailable > 0 && i <= (i + readAvailable) - 1) {
            while (true) {
                fArr[i] = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i])));
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Input input, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        return readAvailableLittleEndian(input, dArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Input input, double[] dArr, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "dst");
        int readAvailable = InputArraysKt.readAvailable(input, dArr, i, i2);
        if (readAvailable > 0 && i <= (i + readAvailable) - 1) {
            while (true) {
                dArr[i] = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i])));
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    /* renamed from: readFullyLittleEndian-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ void m245readFullyLittleEndianWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        m243readFullyLittleEndianWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: readFullyLittleEndian-Wt3Bwxc  reason: not valid java name */
    public static final void m243readFullyLittleEndianWt3Bwxc(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readFullyLittleEndian");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        readFullyLittleEndian(buffer, sArr, i, i2);
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        readFullyLittleEndian(buffer, sArr, i, i2);
    }

    public static final void readFullyLittleEndian(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        BufferPrimitivesKt.readFully(buffer, sArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                sArr[i] = Short.reverseBytes(sArr[i]);
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: readFullyLittleEndian-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ void m249readFullyLittleEndiano2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        m247readFullyLittleEndiano2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: readFullyLittleEndian-o2ZM2JE  reason: not valid java name */
    public static final void m247readFullyLittleEndiano2ZM2JE(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readFullyLittleEndian");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        readFullyLittleEndian(buffer, iArr, i, i2);
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        readFullyLittleEndian(buffer, iArr, i, i2);
    }

    public static final void readFullyLittleEndian(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        BufferPrimitivesKt.readFully(buffer, iArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                iArr[i] = Integer.reverseBytes(iArr[i]);
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: readFullyLittleEndian-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ void m253readFullyLittleEndianpqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        m251readFullyLittleEndianpqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: readFullyLittleEndian-pqYNikA  reason: not valid java name */
    public static final void m251readFullyLittleEndianpqYNikA(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readFullyLittleEndian");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        readFullyLittleEndian(buffer, jArr, i, i2);
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        readFullyLittleEndian(buffer, jArr, i, i2);
    }

    public static final void readFullyLittleEndian(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        BufferPrimitivesKt.readFully(buffer, jArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                jArr[i] = Long.reverseBytes(jArr[i]);
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        readFullyLittleEndian(buffer, fArr, i, i2);
    }

    public static final void readFullyLittleEndian(Buffer buffer, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "dst");
        BufferPrimitivesKt.readFully(buffer, fArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                fArr[i] = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i])));
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static /* synthetic */ void readFullyLittleEndian$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        readFullyLittleEndian(buffer, dArr, i, i2);
    }

    public static final void readFullyLittleEndian(Buffer buffer, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "dst");
        BufferPrimitivesKt.readFully(buffer, dArr, i, i2);
        int i3 = (i2 + i) - 1;
        if (i <= i3) {
            while (true) {
                dArr[i] = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i])));
                if (i != i3) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: readAvailableLittleEndian-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ int m233readAvailableLittleEndianWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        return m231readAvailableLittleEndianWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: readAvailableLittleEndian-Wt3Bwxc  reason: not valid java name */
    public static final int m231readAvailableLittleEndianWt3Bwxc(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readAvailableLittleEndian");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        return readAvailableLittleEndian(buffer, sArr, i, i2);
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        return readAvailableLittleEndian(buffer, sArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "dst");
        int readAvailable = BufferPrimitivesKt.readAvailable(buffer, sArr, i, i2);
        int i3 = (i + readAvailable) - 1;
        if (i <= i3) {
            while (true) {
                sArr[i] = Short.reverseBytes(sArr[i]);
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    /* renamed from: readAvailableLittleEndian-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ int m237readAvailableLittleEndiano2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        return m235readAvailableLittleEndiano2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: readAvailableLittleEndian-o2ZM2JE  reason: not valid java name */
    public static final int m235readAvailableLittleEndiano2ZM2JE(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readAvailableLittleEndian");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        return readAvailableLittleEndian(buffer, iArr, i, i2);
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        return readAvailableLittleEndian(buffer, iArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "dst");
        int readAvailable = BufferPrimitivesKt.readAvailable(buffer, iArr, i, i2);
        int i3 = (i + readAvailable) - 1;
        if (i <= i3) {
            while (true) {
                iArr[i] = Integer.reverseBytes(iArr[i]);
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    /* renamed from: readAvailableLittleEndian-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ int m241readAvailableLittleEndianpqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        return m239readAvailableLittleEndianpqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: readAvailableLittleEndian-pqYNikA  reason: not valid java name */
    public static final int m239readAvailableLittleEndianpqYNikA(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readAvailableLittleEndian");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        return readAvailableLittleEndian(buffer, jArr, i, i2);
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        return readAvailableLittleEndian(buffer, jArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Buffer buffer, long[] jArr, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "dst");
        int readAvailable = BufferPrimitivesKt.readAvailable(buffer, jArr, i, i2);
        if (readAvailable > 0 && i <= (i + readAvailable) - 1) {
            while (true) {
                jArr[i] = Long.reverseBytes(jArr[i]);
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        return readAvailableLittleEndian(buffer, fArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Buffer buffer, float[] fArr, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "dst");
        int readAvailable = BufferPrimitivesKt.readAvailable(buffer, fArr, i, i2);
        if (readAvailable > 0 && i <= (i + readAvailable) - 1) {
            while (true) {
                fArr[i] = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fArr[i])));
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    public static /* synthetic */ int readAvailableLittleEndian$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        return readAvailableLittleEndian(buffer, dArr, i, i2);
    }

    public static final int readAvailableLittleEndian(Buffer buffer, double[] dArr, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "dst");
        int readAvailable = BufferPrimitivesKt.readAvailable(buffer, dArr, i, i2);
        if (readAvailable > 0 && i <= (i + readAvailable) - 1) {
            while (true) {
                dArr[i] = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dArr[i])));
                if (i == i3) {
                    break;
                }
                i++;
            }
        }
        return readAvailable;
    }

    private static final <T> T readPrimitiveTemplate(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        return function1.invoke(function0.invoke());
    }

    private static final <T> T readPrimitiveTemplate(ByteOrder byteOrder, Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1) {
            return function0.invoke();
        }
        return function1.invoke(function0.invoke());
    }

    public static final short readShort(Input input, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1) {
            return InputPrimitivesKt.readShort(input);
        }
        return Short.reverseBytes(InputPrimitivesKt.readShort(input));
    }

    public static final int readInt(Input input, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1) {
            return InputPrimitivesKt.readInt(input);
        }
        return Integer.reverseBytes(InputPrimitivesKt.readInt(input));
    }

    public static final long readLong(Input input, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1) {
            return InputPrimitivesKt.readLong(input);
        }
        return Long.reverseBytes(InputPrimitivesKt.readLong(input));
    }

    public static final float readFloat(Input input, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1) {
            return InputPrimitivesKt.readFloat(input);
        }
        return Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(InputPrimitivesKt.readFloat(input))));
    }

    public static final double readDouble(Input input, ByteOrder byteOrder) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 1) {
            return InputPrimitivesKt.readDouble(input);
        }
        return Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(InputPrimitivesKt.readDouble(input))));
    }
}
