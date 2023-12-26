package io.ktor.utils.io.core;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u0004\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0006H\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006\b"}, d2 = {"use", "R", "C", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Closeable.kt */
public final class CloseableKt {
    public static final <C extends Closeable, R> R use(C c, Function1<? super C, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(c, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            R invoke = function1.invoke(c);
            InlineMarker.finallyStart(1);
            c.close();
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            throw th;
        }
        throw th;
    }
}
