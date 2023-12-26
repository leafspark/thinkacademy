package com.tal.thinkacademy.networkprobe;

import com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache;
import com.tal.thinkacademy.networkprobe.cache.TraceEventCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.thinkacademy.networkprobe.TraceEventListener$Factory$create$1", f = "TraceEventListener.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TraceEventListener.kt */
final class TraceEventListener$Factory$create$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callId;
    final /* synthetic */ NetworkTraceCache $networkTraceBean;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TraceEventListener$Factory$create$1(String str, NetworkTraceCache networkTraceCache, Continuation<? super TraceEventListener$Factory$create$1> continuation) {
        super(2, continuation);
        this.$callId = str;
        this.$networkTraceBean = networkTraceCache;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new TraceEventListener$Factory$create$1(this.$callId, this.$networkTraceBean, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (TraceEventCache.INSTANCE.save(this.$callId, this.$networkTraceBean, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
