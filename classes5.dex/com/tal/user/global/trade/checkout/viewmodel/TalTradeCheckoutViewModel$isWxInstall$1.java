package com.tal.user.global.trade.checkout.viewmodel;

import com.adyen.checkout.components.ComponentAvailableCallback;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isAvailable", "", "<anonymous parameter 1>", "Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "<anonymous parameter 2>", "Lcom/adyen/checkout/components/base/Configuration;", "onAvailabilityResult"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalTradeCheckoutViewModel.kt */
final class TalTradeCheckoutViewModel$isWxInstall$1<ConfigurationT extends Configuration> implements ComponentAvailableCallback<Configuration> {
    final /* synthetic */ TalTradeCheckoutViewModel this$0;

    TalTradeCheckoutViewModel$isWxInstall$1(TalTradeCheckoutViewModel talTradeCheckoutViewModel) {
        this.this$0 = talTradeCheckoutViewModel;
    }

    public final void onAvailabilityResult(boolean z, PaymentMethod paymentMethod, Configuration configuration) {
        Intrinsics.checkNotNullParameter(paymentMethod, "<anonymous parameter 1>");
        this.this$0.isAvailable().setValue(Boolean.valueOf(z));
    }
}
