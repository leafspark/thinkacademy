package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2", f = "Reading.kt", i = {0, 0}, l = {89}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
/* compiled from: Reading.kt */
final class ReadingKt$toByteReadChannel$2 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObjectPool<byte[]> $pool;
    final /* synthetic */ InputStream $this_toByteReadChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReadingKt$toByteReadChannel$2(ObjectPool<byte[]> objectPool, InputStream inputStream, Continuation<? super ReadingKt$toByteReadChannel$2> continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.$this_toByteReadChannel = inputStream;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> readingKt$toByteReadChannel$2 = new ReadingKt$toByteReadChannel$2(this.$pool, this.$this_toByteReadChannel, continuation);
        readingKt$toByteReadChannel$2.L$0 = obj;
        return (Continuation) readingKt$toByteReadChannel$2;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        InputStream inputStream;
        Throwable th;
        WriterScope writerScope;
        byte[] bArr;
        ReadingKt$toByteReadChannel$2 readingKt$toByteReadChannel$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            bArr = this.$pool.borrow();
            writerScope = (WriterScope) this.L$0;
        } else if (i == 1) {
            bArr = (byte[]) this.L$1;
            writerScope = (WriterScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                readingKt$toByteReadChannel$2 = this;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (true) {
            try {
                int read = this.$this_toByteReadChannel.read(bArr, 0, bArr.length);
                if (read < 0) {
                    this.$pool.recycle(bArr);
                    inputStream = this.$this_toByteReadChannel;
                    break;
                } else if (read != 0) {
                    this.L$0 = writerScope;
                    this.L$1 = bArr;
                    this.label = 1;
                    if (writerScope.getChannel().writeFully(bArr, 0, read, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                readingKt$toByteReadChannel$2 = this;
                th = th4;
                try {
                    writerScope.getChannel().close(th);
                    readingKt$toByteReadChannel$2.$pool.recycle(bArr);
                    inputStream = readingKt$toByteReadChannel$2.$this_toByteReadChannel;
                    inputStream.close();
                    return Unit.INSTANCE;
                } catch (Throwable th5) {
                    readingKt$toByteReadChannel$2.$pool.recycle(bArr);
                    readingKt$toByteReadChannel$2.$this_toByteReadChannel.close();
                    throw th5;
                }
            }
        }
        inputStream.close();
        return Unit.INSTANCE;
    }
}
