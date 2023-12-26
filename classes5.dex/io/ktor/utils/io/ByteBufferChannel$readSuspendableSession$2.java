package io.ktor.utils.io;

import io.ktor.utils.io.internal.ReadSessionImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel$readSuspendableSession$2", f = "ByteBufferChannel.kt", i = {}, l = {1616}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ByteBufferChannel.kt */
final class ByteBufferChannel$readSuspendableSession$2 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<SuspendableReadSession, Continuation<? super Unit>, Object> $consumer;
    int label;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$readSuspendableSession$2(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readSuspendableSession$2> continuation) {
        super(2, continuation);
        this.$consumer = function2;
        this.this$0 = byteBufferChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new ByteBufferChannel$readSuspendableSession$2(this.$consumer, this.this$0, continuation);
    }

    public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Unit> continuation) {
        return create(lookAheadSuspendSession, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<SuspendableReadSession, Continuation<? super Unit>, Object> function2 = this.$consumer;
            ReadSessionImpl access$getReadSession$p = this.this$0.readSession;
            this.label = 1;
            if (function2.invoke(access$getReadSession$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                this.this$0.readSession.completed();
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.readSession.completed();
        return Unit.INSTANCE;
    }
}
