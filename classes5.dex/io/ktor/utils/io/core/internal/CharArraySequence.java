package io.ktor.utils.io.core.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0016\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/ktor/utils/io/core/internal/CharArraySequence;", "", "array", "", "offset", "", "length", "([CII)V", "getLength", "()I", "get", "", "index", "indexOutOfBounds", "", "subSequence", "startIndex", "endIndex", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CharArraySequence.kt */
public final class CharArraySequence implements CharSequence {
    private final char[] array;
    private final int length;
    private final int offset;

    public CharArraySequence(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        this.array = cArr;
        this.offset = i;
        this.length = i2;
    }

    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final /* bridge */ int length() {
        return this.length;
    }

    public final int getLength() {
        return this.length;
    }

    public final char get(int i) {
        if (i < this.length) {
            return this.array[i + this.offset];
        }
        indexOutOfBounds(i);
        throw new KotlinNothingValueException();
    }

    public final CharSequence subSequence(int i, int i2) {
        boolean z = true;
        if (i >= 0) {
            int i3 = this.length;
            if (i <= i3) {
                if (i + i2 <= i3) {
                    if (i2 < i) {
                        z = false;
                    }
                    if (z) {
                        return new CharArraySequence(this.array, this.offset + i, i2 - i);
                    }
                    throw new IllegalArgumentException(("endIndex should be greater or equal to startIndex: " + i + " > " + i2).toString());
                }
                throw new IllegalArgumentException(("endIndex is too large: " + i2 + " > " + this.length).toString());
            }
            throw new IllegalArgumentException(("startIndex is too large: " + i + " > " + this.length).toString());
        }
        throw new IllegalArgumentException(("startIndex shouldn't be negative: " + i).toString());
    }

    private final Void indexOutOfBounds(int i) {
        throw new IndexOutOfBoundsException("String index out of bounds: " + i + " > " + this.length);
    }
}
