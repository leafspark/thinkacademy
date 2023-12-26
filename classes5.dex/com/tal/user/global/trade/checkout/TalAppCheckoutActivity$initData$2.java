package com.tal.user.global.trade.checkout;

import androidx.lifecycle.Observer;
import com.tal.user.global.trade.adapter.TalTradePayWayAdapter;
import com.tal.user.global.trade.entity.TalTradePayDetailEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
final class TalAppCheckoutActivity$initData$2<T> implements Observer<Integer> {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    TalAppCheckoutActivity$initData$2(TalAppCheckoutActivity talAppCheckoutActivity) {
        this.this$0 = talAppCheckoutActivity;
    }

    public final void onChanged(Integer num) {
        this.this$0.setCheckBoxResources();
        if (this.this$0.payWayBaseAdapter != null) {
            TalTradePayWayAdapter access$getPayWayBaseAdapter$p = this.this$0.payWayBaseAdapter;
            Intrinsics.checkNotNull(access$getPayWayBaseAdapter$p);
            Intrinsics.checkNotNullExpressionValue(num, "it");
            access$getPayWayBaseAdapter$p.setChoosePosition(num.intValue());
            TalTradePayWayAdapter access$getPayWayBaseAdapter$p2 = this.this$0.payWayBaseAdapter;
            Intrinsics.checkNotNull(access$getPayWayBaseAdapter$p2);
            access$getPayWayBaseAdapter$p2.notifyItemChanged(num.intValue());
        }
        this.this$0.setCurrencySymbolText();
        TalTradePayDetailEntity access$getTalTradePayDetailEntity$p = this.this$0.talTradePayDetailEntity;
        Intrinsics.checkNotNull(access$getTalTradePayDetailEntity$p);
        ArrayList<TalTradePayDetailEntity.PayWayConfig> payWayConfig = access$getTalTradePayDetailEntity$p.getPayWayConfig();
        Intrinsics.checkNotNullExpressionValue(num, "it");
        TalTradePayDetailEntity.PayWayConfig payWayConfig2 = payWayConfig.get(num.intValue());
        Intrinsics.checkNotNullExpressionValue(payWayConfig2, "talTradePayDetailEntity!!.payWayConfig[it]");
        TalAppCheckoutActivity.access$getViewModel$p(this.this$0).judgePayWay(payWayConfig2);
    }
}
