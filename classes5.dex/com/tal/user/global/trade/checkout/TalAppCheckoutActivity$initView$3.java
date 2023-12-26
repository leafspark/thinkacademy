package com.tal.user.global.trade.checkout;

import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import com.tal.user.global.trade.ums.Producer;
import com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/tal/user/global/trade/checkout/TalAppCheckoutActivity$initView$3", "Lcom/tal/user/global/trade/widget/TalTradeSecondaryConfirmationLayout$OnClickListener;", "cancel", "", "confirm", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
public final class TalAppCheckoutActivity$initView$3 implements TalTradeSecondaryConfirmationLayout.OnClickListener {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    TalAppCheckoutActivity$initView$3(TalAppCheckoutActivity talAppCheckoutActivity) {
        this.this$0 = talAppCheckoutActivity;
    }

    public void cancel() {
        Producer.INSTANCE.oneClickLog("04_01_01_00_DJQRLK");
        TalTradeCheckoutListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onClickClose();
        }
        this.this$0.closeCheckOut();
    }

    public void confirm() {
        Producer.INSTANCE.oneClickLog("04_01_01_00_DJJXZF");
        TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlSc;
        Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout, "binding.rlSc");
        talTradeSecondaryConfirmationLayout.setVisibility(8);
    }
}
