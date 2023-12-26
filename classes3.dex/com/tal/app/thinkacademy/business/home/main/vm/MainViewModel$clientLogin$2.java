package com.tal.app.thinkacademy.business.home.main.vm;

import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.BodyHeaders;
import com.tal.app.thinkacademy.common.entity.PushData;
import com.tal.app.thinkacademy.common.entity.PushRequestBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.vm.MainViewModel$clientLogin$2", f = "MainViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainViewModel.kt */
final class MainViewModel$clientLogin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clientId;
    final /* synthetic */ int $clientType;
    Object L$0;
    int label;
    final /* synthetic */ MainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainViewModel$clientLogin$2(MainViewModel mainViewModel, String str, int i, Continuation<? super MainViewModel$clientLogin$2> continuation) {
        super(2, continuation);
        this.this$0 = mainViewModel;
        this.$clientId = str;
        this.$clientType = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainViewModel$clientLogin$2(this.this$0, this.$clientId, this.$clientType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainViewModel$clientLogin$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<Object> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<Object> clientLogin = this.this$0.getClientLogin();
            this.L$0 = clientLogin;
            this.label = 1;
            Object clientLogin2 = this.this$0.repository.clientLogin(new PushRequestBean((BodyHeaders) null, new PushData(this.$clientId, this.$clientType), 1, (DefaultConstructorMarker) null), this);
            if (clientLogin2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = clientLogin;
            obj = clientLogin2;
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
