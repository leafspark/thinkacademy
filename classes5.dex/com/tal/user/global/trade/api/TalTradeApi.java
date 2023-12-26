package com.tal.user.global.trade.api;

import android.app.Activity;
import android.app.Application;
import com.tal.user.global.trade.checkout.TalAppCheckoutHelper;
import com.tal.user.global.trade.config.TalTradeCheckoutConfig;
import com.tal.user.global.trade.config.TalTradeSdkConfig;
import com.tal.user.global.trade.entity.TALTradeCheckoutPayReq;
import com.tal.user.global.trade.listener.TalTradeCheckoutListener;
import com.tal.user.global.trade.listener.TalTradeLogListener;
import java.lang.ref.WeakReference;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J0\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010 H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Lcom/tal/user/global/trade/api/TalTradeApi;", "Lcom/tal/user/global/trade/api/ITalTradeApi;", "()V", "talAppCheckoutHelper", "Lcom/tal/user/global/trade/checkout/TalAppCheckoutHelper;", "getTalAppCheckoutHelper", "()Lcom/tal/user/global/trade/checkout/TalAppCheckoutHelper;", "setTalAppCheckoutHelper", "(Lcom/tal/user/global/trade/checkout/TalAppCheckoutHelper;)V", "getTalTradeCheckoutListener", "Lcom/tal/user/global/trade/listener/TalTradeCheckoutListener;", "init", "", "businessCode", "", "application", "Landroid/app/Application;", "config", "Lcom/tal/user/global/trade/config/TalTradeSdkConfig;", "talTradeCheckoutConfig", "Lcom/tal/user/global/trade/config/TalTradeCheckoutConfig;", "sendCheckoutPayRequest", "", "activity", "Landroid/app/Activity;", "talTradeCheckoutPayReq", "Lcom/tal/user/global/trade/entity/TALTradeCheckoutPayReq;", "listener", "setLocalLanguage", "locale", "Ljava/util/Locale;", "setTalTradeLogListener", "Lcom/tal/user/global/trade/listener/TalTradeLogListener;", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeApi.kt */
public final class TalTradeApi implements ITalTradeApi {
    private TalAppCheckoutHelper talAppCheckoutHelper;

    public final TalAppCheckoutHelper getTalAppCheckoutHelper() {
        return this.talAppCheckoutHelper;
    }

    public final void setTalAppCheckoutHelper(TalAppCheckoutHelper talAppCheckoutHelper2) {
        this.talAppCheckoutHelper = talAppCheckoutHelper2;
    }

    public boolean init(String str, Application application, TalTradeSdkConfig talTradeSdkConfig, TalTradeCheckoutConfig talTradeCheckoutConfig) {
        return TalTradeSdk.Companion.getInstance().init(str, application, talTradeSdkConfig, talTradeCheckoutConfig);
    }

    public void sendCheckoutPayRequest(Activity activity, TALTradeCheckoutPayReq tALTradeCheckoutPayReq, TalTradeCheckoutListener talTradeCheckoutListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(tALTradeCheckoutPayReq, "talTradeCheckoutPayReq");
        TalAppCheckoutHelper talAppCheckoutHelper2 = new TalAppCheckoutHelper(new WeakReference(activity), tALTradeCheckoutPayReq, talTradeCheckoutListener);
        this.talAppCheckoutHelper = talAppCheckoutHelper2;
        Intrinsics.checkNotNull(talAppCheckoutHelper2);
        talAppCheckoutHelper2.goToTalCheckOut();
    }

    public TalTradeCheckoutListener getTalTradeCheckoutListener() {
        TalAppCheckoutHelper talAppCheckoutHelper2 = this.talAppCheckoutHelper;
        if (talAppCheckoutHelper2 != null) {
            return talAppCheckoutHelper2.getListener();
        }
        return null;
    }

    public void setLocalLanguage(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        TalTradeSdk.Companion.getInstance().setLanguage(locale);
    }

    public void setTalTradeLogListener(TalTradeLogListener talTradeLogListener) {
        TalTradeSdk.Companion.getInstance().setTalTradeLogListener(talTradeLogListener);
    }
}
