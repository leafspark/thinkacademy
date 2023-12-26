package com.tal.user.global.trade.checkout;

import android.text.TextUtils;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.config.TalTradeConstant;
import com.tal.user.global.trade.entity.TALTradeCheckoutPayReq;
import com.tal.user.global.trade.entity.TalTradePayDetailEntity;
import com.tal.user.global.trade.http.TalHttpCallBack;
import com.tal.user.global.trade.http.TalHttpManager;
import com.tal.user.global.trade.http.TalHttpRequestParams;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ.\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u0013"}, d2 = {"Lcom/tal/user/global/trade/checkout/TalAppCheckoutSyncHelper;", "", "()V", "postGotoCheckOutOrder", "", "talTradeCheckoutPayReq", "Lcom/tal/user/global/trade/entity/TALTradeCheckoutPayReq;", "talCallBack", "Lcom/tal/user/global/trade/http/TalHttpCallBack;", "postGotoOrderStatusQuery", "talTradePayDetailEntity", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity;", "postGotoPayImmediately", "params", "Lcom/tal/user/global/trade/http/TalHttpRequestParams;", "postPaymentDetailInfo2Adyen", "payTradeNo", "", "threeDsInfo", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutSyncHelper.kt */
public final class TalAppCheckoutSyncHelper {
    public static final TalAppCheckoutSyncHelper INSTANCE = new TalAppCheckoutSyncHelper();

    private TalAppCheckoutSyncHelper() {
    }

    public final void postGotoCheckOutOrder(TALTradeCheckoutPayReq tALTradeCheckoutPayReq, TalHttpCallBack talHttpCallBack) {
        TalHttpRequestParams talHttpRequestParams = new TalHttpRequestParams();
        if (tALTradeCheckoutPayReq != null) {
            if (TalTradeSdk.Companion.getInstance().getBusinessCode() != null) {
                talHttpRequestParams.addBodyParam("businessCode", TalTradeSdk.Companion.getInstance().getBusinessCode());
            }
            if (tALTradeCheckoutPayReq.getMerchantCode() != null) {
                talHttpRequestParams.addBodyParam("merchantCode", tALTradeCheckoutPayReq.getMerchantCode());
            }
            if (tALTradeCheckoutPayReq.getMerchantOrderNo() != null) {
                talHttpRequestParams.addBodyParam("merchantOrderNo", tALTradeCheckoutPayReq.getMerchantOrderNo());
            }
            if (tALTradeCheckoutPayReq.getGoodsName() != null) {
                talHttpRequestParams.addBodyParam("goodsName", tALTradeCheckoutPayReq.getGoodsName());
            }
            if (tALTradeCheckoutPayReq.getGoodsDetail() != null) {
                talHttpRequestParams.addBodyParam("goodsDetail", tALTradeCheckoutPayReq.getGoodsDetail());
            }
            talHttpRequestParams.addBodyParam("totalFee", String.valueOf(tALTradeCheckoutPayReq.getTotalFee()));
            if (tALTradeCheckoutPayReq.getTimeOut() > 0) {
                talHttpRequestParams.addBodyParam("timeOut", String.valueOf(tALTradeCheckoutPayReq.getTimeOut()));
            }
            if (tALTradeCheckoutPayReq.getCurrency() != null) {
                talHttpRequestParams.addBodyParam("currency", tALTradeCheckoutPayReq.getCurrency());
            }
            if (tALTradeCheckoutPayReq.getNotifyUrl() != null) {
                talHttpRequestParams.addBodyParam("notifyUrl", String.valueOf(tALTradeCheckoutPayReq.getNotifyUrl()));
            }
        }
        TalHttpManager.getInstance().postWithDefaultParam(TalTradeConstant.INSTANCE.GET_TAL_URL_ORDER_RECEIVE(), talHttpRequestParams, talHttpCallBack);
    }

    public final void postGotoPayImmediately(TalHttpRequestParams talHttpRequestParams, TalHttpCallBack talHttpCallBack) {
        TalHttpManager.getInstance().postWithDefaultParam(TalTradeConstant.INSTANCE.GET_TAL_URL_PAYMENT_RECEIVE(), talHttpRequestParams, talHttpCallBack);
    }

    public final void postGotoOrderStatusQuery(TalTradePayDetailEntity talTradePayDetailEntity, TalHttpCallBack talHttpCallBack) {
        TalHttpRequestParams talHttpRequestParams = new TalHttpRequestParams();
        if (talTradePayDetailEntity != null) {
            talHttpRequestParams.addBodyParam("merchantCode", talTradePayDetailEntity.getMerchantCode());
            talHttpRequestParams.addBodyParam("merchantOrderNo", talTradePayDetailEntity.getMerchantOrderNo());
        }
        TalHttpManager.getInstance().postWithDefaultParam(TalTradeConstant.INSTANCE.GET_TAL_URL_ORDER_STATUS_QUERY(), talHttpRequestParams, talHttpCallBack);
    }

    public final void postPaymentDetailInfo2Adyen(TalTradePayDetailEntity talTradePayDetailEntity, String str, String str2, TalHttpCallBack talHttpCallBack) {
        TalHttpRequestParams talHttpRequestParams = new TalHttpRequestParams();
        if ((talTradePayDetailEntity != null ? talTradePayDetailEntity.getMerchantCode() : null) != null) {
            talHttpRequestParams.addBodyParam("merchantCode", talTradePayDetailEntity.getMerchantCode());
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            talHttpRequestParams.addBodyParam("payTradeNo", str);
        }
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            talHttpRequestParams.addBodyParam("extendParam", str2);
        }
        TalHttpManager.getInstance().postWithDefaultParam(TalTradeConstant.INSTANCE.GET_TAL_URL_ORDER_PAYMENT_DETAIL_INFO(), talHttpRequestParams, talHttpCallBack);
    }
}
