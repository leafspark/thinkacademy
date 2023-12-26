package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt", f = "Reading.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {28}, m = "copyTo", n = {"$this$copyTo", "channel", "buffer", "limit", "copied", "bufferSize", "rc"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "I$0"})
/* compiled from: Reading.kt */
final class ReadingKt$copyTo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ReadingKt$copyTo$1(Continuation<? super ReadingKt$copyTo$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadingKt.copyTo((InputStream) null, (ByteWriteChannel) null, 0, (Continuation) this);
    }
}
