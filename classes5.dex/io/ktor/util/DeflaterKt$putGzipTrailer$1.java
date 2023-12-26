package io.ktor.util;

import io.ktor.utils.io.ByteWriteChannel;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0}, l = {43, 44}, m = "putGzipTrailer", n = {"$this$putGzipTrailer", "deflater"}, s = {"L$0", "L$1"})
/* compiled from: Deflater.kt */
final class DeflaterKt$putGzipTrailer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    DeflaterKt$putGzipTrailer$1(Continuation<? super DeflaterKt$putGzipTrailer$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DeflaterKt.putGzipTrailer((ByteWriteChannel) null, (Checksum) null, (Deflater) null, (Continuation) this);
    }
}
