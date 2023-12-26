package com.tal.app.thinkacademy.business.home.main.shop.vm;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.List;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getShopHomeBannerList$2", f = "ShopHomeNativeVm.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShopHomeNativeVm.kt */
final class ShopHomeNativeVm$getShopHomeBannerList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $channelId;
    int label;
    final /* synthetic */ ShopHomeNativeVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopHomeNativeVm$getShopHomeBannerList$2(ShopHomeNativeVm shopHomeNativeVm, int i, Continuation<? super ShopHomeNativeVm$getShopHomeBannerList$2> continuation) {
        super(2, continuation);
        this.this$0 = shopHomeNativeVm;
        this.$channelId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShopHomeNativeVm$getShopHomeBannerList$2(this.this$0, this.$channelId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShopHomeNativeVm$getShopHomeBannerList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getShopHomeBannerReal(this.$channelId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getMBannerData().postSuccess((List) obj);
        XesLog.dt("ShopHomeNativeVm", new Object[]{"getShopHomeBannerList success"});
        return Unit.INSTANCE;
    }
}
