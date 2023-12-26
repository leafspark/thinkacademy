package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.request.WishRequestBean;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel$requestStuWishAdd$2", f = "ShopClassDetailViewModel.kt", i = {}, l = {689}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShopClassDetailViewModel.kt */
final class ShopClassDetailViewModel$requestStuWishAdd$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShopRequestCommonBody<WishRequestBean> $requestBody;
    int label;
    final /* synthetic */ ShopClassDetailViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassDetailViewModel$requestStuWishAdd$2(ShopClassDetailViewModel shopClassDetailViewModel, ShopRequestCommonBody<WishRequestBean> shopRequestCommonBody, Continuation<? super ShopClassDetailViewModel$requestStuWishAdd$2> continuation) {
        super(2, continuation);
        this.this$0 = shopClassDetailViewModel;
        this.$requestBody = shopRequestCommonBody;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShopClassDetailViewModel$requestStuWishAdd$2(this.this$0, this.$requestBody, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShopClassDetailViewModel$requestStuWishAdd$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getStuWishAdd(this.$requestBody, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getMWishAdd().postSuccess(obj);
        XesLog.dt("ShopClassDetailViewModel", new Object[]{"requestStuWishAdd success"});
        return Unit.INSTANCE;
    }
}
