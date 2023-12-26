package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.entity.UseGetInfo;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.PersonalInfoViewModel$getUserInfo$2", f = "PersonalInfoViewModel.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PersonalInfoViewModel.kt */
final class PersonalInfoViewModel$getUserInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PersonalInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalInfoViewModel$getUserInfo$2(PersonalInfoViewModel personalInfoViewModel, Continuation<? super PersonalInfoViewModel$getUserInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = personalInfoViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PersonalInfoViewModel$getUserInfo$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PersonalInfoViewModel$getUserInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<UseGetInfo> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<UseGetInfo> mUserGetInfo = this.this$0.getMUserGetInfo();
            this.L$0 = mUserGetInfo;
            this.label = 1;
            Object basicUserInfoOnly = this.this$0.repository.getBasicUserInfoOnly(this);
            if (basicUserInfoOnly == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = mUserGetInfo;
            obj = basicUserInfoOnly;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        stateLiveData.postSuccess(obj);
        XesLog.dt("PersonalInfoViewModel", new Object[]{"获取用户信息成功"});
        return Unit.INSTANCE;
    }
}
