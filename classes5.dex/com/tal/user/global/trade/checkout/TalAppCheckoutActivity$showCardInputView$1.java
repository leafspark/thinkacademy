package com.tal.user.global.trade.checkout;

import com.tal.user.global.trade.listener.TalTradePayClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/user/global/trade/checkout/TalAppCheckoutActivity$showCardInputView$1", "Lcom/tal/user/global/trade/listener/TalTradePayClickListener;", "onClick", "", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
public final class TalAppCheckoutActivity$showCardInputView$1 extends TalTradePayClickListener {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    TalAppCheckoutActivity$showCardInputView$1(TalAppCheckoutActivity talAppCheckoutActivity) {
        this.this$0 = talAppCheckoutActivity;
    }

    public void onClick() {
        if (Intrinsics.areEqual((Boolean) TalAppCheckoutActivity.access$getViewModel$p(this.this$0).isValid().getValue(), true)) {
            TalAppCheckoutActivity.access$getViewModel$p(this.this$0).gotoGetPaymentDetail();
        }
    }
}
