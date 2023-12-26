package com.tal.app.thinkacademy.common.business.browser.helper;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.user.global.trade.config.TalTradeConstant;
import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import com.tal.user.global.trade.entity.TalTradeResp;
import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/tal/app/thinkacademy/common/business/browser/helper/PayHelp$startSendPay$talTradeCheckoutListener$1", "Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;", "onClickClose", "", "openFail", "errorMs", "Lcom/tal/user/global/trade/entity/TalTradeErrorMsg;", "openSuccess", "stringResp", "Lcom/tal/user/global/trade/entity/TalTradeResp$StringResp;", "openTimeOut", "payFail", "paySuccess", "showSuccessPage", "Lcom/tal/user/global/trade/config/TalTradeConstant$TALTradePaymentSuccessCallbackSource;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayHelp.kt */
public final class PayHelp$startSendPay$talTradeCheckoutListener$1 extends TalTradeCheckoutListener {
    final /* synthetic */ PayHelp this$0;

    PayHelp$startSendPay$talTradeCheckoutListener$1(PayHelp payHelp) {
        this.this$0 = payHelp;
    }

    public void openSuccess(TalTradeResp.StringResp stringResp) {
        XesLog.dt(PayHelp.TAG, Intrinsics.stringPlus("收银台打开成功 = ", stringResp));
    }

    public void openFail(TalTradeErrorMsg talTradeErrorMsg) {
        XesLog.dt(PayHelp.TAG, Intrinsics.stringPlus("收银台打开失败 = ", talTradeErrorMsg));
        ToastUtils.showLong(Intrinsics.stringPlus("openFail:", talTradeErrorMsg), new Object[0]);
    }

    public void onClickClose() {
        XesLog.dt(PayHelp.TAG, "收银台主动关闭（点击确认离开按钮)");
    }

    public void openTimeOut() {
        XesLog.dt(PayHelp.TAG, "收银台订单超时（点击超时提醒，查看详情按钮)");
    }

    public void paySuccess(TalTradeConstant.TALTradePaymentSuccessCallbackSource tALTradePaymentSuccessCallbackSource) {
        XesLog.dt(PayHelp.TAG, Intrinsics.stringPlus("收银台订单支付成功,", tALTradePaymentSuccessCallbackSource));
        if (tALTradePaymentSuccessCallbackSource == TalTradeConstant.TALTradePaymentSuccessCallbackSource.FromCheckoutPage) {
            this.this$0.gotoPayResult();
        }
    }

    public void payFail(TalTradeErrorMsg talTradeErrorMsg) {
        XesLog.dt(PayHelp.TAG, Intrinsics.stringPlus("收银台订单支付失败,", talTradeErrorMsg));
        this.this$0.gotoPayResult();
    }
}
