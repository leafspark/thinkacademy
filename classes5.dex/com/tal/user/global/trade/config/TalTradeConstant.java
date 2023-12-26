package com.tal.user.global.trade.config;

import com.tal.user.global.trade.api.TalTradeSdk;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/tal/user/global/trade/config/TalTradeConstant;", "", "()V", "GET_TAL_TRADE_HOST", "", "GET_TAL_URL_ORDER_PAYMENT_DETAIL_INFO", "GET_TAL_URL_ORDER_RECEIVE", "GET_TAL_URL_ORDER_STATUS_QUERY", "GET_TAL_URL_PAYMENT_RECEIVE", "TALTradePaymentSuccessCallbackSource", "TalTradePayProductCode", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeConstant.kt */
public final class TalTradeConstant {
    public static final TalTradeConstant INSTANCE = new TalTradeConstant();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/tal/user/global/trade/config/TalTradeConstant$TALTradePaymentSuccessCallbackSource;", "", "(Ljava/lang/String;I)V", "FromCheckoutPage", "FromPaymentCompletePage", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TalTradeConstant.kt */
    public enum TALTradePaymentSuccessCallbackSource {
        FromCheckoutPage,
        FromPaymentCompletePage
    }

    private TalTradeConstant() {
    }

    public final String GET_TAL_TRADE_HOST() {
        return TalTradeSdk.Companion.getInstance().getConfig().isDebug() ? "http://paygateway.dev.thethinkacademy.com" : "https://paygateway.thethinkacademy.com";
    }

    public final String GET_TAL_URL_ORDER_RECEIVE() {
        return GET_TAL_TRADE_HOST() + "/gateway/pay/api/checkout/app/order/receive";
    }

    public final String GET_TAL_URL_PAYMENT_RECEIVE() {
        return GET_TAL_TRADE_HOST() + "/gateway/pay/api/checkout/app/payment/receive";
    }

    public final String GET_TAL_URL_ORDER_STATUS_QUERY() {
        return GET_TAL_TRADE_HOST() + "/gateway/pay/api/checkout/app/order/status/query";
    }

    public final String GET_TAL_URL_ORDER_PAYMENT_DETAIL_INFO() {
        return GET_TAL_TRADE_HOST() + "/gateway/pay/api/checkout/app/channelPaymentDetail";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/tal/user/global/trade/config/TalTradeConstant$TalTradePayProductCode;", "", "()V", "AlipayAPPCode", "", "getAlipayAPPCode", "()I", "setAlipayAPPCode", "(I)V", "AlipayHKAPPCode", "getAlipayHKAPPCode", "setAlipayHKAPPCode", "CardAPPCode", "getCardAPPCode", "setCardAPPCode", "GrabpayAPPCode", "getGrabpayAPPCode", "setGrabpayAPPCode", "StripeWxH5Code", "getStripeWxH5Code", "setStripeWxH5Code", "WechatAPPCode", "getWechatAPPCode", "setWechatAPPCode", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TalTradeConstant.kt */
    public static final class TalTradePayProductCode {
        private static int AlipayAPPCode = 35;
        private static int AlipayHKAPPCode = 36;
        private static int CardAPPCode = 33;
        private static int GrabpayAPPCode = 40;
        public static final TalTradePayProductCode INSTANCE = new TalTradePayProductCode();
        private static int StripeWxH5Code = 31;
        private static int WechatAPPCode = 34;

        private TalTradePayProductCode() {
        }

        public final int getStripeWxH5Code() {
            return StripeWxH5Code;
        }

        public final void setStripeWxH5Code(int i) {
            StripeWxH5Code = i;
        }

        public final int getCardAPPCode() {
            return CardAPPCode;
        }

        public final void setCardAPPCode(int i) {
            CardAPPCode = i;
        }

        public final int getWechatAPPCode() {
            return WechatAPPCode;
        }

        public final void setWechatAPPCode(int i) {
            WechatAPPCode = i;
        }

        public final int getAlipayAPPCode() {
            return AlipayAPPCode;
        }

        public final void setAlipayAPPCode(int i) {
            AlipayAPPCode = i;
        }

        public final int getAlipayHKAPPCode() {
            return AlipayHKAPPCode;
        }

        public final void setAlipayHKAPPCode(int i) {
            AlipayHKAPPCode = i;
        }

        public final int getGrabpayAPPCode() {
            return GrabpayAPPCode;
        }

        public final void setGrabpayAPPCode(int i) {
            GrabpayAPPCode = i;
        }
    }
}
