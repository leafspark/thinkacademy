package com.tal.user.global.trade.entity;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/tal/user/global/trade/entity/TALTradeCheckoutPayReq;", "", "()V", "currency", "", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "goodsDetail", "getGoodsDetail", "setGoodsDetail", "goodsName", "getGoodsName", "setGoodsName", "merchantCode", "getMerchantCode", "setMerchantCode", "merchantOrderNo", "getMerchantOrderNo", "setMerchantOrderNo", "notifyUrl", "getNotifyUrl", "setNotifyUrl", "timeOut", "", "getTimeOut", "()I", "setTimeOut", "(I)V", "totalFee", "getTotalFee", "setTotalFee", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TALTradeCheckoutPayReq.kt */
public final class TALTradeCheckoutPayReq {
    private String currency;
    private String goodsDetail;
    private String goodsName;
    private String merchantCode;
    private String merchantOrderNo;
    private String notifyUrl;
    private int timeOut;
    private String totalFee;

    public final String getMerchantCode() {
        return this.merchantCode;
    }

    public final void setMerchantCode(String str) {
        this.merchantCode = str;
    }

    public final String getMerchantOrderNo() {
        return this.merchantOrderNo;
    }

    public final void setMerchantOrderNo(String str) {
        this.merchantOrderNo = str;
    }

    public final String getGoodsName() {
        return this.goodsName;
    }

    public final void setGoodsName(String str) {
        this.goodsName = str;
    }

    public final String getGoodsDetail() {
        return this.goodsDetail;
    }

    public final void setGoodsDetail(String str) {
        this.goodsDetail = str;
    }

    public final String getTotalFee() {
        return this.totalFee;
    }

    public final void setTotalFee(String str) {
        this.totalFee = str;
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public final void setTimeOut(int i) {
        this.timeOut = i;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final String getNotifyUrl() {
        return this.notifyUrl;
    }

    public final void setNotifyUrl(String str) {
        this.notifyUrl = str;
    }
}
