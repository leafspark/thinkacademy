package io.ktor.utils.io.bits;

import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\f\u001a;\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a;\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0011\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0016\u001a;\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a;\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001b\u001a;\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a;\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010 \u001a;\u0010!\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\n\u001a;\u0010!\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\f\u001a;\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0010\u001a;\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0011\u001a;\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0015\u001a;\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0016\u001a;\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001a\u001a;\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001b\u001a;\u0010+\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u001f\u001a;\u0010+\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010 \u001a\u0015\u0010-\u001a\u00020.*\u00020.2\u0006\u0010\u0003\u001a\u00020\u0004H\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"loadDoubleArray", "", "Lio/ktor/utils/io/bits/Memory;", "offset", "", "destination", "", "destinationOffset", "count", "loadDoubleArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[DII)V", "", "(Ljava/nio/ByteBuffer;J[DII)V", "loadFloatArray", "", "loadFloatArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[FII)V", "(Ljava/nio/ByteBuffer;J[FII)V", "loadIntArray", "", "loadIntArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[III)V", "(Ljava/nio/ByteBuffer;J[III)V", "loadLongArray", "", "loadLongArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[JII)V", "(Ljava/nio/ByteBuffer;J[JII)V", "loadShortArray", "", "loadShortArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[SII)V", "(Ljava/nio/ByteBuffer;J[SII)V", "storeDoubleArray", "source", "sourceOffset", "storeDoubleArray-9zorpBc", "storeFloatArray", "storeFloatArray-9zorpBc", "storeIntArray", "storeIntArray-9zorpBc", "storeLongArray", "storeLongArray-9zorpBc", "storeShortArray", "storeShortArray-9zorpBc", "withOffset", "Ljava/nio/ByteBuffer;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimitiveArraysJvm.kt */
public final class PrimitiveArraysJvmKt {
    /* renamed from: loadShortArray-9zorpBc  reason: not valid java name */
    public static final void m161loadShortArray9zorpBc(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadShortArray");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        if (j < 2147483647L) {
            m160loadShortArray9zorpBc(byteBuffer, (int) j, sArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadIntArray-9zorpBc  reason: not valid java name */
    public static final void m153loadIntArray9zorpBc(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadIntArray");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        if (j < 2147483647L) {
            m152loadIntArray9zorpBc(byteBuffer, (int) j, iArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadShortArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m162loadShortArray9zorpBc$default(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length - i2;
        }
        m160loadShortArray9zorpBc(byteBuffer, i, sArr, i2, i3);
    }

    /* renamed from: loadLongArray-9zorpBc  reason: not valid java name */
    public static final void m157loadLongArray9zorpBc(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadLongArray");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        if (j < 2147483647L) {
            m156loadLongArray9zorpBc(byteBuffer, (int) j, jArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadShortArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m163loadShortArray9zorpBc$default(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = sArr.length - i4;
        }
        m161loadShortArray9zorpBc(byteBuffer, j, sArr, i4, i2);
    }

    /* renamed from: loadFloatArray-9zorpBc  reason: not valid java name */
    public static final void m149loadFloatArray9zorpBc(ByteBuffer byteBuffer, long j, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadFloatArray");
        Intrinsics.checkNotNullParameter(fArr, "destination");
        if (j < 2147483647L) {
            m148loadFloatArray9zorpBc(byteBuffer, (int) j, fArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadIntArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m154loadIntArray9zorpBc$default(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length - i2;
        }
        m152loadIntArray9zorpBc(byteBuffer, i, iArr, i2, i3);
    }

    /* renamed from: loadDoubleArray-9zorpBc  reason: not valid java name */
    public static final void m145loadDoubleArray9zorpBc(ByteBuffer byteBuffer, long j, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadDoubleArray");
        Intrinsics.checkNotNullParameter(dArr, "destination");
        if (j < 2147483647L) {
            m144loadDoubleArray9zorpBc(byteBuffer, (int) j, dArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadIntArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m155loadIntArray9zorpBc$default(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = iArr.length - i4;
        }
        m153loadIntArray9zorpBc(byteBuffer, j, iArr, i4, i2);
    }

    /* renamed from: storeShortArray-9zorpBc  reason: not valid java name */
    public static final void m181storeShortArray9zorpBc(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeShortArray");
        Intrinsics.checkNotNullParameter(sArr, "source");
        if (j < 2147483647L) {
            m180storeShortArray9zorpBc(byteBuffer, (int) j, sArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadLongArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m158loadLongArray9zorpBc$default(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length - i2;
        }
        m156loadLongArray9zorpBc(byteBuffer, i, jArr, i2, i3);
    }

    /* renamed from: storeIntArray-9zorpBc  reason: not valid java name */
    public static final void m173storeIntArray9zorpBc(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeIntArray");
        Intrinsics.checkNotNullParameter(iArr, "source");
        if (j < 2147483647L) {
            m172storeIntArray9zorpBc(byteBuffer, (int) j, iArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadLongArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m159loadLongArray9zorpBc$default(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = jArr.length - i4;
        }
        m157loadLongArray9zorpBc(byteBuffer, j, jArr, i4, i2);
    }

    /* renamed from: storeLongArray-9zorpBc  reason: not valid java name */
    public static final void m177storeLongArray9zorpBc(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeLongArray");
        Intrinsics.checkNotNullParameter(jArr, "source");
        if (j < 2147483647L) {
            m176storeLongArray9zorpBc(byteBuffer, (int) j, jArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: storeFloatArray-9zorpBc  reason: not valid java name */
    public static final void m169storeFloatArray9zorpBc(ByteBuffer byteBuffer, long j, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeFloatArray");
        Intrinsics.checkNotNullParameter(fArr, "source");
        if (j < 2147483647L) {
            m168storeFloatArray9zorpBc(byteBuffer, (int) j, fArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadFloatArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m150loadFloatArray9zorpBc$default(ByteBuffer byteBuffer, int i, float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length - i2;
        }
        m148loadFloatArray9zorpBc(byteBuffer, i, fArr, i2, i3);
    }

    /* renamed from: loadFloatArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m151loadFloatArray9zorpBc$default(ByteBuffer byteBuffer, long j, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = fArr.length - i4;
        }
        m149loadFloatArray9zorpBc(byteBuffer, j, fArr, i4, i2);
    }

    /* renamed from: storeDoubleArray-9zorpBc  reason: not valid java name */
    public static final void m165storeDoubleArray9zorpBc(ByteBuffer byteBuffer, long j, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeDoubleArray");
        Intrinsics.checkNotNullParameter(dArr, "source");
        if (j < 2147483647L) {
            m164storeDoubleArray9zorpBc(byteBuffer, (int) j, dArr, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadDoubleArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m146loadDoubleArray9zorpBc$default(ByteBuffer byteBuffer, int i, double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length - i2;
        }
        m144loadDoubleArray9zorpBc(byteBuffer, i, dArr, i2, i3);
    }

    private static final ByteBuffer withOffset(ByteBuffer byteBuffer, int i) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        return duplicate;
    }

    /* renamed from: loadDoubleArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m147loadDoubleArray9zorpBc$default(ByteBuffer byteBuffer, long j, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = dArr.length - i4;
        }
        m145loadDoubleArray9zorpBc(byteBuffer, j, dArr, i4, i2);
    }

    /* renamed from: storeDoubleArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m166storeDoubleArray9zorpBc$default(ByteBuffer byteBuffer, int i, double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length - i2;
        }
        m164storeDoubleArray9zorpBc(byteBuffer, i, dArr, i2, i3);
    }

    /* renamed from: storeDoubleArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m167storeDoubleArray9zorpBc$default(ByteBuffer byteBuffer, long j, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = dArr.length - i4;
        }
        m165storeDoubleArray9zorpBc(byteBuffer, j, dArr, i4, i2);
    }

    /* renamed from: storeFloatArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m170storeFloatArray9zorpBc$default(ByteBuffer byteBuffer, int i, float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length - i2;
        }
        m168storeFloatArray9zorpBc(byteBuffer, i, fArr, i2, i3);
    }

    /* renamed from: storeFloatArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m171storeFloatArray9zorpBc$default(ByteBuffer byteBuffer, long j, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = fArr.length - i4;
        }
        m169storeFloatArray9zorpBc(byteBuffer, j, fArr, i4, i2);
    }

    /* renamed from: storeIntArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m174storeIntArray9zorpBc$default(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length - i2;
        }
        m172storeIntArray9zorpBc(byteBuffer, i, iArr, i2, i3);
    }

    /* renamed from: storeIntArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m175storeIntArray9zorpBc$default(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = iArr.length - i4;
        }
        m173storeIntArray9zorpBc(byteBuffer, j, iArr, i4, i2);
    }

    /* renamed from: storeLongArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m178storeLongArray9zorpBc$default(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length - i2;
        }
        m176storeLongArray9zorpBc(byteBuffer, i, jArr, i2, i3);
    }

    /* renamed from: storeLongArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m179storeLongArray9zorpBc$default(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = jArr.length - i4;
        }
        m177storeLongArray9zorpBc(byteBuffer, j, jArr, i4, i2);
    }

    /* renamed from: storeShortArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m182storeShortArray9zorpBc$default(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length - i2;
        }
        m180storeShortArray9zorpBc(byteBuffer, i, sArr, i2, i3);
    }

    /* renamed from: storeShortArray-9zorpBc$default  reason: not valid java name */
    public static /* synthetic */ void m183storeShortArray9zorpBc$default(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = sArr.length - i4;
        }
        m181storeShortArray9zorpBc(byteBuffer, j, sArr, i4, i2);
    }

    /* renamed from: loadShortArray-9zorpBc  reason: not valid java name */
    public static final void m160loadShortArray9zorpBc(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadShortArray");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asShortBuffer().get(sArr, i2, i3);
    }

    /* renamed from: loadIntArray-9zorpBc  reason: not valid java name */
    public static final void m152loadIntArray9zorpBc(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadIntArray");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asIntBuffer().get(iArr, i2, i3);
    }

    /* renamed from: loadLongArray-9zorpBc  reason: not valid java name */
    public static final void m156loadLongArray9zorpBc(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadLongArray");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asLongBuffer().get(jArr, i2, i3);
    }

    /* renamed from: loadFloatArray-9zorpBc  reason: not valid java name */
    public static final void m148loadFloatArray9zorpBc(ByteBuffer byteBuffer, int i, float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadFloatArray");
        Intrinsics.checkNotNullParameter(fArr, "destination");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asFloatBuffer().get(fArr, i2, i3);
    }

    /* renamed from: loadDoubleArray-9zorpBc  reason: not valid java name */
    public static final void m144loadDoubleArray9zorpBc(ByteBuffer byteBuffer, int i, double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadDoubleArray");
        Intrinsics.checkNotNullParameter(dArr, "destination");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asDoubleBuffer().get(dArr, i2, i3);
    }

    /* renamed from: storeShortArray-9zorpBc  reason: not valid java name */
    public static final void m180storeShortArray9zorpBc(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeShortArray");
        Intrinsics.checkNotNullParameter(sArr, "source");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asShortBuffer().put(sArr, i2, i3);
    }

    /* renamed from: storeIntArray-9zorpBc  reason: not valid java name */
    public static final void m172storeIntArray9zorpBc(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeIntArray");
        Intrinsics.checkNotNullParameter(iArr, "source");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asIntBuffer().put(iArr, i2, i3);
    }

    /* renamed from: storeLongArray-9zorpBc  reason: not valid java name */
    public static final void m176storeLongArray9zorpBc(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeLongArray");
        Intrinsics.checkNotNullParameter(jArr, "source");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asLongBuffer().put(jArr, i2, i3);
    }

    /* renamed from: storeFloatArray-9zorpBc  reason: not valid java name */
    public static final void m168storeFloatArray9zorpBc(ByteBuffer byteBuffer, int i, float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeFloatArray");
        Intrinsics.checkNotNullParameter(fArr, "source");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asFloatBuffer().put(fArr, i2, i3);
    }

    /* renamed from: storeDoubleArray-9zorpBc  reason: not valid java name */
    public static final void m164storeDoubleArray9zorpBc(ByteBuffer byteBuffer, int i, double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeDoubleArray");
        Intrinsics.checkNotNullParameter(dArr, "source");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.position(i);
        duplicate.asDoubleBuffer().put(dArr, i2, i3);
    }
}
