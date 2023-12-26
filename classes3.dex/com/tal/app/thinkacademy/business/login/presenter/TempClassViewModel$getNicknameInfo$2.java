package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.common.base.StateLiveData;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.TempClassViewModel$getNicknameInfo$2", f = "TempClassViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TempClassViewModel.kt */
final class TempClassViewModel$getNicknameInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TempClassViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TempClassViewModel$getNicknameInfo$2(TempClassViewModel tempClassViewModel, Continuation<? super TempClassViewModel$getNicknameInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = tempClassViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TempClassViewModel$getNicknameInfo$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TempClassViewModel$getNicknameInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData access$get_nickNameLiveData$p = this.this$0._nickNameLiveData;
            this.L$0 = access$get_nickNameLiveData$p;
            this.label = 1;
            Object nickname = this.this$0.repository.getNickname(this);
            if (nickname == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = access$get_nickNameLiveData$p;
            obj = nickname;
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