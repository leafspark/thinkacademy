package com.tal.user.global.trade.checkout;

import com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout;
import com.tal.user.global.trade.widget.TimeCountDownTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onFinish"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
final class TalAppCheckoutActivity$initView$1 implements TimeCountDownTextView.TimeCountDownListener {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    TalAppCheckoutActivity$initView$1(TalAppCheckoutActivity talAppCheckoutActivity) {
        this.this$0 = talAppCheckoutActivity;
    }

    public final void onFinish() {
        this.this$0.startTimeOutViewTime = System.currentTimeMillis();
        TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlScTimeout;
        Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout, "binding.rlScTimeout");
        talTradeSecondaryConfirmationLayout.setVisibility(0);
    }
}
