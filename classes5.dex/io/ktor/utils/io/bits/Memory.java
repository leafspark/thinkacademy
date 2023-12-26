package io.ktor.utils.io.bits;

import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 32\u00020\u0001:\u00013B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u000fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rH\b¢\u0006\u0004\b#\u0010$J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\tH\b¢\u0006\u0004\b#\u0010%J&\u0010&\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b'\u0010(J&\u0010&\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b'\u0010)J \u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\r2\u0006\u0010+\u001a\u00020!H\b¢\u0006\u0004\b,\u0010-J \u0010*\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\t2\u0006\u0010+\u001a\u00020!H\b¢\u0006\u0004\b,\u0010.J\u0010\u0010/\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\r8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0001\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Lio/ktor/utils/io/bits/Memory;", "", "buffer", "Ljava/nio/ByteBuffer;", "constructor-impl", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", "size", "", "getSize-impl", "(Ljava/nio/ByteBuffer;)J", "size32", "", "getSize32-impl", "(Ljava/nio/ByteBuffer;)I", "copyTo", "", "destination", "offset", "length", "destinationOffset", "copyTo-JT6ljtQ", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;III)V", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;JJJ)V", "equals", "", "other", "equals-impl", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "loadAt", "", "index", "loadAt-impl", "(Ljava/nio/ByteBuffer;I)B", "(Ljava/nio/ByteBuffer;J)B", "slice", "slice-87lwejk", "(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;JJ)Ljava/nio/ByteBuffer;", "storeAt", "value", "storeAt-impl", "(Ljava/nio/ByteBuffer;IB)V", "(Ljava/nio/ByteBuffer;JB)V", "toString", "", "toString-impl", "(Ljava/nio/ByteBuffer;)Ljava/lang/String;", "Companion", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MemoryJvm.kt */
public final class Memory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ByteBuffer Empty;
    private final ByteBuffer buffer;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Memory m39boximpl(ByteBuffer byteBuffer) {
        return new Memory(byteBuffer);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static ByteBuffer m40constructorimpl(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        return byteBuffer;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m43equalsimpl(ByteBuffer byteBuffer, Object obj) {
        return (obj instanceof Memory) && Intrinsics.areEqual(byteBuffer, ((Memory) obj).m55unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m44equalsimpl0(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return Intrinsics.areEqual(byteBuffer, byteBuffer2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47hashCodeimpl(ByteBuffer byteBuffer) {
        return byteBuffer.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m54toStringimpl(ByteBuffer byteBuffer) {
        return "Memory(buffer=" + byteBuffer + ')';
    }

    public boolean equals(Object obj) {
        return m43equalsimpl(this.buffer, obj);
    }

    public int hashCode() {
        return m47hashCodeimpl(this.buffer);
    }

    public String toString() {
        return m54toStringimpl(this.buffer);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ ByteBuffer m55unboximpl() {
        return this.buffer;
    }

    private /* synthetic */ Memory(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public final ByteBuffer getBuffer() {
        return this.buffer;
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static final long m45getSizeimpl(ByteBuffer byteBuffer) {
        return (long) byteBuffer.limit();
    }

    /* renamed from: getSize32-impl  reason: not valid java name */
    public static final int m46getSize32impl(ByteBuffer byteBuffer) {
        return byteBuffer.limit();
    }

    /* renamed from: loadAt-impl  reason: not valid java name */
    public static final byte m48loadAtimpl(ByteBuffer byteBuffer, int i) {
        return byteBuffer.get(i);
    }

    /* renamed from: loadAt-impl  reason: not valid java name */
    public static final byte m49loadAtimpl(ByteBuffer byteBuffer, long j) {
        if (j < 2147483647L) {
            return byteBuffer.get((int) j);
        }
        NumbersKt.failLongToIntConversion(j, "index");
        throw new KotlinNothingValueException();
    }

    /* renamed from: storeAt-impl  reason: not valid java name */
    public static final void m52storeAtimpl(ByteBuffer byteBuffer, int i, byte b) {
        byteBuffer.put(i, b);
    }

    /* renamed from: storeAt-impl  reason: not valid java name */
    public static final void m53storeAtimpl(ByteBuffer byteBuffer, long j, byte b) {
        if (j < 2147483647L) {
            byteBuffer.put((int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, "index");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: slice-87lwejk  reason: not valid java name */
    public static final ByteBuffer m50slice87lwejk(ByteBuffer byteBuffer, int i, int i2) {
        return m40constructorimpl(MemoryJvmKt.sliceSafe(byteBuffer, i, i2));
    }

    /* renamed from: slice-87lwejk  reason: not valid java name */
    public static final ByteBuffer m51slice87lwejk(ByteBuffer byteBuffer, long j, long j2) {
        if (j < 2147483647L) {
            int i = (int) j;
            if (j2 < 2147483647L) {
                return m50slice87lwejk(byteBuffer, i, (int) j2);
            }
            NumbersKt.failLongToIntConversion(j2, "length");
            throw new KotlinNothingValueException();
        }
        NumbersKt.failLongToIntConversion(j, "offset");
        throw new KotlinNothingValueException();
    }

    /* renamed from: copyTo-JT6ljtQ  reason: not valid java name */
    public static final void m41copyToJT6ljtQ(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer2, "destination");
        if (!byteBuffer.hasArray() || !byteBuffer2.hasArray() || byteBuffer.isReadOnly() || byteBuffer2.isReadOnly()) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.position(i);
            duplicate.limit(i + i2);
            ByteBuffer duplicate2 = byteBuffer2.duplicate();
            duplicate2.position(i3);
            duplicate2.put(duplicate);
            return;
        }
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i, byteBuffer2.array(), byteBuffer2.arrayOffset() + i3, i2);
    }

    /* renamed from: copyTo-JT6ljtQ  reason: not valid java name */
    public static final void m42copyToJT6ljtQ(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(byteBuffer2, "destination");
        if (j < 2147483647L) {
            int i = (int) j;
            if (j2 < 2147483647L) {
                int i2 = (int) j2;
                if (j3 < 2147483647L) {
                    m41copyToJT6ljtQ(byteBuffer, byteBuffer2, i, i2, (int) j3);
                } else {
                    NumbersKt.failLongToIntConversion(j3, "destinationOffset");
                    throw new KotlinNothingValueException();
                }
            } else {
                NumbersKt.failLongToIntConversion(j2, "length");
                throw new KotlinNothingValueException();
            }
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Lio/ktor/utils/io/bits/Memory$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/bits/Memory;", "getEmpty-SK3TCg8", "()Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MemoryJvm.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getEmpty-SK3TCg8  reason: not valid java name */
        public final ByteBuffer m56getEmptySK3TCg8() {
            return Memory.Empty;
        }
    }

    static {
        ByteBuffer order = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        Empty = m40constructorimpl(order);
    }
}
