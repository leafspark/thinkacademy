package io.ktor.util;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0, 0, 0}, l = {52}, m = "deflateWhile", n = {"$this$deflateWhile", "deflater", "buffer", "predicate"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: Deflater.kt */
final class DeflaterKt$deflateWhile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    DeflaterKt$deflateWhile$1(Continuation<? super DeflaterKt$deflateWhile$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DeflaterKt.deflateWhile((ByteWriteChannel) null, (Deflater) null, (ByteBuffer) null, (Function0<Boolean>) null, (Continuation) this);
    }
}
