package io.ktor.util.cio;

import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.InputStreamAdaptersKt$toByteReadChannel$1", f = "InputStreamAdapters.kt", i = {0, 0}, l = {34}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
/* compiled from: InputStreamAdapters.kt */
final class InputStreamAdaptersKt$toByteReadChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    final /* synthetic */ InputStream $this_toByteReadChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputStreamAdaptersKt$toByteReadChannel$1(ObjectPool<ByteBuffer> objectPool, InputStream inputStream, Continuation<? super InputStreamAdaptersKt$toByteReadChannel$1> continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.$this_toByteReadChannel = inputStream;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> inputStreamAdaptersKt$toByteReadChannel$1 = new InputStreamAdaptersKt$toByteReadChannel$1(this.$pool, this.$this_toByteReadChannel, continuation);
        inputStreamAdaptersKt$toByteReadChannel$1.L$0 = obj;
        return (Continuation) inputStreamAdaptersKt$toByteReadChannel$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        InputStream inputStream;
        Throwable th;
        WriterScope writerScope;
        ByteBuffer byteBuffer;
        InputStreamAdaptersKt$toByteReadChannel$1 inputStreamAdaptersKt$toByteReadChannel$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            byteBuffer = this.$pool.borrow();
            writerScope = (WriterScope) this.L$0;
        } else if (i == 1) {
            byteBuffer = (ByteBuffer) this.L$1;
            writerScope = (WriterScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                inputStreamAdaptersKt$toByteReadChannel$1 = this;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (true) {
            try {
                byteBuffer.clear();
                int read = this.$this_toByteReadChannel.read(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                if (read < 0) {
                    this.$pool.recycle(byteBuffer);
                    inputStream = this.$this_toByteReadChannel;
                    break;
                } else if (read != 0) {
                    byteBuffer.position(byteBuffer.position() + read);
                    byteBuffer.flip();
                    this.L$0 = writerScope;
                    this.L$1 = byteBuffer;
                    this.label = 1;
                    if (writerScope.getChannel().writeFully(byteBuffer, (Continuation<? super Unit>) (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                inputStreamAdaptersKt$toByteReadChannel$1 = this;
                th = th4;
                try {
                    writerScope.getChannel().close(th);
                    inputStreamAdaptersKt$toByteReadChannel$1.$pool.recycle(byteBuffer);
                    inputStream = inputStreamAdaptersKt$toByteReadChannel$1.$this_toByteReadChannel;
                    inputStream.close();
                    return Unit.INSTANCE;
                } catch (Throwable th5) {
                    inputStreamAdaptersKt$toByteReadChannel$1.$pool.recycle(byteBuffer);
                    inputStreamAdaptersKt$toByteReadChannel$1.$this_toByteReadChannel.close();
                    throw th5;
                }
            }
        }
        inputStream.close();
        return Unit.INSTANCE;
    }
}
