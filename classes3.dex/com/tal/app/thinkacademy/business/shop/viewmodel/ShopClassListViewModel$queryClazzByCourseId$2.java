package com.tal.app.thinkacademy.business.shop.viewmodel;

import com.tal.app.thinkacademy.business.shop.bean.ShopClassData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassListRequestData;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.ShopClassListViewModel$queryClazzByCourseId$2", f = "ShopClassListViewModel.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShopClassListViewModel.kt */
final class ShopClassListViewModel$queryClazzByCourseId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShopRequestCommonBody<ShopClassListRequestData> $body;
    Object L$0;
    int label;
    final /* synthetic */ ShopClassListViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassListViewModel$queryClazzByCourseId$2(ShopClassListViewModel shopClassListViewModel, ShopRequestCommonBody<ShopClassListRequestData> shopRequestCommonBody, Continuation<? super ShopClassListViewModel$queryClazzByCourseId$2> continuation) {
        super(2, continuation);
        this.this$0 = shopClassListViewModel;
        this.$body = shopRequestCommonBody;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShopClassListViewModel$queryClazzByCourseId$2(this.this$0, this.$body, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShopClassListViewModel$queryClazzByCourseId$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<ShopClassData> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<ShopClassData> mShopClassList = this.this$0.getMShopClassList();
            this.L$0 = mShopClassList;
            this.label = 1;
            Object queryClazzByCourseId = this.this$0.mRepository.queryClazzByCourseId(this.$body, this);
            if (queryClazzByCourseId == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = mShopClassList;
            obj = queryClazzByCourseId;
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
