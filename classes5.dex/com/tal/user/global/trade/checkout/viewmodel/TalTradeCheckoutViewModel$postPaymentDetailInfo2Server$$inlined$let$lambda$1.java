package com.tal.user.global.trade.checkout.viewmodel;

import android.content.Context;
import android.widget.Toast;
import com.tal.user.global.trade.api.TalTradeApiCallBack;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.entity.PayOrderStatusQueryEntity;
import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import com.tal.user.global.trade.util.TalTradeLogger;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/tal/user/global/trade/checkout/viewmodel/TalTradeCheckoutViewModel$postPaymentDetailInfo2Server$1$talCallBack$1", "Lcom/tal/user/global/trade/api/TalTradeApiCallBack;", "Lcom/tal/user/global/trade/entity/PayOrderStatusQueryEntity;", "onError", "", "errorMsg", "Lcom/tal/user/global/trade/entity/TalTradeErrorMsg;", "onSuccess", "data", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeCheckoutViewModel.kt */
public final class TalTradeCheckoutViewModel$postPaymentDetailInfo2Server$$inlined$let$lambda$1 extends TalTradeApiCallBack<PayOrderStatusQueryEntity> {
    final /* synthetic */ String $paymentDetailActionString$inlined;
    final /* synthetic */ TalTradeCheckoutViewModel this$0;

    TalTradeCheckoutViewModel$postPaymentDetailInfo2Server$$inlined$let$lambda$1(TalTradeCheckoutViewModel talTradeCheckoutViewModel, String str) {
        this.this$0 = talTradeCheckoutViewModel;
        this.$paymentDetailActionString$inlined = str;
    }

    public void onSuccess(PayOrderStatusQueryEntity payOrderStatusQueryEntity) {
        this.this$0.dismissProgressDialog();
        TalTradeLogger logger = TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG);
        StringBuilder sb = new StringBuilder();
        sb.append("返回支付结果：");
        sb.append(payOrderStatusQueryEntity != null ? Integer.valueOf(payOrderStatusQueryEntity.getStatus()) : null);
        logger.i(sb.toString());
    }

    public void onError(TalTradeErrorMsg talTradeErrorMsg) {
        this.this$0.dismissProgressDialog();
        Toast.makeText((Context) this.this$0.getMActivity().getValue(), talTradeErrorMsg != null ? talTradeErrorMsg.getMsg() : null, 1).show();
        TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).i(talTradeErrorMsg);
    }
}
