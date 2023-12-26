package com.tal.app.thinkacademy.live.business.interactivegames.activity;

import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.interactivegames.activity.GameViewModel$submitGameClose$2", f = "GameViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GameViewModel.kt */
final class GameViewModel$submitGameClose$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OpenStatusBody $body;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ GameViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GameViewModel$submitGameClose$2(GameViewModel gameViewModel, String str, OpenStatusBody openStatusBody, Continuation<? super GameViewModel$submitGameClose$2> continuation) {
        super(2, continuation);
        this.this$0 = gameViewModel;
        this.$url = str;
        this.$body = openStatusBody;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new GameViewModel$submitGameClose$2(this.this$0, this.$url, this.$body, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<EmptyBean> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<EmptyBean> mGameCloseState = this.this$0.getMGameCloseState();
            this.L$0 = mGameCloseState;
            this.label = 1;
            Object submitGameClose = this.this$0.mRepository.submitGameClose(this.$url, this.$body, (Continuation) this);
            if (submitGameClose == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = mGameCloseState;
            obj = submitGameClose;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        stateLiveData.postSuccess(obj);
        return Unit.INSTANCE;
    }
}
