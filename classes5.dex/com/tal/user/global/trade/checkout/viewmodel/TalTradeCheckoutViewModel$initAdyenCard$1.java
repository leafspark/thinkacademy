package com.tal.user.global.trade.checkout.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.adyen.checkout.card.CardComponentState;
import com.adyen.checkout.components.model.payments.request.PaymentComponentData;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "paymentComponentState", "Lcom/adyen/checkout/card/CardComponentState;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalTradeCheckoutViewModel.kt */
final class TalTradeCheckoutViewModel$initAdyenCard$1<T> implements Observer<CardComponentState> {
    final /* synthetic */ TalTradeCheckoutViewModel this$0;

    TalTradeCheckoutViewModel$initAdyenCard$1(TalTradeCheckoutViewModel talTradeCheckoutViewModel) {
        this.this$0 = talTradeCheckoutViewModel;
    }

    public final void onChanged(CardComponentState cardComponentState) {
        Intrinsics.checkNotNullExpressionValue(cardComponentState, "paymentComponentState");
        if (cardComponentState.isValid()) {
            JSONObject serialize = PaymentComponentData.SERIALIZER.serialize(cardComponentState.getData());
            Intrinsics.checkNotNullExpressionValue(serialize, "PaymentComponentData.SER…ymentComponentState.data)");
            StringBuilder sb = new StringBuilder();
            sb.append("adyencheckout://");
            Object value = this.this$0.getMActivity().getValue();
            Intrinsics.checkNotNull(value);
            Intrinsics.checkNotNullExpressionValue(value, "mActivity.value!!");
            sb.append(((AppCompatActivity) value).getPackageName());
            serialize.put("returnUrl", sb.toString());
            this.this$0.paymentCardActionString = !(serialize instanceof JSONObject) ? serialize.toString() : JSONObjectInstrumentation.toString(serialize);
        }
        this.this$0.isValid().setValue(Boolean.valueOf(cardComponentState.isValid()));
    }
}
