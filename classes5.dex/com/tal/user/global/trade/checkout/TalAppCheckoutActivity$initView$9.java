package com.tal.user.global.trade.checkout;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.config.TalTradeConstant;
import com.tal.user.global.trade.entity.TalTradePayDetailEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
final class TalAppCheckoutActivity$initView$9 extends Lambda implements Function1<TextView, Unit> {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TalAppCheckoutActivity$initView$9(TalAppCheckoutActivity talAppCheckoutActivity) {
        super(1);
        this.this$0 = talAppCheckoutActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "it");
        TalTradePayDetailEntity access$getTalTradePayDetailEntity$p = this.this$0.talTradePayDetailEntity;
        Intrinsics.checkNotNull(access$getTalTradePayDetailEntity$p);
        TalTradePayDetailEntity.PayWayConfig payWayConfig = access$getTalTradePayDetailEntity$p.getPayWayConfig().get(this.this$0.choosePosition);
        Intrinsics.checkNotNullExpressionValue(payWayConfig, "talTradePayDetailEntity!…WayConfig[choosePosition]");
        TalTradePayDetailEntity.PayWayConfig payWayConfig2 = payWayConfig;
        this.this$0.choosePayWayCodeToUms(payWayConfig2);
        int payProduct = payWayConfig2.getPayProduct();
        if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getCardAPPCode()) {
            if (TalAppCheckoutActivity.access$getViewModel$p(this.this$0).getCardComponent() != null) {
                this.this$0.showCardInputView(payWayConfig2);
            }
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getWechatAPPCode()) {
            TalAppCheckoutActivity.access$getViewModel$p(this.this$0).isWxInstall(payWayConfig2);
            if (Intrinsics.areEqual((Boolean) TalAppCheckoutActivity.access$getViewModel$p(this.this$0).isAvailable().getValue(), true)) {
                TalAppCheckoutActivity.access$getViewModel$p(this.this$0).gotoGetPaymentDetail();
                return;
            }
            TalAppCheckoutActivity talAppCheckoutActivity = this.this$0;
            Toast.makeText((Context) talAppCheckoutActivity, talAppCheckoutActivity.getResources().getString(R.string.tal_trade_wechat_un_installed), 1).show();
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayAPPCode() || payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayHKAPPCode() || payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getGrabpayAPPCode()) {
            if (TalAppCheckoutActivity.access$getViewModel$p(this.this$0).getRedirectComponent() != null) {
                TalAppCheckoutActivity.access$getViewModel$p(this.this$0).gotoGetPaymentDetail();
            }
        } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getStripeWxH5Code()) {
            TalAppCheckoutActivity.access$getViewModel$p(this.this$0).gotoGetStripePaymentDetail();
        }
    }
}
