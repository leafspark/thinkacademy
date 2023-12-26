package com.tal.app.thinkacademy.business.login.presenter;

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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.SettingsViewModel$accountSwitchSchool$2", f = "SettingsViewModel.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SettingsViewModel.kt */
final class SettingsViewModel$accountSwitchSchool$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $schoolCode;
    int label;
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsViewModel$accountSwitchSchool$2(SettingsViewModel settingsViewModel, int i, Continuation<? super SettingsViewModel$accountSwitchSchool$2> continuation) {
        super(2, continuation);
        this.this$0 = settingsViewModel;
        this.$schoolCode = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsViewModel$accountSwitchSchool$2(this.this$0, this.$schoolCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsViewModel$accountSwitchSchool$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.repository.getAccountList(String.valueOf(this.$schoolCode), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getAccountSwitchSchool().postSuccess(Boxing.boxInt(this.$schoolCode));
        return Unit.INSTANCE;
    }
}
