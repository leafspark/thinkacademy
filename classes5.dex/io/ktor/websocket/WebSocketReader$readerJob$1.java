package io.ktor.websocket;

import io.ktor.util.cio.ChannelIOException;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader$readerJob$1", f = "WebSocketReader.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"buffer"}, s = {"L$0"})
/* compiled from: WebSocketReader.kt */
final class WebSocketReader$readerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    Object L$0;
    int label;
    final /* synthetic */ WebSocketReader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebSocketReader$readerJob$1(ObjectPool<ByteBuffer> objectPool, WebSocketReader webSocketReader, Continuation<? super WebSocketReader$readerJob$1> continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.this$0 = webSocketReader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new WebSocketReader$readerJob$1(this.$pool, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FrameTooBigException e;
        Throwable th;
        ByteBuffer coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ByteBuffer borrow = this.$pool.borrow();
            try {
                this.L$0 = borrow;
                this.label = 1;
                if (this.this$0.readLoop(borrow, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (ClosedChannelException | CancellationException unused) {
            } catch (ChannelIOException unused2) {
                coroutine_suspended = borrow;
                ReceiveChannel.DefaultImpls.cancel$default(this.this$0.queue, (CancellationException) null, 1, (Object) null);
                this.$pool.recycle(coroutine_suspended);
                SendChannel.DefaultImpls.close$default(this.this$0.queue, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            } catch (FrameTooBigException e2) {
                FrameTooBigException frameTooBigException = e2;
                coroutine_suspended = borrow;
                e = frameTooBigException;
                this.this$0.queue.close(e);
                this.$pool.recycle(coroutine_suspended);
                SendChannel.DefaultImpls.close$default(this.this$0.queue, (Throwable) null, 1, (Object) null);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                this.$pool.recycle(coroutine_suspended);
                SendChannel.DefaultImpls.close$default(this.this$0.queue, (Throwable) null, 1, (Object) null);
                throw th2;
            }
            coroutine_suspended = borrow;
        } else if (i == 1) {
            coroutine_suspended = (ByteBuffer) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (ClosedChannelException | CancellationException unused3) {
            } catch (ChannelIOException unused4) {
                ReceiveChannel.DefaultImpls.cancel$default(this.this$0.queue, (CancellationException) null, 1, (Object) null);
            } catch (FrameTooBigException e3) {
                e = e3;
                this.this$0.queue.close(e);
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$pool.recycle(coroutine_suspended);
        SendChannel.DefaultImpls.close$default(this.this$0.queue, (Throwable) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}
