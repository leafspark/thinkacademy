package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\f\u001a>\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\n\u001a>\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\f\u001a>\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a>\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0014\u001a>\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00162\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a>\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00162\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0019\u001a>\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001b2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a>\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u001b2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001e\u001a>\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\n\u001a>\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\f\u001a>\u0010#\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\n\u001a>\u0010#\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\f\u001a>\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0013\u001a>\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0014\u001a>\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00162\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0018\u001a>\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00162\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0019\u001a>\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001d\u001a>\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"loadByteArray", "", "Lio/ktor/utils/io/bits/Memory;", "offset", "", "destination", "", "destinationOffset", "count", "loadByteArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[BII)V", "", "(Ljava/nio/ByteBuffer;J[BII)V", "loadUByteArray", "Lkotlin/UByteArray;", "loadUByteArray-KqtU1YU", "loadUIntArray", "Lkotlin/UIntArray;", "loadUIntArray-EM3dPTA", "(Ljava/nio/ByteBuffer;I[III)V", "(Ljava/nio/ByteBuffer;J[III)V", "loadULongArray", "Lkotlin/ULongArray;", "loadULongArray-bNlDJKc", "(Ljava/nio/ByteBuffer;I[JII)V", "(Ljava/nio/ByteBuffer;J[JII)V", "loadUShortArray", "Lkotlin/UShortArray;", "loadUShortArray-m8CCUi4", "(Ljava/nio/ByteBuffer;I[SII)V", "(Ljava/nio/ByteBuffer;J[SII)V", "storeByteArray", "source", "sourceOffset", "storeByteArray-9zorpBc", "storeUByteArray", "storeUByteArray-KqtU1YU", "storeUIntArray", "storeUIntArray-EM3dPTA", "storeULongArray", "storeULongArray-bNlDJKc", "storeUShortArray", "storeUShortArray-m8CCUi4", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimiteArrays.kt */
public final class PrimiteArraysKt {
    /* renamed from: loadByteArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m106loadByteArray9zorpBc$default(ByteBuffer byteBuffer, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadByteArray");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m59copyTo9zorpBc(byteBuffer, bArr, i, i3, i2);
    }

    /* renamed from: loadByteArray-9zorpBc  reason: not valid java name */
    public static final void m104loadByteArray9zorpBc(ByteBuffer byteBuffer, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadByteArray");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m59copyTo9zorpBc(byteBuffer, bArr, i, i3, i2);
    }

    /* renamed from: loadByteArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m107loadByteArray9zorpBc$default(ByteBuffer byteBuffer, long j, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = bArr.length - i4;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadByteArray");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m60copyTo9zorpBc(byteBuffer, bArr, j, i2, i4);
    }

    /* renamed from: loadByteArray-9zorpBc  reason: not valid java name */
    public static final void m105loadByteArray9zorpBc(ByteBuffer byteBuffer, long j, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadByteArray");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m60copyTo9zorpBc(byteBuffer, bArr, j, i2, i);
    }

    /* renamed from: loadUByteArray-KqtU1YU$default  reason: not valid java name */
    public static /* synthetic */ void m110loadUByteArrayKqtU1YU$default(ByteBuffer byteBuffer, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UByteArray.m396getSizeimpl(bArr) - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUByteArray");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m59copyTo9zorpBc(byteBuffer, bArr, i, i3, i2);
    }

    /* renamed from: loadUByteArray-KqtU1YU  reason: not valid java name */
    public static final void m108loadUByteArrayKqtU1YU(ByteBuffer byteBuffer, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUByteArray");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m59copyTo9zorpBc(byteBuffer, bArr, i, i3, i2);
    }

    /* renamed from: loadUByteArray-KqtU1YU$default  reason: not valid java name */
    public static /* synthetic */ void m111loadUByteArrayKqtU1YU$default(ByteBuffer byteBuffer, long j, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UByteArray.m396getSizeimpl(bArr) - i4;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUByteArray");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m60copyTo9zorpBc(byteBuffer, bArr, j, i2, i4);
    }

    /* renamed from: loadUByteArray-KqtU1YU  reason: not valid java name */
    public static final void m109loadUByteArrayKqtU1YU(ByteBuffer byteBuffer, long j, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUByteArray");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m60copyTo9zorpBc(byteBuffer, bArr, j, i2, i);
    }

    /* renamed from: loadUShortArray-m8CCUi4$default  reason: not valid java name */
    public static /* synthetic */ void m122loadUShortArraym8CCUi4$default(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UShortArray.m656getSizeimpl(sArr) - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUShortArray");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        PrimitiveArraysJvmKt.m160loadShortArray9zorpBc(byteBuffer, i, sArr, i2, i3);
    }

    /* renamed from: loadUShortArray-m8CCUi4  reason: not valid java name */
    public static final void m120loadUShortArraym8CCUi4(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUShortArray");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        PrimitiveArraysJvmKt.m160loadShortArray9zorpBc(byteBuffer, i, sArr, i2, i3);
    }

