package com.tal.user.global.trade.checkout.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.adyen.checkout.adyen3ds2.Adyen3DS2Component;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.redirect.RedirectComponent;
import com.adyen.checkout.wechatpay.WeChatPayActionComponent;
import com.tal.user.global.trade.api.TalTradeApiCallBack;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.config.TalTradeConstant;
import com.tal.user.global.trade.entity.PayInfoEntity;
import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import com.tal.user.global.trade.ums.Producer;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/tal/user/global/trade/checkout/viewmodel/TalTradeCheckoutViewModel$gotoGetPaymentDetail$talCallBack$1", "Lcom/tal/user/global/trade/api/TalTradeApiCallBack;", "Lcom/tal/user/global/trade/entity/PayInfoEntity;", "onError", "", "errorMsg", "Lcom/tal/user/global/trade/entity/TalTradeErrorMsg;", "onSuccess", "data", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeCheckoutViewModel.kt */
public final class TalTradeCheckoutViewModel$gotoGetPaymentDetail$talCallBack$1 extends TalTradeApiCallBack<PayInfoEntity> {
    final /* synthetic */ Ref.IntRef $payProductNo;
    final /* synthetic */ TalTradeCheckoutViewModel this$0;

    TalTradeCheckoutViewModel$gotoGetPaymentDetail$talCallBack$1(TalTradeCheckoutViewModel talTradeCheckoutViewModel, Ref.IntRef intRef) {
        this.this$0 = talTradeCheckoutViewModel;
        this.$payProductNo = intRef;
    }

    public void onSuccess(PayInfoEntity payInfoEntity) {
        RedirectComponent redirectComponent;
        this.this$0.payInfoEntity = payInfoEntity;
        String str = null;
        CharSequence payData = payInfoEntity != null ? payInfoEntity.getPayData() : null;
        if (!(payData == null || payData.length() == 0)) {
            if (payInfoEntity != null) {
                str = payInfoEntity.getPayData();
            }
            Action deserialize = Action.SERIALIZER.deserialize(new JSONObject(str));
            Intrinsics.checkNotNullExpressionValue(deserialize, "com.adyen.checkout.compo…                        )");
            Action action = deserialize;
            Activity activity = (AppCompatActivity) this.this$0.getMActivity().getValue();
            if (activity != null) {
                int i = this.$payProductNo.element;
                if (i == TalTradeConstant.TalTradePayProductCode.INSTANCE.getCardAPPCode()) {
                    Adyen3DS2Component threedsComponent = this.this$0.getThreedsComponent();
                    if (threedsComponent != null) {
                        threedsComponent.handleAction(activity, action);
                    }
                    this.this$0.getPayOrderStatus().setValue(99);
                } else if (i == TalTradeConstant.TalTradePayProductCode.INSTANCE.getWechatAPPCode()) {
                    WeChatPayActionComponent weChatPayActionComponent = this.this$0.getWeChatPayActionComponent();
                    if (weChatPayActionComponent != null) {
                        weChatPayActionComponent.handleAction(activity, action);
                    }
                } else if ((i == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayAPPCode() || i == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayHKAPPCode() || i == TalTradeConstant.TalTradePayProductCode.INSTANCE.getGrabpayAPPCode()) && (redirectComponent = this.this$0.getRedirectComponent()) != null) {
                    redirectComponent.handleAction(activity, action);
                }
            }
        } else {
            this.this$0.getPayOrderStatus().setValue(99);
            try {
                Producer.INSTANCE.oneSDKLog("pay", "payData is null");
            } catch (Exception unused) {
            }
        }
        this.this$0.dismissProgressDialog();
    }

    public void onError(TalTradeErrorMsg talTradeErrorMsg) {
        this.this$0.dismissProgressDialog();
        Toast.makeText((Context) this.this$0.getMActivity().getValue(), talTradeErrorMsg != null ? talTradeErrorMsg.getMsg() : null, 1).show();
        TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).i(talTradeErrorMsg);
    }
}
