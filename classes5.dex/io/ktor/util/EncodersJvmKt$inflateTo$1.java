package io.ktor.util;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", i = {0}, l = {159}, m = "inflateTo", n = {"inflated"}, s = {"I$0"})
/* compiled from: EncodersJvm.kt */
final class EncodersJvmKt$inflateTo$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;

    EncodersJvmKt$inflateTo$1(Continuation<? super EncodersJvmKt$inflateTo$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EncodersJvmKt.inflateTo((Inflater) null, (ByteWriteChannel) null, (ByteBuffer) null, (Checksum) null, (Continuation) this);
    }
}
