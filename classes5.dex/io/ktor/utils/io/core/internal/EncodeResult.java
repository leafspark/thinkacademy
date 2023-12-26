package io.ktor.utils.io.core.internal;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u001c\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0012\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\u000f\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000bJ\u0019\u0010\u0011\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0001\u0007ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lio/ktor/utils/io/core/internal/EncodeResult;", "", "characters", "Lkotlin/UShort;", "bytes", "constructor-impl", "(SS)I", "value", "", "(I)I", "getBytes-Mh2AYeg", "(I)S", "getCharacters-Mh2AYeg", "getValue", "()I", "component1", "component1-Mh2AYeg", "component2", "component2-Mh2AYeg", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: EncodeResult.kt */
public final class EncodeResult {
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ EncodeResult m292boximpl(int i) {
        return new EncodeResult(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m295constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m297equalsimpl(int i, Object obj) {
        return (obj instanceof EncodeResult) && i == ((EncodeResult) obj).m303unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m298equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m301hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m302toStringimpl(int i) {
        return "EncodeResult(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m297equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m301hashCodeimpl(this.value);
    }

    public String toString() {
        return m302toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m303unboximpl() {
        return this.value;
    }

    private /* synthetic */ EncodeResult(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m296constructorimpl(short s, short s2) {
        return m295constructorimpl(((s & UShort.MAX_VALUE) << 16) | (s2 & UShort.MAX_VALUE));
    }

    /* renamed from: getCharacters-Mh2AYeg  reason: not valid java name */
    public static final short m300getCharactersMh2AYeg(int i) {
        return UShort.m598constructorimpl((short) (i >>> 16));
    }

    /* renamed from: getBytes-Mh2AYeg  reason: not valid java name */
    public static final short m299getBytesMh2AYeg(int i) {
        return UShort.m598constructorimpl((short) (i & 65535));
    }

    /* renamed from: component1-Mh2AYeg  reason: not valid java name */
    public static final short m293component1Mh2AYeg(int i) {
        return m300getCharactersMh2AYeg(i);
    }

    /* renamed from: component2-Mh2AYeg  reason: not valid java name */
    public static final short m294component2Mh2AYeg(int i) {
        return m299getBytesMh2AYeg(i);
    }
}
