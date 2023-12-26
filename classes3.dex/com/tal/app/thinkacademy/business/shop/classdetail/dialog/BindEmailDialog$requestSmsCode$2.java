package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$requestSmsCode$2", f = "BindEmailDialog.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BindEmailDialog.kt */
final class BindEmailDialog$requestSmsCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $contactInfo;
    final /* synthetic */ String $countryCallingCode;
    int label;
    final /* synthetic */ BindEmailDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BindEmailDialog$requestSmsCode$2(BindEmailDialog bindEmailDialog, String str, String str2, Continuation<? super BindEmailDialog$requestSmsCode$2> continuation) {
        super(2, continuation);
        this.this$0 = bindEmailDialog;
        this.$contactInfo = str;
        this.$countryCallingCode = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BindEmailDialog$requestSmsCode$2(this.this$0, this.$contactInfo, this.$countryCallingCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BindEmailDialog$requestSmsCode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BindEmailDialog bindEmailDialog = this.this$0;
            String str = this.$contactInfo;
            this.label = 1;
            if (BindEmailDialog.getSmsCode$default(bindEmailDialog, str, this.$countryCallingCode, (Integer) null, (Integer) null, this, 12, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        VerifyCodeCountDownTimer access$getMSmsTimer$p = this.this$0.mSmsTimer;
        if (access$getMSmsTimer$p != null) {
            access$getMSmsTimer$p.start();
        }
        return Unit.INSTANCE;
    }
}
