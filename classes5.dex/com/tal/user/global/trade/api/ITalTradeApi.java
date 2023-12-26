package com.tal.user.global.trade.api;

import android.app.Activity;
import android.app.Application;
import com.tal.user.global.trade.config.TalTradeCheckoutConfig;
import com.tal.user.global.trade.config.TalTradeSdkConfig;
import com.tal.user.global.trade.entity.TALTradeCheckoutPayReq;
import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import com.tal.user.global.trade.listener.TalTradeLogListener;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J0\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001a"}, d2 = {"Lcom/tal/user/global/trade/api/ITalTradeApi;", "", "getTalTradeCheckoutListener", "Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;", "init", "", "businessCode", "", "application", "Landroid/app/Application;", "config", "Lcom/tal/user/global/trade/config/TalTradeSdkConfig;", "talTradeCheckoutConfig", "Lcom/tal/user/global/trade/config/TalTradeCheckoutConfig;", "sendCheckoutPayRequest", "", "activity", "Landroid/app/Activity;", "talTradeCheckoutPayReq", "Lcom/tal/user/global/trade/entity/TALTradeCheckoutPayReq;", "listener", "setLocalLanguage", "locale", "Ljava/util/Locale;", "setTalTradeLogListener", "Lcom/tal/user/global/trade/listener/TalTradeLogListener;", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ITalTradeApi.kt */
public interface ITalTradeApi {
    TalTradeCheckoutListener getTalTradeCheckoutListener();

    boolean init(String str, Application application, TalTradeSdkConfig talTradeSdkConfig, TalTradeCheckoutConfig talTradeCheckoutConfig);

    void sendCheckoutPayRequest(Activity activity, TALTradeCheckoutPayReq tALTradeCheckoutPayReq, TalTradeCheckoutListener talTradeCheckoutListener);

    void setLocalLanguage(Locale locale);

    void setTalTradeLogListener(TalTradeLogListener talTradeLogListener);
}
