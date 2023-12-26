package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0007\u001aC\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"withMemory", "R", "size", "", "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/bits/Memory;", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "(JLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MemoryFactory.kt */
public final class MemoryFactoryKt {
    public static final <R> R withMemory(long j, Function1<? super Memory, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        DefaultAllocator defaultAllocator = DefaultAllocator.INSTANCE;
        ByteBuffer r2 = defaultAllocator.m37allocgFvZug(j);
        try {
            return function1.invoke(Memory.m39boximpl(r2));
        } finally {
            InlineMarker.finallyStart(1);
            defaultAllocator.m38free3GNKZMM(r2);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <R> R withMemory(int i, Function1<? super Memory, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        long j = (long) i;
        DefaultAllocator defaultAllocator = DefaultAllocator.INSTANCE;
        ByteBuffer r0 = defaultAllocator.m37allocgFvZug(j);
        try {
            return function1.invoke(Memory.m39boximpl(r0));
        } finally {
            InlineMarker.finallyStart(1);
            defaultAllocator.m38free3GNKZMM(r0);
            InlineMarker.finallyEnd(1);
        }
    }
}
