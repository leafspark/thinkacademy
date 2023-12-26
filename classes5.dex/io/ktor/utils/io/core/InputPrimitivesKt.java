package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\u0002H\u0002\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0002\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0002H\u0002\u001aK\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u000e0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u000e0\u0018H\b¢\u0006\u0002\u0010\u001a\u001a\n\u0010\u001b\u001a\u00020\u001c*\u00020\u0002\u001a\f\u0010\u001d\u001a\u00020\u001c*\u00020\u0002H\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"readDouble", "", "Lio/ktor/utils/io/core/Input;", "readDoubleFallback", "readFloat", "", "readFloatFallback", "readInt", "", "readIntFallback", "readLong", "", "readLongFallback", "readPrimitive", "R", "size", "main", "Lkotlin/Function2;", "Lio/ktor/utils/io/bits/Memory;", "fallback", "Lkotlin/Function0;", "(Lio/ktor/utils/io/core/Input;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "readPrimitiveFallback", "read", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "(Lio/ktor/utils/io/core/Input;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "readShort", "", "readShortFallback", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputPrimitives.kt */
public final class InputPrimitivesKt {
    private static final <R> R readPrimitiveFallback(Input input, int i, Function1<? super Buffer, ? extends R> function1) {
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, i);
        if (prepareReadFirstHead != null) {
            R invoke = function1.invoke(prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            return invoke;
        }
        StringsKt.prematureEndOfStream(i);
        throw new KotlinNothingValueException();
    }

    public static final short readShort(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 2) {
            return readShortFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 2);
        return input.m224getHeadMemorySK3TCg8().getShort(headPosition);
    }

    private static final short readShortFallback(Input input) {
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 2);
        if (prepareReadFirstHead != null) {
            short readShort = BufferPrimitivesKt.readShort((Buffer) prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            return readShort;
        }
        StringsKt.prematureEndOfStream(2);
        throw new KotlinNothingValueException();
    }

    public static final int readInt(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 4) {
            return readIntFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 4);
        return input.m224getHeadMemorySK3TCg8().getInt(headPosition);
    }

    private static final int readIntFallback(Input input) {
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 4);
        if (prepareReadFirstHead != null) {
            int readInt = BufferPrimitivesKt.readInt((Buffer) prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            return readInt;
        }
        StringsKt.prematureEndOfStream(4);
        throw new KotlinNothingValueException();
    }

    public static final long readLong(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 8) {
            return readLongFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 8);
        return input.m224getHeadMemorySK3TCg8().getLong(headPosition);
    }

    private static final long readLongFallback(Input input) {
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 8);
        if (prepareReadFirstHead != null) {
            long readLong = BufferPrimitivesKt.readLong((Buffer) prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            return readLong;
        }
        StringsKt.prematureEndOfStream(8);
        throw new KotlinNothingValueException();
    }

    public static final float readFloat(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 4) {
            return readFloatFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 4);
        return input.m224getHeadMemorySK3TCg8().getFloat(headPosition);
    }

    public static final float readFloatFallback(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 4);
        if (prepareReadFirstHead != null) {
            float readFloat = BufferPrimitivesKt.readFloat((Buffer) prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            return readFloat;
        }
        StringsKt.prematureEndOfStream(4);
        throw new KotlinNothingValueException();
    }

    public static final double readDouble(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 8) {
            return readDoubleFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 8);
        return input.m224getHeadMemorySK3TCg8().getDouble(headPosition);
    }

    public static final double readDoubleFallback(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 8);
        if (prepareReadFirstHead != null) {
            double readDouble = BufferPrimitivesKt.readDouble((Buffer) prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            return readDouble;
        }
        StringsKt.prematureEndOfStream(8);
        throw new KotlinNothingValueException();
    }

    private static final <R> R readPrimitive(Input input, int i, Function2<? super Memory, ? super Integer, ? extends R> function2, Function0<? extends R> function0) {
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= i) {
            return function0.invoke();
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(i + headPosition);
        return function2.invoke(Memory.m39boximpl(input.m224getHeadMemorySK3TCg8()), Integer.valueOf(headPosition));
    }
}
