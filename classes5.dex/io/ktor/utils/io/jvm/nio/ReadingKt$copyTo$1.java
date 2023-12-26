package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.nio.ReadingKt", f = "Reading.kt", i = {0, 0, 0, 0, 0, 0}, l = {40}, m = "copyTo", n = {"ch", "copied", "eof", "copy", "limit", "needFlush"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0"})
/* compiled from: Reading.kt */
final class ReadingKt$copyTo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    ReadingKt$copyTo$1(Continuation<? super ReadingKt$copyTo$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadingKt.copyTo((ReadableByteChannel) null, (ByteWriteChannel) null, 0, (Continuation<? super Long>) (Continuation) this);
    }
}
