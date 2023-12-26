package io.ktor.util.cio;

import io.ktor.util.BufferViewJvmKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterSuspendSession;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1$3$1", f = "FileChannels.kt", i = {0}, l = {52}, m = "invokeSuspend", n = {"$this$writeSuspendSession"}, s = {"L$0"})
/* compiled from: FileChannels.kt */
final class FileChannelsKt$readChannel$1$3$1 extends SuspendLambda implements Function2<WriterSuspendSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ WriterScope $$this$writer;
    final /* synthetic */ FileChannel $fileChannel;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileChannelsKt$readChannel$1$3$1(WriterScope writerScope, FileChannel fileChannel, Continuation<? super FileChannelsKt$readChannel$1$3$1> continuation) {
        super(2, continuation);
        this.$$this$writer = writerScope;
        this.$fileChannel = fileChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fileChannelsKt$readChannel$1$3$1 = new FileChannelsKt$readChannel$1$3$1(this.$$this$writer, this.$fileChannel, continuation);
        fileChannelsKt$readChannel$1$3$1.L$0 = obj;
        return (Continuation) fileChannelsKt$readChannel$1$3$1;
    }

    public final Object invoke(WriterSuspendSession writerSuspendSession, Continuation<? super Unit> continuation) {
        return create(writerSuspendSession, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        WriterSuspendSession writerSuspendSession;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            writerSuspendSession = (WriterSuspendSession) this.L$0;
        } else if (i == 1) {
            writerSuspendSession = (WriterSuspendSession) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (true) {
            ChunkBuffer request = writerSuspendSession.request(1);
            if (request == null) {
                this.$$this$writer.getChannel().flush();
                this.L$0 = writerSuspendSession;
                this.label = 1;
                if (writerSuspendSession.tryAwait(1, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                int read = BufferViewJvmKt.read(this.$fileChannel, request);
                if (read == -1) {
                    return Unit.INSTANCE;
                }
                writerSuspendSession.written(read);
            }
        }
    }
}