    /* renamed from: loadUShortArray-m8CCUi4$default  reason: not valid java name */
    public static /* synthetic */ void m123loadUShortArraym8CCUi4$default(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i4;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUShortArray");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        PrimitiveArraysJvmKt.m161loadShortArray9zorpBc(byteBuffer, j, sArr, i4, i2);
    }

    /* renamed from: loadUShortArray-m8CCUi4  reason: not valid java name */
    public static final void m121loadUShortArraym8CCUi4(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUShortArray");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        PrimitiveArraysJvmKt.m161loadShortArray9zorpBc(byteBuffer, j, sArr, i, i2);
    }

    /* renamed from: loadUIntArray-EM3dPTA$default  reason: not valid java name */
    public static /* synthetic */ void m114loadUIntArrayEM3dPTA$default(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UIntArray.m474getSizeimpl(iArr) - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUIntArray");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        PrimitiveArraysJvmKt.m152loadIntArray9zorpBc(byteBuffer, i, iArr, i2, i3);
    }

    /* renamed from: loadUIntArray-EM3dPTA  reason: not valid java name */
    public static final void m112loadUIntArrayEM3dPTA(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUIntArray");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        PrimitiveArraysJvmKt.m152loadIntArray9zorpBc(byteBuffer, i, iArr, i2, i3);
    }

    /* renamed from: loadUIntArray-EM3dPTA$default  reason: not valid java name */
    public static /* synthetic */ void m115loadUIntArrayEM3dPTA$default(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i4;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUIntArray");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        PrimitiveArraysJvmKt.m153loadIntArray9zorpBc(byteBuffer, j, iArr, i4, i2);
    }

    /* renamed from: loadUIntArray-EM3dPTA  reason: not valid java name */
    public static final void m113loadUIntArrayEM3dPTA(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUIntArray");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        PrimitiveArraysJvmKt.m153loadIntArray9zorpBc(byteBuffer, j, iArr, i, i2);
    }

    /* renamed from: loadULongArray-bNlDJKc$default  reason: not valid java name */
    public static /* synthetic */ void m118loadULongArraybNlDJKc$default(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = ULongArray.m552getSizeimpl(jArr) - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadULongArray");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        PrimitiveArraysJvmKt.m156loadLongArray9zorpBc(byteBuffer, i, jArr, i2, i3);
    }

    /* renamed from: loadULongArray-bNlDJKc  reason: not valid java name */
    public static final void m116loadULongArraybNlDJKc(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadULongArray");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        PrimitiveArraysJvmKt.m156loadLongArray9zorpBc(byteBuffer, i, jArr, i2, i3);
    }

    /* renamed from: loadULongArray-bNlDJKc$default  reason: not valid java name */
    public static /* synthetic */ void m119loadULongArraybNlDJKc$default(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i4;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadULongArray");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        PrimitiveArraysJvmKt.m157loadLongArray9zorpBc(byteBuffer, j, jArr, i4, i2);
    }

    /* renamed from: loadULongArray-bNlDJKc  reason: not valid java name */
    public static final void m117loadULongArraybNlDJKc(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadULongArray");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        PrimitiveArraysJvmKt.m157loadLongArray9zorpBc(byteBuffer, j, jArr, i, i2);
    }

    /* renamed from: storeByteArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m126storeByteArray9zorpBc$default(ByteBuffer byteBuffer, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeByteArray");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer order = ByteBuffer.wrap(bArr, i2, i3).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m41copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer, 0, i3, i);
    }

    /* renamed from: storeByteArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m127storeByteArray9zorpBc$default(ByteBuffer byteBuffer, long j, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length - i;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeByteArray");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer order = ByteBuffer.wrap(bArr, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m42copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer, 0, (long) i2, j);
    }

    /* renamed from: storeUByteArray-KqtU1YU$default  reason: not valid java name */
    public static /* synthetic */ void m130storeUByteArrayKqtU1YU$default(ByteBuffer byteBuffer, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UByteArray.m396getSizeimpl(bArr) - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUByteArray");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer order = ByteBuffer.wrap(bArr, i2, i3).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m41copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer, 0, i3, i);
    }

    /* renamed from: storeUByteArray-KqtU1YU$default  reason: not valid java name */
    public static /* synthetic */ void m131storeUByteArrayKqtU1YU$default(ByteBuffer byteBuffer, long j, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = UByteArray.m396getSizeimpl(bArr) - i;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUByteArray");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer order = ByteBuffer.wrap(bArr, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m42copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer, 0, (long) i2, j);
    }

    /* renamed from: storeUShortArray-m8CCUi4$default  reason: not valid java name */
    public static /* synthetic */ void m142storeUShortArraym8CCUi4$default(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UShortArray.m656getSizeimpl(sArr) - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUShortArray");
        Intrinsics.checkNotNullParameter(sArr, "source");
        PrimitiveArraysJvmKt.m180storeShortArray9zorpBc(byteBuffer, i, sArr, i2, i3);
    }

    /* renamed from: storeUShortArray-m8CCUi4  reason: not valid java name */
    public static final void m140storeUShortArraym8CCUi4(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUShortArray");
        Intrinsics.checkNotNullParameter(sArr, "source");
        PrimitiveArraysJvmKt.m180storeShortArray9zorpBc(byteBuffer, i, sArr, i2, i3);
    }

