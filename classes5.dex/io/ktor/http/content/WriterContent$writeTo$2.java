package io.ktor.http.content;

import io.ktor.util.cio.OutputStreamAdaptersKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.Closeable;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.WriterContent$writeTo$2", f = "WriterContent.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WriterContent.kt */
final class WriterContent$writeTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteWriteChannel $channel;
    final /* synthetic */ Charset $charset;
    Object L$0;
    int label;
    final /* synthetic */ WriterContent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WriterContent$writeTo$2(ByteWriteChannel byteWriteChannel, Charset charset, WriterContent writerContent, Continuation<? super WriterContent$writeTo$2> continuation) {
        super(1, continuation);
        this.$channel = byteWriteChannel;
        this.$charset = charset;
        this.this$0 = writerContent;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return (Continuation) new WriterContent$writeTo$2(this.$channel, this.$charset, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th;
        Closeable closeable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Closeable writer = OutputStreamAdaptersKt.writer(this.$channel, this.$charset);
            try {
                Function2 access$getBody$p = this.this$0.body;
                this.L$0 = writer;
                this.label = 1;
                if (access$getBody$p.invoke((Writer) writer, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                closeable = writer;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                closeable = writer;
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(closeable, th);
                    throw th4;
                }
            }
        } else if (i == 1) {
            closeable = (Closeable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th5) {
                th = th5;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(closeable, (Throwable) null);
        return Unit.INSTANCE;
    }
}
