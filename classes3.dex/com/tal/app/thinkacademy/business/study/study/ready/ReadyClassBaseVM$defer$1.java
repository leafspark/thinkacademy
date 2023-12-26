package com.tal.app.thinkacademy.business.study.study.ready;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.ready.ReadyClassBaseVM$defer$1", f = "ReadyClassBaseVM.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ReadyClassBaseVM.kt */
final class ReadyClassBaseVM$defer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $call;
    final /* synthetic */ long $timeMillis;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReadyClassBaseVM$defer$1(long j, Function0<Unit> function0, Continuation<? super ReadyClassBaseVM$defer$1> continuation) {
        super(2, continuation);
        this.$timeMillis = j;
        this.$call = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReadyClassBaseVM$defer$1(this.$timeMillis, this.$call, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReadyClassBaseVM$defer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.$timeMillis, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$call.invoke();
        return Unit.INSTANCE;
    }
}
