package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WritingKt", f = "Writing.kt", i = {0, 0, 0, 0}, l = {46}, m = "copyTo", n = {"$this$copyTo", "copied", "copy", "limit"}, s = {"L$0", "L$1", "L$2", "J$0"})
/* compiled from: Writing.kt */
final class WritingKt$copyTo$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    WritingKt$copyTo$1(Continuation<? super WritingKt$copyTo$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WritingKt.copyTo((ByteReadChannel) null, (WritableByteChannel) null, 0, (Continuation<? super Long>) (Continuation) this);
    }
}
