package com.tal.user.global.trade.checkout;

import com.tal.user.global.trade.api.TalTradeApiCallBack;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.base.TalTradeLoadingDialog;
import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import com.tal.user.global.trade.entity.TalTradePayDetailEntity;
import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/tal/user/global/trade/checkout/TalAppCheckoutHelper$goToTalCheckOut$talCallBack$1", "Lcom/tal/user/global/trade/api/TalTradeApiCallBack;", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity;", "onError", "", "errorMsg", "Lcom/tal/user/global/trade/entity/TalTradeErrorMsg;", "onSuccess", "data", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutHelper.kt */
public final class TalAppCheckoutHelper$goToTalCheckOut$talCallBack$1 extends TalTradeApiCallBack<TalTradePayDetailEntity> {
    final /* synthetic */ TalTradeLoadingDialog $talTradeLoadingDialog;
    final /* synthetic */ TalAppCheckoutHelper this$0;

    TalAppCheckoutHelper$goToTalCheckOut$talCallBack$1(TalAppCheckoutHelper talAppCheckoutHelper, TalTradeLoadingDialog talTradeLoadingDialog) {
        this.this$0 = talAppCheckoutHelper;
        this.$talTradeLoadingDialog = talTradeLoadingDialog;
    }

    public void onSuccess(TalTradePayDetailEntity talTradePayDetailEntity) {
        this.$talTradeLoadingDialog.dismiss();
        if (talTradePayDetailEntity != null) {
            talTradePayDetailEntity.setGoodsName(String.valueOf(this.this$0.talTradeCheckoutPayReq.getGoodsName()));
            talTradePayDetailEntity.setGoodsDetail(String.valueOf(this.this$0.talTradeCheckoutPayReq.getGoodsDetail()));
            this.this$0.openCheckout(talTradePayDetailEntity);
        }
    }

    public void onError(TalTradeErrorMsg talTradeErrorMsg) {
        this.$talTradeLoadingDialog.dismiss();
        TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).i(talTradeErrorMsg);
        TalTradeCheckoutListener listener = this.this$0.getListener();
        if (listener != null) {
            listener.openFail(talTradeErrorMsg);
        }
    }
}
