package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\b"}, d2 = {"read", "", "Lio/ktor/utils/io/core/Input;", "n", "", "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PacketDirect.kt */
public final class PacketDirectKt {
    public static /* synthetic */ void read$default(Input input, int i, Function1 function1, int i2, Object obj) {
        int readPosition;
        int writePosition;
        if ((i2 & 1) != 0) {
            i = 1;
        }
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ChunkBuffer prepareRead = input.prepareRead(i);
        if (prepareRead != null) {
            int readPosition2 = prepareRead.getReadPosition();
            try {
                function1.invoke(prepareRead);
                if (readPosition >= readPosition2) {
                    if (readPosition != writePosition) {
                        input.setHeadPosition(readPosition);
                    }
                    return;
                }
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            } finally {
                InlineMarker.finallyStart(1);
                readPosition = prepareRead.getReadPosition();
                if (readPosition >= readPosition2) {
                    if (readPosition == prepareRead.getWritePosition()) {
                        input.ensureNext(prepareRead);
                    } else {
                        input.setHeadPosition(readPosition);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
        } else {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
    }

    public static final void read(Input input, int i, Function1<? super Buffer, Unit> function1) {
        int readPosition;
        int writePosition;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ChunkBuffer prepareRead = input.prepareRead(i);
        if (prepareRead != null) {
            int readPosition2 = prepareRead.getReadPosition();
            try {
                function1.invoke(prepareRead);
                if (readPosition >= readPosition2) {
                    if (readPosition != writePosition) {
                        input.setHeadPosition(readPosition);
                    }
                    return;
                }
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            } finally {
                InlineMarker.finallyStart(1);
                readPosition = prepareRead.getReadPosition();
                if (readPosition >= readPosition2) {
                    if (readPosition == prepareRead.getWritePosition()) {
                        input.ensureNext(prepareRead);
                    } else {
                        input.setHeadPosition(readPosition);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
        } else {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
    }
}
