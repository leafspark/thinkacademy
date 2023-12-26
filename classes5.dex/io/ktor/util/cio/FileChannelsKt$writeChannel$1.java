package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.core.CloseableJVMKt;
import io.ktor.utils.io.jvm.nio.WritingKt;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", i = {0, 0, 0}, l = {99}, m = "invokeSuspend", n = {"$this$use$iv", "file", "closed$iv"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: FileChannels.kt */
final class FileChannelsKt$writeChannel$1 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $this_writeChannel;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileChannelsKt$writeChannel$1(File file, Continuation<? super FileChannelsKt$writeChannel$1> continuation) {
        super(2, continuation);
        this.$this_writeChannel = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fileChannelsKt$writeChannel$1 = new FileChannelsKt$writeChannel$1(this.$this_writeChannel, continuation);
        fileChannelsKt$writeChannel$1.L$0 = obj;
        return (Continuation) fileChannelsKt$writeChannel$1;
    }

    public final Object invoke(ReaderScope readerScope, Continuation<? super Unit> continuation) {
        return create(readerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Closeable closeable;
        RandomAccessFile randomAccessFile;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReaderScope readerScope = (ReaderScope) this.L$0;
            closeable = new RandomAccessFile(this.$this_writeChannel, "rw");
            RandomAccessFile randomAccessFile2 = (RandomAccessFile) closeable;
            ByteReadChannel channel = readerScope.getChannel();
            FileChannel channel2 = randomAccessFile2.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel2, "file.channel");
            this.L$0 = closeable;
            this.L$1 = randomAccessFile2;
            this.I$0 = 0;
            this.label = 1;
            obj = WritingKt.copyTo$default(channel, (WritableByteChannel) channel2, 0, (Continuation) this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            randomAccessFile = randomAccessFile2;
        } else if (i == 1) {
            randomAccessFile = (RandomAccessFile) this.L$1;
            closeable = (Closeable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                CloseableJVMKt.addSuppressedInternal(th, th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        randomAccessFile.setLength(((Number) obj).longValue());
        Unit unit = Unit.INSTANCE;
        closeable.close();
        return Unit.INSTANCE;
        throw th;
    }
}
