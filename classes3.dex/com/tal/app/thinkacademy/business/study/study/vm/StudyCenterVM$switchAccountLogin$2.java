package com.tal.app.thinkacademy.business.study.study.vm;

import com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.UserBean;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.vm.StudyCenterVM$switchAccountLogin$2", f = "StudyCenterVM.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StudyCenterVM.kt */
final class StudyCenterVM$switchAccountLogin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uid;
    Object L$0;
    int label;
    final /* synthetic */ StudyCenterVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudyCenterVM$switchAccountLogin$2(StudyCenterVM studyCenterVM, String str, Continuation<? super StudyCenterVM$switchAccountLogin$2> continuation) {
        super(2, continuation);
        this.this$0 = studyCenterVM;
        this.$uid = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StudyCenterVM$switchAccountLogin$2(this.this$0, this.$uid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StudyCenterVM$switchAccountLogin$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<UserBean> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<UserBean> loginData = this.this$0.getLoginData();
            this.L$0 = loginData;
            this.label = 1;
            Object switchLogin = PlanListRepositoryKt.switchLogin(this.$uid, this);
            if (switchLogin == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = loginData;
            obj = switchLogin;
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
