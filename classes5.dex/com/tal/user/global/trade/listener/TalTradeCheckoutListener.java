package com.tal.user.global.trade.listener;

import com.tal.user.global.trade.config.TalTradeConstant;
import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import com.tal.user.global.trade.entity.TalTradeResp;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0004H&J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;", "", "()V", "onClickClose", "", "openFail", "errorMs", "Lcom/tal/user/global/trade/entity/TalTradeErrorMsg;", "openSuccess", "stringResp", "Lcom/tal/user/global/trade/entity/TalTradeResp$StringResp;", "openTimeOut", "payFail", "paySuccess", "showSuccessPage", "Lcom/tal/user/global/trade/config/TalTradeConstant$TALTradePaymentSuccessCallbackSource;", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeCheckoutListener.kt */
public abstract class TalTradeCheckoutListener {
    public abstract void onClickClose();

    public abstract void openFail(TalTradeErrorMsg talTradeErrorMsg);

    public abstract void openSuccess(TalTradeResp.StringResp stringResp);

    public abstract void openTimeOut();

    public abstract void payFail(TalTradeErrorMsg talTradeErrorMsg);

    public abstract void paySuccess(TalTradeConstant.TALTradePaymentSuccessCallbackSource tALTradePaymentSuccessCallbackSource);
}
