package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.request.ShopClassDetailRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel", f = "ShopClassDetailViewModel.kt", i = {}, l = {608, 606}, m = "getStuFollowAdd", n = {}, s = {})
/* compiled from: ShopClassDetailViewModel.kt */
final class ShopClassDetailViewModel$getStuFollowAdd$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShopClassDetailViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassDetailViewModel$getStuFollowAdd$1(ShopClassDetailViewModel shopClassDetailViewModel, Continuation<? super ShopClassDetailViewModel$getStuFollowAdd$1> continuation) {
        super(continuation);
        this.this$0 = shopClassDetailViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getStuFollowAdd((ShopRequestCommonBody<ShopClassDetailRequest>) null, this);
    }
}
