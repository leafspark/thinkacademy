package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.request.ModifyEmailRequest;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$requestModifyEmail$2", f = "BindEmailDialog.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BindEmailDialog.kt */
final class BindEmailDialog$requestModifyEmail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShopRequestCommonBody<ModifyEmailRequest> $body;
    int label;
    final /* synthetic */ BindEmailDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BindEmailDialog$requestModifyEmail$2(BindEmailDialog bindEmailDialog, ShopRequestCommonBody<ModifyEmailRequest> shopRequestCommonBody, Continuation<? super BindEmailDialog$requestModifyEmail$2> continuation) {
        super(2, continuation);
        this.this$0 = bindEmailDialog;
        this.$body = shopRequestCommonBody;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BindEmailDialog$requestModifyEmail$2(this.this$0, this.$body, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BindEmailDialog$requestModifyEmail$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getModifyEmail(this.$body, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ToastUtils.showLong(R.string.link_success);
        Function1 access$getMListener$p = this.this$0.mListener;
        if (access$getMListener$p != null) {
            access$getMListener$p.invoke(PhoneEmailBindState.BIND_SUCCESS);
        }
        this.this$0.dismiss();
        return Unit.INSTANCE;
    }
}
