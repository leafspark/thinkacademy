package com.tal.app.thinkacademy.live.business.interactivegames.activity;

import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.interactivegames.activity.GameViewModel$submitGameData$2", f = "GameViewModel.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GameViewModel.kt */
final class GameViewModel$submitGameData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubmitGameDataBody $body;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ GameViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GameViewModel$submitGameData$2(GameViewModel gameViewModel, String str, SubmitGameDataBody submitGameDataBody, Continuation<? super GameViewModel$submitGameData$2> continuation) {
        super(2, continuation);
        this.this$0 = gameViewModel;
        this.$url = str;
        this.$body = submitGameDataBody;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new GameViewModel$submitGameData$2(this.this$0, this.$url, this.$body, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<AnswerBean> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<AnswerBean> mGameSubmitState = this.this$0.getMGameSubmitState();
            this.L$0 = mGameSubmitState;
            this.label = 1;
            Object submitGameData = this.this$0.mRepository.submitGameData(this.$url, this.$body, (Continuation) this);
            if (submitGameData == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = mGameSubmitState;
            obj = submitGameData;
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
