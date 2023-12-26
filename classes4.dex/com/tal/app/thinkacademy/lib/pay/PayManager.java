package com.tal.app.thinkacademy.lib.pay;

import android.app.Activity;
import android.app.Application;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.user.global.trade.api.ITalTradeApi;
import com.tal.user.global.trade.api.TalTradeApiFactory;
import com.tal.user.global.trade.config.TalTradeCheckoutConfig;
import com.tal.user.global.trade.config.TalTradeSdkConfig;
import com.tal.user.global.trade.entity.TALTradeCheckoutPayReq;
import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/lib/pay/PayManager;", "", "()V", "TAG", "", "paySdkInit", "", "application", "Landroid/app/Application;", "isDebug", "", "language", "country", "sendCheckoutPayRequest", "activity", "Landroid/app/Activity;", "talTradeCheckoutPayReq", "Lcom/tal/user/global/trade/entity/TALTradeCheckoutPayReq;", "listener", "Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;", "setLanguage", "locale", "Ljava/util/Locale;", "testPay", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayManager.kt */
public final class PayManager {
    public static final PayManager INSTANCE = new PayManager();
    private static final String TAG = "PayManager";

    private PayManager() {
    }

    public final void paySdkInit(Application application, boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(str, "language");
        Intrinsics.checkNotNullParameter(str2, "country");
        XesLog.dt(TAG, "paySdkInit, isdebug = " + z + ",language=" + str + ",country=" + str2);
        TalTradeSdkConfig talTradeSdkConfig = new TalTradeSdkConfig();
        talTradeSdkConfig.setDebug(z).setLog(true);
        TalTradeCheckoutConfig talTradeCheckoutConfig = new TalTradeCheckoutConfig();
        talTradeCheckoutConfig.setPrimaryColor("#FFAA0A");
        talTradeCheckoutConfig.setBtnRadiusDp(24);
        ITalTradeApi talTradeApi = TalTradeApiFactory.INSTANCE.getTalTradeApi();
        if (talTradeApi != null) {
            talTradeApi.init("PYHW", application, talTradeSdkConfig, talTradeCheckoutConfig);
        }
        ITalTradeApi talTradeApi2 = TalTradeApiFactory.INSTANCE.getTalTradeApi();
        if (talTradeApi2 != null) {
            talTradeApi2.setTalTradeLogListener(new PayManager$paySdkInit$1());
        }
        try {
            setLanguage(new Locale(str, str2));
        } catch (Exception e) {
            XesLog.dt(TAG, Intrinsics.stringPlus("init error ", e));
        }
    }

    public final void setLanguage(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        ITalTradeApi talTradeApi = TalTradeApiFactory.INSTANCE.getTalTradeApi();
        if (talTradeApi != null) {
            talTradeApi.setLocalLanguage(locale);
        }
    }

    public final void sendCheckoutPayRequest(Activity activity, TALTradeCheckoutPayReq tALTradeCheckoutPayReq, TalTradeCheckoutListener talTradeCheckoutListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(tALTradeCheckoutPayReq, "talTradeCheckoutPayReq");
        ITalTradeApi talTradeApi = TalTradeApiFactory.INSTANCE.getTalTradeApi();
        if (talTradeApi != null) {
            talTradeApi.sendCheckoutPayRequest(activity, tALTradeCheckoutPayReq, talTradeCheckoutListener);
        }
    }

    public final void testPay(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        TALTradeCheckoutPayReq tALTradeCheckoutPayReq = new TALTradeCheckoutPayReq();
        tALTradeCheckoutPayReq.setMerchantCode("商户编号");
        tALTradeCheckoutPayReq.setMerchantOrderNo("业务商品订单号");
        tALTradeCheckoutPayReq.setGoodsName("商品名称");
        tALTradeCheckoutPayReq.setGoodsDetail("商品描述");
        tALTradeCheckoutPayReq.setTotalFee("1");
        tALTradeCheckoutPayReq.setTimeOut(0);
        tALTradeCheckoutPayReq.setCurrency("CNY");
        tALTradeCheckoutPayReq.setNotifyUrl("");
        TalTradeCheckoutListener payManager$testPay$1 = new PayManager$testPay$1(activity);
        ITalTradeApi talTradeApi = TalTradeApiFactory.INSTANCE.getTalTradeApi();
        if (talTradeApi != null) {
            talTradeApi.sendCheckoutPayRequest(activity, tALTradeCheckoutPayReq, payManager$testPay$1);
        }
    }
}
