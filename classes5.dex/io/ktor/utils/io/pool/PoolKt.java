package io.ktor.utils.io.pool;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0006H\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a?\u0010\b\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0006H\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"useBorrowed", "R", "T", "", "Lio/ktor/utils/io/pool/ObjectPool;", "block", "Lkotlin/Function1;", "(Lio/ktor/utils/io/pool/ObjectPool;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "useInstance", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Pool.kt */
public final class PoolKt {
    public static final <T, R> R useInstance(ObjectPool<T> objectPool, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(objectPool, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        T borrow = objectPool.borrow();
        try {
            return function1.invoke(borrow);
        } finally {
            InlineMarker.finallyStart(1);
            objectPool.recycle(borrow);
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(message = "Use useInstance instead", replaceWith = @ReplaceWith(expression = "useInstance(block)", imports = {}))
    public static final <T, R> R useBorrowed(ObjectPool<T> objectPool, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(objectPool, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        T borrow = objectPool.borrow();
        try {
            return function1.invoke(borrow);
        } finally {
            InlineMarker.finallyStart(1);
            objectPool.recycle(borrow);
            InlineMarker.finallyEnd(1);
        }
    }
}
