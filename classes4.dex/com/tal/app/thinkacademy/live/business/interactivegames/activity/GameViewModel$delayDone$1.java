package com.tal.app.thinkacademy.live.business.interactivegames.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.interactivegames.activity.GameViewModel$delayDone$1", f = "GameViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GameViewModel.kt */
final class GameViewModel$delayDone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    int label;
    final /* synthetic */ GameViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GameViewModel$delayDone$1(long j, GameViewModel gameViewModel, Continuation<? super GameViewModel$delayDone$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
        this.this$0 = gameViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new GameViewModel$delayDone$1(this.$delayTime, this.this$0, continuation);
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
            if (DelayKt.delay(this.$delayTime, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getMDelayData().postStickyData(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}