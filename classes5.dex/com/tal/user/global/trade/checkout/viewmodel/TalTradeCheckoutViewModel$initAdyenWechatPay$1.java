package com.tal.user.global.trade.checkout.viewmodel;

import androidx.lifecycle.Observer;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.core.model.ModelObject;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.user.global.trade.ums.Producer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "actionComponentData", "Lcom/adyen/checkout/components/ActionComponentData;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalTradeCheckoutViewModel.kt */
final class TalTradeCheckoutViewModel$initAdyenWechatPay$1<T> implements Observer<ActionComponentData> {
    final /* synthetic */ TalTradeCheckoutViewModel this$0;

    TalTradeCheckoutViewModel$initAdyenWechatPay$1(TalTradeCheckoutViewModel talTradeCheckoutViewModel) {
        this.this$0 = talTradeCheckoutViewModel;
    }

    public final void onChanged(ActionComponentData actionComponentData) {
        JSONObject serialize = ActionComponentData.SERIALIZER.serialize((ModelObject) actionComponentData);
        String jSONObject = !(serialize instanceof JSONObject) ? serialize.toString() : JSONObjectInstrumentation.toString(serialize);
        Intrinsics.checkNotNullExpressionValue(jSONObject, "ActionComponentData.SERI…ComponentData).toString()");
        this.this$0.postPaymentDetailInfo2Server(jSONObject);
        try {
            Producer.INSTANCE.oneSDKLog("pay", "weChatPayActionComponent");
        } catch (Exception unused) {
        }
    }
}
