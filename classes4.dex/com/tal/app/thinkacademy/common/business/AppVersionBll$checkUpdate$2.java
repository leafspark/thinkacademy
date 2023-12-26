package com.tal.app.thinkacademy.common.business;

import android.content.Context;
import com.tal.app.thinkacademy.common.entity.UpdateVersionEntity;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.business.AppVersionBll$checkUpdate$2", f = "AppVersionBll.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AppVersionBll.kt */
final class AppVersionBll$checkUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $downLoadResult;
    final /* synthetic */ boolean $isAutoCheck;
    int label;
    final /* synthetic */ AppVersionBll this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppVersionBll$checkUpdate$2(AppVersionBll appVersionBll, Function0<Unit> function0, Context context, boolean z, Continuation<? super AppVersionBll$checkUpdate$2> continuation) {
        super(2, continuation);
        this.this$0 = appVersionBll;
        this.$downLoadResult = function0;
        this.$context = context;
        this.$isAutoCheck = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new AppVersionBll$checkUpdate$2(this.this$0, this.$downLoadResult, this.$context, this.$isAutoCheck, continuation);
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
            obj = this.this$0.repository.newCheckUpdate((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$downLoadResult.invoke();
        this.this$0.appUpdateCheck(this.$context, (UpdateVersionEntity) obj, this.$isAutoCheck);
        return Unit.INSTANCE;
    }
}