    /* renamed from: storeUShortArray-m8CCUi4$default  reason: not valid java name */
    public static /* synthetic */ void m143storeUShortArraym8CCUi4$default(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i4;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUShortArray");
        Intrinsics.checkNotNullParameter(sArr, "source");
        PrimitiveArraysJvmKt.m181storeShortArray9zorpBc(byteBuffer, j, sArr, i4, i2);
    }

    /* renamed from: storeUShortArray-m8CCUi4  reason: not valid java name */
    public static final void m141storeUShortArraym8CCUi4(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUShortArray");
        Intrinsics.checkNotNullParameter(sArr, "source");
        PrimitiveArraysJvmKt.m181storeShortArray9zorpBc(byteBuffer, j, sArr, i, i2);
    }

    /* renamed from: storeUIntArray-EM3dPTA$default  reason: not valid java name */
    public static /* synthetic */ void m134storeUIntArrayEM3dPTA$default(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = UIntArray.m474getSizeimpl(iArr) - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUIntArray");
        Intrinsics.checkNotNullParameter(iArr, "source");
        PrimitiveArraysJvmKt.m172storeIntArray9zorpBc(byteBuffer, i, iArr, i2, i3);
    }

    /* renamed from: storeUIntArray-EM3dPTA  reason: not valid java name */
    public static final void m132storeUIntArrayEM3dPTA(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUIntArray");
        Intrinsics.checkNotNullParameter(iArr, "source");
        PrimitiveArraysJvmKt.m172storeIntArray9zorpBc(byteBuffer, i, iArr, i2, i3);
    }

    /* renamed from: storeUIntArray-EM3dPTA$default  reason: not valid java name */
    public static /* synthetic */ void m135storeUIntArrayEM3dPTA$default(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i4;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUIntArray");
        Intrinsics.checkNotNullParameter(iArr, "source");
        PrimitiveArraysJvmKt.m173storeIntArray9zorpBc(byteBuffer, j, iArr, i4, i2);
    }

    /* renamed from: storeUIntArray-EM3dPTA  reason: not valid java name */
    public static final void m133storeUIntArrayEM3dPTA(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUIntArray");
        Intrinsics.checkNotNullParameter(iArr, "source");
        PrimitiveArraysJvmKt.m173storeIntArray9zorpBc(byteBuffer, j, iArr, i, i2);
    }

    /* renamed from: storeULongArray-bNlDJKc$default  reason: not valid java name */
    public static /* synthetic */ void m138storeULongArraybNlDJKc$default(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = ULongArray.m552getSizeimpl(jArr) - i2;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeULongArray");
        Intrinsics.checkNotNullParameter(jArr, "source");
        PrimitiveArraysJvmKt.m176storeLongArray9zorpBc(byteBuffer, i, jArr, i2, i3);
    }

    /* renamed from: storeULongArray-bNlDJKc  reason: not valid java name */
    public static final void m136storeULongArraybNlDJKc(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeULongArray");
        Intrinsics.checkNotNullParameter(jArr, "source");
        PrimitiveArraysJvmKt.m176storeLongArray9zorpBc(byteBuffer, i, jArr, i2, i3);
    }

    /* renamed from: storeULongArray-bNlDJKc$default  reason: not valid java name */
    public static /* synthetic */ void m139storeULongArraybNlDJKc$default(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i4;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeULongArray");
        Intrinsics.checkNotNullParameter(jArr, "source");
        PrimitiveArraysJvmKt.m177storeLongArray9zorpBc(byteBuffer, j, jArr, i4, i2);
    }

    /* renamed from: storeULongArray-bNlDJKc  reason: not valid java name */
    public static final void m137storeULongArraybNlDJKc(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeULongArray");
        Intrinsics.checkNotNullParameter(jArr, "source");
        PrimitiveArraysJvmKt.m177storeLongArray9zorpBc(byteBuffer, j, jArr, i, i2);
    }

    /* renamed from: storeByteArray-9zorpBc  reason: not valid java name */
    public static final void m124storeByteArray9zorpBc(ByteBuffer byteBuffer, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeByteArray");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer order = ByteBuffer.wrap(bArr, i2, i3).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m41copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer, 0, i3, i);
    }

    /* renamed from: storeByteArray-9zorpBc  reason: not valid java name */
    public static final void m125storeByteArray9zorpBc(ByteBuffer byteBuffer, long j, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeByteArray");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer order = ByteBuffer.wrap(bArr, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m42copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer, 0, (long) i2, j);
    }

    /* renamed from: storeUByteArray-KqtU1YU  reason: not valid java name */
    public static final void m128storeUByteArrayKqtU1YU(ByteBuffer byteBuffer, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUByteArray");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer order = ByteBuffer.wrap(bArr, i2, i3).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m41copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer, 0, i3, i);
    }

    /* renamed from: storeUByteArray-KqtU1YU  reason: not valid java name */
    public static final void m129storeUByteArrayKqtU1YU(ByteBuffer byteBuffer, long j, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUByteArray");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer order = ByteBuffer.wrap(bArr, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m42copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer, 0, (long) i2, j);
    }
}
